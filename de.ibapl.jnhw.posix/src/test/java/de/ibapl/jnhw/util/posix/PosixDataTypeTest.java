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
package de.ibapl.jnhw.util.posix;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 * Test all symbolic constants XXX that are defined with #define XXX
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class PosixDataTypeTest {

    private static native boolean JNHW__cc_t__IS__uint8_t();

    private static native boolean JNHW__clock_t__IS__int64_t();

    private static native boolean JNHW__clock_t__IS__int32_t();

    private static native boolean JNHW__off_t__IS__int64_t();

    private static native boolean JNHW__off_t__IS__int32_t();

    private static native boolean JNHW__mode_t__IS__uint16_t();

    private static native boolean JNHW__mode_t__IS__uint32_t();

    private static native boolean JNHW__pid_t__IS__int32_t();

    private static native boolean JNHW__speed_t__IS__uint32_t();

    private static native boolean JNHW__size_t__IS__uint64_t();

    private static native boolean JNHW__size_t__IS__uint32_t();

    private static native boolean JNHW__ssize_t__IS__int64_t();

    private static native boolean JNHW__ssize_t__IS__int32_t();

    private static native boolean JNHW__tcflag_t__IS__uint32_t();

    private static native boolean JNHW__time_t__IS__int64_t();

    private static native boolean JNHW__time_t__IS__int32_t();

    private static native boolean JNHW__uid_t__IS__uint32_t();

    private static native boolean cc_t__isUnsigned();

    private static native long cc_t__AS_Uint64_t();

    private static native boolean clock_t__isSigned();

    private static native long clock_t__AS_Uint64_t();

    private static native boolean mode_t__isUnsigned();

    private static native long mode_t__AS_Uint64_t();

    private static native boolean off_t__isSigned();

    private static native long off_t__AS_Uint64_t();

    private static native boolean pid_t__isSigned();

    private static native long pid_t__AS_Uint64_t();

    private static native boolean size_t__isUnsigned();

    private static native long size_t__AS_Uint64_t();

    private static native boolean speed_t__isUnsigned();

    private static native long speed_t__AS_Uint64_t();

    private static native boolean ssize_t__isSigned();

    private static native long ssize_t__AS_Uint64_t();

    private static native boolean tcflag_t__isUnsigned();

    private static native long tcflag_t__AS_Uint64_t();

    private static native boolean time_t__isSigned();

    private static native long time_t__AS_Uint64_t();

    private static native boolean uid_t__isUnsigned();

    private static native long uid_t__AS_Uint64_t();

    static {
        LibJnhwPosixTestLoader.touch();
    }

    @Test
    public void testCc_t() {
        assertTrue(cc_t__isUnsigned());
        if (JNHW__cc_t__IS__uint8_t()) {
            assertEquals(PosixDataType.cc_t.baseDataType, BaseDataType.uint8_t);
            assertEquals(0x0080L, cc_t__AS_Uint64_t());
        } else {
            fail("cc_t is not datatype uint8_t");
        }
    }

    @Test
    public void testClock_t() {
        assertTrue(clock_t__isSigned());
        if (JNHW__clock_t__IS__int32_t()) {
            assertEquals(PosixDataType.clock_t.baseDataType, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, clock_t__AS_Uint64_t());
        } else if (JNHW__clock_t__IS__int64_t()) {
            assertEquals(PosixDataType.clock_t.baseDataType, BaseDataType.int64_t);
            assertEquals(0x8000000080008080L, clock_t__AS_Uint64_t());
        } else {
            fail("clock_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testMode_t() {
        assertTrue(mode_t__isUnsigned());
        if (JNHW__mode_t__IS__uint16_t()) {
            assertEquals(PosixDataType.mode_t.baseDataType, BaseDataType.uint16_t);
            assertEquals(0x00008080L, mode_t__AS_Uint64_t());
        } else if (JNHW__mode_t__IS__uint32_t()) {
            assertEquals(PosixDataType.mode_t.baseDataType, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, mode_t__AS_Uint64_t());
        } else {
            fail("mode_t is not datatype uint16_t or uint32_t");
        }
    }

    @Test
    public void testOff_t() {
        assertTrue(off_t__isSigned());
        if (JNHW__off_t__IS__int32_t()) {
            assertEquals(PosixDataType.off_t.baseDataType, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, off_t__AS_Uint64_t());
        } else if (JNHW__off_t__IS__int64_t()) {
            assertEquals(PosixDataType.off_t.baseDataType, BaseDataType.int64_t);
            assertEquals(0x8000000080008080L, off_t__AS_Uint64_t());
        } else {
            fail("off_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testPid_t() {
        assertTrue(pid_t__isSigned());
        if (JNHW__pid_t__IS__int32_t()) {
            assertEquals(PosixDataType.pid_t.baseDataType, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, pid_t__AS_Uint64_t());
        } else {
            fail("pid_t is not datatype int32_t");
        }
    }

    @Test
    public void testSize_t() {
        assertTrue(size_t__isUnsigned());
        if (JNHW__size_t__IS__uint32_t()) {
            assertEquals(PosixDataType.size_t.baseDataType, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, size_t__AS_Uint64_t());
        } else if (JNHW__size_t__IS__uint64_t()) {
            assertEquals(PosixDataType.size_t.baseDataType, BaseDataType.uint64_t);
            assertEquals(0x8000000080008080L, size_t__AS_Uint64_t());
        } else {
            fail("size_t is not datatype uint32_t or uint64_t");
        }
    }

    @Test
    public void testSpeed_t() {
        assertTrue(speed_t__isUnsigned());
        if (JNHW__speed_t__IS__uint32_t()) {
            assertEquals(PosixDataType.speed_t.baseDataType, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, speed_t__AS_Uint64_t());
        } else {
            fail("speed_t is not datatype uint32_t");
        }
    }

    @Test
    public void testSsize_t() {
        assertTrue(ssize_t__isSigned());
        if (JNHW__ssize_t__IS__int32_t()) {
            assertEquals(PosixDataType.ssize_t.baseDataType, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, ssize_t__AS_Uint64_t());
        } else if (JNHW__ssize_t__IS__int64_t()) {
            assertEquals(PosixDataType.ssize_t.baseDataType, BaseDataType.int64_t);
            assertEquals(0x8000000080008080L, ssize_t__AS_Uint64_t());
        } else {
            fail("ssize_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testTcflag_t() {
        assertTrue(tcflag_t__isUnsigned());
        if (JNHW__tcflag_t__IS__uint32_t()) {
            assertEquals(PosixDataType.tcflag_t.baseDataType, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, tcflag_t__AS_Uint64_t());
        } else {
            fail("tcflag_t is not datatype uint32_t");
        }
    }

    @Test
    public void testTime_t() {
        assertTrue(time_t__isSigned());
        if (JNHW__time_t__IS__int32_t()) {
            assertEquals(PosixDataType.time_t.baseDataType, BaseDataType.int32_t);
            assertEquals(0xFFFFFFFF80008080L, time_t__AS_Uint64_t());
        } else if (JNHW__time_t__IS__int64_t()) {
            assertEquals(PosixDataType.time_t.baseDataType, BaseDataType.int64_t);
            assertEquals(0x8000000080008080L, time_t__AS_Uint64_t());
        } else {
            fail("time_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testUid_t() {
        assertTrue(uid_t__isUnsigned());
        if (JNHW__uid_t__IS__uint32_t()) {
            assertEquals(PosixDataType.uid_t.baseDataType, BaseDataType.uint32_t);
            assertEquals(0x0000000080008080L, uid_t__AS_Uint64_t());
        } else {
            fail("uid_t is not datatype uint32_t");
        }
    }

}
