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
#include "jnhw.h"

#include "de_ibapl_jnhw_OpaqueMemory.h"
#include <errno.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>


#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    ENOMEM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_OpaqueMemory_ENOMEM
    (JNIEnv *env, jclass clazz) {
        return ENOMEM;
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    malloc
     * Signature: (I)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_OpaqueMemory_malloc
    (JNIEnv *env, jclass clazz, jint sizeInBytes) {
        void* result = result = malloc(sizeInBytes);
        if ((result == NULL) && (sizeInBytes > 0)) {
            throw_NativeErrorException(env, errno);
        }
        return (uintptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    calloc
     * Signature: (II)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_OpaqueMemory_calloc
    (JNIEnv *env, jclass clazz, jint numberOfElements, jint sizeInBytes) {
        void* result = result = calloc(numberOfElements, sizeInBytes);
        if ((result == NULL) && (sizeInBytes > 0) && (numberOfElements > 0)) {
            throw_NativeErrorException(env, errno);
        }
        return (uintptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    free
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_OpaqueMemory_free
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        free((void*) (uintptr_t) baseAddress);
    }

    /*
     * Class:     de_ibapl_jnhw_OpaqueMemory
     * Method:    memset
     * Signature: (JBI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_OpaqueMemory_memset
    (JNIEnv *env, jclass clazz, jlong baseAddress, jbyte byteToSet, jint sizeToSet) {
        memset((void*) (uintptr_t) baseAddress, byteToSet, sizeToSet);
    }

#ifdef __cplusplus
}
#endif