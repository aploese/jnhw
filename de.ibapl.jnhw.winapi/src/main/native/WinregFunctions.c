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
#include "de_ibapl_jnhw_winapi_Winreg.h"

#ifdef HAVE_WINREG_H
#include <winreg.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    RegEnumValueW
     * Signature: (JIJJJJJ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegEnumValueW
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHKey, jint dwIndex, jlong ptrLpValueName, jlong ptrLpcchValueName, jlong ptrLpType, jlong ptrLpData, jlong ptrLpcbData) {

        LSTATUS result = RegEnumValueW((HKEY) (uintptr_t) ptrHKey,
                (uint32_t) dwIndex,
                (LPWSTR) (uintptr_t) ptrLpValueName,
                (LPDWORD) (uintptr_t) ptrLpcchValueName,
                NULL,
                (LPDWORD) (uintptr_t) ptrLpType,
                (uint8_t*) (uintptr_t) ptrLpData,
                (LPDWORD) (uintptr_t) ptrLpcbData);

        switch (result) {
            case ERROR_SUCCESS:
                return ERROR_SUCCESS;
            case ERROR_NO_MORE_ITEMS:
                return ERROR_NO_MORE_ITEMS;
            case ERROR_MORE_DATA:
                return ERROR_MORE_DATA;
            default:
                throw_NativeErrorException(env, (int32_t) GetLastError());
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    RegOpenKeyExW
     * Signature: (JLjava/lang/String;IIJ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegOpenKeyExW
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHKey, jstring lpSubKey, jint ulOptions, jint samDesired) {
        LPCWSTR _lpSubKey = (*env)->GetStringChars(env, lpSubKey, NULL);

        HKEY phkResult;
        LSTATUS result = RegOpenKeyExW((HKEY) (uintptr_t) ptrHKey, _lpSubKey, (uint32_t) ulOptions, (uint32_t) samDesired, &phkResult);

        (*env)->ReleaseStringChars(env, lpSubKey, _lpSubKey);

        if (result != ERROR_SUCCESS) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
        return (int64_t) (uintptr_t) phkResult;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    RegCloseKey
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegCloseKey
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrHKey) {
        LSTATUS result = RegCloseKey((HKEY) (uintptr_t) ptrHKey);
        if (result != ERROR_SUCCESS) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

#ifdef __cplusplus
}
#endif
#endif
