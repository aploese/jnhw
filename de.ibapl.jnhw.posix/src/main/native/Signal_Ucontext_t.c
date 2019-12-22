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
#include "de_ibapl_jnhw_posix_Signal_Ucontext_t.h"

#ifdef HAVE_SIGNAL_H

#include <signal.h>
//for offsetof
#include <stddef.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    sizeofUcontext_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_sizeofUcontext_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct ucontext_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    _uc_sigmask_Offset
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t__1uc_1sigmask_1Offset
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct ucontext_t, uc_sigmask);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    _uc_stack_Offset
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t__1uc_1stack_1Offset
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct ucontext_t, uc_stack);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    uc_link
     * Signature: ()Lde/ibapl/jnhw/posix/Signal$Ucontext_t;
     * /
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_uc_1link__
    (__attribute__ ((unused)) JNIEnv *env, jobject structUcontext_t) {
        return (UNWRAP_STRUCT_UCONTEXT_T_PTR(structUcontext_t))->uc_link;
    }

    / *
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    uc_link
     * Signature: (Lde/ibapl/jnhw/posix/Signal$Ucontext_t;)V
     * /
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_uc_1link__Lde_ibapl_jnhw_posix_Signal_00024Ucontext_1t_2
    (__attribute__ ((unused)) JNIEnv *env, jobject structUcontext_t, jobject uc_link) {
        (UNWRAP_STRUCT_UCONTEXT_T_PTR(structUcontext_t))->uc_link = uc_link;
    }

/ *
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    uc_mcontext
     * Signature: ()Lde/ibapl/jnhw/posix/Signal$Mcontext_t;
     * /
JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_uc_1mcontext__
    (__attribute__ ((unused)) JNIEnv *env, jobject structUcontext_t) {
        return (UNWRAP_STRUCT_UCONTEXT_T_PTR(structUcontext_t))->uc_mcontext;
    }

/ *
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    uc_mcontext
     * Signature: (Lde/ibapl/jnhw/posix/Signal$Mcontext_t;)V
     * /
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_uc_1mcontext__Lde_ibapl_jnhw_posix_Signal_00024Mcontext_1t_2
    (__attribute__ ((unused)) JNIEnv *env, jobject structUcontext_t, jint uc_mcontext) {
        (UNWRAP_STRUCT_UCONTEXT_T_PTR(structUcontext_t))->uc_mcontext = uc_mcontext;
    }
     */
#ifdef __cplusplus
}
#endif
#endif
