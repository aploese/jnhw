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
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.datatypes.OS;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.util.posix.DefinesTest;
import de.ibapl.jnhw.util.posix.PosixDataType;
import java.util.NoSuchElementException;
import jdk.incubator.foreign.ResourceScope;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class TypesTest {

    @BeforeAll
    public static void checkBeforeAll_HAVE_SYS_TYPES_H() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Types.HAVE_SYS_TYPES_H, "not expected to have sys/types.h");
        } else {
            Assertions.assertTrue(Types.HAVE_SYS_TYPES_H, "expected to have sys/types.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_StdioDefines() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Types.class, "HAVE_SYS_TYPES_H");
    }

    private ResourceScope scope;

    @BeforeEach
    public void setUp() {
        scope = ResourceScope.newConfinedScope();
    }

    @AfterEach
    public void tearDown() {
        scope.close();
    }

    @Test
    public void testClock_t() {
        Types.Clock_t instance = Types.Clock_t.allocateNative(scope);
        Assertions.assertEquals(PosixDataType.clock_t, instance.getBaseDataType());

        instance.setFromSignedLong(-1);
        assertEquals(-1L, instance.getAsSignedLong());
        switch (PosixDataType.clock_t) {
            case int32_t:
                instance.setFromSignedLong(0x80706050);
                assertEquals(0x80706050, instance.getAsSignedLong());
                assertEquals(Integer.toString(0x80706050), instance.nativeToString());
                assertEquals("0x80706050", instance.nativeToHexString());
                assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong(1L + Integer.MAX_VALUE));
                assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong((long) Integer.MIN_VALUE - 1L));
                break;
            case int64_t:
                instance.setFromSignedLong(0x8070605040302010L);
                assertEquals(0x8070605040302010L, instance.getAsSignedLong());
                assertEquals(Long.toString(0x8070605040302010L), instance.nativeToString());
                assertEquals("0x8070605040302010", instance.nativeToHexString());
                break;
            case uint64_t:
                instance.setFromUnsignedLong(0x8070605040302010L);
                assertEquals(0x8070605040302010L, instance.getAsUnsignedLong());
                assertEquals(Long.toUnsignedString(0x8070605040302010L), instance.nativeToString());
                assertEquals("0x8070605040302010", instance.nativeToHexString());
                break;
            default:
                fail();
        }
    }

    @Test
    public void testClockid_t() {
        Types.Clockid_t instance = Types.Clockid_t.allocateNative(scope);
        Assertions.assertEquals(PosixDataType.clockid_t, instance.getBaseDataType());
        instance.setFromSignedLong(-1);
        assertEquals(-1L, instance.getAsSignedLong());
        instance.setFromSignedLong(0x80706050);
        assertEquals(0x80706050, instance.getAsSignedLong());
        assertEquals(Integer.toString(0x80706050), instance.nativeToString());
        assertEquals("0x80706050", instance.nativeToHexString());
        assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong(1L + Integer.MAX_VALUE));
        assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong((long) Integer.MIN_VALUE - 1L));
    }

    @Test
    public void testMode_t() {
        Assertions.assertTrue(PosixDataType.mode_t.UNSIGNED);
        Types.Mode_t instance = Types.Mode_t.allocateNative(scope);
        switch (PosixDataType.mode_t.SIZE_OF) {
            case 2:
                Assertions.assertEquals(Alignment.AT_2, PosixDataType.mode_t.ALIGN_OF);
                assertEquals(BaseDataType.uint16_t, instance.getBaseDataType());
                assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(0x00010000));
                assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(-1));
                assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt((short) 0x8070));
                instance.setFromUnsignedInt(0x8070);
                assertEquals(Integer.toUnsignedString(0x8070), instance.nativeToString());
                assertEquals("0x8070", instance.nativeToHexString());
                //Test MAX_UINT16 + 1
                assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(0x00010000));
                assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(-1));
                break;
            case 4:
                Assertions.assertEquals(Alignment.AT_4, PosixDataType.mode_t.ALIGN_OF);
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
                break;
            default:
                fail();
        }
    }

    @Test
    public void testOff_t() {
        Assertions.assertFalse(PosixDataType.off_t.UNSIGNED);
        Types.Off_t instance = Types.Off_t.allocateNative(scope);
        instance.setFromSignedLong(-1);
        assertEquals(-1L, instance.getAsSignedLong());
        switch (PosixDataType.off_t.SIZE_OF) {
            case 4:
                Assertions.assertEquals(Alignment.AT_4, PosixDataType.off_t.ALIGN_OF);
                assertEquals(BaseDataType.int32_t, instance.getBaseDataType());
                instance.setFromSignedLong(0x80706050);
                assertEquals(0x80706050, instance.getAsSignedLong());
                assertEquals(Integer.toString(0x80706050), instance.nativeToString());
                assertEquals("0x80706050", instance.nativeToHexString());
                assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong(1L + Integer.MAX_VALUE));
                assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong((long) Integer.MIN_VALUE - 1L));
                break;
            case 8:
                Assertions.assertEquals(Alignment.AT_8, PosixDataType.off_t.ALIGN_OF);
                assertEquals(BaseDataType.int64_t, instance.getBaseDataType());
                instance.setFromSignedLong(0x8070605040302010L);
                assertEquals(0x8070605040302010L, instance.getAsSignedLong());
                assertEquals(Long.toString(0x8070605040302010L), instance.nativeToString());
                assertEquals("0x8070605040302010", instance.nativeToHexString());
                break;
            default:
                fail();
        }
    }

    @Test
    public void testPid_t() {
        Assertions.assertEquals(4, PosixDataType.pid_t.SIZE_OF);
        Assertions.assertEquals(Alignment.AT_4, PosixDataType.pid_t.ALIGN_OF);
        Assertions.assertFalse(PosixDataType.pid_t.UNSIGNED);
        Types.Pid_t instance = Types.Pid_t.allocateNative(scope);
        instance.int32_t(0x80706050);
        assertEquals(0x80706050, instance.int32_t());
        assertEquals(Integer.toString(0x80706050), instance.nativeToString());
        assertEquals("0x80706050", instance.nativeToHexString());
    }

    @Test
    public void testSize_t() {
        Assertions.assertTrue(PosixDataType.size_t.UNSIGNED);
        Types.Size_t instance = Types.Size_t.allocateNative(scope);
        switch (PosixDataType.size_t.SIZE_OF) {
            case 4:
                Assertions.assertEquals(Alignment.AT_4, PosixDataType.size_t.ALIGN_OF);
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
                break;
            case 8:
                Assertions.assertEquals(Alignment.AT_8, PosixDataType.size_t.ALIGN_OF);
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
                break;
            default:
                fail();
        }
    }

    @Test
    public void testSsize_t() {
        Assertions.assertFalse(PosixDataType.ssize_t.UNSIGNED);
        Types.Ssize_t instance = Types.Ssize_t.allocateNative(scope);
        instance.setFromSignedLong(-1);
        assertEquals(-1L, instance.getAsSignedLong());
        if (PosixDataType.ssize_t.SIZE_OF == 4) {
            Assertions.assertEquals(Alignment.AT_4, PosixDataType.ssize_t.ALIGN_OF);
            assertEquals(BaseDataType.int32_t, instance.getBaseDataType());
            instance.setFromSignedLong(0x80706050);
            assertEquals(0x80706050, instance.getAsSignedLong());
            assertEquals(Integer.toString(0x80706050), instance.nativeToString());
            assertEquals("0x80706050", instance.nativeToHexString());
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong(1L + Integer.MAX_VALUE));
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong((long) Integer.MIN_VALUE - 1L));
        } else if (PosixDataType.ssize_t.SIZE_OF == 8) {
            Assertions.assertEquals(Alignment.AT_8, PosixDataType.ssize_t.ALIGN_OF);
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
        Assertions.assertFalse(PosixDataType.time_t.UNSIGNED);
        Types.Time_t instance = Types.Time_t.allocateNative(scope);
        instance.setFromSignedLong(-1);
        assertEquals(-1L, instance.getAsSignedLong());
        if (PosixDataType.time_t.SIZE_OF == 4) {
            Assertions.assertEquals(Alignment.AT_4, PosixDataType.time_t.ALIGN_OF);
            assertEquals(BaseDataType.int32_t, instance.getBaseDataType());
            instance.setFromSignedLong(0x80706050);
            assertEquals(0x80706050, instance.getAsSignedLong());
            assertEquals(Integer.toString(0x80706050), instance.nativeToString());
            assertEquals("0x80706050", instance.nativeToHexString());
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong(1L + Integer.MAX_VALUE));
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong((long) Integer.MIN_VALUE - 1L));
        } else if (PosixDataType.time_t.SIZE_OF == 8) {
            Assertions.assertEquals(Alignment.AT_8, PosixDataType.time_t.ALIGN_OF);
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
        Assertions.assertEquals(4, PosixDataType.uid_t.SIZE_OF);
        Assertions.assertEquals(Alignment.AT_4, PosixDataType.uid_t.ALIGN_OF);
        Assertions.assertTrue(PosixDataType.uid_t.UNSIGNED);
        Types.Uid_t instance = Types.Uid_t.allocateNative(scope);
        instance.uint32_t(0x80706050);
        assertEquals(0x80706050, instance.uint32_t());
        assertEquals(Integer.toUnsignedString(0x80706050), instance.nativeToString());
        assertEquals("0x80706050", instance.nativeToHexString());
    }

    @Test
    public void testGid_t() {
        Assertions.assertEquals(4, PosixDataType.gid_t.SIZE_OF);
        Assertions.assertEquals(Alignment.AT_4, PosixDataType.gid_t.ALIGN_OF);
        Assertions.assertTrue(PosixDataType.gid_t.UNSIGNED);
        Types.Gid_t instance = Types.Gid_t.allocateNative(scope);
        instance.uint32_t(0x80706050);
        assertEquals(0x80706050, instance.uint32_t());
        assertEquals(Integer.toUnsignedString(0x80706050), instance.nativeToString());
        assertEquals("0x80706050", instance.nativeToHexString());
    }

}
