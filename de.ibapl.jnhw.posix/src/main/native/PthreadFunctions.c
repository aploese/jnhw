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
#include <signal.h>
#include <stdlib.h>

#include "jnhw-posix.h"

#ifdef HAVE_PTHREAD_H

#include "de_ibapl_jnhw_posix_Pthread.h"
#include <pthread.h>
#include <errno.h>


#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_self0
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1self0
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject result) {
        *UNWRAP_PTHREAD_T_PTR(result) = pthread_self();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_equal
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_t;Lde/ibapl/jnhw/posix/Pthread/Pthread_t;)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1equal
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject t1, jobject t2) {
        if (pthread_equal(*UNWRAP_PTHREAD_T_PTR(t1), *UNWRAP_PTHREAD_T_PTR(t2))) {
            return JNI_TRUE;
        } else {
            return JNI_FALSE;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_getcpuclockid
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_t;Lde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1getcpuclockid
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject thread_id, jobject clock_id) {
        if (clock_id == NULL) {
            throw_NullPointerException(env, "clock_id is null");
            return;
        }
        clockid_t _clock_id = GET_INT_REF_VALUE(clock_id);

        if (pthread_getcpuclockid(*UNWRAP_PTHREAD_T_PTR(thread_id), &_clock_id)) {
            throw_NativeErrorException(env, errno);
            return;
        }

        SET_INT_REF_VALUE(clock_id, _clock_id);
    }

#ifdef __cplusplus
}
#endif
#endif
