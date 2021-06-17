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
#include "de_ibapl_jnhw_posix_SchedTest_NativeDefines.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...
#if !defined(HAVE_SCHED_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeDefines
     * Method:    HAVE_SCHED_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeDefines_HAVE_1SCHED_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_FALSE;
    }
#else
#include <sched.h>

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeDefines
     * Method:    HAVE_SCHED_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeDefines_HAVE_1SCHED_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_TRUE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeDefines
     * Method:    SCHED_FIFO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeDefines_SCHED_1FIFO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SCHED_FIFO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeDefines
     * Method:    SCHED_OTHER
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeDefines_SCHED_1OTHER
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SCHED_OTHER;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeDefines
     * Method:    SCHED_RR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeDefines_SCHED_1RR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SCHED_RR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeDefines
     * Method:    SCHED_SPORADIC
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeDefines_SCHED_1SPORADIC
#if defined (__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return NULL;
#elif not defined(SCHED_SPORADIC)
#error "SCHED_SPORADIC not defined defined"
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JnhwWrapInteger(env, SCHED_SPORADIC);
#endif
    }

#endif
#ifdef __cplusplus
}
#endif
