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
public abstract class NativeIntNumber extends OpaqueMemory32 {

    public static BaseDataTypes getIntegerType(int sizeInBytes, boolean unsigned) {
        switch (sizeInBytes) {
            case 1:
                return unsigned ? BaseDataTypes.uint8_t : BaseDataTypes.int8_t;
            case 2:
                return unsigned ? BaseDataTypes.uint16_t : BaseDataTypes.int16_t;
            case 4:
                return unsigned ? BaseDataTypes.uint32_t : BaseDataTypes.int32_t;
            case 8:
                return unsigned ? BaseDataTypes.uint64_t : BaseDataTypes.int64_t;
            default:
                throw new RuntimeException("Can't handle sizeof value: " + sizeInBytes);
        }

    }

    public NativeIntNumber(int sizeInBytes, boolean clearMem) {
        super(sizeInBytes, clearMem);
    }

    public NativeIntNumber(OpaqueMemory32 owner, int offset, int sizeInBytes) {
        super(owner, offset, sizeInBytes);
    }

    protected native String nativeInt8ToHexString();

    protected native String nativeInt16ToHexString();

    protected native String nativeInt32ToHexString();

    protected native String nativeInt64ToHexString();

    @Override
    public String nativeToHexString() {
        switch (getBaseDataType()) {
            case int8_t:
            case uint8_t:
                return nativeInt8ToHexString();
            case int16_t:
            case uint16_t:
                return nativeInt16ToHexString();
            case int32_t:
            case uint32_t:
                return nativeInt32ToHexString();
            case int64_t:
            case uint64_t:
                return nativeInt64ToHexString();
            default:
                throw new RuntimeException("Cant handle baseDataType of: " + getBaseDataType());
        }
    }

}
