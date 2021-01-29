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

#include "de_ibapl_jnhw_common_memory_OpaqueMemory32.h"
#include <string.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_common_memory_OpaqueMemory32
     * Method:    copy
     * Signature: ([BILde/ibapl/jnhw/common/memory/OpaqueMemory32;II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_OpaqueMemory32_copy___3BILde_ibapl_jnhw_common_memory_OpaqueMemory32_2II
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jbyteArray src, jint srcPos, jobject dest, jint destPos, jint len) {
        if (outOfBoundsByteArray(env, srcPos, len, src)) {
            throw_ArrayIndexOutOfBoundsException(env, "Source ArrayIndex!");
            return;
        }
        if (outOfBoundsOpaqueMemory32(env, destPos, len, dest)) {
            throw_IndexOutOfBoundsException(env, "Index outside of destinated opaque memory!");
            return;
        }
        (*env)->GetByteArrayRegion(env, src, srcPos, len, UNWRAP_ABSTRACT_MEM_TO_VOID_PTR(dest) + destPos);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_OpaqueMemory32
     * Method:    copy
     * Signature: (Lde/ibapl/jnhw/common/memory/OpaqueMemory32;I[BII)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_OpaqueMemory32_copy__Lde_ibapl_jnhw_common_memory_OpaqueMemory32_2I_3BII
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject src, jint srcPos, jbyteArray dest, jint destPos, jint len) {
        if (outOfBoundsOpaqueMemory32(env, srcPos, len, src)) {
            throw_IndexOutOfBoundsException(env, "Source index outside of opaque memory!");
            return;
        }
        if (outOfBoundsByteArray(env, destPos, len, dest)) {
            throw_ArrayIndexOutOfBoundsException(env, "Destination ArrayIndex!");
            return;
        }
        (*env)->SetByteArrayRegion(env, dest, destPos, len, UNWRAP_ABSTRACT_MEM_TO_VOID_PTR(src) + srcPos);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_OpaqueMemory32
     * Method:    getByte
     * Signature: (Lde/ibapl/jnhw/common/memory/OpaqueMemory32;I)B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_common_memory_OpaqueMemory32_getByte
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject opaqueMemory, jint index) {
        if (outOfBoundsOpaqueMemory32(env, index, 1, opaqueMemory)) {
            throw_IndexOutOfBoundsException(env, "Index outside of allocated memory!");
            return 0;
        }
        return *(UNWRAP_ABSTRACT_MEM_TO(jbyte*, opaqueMemory) + index);
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_OpaqueMemory32
     * Method:    setByte
     * Signature: (Lde/ibapl/jnhw/common/memory/OpaqueMemory32;IB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_OpaqueMemory32_setByte
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jobject opaqueMemory, jint index, jbyte value) {
        if (outOfBoundsOpaqueMemory32(env, index, 1, opaqueMemory)) {
            throw_IndexOutOfBoundsException(env, "Index outside of allocated memory!");
            return;
        }
        *(UNWRAP_ABSTRACT_MEM_TO(jbyte*, opaqueMemory) + index) = value;
    }

    /*
     * Class:     de_ibapl_jnhw_common_memory_OpaqueMemory32
     * Method:    memset
     * Signature: (Lde/ibapl/jnhw/common/memory/OpaqueMemory32;B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_common_memory_OpaqueMemory32_memset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject opaqueMemory32, jbyte byteToSet) {
        memset(UNWRAP_ABSTRACT_MEM_TO_VOID_PTR(opaqueMemory32), byteToSet, (uint32_t) SIZE_OF_OPAQUE_MEM_32(opaqueMemory32));
    }



#ifdef __cplusplus
}
#endif
