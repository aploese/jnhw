/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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

int getValueOf_HAVE_SIGNAL_H() {
    return 0;
}
#else
#include <signal.h>
#include <stdint.h>

int getValueOf_HAVE_SIGNAL_H() {
    return 1;
}

int getValueOf_ILL_ILLOPC() {
    return ILL_ILLOPC;
}

int getValueOf_ILL_ILLOPN() {
    return ILL_ILLOPN;
}

int getValueOf_ILL_ILLADR() {
    return ILL_ILLADR;
}

int getValueOf_ILL_ILLTRP() {
    return ILL_ILLTRP;
}

int getValueOf_ILL_PRVOPC() {
    return ILL_PRVOPC;
}

int getValueOf_ILL_PRVREG() {
    return ILL_PRVREG;
}

int getValueOf_ILL_COPROC() {
    return ILL_COPROC;
}

int getValueOf_ILL_BADSTK() {
    return ILL_BADSTK;
}

int getValueOf_FPE_INTDIV() {
    return FPE_INTDIV;
}

int getValueOf_FPE_INTOVF() {
    return FPE_INTOVF;
}

int getValueOf_FPE_FLTDIV() {
    return FPE_FLTDIV;
}

int getValueOf_FPE_FLTOVF() {
    return FPE_FLTOVF;
}

int getValueOf_FPE_FLTUND() {
    return FPE_FLTUND;
}

int getValueOf_FPE_FLTRES() {
    return FPE_FLTRES;
}

int getValueOf_FPE_FLTINV() {
    return FPE_FLTINV;
}

int getValueOf_FPE_FLTSUB() {
    return FPE_FLTSUB;
}

int getValueOf_SEGV_MAPERR() {
    return SEGV_MAPERR;
}

int getValueOf_SEGV_ACCERR() {
    return SEGV_ACCERR;
}

int getValueOf_BUS_ADRALN() {
    return BUS_ADRALN;
}

int getValueOf_BUS_ADRERR() {
    return BUS_ADRERR;
}

int getValueOf_BUS_OBJERR() {
    return BUS_OBJERR;
}

int getValueOf_TRAP_BRKPT() {
    return TRAP_BRKPT;
}

int getValueOf_TRAP_TRACE() {
    return TRAP_TRACE;
}

int getValueOf_CLD_EXITED() {
    return CLD_EXITED;
}

int getValueOf_CLD_KILLED() {
    return CLD_KILLED;
}

int getValueOf_CLD_DUMPED() {
    return CLD_DUMPED;
}

int getValueOf_CLD_TRAPPED() {
    return CLD_TRAPPED;
}

int getValueOf_CLD_STOPPED() {
    return CLD_STOPPED;
}

int getValueOf_CLD_CONTINUED() {
    return CLD_CONTINUED;
}

int* tryGetValueOf_POLL_IN(int* value) {
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

int* tryGetValueOf_POLL_OUT(int* value) {
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

int* tryGetValueOf_POLL_MSG(int* value) {
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

int* tryGetValueOf_POLL_ERR(int* value) {
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

int* tryGetValueOf_POLL_PRI(int* value) {
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

int* tryGetValueOf_POLL_HUP(int* value) {
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

int getValueOf_SI_USER() {
    return SI_USER;
}

int getValueOf_SI_QUEUE() {
    return SI_QUEUE;
}

int getValueOf_SI_TIMER() {
    return SI_TIMER;
}

int* tryGetValueOf_SI_ASYNCIO(int* value) {
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

int* tryGetValueOf_SI_MESGQ(int* value) {
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

int getValueOf_SIG_BLOCK() {
    return SIG_BLOCK;
}

int getValueOf_SIG_UNBLOCK() {
    return SIG_UNBLOCK;
}

int getValueOf_SIG_SETMASK() {
    return SIG_SETMASK;
}

int getValueOf_SA_NOCLDSTOP() {
    return SA_NOCLDSTOP;
}

int getValueOf_SA_ONSTACK() {
    return SA_ONSTACK;
}

int getValueOf_SA_RESETHAND() {
    return (int32_t) SA_RESETHAND;
}

int getValueOf_SA_RESTART() {
    return SA_RESTART;
}

int getValueOf_SA_SIGINFO() {
    return SA_SIGINFO;
}

int getValueOf_SA_NOCLDWAIT() {
    return SA_NOCLDWAIT;
}

int getValueOf_SA_NODEFER() {
    return SA_NODEFER;
}

int getValueOf_SS_ONSTACK() {
    return SS_ONSTACK;
}

int getValueOf_SS_DISABLE() {
    return SS_DISABLE;
}

//glibc > 2.34 redefines this to sysconf(_SC_MINSIGSTKSZ), so this const is useless
long getValueOf_MINSIGSTKSZ() {
    return MINSIGSTKSZ;
}

//glibc > 2.34 redefines this to sysconf(_SC_SIGSTKSZ), so this const is useless
long getValueOf_SIGSTKSZ() {
    return SIGSTKSZ;
}

long getValueOf_SIG_DFL() {
    return (intptr_t) SIG_DFL;
}

long getValueOf_SIG_ERR() {
    return (intptr_t) SIG_ERR;
}

int* tryGetValueOf_SIG_HOLD(int* value) {
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

long getValueOf_SIG_IGN() {
    return (intptr_t) SIG_IGN;
}

int* tryGetValueOf_SIGEV_NONE(int* value) {
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

int* tryGetValueOf_SIGEV_SIGNAL(int* value) {
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

int* tryGetValueOf_SIGEV_THREAD(int* value) {
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

int getValueOf_SIGABRT() {
    return SIGABRT;
}

int getValueOf_SIGALRM() {
    return SIGALRM;
}

int getValueOf_SIGBUS() {
    return SIGBUS;
}

int getValueOf_SIGCHLD() {
    return SIGCHLD;
}

int getValueOf_SIGCONT() {
    return SIGCONT;
}

int getValueOf_SIGFPE() {
    return SIGFPE;
}

int getValueOf_SIGHUP() {
    return SIGHUP;
}

int getValueOf_SIGILL() {
    return SIGILL;
}

int getValueOf_SIGINT() {
    return SIGINT;
}

int getValueOf_SIGKILL() {
    return SIGKILL;
}

int getValueOf_SIGPIPE() {
    return SIGPIPE;
}

int getValueOf_SIGQUIT() {
    return SIGQUIT;
}

int getValueOf_SIGSEGV() {
    return SIGSEGV;
}

int getValueOf_SIGSTOP() {
    return SIGSTOP;
}

int getValueOf_SIGTERM() {
    return SIGTERM;
}

int getValueOf_SIGTSTP() {
    return SIGTSTP;
}

int getValueOf_SIGTTIN() {
    return SIGTTIN;
}

int getValueOf_SIGTTOU() {
    return SIGTTOU;
}

int getValueOf_SIGUSR1() {
    return SIGUSR1;
}

int getValueOf_SIGUSR2() {
    return SIGUSR2;
}

int* tryGetValueOf_SIGPOLL(int* value) {
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

int getValueOf_SIGPROF() {
    return SIGPROF;
}

int getValueOf_SIGSYS() {
    return SIGSYS;
}

int getValueOf_SIGTRAP() {
    return SIGTRAP;
}

int getValueOf_SIGURG() {
    return SIGURG;
}

int getValueOf_SIGVTALRM() {
    return SIGVTALRM;
}

int getValueOf_SIGXCPU() {
    return SIGXCPU;
}

int getValueOf_SIGXFSZ() {
    return SIGXFSZ;
}

#endif
