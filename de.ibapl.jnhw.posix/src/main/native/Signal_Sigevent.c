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
#include "jnhw-posix.h"
#include "de_ibapl_jnhw_posix_Signal_Sigevent.h"

#ifdef __cplusplus
extern "C" {
#endif


#ifdef _POSIX_VERSION
#include <signal.h>
    //for offsetof
#include <stddef.h>
#include <unistd.h>
#include <stdint.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    offsetof_Sigev_value
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_offsetof_1Sigev_1value
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
        return -1;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct sigevent, sigev_value);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sizeof
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
        return -1;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct sigevent);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_alignof
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
        return -1;
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct sigevent);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify__
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structSigevent) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
        return -1;
#else
    (JNIEnv *env, jobject structSigevent) {
        return (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify__I
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structSigevent, __attribute__ ((unused)) jint value) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
#else
    (JNIEnv *env, jobject structSigevent, jint value) {
        (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify = value;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_signo
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1signo__
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structSigevent) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
        return -1;
#else
    (JNIEnv *env, jobject structSigevent) {
        return (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_signo;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_signo
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1signo__I
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structSigevent, __attribute__ ((unused)) jint value) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
#else
    (JNIEnv *env, jobject structSigevent, jint value) {
        (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_signo = value;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify_attributes
     * Signature: ()Lde/ibapl/jnhw/common/memory/NativeAddressHolder;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify_1attributes
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structSigevent) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
        return NULL;
#else
    (JNIEnv *env, jobject structSigevent) {
        return CREATE_NativeAddressHolder((intptr_t) (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify_attributes);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify_attributes0
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_attr_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify_1attributes0
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structSigevent, __attribute__ ((unused)) jobject value) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
#else
    (JNIEnv *env, jobject structSigevent, jobject value) {
        (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify_attributes = UNWRAP_PTHREAD_ATTR_T_PTR_OR_NULL(value);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify_function
     * Signature: ()Lde/ibapl/jnhw/common/memory/NativeFunctionPointer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify_1function
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structSigevent) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
        return NULL;
#else
    (JNIEnv *env, jobject structSigevent) {
        return CREATE_NativeFunctionPointer((intptr_t) (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify_function);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    sigev_notify_function0
     * Signature: (Lde/ibapl/jnhw/common/memory/NativeFunctionPointer;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_sigev_1notify_1function0
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structSigevent, __attribute__ ((unused)) jobject value) {
        throw_NoSuchNativeTypeException(env, "struct sigevent");
#else
    (JNIEnv *env, jobject structSigevent, jobject value) {
        (UNWRAP_STRUCT_SIGEVENT_PTR(structSigevent))->sigev_notify_function = UNWRAP_NativeFunctionPointer_TO(void (*) (union sigval), value);
#endif
    }

#ifdef __cplusplus
}
#endif
#endif
