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
#include "de_ibapl_jnhw_util_posix_SizeOf.h"

#ifdef HAVE_SYS_EVENTFD_H
#include <sys/eventfd.h>
#endif

#ifdef HAVE_SYS_TYPES_H
#include <sys/types.h>
#endif

#ifdef HAVE_TERMIOS_H
#include <termios.h>
#endif

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_util_posix_SizeOf
     * Method:    off_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_SizeOf_off_1t
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_SYS_TYPES_H
        return sizeof (off_t);
#else
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_SizeOf
     * Method:    cc_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_SizeOf_cc_1t
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_TERMIOS_H
        return sizeof (cc_t);
#else
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_SizeOf
     * Method:    tcflag_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_SizeOf_tcflag_1t
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_TERMIOS_H
        return sizeof (tcflag_t);
#else
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_SizeOf
     * Method:    speed_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_SizeOf_speed_1t
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_TERMIOS_H
        return sizeof (speed_t);
#else
        return 0;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_util_posix_SizeOf
     * Method:    eventfd_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_util_posix_SizeOf_eventfd_1t
    (JNIEnv *env, jclass clazz) {
#ifdef HAVE_SYS_EVENTFD_H
        return sizeof (eventfd_t);
#else
        return 0;
#endif
    }

#ifdef __cplusplus
}
#endif