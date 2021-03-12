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
package de.ibapl.jnhw.common.test.memory;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.PointerArray32;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SET_MEM_TO_0;
import de.ibapl.jnhw.common.memory.layout.Alignment;

/**
 *
 * @author aploese
 */
public class PointerArray32Test {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }

    private static native int getCachedReferencesLength(PointerArray32 pointerArray);

    public PointerArray32Test() {
    }

    /**
     * Test of si method, of class PointerArray.
     */
    @Test
    public void testSizeofPointer() {
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                Assertions.assertEquals(4, BaseDataType.uintptr_t.SIZE_OF);
                break;
            case _64_BIT:
                Assertions.assertEquals(8, BaseDataType.uintptr_t.SIZE_OF);
                break;
            default:
                throw new RuntimeException("Unknown Wordsize");
        }
    }

    @Test
    public void testAlignofPointer() {
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                Assertions.assertEquals(Alignment.AT_4, BaseDataType.uintptr_t.ALIGN_OF);
                break;
            case _64_BIT:
                Assertions.assertEquals(Alignment.AT_8, BaseDataType.uintptr_t.ALIGN_OF);
                break;
            default:
                throw new RuntimeException("Unknown Wordsize");
        }
    }

    /**
     * Test of set method, of class PointerArray.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testSetAndGet() {
        System.out.println("set");
        PointerArray32.ElementProducer<OpaqueMemory32> producerFail = (baseAddress, index, cachedElement) -> {
            Assertions.fail("Not expecting to be called for index: " + index);
            return null;
        };
        PointerArray32<OpaqueMemory32> instance = new PointerArray32<>(16, SET_MEM_TO_0);
        OpaqueMemory32 element1 = new Memory32Heap((OpaqueMemory32) null, 0, 8, SET_MEM_TO_0);
        OpaqueMemory32.setByte(element1, 0, (byte) 1);
        instance.set(1, element1);
        for (int i = 0; i < instance.length(); i++) {
            instance.get(i, producerFail);
        }

        OpaqueMemory32 element2 = new Memory32Heap((OpaqueMemory32) null, 0, 8, SET_MEM_TO_0);
        OpaqueMemory32.setByte(element2, 0, (byte) 2);
        instance.set(2, element2);
        for (int i = 0; i < instance.length(); i++) {
            instance.get(i, producerFail);
        }

        instance.set(4, element1);
        for (int i = 0; i < instance.length(); i++) {
            instance.get(i, producerFail);
        }
    }

    /**
     * Test of toString method, of class PointerArray.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testNativeToString() {
        System.out.println("toString");
        PointerArray32<OpaqueMemory32> instance = new PointerArray32<>(6, SET_MEM_TO_0);
        OpaqueMemory32 element1 = new Memory32Heap((OpaqueMemory32) null, 0, 1, SET_MEM_TO_0);
        instance.set(1, element1);
        String result = instance.nativeToString();
        Assertions.assertEquals("[null, " + element1.nativeToString() + ", null, null, null, null]", result);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testArrayBounds() {
        PointerArray32<OpaqueMemory32> instance = new PointerArray32<>(2, SET_MEM_TO_0);

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

    @Test
    public void testCachedPointerArrayLength() {
        PointerArray32<OpaqueMemory32> instance = new PointerArray32<>(0, SET_MEM_TO_0);
        Assertions.assertEquals(instance.length(), getCachedReferencesLength(instance));

        instance = new PointerArray32(1, SET_MEM_TO_0);
        Assertions.assertEquals(instance.length(), getCachedReferencesLength(instance));

        instance = new PointerArray32(2, SET_MEM_TO_0);
        Assertions.assertEquals(instance.length(), getCachedReferencesLength(instance));
    }

}
