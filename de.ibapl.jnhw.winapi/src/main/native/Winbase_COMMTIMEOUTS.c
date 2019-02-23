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
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadIntervalTimeout__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadIntervalTimeout;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadIntervalTimeout
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadIntervalTimeout__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint readIntervalTimeout) {
        ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadIntervalTimeout = readIntervalTimeout;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutMultiplier
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutMultiplier__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutMultiplier
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutMultiplier__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint readTotalTimeoutMultiplier) {
        ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadTotalTimeoutMultiplier = readTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutConstant
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutConstant__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadTotalTimeoutConstant;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutConstant
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutConstant__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint readTotalTimeoutConstant) {
        ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->ReadTotalTimeoutConstant = readTotalTimeoutConstant;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutMultiplier
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutMultiplier__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->WriteTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutMultiplier
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutMultiplier__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint writeTotalTimeoutMultiplier) {
        ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->WriteTotalTimeoutMultiplier = writeTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutConstant
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutConstant__J
    (JNIEnv *env, jclass clazz, jlong baseAddress) {
        return ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->WriteTotalTimeoutConstant;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutConstant
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutConstant__JI
    (JNIEnv *env, jclass clazz, jlong baseAddress, jint writeTotalTimeoutConstant) {
        ((COMMTIMEOUTS*) (uintptr_t) baseAddress)->WriteTotalTimeoutConstant = writeTotalTimeoutConstant;
    }

#ifdef __cplusplus
}
#endif
#endif
