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
#include "de_ibapl_jnhw_posix_Sched.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <sched.h>
#include <errno.h>
#include <stdio.h>
#include <unistd.h>

    JNHW_ASSERT__pid_t__IS__int32_t

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_get_priority_max
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1get_1priority_1max
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint policy) {
        const int result = sched_get_priority_max(policy);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_get_priority_min
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1get_1priority_1min
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint policy) {
        const int result = sched_get_priority_min(policy);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_getparam
     * Signature: (IJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1getparam
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint pid, __attribute__ ((unused)) jlong ptrSched_param) {
        throw_NoSuchNativeMethodException(env, "sched_getparam");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jlong ptrSched_param) {
        if (sched_getparam(pid, (struct sched_param*) (uintptr_t) ptrSched_param)) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_getscheduler
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1getscheduler
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint pid) {
        throw_NoSuchNativeMethodException(env, "sched_getscheduler");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid) {
        const int result = sched_getscheduler(pid);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_rr_get_interval
     * Signature: (IJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1rr_1get_1interval
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint pid, __attribute__ ((unused)) jlong ptrInterval) {
        throw_NoSuchNativeMethodException(env, "sched_rr_get_interval");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jlong ptrInterval) {
        if (sched_rr_get_interval(pid, (struct timespec*) (uintptr_t) ptrInterval)) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_setparam
     * Signature: (IJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1setparam
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint pid, __attribute__ ((unused)) jlong ptrSched_param) {
        throw_NoSuchNativeMethodException(env, "sched_setparam");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jlong ptrSched_param) {
        if (sched_setparam(pid, (struct sched_param*) (uintptr_t) ptrSched_param)) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_setscheduler
     * Signature: (IIJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1setscheduler
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint pid, __attribute__ ((unused)) jint policy, __attribute__ ((unused)) jlong ptrParam) {
        throw_NoSuchNativeMethodException(env, "sched_setscheduler");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jint policy, jlong ptrParam) {
        const int result = sched_setscheduler(pid, policy, (struct sched_param*) (uintptr_t) ptrParam);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_yield
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1yield
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        if (sched_yield()) {
            throw_NativeErrorException(env, errno);
        }
    }


#endif
#ifdef __cplusplus
}
#endif