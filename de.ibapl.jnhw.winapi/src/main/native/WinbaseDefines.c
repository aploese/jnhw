#include "jnhw-winapi.h"
#include "de_ibapl_jnhw_winapi_Winbase.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    HAVE_WINBASE_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_HAVE_1WINBASE_1H
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_WINBASE_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef HAVE_WINBASE_H
#include <winbase.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    WAIT_FAILED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1FAILED
    (JNIEnv *env, jclass clazz) {
        return WAIT_FAILED;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    WAIT_OBJECT_0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1OBJECT_10
    (JNIEnv *env, jclass clazz) {
        return WAIT_OBJECT_0;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    WAIT_ABANDONED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1ABANDONED
    (JNIEnv *env, jclass clazz) {
        return WAIT_ABANDONED;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    WAIT_TIMEOUT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1TIMEOUT
    (JNIEnv *env, jclass clazz) {
        return WAIT_TIMEOUT;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_OVERLAPPED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1OVERLAPPED
    (JNIEnv *env, jclass clazz) {
        return FILE_FLAG_OVERLAPPED;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    RTS_CONTROL_DISABLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_RTS_1CONTROL_1DISABLE
    (JNIEnv *env, jclass clazz) {
        return RTS_CONTROL_DISABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    RTS_CONTROL_HANDSHAKE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_RTS_1CONTROL_1HANDSHAKE
    (JNIEnv *env, jclass clazz) {
        return RTS_CONTROL_HANDSHAKE;
    }

        /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    INVALID_HANDLE_VALUE0
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winbase_INVALID_1HANDLE_1VALUE0
    (JNIEnv *env, jclass clazz) {
        return (jlong) (uintptr_t) INVALID_HANDLE_VALUE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    NOPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_NOPARITY
    (JNIEnv *env, jclass clazz) {
        return NOPARITY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    ODDPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ODDPARITY
    (JNIEnv *env, jclass clazz) {
        return ODDPARITY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    EVENPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_EVENPARITY
    (JNIEnv *env, jclass clazz) {
        return EVENPARITY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    MARKPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MARKPARITY
    (JNIEnv *env, jclass clazz) {
        return MARKPARITY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SPACEPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SPACEPARITY
    (JNIEnv *env, jclass clazz) {
        return SPACEPARITY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    ONESTOPBIT
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ONESTOPBIT
    (JNIEnv *env, jclass clazz) {
        return ONESTOPBIT;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    ONE5STOPBITS
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ONE5STOPBITS
    (JNIEnv *env, jclass clazz) {
        return ONE5STOPBITS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    TWOSTOPBITS
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_TWOSTOPBITS
    (JNIEnv *env, jclass clazz) {
        return TWOSTOPBITS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    INFINITE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_INFINITE
    (JNIEnv *env, jclass clazz) {
        return INFINITE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SETRTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETRTS
    (JNIEnv *env, jclass clazz) {
        return SETRTS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CLRRTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CLRRTS
    (JNIEnv *env, jclass clazz) {
        return CLRRTS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SETDTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETDTR
    (JNIEnv *env, jclass clazz) {
        return SETDTR;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CLRDTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CLRDTR
    (JNIEnv *env, jclass clazz) {
        return CLRDTR;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SETBREAK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETBREAK
    (JNIEnv *env, jclass clazz) {
        return SETBREAK;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CLRBREAK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CLRBREAK
    (JNIEnv *env, jclass clazz) {
        return CLRBREAK;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    MS_CTS_ON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1CTS_1ON
    (JNIEnv *env, jclass clazz) {
        return MS_CTS_ON;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    MS_DSR_ON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1DSR_1ON
    (JNIEnv *env, jclass clazz) {
        return MS_DSR_ON;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    MS_RING_ON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1RING_1ON
    (JNIEnv *env, jclass clazz) {
        return MS_RING_ON;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    MS_RLSD_ON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1RLSD_1ON
    (JNIEnv *env, jclass clazz) {
        return MS_RLSD_ON;
    }

#endif

#ifdef __cplusplus
}
#endif
