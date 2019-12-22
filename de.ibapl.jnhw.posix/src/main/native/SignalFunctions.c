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

#ifdef HAVE_SIGNAL_H

#include <signal.h>
#include <errno.h>

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    si_addr
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Signal_si_1addr
    (JNIEnv *, jclass);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    si_pid
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_si_1pid
    (JNIEnv *, jclass);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    si_status
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_si_1status
    (JNIEnv *, jclass);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    si_uid
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_si_1uid
    (JNIEnv *, jclass);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    si_band
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_Signal_si_1band
    (JNIEnv *, jclass);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    kill
     * Signature: (II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_kill
    (JNIEnv *, jclass, jint, jint);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    killpg
     * Signature: (II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_killpg
    (JNIEnv *, jclass, jint, jint);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    psiginfo
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Siginfo_t;Ljava/lang/String;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_psiginfo
    (JNIEnv *, jclass, jobject, jstring);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    psignal
     * Signature: (ILjava/lang/String;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_psignal
    (JNIEnv *, jclass, jint, jstring);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    pthread_kill
     * Signature: (JI)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_pthread_1kill
    (JNIEnv *, jclass, jlong, jint);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    pthread_sigmask
     * Signature: (ILde/ibapl/jnhw/posix/Signal/Sigset_t;Lde/ibapl/jnhw/posix/Signal/Sigset_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_pthread_1sigmask
    (JNIEnv *, jclass, jint, jobject, jobject);

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
    (JNIEnv *, jclass, jint, jobject, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigaddset
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigaddset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject set, jint signo) {
        if (set == NULL) {
            throw_NullPointerException(env, "set");
            return;
        }
        if (sigaddset(UNWRAP_OPAQUE_MEM_TO(sigset_t*, set), signo)) {
            throw_NativeErrorException(env, errno);
        }
        return;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigaltstack
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Stack_t;Lde/ibapl/jnhw/posix/Signal/Stack_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigaltstack
    (JNIEnv *, jclass, jobject, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigdelset
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigdelset
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject set, jint signo) {
        if (set == NULL) {
            throw_NullPointerException(env, "set");
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
            throw_NullPointerException(env, "set");
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
            throw_NullPointerException(env, "set");
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
    (JNIEnv *, jclass, jint);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigignore
     * Signature: (I)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigignore
    (JNIEnv *, jclass, jint);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    siginterrupt
     * Signature: (II)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_siginterrupt
    (JNIEnv *, jclass, jint, jint);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigismember
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;I)Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_Signal_sigismember
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jobject set, jint signo) {
        if (set == NULL) {
            throw_NullPointerException(env, "set");
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
     * Signature: (ILde/ibapl/jnhw/NativeFunctionPointer;)Lde/ibapl/jnhw/NativeFunctionPointer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_signal
    (JNIEnv *env, __attribute__ ((unused)) jclass clazz, jint sig, jobject func) {
        __sighandler_t result;
        if (func == NULL) {
            result = signal(sig, NULL);
        } else {
            result = signal(sig, UNWRAP_NATIVE_FUNCTION_POINTER(func));
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
    }

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigpending
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigpending
    (JNIEnv *, jclass);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigprocmask
     * Signature: (ILde/ibapl/jnhw/posix/Signal/Sigset_t;Lde/ibapl/jnhw/posix/Signal/Sigset_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigprocmask
    (JNIEnv *, jclass, jint, jobject, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigqueue
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigqueue
    (JNIEnv *, jclass);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigrelse
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigrelse
    (JNIEnv *, jclass);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigset
     * Signature: (ILde/ibapl/jnhw/NativeFunctionPointer;)Lde/ibapl/jnhw/NativeFunctionPointer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_Signal_sigset
    (JNIEnv *env, __attribute__ ((unused)) jclass class, jint sig, jobject disp) {
        __sighandler_t result;
        if (disp == NULL) {
            result = sigset(sig, NULL);
        } else {
            result = sigset(sig, UNWRAP_NATIVE_FUNCTION_POINTER(disp));
        }
        if (result == SIG_ERR) {
            throw_NativeErrorException(env, errno);
            return NULL;
        }
        return CREATE_NATIVE_FUNCTION_POINTER(result);
    }
    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigsuspend
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;)V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigsuspend
    (JNIEnv *, jclass, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigtimedwait
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;Lde/ibapl/jnhw/posix/Signal/Siginfo_t;Lde/ibapl/jnhw/posix/Time/Timespec;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_sigtimedwait
    (JNIEnv *, jclass, jobject, jobject, jobject);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigwait
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_sigwait
    (JNIEnv *, jclass);

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    sigwaitinfo
     * Signature: (Lde/ibapl/jnhw/posix/Signal/Sigset_t;Lde/ibapl/jnhw/posix/Signal/Siginfo_t;)I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_Signal_sigwaitinfo
    (JNIEnv *, jclass, jobject, jobject);

#ifdef __cplusplus
}
#endif
#endif