#include "../../../config.h"
#include "jnhw.h"
#include "de_ibapl_jnhw_winapi_Fileapi.h"

#ifdef HAVE_FILEAPI_H
#include <windows.h>
#include <fileapi.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    CreateFileW
     * Signature: (Ljava/lang/String;IIJIIJ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_CreateFileW
    (JNIEnv *env, jclass clazz, jstring lpFileName, jint dwDesiredAccess, jint dwShareMode, jlong lpSecurityAttributes, jint dwCreationDisposition, jint dwFlagsAndAttributes, jlong hTemplateFile) {
        if (lpFileName == NULL) {
            throw_NullPointerException(env, "lpFileName is null.");
            return ERROR_INVALID_PARAMETER;
        }
        LPCWSTR _lpFileName = (*env)->GetStringChars(env, lpFileName, NULL);

        HANDLE result = CreateFileW(_lpFileName, dwDesiredAccess, dwShareMode, (LPSECURITY_ATTRIBUTES) (uintptr_t) lpSecurityAttributes, dwCreationDisposition, dwFlagsAndAttributes, (HANDLE) (uintptr_t) hTemplateFile);

        (*env)->ReleaseStringChars(env, lpFileName, _lpFileName);
        if (result == INVALID_HANDLE_VALUE) {
            throw_NativeErrorException(env, GetLastError());
        }
        return (jlong) (uintptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    FlushFileBuffers
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_FlushFileBuffers
    (JNIEnv *env, jclass clazz, jlong hFile) {
        if (!FlushFileBuffers((HANDLE) (uintptr_t) hFile)) {
            throw_NativeErrorException(env, GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (J[BIILde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__J_3BIILde_ibapl_jnhw_IntRef_2
    (JNIEnv *env, jclass clazz, jlong hFile, jbyteArray lpBuffer, jint pos, jint len, jobject lpNumberOfBytesRead) {
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null");
            return;
        }
        int bufsize = (*env)->GetArrayLength(env, lpBuffer);
        if ((pos < 0) || (pos > bufsize) || (len < 0) || (pos + len > bufsize)) {
            throw_ArrayIndexOutOfBoundsException(env, "");
            return;
        }
        jbyte _buf[len];

        DWORD _lpNumberOfBytesRead = 0;
        BOOL result = ReadFile((HANDLE) (uintptr_t) hFile, &_buf, len, &_lpNumberOfBytesRead, NULL);
        (*env)->SetByteArrayRegion(env, lpBuffer, pos, _lpNumberOfBytesRead, _buf);
        (*env)->SetIntField(env, lpNumberOfBytesRead, de_ibapl_jnhw_IntRef_value_ID, _lpNumberOfBytesRead);

        if (!result) {
            throw_NativeErrorException(env, GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (JLjava/nio/ByteBuffer;IILde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__JLjava_nio_ByteBuffer_2IILde_ibapl_jnhw_IntRef_2
    (JNIEnv *env, jclass clazz, jlong hFile, jobject lpBuffer, jint pos, jint len, jobject lpNumberOfBytesRead) {
        DWORD _lpNumberOfBytesRead;
        if (ReadFile((HANDLE) (uintptr_t) hFile, (*env)->GetDirectBufferAddress(env, lpBuffer) + pos, len, &_lpNumberOfBytesRead, NULL)) {
            (*env)->SetIntField(env, lpNumberOfBytesRead, de_ibapl_jnhw_IntRef_value_ID, _lpNumberOfBytesRead);
        } else {
            throw_NativeErrorException(env, GetLastError());
            return;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    ReadFile
     * Signature: (JLjava/nio/ByteBuffer;IIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_ReadFile__JLjava_nio_ByteBuffer_2IIJ
    (JNIEnv *env, jclass clazz, jlong hFile, jobject lpBuffer, jint pos, jint len, jlong lpOVERLAPPED) {
        if (!ReadFile((HANDLE) (uintptr_t) hFile, (*env)->GetDirectBufferAddress(env, lpBuffer) + pos, len, NULL, (LPOVERLAPPED) (uintptr_t) lpOVERLAPPED)) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, GetLastError());
            }
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (J[BIILde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__J_3BIILde_ibapl_jnhw_IntRef_2
    (JNIEnv *env, jclass clazz, jlong hFile, jbyteArray lpBuffer, jint pos, jint len, jobject lpNumberOfBytesWritten) {
        if (lpBuffer == NULL) {
            throw_NullPointerException(env, "lpBuffer is null");
            return;
        }
        jbyte _buf[len];
        (*env)->GetByteArrayRegion(env, lpBuffer, pos, len, _buf);
        if ((*env)->ExceptionOccurred(env)) {
            return;
        }
        DWORD _lpNumberOfBytesWritten = 0;
        BOOL result = WriteFile((HANDLE) (uintptr_t) hFile, &_buf, len, &_lpNumberOfBytesWritten, NULL);
        (*env)->SetIntField(env, lpNumberOfBytesWritten, de_ibapl_jnhw_IntRef_value_ID, _lpNumberOfBytesWritten);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (JLjava/nio/ByteBuffer;IILde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__JLjava_nio_ByteBuffer_2IILde_ibapl_jnhw_IntRef_2
    (JNIEnv *env, jclass clazz, jlong hFile, jobject lpBuffer, jint pos, jint len, jobject lpNumberOfBytesWritten) {
        DWORD _lpNumberOfBytesWritten;
        if (WriteFile((HANDLE) (uintptr_t) hFile, (*env)->GetDirectBufferAddress(env, lpBuffer) + pos, len, &_lpNumberOfBytesWritten, NULL)) {
            (*env)->SetIntField(env, lpNumberOfBytesWritten, de_ibapl_jnhw_IntRef_value_ID, _lpNumberOfBytesWritten);
        } else {
            throw_NativeErrorException(env, GetLastError());
            return;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    WriteFile
     * Signature: (JLjava/nio/ByteBuffer;IIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_WriteFile__JLjava_nio_ByteBuffer_2IIJ
    (JNIEnv *env, jclass clazz, jlong hFile, jobject lpBuffer, jint pos, jint len, jlong lpOVERLAPPED) {
        if (!WriteFile((HANDLE) (uintptr_t) hFile, (*env)->GetDirectBufferAddress(env, lpBuffer) + pos, len, NULL, (LPOVERLAPPED) (uintptr_t) lpOVERLAPPED)) {
            if (GetLastError() != ERROR_IO_PENDING) {
                throw_NativeErrorException(env, GetLastError());
            }
        }
    }
#ifdef __cplusplus
}
#endif
#endif

