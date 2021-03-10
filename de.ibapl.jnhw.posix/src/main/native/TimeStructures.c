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
#include "de_ibapl_jnhw_posix_Time_Timespec.h"
#include "de_ibapl_jnhw_posix_Time_Itimerspec.h"
#include "de_ibapl_jnhw_posix_Time_Timer_t.h"
#include "de_ibapl_jnhw_posix_Time_Tm.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <time.h>

    //for offsetof
#include <stddef.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Timespec
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Time/Timespec/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timespec_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (struct timespec), __alignof__ (struct timespec));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "tv_sec", offsetof(struct timespec, tv_sec))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "tv_nsec", offsetof(struct timespec, tv_nsec))) {
            return result;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Itimerspec
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Time/Itimerspec/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_00024Itimerspec_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (struct itimerspec), __alignof__ (struct itimerspec));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "it_interval", offsetof(struct itimerspec, it_interval))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "it_value", offsetof(struct itimerspec, it_value))) {
            return result;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Timer_t
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Time/Timer_t/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timer_1t_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (timer_t), __alignof__ (timer_t));
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Tm
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Time/Tm/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Time_00024Tm_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (struct tm), __alignof__ (struct tm));
        if (result == NULL) {
            return NULL;
        }
        //TODO   ASSERT SIZE sign

        if (JnhwSetLongField(env, result, "tm_sec", offsetof(struct tm, tm_sec))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "tm_min", offsetof(struct tm, tm_min))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "tm_hour", offsetof(struct tm, tm_hour))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "tm_mday", offsetof(struct tm, tm_mday))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "tm_mon", offsetof(struct tm, tm_mon))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "tm_year", offsetof(struct tm, tm_year))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "tm_wday", offsetof(struct tm, tm_wday))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "tm_yday", offsetof(struct tm, tm_yday))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "tm_isdst", offsetof(struct tm, tm_isdst))) {
            return result;
        }
        return result;
    }


#endif
#ifdef __cplusplus
}
#endif
