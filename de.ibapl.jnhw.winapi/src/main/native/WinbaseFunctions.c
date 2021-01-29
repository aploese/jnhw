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
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ClearCommBreak
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
        if (!ClearCommBreak(UNWRAP_HANDLE(hFile))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    ClearCommError
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Winbase/COMSTAT;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ClearCommError
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpErrors, jobject lpCOMSTAT) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
        DWORD _lpErrors;
        if (!ClearCommError(UNWRAP_HANDLE(hFile), lpErrors != NULL ? &_lpErrors : NULL, UNWRAP_LPCOMSTAT_OR_NULL(lpCOMSTAT))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
        if (lpErrors != NULL) {
            SET_INT_REF_VALUE(lpErrors, (int32_t)_lpErrors);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    EscapeCommFunction
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_EscapeCommFunction
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jint dwFunc) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
    if (!EscapeCommFunction(UNWRAP_HANDLE(hFile), (uint32_t)dwFunc)) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    GetCommModemStatus
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/common/references/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommModemStatus
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpModemStat) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
        DWORD _lpModemStat;
        if (!GetCommModemStatus(UNWRAP_HANDLE(hFile), &_lpModemStat)) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
        SET_INT_REF_VALUE(lpModemStat, (int32_t)_lpModemStat);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    GetCommState
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/winapi/Winbase/DCB;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommState
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpDCB) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
        if (lpDCB == NULL) {
            throw_NullPointerException(env, "lpDCB is null");
            return;
        }
        if (!GetCommState(UNWRAP_HANDLE(hFile), UNWRAP_LPDCB(lpDCB))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    GetCommTimeouts
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/winapi/Winbase/COMMTIMEOUTS;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommTimeouts
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpCOMMTIMEOUTS) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
        if (lpCOMMTIMEOUTS == NULL) {
            throw_NullPointerException(env, "lpCOMMTIMEOUTS is null");
            return;
        }
        if (!GetCommTimeouts(UNWRAP_HANDLE(hFile), UNWRAP_LPCOMMTIMEOUTS(lpCOMMTIMEOUTS))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SetCommBreak
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommBreak
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
        if (!SetCommBreak(UNWRAP_HANDLE(hFile))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SetCommState
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/winapi/Winbase/DCB;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommState
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpDCB) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
        if (lpDCB == NULL) {
            throw_NullPointerException(env, "lpDCB is null");
            return;
        }
        if (!SetCommState(UNWRAP_HANDLE(hFile), UNWRAP_LPDCB(lpDCB))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SetCommTimeouts
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;Lde/ibapl/jnhw/winapi/Winbase/COMMTIMEOUTS;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommTimeouts
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject lpCOMMTIMEOUTS) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
        if (lpCOMMTIMEOUTS == NULL) {
            throw_NullPointerException(env, "lpCOMMTIMEOUTS is null");
            return;
        }
        if (!SetCommTimeouts(UNWRAP_HANDLE(hFile), UNWRAP_LPCOMMTIMEOUTS(lpCOMMTIMEOUTS))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SetFileCompletionNotificationModes
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;B)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetFileCompletionNotificationModes
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jbyte uFlags) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
        if (!SetFileCompletionNotificationModes(UNWRAP_HANDLE(hFile), (uint8_t)uFlags)) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    BindIoCompletionCallback
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt/HANDLE;Lde/ibapl/jnhw/winapi/Minwinbase/LPOVERLAPPED_COMPLETION_ROUTINE;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_BindIoCompletionCallback
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hFile, jobject Function, jint Flags) {
        if (hFile == NULL) {
            throw_NullPointerException(env, "hFile is null");
            return;
        }
        if (Function == NULL) {
            throw_NullPointerException(env, "Function is null.");
            return;
        }
        if (!BindIoCompletionCallback(UNWRAP_HANDLE(hFile), UNWRAP_LPOVERLAPPED_COMPLETION_ROUTINE(Function), (uint32_t)Flags)) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }


#ifdef __cplusplus
}
#endif
#endif
