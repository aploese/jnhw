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
 * teh datatype unsigned long
 *
 * @author aploese
 */
public class Unsigned_Long extends NativeIntNumber {

    private final BaseDataType dataType;

    public Unsigned_Long(AbstractNativeMemory owner, long offset, SetMem setMem) {
        super(owner, offset, BaseDataType.__SIZE_OF_LONG, setMem);
        dataType = BaseDataType.getUnsigned_Long_Mapping();
    }

    public long unsigned_long() {
        return MEM_ACCESS.unsigned_long(this, 0);
    }

    public void unsigned_long(long value) {
        MEM_ACCESS.unsigned_long(this, 0, value);
    }

    @Override
    public String nativeToHexString() {
        return MEM_ACCESS.getUnsignedLongOf_AsHex(this, 0, sizeInBytes);
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        sb.append(MEM_ACCESS.getUnsignedLongOf_nativeToString(this, 0, sizeInBytes));
    }

    @Override
    public BaseDataType getBaseDataType() {
        return dataType;
    }

}
