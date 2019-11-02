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
#include "jnhw-winapi.h"
#include "de_ibapl_jnhw_winapi_Winnt.h"

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt
 * Method:    HAVE_WINNT_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winnt_HAVE_1WINNT_1H
(__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef HAVE_WINNT_H
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

#ifdef HAVE_WINNT_H
#include <winnt.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    MAXDWORD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_MAXDWORD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return MAXDWORD;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    GENERIC_READ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_GENERIC_1READ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return GENERIC_READ;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    GENERIC_WRITE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_GENERIC_1WRITE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return GENERIC_WRITE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    KEY_READ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_KEY_1READ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return KEY_READ;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_NONE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1NONE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_NONE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_SZ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1SZ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_SZ;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_EXPAND_SZ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1EXPAND_1SZ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_EXPAND_SZ;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_BINARY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1BINARY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_BINARY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_DWORD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1DWORD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_DWORD;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_DWORD_LITTLE_ENDIAN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1DWORD_1LITTLE_1ENDIAN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_DWORD_LITTLE_ENDIAN;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_DWORD_BIG_ENDIAN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1DWORD_1BIG_1ENDIAN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_DWORD_BIG_ENDIAN;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_LINK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1LINK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_LINK;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_MULTI_SZ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1MULTI_1SZ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_MULTI_SZ;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_RESOURCE_LIST
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1RESOURCE_1LIST
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_RESOURCE_LIST;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_FULL_RESOURCE_DESCRIPTOR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1FULL_1RESOURCE_1DESCRIPTOR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_FULL_RESOURCE_DESCRIPTOR;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_RESOURCE_REQUIREMENTS_LIST
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1RESOURCE_1REQUIREMENTS_1LIST
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_RESOURCE_REQUIREMENTS_LIST;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_QWORD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1QWORD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_QWORD;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    REG_QWORD_LITTLE_ENDIAN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_REG_1QWORD_1LITTLE_1ENDIAN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return REG_QWORD_LITTLE_ENDIAN;
    }

#ifdef __cplusplus
}
#endif
#endif