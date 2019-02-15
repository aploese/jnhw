#include "../../../config.h"
#include "jnhw.h"
#include "de_ibapl_jnhw_winapi_Fileapi.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    HAVE_FILEAPI_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_HAVE_1FILEAPI_1H
  (JNIEnv *env, jclass clazz) {
#ifdef HAVE_FILEAPI_H
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

#ifdef HAVE_FILEAPI_H
#include <windows.h>
#include <fileapi.h>

/*
 * Class:     de_ibapl_jnhw_winapi_Fileapi
 * Method:    OPEN_EXISTING
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_OPEN_1EXISTING
  (JNIEnv *env, jclass clazz) {
    return OPEN_EXISTING;
}


#endif
#ifdef __cplusplus
}
#endif

