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
#define _JNHW_COMMON_IMPLEMENTATION_ 1
#include "jnhw-common.h"

#include "de_ibapl_jnhw_AbstractNativeMemory.h"
#include <errno.h>
#include <stdlib.h>
#include <string.h>


#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory
 * Method:    ENOMEM
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_ENOMEM
    (__attribute__ ((unused))JNIEnv *env, __attribute__ ((unused))jclass clazz) {
        return ENOMEM;
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory
 * Method:    malloc
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_malloc__I
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
 * Class:     de_ibapl_jnhw_AbstractNativeMemory
 * Method:    malloc
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_malloc__J
#if !defined(_LP64)
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, __attribute__ ((unused))jlong sizeInBytes) {
        throw_NoSuchNativeMethodException(env, "malloc");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused))jclass clazz, jlong sizeInBytes) {
        if (sizeInBytes < 0) {
            throw_IllegalArgumentException(env, "sizeInBytes is negative!");
            return -1;
        }
        void* result = malloc((uint64_t) sizeInBytes);
        if (result == NULL) {
            throw_NativeErrorException(env, errno);
        }
        return (intptr_t) result;
#endif
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory
 * Method:    calloc
 * Signature: (II)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_calloc__II
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
        if (result == NULL) {
            throw_NativeErrorException(env, errno);
        }
        return (intptr_t) result;
    }

/*
 * Class:     de_ibapl_jnhw_AbstractNativeMemory
 * Method:    calloc
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_AbstractNativeMemory_calloc__JJ
#if !defined(_LP64)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong numberOfElements, __attribute__ ((unused)) jlong sizeInBytes) {
        throw_NoSuchNativeMethodException(env, "calloc(JJ)J");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong numberOfElements, jlong sizeInBytes) {
        if (sizeInBytes < 0) {
            throw_IllegalArgumentException(env, "sizeInBytes is negative!");
            return -1;
        }
        if (numberOfElements < 0) {
            throw_IllegalArgumentException(env, "numberOfElements is negative!");
            return -1;
        }

        void* result = result = calloc((uint64_t) numberOfElements, (uint64_t) sizeInBytes);
        if (result == NULL) {
            throw_NativeErrorException(env, errno);
        }
        return (intptr_t) result;
#endif
    }

#ifdef __cplusplus
}
#endif