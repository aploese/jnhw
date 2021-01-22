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
#define _JNHW_COMMON_IMPLEMENTATION_ 1
#include "jnhw-common.h"
#include "de_ibapl_jnhw_common_memory_Int16_t.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_common_memory_Int16_t
 * Method:    sizeof
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_Int16_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (int16_t);
    }

/*
 * Class:     de_ibapl_jnhw_common_memory_Int16_t
 * Method:    alignof
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_Int16_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (int16_t);
    }

/*
 * Class:     de_ibapl_jnhw_common_memory_Int16_t
 * Method:    rawInt16_t
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_common_memory_Int16_1t_rawInt16_1t__
    (JNIEnv *env, jobject jnhw_int16_t) {
        return *UNWRAP_ABSTRACT_MEM_TO(int16_t*, jnhw_int16_t);
    }

/*
 * Class:     de_ibapl_jnhw_common_memory_Int16_t
 * Method:    rawInt16_t
 * Signature: (S)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_Int16_1t_rawInt16_1t__S
    (JNIEnv *env, jobject jnhw_int16_t, jshort value) {
        *UNWRAP_ABSTRACT_MEM_TO(int16_t*, jnhw_int16_t) = value;
    }


/*
 * Class:     de_ibapl_jnhw_common_memory_Int16_t
 * Method:    nativeToString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_Int16_1t_nativeToString
    (JNIEnv *env, jobject jnhw_int16_t) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_int16_t, *UNWRAP_ABSTRACT_MEM_TO(int16_t*, jnhw_int16_t));
        return (*env)->NewStringUTF(env, buf);
    }

#ifdef __cplusplus
}
#endif
