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

    //We need the POSIX version ...    
#if !defined(HAVE_PTHREAD_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <pthread.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_PTHREAD_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "PTHREAD_EXPLICIT_SCHED", PTHREAD_EXPLICIT_SCHED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "PTHREAD_INHERIT_SCHED", PTHREAD_INHERIT_SCHED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "PTHREAD_CANCEL_DISABLE", PTHREAD_CANCEL_DISABLE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "PTHREAD_CANCEL_ENABLE", PTHREAD_CANCEL_ENABLE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "PTHREAD_CANCEL_DEFERRED", PTHREAD_CANCEL_DEFERRED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "PTHREAD_CANCEL_ASYNCHRONOUS", PTHREAD_CANCEL_ASYNCHRONOUS)) {
            return;
        }
    }

#endif
#ifdef __cplusplus
}
#endif
