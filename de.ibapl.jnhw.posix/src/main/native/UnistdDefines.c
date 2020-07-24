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
#ifdef __cplusplus
extern "C" {
#endif

#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Unistd.h"

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    HAVE_UNISTD_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Unistd_HAVE_1UNISTD_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef HAVE_UNISTD_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#if HAVE_UNISTD_H
#include <unistd.h>
#endif

#ifdef _POSIX_VERSION

#include <stdio.h>
#include <errno.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    SEEK_SET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_SEEK_1SET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_SET;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    SEEK_CUR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_SEEK_1CUR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_CUR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    SEEK_END
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_SEEK_1END
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_END;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    SEEK_DATA
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_SEEK_1DATA
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(SEEK_DATA)
#error "SEEK_DATA defined"
#endif
        throw_NotDefinedException(env, "SEEK_DATA");
        return 0;
#else
        return SEEK_DATA;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    SEEK_HOLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_SEEK_1HOLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(SEEK_HOLE)
#error "SEEK_HOLE defined"
#endif
        throw_NotDefinedException(env, "SEEK_HOLE");
        return 0;
#else
        return SEEK_HOLE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    STDIN_FILENO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_STDIN_1FILENO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return STDIN_FILENO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    STDOUT_FILENO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_STDOUT_1FILENO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return STDOUT_FILENO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    STDERR_FILENO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Unistd_STDERR_1FILENO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return STDERR_FILENO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    _POSIX_VERSION
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_Unistd__1POSIX_1VERSION
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return _POSIX_VERSION;
    }


#endif

#ifdef __cplusplus
}
#endif
