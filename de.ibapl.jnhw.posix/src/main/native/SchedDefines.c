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

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    HAVE_SCHED_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Sched_HAVE_1SCHED_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_SCHED_H) && defined(_POSIX_VERSION)
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }


#ifdef _POSIX_VERSION
#include <sched.h>


    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    SCHED_FIFO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_SCHED_1FIFO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SCHED_FIFO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    SCHED_RR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_SCHED_1RR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SCHED_RR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    SCHED_SPORADIC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_SCHED_1SPORADIC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined (__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__) 
        throw_NotDefinedException(env, "SCHED_SPORADIC");
        return 0;
#elif not defined(SCHED_SPORADIC)
#error "SCHED_SPORADIC not defined defined"
#else
        return SCHED_SPORADIC;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    SCHED_OTHER
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Sched_SCHED_1OTHER
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SCHED_OTHER;
    }


#endif
#ifdef __cplusplus
}
#endif
