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
#include "de_ibapl_jnhw_posix_AioTest_NativeDefines.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
#include <aio.h>

#if defined(__OpenBSD__)
#error OpenBSD and aio.h
#endif

#endif

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    HAVE_AIO_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_HAVE_1AIO_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    AIO_ALLDONE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_AIO_1ALLDONE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
        return JnhwWrapInteger(env, AIO_ALLDONE);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    AIO_CANCELED
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_AIO_1CANCELED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
        return JnhwWrapInteger(env, AIO_CANCELED);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    AIO_NOTCANCELED
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_AIO_1NOTCANCELED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
        return JnhwWrapInteger(env, AIO_NOTCANCELED);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    LIO_NOP
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_LIO_1NOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
        return JnhwWrapInteger(env, LIO_NOP);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    LIO_NOWAIT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_LIO_1NOWAIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
        return JnhwWrapInteger(env, LIO_NOWAIT);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    LIO_READ
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_LIO_1READ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
        return JnhwWrapInteger(env, LIO_READ);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    LIO_WAIT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_LIO_1WAIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
        return JnhwWrapInteger(env, LIO_WAIT);
#else
        return NULL;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    LIO_WRITE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_LIO_1WRITE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(HAVE_AIO_H) && defined(_POSIX_VERSION)
        return JnhwWrapInteger(env, LIO_WRITE);
#else
        return NULL;
#endif
    }

#ifdef __cplusplus
}
#endif
