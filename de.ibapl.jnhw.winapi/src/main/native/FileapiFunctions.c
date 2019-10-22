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
    (JNIEnv *env, jclass clazz, jstring lpFileName, jint dwDesiredAccess, jint dwShareMode, jobject lpSecurityAttributes, jint dwCreationDisposition, jint dwFlagsAndAttributes, jobject hTemplateFile) {
        if (lpFileName == NULL) {
            throw_NullPointerException(env, "lpFileName is null.");
            return NULL;
        }

        LPCWSTR _lpFileName = (*env)->GetStringChars(env, lpFileName, NULL);

        HANDLE result = CreateFileW(_lpFileName, dwDesiredAccess, dwShareMode, UNWRAP_LPSECURITY_ATTRIBUTES_OR_NULL(lpSecurityAttributes), dwCreationDisposition, dwFlagsAndAttributes, UNWRAP_HANDLE_OR_NULL(hTemplateFile));

        (*env)->ReleaseStringChars(env, lpFileName, _lpFileName);
        if (result == INVALID_HANDLE_VALUE) {
            throw_NativeErrorException(env, GetLastError());
        }
        return CREATE_HANDLE(result, JNI_TRUE);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    FlushFileBuffers
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_FlushFileBuffers
    (JNIEnv *env, jclass clazz, jobject hFile) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return;
        }
        if (!FlushFileBuffers(UNWRAP_HANDLE(hFile))) {
            throw_NativeErrorException(env, GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2_3BII
    (JNIEnv *env, jclass clazz, jobject hFile, jbyteArray lpBuffer, jint pos, jint len) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null");
            return -1;
        }
        if (outOfBoundsByteArray(env, pos, len, lpBuffer)) {
            throw_ArrayIndexOutOfBoundsException(env, "lpBuffer");
            return -1;
        }

        jbyte stackBuf[len > MAX_STACK_BUF_SIZE ? 0 : len];
        jbyte *_buf = NULL;
        if (len == 0) {
            return 0;
        } else if (len > MAX_STACK_BUF_SIZE) {
            _buf = malloc(len);
            if (_buf == NULL) {
                throwException(env, "java/lang/OutOfMemoryError", "Can`t aquire %d bytes of memory", len);
                return 0;
            }
        } else {
            _buf = stackBuf;
        }

        DWORD lpNumberOfBytesRead;
        if (ReadFile(UNWRAP_HANDLE(hFile), _buf, len, &lpNumberOfBytesRead, NULL)) {
            (*env)->SetByteArrayRegion(env, lpBuffer, pos, lpNumberOfBytesRead, _buf);
        } else {
            throw_NativeErrorException(env, GetLastError());
            lpNumberOfBytesRead = -1;
        }

        if (_buf != stackBuf) {
            free(_buf);
        }

        return lpNumberOfBytesRead;
    }

