#include <config.h>
#include "jnhw.h"

#ifdef HAVE_MINWINBASE_H
#include <minwinbase.h>
#include "de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED.h"

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
        return sizeof (struct OVERLAPPED);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    Internal
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_Internal
    (JNIEnv *env, jclass clazz, jlongbaseAddres) {
        return ((struct OVERLAPPED*) (long) baseAddress)->Internal;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    InternalHigh
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_InternalHigh
    (JNIEnv *env, jclass clazz, jlongbaseAddres) {
        return ((struct OVERLAPPED*) (long) baseAddress)->InternalHigh;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    hEvent
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_hEvent__J
    (JNIEnv *env, jclass clazz, jlongbaseAddres) {
        return ((struct OVERLAPPED*) (long) baseAddress)->hEvent;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
     * Method:    hEvent
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_hEvent__JJ
    (JNIEnv *env, jclass clazz, jlongbaseAddres, jlong value) {
        ((struct OVERLAPPED*) (long) baseAddress)->hEvent = value;
    }

#ifdef __cplusplus
}
#endif
#endif
