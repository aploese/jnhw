#include "../../../config.h"
#include "jnhw.h"
#include "de_ibapl_jnhw_winapi_Winbase_COMSTAT.h"

#ifdef HAVE_WINBASE_H
#include <windows.h>
#include <winbase.h>

#ifdef __cplusplus
extern "C" {
#endif
    
/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    sizeofCOMSTAT
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_sizeofCOMSTAT
  (JNIEnv *env, jclass clazz) {
    return sizeof(COMSTAT);
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    fCtsHold
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fCtsHold
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMSTAT*) (uintptr_t) baseAddress)->fCtsHold;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    fDsrHold
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fDsrHold
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMSTAT*) (uintptr_t) baseAddress)->fDsrHold;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    fRlsdHold
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fRlsdHold
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMSTAT*) (uintptr_t) baseAddress)->fRlsdHold;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    fXoffHold
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fXoffHold
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMSTAT*) (uintptr_t) baseAddress)->fXoffHold;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    fXoffSent
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fXoffSent
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMSTAT*) (uintptr_t) baseAddress)->fXoffSent;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    fEof
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fEof
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMSTAT*) (uintptr_t) baseAddress)->fEof;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    fTxim
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fTxim
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMSTAT*) (uintptr_t) baseAddress)->fTxim;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    fReserved
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fReserved
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMSTAT*) (uintptr_t) baseAddress)->fReserved;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    cbInQue
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_cbInQue
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMSTAT*) (uintptr_t) baseAddress)->cbInQue;
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
 * Method:    cbOutQue
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_cbOutQue
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((COMSTAT*) (uintptr_t) baseAddress)->cbOutQue;
}

#ifdef __cplusplus
}
#endif
#endif
