#include "jnhw-winapi.h"
#include "de_ibapl_jnhw_winapi_Synchapi.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_winapi_Synchapi
 * Method:    HAVE_SYNCHAPI_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Synchapi_HAVE_1SYNCHAPI_1H
  (JNIEnv *env, jclass clazz) {
#ifdef HAVE_SYNCHAPI_H
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

#ifdef HAVE_SYNCHAPI_H
#include <synchapi.h>

#endif
#ifdef __cplusplus
}
#endif
