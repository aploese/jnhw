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
#include "de_ibapl_jnhw_posix_UnistdTest_NativeDefines.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...
#if !defined(HAVE_UNISTD_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    HAVE_UNISTD_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines_HAVE_1UNISTD_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_FALSE;
    }
#else
#include <unistd.h>
#include <errno.h>

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    HAVE_UNISTD_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines_HAVE_1UNISTD_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_TRUE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    _POSIX_VERSION
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines__1POSIX_1VERSION
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return _POSIX_VERSION;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    SEEK_CUR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines_SEEK_1CUR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_CUR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    SEEK_DATA
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines_SEEK_1DATA
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(SEEK_DATA)
#error "SEEK_DATA defined"
#endif
        return NULL;
#else
        return JnhwWrapInteger(env, SEEK_DATA);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    SEEK_END
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines_SEEK_1END
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_END;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    SEEK_HOLE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines_SEEK_1HOLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__OpenBSD__)
#if defined(SEEK_HOLE)
#error "SEEK_HOLE defined"
#endif
        return NULL;
#else
        return JnhwWrapInteger(env, SEEK_HOLE);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    SEEK_SET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines_SEEK_1SET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_SET;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    STDERR_FILENO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines_STDERR_1FILENO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return STDERR_FILENO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    STDIN_FILENO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines_STDIN_1FILENO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return STDIN_FILENO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_UnistdTest_NativeDefines
     * Method:    STDOUT_FILENO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_UnistdTest_00024NativeDefines_STDOUT_1FILENO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return STDOUT_FILENO;
    }


#endif

#ifdef __cplusplus
}
#endif
