/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Defined;
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.linux.sys.Eventfd;
import de.ibapl.jnhw.posix.Aio;
import de.ibapl.jnhw.posix.Fcntl;
import de.ibapl.jnhw.posix.Locale;
import de.ibapl.jnhw.posix.Poll;
import de.ibapl.jnhw.posix.Pthread;
import de.ibapl.jnhw.posix.Signal;
import de.ibapl.jnhw.posix.Stdio;
import de.ibapl.jnhw.posix.StringHeader;
import de.ibapl.jnhw.posix.Termios;
import de.ibapl.jnhw.posix.Time;
import de.ibapl.jnhw.posix.Unistd;
import de.ibapl.jnhw.posix.sys.Stat;
import de.ibapl.jnhw.posix.sys.Types;
import de.ibapl.jnhw.unix.sys.Ioctl;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

/**
 * Test all symbolic constants XXX that are defined with #define XXX
 *
 * @author aploese
 */
public class DefinesTest {

    private static MultiarchTupelBuilder multiarchTupelBuilder;

    @BeforeAll
    public static void setUpClass() {
        multiarchTupelBuilder = new MultiarchTupelBuilder();
    }

    public static void testDefines(Class clazz) throws Exception {
        System.out.println(clazz.getName() + " Defines: ");
        for (Method m : clazz.getMethods()) {
            final Class<?> exceptionTypes[] = m.getExceptionTypes();
            try {
                final Define define = m.getAnnotation(Define.class);
                if (define != null) {
                    System.out.println("\t" + m.getName() + " = " + m.invoke(clazz));
                }
            } catch (InvocationTargetException ite) {
                if (ite.getTargetException() instanceof NotDefinedException) {
                    boolean found = false;
                    for (Class<?> et : exceptionTypes) {
                        if (et == NotDefinedException.class) {
                            found = true;
                            break;
                        }
                        if (found) {
                            System.out.println("\t" + m.getName() + " NOT DEFINED!");
                        } else {
                            Assertions.fail("Name: " + m.getName() + " throws NotDefinedException but dont declare it" + ite.getTargetException());
                        }
                    }
                } else {
                    Assertions.fail("Name: " + m.getName() + " throws InvocationTargetException: " + ite.getTargetException());
                }
            } catch (Throwable t) {
                Assertions.fail("Name: " + m.getName() + " throws unknown exception: " + t);
            }
        }
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
    public void testUnistdDefines() throws Exception {
        testDefines(Unistd.class);
    }

    @Test
    public void test_HAVE_AIO_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Aio.HAVE_AIO_H(), "expected not to have aio.h");
        } else {
            Assertions.assertTrue(Aio.HAVE_AIO_H(), "expected to have aio.h");
        }
    }

    @Test
    public void test_HAVE_ERRNO_H() throws Exception {
        Assertions.assertTrue(de.ibapl.jnhw.isoc.Errno.HAVE_ERRNO_H(), "expected to have errno.h");
    }

    @Test
    public void test_HAVE_FCNTL_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Fcntl.HAVE_FCNTL_H(), "expected not to have fcntl.h");
        } else {
            Assertions.assertTrue(Fcntl.HAVE_FCNTL_H(), "expected to have fcntl.h");
        }
    }

    @Test
    public void test_HAVE_LOCALE_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Locale.HAVE_LOCALE_H(), "expected not to have locale.h");
        } else {
            Assertions.assertTrue(Locale.HAVE_LOCALE_H(), "expected to have locale.h");
        }
    }

    @Test
    public void test_HAVE_POLL_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Poll.HAVE_POLL_H(), "not expected to have poll.h");
        } else {
            Assertions.assertTrue(Poll.HAVE_POLL_H(), "expected to have poll.h");
        }
    }

    @Test
    public void test_HAVE_PTHREAD_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Pthread.HAVE_PTHREAD_H(), "not expected to have pthread.h");
        } else {
            Assertions.assertTrue(Pthread.HAVE_PTHREAD_H(), "expected to have pthread.h");
        }
    }

    @Test
    public void test_HAVE_SIGNAL_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Signal.HAVE_SIGNAL_H(), "not expected to have signal.h");
        } else {
            Assertions.assertTrue(Signal.HAVE_SIGNAL_H(), "expected to have signal.h");
        }
    }

    @Test
    public void test_HAVE_STDIO_H() {
        System.out.println("HAVE_STDIO_H");
        assertTrue(Stdio.HAVE_STDIO_H(), "expected to have stdio.h");
    }

    @Test
    public void test_HAVE_STRING_H() {
        System.out.println("HAVE_STRING_H");
        assertTrue(StringHeader.HAVE_STRING_H(), "expected to have string.h");
    }

    @Test
    public void test_HAVE_SYS_EVENTFD_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.LINUX) {
            Assertions.assertTrue(Eventfd.HAVE_SYS_EVENTFD_H(), "expected to have sys/eventfd.h");
        } else {
            Assertions.assertFalse(Eventfd.HAVE_SYS_EVENTFD_H(), "not expected to have sys/eventfd.h");
        }
    }

    @Test
    public void test_HAVE_SYS_IOCTL_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            assertFalse(Ioctl.HAVE_SYS_IOCTL_H(), "not expected to have sys/ioctl.h");
        } else {
            assertTrue(Ioctl.HAVE_SYS_IOCTL_H(), "expected to have sys/ioctl.h");
        }
    }

    @Test
    public void test_HAVE_SYS_STAT_H() throws Exception {
        Assertions.assertTrue(Stat.HAVE_SYS_STAT_H(), "expected to have sys/stat.h");
    }

    @Test
    public void test_HAVE_SYS_TYPES_H() throws Exception {
        Assertions.assertTrue(Types.HAVE_SYS_TYPES_H(), "expected to have sys/types.h");
    }

    @Test
    public void test_HAVE_TERMIOS_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            assertFalse(Termios.HAVE_TERMIOS_H(), "not expected to have termios.h");
        } else {
            assertTrue(Termios.HAVE_TERMIOS_H(), "expected to have termios.h");
        }
    }

    @Test
    public void test_HAVE_TIME_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            assertFalse(Time.HAVE_TIME_H(), "not expected to have time.h");
        } else {
            assertTrue(Time.HAVE_TIME_H(), "expected to have time.h");
        }
    }

    @Test
    public void test_HAVE_UNISTD_H() throws Exception {
        Assertions.assertTrue(Unistd.HAVE_UNISTD_H(), "expected to have unistd.h");
    }

    /**
     * Test of _LARGEFILE64_SOURCE method, of class Defines.
     */
    @Test
    public void test_LARGEFILE64_SOURCE() {
        System.out.println("_LARGEFILE64_SOURCE");
        switch (multiarchTupelBuilder.getOS()) {
            case LINUX:
                switch (Defines.__WORDSIZE()) {
                    case 32:
                        assertTrue(Defines._LARGEFILE64_SOURCE());
                        break;
                    case 64:
                        assertTrue(Defines._LARGEFILE64_SOURCE());
                        break;
                    default:
                        fail("no case for this wordsize:" + Defines.__WORDSIZE());
                        break;
                }
                break;

            case FREE_BSD:
                assertFalse(Defines._LARGEFILE64_SOURCE());
                break;
            case MAC_OS_X:
                assertFalse(Defines._LARGEFILE64_SOURCE());
                break;
            case WINDOWS:
                assertFalse(Defines._LARGEFILE64_SOURCE());
                break;
            default:
                fail("No testcase for OS: " + multiarchTupelBuilder.getOS());
        }
    }

    /**
     * Test of __APPLE__ method, of class Defines.
     */
    @Test
    public void test__APPLE__() {
        System.out.println("__APPLE__");
        assertEquals(multiarchTupelBuilder.getOS() == OS.MAC_OS_X, Defines.__APPLE__());
    }

    /**
     * Test of __FreeBSD__ method, of class Defines.
     */
    @Test
    public void test__FreeBSD__() {
        System.out.println("__FreeBSD__");
        assertEquals(multiarchTupelBuilder.getOS() == OS.FREE_BSD, Defined.defined(Defines::__FreeBSD__));
    }

    /**
     * Test of __WORDSIZE method, of class Defines.
     */
    @Test
    public void test__WORDSIZE() {
        System.out.println("__WORDSIZE");
        for (MultiarchInfo mi : new MultiarchTupelBuilder().guessMultiarch()) {
            if (mi.getOS() == OS.WINDOWS) {
                assertThrows(NotDefinedException.class, () -> {
                    Defines.__WORDSIZE();
                });
            } else {
                assertEquals(mi.getWordSize(), Defines.__WORDSIZE(), "wordsize");
            }
        }
    }

    /**
     * Test of __linux__ method, of class Defines.
     */
    @Test
    public void test__linux__() {
        System.out.println("__linux__");
        assertEquals(multiarchTupelBuilder.getOS() == OS.LINUX, Defines.__linux__());
    }

}
