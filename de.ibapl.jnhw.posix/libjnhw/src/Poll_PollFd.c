#include "jnhw.h"

#include "de_ibapl_jnhw_posix_Poll_PollFd.h"
#include <errno.h>
#include <poll.h>

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_posix_Poll_PollFd
 * Method:    sizeofPollFd
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_sizeofPollFd
  (JNIEnv *env, jclass clazz) {
    return sizeof(struct pollfd);
}

/*
 * Class:     de_ibapl_jnhw_posix_Poll_PollFd
 * Method:    events
 * Signature: (J)S
 */
JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_events__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
    return ((struct pollfd*)baseAddress)->events;
}

/*
 * Class:     de_ibapl_jnhw_posix_Poll_PollFd
 * Method:    events
 * Signature: (JS)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_events__JS
  (JNIEnv *env, jclass clazz, jlong baseAddress, jshort value) {
    ((struct pollfd*)baseAddress)->events = value;
}

/*
 * Class:     de_ibapl_jnhw_posix_Poll_PollFd
 * Method:    fd
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_fd__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((struct pollfd*)baseAddress)->fd;
}

/*
 * Class:     de_ibapl_jnhw_posix_Poll_PollFd
 * Method:    fd
 * Signature: (JI)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_fd__JI
  (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
    ((struct pollfd*)baseAddress)->fd = value;
}

/*
 * Class:     de_ibapl_jnhw_posix_Poll_PollFd
 * Method:    revents
 * Signature: (J)S
 */
JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_revents__J
  (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((struct pollfd*)baseAddress)->revents;
}

/*
 * Class:     de_ibapl_jnhw_posix_Poll_PollFd
 * Method:    revents
 * Signature: (JS)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_revents__JS
  (JNIEnv *env, jclass clazz, jlong baseAddress, jshort value) {
    ((struct pollfd*)baseAddress)->revents = value;
}

#ifdef __cplusplus
}
#endif