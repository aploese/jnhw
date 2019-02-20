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
     * Signature: (JJ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_WaitForSingleObject
    (JNIEnv *env, jclass clazz, jlong hHandle, jlong dwMilliseconds) {
        return WaitForSingleObject((HANDLE) (uintptr_t) hHandle, dwMilliseconds);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    CreateEventW
     * Signature: (JZZLjava/lang/String;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_CreateEventW
    (JNIEnv *env, jclass clazz, jlong lpEventAttributes, jboolean bManualReset, jboolean bInitialState, jstring lpName) {
        LPCWSTR _lpName = lpName != NULL ? (*env)->GetStringChars(env, lpName, NULL) : NULL;

        HANDLE result = CreateEventW((LPSECURITY_ATTRIBUTES) (uintptr_t) lpEventAttributes, bManualReset, bInitialState, _lpName);
        if (lpName != NULL) {
            (*env)->ReleaseStringChars(env, lpName, _lpName);
        }
        
        if (result == NULL) {
            throw_NativeErrorException(env, GetLastError());
        }
        return (uintptr_t) result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    SetEvent
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_SetEvent
    (JNIEnv *env, jclass clazz, jlong hEvent) {
        return SetEvent((HANDLE) (uintptr_t) hEvent);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Synchapi
     * Method:    ResetEvent
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_ResetEvent
    (JNIEnv *env, jclass clazz, jlong hEvent) {
        return ResetEvent((HANDLE) (uintptr_t) hEvent);
    }


#endif
#ifdef __cplusplus
}
#endif
