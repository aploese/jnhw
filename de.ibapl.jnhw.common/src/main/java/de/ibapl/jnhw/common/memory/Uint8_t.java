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

import de.ibapl.jnhw.common.annotation.uint8_t;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import java.io.IOException;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

/**
 *
 * @author aploese
 */
public class Uint8_t extends NativeIntNumber {

    public final static BaseDataType DATA_TYPE = BaseDataType.uint8_t;

    public static Uint8_t allocateNative(MemorySession ms) {
        return new Uint8_t(MemorySegment.allocateNative(DATA_TYPE.SIZE_OF, ms), 0);
    }

    public Uint8_t(MemorySegment memorySegment, long offset) {
        super(memorySegment, offset, DATA_TYPE.SIZE_OF);
    }

    public static Uint8_t map(OpaqueMemory mem, long offset) {
        return new Uint8_t(mem.memorySegment, offset);
    }

    @uint8_t
    public byte uint8_t() {
        return MEM_ACCESS.uint8_t(memorySegment, 0);
    }

    @uint8_t
    public short uint8_t_AsShort() {
        return MEM_ACCESS.uint8_t_AsShort(memorySegment, 0);
    }

    public void uint8_t(@uint8_t byte value) {
        MEM_ACCESS.uint8_t(memorySegment, 0, value);
    }

    public void uint8_t_FromShort(@uint8_t short value) {
        MEM_ACCESS.uint8_t_FromShort(memorySegment, 0, value);
    }

    @Override
    public String nativeToHexString() {
        return MEM_ACCESS.uint8_t_AsHex(memorySegment, 0);
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        sb.append(MEM_ACCESS.uint8_t_nativeToString(memorySegment, 0));
    }

    @Override
    public BaseDataType getBaseDataType() {
        return DATA_TYPE;
    }

}
