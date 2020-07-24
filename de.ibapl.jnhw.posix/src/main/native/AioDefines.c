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
#include "de_ibapl_jnhw_posix_Aio.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    HAVE_AIO_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Aio_HAVE_1AIO_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }


#if defined(_POSIX_VERSION) 
#if defined(__OpenBSD__)
#if defined(HAVE_AIO_H)
#error OpenBSD and aio.h
#endif
#else    
#include <aio.h>
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    AIO_ALLDONE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_AIO_1ALLDONE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(AIO_ALLDONE)
#error "AIO_ALLDONE defined"
#endif
        throw_NotDefinedException(env, "AIO_ALLDONE");
        return 0;
#else
        return AIO_ALLDONE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    AIO_CANCELED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_AIO_1CANCELED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(AIO_CANCELED)
#error "AIO_CANCELED defined"
#endif
        throw_NotDefinedException(env, "AIO_CANCELED");
        return 0;
#else
        return AIO_CANCELED;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    AIO_NOTCANCELED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_AIO_1NOTCANCELED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(AIO_NOTCANCELED)
#error "AIO_NOTCANCELED defined"
#endif
        throw_NotDefinedException(env, "AIO_NOTCANCELED");
        return 0;
#else
        return AIO_NOTCANCELED;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    LIO_NOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_LIO_1NOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(LIO_NOP)
#error "LIO_NOP defined"
#endif
        throw_NotDefinedException(env, "LIO_NOP");
        return 0;
#else
        return LIO_NOP;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    LIO_NOWAIT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_LIO_1NOWAIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(LIO_NOWAIT)
#error "LIO_NOWAIT defined"
#endif
        throw_NotDefinedException(env, "LIO_NOWAIT");
        return 0;
#else
        return LIO_NOWAIT;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    LIO_READ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_LIO_1READ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(LIO_READ)
#error "LIO_READ defined"
#endif
        throw_NotDefinedException(env, "LIO_READ");
        return 0;
#else
        return LIO_READ;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    LIO_WAIT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_LIO_1WAIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(LIO_WAIT)
#error "LIO_WAIT defined"
#endif
        throw_NotDefinedException(env, "LIO_WAIT");
        return 0;
#else
        return LIO_WAIT;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Aio
     * Method:    LIO_WRITE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Aio_LIO_1WRITE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if defined(LIO_WRITE)
#error "LIO_WRITE defined"
#endif
        throw_NotDefinedException(env, "LIO_WRITE");
        return 0;
#else
        return LIO_WRITE;
#endif
    }


#endif
#ifdef __cplusplus
}
#endif
