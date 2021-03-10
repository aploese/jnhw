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
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SET_MEM_TO_0;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.util.posix.PosixDataType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class TypesTest {

    public TypesTest() {
    }

    @Test
    public void testClock_t() {
        Assertions.assertFalse(PosixDataType.clock_t.baseDataType.UNSIGNED);
        Types.Clock_t instance = new Types.Clock_t(null, 0, SET_MEM_TO_0);
        instance.setFromSignedLong(-1);
        assertEquals(-1L, instance.getAsSignedLong());
        if (PosixDataType.clock_t.baseDataType.SIZE_OF == 4) {
            Assertions.assertEquals(Alignment.AT_4, PosixDataType.clock_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.int32_t, instance.getBaseDataType());
            instance.setFromSignedLong(0x80706050);
            assertEquals(0x80706050, instance.getAsSignedLong());
            assertEquals(Integer.toString(0x80706050), instance.nativeToString());
            assertEquals("0x80706050", instance.nativeToHexString());
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong(1L + Integer.MAX_VALUE));
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong((long) Integer.MIN_VALUE - 1L));
        } else if (PosixDataType.clock_t.baseDataType.SIZE_OF == 8) {
            Assertions.assertEquals(Alignment.AT_8, PosixDataType.clock_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.int64_t, instance.getBaseDataType());
            instance.setFromSignedLong(0x8070605040302010L);
            assertEquals(0x8070605040302010L, instance.getAsSignedLong());
            assertEquals(Long.toString(0x8070605040302010L), instance.nativeToString());
            assertEquals("0x8070605040302010", instance.nativeToHexString());
        } else {
            fail();
        }
    }

    @Test
    public void testMode_t() {
        Assertions.assertTrue(PosixDataType.mode_t.baseDataType.UNSIGNED);
        Types.Mode_t instance = new Types.Mode_t(null, 0, SET_MEM_TO_0);
        if (PosixDataType.mode_t.baseDataType.SIZE_OF == 2) {
            Assertions.assertEquals(Alignment.AT_2, PosixDataType.mode_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.uint16_t, instance.getBaseDataType());
            assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(0x8070));
            assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(0x00008070));
            instance.setFromUnsignedInt((short) 0x8070);
            assertEquals((short) 0x8070, instance.getAsUnsignedInt());
            assertEquals(Integer.toUnsignedString(0x8070), instance.nativeToString());
            assertEquals("0x8070", instance.nativeToHexString());
            //Test MAX_UINT16 + 1
            assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(0x00010000));
            assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(-1));
        } else if (PosixDataType.mode_t.baseDataType.SIZE_OF == 4) {
            Assertions.assertEquals(Alignment.AT_4, PosixDataType.mode_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.uint32_t, instance.getBaseDataType());
            instance.setFromUnsignedInt(0x80706050);
            assertEquals(0x80706050, instance.getAsUnsignedInt());
            assertEquals(Integer.toUnsignedString(0x80706050), instance.nativeToString());
            assertEquals("0x80706050", instance.nativeToHexString());
            //This is unsigned so this is really
            instance.setFromUnsignedInt(-1);
            assertEquals(-1, instance.getAsUnsignedInt());
            assertEquals("4294967295", instance.nativeToString());
            assertEquals("0xffffffff", instance.nativeToHexString());
        } else {
            fail();
        }
    }

    @Test
    public void testOff_t() {
        Assertions.assertFalse(PosixDataType.off_t.baseDataType.UNSIGNED);
        Types.Off_t instance = new Types.Off_t(null, 0, SET_MEM_TO_0);
        instance.setFromSignedLong(-1);
        assertEquals(-1L, instance.getAsSignedLong());
        if (PosixDataType.off_t.baseDataType.SIZE_OF == 4) {
            Assertions.assertEquals(Alignment.AT_4, PosixDataType.off_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.int32_t, instance.getBaseDataType());
            instance.setFromSignedLong(0x80706050);
            assertEquals(0x80706050, instance.getAsSignedLong());
            assertEquals(Integer.toString(0x80706050), instance.nativeToString());
            assertEquals("0x80706050", instance.nativeToHexString());
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong(1L + Integer.MAX_VALUE));
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong((long) Integer.MIN_VALUE - 1L));
        } else if (PosixDataType.off_t.baseDataType.SIZE_OF == 8) {
            Assertions.assertEquals(Alignment.AT_8, PosixDataType.off_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.int64_t, instance.getBaseDataType());
            instance.setFromSignedLong(0x8070605040302010L);
            assertEquals(0x8070605040302010L, instance.getAsSignedLong());
            assertEquals(Long.toString(0x8070605040302010L), instance.nativeToString());
            assertEquals("0x8070605040302010", instance.nativeToHexString());
        } else {
            fail();
        }
    }

    @Test
    public void testPid_t() {
        Assertions.assertEquals(4, PosixDataType.pid_t.baseDataType.SIZE_OF);
        Assertions.assertEquals(Alignment.AT_4, PosixDataType.pid_t.baseDataType.ALIGN_OF);
        Assertions.assertFalse(PosixDataType.pid_t.baseDataType.UNSIGNED);
        Types.Pid_t instance = new Types.Pid_t(null, 0, SET_MEM_TO_0);
        instance.int32_t(0x80706050);
        assertEquals(0x80706050, instance.int32_t());
        assertEquals(Integer.toString(0x80706050), instance.nativeToString());
        assertEquals("0x80706050", instance.nativeToHexString());
    }

    @Test
    public void testSize_t() {
        Assertions.assertTrue(PosixDataType.size_t.baseDataType.UNSIGNED);
        Types.Size_t instance = new Types.Size_t(null, 0, SET_MEM_TO_0);
        if (PosixDataType.size_t.baseDataType.SIZE_OF == 4) {
            Assertions.assertEquals(Alignment.AT_4, PosixDataType.size_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.uint32_t, instance.getBaseDataType());
            assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedLong(0x80706050));
            assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedLong(0x0000000080706050));
            instance.setFromUnsignedLong(0x80706050L);
            assertEquals(0x80706050L, instance.getAsUnsignedLong());
            assertEquals(Integer.toUnsignedString(0x80706050), instance.nativeToString());
            assertEquals("0x80706050", instance.nativeToHexString());
            //Test MAX_UINT32 + 1
            assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedLong(0x0000000100000000L));
            assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedLong(-1));
        } else if (PosixDataType.size_t.baseDataType.SIZE_OF == 8) {
            Assertions.assertEquals(Alignment.AT_8, PosixDataType.size_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.uint64_t, instance.getBaseDataType());
            instance.setFromUnsignedLong(0x8070605040302010L);
            assertEquals(0x8070605040302010L, instance.getAsUnsignedLong());
            assertEquals(Long.toUnsignedString(0x8070605040302010L), instance.nativeToString());
            assertEquals("0x8070605040302010", instance.nativeToHexString());
            //This is unsigned so this is really
            instance.setFromUnsignedLong(-1L);
            assertEquals(-1, instance.getAsUnsignedLong());
            assertEquals("18446744073709551615", instance.nativeToString());
            assertEquals("0xffffffffffffffff", instance.nativeToHexString());
        } else {
            fail();
        }
    }

    @Test
    public void testSsize_t() {
        Assertions.assertFalse(PosixDataType.ssize_t.baseDataType.UNSIGNED);
        Types.Ssize_t instance = new Types.Ssize_t(null, 0, SET_MEM_TO_0);
        instance.setFromSignedLong(-1);
        assertEquals(-1L, instance.getAsSignedLong());
        if (PosixDataType.ssize_t.baseDataType.SIZE_OF == 4) {
            Assertions.assertEquals(Alignment.AT_4, PosixDataType.ssize_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.int32_t, instance.getBaseDataType());
            instance.setFromSignedLong(0x80706050);
            assertEquals(0x80706050, instance.getAsSignedLong());
            assertEquals(Integer.toString(0x80706050), instance.nativeToString());
            assertEquals("0x80706050", instance.nativeToHexString());
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong(1L + Integer.MAX_VALUE));
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong((long) Integer.MIN_VALUE - 1L));
        } else if (PosixDataType.ssize_t.baseDataType.SIZE_OF == 8) {
            Assertions.assertEquals(Alignment.AT_8, PosixDataType.ssize_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.int64_t, instance.getBaseDataType());
            instance.setFromSignedLong(0x8070605040302010L);
            assertEquals(0x8070605040302010L, instance.getAsSignedLong());
            assertEquals(Long.toString(0x8070605040302010L), instance.nativeToString());
            assertEquals("0x8070605040302010", instance.nativeToHexString());
        } else {
            fail();
        }
    }

    @Test
    public void testTime_t() {
        Assertions.assertFalse(PosixDataType.time_t.baseDataType.UNSIGNED);
        Types.Time_t instance = new Types.Time_t(null, 0, SET_MEM_TO_0);
        instance.setFromSignedLong(-1);
        assertEquals(-1L, instance.getAsSignedLong());
        if (PosixDataType.time_t.baseDataType.SIZE_OF == 4) {
            Assertions.assertEquals(Alignment.AT_4, PosixDataType.time_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.int32_t, instance.getBaseDataType());
            instance.setFromSignedLong(0x80706050);
            assertEquals(0x80706050, instance.getAsSignedLong());
            assertEquals(Integer.toString(0x80706050), instance.nativeToString());
            assertEquals("0x80706050", instance.nativeToHexString());
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong(1L + Integer.MAX_VALUE));
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong((long) Integer.MIN_VALUE - 1L));
        } else if (PosixDataType.time_t.baseDataType.SIZE_OF == 8) {
            Assertions.assertEquals(Alignment.AT_8, PosixDataType.time_t.baseDataType.ALIGN_OF);
            assertEquals(BaseDataType.int64_t, instance.getBaseDataType());
            instance.setFromSignedLong(0x8070605040302010L);
            assertEquals(0x8070605040302010L, instance.getAsSignedLong());
            assertEquals(Long.toString(0x8070605040302010L), instance.nativeToString());
            assertEquals("0x8070605040302010", instance.nativeToHexString());
        } else {
            fail();
        }
    }

    @Test
    public void testUid_t() {
        Assertions.assertEquals(4, PosixDataType.uid_t.baseDataType.SIZE_OF);
        Assertions.assertEquals(Alignment.AT_4, PosixDataType.uid_t.baseDataType.ALIGN_OF);
        Assertions.assertTrue(PosixDataType.uid_t.baseDataType.UNSIGNED);
        Types.Uid_t instance = new Types.Uid_t(null, 0, SET_MEM_TO_0);
        instance.uint32_t(0x80706050);
        assertEquals(0x80706050, instance.uint32_t());
        assertEquals(Integer.toUnsignedString(0x80706050), instance.nativeToString());
        assertEquals("0x80706050", instance.nativeToHexString());
    }

}
