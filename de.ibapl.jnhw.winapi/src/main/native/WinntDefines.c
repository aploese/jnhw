#include <windows.h>
#include <config.h>
#include "jnhw.h"

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    HAVE_WINNT_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winnt_HAVE_1WINNT_1H
  (JNIEnv *env, jclass clazz) {
#ifdef HAVE_WINNT_H
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

#ifdef HAVE_WINNT_H

#include "de_ibapl_jnhw_winapi_Winnt.h"
#include <winnt.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    MAXDWORD
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_MAXDWORD
  (JNIEnv *env, jclass clazz) {
    return MAXDWORD;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    GENERIC_READ
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_GENERIC_1READ
  (JNIEnv *env, jclass clazz) {
    return GENERIC_READ;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    GENERIC_WRITE
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_GENERIC_1WRITE
  (JNIEnv *env, jclass clazz) {
    return GENERIC_WRITE;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    KEY_READ
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_KEY_1READ
  (JNIEnv *env, jclass clazz) {
    return KEY_READ;
}

#ifdef __cplusplus
}
#endif
#endif