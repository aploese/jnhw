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

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    HAVE_POLL_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Poll_HAVE_1POLL_1H
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_POLL_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef HAVE_POLL_H

#include "de_ibapl_jnhw_posix_Poll.h"
#include <poll.h>

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