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
#include "de_ibapl_jnhw_posix_Time.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...    
#if !defined(HAVE_TIME_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <time.h>
#include <unistd.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Time
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_TIME_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "CLOCKS_PER_SEC", CLOCKS_PER_SEC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLOCK_MONOTONIC", CLOCK_MONOTONIC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLOCK_PROCESS_CPUTIME_ID", CLOCK_PROCESS_CPUTIME_ID)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLOCK_REALTIME", CLOCK_REALTIME)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLOCK_THREAD_CPUTIME_ID", CLOCK_THREAD_CPUTIME_ID)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TIMER_ABSTIME", TIMER_ABSTIME)) {
            return;
        }
    }

#endif
#ifdef __cplusplus
}
#endif
