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
#include "de_ibapl_jnhw_winapi_Ioapiset.h"

#ifdef HAVE_IOAPISET_H
#include <ioapiset.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    GetOverlappedResult
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/winapi/Minwinbase$OVERLAPPED;Z)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_GetOverlappedResult
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpOverlapped, jboolean bWait) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }
        if (lpOverlapped == NULL) {
            throw_NullPointerException(env, "lpOVERLAPPED is null.");
            return -1;
        }

        DWORD lpNumberOfBytesTransferred;
        if (GetOverlappedResult(UNWRAP_HANDLE(hFile),
                UNWRAP_LPOVERLAPPED(lpOverlapped),
                &lpNumberOfBytesTransferred,
                bWait)) {
            return (int32_t)lpNumberOfBytesTransferred;
        } else {
            throw_NativeErrorException(env, (int32_t)GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    CancelIoEx
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/winapi/Minwinbase$OVERLAPPED;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_CancelIoEx
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpOverlapped) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return;
        }
        if (lpOverlapped == NULL) {
            throw_NullPointerException(env, "lpOVERLAPPED is null.");
            return;
        }

        if (!CancelIoEx(UNWRAP_HANDLE(hFile),
                UNWRAP_LPOVERLAPPED(lpOverlapped))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    CancelIo
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_CancelIo
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return;
        }
        if (!CancelIo(UNWRAP_HANDLE(hFile))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

/*
 * Class:     de_ibapl_jnhw_winapi_Ioapiset
 * Method:    CreateIoCompletionPort
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/winapi/Winnt/HANDLE;JI)Lde/ibapl/jnhw/winapi/Winnt/HANDLE;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_CreateIoCompletionPort
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
 * Class:     de_ibapl_jnhw_winapi_Ioapiset
 * Method:    GetQueuedCompletionStatus
 * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_GetQueuedCompletionStatus
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
        DWORD _lpNumberOfBytesTransferred =  (uint32_t)GET_INT_REF_VALUE(lpNumberOfBytesTransferred);
        ULONG_PTR _lpCompletionKey = (ULONG_PTR)GET_LONG_REF_VALUE(lpCompletionKey); //ULONG_PTR: On ix68 its 32 bit long and on x64 ist 64 bit long
        jobject lpOverlapped_Ref_Value = GET_OBJECT_REF_VALUE(lpOverlapped);
        LPOVERLAPPED _lpOverlapped = lpOverlapped_Ref_Value == NULL ? NULL : UNWRAP_NATIVE_ADDRESS_HOLDER_TO(LPOVERLAPPED, lpOverlapped_Ref_Value);
        if (!GetQueuedCompletionStatus(UNWRAP_HANDLE(CompletionPort),&_lpNumberOfBytesTransferred, &_lpCompletionKey, &_lpOverlapped, (uint32_t)dwMilliseconds)) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
        
        SET_INT_REF_VALUE(lpNumberOfBytesTransferred, (int32_t)_lpNumberOfBytesTransferred);
        SET_LONG_REF_VALUE(lpCompletionKey, (int64_t)_lpCompletionKey);//ULONG_PTR: On ix68 its 32 bit long and on x64 ist 64 bit long
        SET_OBJECT_REF_VALUE(lpOverlapped, CREATE_NATIVE_ADDRESS_HOLDER(_lpOverlapped));
}


#ifdef __cplusplus
}
#endif
#endif

