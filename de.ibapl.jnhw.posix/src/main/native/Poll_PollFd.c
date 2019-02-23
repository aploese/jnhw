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
#include "../../../config.h"
#include "jnhw.h"

#ifdef HAVE_POLL_H

#include "de_ibapl_jnhw_posix_Poll_PollFd.h"
#include <errno.h>
#include <poll.h>
#include <stdint.h>


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
        return sizeof (struct pollfd);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_PollFd
     * Method:    events
     * Signature: (J)S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_events__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((struct pollfd*) (uintptr_t) baseAddress)->events;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_PollFd
     * Method:    events
     * Signature: (JS)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_events__JS
    (JNIEnv *env, jclass clazz, jlong baseAddress, jshort value) {
        ((struct pollfd*) (uintptr_t) baseAddress)->events = value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_PollFd
     * Method:    fd
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_fd__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((struct pollfd*) (uintptr_t) baseAddress)->fd;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_PollFd
     * Method:    fd
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_fd__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint value) {
        ((struct pollfd*) (uintptr_t) baseAddress)->fd = value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_PollFd
     * Method:    revents
     * Signature: (J)S
     */
    JNIEXPORT jshort JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_revents__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((struct pollfd*) (uintptr_t) baseAddress)->revents;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Poll_PollFd
     * Method:    revents
     * Signature: (JS)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_00024PollFd_revents__JS
    (JNIEnv *env, jclass clazz, jlong baseAddress, jshort value) {
        ((struct pollfd*) (uintptr_t) baseAddress)->revents = value;
    }

#ifdef __cplusplus
}
#endif
#endif
