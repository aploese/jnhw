/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2025, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.posix.JnhwTestLogger;
import static de.ibapl.jnhw.posix.LibJnhwPosixTestLoader.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
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
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__cc_t__Sign"), PosixDataType.cc_t.sign, "cc_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__cc_t"), PosixDataType.cc_t.byteSize, "cc_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__cc_t"), PosixDataType.cc_t.byteAlignment, "cc_t alignof" )
        );
    }

    @Test
    public void testClock_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__clock_t__Sign"), PosixDataType.clock_t.sign, "clock_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__clock_t"), PosixDataType.clock_t.byteSize, "clock_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__clock_t"), PosixDataType.clock_t.byteAlignment, "clock_t alignof" )
        );
    }

    @Test
    public void testClockid_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__clockid_t__Sign"), PosixDataType.clockid_t.sign, "clockid_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__clockid_t"), PosixDataType.clockid_t.byteSize, "clockid_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__clockid_t"), PosixDataType.clockid_t.byteAlignment, "clockid_t alignof" )
        );
    }

    @Test
    public void testMode_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__mode_t__Sign"), PosixDataType.mode_t.sign, "mode_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__mode_t"), PosixDataType.mode_t.byteSize, "mode_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__mode_t"), PosixDataType.mode_t.byteAlignment, "mode_t alignof" )
        );
    }

    @Test
    public void testNfds_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__nfds_t__Sign"), PosixDataType.nfds_t.sign, "nfds_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__nfds_t"), PosixDataType.nfds_t.byteSize, "nfds_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__nfds_t"), PosixDataType.nfds_t.byteAlignment, "nfds_t alignof" )
        );
    }

    @Test
    public void testOff_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__off_t__Sign"), PosixDataType.off_t.sign, "off_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__off_t"), PosixDataType.off_t.byteSize, "off_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__off_t"), PosixDataType.off_t.byteAlignment, "off_t alignof" )
        );
    }

    @Test
    public void testPid_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__pid_t__Sign"), PosixDataType.pid_t.sign, "pid_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__pid_t"), PosixDataType.pid_t.byteSize, "pid_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__pid_t"), PosixDataType.pid_t.byteAlignment, "pid_t alignof" )
        );
    }

    @Test
    public void testSize_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__size_t__Sign"), PosixDataType.size_t.sign, "size_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__size_t"), PosixDataType.size_t.byteSize, "size_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__size_t"), PosixDataType.size_t.byteAlignment, "size_t alignof" )
        );
    }

    @Test
    public void testSpeed_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__speed_t__Sign"), PosixDataType.speed_t.sign, "speed_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__speed_t"), PosixDataType.speed_t.byteSize, "speed_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__speed_t"), PosixDataType.speed_t.byteAlignment, "speed_t alignof" )
        );
    }

    @Test
    public void testSsize_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__ssize_t__Sign"), PosixDataType.ssize_t.sign, "ssize_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__ssize_t"), PosixDataType.ssize_t.byteSize, "ssize_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__ssize_t"), PosixDataType.ssize_t.byteAlignment, "ssize_t alignof" )
        );
    }

    @Test
    public void testTcflag_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__tcflag_t__Sign"), PosixDataType.tcflag_t.sign, "tcflag_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__tcflag_t"), PosixDataType.tcflag_t.byteSize, "tcflag_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__tcflag_t"), PosixDataType.tcflag_t.byteAlignment, "tcflag_t alignof" )
        );
    }

    @Test
    public void testTime_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__time_t__Sign"), PosixDataType.time_t.sign, "time_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__time_t"), PosixDataType.time_t.byteSize, "time_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__time_t"), PosixDataType.time_t.byteAlignment, "time_t alignof" )
        );
    }

    @Test
    public void testUid_t() {
        assertAll(
                () -> assertEquals(invokeExact_CharToSign_V("JNHW__uid_t__Sign"), PosixDataType.uid_t.sign, "uid_t sign" ),
                () -> assertEquals(invoke_sI___V("JNHW__sizeof__uid_t"), PosixDataType.uid_t.byteSize, "uid_t sizeof" ),
                () -> assertEquals(invoke_sI___V("JNHW__alignof__uid_t"), PosixDataType.uid_t.byteAlignment, "uid_t alignof" )
        );
    }

}