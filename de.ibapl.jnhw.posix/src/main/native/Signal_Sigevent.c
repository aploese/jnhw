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
#include "de_ibapl_jnhw_posix_Signal_Sigevent.h"

#if defined(HAVE_SIGNAL_H) && defined(_POSIX_VERSION)

#include <signal.h>
//for offsetof
#include <stddef.h>
#include <unistd.h>
#include <stdint.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    _sigev_value_Offset
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent__1sigev_1value_1Offset
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct sigevent, sigev_value);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sizeofSigevent
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sizeofSigevent
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct sigevent);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify__
    (JNIEnv *env, jobject structSigevent) {
        return (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify__I
    (JNIEnv *env, jobject structSigevent, jint value) {
        (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify = value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_signo
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1signo__
    (JNIEnv *env, jobject structSigevent) {
        return (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_signo;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_signo
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1signo__I
    (JNIEnv *env, jobject structSigevent, jint value) {
        (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_signo = value;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify_attributes
     * Signature: ()Lde/ibapl/jnhw/NativeAddressHolder;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify_1attributes
    (JNIEnv *env, jobject structSigevent) {
        return CREATE_NATIVE_ADDRESS_HOLDER((intptr_t) (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify_attributes);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify_attributes0
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_attr_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify_1attributes0
    (JNIEnv *env, jobject structSigevent, jobject value) {
        (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify_attributes = UNWRAP_PTHREAD_ATTR_T_PTR_OR_NULL(value);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify_function
     * Signature: ()Lde/ibapl/jnhw/NativeFunctionPointer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify_1function
    (JNIEnv *env, jobject structSigevent) {
        return CREATE_NATIVE_FUNCTION_POINTER((intptr_t) (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify_function);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify_function0
     * Signature: (Lde/ibapl/jnhw/NativeFunctionPointer;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify_1function0__Lde_ibapl_jnhw_NativeFunctionPointer_2
    (JNIEnv *env, jobject structSigevent, jobject value) {
        (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify_function = UNWRAP_NATIVE_FUNCTION_POINTER(value);
    }

#ifdef __cplusplus
}
#endif
#endif
