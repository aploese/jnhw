/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.test.memory;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.PointerArray;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class PointerArrayTest {

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }

    public PointerArrayTest() {
    }

    /**
     * Test of si method, of class PointerArray.
     */
    @Test
    public void testSizeofPointer() {
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _32_BIT:
                Assertions.assertEquals(4, BaseDataType.uintptr_t.SIZE_OF);
                break;
            case _64_BIT:
                Assertions.assertEquals(8, BaseDataType.uintptr_t.SIZE_OF);
                break;
            default:
                throw new RuntimeException("Unknown SizeOfPointer");
        }
    }

    @Test
    public void testAlignofPointer() {
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _32_BIT:
                Assertions.assertEquals(Alignment.AT_4, BaseDataType.uintptr_t.ALIGN_OF);
                break;
            case _64_BIT:
                Assertions.assertEquals(Alignment.AT_8, BaseDataType.uintptr_t.ALIGN_OF);
                break;
            default:
                throw new RuntimeException("Unknown SizeOfPointer");
        }
    }

    /**
     * Test of set method, of class PointerArray.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testSetAndGet() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            System.out.println("set");
            PointerArray.ElementProducer<OpaqueMemory> producerFail = (baseAddress, index, cachedElement) -> {
                Assertions.fail("Not expecting to be called for index: " + index);
                return null;
            };
            PointerArray<OpaqueMemory> instance = new PointerArray<>(MemorySegment.allocateNative(16 * BaseDataType.uintptr_t.SIZE_OF, ms), 0, 16);
            OpaqueMemory element1 = MemoryHeap.wrap(MemorySegment.allocateNative(8, ms));
            OpaqueMemory.setByte(element1, 0, (byte) 1);
            instance.set(1, element1);
            for (int i = 0; i < instance.length(); i++) {
                instance.get(i, producerFail);
            }

            OpaqueMemory element2 = MemoryHeap.wrap(MemorySegment.allocateNative(8, ms));
            OpaqueMemory.setByte(element2, 0, (byte) 2);
            instance.set(2, element2);
            for (int i = 0; i < instance.length(); i++) {
                instance.get(i, producerFail);
            }

            instance.set(4, element1);
            for (int i = 0; i < instance.length(); i++) {
                instance.get(i, producerFail);
            }
        }
    }

    /**
     * Test of toString method, of class PointerArray.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testNativeToString() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            System.out.println("toString");
            PointerArray<OpaqueMemory> instance = new PointerArray<>(MemorySegment.allocateNative(6 * BaseDataType.uintptr_t.SIZE_OF, ms), 0, 6);
            OpaqueMemory element1 = MemoryHeap.wrap(MemorySegment.allocateNative(1, ms));
            instance.set(1, element1);
            String result = instance.nativeToString();
            Assertions.assertEquals("[null, " + element1.nativeToString() + ", null, null, null, null]", result);
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testArrayBounds() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            PointerArray<OpaqueMemory> instance = new PointerArray<>(MemorySegment.allocateNative(2 * BaseDataType.uintptr_t.SIZE_OF, ms), 0, 2);

            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                instance.set(-1, null);
            });
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                instance.get(-1, (baseAddress, index, cachedElement) -> {
                    return null;
                });
            });
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                instance.set(16, null);
            });
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                instance.get(16, (baseAddress, index, cachedElement) -> {
                    return null;
                });
            });
        }
    }

}
