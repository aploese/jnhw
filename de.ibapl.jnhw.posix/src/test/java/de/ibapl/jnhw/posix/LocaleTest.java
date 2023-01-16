/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.Defines;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.lang.foreign.MemorySession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class LocaleTest {

    @Test
    public static void testSizeof__locale_t() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertTrue(LibJnhwPosixTestLoader.invoke_sI___V("sizeof__locale_t") > Defines.__SIZEOF_POINTER__, "sizeof locale_t must be >= sizeof uintptr_t");
        DefinesTest.testDefines(Locale.class, "HAVE_LOCALE_H");
    }

    @BeforeAll
    public static void checkBeforeAll_HAVE_LOCALE_H() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Locale.HAVE_LOCALE_H, "not expected to have locale.h");
        } else {
            Assertions.assertTrue(Locale.HAVE_LOCALE_H, "expected to have locale.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_LocaleDefines() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Locale.class, "HAVE_LOCALE_H", (name) -> {
            return switch (name) {
                case "LC_GLOBAL_LOCALE" ->
                    Locale.Locale_t.of(LibJnhwPosixTestLoader.getAdrDefine(name));
                default ->
                    throw new AssertionError();
            };
        });
    }

    @BeforeAll
    public static void checkBeforeAll_lconv_t() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_sizeof"), Locale.Lconv.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_alignof"), Locale.Lconv.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_currency_symbol"), Locale.Lconv.offsetof_Currency_symbol, "offsetof_Currency_symbol");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_decimal_point"), Locale.Lconv.offsetof_Decimal_point, "offsetof_Decimal_point");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_frac_digits"), Locale.Lconv.offsetof_Frac_digits, "offsetof_Frac_digits");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_grouping"), Locale.Lconv.offsetof_Grouping, "offsetof_Grouping");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_int_curr_symbol"), Locale.Lconv.offsetof_Int_curr_symbol, "offsetof_Int_curr_symbol");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_int_frac_digits"), Locale.Lconv.offsetof_Int_frac_digits, "offsetof_Int_frac_digits");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_int_n_cs_precedes"), Locale.Lconv.offsetof_Int_n_cs_precedes, "offsetof_Int_n_cs_precedes");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_int_n_sep_by_space"), Locale.Lconv.offsetof_Int_n_sep_by_space, "offsetof_Int_n_sep_by_space");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_int_n_sign_posn"), Locale.Lconv.offsetof_Int_n_sign_posn, "offsetof_Int_n_sign_posn");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_int_p_cs_precedes"), Locale.Lconv.offsetof_Int_p_cs_precedes, "offsetof_Int_p_cs_precedes");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_int_p_sep_by_space"), Locale.Lconv.offsetof_Int_p_sep_by_space, "offsetof_Int_p_sep_by_space");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_int_p_sign_posn"), Locale.Lconv.offsetof_Int_p_sign_posn, "offsetof_Int_p_sign_posn");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_mon_decimal_point"), Locale.Lconv.offsetof_Mon_decimal_point, "offsetof_Mon_decimal_point");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_mon_grouping"), Locale.Lconv.offsetof_Mon_grouping, "offsetof_Mon_grouping");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_mon_thousands_sep"), Locale.Lconv.offsetof_Mon_thousands_sep, "offsetof_Mon_thousands_sep");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_n_cs_precedes"), Locale.Lconv.offsetof_N_cs_precedes, "offsetof_N_cs_precedes");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_n_sep_by_space"), Locale.Lconv.offsetof_N_sep_by_space, "offsetof_N_sep_by_space");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_n_sign_posn"), Locale.Lconv.offsetof_N_sign_posn, "offsetof_N_sign_posn");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_negative_sign"), Locale.Lconv.offsetof_Negative_sign, "offsetof_Negative_sign");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_p_cs_precedes"), Locale.Lconv.offsetof_P_cs_precedes, "offsetof_P_cs_precedes");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_p_sep_by_space"), Locale.Lconv.offsetof_P_sep_by_space, "offsetof_P_sep_by_space");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_p_sign_posn"), Locale.Lconv.offsetof_P_sign_posn, "offsetof_P_sign_posn");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_positive_sign"), Locale.Lconv.offsetof_Positive_sign, "offsetof_Positive_sign");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("lconv_t_offsetof_thousands_sep"), Locale.Lconv.offsetof_Thousands_sep, "offsetof_Thousands_sep");
                }
        );
    }

    private MemorySession ms;

    @BeforeEach
    public void setUp() throws Exception {
        ms = MemorySession.openConfined();
    }

    @AfterEach
    public void tearDown() throws Exception {
        ms.close();
    }

    /**
     * Test of native create ans wrap of class Locale.Locale_t.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testUnwrapLC_GLOBAL_LOCALE() throws Exception {
        System.out.println("testUnwrapLC_GLOBAL_LOCALE");
        Assertions.assertTrue(LibJnhwPosixTestLoader.invokeExact_CharToBool_Adr("test_LC_GLOBAL_LOCALE_equals", Locale.LC_GLOBAL_LOCALE.toAddressable()), "Natively not the same LC_GLOBAL_LOCALE");
    }

    /**
     * Test of duplocale method, of class Locale.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDuplocale() throws Exception {
        System.out.println("duplocale");
        Locale.Locale_t locobj = Locale.LC_GLOBAL_LOCALE;
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
        Locale.Lconv result = Locale.localeconv(ms);
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
            Locale.newlocale(Locale.LC_NUMERIC_MASK, "", Locale.LC_GLOBAL_LOCALE);
        });
    }

    /**
     * Test of newlocale method, of class Locale.
     */
    @Test
    public void testNewlocale_null() throws Exception {
        System.out.println("newlocale locale == null");
        Locale.Locale_t locale = Locale.duplocale(Locale.LC_GLOBAL_LOCALE);
        try {
            Assertions.assertThrows(NullPointerException.class, () -> {
                Locale.newlocale(Locale.LC_NUMERIC_MASK, null, locale);
            });
        } finally {
            Locale.freelocale(locale);
        }
        System.out.println("newlocale base == null");
        Assertions.assertThrows(NullPointerException.class, () -> {
            Locale.newlocale(Locale.LC_NUMERIC_MASK, "", null);
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
        final int category_mask = Locale.LC_NUMERIC_MASK;
        final String locale = "C";
        final Locale.Locale_t base = Locale.Locale_t.LOCALE_T_0;
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
        String result = Locale.setlocale(category, null);
        Assertions.assertNotNull(result);
        result = Locale.setlocale(category, "C");
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
        Locale.Locale_t newloc = Locale.LC_GLOBAL_LOCALE;
        Locale.Locale_t result = Locale.uselocale(newloc);
        Assertions.assertNotNull(result);
        Assertions.assertNotEquals(Locale.Locale_t.LOCALE_T_0, result);
    }

}
