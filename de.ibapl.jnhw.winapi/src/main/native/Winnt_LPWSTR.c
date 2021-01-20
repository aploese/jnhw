/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
#include "de_ibapl_jnhw_winapi_Winnt_LPWSTR.h"

#ifdef HAVE_WINNT_H
#include <winnt.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt_LPWSTR
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_00024LPWSTR_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (LPWSTR);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winnt_LPWSTR
     * Method:    getString
     * Signature: (Lde/ibapl/jnhw/common/memory/OpaqueMemory;I)Ljava/lang/String;
     */
    JNIEXPORT jstring JNICALL Java_de_ibapl_jnhw_winapi_Winnt_00024LPWSTR_getString
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject opaqueMem, jint len) {
        return (*env)->NewString(env, UNWRAP_OPAQUE_MEM_TO_VOID_PTR(opaqueMem), len);
    }


#ifdef __cplusplus
}
#endif
#endif