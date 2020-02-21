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
#include "de_ibapl_jnhw_posix_Sched.h"

#ifdef HAVE_SCHED_H

#include <sched.h>
#include <errno.h>
#include <stdio.h>

#ifdef __cplusplus
extern "C" {
#endif

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
     * Signature: (ILde/ibapl/jnhw/posix/Sched/Sched_param;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1getparam
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jobject sched_param) {
        if (sched_param == NULL) {
            throw_NullPointerException(env, "sched_param is NULL");
            return;
        }
        if (sched_getparam(pid, UNWRAP_STRUCT_SCHED_PARAM_PTR(sched_param))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_getscheduler
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1getscheduler
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid) {
        const int result = sched_getscheduler(pid);
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_rr_get_interval
     * Signature: (ILde/ibapl/jnhw/posix/Time/Timespec;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1rr_1get_1interval
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jobject interval) {
        if (interval == NULL) {
            throw_NullPointerException(env, "interval is NULL");
            return;
        }
        if (sched_rr_get_interval(pid, UNWRAP_STRUCT_TIMESPEC_PTR(interval))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_setparam
     * Signature: (ILde/ibapl/jnhw/posix/Sched/Sched_param;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1setparam
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jobject sched_param) {
        if (sched_param == NULL) {
            throw_NullPointerException(env, "sched_param is NULL");
            return;
        }
        if (sched_setparam(pid, UNWRAP_STRUCT_SCHED_PARAM_PTR(sched_param))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    sched_setscheduler
     * Signature: (IILde/ibapl/jnhw/posix/Sched/Sched_param;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_sched_1setscheduler
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jint policy, jobject param) {
        if (param == NULL) {
            throw_NullPointerException(env, "sched_param is NULL");
            return -1;
        }
        const int result = sched_setscheduler(pid, policy, UNWRAP_STRUCT_SCHED_PARAM_PTR(param));
        if (result == -1) {
            throw_NativeErrorException(env, errno);
        }
        return result;
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


#ifdef __cplusplus
}
#endif
#endif