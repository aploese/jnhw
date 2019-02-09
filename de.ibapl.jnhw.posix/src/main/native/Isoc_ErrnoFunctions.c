#include <config.h>
#include "jnhw.h"

#ifdef HAVE_ERRNO_H

#include "de_ibapl_jnhw_isoc_Errno.h"
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_isoc_Errno
     * Method:    errno
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_isoc_Errno_errno__
    (JNIEnv *env, jclass clazz) {
        return errno;
    }

    /*
     * Class:     de_ibapl_jnhw_isoc_Errno
     * Method:    errno
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_isoc_Errno_errno__I
    (JNIEnv *env, jclass clazz, jint newErrno) {
        errno = newErrno;
    }

#ifdef __cplusplus
}
#endif
#endif