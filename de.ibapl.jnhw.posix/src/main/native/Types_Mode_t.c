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
#include "de_ibapl_jnhw_posix_sys_Types_Mode_t.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION    
#include <sys/types.h>

JNHW_ASSERT__mode_t__IS__uint16_t__OR__uint32_t

/*
 * Class:     de_ibapl_jnhw_posix_sys_Types_Mode_t
 * Method:    sizeof
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Mode_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (mode_t);
    }

/*
 * Class:     de_ibapl_jnhw_posix_sys_Types_Mode_t
 * Method:    alignof
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Mode_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (mode_t);
    }

/*
 * Class:     de_ibapl_jnhw_posix_sys_Types_Mode_t
 * Method:    unsigned
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Mode_1t_unsigned
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (0 < (mode_t)-1);
    }

/*
 * Class:     de_ibapl_jnhw_posix_sys_Types_Mode_t
 * Method:    getValue
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Mode_1t_getValue
    (JNIEnv *env, jobject jnhw_mode_t) {
        return (int32_t) *UNWRAP_ABSTRACT_MEM_TO(mode_t*, jnhw_mode_t);
    }

/*
 * Class:     de_ibapl_jnhw_posix_sys_Types_Mode_t
 * Method:    setValue
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Mode_1t_setValue
    (JNIEnv *env, jobject jnhw_mode_t, jint value) {
#if defined(_JNHW__mode_t__IS__uint16_t)
        if ((value > UINT16_MAX) || (value < 0)) {
            throw_IllegalArgumentException(env, "value outside mode_t(uint16_t)");
            return;
        }
#elif defined(_JNHW__mode_t__IS__uint32_t)
#else
#error expected mode_t uint16_t or uint32_t
#endif 
        *UNWRAP_ABSTRACT_MEM_TO(mode_t*, jnhw_mode_t) = (mode_t)value;
    }

/*
 * Class:     de_ibapl_jnhw_posix_sys_Types_Mode_t
 * Method:    nativeToString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_posix_sys_Types_00024Mode_1t_nativeToString
    (JNIEnv *env, jobject jnhw_mode_t) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_mode_t, *UNWRAP_ABSTRACT_MEM_TO(mode_t*, jnhw_mode_t));
        return (*env)->NewStringUTF(env, buf);
    }

#endif
#ifdef __cplusplus
}
#endif
