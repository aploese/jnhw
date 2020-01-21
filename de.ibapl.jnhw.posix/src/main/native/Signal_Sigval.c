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
#include "de_ibapl_jnhw_posix_Signal_Sigval.h"

#ifdef HAVE_SIGNAL_H

#include <signal.h>
#include <unistd.h>

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     de_ibapl_jnhw_posix_Signal_Sigval
 * Method:    sival_ptr0
 * Signature: (Lde/ibapl/jnhw/OpaqueMemory;)V
 */
JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_sival_1ptr0__Lde_ibapl_jnhw_OpaqueMemory_2
    (__attribute__ ((unused)) JNIEnv *env, jobject unionSigval, jobject sival_ptr) {
        (UNWRAP_UNION_SIGVAL_PTR(unionSigval))->sival_ptr = UNWRAP_OPAQUE_MEM_TO_VOID_PTR_OR_NULL(sival_ptr);
    }

/*
 * Class:     de_ibapl_jnhw_posix_Signal_Sigval
 * Method:    sival_ptr0
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_sival_1ptr0__
    (__attribute__ ((unused)) JNIEnv *env, jobject unionSigval) {
        return (intptr_t)(UNWRAP_UNION_SIGVAL_PTR(unionSigval))->sival_ptr;
    }


        /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigval
     * Method:    sizeofSigval
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_sizeofSigval
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (union sigval);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigval
     * Method:    sival_int
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_sival_1int__
    (__attribute__ ((unused)) JNIEnv *env, jobject unionSigval) {
        return (UNWRAP_UNION_SIGVAL_PTR(unionSigval))->sival_int;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigval
     * Method:    sival_int
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_sival_1int__I
    (__attribute__ ((unused)) JNIEnv *env, jobject unionSigval, jint sival_int) {
        (UNWRAP_UNION_SIGVAL_PTR(unionSigval))->sival_int = sival_int;
    }

#ifdef __cplusplus
}
#endif
#endif
