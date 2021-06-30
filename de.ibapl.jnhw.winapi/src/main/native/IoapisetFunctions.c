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
#include "de_ibapl_jnhw_winapi_Ioapiset.h"

#ifdef HAVE_IOAPISET_H
#include <ioapiset.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    GetOverlappedResult
     * Signature: (JJZ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_GetOverlappedResult
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpOverlapped, jboolean bWait) {
        DWORD lpNumberOfBytesTransferred;
        if (GetOverlappedResult((HANDLE) (uintptr_t) ptrHFile,
                (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped,
                &lpNumberOfBytesTransferred,
                bWait)) {
            return (int32_t) lpNumberOfBytesTransferred;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    CancelIoEx
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_CancelIoEx
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpOverlapped) {
        if (!CancelIoEx((HANDLE) (uintptr_t) ptrHFile,
                (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    CancelIo
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_CancelIo
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile) {
        if (!CancelIo((HANDLE) (uintptr_t) ptrHFile)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    DeviceIoControl
     * Signature: (JIJIJIJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_DeviceIoControl
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHDevice, jint dwIoControlCode, jlong ptrLpInBuffer, jint nInBufferSize, jlong ptrLpOutBuffer, jint nOutBufferSize, jlong ptrLpOverlapped) {
        DWORD _BytesReturned;

        if (!DeviceIoControl((HANDLE) (uintptr_t) ptrHDevice,
                (uint32_t) dwIoControlCode,
                (void*) (uintptr_t) ptrLpInBuffer,
                (uint32_t) nInBufferSize,
                (void*) (uintptr_t) ptrLpOutBuffer,
                (uint32_t) nOutBufferSize,
                &_BytesReturned,
                (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped)) {
            if ((((LPOVERLAPPED) (uintptr_t) ptrLpOverlapped) == NULL) || (GetLastError() != ERROR_IO_PENDING)) {
                //if lpOverlapped is not NULL and GetLastError() == ERROR_IO_PENDING is not an error condition
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
        return (int32_t) _BytesReturned;
    }

#ifdef __cplusplus
}
#endif
#endif

