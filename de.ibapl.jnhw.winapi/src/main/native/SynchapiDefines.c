#include <config.h>
#include "jnhw.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_winapi_Synchapi
 * Method:    HAVE_SYNCAPI_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_HAVE_1SYNCAPI_1H
  (JNIEnv *env, jclass clazz) {
#ifdef HAVE_SYNCAPI_H
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

#ifdef HAVE_SYNCAPI_H
#include <windows.h>
#include <synchapi.h>

#endif
#ifdef __cplusplus
}
#endif
