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

    //for offsetof
#include <stddef.h>
#include <unistd.h>

#ifdef _POSIX_VERSION
#include <sched.h>

int Sched_param_alignof() {
    return __alignof__ (struct sched_param);
}

int Sched_param_sizeof() {
    return sizeof (struct sched_param);
}

int Sched_param_offsetof_sched_priority() {
    return offsetof(struct sched_param, sched_priority);
}

int Sched_param_offsetof_sched_ss_low_priority() {
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    return -1;
#else
    return offsetof(struct sched_param, sched_ss_low_priority);
#endif
}

int Sched_param_offsetof_sched_ss_repl_period() {
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    return -1;
#else
    return offsetof(struct sched_param, sched_ss_repl_period);
#endif
}

int Sched_param_offsetof_sched_ss_init_budget() {
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    return -1;
#else
    return offsetof(struct sched_param, sched_ss_init_budget);
#endif
}

int Sched_param_offsetof_sched_ss_max_repl() {
#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    return -1;
#else
    return offsetof(struct sched_param, sched_ss_max_repl);
#endif
}

#endif