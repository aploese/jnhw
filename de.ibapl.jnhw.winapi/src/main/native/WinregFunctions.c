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
     * Signature: (JIJLde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/IntRef;JLde/ibapl/jnhw/IntRef;)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegEnumValueW
    (JNIEnv *env, jclass clazz, jlong hKey, jint dwIndex, jlong lpValueName, jobject lpccValueName, jobject lpType, jlong lpData, jobject lpccData) {

    DWORD _lpcchValueName = (*env)->GetIntField(env, lpccValueName, de_ibapl_jnhw_IntRef_value_ID);
    DWORD _lpType;
    DWORD _lpccData = lpccData != NULL ? (*env)->GetIntField(env, lpccData, de_ibapl_jnhw_IntRef_value_ID) : 0;

    LSTATUS result = RegEnumValueW((HKEY)(uintptr_t)hKey,
            dwIndex,
            (LPWSTR) (uintptr_t) lpValueName,
            &_lpcchValueName,
            NULL,
            lpType != NULL ? &_lpType : NULL,
            (LPBYTE) (uintptr_t) lpData,
            lpccData != NULL ? &_lpccData : NULL);

    (*env)->SetIntField(env, lpccValueName, de_ibapl_jnhw_IntRef_value_ID, _lpcchValueName);
    if (lpType != NULL) {
        (*env)->SetIntField(env, lpType, de_ibapl_jnhw_IntRef_value_ID, _lpType);
    }
    if (lpccData != NULL) {
        (*env)->SetIntField(env, lpccData, de_ibapl_jnhw_IntRef_value_ID, _lpccData);
    }

    return result;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    RegOpenKeyExW
 * Signature: (JLjava/lang/String;IILde/ibapl/jnhw/LongRef;)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegOpenKeyExW
(JNIEnv *env, jclass clazz, jlong hKey, jstring lpSubKey, jint ulOptions, jint samDesired, jobject phkResult) {
    if (lpSubKey == NULL) {
        throw_NullPointerException(env, "lpSubKey is null.");
        return ERROR_INVALID_PARAMETER;
    }
    LPCWSTR _lpSubKey = (*env)->GetStringChars(env, lpSubKey, NULL);

    HKEY _phkResult;

    LSTATUS result = RegOpenKeyExW((HKEY)(uintptr_t)hKey, _lpSubKey, ulOptions, samDesired, &_phkResult);

    (*env)->ReleaseStringChars(env, lpSubKey, _lpSubKey);
    (*env)->SetLongField(env, phkResult, de_ibapl_jnhw_LongRef_value_ID, (jlong)(uintptr_t)_phkResult);

    return result;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    RegCloseKey
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegCloseKey
(JNIEnv *env, jclass clazz, jlong hKey) {
    return RegCloseKey((HKEY)(uintptr_t)hKey);
}

#ifdef __cplusplus
}
#endif
#endif
