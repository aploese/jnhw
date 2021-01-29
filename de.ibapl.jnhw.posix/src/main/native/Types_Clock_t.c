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
#include "de_ibapl_jnhw_posix_sys_Types_Clock_t.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION    
#include <sys/types.h>

JNHW_ASSERT__clock_t__IS__int64_t__OR__int32_t

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Types_Clock_t
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Clock_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (clock_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Types_Clock_t
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Clock_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (clock_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Types_Clock_t
     * Method:    unsigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Clock_1t_unsigned
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (0 < (clock_t)-1);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Types_Clock_t
     * Method:    getValue
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Clock_1t_getValue
    (JNIEnv *env, jobject jnhw_clock_t) {
        return (int64_t) *UNWRAP_ABSTRACT_MEM_TO(clock_t*, jnhw_clock_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Types_Clock_t
     * Method:    setValue
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Clock_1t_setValue
    (JNIEnv *env, jobject jnhw_clock_t, jlong value) {
#if defined(_JNHW__clock_t__IS__int32_t)
        if ((value > INT32_MAX) || (value < INT32_MIN)) {
            throw_IllegalArgumentException(env, "value outside clock_t(int32_t)");
            return;
        }
#elif defined(_JNHW__clock_t__IS__int64_t)
#else
#error expected clock_t is int32_t or int64_t
#endif 
        *UNWRAP_ABSTRACT_MEM_TO(clock_t*, jnhw_clock_t) = (clock_t)value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_sys_Types_Clock_t
     * Method:    nativeToString
     * Signature: ()Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Clock_1t_nativeToString
    (JNIEnv *env, jobject jnhw_clock_t) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_clock_t, *UNWRAP_ABSTRACT_MEM_TO(clock_t*, jnhw_clock_t));
        return (*env)->NewStringUTF(env, buf);
    }

#endif
#ifdef __cplusplus
}
#endif
