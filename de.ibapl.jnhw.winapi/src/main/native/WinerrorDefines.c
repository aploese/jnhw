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
#include "de_ibapl_jnhw_winapi_Winerror.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    HAVE_WINERROR_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winerror_HAVE_1WINERROR_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef HAVE_WINERROR_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef HAVE_WINERROR_H
#include <winerror.h>

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_SUCCESS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1SUCCESS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_SUCCESS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_FILE_NOT_FOUND
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1FILE_1NOT_1FOUND
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_FILE_NOT_FOUND;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_ACCESS_DENIED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1ACCESS_1DENIED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_ACCESS_DENIED;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_GEN_FAILURE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1GEN_1FAILURE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_GEN_FAILURE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_INVALID_PARAMETER
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1INVALID_1PARAMETER
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_INVALID_PARAMETER;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_INVALID_HANDLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1INVALID_1HANDLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_INVALID_HANDLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_IO_PENDING
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1IO_1PENDING
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_IO_PENDING;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_NOACCESS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1NOACCESS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_NOACCESS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_NO_MORE_ITEMS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1NO_1MORE_1ITEMS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_NO_MORE_ITEMS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_MORE_DATA
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1MORE_1DATA
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_MORE_DATA;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_NOT_FOUND
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1NOT_1FOUND
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_NOT_FOUND;
    }


    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_SHARING_VIOLATION
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1SHARING_1VIOLATION
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_SHARING_VIOLATION;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_PROC_NOT_FOUND
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1PROC_1NOT_1FOUND
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_PROC_NOT_FOUND;
    }



    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_ALREADY_EXISTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1ALREADY_1EXISTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_ALREADY_EXISTS;
    }
    
            
    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_FILE_EXISTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1FILE_1EXISTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_FILE_EXISTS;
    }
            
            
    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_PIPE_BUSY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1PIPE_1BUSY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_PIPE_BUSY;
    }
            
    /*
     * Class:     de_ibapl_jnhw_winapi_Winerror
     * Method:    ERROR_IO_INCOMPLETE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winerror_ERROR_1IO_1INCOMPLETE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ERROR_IO_INCOMPLETE;
    }
            
#endif

#ifdef __cplusplus
}
#endif
