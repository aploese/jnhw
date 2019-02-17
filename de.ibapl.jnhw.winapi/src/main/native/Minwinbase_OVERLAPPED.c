#include "jnhw-winapi.h"
#include "de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED.h"

#ifdef HAVE_MINWINBASE_H
#include <minwinbase.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    sizeofOVERLAPPED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_sizeofOVERLAPPED
    (JNIEnv *env, jclass clazz) {
        return sizeof (OVERLAPPED);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    Internal
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_Internal
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((OVERLAPPED*) (uintptr_t) baseAddress)->Internal;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    InternalHigh
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_InternalHigh
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((OVERLAPPED*) (uintptr_t) baseAddress)->InternalHigh;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    hEvent
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_hEvent__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return (uintptr_t)((OVERLAPPED*) (uintptr_t) baseAddress)->hEvent;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    hEvent
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_hEvent__JJ
    (JNIEnv *env, jclass clazz, jlong baseAddress, jlong value) {
        ((OVERLAPPED*) (uintptr_t) baseAddress)->hEvent = (HANDLE)(uintptr_t)value;
    }

#ifdef __cplusplus
}
#endif
#endif
