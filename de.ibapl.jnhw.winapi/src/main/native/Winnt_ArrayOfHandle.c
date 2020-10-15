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
#include "de_ibapl_jnhw_winapi_Winnt_ArrayOfHandle.h"

#ifdef HAVE_WINNT_H
#include <winnt.h>

#ifdef __cplusplus
extern "C" {
#endif


/*
 * Class:     de_ibapl_jnhw_winapi_Winnt_ArrayOfHandle
 * Method:    get0
 * Signature: (I)Lde/ibapl/jnhw/winapi/Winnt/HANDLE;
 */
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winnt_00024ArrayOfHandle_get0
  (__attribute__ ((unused)) JNIEnv *env, jobject this, jint i) {
    return CREATE_HANDLE(*(UNWRAP_OPAQUE_MEM_TO(HANDLE *, this)+ i));
  }

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt_ArrayOfHandle
 * Method:    set0
 * Signature: (ILde/ibapl/jnhw/winapi/Winnt/HANDLE;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winnt_00024ArrayOfHandle_set0
  (__attribute__ ((unused)) JNIEnv *env, jobject this, jint i, jobject element) {
    *(UNWRAP_OPAQUE_MEM_TO(HANDLE *, this) + i) = UNWRAP_HANDLE_OR_NULL(element);
  }

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt_ArrayOfHandle
 * Method:    sizeofHANDLE
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_00024ArrayOfHandle_sizeofHANDLE
  (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    return sizeof(HANDLE);
  }

#ifdef __cplusplus
}
#endif
#endif