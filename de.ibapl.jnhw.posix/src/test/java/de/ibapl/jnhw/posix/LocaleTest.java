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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.NoSuchNativeMethodException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class LocaleTest {

    private static MultiarchTupelBuilder multiarchTupelBuilder;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        multiarchTupelBuilder = new MultiarchTupelBuilder();
        LibJnhwPosixTestLoader.touch();
    }

    public LocaleTest() {
    }

    private native long nativeLocale_t(long value);

    private native void testNativelyLC_GLOBAL_LOCALE(Locale.Locale_t value);

    /**
     * Test of native create ans wrap of class Locale.Locale_t.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testUnwrapLC_GLOBAL_LOCALE() throws Exception {
        System.out.println("testUnwrapLC_GLOBAL_LOCALE");
        if (multiarchTupelBuilder.getOS() == OS.MAC_OS_X) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                testNativelyLC_GLOBAL_LOCALE(Locale.LC_GLOBAL_LOCALE());
            });

        } else {
            testNativelyLC_GLOBAL_LOCALE(Locale.LC_GLOBAL_LOCALE());
        }
    }

    /**
     * Test of native create ans wrap of class Locale.Locale_t.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testLocale_t() throws Exception {
        System.out.println("testLocale_t");
        if (multiarchTupelBuilder.getOS() == OS.MAC_OS_X) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                nativeLocale_t(0);
            });

        } else {
        Assertions.assertEquals(0, nativeLocale_t(0));
        Assertions.assertEquals(1, nativeLocale_t(1));
            Assertions.assertEquals(-1, nativeLocale_t(-1));
        }
    }

    /**
     * Test of duplocale method, of class Locale.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDuplocale() throws Exception {
        System.out.println("duplocale");
        Locale.Locale_t locobj = Locale.LC_GLOBAL_LOCALE();
        try {
            Locale.Locale_t result = Locale.duplocale(locobj);
            Assertions.assertNotNull(result);
            Locale.freelocale(result);
        } catch (NativeErrorException nee) {
            fail(nee.getMessage() + " errno: " + Errno.getErrnoSymbol(nee.errno));
        }
    }

    /**
     * Test of localeconv method, of class Locale.
     */
    @Test
    public void testLocaleconv() {
        System.out.println("localeconv");
        Locale.Lconv result = Locale.localeconv();
        Assertions.assertNotNull(result);
        System.out.println("localeconv: " + result);
    }

    /**
     * Test of newlocale method, of class Locale.
     */
    @Test
    public void testNewlocale_LC_GLOBAL_LOCALE() {
        System.out.println("newlocale LC_GLOBAL_LOCALE");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Locale.newlocale(Locale.LC_NUMERIC_MASK(), "", Locale.LC_GLOBAL_LOCALE());
        });
    }

    /**
     * Test of newlocale method, of class Locale.
     */
    @Test
    public void testNewlocale_null() {
        System.out.println("newlocale locale == null");
        Assertions.assertThrows(NullPointerException.class, () -> {
            Locale.newlocale(Locale.LC_NUMERIC_MASK(), null, Locale.LC_GLOBAL_LOCALE());
        });
        System.out.println("newlocale base == null");
        Assertions.assertThrows(NullPointerException.class, () -> {
            Locale.newlocale(Locale.LC_NUMERIC_MASK(), "", null);
        });
    }

    /**
     * Test of newlocale method, of class Locale.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testNewlocale_AND_Freelocale() throws Exception {
        System.out.println("newlocale");
        final int category_mask = Locale.LC_NUMERIC_MASK();
        final String locale = "C";
        final Locale.Locale_t base = Locale.Locale_t.locale_t_0();
        final Locale.Locale_t result = Locale.newlocale(category_mask, locale, base);
        Assertions.assertNotNull(result);
        Locale.freelocale(result);
    }

    /**
     * Test of setlocale method, of class Locale.
     */
    @Test
    public void testSetlocale() {
        System.out.println("setlocale");
        int category = 0;
        String locale = "";
        String result = Locale.setlocale(category, locale);
        Assertions.assertNotNull(result);
    }

    /**
     * Test of uselocale method, of class Locale.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testUselocale_AND_freelocale() throws Exception {
        System.out.println("uselocale");
        Locale.Locale_t newloc = Locale.LC_GLOBAL_LOCALE();
        Locale.Locale_t result = Locale.uselocale(newloc);
        Assertions.assertNotNull(result);
            Assertions.assertNotEquals(Locale.Locale_t.locale_t_0(), result);
    }

}
