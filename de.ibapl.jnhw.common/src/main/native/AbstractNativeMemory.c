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

#include "de_ibapl_jnhw_common_memory_AbstractNativeMemory.h"
#include <errno.h>
#include <stdlib.h>
#include <string.h>


#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_common_memory_AbstractNativeMemory
 * Method:    ENOMEM
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_common_memory_AbstractNativeMemory_ENOMEM
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return ENOMEM;
    }

/*
 * Class:     de_ibapl_jnhw_common_memory_AbstractNativeMemory
 * Method:    malloc
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_AbstractNativeMemory_malloc__I
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jint sizeInBytes) {
        if (sizeInBytes < 0) {
            throw_IllegalArgumentException(env, "sizeInBytes is negative!");
            return -1;
        }
        void* result = malloc((uint32_t) sizeInBytes);
        if (result == NULL) {
            throw_NativeErrorException(env, errno);
        }
        return (intptr_t) result;
    }

/*
 * Class:     de_ibapl_jnhw_common_memory_AbstractNativeMemory
 * Method:    malloc
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_AbstractNativeMemory_malloc__J
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
        }
        return (intptr_t) result;
    }

/*
 * Class:     de_ibapl_jnhw_common_memory_AbstractNativeMemory
 * Method:    calloc
 * Signature: (II)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_AbstractNativeMemory_calloc__II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint nelem, jint elsize) {
        if (nelem < 0) {
            throw_IllegalArgumentException(env, "nelem is negative!");
            return -1;
        }
        if (elsize < 0) {
            throw_IllegalArgumentException(env, "elsize is negative!");
            return -1;
        }
        void* result = result = calloc((uint32_t) nelem, (uint32_t) elsize);
        if (result == NULL) {
            throw_NativeErrorException(env, errno);
        }
        return (intptr_t) result;
    }

/*
 * Class:     de_ibapl_jnhw_common_memory_AbstractNativeMemory
 * Method:    calloc
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_common_memory_AbstractNativeMemory_calloc__JJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong nelem, jlong elsize) {
        if (nelem < 0) {
            throw_IllegalArgumentException(env, "nelem is negative!");
            return -1;
        }
        if (elsize < 0) {
            throw_IllegalArgumentException(env, "elsize is negative!");
            return -1;
        }
#if defined(_LP64)
        void* result = result = calloc((uint64_t) nelem, (uint64_t) elsize);
#else
        if (nelem > UINT32_MAX) {
            throw_IllegalArgumentException(env, "nelem > UINT32_MAX!");
            return -1;
        }
        if (elsize > UINT32_MAX) {
            throw_IllegalArgumentException(env, "elsize > UINT32_MAX!");
            return -1;
        }
        void* result = result = calloc((uint32_t) nelem, (uint32_t) elsize);
#endif
        if (result == NULL) {
            throw_NativeErrorException(env, errno);
        }
        return (intptr_t) result;
    }


#ifdef __cplusplus
}
#endif