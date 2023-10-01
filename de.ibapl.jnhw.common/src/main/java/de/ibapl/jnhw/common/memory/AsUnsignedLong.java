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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class AsUnsignedLong extends NativeIntNumber {

    public static AsUnsignedLong allocateNative(BaseDataType nativeType, Arena arena) {
        return new AsUnsignedLong(nativeType, arena.allocate(nativeType.SIZE_OF, nativeType.ALIGN_OF.alignof), 0);
    }

    private final BaseDataType dataType;

    public AsUnsignedLong(BaseDataType nativeType, MemorySegment memorySegment, long offset) {
        super(memorySegment, offset, nativeType.SIZE_OF);
        if (!nativeType.UNSIGNED) {
            throw new IllegalArgumentException("Data type is signed, but an unsigned data type was expected");
        }
        if (nativeType.SIZE_OF > BaseDataType.uint64_t.SIZE_OF) {
            throw new IllegalArgumentException("Data type is too big, a smaller data type was expected");
        }
        dataType = nativeType;
    }

    public static AsUnsignedLong map(BaseDataType nativeType, OpaqueMemory mem, long offset) {
        return new AsUnsignedLong(nativeType, mem.memorySegment, offset);
    }

    public long getAsUnsignedLong() {
        return MEM_ACCESS.getUnsignedLongOf(memorySegment, 0, dataType.SIZE_OF);
    }

    public void setFromUnsignedLong(long value) {
        MEM_ACCESS.setUnsignedLongOf(memorySegment, 0, dataType.SIZE_OF, value);
    }

    @Override
    public String nativeToHexString() {
        return MEM_ACCESS.getUnsignedLongOf_AsHex(memorySegment, 0, dataType.SIZE_OF);
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        sb.append(MEM_ACCESS.getUnsignedLongOf_nativeToString(memorySegment, 0, dataType.SIZE_OF));
    }

    @Override
    public BaseDataType getBaseDataType() {
        return dataType;
    }

}
