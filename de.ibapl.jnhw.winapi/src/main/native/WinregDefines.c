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
#include "de_ibapl_jnhw_winapi_Winreg.h"

/*
 * Class:     de_ibapl_jnhw_winapi_Winreg
 * Method:    HAVE_WINREG_H
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winreg_HAVE_1WINREG_1H
(__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef HAVE_WINREG_H
    return JNI_TRUE;
#else
    return JNI_FALSE;
#endif
}

#ifdef HAVE_WINREG_H
#include <winreg.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    create_HKEY_CLASSES_ROOT
     * Signature: ()Lde/ibapl/jnhw/winapi/WinDef/HKEY;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_create_1HKEY_1CLASSES_1ROOT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(HKEY_CLASSES_ROOT);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    create_HKEY_CURRENT_USER
     * Signature: ()Lde/ibapl/jnhw/winapi/WinDef$HKEY;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_create_1HKEY_1CURRENT_1USER
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(HKEY_CURRENT_USER);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    create_HKEY_CURRENT_USER_LOCAL_SETTINGS
     * Signature: ()Lde/ibapl/jnhw/winapi/WinDef$HKEY;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_create_1HKEY_1CURRENT_1USER_1LOCAL_1SETTINGS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(HKEY_CURRENT_USER_LOCAL_SETTINGS);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    create_HKEY_LOCAL_MACHINE
     * Signature: ()Lde/ibapl/jnhw/winapi/WinDef$HKEY;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_create_1HKEY_1LOCAL_1MACHINE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(HKEY_LOCAL_MACHINE);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    create_HKEY_USERS
     * Signature: ()Lde/ibapl/jnhw/winapi/WinDef$HKEY;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_create_1HKEY_1USERS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(HKEY_USERS);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    create_HKEY_PERFORMANCE_DATA
     * Signature: ()Lde/ibapl/jnhw/winapi/WinDef$HKEY;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_create_1HKEY_1PERFORMANCE_1DATA
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(HKEY_PERFORMANCE_DATA);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    create_HKEY_PERFORMANCE_TEXT
     * Signature: ()Lde/ibapl/jnhw/winapi/WinDef$HKEY;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_create_1HKEY_1PERFORMANCE_1TEXT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(HKEY_PERFORMANCE_TEXT);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    create_HKEY_PERFORMANCE_NLSTEXT
     * Signature: ()Lde/ibapl/jnhw/winapi/WinDef$HKEY;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_create_1HKEY_1PERFORMANCE_1NLSTEXT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(HKEY_PERFORMANCE_NLSTEXT);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    create_HKEY_CURRENT_CONFIG
     * Signature: ()Lde/ibapl/jnhw/winapi/WinDef$HKEY;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_create_1HKEY_1CURRENT_1CONFIG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(HKEY_CURRENT_CONFIG);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    create_HKEY_DYN_DATA
     * Signature: ()Lde/ibapl/jnhw/winapi/WinDef$HKEY;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winreg_create_1HKEY_1DYN_1DATA
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(HKEY_DYN_DATA);
    }

#ifdef __cplusplus
}
#endif
#endif
