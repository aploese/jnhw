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
#include "jnhw-winapi.h"
#include "de_ibapl_jnhw_winapi_Processthreadsapi.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef HAVE_PROCESSTHREADSAPI_H
#include <processthreadsapi.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_Processthreadsapi
     * Method:    QueueUserAPC
     * Signature: (JJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Processthreadsapi_QueueUserAPC
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrPfnAPC, jlong ptrHThread, jlong dwData) {
#if defined(_WIN64)
        if (QueueUserAPC((PAPCFUNC) (uintptr_t) ptrPfnAPC, (HANDLE) (uintptr_t) ptrHThread, (uint64_t) dwData)) {
#elif defined(_WIN32)
        if ((dwData > LONG_MAX) || (dwData < LONG_MAX)) {
            throw_IllegalArgumentException(env, "dwData out of bounds for 32 bit!");
            return;
        }
        if (QueueUserAPC((PAPCFUNC) (uintptr_t) ptrPfnAPC, (HANDLE) (uintptr_t) ptrHThread, (uint32_t) dwData)) {
#else
#error "no _WIN64 nor _WIN32 defined!"
#endif
            return;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Processthreadsapi
     * Method:    GetCurrentThread
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Processthreadsapi_GetCurrentThread
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int64_t) (uintptr_t) GetCurrentThread();
    }

#endif
#ifdef __cplusplus
}
#endif
