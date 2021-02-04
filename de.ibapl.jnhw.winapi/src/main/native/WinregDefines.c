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
#include "jnhw-winapi.h"
#include "de_ibapl_jnhw_winapi_Winreg.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifndef HAVE_WINREG_H

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winreg_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <winreg.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_Winreg
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winreg_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_WINREG_H", JNI_TRUE)) {
            return;
        }


        if (JnhwSetStaticObjectField(env, clazz, dij_w_HANDLE__CSig, "HKEY_CLASSES_ROOT", CREATE_HANDLE(HKEY_CLASSES_ROOT))) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dij_w_HANDLE__CSig, "HKEY_CURRENT_USER", CREATE_HANDLE(HKEY_CURRENT_USER))) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dij_w_HANDLE__CSig, "HKEY_CURRENT_USER_LOCAL_SETTINGS", CREATE_HANDLE(HKEY_CURRENT_USER_LOCAL_SETTINGS))) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dij_w_HANDLE__CSig, "HKEY_LOCAL_MACHINE", CREATE_HANDLE(HKEY_LOCAL_MACHINE))) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dij_w_HANDLE__CSig, "HKEY_USERS", CREATE_HANDLE(HKEY_USERS))) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dij_w_HANDLE__CSig, "HKEY_PERFORMANCE_DATA", CREATE_HANDLE(HKEY_PERFORMANCE_DATA))) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dij_w_HANDLE__CSig, "HKEY_PERFORMANCE_TEXT", CREATE_HANDLE(HKEY_PERFORMANCE_TEXT))) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dij_w_HANDLE__CSig, "HKEY_PERFORMANCE_NLSTEXT", CREATE_HANDLE(HKEY_PERFORMANCE_NLSTEXT))) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dij_w_HANDLE__CSig, "HKEY_CURRENT_CONFIG", CREATE_HANDLE(HKEY_CURRENT_CONFIG))) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dij_w_HANDLE__CSig, "HKEY_DYN_DATA", CREATE_HANDLE(HKEY_DYN_DATA))) {
            return;
        }
    }

#ifdef __cplusplus
}
#endif
#endif
