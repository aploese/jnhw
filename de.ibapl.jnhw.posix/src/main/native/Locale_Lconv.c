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
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Locale_Lconv.h"

#ifdef __cplusplus
extern "C" {
#endif

#if defined(_POSIX_VERSION)
#include <locale.h>

#if (MAX_CHAR > 127)
#error MAX_CHAR is bigger then 127 replace any jbyte return with jshort to make it save not to return a negative number....     
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct lconv);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct lconv);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    currency_symbol
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_currency_1symbol
    (JNIEnv *env, jobject structLconv) {
        return (*env)->NewStringUTF(env, (UNWRAP_STRUCT_LCONV_PTR(structLconv))->currency_symbol);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    decimal_point
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_decimal_1point
    (JNIEnv *env, jobject structLconv) {
        return (*env)->NewStringUTF(env, (UNWRAP_STRUCT_LCONV_PTR(structLconv))->decimal_point);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    frac_digits
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_frac_1digits
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->frac_digits;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    grouping
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_grouping
    (JNIEnv *env, jobject structLconv) {
        return (*env)->NewStringUTF(env, (UNWRAP_STRUCT_LCONV_PTR(structLconv))->grouping);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    int_curr_symbol
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_int_1curr_1symbol
    (JNIEnv *env, jobject structLconv) {
        return (*env)->NewStringUTF(env, (UNWRAP_STRUCT_LCONV_PTR(structLconv))->int_curr_symbol);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    int_frac_digits
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_int_1frac_1digits
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->int_frac_digits;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    int_n_cs_precedes
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_int_1n_1cs_1precedes
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->int_n_cs_precedes;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    int_n_sep_by_space
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_int_1n_1sep_1by_1space
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->int_n_sep_by_space;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    int_n_sign_posn
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_int_1n_1sign_1posn
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->int_n_sign_posn;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    int_p_cs_precedes
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_int_1p_1cs_1precedes
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->int_p_cs_precedes;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    int_p_sep_by_space
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_int_1p_1sep_1by_1space
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->int_p_sep_by_space;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    int_p_sign_posn
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_int_1p_1sign_1posn
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->int_p_sign_posn;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    mon_decimal_point
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_mon_1decimal_1point
    (JNIEnv *env, jobject structLconv) {
        return (*env)->NewStringUTF(env, (UNWRAP_STRUCT_LCONV_PTR(structLconv))->mon_decimal_point);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    mon_grouping
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_mon_1grouping
    (JNIEnv *env, jobject structLconv) {
        return (*env)->NewStringUTF(env, (UNWRAP_STRUCT_LCONV_PTR(structLconv))->mon_grouping);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    mon_thousands_sep
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_mon_1thousands_1sep
    (JNIEnv *env, jobject structLconv) {
        return (*env)->NewStringUTF(env, (UNWRAP_STRUCT_LCONV_PTR(structLconv))->mon_thousands_sep);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    negative_sign
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_negative_1sign
    (JNIEnv *env, jobject structLconv) {
        return (*env)->NewStringUTF(env, (UNWRAP_STRUCT_LCONV_PTR(structLconv))->negative_sign);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    n_cs_precedes
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_n_1cs_1precedes
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->n_cs_precedes;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    n_sep_by_space
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_n_1sep_1by_1space
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->n_sep_by_space;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    n_sign_posn
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_n_1sign_1posn
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->n_sign_posn;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    positive_sign
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_positive_1sign
    (JNIEnv *env, jobject structLconv) {
        return (*env)->NewStringUTF(env, (UNWRAP_STRUCT_LCONV_PTR(structLconv))->positive_sign);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    p_cs_precedes
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_p_1cs_1precedes
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->p_cs_precedes;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    p_sep_by_space
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_p_1sep_1by_1space
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->p_sep_by_space;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    p_sign_posn
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_p_1sign_1posn
    (JNIEnv *env, jobject structLconv) {
        return (UNWRAP_STRUCT_LCONV_PTR(structLconv))->p_sign_posn;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale_Lconv
     * Method:    thousands_sep
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_Locale_00024Lconv_thousands_1sep
    (JNIEnv *env, jobject structLconv) {
        return (*env)->NewStringUTF(env, (UNWRAP_STRUCT_LCONV_PTR(structLconv))->thousands_sep);
    }


#endif
#ifdef __cplusplus
}
#endif
