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
#include "jnhw-winapi.h"
#include "de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED.h"

#ifdef HAVE_MINWINBASE_H
#include <minwinbase.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    sizeofOVERLAPPED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_sizeofOVERLAPPED
    (JNIEnv *env, jclass clazz) {
        return sizeof (OVERLAPPED);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    Internal
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_Internal
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((OVERLAPPED*) (uintptr_t) baseAddress)->Internal;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    InternalHigh
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_InternalHigh
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((OVERLAPPED*) (uintptr_t) baseAddress)->InternalHigh;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    hEvent
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_hEvent__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return (uintptr_t)((OVERLAPPED*) (uintptr_t) baseAddress)->hEvent;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    hEvent
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_hEvent__JJ
    (JNIEnv *env, jclass clazz, jlong baseAddress, jlong value) {
        ((OVERLAPPED*) (uintptr_t) baseAddress)->hEvent = (HANDLE)(uintptr_t)value;
    }

#ifdef __cplusplus
}
#endif
#endif
