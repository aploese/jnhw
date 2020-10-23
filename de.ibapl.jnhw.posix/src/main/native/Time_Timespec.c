/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <time.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Timespec
     * Method:    sizeofTimespec
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timespec_sizeofTimespec
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct timespec);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Timespec
     * Method:    tv_sec
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timespec_tv_1sec__
    (JNIEnv *env, jobject structTimespec) {
        return (UNWRAP_STRUCT_TIMESPEC_PTR(structTimespec))->tv_sec;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Timespec
     * Method:    tv_sec
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timespec_tv_1sec__J
    (JNIEnv *env, jobject structTimespec, jlong tv_sec) {
#if defined(__LP64__)
        (UNWRAP_STRUCT_TIMESPEC_PTR(structTimespec))->tv_sec = tv_sec;
#else
        if ((tv_sec > INT32_MAX) || (tv_sec < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation tv_sec is only an integer with the size of jint");
            return;
        }
        (UNWRAP_STRUCT_TIMESPEC_PTR(structTimespec))->tv_sec = (int32_t)tv_sec;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Timespec
     * Method:    tv_nsec
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timespec_tv_1nsec__
    (JNIEnv *env, jobject structTimespec) {
        return (UNWRAP_STRUCT_TIMESPEC_PTR(structTimespec))->tv_nsec;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Time_Timespec
     * Method:    tv_nsec
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Time_00024Timespec_tv_1nsec__J
    (JNIEnv *env, jobject structTimespec, jlong tv_nsec) {
#if defined(__LP64__)
        (UNWRAP_STRUCT_TIMESPEC_PTR(structTimespec))->tv_nsec = tv_nsec;
#else
        if ((tv_nsec > INT32_MAX) || (tv_nsec < INT32_MIN)) {
            throw_IndexOutOfBoundsException(env, "In this native implementation tv_nsec is only an integer with the size of jint");
            return;
        }
        (UNWRAP_STRUCT_TIMESPEC_PTR(structTimespec))->tv_nsec = (int32_t)tv_nsec;
#endif
    }

#endif
#ifdef __cplusplus
}
#endif
