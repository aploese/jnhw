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
#include "de_ibapl_jnhw_posix_Signal_Mcontext_t.h"
#include "de_ibapl_jnhw_posix_Signal_Sigaction.h"
#include "de_ibapl_jnhw_posix_Signal_Sigevent.h"
#include "de_ibapl_jnhw_posix_Signal_Siginfo_t.h"
#include "de_ibapl_jnhw_posix_Signal_Sigset_t.h"
#include "de_ibapl_jnhw_posix_Signal_Sigval.h"
#include "de_ibapl_jnhw_posix_Signal_Stack_t.h"
#include "de_ibapl_jnhw_posix_Signal_Ucontext_t.h"

#ifdef __cplusplus
extern "C" {
#endif


#ifdef _POSIX_VERSION
#include <signal.h>
    //for offsetof
#include <stddef.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Mcontext_t
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Signal/Mcontext_t/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Mcontext_1t_native2Layout
#if defined(__OpenBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jclass layoutClass) {
        return NULL;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof ( mcontext_t), __alignof__ (mcontext_t));
        if (result == NULL) {
            return NULL;
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigaction
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Signal/Sigaction/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigaction_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (struct sigaction), __alignof__ (struct sigaction));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "sa_handler", offsetof(struct sigaction, sa_handler))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sa_mask", offsetof(struct sigaction, sa_mask))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sa_flags", offsetof(struct sigaction, sa_flags))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sa_sigaction", offsetof(struct sigaction, sa_sigaction))) {
            return result;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigevent
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Signal/Sigevent/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigevent_native2Layout
#if defined(__OpenBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jclass layoutClass) {
        return NULL;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (struct sigevent), __alignof__ (struct sigevent));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "sigev_notify", offsetof(struct sigevent, sigev_notify))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sigev_signo", offsetof(struct sigevent, sigev_signo))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sigev_value", offsetof(struct sigevent, sigev_value))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sigev_notify_function", offsetof(struct sigevent, sigev_notify_function))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sigev_notify_attributes", offsetof(struct sigevent, sigev_notify_attributes))) {
            return result;
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Siginfo_t
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Signal/Siginfo_t/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Siginfo_1t_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (siginfo_t), __alignof__ (siginfo_t));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "si_signo", offsetof(siginfo_t, si_signo))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "si_code", offsetof(siginfo_t, si_code))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "si_errno", offsetof(siginfo_t, si_errno))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "si_pid", offsetof(siginfo_t, si_pid))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "si_uid", offsetof(siginfo_t, si_uid))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "si_addr", offsetof(siginfo_t, si_addr))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "si_status", offsetof(siginfo_t, si_status))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "si_band", offsetof(siginfo_t, si_band))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "si_value", offsetof(siginfo_t, si_value))) {
            return result;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigset_t
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Signal/Sigset_t/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigset_1t_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (sigset_t), __alignof__ (sigset_t));
        if (result == NULL) {
            return NULL;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Sigval
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Signal/Sigval/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Sigval_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (union sigval), __alignof__ (union sigval));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "sival_int", offsetof(union sigval, sival_int))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "sival_ptr", offsetof(union sigval, sival_ptr))) {
            return result;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Stack_t
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Signal/Stack_t/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Stack_1t_native2Layout
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (stack_t), __alignof__ (stack_t));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "ss_sp", offsetof(stack_t, ss_sp))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "ss_size", offsetof(stack_t, ss_size))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "ss_flags", offsetof(stack_t, ss_flags))) {
            return result;
        }
        return result;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal_Ucontext_t
     * Method:    native2Layout
     * Signature: (Ljava/lang/Class;)Lde/ibapl/jnhw/posix/Signal/Ucontext_t/Layout;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_00024Ucontext_1t_native2Layout
#if defined(__APPLE__) || defined(__OpenBSD__)
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jclass layoutClass) {
        return NULL;
#elif defined(__FreeBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (ucontext_t), __alignof__ (ucontext_t));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "uc_link", offsetof(ucontext_t, uc_link))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "uc_sigmask", offsetof(ucontext_t, uc_sigmask))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "uc_stack", offsetof(ucontext_t, uc_stack))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "uc_mcontext", offsetof(ucontext_t, uc_mcontext))) {
            return result;
        }
        return result;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jclass layoutClass) {
        jobject result = JnhwCreateStructLayout(env, layoutClass, sizeof (struct ucontext_t), __alignof__ (struct ucontext_t));
        if (result == NULL) {
            return NULL;
        }
        if (JnhwSetLongField(env, result, "uc_link", offsetof(struct ucontext_t, uc_link))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "uc_sigmask", offsetof(struct ucontext_t, uc_sigmask))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "uc_stack", offsetof(struct ucontext_t, uc_stack))) {
            return result;
        }
        if (JnhwSetLongField(env, result, "uc_mcontext", offsetof(struct ucontext_t, uc_mcontext))) {
            return result;
        }
        return result;
#endif
    }

#endif
#ifdef __cplusplus
}
#endif
