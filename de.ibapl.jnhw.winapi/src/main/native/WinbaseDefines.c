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
        return (int32_t) STD_INPUT_HANDLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    STD_OUTPUT_HANDLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_STD_1OUTPUT_1HANDLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t) STD_OUTPUT_HANDLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    STD_ERROR_HANDLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_STD_1ERROR_1HANDLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t) STD_ERROR_HANDLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    WAIT_FAILED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_WAIT_1FAILED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t) WAIT_FAILED;
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
     * Method:    FILE_ATTRIBUTE_ARCHIVE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1ATTRIBUTE_1ARCHIVE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_ATTRIBUTE_ARCHIVE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_ATTRIBUTE_ENCRYPTED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1ATTRIBUTE_1ENCRYPTED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_ATTRIBUTE_ENCRYPTED;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_ATTRIBUTE_HIDDEN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1ATTRIBUTE_1HIDDEN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_ATTRIBUTE_HIDDEN;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_ATTRIBUTE_NORMAL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1ATTRIBUTE_1NORMAL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_ATTRIBUTE_NORMAL;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_ATTRIBUTE_OFFLINE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1ATTRIBUTE_1OFFLINE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_ATTRIBUTE_OFFLINE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_ATTRIBUTE_READONLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1ATTRIBUTE_1READONLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_ATTRIBUTE_READONLY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_ATTRIBUTE_SYSTEM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1ATTRIBUTE_1SYSTEM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_ATTRIBUTE_SYSTEM;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_ATTRIBUTE_TEMPORARY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1ATTRIBUTE_1TEMPORARY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_ATTRIBUTE_TEMPORARY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_BACKUP_SEMANTICS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1BACKUP_1SEMANTICS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_FLAG_BACKUP_SEMANTICS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_DELETE_ON_CLOSE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1DELETE_1ON_1CLOSE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_FLAG_DELETE_ON_CLOSE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_NO_BUFFERING
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1NO_1BUFFERING
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_FLAG_NO_BUFFERING;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_OPEN_NO_RECALL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1OPEN_1NO_1RECALL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_FLAG_OPEN_NO_RECALL;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_OPEN_REPARSE_POINT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1OPEN_1REPARSE_1POINT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_FLAG_OPEN_REPARSE_POINT;
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
     * Method:    FILE_FLAG_POSIX_SEMANTICS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1POSIX_1SEMANTICS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_FLAG_POSIX_SEMANTICS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_RANDOM_ACCESS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1RANDOM_1ACCESS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_FLAG_RANDOM_ACCESS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_SESSION_AWARE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1SESSION_1AWARE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_FLAG_SESSION_AWARE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_SEQUENTIAL_SCAN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1SEQUENTIAL_1SCAN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FILE_FLAG_SEQUENTIAL_SCAN;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    FILE_FLAG_WRITE_THROUGH
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_FILE_1FLAG_1WRITE_1THROUGH
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t) FILE_FLAG_WRITE_THROUGH;
    }

/*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SECURITY_ANONYMOUS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SECURITY_1ANONYMOUS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SECURITY_ANONYMOUS;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SECURITY_CONTEXT_TRACKING
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SECURITY_1CONTEXT_1TRACKING
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SECURITY_CONTEXT_TRACKING;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SECURITY_DELEGATION
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SECURITY_1DELEGATION
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SECURITY_DELEGATION;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SECURITY_EFFECTIVE_ONLY
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SECURITY_1EFFECTIVE_1ONLY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SECURITY_EFFECTIVE_ONLY;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SECURITY_IDENTIFICATION
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SECURITY_1IDENTIFICATION
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SECURITY_IDENTIFICATION;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SECURITY_IMPERSONATION
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SECURITY_1IMPERSONATION
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SECURITY_IMPERSONATION;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    RTS_CONTROL_DISABLE
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_RTS_1CONTROL_1DISABLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return RTS_CONTROL_DISABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    RTS_CONTROL_ENABLE
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_RTS_1CONTROL_1ENABLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return RTS_CONTROL_ENABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    RTS_CONTROL_TOGGLE
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_RTS_1CONTROL_1TOGGLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return RTS_CONTROL_TOGGLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    RTS_CONTROL_HANDSHAKE
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_RTS_1CONTROL_1HANDSHAKE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return RTS_CONTROL_HANDSHAKE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    DTR_CONTROL_DISABLE
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_DTR_1CONTROL_1DISABLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return DTR_CONTROL_DISABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    DTR_CONTROL_ENABLE
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_DTR_1CONTROL_1ENABLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return DTR_CONTROL_ENABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    DTR_CONTROL_HANDSHAKE
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_DTR_1CONTROL_1HANDSHAKE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return DTR_CONTROL_HANDSHAKE;
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
        return (int32_t) INFINITE;
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
     * Method:    SETXOFF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETXOFF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SETXOFF;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    SETXON
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_SETXON
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SETXON;
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

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CE_BREAK
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CE_1BREAK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CE_BREAK;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CE_FRAME
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CE_1FRAME
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CE_FRAME;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CE_OVERRUN
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CE_1OVERRUN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CE_OVERRUN;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CE_RXOVER
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CE_1RXOVER
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CE_RXOVER;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase
     * Method:    CE_RXPARITY
     * Signature: ()B
     */
    JNIEXPORT jbyte JNICALL Java_de_ibapl_jnhw_winapi_Winbase_CE_1RXPARITY
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CE_RXPARITY;
    }

#endif

#ifdef __cplusplus
}
#endif
