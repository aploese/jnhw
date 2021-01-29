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

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    HAVE_PTHREAD_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Pthread_HAVE_1PTHREAD_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_PTHREAD_H) && defined(_POSIX_VERSION)
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef _POSIX_VERSION
#include <pthread.h>


    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    PTHREAD_EXPLICIT_SCHED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_PTHREAD_1EXPLICIT_1SCHED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PTHREAD_EXPLICIT_SCHED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    PTHREAD_INHERIT_SCHED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_PTHREAD_1INHERIT_1SCHED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PTHREAD_INHERIT_SCHED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    PTHREAD_CANCEL_DISABLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_PTHREAD_1CANCEL_1DISABLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PTHREAD_CANCEL_DISABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    PTHREAD_CANCEL_ENABLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_PTHREAD_1CANCEL_1ENABLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PTHREAD_CANCEL_ENABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    PTHREAD_CANCEL_DEFERRED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_PTHREAD_1CANCEL_1DEFERRED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PTHREAD_CANCEL_DEFERRED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    PTHREAD_CANCEL_ASYNCHRONOUS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_PTHREAD_1CANCEL_1ASYNCHRONOUS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return PTHREAD_CANCEL_ASYNCHRONOUS;
    }

#endif
#ifdef __cplusplus
}
#endif
