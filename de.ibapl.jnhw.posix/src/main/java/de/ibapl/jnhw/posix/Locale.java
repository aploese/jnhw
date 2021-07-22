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
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.util.JnhwFormater;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.libloader.MultiarchInfo;
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

    public static interface BsdDefines {

        public final static int LC_ALL = 0;
        public final static int LC_COLLATE = 1;
        public final static int LC_CTYPE = 2;
        public final static long LC_GLOBAL_LOCALE = -1;
        public final static int LC_MESSAGES = 6;
        public final static int LC_MONETARY = 3;
        public final static int LC_NUMERIC = 4;
        public final static int LC_TIME = 5;
    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int LC_ALL_MASK = 63;
        public final static int LC_COLLATE_MASK = 1;
        public final static int LC_CTYPE_MASK = 2;
        public final static int LC_MESSAGES_MASK = 4;
        public final static int LC_MONETARY_MASK = 8;
        public final static int LC_NUMERIC_MASK = 16;
        public final static int LC_TIME_MASK = 32;

    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int LC_ALL_MASK = 63;
        public final static int LC_COLLATE_MASK = 1;
        public final static int LC_CTYPE_MASK = 2;
        public final static int LC_MESSAGES_MASK = 32;
        public final static int LC_MONETARY_MASK = 4;
        public final static int LC_NUMERIC_MASK = 8;
        public final static int LC_TIME_MASK = 16;

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/locale.h.html">{@code structure
     * lconv}</a>.
     *
     */
    public static final class Lconv extends PosixStruct32 {

        public final static Alignment alignof;
        public final static long offsetof_Currency_symbol;
        public final static long offsetof_Decimal_point;
        public final static long offsetof_Frac_digits;
        public final static long offsetof_Grouping;
        public final static long offsetof_Int_curr_symbol;
        public final static long offsetof_Int_frac_digits;
        public final static long offsetof_Int_n_cs_precedes;
        public final static long offsetof_Int_n_sep_by_space;
        public final static long offsetof_Int_n_sign_posn;
        public final static long offsetof_Int_p_cs_precedes;
        public final static long offsetof_Int_p_sep_by_space;
        public final static long offsetof_Int_p_sign_posn;
        public final static long offsetof_Mon_decimal_point;
        public final static long offsetof_Mon_grouping;
        public final static long offsetof_Mon_thousands_sep;
        public final static long offsetof_N_cs_precedes;
        public final static long offsetof_N_sep_by_space;
        public final static long offsetof_N_sign_posn;
        public final static long offsetof_Negative_sign;
        public final static long offsetof_P_cs_precedes;
        public final static long offsetof_P_sep_by_space;
        public final static long offsetof_P_sign_posn;
        public final static long offsetof_Positive_sign;
        public final static long offsetof_Thousands_sep;
        public final static int sizeof;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
            switch (multiarchInfo.getOS()) {

                case LINUX:
                    switch (multiarchInfo.getSizeOfPointer()) {
                        case _32_BIT:
                            alignof = Alignment.AT_4;
                            sizeof = 56;
                            offsetof_Currency_symbol = 16;
                            offsetof_Decimal_point = 0;
                            offsetof_Frac_digits = 41;
                            offsetof_Grouping = 8;
                            offsetof_Int_curr_symbol = 12;
                            offsetof_Int_frac_digits = 40;
                            offsetof_Int_n_cs_precedes = 50;
                            offsetof_Int_n_sep_by_space = 51;
                            offsetof_Int_n_sign_posn = 53;
                            offsetof_Int_p_cs_precedes = 48;
                            offsetof_Int_p_sep_by_space = 49;
                            offsetof_Int_p_sign_posn = 52;
                            offsetof_Mon_decimal_point = 20;
                            offsetof_Mon_grouping = 28;
                            offsetof_Mon_thousands_sep = 24;
                            offsetof_Negative_sign = 36;
                            offsetof_N_cs_precedes = 44;
                            offsetof_N_sep_by_space = 45;
                            offsetof_N_sign_posn = 47;
                            offsetof_Positive_sign = 32;
                            offsetof_P_cs_precedes = 42;
                            offsetof_P_sep_by_space = 43;
                            offsetof_P_sign_posn = 46;
                            offsetof_Thousands_sep = 4;
                            break;
                        case _64_BIT:
                            alignof = Alignment.AT_8;
                            sizeof = 96;
                            offsetof_Currency_symbol = 32;
                            offsetof_Decimal_point = 0;
                            offsetof_Frac_digits = 81;
                            offsetof_Grouping = 16;
                            offsetof_Int_curr_symbol = 24;
                            offsetof_Int_frac_digits = 80;
                            offsetof_Int_n_cs_precedes = 90;
                            offsetof_Int_n_sep_by_space = 91;
                            offsetof_Int_n_sign_posn = 93;
                            offsetof_Int_p_cs_precedes = 88;
                            offsetof_Int_p_sep_by_space = 89;
                            offsetof_Int_p_sign_posn = 92;
                            offsetof_Mon_decimal_point = 40;
                            offsetof_Mon_grouping = 56;
                            offsetof_Mon_thousands_sep = 48;
                            offsetof_Negative_sign = 72;
                            offsetof_N_cs_precedes = 84;
                            offsetof_N_sep_by_space = 85;
                            offsetof_N_sign_posn = 87;
                            offsetof_Positive_sign = 64;
                            offsetof_P_cs_precedes = 82;
                            offsetof_P_sep_by_space = 83;
                            offsetof_P_sign_posn = 86;
                            offsetof_Thousands_sep = 8;
                            break;
                        default:
                            throw new NoClassDefFoundError("No locale.h linux defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                    }
                    break;
                case DARWIN:
                case FREE_BSD:
                    alignof = Alignment.AT_8;
                    sizeof = 96;
                    offsetof_Currency_symbol = 32;
                    offsetof_Decimal_point = 0;
                    offsetof_Frac_digits = 81;
                    offsetof_Grouping = 16;
                    offsetof_Int_curr_symbol = 24;
                    offsetof_Int_frac_digits = 80;
                    offsetof_Int_n_cs_precedes = 89;
                    offsetof_Int_n_sep_by_space = 91;
                    offsetof_Int_n_sign_posn = 93;
                    offsetof_Int_p_cs_precedes = 88;
                    offsetof_Int_p_sep_by_space = 90;
                    offsetof_Int_p_sign_posn = 92;
                    offsetof_Mon_decimal_point = 40;
                    offsetof_Mon_grouping = 56;
                    offsetof_Mon_thousands_sep = 48;
                    offsetof_Negative_sign = 72;
                    offsetof_N_cs_precedes = 84;
                    offsetof_N_sep_by_space = 85;
                    offsetof_N_sign_posn = 87;
                    offsetof_Positive_sign = 64;
                    offsetof_P_cs_precedes = 82;
                    offsetof_P_sep_by_space = 83;
                    offsetof_P_sign_posn = 86;
                    offsetof_Thousands_sep = 8;
                    break;
                case OPEN_BSD:
                    alignof = Alignment.AT_8;
                    sizeof = 96;
                    offsetof_Currency_symbol = 32;
                    offsetof_Decimal_point = 0;
                    offsetof_Frac_digits = 81;
                    offsetof_Grouping = 16;
                    offsetof_Int_curr_symbol = 24;
                    offsetof_Int_frac_digits = 80;
                    offsetof_Int_n_cs_precedes = 90;
                    offsetof_Int_n_sep_by_space = 91;
                    offsetof_Int_n_sign_posn = 93;
                    offsetof_Int_p_cs_precedes = 88;
                    offsetof_Int_p_sep_by_space = 89;
                    offsetof_Int_p_sign_posn = 92;
                    offsetof_Mon_decimal_point = 40;
                    offsetof_Mon_grouping = 56;
                    offsetof_Mon_thousands_sep = 48;
                    offsetof_Negative_sign = 72;
                    offsetof_N_cs_precedes = 84;
                    offsetof_N_sep_by_space = 85;
                    offsetof_N_sign_posn = 87;
                    offsetof_Positive_sign = 64;
                    offsetof_P_cs_precedes = 82;
                    offsetof_P_sep_by_space = 83;
                    offsetof_P_sign_posn = 86;
                    offsetof_Thousands_sep = 8;
                    break;
                default:
                    throw new NoClassDefFoundError("No locale.h OS defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
            }
        }

        public Lconv() {
            this(null, 0, SetMem.DO_NOT_SET);
        }

        public Lconv(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, Lconv.sizeof, setMem);
        }

        public Lconv(NativeAddressHolder addressHolder) {
            super(addressHolder, Lconv.sizeof);
        }

        /**
         * The string that shall be used as the local currency symbol.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of currency_symbol.
         */
        public final String currency_symbol() {
            return MEM_ACCESS.getUTF_8String(this, Lconv.offsetof_Currency_symbol);
        }

        /**
         *
         * @return the native value of decimal_point.
         */
        public final String decimal_point() {
            return MEM_ACCESS.getUTF_8String(this, Lconv.offsetof_Decimal_point);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_Frac_digits);
        }

        /**
         *
         * @return the native value of grouping.
         */
        public final String grouping() {
            return MEM_ACCESS.getUTF_8String(this, Lconv.offsetof_Grouping);
        }

        /**
         * The international currency symbol.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of int_curr_symbol.
         */
        public final String int_curr_symbol() {
            return MEM_ACCESS.getUTF_8String(this, Lconv.offsetof_Int_curr_symbol);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_Int_frac_digits);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_Int_n_cs_precedes);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_Int_n_sep_by_space);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_Int_n_sign_posn);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_Int_p_cs_precedes);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_Int_p_sep_by_space);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_Int_p_sign_posn);
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
            return MEM_ACCESS.getUTF_8String(this, Lconv.offsetof_Mon_decimal_point);
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
            return MEM_ACCESS.getUTF_8String(this, Lconv.offsetof_Mon_grouping);
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
            return MEM_ACCESS.getUTF_8String(this, Lconv.offsetof_Mon_thousands_sep);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_N_cs_precedes);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_N_sep_by_space);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_N_sign_posn);
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
         * A string that shall be used to indicate a negative-valued formatted
         * monetary quantity.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/V1_chap07.html#tag_07_03_03">{@code LC_MONETARY}</a>.
         *
         * @return the native value of negative_sign.
         */
        public final String negative_sign() {
            return MEM_ACCESS.getUTF_8String(this, Lconv.offsetof_Negative_sign);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_P_cs_precedes);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_P_sep_by_space);
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
            return MEM_ACCESS.int16_t(this, Lconv.offsetof_P_sign_posn);
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
            return MEM_ACCESS.getUTF_8String(this, Lconv.offsetof_Positive_sign);
        }

        /**
         *
         * @return the native value of thousands_sep.
         */
        public final String thousands_sep() {
            return MEM_ACCESS.getUTF_8String(this, Lconv.offsetof_Thousands_sep);
        }

    }

    public static interface LinuxDefines {

        public final static int LC_ALL = 6;
        public final static int LC_ALL_MASK = 8127;
        public final static int LC_COLLATE = 3;
        public final static int LC_COLLATE_MASK = 8;
        public final static int LC_CTYPE = 0;
        public final static int LC_CTYPE_MASK = 1;
        public final static long LC_GLOBAL_LOCALE = -1;
        public final static int LC_MESSAGES = 5;
        public final static int LC_MESSAGES_MASK = 32;
        public final static int LC_MONETARY = 4;
        public final static int LC_MONETARY_MASK = 16;
        public final static int LC_NUMERIC = 1;
        public final static int LC_NUMERIC_MASK = 2;
        public final static int LC_TIME = 2;
        public final static int LC_TIME_MASK = 4;
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/locale.h.html">{@code typedef
     * locale_t}</a>. This is basically a pointer which points to the real
     * struct.
     *
     * @author aploese
     */
    @locale_t
    public static class Locale_t {

        public final static Locale_t fromNativeValue(final long nativeValue) {
            return new Locale_t(nativeValue);
        }

        public final static long getNativeValue(final Locale_t locale) {
            return locale.nativeValue;
        }

        /**
         *
         * @return (locale_t)0
         */
        public static Locale_t locale_t_0() {
            return new Locale_t(0);
        }

        private final long nativeValue;

        private Locale_t(long nativeValue) {
            this.nativeValue = nativeValue;
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
        public int hashCode() {
            int hash = 7;
            hash = 73 * hash + (int) (this.nativeValue ^ (this.nativeValue >>> 32));
            return hash;
        }

        @Override
        public String toString() {
            return "{nativeValue : " + JnhwFormater.formatAddress(nativeValue) + "}";
        }

    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int LC_ALL_MASK = 126;
        public final static int LC_COLLATE_MASK = 2;
        public final static int LC_CTYPE_MASK = 4;
        public final static int LC_MESSAGES_MASK = 64;
        public final static int LC_MONETARY_MASK = 8;
        public final static int LC_NUMERIC_MASK = 16;
        public final static int LC_TIME_MASK = 32;

    }

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
        final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
        switch (multiarchInfo.getOS()) {
            case LINUX:
                HAVE_LOCALE_H = true;
                LC_ALL = LinuxDefines.LC_ALL;
                LC_ALL_MASK = LinuxDefines.LC_ALL_MASK;
                LC_COLLATE = LinuxDefines.LC_COLLATE;
                LC_COLLATE_MASK = LinuxDefines.LC_COLLATE_MASK;
                LC_CTYPE = LinuxDefines.LC_CTYPE;
                LC_CTYPE_MASK = LinuxDefines.LC_CTYPE_MASK;
                LC_GLOBAL_LOCALE = Locale_t.fromNativeValue(LinuxDefines.LC_GLOBAL_LOCALE);
                LC_MESSAGES = LinuxDefines.LC_MESSAGES;
                LC_MESSAGES_MASK = LinuxDefines.LC_MESSAGES_MASK;
                LC_MONETARY = LinuxDefines.LC_MONETARY;
                LC_MONETARY_MASK = LinuxDefines.LC_MONETARY_MASK;
                LC_NUMERIC = LinuxDefines.LC_NUMERIC;
                LC_NUMERIC_MASK = LinuxDefines.LC_NUMERIC_MASK;
                LC_TIME = LinuxDefines.LC_TIME;
                LC_TIME_MASK = LinuxDefines.LC_TIME_MASK;
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_LOCALE_H = true;
                LC_ALL = BsdDefines.LC_ALL;
                LC_COLLATE = BsdDefines.LC_COLLATE;
                LC_CTYPE = BsdDefines.LC_CTYPE;
                LC_GLOBAL_LOCALE = Locale_t.fromNativeValue(BsdDefines.LC_GLOBAL_LOCALE);
                LC_MESSAGES = BsdDefines.LC_MESSAGES;
                LC_MONETARY = BsdDefines.LC_MONETARY;
                LC_NUMERIC = BsdDefines.LC_NUMERIC;
                LC_TIME = BsdDefines.LC_TIME;
                switch (multiarchInfo.getOS()) {
                    case DARWIN:
                        LC_ALL_MASK = DarwinDefines.LC_ALL_MASK;
                        LC_COLLATE_MASK = DarwinDefines.LC_COLLATE_MASK;
                        LC_CTYPE_MASK = DarwinDefines.LC_CTYPE_MASK;
                        LC_MESSAGES_MASK = DarwinDefines.LC_MESSAGES_MASK;
                        LC_MONETARY_MASK = DarwinDefines.LC_MONETARY_MASK;
                        LC_NUMERIC_MASK = DarwinDefines.LC_NUMERIC_MASK;
                        LC_TIME_MASK = DarwinDefines.LC_TIME_MASK;
                        break;
                    case FREE_BSD:
                        LC_ALL_MASK = FreeBsdDefines.LC_ALL_MASK;
                        LC_COLLATE_MASK = FreeBsdDefines.LC_COLLATE_MASK;
                        LC_CTYPE_MASK = FreeBsdDefines.LC_CTYPE_MASK;
                        LC_MESSAGES_MASK = FreeBsdDefines.LC_MESSAGES_MASK;
                        LC_MONETARY_MASK = FreeBsdDefines.LC_MONETARY_MASK;
                        LC_NUMERIC_MASK = FreeBsdDefines.LC_NUMERIC_MASK;
                        LC_TIME_MASK = FreeBsdDefines.LC_TIME_MASK;
                        break;
                    case OPEN_BSD:
                        LC_ALL_MASK = OpenBsdDefines.LC_ALL_MASK;
                        LC_COLLATE_MASK = OpenBsdDefines.LC_COLLATE_MASK;
                        LC_CTYPE_MASK = OpenBsdDefines.LC_CTYPE_MASK;
                        LC_MESSAGES_MASK = OpenBsdDefines.LC_MESSAGES_MASK;
                        LC_MONETARY_MASK = OpenBsdDefines.LC_MONETARY_MASK;
                        LC_NUMERIC_MASK = OpenBsdDefines.LC_NUMERIC_MASK;
                        LC_TIME_MASK = OpenBsdDefines.LC_TIME_MASK;
                        break;
                    default:
                        throw new NoClassDefFoundError("No locale.h BSD defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                }
                break;
            default:
                throw new NoClassDefFoundError("No locale.h OS defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
        }
    }

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
    public final static Locale_t duplocale(Locale_t locobj) throws NativeErrorException {
        return new Locale_t(duplocale(locobj.nativeValue));
    }

    private static native long duplocale(long nativeLocobj) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/freelocale.html">freelocale
     * - free resources allocated for a locale object</a>.
     *
     * @param locobj a valid locale object handle.
     *
     */
    public final static void freelocale(Locale_t locobj) {
        freelocale(locobj.nativeValue);
    }

    private static native void freelocale(long nativeLocobj);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/localeconv.html">localeconv
     * - return locale-specific information</a>.
     *
     *
     * @return The localeconv() function shall return a pointer to the filled-in
     * object.
     */
    public final static Lconv localeconv() {
        return new Lconv(NativeAddressHolder.ofUintptr_t(localeconv0()));
    }

    private static native long localeconv0();

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
    public final static Locale_t newlocale(int category_mask, String locale, Locale_t base) throws NativeErrorException {
        if (locale == null) {
            throw new NullPointerException("locale is null.");
        }
        if (LC_GLOBAL_LOCALE.equals(base)) {
            throw new IllegalArgumentException("base is LC_GLOBAL_LOCALE");
        }
        return new Locale_t(newlocale(category_mask, locale, base.nativeValue));
    }

    private static native long newlocale(int category_mask, String locale, long nativeBase) throws NativeErrorException;

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
    public final static Locale_t uselocale(Locale_t newloc) throws NativeErrorException {
        return new Locale_t(uselocale(newloc.nativeValue));
    }

    private static native long uselocale(long nativeNewloc) throws NativeErrorException;
}
