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
#include "de_ibapl_jnhw_winapi_Winbase.h"

#ifdef HAVE_WINBASE_H
#include <winbase.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    ClearCommBreak
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ClearCommBreak
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile) {
        if (!ClearCommBreak((HANDLE) (uintptr_t) ptrHFile)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    ClearCommError
     * Signature: (JJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ClearCommError
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpErrors, jlong ptrLpCOMSTAT) {
        if (!ClearCommError((HANDLE) (uintptr_t) ptrHFile, (LPDWORD) (uintptr_t) ptrLpErrors, (LPCOMSTAT) (uintptr_t) ptrLpCOMSTAT)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    EscapeCommFunction
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_EscapeCommFunction
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jint dwFunc) {
        if (!EscapeCommFunction((HANDLE) (uintptr_t) ptrHFile, (uint32_t) dwFunc)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    GetCommModemStatus
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommModemStatus
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpModemStat) {
        if (!GetCommModemStatus((HANDLE) (uintptr_t) ptrHFile, (LPDWORD) (uintptr_t) ptrLpModemStat)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    GetCommState
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommState
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpDCB) {
        if (!GetCommState((HANDLE) (uintptr_t) ptrHFile, (LPDCB) (uintptr_t) ptrLpDCB)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    GetCommTimeouts
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommTimeouts
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpCOMMTIMEOUTS) {
        if (!GetCommTimeouts((HANDLE) (uintptr_t) ptrHFile, (LPCOMMTIMEOUTS) (uintptr_t) ptrLpCOMMTIMEOUTS)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SetCommBreak
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommBreak
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile) {
        if (!SetCommBreak((HANDLE) (uintptr_t) ptrHFile)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SetCommState
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommState
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpDCB) {
        if (!SetCommState((HANDLE) (uintptr_t) ptrHFile, (LPDCB) (uintptr_t) ptrLpDCB)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SetCommTimeouts
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommTimeouts
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrLpCOMMTIMEOUTS) {
        if (!SetCommTimeouts((HANDLE) (uintptr_t) ptrHFile, (LPCOMMTIMEOUTS) (uintptr_t) ptrLpCOMMTIMEOUTS)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SetFileCompletionNotificationModes
     * Signature: (JB)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetFileCompletionNotificationModes
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jbyte uFlags) {
        if (!SetFileCompletionNotificationModes((HANDLE) (uintptr_t) ptrHFile, (uint8_t) uFlags)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    BindIoCompletionCallback
     * Signature: (JJI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_BindIoCompletionCallback
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHFile, jlong ptrFunction, jint Flags) {
        if (!BindIoCompletionCallback((HANDLE) (uintptr_t) ptrHFile, (LPOVERLAPPED_COMPLETION_ROUTINE) (uintptr_t) ptrFunction, (uint32_t) Flags)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }


#ifdef __cplusplus
}
#endif
#endif
