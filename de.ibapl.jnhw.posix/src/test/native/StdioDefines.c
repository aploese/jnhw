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
#include "de_ibapl_jnhw_posix_StdioTest_NativeDefines.h"

#ifdef __cplusplus
extern "C" {
#endif


    //We need the POSIX version ...
#if !defined(HAVE_STDIO_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_StdioTest_NativeDefines
     * Method:    HAVE_STDIO_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_StdioTest_00024NativeDefines_HAVE_1STDIO_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_FALSE;
    }
#else
#include <stdio.h>

        /*
     * Class:     de_ibapl_jnhw_posix_StdioTest_NativeDefines
     * Method:    HAVE_STDIO_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_StdioTest_00024NativeDefines_HAVE_1STDIO_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_TRUE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_StdioTest_NativeDefines
     * Method:    EOF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_StdioTest_00024NativeDefines_EOF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EOF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_StdioTest_NativeDefines
     * Method:    SEEK_CUR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_StdioTest_00024NativeDefines_SEEK_1CUR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_CUR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_StdioTest_NativeDefines
     * Method:    SEEK_END
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_StdioTest_00024NativeDefines_SEEK_1END
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_END;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_StdioTest_NativeDefines
     * Method:    SEEK_SET
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_StdioTest_00024NativeDefines_SEEK_1SET
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEEK_SET;
    }

#endif
#ifdef __cplusplus
}
#endif