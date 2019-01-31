#include "jnhw.h"

#include "de_ibapl_jnhw_linux_sys_Eventfd.h"
#include <sys/eventfd.h>

#ifdef __cplusplus
extern "C" {
#endif
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
