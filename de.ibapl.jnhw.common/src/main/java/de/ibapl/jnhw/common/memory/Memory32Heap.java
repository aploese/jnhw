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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.datatypes.BaseDataTypes;

/**
 *
 * @author aploese
 */
public class Memory32Heap extends OpaqueMemory32 {

    public Memory32Heap(int sizeInBytes, boolean clearMem) {
        super(sizeInBytes, clearMem);
    }

    public Memory32Heap(NativeAddressHolder nativeAddress, int sizeInBytes) {
        super(nativeAddress, sizeInBytes);
    }

    @Override
    public BaseDataTypes getBaseDataType() {
        return BaseDataTypes.intptr_t;
    }

    @Override
    public String nativeToHexString() {
        if (sizeInBytes > Integer.MAX_VALUE / 2) {
            throw new UnsupportedOperationException("memory block is too big!");
        } else {
            StringBuilder sb = new StringBuilder(sizeInBytes * 2);
            for (int i = 0; i < sizeInBytes; i++) {
                sb.append(String.format("%02x", OpaqueMemory32.getByte(this, i)));
            }
            return sb.toString();
        }
    }

}
