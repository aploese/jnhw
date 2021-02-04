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

import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.PointerArray32;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
                Assertions.assertEquals(4, PointerArray32.sizeofPointer());
                break;
            case _64_BIT:
                Assertions.assertEquals(8, PointerArray32.sizeofPointer());
                break;
            default:
                throw new RuntimeException("Unknown Wordsize");
        }
    }

    @Test
    public void testAlignofPointer() {
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                Assertions.assertEquals(4, PointerArray32.alignofPointer());
                break;
            case _64_BIT:
                Assertions.assertEquals(8, PointerArray32.alignofPointer());
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
        PointerArray32<OpaqueMemory32> instance = new PointerArray32<>(16, true);
        OpaqueMemory32 element1 = new Memory32Heap(8, true);
        OpaqueMemory32.setByte(element1, 0, (byte) 1);
        instance.set(1, element1);
        OpaqueMemory32 element2 = new Memory32Heap(8, true);
        OpaqueMemory32.setByte(element2, 0, (byte) 2);
        instance.set(2, element2);
        instance.set(4, element1);
        instance.get(0, (baseAddress, index, cachedElement) -> {
            Assertions.assertEquals(null, cachedElement);
            Assertions.assertEquals(0, index);
            Assertions.assertEquals(new NativeAddressHolder(0L), baseAddress);
            return cachedElement;
        });
        instance.get(1, (baseAddress, index, cachedElement) -> {
            Assertions.assertSame(element1, cachedElement);
            Assertions.assertEquals(1, index);
            Assertions.assertTrue(OpaqueMemory32.isSameAddress(baseAddress, cachedElement), "baseaddress != cachedElement.baseAddress");
            return cachedElement;
        });
        instance.get(3, (baseAddress, index, cachedElement) -> {
            Assertions.assertEquals(null, cachedElement);
            Assertions.assertEquals(3, index);
            Assertions.assertEquals(new NativeAddressHolder(0L), baseAddress);
            return cachedElement;
        });
        instance.get(2, (baseAddress, index, cachedElement) -> {
            Assertions.assertSame(element2, cachedElement);
            Assertions.assertEquals(2, index);
            Assertions.assertTrue(OpaqueMemory32.isSameAddress(baseAddress, cachedElement), "baseaddress != cachedElement.baseAddress");
            return cachedElement;
        });
        instance.get(4, (baseAddress, index, cachedElement) -> {
            Assertions.assertSame(element1, cachedElement);
            Assertions.assertEquals(4, index);
            Assertions.assertTrue(OpaqueMemory32.isSameAddress(baseAddress, cachedElement), "baseaddress != cachedElement.baseAddress");
            return cachedElement;
        });

    }

    /**
     * Test of toString method, of class PointerArray.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testNativeToString() {
        System.out.println("toString");
        PointerArray32<OpaqueMemory32> instance = new PointerArray32<>(6, true);
        OpaqueMemory32 element1 = new Memory32Heap(1, true);
        instance.set(1, element1);
        String result = instance.nativeToString();
        Assertions.assertEquals("[null, " + element1.nativeToString() + ", null, null, null, null]", result);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testArrayBounds() {
        PointerArray32<OpaqueMemory32> instance = new PointerArray32<>(2, true);

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
        PointerArray32<OpaqueMemory32> instance = new PointerArray32<>(0, true);
        Assertions.assertEquals(instance.length(), getCachedReferencesLength(instance));

        instance = new PointerArray32(1, true);
        Assertions.assertEquals(instance.length(), getCachedReferencesLength(instance));

        instance = new PointerArray32(2, true);
        Assertions.assertEquals(instance.length(), getCachedReferencesLength(instance));
    }

}
