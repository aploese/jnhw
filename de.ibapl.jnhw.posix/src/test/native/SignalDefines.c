/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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

    //We need the POSIX version ...
#if !defined(HAVE_SIGNAL_H) || !defined(_POSIX_VERSION)

int32_t getValueOf_HAVE_SIGNAL_H() {
    return 0;
}
#else
#include <signal.h>
#include <stdint.h>

int32_t getValueOf_HAVE_SIGNAL_H() {
    return 1;
}

int32_t getValueOf_ILL_ILLOPC() {
    return ILL_ILLOPC;
}

int32_t getValueOf_ILL_ILLOPN() {
    return ILL_ILLOPN;
}

int32_t getValueOf_ILL_ILLADR() {
    return ILL_ILLADR;
}

int32_t getValueOf_ILL_ILLTRP() {
    return ILL_ILLTRP;
}

int32_t getValueOf_ILL_PRVOPC() {
    return ILL_PRVOPC;
}

int32_t getValueOf_ILL_PRVREG() {
    return ILL_PRVREG;
}

int32_t getValueOf_ILL_COPROC() {
    return ILL_COPROC;
}

int32_t getValueOf_ILL_BADSTK() {
    return ILL_BADSTK;
}

int32_t getValueOf_FPE_INTDIV() {
    return FPE_INTDIV;
}

int32_t getValueOf_FPE_INTOVF() {
    return FPE_INTOVF;
}

int32_t getValueOf_FPE_FLTDIV() {
    return FPE_FLTDIV;
}

int32_t getValueOf_FPE_FLTOVF() {
    return FPE_FLTOVF;
}

int32_t getValueOf_FPE_FLTUND() {
    return FPE_FLTUND;
}

int32_t getValueOf_FPE_FLTRES() {
    return FPE_FLTRES;
}

int32_t getValueOf_FPE_FLTINV() {
    return FPE_FLTINV;
}

int32_t getValueOf_FPE_FLTSUB() {
    return FPE_FLTSUB;
}

int32_t getValueOf_SEGV_MAPERR() {
    return SEGV_MAPERR;
}

int32_t getValueOf_SEGV_ACCERR() {
    return SEGV_ACCERR;
}

int32_t getValueOf_BUS_ADRALN() {
    return BUS_ADRALN;
}

int32_t getValueOf_BUS_ADRERR() {
    return BUS_ADRERR;
}

int32_t getValueOf_BUS_OBJERR() {
    return BUS_OBJERR;
}

int32_t getValueOf_TRAP_BRKPT() {
    return TRAP_BRKPT;
}

int32_t getValueOf_TRAP_TRACE() {
    return TRAP_TRACE;
}

int32_t getValueOf_CLD_EXITED() {
    return CLD_EXITED;
}

int32_t getValueOf_CLD_KILLED() {
    return CLD_KILLED;
}

int32_t getValueOf_CLD_DUMPED() {
    return CLD_DUMPED;
}

int32_t getValueOf_CLD_TRAPPED() {
    return CLD_TRAPPED;
}

int32_t getValueOf_CLD_STOPPED() {
    return CLD_STOPPED;
}

int32_t getValueOf_CLD_CONTINUED() {
    return CLD_CONTINUED;
}

int32_t* tryGetValueOf_POLL_IN(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(POLL_IN)
    value = NULL;
#else
#error "POLL_IN defined"
#endif
#else
    *value = POLL_IN;
#endif
    return value;
}

int32_t* tryGetValueOf_POLL_OUT(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(POLL_OUT)
    value = NULL;
#else
#error "POLL_OUT defined"
#endif
#else
    *value = POLL_OUT;
#endif
    return value;
}

int32_t* tryGetValueOf_POLL_MSG(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(POLL_MSG)
    value = NULL;
#else
#error "POLL_MSG defined"
#endif
#else
    *value = POLL_MSG;
#endif
    return value;
}

int32_t* tryGetValueOf_POLL_ERR(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(POLL_ERR)
    value = NULL;
#else
#error "POLL_ERR defined"
#endif
#else
    *value = POLL_ERR;
#endif
    return value;
}

int32_t* tryGetValueOf_POLL_PRI(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(POLL_PRI)
    value = NULL;
#else
#error "POLL_PRI defined"
#endif
#else
    *value = POLL_PRI;
#endif
    return value;
}

int32_t* tryGetValueOf_POLL_HUP(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(POLL_HUP)
    value = NULL;
#else
#error "POLL_HUP defined"
#endif
#else
    *value = POLL_HUP;
#endif
    return value;
}

int32_t getValueOf_SI_USER() {
    return SI_USER;
}

int32_t getValueOf_SI_QUEUE() {
    return SI_QUEUE;
}

int32_t getValueOf_SI_TIMER() {
    return SI_TIMER;
}

int32_t* tryGetValueOf_SI_ASYNCIO(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(SI_ASYNCIO)
    value = NULL;
#else
#error "SI_ASYNCIO defined"
#endif
#else
    *value = SI_ASYNCIO;
#endif
    return value;
}

int32_t* tryGetValueOf_SI_MESGQ(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(SI_MESGQ)
    value = NULL;
#else
#error "SI_MESGQ defined"
#endif
#else
    *value = SI_MESGQ;
#endif
    return value;
}

int32_t getValueOf_SIG_BLOCK() {
    return SIG_BLOCK;
}

