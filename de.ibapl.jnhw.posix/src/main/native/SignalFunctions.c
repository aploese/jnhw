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
#include "de_ibapl_jnhw_posix_Signal.h"

#ifdef __cplusplus
extern "C" {
#endif


#ifdef _POSIX_VERSION
#include <signal.h>
#include <errno.h>
#include <stdio.h>
#if defined(__OpenBSD__)
#include <pthread.h>
    //for pthread_kill
#endif

    JNHW_ASSERT__pid_t__IS__int32_t

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
     * Signature: (JLjava/lang/String;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_psiginfo
#if defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jlong ptrPinfo, __attribute__ ((unused)) jstring message) {
        throw_NoSuchNativeMethodException(env, "psiginfo");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrPinfo, jstring message) {
        const int old_errno = errno;
        const char* _message;
        if (message == NULL) {
            _message = NULL;
        } else {
            _message = (*env)->GetStringUTFChars(env, message, NULL);
        }
        errno = 0;
        psiginfo((siginfo_t*) (uintptr_t) ptrPinfo, _message);
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
        psignal((uint32_t) signo, _message);
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
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_pthread_1kill
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrThread_id, jint sig) {
        if (pthread_kill(*((pthread_t*) (uintptr_t) ptrThread_id), sig)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    pthread_sigmask
     * Signature: (IJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_pthread_1sigmask
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint how, jlong ptrSet, jlong ptrOset) {
        if (pthread_sigmask(how, (sigset_t *) (uintptr_t) ptrSet, (sigset_t *) (uintptr_t) ptrOset)) {
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
     * Signature: (IJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigaction
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig, jlong ptrAct, jlong ptrOact) {
        if (sigaction(sig, (struct sigaction*) (uintptr_t) ptrAct, (struct sigaction*) (uintptr_t) ptrOact)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigaddset
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigaddset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrSet, jint signo) {
        if (sigaddset((sigset_t*) (uintptr_t) ptrSet, signo)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigaltstack
     * Signature: (JJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigaltstack
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrSs, jlong ptrOss) {
        if (sigaltstack((stack_t*) (uintptr_t) ptrSs, (stack_t*) (uintptr_t) ptrOss)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigdelset
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigdelset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrSet, jint signo) {
        if (sigdelset((sigset_t*) (uintptr_t) ptrSet, signo)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigemptyset
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigemptyset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrSet) {
        if (sigemptyset((sigset_t*) (uintptr_t) ptrSet)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigfillset
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigfillset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrSet) {
        if (sigfillset((sigset_t*) (uintptr_t) ptrSet)) {
            throw_NativeErrorException(env, errno);
        }
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
     * Signature: (JI)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Signal_sigismember
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrSet, jint signo) {
        const int result = sigismember((sigset_t*) (uintptr_t) ptrSet, signo);
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
     * Signature: (IJ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Signal_signal
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig, jlong ptrFunc) {
        void* result;
        if (ptrFunc == (jlong) (uintptr_t) NULL) {
            result = signal(sig, NULL);
        } else {
            result = signal(sig, (void (*) (jint))(uintptr_t) ptrFunc);
        }
        if (result == SIG_ERR) {
            throw_NativeErrorException(env, errno);
            return (jlong) (uintptr_t) NULL;
        }
        return (jlong) (uintptr_t) result;
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
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigpending
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrSet) {
        if (sigpending((sigset_t*) (uintptr_t) ptrSet)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigprocmask
     * Signature: (IJJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigprocmask
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint how, jlong ptrSet, jlong ptrOset) {
        if (sigprocmask(how, (sigset_t*) (uintptr_t) ptrSet, (sigset_t*) (uintptr_t) ptrOset)) {
            throw_NativeErrorException(env, errno);
        }
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigqueue
     * Signature: (IIJ)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigqueue
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, __attribute__ ((unused)) jint pid, __attribute__ ((unused)) jint signo, __attribute__ ((unused)) jlong ptrSigval) {
        throw_NoSuchNativeMethodException(env, "sigqueue");
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint pid, jint signo, jlong ptrSigval) {

        if (sigqueue(pid, signo, *((union sigval*)(uintptr_t) ptrSigval))) {
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
     * Signature: (IJ)J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Signal_sigset
#if defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass class, __attribute__ ((unused)) jint sig, __attribute__ ((unused)) jlong ptrDisp) {
        throw_NoSuchNativeMethodException(env, "sigset");
        return (jlong) (uintptr_t) NULL;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass class, jint sig, jlong ptrDisp) {
        void* result;
        if (ptrDisp == (jlong) (uintptr_t) NULL) {
            result = sigset(sig, NULL);
        } else {
            result = sigset(sig, (void (*) (jint))(uintptr_t) ptrDisp);
        }
        if (result == SIG_ERR) {
            throw_NativeErrorException(env, errno);
            return (jlong) (uintptr_t) NULL;
        }
        return (jlong) (uintptr_t) result;
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigsuspend
     * Signature: (J)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigsuspend
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jlong ptrSigmask) {
        if (sigsuspend((sigset_t*) (uintptr_t) ptrSigmask)) {
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
     * Signature: (JJJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_sigtimedwait
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass class, __attribute__ ((unused)) jlong ptrSet, __attribute__ ((unused)) jlong ptrInfo, __attribute__ ((unused)) jlong ptrTimeout) {
        throw_NoSuchNativeMethodException(env, "sigtimedwait");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass class, jlong ptrSet, jlong ptrInfo, jlong ptrTimeout) {
        const int result = sigtimedwait((sigset_t*) (uintptr_t) ptrSet, (siginfo_t*) (uintptr_t) ptrInfo, (struct timespec*) (uintptr_t) ptrTimeout);
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
     * Signature: (JI)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_sigwait
    (JNIEnv *env, __attribute__ ((unused)) jclass class, jlong ptrSet, jint sig) {
        int _sig = sig;

        if (sigwait((sigset_t*) (uintptr_t) ptrSet, &_sig)) {
            throw_NativeErrorException(env, errno);
            return -1;
        }
        return _sig;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigwaitinfo
     * Signature: (JJ)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_sigwaitinfo
#if defined(__APPLE__) || defined(__OpenBSD__)
    (JNIEnv *env, __attribute__ ((unused)) jclass class, __attribute__ ((unused)) jlong ptrSet, __attribute__ ((unused)) jlong ptrInfo) {
        throw_NoSuchNativeMethodException(env, "sigwaitinfo");
        return -1;
#else
    (JNIEnv *env, __attribute__ ((unused)) jclass class, jlong ptrSet, jlong ptrInfo) {
        const int result = sigwaitinfo((sigset_t*) (uintptr_t) ptrSet, (siginfo_t*) (uintptr_t) ptrInfo);
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
