/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb;

import de.ibapl.jnhw.syscall.linux.sysfs.SysFs;
import de.ibapl.jnhw.syscall.linux.sysfs.UsbDevice;
import de.ibapl.jnhw.syscall.linux.sysfs.UsbSerialDevice;
import jdk.incubator.foreign.ResourceScope;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class Ch9__Usb_device_descriptorTest {

    public Ch9__Usb_device_descriptorTest() {
    }

    /**
     * Test of usb_endpoint_dir_in method, of class Ch9.
     */
    @Test
    public void testUsb_device_descriptor() throws Exception {
        try ( ResourceScope scope = ResourceScope.newConfinedScope()) {
            System.out.println("test Usb_device_descriptor");
            for (UsbDevice dev : SysFs.bus().usb().devices()) {
                System.out.println("SysFs dir: \"" + dev.getSysDir() + "\" links to device dir: \"" + dev.getSysDir().getCanonicalPath() + "\"");
                System.out.println(dev.toShortString());
                for (AbstractDescriptor descriptor : dev.descriptors(scope)) {
                    descriptor.nativeToString(System.out, "", "");
                    System.out.println();
                    if (descriptor.bDescriptorType() == Ch9.USB_DT_DEVICE) {
                        assertEquals(dev.idProduct(), ((Ch9.Usb_device_descriptor) descriptor).idProduct());
                        assertEquals(dev.idVendor(), ((Ch9.Usb_device_descriptor) descriptor).idVendor());
                    }
                }
            }
        }

    }

    /**
     * Test of usb_endpoint_dir_in method, of class Ch9.
     */
    @Test
    public void testUsb_Serial_device_descriptor() throws Exception {
        System.out.println("test usb-serial device_descriptor");
        for (UsbSerialDevice dev : SysFs.bus().usb_serial().devices()) {
            System.out.println("SysFs dir: \"" + dev.getSysDir() + "\" links to device dir: \"" + dev.getSysDir().getCanonicalPath() + "\"");
        }

    }
}
