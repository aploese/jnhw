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
module de.ibapl.jnhw.syscall.linux {

    requires jdk.incubator.foreign;
    
    requires de.ibapl.jnhw.posix;

    exports de.ibapl.jnhw.syscall.linux.annotation;
    exports de.ibapl.jnhw.syscall.linux.drivers.usb.serial;
    exports de.ibapl.jnhw.syscall.linux.include.linux;
    exports de.ibapl.jnhw.syscall.linux.include.linux.usb;
    exports de.ibapl.jnhw.syscall.linux.include.uapi.linux;
    exports de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb;
    exports de.ibapl.jnhw.syscall.linux.sysfs;
    exports de.ibapl.jnhw.syscall.linux.uapi.asm_generic;
    exports de.ibapl.jnhw.syscall.linux.usb;
    exports de.ibapl.jnhw.syscall.linux.util.memory;
}
