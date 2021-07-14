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
#include "de_ibapl_jnhw_posix_TimeTest_NativeDefines.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...
#if !defined(HAVE_TIME_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeDefines
     * Method:    HAVE_TIME_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeDefines_HAVE_1TIME_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_FALSE;
    }
#else
#include <time.h>

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeDefines
     * Method:    HAVE_TIME_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeDefines_HAVE_1TIME_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_TRUE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeDefines
     * Method:    CLOCKS_PER_SEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeDefines_CLOCKS_1PER_1SEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCKS_PER_SEC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeDefines
     * Method:    CLOCK_MONOTONIC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeDefines_CLOCK_1MONOTONIC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCK_MONOTONIC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeDefines
     * Method:    CLOCK_PROCESS_CPUTIME_ID
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeDefines_CLOCK_1PROCESS_1CPUTIME_1ID
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCK_PROCESS_CPUTIME_ID;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeDefines
     * Method:    CLOCK_REALTIME
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeDefines_CLOCK_1REALTIME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCK_REALTIME;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeDefines
     * Method:    CLOCK_THREAD_CPUTIME_ID
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeDefines_CLOCK_1THREAD_1CPUTIME_1ID
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCK_THREAD_CPUTIME_ID;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_TimeTest_NativeDefines
     * Method:    TIMER_ABSTIME
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_TimeTest_00024NativeDefines_TIMER_1ABSTIME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__)
#if defined(TIMER_ABSTIME)
#error "TIMER_ABSTIME defined"
#endif
        return NULL;
#else
        return JnhwWrapInteger(env, TIMER_ABSTIME);
#endif
    }

#endif
#ifdef __cplusplus
}
#endif
