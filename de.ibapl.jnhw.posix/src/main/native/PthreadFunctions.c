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
        //This is private, so it can't be NULL
        *UNWRAP_PTHREAD_T_PTR(result) = pthread_self();
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_equal
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_t;Lde/ibapl/jnhw/posix/Pthread/Pthread_t;)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1equal
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject t1, jobject t2) {
        if (t1 == NULL) {
            throw_NullPointerException(env, "t1 is NULL");
            return JNI_FALSE;
        }
        if (t2 == NULL) {
            throw_NullPointerException(env, "t2 is NULL");
            return JNI_FALSE;
        }
        if (pthread_equal(*UNWRAP_PTHREAD_T_PTR(t1), *UNWRAP_PTHREAD_T_PTR(t2))) {
            return JNI_TRUE;
        } else {
            return JNI_FALSE;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_getinheritsched
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_attr_t;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1getinheritsched
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject attr) {
        if (attr == NULL) {
            throw_NullPointerException(env, "attr is NULL");
            return -1;
        }
        int inheritsched;
        const int result = pthread_attr_getinheritsched(UNWRAP_PTHREAD_ATTR_T_PTR(attr), &inheritsched);
        if (result) {
            throw_NativeErrorException(env, result);
        }
        return inheritsched;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_getschedparam
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_attr_t;Lde/ibapl/jnhw/posix/Sched/Sched_param;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1getschedparam
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject attr, jobject param) {
        if (attr == NULL) {
            throw_NullPointerException(env, "attr is NULL");
            return;
        }
        if (param == NULL) {
            throw_NullPointerException(env, "param is NULL");
            return;
        }
        const int result = pthread_attr_getschedparam(UNWRAP_PTHREAD_ATTR_T_PTR(attr), UNWRAP_STRUCT_SCHED_PARAM_PTR(param));
        if (result) {
            throw_NativeErrorException(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_setinheritsched
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_attr_t;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1setinheritsched
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject attr, jint inheritsched) {
        if (attr == NULL) {
            throw_NullPointerException(env, "attr is NULL");
            return;
        }
        const int result = pthread_attr_setinheritsched(UNWRAP_PTHREAD_ATTR_T_PTR(attr), inheritsched);
        if (result) {
            throw_NativeErrorException(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_setschedparam
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_attr_t;Lde/ibapl/jnhw/posix/Sched/Sched_param;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1setschedparam
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject attr, jobject param) {
        if (attr == NULL) {
            throw_NullPointerException(env, "attr is NULL");
            return;
        }
        if (param == NULL) {
            throw_NullPointerException(env, "param is NULL");
            return;
        }
        const int result = pthread_attr_setschedparam(UNWRAP_PTHREAD_ATTR_T_PTR(attr), UNWRAP_STRUCT_SCHED_PARAM_PTR(param));
        if (result) {
            throw_NativeErrorException(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_getschedparam
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_t;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/posix/Sched/Sched_param;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1getschedparam
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject thread, jobject policy, jobject param) {
        if (thread == NULL) {
            throw_NullPointerException(env, "thread is NULL");
            return;
        }
        if (policy == NULL) {
            throw_NullPointerException(env, "policy is NULL");
            return;
        }
        if (param == NULL) {
            throw_NullPointerException(env, "param is NULL");
            return;
        }
        int _policy = GET_INT_REF_VALUE(policy);
        const int result = pthread_getschedparam(*UNWRAP_PTHREAD_T_PTR(thread), &_policy, UNWRAP_STRUCT_SCHED_PARAM_PTR(param));
        SET_INT_REF_VALUE(policy, _policy);
        if (result) {
            throw_NativeErrorException(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_setschedparam
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_t;ILde/ibapl/jnhw/posix/Sched/Sched_param;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1setschedparam
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject thread, jint policy, jobject param) {
        if (thread == NULL) {
            throw_NullPointerException(env, "thread is NULL");
            return;
        }
        if (param == NULL) {
            throw_NullPointerException(env, "param is NULL");
            return;
        }
        const int result = pthread_setschedparam(*UNWRAP_PTHREAD_T_PTR(thread), policy, UNWRAP_STRUCT_SCHED_PARAM_PTR(param));
        if (result) {
            throw_NativeErrorException(env, result);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_setschedprio
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_t;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1setschedprio
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject thread, jint prio) {
        if (thread == NULL) {
            throw_NullPointerException(env, "thread is NULL");
            return;
        }
        const int result = pthread_setschedprio(*UNWRAP_PTHREAD_T_PTR(thread), prio);
        if (result) {
            throw_NativeErrorException(env, result);
        }

    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_getcpuclockid
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_t;Lde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1getcpuclockid
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject thread_id, jobject clock_id) {
        if (thread_id == NULL) {
            throw_NullPointerException(env, "thread_id is NULL");
            return;
        }
        if (clock_id == NULL) {
            throw_NullPointerException(env, "clock_id is NULL");
            return;
        }
        clockid_t _clock_id = GET_INT_REF_VALUE(clock_id);

        if (pthread_getcpuclockid(*UNWRAP_PTHREAD_T_PTR(thread_id), &_clock_id)) {
            throw_NativeErrorException(env, errno);
        }
        SET_INT_REF_VALUE(clock_id, _clock_id);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_destroy
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_attr_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1destroy
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject attr) {
        if (attr == NULL) {
            throw_NullPointerException(env, "attr is null");
            return;
        }
        if (pthread_attr_destroy(UNWRAP_PTHREAD_ATTR_T_PTR(attr))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Pthread
     * Method:    pthread_attr_init
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_attr_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Pthread_pthread_1attr_1init
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject attr) {
        if (attr == NULL) {
            throw_NullPointerException(env, "attr is null");
            return;
        }
        if (pthread_attr_init(UNWRAP_PTHREAD_ATTR_T_PTR(attr))) {
            throw_NativeErrorException(env, errno);
        }
    }

#ifdef __cplusplus
}
#endif
#endif
