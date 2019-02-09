#include <config.h>
#include "jnhw.h"

/*
 * Class:     de_ibapl_jnhw_isoc_Fcntl
 * Method:    HAVE_FCNTL_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_isoc_Fcntl_HAVE_1FCNTL_1H
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_FCNTL_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }


#ifdef HAVE_FCNTL_H

#include "de_ibapl_jnhw_isoc_Fcntl.h"
#include <fcntl.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_isoc_Fcntl
     * Method:    O_RDWR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_isoc_Fcntl_O_1RDWR
    (JNIEnv *env, jclass clazz) {
        return O_RDWR;
    }

#ifdef __cplusplus
}
#endif
#endif