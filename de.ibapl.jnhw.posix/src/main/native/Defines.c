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
#include "de_ibapl_jnhw_util_posix_Defines.h"

#include <stdint.h>
#include <unistd.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _LARGEFILE_SOURCE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1LARGEFILE_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(_LARGEFILE_SOURCE)
        return _LARGEFILE_SOURCE;
#else
        throw_NotDefinedException(env, "_LARGEFILE_SOURCE");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _LARGEFILE64_SOURCE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1LARGEFILE64_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(_LARGEFILE64_SOURCE)
        return _LARGEFILE64_SOURCE;
#else
        throw_NotDefinedException(env, "_LARGEFILE64_SOURCE");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __APPLE__
     * Signature: ()Z
     * I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1APPLE_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__)
        return __APPLE__;
#else
        throw_NotDefinedException(env, "__APPLE__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __FreeBSD__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1FreeBSD_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__FreeBSD__)
        return __FreeBSD__;
#else
        throw_NotDefinedException(env, "__FreeBSD__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __OpenBSD__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1OpenBSD_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return __OpenBSD__;
#else
        throw_NotDefinedException(env, "__OpenBSD__");
        return -1;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __WORDSIZE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1WORDSIZE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__WIN32__) || defined(__OpenBSD__)
#if defined(__WORDSIZE)
#error "__WORDSIZE defined"
#endif
        throw_NotDefinedException(env, "__WORDSIZE");
        return 0;
#else
        return __WORDSIZE;
#endif
    }

/*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __SIZEOF_LONG__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1SIZEOF_1LONG_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __SIZEOF_LONG__;
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _FILE_OFFSET_BITS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1FILE_1OFFSET_1BITS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_FILE_OFFSET_BITS)
        return _FILE_OFFSET_BITS;
#else
        throw_NotDefinedException(env, "_FILE_OFFSET_BITS");
        return 0;
#endif
    }

/*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _BSD_SOURCE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1BSD_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_BSD_SOURCE)
        return _BSD_SOURCE;
#else
        throw_NotDefinedException(env, "_BSD_SOURCE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _POSIX_C_SOURCE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1POSIX_1C_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_POSIX_C_SOURCE)
        return _POSIX_C_SOURCE;
#else
        throw_NotDefinedException(env, "_POSIX_C_SOURCE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _XOPEN_SOURCE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1XOPEN_1SOURCE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_XOPEN_SOURCE)
        return _XOPEN_SOURCE;
#else
        throw_NotDefinedException(env, "_XOPEN_SOURCE");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    _XOPEN_SOURCE_EXTENDED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1XOPEN_1SOURCE_1EXTENDED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (_XOPEN_SOURCE_EXTENDED)
        return _XOPEN_SOURCE_EXTENDED;
#else
        throw_NotDefinedException(env, "_XOPEN_SOURCE_EXTENDED");
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_Defines
     * Method:    __linux__
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Defines__1_1linux_1_1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__)
        return __linux__;
#else
        throw_NotDefinedException(env, "__linux__");
        return -1;
#endif
    }

#ifdef __cplusplus
}
#endif