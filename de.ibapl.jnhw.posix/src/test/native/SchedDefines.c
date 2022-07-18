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
#if !defined(HAVE_SCHED_H) || !defined(_POSIX_VERSION)

int getValueOf_HAVE_SCHED_H() {
    return 0;
}

#else
#include <sched.h>

int getValueOf_HAVE_SCHED_H() {
    return 1;
}

int getValueOf_SCHED_FIFO() {
    return SCHED_FIFO;
}

int getValueOf_SCHED_OTHER() {
    return SCHED_OTHER;
}

int getValueOf_SCHED_RR() {
    return SCHED_RR;
}

int* tryGetValueOf_SCHED_SPORADIC(int* value) {
#if defined (__linux__) || defined(__APPLE__) || defined(__FreeBSD__) || defined(__OpenBSD__)
    value = NULL;
#elif not defined(SCHED_SPORADIC)
#error "SCHED_SPORADIC not defined defined"
#else
    value = SCHED_SPORADIC;
#endif
    return value;
}

#endif
