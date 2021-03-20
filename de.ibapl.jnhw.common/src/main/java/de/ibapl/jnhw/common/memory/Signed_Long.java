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
 * teh datatype signed long
 *
 * @author aploese
 */
public class Signed_Long extends NativeIntNumber {

    private final BaseDataType dataType;

    public Signed_Long(AbstractNativeMemory owner, long offset, Byte setMem) {
        super(owner, offset, BaseDataType.__SIZE_OF_LONG, setMem);
        dataType = BaseDataType.getSigned_Long_Mapping();
    }

    public long signed_long() {
        return MEM_ACCESS.signed_long(this, 0);
    }

    public void signed_long(long value) {
        MEM_ACCESS.signed_long(this, 0, value);
    }

    @Override
    public String nativeToHexString() {
        return MEM_ACCESS.getSignedLongOf_AsHex(this, 0, sizeInBytes);
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        sb.append(MEM_ACCESS.getSignedLongOf_nativeToString(this, 0, sizeInBytes));
    }

    @Override
    public BaseDataType getBaseDataType() {
        return dataType;
    }

}
