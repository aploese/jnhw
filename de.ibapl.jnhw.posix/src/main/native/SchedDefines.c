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

    //We need the POSIX version ...    
#if !defined(HAVE_SCHED_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <sched.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Sched
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Sched_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_SCHED_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "SCHED_FIFO", SCHED_FIFO)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SCHED_RR", SCHED_RR)) {
            return;
        }

#if defined (__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__) 
#elif not defined(SCHED_SPORADIC)
#error "SCHED_SPORADIC not defined defined"
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "SCHED_SPORADIC", SCHED_SPORADIC)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "SCHED_OTHER", SCHED_OTHER)) {
            return;
        }
    }


#endif
#ifdef __cplusplus
}
#endif
