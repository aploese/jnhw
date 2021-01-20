/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.annotations.AlignOf;
import de.ibapl.jnhw.common.annotations.Define;
import de.ibapl.jnhw.common.annotations.Include;
import de.ibapl.jnhw.common.annotations.SizeOf;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.exceptions.NativeErrorException;
import de.ibapl.jnhw.common.exceptions.NotDefinedException;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

/**
 * Wrapper around the {@code <aio.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/locale.h.html">locale.h
 * - category macros</a>.
 *
 * @author aploese
 */
@Include("#include <locale.h>")
public class Locale {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_LOCALE_H();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_ALL.
     */
    @Define()
    public final static native int LC_ALL();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_ALL_MASK.
     * @throws NotDefinedException if LC_ALL_MASK is not defined natively.
     */
    @Define()
    public final static native int LC_ALL_MASK() throws NotDefinedException;

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_COLLATE.
     */
    @Define()
    public final static native int LC_COLLATE();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_COLLATE_MASK.
     */
    @Define()
    public final static native int LC_COLLATE_MASK();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_CTYPE.
     */
    @Define()
    public final static native int LC_CTYPE();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_CTYPE_MASK.
     */
    @Define()
    public final static native int LC_CTYPE_MASK();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_GLOBAL_LOCALE.
     */
    @Define()
    public final static native Locale_t LC_GLOBAL_LOCALE();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_MESSAGES.
     */
    @Define()
    public final static native int LC_MESSAGES();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_MESSAGES_MASK.
     */
    @Define()
    public final static native int LC_MESSAGES_MASK();

    /**
     * The LC_MONETARY category shall define the rules and symbols that are used
     * to format monetary numeric information.
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
     *
     * @return the native symbolic constant of LC_MONETARY.
     */
    @Define()
    public final static native int LC_MONETARY();

    /**
     * The LC_MONETARY category shall define the rules and symbols that are used
     * to format monetary numeric information.
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
     *
     * @return the native symbolic constant of LC_MONETARY_MASK.
     */
    @Define()
    public final static native int LC_MONETARY_MASK();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_NUMERIC.
     */
    @Define()
    public final static native int LC_NUMERIC();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_NUMERIC_MASK.
     */
    @Define()
    public final static native int LC_NUMERIC_MASK();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_TIME.
     */
    @Define()
    public final static native int LC_TIME();

