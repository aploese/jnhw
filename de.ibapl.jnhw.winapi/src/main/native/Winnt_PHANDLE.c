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
#include "de_ibapl_jnhw_winapi_Winnt_PHANDLE.h"

#ifdef HAVE_WINNT_H
#include <winnt.h>

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_ibapl_jnhw_winapi_Winnt_PHANDLE
 * Method:    sizeofHANDLE
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winnt_00024PHANDLE_sizeofHANDLE
  (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    return sizeof(HANDLE);
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt_PHANDLE
 * Method:    getHandleValue
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_winapi_Winnt_00024PHANDLE_getHandleValue
  (__attribute__ ((unused)) JNIEnv *env, jobject this) {
    return (intptr_t) *(UNWRAP_PHANDLE(this));
}

/*
 * Class:     de_ibapl_jnhw_winapi_Winnt_PHANDLE
 * Method:    setHandleValue
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winnt_00024PHANDLE_setHandleValue
  (JNIEnv *env, jobject this, jlong value) {
    *(UNWRAP_PHANDLE(this)) = (HANDLE) (intptr_t) value;
}

#ifdef __cplusplus
}
#endif
#endif