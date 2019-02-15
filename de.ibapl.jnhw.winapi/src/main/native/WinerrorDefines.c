#include "../../../config.h"
#include "jnhw.h"
#include "de_ibapl_jnhw_winapi_Winerror.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_winapi_Winerror
 * Method:    HAVE_WINERROR_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winerror_HAVE_1WINERR_1H
  (JNIEnv *env, jclass clazz) {
#ifdef HAVE_WINERROR_H
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

#ifdef HAVE_WINERROR_H
#include <windows.h>
#include <winerror.h>

/*
 * Class:     de_ibapl_jnhw_winapi_Winerror
 * Method:    ERROR_SUCCESS
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1SUCCESS
  (JNIEnv *env, jclass clazz) {
	return ERROR_SUCCESS;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winerror
 * Method:    ERROR_FILE_NOT_FOUND
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1FILE_1NOT_1FOUND
(JNIEnv *env, jclass clazz) {
	return ERROR_FILE_NOT_FOUND;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winerror
 * Method:    ERROR_ACCESS_DENIED
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1ACCESS_1DENIED
(JNIEnv *env, jclass clazz) {
	return ERROR_ACCESS_DENIED;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winerror
 * Method:    ERROR_GEN_FAILURE
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1GEN_1FAILURE
(JNIEnv *env, jclass clazz) {
	return ERROR_GEN_FAILURE;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winerror
 * Method:    ERROR_INVALID_PARAMETER
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1INVALID_1PARAMETER
(JNIEnv *env, jclass clazz) {
	return ERROR_INVALID_PARAMETER;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winerror
 * Method:    ERROR_IO_PENDING
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1IO_1PENDING
(JNIEnv *env, jclass clazz) {
	return ERROR_IO_PENDING;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winerror
 * Method:    ERROR_NOACCESS
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1NOACCESS
(JNIEnv *env, jclass clazz) {
	return ERROR_NOACCESS;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winerror
 * Method:    ERROR_NO_MORE_ITEMS
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1NO_1MORE_1ITEMS
(JNIEnv *env, jclass clazz) {
	return ERROR_NO_MORE_ITEMS;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winerror
 * Method:    ERROR_MORE_DATA
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1MORE_1DATA
(JNIEnv *env, jclass clazz) {
	return ERROR_MORE_DATA;
}



#endif

#ifdef __cplusplus
}
#endif
