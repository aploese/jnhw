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
#include "de_ibapl_jnhw_winapi_Synchapi.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef HAVE_SYNCHAPI_H
#include <synchapi.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    WaitForSingleObject
     * Signature: (JJ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_WaitForSingleObject
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHHandle, jlong dwMilliseconds) {
        DWORD result = WaitForSingleObject((HANDLE) (uintptr_t) ptrHHandle, (uint32_t) dwMilliseconds);
        if (result == WAIT_FAILED) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    WaitForSingleObjectEx
     * Signature: (JJZ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_WaitForSingleObjectEx
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHHandle, jlong dwMilliseconds, jboolean bAlertable) {
        DWORD result = WaitForSingleObjectEx((HANDLE) (uintptr_t) ptrHHandle, (uint32_t) dwMilliseconds, bAlertable);
        if (result == WAIT_FAILED) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    CreateEventW
     * Signature: (JZZLjava/lang/String;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_CreateEventW
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrLpEventAttributes, jboolean bManualReset, jboolean bInitialState, jstring lpName) {

        LPCWSTR _lpName = lpName != NULL ? (*env)->GetStringChars(env, lpName, NULL) : NULL;

        HANDLE result = CreateEventW((LPSECURITY_ATTRIBUTES) (uintptr_t) ptrLpEventAttributes, bManualReset, bInitialState, _lpName);
        if (lpName != NULL) {
            (*env)->ReleaseStringChars(env, lpName, _lpName);
        }

        if (result == NULL) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
            return (int64_t) (uintptr_t) NULL;
        }
        return (int64_t) (uintptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    SetEvent
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_SetEvent
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHEvent) {

        if (!SetEvent((HANDLE) (uintptr_t) ptrHEvent)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    ResetEvent
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_ResetEvent
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHEvent) {
        if (!ResetEvent((HANDLE) (uintptr_t) ptrHEvent)) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    SleepEx
     * Signature: (JZ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_SleepEx
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong dwMilliseconds, jboolean bAlertable) {
        if ((dwMilliseconds < 0) && ((uint32_t) dwMilliseconds != INFINITE)) {
            throw_IllegalArgumentException(env, "dwMilliseconds < 0");
            return ERROR_INVALID_PARAMETER;
        }
        return SleepEx((uint32_t) dwMilliseconds, bAlertable);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    WaitForMultipleObjects_ArgsOK
     * Signature: (IJZJ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_WaitForMultipleObjects_1ArgsOK
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint nCount, jlong ptrLpHandles, jboolean bWaitAll, jlong dwMilliseconds) {
        DWORD result = WaitForMultipleObjects((uint32_t) nCount, (PHANDLE) (uintptr_t) ptrLpHandles, bWaitAll, (uint32_t) dwMilliseconds);
        if (result == WAIT_FAILED) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    WaitForMultipleObjectsEx_ArgsOK
     * Signature: (IJZJZ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_WaitForMultipleObjectsEx_1ArgsOK
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint nCount, jlong ptrLpHandles, jboolean bWaitAll, jlong dwMilliseconds, jboolean bAlertable) {
        DWORD result = WaitForMultipleObjectsEx((uint32_t) nCount, (PHANDLE) (uintptr_t) ptrLpHandles, bWaitAll, (uint32_t) dwMilliseconds, bAlertable);
        if (result == WAIT_FAILED) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
        return result;
    }

#endif
#ifdef __cplusplus
}
#endif
