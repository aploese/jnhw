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
     * Signature: (Ljava/lang/String;IIJIIJ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_CreateFileW
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jstring lpFileName, jint dwDesiredAccess, jint dwShareMode, jlong ptrLpSecurityAttributes, jint dwCreationDisposition, jint dwFlagsAndAttributes, jlong ptrHTemplateFile) {
        LPCWSTR _lpFileName = (*env)->GetStringChars(env, lpFileName, NULL);

        HANDLE result = CreateFileW(_lpFileName, (uint32_t) dwDesiredAccess, (uint32_t) dwShareMode, (LPSECURITY_ATTRIBUTES) (uintptr_t) ptrLpSecurityAttributes, (uint32_t) dwCreationDisposition, (uint32_t) dwFlagsAndAttributes, (HANDLE) (uintptr_t) ptrHTemplateFile);

        (*env)->ReleaseStringChars(env, lpFileName, _lpFileName);
        if (result == INVALID_HANDLE_VALUE) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
        return (int64_t) (uintptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    FlushFileBuffers
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_FlushFileBuffers
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile) {
        if (!FlushFileBuffers((HANDLE) (uintptr_t) ptrHFile)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (J[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__J_3BII
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jbyteArray lpBuffer, jint off, jint nNumberOfBytesToRead) {
        jbyte stackBuf[nNumberOfBytesToRead > MAX_STACK_BUF_SIZE ? 0 : nNumberOfBytesToRead];
        jbyte *_buf = NULL;
        if (nNumberOfBytesToRead == 0) {
            return 0;
        } else if (nNumberOfBytesToRead > MAX_STACK_BUF_SIZE) {
            _buf = malloc((uint32_t) nNumberOfBytesToRead);
            if (_buf == NULL) {
                throw_Exception(env, OUT_OF_MEMORY_ERROR_CLASS_NAME, "Can`t aquire %d bytes of memory", nNumberOfBytesToRead);
                return 0;
            }
        } else {
            _buf = stackBuf;
        }

        DWORD lpNumberOfBytesRead;
        if (ReadFile((HANDLE) (uintptr_t) ptrHFile, _buf, (uint32_t) nNumberOfBytesToRead, &lpNumberOfBytesRead, NULL)) {
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
     * Method:    ReadFile
     * Signature: (JLjava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__JLjava_nio_ByteBuffer_2II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jobject lpBuffer, jint off, jint nNumberOfBytesToRead) {

        DWORD lpNumberOfBytesRead;
        if (ReadFile((HANDLE) (uintptr_t) ptrHFile, (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToRead, &lpNumberOfBytesRead, NULL)) {
            return (int32_t) lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (JLjava/nio/ByteBuffer;IIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__JLjava_nio_ByteBuffer_2IIJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jobject lpBuffer, jint off, jint nNumberOfBytesToRead, jlong ptrLpOverlapped) {
        if (!ReadFile((HANDLE) (uintptr_t) ptrHFile, (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToRead, NULL, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped)) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (JJII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__JJII
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jint off, jint nNumberOfBytesToRead) {
        DWORD lpNumberOfBytesRead;
        if (ReadFile((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToRead, &lpNumberOfBytesRead, NULL)) {
            return (int32_t) lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (JJJI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__JJJI
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jlong off, jint nNumberOfBytesToRead) {

        DWORD lpNumberOfBytesRead;
        if (ReadFile((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToRead, &lpNumberOfBytesRead, NULL)) {
            return (int32_t) lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (JB)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__JB
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jbyte b) {
        DWORD lpNumberOfBytesWritten;
        if (WriteFile((HANDLE) (uintptr_t) ptrHFile, &b, 1, &lpNumberOfBytesWritten, NULL)) {
            return (int32_t) lpNumberOfBytesWritten;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (JJIIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__JJIIJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jint off, jint nNumberOfBytesToRead, jlong ptrLpOverlapped) {
        if (!ReadFile((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToRead, NULL, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped)) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (JJJIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__JJJIJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jlong off, jint nNumberOfBytesToRead, jlong ptrLpOverlapped) {
        if (!ReadFile((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToRead, NULL, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped)) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (J[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__J_3BII
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jbyteArray lpBuffer, jint off, jint nNumberOfBytesToWrite) {
        jbyte stackBuf[nNumberOfBytesToWrite > MAX_STACK_BUF_SIZE ? 0 : nNumberOfBytesToWrite];
        jbyte *_buf = NULL;
        if (nNumberOfBytesToWrite == 0) {
            return 0;
        } else if (nNumberOfBytesToWrite > MAX_STACK_BUF_SIZE) {
            _buf = malloc((uint32_t) nNumberOfBytesToWrite);
            if (_buf == NULL) {
                throw_Exception(env, OUT_OF_MEMORY_ERROR_CLASS_NAME, "Can`t aquire %d bytes of memory", nNumberOfBytesToWrite);
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
        if (WriteFile((HANDLE) (uintptr_t) ptrHFile, _buf, (uint32_t) nNumberOfBytesToWrite, &lpNumberOfBytesWritten, NULL)) {
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
     * Method:    WriteFile
     * Signature: (JLjava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__JLjava_nio_ByteBuffer_2II
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jobject lpBuffer, jint off, jint nNumberOfBytesToWrite) {

        DWORD lpNumberOfBytesWritten;
        if (WriteFile((HANDLE) (uintptr_t) ptrHFile, (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, &lpNumberOfBytesWritten, NULL)) {
            return (int32_t) lpNumberOfBytesWritten;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (JLjava/nio/ByteBuffer;IIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__JLjava_nio_ByteBuffer_2IIJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jobject lpBuffer, jint off, jint nNumberOfBytesToWrite, jlong ptrLpOverlapped) {
        if (!WriteFile((HANDLE) (uintptr_t) ptrHFile, (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, NULL, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped)) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (JJII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__JJII
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jint off, jint nNumberOfBytesToWrite) {

        DWORD lpNumberOfBytesRead;
        if (WriteFile((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, &lpNumberOfBytesRead, NULL)) {
            return (int32_t) lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (JJJI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__JJJI
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jlong off, jint nNumberOfBytesToWrite) {

        DWORD lpNumberOfBytesRead;
        if (WriteFile((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, &lpNumberOfBytesRead, NULL)) {
            return (int32_t) lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (JJIIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__JJIIJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jint off, jint nNumberOfBytesToWrite, jlong ptrLpOverlapped) {
        if (!WriteFile((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, NULL, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped)) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (JJJIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__JJJIJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jlong off, jint nNumberOfBytesToWrite, jlong ptrLpOverlapped) {
        if (!WriteFile((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, NULL, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped)) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, (int32_t) GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFileEx
     * Signature: (JJIIJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFileEx__JJIIJJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jint off, jint nNumberOfBytesToRead, jlong ptrLpOverlapped, jlong ptrLpCompletionRoutine) {
        if (!ReadFileEx((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToRead, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped, (LPOVERLAPPED_COMPLETION_ROUTINE) (uintptr_t) ptrLpCompletionRoutine)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFileEx
     * Signature: (JJJIJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFileEx__JJJIJJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jlong off, jint nNumberOfBytesToRead, jlong ptrLpOverlapped, jlong ptrLpCompletionRoutine) {
        if (!ReadFileEx((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToRead, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped, (LPOVERLAPPED_COMPLETION_ROUTINE) (uintptr_t) ptrLpCompletionRoutine)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFileEx
     * Signature: (JLjava/nio/ByteBuffer;IIJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFileEx__JLjava_nio_ByteBuffer_2IIJJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jobject lpBuffer, jint off, jint nNumberOfBytesToRead, jlong ptrLpOverlapped, jlong ptrLpCompletionRoutine) {
        if (!ReadFileEx((HANDLE) (uintptr_t) ptrHFile, (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToRead, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped, (LPOVERLAPPED_COMPLETION_ROUTINE) (uintptr_t) ptrLpCompletionRoutine)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFileEx
     * Signature: (JJIIJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFileEx__JJIIJJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jint off, jint nNumberOfBytesToWrite, jlong ptrLpOverlapped, jlong ptrLpCompletionRoutine) {
        if (!WriteFileEx((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped, (LPOVERLAPPED_COMPLETION_ROUTINE) (uintptr_t) ptrLpCompletionRoutine)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFileEx
     * Signature: (JJJIJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFileEx__JJJIJJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpBuffer, jlong off, jint nNumberOfBytesToWrite, jlong ptrLpOverlapped, jlong ptrLpCompletionRoutine) {
        if (!WriteFileEx((HANDLE) (uintptr_t) ptrHFile, ((void*) (uintptr_t) ptrLpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped, (LPOVERLAPPED_COMPLETION_ROUTINE) (uintptr_t) ptrLpCompletionRoutine)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFileEx
     * Signature: (JLjava/nio/ByteBuffer;IIJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFileEx__JLjava_nio_ByteBuffer_2IIJJ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jobject lpBuffer, jint off, jint nNumberOfBytesToWrite, jlong ptrLpOverlapped, jlong ptrLpCompletionRoutine) {
        if (!WriteFileEx((HANDLE) (uintptr_t) ptrHFile, (*env)->GetDirectBufferAddress(env, lpBuffer) + off, (uint32_t) nNumberOfBytesToWrite, (LPOVERLAPPED) (uintptr_t) ptrLpOverlapped, (LPOVERLAPPED_COMPLETION_ROUTINE) (uintptr_t) ptrLpCompletionRoutine)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }


#ifdef __cplusplus
}
#endif
#endif

