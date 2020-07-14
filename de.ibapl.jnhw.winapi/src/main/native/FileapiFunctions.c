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
#include "de_ibapl_jnhw_winapi_Fileapi.h"

#ifdef HAVE_FILEAPI_H
#include <fileapi.h>

/* The maximum size of a stack-allocated buffer.
 */
#define MAX_STACK_BUF_SIZE 8192

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    CreateFileW
     * Signature: (Ljava/lang/String;IILde/ibapl/jnhw/winapi/Minwinbase$SECURITY_ATTRIBUTES;IILde/ibapl/jnhw/winapi/Winnt$HANDLE;)Lde/ibapl/jnhw/winapi/Winnt$HANDLE;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_CreateFileW
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring lpFileName, jint dwDesiredAccess, jint dwShareMode, jobject lpSecurityAttributes, jint dwCreationDisposition, jint dwFlagsAndAttributes, jobject hTemplateFile) {
        if (lpFileName == NULL) {
            throw_NullPointerException(env, "lpFileName is null.");
            return NULL;
        }

        LPCWSTR _lpFileName = (*env)->GetStringChars(env, lpFileName, NULL);

        HANDLE result = CreateFileW(_lpFileName, (uint32_t) dwDesiredAccess, (uint32_t) dwShareMode, UNWRAP_LPSECURITY_ATTRIBUTES_OR_NULL(lpSecurityAttributes), (uint32_t) dwCreationDisposition, (uint32_t) dwFlagsAndAttributes, UNWRAP_HANDLE_OR_NULL(hTemplateFile));

        (*env)->ReleaseStringChars(env, lpFileName, _lpFileName);
        if (result == INVALID_HANDLE_VALUE) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
        return CREATE_HANDLE(result);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    FlushFileBuffers
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_FlushFileBuffers
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return;
        }
        if (!FlushFileBuffers(UNWRAP_HANDLE(hFile))) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2_3BII
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jbyteArray lpBuffer, jint off, jint nNumberOfBytesToRead) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null");
            return -1;
        }
        if (outOfBoundsByteArray(env, off, nNumberOfBytesToRead, lpBuffer)) {
            throw_ArrayIndexOutOfBoundsException(env, "lpBuffer");
            return -1;
        }

        jbyte stackBuf[nNumberOfBytesToRead > MAX_STACK_BUF_SIZE ? 0 : nNumberOfBytesToRead];
        jbyte *_buf = NULL;
        if (nNumberOfBytesToRead == 0) {
            return 0;
        } else if (nNumberOfBytesToRead > MAX_STACK_BUF_SIZE) {
            _buf = malloc((uint32_t) nNumberOfBytesToRead);
            if (_buf == NULL) {
                throw_Exception(env, "java/lang/OutOfMemoryError", "Can`t aquire %d bytes of memory", nNumberOfBytesToRead);
                return 0;
            }
        } else {
            _buf = stackBuf;
        }

        DWORD lpNumberOfBytesRead;
        if (ReadFile(UNWRAP_HANDLE(hFile), _buf, (uint32_t) nNumberOfBytesToRead, &lpNumberOfBytesRead, NULL)) {
            (*env)->SetByteArrayRegion(env, lpBuffer, off, (int32_t) lpNumberOfBytesRead, _buf);
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            lpNumberOfBytesRead = (uint32_t) - 1;
        }

        if (_buf != stackBuf) {
            free(_buf);
        }

        return (int32_t) lpNumberOfBytesRead;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile_ArgsOK
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Ljava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile_1ArgsOK__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Ljava_nio_ByteBuffer_2II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToRead) {

        DWORD lpNumberOfBytesRead;
        if (ReadFile(UNWRAP_HANDLE(hFile), (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToRead, &lpNumberOfBytesRead, NULL)) {
            return (int32_t) lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile_ArgsOK
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Ljava/nio/ByteBuffer;IILde/ibapl/jnhw/winapi/Minwinbase$OVERLAPPED;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile_1ArgsOK__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Ljava_nio_ByteBuffer_2IILde_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_2
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToRead, jobject lpOverlapped) {
        if (!ReadFile(UNWRAP_HANDLE(hFile), (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToRead, NULL, UNWRAP_LPOVERLAPPED(lpOverlapped))) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/OpaqueMemory;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Lde_ibapl_jnhw_OpaqueMemory_2II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToRead) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null.");
            return -1;
        }
        if (outOfBoundsOpaqueMemory(env, off, nNumberOfBytesToRead, lpBuffer)) {
            throw_IndexOutOfBoundsException(env, "lpBuffer index out of bounds");
            return -1;
        }

        DWORD lpNumberOfBytesRead;
        if (ReadFile(UNWRAP_HANDLE(hFile), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(lpBuffer) + off, (uint32_t) nNumberOfBytesToRead, &lpNumberOfBytesRead, NULL)) {
            return (int32_t) lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/ByteRef;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_0024HANDLE_2Lde_ibapl_jnhw_ByteRef_2
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject byteRef) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }
        if (byteRef == NULL) {
            throw_NullPointerException(env, "byteRef is null.");
            return -1;
        }

        DWORD lpNumberOfBytesRead;
        jbyte _buf;
        if (ReadFile(UNWRAP_HANDLE(hFile), &_buf, 1, &lpNumberOfBytesRead, NULL)) {
            SET_BYTE_REF_VALUE(byteRef, _buf);
            return (int32_t) lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;B)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_0024HANDLE_2B
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jbyte b) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }

        DWORD lpNumberOfBytesWritten;
        if (WriteFile(UNWRAP_HANDLE(hFile), &b, 1, &lpNumberOfBytesWritten, NULL)) {
            return (int32_t) lpNumberOfBytesWritten;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/OpaqueMemory;IILde/ibapl/jnhw/winapi/Minwinbase$OVERLAPPED;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Lde_ibapl_jnhw_OpaqueMemory_2IILde_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_2
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToRead, jobject lpOverlapped) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null.");
            return;
        }
        if (outOfBoundsOpaqueMemory(env, off, nNumberOfBytesToRead, lpBuffer)) {
            throw_IndexOutOfBoundsException(env, "lpBuffer index out of bounds");
            return;
        }
        if (lpOverlapped == NULL) {
            throw_NullPointerException(env, "lpOverlapped is null.");
            return;
        }
        if (!ReadFile(UNWRAP_HANDLE(hFile), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(lpBuffer) + off, (uint32_t) nNumberOfBytesToRead, NULL, UNWRAP_LPOVERLAPPED(lpOverlapped))) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2_3BII
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jbyteArray lpBuffer, jint off, jint nNumberOfBytesToWrite) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null");
            return -1;
        }
        if (outOfBoundsByteArray(env, off, nNumberOfBytesToWrite, lpBuffer)) {
            throw_ArrayIndexOutOfBoundsException(env, "lpBuffer");
            return -1;
        }

        jbyte stackBuf[nNumberOfBytesToWrite > MAX_STACK_BUF_SIZE ? 0 : nNumberOfBytesToWrite];
        jbyte *_buf = NULL;
        if (nNumberOfBytesToWrite == 0) {
            return 0;
        } else if (nNumberOfBytesToWrite > MAX_STACK_BUF_SIZE) {
            _buf = malloc((uint32_t) nNumberOfBytesToWrite);
            if (_buf == NULL) {
                throw_Exception(env, "java/lang/OutOfMemoryError", "Can`t aquire %d bytes of memory", nNumberOfBytesToWrite);
                return 0;
            }
        } else {
            _buf = stackBuf;
        }

        (*env)->GetByteArrayRegion(env, lpBuffer, off, nNumberOfBytesToWrite, _buf);
        if ((*env)->ExceptionOccurred(env)) {
            return -1;
        }

        DWORD lpNumberOfBytesWritten;
        if (WriteFile(UNWRAP_HANDLE(hFile), _buf, (uint32_t) nNumberOfBytesToWrite, &lpNumberOfBytesWritten, NULL)) {
        } else {
            throw_NativeErrorException(env, errno);
            lpNumberOfBytesWritten = (uint32_t) - 1;
        }

        if (_buf != stackBuf) {
            free(_buf);
        }

        return (int32_t) lpNumberOfBytesWritten;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile_ArgsOK
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Ljava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile_1ArgsOK__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Ljava_nio_ByteBuffer_2II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToWrite) {

        DWORD lpNumberOfBytesWritten;
        if (WriteFile(UNWRAP_HANDLE(hFile), (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, &lpNumberOfBytesWritten, NULL)) {
            return (int32_t) lpNumberOfBytesWritten;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile_ArgsOK
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Ljava/nio/ByteBuffer;IILde/ibapl/jnhw/winapi/Minwinbase$OVERLAPPED;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile_1ArgsOK__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Ljava_nio_ByteBuffer_2IILde_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_2
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToWrite, jobject lpOverlapped) {
        if (!WriteFile(UNWRAP_HANDLE(hFile), (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, NULL, UNWRAP_LPOVERLAPPED(lpOverlapped))) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/OpaqueMemory;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Lde_ibapl_jnhw_OpaqueMemory_2II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToWrite) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null.");
            return -1;
        }
        if (outOfBoundsOpaqueMemory(env, off, nNumberOfBytesToWrite, lpBuffer)) {
            throw_IndexOutOfBoundsException(env, "lpBuffer index out of bounds");
            return -1;
        }

        DWORD lpNumberOfBytesRead;
        if (WriteFile(UNWRAP_HANDLE(hFile), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(lpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, &lpNumberOfBytesRead, NULL)) {
            return (int32_t) lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/OpaqueMemory;IILde/ibapl/jnhw/winapi/Minwinbase$OVERLAPPED;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Lde_ibapl_jnhw_OpaqueMemory_2IILde_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_2
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToWrite, jobject lpOverlapped) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null.");
            return;
        }
        if (outOfBoundsOpaqueMemory(env, off, nNumberOfBytesToWrite, lpBuffer)) {
            throw_IndexOutOfBoundsException(env, "lpBuffer index out of bounds");
            return;
        }
        if (lpOverlapped == NULL) {
            throw_NullPointerException(env, "lpOverlapped is null.");
            return;
        }
        if (!WriteFile(UNWRAP_HANDLE(hFile), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(lpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, NULL, UNWRAP_LPOVERLAPPED(lpOverlapped))) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFileEx
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/OpaqueMemory;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFileEx
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToRead, jobject lpOverlapped, jobject lpCompletionRoutine) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null.");
            return;
        }
        if (outOfBoundsOpaqueMemory(env, off, nNumberOfBytesToRead, lpBuffer)) {
            throw_IndexOutOfBoundsException(env, "lpBuffer index out of bounds");
            return;
        }
        if (lpOverlapped == NULL) {
            throw_NullPointerException(env, "lpOverlapped is null.");
            return;
        }
        if (lpCompletionRoutine == NULL) {
            throw_NullPointerException(env, "lpCompletionRoutine is null.");
            return;
        }
        ReadFileEx(UNWRAP_HANDLE(hFile), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(lpBuffer) + off, (uint32_t) nNumberOfBytesToRead, UNWRAP_LPOVERLAPPED(lpOverlapped), UNWRAP_LPOVERLAPPED_COMPLETION_ROUTINE(lpCompletionRoutine));
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFileEx_ArgsOK
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Ljava/nio/ByteBuffer;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFileEx_1ArgsOK
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToRead, jobject lpOverlapped, jobject lpCompletionRoutine) {
        ReadFileEx(UNWRAP_HANDLE(hFile), (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToRead, UNWRAP_LPOVERLAPPED(lpOverlapped), UNWRAP_LPOVERLAPPED_COMPLETION_ROUTINE(lpCompletionRoutine));
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFileEx
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/OpaqueMemory;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFileEx
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToWrite, jobject lpOverlapped, jobject lpCompletionRoutine) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null.");
            return;
        }
        if (outOfBoundsOpaqueMemory(env, off, nNumberOfBytesToWrite, lpBuffer)) {
            throw_IndexOutOfBoundsException(env, "lpBuffer index out of bounds");
            return;
        }
        if (lpOverlapped == NULL) {
            throw_NullPointerException(env, "lpOverlapped is null.");
            return;
        }
        if (lpCompletionRoutine == NULL) {
            throw_NullPointerException(env, "lpCompletionRoutine is null.");
            return;
        }
        WriteFileEx(UNWRAP_HANDLE(hFile), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(lpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, UNWRAP_LPOVERLAPPED(lpOverlapped), UNWRAP_LPOVERLAPPED_COMPLETION_ROUTINE(lpCompletionRoutine));
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFileEx_ArgsOK
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Ljava/nio/ByteBuffer;IILde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFileEx_1ArgsOK
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpBuffer, jint off, jint nNumberOfBytesToWrite, jobject lpOverlapped, jobject lpCompletionRoutine) {
        WriteFileEx(UNWRAP_HANDLE(hFile), (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, UNWRAP_LPOVERLAPPED(lpOverlapped), UNWRAP_LPOVERLAPPED_COMPLETION_ROUTINE(lpCompletionRoutine));
        if (GetLastError() != ERROR_IO_PENDING) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }


#ifdef __cplusplus
}
#endif
#endif

