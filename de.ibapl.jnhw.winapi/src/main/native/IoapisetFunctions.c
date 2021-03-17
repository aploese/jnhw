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
            return (int32_t) lpNumberOfBytesTransferred;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
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
            throw_NativeErrorException(env, (int32_t) GetLastError());
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
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Ioapiset
     * Method:    DeviceIoControl
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;ILde/ibapl/jnhw/common/memory/OpaqueMemory32;ILde/ibapl/jnhw/common/memory/OpaqueMemory32;ILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Ioapiset_DeviceIoControl__Lde_ibapl_jnhw_winapi_Winnt_HANDLE_2ILde_ibapl_jnhw_common_memory_OpaqueMemory32_2ILde_ibapl_jnhw_common_memory_OpaqueMemory32_2ILde_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED_2
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hDevice, jint dwIoControlCode, jobject lpInBuffer,
            jint nInBufferSize, jobject lpOutBuffer, jint nOutBufferSize, jobject lpOverlapped) {
        if (hDevice == NULL) {
            throw_NullPointerException(env, "hDevice is null.");
            return -1;
        }
        if (nInBufferSize < 0) {
            throw_IndexOutOfBoundsException(env, "nInBufferSize index out of bounds");
            return -1;
        }
        if (nOutBufferSize < 0) {
            throw_IndexOutOfBoundsException(env, "nOutBufferSize index out of bounds");
            return -1;
        }

        DWORD _BytesReturned;

        if (!DeviceIoControl(UNWRAP_HANDLE(hDevice),
                (uint32_t) dwIoControlCode,
                UNWRAP_ABSTRACT_MEM_TO_VOID_PTR_OR_NULL(lpInBuffer),
                (uint32_t) nInBufferSize,
                UNWRAP_ABSTRACT_MEM_TO_VOID_PTR_OR_NULL(lpOutBuffer),
                (uint32_t) nOutBufferSize,
                &_BytesReturned,
                UNWRAP_LPOVERLAPPED_OR_NULL(lpOverlapped))) {
            if ((UNWRAP_LPOVERLAPPED_OR_NULL(lpOverlapped) == NULL) || (GetLastError() != ERROR_IO_PENDING)) {
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

