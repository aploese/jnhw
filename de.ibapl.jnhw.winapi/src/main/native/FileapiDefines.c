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
#include "de_ibapl_jnhw_winapi_Fileapi.h"

#ifdef __cplusplus
extern "C" {
#endif

#ifndef HAVE_FILEAPI_H

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <fileapi.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_FILEAPI_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "CREATE_ALWAYS", CREATE_ALWAYS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CREATE_NEW", CREATE_NEW)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "OPEN_ALWAYS", OPEN_ALWAYS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "OPEN_EXISTING", OPEN_EXISTING)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TRUNCATE_EXISTING", TRUNCATE_EXISTING)) {
            return;
        }
    }


#endif
#ifdef __cplusplus
}
#endif

