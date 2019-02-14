#include <config.h>
#include "jnhw.h"

#ifdef HAVE_WINBASE_H
#include <windows.h>
#include <winbase.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    sizeofCOMMTIMEOUTS
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_sizeofCOMMTIMEOUTS
  (JNIEnv *env, jclass clazz) {
    return sizeof(COMMTIMEOUTS);
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    ReadIntervalTimeout
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadIntervalTimeout__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadIntervalTimeout;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    ReadIntervalTimeout
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadIntervalTimeout__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint readIntervalTimeout) {
    ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadIntervalTimeout = readIntervalTimeout;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    ReadTotalTimeoutMultiplier
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutMultiplier__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadTotalTimeoutMultiplier;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    ReadTotalTimeoutMultiplier
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutMultiplier__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint readTotalTimeoutMultiplier) {
    ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadTotalTimeoutMultiplier = readTotalTimeoutMultiplier;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    ReadTotalTimeoutConstant
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutConstant__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadTotalTimeoutConstant;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    ReadTotalTimeoutConstant
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutConstant__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint readTotalTimeoutConstant) {
    ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadTotalTimeoutConstant = readTotalTimeoutConstant;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    WriteTotalTimeoutMultiplier
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutMultiplier__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->WriteTotalTimeoutMultiplier;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    WriteTotalTimeoutMultiplier
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutMultiplier__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint writeTotalTimeoutMultiplier) {
    ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->WriteTotalTimeoutMultiplier = writeTotalTimeoutMultiplier;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    WriteTotalTimeoutConstant
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutConstant__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->WriteTotalTimeoutConstant;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
 * Method:    WriteTotalTimeoutConstant
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutConstant__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint writeTotalTimeoutConstant) {
    ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->WriteTotalTimeoutConstant = writeTotalTimeoutConstant;
}

#ifdef __cplusplus
}
#endif
#endif
