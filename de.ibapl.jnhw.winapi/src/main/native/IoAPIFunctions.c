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
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/winapi/Winnt/HANDLE;JI)Lde/ibapl/jnhw/winapi/Winnt/HANDLE;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_IoAPI_CreateIoCompletionPort
  (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject FileHandle, jobject ExistingCompletionPort, jlong CompletionKey, jint NumberOfConcurrentThreads) {
        if (FileHandle == NULL) {
            throw_NullPointerException(env, "FileHandle is null.");
            return NULL;
        }
        if (NumberOfConcurrentThreads < 0) {
            throw_IllegalArgumentException(env, "NumberOfConcurrentThreads < 0");
            return NULL;
        }
        HANDLE _ExistingCompletionPort = ExistingCompletionPort != NULL ?  UNWRAP_HANDLE(ExistingCompletionPort) : NULL;
        //ULONG_PTR: On ix68 its 32 bit long and on x64 ist 64 bit long
        HANDLE result = CreateIoCompletionPort(UNWRAP_HANDLE(FileHandle), _ExistingCompletionPort, (ULONG_PTR)CompletionKey, (uint32_t)NumberOfConcurrentThreads);
        if (result == NULL ) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
            return NULL;
        }
        return CREATE_HANDLE(result);
    
}

/*
 * Class:     de_ibapl_jnhw_winapi_IoAPI
 * Method:    GetQueuedCompletionStatus
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_IoAPI_GetQueuedCompletionStatus
  (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject CompletionPort, jobject lpNumberOfBytesTransferred, jobject lpCompletionKey, jobject lpOverlapped, jlong dwMilliseconds) {
        if (CompletionPort == NULL) {
            throw_NullPointerException(env, "CompletionPort is null.");
            return;
        }
        if (lpNumberOfBytesTransferred == NULL) {
            throw_NullPointerException(env, "lpNumberOfBytesTransferred is null.");
            return;
        }
        if (lpCompletionKey == NULL) {
            throw_NullPointerException(env, "lpCompletionKey is null.");
            return;
        }
        if (lpOverlapped == NULL) {
            throw_NullPointerException(env, "lpOverlapped is null.");
            return;
        }
        if ((dwMilliseconds < 0) && ((uint32_t)dwMilliseconds != INFINITE))  {
            throw_IllegalArgumentException(env, "dwMilliseconds < 0");
            return;
        }
        DWORD _lpNumberOfBytesTransferred;
        ULONG_PTR _lpCompletionKey; //ULONG_PTR: On ix68 its 32 bit long and on x64 ist 64 bit long
        LPOVERLAPPED _lpOverlapped;
        if (!GetQueuedCompletionStatus(UNWRAP_HANDLE(CompletionPort),&_lpNumberOfBytesTransferred, &_lpCompletionKey, &_lpOverlapped, (uint32_t)dwMilliseconds)) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
        
        SET_INT_REF_VALUE(lpNumberOfBytesTransferred, (int32_t)_lpNumberOfBytesTransferred);
        SET_LONG_REF_VALUE(lpCompletionKey, (int64_t)_lpCompletionKey);//ULONG_PTR: On ix68 its 32 bit long and on x64 ist 64 bit long
        SET_OBJECT_REF_VALUE(lpOverlapped, CREATE_NATIVE_ADDRESS_HOLDER(_lpOverlapped));
}

/*
 * Class:     de_ibapl_jnhw_winapi_IoAPI
 * Method:    PostQueuedCompletionStatus
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;IJLde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_IoAPI_PostQueuedCompletionStatus
  (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject CompletionPort, jint dwNumberOfBytesTransferred, jlong dwCompletionKey, jobject lpOverlapped) {
        if (CompletionPort == NULL) {
            throw_NullPointerException(env, "CompletionPort is null.");
            return;
        }
#if defined(_WIN64)
       if (!PostQueuedCompletionStatus(UNWRAP_HANDLE(CompletionPort), (uint32_t) dwNumberOfBytesTransferred, (uint64_t)dwCompletionKey, UNWRAP_LPOVERLAPPED_OR_NULL(lpOverlapped))) {
#elif defined(_WIN32)
        if ((dwCompletionKey > LONG_MAX) || (dwCompletionKey < LONG_MAX)) {
            throw_IllegalArgumentException(env, "dwCompletionKey out of bounds for 32 bit!");
            return;
        }
       if (!PostQueuedCompletionStatus(UNWRAP_HANDLE(CompletionPort), (uint32_t) dwNumberOfBytesTransferred, (uint32_t)dwCompletionKey, UNWRAP_LPOVERLAPPED_OR_NULL(lpOverlapped))) {
#else
#error "no _WIN64 nor _WIN32 defined!"
#endif            
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
}

#ifdef __cplusplus
}
#endif
#endif

