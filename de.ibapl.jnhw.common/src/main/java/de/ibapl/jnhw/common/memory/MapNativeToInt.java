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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import java.io.IOException;

/**
 *
 * @author aploese
 */
public class MapNativeToInt extends NativeIntNumber {

    private final BaseDataType dataType;
    private final boolean unsigned;

    public MapNativeToInt(BaseDataType nativeType, AbstractNativeMemory owner, int offset, SetMem setMem) {
        super(owner, offset, nativeType.SIZE_OF, setMem);
        if (nativeType.SIZE_OF > BaseDataType.int32_t.SIZE_OF) {
            throw new IllegalArgumentException("Data type is too big, a smaller data type was expected");
        }
        dataType = nativeType;
        unsigned = dataType.UNSIGNED;
    }

    public int asInt() {
        if (unsigned) {
            return MEM_ACCESS.getUnsignedIntOf(this, 0, sizeInBytes);
        } else {
            return MEM_ACCESS.getSignedIntOf(this, 0, sizeInBytes);
        }
    }

    public void asInt(int value) {
        if (unsigned) {
            MEM_ACCESS.setUnsignedIntOf(this, 0, sizeInBytes, value);
        } else {
            MEM_ACCESS.setSignedIntOf(this, 0, sizeInBytes, value);

        }
    }

    @Override
    public String nativeToHexString() {
        if (unsigned) {
            return MEM_ACCESS.getUnsignedIntOf_AsHex(this, 0, sizeInBytes);
        } else {
            return MEM_ACCESS.getSignedIntOf_AsHex(this, 0, sizeInBytes);
        }
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        if (unsigned) {
            sb.append(MEM_ACCESS.getUnsignedLongOf_nativeToString(this, 0, sizeInBytes));
        } else {
            sb.append(MEM_ACCESS.getSignedLongOf_nativeToString(this, 0, sizeInBytes));
        }
    }

    @Override
    public BaseDataType getBaseDataType() {
        return dataType;
    }

}
