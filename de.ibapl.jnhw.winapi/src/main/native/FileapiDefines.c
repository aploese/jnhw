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
#include "de_ibapl_jnhw_winapi_Fileapi.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    HAVE_FILEAPI_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_HAVE_1FILEAPI_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef HAVE_FILEAPI_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef HAVE_FILEAPI_H
#include <fileapi.h>
        /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    CREATE_ALWAYS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_CREATE_1ALWAYS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_ALWAYS;
    }

        /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    CREATE_NEW
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_CREATE_1NEW
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_NEW;
    }

        /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    OPEN_ALWAYS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_OPEN_1ALWAYS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return OPEN_ALWAYS;
    }

        /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    OPEN_EXISTING
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_OPEN_1EXISTING
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return OPEN_EXISTING;
    }

        /*
     * Class:     de_ibapl_jnhw_winapi_Fileapi
     * Method:    TRUNCATE_EXISTING
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Fileapi_TRUNCATE_1EXISTING
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TRUNCATE_EXISTING;
    }


#endif
#ifdef __cplusplus
}
#endif

