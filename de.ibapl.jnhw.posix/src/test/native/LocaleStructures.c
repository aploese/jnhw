/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
#include "jnhw-posix.h"

#if defined(_POSIX_VERSION)
#include <locale.h>
    //for offsetof
#include <stddef.h>

int lconv_t_alignof() {
    return __alignof__ (struct lconv);
}

int lconv_t_sizeof() {
    return sizeof (struct lconv);
}

int lconv_t_offsetof_currency_symbol() {
    return offsetof(struct lconv, currency_symbol);
}

int lconv_t_offsetof_decimal_point() {
    return offsetof(struct lconv, decimal_point);
}

int lconv_t_offsetof_frac_digits() {
    return offsetof(struct lconv, frac_digits);
}

int lconv_t_offsetof_grouping() {
    return offsetof(struct lconv, grouping);
}

int lconv_t_offsetof_int_curr_symbol() {
    return offsetof(struct lconv, int_curr_symbol);
}

int lconv_t_offsetof_int_frac_digits() {
    return offsetof(struct lconv, int_frac_digits);
}

int lconv_t_offsetof_int_n_cs_precedes() {
    return offsetof(struct lconv, int_n_cs_precedes);
}

int lconv_t_offsetof_int_n_sep_by_space() {
    return offsetof(struct lconv, int_n_sep_by_space);
}

int lconv_t_offsetof_int_n_sign_posn() {
    return offsetof(struct lconv, int_n_sign_posn);
}

int lconv_t_offsetof_int_p_cs_precedes() {
    return offsetof(struct lconv, int_p_cs_precedes);
}

int lconv_t_offsetof_int_p_sep_by_space() {
    return offsetof(struct lconv, int_p_sep_by_space);
}

int lconv_t_offsetof_int_p_sign_posn() {
    return offsetof(struct lconv, int_p_sign_posn);
}

int lconv_t_offsetof_mon_decimal_point() {
    return offsetof(struct lconv, mon_decimal_point);
}

int lconv_t_offsetof_mon_grouping() {
    return offsetof(struct lconv, mon_grouping);
}

int lconv_t_offsetof_mon_thousands_sep() {
    return offsetof(struct lconv, mon_thousands_sep);
}

int lconv_t_offsetof_negative_sign() {
    return offsetof(struct lconv, negative_sign);
}

int lconv_t_offsetof_n_cs_precedes() {
    return offsetof(struct lconv, n_cs_precedes);
}

int lconv_t_offsetof_n_sep_by_space() {
    return offsetof(struct lconv, n_sep_by_space);
}

int lconv_t_offsetof_n_sign_posn() {
    return offsetof(struct lconv, n_sign_posn);
}

int lconv_t_offsetof_positive_sign() {
    return offsetof(struct lconv, positive_sign);
}

int lconv_t_offsetof_p_cs_precedes() {
    return offsetof(struct lconv, p_cs_precedes);
}

int lconv_t_offsetof_p_sep_by_space() {
    return offsetof(struct lconv, p_sep_by_space);
}

int lconv_t_offsetof_p_sign_posn() {
    return offsetof(struct lconv, p_sign_posn);
}

int lconv_t_offsetof_thousands_sep() {
    return offsetof(struct lconv, thousands_sep);
}

#endif