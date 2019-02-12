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
 * Method:    HKEY_CLASSES_ROOT0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1CLASSES_1ROOT0
  (JNIEnv *env, jclass clazz) {
    return (jlong)(uintptr_t)HKEY_CLASSES_ROOT;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HKEY_CURRENT_USER0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1CURRENT_1USER0
  (JNIEnv *env, jclass clazz) {
    return (jlong)(uintptr_t)HKEY_CURRENT_USER;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HKEY_LOCAL_MACHINE0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1LOCAL_1MACHINE0
  (JNIEnv *env, jclass clazz) {
    return (jlong)(uintptr_t)HKEY_LOCAL_MACHINE;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HKEY_USERS0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1USERS0
  (JNIEnv *env, jclass clazz) {
    return (jlong)(uintptr_t)HKEY_USERS;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HKEY_PERFORMANCE_DATA0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1PERFORMANCE_1DATA0
  (JNIEnv *env, jclass clazz) {
    return (jlong)(uintptr_t)HKEY_PERFORMANCE_DATA;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HKEY_PERFORMANCE_TEXT0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1PERFORMANCE_1TEXT0
  (JNIEnv *env, jclass clazz) {
    return (jlong)(uintptr_t)HKEY_PERFORMANCE_TEXT;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HKEY_PERFORMANCE_NLSTEXT0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1PERFORMANCE_1NLSTEXT0
  (JNIEnv *env, jclass clazz) {
    return (jlong)(uintptr_t)HKEY_PERFORMANCE_NLSTEXT;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HKEY_CURRENT_CONFIG0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1CURRENT_1CONFIG0
  (JNIEnv *env, jclass clazz) {
    return (jlong)(uintptr_t)HKEY_CURRENT_CONFIG;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HKEY_DYN_DATA0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HKEY_1DYN_1DATA0
  (JNIEnv *env, jclass clazz) {
    return (jlong)(uintptr_t)HKEY_DYN_DATA;
}
   
#ifdef __cplusplus
}
#endif
#endif
