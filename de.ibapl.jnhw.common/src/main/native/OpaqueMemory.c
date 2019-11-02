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
#define _JNHW_COMMON_IMPLEMENTATION_ 1
#include "jnhw-common.h"

#include "de_ibapl_jnhw_OpaqueMemory.h"
#include <errno.h>
#include <stdlib.h>
#include <string.h>


#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    copy
     * Signature: ([BILde/ibapl/jnhw/OpaqueMemory;II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_OpaqueMemory_copy___3BILde_ibapl_jnhw_OpaqueMemory_2II
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jbyteArray src, jint srcPos, jobject dest, jint destPos, jint len) {
        if (outOfBoundsByteArray(env, srcPos, len, src)) {
            throw_ArrayIndexOutOfBoundsException(env, "Source ArrayIndex!");
            return;
        }
        if (outOfBoundsOpaqueMemory(env, destPos, len, dest)) {
            throw_IndexOutOfBoundsException(env, "Index outside of destinated opaque memory!");
            return;
        }
        (*env)->GetByteArrayRegion(env, src, srcPos, len, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(dest) + destPos);
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    copy
     * Signature: (Lde/ibapl/jnhw/OpaqueMemory;I[BII)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_OpaqueMemory_copy__Lde_ibapl_jnhw_OpaqueMemory_2I_3BII
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject src, jint srcPos, jbyteArray dest, jint destPos, jint len) {
        if (outOfBoundsOpaqueMemory(env, srcPos, len, src)) {
            throw_IndexOutOfBoundsException(env, "Source index outside of opaque memory!");
            return;
        }
        if (outOfBoundsByteArray(env, destPos, len, dest)) {
            throw_ArrayIndexOutOfBoundsException(env, "Destination ArrayIndex!");
            return;
        }
        (*env)->SetByteArrayRegion(env, dest, destPos, len, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(src) + srcPos);
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    setByte
     * Signature: (Lde/ibapl/jnhw/OpaqueMemory;IB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_OpaqueMemory_setByte
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject opaqueMemory, jint index, jbyte value) {
        if (outOfBoundsOpaqueMemory(env, index, 1, opaqueMemory)) {
            throw_IndexOutOfBoundsException(env, "Index outside of allocated memory!");
            return;
        }
        *(UNWRAP_OPAQUE_MEM_TO(jbyte*, opaqueMemory) + index) = value;
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    getByte
     * Signature: (Lde/ibapl/jnhw/OpaqueMemory;I)B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_OpaqueMemory_getByte
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject opaqueMemory, jint index) {
        if (outOfBoundsOpaqueMemory(env, index, 1, opaqueMemory)) {
            throw_IndexOutOfBoundsException(env, "Index outside of allocated memory!");
            return 0;
        }
        return *(UNWRAP_OPAQUE_MEM_TO(jbyte*, opaqueMemory) + index);
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    ENOMEM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_OpaqueMemory_ENOMEM
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return ENOMEM;
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    malloc
     * Signature: (I)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_OpaqueMemory_malloc
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jint sizeInBytes) {
        if (sizeInBytes < 0) {
            throw_IllegalArgumentException(env, "sizeInBytes is negative!");
            return -1;
        }
        void* result = malloc((uint32_t) sizeInBytes);
        if ((result == NULL) && (sizeInBytes > 0)) {
            throw_NativeErrorException(env, errno);
        }
        return (intptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    calloc
     * Signature: (II)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_OpaqueMemory_calloc
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint numberOfElements, jint sizeInBytes) {
        if (sizeInBytes < 0) {
            throw_IllegalArgumentException(env, "sizeInBytes is negative!");
            return -1;
        }
        if (numberOfElements < 0) {
            throw_IllegalArgumentException(env, "numberOfElements is negative!");
            return -1;
        }

        void* result = result = calloc((uint32_t) numberOfElements, (uint32_t) sizeInBytes);
        if ((result == NULL) && (sizeInBytes > 0) && (numberOfElements > 0)) {
            throw_NativeErrorException(env, errno);
        }
        return (intptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    free
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_OpaqueMemory_free
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong baseAddress) {
        free((void*) (intptr_t) baseAddress);
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    memset
     * Signature: (Lde/ibapl/jnhw/OpaqueMemory;B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_OpaqueMemory_memset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject opaqueMemory, jbyte byteToSet) {
        memset(UNWRAP_OPAQUE_MEM_TO_VOID_PTR(opaqueMemory), byteToSet, (uint32_t) SIZE_OF_OPAQUE_MEM(opaqueMemory));
    }

#ifdef __cplusplus
}
#endif