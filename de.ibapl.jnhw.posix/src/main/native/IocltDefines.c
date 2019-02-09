#include <config.h>
#include "jnhw.h"
/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    HAVE_SYS_IOCTL_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_HAVE_1SYS_1IOCTL_1H
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_SYS_IOCTL_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }


#ifdef HAVE_SYS_IOCTL_H

#include "de_ibapl_jnhw_unix_sys_Ioctl.h"
#include <sys/ioctl.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    FIONREAD
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_FIONREAD
    (JNIEnv *env, jclass clazz) {
        return FIONREAD;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCM_CTS
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1CTS
    (JNIEnv *env, jclass clazz) {
        return TIOCM_CTS;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCM_DTR
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1DTR
    (JNIEnv *env, jclass clazz) {
        return TIOCM_DTR;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCM_CAR
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1CAR
    (JNIEnv *env, jclass clazz) {
        return TIOCM_CAR;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCM_RTS
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1RTS
    (JNIEnv *env, jclass clazz) {
        return TIOCM_RTS;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCM_RNG
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1RNG
    (JNIEnv *env, jclass clazz) {
        return TIOCM_RNG;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCM_DSR
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCM_1DSR
    (JNIEnv *env, jclass clazz) {
        return TIOCM_DSR;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCEXCL
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCEXCL
    (JNIEnv *env, jclass clazz) {
        return TIOCEXCL;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCSBRK
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCSBRK
    (JNIEnv *env, jclass clazz) {
        return TIOCSBRK;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCCBRK
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCCBRK
    (JNIEnv *env, jclass clazz) {
        return TIOCCBRK;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCMGET
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCMGET
    (JNIEnv *env, jclass clazz) {
        return TIOCMGET;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCMSET
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCMSET
    (JNIEnv *env, jclass clazz) {
        return TIOCMSET;
    }

/*
 * Class:     de_ibapl_jnhw_unix_sys_Ioctl
 * Method:    TIOCOUTQ
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_unix_sys_Ioctl_TIOCOUTQ
    (JNIEnv *env, jclass clazz) {
        return TIOCOUTQ;
    }

#ifdef __cplusplus
}
#endif
#endif