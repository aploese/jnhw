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

    //We need the POSIX version ...    
#if !defined(HAVE_SIGNAL_H) || !defined(_POSIX_VERSION)

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_initFields
    (__attribute__ ((unused)) JNIEnv *env, __attribute__ ((unused)) jclass clazz) {
    }
#else
#include <signal.h>
#include <stdint.h>

    /*
     * Class:     de_ibapl_jnhw_posix_Signal
     * Method:    initFields
     * Signature: ()V
     */
    JNIEXPORT void JNICALL Java_de_ibapl_jnhw_posix_Signal_initFields
    (JNIEnv *env, jclass clazz) {

        if (JnhwSetStaticBooleanField(env, clazz, "HAVE_SIGNAL_H", JNI_TRUE)) {
            return;
        }

        if (JnhwSetStaticObjectField(env, clazz, dijc_np_FunctionPtr_I_V_CSig, "SIG_DFL", CREATE_FunctionPtr_I_V((uintptr_t) SIG_DFL))) {
            return;
        }
        if (JnhwSetStaticObjectField(env, clazz, dijc_np_FunctionPtr_I_V_CSig, "SIG_ERR", CREATE_FunctionPtr_I_V((uintptr_t) SIG_ERR))) {
            return;
        }

#if defined(__OpenBSD__)
#if defined(SIG_HOLD)
#error "SIG_HOLD defined"
#endif
#else
        if (JnhwSetStaticObjectDefineField(env, clazz, "SIG_HOLD", CREATE_FunctionPtr_I_V((uintptr_t) SIG_HOLD))) {
            return;
        }
#endif

        if (JnhwSetStaticObjectField(env, clazz, dijc_np_FunctionPtr_I_V_CSig, "SIG_IGN", CREATE_FunctionPtr_I_V((uintptr_t) SIG_IGN))) {
            return;
        }

#if defined(__OpenBSD__)
#if defined(SIGEV_NONE)
#error "SIGEV_NONE defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "SIGEV_NONE", SIGEV_NONE)) {
            return;
        }
#endif

#if defined(__OpenBSD__)
#if defined(SIGEV_SIGNAL)
#error "SIGEV_SIGNAL defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "SIGEV_SIGNAL", SIGEV_SIGNAL)) {
            return;
        }
#endif

#if defined(__OpenBSD__)
#if defined(SIGEV_THREAD)
#error "SIGEV_THREAD defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "SIGEV_THREAD", SIGEV_THREAD)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "SIGABRT", SIGABRT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGALRM", SIGALRM)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGBUS", SIGBUS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGCHLD", SIGCHLD)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGCONT", SIGCONT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGFPE", SIGFPE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGHUP", SIGHUP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGILL", SIGILL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGINT", SIGINT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGKILL", SIGKILL)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGPIPE", SIGPIPE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGQUIT", SIGQUIT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGSEGV", SIGSEGV)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGSTOP", SIGSTOP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGTERM", SIGTERM)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGTSTP", SIGTSTP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGTTIN", SIGTTIN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGTTOU", SIGTTOU)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGUSR1", SIGUSR1)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGUSR2", SIGUSR2)) {
            return;
        }

