#include <config.h>
#include "jnhw.h"
/*
 * Class:     de_ibapl_jnhw_linux_sys_Eventfd
 * Method:    HAVE_SYS_EVENTFD_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_HAVE_1SYS_1EVENTFD_1H
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_SYS_EVENTFD_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }


#ifdef HAVE_SYS_EVENTFD_H

#include "de_ibapl_jnhw_linux_sys_Eventfd.h"
#include <sys/eventfd.h>

#ifdef __cplusplus
extern "C" {
#endif
    
/*
 * Class:     de_ibapl_jnhw_linux_sys_Eventfd
 * Method:    JNHW_HAVE_SYS_EVENTFD_H
 * Signature: ()I
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_JNHW_1HAVE_1SYS_1EVENTFD_1H
  (JNIEnv *env, jclass clazz) {
    return JNI_TRUE;
}

/*
 * Class:     de_ibapl_jnhw_linux_sys_Eventfd
 * Method:    EFD_CLOEXEC
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_EFD_1CLOEXEC
  (JNIEnv *env, jclass clazz) {
    return EFD_CLOEXEC;
}

/*
 * Class:     de_ibapl_jnhw_linux_sys_Eventfd
 * Method:    EFD_NONBLOCK
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_EFD_1NONBLOCK
  (JNIEnv *env, jclass clazz) {
    return EFD_NONBLOCK;
}

/*
 * Class:     de_ibapl_jnhw_linux_sys_Eventfd
 * Method:    EFD_SEMAPHORE
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_EFD_1SEMAPHORE
  (JNIEnv *env, jclass clazz) {
    return EFD_SEMAPHORE;
}

#ifdef __cplusplus
}
#endif

#else

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_linux_sys_Eventfd
 * Method:    JNHW_HAVE_SYS_EVENTFD_H
 * Signature: ()I
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_linux_sys_Eventfd_JNHW_1HAVE_1SYS_1EVENTFD_1H
  (JNIEnv *env, jclass clazz) {
    return JNI_FALSE;
}

#ifdef __cplusplus
}
#endif
#endif