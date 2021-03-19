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

import de.ibapl.jnhw.annotation.posix.locale.locale_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayout;
import de.ibapl.jnhw.common.util.JnhwFormater;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import de.ibapl.jnhw.util.posix.memory.PosixStruct32;
import java.io.IOException;

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
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwPosixLoader.touch();

        HAVE_LOCALE_H = false;
        LC_ALL = 0;
        LC_ALL_MASK = 0;
        LC_COLLATE = 0;
        LC_COLLATE_MASK = 0;
        LC_CTYPE = 0;
        LC_CTYPE_MASK = 0;
        LC_GLOBAL_LOCALE = null;
        LC_MESSAGES = 0;
        LC_MESSAGES_MASK = 0;
        LC_MONETARY = 0;
        LC_MONETARY_MASK = 0;
        LC_NUMERIC = 0;
        LC_NUMERIC_MASK = 0;
        LC_TIME = 0;
        LC_TIME_MASK = 0;

        initFields();
    }

    private static native void initFields();

    public final static boolean HAVE_LOCALE_H;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_ALL;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_ALL_MASK;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_COLLATE;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_COLLATE_MASK;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_CTYPE;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_CTYPE_MASK;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static Locale_t LC_GLOBAL_LOCALE;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_MESSAGES;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_MESSAGES_MASK;

    /**
     * The LC_MONETARY category shall define the rules and symbols that are used
     * to format monetary numeric information.
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
     *
     */
    @Define
    public final static int LC_MONETARY;

    /**
     * The LC_MONETARY category shall define the rules and symbols that are used
     * to format monetary numeric information.
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
     *
     */
    @Define
    public final static int LC_MONETARY_MASK;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_NUMERIC;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_NUMERIC_MASK;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_TIME;

    /**
     * <b>POSIX:</b> XXX
     *
     */
    @Define
    public final static int LC_TIME_MASK;

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
    public static final class Lconv extends PosixStruct32 {

        public static class Layout extends StructLayout {

            public final long currency_symbol;
            public final long decimal_point;
            public final long frac_digits;
            public final long grouping;
            public final long int_curr_symbol;
            public final long int_frac_digits;
            public final long int_n_cs_precedes;
            public final long int_n_sep_by_space;
            public final long int_n_sign_posn;
            public final long int_p_cs_precedes;
            public final long int_p_sep_by_space;
            public final long int_p_sign_posn;
            public final long mon_decimal_point;
            public final long mon_grouping;
            public final long mon_thousands_sep;
            public final long negative_sign;
            public final long n_cs_precedes;
            public final long n_sep_by_space;
            public final long n_sign_posn;
            public final long positive_sign;
            public final long p_cs_precedes;
            public final long p_sep_by_space;
            public final long p_sign_posn;
            public final long thousands_sep;
            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                currency_symbol = -1;
                decimal_point = -1;
                frac_digits = -1;
                grouping = -1;
                int_curr_symbol = -1;
                int_frac_digits = -1;
                int_n_cs_precedes = -1;
                int_n_sep_by_space = -1;
                int_n_sign_posn = -1;
                int_p_cs_precedes = -1;
                int_p_sep_by_space = -1;
                int_p_sign_posn = -1;
                mon_decimal_point = -1;
                mon_grouping = -1;
                mon_thousands_sep = -1;
                negative_sign = -1;
                n_cs_precedes = -1;
                n_sep_by_space = -1;
                n_sign_posn = -1;
                positive_sign = -1;
                p_cs_precedes = -1;
                p_sep_by_space = -1;
                p_sign_posn = -1;
                thousands_sep = -1;
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        public final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        public Lconv() {
            this(null, 0, MEM_UNINITIALIZED);
        }

        public Lconv(OpaqueMemory32 parent, int offset, Byte setMem) {
            super(parent, offset, LAYOUT.sizeof, setMem);
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
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendStringMember("currency_symbol", currency_symbol());
            jsb.appendStringMember("decimal_point", decimal_point());
            jsb.appendShortMember("frac_digits", frac_digits());
            jsb.appendStringMember("grouping", grouping());
            jsb.appendStringMember("int_curr_symbol", int_curr_symbol());
            jsb.appendShortMember("int_frac_digits", int_frac_digits());
            jsb.appendShortMember("int_n_cs_precedes", int_n_cs_precedes());
            jsb.appendShortMember("int_n_sep_by_space", int_n_sep_by_space());
            jsb.appendShortMember("int_n_sign_posn", int_n_sign_posn());
            jsb.appendShortMember("int_p_cs_precedes", int_p_cs_precedes());
            jsb.appendShortMember("int_p_sep_by_space", int_p_sep_by_space());
            jsb.appendShortMember("int_p_sign_posn", int_p_sign_posn());
            jsb.appendStringMember("mon_decimal_point", mon_decimal_point());
            jsb.appendStringMember("mon_grouping", mon_grouping());
            jsb.appendStringMember("mon_thousands_sep", mon_thousands_sep());
            jsb.appendShortMember("n_cs_precedes", n_cs_precedes());
            jsb.appendShortMember("n_sep_by_space", n_sep_by_space());
            jsb.appendShortMember("n_sign_posn", n_sign_posn());
            jsb.appendStringMember("negative_sign", negative_sign());
            jsb.appendShortMember("p_cs_precedes", p_cs_precedes());
            jsb.appendShortMember("p_sep_by_space", p_sep_by_space());
            jsb.appendShortMember("p_sign_posn", p_sign_posn());
            jsb.appendStringMember("positive_sign", positive_sign());
            jsb.appendStringMember("thousands_sep", thousands_sep());
            jsb.close();
        }

        /**
         * The string that shall be used as the local currency symbol.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of currency_symbol.
         */
        public final String currency_symbol() {
            return MEM_ACCESS.getUTF_8String(this, LAYOUT.currency_symbol);
        }

        /**
         *
         * @return the native value of decimal_point.
         */
        public final String decimal_point() {
            return MEM_ACCESS.getUTF_8String(this, LAYOUT.decimal_point);
        }

        /**
         * An integer representing the number of fractional digits (those to the
         * right of the decimal delimiter) to be written in a formatted monetary
         * quantity using currency_symbol.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of frac_digits.
         */
        public final short frac_digits() {
            return MEM_ACCESS.int16_t(this, LAYOUT.frac_digits);
        }

        /**
         *
         * @return the native value of grouping.
         */
        public final String grouping() {
            return MEM_ACCESS.getUTF_8String(this, LAYOUT.grouping);
        }

        /**
         * The international currency symbol.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_curr_symbol.
         */
        public final String int_curr_symbol() {
            return MEM_ACCESS.getUTF_8String(this, LAYOUT.int_curr_symbol);
        }

        /**
         * An integer representing the number of fractional digits (those to the
         * right of the decimal delimiter) to be written in a formatted monetary
         * quantity using int_curr_symbol.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_frac_digits.
         */
        public final short int_frac_digits() {
            return MEM_ACCESS.int16_t(this, LAYOUT.int_frac_digits);
        }

        /**
         * An integer set to 1 if the int_curr_symbol precedes the value for a
         * monetary quantity with a negative value, and set to 0 if the symbol
         * succeeds the value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_n_cs_precedes.
         */
        public final short int_n_cs_precedes() {
            return MEM_ACCESS.int16_t(this, LAYOUT.int_n_cs_precedes);
        }

        /**
         * Set to a value indicating the separation of the int_curr_symbol, the
         * sign string, and the value for a negative internationally formatted
         * monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_n_sep_by_space.
         */
        public final short int_n_sep_by_space() {
            return MEM_ACCESS.int16_t(this, LAYOUT.int_n_sep_by_space);
        }

        /**
         * An integer set to a value indicating the positioning of the
         * negative_sign for a negative monetary quantity formatted with the
         * international format.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_n_sign_posn.
         */
        public final short int_n_sign_posn() {
            return MEM_ACCESS.int16_t(this, LAYOUT.int_n_sign_posn);
        }

        /**
         * An integer set to 1 if the int_curr_symbol precedes the value for a
         * monetary quantity with a non-negative value, and set to 0 if the
         * symbol succeeds the value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_p_cs_precedes.
         */
        public final short int_p_cs_precedes() {
            return MEM_ACCESS.int16_t(this, LAYOUT.int_p_cs_precedes);
        }

        /**
         * Set to a value indicating the separation of the int_curr_symbol, the
         * sign string, and the value for a non-negative internationally
         * formatted monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_p_sep_by_space.
         */
        public final short int_p_sep_by_space() {
            return MEM_ACCESS.int16_t(this, LAYOUT.int_p_sep_by_space);
        }

        /**
         * An integer set to a value indicating the positioning of the
         * positive_sign for a positive monetary quantity formatted with the
         * international format.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_p_sign_posn.
         */
        public final short int_p_sign_posn() {
            return MEM_ACCESS.int16_t(this, LAYOUT.int_p_sign_posn);
        }

        /**
         * The operand is a string containing the symbol that shall be used as
         * the decimal delimiter (radix character) in monetary formatted
         * quantities.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of mon_decimal_point.
         */
        public final String mon_decimal_point() {
            return MEM_ACCESS.getUTF_8String(this, LAYOUT.mon_decimal_point);
        }

        /**
         * Define the size of each group of digits in formatted monetary
         * quantities.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of mon_grouping.
         */
        public final String mon_grouping() {
            return MEM_ACCESS.getUTF_8String(this, LAYOUT.mon_grouping);
        }

        /**
         * The operand is a string containing the symbol that shall be used as a
         * separator for groups of digits to the left of the decimal delimiter
         * in formatted monetary quantities.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of mon_thousands_sep.
         */
        public final String mon_thousands_sep() {
            return MEM_ACCESS.getUTF_8String(this, LAYOUT.mon_thousands_sep);
        }

        /**
         * A string that shall be used to indicate a negative-valued formatted
         * monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of negative_sign.
         */
        public final String negative_sign() {
            return MEM_ACCESS.getUTF_8String(this, LAYOUT.negative_sign);
        }

        /**
         * An integer set to 1 if the currency_symbol precedes the value for a
         * monetary quantity with a negative value, and set to 0 if the symbol
         * succeeds the value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of n_cs_precedes.
         */
        public final short n_cs_precedes() {
            return MEM_ACCESS.int16_t(this, LAYOUT.n_cs_precedes);
        }

        /**
         * Set to a value indicating the separation of the currency_symbol, the
         * sign string, and the value for a negative formatted monetary
         * quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of n_sep_by_space.
         */
        public final short n_sep_by_space() {
            return MEM_ACCESS.int16_t(this, LAYOUT.n_sep_by_space);
        }

        /**
         * An integer set to a value indicating the positioning of the
         * negative_sign for a negative formatted monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of n_sign_posn.
         */
        public final short n_sign_posn() {
            return MEM_ACCESS.int16_t(this, LAYOUT.n_sign_posn);
        }

        /**
         * A string that shall be used to indicate a non-negative-valued
         * formatted monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of positive_sign.
         */
        public final String positive_sign() {
            return MEM_ACCESS.getUTF_8String(this, LAYOUT.positive_sign);
        }

        /**
         * An integer set to 1 if the currency_symbol precedes the value for a
         * monetary quantity with a non-negative value, and set to 0 if the
         * symbol succeeds the value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of p_cs_precedes.
         */
        public final short p_cs_precedes() {
            return MEM_ACCESS.int16_t(this, LAYOUT.p_cs_precedes);
        }

        /**
         * Set to a value indicating the separation of the currency_symbol, the
         * sign string, and the value for a non-negative formatted monetary
         * quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of p_sep_by_space.
         */
        public final short p_sep_by_space() {
            return MEM_ACCESS.int16_t(this, LAYOUT.p_sep_by_space);
        }

        /**
         * An integer set to a value indicating the positioning of the
         * positive_sign for a monetary quantity with a non-negative value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of p_sign_posn.
         */
        public final short p_sign_posn() {
            return MEM_ACCESS.int16_t(this, LAYOUT.p_sign_posn);
        }

        /**
         *
         * @return the native value of thousands_sep.
         */
        public final String thousands_sep() {
            return MEM_ACCESS.getUTF_8String(this, LAYOUT.thousands_sep);
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/locale.h.html">{@code typedef
     * locale_t}</a>.
     *
     * @author aploese
     */
    @locale_t
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
            return "{nativeValue : " + JnhwFormater.formatAddress(nativeValue) + "}";
        }

    }
}
