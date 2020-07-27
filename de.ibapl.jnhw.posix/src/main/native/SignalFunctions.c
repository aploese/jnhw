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
#include "de_ibapl_jnhw_posix_Signal.h"

#ifdef __cplusplus
extern "C" {
#endif


#ifdef _POSIX_VERSION
#include <signal.h>
#include <errno.h>
#include <stdio.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    kill
     * Signature: (II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_kill
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jint sig) {
        if (kill(pid, sig)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    killpg
     * Signature: (II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_killpg
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pgrp, jint sig) {
        if (killpg(pgrp, sig)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    psiginfo
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Siginfo_t;Ljava/lang/String;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_psiginfo
#if defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject pinfo, __attribute__ ((unused)) jstring message) {
        throw_NoSuchNativeMethodException(env, "psiginfo");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject pinfo, jstring message) {
        if (pinfo == NULL) {
            throw_NullPointerException(env, "pinfo is null");
            return;
        }
        const int old_errno = errno;
        const char* _message;
        if (message == NULL) {
            _message = NULL;
        } else {
            _message = (*env)->GetStringUTFChars(env, message, NULL);
        }
        errno = 0;
        psiginfo(UNWRAP_SIGINFO_T_PTR_OR_NULL(pinfo), _message);
        if (errno) {
            if (ferror(stderr)) {
                throw_NativeErrorException(env, errno);
            }
        }
        if (_message != NULL) {
            (*env)->ReleaseStringUTFChars(env, message, _message);
        }
        errno = old_errno;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    psignal
     * Signature: (ILjava/lang/String;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_psignal
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint signo, jstring message) {
        const int old_errno = errno;
        const char* _message;
        if (message == NULL) {
            _message = NULL;
        } else {
            _message = (*env)->GetStringUTFChars(env, message, NULL);
        }
        errno = 0;
#if defined(__APPLE__) || defined(__OpenBSD__)
        psignal((uint32_t)signo, _message);
#else
        psignal(signo, _message);
#endif
        if (errno) {
            if (ferror(stderr)) {
                throw_NativeErrorException(env, errno);
            }
        }
        if (_message != NULL) {
            (*env)->ReleaseStringUTFChars(env, message, _message);
        }
        errno = old_errno;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    pthread_kill
     * Signature: (Lde/ibapl/jnhw/posix/Pthread/Pthread_t;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_pthread_1kill
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jobject thread_id, __attribute__ ((unused)) jint sig) {
        throw_NoSuchNativeMethodException(env, "pthread_kill");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject thread_id, jint sig) {
        if (thread_id == NULL) {
            throw_NullPointerException(env, "thread_id is null");
            return;
        }
        if (pthread_kill(*UNWRAP_PTHREAD_T_PTR(thread_id), sig)) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    pthread_sigmask
     * Signature: (ILde/ibapl/jnhw/posix/Signal/Sigset_t;Lde/ibapl/jnhw/posix/Signal/Sigset_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_pthread_1sigmask
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint how, jobject set, jobject oset) {
        sigset_t *_set = UNWRAP_SIGSET_T_PTR_OR_NULL(set);
        sigset_t *_oset = UNWRAP_SIGSET_T_PTR_OR_NULL(oset);
        if (pthread_sigmask(how, _set, _oset)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    raise
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_raise
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig) {
        if (raise(sig)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigaction
     * Signature: (ILde/ibapl/jnhw/posix/Signal/Sigaction;Lde/ibapl/jnhw/posix/Signal/Sigaction;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigaction
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig, jobject act, jobject oact) {
        if (sigaction(sig, UNWRAP_STRUCT_SIGACTION_PTR_OR_NULL(act), UNWRAP_STRUCT_SIGACTION_PTR_OR_NULL(oact))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigaddset
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigaddset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject set, jint signo) {
        if (set == NULL) {
            throw_NullPointerException(env, "set is null");
            return;
        }
        if (sigaddset(UNWRAP_SIGSET_T_PTR(set), signo)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigaltstack
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Stack_t;Lde/ibapl/jnhw/posix/Signal/Stack_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigaltstack
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject ss, jobject oss) {
        if (sigaltstack(UNWRAP_STACK_T_PTR_OR_NULL(ss), UNWRAP_STACK_T_PTR_OR_NULL(oss))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigdelset
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigdelset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject set, jint signo) {
        if (set == NULL) {
            throw_NullPointerException(env, "set is null");
            return;
        }
        if (sigdelset(UNWRAP_OPAQUE_MEM_TO(sigset_t*, set), signo)) {
            throw_NativeErrorException(env, errno);
        }
        return;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigemptyset
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigemptyset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject set) {
        if (set == NULL) {
            throw_NullPointerException(env, "set is null");
            return;
        }
        if (sigemptyset(UNWRAP_OPAQUE_MEM_TO(sigset_t*, set))) {
            throw_NativeErrorException(env, errno);
        }
        return;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigfillset
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigfillset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject set) {
        if (set == NULL) {
            throw_NullPointerException(env, "set is null");
            return;
        }
        if (sigfillset(UNWRAP_OPAQUE_MEM_TO(sigset_t*, set))) {
            throw_NativeErrorException(env, errno);
        }
        return;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sighold
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sighold
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint sig) {
        throw_NoSuchNativeMethodException(env, "sighold");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig) {
        if (sighold(sig)) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigignore
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigignore
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint sig) {
        throw_NoSuchNativeMethodException(env, "sighold");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig) {
        if (sigignore(sig)) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    siginterrupt
     * Signature: (IZ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_siginterrupt
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig, jboolean flag) {
        if (siginterrupt(sig, flag)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigismember
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;I)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Signal_sigismember
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject set, jint signo) {
        if (set == NULL) {
            throw_NullPointerException(env, "set is null");
            return JNI_FALSE;
        }
        const int result = sigismember(UNWRAP_OPAQUE_MEM_TO(sigset_t*, set), signo);
        if (result == 0) {
            return JNI_FALSE;
        } else if (result == 1) {
            return JNI_TRUE;
        } else {
            throw_NativeErrorException(env, errno);
            return JNI_FALSE;
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    signal
     * Signature: (ILde/ibapl/jnhw/Callback_I_V;)Lde/ibapl/jnhw/Callback_I_V;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_signal
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig, jobject func) {
        void* result;
        if (func == NULL) {
            result = signal(sig, NULL);
        } else {
            result = signal(sig, UNWRAP_NATIVE_FUNCTION_POINTER_TO(void (*) (jint), func));
        }
        if (result == SIG_ERR) {
            throw_NativeErrorException(env, errno);
            return NULL;
        }
        return CREATE_NATIVE_FUNCTION_POINTER(result);
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigpause
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigpause
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint sig) {
        throw_NoSuchNativeMethodException(env, "sigpause");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig) {
        const int result = sigpause(sig);
        if (result == -1) {
            if (errno == EINTR) {
                return;
            } else {
                throw_NativeErrorException(env, errno);
            }
        } else {
            throw_Exception(env, "java/lang/RuntimeException", "Result of sigpause not excpected: %d", result);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigpending
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigpending
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject set) {
        if (set == NULL) {
            throw_NullPointerException(env, "set is null");
            return;
        }
        if (sigpending(UNWRAP_SIGSET_T_PTR(set))) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigprocmask
     * Signature: (ILde/ibapl/jnhw/posix/Signal/Sigset_t;Lde/ibapl/jnhw/posix/Signal/Sigset_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigprocmask
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint how, jobject set, jobject oset) {
        sigset_t *_set = UNWRAP_SIGSET_T_PTR_OR_NULL(set);
        sigset_t *_oset = UNWRAP_SIGSET_T_PTR_OR_NULL(oset);
        if (sigprocmask(how, _set, _oset)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigqueue
     * Signature: (IILde/ibapl/jnhw/posix/Signal/Sigval;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigqueue
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint pid, __attribute__ ((unused)) jint signo, __attribute__ ((unused)) jobject sigval) {
        throw_NoSuchNativeMethodException(env, "sigqueue");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jint signo, jobject sigval) {
        if (sigval == NULL) {
            throw_NullPointerException(env, "sigval is null");
            return;
        }
        if (sigqueue(pid, signo, *(UNWRAP_UNION_SIGVAL_PTR(sigval)))) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigrelse
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigrelse
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint sig) {
        throw_NoSuchNativeMethodException(env, "sigrelse");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig) {
        if (sigrelse(sig)) {
            throw_NativeErrorException(env, errno);
        }
#endif
    }

        /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigset
     * Signature: (ILde/ibapl/jnhw/Callback_I_V;)Lde/ibapl/jnhw/Callback_I_V;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_sigset
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass class, __attribute__ ((unused)) jint sig, __attribute__ ((unused)) jobject disp) {
        throw_NoSuchNativeMethodException(env, "sigset");
        return NULL;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass class, jint sig, jobject disp) {
        void* result;
        if (disp == NULL) {
            result = sigset(sig, NULL);
        } else {
            result = sigset(sig, UNWRAP_NATIVE_FUNCTION_POINTER_TO(void (*) (jint), disp));
        }
        if (result == SIG_ERR) {
            throw_NativeErrorException(env, errno);
            return NULL;
        }
        return CREATE_NATIVE_FUNCTION_POINTER(result);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigsuspend
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigsuspend
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject sigmask) {
        if (sigmask == NULL) {
            throw_NullPointerException(env, "sigmask is null");
            return;
        }
        if (sigsuspend(UNWRAP_SIGSET_T_PTR(sigmask))) {
            if (errno == EINTR) {
                //no-op expected
            } else {
                throw_NativeErrorException(env, errno);
            }
        } else {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigtimedwait
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;Lde/ibapl/jnhw/posix/Signal/Siginfo_t;Lde/ibapl/jnhw/posix/Time/Timespec;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_sigtimedwait
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass class, __attribute__ ((unused)) jobject set, __attribute__ ((unused)) jobject info, __attribute__ ((unused)) jobject timeout) {
        throw_NoSuchNativeMethodException(env, "sigtimedwait");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass class, jobject set, jobject info, jobject timeout) {
        if (set == NULL) {
            throw_NullPointerException(env, "set is null");
            return -1;
        }
        if (timeout == NULL) {
            throw_NullPointerException(env, "timeout is null");
            return -1;
        }

        const int result = sigtimedwait(UNWRAP_SIGSET_T_PTR(set), UNWRAP_SIGINFO_T_PTR_OR_NULL(info), UNWRAP_STRUCT_TIMESPEC_PTR(timeout));
        if (result == -1) {
            throw_NativeErrorException(env, errno);
            return -1;
        }
        return result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigwait
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_sigwait
    (JNIEnv *env, __attribute__ ((unused)) jclass class, jobject set) {
        if (set == NULL) {
            throw_NullPointerException(env, "set is null");
            return -1;
        }
        int sig;

        if (sigwait(UNWRAP_SIGSET_T_PTR(set), &sig)) {
            throw_NativeErrorException(env, errno);
            return -1;
        }
        return sig;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigwaitinfo
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;Lde/ibapl/jnhw/posix/Signal/Siginfo_t;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_sigwaitinfo
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass class, __attribute__ ((unused)) jobject set, __attribute__ ((unused)) jobject info) {
        throw_NoSuchNativeMethodException(env, "sigwaitinfo");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass class, jobject set, jobject info) {
        if (set == NULL) {
            throw_NullPointerException(env, "set is null");
            return -1;
        }
        const int result = sigwaitinfo(UNWRAP_SIGSET_T_PTR(set), UNWRAP_SIGINFO_T_PTR_OR_NULL(info));
        if (result == -1) {
            throw_NativeErrorException(env, errno);
            return -1;
        }
        return result;
#endif
    }

#endif
#ifdef __cplusplus
}
#endif
