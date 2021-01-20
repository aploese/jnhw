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
     * Signature: (Lde/ibapl/jnhw/winapi/WinDef$HKEY;ILde/ibapl/jnhw/winapi/Winnt$LPWSTR;Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/winapi/WinDef$LPBYTE;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegEnumValueW
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hKey, jint dwIndex, jobject lpValueName, jobject lpType, jobject lpData) {
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
        DWORD lpcchValueName = (uint32_t) (*env)->GetIntField(env, lpValueName, de_ibapl_jnhw_winapi_Winnt_LPWSTR_bufferEnd_ID);
        DWORD _lpType;
        DWORD lpccData = lpData != NULL ? (uint32_t) (*env)->GetIntField(env, lpData, de_ibapl_jnhw_winapi_WinDef_LPBYTE_bufferEnd_ID) : 0;

        LSTATUS result = RegEnumValueW(UNWRAP_HKEY(hKey),
                (uint32_t) dwIndex,
                UNWRAP_LPWSTR(lpValueName),
                &lpcchValueName,
                NULL,
                lpType == NULL ? NULL : &_lpType,
                lpData == NULL ? NULL : UNWRAP_LPBYTE(lpData),
                lpData == NULL ? NULL : &lpccData);

        (*env)->SetIntField(env, lpValueName, de_ibapl_jnhw_winapi_Winnt_LPWSTR_bufferEnd_ID, (int32_t) lpcchValueName);
        if (lpType != NULL) {
            SET_INT_REF_VALUE(lpType, (int32_t) _lpType);
        }
        if (lpData != NULL) {
            (*env)->SetIntField(env, lpData, de_ibapl_jnhw_winapi_WinDef_LPBYTE_bufferEnd_ID, (int32_t) lpccData);
        }

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
     * Signature: (Lde/ibapl/jnhw/winapi/WinDef$HKEY;Ljava/lang/String;IILde/ibapl/jnhw/winapi/WinDef$PHKEY;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegOpenKeyExW
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hKey, jstring lpSubKey, jint ulOptions, jint samDesired, jobject phkResult) {
        if (hKey == NULL) {
            throw_NullPointerException(env, "hKey is null");
            return;
        }
        if (lpSubKey == NULL) {
            throw_NullPointerException(env, "lpSubKey is null.");
            return;
        }
        if (phkResult == NULL) {
            throw_NullPointerException(env, "phkResult is null.");
            return;
        }
        LPCWSTR _lpSubKey = (*env)->GetStringChars(env, lpSubKey, NULL);

        LSTATUS result = RegOpenKeyExW(UNWRAP_HKEY(hKey), _lpSubKey, (uint32_t) ulOptions, (uint32_t) samDesired, UNWRAP_PHKEY(phkResult));

        (*env)->ReleaseStringChars(env, lpSubKey, _lpSubKey);

        if (result != ERROR_SUCCESS) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    RegCloseKey
     * Signature: (Lde/ibapl/jnhw/winapi/WinDef$HKEY;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegCloseKey
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject hKey) {
        if (hKey == NULL) {
            throw_NullPointerException(env, "hKey is null");
            return;
        }
        LSTATUS result = RegCloseKey(UNWRAP_HKEY(hKey));
        if (result != ERROR_SUCCESS) {
            throw_NativeErrorException(env, (int32_t) GetLastError());
        }
    }

#ifdef __cplusplus
}
#endif
#endif
