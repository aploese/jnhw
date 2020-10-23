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
#include "de_ibapl_jnhw_posix_Signal_Stack_t.h"

#ifdef __cplusplus
extern "C" {
#endif


#ifdef _POSIX_VERSION
#include <signal.h>
#include <stdint.h>


    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Stack_t
     * Method:    sizeofStack_t
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Stack_1t_sizeofStack_1t
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (stack_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Stack_t
     * Method:    ss_sp0
     * Signature: ()Lde/ibapl/jnhw/NativeAddressHolder;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Stack_1t_ss_1sp0
    (JNIEnv *env, jobject structStack_t) {
        return CREATE_NATIVE_ADDRESS_HOLDER((intptr_t) (UNWRAP_STACK_T_PTR(structStack_t))->ss_sp);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Stack_t
     * Method:    ss_flags
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Stack_1t_ss_1flags__I
    (JNIEnv *env, jobject structStack_t, jint ss_flags) {
        (UNWRAP_STACK_T_PTR(structStack_t))->ss_flags = ss_flags;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Stack_t
     * Method:    ss_size
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Stack_1t_ss_1size__J
    (JNIEnv *env, jobject structStack_t, jlong ss_size) {
        if (ss_size < 0) {
            throw_IndexOutOfBoundsException(env, "In ss_size < 0");
            return;
        }
#if defined(__LP64__)
        (UNWRAP_STACK_T_PTR(structStack_t))->ss_size = (uint64_t) ss_size;
#else
        if (ss_size > INT32_MAX) {
            throw_IndexOutOfBoundsException(env, "In this native implementation ss_size is only an integer with the size of jint");
            return;
        }
        (UNWRAP_STACK_T_PTR(structStack_t))->ss_size = (uint32_t) ss_size;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Stack_t
     * Method:    ss_size
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Stack_1t_ss_1size__
    (JNIEnv *env, jobject structStack_t) {
        return (int64_t) (UNWRAP_STACK_T_PTR(structStack_t))->ss_size;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Stack_t
     * Method:    ss_flags
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Stack_1t_ss_1flags__
    (JNIEnv *env, jobject structStack_t) {
        return (UNWRAP_STACK_T_PTR(structStack_t))->ss_flags;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Stack_t
     * Method:    ss_sp
     * Signature: (Lde/ibapl/jnhw/OpaqueMemory;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Stack_1t_ss_1sp
    (JNIEnv *env, jobject structStack_t, jobject ss_sp) {
        (UNWRAP_STACK_T_PTR(structStack_t))->ss_sp = UNWRAP_OPAQUE_MEM_TO_VOID_PTR_OR_NULL(ss_sp);
    }



#endif
#ifdef __cplusplus
}
#endif