    /**
     * <b>POSIX:</b> XXX
     *
     * @return the native symbolic constant of LC_TIME_MASK.
     */
    @Define()
    public final static native int LC_TIME_MASK();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/duplocale.html">duplocale
     * - duplicate a locale object</a>.
     *
     *
     * @param locobj a valid locale object handle.
     * @return a copy of {@code locobj}
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native Locale_t duplocale(Locale_t locobj) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/freelocale.html">freelocale
     * - free resources allocated for a locale object</a>.
     *
     * @param locobj a valid locale object handle.
     *
     */
    public final static native void freelocale(Locale_t locobj);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/localeconv.html">localeconv
     * - return locale-specific information</a>.
     *
     *
     * @return The localeconv() function shall return a pointer to the filled-in
     * object.
     */
    public final static native Lconv localeconv();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/newlocale.html">newlocale
     * - create or modify a locale object</a>.
     *
     *
     * @param category_mask the locale categories to be set or modified.
     * @param locale the locale from which the data specified in category_mask
     * is taken.
     * @param base the base locale object handle to be used.
     * @return on successful completion, a valid locale object handle.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native Locale_t newlocale(int category_mask, String locale, Locale_t base) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/setlocale.html">setlocale
     * - set program locale</a>.
     *
     * @param category the category to set.
     * @param locale the locale to use for the given {@code category}
     * @return on successful completion, the string associated with the
     * specified category for the new locale. otherwise {@code null}
     */
    public final static native String setlocale(int category, String locale);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/uselocale.html">uselocale
     * - use locale in current thread</a>.
     *
     *
     * @param newloc the new thread-local locale to set. If 0 nothing will be
     * changed, but the current locale is returned.
     * @return a handle for the thread-local locale that was in use as the
     * current locale for the calling thread on entry to the function, or
     * LC_GLOBAL_LOCALE if no thread-local locale was in use.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native Locale_t uselocale(Locale_t newloc) throws NativeErrorException;

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/locale.h.html">{@code structure
     * lconv}</a>.
     *
     */
    public static final class Lconv extends Struct32 {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct lconv natively.
         *
         * @return the native value sizeof(struct lconv).
         */
        @SizeOf
        public static native int sizeof();

        /**
         * Get the alignment of struct lconv natively.
         *
         * @return the native value __alignof__(struct lconv).
         */
        @AlignOf
        public static native int alignof();

        public Lconv() {
            super(sizeof(), false);
        }

        /**
         * To be called only from native code ...
         *
         * @param addressHolder
         * @param size
         */
        private Lconv(NativeAddressHolder addressHolder, int size) {
            super(addressHolder, size);
        }

        @Override
        public String nativeToString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{currency_symbol : \"").append(currency_symbol());
            sb.append("\", decimal_point : \"").append(decimal_point());
            sb.append("\", frac_digits : ").append(frac_digits());
            sb.append(", grouping : \"").append(grouping());
            sb.append("\", int_curr_symbol : \"").append(int_curr_symbol());
            sb.append("\", int_frac_digits : ").append(int_frac_digits());
            sb.append(", int_n_cs_precedes : ").append(int_n_cs_precedes());
            sb.append(", int_n_sep_by_space : ").append(int_n_sep_by_space());
            sb.append(", int_n_sign_posn : ").append(int_n_sign_posn());
            sb.append(", int_p_cs_precedes : ").append(int_p_cs_precedes());
            sb.append(", int_p_sep_by_space :").append(int_p_sep_by_space());
            sb.append(", int_p_sign_posn : ").append(int_p_sign_posn());
            sb.append("\", mon_decimal_point : \"").append(mon_decimal_point());
            sb.append("\", mon_grouping : \"").append(mon_grouping());
            sb.append("\", mon_thousands_sep : \"").append(mon_thousands_sep());
            sb.append("\", n_cs_precedes : ").append(n_cs_precedes());
            sb.append(", n_sep_by_space : ").append(n_sep_by_space());
            sb.append(", n_sign_posn : ").append(n_sign_posn());
            sb.append(", negative_sign : \"").append(negative_sign());
            sb.append("\", p_cs_precedes : ").append(p_cs_precedes());
            sb.append(", p_sep_by_space : ").append(p_sep_by_space());
            sb.append(", p_sign_posn : ").append(p_sign_posn());
            sb.append(", positive_sign : \"").append(positive_sign());
            sb.append("\", thousands_sep : \"").append(thousands_sep());
            sb.append("\"}");
            return sb.toString();
        }

        /**
         * The string that shall be used as the local currency symbol.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of currency_symbol.
         */
        public final native String currency_symbol();

        /**
         *
         * @return the native value of decimal_point.
         */
        public final native String decimal_point();

        /**
         * An integer representing the number of fractional digits (those to the
         * right of the decimal delimiter) to be written in a formatted monetary
         * quantity using currency_symbol.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of frac_digits.
         */
        public final native short frac_digits();

        /**
         *
         * @return the native value of grouping.
         */
        public final native String grouping();

        /**
         * The international currency symbol.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_curr_symbol.
         */
        public final native String int_curr_symbol();

        /**
         * An integer representing the number of fractional digits (those to the
         * right of the decimal delimiter) to be written in a formatted monetary
         * quantity using int_curr_symbol.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_frac_digits.
         */
        public final native short int_frac_digits();

        /**
         * An integer set to 1 if the int_curr_symbol precedes the value for a
         * monetary quantity with a negative value, and set to 0 if the symbol
         * succeeds the value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_n_cs_precedes.
         */
        public final native short int_n_cs_precedes();

        /**
         * Set to a value indicating the separation of the int_curr_symbol, the
         * sign string, and the value for a negative internationally formatted
         * monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_n_sep_by_space.
         */
        public final native short int_n_sep_by_space();

        /**
         * An integer set to a value indicating the positioning of the
         * negative_sign for a negative monetary quantity formatted with the
         * international format.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_n_sign_posn.
         */
        public final native short int_n_sign_posn();

        /**
         * An integer set to 1 if the int_curr_symbol precedes the value for a
         * monetary quantity with a non-negative value, and set to 0 if the
         * symbol succeeds the value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_p_cs_precedes.
         */
        public final native short int_p_cs_precedes();

        /**
         * Set to a value indicating the separation of the int_curr_symbol, the
         * sign string, and the value for a non-negative internationally
         * formatted monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_p_sep_by_space.
         */
        public final native short int_p_sep_by_space();

        /**
         * An integer set to a value indicating the positioning of the
         * positive_sign for a positive monetary quantity formatted with the
         * international format.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_p_sign_posn.
         */
        public final native short int_p_sign_posn();

        /**
         * The operand is a string containing the symbol that shall be used as
         * the decimal delimiter (radix character) in monetary formatted
         * quantities.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of mon_decimal_point.
         */
        public final native String mon_decimal_point();

        /**
         * Define the size of each group of digits in formatted monetary
         * quantities.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of mon_grouping.
         */
        public final native String mon_grouping();

        /**
         * The operand is a string containing the symbol that shall be used as a
         * separator for groups of digits to the left of the decimal delimiter
         * in formatted monetary quantities.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of mon_thousands_sep.
         */
        public final native String mon_thousands_sep();

        /**
         * A string that shall be used to indicate a negative-valued formatted
         * monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of negative_sign.
         */
        public final native String negative_sign();

        /**
         * An integer set to 1 if the currency_symbol precedes the value for a
         * monetary quantity with a negative value, and set to 0 if the symbol
         * succeeds the value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of n_cs_precedes.
         */
        public final native short n_cs_precedes();

        /**
         * Set to a value indicating the separation of the currency_symbol, the
         * sign string, and the value for a negative formatted monetary
         * quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of n_sep_by_space.
         */
        public final native short n_sep_by_space();

        /**
         * An integer set to a value indicating the positioning of the
         * negative_sign for a negative formatted monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of n_sign_posn.
         */
        public final native short n_sign_posn();

        /**
         * A string that shall be used to indicate a non-negative-valued
         * formatted monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of positive_sign.
         */
        public final native String positive_sign();

        /**
         * An integer set to 1 if the currency_symbol precedes the value for a
         * monetary quantity with a non-negative value, and set to 0 if the
         * symbol succeeds the value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of p_cs_precedes.
         */
        public final native short p_cs_precedes();

        /**
         * Set to a value indicating the separation of the currency_symbol, the
         * sign string, and the value for a non-negative formatted monetary
         * quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of p_sep_by_space.
         */
        public final native short p_sep_by_space();

        /**
         * An integer set to a value indicating the positioning of the
         * positive_sign for a monetary quantity with a non-negative value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of p_sign_posn.
         */
        public final native short p_sign_posn();

        /**
         *
         * @return the native value of thousands_sep.
         */
        public final native String thousands_sep();
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/locale.h.html">{@code typedef
     * locale_t}</a>.
     *
     * @author aploese
     */
    public static class Locale_t {

        private final long nativeValue;

        private Locale_t(long nativeValue) {
            this.nativeValue = nativeValue;
        }

        /**
         *
         * @return (locale_t)0
         */
        public static Locale_t locale_t_0() {
            return new Locale_t(0);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 73 * hash + (int) (this.nativeValue ^ (this.nativeValue >>> 32));
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Locale_t other = (Locale_t) obj;
            return this.nativeValue == other.nativeValue;
        }

        @Override
        public String toString() {
            return "{nativeValue : " + nativeValue + "}";
        }


    }
}
