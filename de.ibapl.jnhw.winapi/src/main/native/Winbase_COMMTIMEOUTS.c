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
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (COMMTIMEOUTS);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadIntervalTimeout
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadIntervalTimeout__
    (JNIEnv *env, jobject this) {
         return (int32_t)(UNWRAP_COMMTIMEOUTS(this))->ReadIntervalTimeout;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadIntervalTimeout
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadIntervalTimeout__I
    (JNIEnv *env, jobject this, jint readIntervalTimeout) {
        if (readIntervalTimeout < 0) {
            throw_IllegalArgumentException(env, "readIntervalTimeout must not < 0");
        }
        (UNWRAP_COMMTIMEOUTS(this))->ReadIntervalTimeout = (uint32_t)readIntervalTimeout;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutMultiplier
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutMultiplier__
    (JNIEnv *env, jobject this) {
        return (int32_t)(UNWRAP_COMMTIMEOUTS(this))->ReadTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutMultiplier
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutMultiplier__I
    (JNIEnv *env, jobject this, jint readTotalTimeoutMultiplier) {
        if (readTotalTimeoutMultiplier < 0) {
            throw_IllegalArgumentException(env, "readTotalTimeoutMultiplier must not < 0");
        }
        (UNWRAP_COMMTIMEOUTS(this))->ReadTotalTimeoutMultiplier = (uint32_t)readTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutConstant
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutConstant__
    (JNIEnv *env, jobject this) {
        return (int32_t)(UNWRAP_COMMTIMEOUTS(this))->ReadTotalTimeoutConstant;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    ReadTotalTimeoutConstant
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_ReadTotalTimeoutConstant__I
    (JNIEnv *env, jobject this, jint readTotalTimeoutConstant) {
        if (readTotalTimeoutConstant < 0) {
            throw_IllegalArgumentException(env, "readTotalTimeoutConstant must not < 0");
        }
        (UNWRAP_COMMTIMEOUTS(this))->ReadTotalTimeoutConstant = (uint32_t)readTotalTimeoutConstant;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutMultiplier
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutMultiplier__
    (JNIEnv *env, jobject this) {
        return (int32_t)(UNWRAP_COMMTIMEOUTS(this))->WriteTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutMultiplier
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutMultiplier__I
    (JNIEnv *env, jobject this, jint writeTotalTimeoutMultiplier) {
        if (writeTotalTimeoutMultiplier < 0) {
            throw_IllegalArgumentException(env, "writeTotalTimeoutMultiplier must not < 0");
        }
        (UNWRAP_COMMTIMEOUTS(this))->WriteTotalTimeoutMultiplier = (uint32_t)writeTotalTimeoutMultiplier;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutConstant
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutConstant__
    (JNIEnv *env, jobject this) {
        return (int32_t)(UNWRAP_COMMTIMEOUTS(this))->WriteTotalTimeoutConstant;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMMTIMEOUTS
     * Method:    WriteTotalTimeoutConstant
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMMTIMEOUTS_WriteTotalTimeoutConstant__I
    (JNIEnv *env, jobject this, jint writeTotalTimeoutConstant) {
        if (writeTotalTimeoutConstant < 0) {
            throw_IllegalArgumentException(env, "writeTotalTimeoutConstant must not < 0");
        }
        (UNWRAP_COMMTIMEOUTS(this))->WriteTotalTimeoutConstant = (uint32_t)writeTotalTimeoutConstant;
    }

#ifdef __cplusplus
}
#endif
#endif
