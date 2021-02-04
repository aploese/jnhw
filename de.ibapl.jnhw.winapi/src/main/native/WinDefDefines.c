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
#include "de_ibapl_jnhw_winapi_WinDef.h"

#ifdef HAVE_WINDEF_H
#include <windef.h>
#define HAVE_WINDEF_OR_MINWINDEF_H 1;
#elif defined(HAVE_MINWINDEF_H)
#include <minwindef.h>
#define HAVE_WINDEF_OR_MINWINDEF_H 1;
#endif


#ifdef __cplusplus
extern "C" {
#endif

#ifndef HAVE_WINDEF_OR_MINWINDEF_H

    /*
     * Class:     de_ibapl_jnhw_winapi_WinDef
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_WinDef_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else

    /*
     * Class:     de_ibapl_jnhw_winapi_WinDef
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_WinDef_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_WINDEF_H", JNI_TRUE)) {
            return;
        }

    }

#endif
#ifdef __cplusplus
}
#endif
