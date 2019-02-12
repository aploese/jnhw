#include <config.h>
#include "jnhw.h"

#ifdef HAVE_WINREG_H
#include <windows.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    RegEnumValueW
     * Signature: (JIJLde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/IntRef;JLde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegEnumValueW
    (JNIEnv *env, jclass clazz, jlong hKey, jint dwIndex, jlong lpValueName, jobject lpccValueName, jobject lpType, jlong lpData, jobject lpccData);

    int _lpcchValueName = (*env)->GetIntField(env, lpccValueName, de_ibapl_jnhw_IntRef_value_ID);
    int _lpType;
    int _lpccData = lpccData != null ? (*env)->GetIntField(env, lpccData, de_ibapl_jnhw_IntRef_value_ID) : 0;

    LSTATUS result = RegEnumValueW(hKey,
            dwIndex,
            (LPWSTR) (uintptr_t) lpValueName,
            &_lpcchValueName,
            NULL,
            lpType != null ? &_lpType : NULL,
            (LPBYTE) (uintptr_t) lpData,
            lpccData != null ? &_lpccData : NULL);

    (*env)->SetIntField(env, lpccValueName, de_ibapl_jnhw_IntRef_value_ID, _lpcchValueName);
    if (lpType != null) {
        (*env)->SetIntField(env, lpType, de_ibapl_jnhw_IntRef_value_ID, _lpType);
    }
    if (lpccData != null) {
        (*env)->SetIntField(env, lpccData, de_ibapl_jnhw_IntRef_value_ID, _lpccData);
    }

    if (result != ERROR_SUCCESS) {
        throw_NativeErrorException(env, GetLastError());
    }
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    RegOpenKeyExW
 * Signature: (JLjava/lang/CharSequence;IILde/ibapl/jnhw/LongRef;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegOpenKeyExW
(JNIEnv *env, jclass clazz, jlong hKey, jobject lpSubKey, jint ulOptions, jint samDesired, jobject phkResult) {
    if (lpSubKey == NULL) {
        throw_NullPointerException(env, "lpSubKey is null.");
        return -1;
    }
    LPCWSTR _lpSubKey = (*env)->GetStringChars(env, lpSubKey, NULL);

    int _phkResult;

    LSTATUS result = RegOpenKeyExW(hKey, _lpSubKey, samDesired, _phkResult);

    (*env)->ReleaseStringChars(env, lpSubKey, _lpSubKey);
    (*env)->SetLongField(env, phkResult, de_ibapl_jnhw_LongRef_value_ID, _phkResult);

    if (ERROR_SUCCESS != result) {
        throw_NativeErrorException(env, GetLastError());
    }
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    RegCloseKey
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winreg_RegCloseKey
(JNIEnv *env, jclass clazz, jlong hKey) {
    if (ERROR_SUCCESS != RegCloseKey(hKey)) {
        throw_NativeErrorException(env, GetLastError());
    }
}

#ifdef __cplusplus
}
#endif
#endif
