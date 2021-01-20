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
#include "de_ibapl_jnhw_posix_Signal_Sigaction.h"

#ifdef __cplusplus
extern "C" {
#endif


#ifdef _POSIX_VERSION
#include <signal.h>
//for offsetof
#include <stddef.h>
#include <stdint.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct sigaction);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct sigaction);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    offsetof_Sa_mask
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_offsetof_1Sa_1mask
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
     * Method:    sa_handler
     * Signature: ()Lde/ibapl/jnhw/common/memory/NativeFunctionPointer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sa_1handler
    (JNIEnv *env, jobject structSigaction) {
        return CREATE_NATIVE_FUNCTION_POINTER((intptr_t) (UNWRAP_STRUCT_SIGACTION_PTR(structSigaction))->sa_handler);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sa_handler0
     * Signature: (Lde/ibapl/jnhw/common/callbacks/Callback_I_V;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sa_1handler0__Lde_ibapl_jnhw_common_callbacks_Callback_1I_1V_2
    (JNIEnv *env, jobject structSigaction, jobject value) {
        (UNWRAP_STRUCT_SIGACTION_PTR(structSigaction))->sa_handler = UNWRAP_NATIVE_FUNCTION_POINTER_TO(void (*) (jint), value);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sa_sigaction0
     * Signature: (Lde/ibapl/jnhw/common/callbacks/Callback_I_PtrAbstractNativeMemory_PtrAbstractNativeMemory_V;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sa_1sigaction0__Lde_ibapl_jnhw_common_callbacks_Callback_1I_1PtrAbstractNativeMemory_1PtrAbstractNativeMemory_1V_2
    (JNIEnv *env, jobject structSigaction, jobject value) {
        (UNWRAP_STRUCT_SIGACTION_PTR(structSigaction))->sa_sigaction = UNWRAP_NATIVE_FUNCTION_POINTER_TO(void (*) (jint, siginfo_t *, void *), value);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    sa_sigaction
     * Signature: ()Lde/ibapl/jnhw/common/memory/NativeFunctionPointer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_sa_1sigaction
    (JNIEnv *env, jobject structSigaction) {
        return CREATE_NATIVE_FUNCTION_POINTER((intptr_t) (UNWRAP_STRUCT_SIGACTION_PTR(structSigaction))->sa_sigaction);
    }

#endif    
#ifdef __cplusplus
}
#endif
