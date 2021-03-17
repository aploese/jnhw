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

#include "de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor.h"
#include <errno.h>
#include <stdlib.h>
#include <string.h>


#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor
     * Method:    uintptr_t0
     * Signature: (JLjava/nio/ByteBuffer;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor_uintptr_1t0
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address, jobject byteBuffer, jint off) {
        *((void**) (intptr_t) address) = (*env)->GetDirectBufferAddress(env, byteBuffer) + off;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor
     * Method:    callJniNewStringUTF
     * Signature: (J)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor_callJniNewStringUTF
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address) {
        return (*env)->NewStringUTF(env, ((char*) (intptr_t) address));
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor
     * Method:    callJniGetStringUTFRegion
     * Signature: (Ljava/lang/String;IJI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor_callJniGetStringUTFRegion
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring s, jint srcStart, jlong address, jint len) {
        (*env)->GetStringUTFRegion(env, s, srcStart, len, ((char*) (intptr_t) address));
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor
     * Method:    callJniGetStringUTFLength
     * Signature: (Ljava/lang/String;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor_callJniGetStringUTFLength
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring s) {
        return (*env)->GetStringUTFLength(env, s);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor
     * Method:    callJniNewString
     * Signature: (JII)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor_callJniNewString
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong address, jint start, jint len) {
        return (*env)->NewString(env, (((jchar*) (uintptr_t) address) + start), len);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor
     * Method:    callJniGetStringRegion
     * Signature: (Ljava/lang/String;IJII)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor_callJniGetStringRegion
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring s, jint srcStart, jlong address, jint destStart, jint len) {
        (*env)->GetStringRegion(env, s, srcStart, len, (((jchar*) (uintptr_t) address) + destStart));
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor
     * Method:    callJniGetStringLength
     * Signature: (Ljava/lang/String;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_UnsafeMemoryAccessor_callJniGetStringLength
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring s) {
        return (*env)->GetStringLength(env, s);
    }

#ifdef __cplusplus
}
#endif
