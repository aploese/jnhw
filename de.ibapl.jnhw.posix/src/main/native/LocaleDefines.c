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
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Locale.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...    
#if !defined(HAVE_LOCALE_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Locale_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else    
#include <locale.h>
#if defined (__APPLE__) 
#include <xlocale.h>
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Locale
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Locale_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_LOCALE_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticIntField(env, clazz, "LC_ALL", LC_ALL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_ALL_MASK", LC_ALL_MASK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_COLLATE", LC_COLLATE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_COLLATE_MASK", LC_COLLATE_MASK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_CTYPE", LC_CTYPE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_CTYPE_MASK", LC_CTYPE_MASK)) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dij_p_Locale_t_CSig, "LC_GLOBAL_LOCALE", CREATE_Locale_t(LC_GLOBAL_LOCALE))) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_MESSAGES", LC_MESSAGES)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_MESSAGES_MASK", LC_MESSAGES_MASK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_MONETARY", LC_MONETARY)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_MONETARY_MASK", LC_MONETARY_MASK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_NUMERIC", LC_NUMERIC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_NUMERIC_MASK", LC_NUMERIC_MASK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_TIME", LC_TIME)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "LC_TIME_MASK", LC_TIME_MASK)) {
            return;
        }
    }

#endif

#ifdef __cplusplus
}
#endif