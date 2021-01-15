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
#include "de_ibapl_jnhw_posix_Signal_Sigval.h"

#ifdef __cplusplus
extern "C" {
#endif


#ifdef _POSIX_VERSION
#include <signal.h>
#include <unistd.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigval
     * Method:    sival_ptr
     * Signature: ()Lde/ibapl/jnhw/common/memory/NativeAddressHolder;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_sival_1ptr
    (__attribute__ ((unused)) JNIEnv *env, jobject unionSigval) {
        return CREATE_NATIVE_ADDRESS_HOLDER((intptr_t) (UNWRAP_UNION_SIGVAL_PTR(unionSigval))->sival_ptr);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigval
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (union sigval);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigval
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (union sigval);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigval
     * Method:    sival_int
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_sival_1int__
    (JNIEnv *env, jobject unionSigval) {
        return (UNWRAP_UNION_SIGVAL_PTR(unionSigval))->sival_int;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigval
     * Method:    sival_int
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_sival_1int__I
    (JNIEnv *env, jobject unionSigval, jint sival_int) {
        (UNWRAP_UNION_SIGVAL_PTR(unionSigval))->sival_int = sival_int;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigval
     * Method:    sival_ptr0
     * Signature: (Lde/ibapl/jnhw/common/memory/OpaqueMemory32;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_sival_1ptr0
    (JNIEnv *env, jobject unionSigval, jobject sival_ptr) {
        (UNWRAP_UNION_SIGVAL_PTR(unionSigval))->sival_ptr = UNWRAP_OPAQUE_MEM_TO_VOID_PTR_OR_NULL(sival_ptr);
    }

#ifdef __cplusplus
}
#endif
#endif

