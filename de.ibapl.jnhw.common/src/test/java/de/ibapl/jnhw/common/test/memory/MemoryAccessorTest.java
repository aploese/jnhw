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
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.UnsafeMemoryAccessor32;
import de.ibapl.jnhw.common.memory.UnsafeMemoryAccessor64;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.WordSize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author aploese
 */
public class MemoryAccessorTest {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();
    private final static boolean IS_BIG_ENDIAN = MULTIARCH_TUPEL_BUILDER.getEndianess().isBigEndian();
    private final static Memory32Heap heap = new Memory32Heap(null, 0, 8 * 12, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t prev = new Int64_t(heap, 0, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t mem = new Int64_t(heap, 8 * 1, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t succ1 = new Int64_t(heap, 8 * 2, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t succ2 = new Int64_t(heap, 8 * 3, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t succ3 = new Int64_t(heap, 8 * 4, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t succ4 = new Int64_t(heap, 8 * 5, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t succ5 = new Int64_t(heap, 8 * 6, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t succ6 = new Int64_t(heap, 8 * 7, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t succ7 = new Int64_t(heap, 8 * 8, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t succ8 = new Int64_t(heap, 8 * 9, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t succ9 = new Int64_t(heap, 8 * 10, AbstractNativeMemory.MEM_UNINITIALIZED);
    private final static Int64_t succ10 = new Int64_t(heap, 8 * 11, AbstractNativeMemory.MEM_UNINITIALIZED);

    private final MemoryAccessor ma;

    @BeforeEach
    public void beforeEach() {
        OpaqueMemory32.clear(heap);
    }

    public static void assertMem() {
        // Just make sure we have not written outside...
        assertEquals(0L, prev.int64_t());
        assertEquals(0L, succ1.int64_t());
        assertEquals(0L, succ2.int64_t());
        assertEquals(0L, succ3.int64_t());
        assertEquals(0L, succ4.int64_t());
        assertEquals(0L, succ5.int64_t());
        assertEquals(0L, succ6.int64_t());
        assertEquals(0L, succ7.int64_t());
        assertEquals(0L, succ8.int64_t());
        assertEquals(0L, succ9.int64_t());
        assertEquals(0L, succ10.int64_t());
    }

    public MemoryAccessorTest() {
        this.ma = MULTIARCH_TUPEL_BUILDER.getWordSize() == WordSize._64_BIT ? new UnsafeMemoryAccessor64() : new UnsafeMemoryAccessor32();
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
        ma.int8_t(mem, 0, value);
        assertMem();
        assertMemEqualsByte(value);
        assertEquals(value, ma.int8_t(mem, 0));

        assertEquals(String.format("0x%02x", value), ma.int8_t_AsHex(mem, 0));
        assertEquals(Byte.toString(value), ma.int8_t_nativeToString(mem, 0));
    }

    /**
     * Test of uint8_t (byte) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(bytes = {Byte.MIN_VALUE, -1, 0, 1, Byte.MAX_VALUE})
    public void testUint8_t_ByteTest(byte value) {
        ma.uint8_t(mem, 0, value);
        assertMem();
        assertMemEqualsByte(value);
        assertEquals(value, ma.uint8_t(mem, 0));

        assertEquals(String.format("0x%02x", value), ma.uint8_t_AsHex(mem, 0));
        assertEquals(Integer.toString(value & 0xff), ma.uint8_t_nativeToString(mem, 0));
    }

    /**
     * Test of uint8_t (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {-1, 0, 1, 0x00ff, 0x0100})
    public void testUint8_t_ShortTest(short value) {
        if ((value < 0) || (value > 0xff)) {
            assertThrows(IllegalArgumentException.class, () -> ma.uint8_t_FromShort(mem, 0, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.uint8_t_FromShort(mem, 0, value);
        assertMem();
        assertMemEqualsByte((byte) value);
        assertEquals(value, ma.uint8_t_AsShort(mem, 0));

        assertEquals(String.format("0x%02x", value), ma.uint8_t_AsHex(mem, 0));
        assertEquals(Integer.toString(value & 0xffff), ma.uint8_t_nativeToString(mem, 0));
    }

    /**
     * Test of int16_t (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {Short.MIN_VALUE, -1, 0, 1, Short.MAX_VALUE})
    public void testInt16_t_ShortTest(short value) {
        ma.int16_t(mem, 0, value);
        assertMem();
        assertMemEqualsShort(value);
        assertEquals(value, ma.int16_t(mem, 0));

        assertEquals(String.format("0x%04x", value), ma.int16_t_AsHex(mem, 0));
        assertEquals(Short.toString(value), ma.int16_t_nativeToString(mem, 0));
    }

    /**
     * Test of uint16_t (short) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(shorts = {Short.MIN_VALUE, -1, 0, 1, Short.MAX_VALUE})
    public void testUint16_t_ShortTest(short value) {
        ma.uint16_t(mem, 0, value);
        assertMem();
        assertMemEqualsShort(value);
        assertEquals(value, ma.uint16_t(mem, 0));

        assertEquals(String.format("0x%04x", value), ma.uint16_t_AsHex(mem, 0));
        assertEquals(Integer.toString(value & 0xffff), ma.uint16_t_nativeToString(mem, 0));
    }

    /**
     * Test of uint16_t (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 0x0000ffff, 0x00010000})
    public void testUint16_t_IntTest(int value) {
        if ((value < 0) || (value > 0xffff)) {
            assertThrows(IllegalArgumentException.class, () -> ma.uint16_t_FromInt(mem, 0, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.uint16_t_FromInt(mem, 0, value);
        assertMem();
        assertMemEqualsShort((short) value);
        assertEquals(value, ma.uint16_t_AsInt(mem, 0));

        assertEquals(String.format("0x%04x", value), ma.uint16_t_AsHex(mem, 0));
        assertEquals(Integer.toString(value & 0xffff), ma.uint16_t_nativeToString(mem, 0));
    }

    /**
     * Test of int32_t (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    public void testInt32_t_IntTest(int value) {
        ma.int32_t(mem, 0, value);
        assertMem();
        assertMemEqualsInt(value);
        assertEquals(value, ma.int32_t(mem, 0));

        assertEquals(String.format("0x%08x", value), ma.int32_t_AsHex(mem, 0));
        assertEquals(Integer.toString(value), ma.int32_t_nativeToString(mem, 0));
    }

    /**
     * Test of uint32_t (int) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE})
    public void testUint32_t_IntTest(int value) {
        ma.uint32_t(mem, 0, value);
        assertMem();
        assertMemEqualsInt(value);
        assertEquals(value, ma.uint32_t(mem, 0));

        assertEquals(String.format("0x%08x", value), ma.uint32_t_AsHex(mem, 0));
        assertEquals(Long.toString(value & 0xffffffffL), ma.uint32_t_nativeToString(mem, 0));
    }

    /**
     * Test of uint32_t (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {-1, 0, 1, 0x00000000ffffffff, 0x0000000100000000L})
    public void testUint32_t_LongTest(long value) {
        if ((value < 0) || (value > 0xffffffffL)) {
            assertThrows(IllegalArgumentException.class, () -> ma.uint32_t_FromLong(mem, 0, value));
            assertMem();
            assertMemIsClear();
            return;
        }

        ma.uint32_t_FromLong(mem, 0, value);
        assertMem();
        assertMemEqualsInt((int) value);
        assertEquals(value, ma.uint32_t_AsLong(mem, 0));

        assertEquals(String.format("0x%08x", value), ma.uint32_t_AsHex(mem, 0));
        assertEquals(Long.toString(value & 0xffffffffL), ma.uint32_t_nativeToString(mem, 0));
    }

    /**
     * Test of int64_t (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE})
    public void testInt64_t_LongTest(long value) {
        ma.int64_t(mem, 0, value);
        assertMem();
        assertMemEqualsLong(value);
        assertEquals(value, ma.int64_t(mem, 0));

        assertEquals(String.format("0x%016x", value), ma.int64_t_AsHex(mem, 0));
        assertEquals(Long.toString(value), ma.int64_t_nativeToString(mem, 0));
    }

    /**
     * Test of uint64_t (long) methods, of class MemoryAccessor.
     */
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE})
    public void testUint64_t_LongTest(long value) {
        ma.uint64_t(mem, 0, value);
        assertMem();
        assertMemEqualsLong(value);
        assertEquals(value, ma.uint64_t(mem, 0));

        assertEquals(String.format("0x%016x", value), ma.uint64_t_AsHex(mem, 0));
        assertEquals(Long.toUnsignedString(value), ma.uint64_t_nativeToString(mem, 0));
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
        byte result = instance.int8_t(mem, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of signed_long method, of class MemoryAccessor.
     * /
    @Test
    public void testSigned_long_OpaqueMemory32_long() {
        System.out.println("signed_long");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        long expResult = 0L;
        long result = instance.signed_long(mem, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of signed_long method, of class MemoryAccessor.
     * /
    @Test
    public void testSigned_long_3args() {
        System.out.println("signed_long");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        long value = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.signed_long(mem, offset, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unsigned_long method, of class MemoryAccessor.
     * /
    @Test
    public void testUnsigned_long_OpaqueMemory32_long() {
        System.out.println("unsigned_long");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        long expResult = 0L;
        long result = instance.unsigned_long(mem, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unsigned_long method, of class MemoryAccessor.
     * /
    @Test
    public void testUnsigned_long_3args() {
        System.out.println("unsigned_long");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        long value = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.unsigned_long(mem, offset, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSignedIntOf method, of class MemoryAccessor.
     * /
    @Test
    public void testGetSignedIntOf() {
        System.out.println("getSignedIntOf");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        int expResult = 0;
        int result = instance.getSignedIntOf(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSignedIntOf method, of class MemoryAccessor.
     * /
    @Test
    public void testSetSignedIntOf() {
        System.out.println("setSignedIntOf");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        int value = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.setSignedIntOf(mem, offset, realSize, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnsignedIntOf method, of class MemoryAccessor.
     * /
    @Test
    public void testSetUnsignedIntOf() {
        System.out.println("setUnsignedIntOf");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        int value = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.setUnsignedIntOf(mem, offset, realSize, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnsignedIntOf method, of class MemoryAccessor.
     * /
    @Test
    public void testGetUnsignedIntOf() {
        System.out.println("getUnsignedIntOf");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        int expResult = 0;
        int result = instance.getUnsignedIntOf(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnsignedIntOf_AsHex method, of class MemoryAccessor.
     * /
    @Test
    public void testGetUnsignedIntOf_AsHex() {
        System.out.println("getUnsignedIntOf_AsHex");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        String expResult = "";
        String result = instance.getUnsignedIntOf_AsHex(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSignedIntOf_AsHex method, of class MemoryAccessor.
     * /
    @Test
    public void testGetSignedIntOf_AsHex() {
        System.out.println("getSignedIntOf_AsHex");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        String expResult = "";
        String result = instance.getSignedIntOf_AsHex(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnsignedIntOf_nativeToString method, of class MemoryAccessor.
     * /
    @Test
    public void testGetUnsignedIntOf_nativeToString() {
        System.out.println("getUnsignedIntOf_nativeToString");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        String expResult = "";
        String result = instance.getUnsignedIntOf_nativeToString(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSignedIntOf_nativeToString method, of class MemoryAccessor.
     * /
    @Test
    public void testGetSignedIntOf_nativeToString() {
        System.out.println("getSignedIntOf_nativeToString");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        String expResult = "";
        String result = instance.getSignedIntOf_nativeToString(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSignedLongOf method, of class MemoryAccessor.
     * /
    @Test
    public void testGetSignedLongOf() {
        System.out.println("getSignedLongOf");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        long expResult = 0L;
        long result = instance.getSignedLongOf(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSignedLongOf method, of class MemoryAccessor.
     * /
    @Test
    public void testSetSignedLongOf() {
        System.out.println("setSignedLongOf");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        long value = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.setSignedLongOf(mem, offset, realSize, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnsignedLongOf method, of class MemoryAccessor.
     * /
    @Test
    public void testSetUnsignedLongOf() {
        System.out.println("setUnsignedLongOf");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        long value = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.setUnsignedLongOf(mem, offset, realSize, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnsignedLongOf method, of class MemoryAccessor.
     * /
    @Test
    public void testGetUnsignedLongOf() {
        System.out.println("getUnsignedLongOf");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        long expResult = 0L;
        long result = instance.getUnsignedLongOf(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnsignedLongOf_AsHex method, of class MemoryAccessor.
     * /
    @Test
    public void testGetUnsignedLongOf_AsHex() {
        System.out.println("getUnsignedLongOf_AsHex");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        String expResult = "";
        String result = instance.getUnsignedLongOf_AsHex(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSignedLongOf_AsHex method, of class MemoryAccessor.
     * /
    @Test
    public void testGetSignedLongOf_AsHex() {
        System.out.println("getSignedLongOf_AsHex");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        String expResult = "";
        String result = instance.getSignedLongOf_AsHex(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnsignedLongOf_nativeToString method, of class MemoryAccessor.
     * /
    @Test
    public void testGetUnsignedLongOf_nativeToString() {
        System.out.println("getUnsignedLongOf_nativeToString");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        String expResult = "";
        String result = instance.getUnsignedLongOf_nativeToString(mem, offset, realSize);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSignedLongOf_nativeToString method, of class MemoryAccessor.
     * /
    @Test
    public void testGetSignedLongOf_nativeToString() {
        System.out.println("getSignedLongOf_nativeToString");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int realSize = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        String expResult = "";
        String result = instance.getSignedLongOf_nativeToString(mem, offset, realSize);
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
     * Test of uintptr_t method, of class MemoryAccessor.
     * /
    @Test
    public void testUintptr_t_OpaqueMemory32_long() {
        System.out.println("uintptr_t");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        NativeAddressHolder expResult = null;
        NativeAddressHolder result = instance.uintptr_t(mem, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uintptr_t method, of class MemoryAccessor.
     * /
    @Test
    public void testUintptr_t_3args_1() {
        System.out.println("uintptr_t");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        OpaqueMemory32 dest = null;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.uintptr_t(mem, offset, dest);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uintptr_t method, of class MemoryAccessor.
     * /
    @Test
    public void testUintptr_t_4args() {
        System.out.println("uintptr_t");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        OpaqueMemory32 dest = null;
        long destOffset = 0L;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.uintptr_t(mem, offset, dest, destOffset);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uintptr_t method, of class MemoryAccessor.
     * /
    @Test
    public void testUintptr_t_3args_2() {
        System.out.println("uintptr_t");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        ByteBuffer dest = null;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.uintptr_t(mem, offset, dest);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uintptr_t method, of class MemoryAccessor.
     * /
    @Test
    public void testUintptr_t_3args_3() {
        System.out.println("uintptr_t");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        NativeAddressHolder dest = null;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.uintptr_t(mem, offset, dest);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uintptr_t method, of class MemoryAccessor.
     * /
    @Test
    public void testUintptr_t_3args_4() {
        System.out.println("uintptr_t");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        NativeFunctionPointer dest = null;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.uintptr_t(mem, offset, dest);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uintptr_t_AtIndex method, of class MemoryAccessor.
     * /
    @Test
    public void testUintptr_t_AtIndex_3args() {
        System.out.println("uintptr_t_AtIndex");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int index = 0;
        MemoryAccessor instance = new MemoryAccessorImpl();
        NativeAddressHolder expResult = null;
        NativeAddressHolder result = instance.uintptr_t_AtIndex(mem, offset, index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uintptr_t_AtIndex method, of class MemoryAccessor.
     * /
    @Test
    public void testUintptr_t_AtIndex_4args_1() {
        System.out.println("uintptr_t_AtIndex");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int index = 0;
        OpaqueMemory32 dest = null;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.uintptr_t_AtIndex(mem, offset, index, dest);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uintptr_t_AtIndex method, of class MemoryAccessor.
     * /
    @Test
    public void testUintptr_t_AtIndex_4args_2() {
        System.out.println("uintptr_t_AtIndex");
        OpaqueMemory32 mem = null;
        long offset = 0L;
        int index = 0;
        NativeAddressHolder dest = null;
        MemoryAccessor instance = new MemoryAccessorImpl();
        instance.uintptr_t_AtIndex(mem, offset, index, dest);
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
        ma.copyMemory32(mem, 0, actual, 0, actual.length);

        final byte[] expected = new byte[8];
        expected[0] = value;
        assertArrayEquals(expected, actual);

    }

    private void assertMemEqualsShort(short value) {
        final byte[] actual = new byte[8];
        ma.copyMemory32(mem, 0, actual, 0, actual.length);

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
        ma.copyMemory32(mem, 0, actual, 0, actual.length);

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
        ma.copyMemory32(mem, 0, actual, 0, actual.length);

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
        assertEquals(0, mem.int64_t());
    }

}
