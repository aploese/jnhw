#include <config.h>
#include "jnhw.h"

#ifdef HAVE_WINBASE_H
#include <windows.h>
#include <winbase.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CloseHandle
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CloseHandle
    (JNIEnv *env, jclass clazz, jlong hObject) {
        if (!CloseHandle((HANDLE)(uintptr_t)hObject)) {
            throw_NativeErrorException(env, GetLastError());
        }

    }
    
/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    ClearCommBreak
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ClearCommBreak
  (JNIEnv *env, jclass clazz, jlong hFile) {
    if (!ClearCommBreak((HANDLE)(uintptr_t)hFile)) {
            throw_NativeErrorException(env, GetLastError());
    }
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    ClearCommError
 * Signature: (JLde/ibapl/jnhw/IntRef;J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ClearCommError
  (JNIEnv *env, jclass clazz, jlong hFile, jobject lpErrors, jlong lpCOMSTAT) {
    DWORD _lpErrors;
    if (!ClearCommError((HANDLE)(uintptr_t)hFile, lpErrors != NULL ? &_lpErrors : NULL, (LPCOMSTAT)(uintptr_t)lpCOMSTAT)) {
            throw_NativeErrorException(env, GetLastError());
    }
    if (lpErrors != NULL) {
        (*env)->SetIntField(env, lpErrors, de_ibapl_jnhw_IntRef_value_ID, _lpErrors);
    }
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    EscapeCommFunction
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_EscapeCommFunction
  (JNIEnv *env, jclass clazz, jlong hFile, jint dwFunc) {
    if (!EscapeCommFunction((HANDLE)(uintptr_t)hFile, dwFunc)) {
            throw_NativeErrorException(env, GetLastError());
    }
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetCommModemStatus
 * Signature: (JLde/ibapl/jnhw/IntRef;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommModemStatus
  (JNIEnv *env, jclass clazz, jlong hFile, jobject lpModemStat) {
    DWORD _lpModemStat;
    if (!GetCommModemStatus((HANDLE)(uintptr_t)hFile, &_lpModemStat)) {
            throw_NativeErrorException(env, GetLastError());
    }
        (*env)->SetIntField(env, lpModemStat, de_ibapl_jnhw_IntRef_value_ID, _lpModemStat);
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetCommState
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommState
  (JNIEnv *env, jclass clazz, jlong hFile, jlong lpDCB) {
    if (!GetCommState((HANDLE)(uintptr_t)hFile, (LPDCB)(uintptr_t)lpDCB)) {
            throw_NativeErrorException(env, GetLastError());
    }
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    GetCommTimeouts
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_GetCommTimeouts
  (JNIEnv *env, jclass clazz, jlong hFile, jlong lpCOMMTIMEOUTS) {
    if (!GetCommTimeouts((HANDLE)(uintptr_t)hFile, (LPCOMMTIMEOUTS)(uintptr_t)lpCOMMTIMEOUTS)) {
            throw_NativeErrorException(env, GetLastError());
    }
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SetCommBreak
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommBreak
  (JNIEnv *env, jclass clazz, jlong hFile) {
    if (!SetCommBreak((HANDLE)(uintptr_t)hFile)) {
            throw_NativeErrorException(env, GetLastError());
    }
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SetCommState
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommState
  (JNIEnv *env, jclass clazz, jlong hFile, jlong lpDCB) {
    if (!SetCommState((HANDLE)(uintptr_t)hFile, (LPDCB)(uintptr_t)lpDCB)) {
            throw_NativeErrorException(env, GetLastError());
    }
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase
 * Method:    SetCommTimeouts
 * Signature: (JJ)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SetCommTimeouts
  (JNIEnv *env, jclass clazz, jlong hFile, jlong lpCOMMTIMEOUTS) {
    if (!SetCommTimeouts((HANDLE)(uintptr_t)hFile, (LPCOMMTIMEOUTS)(uintptr_t)lpCOMMTIMEOUTS)) {
            throw_NativeErrorException(env, GetLastError());
    }
}

#ifdef __cplusplus
}
#endif
#endif
