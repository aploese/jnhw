/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2025, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.annotation.int8_t;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
@int8_t
public class Int8_t extends NativeIntNumber<Byte> {

    public final static BaseDataType DATA_TYPE = BaseDataType.int8_t;

    public static Int8_t allocateNative(Arena arena) {
        return new Int8_t(arena.allocate(DATA_TYPE.byteSize, DATA_TYPE.byteAlignment), 0);
    }

    public static Int8_t map(OpaqueMemory mem, long offset) {
        return new Int8_t(mem.memorySegment, offset);
    }

    public Int8_t(MemorySegment memorySegment, long offset) {
        super(memorySegment, offset, DATA_TYPE.byteSize);
    }

    @int8_t
    public byte int8_t() {
        return MEM_ACCESS.int8_t(memorySegment, 0);
    }

    public void int8_t(@int8_t byte value) {
        MEM_ACCESS.int8_t(memorySegment, 0, value);
    }

    @Override
    public String nativeToHexString() {
        return MEM_ACCESS.int8_t_AsHex(memorySegment, 0);
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        sb.append(MEM_ACCESS.int8_t_nativeToString(memorySegment, 0));
    }

    @Override
    public BaseDataType getBaseDataType() {
        return DATA_TYPE;
    }

}
