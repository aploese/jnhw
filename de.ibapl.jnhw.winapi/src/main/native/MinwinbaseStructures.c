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
#include "de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED.h"
#include "de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES.h"

#ifdef HAVE_MINWINBASE_H
#include <minwinbase.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_winapi_Minwinbase_OVERLAPPED
 * Method:    native2Layout
 * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/winapi/Minwinbase/OVERLAPPED/Layout;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024OVERLAPPED_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (OVERLAPPED), __alignof__ (OVERLAPPED));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "Internal", offsetof(OVERLAPPED, Internal))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "InternalHigh", offsetof(OVERLAPPED, InternalHigh))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "Offset", offsetof(OVERLAPPED, Offset))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "OffsetHigh", offsetof(OVERLAPPED, OffsetHigh))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "Pointer", offsetof(OVERLAPPED, Pointer))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "hEvent", offsetof(OVERLAPPED, hEvent))) {
            return result;
        }
        return result;
    }

/*
 * Class:     de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES
 * Method:    native2Layout
 * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/winapi/Minwinbase/SECURITY_ATTRIBUTES/Layout;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024SECURITY_1ATTRIBUTES_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (SECURITY_ATTRIBUTES), __alignof__ (SECURITY_ATTRIBUTES));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "nLength", offsetof(SECURITY_ATTRIBUTES, nLength))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "lpSecurityDescriptor", offsetof(SECURITY_ATTRIBUTES, lpSecurityDescriptor))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "bInheritHandle", offsetof(SECURITY_ATTRIBUTES, bInheritHandle))) {
            return result;
        }
        return result;
    }

#ifdef __cplusplus
}
#endif
#endif
