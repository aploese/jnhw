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
#include "de_ibapl_jnhw_posix_Termios_Cc_t.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION    
#include <termios.h>

    JNHW_ASSERT__cc_t__IS__uint8_t

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_Cc_t
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024Cc_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (cc_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_Cc_t
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Termios_00024Cc_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (cc_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_Cc_t
     * Method:    unsigned
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Termios_00024Cc_1t_unsigned
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (0 < (cc_t) - 1);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_Cc_t
     * Method:    getValue
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_posix_Termios_00024Cc_1t_getValue
    (JNIEnv *env, jobject jnhw_cc_t) {
        return (int8_t) *UNWRAP_ABSTRACT_MEM_TO(cc_t*, jnhw_cc_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Termios_Cc_t
     * Method:    setValue
     * Signature: (B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Termios_00024Cc_1t_setValue
    (JNIEnv *env, jobject jnhw_cc_t, jbyte value) {
        *UNWRAP_ABSTRACT_MEM_TO(cc_t*, jnhw_cc_t) = (uint8_t) value;
    }

#endif
#ifdef __cplusplus
}
#endif
