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
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Signal_Siginfo_t.h"

#ifdef __cplusplus
extern "C" {
#endif


#ifdef _POSIX_VERSION
#include <signal.h>
//for offsetof
#include <stddef.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Siginfo_t
     * Method:    sizeofSiginfo_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Siginfo_1t_sizeofSiginfo_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (siginfo_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Siginfo_t
     * Method:    _si_value_Offset
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Siginfo_1t__1si_1value_1Offset
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(siginfo_t, si_value);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Siginfo_t
     * Method:    si_signo
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Siginfo_1t_si_1signo
    (JNIEnv *env, jobject structSiginfo_t) {
        return (UNWRAP_SIGINFO_T_PTR(structSiginfo_t))->si_signo;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Siginfo_t
     * Method:    si_code
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Siginfo_1t_si_1code
    (JNIEnv *env, jobject structSiginfo_t) {
        return (UNWRAP_SIGINFO_T_PTR(structSiginfo_t))->si_code;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Siginfo_t
     * Method:    si_errno
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Siginfo_1t_si_1errno
    (JNIEnv *env, jobject structSiginfo_t) {
        return (UNWRAP_SIGINFO_T_PTR(structSiginfo_t))->si_errno;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Siginfo_t
     * Method:    si_pid
     * Signature: ()I;
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Siginfo_1t_si_1pid
    (JNIEnv *env, jobject structSiginfo_t) {
        return (UNWRAP_SIGINFO_T_PTR(structSiginfo_t))->si_pid;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Siginfo_t
     * Method:    si_addr
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Siginfo_1t_si_1addr
    (JNIEnv *env, jobject structSiginfo_t) {
        return (intptr_t) (UNWRAP_SIGINFO_T_PTR(structSiginfo_t))->si_addr;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Siginfo_t
     * Method:    si_status
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Siginfo_1t_si_1status
    (JNIEnv *env, jobject structSiginfo_t) {
        return (UNWRAP_SIGINFO_T_PTR(structSiginfo_t))->si_status;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Siginfo_t
     * Method:    si_band
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Siginfo_1t_si_1band
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structSiginfo_t) {
        throw_NoSuchNativeTypeMemberException(env, "struct siginfo_t", "si_band");
        return -1;
#else
    (JNIEnv *env, jobject structSiginfo_t) {
        return (UNWRAP_SIGINFO_T_PTR(structSiginfo_t))->si_band;
#endif
    }

#endif
#ifdef __cplusplus
}
#endif