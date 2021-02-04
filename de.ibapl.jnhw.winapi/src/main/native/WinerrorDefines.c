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
#include "de_ibapl_jnhw_winapi_Winerror.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifndef HAVE_WINERROR_H

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winerror_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <winerror.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winerror_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_WINERROR_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "ERROR_SUCCESS", ERROR_SUCCESS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_FILE_NOT_FOUND", ERROR_FILE_NOT_FOUND)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_ACCESS_DENIED", ERROR_ACCESS_DENIED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_GEN_FAILURE", ERROR_GEN_FAILURE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_INVALID_PARAMETER", ERROR_INVALID_PARAMETER)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_INVALID_HANDLE", ERROR_INVALID_HANDLE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_IO_PENDING", ERROR_IO_PENDING)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_NOACCESS", ERROR_NOACCESS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_NO_MORE_ITEMS", ERROR_NO_MORE_ITEMS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_MORE_DATA", ERROR_MORE_DATA)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_NOT_FOUND", ERROR_NOT_FOUND)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_SHARING_VIOLATION", ERROR_SHARING_VIOLATION)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_PROC_NOT_FOUND", ERROR_PROC_NOT_FOUND)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_ALREADY_EXISTS", ERROR_ALREADY_EXISTS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_FILE_EXISTS", ERROR_FILE_EXISTS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_PIPE_BUSY", ERROR_PIPE_BUSY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ERROR_IO_INCOMPLETE", ERROR_IO_INCOMPLETE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "WAIT_TIMEOUT", WAIT_TIMEOUT)) {
            return;
        }
    }

#endif

#ifdef __cplusplus
}
#endif
