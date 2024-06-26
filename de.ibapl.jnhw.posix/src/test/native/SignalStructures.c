/**
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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


#ifdef _POSIX_VERSION
#include <signal.h>
    //for offsetof
#include <stddef.h>

int32_t Mcontext_t_alignof() {
#if defined(__OpenBSD__)
    return 0;
#else
    return __alignof__ (mcontext_t);
#endif
}

int32_t Mcontext_t_sizeof() {
#if defined(__OpenBSD__)
    return 0;
#else
    return sizeof (mcontext_t);
#endif
}

int32_t Sigaction_alignof() {
    return __alignof__ (struct sigaction);
}

int32_t Sigaction_sizeof() {
    return sizeof (struct sigaction);
}

int32_t Sigaction_offsetof_sa_handler() {
    return offsetof(struct sigaction, sa_handler);
}

int32_t Sigaction_offsetof_sa_mask() {
    return offsetof(struct sigaction, sa_mask);
}

int32_t Sigaction_offsetof_sa_flags() {
    return offsetof(struct sigaction, sa_flags);
}

int32_t Sigaction_offsetof_sa_sigaction() {
    return offsetof(struct sigaction, sa_sigaction);
}

int32_t Sigevent_alignof() {
#if defined(__OpenBSD__)
    return 0;
#else
    return __alignof__ (struct sigevent);
#endif
}

int32_t Sigevent_sizeof() {
#if defined(__OpenBSD__)
    return 0;
#else
    return sizeof (struct sigevent);
#endif
}

int32_t Sigevent_offsetof_sigev_notify() {
#if defined(__OpenBSD__)
    return -1;
#else
    return offsetof(struct sigevent, sigev_notify);
#endif
}

int32_t Sigevent_offsetof_sigev_signo() {
#if defined(__OpenBSD__)
    return -1;
#else
    return offsetof(struct sigevent, sigev_signo);
#endif
}

int32_t Sigevent_offsetof_sigev_value() {
#if defined(__OpenBSD__)
    return -1;
#else
    return offsetof(struct sigevent, sigev_value);
#endif
}

int32_t Sigevent_offsetof_sigev_notify_function() {
#if defined(__OpenBSD__)
    return -1;
#else
    return offsetof(struct sigevent, sigev_notify_function);
#endif
}

int32_t Sigevent_offsetof_sigev_notify_attributes() {
#if defined(__OpenBSD__)
    return -1;
#else
    return offsetof(struct sigevent, sigev_notify_attributes);
#endif
}

int32_t Siginfo_t_alignof() {
    return __alignof__ (siginfo_t);
}

int32_t Siginfo_t_sizeof() {
    return sizeof (siginfo_t);
}

int32_t Siginfo_t_offsetof_si_signo() {
    return offsetof(siginfo_t, si_signo);
}

int32_t Siginfo_t_offsetof_si_code() {
    return offsetof(siginfo_t, si_code);
}

int32_t Siginfo_t_offsetof_si_errno() {
    return offsetof(siginfo_t, si_errno);
}

int32_t Siginfo_t_offsetof_si_pid() {
    return offsetof(siginfo_t, si_pid);
}

int32_t Siginfo_t_offsetof_si_uid() {
    return offsetof(siginfo_t, si_uid);
}

int32_t Siginfo_t_offsetof_si_addr() {
    return offsetof(siginfo_t, si_addr);
}

int32_t Siginfo_t_offsetof_si_status() {
    return offsetof(siginfo_t, si_status);
}

int32_t Siginfo_t_offsetof_si_band() {
#if defined(__OpenBSD__)
    return -1;
#else
    return offsetof(siginfo_t, si_band);
#endif
}

int32_t Siginfo_t_offsetof_si_value() {
    return offsetof(siginfo_t, si_value);
}

int32_t Sigset_t_alignof() {
    return __alignof__ (sigset_t);
}

int32_t Sigset_t_sizeof() {
    return sizeof (sigset_t);
}

int32_t Sigval_alignof() {
    return __alignof__ (union sigval);
}

int32_t Sigval_sizeof() {
    return sizeof (union sigval);
}

int32_t Sigval_offsetof_sival_int() {
    return offsetof(union sigval, sival_int);
}

int32_t Sigval_offsetof_sival_ptr() {
    return offsetof(union sigval, sival_ptr);
}

int32_t Stack_t_alignof() {
    return __alignof__ (stack_t);
}

int32_t Stack_t_sizeof() {
    return sizeof (stack_t);
}

int32_t Stack_t_offsetof_ss_sp() {
    return offsetof(stack_t, ss_sp);
}

int32_t Stack_t_offsetof_ss_size() {
    return offsetof(stack_t, ss_size);
}

int32_t Stack_t_offsetof_ss_flags() {
    return offsetof(stack_t, ss_flags);
}

int32_t Ucontext_t_alignof() {
#if defined(__APPLE__) || defined(__OpenBSD__)
    return 0;
#elif defined(__FreeBSD__)
    return __alignof__ (ucontext_t);
#else
    return __alignof__ (struct ucontext_t);
#endif
}

int32_t Ucontext_t_sizeof() {
#if defined(__APPLE__) || defined(__OpenBSD__)
    return 0;
#elif defined(__FreeBSD__)
    return sizeof (ucontext_t);
#else
    return sizeof (struct ucontext_t);
#endif
}

int32_t Ucontext_t_offsetof_uc_link() {
#if defined(__APPLE__) || defined(__OpenBSD__)
    return -1;
#elif defined(__FreeBSD__)
    return offsetof(ucontext_t, uc_link);
#else
    return offsetof(struct ucontext_t, uc_link);
#endif
}

int32_t Ucontext_t_offsetof_uc_sigmask() {
#if defined(__APPLE__) || defined(__OpenBSD__)
    return -1;
#elif defined(__FreeBSD__)
        return offsetof(ucontext_t, uc_sigmask);
#else
    return offsetof(struct ucontext_t, uc_sigmask);
#endif
}

int32_t Ucontext_t_offsetof_uc_stack() {
#if defined(__APPLE__) || defined(__OpenBSD__)
    return -1;
#elif defined(__FreeBSD__)
    return offsetof(ucontext_t, uc_stack);
#else
    return offsetof(struct ucontext_t, uc_stack);
#endif
}

int32_t Ucontext_t_offsetof_uc_mcontext() {
#if defined(__APPLE__) || defined(__OpenBSD__)
    return -1;
#elif defined(__FreeBSD__)
    return offsetof(ucontext_t, uc_mcontext);
#else
    return offsetof(struct ucontext_t, uc_mcontext);
#endif
}

#endif