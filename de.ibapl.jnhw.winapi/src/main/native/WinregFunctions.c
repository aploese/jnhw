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
#include "de_ibapl_jnhw_winapi_Winreg.h"

#ifdef HAVE_WINREG_H
#include <winreg.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    RegEnumValueW
     * Signature: (Lde/ibapl/jnhw/winapi/Minwindef$HKEY;ILde/ibapl/jnhw/winapi/Winnt$LPWSTR;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/Minwindef$LPBYTE;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegEnumValueW
    (JNIEnv *env, jclass clazz, jobject hKey, jint dwIndex, jobject lpValueName, jobject lpType, jobject lpData) {
        if (hKey == NULL) {
            throw_NullPointerException(env, "hKey is null");
            return ERROR_INVALID_PARAMETER;
        }
        if (lpValueName == NULL) {
            throw_NullPointerException(env, "lpValueName is null");
            return ERROR_INVALID_PARAMETER;
        }
        //jobject lpccValueName, 
        //, jobject lpccData
        DWORD lpcchValueName = (*env)->GetIntField(env, lpValueName, de_ibapl_jnhw_winapi_Winnt_LPWSTR_bufferEnd_ID);
        DWORD _lpType;
        DWORD lpccData = lpData != NULL ? (*env)->GetIntField(env, lpData, de_ibapl_jnhw_winapi_Minwindef_LPBYTE_bufferEnd_ID) : 0;

        LSTATUS result = RegEnumValueW(UNWRAP_HKEY(hKey),
                dwIndex,
                UNWRAP_LPWSTR(lpValueName),
                &lpcchValueName,
                NULL,
                lpType == NULL ? NULL : &_lpType,
                lpData == NULL ? NULL : UNWRAP_LPBYTE(lpData),
                lpData == NULL ? NULL : &lpccData);

        (*env)->SetIntField(env, lpValueName, de_ibapl_jnhw_winapi_Winnt_LPWSTR_bufferEnd_ID, lpcchValueName);
        if (lpType != NULL) {
            SET_INT_REF_VALUE(lpType, _lpType);
        }
        if (lpData != NULL) {
            (*env)->SetIntField(env, lpData, de_ibapl_jnhw_winapi_Minwindef_LPBYTE_bufferEnd_ID, lpccData);
        }

        if ((result == ERROR_SUCCESS) || (result == ERROR_NO_MORE_ITEMS) || (result == ERROR_MORE_DATA)) {
        } else {
            throw_NativeErrorException(env, GetLastError());
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    RegOpenKeyExW
     * Signature: (Lde/ibapl/jnhw/winapi/Minwindef$HKEY;Ljava/lang/String;IILde/ibapl/jnhw/winapi/Minwindef$PHKEY;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegOpenKeyExW
    (JNIEnv *env, jclass clazz, jobject hKey, jstring lpSubKey, jint ulOptions, jint samDesired, jobject phkResult) {
        if (hKey == NULL) {
            throw_NullPointerException(env, "hKey is null");
            return ERROR_INVALID_PARAMETER;
        }
        if (lpSubKey == NULL) {
            throw_NullPointerException(env, "lpSubKey is null.");
            return ERROR_INVALID_PARAMETER;
        }
        if (phkResult == NULL) {
            throw_NullPointerException(env, "phkResult is null.");
            return ERROR_INVALID_PARAMETER;
        }
        LPCWSTR _lpSubKey = (*env)->GetStringChars(env, lpSubKey, NULL);

        HKEY _phkResult;

        LSTATUS result = RegOpenKeyExW(UNWRAP_HKEY(hKey), _lpSubKey, ulOptions, samDesired, &_phkResult);

        (*env)->ReleaseStringChars(env, lpSubKey, _lpSubKey);
        SET_HANDLE_VALUE(phkResult, _phkResult);

        if (result != ERROR_SUCCESS) {
            throw_NativeErrorException(env, GetLastError());
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    RegCloseKey
     * Signature: (Lde/ibapl/jnhw/winapi/Minwindef$HKEY;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegCloseKey
    (JNIEnv *env, jclass clazz, jobject hKey) {
        if (hKey == NULL) {
            throw_NullPointerException(env, "hKey is null");
            return ERROR_INVALID_PARAMETER;
        }
        LSTATUS result = RegCloseKey(UNWRAP_HKEY(hKey));
        if (result != ERROR_SUCCESS) {
            throw_NativeErrorException(env, GetLastError());
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif
