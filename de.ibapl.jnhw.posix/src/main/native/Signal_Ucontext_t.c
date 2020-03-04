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
#include <unistd.h>

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
 * Method:    _uc_mcontext_Offset
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t__1uc_1mcontext_1Offset
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct ucontext_t, uc_mcontext);
    }
    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    uc_link0
     * Signature: ()Lde/ibapl/jnhw/NativeAddressHolder;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_uc_1link0
    (JNIEnv *env, jobject structUcontext_t) {
        return CREATE_NATIVE_ADDRESS_HOLDER((intptr_t)(UNWRAP_STRUCT_UCONTEXT_T_PTR(structUcontext_t))->uc_link);
    }

#ifdef __cplusplus
}
#endif
#endif
