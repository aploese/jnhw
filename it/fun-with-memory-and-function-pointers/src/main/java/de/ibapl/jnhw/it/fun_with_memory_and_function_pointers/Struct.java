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
package de.ibapl.jnhw.it.fun_with_memory_and_function_pointers;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.Int16_t;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Int64_t;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Uint16_t;
import de.ibapl.jnhw.common.memory.Uint32_t;
import de.ibapl.jnhw.common.memory.Uint64_t;
import de.ibapl.jnhw.common.memory.Uint8_t;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactory;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactoryImpl;
import java.io.IOException;
import java.lang.foreign.Arena;

/**
 *
 * @author aploese
 */
public class Struct {

    public static void getMemory(Arena arena) {
        System.out.println("\n\nStruct.getMemory()\n");
        final MemoryHeap heap = MemoryHeap.allocateNative(1024, arena);

        final Int8_t int8_t = Int8_t.allocateNative(arena);
        int8_t.int8_t((byte) 42);
        final Int16_t int16_t = Int16_t.allocateNative(arena);
        int16_t.int16_t(int8_t.int8_t());
        final Int32_t int32_t = Int32_t.allocateNative(arena);
        int32_t.int32_t(int16_t.int16_t());
        final Int64_t int64_t = Int64_t.allocateNative(arena);
        int64_t.int64_t(int32_t.int32_t());
        System.out.println("int64_t: " + int64_t.int64_t());

        final Uint8_t uint8_t = Uint8_t.allocateNative(arena);
        uint8_t.uint8_t((byte) 42);
        final Uint16_t uint16_t = Uint16_t.allocateNative(arena);
        uint16_t.uint16_t(uint8_t.uint8_t());
        final Uint32_t uint32_t = Uint32_t.allocateNative(arena);
        uint32_t.uint32_t(uint16_t.uint16_t());
        final Uint64_t uint64_t = Uint64_t.allocateNative(arena);
        uint64_t.uint64_t(uint32_t.uint32_t());
        System.out.println("uint64_t: " + Long.toUnsignedString(uint64_t.uint64_t()));
        System.out.println();
    }

    /**
     * {@code
     * struct {
     *   int8_t _int8_t;
     *   int16_t _int16_t;
     *   int32_t _int32_t;
     *   int64_t _int64_t;
     * }
     * }
     */
    public static void onTheFlyStructure(Arena arena) {
        System.out.println("\n\nStruct.onTheFlyStructure()\n");
        final MemoryHeap heap = MemoryHeap.allocateNative(16, arena);
        StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactory.Type.STRUCT);
        final long offsetInHeap = heap.getAlignmentOffset(0, Alignment.AT_16);

        //start with offset == 0
        final Int8_t _int8_t = Int8_t.map(heap, offsetInHeap + slf.int8_t());
        _int8_t.int8_t((byte) 0x61);//a
        //alignment on 2 byte boundary after int16_t
        final Int16_t _int16_t = Int16_t.map(heap, offsetInHeap + slf.int16_t());
        _int16_t.int16_t((short) 0x6362);//bc
        final Int32_t _int32_t = Int32_t.map(heap, offsetInHeap + slf.int32_t());
        _int32_t.int32_t(0x67666564);//defg
        final Int64_t _int64_t = Int64_t.map(heap, offsetInHeap + slf.int64_t());
        _int64_t.int64_t(0x6f6e6d6c6b6a6968L);//hijklmno

        System.out.println("int8_t: " + _int8_t.toString() + " " + _int8_t.int8_t());
        System.out.println("int16_t: " + _int16_t.toString() + " " + _int16_t.int16_t());
        System.out.println("int32_t: " + _int32_t.toString() + " " + _int32_t.int32_t());
        System.out.println("int64_t: " + _int64_t.toString() + " " + _int64_t.int64_t());
        System.out.println("nativeToHexString:\n" + heap.nativeToHexString());
        //the gap betwen a and b is due to the alignment of int16_t
        System.out.println("nativeToString:\n" + heap.nativeToString());
        System.out.println();
    }

    /**
     * {@code
     * struct {
     *   int8_t _int8_t;
     *   union {
     *     int16_t _int16_t;
     *     int32_t _int32_t;
     *     int64_t _int64_t;
     * }
     * }
     * }
     */
    public static void onTheFlyUnion(Arena arena) {
        System.out.println("\n\nStruct.onTheFlyUnion()\n");
        final MemoryHeap heap = MemoryHeap.allocateNative(16, arena);
        StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactory.Type.STRUCT);
        final long offsetInHeap = heap.getAlignmentOffset(0, Alignment.AT_8);

        //start with offset == 0
        final Int8_t _int8_t = Int8_t.map(heap, offsetInHeap + slf.int8_t());
        _int8_t.int8_t((byte) 'a');

        //use the biggest alignment to align union
        final long unionOffset = offsetInHeap + slf.union(BaseDataType.int64_t.SIZE_OF, BaseDataType.int64_t.ALIGN_OF);
        //alignment on 2 byte boundary after int16_t
        final Int16_t _int16_t = Int16_t.map(heap, unionOffset);
        final Int32_t _int32_t = Int32_t.map(heap, unionOffset);
        final Int64_t _int64_t = Int64_t.map(heap, unionOffset);
        _int32_t.int32_t('b');

        System.out.println("int8_t: " + _int8_t.int8_t());
        System.out.println("int16_t: " + _int16_t.int16_t());
        System.out.println("int32_t: " + _int32_t.int32_t());
        System.out.println("int64_t: " + _int64_t.int64_t());
        System.out.println("mem:\n" + heap.nativeToString());
        System.out.println();
    }

    public static void printMemory(Arena arena) throws IOException {
        System.out.println("\n\nStruct.printMemory()\n");
        final MemoryHeap heap = MemoryHeap.allocateNative(256, arena);
        for (int i = 0; i < heap.sizeof(); i++) {
            OpaqueMemory.setByte(heap, i, (byte) i);
        }
        System.out.println();
        System.out.println("toString:\n" + heap.toString());
        System.out.println();
        System.out.println("nativeToHexString:\n" + heap.nativeToHexString());
        System.out.println();
        System.out.println("nativeToString:\n" + heap.nativeToString());
        System.out.println();
        System.out.println("OpaqueMemory32.printMemory:\n" + heap.nativeToString());
        OpaqueMemory.printMemory(System.out, heap, true);
        System.out.println();
    }

}
