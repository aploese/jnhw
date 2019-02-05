#include "jnhw.h"
#if HAVE_UNISTD_H
# include <unistd.h>
#endif

#ifdef _POSIX_VERSION

#include "de_ibapl_jnhw_posix_Unistd.h"
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    pipe
     * Signature: (Lde/ibapl/jnhw/IntRef;Lde/ibapl/jnhw/IntRef;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Unistd_pipe
    (JNIEnv *env, jclass clazz, jobject read_fd_ref, jobject write_fd_ref) {
        if (read_fd_ref == NULL) {
            throw_NullPointerException(env, "read_fd_ref is null");
            return;
        }
        if (write_fd_ref == NULL) {
            throw_NullPointerException(env, "write_fd_ref is null");
            return;
        }
        int fdes[2];
        int result = pipe(fdes);
        (*env)->SetIntField(env, read_fd_ref, de_ibapl_jnhw_IntRef_value_ID, fdes[0]);
        (*env)->SetIntField(env, write_fd_ref, de_ibapl_jnhw_IntRef_value_ID, fdes[1]);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
    }


#ifdef __cplusplus
}
#endif
#endif