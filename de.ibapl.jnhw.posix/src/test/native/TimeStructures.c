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

#ifdef _POSIX_VERSION
#include <time.h>

//for offsetof
#include <stddef.h>

int Timespec_alignof() {
    return __alignof__ (struct timespec);
}

int Timespec_sizeof() {
    return sizeof (struct timespec);
}

int Timespec_offsetof_tv_sec() {
    return offsetof(struct timespec, tv_sec);
}

int Timespec_offsetof_tv_nsec() {
    return offsetof(struct timespec, tv_nsec);
}

int Itimerspec_alignof() {
#if defined(__APPLE__)
    return 0;
#else
    return __alignof__ (struct itimerspec);
#endif
}

int Itimerspec_sizeof() {
#if defined(__APPLE__)
    return 0;
#else
    return sizeof (struct itimerspec);
#endif
}

int Itimerspec_offsetof_it_interval() {
#if defined(__APPLE__)
    return -1;
#else
    return offsetof(struct itimerspec, it_interval);
#endif
}

int Itimerspec_offsetof_it_value() {
#if defined(__APPLE__)
    return -1;
#else
    return offsetof(struct itimerspec, it_value);
#endif
}

int Timer_t_alignof() {
#if defined(__APPLE__)
    return 0;
#else
    return __alignof__ (timer_t);
#endif
}

int Timer_t_sizeof() {
#if defined(__APPLE__)
    return 0;
#else
    return sizeof (timer_t);
#endif
}

int Tm_alignof() {
    return __alignof__ (struct tm);
}

int Tm_sizeof() {
    return sizeof (struct tm);
}

int Tm_offsetof_tm_sec() {
    return offsetof(struct tm, tm_sec);
}

int Tm_offsetof_tm_min() {
    return offsetof(struct tm, tm_min);
}

int Tm_offsetof_tm_hour() {
    return offsetof(struct tm, tm_hour);
}

int Tm_offsetof_tm_mday() {
    return offsetof(struct tm, tm_mday);
}

int Tm_offsetof_tm_mon() {
    return offsetof(struct tm, tm_mon);
}

int Tm_offsetof_tm_year() {
    return offsetof(struct tm, tm_year);
}

int Tm_offsetof_tm_wday() {
    return offsetof(struct tm, tm_wday);
}

int Tm_offsetof_tm_yday() {
    return offsetof(struct tm, tm_yday);
}

int Tm_offsetof_tm_isdst() {
    return offsetof(struct tm, tm_isdst);
}

#endif