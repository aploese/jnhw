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
#include "de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES.h"

#ifdef HAVE_MINWINBASE_H
#include <minwinbase.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES
     * Method:    sizeofSECURITY_ATTRIBUTES
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024SECURITY_1ATTRIBUTES_sizeofSECURITY_1ATTRIBUTES
    (JNIEnv *env, jclass clazz) {
        return sizeof (SECURITY_ATTRIBUTES);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES
     * Method:    nLength
     * Signature: (J)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024SECURITY_1ATTRIBUTES_nLength
    (JNIEnv *env, jobject clazz, jlong baseAddress) {
        return ((SECURITY_ATTRIBUTES*) (uintptr_t) baseAddress)->nLength;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Minwinbase_SECURITY_ATTRIBUTES
     * Method:    bInheritHandle
     * Signature: (J)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Minwinbase_00024SECURITY_1ATTRIBUTES_bInheritHandle
    (JNIEnv *env, jobject clazz, jlong baseAddress) {
        return ((SECURITY_ATTRIBUTES*) (uintptr_t) baseAddress)->bInheritHandle;
    }

#ifdef __cplusplus
}
#endif
#endif
