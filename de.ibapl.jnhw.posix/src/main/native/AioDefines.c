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
#include "de_ibapl_jnhw_posix_Aio.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...    
#if !defined(HAVE_AIO_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#if defined(__OpenBSD__)
#error OpenBSD and aio.h
#else
#include <aio.h>
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Aio_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_AIO_H", JNI_TRUE)) {
            return;
        }
        if (JnhwSetStaticIntDefineField(env, clazz, "AIO_ALLDONE", AIO_ALLDONE)) {
            return;
        }
        if (JnhwSetStaticIntDefineField(env, clazz, "AIO_CANCELED", AIO_CANCELED)) {
            return;
        }
        if (JnhwSetStaticIntDefineField(env, clazz, "AIO_NOTCANCELED", AIO_NOTCANCELED)) {
            return;
        }
        if (JnhwSetStaticIntDefineField(env, clazz, "LIO_NOP", LIO_NOP)) {
            return;
        }
        if (JnhwSetStaticIntDefineField(env, clazz, "LIO_NOWAIT", LIO_NOWAIT)) {
            return;
        }
        if (JnhwSetStaticIntDefineField(env, clazz, "LIO_READ", LIO_READ)) {
            return;
        }
        if (JnhwSetStaticIntDefineField(env, clazz, "LIO_WAIT", LIO_WAIT)) {
            return;
        }
        if (JnhwSetStaticIntDefineField(env, clazz, "LIO_WRITE", LIO_WRITE)) {
            return;
        }
    }

#endif

#ifdef __cplusplus
}
#endif
