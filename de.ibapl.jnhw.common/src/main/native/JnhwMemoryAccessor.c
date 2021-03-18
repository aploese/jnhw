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

#include "de_ibapl_jnhw_common_memory_JnhwMemoryAccessor.h"
#include <errno.h>
#include <stdlib.h>
#include <string.h>


#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    setMemory0
     * Signature: (JJB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_setMemory0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jlong length, jbyte value) {
        memset((void*) (uintptr_t) address, value, (uint32_t) length);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    copyMemory0
     * Signature: ([BIJJI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_copyMemory0___3BIJJI
    (JNIEnv *env, __attribute__ ((unused))jclass memAcc, jbyteArray src, jint srcPos, jlong destAddress, jlong destPos, jint len) {
        (*env)->GetByteArrayRegion(env, src, srcPos, len, ((void*) (uintptr_t) destAddress) + destPos);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    copyMemory0
     * Signature: (JJ[BII)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_copyMemory0__JJ_3BII
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong srcAddress, jlong srcPos, jbyteArray dest, jint destPos, jint len) {
        (*env)->SetByteArrayRegion(env, dest, destPos, len, ((void*) (uintptr_t) srcAddress) + srcPos);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    intptr_t0
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_intptr_1t0__J
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return (int64_t)*((intptr_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    intptr_t0
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_intptr_1t0__JJ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jlong value) {
#if __SIZEOF_POINTER__ == 8
        * ((intptr_t*) (uintptr_t) address) = (intptr_t) value;
#elif __SIZEOF_POINTER__ == 4
        if ((value > INT32_MAX) || (value < INT32_MIN)) {
            throw_IllegalArgumentException(env, "value outside of int32_t");
            return;
        }
        *((intptr_t*) (uintptr_t) address) = (intptr_t) value;
#else
#error unknown __SIZEOF_POINTER__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    intptr_t_AtIndex0
     * Signature: (JI)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_intptr_1t_1AtIndex0__JI
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint index) {
        return (int64_t)*(((intptr_t*) (uintptr_t) address) + index);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    intptr_t_AtIndex0
     * Signature: (JIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_intptr_1t_1AtIndex0__JIJ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint index, jlong value) {
#if __SIZEOF_POINTER__ == 8
        * (((intptr_t*) (uintptr_t) address) + index) = (intptr_t) value;
#elif __SIZEOF_POINTER__ == 4
        if ((value > INT32_MAX) || (value < INT32_MIN)) {
            throw_IllegalArgumentException(env, "value outside of int32_t");
            return;
        }
        * (((intptr_t*) (uintptr_t) address) + index) = (intptr_t) value;
#else
#error unknown __SIZEOF_POINTER__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uintptr_t0
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t0__J
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
#if __SIZEOF_POINTER__ == 8
        return (int64_t)*((uintptr_t*) (uintptr_t) address);
#elif __SIZEOF_POINTER__ == 4
        return (int64_t) (*((uintptr_t*) (uintptr_t) address) & 0x00000000ffffffff);
#else
#error unknown __SIZEOF_POINTER__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uintptr_t0
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t0__JJ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jlong value) {
#if __SIZEOF_POINTER__ == 8
        * ((uintptr_t*) (uintptr_t) address) = (uintptr_t) value;
#elif __SIZEOF_POINTER__ == 4
        if ((value > 0x00000000ffffffffL)) {
            throw_IllegalArgumentException(env, "value too big for uint32_t");
            return;
        }
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not be negative");
            return;
        }
        * ((uintptr_t*) (uintptr_t) address) = (uintptr_t) value;
#else
#error unknown __SIZEOF_POINTER__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uintptr_t_AtIndex0
     * Signature: (JI)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t_1AtIndex0__JI
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint index) {
#if __SIZEOF_POINTER__ == 8
        return (int64_t)*(((uintptr_t*) (uintptr_t) address) + index);
#elif __SIZEOF_POINTER__ == 4
        return (int64_t) (*(((uintptr_t*) (uintptr_t) address) + index) & 0x00000000ffffffff);
#else
#error unknown __SIZEOF_POINTER__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uintptr_t_AtIndex0
     * Signature: (JIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t_1AtIndex0__JIJ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint index, jlong value) {
#if __SIZEOF_POINTER__ == 8
        *(((uintptr_t*) (uintptr_t) address) + index) = (uintptr_t) value;
#elif __SIZEOF_POINTER__ == 4
        if ((value > 0x00000000ffffffffL)) {
            throw_IllegalArgumentException(env, "value too big for uint32_t");
            return;
        }
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not be negative");
            return;
        }
        *(((uintptr_t*) (uintptr_t) address) + index) = (uintptr_t) value;
#else
#error unknown __SIZEOF_POINTER__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uintptr_t_AsHex0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t_1AsHex0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_HEX_uintptr_t, *((uintptr_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int8_t0
     * Signature: (J)B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int8_1t0__J
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return *((int8_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int8_t0
     * Signature: (JB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int8_1t0__JB
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jbyte value) {
        *((int8_t*) (uintptr_t) address) = value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int8_t_AsHex0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int8_1t_1AsHex0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_HEX_int8_t, 0x000000FF & *((int8_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int8_t_nativeToString0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int8_1t_1nativeToString0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_int8_t, *((int8_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int16_t0
     * Signature: (J)S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int16_1t0__J
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return *((int16_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int16_t0
     * Signature: (JS)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int16_1t0__JS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jshort value) {
        *((int16_t*) (uintptr_t) address) = value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int16_t_AsHex0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int16_1t_1AsHex0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_HEX_int16_t, 0x0000FFFF & *((int16_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int16_t_nativeToString0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int16_1t_1nativeToString0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_int16_t, *((int16_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int32_t0
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int32_1t0__J
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return *((int32_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int32_t0
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int32_1t0__JI
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint value) {
        *((int32_t*) (uintptr_t) address) = value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int32_t_AsHex0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int32_1t_1AsHex0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_HEX_int32_t, *((int32_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int32_t_nativeToString0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int32_1t_1nativeToString0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_int32_t, *((int32_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int64_t0
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int64_1t0__J
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return *((int64_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int64_t0
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int64_1t0__JJ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jlong value) {
        *((int64_t*) (uintptr_t) address) = value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int64_t_AsHex0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int64_1t_1AsHex0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_HEX_int64_t, *((int64_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    int64_t_nativeToString0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_int64_1t_1nativeToString0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_int64_t, *((int64_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint8_t0
     * Signature: (J)B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t0__J
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return *((int8_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint8_t_AsShort0
     * Signature: (J)S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t_1AsShort0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return (int16_t)*((uint8_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint8_t0
     * Signature: (JB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t0__JB
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jbyte value) {
        *((uint8_t*) (uintptr_t) address) = (uint8_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint8_t_FromShort0
     * Signature: (JS)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t_1FromShort0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jshort value) {
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not be negative");
            return;
        }
        *((uint8_t*) (uintptr_t) address) = (uint8_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint8_t_AsHex0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t_1AsHex0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_HEX_uint8_t, 0x000000FF & *((uint8_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint8_t_nativeToString0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint8_1t_1nativeToString0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_uint8_t, *((uint8_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint16_t0
     * Signature: (J)S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t0__J
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return *((int16_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint16_t_AsInt0
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t_1AsInt0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return (int32_t)*((uint16_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint16_t0
     * Signature: (JS)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t0__JS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jshort value) {
        *((uint16_t*) (uintptr_t) address) = (uint16_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint16_t_FromInt0
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t_1FromInt0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint value) {
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not be negative");
            return;
        }
        *((uint16_t*) (uintptr_t) address) = (uint16_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint16_t_AsHex0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t_1AsHex0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_HEX_uint16_t, 0x0000FFFF & *((uint16_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint16_t_nativeToString0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint16_1t_1nativeToString0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_uint16_t, *((uint16_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint32_t0
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t0__J
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return *((int32_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint32_t_AsLong0
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t_1AsLong0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return (int64_t)*((uint32_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint32_t0
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t0__JI
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint value) {
        *((uint32_t*) (uintptr_t) address) = (uint32_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint32_t_FromLong0
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t_1FromLong0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jlong value) {
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not be negative");
            return;
        }
        *((uint32_t*) (uintptr_t) address) = (uint32_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint32_t_AsHex0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t_1AsHex0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_HEX_uint32_t, *((uint32_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint32_t_nativeToString0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint32_1t_1nativeToString0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_uint32_t, *((uint32_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint64_t0
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint64_1t0__J
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return *((int64_t*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint64_t0
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint64_1t0__JJ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jlong value) {
        *((uint64_t*) (uintptr_t) address) = (uint64_t) value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint64_t_AsHex0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint64_1t_1AsHex0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_HEX_uint64_t, *((uint64_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uint64_t_nativeToString0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uint64_1t_1nativeToString0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_uint64_t, *((uint64_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    ENOMEM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_ENOMEM
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return ENOMEM;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    malloc
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_malloc
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jlong sizeInBytes) {
        if (sizeInBytes < 0) {
            throw_IllegalArgumentException(env, "sizeInBytes is negative!");
            return -1;
        }
#if defined(_LP64)
        void* result = malloc((uint64_t) sizeInBytes);
#else
        if (sizeInBytes > UINT32_MAX) {
            throw_IllegalArgumentException(env, "sizeInBytes > UINT32_MAX!");
            return -1;
        }
        void* result = malloc((uint32_t) sizeInBytes);
#endif
        if (result == NULL) {
            throw_NativeErrorException(env, errno);
            return -1;
        }
        //on 32bit it must not be negative
        return (int64_t) (uintptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    free
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_free
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz, jlong address) {
        free((void*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    signed_long0
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_signed_1long0__J
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        return *((long*) (uintptr_t) address);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    signed_long0
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_signed_1long0__JJ
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jlong value) {
#if __SIZEOF_LONG__ == 8
        *((long*) (uintptr_t) address) = value;
#elif __SIZEOF_LONG__ == 4
        if ((value > INT32_MAX) || (value < INT32_MIN)) {
            throw_IllegalArgumentException(env, "value outside of int32_t");
            return;
        }
        *((long*) (uintptr_t) address) = (long) value;
#else
#error unknown __SIZEOF_LONG__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    signed_long_AtIndex0
     * Signature: (JI)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_signed_1long_1AtIndex0__JI
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint index) {
#if __SIZEOF_LONG__ == 8
        return *(((long*) (uintptr_t) address) + index);
#elif __SIZEOF_LONG__ == 4
        return *(((long*) (uintptr_t) address) + index);
#else
#error unknown __SIZEOF_LONG__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    signed_long_AtIndex0
     * Signature: (JIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_signed_1long_1AtIndex0__JIJ
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint index, jlong value) {
#if __SIZEOF_LONG__ == 8
        *(((long*) (uintptr_t) address) + index) = value;
#elif __SIZEOF_LONG__ == 4
        if ((value > INT32_MAX) || (value < INT32_MIN)) {
            throw_IllegalArgumentException(env, "value outside of int32_t");
            return;
        }
        *(((long*) (uintptr_t) address) + index) = (long) value;
#else
#error unknown __SIZEOF_LONG__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    unsigned_long0
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_unsigned_1long0__J
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
#if __SIZEOF_LONG__ == 8
        return (int64_t)*((unsigned long*) (uintptr_t) address);
#elif __SIZEOF_LONG__ == 4
        return (int64_t) (*((unsigned long*) (uintptr_t) address) & 0x00000000ffffffff);
#else
#error unknown __SIZEOF_LONG__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    unsigned_long0
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_unsigned_1long0__JJ
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jlong value) {
#if __SIZEOF_LONG__ == 8
        *((unsigned long*) (uintptr_t) address) = (uint64_t) value;
#elif __SIZEOF_LONG__ == 4
        if ((value > 0x00000000ffffffffL)) {
            throw_IllegalArgumentException(env, "value too big for uint32_t");
            return;
        }
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not be negative");
            return;
        }
        *((unsigned long*) (uintptr_t) address) = (uint32_t) value;
#else
#error unknown __SIZEOF_LONG__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    unsigned_long_AtIndex0
     * Signature: (JI)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_unsigned_1long_1AtIndex0__JI
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint index) {
#if __SIZEOF_LONG__ == 8
        return (int64_t)*(((unsigned long*) (uintptr_t) address) + index);
#elif __SIZEOF_LONG__ == 4
        return (int64_t) (*(((unsigned long*) (uintptr_t) address) + index) & 0x00000000ffffffff);
#else
#error unknown __SIZEOF_LONG__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    unsigned_long_AtIndex0
     * Signature: (JIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_unsigned_1long_1AtIndex0__JIJ
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address, jint index, jlong value) {
#if __SIZEOF_LONG__ == 8
        *(((unsigned long*) (uintptr_t) address) + index) = (uint64_t) value;
#elif __SIZEOF_LONG__ == 4
        if ((value > 0x00000000ffffffffL)) {
            throw_IllegalArgumentException(env, "value too big for uint32_t");
            return;
        }
        if (value < 0) {
            throw_IllegalArgumentException(env, "value must not be negative");
            return;
        }
        *(((unsigned long*) (uintptr_t) address) + index) = (uint32_t) value;
#else
#error unknown __SIZEOF_LONG__
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    intptr_t_AsHex0
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_intptr_1t_1AsHex0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused))jclass memAcc, jlong address) {
        char buf[128] = {0};
        snprintf(buf, sizeof (buf) - 1, JNHW_FORMAT_STRING_HEX_intptr_t, *((intptr_t*) (uintptr_t) address));
        return (*env)->NewStringUTF(env, buf);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    uintptr_t0
     * Signature: (JLjava/nio/ByteBuffer;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_uintptr_1t0__JLjava_nio_ByteBuffer_2I
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address, jobject byteBuffer, jint off) {
        *((void**) (uintptr_t) address) = (*env)->GetDirectBufferAddress(env, byteBuffer) + off;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    callJniNewStringUTF
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_callJniNewStringUTF
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address) {
        return (*env)->NewStringUTF(env, ((char*) (intptr_t) address));
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    callJniGetStringUTFRegion
     * Signature: (Ljava/lang/String;IJI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_callJniGetStringUTFRegion
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring s, jint srcStart, jlong address, jint len) {
        (*env)->GetStringUTFRegion(env, s, srcStart, len, ((char*) (intptr_t) address));
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    callJniGetStringUTFLength
     * Signature: (Ljava/lang/String;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_callJniGetStringUTFLength
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring s) {
        return (*env)->GetStringUTFLength(env, s);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    callJniNewString
     * Signature: (JII)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_callJniNewString
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address, jint start, jint len) {
        return (*env)->NewString(env, (((jchar*) (uintptr_t) address) + start), len);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    callJniGetStringRegion
     * Signature: (Ljava/lang/String;IJII)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_callJniGetStringRegion
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring s, jint srcStart, jlong address, jint destStart, jint len) {
        (*env)->GetStringRegion(env, s, srcStart, len, (((jchar*) (uintptr_t) address) + destStart));
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_JnhwMemoryAccessor
     * Method:    callJniGetStringLength
     * Signature: (Ljava/lang/String;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_JnhwMemoryAccessor_callJniGetStringLength
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring s) {
        return (*env)->GetStringLength(env, s);
    }

#ifdef __cplusplus
}
#endif
