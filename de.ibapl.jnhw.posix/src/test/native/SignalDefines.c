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
#include "de_ibapl_jnhw_posix_SignalTest_NativeDefines.h"

#ifdef __cplusplus
extern "C" {
#endif

    //We need the POSIX version ...
#if !defined(HAVE_SIGNAL_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    HAVE_SIGNAL_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_HAVE_1SIGNAL_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_FALSE;
    }
#else
#include <signal.h>
#include <stdint.h>

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    HAVE_SIGNAL_H
     * Signature: ()Z
     */
    JNIEXPORT jboolean JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_HAVE_1SIGNAL_1H
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return JNI_TRUE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    ILL_ILLOPC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_ILL_1ILLOPC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ILL_ILLOPC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    ILL_ILLOPN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_ILL_1ILLOPN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ILL_ILLOPN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    ILL_ILLADR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_ILL_1ILLADR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ILL_ILLADR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    ILL_ILLTRP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_ILL_1ILLTRP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ILL_ILLTRP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    ILL_PRVOPC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_ILL_1PRVOPC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ILL_PRVOPC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    ILL_PRVREG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_ILL_1PRVREG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ILL_PRVREG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    ILL_COPROC
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_ILL_1COPROC
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ILL_COPROC;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    ILL_BADSTK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_ILL_1BADSTK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return ILL_BADSTK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    FPE_INTDIV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_FPE_1INTDIV
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FPE_INTDIV;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    FPE_INTOVF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_FPE_1INTOVF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FPE_INTOVF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    FPE_FLTDIV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_FPE_1FLTDIV
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FPE_FLTDIV;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    FPE_FLTOVF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_FPE_1FLTOVF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FPE_FLTOVF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    FPE_FLTUND
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_FPE_1FLTUND
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FPE_FLTUND;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    FPE_FLTRES
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_FPE_1FLTRES
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FPE_FLTRES;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    FPE_FLTINV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_FPE_1FLTINV
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FPE_FLTINV;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    FPE_FLTSUB
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_FPE_1FLTSUB
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return FPE_FLTSUB;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SEGV_MAPERR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SEGV_1MAPERR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEGV_MAPERR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SEGV_ACCERR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SEGV_1ACCERR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SEGV_ACCERR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    BUS_ADRALN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_BUS_1ADRALN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return BUS_ADRALN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    BUS_ADRERR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_BUS_1ADRERR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return BUS_ADRERR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    BUS_OBJERR
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_BUS_1OBJERR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return BUS_OBJERR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    TRAP_BRKPT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_TRAP_1BRKPT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TRAP_BRKPT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    TRAP_TRACE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_TRAP_1TRACE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return TRAP_TRACE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    CLD_EXITED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_CLD_1EXITED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLD_EXITED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    CLD_KILLED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_CLD_1KILLED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLD_KILLED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    CLD_DUMPED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_CLD_1DUMPED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLD_DUMPED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    CLD_TRAPPED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_CLD_1TRAPPED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLD_TRAPPED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    CLD_STOPPED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_CLD_1STOPPED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLD_STOPPED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    CLD_CONTINUED
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_CLD_1CONTINUED
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return CLD_CONTINUED;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    POLL_IN
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_POLL_1IN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(POLL_IN)
        return NULL;
#else
#error "POLL_IN defined"
#endif
#else
        return JnhwWrapInteger(env, POLL_IN);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    POLL_OUT
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_POLL_1OUT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(POLL_OUT)
        return NULL;
#else
#error "POLL_OUT defined"
#endif
#else
        return JnhwWrapInteger(env, POLL_OUT);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    POLL_MSG
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_POLL_1MSG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(POLL_MSG)
        return NULL;
#else
#error "POLL_MSG defined"
#endif
#else
        return JnhwWrapInteger(env, POLL_MSG);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    POLL_ERR
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_POLL_1ERR
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(POLL_ERR)
        return NULL;
#else
#error "POLL_ERR defined"
#endif
#else
        return JnhwWrapInteger(env, POLL_ERR);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    POLL_PRI
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_POLL_1PRI
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(POLL_PRI)
        return NULL;
#else
#error "POLL_PRI defined"
#endif
#else
        return JnhwWrapInteger(env, POLL_PRI);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    POLL_HUP
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_POLL_1HUP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(POLL_HUP)
        return NULL;
#else
#error "POLL_HUP defined"
#endif
#else
        return JnhwWrapInteger(env, POLL_HUP);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SI_USER
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SI_1USER
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SI_USER;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SI_QUEUE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SI_1QUEUE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SI_QUEUE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SI_TIMER
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SI_1TIMER
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SI_TIMER;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SI_ASYNCIO
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SI_1ASYNCIO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(SI_ASYNCIO)
        return NULL;
