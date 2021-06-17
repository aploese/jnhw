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
#include "de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t.h"

#ifdef __cplusplus
extern "C" {
#endif

#if defined(_POSIX_VERSION)
#include <locale.h>
    //for offsetof
#include <stddef.h>

        /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct lconv);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct lconv);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    currency_symbol
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_currency_1symbol
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, currency_symbol);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    decimal_point
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_decimal_1point
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, decimal_point);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    frac_digits
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_frac_1digits
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, frac_digits);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    grouping
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_grouping
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, grouping);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    int_curr_symbol
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_int_1curr_1symbol
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, int_curr_symbol);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    int_frac_digits
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_int_1frac_1digits
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, int_frac_digits);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    int_n_cs_precedes
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_int_1n_1cs_1precedes
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, int_n_cs_precedes);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    int_n_sep_by_space
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_int_1n_1sep_1by_1space
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, int_n_sep_by_space);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    int_n_sign_posn
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_int_1n_1sign_1posn
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, int_n_sign_posn);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    int_p_cs_precedes
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_int_1p_1cs_1precedes
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, int_p_cs_precedes);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    int_p_sep_by_space
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_int_1p_1sep_1by_1space
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, int_p_sep_by_space);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    int_p_sign_posn
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_int_1p_1sign_1posn
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, int_p_sign_posn);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    mon_decimal_point
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_mon_1decimal_1point
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, mon_decimal_point);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    mon_grouping
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_mon_1grouping
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, mon_grouping);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    mon_thousands_sep
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_mon_1thousands_1sep
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, mon_thousands_sep);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    negative_sign
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_negative_1sign
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, negative_sign);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    n_cs_precedes
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_n_1cs_1precedes
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, n_cs_precedes);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    n_sep_by_space
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_n_1sep_1by_1space
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, n_sep_by_space);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    n_sign_posn
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_n_1sign_1posn
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, n_sign_posn);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    positive_sign
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_positive_1sign
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, positive_sign);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    p_cs_precedes
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_p_1cs_1precedes
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, p_cs_precedes);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    p_sep_by_space
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_p_1sep_1by_1space
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, p_sep_by_space);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    p_sign_posn
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_p_1sign_1posn
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, p_sign_posn);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_LocaleTest_NativeLconv_t
     * Method:    thousands_sep
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_LocaleTest_00024NativeLconv_1t_thousands_1sep
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct lconv, thousands_sep);
    }

#endif
#ifdef __cplusplus
}
#endif
