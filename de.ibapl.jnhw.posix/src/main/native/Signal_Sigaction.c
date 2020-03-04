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
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Signal_Sigaction.h"

#ifdef HAVE_SIGNAL_H

#include <signal.h>
//for offsetof
#include <stddef.h>
#include <stdint.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sizeofSigaction
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sizeofSigaction
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct sigaction);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    _sa_mask_Offset
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction__1sa_1mask_1Offset
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct sigaction, sa_mask);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sa_flags
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sa_1flags__
    (JNIEnv *env, jobject structSigaction) {
        return (UNWRAP_STRUCT_SIGACTION_PTR(structSigaction))->sa_flags;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sa_flags
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sa_1flags__I
    (JNIEnv *env, jobject structSigaction, jint sa_flags) {
        (UNWRAP_STRUCT_SIGACTION_PTR(structSigaction))->sa_flags = sa_flags;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sa_handler0
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sa_1handler0__
    (JNIEnv *env, jobject structSigaction) {
        return (intptr_t) (UNWRAP_STRUCT_SIGACTION_PTR(structSigaction))->sa_handler;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sa_handler0
     * Signature: (Lde/ibapl/jnhw/Callback_I_V;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sa_1handler0__Lde_ibapl_jnhw_Callback_1I_1V_2
    (JNIEnv *env, jobject structSigaction, jobject value) {
        (UNWRAP_STRUCT_SIGACTION_PTR(structSigaction))->sa_handler = UNWRAP_NATIVE_FUNCTION_POINTER(value);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sa_sigaction0
     * Signature: (Lde/ibapl/jnhw/Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sa_1sigaction0__Lde_ibapl_jnhw_Callback_1I_1PtrOpaqueMemory_1PtrOpaqueMemory_1V_2
    (JNIEnv *env, jobject structSigaction, jobject value) {
        (UNWRAP_STRUCT_SIGACTION_PTR(structSigaction))->sa_sigaction = UNWRAP_NATIVE_FUNCTION_POINTER(value);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sa_sigaction0
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sa_1sigaction0__
    (JNIEnv *env, jobject structSigaction) {
        return (intptr_t) (UNWRAP_STRUCT_SIGACTION_PTR(structSigaction))->sa_sigaction;
    }

#ifdef __cplusplus
}
#endif
#endif
