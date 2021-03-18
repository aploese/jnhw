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

import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Int64_t;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.MemoryAccessor;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Uint32_t;
import de.ibapl.jnhw.common.memory.Uint64_t;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.SizeInBit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

/**
 *
 * succ64_X is the Xth successor in 64bit mode succ32_X is the Xth successor in
 * 32bit mode
 *
 * @author aploese
 */
public class MemoryAccessorTest {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();
    private final static boolean IS_BIG_ENDIAN = MULTIARCH_TUPEL_BUILDER.getEndianess().isBigEndian();
    private final static Memory32Heap heap = new Memory32Heap(null, 0, 8 * 12, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t prev = new Int64_t(heap, 0, AbstractNativeMemory.MEM_UNINITIALIZED);

    private final static Int64_t mem64 = new Int64_t(heap, 8 * 1, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t mem32 = new Int64_t(heap, 4 * 2, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Memory32Heap buff_16 = new Memory32Heap(heap, 8 * 1, 16, AbstractNativeMemory.MEM_UNINITIALIZED);

    private final static Uint32_t succ32_1 = new Uint32_t(heap, 4 * 3, AbstractNativeMemory.MEM_UNINITIALIZED);

    private final static Uint64_t succ64_1 = new Uint64_t(heap, 8 * 2, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Uint32_t succ32_2 = new Uint32_t(heap, 4 * 4, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Uint32_t succ32_3 = new Uint32_t(heap, 4 * 5, AbstractNativeMemory.MEM_UNINITIALIZED);

    private final static Uint64_t succ64_2 = new Uint64_t(heap, 8 * 3, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Uint32_t succ32_4 = new Uint32_t(heap, 4 * 6, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Uint32_t succ32_5 = new Uint32_t(heap, 4 * 7, AbstractNativeMemory.MEM_UNINITIALIZED);

    private final static Uint64_t succ64_3 = new Uint64_t(heap, 8 * 4, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Uint32_t succ32_6 = new Uint32_t(heap, 4 * 8, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Uint32_t succ32_7 = new Uint32_t(heap, 4 * 9, AbstractNativeMemory.MEM_UNINITIALIZED);

    private final static Uint64_t succ64_4 = new Uint64_t(heap, 8 * 5, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Uint32_t succ32_8 = new Uint32_t(heap, 4 * 10, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Uint32_t succ32_9 = new Uint32_t(heap, 4 * 11, AbstractNativeMemory.MEM_UNINITIALIZED);

    private abstract static class MEM extends Memory32Heap {

        public MEM(AbstractNativeMemory owner, long offset, int sizeInBytes, Byte setMem) {
            super(owner, offset, sizeInBytes, setMem);
        }

        static MemoryAccessor getCurrentMemAcc() {
            return MEM_ACCESS;
        }

    }

    private final MemoryAccessor ma;

    @BeforeEach
    public void beforeEach() {
        OpaqueMemory32.clear(heap);
    }

    public static void assertMem() {
        // Just make sure we have not written outside...
        assertEquals(0L, prev.int64_t());
        assertEquals(0L, succ64_1.uint64_t());
        assertEquals(0L, succ64_2.uint64_t());
        assertEquals(0L, succ64_3.uint64_t());
        assertEquals(0L, succ64_4.uint64_t());
    }

    public MemoryAccessorTest() {
        this.ma = MEM.getCurrentMemAcc();
    }

    /**
     * Test of outOfBoundsByteArray method, of class MemoryAccessor.
     */
    @Test
    public void testOutOfBoundsByteArray() {
        MemoryAccessor.outOfBoundsByteArray(1, 2, 3);
        MemoryAccessor.outOfBoundsByteArray(0, 0, 0);
        MemoryAccessor.outOfBoundsByteArray(0, 1, 1);
        MemoryAccessor.outOfBoundsByteArray(1, 0, 1);
    }

    /**
     * Test of outOfBoundsMem method, of class MemoryAccessor.
     */
    @Test
    public void testOutOfBoundsMem() {
        MemoryAccessor.outOfBoundsMem(1, 2, 3);
        MemoryAccessor.outOfBoundsMem(0, 0, 0);
        MemoryAccessor.outOfBoundsMem(0, 1, 1);
        MemoryAccessor.outOfBoundsMem(1, 0, 1);
    }

    /**
     * Test of int8_t (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(bytes = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testInt8_t_ByteTest(byte value) {
        ma.int8_t(mem64, 0, value);
        assertMem();
        assertMemEqualsByte(value);
        assertEquals(value, ma.int8_t(mem64, 0));

        assertEquals(String.format("0x%02x", value), ma.int8_t_AsHex(mem64, 0));
        assertEquals(Byte.toString(value), ma.int8_t_nativeToString(mem64, 0));
    }

    /**
     * Test of SignedIntOf (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testSignedIntOf_ByteTest(int value) {
        ma.setSignedIntOf(mem64, 0, 1, value);
        assertMem();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.getSignedIntOf(mem64, 0, 1));

        assertEquals(String.format("0x%02x", value & 0xff), ma.getSignedIntOf_AsHex(mem64, 0, 1));
        assertEquals(Byte.toString((byte) value), ma.getSignedIntOf_nativeToString(mem64, 0, 1));
    }

    /**
     * Test of SignedLongOf (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testSignedLongOf_ByteTest(long value) {
        ma.setSignedLongOf(mem64, 0, 1, value);
        assertMem();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.getSignedLongOf(mem64, 0, 1));

        assertEquals(String.format("0x%02x", value & 0xff), ma.getSignedLongOf_AsHex(mem64, 0, 1));
        assertEquals(Byte.toString((byte) value), ma.getSignedLongOf_nativeToString(mem64, 0, 1));
    }

    /**
     * Test of uint8_t (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(bytes = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testUint8_t_ByteTest(byte value) {
        ma.uint8_t(mem64, 0, value);
        assertMem();
        assertMemEqualsByte(value);
        assertEquals(value, ma.uint8_t(mem64, 0));

        assertEquals(String.format("0x%02x", value), ma.uint8_t_AsHex(mem64, 0));
        assertEquals(Integer.toString(value & 0xff), ma.uint8_t_nativeToString(mem64, 0));
    }

    /**
     * Test of uint8_t (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {-1, 0, 1, 0x00ff, 0x0100})
    public void testUint8_t_ShortTest(short value) {
        if ((value < 0) || (value > 0xff)) {
            assertThrows(IllegalArgumentException.class, () -> ma.uint8_t_FromShort(mem64, 0, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.uint8_t_FromShort(mem64, 0, value);
        assertMem();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.uint8_t_AsShort(mem64, 0));

        assertEquals(String.format("0x%02x", value), ma.uint8_t_AsHex(mem64, 0));
        assertEquals(Integer.toString(value & 0xffff), ma.uint8_t_nativeToString(mem64, 0));
    }

    /**
     * Test of UnsignedIntOf (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testUnsignedInt_ByteTest(int value) {
        if ((value < 0) || (value > 0xff)) {
            assertThrows(IllegalArgumentException.class, () -> ma.setUnsignedIntOf(mem64, 0, 1, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.setUnsignedIntOf(mem64, 0, 1, value);
        assertMem();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.getUnsignedIntOf(mem64, 0, 1));

        assertEquals(String.format("0x%02x", value & 0xff), ma.getUnsignedIntOf_AsHex(mem64, 0, 1));
        assertEquals(Integer.toString(value & 0xff), ma.getUnsignedIntOf_nativeToString(mem64, 0, 1));
    }

    /**
     * Test of UnsignedLongOf (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testUnsignedLong_ByteTest(long value) {
        if ((value < 0) || (value > 0xff)) {
            assertThrows(IllegalArgumentException.class, () -> ma.setUnsignedLongOf(mem64, 0, 1, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.setUnsignedLongOf(mem64, 0, 1, value);
        assertMem();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.getUnsignedLongOf(mem64, 0, 1));

        assertEquals(String.format("0x%02x", value & 0xff), ma.getUnsignedLongOf_AsHex(mem64, 0, 1));
        assertEquals(Long.toString(value & 0xff), ma.getUnsignedLongOf_nativeToString(mem64, 0, 1));
    }

    /**
     * Test of int16_t (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {Short.MIN_VALUE, -1, 0, 1, Short.MAX_VALUE})
    public void testInt16_t_ShortTest(short value) {
        ma.int16_t(mem64, 0, value);
        assertMem();
        assertMemEqualsShort(value);
        assertEquals(value, ma.int16_t(mem64, 0));

        assertEquals(String.format("0x%04x", value), ma.int16_t_AsHex(mem64, 0));
        assertEquals(Short.toString(value), ma.int16_t_nativeToString(mem64, 0));
    }

    /**
     * Test of SignedIntOf (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Short.MIN_VALUE, -1, 0, 1, Short.MAX_VALUE})
    public void testSignedIntOf_ShortTest(int value) {
        ma.setSignedIntOf(mem64, 0, 2, value);
        assertMem();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.getSignedIntOf(mem64, 0, 2));

        assertEquals(String.format("0x%04x", value & 0xffff), ma.getSignedIntOf_AsHex(mem64, 0, 2));
        assertEquals(Short.toString((short) value), ma.getSignedIntOf_nativeToString(mem64, 0, 2));
    }

    /**
     * Test of SignedLongOf (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {Short.MIN_VALUE, -1, 0, 1, Short.MAX_VALUE})
    public void testSignedLongOf_ShortTest(long value) {
        ma.setSignedLongOf(mem64, 0, 2, value);
        assertMem();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.getSignedLongOf(mem64, 0, 2));

        assertEquals(String.format("0x%04x", value & 0xffff), ma.getSignedLongOf_AsHex(mem64, 0, 2));
        assertEquals(Short.toString((short) value), ma.getSignedLongOf_nativeToString(mem64, 0, 2));
    }

    /**
     * Test of uint16_t (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {Short.MIN_VALUE, -1, 0, 1, Short.MAX_VALUE})
    public void testUint16_t_ShortTest(short value) {
        ma.uint16_t(mem64, 0, value);
        assertMem();
        assertMemEqualsShort(value);
        assertEquals(value, ma.uint16_t(mem64, 0));

        assertEquals(String.format("0x%04x", value), ma.uint16_t_AsHex(mem64, 0));
        assertEquals(Integer.toString(value & 0xffff), ma.uint16_t_nativeToString(mem64, 0));
    }

    /**
     * Test of uint16_t (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 0x0000ffff, 0x00010000})
    public void testUint16_t_IntTest(int value) {
        if ((value < 0) || (value > 0xffff)) {
            assertThrows(IllegalArgumentException.class, () -> ma.uint16_t_FromInt(mem64, 0, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.uint16_t_FromInt(mem64, 0, value);
        assertMem();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.uint16_t_AsInt(mem64, 0));

        assertEquals(String.format("0x%04x", value), ma.uint16_t_AsHex(mem64, 0));
        assertEquals(Integer.toUnsignedString(value), ma.uint16_t_nativeToString(mem64, 0));
    }

    /**
     * Test of UnsignedIntOf (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 0x0000ffff, 0x00010000})
    public void testUnsignedInt_ShortTest(int value) {
        if ((value < 0) || (value > 0xffff)) {
            assertThrows(IllegalArgumentException.class, () -> ma.setUnsignedIntOf(mem64, 0, 2, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.setUnsignedIntOf(mem64, 0, 2, value);
        assertMem();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.getUnsignedIntOf(mem64, 0, 2));

        assertEquals(String.format("0x%04x", value & 0xffff), ma.getUnsignedIntOf_AsHex(mem64, 0, 2));
        assertEquals(Integer.toString(value & 0xffff), ma.getUnsignedIntOf_nativeToString(mem64, 0, 2));
    }

    /**
     * Test of UnsignedLongOf (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 0x0000ffff, 0x00010000})
    public void testUnsignedLong_ShortTest(long value) {
        if ((value < 0) || (value > 0xffff)) {
            assertThrows(IllegalArgumentException.class, () -> ma.setUnsignedLongOf(mem64, 0, 2, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.setUnsignedLongOf(mem64, 0, 2, value);
        assertMem();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.getUnsignedLongOf(mem64, 0, 2));

        assertEquals(String.format("0x%04x", value & 0xffff), ma.getUnsignedLongOf_AsHex(mem64, 0, 2));
        assertEquals(Long.toString(value & 0xffff), ma.getUnsignedLongOf_nativeToString(mem64, 0, 2));
    }

    /**
     * Test of int32_t (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    public void testInt32_t_IntTest(int value) {
        ma.int32_t(mem64, 0, value);
        assertMem();
        assertMemEqualsInt(value);
        assertEquals(value, ma.int32_t(mem64, 0));

        assertEquals(String.format("0x%08x", value), ma.int32_t_AsHex(mem64, 0));
        assertEquals(Integer.toString(value), ma.int32_t_nativeToString(mem64, 0));
    }

    /**
     * Test of SignedIntOf (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    public void testSignedIntOf_IntTest(int value) {
        ma.setSignedIntOf(mem64, 0, 4, value);
        assertMem();
        assertMemEqualsInt(value);
        assertEquals(value, ma.getSignedIntOf(mem64, 0, 4));

        assertEquals(String.format("0x%08x", value), ma.getSignedIntOf_AsHex(mem64, 0, 4));
        assertEquals(Integer.toString(value), ma.getSignedIntOf_nativeToString(mem64, 0, 4));
    }

    /**
     * Test of SignedLongOf (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE, Long.MAX_VALUE})
    public void testSignedLongOf_IntTest(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            assertThrows(IllegalArgumentException.class, () -> ma.setSignedLongOf(mem64, 0, 4, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.setSignedLongOf(mem64, 0, 4, value);
        assertMem();
        assertMemEqualsInt((int) value);
        assertEquals(value, ma.getSignedLongOf(mem64, 0, 4));

        assertEquals(String.format("0x%08x", value & 0xffffffffL), ma.getSignedLongOf_AsHex(mem64, 0, 4));
        assertEquals(Integer.toString((int) value), ma.getSignedLongOf_nativeToString(mem64, 0, 4));
    }

    /**
     * Test of uint32_t (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    public void testUint32_t_IntTest(int value) {
        ma.uint32_t(mem64, 0, value);
        assertMem();
        assertMemEqualsInt(value);
        assertEquals(value, ma.uint32_t(mem64, 0));

        assertEquals(String.format("0x%08x", value), ma.uint32_t_AsHex(mem64, 0));
        assertEquals(Long.toString(value & 0xffffffffL), ma.uint32_t_nativeToString(mem64, 0));
    }

    /**
     * Test of uint32_t (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 0x00000000ffffffff, 0x0000000100000000L})
    public void testUint32_t_LongTest(long value) {
        if ((value < 0) || (value > 0xffffffffL)) {
            assertThrows(IllegalArgumentException.class, () -> ma.uint32_t_FromLong(mem64, 0, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.uint32_t_FromLong(mem64, 0, value);
        assertMem();
        assertMemEqualsInt((int) value);
        assertEquals(value, ma.uint32_t_AsLong(mem64, 0));

        assertEquals(String.format("0x%08x", value), ma.uint32_t_AsHex(mem64, 0));
        assertEquals(Long.toUnsignedString(value), ma.uint32_t_nativeToString(mem64, 0));
    }

    /**
     * Test of UnsignedIntOf (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    public void testUnsignedInt_IntTest(int value) {
        ma.setUnsignedIntOf(mem64, 0, 4, value);
        assertMem();
        assertMemEqualsInt((int) value);
        assertEquals(value, ma.getUnsignedIntOf(mem64, 0, 4));

        assertEquals(String.format("0x%08x", value), ma.getUnsignedIntOf_AsHex(mem64, 0, 4));
        assertEquals(Integer.toUnsignedString(value), ma.getUnsignedIntOf_nativeToString(mem64, 0, 4));
    }

    /**
     * Test of UnsignedLongOf (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 0x00000000ffffffff, 0x0000000100000000L})
    public void testUnsignedLong_IntTest(long value) {
        if ((value < 0) || (value > 0xffffffffL)) {
            assertThrows(IllegalArgumentException.class, () -> ma.setUnsignedLongOf(mem64, 0, 4, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.setUnsignedLongOf(mem64, 0, 4, value);
        assertMem();
        assertMemEqualsInt((int) value);
        assertEquals(value, ma.getUnsignedLongOf(mem64, 0, 4));

        assertEquals(String.format("0x%08x", value & 0xffffffffL), ma.getUnsignedLongOf_AsHex(mem64, 0, 4));
        assertEquals(Long.toUnsignedString(value & 0xffffffffL), ma.getUnsignedLongOf_nativeToString(mem64, 0, 4));
    }

    /**
     * Test of int64_t (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE})
    public void testInt64_t_LongTest(long value) {
        ma.int64_t(mem64, 0, value);
        assertMem();
        assertMemEqualsLong(value);
        assertEquals(value, ma.int64_t(mem64, 0));

        assertEquals(String.format("0x%016x", value), ma.int64_t_AsHex(mem64, 0));
        assertEquals(Long.toString(value), ma.int64_t_nativeToString(mem64, 0));
    }

    /**
     * Test of SignedLongOf (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE})
    public void testSignedLongOf_LongTest(long value) {
        ma.setSignedLongOf(mem64, 0, 8, value);
        assertMem();
        assertMemEqualsLong(value);
        assertEquals(value, ma.getSignedLongOf(mem64, 0, 8));

        assertEquals(String.format("0x%016x", value), ma.getSignedLongOf_AsHex(mem64, 0, 8));
        assertEquals(Long.toString(value), ma.getSignedLongOf_nativeToString(mem64, 0, 8));
    }

    /**
     * Test of uint64_t (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE})
    public void testUint64_t_LongTest(long value) {
        ma.uint64_t(mem64, 0, value);
        assertMem();
        assertMemEqualsLong(value);
        assertEquals(value, ma.uint64_t(mem64, 0));

        assertEquals(String.format("0x%016x", value), ma.uint64_t_AsHex(mem64, 0));
        assertEquals(Long.toUnsignedString(value), ma.uint64_t_nativeToString(mem64, 0));
    }

    /**
     * Test of UnsignedLongOf (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE})
    public void testUnsignedLong_LongTest(long value) {
        ma.setUnsignedLongOf(mem64, 0, 8, value);
        assertMem();
        assertMemEqualsLong(value);
        assertEquals(value, ma.getUnsignedLongOf(mem64, 0, 8));

        assertEquals(String.format("0x%016x", value), ma.getUnsignedLongOf_AsHex(mem64, 0, 8));
        assertEquals(Long.toUnsignedString(value), ma.getUnsignedLongOf_nativeToString(mem64, 0, 8));
    }

    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE, Long.MAX_VALUE})
    public void testIntptr_tTest(long value) {
        if (MULTIARCH_TUPEL_BUILDER.getSizeOfPointer() == SizeInBit._32_BIT) {
            if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
                assertThrows(IllegalArgumentException.class, () -> ma.intptr_t(mem64, 0, value));
                assertMem();
                assertMemIsClear();
                return;
            }
            ma.intptr_t(mem64, 0, value);
            assertMem();
            assertMemEqualsInt((int) value);
            assertEquals(value, ma.intptr_t(mem32, 0));
            return;
        }
        ma.intptr_t(mem64, 0, value);
        assertMem();
        assertMemEqualsLong(value);
        assertEquals(value, ma.intptr_t(mem64, 0));

    }

    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 0x00000000ffffffff, 0x0000000100000000L})
    public void testUintPtr_tTest(long value) {
        if (MULTIARCH_TUPEL_BUILDER.getSizeOfPointer() == SizeInBit._32_BIT) {
            if ((value < 0) || (value > 0xffffffffL)) {
                assertThrows(IllegalArgumentException.class, () -> ma.uintptr_t(mem64, 0, value));
                assertMem();
                assertMemIsClear();
                return;
            }
            ma.uintptr_t(mem64, 0, value);
            assertMem();
            assertMemEqualsInt((int) value);
            assertEquals(value, ma.uintptr_t(mem32, 0));
            assertEquals(String.format("0x%08x", value), ma.uintptr_t_AsHex(mem32, 0));
            return;
        }

        ma.uintptr_t(mem64, 0, value);
        assertMem();
        assertMemEqualsLong(value);
        assertEquals(value, ma.uintptr_t(mem64, 0));
        assertEquals(String.format("0x%016x", value), ma.uintptr_t_AsHex(mem64, 0));
    }

    @Test
    public void testUintptr_t_AtIndex() {
        final long address = MULTIARCH_TUPEL_BUILDER.getSizeOfPointer() == SizeInBit._32_BIT ? 0x04030201L : 0x0807060504030201L;
        NativeAddressHolder expected = NativeAddressHolder.ofUintptr_t(address);
        ma.uintptr_t_AtIndex(mem64, 0, 3, expected);

        assertEquals(expected, ma.uintptr_t_AtIndex_AsNativeAddressHolder(mem64, 0, 3));
        switch (MULTIARCH_TUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                assertEquals(0, succ32_2.uint32_t());
                assertEquals(address, succ32_3.uint32_t_AsLong());
                assertEquals(0, succ32_4.uint32_t());
                break;
            case _64_BIT:
                assertEquals(0, succ64_2.uint64_t());
                assertEquals(address, succ64_3.uint64_t());
                assertEquals(0, succ64_4.uint64_t());
                break;
            default:
                fail();
        }

    }

    @Test
    public void testunsigned_long_AtIndex() {
        final long expected = MULTIARCH_TUPEL_BUILDER.getSizeOfLong() == SizeInBit._32_BIT ? 0x04030201L : 0x0807060504030201L;
        ma.unsigned_long_AtIndex(mem64, 0, 3, expected);

        assertEquals(expected, ma.unsigned_long_AtIndex(mem64, 0, 3));
        switch (MULTIARCH_TUPEL_BUILDER.getSizeOfLong()) {
            case _32_BIT:
                assertEquals(0, succ32_2.uint32_t());
                assertEquals(expected, succ32_3.uint32_t_AsLong());
                assertEquals(0, succ32_4.uint32_t());
                break;
            case _64_BIT:
                assertEquals(0, succ64_2.uint64_t());
                assertEquals(expected, succ64_3.uint64_t());
                assertEquals(0, succ64_4.uint64_t());
                break;
            default:
                fail();
        }
    }

    @Test
    public void testsigned_long_AtIndex() {
        final long expected = MULTIARCH_TUPEL_BUILDER.getSizeOfLong() == SizeInBit._32_BIT ? 0x04030201L : 0x0807060504030201L;
        ma.signed_long_AtIndex(mem64, 0, 3, expected);
        assertEquals(expected, ma.signed_long_AtIndex(mem64, 0, 3));
        switch (MULTIARCH_TUPEL_BUILDER.getSizeOfLong()) {
            case _32_BIT:
                assertEquals(0, succ32_2.uint32_t());
                assertEquals(expected, succ32_3.uint32_t_AsLong());
                assertEquals(0, succ32_4.uint32_t());
                break;
            case _64_BIT:
                assertEquals(0, succ64_2.uint64_t());
                assertEquals(expected, succ64_3.uint64_t());
                assertEquals(0, succ64_4.uint64_t());
                break;
            default:
                fail();
        }

        ma.signed_long_AtIndex(mem64, 0, 3, -1);
        assertEquals(-1, ma.signed_long_AtIndex(mem64, 0, 3));
    }

    @Test
    public void testStringAsUnicode_ASCII_Only() {

        final String expectedString = "Hello!";
        final int LENGTH = expectedString.length();
        final int NATIVE_LENGTH = ma.getUnicodeStringLength(expectedString);
        // assert enough space in buff_16
        assert (NATIVE_LENGTH * 2 < buff_16.sizeInBytes);
        assertEquals(LENGTH, NATIVE_LENGTH);

        ma.setUnicodeString(expectedString, 0, buff_16, 0, 0, LENGTH);
        if (IS_BIG_ENDIAN) {
            assertEquals("00480065 006c006c  006f0021 00000000 | .H.e.l.l.o.!....", OpaqueMemory32.printMemory(buff_16, false));
        } else {
            assertEquals("48006500 6c006c00  6f002100 00000000 | H.e.l.l.o.!.....", OpaqueMemory32.printMemory(buff_16, false));
        }
        assertEquals(expectedString, ma.getUnicodeString(buff_16, 0, 0, LENGTH));
        assertEquals(expectedString.substring(2, 6), ma.getUnicodeString(buff_16, 0, 2, 4));
        ma.setUnicodeString("XXX_LL_YY", 4, buff_16, 0, 2, 2);
        assertEquals("HeLLo!", ma.getUnicodeString(buff_16, 0, 0, LENGTH));
    }

    @Test
    public void testStringAsUnicode_With_Non_ASCII() {

        final String expectedString = "\u263A Hi! \u263A";
        final int LENGTH = expectedString.length();
        final int NATIVE_LENGTH = ma.getUnicodeStringLength(expectedString);
        // assert enough space in buff_16
        assert (NATIVE_LENGTH * 2 < buff_16.sizeInBytes);
        assertEquals(LENGTH, NATIVE_LENGTH);

        ma.setUnicodeString(expectedString, 0, buff_16, 0, 0, LENGTH);

        if (IS_BIG_ENDIAN) {
            assertEquals("263a0020 00480069  00210020 263a0000 | &:. .H.i.!. .&.:", OpaqueMemory32.printMemory(buff_16, false));
        } else {
            assertEquals("3a262000 48006900  21002000 3a260000 | :& .H.i.!. .:&..", OpaqueMemory32.printMemory(buff_16, false));
        }

        assertEquals(expectedString, ma.getUnicodeString(buff_16, 0, 0, LENGTH));
        assertEquals(expectedString.substring(2, 6), ma.getUnicodeString(buff_16, 0, 2, 4));
        ma.setUnicodeString("XXX_YY_ZZZ", 4, buff_16, 0, 2, 2);
        assertEquals("\u263A YY! \u263A", ma.getUnicodeString(buff_16, 0, 0, LENGTH));
    }

    @Test
    public void testStringAsUTF_ASCII_Only() {
        String expectedString = "Hello!";
        assertEquals(expectedString.length(), ma.getUTF_8StringLength(expectedString));

        ma.setUTF_8String(expectedString, 0, buff_16, 0, expectedString.length());
        assertEquals("48656c6c 6f210000  00000000 00000000 | Hello!..........", OpaqueMemory32.printMemory(buff_16, false));
        assertEquals(expectedString, ma.getUTF_8String(buff_16, 0));

    }

    @Test
    public void testStringAsUTF_With_Non_ASCII() {
        String expectedString = "\u263AHi!\u263A";
        final int LENGTH = expectedString.length();
        final int NATIVE_LENGTH = ma.getUTF_8StringLength(expectedString);
        // assert enough space in buff_16
        assert (NATIVE_LENGTH + 1 < buff_16.sizeInBytes);

        assertEquals(LENGTH + 4, NATIVE_LENGTH);

        ma.setUTF_8String(expectedString, 0, buff_16, 0, LENGTH);
        assertEquals("e298ba48 6921e298  ba000000 00000000 | ...Hi!..........", OpaqueMemory32.printMemory(buff_16, false));
        assertEquals(expectedString, ma.getUTF_8String(buff_16, 0));
    }

    /*

    /**
     * Test of int8_t method, of class MemoryAccessor.
     * /
    @Test
    public void testInt8_t_OpaqueMemory64_long() {
        System.out.println("int8_t");
        OpaqueMemory64 mem = null;
        long offset = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        byte expResult = 0;
        byte result = instance.int8_t(mem64, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of allocateMemory method, of class MemoryAccessor.
     * /
    @Test
    public void testAllocateMemory() {
        System.out.println("allocateMemory");
        AbstractNativeMemory mem = null;
        long sizeInBytes = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        long expResult = 0L;
        long result = instance.allocateMemory(mem, sizeInBytes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMemory32 method, of class MemoryAccessor.
     * /
    @Test
    public void testSetMemory32() {
        System.out.println("setMemory32");
        OpaqueMemory32 mem = null;
        byte value = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.setMemory32(mem, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMemory64 method, of class MemoryAccessor.
     * /
    @Test
    public void testSetMemory64() {
        System.out.println("setMemory64");
        OpaqueMemory64 mem = null;
        byte value = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.setMemory64(mem, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copyMemory32 method, of class MemoryAccessor.
     * /
    @Test
    public void testCopyMemory32_5args_1() {
        System.out.println("copyMemory32");
        byte[] src = null;
        int srcPos = 0;
        OpaqueMemory32 destMem = null;
        int destPos = 0;
        int length = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.copyMemory32(src, srcPos, destMem, destPos, length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copyMemory64 method, of class MemoryAccessor.
     * /
    @Test
    public void testCopyMemory64_5args_1() {
        System.out.println("copyMemory64");
        byte[] src = null;
        int srcPos = 0;
        OpaqueMemory64 destMem = null;
        long destPos = 0L;
        int length = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.copyMemory64(src, srcPos, destMem, destPos, length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copyMemory32 method, of class MemoryAccessor.
     * /
    @Test
    public void testCopyMemory32_5args_2() {
        System.out.println("copyMemory32");
        OpaqueMemory32 srcMem = null;
        int srcPos = 0;
        byte[] dest = null;
        int destPos = 0;
        int length = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.copyMemory32(srcMem, srcPos, dest, destPos, length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of copyMemory64 method, of class MemoryAccessor.
     * /
    @Test
    public void testCopyMemory64_5args_2() {
        System.out.println("copyMemory64");
        OpaqueMemory64 srcMem = null;
        long srcPos = 0L;
        byte[] dest = null;
        int destPos = 0;
        int length = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.copyMemory64(srcMem, srcPos, dest, destPos, length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStringUTF method, of class MemoryAccessor.
     * /
    @Test
    public void testGetStringUTF() {
        System.out.println("getStringUTF");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        String expResult = "";
        String result = instance.getStringUTF(mem, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");

    }
     */
    private void assertMemEqualsByte(byte value) {
        final byte[] actual = new byte[8];
        ma.copyMemory32(mem64, 0, actual, 0, actual.length);

        final byte[] expected = new byte[8];
        expected[0] = value;
        assertArrayEquals(expected, actual);
    }

    private void assertMemEqualsShort(short value) {
        final byte[] actual = new byte[8];
        ma.copyMemory32(mem64, 0, actual, 0, actual.length);

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
        ma.copyMemory32(mem64, 0, actual, 0, actual.length);

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
        ma.copyMemory32(mem64, 0, actual, 0, actual.length);

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
        assertEquals(1, MemoryAccessor.setBitsInLong(0, 1, 0, 1));
        assertEquals(1, MemoryAccessor.setBitsInLong(-1, 0, 1, 63));
        assertThrows(IllegalArgumentException.class, () -> MemoryAccessor.setBitsInLong(0, 0x00010000, 0, 16));
    }

    @Test
    public void testBitInInt() {
        assertTrue(MemoryAccessor.getBitInInt(0x00000001, 0));
        assertTrue(MemoryAccessor.getBitInInt(0x01000000, 24));
        assertFalse(MemoryAccessor.getBitInInt(0x11111111, 1));
        assertEquals(0x02, MemoryAccessor.setBitInInt(0, true, 1));
        assertEquals(0xfffffffd, MemoryAccessor.setBitInInt(-1, false, 1));
    }

    @Test
    public void testBitsInInt() {
        assertEquals(0x07, MemoryAccessor.getBitsInInt(0x05060708, 8, 4));
        assertEquals(0x01, MemoryAccessor.getBitsInInt(0x05060708, 3, 5));
        assertEquals(1, MemoryAccessor.setBitsInInt(0, 1, 0, 1));
        assertEquals(1, MemoryAccessor.setBitsInInt(-1, 0, 1, 31));
        assertThrows(IllegalArgumentException.class, () -> MemoryAccessor.setBitsInInt(0, 0x00010000, 0, 16));
    }

    @Test
    public void testBitsInShort() {
        assertEquals(0x07, MemoryAccessor.getBitsInShort((short) 0x0708, 8, 4));
        assertEquals(0x01, MemoryAccessor.getBitsInShort((short) 0x0708, 3, 5));
        assertEquals(1, MemoryAccessor.setBitsInShort((short) 0, (short) 1, 0, 1));
        assertEquals(1, MemoryAccessor.setBitsInShort((short) -1, (short) 0, 1, 15));
        assertThrows(IllegalArgumentException.class, () -> MemoryAccessor.setBitsInShort((short) 0, (short) 0x0100, 0, 8));
    }

    @Test
    public void testBitsInByte() {
        assertEquals(0x07, MemoryAccessor.getBitsInByte((byte) 0x07, 0, 4));
        assertEquals(0x01, MemoryAccessor.getBitsInByte((byte) 0x08, 3, 5));
        assertEquals(1, MemoryAccessor.setBitsInByte((byte) 0, (byte) 1, 0, 1));
        assertEquals(1, MemoryAccessor.setBitsInByte((byte) -1, (byte) 0, 1, 7));
        assertThrows(IllegalArgumentException.class, () -> MemoryAccessor.setBitsInByte((byte) 0, (byte) 0x10, 0, 4));
    }
}
