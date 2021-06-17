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
#include "de_ibapl_jnhw_posix_SchedTest_NativeSched_param.h"

#ifdef __cplusplus
extern "C" {
#endif
    //for offsetof
#include <stddef.h>
#include <unistd.h>

#ifdef _POSIX_VERSION
#include <sched.h>

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeSched_param
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeSched_1param_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct sched_param);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeSched_param
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeSched_1param_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct sched_param);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeSched_param
     * Method:    sched_priority
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeSched_1param_sched_1priority
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct sched_param, sched_priority);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeSched_param
     * Method:    sched_ss_low_priority
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeSched_1param_sched_1ss_1low_1priority
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
        return -1;
#else
        return offsetof(struct sched_param, sched_ss_low_priority);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeSched_param
     * Method:    sched_ss_repl_period
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeSched_1param_sched_1ss_1repl_1period
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
        return -1;
#else
        return offsetof(struct sched_param, sched_ss_repl_period);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeSched_param
     * Method:    sched_ss_init_budget
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeSched_1param_sched_1ss_1init_1budget
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
        return -1;
#else
        return offsetof(struct sched_param, sched_ss_init_budget);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SchedTest_NativeSched_param
     * Method:    sched_ss_max_repl
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SchedTest_00024NativeSched_1param_sched_1ss_1max_1repl
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
        return -1;
#else
        return offsetof(struct sched_param, sched_ss_max_repl);
#endif
    }

#endif
#ifdef __cplusplus
}
#endif
