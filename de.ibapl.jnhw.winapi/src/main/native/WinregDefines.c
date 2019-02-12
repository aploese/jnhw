#include <config.h>
#include "jnhw.h"

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HAVE_WINREG_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HAVE_1WINREG_1H
  (JNIEnv *env, jclass clazz) {
#ifdef HAVE_WINREG_H
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

#ifdef HAVE_WINREG_H
#include <windows.h>
#include <winreg.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HKEY_LOCAL_MACHINE0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1LOCAL_1MACHINE0
  (JNIEnv *env, jclass clazz) {
    return HKEY_LOCAL_MACHINE;
}

   
#ifdef __cplusplus
}
#endif
#endif