#if defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
#if defined(SIGPOLL)
#error "SIGPOLL defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "SIGPOLL", SIGPOLL)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "SIGPROF", SIGPROF)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGSYS", SIGSYS)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGTRAP", SIGTRAP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGURG", SIGURG)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGVTALRM", SIGVTALRM)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGXCPU", SIGXCPU)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGXFSZ", SIGXFSZ)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIG_BLOCK", SIG_BLOCK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIG_UNBLOCK", SIG_UNBLOCK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIG_SETMASK", SIG_SETMASK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SA_NOCLDSTOP", SA_NOCLDSTOP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SA_ONSTACK", SA_ONSTACK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SA_RESETHAND", (int32_t) SA_RESETHAND)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SA_RESTART", SA_RESTART)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SA_SIGINFO", SA_SIGINFO)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SA_NOCLDWAIT", SA_NOCLDWAIT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SA_NODEFER", SA_NODEFER)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SS_ONSTACK", SS_ONSTACK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SS_DISABLE", SS_DISABLE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "MINSIGSTKSZ", MINSIGSTKSZ)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SIGSTKSZ", SIGSTKSZ)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ILL_ILLOPC", ILL_ILLOPC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ILL_ILLOPN", ILL_ILLOPN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ILL_ILLADR", ILL_ILLADR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ILL_ILLTRP", ILL_ILLTRP)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ILL_PRVOPC", ILL_PRVOPC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ILL_PRVREG", ILL_PRVREG)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ILL_COPROC", ILL_COPROC)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "ILL_BADSTK", ILL_BADSTK)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FPE_INTDIV", FPE_INTDIV)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FPE_INTOVF", FPE_INTOVF)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FPE_FLTDIV", FPE_FLTDIV)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FPE_FLTOVF", FPE_FLTOVF)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FPE_FLTUND", FPE_FLTUND)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FPE_FLTRES", FPE_FLTRES)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FPE_FLTINV", FPE_FLTINV)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "FPE_FLTSUB", FPE_FLTSUB)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SEGV_MAPERR", SEGV_MAPERR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SEGV_ACCERR", SEGV_ACCERR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "BUS_ADRALN", BUS_ADRALN)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "BUS_ADRERR", BUS_ADRERR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "BUS_OBJERR", BUS_OBJERR)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TRAP_BRKPT", TRAP_BRKPT)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "TRAP_TRACE", TRAP_TRACE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLD_EXITED", CLD_EXITED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLD_KILLED", CLD_KILLED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLD_DUMPED", CLD_DUMPED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLD_TRAPPED", CLD_TRAPPED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLD_STOPPED", CLD_STOPPED)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "CLD_CONTINUED", CLD_CONTINUED)) {
            return;
        }

#if defined(__OpenBSD__)
#if defined(POLL_IN)
#error "POLL_IN defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POLL_IN", POLL_IN)) {
            return;
        }
#endif

#if defined(__OpenBSD__)
#if defined(POLL_OUT)
#error "POLL_OUT defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POLL_OUT", POLL_OUT)) {
            return;
        }
#endif

#if defined(__OpenBSD__)
#if defined(POLL_MSG)
#error "POLL_MSG defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POLL_MSG", POLL_MSG)) {
            return;
        }
#endif

#if defined(__OpenBSD__)
#if defined(POLL_ERR)
#error "POLL_ERR defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POLL_ERR", POLL_ERR)) {
            return;
        }
#endif

#if defined(__OpenBSD__)
#if defined(POLL_PRI)
#error "POLL_PRI defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POLL_PRI", POLL_PRI)) {
            return;
        }
#endif

#if defined(__OpenBSD__)
#if defined(POLL_HUP)
#error "POLL_HUP defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "POLL_HUP", POLL_HUP)) {
            return;
        }
#endif

        if (JnhwSetStaticIntField(env, clazz, "SI_USER", SI_USER)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SI_QUEUE", SI_QUEUE)) {
            return;
        }
        if (JnhwSetStaticIntField(env, clazz, "SI_TIMER", SI_TIMER)) {
            return;
        }

#if defined(__OpenBSD__)
#if defined(SI_ASYNCIO)
#error "SI_ASYNCIO defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "SI_ASYNCIO", SI_ASYNCIO)) {
            return;
        }
#endif

#if defined(__OpenBSD__)
#if defined(SI_MESGQ)
#error "SI_MESGQ defined"
#endif
#else
        if (JnhwSetStaticIntDefineField(env, clazz, "SI_MESGQ", SI_MESGQ)) {
            return;
        }
#endif
    }


#endif
#ifdef __cplusplus
}
#endif
