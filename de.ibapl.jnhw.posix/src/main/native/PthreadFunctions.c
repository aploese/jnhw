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
#include "de_ibapl_jnhw_posix_Pthread.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <pthread.h>
#include <errno.h>
#include <signal.h>
#include <stdlib.h>
#include <unistd.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_self
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1self
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrResult) {
        *((pthread_t*) (uintptr_t) ptrResult) = pthread_self();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_equal
     * Signature: (JJ)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1equal
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrT1, jlong ptrT2) {
        if (pthread_equal(*((pthread_t*) (uintptr_t) ptrT1), *((pthread_t*) (uintptr_t) ptrT2))) {
            return JNI_TRUE;
        } else {
            return JNI_FALSE;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_getinheritsched
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1getinheritsched
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrAttr) {
        int inheritsched;
        const int result = pthread_attr_getinheritsched((pthread_attr_t*) (uintptr_t) ptrAttr, &inheritsched);
        if (result) {
            throw_NativeErrorException(env, result);
        }
        return inheritsched;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_getschedparam
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1getschedparam
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrAttr, jlong ptrParam) {
        const int result = pthread_attr_getschedparam((pthread_attr_t*) (uintptr_t) ptrAttr, (struct sched_param*) (uintptr_t) ptrParam);
        if (result) {
            throw_NativeErrorException(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_setinheritsched
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1setinheritsched
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrAttr, jint inheritsched) {
        const int result = pthread_attr_setinheritsched((pthread_attr_t*) (uintptr_t) ptrAttr, inheritsched);
        if (result) {
            throw_NativeErrorException(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_setschedparam
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1setschedparam
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrAttr, jlong ptrParam) {
        const int result = pthread_attr_setschedparam((pthread_attr_t*) (uintptr_t) ptrAttr, (struct sched_param*) (uintptr_t) ptrParam);
        if (result) {
            throw_NativeErrorException(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_getschedparam
     * Signature: (JJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1getschedparam
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrThread, jlong ptrParam) {
        int policy;
        const int result = pthread_getschedparam(*((pthread_t*) (uintptr_t) ptrThread), &policy, (struct sched_param*) (uintptr_t) ptrParam);
        if (result) {
            throw_NativeErrorException(env, result);
        }
        return policy;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_setschedparam
     * Signature: (JIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1setschedparam
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrThread, jint policy, jlong ptrParam) {
        const int result = pthread_setschedparam(*((pthread_t*) (uintptr_t) ptrThread), policy, (struct sched_param*) (uintptr_t) ptrParam);
        if (result) {
            throw_NativeErrorException(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_setschedprio
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1setschedprio
#if defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong ptrThread, __attribute__ ((unused)) jint prio) {
        throw_NoSuchNativeMethodException(env, "pthread_setschedprio");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrThread, jint prio) {
        const int result = pthread_setschedprio(*((pthread_t*) (uintptr_t) ptrThread), prio);
        if (result) {
            throw_NativeErrorException(env, result);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_getcpuclockid
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1getcpuclockid
#if defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (
            JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong ptrThread_id) {
        throw_NoSuchNativeMethodException(env, "pthread_getcpuclockid");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrThread_id) {
        int result;
        if (pthread_getcpuclockid(*((pthread_t*) (uintptr_t) ptrThread_id), &result)) {
            throw_NativeErrorException(env, errno);
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_destroy
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1destroy
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrAttr) {
        if (pthread_attr_destroy((pthread_attr_t*) (uintptr_t) ptrAttr)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_init
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1init
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrAttr) {
        if (pthread_attr_init((pthread_attr_t*) (uintptr_t) ptrAttr)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_cancel
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1cancel
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrPthread_t) {
        if (pthread_cancel(*((pthread_t*) (uintptr_t) (ptrPthread_t)))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_testcancel
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1testcancel
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        pthread_testcancel();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_setcancelstate
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1setcancelstate
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint state) {
        int oldstate;
        if (pthread_setcancelstate(state, &oldstate)) {
            throw_NativeErrorException(env, errno);
        }
        return oldstate;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_setcanceltype
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1setcanceltype
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint type) {
        int oldtype;
        if (pthread_setcanceltype(type, &oldtype)) {
            throw_NativeErrorException(env, errno);
        }
        return oldtype;
    }

#endif
#ifdef __cplusplus
}
#endif
