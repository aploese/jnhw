#include <config.h>
#include "jnhw.h"

/*
 * Class:     de_ibapl_jnhw_isoc_Unistd
 * Method:    HAVE_UNISTD_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_isoc_Unistd_HAVE_1UNISTD_1H
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_UNISTD_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef HAVE_UNISTD_H

#include "de_ibapl_jnhw_isoc_Unistd.h"
#include <unistd.h>

#ifdef __cplusplus
}
#endif
#endif