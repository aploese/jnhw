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
#include "de_ibapl_jnhw_posix_SignalTest_NativeMcontext_t.h"
#include "de_ibapl_jnhw_posix_SignalTest_NativeSigaction.h"
#include "de_ibapl_jnhw_posix_SignalTest_NativeSigevent.h"
#include "de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t.h"
#include "de_ibapl_jnhw_posix_SignalTest_NativeSigset_t.h"
#include "de_ibapl_jnhw_posix_SignalTest_NativeSigval.h"
#include "de_ibapl_jnhw_posix_SignalTest_NativeStack_t.h"
#include "de_ibapl_jnhw_posix_SignalTest_NativeUcontext_t.h"

#ifdef __cplusplus
extern "C" {
#endif


#ifdef _POSIX_VERSION
#include <signal.h>
    //for offsetof
#include <stddef.h>

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeMcontext_t
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeMcontext_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return 0;
#else
        return __alignof__ (mcontext_t);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeMcontext_t
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeMcontext_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return 0;
#else
        return sizeof (mcontext_t);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigaction
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigaction_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (struct sigaction);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigaction
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigaction_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (struct sigaction);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigaction
     * Method:    sa_handler
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigaction_sa_1handler
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct sigaction, sa_handler);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigaction
     * Method:    sa_mask
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigaction_sa_1mask
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct sigaction, sa_mask);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigaction
     * Method:    sa_flags
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigaction_sa_1flags
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct sigaction, sa_flags);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigaction
     * Method:    sa_sigaction
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigaction_sa_1sigaction
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(struct sigaction, sa_sigaction);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigevent
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigevent_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return 0;
#else
        return __alignof__ (struct sigevent);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigevent
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigevent_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return 0;
#else
        return sizeof (struct sigevent);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigevent
     * Method:    sigev_notify
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigevent_sigev_1notify
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return 0;
#else
        return offsetof(struct sigevent, sigev_notify);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigevent
     * Method:    sigev_signo
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigevent_sigev_1signo
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return 0;
#else
        return offsetof(struct sigevent, sigev_signo);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigevent
     * Method:    sigev_value
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigevent_sigev_1value
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return 0;
#else
        return offsetof(struct sigevent, sigev_value);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigevent
     * Method:    sigev_notify_function
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigevent_sigev_1notify_1function
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return 0;
#else
        return offsetof(struct sigevent, sigev_notify_function);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigevent
     * Method:    sigev_notify_attributes
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigevent_sigev_1notify_1attributes
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
        return 0;
#else
        return offsetof(struct sigevent, sigev_notify_attributes);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (siginfo_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (siginfo_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    si_signo
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_si_1signo
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(siginfo_t, si_signo);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    si_code
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_si_1code
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(siginfo_t, si_code);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    si_errno
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_si_1errno
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(siginfo_t, si_errno);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    si_pid
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_si_1pid
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(siginfo_t, si_pid);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    si_uid
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_si_1uid
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(siginfo_t, si_uid);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    si_addr
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_si_1addr
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(siginfo_t, si_addr);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    si_status
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_si_1status
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(siginfo_t, si_status);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    si_band
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_si_1band
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(siginfo_t, si_band);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSiginfo_t
     * Method:    si_value
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSiginfo_1t_si_1value
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(siginfo_t, si_value);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigset_t
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigset_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (sigset_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigset_t
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigset_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (sigset_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigval
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigval_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (union sigval);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigval
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigval_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (union sigval);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigval
     * Method:    sival_int
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigval_sival_1int
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(union sigval, sival_int);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeSigval
     * Method:    sival_ptr
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeSigval_sival_1ptr
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(union sigval, sival_ptr);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeStack_t
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeStack_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return __alignof__ (stack_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeStack_t
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeStack_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return sizeof (stack_t);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeStack_t
     * Method:    ss_sp
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeStack_1t_ss_1sp
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(stack_t, ss_sp);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeStack_t
     * Method:    ss_size
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeStack_1t_ss_1size
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(stack_t, ss_size);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeStack_t
     * Method:    ss_flags
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeStack_1t_ss_1flags
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return offsetof(stack_t, ss_flags);
    }

        /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeUcontext_t
     * Method:    alignof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeUcontext_1t_alignof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__OpenBSD__)
        return 0;
#elif defined(__FreeBSD__)
        return __alignof__ (ucontext_t);
#else
        return __alignof__ (struct ucontext_t);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeUcontext_t
     * Method:    sizeof
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeUcontext_1t_sizeof
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__OpenBSD__)
        return 0;
#elif defined(__FreeBSD__)
        return sizeof (ucontext_t);
#else
        return sizeof (struct ucontext_t);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeUcontext_t
     * Method:    uc_link
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeUcontext_1t_uc_1link
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__OpenBSD__)
        return 0;
#elif defined(__FreeBSD__)
        return offsetof(ucontext_t, uc_link);
#else
        return offsetof(struct ucontext_t, uc_link);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeUcontext_t
     * Method:    uc_sigmask
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeUcontext_1t_uc_1sigmask
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__OpenBSD__)
        return 0;
#elif defined(__FreeBSD__)
        return offsetof(ucontext_t, uc_sigmask);
#else
        return offsetof(struct ucontext_t, uc_sigmask);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeUcontext_t
     * Method:    uc_stack
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeUcontext_1t_uc_1stack
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__OpenBSD__)
        return 0;
#elif defined(__FreeBSD__)
        return offsetof(ucontext_t, uc_stack);
#else
        return offsetof(struct ucontext_t, uc_stack);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeUcontext_t
     * Method:    uc_mcontext
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeUcontext_1t_uc_1mcontext
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__OpenBSD__)
        return 0;
#elif defined(__FreeBSD__)
        return offsetof(ucontext_t, uc_mcontext);
#else
        return offsetof(struct ucontext_t, uc_mcontext);
#endif
    }

#endif
#ifdef __cplusplus
}
#endif
