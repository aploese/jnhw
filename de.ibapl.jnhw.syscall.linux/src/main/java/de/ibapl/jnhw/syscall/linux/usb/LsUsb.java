/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.syscall.linux.usb;

import de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb.AbstractDescriptor;
import de.ibapl.jnhw.syscall.linux.sysfs.SysFs;
import de.ibapl.jnhw.syscall.linux.sysfs.UsbDevice;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public class LsUsb {

    public static void main(String[] args) {
        LsUsb lsUsb = new LsUsb();
//        lsUsb.listShort();
        lsUsb.listLong();
    }

    private void listShort() {
        for (UsbDevice d : SysFs.bus().usb().devices()) {
            System.out.println(d.toShortString());
        }
    }

    private void listLong() {
        try (Arena arena = Arena.ofConfined()) {
            for (UsbDevice dev : SysFs.bus().usb().devices()) {
                System.out.println("SysFs dir: \"" + dev.getSysDir() + "\"");
                System.out.println(dev.toShortString());
                for (AbstractDescriptor descr : dev.descriptors(arena)) {
                    try {
                        descr.nativeToString(System.out, " ", " ");
                    } catch (IOException ex) {
                        Logger.getLogger(LsUsb.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println();
                }
            }
        }
    }

}
