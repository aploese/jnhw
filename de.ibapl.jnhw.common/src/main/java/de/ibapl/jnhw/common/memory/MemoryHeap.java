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
import de.ibapl.jnhw.common.memory.layout.Alignment;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

/**
 *
 * @author aploese
 */
public class MemoryHeap extends OpaqueMemory {

    public static MemoryHeap allocateNative(long bytesSize, MemorySession ms) {
        return new MemoryHeap(MemorySegment.allocateNative(bytesSize, ms), 0, bytesSize);
    }

    public MemoryHeap(MemorySegment memorySegment, long offset, long sizeInBytes) {
        super(memorySegment, offset, sizeInBytes);
    }

    public MemoryHeap(MemoryAddress address, MemorySession ms, long sizeInBytes) {
        super(address, ms, sizeInBytes);
    }

    public static MemoryHeap ofArray(byte[] bytes) {
        final MemorySegment memorySegment = MemorySegment.ofArray(bytes);
        return new MemoryHeap(memorySegment, 0, bytes.length);
    }

    public static MemoryHeap wrap(MemorySegment mem) {
        return new MemoryHeap(mem, 0, mem.byteSize());
    }

    /**
     * map a new MemoryHeap at offset with sizeInBytes onto mem.
     *
     * @param mem
     * @param offset
     * @param sizeInBytes
     * @return
     */
    public static MemoryHeap map(OpaqueMemory mem, long offset, long sizeInBytes) {
        return new MemoryHeap(mem.memorySegment, offset, sizeInBytes);
    }

    @Override
    public BaseDataType getBaseDataType() {
        return BaseDataType.intptr_t;
    }

    @Deprecated
    public long nextOffset(OpaqueMemory fieldOnTheFly, Alignment fieldAlignment) {
        return OpaqueMemory.calcOffsetForAlignment(this, fieldAlignment, memorySegment.segmentOffset(fieldOnTheFly.memorySegment) + fieldOnTheFly.sizeof());
    }

    @Deprecated
    public long getAlignmentOffset(long offset, Alignment alignment) {
        return OpaqueMemory.calcOffsetForAlignment(this, alignment, offset);
    }

}
