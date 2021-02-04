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

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.linux.sys.Eventfd;
import de.ibapl.jnhw.posix.Aio;
import de.ibapl.jnhw.posix.Fcntl;
import de.ibapl.jnhw.posix.Locale;
import de.ibapl.jnhw.posix.Poll;
import de.ibapl.jnhw.posix.Pthread;
import de.ibapl.jnhw.posix.Sched;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.posix.Stdio;
import de.ibapl.jnhw.posix.StringHeader;
import de.ibapl.jnhw.posix.Termios;
import de.ibapl.jnhw.posix.Time;
import de.ibapl.jnhw.posix.Unistd;
import de.ibapl.jnhw.posix.sys.Stat;
import de.ibapl.jnhw.posix.sys.Types;
import de.ibapl.jnhw.unix.sys.Ioctl;
import de.ibapl.jnhw.x_open.Ucontext;
import java.lang.reflect.Field;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

/**
 * Test all symbolic constants XXX that are defined with #define XXX
 *
 * @author aploese
 */
public class DefinesTest {

    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    public static void testDefines(Class clazz) throws Exception {
        System.out.println(clazz.getName() + " Defines: >>>");
        for (Field f : clazz.getFields()) {
            final Define define = f.getAnnotation(Define.class);
            if (define != null) {
                Class type = f.getType();
                if (Long.class.equals(type) || long.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$016x | %2$d", f.getName(), f.getLong(clazz)));
                } else if (Integer.class.equals(type) || int.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$08x | %2$d", f.getName(), f.getInt(clazz)));
                } else if (Short.class.equals(type) || short.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$04x | %2$d", f.getName(), f.getShort(clazz)));
                } else if (Byte.class.equals(type) || byte.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$02x | %2$d", f.getName(), f.getByte(clazz)));
                } else if (IntDefine.class.equals(type)) {
                    IntDefine def = (IntDefine) f.get(clazz);
                    assertNotNull(def, clazz.getName() + "#" + f.getName());
                    if (def.isDefined()) {
                        System.out.println(String.format("\t%-30s = 0x%2$08x | %2$d", f.getName(), def.get()));
                    } else {
                        System.out.println(String.format("\t%-30s ... is not defined", f.getName()));
                    }
                } else {
                    System.out.println(String.format("\t%-30s = \"%s\"", f.getName(), f.get(clazz)));
                }
            }
        }
        System.out.println("<<< " + clazz.getName() + " Defines");
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testAioDefines() throws Exception {
        testDefines(Aio.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.LINUX)
    public void testEventfdDefines() throws Exception {
        testDefines(Eventfd.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testFcntlDefines() throws Exception {
        testDefines(Fcntl.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testIoctlDefines() throws Exception {
        testDefines(Ioctl.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testIsocErrnoDefines() throws Exception {
        testDefines(de.ibapl.jnhw.isoc.Errno.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testLocaleDefines() throws Exception {
        testDefines(Locale.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testPollDefines() throws Exception {
        testDefines(Poll.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testPthreadDefines() throws Exception {
        testDefines(Pthread.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testPosixErrnoDefines() throws Exception {
        testDefines(de.ibapl.jnhw.posix.Errno.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testSignalDefines() throws Exception {
        testDefines(Signal.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testSchedDefines() throws Exception {
        testDefines(Sched.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testStatDefines() throws Exception {
        testDefines(Stat.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testStdioDefines() throws Exception {
        testDefines(Stdio.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testStringHeaderDefines() throws Exception {
        testDefines(StringHeader.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testTermiosDefines() throws Exception {
        testDefines(Termios.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testTimeDefines() throws Exception {
        testDefines(Time.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testTypesDefines() throws Exception {
        testDefines(Types.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testUcontext() throws Exception {
        testDefines(Ucontext.class);
    }

    @Test
    public void testDefines() throws Exception {
        testDefines(Defines.class);
    }

    @Test
    @DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testUnistdDefines() throws Exception {
        testDefines(Unistd.class);
    }

    @Test
    public void test_HAVE_AIO_H() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
            case WINDOWS:
                Assertions.assertFalse(Aio.HAVE_AIO_H, "expected not to have aio.h");
                break;
            default:
                Assertions.assertTrue(Aio.HAVE_AIO_H, "expected to have aio.h");
        }
    }

    @Test
    public void test_HAVE_ERRNO_H() throws Exception {
        Assertions.assertTrue(de.ibapl.jnhw.isoc.Errno.HAVE_ERRNO_H, "expected to have errno.h");
    }

    @Test
    public void test_HAVE_FCNTL_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Fcntl.HAVE_FCNTL_H, "expected not to have fcntl.h");
        } else {
            Assertions.assertTrue(Fcntl.HAVE_FCNTL_H, "expected to have fcntl.h");
        }
    }

    @Test
    public void test_HAVE_LOCALE_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Locale.HAVE_LOCALE_H, "expected not to have locale.h");
        } else {
            Assertions.assertTrue(Locale.HAVE_LOCALE_H, "expected to have locale.h");
        }
    }

    @Test
    public void test_HAVE_POLL_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Poll.HAVE_POLL_H, "not expected to have poll.h");
        } else {
            Assertions.assertTrue(Poll.HAVE_POLL_H, "expected to have poll.h");
        }
    }

    @Test
    public void test_HAVE_PTHREAD_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Pthread.HAVE_PTHREAD_H, "not expected to have pthread.h");
        } else {
            Assertions.assertTrue(Pthread.HAVE_PTHREAD_H, "expected to have pthread.h");
        }
    }

    @Test
    public void test_HAVE_SCHED_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Sched.HAVE_SCHED_H, "not expected to have sched.h");
        } else {
            Assertions.assertTrue(Sched.HAVE_SCHED_H, "expected to have sched.h");
        }
    }

    @Test
    public void test_HAVE_SIGNAL_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Signal.HAVE_SIGNAL_H, "not expected to have signal.h");
        } else {
            Assertions.assertTrue(Signal.HAVE_SIGNAL_H, "expected to have signal.h");
        }
    }

    @Test
    public void test_HAVE_STDIO_H() {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            assertFalse(Stdio.HAVE_STDIO_H, "not expected to have stdio.h");
        } else {
            assertTrue(Stdio.HAVE_STDIO_H, "expected to have stdio.h");
        }
    }

    @Test
    public void test_HAVE_STRING_H() {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(StringHeader.HAVE_STRING_H, "not expected to have string.h");
        } else {
            assertTrue(StringHeader.HAVE_STRING_H, "expected to have string.h");
        }
    }

    @Test
    public void test_HAVE_SYS_EVENTFD_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.LINUX) {
            Assertions.assertTrue(Eventfd.HAVE_SYS_EVENTFD_H, "expected to have sys/eventfd.h");
        } else {
            Assertions.assertFalse(Eventfd.HAVE_SYS_EVENTFD_H, "not expected to have sys/eventfd.h");
        }
    }

    @Test
    public void test_HAVE_SYS_IOCTL_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            assertFalse(Ioctl.HAVE_SYS_IOCTL_H, "not expected to have sys/ioctl.h");
        } else {
            assertTrue(Ioctl.HAVE_SYS_IOCTL_H, "expected to have sys/ioctl.h");
        }
    }

    @Test
    public void test_HAVE_SYS_STAT_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Stat.HAVE_SYS_STAT_H, "not expected to have sys/stat.h");
        } else {
            Assertions.assertTrue(Stat.HAVE_SYS_STAT_H, "expected to have sys/stat.h");
        }
    }

    @Test
    public void test_HAVE_SYS_TYPES_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Types.HAVE_SYS_TYPES_H, "not expected to have sys/types.h");
        } else {
            Assertions.assertTrue(Types.HAVE_SYS_TYPES_H, "expected to have sys/types.h");
        }
    }

    @Test
    public void test_HAVE_TERMIOS_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            assertFalse(Termios.HAVE_TERMIOS_H, "not expected to have termios.h");
        } else {
            assertTrue(Termios.HAVE_TERMIOS_H, "expected to have termios.h");
        }
    }

