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
#if !defined(HAVE_AIO_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    HAVE_AIO_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_HAVE_1AIO_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_FALSE;
    }

#else
#if defined(__OpenBSD__)
#error OpenBSD and aio.h
#else
#include <aio.h>
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    HAVE_AIO_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_HAVE_1AIO_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_TRUE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    AIO_ALLDONE
     * Signature: ()Lde/ibapl/jnhw/common/util/IntDefine;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_AIO_1ALLDONE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JnhwWrapInteger(env, AIO_ALLDONE);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    AIO_CANCELED
     * Signature: ()Lde/ibapl/jnhw/common/util/IntDefine;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_AIO_1CANCELED
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JnhwWrapInteger(env, AIO_CANCELED);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    AIO_NOTCANCELED
     * Signature: ()Lde/ibapl/jnhw/common/util/IntDefine;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_AIO_1NOTCANCELED
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JnhwWrapInteger(env, AIO_NOTCANCELED);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    LIO_NOP
     * Signature: ()Lde/ibapl/jnhw/common/util/IntDefine;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_LIO_1NOP
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JnhwWrapInteger(env, LIO_NOP);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    LIO_NOWAIT
     * Signature: ()Lde/ibapl/jnhw/common/util/IntDefine;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_LIO_1NOWAIT
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JnhwWrapInteger(env, LIO_NOWAIT);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    LIO_READ
     * Signature: ()Lde/ibapl/jnhw/common/util/IntDefine;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_LIO_1READ
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JnhwWrapInteger(env, LIO_READ);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    LIO_WAIT
     * Signature: ()Lde/ibapl/jnhw/common/util/IntDefine;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_LIO_1WAIT
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JnhwWrapInteger(env, LIO_WAIT);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_AioTest_NativeDefines
     * Method:    LIO_WRITE
     * Signature: ()Lde/ibapl/jnhw/common/util/IntDefine;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_AioTest_00024NativeDefines_LIO_1WRITE
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JnhwWrapInteger(env, LIO_WRITE);
    }

#endif

#ifdef __cplusplus
}
#endif
