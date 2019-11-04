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
#include "de_ibapl_jnhw_winapi_Synchapi.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef HAVE_SYNCHAPI_H
#include <synchapi.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    WaitForSingleObject
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_WaitForSingleObject
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hHandle, jlong dwMilliseconds) {
        if (hHandle == NULL) {
            throw_NullPointerException(env, "hHandle is null");
            return ERROR_INVALID_PARAMETER;
        }
        DWORD result = WaitForSingleObject(UNWRAP_HANDLE(hHandle), (uint32_t)dwMilliseconds);
        if (result == WAIT_FAILED) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    CreateEventW
     * Signature: (Lde/ibapl/jnhw/winapi/Minwinbase$SECURITY_ATTRIBUTES;ZZLjava/lang/String;)Lde/ibapl/jnhw/winapi/Winnt$HANDLE;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_CreateEventW
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject lpEventAttributes, jboolean bManualReset, jboolean bInitialState, jstring lpName) {

        LPCWSTR _lpName = lpName != NULL ? (*env)->GetStringChars(env, lpName, NULL) : NULL;

        HANDLE result = CreateEventW(UNWRAP_LPSECURITY_ATTRIBUTES_OR_NULL(lpEventAttributes), bManualReset, bInitialState, _lpName);
        if (lpName != NULL) {
            (*env)->ReleaseStringChars(env, lpName, _lpName);
        }

        if (result == NULL) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
            return NULL;
        }
        return CREATE_HANDLE(result);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    SetEvent
     * Signature: (Lde/ibapl/jnhw/winapi/Winnt$HANDLE;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_SetEvent
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hEvent) {
        if (hEvent == NULL) {
            throw_NullPointerException(env, "hEvent is null");
            return;
        }

        if (!SetEvent(UNWRAP_HANDLE(hEvent))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    ResetEvent
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_ResetEvent
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hEvent) {
        if (hEvent == NULL) {
            throw_NullPointerException(env, "hEvent is null");
            return;
        }
        if (!ResetEvent(UNWRAP_HANDLE(hEvent))) {
            throw_NativeErrorException(env, (int32_t)GetLastError());
        }
    }


#endif
#ifdef __cplusplus
}
#endif
