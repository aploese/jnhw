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
#include <time.h>

//for offsetof
#include <stddef.h>

int32_t Timespec_alignof() {
    return __alignof__ (struct timespec);
}

int32_t Timespec_sizeof() {
    return sizeof (struct timespec);
}

int32_t Timespec_offsetof_tv_sec() {
    return offsetof(struct timespec, tv_sec);
}

int32_t Timespec_offsetof_tv_nsec() {
    return offsetof(struct timespec, tv_nsec);
}

int32_t Itimerspec_alignof() {
#if defined(__APPLE__)
    return 0;
#else
    return __alignof__ (struct itimerspec);
#endif
}

int32_t Itimerspec_sizeof() {
#if defined(__APPLE__)
    return 0;
#else
    return sizeof (struct itimerspec);
#endif
}

int32_t Itimerspec_offsetof_it_interval() {
#if defined(__APPLE__)
    return -1;
#else
    return offsetof(struct itimerspec, it_interval);
#endif
}

int32_t Itimerspec_offsetof_it_value() {
#if defined(__APPLE__)
    return -1;
#else
    return offsetof(struct itimerspec, it_value);
#endif
}

int32_t Timer_t_alignof() {
#if defined(__APPLE__)
    return 0;
#else
    return __alignof__ (timer_t);
#endif
}

int32_t Timer_t_sizeof() {
#if defined(__APPLE__)
    return 0;
#else
    return sizeof (timer_t);
#endif
}

int32_t Tm_alignof() {
    return __alignof__ (struct tm);
}

int32_t Tm_sizeof() {
    return sizeof (struct tm);
}

int32_t Tm_offsetof_tm_sec() {
    return offsetof(struct tm, tm_sec);
}

int32_t Tm_offsetof_tm_min() {
    return offsetof(struct tm, tm_min);
}

int32_t Tm_offsetof_tm_hour() {
    return offsetof(struct tm, tm_hour);
}

int32_t Tm_offsetof_tm_mday() {
    return offsetof(struct tm, tm_mday);
}

int32_t Tm_offsetof_tm_mon() {
    return offsetof(struct tm, tm_mon);
}

int32_t Tm_offsetof_tm_year() {
    return offsetof(struct tm, tm_year);
}

int32_t Tm_offsetof_tm_wday() {
    return offsetof(struct tm, tm_wday);
}

int32_t Tm_offsetof_tm_yday() {
    return offsetof(struct tm, tm_yday);
}

int32_t Tm_offsetof_tm_isdst() {
    return offsetof(struct tm, tm_isdst);
}

#endif