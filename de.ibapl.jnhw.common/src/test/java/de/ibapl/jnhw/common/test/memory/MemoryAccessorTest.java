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
package de.ibapl.jnhw.common.test.memory;

import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Int64_t;
import de.ibapl.jnhw.common.memory.MemoryAccessor;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Uint32_t;
import de.ibapl.jnhw.common.memory.Uint64_t;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.SizeInBit;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.nio.ByteOrder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * succ64_X is the Xth successor in 64bit mode succ32_X is the Xth successor in
 * 32bit mode
 *
 * @author aploese
 */
public class MemoryAccessorTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    @BeforeEach
    public void setUpBeforeEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testTnfo);
    }

    @AfterEach
    public void tearDownAfterEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterEach(testTnfo);
    }

    private final static boolean IS_BIG_ENDIAN = MultiarchTupelBuilder.getEndianess().isBigEndian();

    private final static MemorySession ms = MemorySession.openConfined();

    private final static int HEAP_SIZE = 8 * 12;

    private final static MemoryHeap heap = MemoryHeap.wrap(MemorySegment.allocateNative(HEAP_SIZE, ms));
    private final static Int64_t prev = Int64_t.map(heap, 0);

    //Her is the place to write/read
    private final static Int64_t mem64 = Int64_t.map(heap, 8 * 1);
    private final static Int32_t mem32 = Int32_t.map(heap, 4 * 2);
    private final static MemoryHeap buff_16 = MemoryHeap.map(heap, 8 * 1, 16);

    private final static Uint32_t succ32_1 = Uint32_t.map(heap, 4 * 3);

    private final static Uint64_t succ64_1 = Uint64_t.map(heap, 8 * 2);
    private final static Uint32_t succ32_2 = Uint32_t.map(heap, 4 * 4);
    private final static Uint32_t succ32_3 = Uint32_t.map(heap, 4 * 5);

    private final static Uint64_t succ64_2 = Uint64_t.map(heap, 8 * 3);
    private final static Uint32_t succ32_4 = Uint32_t.map(heap, 4 * 6);
    private final static Uint32_t succ32_5 = Uint32_t.map(heap, 4 * 7);

    private final static Uint64_t succ64_3 = Uint64_t.map(heap, 8 * 4);
    private final static Uint32_t succ32_6 = Uint32_t.map(heap, 4 * 8);
    private final static Uint32_t succ32_7 = Uint32_t.map(heap, 4 * 9);

    private final static Uint64_t succ64_4 = Uint64_t.map(heap, 8 * 5);
    private final static Uint32_t succ32_8 = Uint32_t.map(heap, 4 * 10);
    private final static Uint32_t succ32_9 = Uint32_t.map(heap, 4 * 11);

    @AfterAll
    public static void afterAll() {
        ms.close();
    }

    //byte order native
    private final MemoryAccessor ma = MemoryAccessor.getMemoryAccessor(ByteOrder.nativeOrder());
    //byte order little endian
    private final MemoryAccessor maLE = MemoryAccessor.getMemoryAccessor(ByteOrder.LITTLE_ENDIAN);
    //byte order big endian
    private final MemoryAccessor maBE = MemoryAccessor.getMemoryAccessor(ByteOrder.BIG_ENDIAN);

    @BeforeEach
    public void beforeEach() {
        OpaqueMemory.clear(heap);
    }

    public static void assertMemIsClean() {
        // Just make sure we have not written outside...
        assertEquals(0L, prev.int64_t());
        assertEquals(0L, succ64_1.uint64_t());
        assertEquals(0L, succ64_2.uint64_t());
        assertEquals(0L, succ64_3.uint64_t());
        assertEquals(0L, succ64_4.uint64_t());
    }

    /**
     * Test of int8_t (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(bytes = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testInt8_t_ByteTest(byte value) {
        ma.int8_t(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsByte(value);
        assertEquals(value, ma.int8_t(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%02x", value), ma.int8_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Byte.toString(value), ma.int8_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of SignedIntOf (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testSignedIntOf_ByteTest(int value) {
        ma.setSignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 1, value);
        assertMemIsClean();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.getSignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 1));

        assertEquals(String.format("0x%02x", value & 0xff), ma.getSignedIntOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 1));
        assertEquals(Byte.toString((byte) value), ma.getSignedIntOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 1));
    }

    /**
     * Test of SignedLongOf (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testSignedLongOf_ByteTest(long value) {
        ma.setSignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 1, value);
        assertMemIsClean();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.getSignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 1));

        assertEquals(String.format("0x%02x", value & 0xff), ma.getSignedLongOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 1));
        assertEquals(Byte.toString((byte) value), ma.getSignedLongOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 1));
    }

    /**
     * Test of uint8_t (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(bytes = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testUint8_t_ByteTest(byte value) {
        ma.uint8_t(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsByte(value);
        assertEquals(value, ma.uint8_t(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%02x", value), ma.uint8_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Integer.toString(value & 0xff), ma.uint8_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of uint8_t (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {-1, 0, 1, 0x00ff, 0x0100})
    public void testUint8_t_ShortTest(short value) {
        if ((value < 0) || (value > 0xff)) {
            assertThrows(IllegalArgumentException.class,
                    () -> ma.uint8_t_FromShort(OpaqueMemory.getMemorySegment(mem64), 0, value));
            assertMemIsClean();
            assertMemIsClear();
            return;
        }

        ma.uint8_t_FromShort(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.uint8_t_AsShort(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%02x", value), ma.uint8_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Integer.toString(value & 0xffff), ma.uint8_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of UnsignedIntOf (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testUnsignedInt_ByteTest(int value) {
        if ((value < 0) || (value > 0xff)) {
            assertThrows(IllegalArgumentException.class,
                    () -> ma.setUnsignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 1, value));
            assertMemIsClean();
            assertMemIsClear();
            return;
        }

        ma.setUnsignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 1, value);
        assertMemIsClean();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.getUnsignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 1));

        assertEquals(String.format("0x%02x", value & 0xff), ma.getUnsignedIntOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 1));
        assertEquals(Integer.toString(value & 0xff), ma.getUnsignedIntOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 1));
    }

    /**
     * Test of UnsignedLongOf (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testUnsignedLong_ByteTest(long value) {
        if ((value < 0) || (value > 0xff)) {
            assertThrows(IllegalArgumentException.class,
                    () -> ma.setUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 1, value));
            assertMemIsClean();
            assertMemIsClear();
            return;
        }

        ma.setUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 1, value);
        assertMemIsClean();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.getUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 1));

        assertEquals(String.format("0x%02x", value & 0xff), ma.getUnsignedLongOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 1));
        assertEquals(Long.toString(value & 0xff), ma.getUnsignedLongOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 1));
    }

    /**
     * Test of int16_t (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {Short.MIN_VALUE, -1, 0, 1, Short.MAX_VALUE})
    public void testInt16_t_ShortTest(short value) {
        ma.int16_t(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsShort(value);
        assertEquals(value, ma.int16_t(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%04x", value), ma.int16_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Short.toString(value), ma.int16_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of SignedIntOf (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Short.MIN_VALUE, -1, 0, 1, Short.MAX_VALUE})
    public void testSignedIntOf_ShortTest(int value) {
        ma.setSignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 2, value);
        assertMemIsClean();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.getSignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 2));

        assertEquals(String.format("0x%04x", value & 0xffff), ma.getSignedIntOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 2));
        assertEquals(Short.toString((short) value), ma.getSignedIntOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 2));
    }

    /**
     * Test of SignedLongOf (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {Short.MIN_VALUE, -1, 0, 1, Short.MAX_VALUE})
    public void testSignedLongOf_ShortTest(long value) {
        ma.setSignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 2, value);
        assertMemIsClean();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.getSignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 2));

        assertEquals(String.format("0x%04x", value & 0xffff), ma.getSignedLongOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 2));
        assertEquals(Short.toString((short) value), ma.getSignedLongOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 2));
    }

    /**
     * Test of uint16_t (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {Short.MIN_VALUE, -1, 0, 1, Short.MAX_VALUE})
    public void testUint16_t_ShortTest(short value) {
        ma.uint16_t(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsShort(value);
        assertEquals(value, ma.uint16_t(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%04x", value), ma.uint16_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Integer.toString(value & 0xffff), ma.uint16_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of uint16_t (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 0x0000ffff, 0x00010000})
    public void testUint16_t_IntTest(int value) {
        if ((value < 0) || (value > 0xffff)) {
            assertThrows(IllegalArgumentException.class,
                    () -> ma.uint16_t_FromInt(OpaqueMemory.getMemorySegment(mem64), 0, value));
            assertMemIsClean();
            assertMemIsClear();
            return;
        }

        ma.uint16_t_FromInt(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.uint16_t_AsInt(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%04x", value), ma.uint16_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Integer.toUnsignedString(value), ma.uint16_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of UnsignedIntOf (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 0x0000ffff, 0x00010000})
    public void testUnsignedInt_ShortTest(int value) {
        if ((value < 0) || (value > 0xffff)) {
            assertThrows(IllegalArgumentException.class,
                    () -> ma.setUnsignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 2, value));
            assertMemIsClean();
            assertMemIsClear();
            return;
        }

        ma.setUnsignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 2, value);
        assertMemIsClean();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.getUnsignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 2));

        assertEquals(String.format("0x%04x", value & 0xffff), ma.getUnsignedIntOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 2));
        assertEquals(Integer.toString(value & 0xffff), ma.getUnsignedIntOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 2));
    }

    /**
     * Test of UnsignedLongOf (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 0x0000ffff, 0x00010000})
    public void testUnsignedLong_ShortTest(long value) {
        if ((value < 0) || (value > 0xffff)) {
            assertThrows(IllegalArgumentException.class,
                    () -> ma.setUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 2, value));
            assertMemIsClean();
            assertMemIsClear();
            return;
        }

        ma.setUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 2, value);
        assertMemIsClean();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.getUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 2));

        assertEquals(String.format("0x%04x", value & 0xffff), ma.getUnsignedLongOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 2));
        assertEquals(Long.toString(value & 0xffff), ma.getUnsignedLongOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 2));
    }

    /**
     * Test of int32_t (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    public void testInt32_t_IntTest(int value) {
        ma.int32_t(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsInt(value);
        assertEquals(value, ma.int32_t(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%08x", value), ma.int32_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Integer.toString(value), ma.int32_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of SignedIntOf (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    public void testSignedIntOf_IntTest(int value) {
        ma.setSignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 4, value);
        assertMemIsClean();
        assertMemEqualsInt(value);
        assertEquals(value, ma.getSignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 4));

        assertEquals(String.format("0x%08x", value), ma.getSignedIntOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 4));
        assertEquals(Integer.toString(value), ma.getSignedIntOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 4));
    }

    /**
     * Test of SignedLongOf (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE, Long.MAX_VALUE})
    public void testSignedLongOf_IntTest(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            assertThrows(IllegalArgumentException.class,
                    () -> ma.setSignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 4, value));
            assertMemIsClean();
            assertMemIsClear();
            return;
        }

        ma.setSignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 4, value);
        assertMemIsClean();
        assertMemEqualsInt((int) value);
        assertEquals(value, ma.getSignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 4));

        assertEquals(String.format("0x%08x", value & 0xffffffffL), ma.getSignedLongOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 4));
        assertEquals(Integer.toString((int) value), ma.getSignedLongOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 4));
    }

    /**
     * Test of uint32_t (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    public void testUint32_t_IntTest(int value) {
        ma.uint32_t(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsInt(value);
        assertEquals(value, ma.uint32_t(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%08x", value), ma.uint32_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Long.toString(value & 0xffffffffL), ma.uint32_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of uint32_t (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 0x00000000ffffffff, 0x0000000100000000L})
    public void testUint32_t_LongTest(long value) {
        if ((value < 0) || (value > 0xffffffffL)) {
            assertThrows(IllegalArgumentException.class,
                    () -> ma.uint32_t_FromLong(OpaqueMemory.getMemorySegment(mem64), 0, value));
            assertMemIsClean();
            assertMemIsClear();
            return;
        }

        ma.uint32_t_FromLong(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsInt((int) value);
        assertEquals(value, ma.uint32_t_AsLong(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%08x", value), ma.uint32_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Long.toUnsignedString(value), ma.uint32_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of UnsignedIntOf (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    public void testUnsignedInt_IntTest(int value) {
        ma.setUnsignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 4, value);
        assertMemIsClean();
        assertMemEqualsInt((int) value);
        assertEquals(value, ma.getUnsignedIntOf(OpaqueMemory.getMemorySegment(mem64), 0, 4));

        assertEquals(String.format("0x%08x", value), ma.getUnsignedIntOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 4));
        assertEquals(Integer.toUnsignedString(value), ma.getUnsignedIntOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 4));
    }

    /**
     * Test of UnsignedLongOf (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 0x00000000ffffffff, 0x0000000100000000L})
    public void testUnsignedLong_IntTest(long value) {
        if ((value < 0) || (value > 0xffffffffL)) {
            assertThrows(IllegalArgumentException.class,
                    () -> ma.setUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 4, value));
            assertMemIsClean();
            assertMemIsClear();
            return;
        }

        ma.setUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 4, value);
        assertMemIsClean();
        assertMemEqualsInt((int) value);
        assertEquals(value, ma.getUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 4));

        assertEquals(String.format("0x%08x", value & 0xffffffffL), ma.getUnsignedLongOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 4));
        assertEquals(Long.toUnsignedString(value & 0xffffffffL), ma.getUnsignedLongOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 4));
    }

    /**
     * Test of int64_t (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE})
    public void testInt64_t_LongTest(long value) {
        ma.int64_t(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsLong(value);
        assertEquals(value, ma.int64_t(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%016x", value), ma.int64_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Long.toString(value), ma.int64_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of SignedLongOf (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE})
    public void testSignedLongOf_LongTest(long value) {
        ma.setSignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 8, value);
        assertMemIsClean();
        assertMemEqualsLong(value);
        assertEquals(value, ma.getSignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 8));

        assertEquals(String.format("0x%016x", value), ma.getSignedLongOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 8));
        assertEquals(Long.toString(value), ma.getSignedLongOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 8));
    }

    /**
     * Test of uint64_t (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE})
    public void testUint64_t_LongTest(long value) {
        ma.uint64_t(OpaqueMemory.getMemorySegment(mem64), 0, value);
        assertMemIsClean();
        assertMemEqualsLong(value);
        assertEquals(value, ma.uint64_t(OpaqueMemory.getMemorySegment(mem64), 0));

        assertEquals(String.format("0x%016x", value), ma.uint64_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
        assertEquals(Long.toUnsignedString(value), ma.uint64_t_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0));
    }

    /**
     * Test of UnsignedLongOf (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE})
    public void testUnsignedLong_LongTest(long value) {
        ma.setUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 8, value);
        assertMemIsClean();
        assertMemEqualsLong(value);
        assertEquals(value, ma.getUnsignedLongOf(OpaqueMemory.getMemorySegment(mem64), 0, 8));

        assertEquals(String.format("0x%016x", value), ma.getUnsignedLongOf_AsHex(OpaqueMemory.getMemorySegment(mem64), 0, 8));
        assertEquals(Long.toUnsignedString(value), ma.getUnsignedLongOf_nativeToString(OpaqueMemory.getMemorySegment(mem64), 0, 8));
    }

    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE, Long.MAX_VALUE})
    public void testIntptr_tTest(long value) {
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _32_BIT -> {
                // TODO BUG OpneJDK silent masking with 0x000000ffffffL
                ma.intptr_t(OpaqueMemory.getMemorySegment(mem64), 0, MemoryAddress.ofLong(value));
                assertMemIsClean();
                assertMemEqualsInt((int) value);
                assertEquals(MemoryAddress.ofLong((int) value), ma.intptr_t(OpaqueMemory.getMemorySegment(mem32), 0));
            }
            case _64_BIT -> {
                ma.intptr_t(OpaqueMemory.getMemorySegment(mem64), 0, MemoryAddress.ofLong(value));
                assertMemIsClean();
                assertMemEqualsLong(value);
                assertEquals(MemoryAddress.ofLong(value), ma.intptr_t(OpaqueMemory.getMemorySegment(mem64), 0));
            }
            default ->
                fail();
        }
    }

    @Test
    public void testIntptr_t_AtIndex() {
        final MemoryAddress address;
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _32_BIT -> {
                address = MemoryAddress.ofLong(0x04030201L);
                ma.intptr_t_AtIndex(OpaqueMemory.getMemorySegment(heap), 2, address);
                assertEquals(address, ma.intptr_t_AtIndex(OpaqueMemory.getMemorySegment(heap), 2));
                assertEquals(0, prev.int64_t());
                assertEquals(address, MemoryAddress.ofLong(ma.int32_t(OpaqueMemory.getMemorySegment(mem32), 0)));
                assertEquals(0, succ32_1.uint32_t());
            }
            case _64_BIT -> {
                address = MemoryAddress.ofLong(0x0807060504030201L);
                ma.intptr_t_AtIndex(OpaqueMemory.getMemorySegment(heap), 1, address);
                assertEquals(address, ma.intptr_t_AtIndex(OpaqueMemory.getMemorySegment(heap), 1));
                assertEquals(0, prev.int64_t());
                assertEquals(address, MemoryAddress.ofLong(ma.int64_t(OpaqueMemory.getMemorySegment(mem64), 0)));
                assertEquals(0, succ64_1.uint64_t());
            }
            default ->
                fail("cant handle pointer size: " + MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer);
        }
    }

    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE, Long.MAX_VALUE})
    public void testIntptr_t_AtIndex(long value) {
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _32_BIT -> {
                // TODO BUG OpneJDK silent masking with 0x000000ffffffL
                ma.intptr_t(OpaqueMemory.getMemorySegment(mem64), 0, MemoryAddress.ofLong(value));
                assertMemIsClean();
                assertMemEqualsInt((int) value);
                assertEquals(MemoryAddress.ofLong((int) value), ma.intptr_t_AtIndex(OpaqueMemory.getMemorySegment(mem32), 0));
            }
            case _64_BIT -> {
                ma.intptr_t(OpaqueMemory.getMemorySegment(mem64), 0, MemoryAddress.ofLong(value));
                assertMemIsClean();
                assertMemEqualsLong(value);
                assertEquals(MemoryAddress.ofLong(value), ma.intptr_t_AtIndex(OpaqueMemory.getMemorySegment(mem64), 0));
            }
            default ->
                fail();
        }
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 0x00000000ffffffff, 0x0000000100000000L})
    public void testUintPtr_tTest(long value) {
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _32_BIT -> {
                // TODO BUG OpneJDK silent masking with 0x000000ffffffL
                ma.uintptr_t(OpaqueMemory.getMemorySegment(mem64), 0, MemoryAddress.ofLong(value));
                assertMemIsClean();
                assertMemEqualsInt((int) value);
                assertEquals(MemoryAddress.ofLong(0xffffffffL & value), ma.uintptr_t(OpaqueMemory.getMemorySegment(mem32), 0));
                assertEquals(String.format("0x%08x", 0xffffffffL & value), ma.uintptr_t_AsHex(OpaqueMemory.getMemorySegment(mem32), 0));
            }
            case _64_BIT -> {
                ma.uintptr_t(OpaqueMemory.getMemorySegment(mem64), 0, MemoryAddress.ofLong(value));
                assertMemIsClean();
                assertMemEqualsLong(value);
                assertEquals(MemoryAddress.ofLong(value), ma.uintptr_t(OpaqueMemory.getMemorySegment(mem64), 0));
                assertEquals(String.format("0x%016x", value), ma.uintptr_t_AsHex(OpaqueMemory.getMemorySegment(mem64), 0));
            }
            default ->
                fail();
        }
    }

    @Test
    public void testUintptr_t_AtIndex() {
        final MemoryAddress address;
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _32_BIT -> {
                address = MemoryAddress.ofLong(0x04030201L);
                ma.uintptr_t_AtIndex(OpaqueMemory.getMemorySegment(heap), 2, address);
                assertEquals(address, ma.uintptr_t_AtIndex(OpaqueMemory.getMemorySegment(heap), 2));
                assertEquals(0, prev.int64_t());
                assertEquals(address, MemoryAddress.ofLong(ma.uint32_t(OpaqueMemory.getMemorySegment(mem32), 0)));
                assertEquals(0, succ32_1.uint32_t());
            }
            case _64_BIT -> {
                address = MemoryAddress.ofLong(0x0807060504030201L);
                ma.uintptr_t_AtIndex(OpaqueMemory.getMemorySegment(heap), 1, address);
                assertEquals(address, ma.uintptr_t_AtIndex(OpaqueMemory.getMemorySegment(heap), 1));
                assertEquals(0, prev.int64_t());
                assertEquals(address, MemoryAddress.ofLong(ma.uint64_t(OpaqueMemory.getMemorySegment(mem64), 0)));
                assertEquals(0, succ64_1.uint64_t());
            }
            default ->
                fail("cant handle pointer size: " + MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer);
        }
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 0x00000000ffffffff, 0x0000000100000000L})
    public void testUintPtr_t_AtIndex(long value) {
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
            case _32_BIT -> {
                //TODO OpenJDK bug int to long wiht sign ....
                ma.uintptr_t(OpaqueMemory.getMemorySegment(mem64), 0, MemoryAddress.ofLong(value));
                assertMemIsClean();
                assertMemEqualsInt((int) value);
                assertEquals(MemoryAddress.ofLong(0xffffffffL & value), ma.uintptr_t_AtIndex(OpaqueMemory.getMemorySegment(mem32), 0));

            }
            case _64_BIT -> {
                ma.uintptr_t_AtIndex(OpaqueMemory.getMemorySegment(mem64), 0, MemoryAddress.ofLong(value));
                assertMemIsClean();
                assertMemEqualsLong(value);
                assertEquals(MemoryAddress.ofLong(value), ma.uintptr_t(OpaqueMemory.getMemorySegment(mem64), 0));
            }
            default ->
                fail();
        }
    }

    @Test
    public void testunsigned_long_AtIndex() {
        final long expected = MultiarchTupelBuilder.getMemoryModel().sizeOf_long == SizeInBit._32_BIT ? 0x04030201L : 0x0807060504030201L;
        ma.unsigned_long_AtIndex(OpaqueMemory.getMemorySegment(heap), OpaqueMemory.offsetof(heap, mem64), 3, expected);

        assertEquals(expected, ma.unsigned_long_AtIndex(OpaqueMemory.getMemorySegment(heap), OpaqueMemory.offsetof(heap, mem64), 3));
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_long) {
            case _32_BIT -> {
                assertEquals(0, succ32_2.uint32_t());
                assertEquals(expected, succ32_3.uint32_t_AsLong());
                assertEquals(0, succ32_4.uint32_t());
            }
            case _64_BIT -> {
                assertEquals(0, succ64_2.uint64_t());
                assertEquals(expected, succ64_3.uint64_t());
                assertEquals(0, succ64_4.uint64_t());
            }
            default ->
                fail();
        }
    }

    @Test
    public void testsigned_long_AtIndex() {
        final long expected = MultiarchTupelBuilder.getMemoryModel().sizeOf_long == SizeInBit._32_BIT ? 0x04030201L : 0x0807060504030201L;
        ma.signed_long_AtIndex(OpaqueMemory.getMemorySegment(heap), OpaqueMemory.offsetof(heap, mem64), 3, expected);
        assertEquals(expected, ma.signed_long_AtIndex(OpaqueMemory.getMemorySegment(heap), OpaqueMemory.offsetof(heap, mem64), 3));
        switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_long) {
            case _32_BIT -> {
                assertEquals(0, succ32_2.uint32_t());
                assertEquals(expected, succ32_3.uint32_t_AsLong());
                assertEquals(0, succ32_4.uint32_t());
            }
            case _64_BIT -> {
                assertEquals(0, succ64_2.uint64_t());
                assertEquals(expected, succ64_3.uint64_t());
                assertEquals(0, succ64_4.uint64_t());
            }
            default ->
                fail();
        }

        ma.signed_long_AtIndex(OpaqueMemory.getMemorySegment(heap), OpaqueMemory.offsetof(heap, mem64), 3, -1);
        assertEquals(-1, ma.signed_long_AtIndex(OpaqueMemory.getMemorySegment(heap), OpaqueMemory.offsetof(heap, mem64), 3));
    }

    @Test
    public void testStringAsUnicode_ASCII_Only() {

        final String expectedString = "Hello!";
        final int LENGTH = expectedString.length();

        ma.setUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH, expectedString);
        if (IS_BIG_ENDIAN) {
            assertEquals("00480065 006c006c  006f0021 00000000 | \u0000H\u0000e\u0000l\u0000l\u0000o\u0000!\u0000\u0000\u0000\u0000", OpaqueMemory.printMemory(buff_16, false));
        } else {
            assertEquals("48006500 6c006c00  6f002100 00000000 | H\u0000e\u0000l\u0000l\u0000o\u0000!\u0000\u0000\u0000\u0000\u0000", OpaqueMemory.printMemory(buff_16, false));
        }
        assertEquals(expectedString, ma.getUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH));
    }

    @Test
    public void testStringAsUnicode_With_Non_ASCII() {

        final String expectedString = "\u263A Hi! \u263A";
        final int LENGTH = expectedString.length();

        ma.setUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH, expectedString);

        if (IS_BIG_ENDIAN) {
            assertEquals("263a0020 00480069  00210020 263a0000 | &:\u0000 \u0000H\u0000i\u0000!\u0000 &:\u0000\u0000", OpaqueMemory.printMemory(buff_16, false));
        } else {
            assertEquals("3a262000 48006900  21002000 3a260000 | :& \u0000H\u0000i\u0000!\u0000 \u0000:&\u0000\u0000", OpaqueMemory.printMemory(buff_16, false));
        }

        assertEquals(expectedString, ma.getUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH));
    }

    @Test
    public void testStringAsUnicodeLE_ASCII_Only() {

        final String expectedString = "Hello!";
        final int LENGTH = expectedString.length();

        maLE.setUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH, expectedString);

        assertEquals("48006500 6c006c00  6f002100 00000000 | H\u0000e\u0000l\u0000l\u0000o\u0000!\u0000\u0000\u0000\u0000\u0000", OpaqueMemory.printMemory(buff_16, false));
        assertEquals(expectedString, maLE.getUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH));
    }

    @Test
    public void testStringAsUnicodeBE_ASCII_Only() {

        final String expectedString = "Hello!";
        final int LENGTH = expectedString.length();

        maBE.setUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH, expectedString);

        assertEquals("00480065 006c006c  006f0021 00000000 | \u0000H\u0000e\u0000l\u0000l\u0000o\u0000!\u0000\u0000\u0000\u0000", OpaqueMemory.printMemory(buff_16, false));
        assertEquals(expectedString, maBE.getUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH));
    }

    @Test
    public void testStringAsUnicodeLE_With_Non_ASCII() {

        final String expectedString = "\u263A Hi! \u263A";
        final int LENGTH = expectedString.length();

        maLE.setUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH, expectedString);

        assertEquals("3a262000 48006900  21002000 3a260000 | :& \u0000H\u0000i\u0000!\u0000 \u0000:&\u0000\u0000", OpaqueMemory.printMemory(buff_16, false));
        assertEquals(expectedString, maLE.getUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH));
    }

    @Test
    public void testStringAsUnicodeBE__With_Non_ASCII() {

        final String expectedString = "\u263A Hi! \u263A";
        final int LENGTH = expectedString.length();

        maBE.setUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH, expectedString);

        assertEquals("263a0020 00480069  00210020 263a0000 | &:\u0000 \u0000H\u0000i\u0000!\u0000 &:\u0000\u0000", OpaqueMemory.printMemory(buff_16, false));
        assertEquals(expectedString, maBE.getUnicodeString(OpaqueMemory.getMemorySegment(buff_16), 0, LENGTH));
    }

    @Test
    public void testStringAsUTF_ASCII_Only() {
        String expectedString = "Hello!";

        ma.setUTF_8String(OpaqueMemory.getMemorySegment(buff_16), 0, expectedString);
        assertEquals("48656c6c 6f210000  00000000 00000000 | Hello!\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000", OpaqueMemory.printMemory(buff_16, false));
        assertEquals(expectedString, ma.getUTF_8String(OpaqueMemory.getMemorySegment(buff_16), 0));

    }

    @Test
    public void testStringAsUTF_With_Non_ASCII() {
        final String expectedString = "\u263AHi!\u263A";
        final char[] chars = expectedString.toCharArray();
        final int LENGTH = expectedString.length();

        assertEquals(LENGTH, chars.length);

//        assertEquals(LENGTH + 4, NATIVE_LENGTH);
        ma.setUTF_8String(OpaqueMemory.getMemorySegment(buff_16), 0, expectedString);
        assertEquals(expectedString, ma.getUTF_8String(OpaqueMemory.getMemorySegment(buff_16), 0));
        assertEquals("""
                     e298ba48 6921e298  ba000000 00000000 | \u00e2\u0098\u00ba\u0048\u0069\u0021\u00e2\u0098\u00ba\u0000\u0000\u0000\u0000\u0000\u0000\u0000""", OpaqueMemory.printMemory(buff_16, false));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ma.setUTF_8String(OpaqueMemory.getMemorySegment(heap), heap.sizeof() - 4, expectedString);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            ma.setUTF_8String(OpaqueMemory.getMemorySegment(heap).asSlice(0, mem32.sizeof()), mem32.sizeof(), expectedString);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            //Just try to override some memory
            ma.setUTF_8String(OpaqueMemory.getMemorySegment(mem32), 0, expectedString);
        });
    }

    private void assertMemEqualsByte(byte value) {
        final byte[] actual = new byte[8];
        ma.copyMemory(OpaqueMemory.getMemorySegment(mem64), 0, actual, 0, actual.length);

        final byte[] expected = new byte[8];
        expected[0] = value;
        assertArrayEquals(expected, actual);
    }

    private void assertMemEqualsShort(short value) {
        final byte[] actual = new byte[8];
        ma.copyMemory(OpaqueMemory.getMemorySegment(mem64), 0, actual, 0, actual.length);

        final byte[] expected = new byte[8];
        if (IS_BIG_ENDIAN) {
            expected[0] = (byte) ((value >>> 8) & 0xff);
            expected[1] = (byte) (value & 0xff);
        } else {
            expected[0] = (byte) (value & 0xff);
            expected[1] = (byte) ((value >>> 8) & 0xff);
        }
        assertArrayEquals(expected, actual);

    }

    private void assertMemEqualsInt(int value) {
        final byte[] actual = new byte[8];
        ma.copyMemory(OpaqueMemory.getMemorySegment(mem64), 0, actual, 0, actual.length);

        final byte[] expected = new byte[8];
        if (IS_BIG_ENDIAN) {
            expected[0] = (byte) ((value >>> 24) & 0xff);
            expected[1] = (byte) ((value >>> 16) & 0xff);
            expected[2] = (byte) ((value >>> 8) & 0xff);
            expected[3] = (byte) (value & 0xff);
        } else {
            expected[0] = (byte) (value & 0xff);
            expected[1] = (byte) ((value >>> 8) & 0xff);
            expected[2] = (byte) ((value >>> 16) & 0xff);
            expected[3] = (byte) ((value >>> 24) & 0xff);
        }
        assertArrayEquals(expected, actual);
    }

    private void assertMemEqualsLong(long value) {
        final byte[] actual = new byte[8];
        ma.copyMemory(OpaqueMemory.getMemorySegment(mem64), 0, actual, 0, actual.length);

        final byte[] expected = new byte[8];
        if (IS_BIG_ENDIAN) {
            expected[0] = (byte) ((value >>> 56) & 0xff);
            expected[1] = (byte) ((value >>> 48) & 0xff);
            expected[2] = (byte) ((value >>> 40) & 0xff);
            expected[3] = (byte) ((value >>> 32) & 0xff);
            expected[4] = (byte) ((value >>> 24) & 0xff);
            expected[5] = (byte) ((value >>> 16) & 0xff);
            expected[6] = (byte) ((value >>> 8) & 0xff);
            expected[7] = (byte) (value & 0xff);
        } else {
            expected[0] = (byte) (value & 0xff);
            expected[1] = (byte) ((value >>> 8) & 0xff);
            expected[2] = (byte) ((value >>> 16) & 0xff);
            expected[3] = (byte) ((value >>> 24) & 0xff);
            expected[4] = (byte) ((value >>> 32) & 0xff);
            expected[5] = (byte) ((value >>> 40) & 0xff);
            expected[6] = (byte) ((value >>> 48) & 0xff);
            expected[7] = (byte) ((value >>> 56) & 0xff);
        }
        assertArrayEquals(expected, actual);
    }

    private void assertMemIsClear() {
        assertEquals(0, mem64.int64_t());
    }

    @Test
    public void testBitsInLong() {
        assertEquals(0x07, MemoryAccessor.getBitsInLong(0x0102030405060708L, 8, 4));
        assertEquals(0x01, MemoryAccessor.getBitsInLong(0x0102030405060708L, 3, 5));
        assertEquals(1, MemoryAccessor.setBitsInLong(0, 0, 1, 1));
        assertEquals(1, MemoryAccessor.setBitsInLong(-1, 1, 63, 0));
        assertThrows(IllegalArgumentException.class,
                () -> MemoryAccessor.setBitsInLong(0, 0, 16, 0x00010000));
    }

    @Test
    public void testBitInInt() {
        assertTrue(MemoryAccessor.getBitInInt(0x00000001, 0));
        assertTrue(MemoryAccessor.getBitInInt(0x01000000, 24));
        assertFalse(MemoryAccessor.getBitInInt(0x11111111, 1));
        assertEquals(0x02, MemoryAccessor.setBitInInt(0, 1, true));
        assertEquals(0xfffffffd, MemoryAccessor.setBitInInt(-1, 1, false));
    }

    @Test
    public void testBitsInInt() {
        assertEquals(0x07, MemoryAccessor.getBitsInInt(0x05060708, 8, 4));
        assertEquals(0x01, MemoryAccessor.getBitsInInt(0x05060708, 3, 5));
        assertEquals(1, MemoryAccessor.setBitsInInt(0, 0, 1, 1));
        assertEquals(1, MemoryAccessor.setBitsInInt(-1, 1, 31, 0));
        assertThrows(IllegalArgumentException.class,
                () -> MemoryAccessor.setBitsInInt(0, 0, 16, 0x00010000));
    }

    @Test
    public void testBitsInShort() {
        assertEquals(0x07, MemoryAccessor.getBitsInShort((short) 0x0708, 8, 4));
        assertEquals(0x01, MemoryAccessor.getBitsInShort((short) 0x0708, 3, 5));
        assertEquals(1, MemoryAccessor.setBitsInShort((short) 0, 0, 1, (short) 1));
        assertEquals(1, MemoryAccessor.setBitsInShort((short) -1, 1, 15, (short) 0));
        assertThrows(IllegalArgumentException.class,
                () -> MemoryAccessor.setBitsInShort((short) 0, 0, 8, (short) 0x0100));
    }

    @Test
    public void testBitsInByte() {
        assertEquals(0x07, MemoryAccessor.getBitsInByte((byte) 0x07, 0, 4));
        assertEquals(0x01, MemoryAccessor.getBitsInByte((byte) 0x08, 3, 5));
        assertEquals(1, MemoryAccessor.setBitsInByte((byte) 0, 0, 1, (byte) 1));
        assertEquals(1, MemoryAccessor.setBitsInByte((byte) -1, 1, 7, (byte) 0));
        assertThrows(IllegalArgumentException.class,
                () -> MemoryAccessor.setBitsInByte((byte) 0, 0, 4, (byte) 0x10));
    }

    @Test
    public void testCopyTooBig() {
        byte[] actual = new byte[HEAP_SIZE * 2];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            //TODO We can override mem in the heap... use MemorySegment.slice ???
            ma.copyMemory(OpaqueMemory.getMemorySegment(mem64), 0, actual, 0, actual.length);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ma.copyMemory(OpaqueMemory.getMemorySegment(heap), 0, actual, 0, actual.length);
        });
    }

    @Test
    public void testCopyStartOutside() {
        final byte[] actual = new byte[4];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ma.copyMemory(OpaqueMemory.getMemorySegment(heap), -1, actual, 0, actual.length);
        });
        ma.copyMemory(OpaqueMemory.getMemorySegment(heap), 20, actual, 0, actual.length);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ma.copyMemory(OpaqueMemory.getMemorySegment(heap), heap.sizeof() + 20, actual, 0, actual.length);
        });
    }

    @Test
    public void testCopyDestOffsetOutside() {
        final byte[] actual = new byte[4];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ma.copyMemory(OpaqueMemory.getMemorySegment(mem64), 0, actual, 10, actual.length);
        });
    }
}
