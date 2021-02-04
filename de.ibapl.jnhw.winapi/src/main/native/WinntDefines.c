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
#include "de_ibapl_jnhw_winapi_Winnt.h"

#ifdef __cplusplus
extern "C" {
#endif



#ifndef HAVE_WINNT_H

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winnt_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <winnt.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winnt_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_WINNT_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "FILE_SHARE_DELETE", FILE_SHARE_DELETE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_SHARE_READ", FILE_SHARE_READ)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FILE_SHARE_WRITE", FILE_SHARE_WRITE)) {
            return;
        }
        if (JnhwSetStaticLongField(env, clazz, "MAXDWORD", (int64_t) MAXDWORD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "GENERIC_ALL", (int32_t) GENERIC_ALL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "GENERIC_EXECUTE", (int32_t) GENERIC_EXECUTE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "GENERIC_READ", (int32_t) GENERIC_READ)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "GENERIC_WRITE", GENERIC_WRITE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "KEY_ALL_ACCESS", KEY_ALL_ACCESS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "KEY_EXECUTE", KEY_EXECUTE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "KEY_QUERY_VALUE", KEY_QUERY_VALUE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "KEY_SET_VALUE", KEY_SET_VALUE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "KEY_CREATE_SUB_KEY", KEY_CREATE_SUB_KEY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "KEY_ENUMERATE_SUB_KEYS", KEY_ENUMERATE_SUB_KEYS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "KEY_NOTIFY", KEY_NOTIFY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "KEY_CREATE_LINK", KEY_CREATE_LINK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "KEY_READ", KEY_READ)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_OPTION_NON_VOLATILE", REG_OPTION_NON_VOLATILE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_OPTION_VOLATILE", REG_OPTION_VOLATILE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_OPTION_CREATE_LINK", REG_OPTION_CREATE_LINK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_OPTION_BACKUP_RESTORE", REG_OPTION_BACKUP_RESTORE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_OPTION_OPEN_LINK", REG_OPTION_OPEN_LINK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_OPENED_EXISTING_KEY", REG_OPENED_EXISTING_KEY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_NONE", REG_NONE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_SZ", REG_SZ)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_EXPAND_SZ", REG_EXPAND_SZ)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_BINARY", REG_BINARY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_DWORD", REG_DWORD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_DWORD_LITTLE_ENDIAN", REG_DWORD_LITTLE_ENDIAN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_DWORD_BIG_ENDIAN", REG_DWORD_BIG_ENDIAN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_LINK", REG_LINK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_MULTI_SZ", REG_MULTI_SZ)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_RESOURCE_LIST", REG_RESOURCE_LIST)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_FULL_RESOURCE_DESCRIPTOR", REG_FULL_RESOURCE_DESCRIPTOR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_RESOURCE_REQUIREMENTS_LIST", REG_RESOURCE_REQUIREMENTS_LIST)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_QWORD", REG_QWORD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_QWORD_LITTLE_ENDIAN", REG_QWORD_LITTLE_ENDIAN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "REG_CREATED_NEW_KEY", REG_CREATED_NEW_KEY)) {
            return;
        }
    }

#ifdef __cplusplus
}
#endif
#endif