#else
#error "SI_ASYNCIO defined"
#endif
#else
        return JnhwWrapInteger(env, SI_ASYNCIO);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SI_MESGQ
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SI_1MESGQ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(SI_MESGQ)
        return NULL;
#else
#error "SI_MESGQ defined"
#endif
#else
        return JnhwWrapInteger(env, SI_MESGQ);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIG_BLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIG_1BLOCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIG_BLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIG_UNBLOCK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIG_1UNBLOCK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIG_UNBLOCK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIG_SETMASK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIG_1SETMASK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIG_SETMASK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SA_NOCLDSTOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SA_1NOCLDSTOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SA_NOCLDSTOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SA_ONSTACK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SA_1ONSTACK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SA_ONSTACK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SA_RESETHAND
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SA_1RESETHAND
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (int32_t) SA_RESETHAND;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SA_RESTART
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SA_1RESTART
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SA_RESTART;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SA_SIGINFO
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SA_1SIGINFO
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SA_SIGINFO;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SA_NOCLDWAIT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SA_1NOCLDWAIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SA_NOCLDWAIT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SA_NODEFER
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SA_1NODEFER
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SA_NODEFER;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SS_ONSTACK
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SS_1ONSTACK
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SS_ONSTACK;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SS_DISABLE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SS_1DISABLE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SS_DISABLE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    MINSIGSTKSZ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_MINSIGSTKSZ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return MINSIGSTKSZ;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGSTKSZ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGSTKSZ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGSTKSZ;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIG_DFL0
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIG_1DFL0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (intptr_t) SIG_DFL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIG_ERR0
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIG_1ERR0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (intptr_t) SIG_ERR;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIG_HOLD0
     * Signature: ()Ljava/lang/Long;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIG_1HOLD0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(SIG_HOLD)
        return NULL;
#else
#error "SIG_HOLD defined"
#endif
#else
        return JnhwWrapLong(env, (intptr_t) SIG_HOLD);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIG_IGN0
     * Signature: ()J
     */
    JNIEXPORT jlong JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIG_1IGN0
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return (intptr_t) SIG_IGN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGEV_NONE
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGEV_1NONE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(SIGEV_NONE)
        return NULL;
#else
#error "SIGEV_NONE defined"
#endif
#else
        return JnhwWrapInteger(env, SIGEV_NONE);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGEV_SIGNAL
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGEV_1SIGNAL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(SIGEV_SIGNAL)
        return NULL;
#else
#error "SIGEV_SIGNAL defined"
#endif
#else
        return JnhwWrapInteger(env, SIGEV_SIGNAL);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGEV_THREAD
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGEV_1THREAD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__OpenBSD__)
#if !defined(SIGEV_THREAD)
        return NULL;
#else
#error "SIGEV_THREAD defined"
#endif
#else
        return JnhwWrapInteger(env, SIGEV_THREAD);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGABRT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGABRT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGABRT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGALRM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGALRM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGALRM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGBUS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGBUS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGBUS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGCHLD
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGCHLD
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGCHLD;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGCONT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGCONT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGCONT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGFPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGFPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGFPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGHUP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGHUP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGHUP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGILL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGILL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGILL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGINT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGINT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGINT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGKILL
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGKILL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGKILL;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGPIPE
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGPIPE
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGPIPE;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGQUIT
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGQUIT
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGQUIT;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGSEGV
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGSEGV
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGSEGV;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGSTOP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGSTOP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGSTOP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGTERM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGTERM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGTERM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGTSTP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGTSTP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGTSTP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGTTIN
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGTTIN
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGTTIN;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGTTOU
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGTTOU
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGTTOU;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGUSR1
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGUSR1
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGUSR1;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGUSR2
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGUSR2
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGUSR2;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGPOLL
     * Signature: ()Ljava/lang/Integer;
     */
    JNIEXPORT jobject JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGPOLL
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
#if defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
#if !defined(SIGPOLL)
        return NULL;
#else
#error "SIGPOLL defined"
#endif
#else
        return JnhwWrapInteger(env, SIGPOLL);
#endif
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGPROF
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGPROF
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGPROF;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGSYS
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGSYS
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGSYS;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGTRAP
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGTRAP
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGTRAP;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGURG
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGURG
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGURG;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGVTALRM
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGVTALRM
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGVTALRM;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGXCPU
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGXCPU
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGXCPU;
    }

    /*
     * Class:     de_ibapl_jnhw_posix_SignalTest_NativeDefines
     * Method:    SIGXFSZ
     * Signature: ()I
     */
    JNIEXPORT jint JNICALL Java_de_ibapl_jnhw_posix_SignalTest_00024NativeDefines_SIGXFSZ
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
        return SIGXFSZ;
    }

#endif

#ifdef __cplusplus
}
#endif
