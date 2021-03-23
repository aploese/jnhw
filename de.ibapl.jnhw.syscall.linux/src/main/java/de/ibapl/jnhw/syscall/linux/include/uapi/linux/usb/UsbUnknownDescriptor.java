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

import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import java.io.IOException;

/**
 *
 * @author aploese
 */
public class UsbUnknownDescriptor extends AbstractDescriptor {

    public UsbUnknownDescriptor(AbstractNativeMemory parent, long offset, int size, SetMem setMem) {
        super(parent, offset, size, setMem);
    }

    @Override
    protected void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
        byte[] payload = new byte[sizeInBytes - Layout._sizeof];
        MEM_ACCESS.copyMemory32(this, Layout._sizeof, payload, 0, payload.length);
        jsb.appendRawDataMember("payload", payload);
    }

}
