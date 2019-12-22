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
#include "de_ibapl_jnhw_posix_Time.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    HAVE_TIME_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Time_HAVE_1TIME_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef HAVE_TIME_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }


#ifdef HAVE_TIME_H

#include <time.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    CLOCKS_PER_SEC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_CLOCKS_1PER_1SEC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCKS_PER_SEC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    CLOCK_MONOTONIC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_CLOCK_1MONOTONIC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCK_MONOTONIC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    CLOCK_PROCESS_CPUTIME_ID
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_CLOCK_1PROCESS_1CPUTIME_1ID
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCK_PROCESS_CPUTIME_ID;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    CLOCK_REALTIME
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_CLOCK_1REALTIME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCK_REALTIME;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    CLOCK_THREAD_CPUTIME_ID
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_CLOCK_1THREAD_1CPUTIME_1ID
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLOCK_THREAD_CPUTIME_ID;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    TIMER_ABSTIME
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_TIMER_1ABSTIME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TIMER_ABSTIME;
    }

#endif
#ifdef __cplusplus
}
#endif
