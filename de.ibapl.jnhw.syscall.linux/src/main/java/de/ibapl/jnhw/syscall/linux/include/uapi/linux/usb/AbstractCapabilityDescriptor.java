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
package de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb;

import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.syscall.linux.annotation.SysFs;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types;
import java.io.IOException;

@SysFs("/sys/bus/usb/devices/*/descriptors")
public abstract class AbstractCapabilityDescriptor extends AbstractDescriptor {

    public AbstractCapabilityDescriptor(OpaqueMemory32 parent, int offset, int sizeInBytes, Byte setMem) {
        super(parent, offset, sizeInBytes, setMem);
    }

    @Override
    protected void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
        jsb.appendShortMember("bDevCapabilityType", bDevCapabilityType());
    }

    @Types.__u8
    public final native byte bDevCapabilityType();
}