    @Test
    public void test_HAVE_TIME_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            assertFalse(Time.HAVE_TIME_H, "not expected to have time.h");
        } else {
            assertTrue(Time.HAVE_TIME_H, "expected to have time.h");
        }
    }

    @Test
    public void test_HAVE_UCONTEXT_H() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case WINDOWS:
            case OPEN_BSD:
                assertFalse(Ucontext.HAVE_UCONTEXT_H, "not expected to have ucontext.h");
                break;
            default:
                assertTrue(Ucontext.HAVE_UCONTEXT_H, "expected to have ucontext.h");
        }
    }

    @Test
    public void test_HAVE_UNISTD_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Unistd.HAVE_UNISTD_H, "not expected to have unistd.h");
        } else {
            Assertions.assertTrue(Unistd.HAVE_UNISTD_H, "expected to have unistd.h");
        }
    }

    /**
     * Test of _LARGEFILE64_SOURCE method, of class Defines.
     */
    @Test
    public void test_LARGEFILE64_SOURCE() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (Defines.__SIZEOF_LONG__) {
                    case 4:
                        assertTrue(Defines._LARGEFILE64_SOURCE.get() != 0);
                        break;
                    case 8:
                        assertTrue(Defines._LARGEFILE64_SOURCE.get() != 0);
                        break;
                    default:
                        fail("no case for this size of long:" + Defines.__SIZEOF_LONG__);
                        break;
                }
                break;

            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
            case WINDOWS:
                assertFalse(Defines._LARGEFILE64_SOURCE.isDefined());
                break;
            default:
                fail("No testcase for OS: " + MULTIARCHTUPEL_BUILDER.getOS());
        }
    }

    /**
     * Test of _LARGEFILE_SOURCE method, of class Defines.
     */
    @Test
    public void test_LARGEFILE_SOURCE() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (Defines.__SIZEOF_LONG__) {
                    case 4:
                        assertTrue(Defines._LARGEFILE_SOURCE.get() != 0);
                        break;
                    case 8:
                        assertTrue(Defines._LARGEFILE_SOURCE.get() != 0);
                        break;
                    default:
                        fail("no case for this size of long:" + Defines.__SIZEOF_LONG__);
                        break;
                }
                break;

            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
            case WINDOWS:
                assertFalse(Defines._LARGEFILE_SOURCE.isDefined());
                break;
            default:
                fail("No testcase for OS: " + MULTIARCHTUPEL_BUILDER.getOS());
        }
    }

    /**
     * Test of _FILE_OFFSET_BITS method, of class Defines.
     */
    @Test
    public void test_FILE_OFFSET_BITS() throws Exception {
        assertFalse(Defines._FILE_OFFSET_BITS.isDefined());
    }

    /**
     * Test of _POSIX_C_SOURCE method, of class Defines.
     */
    @Test
    public void test_POSIX_C_SOURCE() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
                assertEquals(200809, Defines._POSIX_C_SOURCE.get());
                break;
            case WINDOWS:
                assertFalse(Defines._POSIX_C_SOURCE.isDefined());
                break;
            default:
                fail("No testcase for OS: " + MULTIARCHTUPEL_BUILDER.getOS());
        }
    }

    /**
     * Test of _XOPEN_SOURCE method, of class Defines.
     */
    @Test
    public void test_XOPEN_SOURCE() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
                assertEquals(700, Defines._XOPEN_SOURCE.get());
                break;
            case WINDOWS:
                assertFalse(Defines._XOPEN_SOURCE.isDefined());
                break;
            default:
                fail("No testcase for OS: " + MULTIARCHTUPEL_BUILDER.getOS());
        }
    }

    /**
     * Test of _XOPEN_SOURCE_EXTENDED method, of class Defines.
     */
    @Test
    public void test_XOPEN_SOURCE_EXTENDED() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
                assertEquals(1, Defines._XOPEN_SOURCE_EXTENDED.get());
                break;
            case WINDOWS:
                assertFalse(Defines._XOPEN_SOURCE_EXTENDED.isDefined());
                break;
            default:
                fail("No testcase for OS: " + MULTIARCHTUPEL_BUILDER.getOS());
        }
    }

    /**
     * Test of __APPLE__ method, of class Defines.
     */
    @Test
    public void test__APPLE__() {
        assertEquals(MULTIARCHTUPEL_BUILDER.getOS() == OS.MAC_OS_X, Defines.__APPLE__.isDefined());
    }

    /**
     * Test of __FreeBSD__ method, of class Defines.
     */
    @Test
    public void test__FreeBSD__() {
        assertEquals(MULTIARCHTUPEL_BUILDER.getOS() == OS.FREE_BSD, Defines.__FreeBSD__.isDefined());
    }

    /**
     * Test of __WORDSIZE method, of class Defines.
     */
    @Test
    public void test__WORDSIZE() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
            case WINDOWS:
                assertFalse(Defines.__WORDSIZE.isDefined());
                break;
            default:
                assertEquals(MULTIARCHTUPEL_BUILDER.getWordSize().sizeInBit, Defines.__WORDSIZE.get(), "wordsize");
        }
    }

    /**
     * Test of __linux__ method, of class Defines.
     */
    @Test
    public void test__linux__() {
        assertEquals(MULTIARCHTUPEL_BUILDER.getOS() == OS.LINUX, Defines.__linux__.isDefined());
    }

    @Test
    public void test__ORDER_LITTLE_ENDIAN__() throws Exception {
        assertEquals(1234, Defines.__ORDER_LITTLE_ENDIAN__);
    }

    @Test
    public void test__ORDER_BIG_ENDIAN__() throws Exception {
        assertEquals(4321, Defines.__ORDER_BIG_ENDIAN__);
    }

    @Test
    public void test__ORDER_PDP_ENDIAN__() throws Exception {
        assertEquals(3412, Defines.__ORDER_PDP_ENDIAN__);
    }

    @Test
    public void test__BYTE_ORDER__() throws Exception {
        assertEquals(1234, Defines.__ORDER_LITTLE_ENDIAN__);
        switch (MULTIARCHTUPEL_BUILDER.getEndianess()) {
            case BIG:
                assertEquals(Defines.__ORDER_BIG_ENDIAN__, Defines.__BYTE_ORDER__);
                break;
            case LITTLE:
                assertEquals(Defines.__ORDER_LITTLE_ENDIAN__, Defines.__BYTE_ORDER__);
                break;
        }
    }

    @Test
    public void test__GNU_LIBRARY__() throws Exception {
        if (Defines.__GNU_LIBRARY__.isDefined()) {
            assertTrue(Defines.__GLIBC__.isDefined(), "__GLIBC__");
            assertTrue(Defines.__GLIBC_MINOR__.isDefined(), "__GLIBC_MINOR__");
            assertEquals(MULTIARCHTUPEL_BUILDER.getWordSize().sizeInBit, Defines.__WORDSIZE.get());
            //assertEquals(new MultiarchTupelBuilder().getWordSize().sizeInBit, Defines.__TIMESIZE());
        }
    }

}
