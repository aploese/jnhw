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
#include "de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS.h"

#ifdef HAVE_WINBASE_H
#include <winbase.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    sizeofCOMMTIMEOUTS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_sizeofCOMMTIMEOUTS
    (JNIEnv *env, jclass clazz) {
        return sizeof (COMMTIMEOUTS);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadIntervalTimeout
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadIntervalTimeout__
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMMTIMEOUTS(this))->ReadIntervalTimeout;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadIntervalTimeout
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadIntervalTimeout__I
    (JNIEnv *env, jobject this, jint readIntervalTimeout) {
        (UNWRAP_COMMTIMEOUTS(this))->ReadIntervalTimeout = readIntervalTimeout;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutMultiplier
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutMultiplier__
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMMTIMEOUTS(this))->ReadTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutMultiplier
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutMultiplier__I
    (JNIEnv *env, jobject this, jint readTotalTimeoutMultiplier) {
        (UNWRAP_COMMTIMEOUTS(this))->ReadTotalTimeoutMultiplier = readTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutConstant
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutConstant__
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMMTIMEOUTS(this))->ReadTotalTimeoutConstant;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutConstant
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutConstant__I
    (JNIEnv *env, jobject this, jint readTotalTimeoutConstant) {
        (UNWRAP_COMMTIMEOUTS(this))->ReadTotalTimeoutConstant = readTotalTimeoutConstant;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutMultiplier
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutMultiplier__
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMMTIMEOUTS(this))->WriteTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutMultiplier
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutMultiplier__I
    (JNIEnv *env, jobject this, jint writeTotalTimeoutMultiplier) {
        (UNWRAP_COMMTIMEOUTS(this))->WriteTotalTimeoutMultiplier = writeTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutConstant
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutConstant__
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMMTIMEOUTS(this))->WriteTotalTimeoutConstant;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutConstant
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutConstant__I
    (JNIEnv *env, jobject this, jint writeTotalTimeoutConstant) {
        (UNWRAP_COMMTIMEOUTS(this))->WriteTotalTimeoutConstant = writeTotalTimeoutConstant;
    }

#ifdef __cplusplus
}
#endif
#endif
