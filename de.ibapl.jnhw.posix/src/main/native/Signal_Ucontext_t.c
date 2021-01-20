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
#include "de_ibapl_jnhw_posix_Signal_Ucontext_t.h"

#ifdef __cplusplus
extern "C" {
#endif


#ifdef _POSIX_VERSION
#include <signal.h>
    //for offsetof
#include <stddef.h>
#include <unistd.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_sizeof
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct ucontext_t");
        return -1;
#elif defined(__FreeBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (ucontext_t);
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct ucontext_t);
#endif    
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_alignof
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct ucontext_t");
        return -1;
#elif defined(__FreeBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (ucontext_t);
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct ucontext_t);
#endif    
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    offsetof_Uc_sigmask
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_offsetof_1Uc_1sigmask
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct ucontext_t");
        return -1;
#elif defined(__FreeBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(ucontext_t, uc_sigmask);
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct ucontext_t, uc_sigmask);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    offsetof_Uc_stack
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_offsetof_1Uc_1stack
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct ucontext_t");
        return -1;
#elif defined(__FreeBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(ucontext_t, uc_stack);
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct ucontext_t, uc_stack);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    offsetof_Uc_mcontext
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_offsetof_1Uc_1mcontext
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        throw_NoSuchNativeTypeException(env, "struct ucontext_t");
        return -1;
#elif defined(__FreeBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(ucontext_t, uc_mcontext);
#else
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct ucontext_t, uc_mcontext);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    uc_link0
     * Signature: ()Lde/ibapl/jnhw/common/memory/NativeAddressHolder;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_uc_1link0
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jobject structUcontext_t) {
        throw_NoSuchNativeTypeException(env, "struct ucontext_t");
        return NULL;
#else
    (JNIEnv *env, jobject structUcontext_t) {
        return CREATE_NATIVE_ADDRESS_HOLDER((intptr_t) (UNWRAP_STRUCT_UCONTEXT_T_PTR(structUcontext_t))->uc_link);
#endif
    }

#endif

#ifdef __cplusplus
}
#endif
