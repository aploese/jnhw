#include "jnhw.h"

#ifdef HAVE_POLL_H

#include "de_ibapl_jnhw_posix_Poll.h"
#include <poll.h>
#include <errno.h>
#include <stdint.h>


#ifdef __cplusplus
extern "C" {
#endif

/*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    poll
     * Signature: (JJI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Poll_poll
    (JNIEnv *env, jclass clazz, jlong pollFdBaseAddress, jlong nfds, jint timeout) {
        int result = poll((void*)(uintptr_t) pollFdBaseAddress, nfds, timeout);
        if (result < 0) {
            throw_NativeErrorException(env, errno);
        }
        return result;
    }


#ifdef __cplusplus
}
#endif
#endif
