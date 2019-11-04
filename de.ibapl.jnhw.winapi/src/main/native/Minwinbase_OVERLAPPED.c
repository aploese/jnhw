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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (OVERLAPPED);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    Internal
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_Internal
    (__attribute__ ((unused)) JNIEnv *env, jobject this) {
        return (intptr_t)(UNWRAP_OVERLAPPED(this))->Internal;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    InternalHigh
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_InternalHigh
    (__attribute__ ((unused)) JNIEnv *env, jobject this) {
        return (intptr_t)(UNWRAP_OVERLAPPED(this))->InternalHigh;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    hEvent
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_hEvent__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2
    (__attribute__ ((unused)) JNIEnv *env, jobject this, jobject hEvent) {
        (UNWRAP_OVERLAPPED(this))->hEvent = UNWRAP_HANDLE_OR_NULL(hEvent);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    hEvent
     * Signature: ()Lde/ibapl/jnhw/winapi/Winnt$HANDLE;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_hEvent__
    (__attribute__ ((unused)) JNIEnv *env, jobject this) {
        return CREATE_HANDLE((UNWRAP_OVERLAPPED(this))->hEvent);
    }

#ifdef __cplusplus
}
#endif
#endif
