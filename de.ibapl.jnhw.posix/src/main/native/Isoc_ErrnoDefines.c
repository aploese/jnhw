#include "jnhw.h"
/*
 * Class:     de_ibapl_jnhw_isoc_Errno
 * Method:    HAVE_ERRNO_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_isoc_Errno_HAVE_1ERRNO_1H
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_ERRNO_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }


#ifdef HAVE_ERRNO_H

#include "de_ibapl_jnhw_isoc_Errno.h"
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_isoc_Errno
     * Method:    EDOM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_isoc_Errno_EDOM
    (JNIEnv *env, jclass clazz) {
        return EDOM;
    }

    /*
     * Class:     de_ibapl_jnhw_isoc_Errno
     * Method:    ERANGE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_isoc_Errno_ERANGE
    (JNIEnv *env, jclass clazz) {
        return ERANGE;
    }

    /*
     * Class:     de_ibapl_jnhw_isoc_Errno
     * Method:    EILSEQ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_isoc_Errno_EILSEQ
    (JNIEnv *env, jclass clazz) {
        return EILSEQ;
    }

#ifdef __cplusplus
}
#endif
#endif