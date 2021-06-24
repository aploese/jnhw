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

/**
 * Test all symbolic constants XXX that are defined with #define XXX
 *
 * @author aploese
 */
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

    static {
        LibJnhwPosixTestLoader.touch();
    }

    @Test
    public void testCc_t() {
        if (JNHW__cc_t__IS__uint8_t()) {
            assertEquals(PosixDataType.cc_t.baseDataType, BaseDataType.uint8_t);
        } else {
            fail("cc_t is not datatype uint8_t");
        }
    }

    @Test
    public void testClock_t() {
        if (JNHW__clock_t__IS__int32_t()) {
            assertEquals(PosixDataType.clock_t.baseDataType, BaseDataType.int32_t);
        } else if (JNHW__clock_t__IS__int64_t()) {
            assertEquals(PosixDataType.clock_t.baseDataType, BaseDataType.int64_t);
        } else {
            fail("clock_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testMode_t() {
        if (JNHW__mode_t__IS__uint16_t()) {
            assertEquals(PosixDataType.mode_t.baseDataType, BaseDataType.uint16_t);
        } else if (JNHW__mode_t__IS__uint32_t()) {
            assertEquals(PosixDataType.mode_t.baseDataType, BaseDataType.uint32_t);
        } else {
            fail("mode_t is not datatype uint16_t or uint32_t");
        }
    }

    @Test
    public void testOff_t() {
        if (JNHW__off_t__IS__int32_t()) {
            assertEquals(PosixDataType.off_t.baseDataType, BaseDataType.int32_t);
        } else if (JNHW__off_t__IS__int64_t()) {
            assertEquals(PosixDataType.off_t.baseDataType, BaseDataType.int64_t);
        } else {
            fail("off_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testPid_t() {
        if (JNHW__pid_t__IS__int32_t()) {
            assertEquals(PosixDataType.pid_t.baseDataType, BaseDataType.int32_t);
        } else {
            fail("pid_t is not datatype int32_t");
        }
    }

    @Test
    public void testSize_t() {
        if (JNHW__size_t__IS__uint32_t()) {
            assertEquals(PosixDataType.size_t.baseDataType, BaseDataType.uint32_t);
        } else if (JNHW__size_t__IS__uint64_t()) {
            assertEquals(PosixDataType.size_t.baseDataType, BaseDataType.uint64_t);
        } else {
            fail("size_t is not datatype uint32_t or uint64_t");
        }
    }

    @Test
    public void testSpeed_t() {
        if (JNHW__speed_t__IS__uint32_t()) {
            assertEquals(PosixDataType.speed_t.baseDataType, BaseDataType.uint32_t);
        } else {
            fail("speed_t is not datatype uint32_t");
        }
    }

    @Test
    public void testSsize_t() {
        if (JNHW__ssize_t__IS__int32_t()) {
            assertEquals(PosixDataType.ssize_t.baseDataType, BaseDataType.int32_t);
        } else if (JNHW__ssize_t__IS__int64_t()) {
            assertEquals(PosixDataType.ssize_t.baseDataType, BaseDataType.int64_t);
        } else {
            fail("ssize_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testTcflag_t() {
        if (JNHW__tcflag_t__IS__uint32_t()) {
            assertEquals(PosixDataType.tcflag_t.baseDataType, BaseDataType.uint32_t);
        } else {
            fail("tcflag_t is not datatype uint32_t");
        }
    }

    @Test
    public void testTime_t() {
        if (JNHW__time_t__IS__int32_t()) {
            assertEquals(PosixDataType.time_t.baseDataType, BaseDataType.int32_t);
        } else if (JNHW__time_t__IS__int64_t()) {
            assertEquals(PosixDataType.time_t.baseDataType, BaseDataType.int64_t);
        } else {
            fail("time_t is not datatype int32_t or int64_t");
        }
    }

    @Test
    public void testUid_t() {
        if (JNHW__uid_t__IS__uint32_t()) {
            assertEquals(PosixDataType.uid_t.baseDataType, BaseDataType.uint32_t);
        } else {
            fail("uid_t is not datatype uint32_t");
        }
    }

}
