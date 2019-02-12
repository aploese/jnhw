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
#include <windows.h>

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

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_NONE
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1NONE
  (JNIEnv *env, jclass clazz) {
    return REG_NONE;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_SZ
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1SZ
  (JNIEnv *env, jclass clazz) {
    return REG_SZ;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_EXPAND_SZ
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1EXPAND_1SZ
  (JNIEnv *env, jclass clazz) {
    return REG_EXPAND_SZ;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_BINARY
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1BINARY
  (JNIEnv *env, jclass clazz) {
    return REG_BINARY;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_DWORD
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1DWORD
  (JNIEnv *env, jclass clazz) {
    return REG_DWORD;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_DWORD_LITTLE_ENDIAN
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1DWORD_1LITTLE_1ENDIAN
  (JNIEnv *env, jclass clazz) {
    return REG_DWORD_LITTLE_ENDIAN;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_DWORD_BIG_ENDIAN
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1DWORD_1BIG_1ENDIAN
  (JNIEnv *env, jclass clazz) {
    return REG_DWORD_BIG_ENDIAN;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_LINK
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1LINK
  (JNIEnv *env, jclass clazz) {
    return REG_LINK;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_MULTI_SZ
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1MULTI_1SZ
  (JNIEnv *env, jclass clazz) {
    return REG_MULTI_SZ;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_RESOURCE_LIST
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1RESOURCE_1LIST
  (JNIEnv *env, jclass clazz) {
    return REG_RESOURCE_LIST;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_FULL_RESOURCE_DESCRIPTOR
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1FULL_1RESOURCE_1DESCRIPTOR
  (JNIEnv *env, jclass clazz) {
    return REG_FULL_RESOURCE_DESCRIPTOR;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_RESOURCE_REQUIREMENTS_LIST
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1RESOURCE_1REQUIREMENTS_1LIST
  (JNIEnv *env, jclass clazz) {
    return REG_RESOURCE_REQUIREMENTS_LIST;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_QWORD
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1QWORD
  (JNIEnv *env, jclass clazz) {
    return REG_QWORD;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    REG_QWORD_LITTLE_ENDIAN
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1QWORD_1LITTLE_1ENDIAN
  (JNIEnv *env, jclass clazz) {
    return REG_QWORD_LITTLE_ENDIAN;
}

#ifdef __cplusplus
}
#endif
#endif