/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package de.ibapl.jnhw.syscall.linux.sysfs;

import de.ibapl.jnhw.common.exception.NativeErrorException;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.MEM_UNINITIALIZED;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.posix.Fcntl;
import de.ibapl.jnhw.posix.Unistd;
import de.ibapl.jnhw.syscall.linux.annotation.Path;
import de.ibapl.jnhw.syscall.linux.annotation.PathRegex;
import de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb.AbstractDescriptor;
import de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb.Ch9;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author aploese
 */
@Path("/sys/bus/usb/devices/*")
@PathRegex("/sys/bus/usb/devices/*/idProduct")
public class UsbDevice {

    static boolean isDeviceDir(File f) {
        File idProcuct = new File(f, "idProduct");
        return idProcuct.exists();
    }

    private final File sysFsDir;

    public byte busnum() {
        return Byte.parseByte(readFile(new File(sysFsDir, "busnum")));
    }

    public short devnum() {
        return Short.parseShort(readFile(new File(sysFsDir, "devnum")));
    }

    public short idVendor() {
        return (short) Integer.parseInt(readFile(new File(sysFsDir, "idVendor")), 16);
    }

    public final short idProduct() {
        return (short) Integer.parseInt(readFile(new File(sysFsDir, "idProduct")), 16);
    }

    public final String product() {
        try {
            return readFile(new File(sysFsDir, "product"));
        } catch (Exception e) {
            return null;
        }
    }

    public final String vendorName() {
        return "UNKNOWN";
    }

    private UsbDevice(File sysFsDir) {
        this.sysFsDir = sysFsDir;
    }

    public static UsbDevice toUsbDevice(File sysFsDir) {
        if (isDeviceDir(sysFsDir)) {
            return new UsbDevice(sysFsDir);
        } else {
            throw new IllegalArgumentException(sysFsDir.getAbsolutePath() + " is not an sysfs usb bus device directory!");
        }
    }

    public String toShortString() {
        return String.format("Bus %03d Device %03d: ID %04x:%04x %s %s", busnum(), devnum(), idVendor(), idProduct(), vendorName(), product());

    }

    private String readFile(File f) {
        try (Reader r = new FileReader(f)) {
            try (BufferedReader br = new BufferedReader(r)) {
                return br.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Collection<AbstractDescriptor> descriptors() {
        // get 1 page of kernel memory - this is also the size od descriptors ...
        OpaqueMemory32 mem = new Memory32Heap(null, 0, 1024 * 64, MEM_UNINITIALIZED);
        List<AbstractDescriptor> result = new LinkedList<>();
        try {
            final int fd = Fcntl.open(new File(sysFsDir, "descriptors").getAbsolutePath(), Fcntl.O_RDONLY);
            try {
                int size = Unistd.read(fd, mem);
                if (size < Ch9.Usb_descriptor_header.Layout.sizeof) {
                    throw new RuntimeException("read not the minimum length!");
                }
                int currentPos = 0;
                do {
                    Ch9.Usb_descriptor_header header = new Ch9.Usb_descriptor_header(mem, currentPos, null);
                    AbstractDescriptor current = header.toDescriptor();
                    currentPos += current.sizeInBytes;
                    result.add(current);
                } while (currentPos < size);
                return result;
            } finally {
                Unistd.close(fd);
            }
        } catch (NativeErrorException e) {
            throw new RuntimeException(e);
        }
    }

    public File getSysDir() {
        return sysFsDir;
    }
}
