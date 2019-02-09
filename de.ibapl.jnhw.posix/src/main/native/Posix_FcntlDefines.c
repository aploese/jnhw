#include <config.h>
#include "jnhw.h"
#if HAVE_UNISTD_H
# include <unistd.h>
#endif

#ifdef _POSIX_VERSION

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
    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_GETFL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1GETFL
    (JNIEnv *env, jclass clazz) {
        return F_GETFL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    F_SETFL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_F_1SETFL
    (JNIEnv *env, jclass clazz) {
        return F_SETFL;
    }


#ifdef __cplusplus
}
#endif
#endif