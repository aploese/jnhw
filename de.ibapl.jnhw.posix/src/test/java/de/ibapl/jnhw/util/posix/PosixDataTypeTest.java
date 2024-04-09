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
package de.ibapl.jnhw.util.posix;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.posix.JnhwTestLogger;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 * Test all symbolic constants XXX that are defined with #define XXX
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class PosixDataTypeTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testInfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testInfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testInfo) throws Exception {
        JnhwTestLogger.logAfterAll(testInfo);
    }

    @BeforeEach
    public void setUp(TestInfo testInfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testInfo);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        JnhwTestLogger.logAfterEach(testInfo);
    }

    @Test
    public void testCc_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__cc_t__isUnsigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__cc_t__IS__uint8_t")) {
            assertEquals(PosixDataType.cc_t, BaseDataType.uint8_t);
            assertEquals(0x0080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__cc_t__AS_Uint64_t"));
        } else {
            fail("cc_t is not datatype uint8_t");
        }
    }

    @Test
    public void testClock_t() {
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__clock_t__IS__int32_t")) {
            assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__clock_t__isSigned"));
            assertEquals(PosixDataType.clock_t, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__clock_t__AS_Uint64_t"));
        } else if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__clock_t__IS__int64_t")) {
            assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__clock_t__isSigned"));
            assertEquals(PosixDataType.clock_t, BaseDataType.int64_t);
            assertEquals(0x8000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__clock_t__AS_Uint64_t"));
        } else if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__clock_t__IS__uint64_t")) {
            assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__clock_t__isUnsigned"));
            assertEquals(PosixDataType.clock_t, BaseDataType.uint64_t);
            assertEquals(0x8000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__clock_t__AS_Uint64_t"));
        } else {
            fail("clock_t is not datatype int32_t or int64_t or uint64_t");
        }
    }

    @Test
    public void testClockid_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__clockid_t__isSigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__clockid_t__IS__int32_t")) {
            assertEquals(PosixDataType.clockid_t, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__clockid_t__AS_Uint64_t"));
        } else {
            fail("clockid_t is not datatype int32_t");
        }
    }

    @Test
    public void testMode_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__mode_t__isUnsigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__mode_t__IS__uint16_t")) {
            assertEquals(PosixDataType.mode_t, BaseDataType.uint16_t);
            assertEquals(0x00008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__mode_t__AS_Uint64_t"));
        } else if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__mode_t__IS__uint32_t")) {
            assertEquals(PosixDataType.mode_t, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__mode_t__AS_Uint64_t"));
        } else {
            fail("mode_t is not datatype uint16_t or uint32_t");
        }
    }

    @Test
    public void testNfds_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__nfds_t__isUnsigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__nfds_t__IS__uint32_t")) {
            assertEquals(PosixDataType.nfds_t, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__nfds_t__AS_Uint64_t"));
        } else if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__nfds_t__IS__uint64_t")) {
            assertEquals(PosixDataType.nfds_t, BaseDataType.uint64_t);
            assertEquals(0x8000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__nfds_t__AS_Uint64_t"));
        } else {
            fail("nfds_t is not datatype uint32_t or uint64_t");
        }
    }

    @Test
    public void testOff_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__off_t__isSigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__off_t__IS__int32_t")) {
            assertEquals(PosixDataType.off_t, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__off_t__AS_Uint64_t"));
        } else if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__off_t__IS__int64_t")) {
            assertEquals(PosixDataType.off_t, BaseDataType.int64_t);
            assertEquals(0x8000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__off_t__AS_Uint64_t"));
        } else {
            fail("off_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testPid_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__pid_t__isSigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__pid_t__IS__int32_t")) {
            assertEquals(PosixDataType.pid_t, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__pid_t__AS_Uint64_t"));
        } else {
            fail("pid_t is not datatype int32_t");
        }
    }

    @Test
    public void testSize_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__size_t__isUnsigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__size_t__IS__uint32_t")) {
            assertEquals(PosixDataType.size_t, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__size_t__AS_Uint64_t"));
        } else if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__size_t__IS__uint64_t")) {
            assertEquals(PosixDataType.size_t, BaseDataType.uint64_t);
            assertEquals(0x8000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__size_t__AS_Uint64_t"));
        } else {
            fail("size_t is not datatype uint32_t or uint64_t");
        }
    }

    @Test
    public void testSpeed_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__speed_t__isUnsigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__speed_t__IS__uint32_t")) {
            assertEquals(PosixDataType.speed_t, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__speed_t__AS_Uint64_t"));
        } else if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__speed_t__IS__uint64_t")) {
            assertEquals(PosixDataType.speed_t, BaseDataType.uint64_t);
            assertEquals(0x8000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__speed_t__AS_Uint64_t"));
        } else {
            fail("speed_t is not datatype uint32_t or uint64_t");
        }
    }

    @Test
    public void testSsize_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__ssize_t__isSigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__ssize_t__IS__int32_t")) {
            assertEquals(PosixDataType.ssize_t, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__ssize_t__AS_Uint64_t"));
        } else if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__ssize_t__IS__int64_t")) {
            assertEquals(PosixDataType.ssize_t, BaseDataType.int64_t);
            assertEquals(0x8000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__ssize_t__AS_Uint64_t"));
        } else {
            fail("ssize_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testTcflag_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__tcflag_t__isUnsigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__tcflag_t__IS__uint32_t")) {
            assertEquals(PosixDataType.tcflag_t, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__tcflag_t__AS_Uint64_t"));
        } else if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__tcflag_t__IS__uint64_t")) {
            assertEquals(PosixDataType.tcflag_t, BaseDataType.uint64_t);
            assertEquals(0x8000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__tcflag_t__AS_Uint64_t"));
        } else {
            fail("tcflag_t is not datatype uint32_t or uint64_t");
        }
    }

    @Test
    public void testTime_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__time_t__isSigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__time_t__IS__int32_t")) {
            assertEquals(PosixDataType.time_t, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__time_t__AS_Uint64_t"));
        } else if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__time_t__IS__int64_t")) {
            assertEquals(PosixDataType.time_t, BaseDataType.int64_t);
            assertEquals(0x8000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__time_t__AS_Uint64_t"));
        } else {
            fail("time_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testUid_t() {
        assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__uid_t__isUnsigned"));
        if (LibJnhwPosixTestLoader.invokeExact_CharToBool_V("JNHW__uid_t__IS__uint32_t")) {
            assertEquals(PosixDataType.uid_t, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, LibJnhwPosixTestLoader.invoke_sL___V("JNHW__uid_t__AS_Uint64_t"));
        } else {
            fail("uid_t is not datatype uint32_t");
        }
    }

}