/*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile_ParamsOK
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Ljava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile_1ParamsOK__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Ljava_nio_ByteBuffer_2II
    (JNIEnv *env, jclass clazz, jobject hFile, jobject lpBuffer, jint pos, jint len) {

        DWORD lpNumberOfBytesRead;
        if (ReadFile(UNWRAP_HANDLE(hFile), (*env)->GetDirectBufferAddress(env, lpBuffer) + pos, len, &lpNumberOfBytesRead, NULL)) {
            return lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile_ParamsOK
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Ljava/nio/ByteBuffer;IILde/ibapl/jnhw/winapi/Minwinbase$OVERLAPPED;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile_1ParamsOK__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Ljava_nio_ByteBuffer_2IILde_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_2
    (JNIEnv *env, jclass clazz, jobject hFile, jobject lpBuffer, jint pos, jint len, jobject lpOVERLAPPED) {
        if (!ReadFile(UNWRAP_HANDLE(hFile), (*env)->GetDirectBufferAddress(env, lpBuffer) + pos, len, NULL, UNWRAP_LPOVERLAPPED(lpOVERLAPPED))) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/OpaqueMemory;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Lde_ibapl_jnhw_OpaqueMemory_2II
    (JNIEnv *env, jclass clazz, jobject hFile, jobject lpBuffer, jint pos, jint len) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null.");
            return -1;
        }
        if (outOfBoundsOpaqueMemory(env, pos, len, lpBuffer)) {
            throw_IndexOutOfBoundsException(env, "lpBuffer index out of bounds");
            return -1;
        }

        DWORD lpNumberOfBytesRead;
        if (ReadFile(UNWRAP_HANDLE(hFile), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(lpBuffer) + pos, len, &lpNumberOfBytesRead, NULL)) {
            return lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/OpaqueMemory;IILde/ibapl/jnhw/winapi/Minwinbase$OVERLAPPED;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Lde_ibapl_jnhw_OpaqueMemory_2IILde_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_2
    (JNIEnv *env, jclass clazz, jobject hFile, jobject lpBuffer, jint pos, jint len, jobject lpOVERLAPPED) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null.");
            return;
        }
        if (outOfBoundsOpaqueMemory(env, pos, len, lpBuffer)) {
            throw_IndexOutOfBoundsException(env, "lpBuffer index out of bounds");
            return;
        }
        if (lpOVERLAPPED == NULL) {
            throw_NullPointerException(env, "lpOVERLAPPED is null.");
            return;
        }
        if (!ReadFile(UNWRAP_HANDLE(hFile), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(lpBuffer) + pos, len, NULL, UNWRAP_LPOVERLAPPED(lpOVERLAPPED))) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;[BII)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2_3BII
    (JNIEnv *env, jclass clazz, jobject hFile, jbyteArray lpBuffer, jint pos, jint len) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null");
            return -1;
        }
        if (outOfBoundsByteArray(env, pos, len, lpBuffer)) {
            throw_ArrayIndexOutOfBoundsException(env, "lpBuffer");
            return -1;
        }

        jbyte stackBuf[len > MAX_STACK_BUF_SIZE ? 0 : len];
        jbyte *_buf = NULL;
        if (len == 0) {
            return 0;
        } else if (len > MAX_STACK_BUF_SIZE) {
            _buf = malloc(len);
            if (_buf == NULL) {
                throwException(env, "java/lang/OutOfMemoryError", "Can`t aquire %d bytes of memory", len);
                return 0;
            }
        } else {
            _buf = stackBuf;
        }

        (*env)->GetByteArrayRegion(env, lpBuffer, pos, len, _buf);
        if ((*env)->ExceptionOccurred(env)) {
            return -1;
        }

        DWORD lpNumberOfBytesWritten;
        if (WriteFile(UNWRAP_HANDLE(hFile), _buf, len, &lpNumberOfBytesWritten, NULL)) {
        } else {
            throw_NativeErrorException(env, errno);
            lpNumberOfBytesWritten = -1;
        }

        if (_buf != stackBuf) {
            free(_buf);
        }

        return lpNumberOfBytesWritten;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile_ParamsOK
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Ljava/nio/ByteBuffer;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile_1ParamsOK__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Ljava_nio_ByteBuffer_2II
    (JNIEnv *env, jclass clazz, jobject hFile, jobject lpBuffer, jint pos, jint len) {

        DWORD lpNumberOfBytesWritten;
        if (WriteFile(UNWRAP_HANDLE(hFile), (*env)->GetDirectBufferAddress(env, lpBuffer) + pos, len, &lpNumberOfBytesWritten, NULL)) {
            return lpNumberOfBytesWritten;
        } else {
            throw_NativeErrorException(env, GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile_ParamsOK
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Ljava/nio/ByteBuffer;IILde/ibapl/jnhw/winapi/Minwinbase$OVERLAPPED;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile_1ParamsOK__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Ljava_nio_ByteBuffer_2IILde_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_2
    (JNIEnv *env, jclass clazz, jobject hFile, jobject lpBuffer, jint pos, jint len, jobject lpOVERLAPPED) {
        if (!WriteFile(UNWRAP_HANDLE(hFile), (*env)->GetDirectBufferAddress(env, lpBuffer) + pos, len, NULL, UNWRAP_LPOVERLAPPED(lpOVERLAPPED))) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/OpaqueMemory;II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Lde_ibapl_jnhw_OpaqueMemory_2II
    (JNIEnv *env, jclass clazz, jobject hFile, jobject lpBuffer, jint pos, jint len) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return -1;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null.");
            return -1;
        }
        if (outOfBoundsOpaqueMemory(env, pos, len, lpBuffer)) {
            throw_IndexOutOfBoundsException(env, "lpBuffer index out of bounds");
            return -1;
        }

        DWORD lpNumberOfBytesRead;
        if (WriteFile(UNWRAP_HANDLE(hFile), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(lpBuffer) + pos, len, &lpNumberOfBytesRead, NULL)) {
            return lpNumberOfBytesRead;
        } else {
            throw_NativeErrorException(env, GetLastError());
            return -1;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/OpaqueMemory;IILde/ibapl/jnhw/winapi/Minwinbase$OVERLAPPED;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__Lde_ibapl_jnhw_winapi_Winnt_00024HANDLE_2Lde_ibapl_jnhw_OpaqueMemory_2IILde_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_2
    (JNIEnv *env, jclass clazz, jobject hFile, jobject lpBuffer, jint pos, jint len, jobject lpOVERLAPPED) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null.");
            return;
        }
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null.");
            return;
        }
        if (outOfBoundsOpaqueMemory(env, pos, len, lpBuffer)) {
            throw_IndexOutOfBoundsException(env, "lpBuffer index out of bounds");
            return;
        }
        if (lpOVERLAPPED == NULL) {
            throw_NullPointerException(env, "lpOVERLAPPED is null.");
            return;
        }
        if (!WriteFile(UNWRAP_HANDLE(hFile), UNWRAP_OPAQUE_MEM_TO_VOID_PTR(lpBuffer) + pos, len, NULL, UNWRAP_LPOVERLAPPED(lpOVERLAPPED))) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, GetLastError());
            }
        }
    }

#ifdef __cplusplus
}
#endif
#endif

