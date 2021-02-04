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
#include "de_ibapl_jnhw_posix_Poll.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...    
#if !defined(HAVE_POLL_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <poll.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Poll
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Poll_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_POLL_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticShortField(env, clazz, "POLLERR", POLLERR)) {
            return;
        }
        if (JnhwSetStaticShortField(env, clazz, "POLLHUP", POLLHUP)) {
            return;
        }
        if (JnhwSetStaticShortField(env, clazz, "POLLIN", POLLIN)) {
            return;
        }
        if (JnhwSetStaticShortField(env, clazz, "POLLNVAL", POLLNVAL)) {
            return;
        }
        if (JnhwSetStaticShortField(env, clazz, "POLLOUT", POLLOUT)) {
            return;
        }
        if (JnhwSetStaticShortField(env, clazz, "POLLPRI", POLLPRI)) {
            return;
        }
        if (JnhwSetStaticShortField(env, clazz, "POLLRDBAND", POLLRDBAND)) {
            return;
        }
        if (JnhwSetStaticShortField(env, clazz, "POLLRDNORM", POLLRDNORM)) {
            return;
        }
        if (JnhwSetStaticShortField(env, clazz, "POLLWRBAND", POLLWRBAND)) {
            return;
        }
        if (JnhwSetStaticShortField(env, clazz, "POLLWRNORM", POLLWRNORM)) {
            return;
        }
    }


#endif
#ifdef __cplusplus
}
#endif