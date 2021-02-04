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
#include "de_ibapl_jnhw_posix_Unistd.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...    
#if !defined(HAVE_UNISTD_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Unistd_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <unistd.h>
#include <stdio.h>
#include <errno.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Unistd
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Unistd_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_UNISTD_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "SEEK_SET", SEEK_SET)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SEEK_CUR", SEEK_CUR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SEEK_END", SEEK_END)) {
            return;
        }

#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(SEEK_DATA)
#error "SEEK_DATA defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "SEEK_DATA", SEEK_DATA)) {
            return;
        }
#endif

#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(SEEK_HOLE)
#error "SEEK_HOLE defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "SEEK_HOLE", SEEK_HOLE)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "STDIN_FILENO", STDIN_FILENO)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "STDOUT_FILENO", STDOUT_FILENO)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "STDERR_FILENO", STDERR_FILENO)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "_POSIX_VERSION", _POSIX_VERSION)) {
            return;
        }
    }


#endif

#ifdef __cplusplus
}
#endif
