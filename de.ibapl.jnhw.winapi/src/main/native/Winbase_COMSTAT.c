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
#include "de_ibapl_jnhw_winapi_Winbase_COMSTAT.h"

#ifdef HAVE_WINBASE_H
#include <winbase.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (COMSTAT);
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    fCtsHold
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fCtsHold
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMSTAT(this))->fCtsHold;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    fDsrHold
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fDsrHold
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMSTAT(this))->fDsrHold;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    fRlsdHold
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fRlsdHold
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMSTAT(this))->fRlsdHold;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    fXoffHold
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fXoffHold
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMSTAT(this))->fXoffHold;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    fXoffSent
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fXoffSent
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMSTAT(this))->fXoffSent;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    fEof
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fEof
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMSTAT(this))->fEof;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    fTxim
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fTxim
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMSTAT(this))->fTxim;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    fReserved
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_fReserved
    (JNIEnv *env, jobject this) {
        return (UNWRAP_COMSTAT(this))->fReserved;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    cbInQue
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_cbInQue
    (JNIEnv *env, jobject this) {
        return (int32_t) (UNWRAP_COMSTAT(this))->cbInQue;
    }

    /*
     * Class:     de_ibapl_jnhw_winapi_Winbase_COMSTAT
     * Method:    cbOutQue
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_winapi_Winbase_00024COMSTAT_cbOutQue
    (JNIEnv *env, jobject this) {
        return (int32_t) (UNWRAP_COMSTAT(this))->cbOutQue;
    }

#ifdef __cplusplus
}
#endif
#endif
