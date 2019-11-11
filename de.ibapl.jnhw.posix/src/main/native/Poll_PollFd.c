/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
#include "jnhw-posix.h"

#ifdef HAVE_POLL_H

#include "de_ibapl_jnhw_posix_Poll_PollFd.h"
#include <errno.h>
#include <poll.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_00024PollFd
     * Method:    sizeofPollFd
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_sizeofPollFd
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct pollfd);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_00024PollFd
     * Method:    events
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_events__
    (JNIEnv *env, jobject pollFd) {
        return (UNWRAP_STRUCT_POLLFD_PTR(pollFd))->events;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_00024PollFd
     * Method:    events
     * Signature: (S)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_events__S
    (JNIEnv *env, jobject pollFd, jshort value) {
        (UNWRAP_STRUCT_POLLFD_PTR(pollFd))->events = value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_00024PollFd
     * Method:    fd
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_fd__
    (JNIEnv *env, jobject pollFd) {
        return (UNWRAP_STRUCT_POLLFD_PTR(pollFd))->fd;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_00024PollFd
     * Method:    fd
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_fd__I
    (JNIEnv *env, jobject pollFd, jint value) {
        (UNWRAP_STRUCT_POLLFD_PTR(pollFd))->fd = value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_00024PollFd
     * Method:    revents
     * Signature: ()S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_revents__
    (JNIEnv *env, jobject pollFd) {
        return (UNWRAP_STRUCT_POLLFD_PTR(pollFd))->revents;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_00024PollFd
     * Method:    revents
     * Signature: (S)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_revents__S
    (JNIEnv *env, jobject pollFd, jshort value) {
        (UNWRAP_STRUCT_POLLFD_PTR(pollFd))->revents = value;
    }

#ifdef __cplusplus
}
#endif
#endif
