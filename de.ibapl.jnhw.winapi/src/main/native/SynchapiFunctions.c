#include <config.h>
#include "jnhw.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifdef HAVE_SYNCHAPI_H
#include <windows.h>
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
        if (lpName == NULL) {
            throw_NullPointerException(env, "lpName is null.");
            return ERROR_INVALID_PARAMETER;
        }
        LPCWSTR _lpName = (*env)->GetStringChars(env, lpName, NULL);

        HANDLE result = CreateEventW((LPSECURITY_ATTRIBUTES) (uintptr_t) & lpEventAttributes, bManualReset, bInitialState, _lpName);

        (*env)->ReleaseStringChars(env, lpName, _lpName);

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


#endif
#ifdef __cplusplus
}
#endif