int32_t getValueOf_SIG_UNBLOCK() {
    return SIG_UNBLOCK;
}

int32_t getValueOf_SIG_SETMASK() {
    return SIG_SETMASK;
}

int32_t getValueOf_SA_NOCLDSTOP() {
    return SA_NOCLDSTOP;
}

int32_t getValueOf_SA_ONSTACK() {
    return SA_ONSTACK;
}

int32_t getValueOf_SA_RESETHAND() {
    return (int32_t) SA_RESETHAND;
}

int32_t getValueOf_SA_RESTART() {
    return SA_RESTART;
}

int32_t getValueOf_SA_SIGINFO() {
    return SA_SIGINFO;
}

int32_t getValueOf_SA_NOCLDWAIT() {
    return SA_NOCLDWAIT;
}

int32_t getValueOf_SA_NODEFER() {
    return SA_NODEFER;
}

int32_t getValueOf_SS_ONSTACK() {
    return SS_ONSTACK;
}

int32_t getValueOf_SS_DISABLE() {
    return SS_DISABLE;
}

//glibc > 2.34 redefines this to sysconf(_SC_MINSIGSTKSZ), so this const is useless
int64_t getValueOf_MINSIGSTKSZ() {
    return MINSIGSTKSZ;
}

//glibc > 2.34 redefines this to sysconf(_SC_SIGSTKSZ), so this const is useless
int64_t getValueOf_SIGSTKSZ() {
    return SIGSTKSZ;
}

intptr_t getValueOf_SIG_DFL() {
    return (intptr_t) SIG_DFL;
}

intptr_t getValueOf_SIG_ERR() {
    return (intptr_t) SIG_ERR;
}

intptr_t* tryGetValueOf_SIG_HOLD(intptr_t* value) {
#if defined(__OpenBSD__)
#if !defined(SIG_HOLD)
     value = NULL;
#else
#error "SIG_HOLD defined"
#endif
#else
    *value = (intptr_t) SIG_HOLD;
#endif
    return value;
}

intptr_t getValueOf_SIG_IGN() {
    return (intptr_t) SIG_IGN;
}

int32_t* tryGetValueOf_SIGEV_NONE(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(SIGEV_NONE)
    value = NULL;
#else
#error "SIGEV_NONE defined"
#endif
#else
    *value = SIGEV_NONE;
#endif
    return value;
}

int32_t* tryGetValueOf_SIGEV_SIGNAL(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(SIGEV_SIGNAL)
    value = NULL;
#else
#error "SIGEV_SIGNAL defined"
#endif
#else
    *value = SIGEV_SIGNAL;
#endif
    return value;
}

int32_t* tryGetValueOf_SIGEV_THREAD(int32_t* value) {
#if defined(__OpenBSD__)
#if !defined(SIGEV_THREAD)
    value = NULL;
#else
#error "SIGEV_THREAD defined"
#endif
#else
    *value = SIGEV_THREAD;
#endif
    return value;
}

int32_t getValueOf_SIGABRT() {
    return SIGABRT;
}

int32_t getValueOf_SIGALRM() {
    return SIGALRM;
}

int32_t getValueOf_SIGBUS() {
    return SIGBUS;
}

int32_t getValueOf_SIGCHLD() {
    return SIGCHLD;
}

int32_t getValueOf_SIGCONT() {
    return SIGCONT;
}

int32_t getValueOf_SIGFPE() {
    return SIGFPE;
}

int32_t getValueOf_SIGHUP() {
    return SIGHUP;
}

int32_t getValueOf_SIGILL() {
    return SIGILL;
}

int32_t getValueOf_SIGINT() {
    return SIGINT;
}

int32_t getValueOf_SIGKILL() {
    return SIGKILL;
}

int32_t getValueOf_SIGPIPE() {
    return SIGPIPE;
}

int32_t getValueOf_SIGQUIT() {
    return SIGQUIT;
}

int32_t getValueOf_SIGSEGV() {
    return SIGSEGV;
}

int32_t getValueOf_SIGSTOP() {
    return SIGSTOP;
}

int32_t getValueOf_SIGTERM() {
    return SIGTERM;
}

int32_t getValueOf_SIGTSTP() {
    return SIGTSTP;
}

int32_t getValueOf_SIGTTIN() {
    return SIGTTIN;
}

int32_t getValueOf_SIGTTOU() {
    return SIGTTOU;
}

int32_t getValueOf_SIGUSR1() {
    return SIGUSR1;
}

int32_t getValueOf_SIGUSR2() {
    return SIGUSR2;
}

int32_t* tryGetValueOf_SIGPOLL(int32_t* value) {
#if defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
#if !defined(SIGPOLL)
    value = NULL;
#else
#error "SIGPOLL defined"
#endif
#else
    *value = SIGPOLL;
#endif
    return value;
}

int32_t getValueOf_SIGPROF() {
    return SIGPROF;
}

int32_t getValueOf_SIGSYS() {
    return SIGSYS;
}

int32_t getValueOf_SIGTRAP() {
    return SIGTRAP;
}

int32_t getValueOf_SIGURG() {
    return SIGURG;
}

int32_t getValueOf_SIGVTALRM() {
    return SIGVTALRM;
}

int32_t getValueOf_SIGXCPU() {
    return SIGXCPU;
}

int32_t getValueOf_SIGXFSZ() {
    return SIGXFSZ;
}

#endif
