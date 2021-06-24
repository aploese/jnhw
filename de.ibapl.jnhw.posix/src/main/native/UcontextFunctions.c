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


#if HAVE_UCONTEXT_H
#include <ucontext.h>
#endif

#ifdef _POSIX_VERSION

#include "de_ibapl_jnhw_x_open_Ucontext.h"
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_x_open_Ucontext
     * Method:    getcontext
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_x_1open_Ucontext_getcontext
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong ptrUcp) {
        throw_NoSuchNativeMethodException(env, "getcontext");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrUcp) {
#if  defined(__FreeBSD__)
        if (getcontext((ucontext_t*) (uintptr_t) ptrUcp)) {
#else
        if (getcontext((struct ucontext_t*) (uintptr_t) ptrUcp)) {
#endif
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_x_open_Ucontext
     * Method:    setcontext
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_x_1open_Ucontext_setcontext
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong ptrUcp) {
        throw_NoSuchNativeMethodException(env, "setcontext");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrUcp) {
#if  defined(__FreeBSD__)
        if (setcontext((ucontext_t*) (uintptr_t) ptrUcp)) {
#else
        if (setcontext((struct ucontext_t*) (uintptr_t) ptrUcp)) {
#endif
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_x_open_Ucontext
     * Method:    swapcontext
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_x_1open_Ucontext_swapcontext
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong ptrOucp, __attribute__ ((unused)) jlong ptrUcp) {
        throw_NoSuchNativeMethodException(env, "swapcontext");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrOucp, jlong ptrUcp) {
#if  defined(__FreeBSD__)
        if (swapcontext((ucontext_t*) (uintptr_t) ptrOucp, (ucontext_t*) (uintptr_t) ptrUcp)) {
#else
        if (swapcontext((struct ucontext_t*) (uintptr_t) ptrOucp, (struct ucontext_t*) (uintptr_t) ptrUcp)) {
#endif
            throw_NativeErrorException(env, errno);
        }
#endif
    }

#ifdef __cplusplus
}
#endif
#endif
