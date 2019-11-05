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
#include "de_ibapl_jnhw_winapi_Winbase.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    HAVE_WINBASE_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_HAVE_1WINBASE_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#ifdef HAVE_WINBASE_H
        return JNI_TRUE;
#else
        return JNI_FALSE;
#endif
    }

#ifdef HAVE_WINBASE_H
#include <winbase.h>
    
    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    STD_INPUT_HANDLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_STD_1INPUT_1HANDLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t)STD_INPUT_HANDLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    STD_OUTPUT_HANDLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_STD_1OUTPUT_1HANDLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t)STD_OUTPUT_HANDLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    STD_ERROR_HANDLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_STD_1ERROR_1HANDLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t)STD_ERROR_HANDLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    WAIT_FAILED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1FAILED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t)WAIT_FAILED;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    WAIT_OBJECT_0
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1OBJECT_10
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return WAIT_OBJECT_0;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    WAIT_ABANDONED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1ABANDONED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return WAIT_ABANDONED;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    WAIT_TIMEOUT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1TIMEOUT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return WAIT_TIMEOUT;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_OVERLAPPED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1OVERLAPPED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_FLAG_OVERLAPPED;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    RTS_CONTROL_DISABLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_RTS_1CONTROL_1DISABLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return RTS_CONTROL_DISABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    RTS_CONTROL_HANDSHAKE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_RTS_1CONTROL_1HANDSHAKE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return RTS_CONTROL_HANDSHAKE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    create_INVALID_HANDLE_VALUE
     * Signature: ()Lde/ibapl/jnhw/winapi/Winnt$HANDLE;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_winapi_Winbase_create_1INVALID_1HANDLE_1VALUE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CREATE_HANDLE(INVALID_HANDLE_VALUE);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    NOPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_NOPARITY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return NOPARITY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    ODDPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ODDPARITY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ODDPARITY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    EVENPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_EVENPARITY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return EVENPARITY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    MARKPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MARKPARITY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return MARKPARITY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SPACEPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SPACEPARITY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SPACEPARITY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    ONESTOPBIT
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ONESTOPBIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ONESTOPBIT;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    ONE5STOPBITS
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_ONE5STOPBITS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ONE5STOPBITS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    TWOSTOPBITS
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_TWOSTOPBITS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TWOSTOPBITS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    INFINITE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_INFINITE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t)INFINITE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SETRTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETRTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SETRTS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CLRRTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CLRRTS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLRRTS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SETDTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETDTR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SETDTR;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CLRDTR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CLRDTR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLRDTR;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SETBREAK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETBREAK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SETBREAK;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CLRBREAK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CLRBREAK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLRBREAK;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    MS_CTS_ON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1CTS_1ON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return MS_CTS_ON;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    MS_DSR_ON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1DSR_1ON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return MS_DSR_ON;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    MS_RING_ON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1RING_1ON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return MS_RING_ON;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    MS_RLSD_ON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_MS_1RLSD_1ON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return MS_RLSD_ON;
    }

#endif

#ifdef __cplusplus
}
#endif
