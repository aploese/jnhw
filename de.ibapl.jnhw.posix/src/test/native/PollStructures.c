/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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
#include "de_ibapl_jnhw_posix_PollTest_NativePollFd.h"


#ifdef __cplusplus
extern "C" {
#endif

#ifdef _POSIX_VERSION
#include <poll.h>
#include <errno.h>
#include <unistd.h>

    //for offsetof
#include <stddef.h>


    //see jnhw-posix-datatypes.h why FreeBSD cant do this.
#if !defined(__FreeBSD__)
#include <assert.h>

    static_assert(sizeof (((struct pollfd *) 0)->events) == sizeof (jshort), "pollfd.events not jlong size");
    static_assert(sizeof (((struct pollfd *) 0)->revents) == sizeof (jshort), "pollfd.revents not jlong size");
    static_assert(sizeof (((struct pollfd *) 0)->fd) == sizeof (jint), "pollfd.fd not jlong size");
    static_assert((typeof (((struct pollfd *) 0)->events)) - 1 < 0, "Not signed");
#endif

        /*
     * Class:     de_ibapl_jnhw_posix_PollTest_NativePollFd
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_PollTest_00024NativePollFd_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct pollfd);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_PollTest_NativePollFd
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_PollTest_00024NativePollFd_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct pollfd);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_PollTest_NativePollFd
     * Method:    fd
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_PollTest_00024NativePollFd_fd
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct pollfd, fd);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_PollTest_NativePollFd
     * Method:    events
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_PollTest_00024NativePollFd_events
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct pollfd, events);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_PollTest_NativePollFd
     * Method:    revents
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_PollTest_00024NativePollFd_revents
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct pollfd, revents);
    }

#endif
#ifdef __cplusplus
}
#endif
