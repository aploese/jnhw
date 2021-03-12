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
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Locale_Lconv.h"

#ifdef __cplusplus
extern "C" {
#endif

#if defined(_POSIX_VERSION)
#include <locale.h>
    //for offsetof
#include <stddef.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Locale/Lconv/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (struct lconv), __alignof__ (struct lconv));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "currency_symbol", offsetof(struct lconv, currency_symbol))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "decimal_point", offsetof(struct lconv, decimal_point))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "frac_digits", offsetof(struct lconv, frac_digits))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "grouping", offsetof(struct lconv, grouping))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "int_curr_symbol", offsetof(struct lconv, int_curr_symbol))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "int_frac_digits", offsetof(struct lconv, int_frac_digits))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "int_n_cs_precedes", offsetof(struct lconv, int_n_cs_precedes))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "int_n_sep_by_space", offsetof(struct lconv, int_n_sep_by_space))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "int_n_sign_posn", offsetof(struct lconv, int_n_sign_posn))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "int_p_cs_precedes", offsetof(struct lconv, int_p_cs_precedes))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "int_p_sep_by_space", offsetof(struct lconv, int_p_sep_by_space))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "int_p_sign_posn", offsetof(struct lconv, int_p_sign_posn))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "mon_decimal_point", offsetof(struct lconv, mon_decimal_point))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "mon_grouping", offsetof(struct lconv, mon_grouping))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "mon_thousands_sep", offsetof(struct lconv, mon_thousands_sep))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "negative_sign", offsetof(struct lconv, negative_sign))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "n_cs_precedes", offsetof(struct lconv, n_cs_precedes))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "n_sep_by_space", offsetof(struct lconv, n_sep_by_space))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "n_sign_posn", offsetof(struct lconv, n_sign_posn))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "positive_sign", offsetof(struct lconv, positive_sign))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "p_cs_precedes", offsetof(struct lconv, p_cs_precedes))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "p_sep_by_space", offsetof(struct lconv, p_sep_by_space))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "p_sign_posn", offsetof(struct lconv, p_sign_posn))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "thousands_sep", offsetof(struct lconv, thousands_sep))) {
            return result;
        }
        return result;
    }


#endif
#ifdef __cplusplus
}
#endif
