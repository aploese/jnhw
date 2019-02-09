#include <config.h>
#include "jnhw.h"
#if HAVE_UNISTD_H
# include <unistd.h>
#endif

#ifdef _POSIX_VERSION

#include "de_ibapl_jnhw_posix_Fcntl.h"
#include <fcntl.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    fcntl
     * Signature: (II)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl__II
    (JNIEnv *env, jclass clazz, jint fd, jint cmd) {
        int result = fcntl(fd, cmd);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Fcntl
     * Method:    fcntl
     * Signature: (III)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Fcntl_fcntl__III
    (JNIEnv *env, jclass clazz, jint fd, jint cmd, jint vararg_0) {
        int result = fcntl(fd, cmd, vararg_0);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }


#ifdef __cplusplus
}
#endif
#endif