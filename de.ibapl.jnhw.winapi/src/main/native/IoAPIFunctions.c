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
#include "de_ibapl_jnhw_winapi_IoAPI.h"

#ifdef HAVE_IOAPI_H
#include <ioapi.h>
#define HAVE_IOAPI_OR_IOAPISET_H 1;
#elif defined(HAVE_IOAPISET_H)
#include <ioapiset.h>
//mingw defines this here instead of ioapi.h
#define HAVE_IOAPI_OR_IOAPISET_H 1;
#endif

#ifdef HAVE_IOAPI_OR_IOAPISET_H

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_IoAPI
     * Method:    CreateIoCompletionPort
     * Signature: (JJJI)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_IoAPI_CreateIoCompletionPort
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrFileHandle, jlong ptrExistingCompletionPort, jlong CompletionKey, jint NumberOfConcurrentThreads) {
        //ULONG_PTR: On ix68 its 32 bit long and on x64 ist 64 bit long
        HANDLE result = CreateIoCompletionPort((HANDLE) (uintptr_t) ptrFileHandle, (HANDLE) (uintptr_t) ptrExistingCompletionPort, (ULONG_PTR) CompletionKey, (uint32_t) NumberOfConcurrentThreads);
        if (result == NULL) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return (int64_t) (uintptr_t) NULL;
        }
        return (int64_t) (uintptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_IoAPI
     * Method:    GetQueuedCompletionStatus
     * Signature: (JJJJ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_IoAPI_GetQueuedCompletionStatus
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrCompletionPort, jlong ptrLpNumberOfBytesTransferred, jlong ptrLpCompletionKey, jlong dwMilliseconds) {
        LPOVERLAPPED lpOverlapped;
        if (!GetQueuedCompletionStatus((HANDLE) (uintptr_t) ptrCompletionPort, (LPDWORD) (uintptr_t) ptrLpNumberOfBytesTransferred, (PULONG_PTR) (uintptr_t) ptrLpCompletionKey, &lpOverlapped, (uint32_t) dwMilliseconds)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
        return (int64_t) (uintptr_t) lpOverlapped;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_IoAPI
     * Method:    PostQueuedCompletionStatus
     * Signature: (JIJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_IoAPI_PostQueuedCompletionStatus
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrCompletionPort, jint dwNumberOfBytesTransferred, jlong dwCompletionKey, jlong ptrLpOverlapped) {
#if defined(_WIN64)

        if (!PostQueuedCompletionStatus((HANDLE) (uintptr_t) ptrCompletionPort, (uint32_t) dwNumberOfBytesTransferred, (uint64_t) dwCompletionKey, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped)) {
#elif defined(_WIN32)
        if ((dwCompletionKey > LONG_MAX) || (dwCompletionKey < LONG_MAX)) {
            throw_IllegalArgumentException(env, "dwCompletionKey out of bounds for 32 bit!");
            return;
        }
        if (!PostQueuedCompletionStatus((HANDLE) (uintptr_t) ptrCompletionPort, (uint32_t) dwNumberOfBytesTransferred, (uint32_t) dwCompletionKey, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped)) {
#else
#error "no _WIN64 nor _WIN32 defined!"
#endif
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

#ifdef __cplusplus
}
#endif
#endif

