#include "jnhw.h"

#include "de_ibapl_jnhw_posix_Fcntl.h"
#include <fcntl.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    FNONBLOCK
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_FNONBLOCK
    (JNIEnv *env, jclass clazz) {
        return FNONBLOCK;
    }

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    O_RDWR
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1RDWR
    (JNIEnv *env, jclass clazz) {
        return O_RDWR;
    }

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    O_NOCTTY
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1NOCTTY
    (JNIEnv *env, jclass clazz) {
        return O_NOCTTY;
    }

/*
 * Class:     de_ibapl_jnhw_posix_Fcntl
 * Method:    O_NONBLOCK
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_O_1NONBLOCK
    (JNIEnv *env, jclass clazz) {
        return O_NONBLOCK;
    }

    
#ifdef __cplusplus
}
#endif