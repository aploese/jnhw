#include "jnhw.h"

#ifdef HAVE_POLL_H

#include "de_ibapl_jnhw_posix_Poll.h"
#include <poll.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    POLLERR
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_POLLERR
    (JNIEnv *env, jclass clazz) {
        return POLLERR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    POLLHUP
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_POLLHUP
    (JNIEnv *env, jclass clazz) {
        return POLLHUP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    POLLIN
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_POLLIN
    (JNIEnv *env, jclass clazz) {
        return POLLIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    POLLNVAL
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_POLLNVAL
    (JNIEnv *env, jclass clazz) {
        return POLLNVAL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    POLLOUT
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_POLLOUT
    (JNIEnv *env, jclass clazz) {
        return POLLOUT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    POLLPRI
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_POLLPRI
    (JNIEnv *env, jclass clazz) {
        return POLLPRI;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    POLLRDBAND
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_POLLRDBAND
    (JNIEnv *env, jclass clazz) {
        return POLLRDBAND;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    POLLRDNORM
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_POLLRDNORM
    (JNIEnv *env, jclass clazz) {
        return POLLRDNORM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    POLLWRBAND
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_POLLWRBAND
    (JNIEnv *env, jclass clazz) {
        return POLLWRBAND;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    POLLWRNORM
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_POLLWRNORM
    (JNIEnv *env, jclass clazz) {
        return POLLWRNORM;
    }

#ifdef __cplusplus
}
#endif
#endif