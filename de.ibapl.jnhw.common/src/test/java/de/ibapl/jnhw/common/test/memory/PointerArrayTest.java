/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2022-2025, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.exception.InvalidCacheException;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.PointerArray;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.Arena;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 *
 * @author aploese
 */
public class PointerArrayTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    public PointerArrayTest() {
    }

    @BeforeEach
    public void setUpBeforeEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testTnfo);
    }

    @AfterEach
    public void tearDownAfterEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterEach(testTnfo);
    }

    /**
     * Test of si method, of class PointerArray.
     */
    @Test
    public void testSizeofPointer() {
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _32_Bit ->
                Assertions.assertEquals(4, BaseDataType.uintptr_t.byteSize);
            case _64_Bit ->
                Assertions.assertEquals(8, BaseDataType.uintptr_t.byteSize);
            default ->
                throw new RuntimeException("Unknown SizeOfPointer");
        }
    }

    @Test
    public void testAlignofPointer() {
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _32_Bit ->
                Assertions.assertEquals(Alignment.AT_4, BaseDataType.uintptr_t.ALIGNMENT);
            case _64_Bit ->
                Assertions.assertEquals(Alignment.AT_8, BaseDataType.uintptr_t.ALIGNMENT);
            default ->
                throw new RuntimeException("Unknown SizeOfPointer");
        }
    }

    /**
     * Test of set method, of class PointerArray.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testSetAndGet() throws InvalidCacheException {
        try (Arena arena = Arena.ofConfined()) {
            final Int8_t element1 = Int8_t.allocateNative(arena);
            element1.int8_t((byte) 1);
            final Int8_t element2 = Int8_t.allocateNative(arena);
            element2.int8_t((byte) 2);

            PointerArray<Int8_t> instance = new PointerArray<>(arena.allocate(16 * BaseDataType.uintptr_t.byteSize), 0, 16);

            instance.set(1, element1);
            Assertions.assertEquals(1, instance.getAs(1).int8_t());
            testInstance(instance);

            instance.set(2, element2);
            Assertions.assertEquals(2, instance.getAs(2).int8_t());
            testInstance(instance);

            instance.set(4, element1);
            testInstance(instance);
        }
    }

    /**
     * Test of toString method, of class PointerArray.
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testNativeToString() {
        try (Arena arena = Arena.ofConfined()) {
            PointerArray<OpaqueMemory> instance = new PointerArray<>(arena.allocate(6 * BaseDataType.uintptr_t.byteSize), 0, 6);
            OpaqueMemory element1 = MemoryHeap.wrap(arena.allocate(1));
            instance.set(1, element1);
            String result = instance.nativeToString();
            Assertions.assertEquals("[null, " + element1.nativeToString() + ", null, null, null, null]", result);
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testArrayBounds() {
        try (Arena arena = Arena.ofConfined()) {
            PointerArray<Pointer> instance = new PointerArray<>(arena.allocate(2 * BaseDataType.uintptr_t.byteSize), 0, 2);

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                instance.set(-1, Pointer.NULL);
            });
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                instance.get(-1);
            });
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                instance.set(16, Pointer.NULL);
            });
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                instance.get(16);
            });
        }
    }

    private void testInstance(PointerArray<?> instance) {
        for (int i = 0; i < instance.length(); i++) {
            try {
                instance.getAs(i);
                if (instance.get(i).address() == 0L) {
                    Assertions.fail();
                }
            } catch (InvalidCacheException ice) {
                if (instance.get(i).address() != 0L) {
                    Assertions.fail();
                }
            }
        }
    }

}
