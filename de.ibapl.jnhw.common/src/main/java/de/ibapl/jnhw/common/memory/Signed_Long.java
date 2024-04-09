/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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
 * teh datatype signed long
 *
 * @author aploese
 */
public class Signed_Long extends NativeIntNumber {

    public final static BaseDataType DATA_TYPE = BaseDataType.C_long;

    public static Signed_Long allocateNative(Arena arena) {
        return new Signed_Long(arena.allocate(DATA_TYPE.SIZE_OF, DATA_TYPE.ALIGN_OF.alignof), 0);
    }

    public Signed_Long(MemorySegment memorySegment, long offset) {
        super(memorySegment, offset, DATA_TYPE.SIZE_OF);
    }

    public static Signed_Long map(OpaqueMemory mem, long offset) {
        return new Signed_Long(mem.memorySegment, offset);
    }

    public long signed_long() {
        return MEM_ACCESS.signed_long(memorySegment, 0);
    }

    public void signed_long(long value) {
        MEM_ACCESS.signed_long(memorySegment, 0, value);
    }

    @Override
    public String nativeToHexString() {
        return MEM_ACCESS.getSignedLongOf_AsHex(memorySegment, 0, DATA_TYPE.SIZE_OF);
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        sb.append(MEM_ACCESS.getSignedLongOf_nativeToString(memorySegment, 0, DATA_TYPE.SIZE_OF));
    }

    @Override
    public BaseDataType getBaseDataType() {
        return DATA_TYPE;
    }

}
