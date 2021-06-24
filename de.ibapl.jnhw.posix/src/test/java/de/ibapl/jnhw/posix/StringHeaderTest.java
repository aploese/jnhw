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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.DefinesTest;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class StringHeaderTest {

    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    public static class NativeDefines {

        public final static native boolean HAVE_STRING_H();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    @BeforeAll
    public static void checkBeforeAll_HAVE_STRING_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(StringHeader.HAVE_STRING_H, "not expected to have string.h");
        } else {
            Assertions.assertTrue(StringHeader.HAVE_STRING_H, "expected to have string.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_StdioDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(StringHeader.class, NativeDefines.class, "HAVE_STRING_H");
    }

    /**
     * Test of strerror method, of class StringHeader.
     */
    @Test
    public void testStrerror() throws Exception {
        System.out.println("strerror");

        //Fallback to "C" locale so that the test can succeed on any machine
        final Locale.Locale_t locale = Locale.newlocale(Locale.LC_ALL_MASK, "C", Locale.Locale_t.locale_t_0());
        final Locale.Locale_t oldLocale = Locale.uselocale(locale);
        try {
            assertEquals("Invalid argument", StringHeader.strerror(Errno.EINVAL));
            switch (MULTIARCHTUPEL_BUILDER.getOS()) {
                case FREE_BSD:
                    assertEquals("No error: 0", StringHeader.strerror(0));
                    assertEquals("Unknown error: 2147483647", StringHeader.strerror(Integer.MAX_VALUE));
                    assertEquals("Unknown error: -1", StringHeader.strerror(-1));
                    break;
                case OPEN_BSD:
                case MAC_OS_X:
                    assertEquals("Undefined error: 0", StringHeader.strerror(0));
                    assertEquals("Unknown error: 2147483647", StringHeader.strerror(Integer.MAX_VALUE));
                    assertEquals("Unknown error: -1", StringHeader.strerror(-1));
                    break;
                default:
                    assertEquals("Success", StringHeader.strerror(0));
                    assertEquals("Unknown error 2147483647", StringHeader.strerror(Integer.MAX_VALUE));
                    assertEquals("Unknown error -1", StringHeader.strerror(-1));
            }
        } finally {
            Locale.uselocale(oldLocale);
        }
    }

    /**
     * Test of strerror_l method, of class StringHeader.
     */
    @Test
    public void testStrerror_l() throws Exception {
        System.out.println("strerror_l");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case FREE_BSD:
            case MAC_OS_X:
                assertThrows(NoSuchNativeMethodException.class, () -> {
                    StringHeader.strerror_l(Errno.EAGAIN, Locale.Locale_t.locale_t_0());
                });
                break;
            default:
                assertThrows(NullPointerException.class, () -> {
                    StringHeader.strerror_l(Errno.EAGAIN, null);
                });
                //Use "C" locale so that the test can succeed on any machine
                final Locale.Locale_t locale = Locale.newlocale(Locale.LC_ALL_MASK, "C", Locale.Locale_t.locale_t_0());
                assertEquals("Resource temporarily unavailable", StringHeader.strerror_l(Errno.EAGAIN, locale));
        }
    }

    /**
     * Test of strsignal method, of class StringHeader.
     */
    @Test
    public void testStrsignal() throws Exception {
        System.out.println("strsignal");

        //Fallback to "C" locale so that the test can succeed on any machine
        final Locale.Locale_t locale = Locale.newlocale(Locale.LC_ALL_MASK, "C", Locale.Locale_t.locale_t_0());
        final Locale.Locale_t oldLocale = Locale.uselocale(locale);
        try {
            switch (MULTIARCHTUPEL_BUILDER.getOS()) {
                case FREE_BSD:
                    assertEquals("Segmentation fault", StringHeader.strsignal(Signal.SIGSEGV));
                    assertEquals("Unknown signal: 2147483647", StringHeader.strsignal(Integer.MAX_VALUE));
                    assertEquals("Unknown signal: 0", StringHeader.strsignal(0));
                    assertEquals("Unknown signal: -1", StringHeader.strsignal(-1));
                    break;
                case OPEN_BSD:
                    assertEquals("Segmentation fault", StringHeader.strsignal(Signal.SIGSEGV));
                    assertEquals("Unknown signal: 2147483647", StringHeader.strsignal(Integer.MAX_VALUE));
                    assertEquals("Signal 0", StringHeader.strsignal(0));
                    assertEquals("Unknown signal: 4294967295", StringHeader.strsignal(-1));
                    break;
                case MAC_OS_X:
                    assertEquals("Segmentation fault: 11", StringHeader.strsignal(Signal.SIGSEGV));
                    assertEquals("Unknown signal: 2147483647", StringHeader.strsignal(Integer.MAX_VALUE));
                    assertEquals("Unknown signal: 0", StringHeader.strsignal(0));
                    assertEquals("Unknown signal: -1", StringHeader.strsignal(-1));
                    break;
                default:
                    assertEquals("Segmentation fault", StringHeader.strsignal(Signal.SIGSEGV));
                    assertEquals("Unknown signal 2147483647", StringHeader.strsignal(Integer.MAX_VALUE));
                    assertEquals("Unknown signal 0", StringHeader.strsignal(0));
                    assertEquals("Unknown signal -1", StringHeader.strsignal(-1));
            }
        } finally {
            Locale.uselocale(oldLocale);
        }
    }

}
