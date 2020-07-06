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
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Locale.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    HAVE_LOCALE_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Locale_HAVE_1LOCALE_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_LOCALE_H) && defined(_POSIX_VERSION)
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }


#if defined(_POSIX_VERSION)
#include <locale.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_ALL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1ALL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_ALL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_ALL_MASK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1ALL_1MASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_ALL_MASK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_COLLATE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1COLLATE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_COLLATE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_COLLATE_MASK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1COLLATE_1MASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_COLLATE_MASK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_CTYPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1CTYPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_CTYPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_CTYPE_MASK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1CTYPE_1MASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_CTYPE_MASK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_GLOBAL_LOCALE
     * Signature: ()Lde/ibapl/jnhw/posix/Locale$Locale_t;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1GLOBAL_1LOCALE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_LOCALE_T(LC_GLOBAL_LOCALE);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_MESSAGES
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1MESSAGES
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_MESSAGES;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_MESSAGES_MASK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1MESSAGES_1MASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_MESSAGES_MASK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_MONETARY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1MONETARY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_MONETARY;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_MONETARY_MASK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1MONETARY_1MASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_MONETARY_MASK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_NUMERIC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1NUMERIC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_NUMERIC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_NUMERIC_MASK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1NUMERIC_1MASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_NUMERIC_MASK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_TIME
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1TIME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_TIME;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    LC_TIME_MASK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Locale_LC_1TIME_1MASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return LC_TIME_MASK;
    }

#endif
#ifdef __cplusplus
}
#endif