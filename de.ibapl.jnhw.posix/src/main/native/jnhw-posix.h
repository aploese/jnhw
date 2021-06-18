/**
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
#ifndef _jnhw_posix_H
#define _jnhw_posix_H


#if defined(_LP64)
//64 bit

#else
//32 bit
#if defined(_ILP32)
#endif

#endif

#if  defined(__linux__)
#define _GNU_SOURCE

#elif defined(__FreeBSD__)
#define _POSIX_C_SOURCE 200809
#define _XOPEN_SOURCE 700
#define _XOPEN_SOURCE_EXTENDED 1
//force this here, /usr/include/sys/cdefs does not set these if _POSIX_C_SOURCE is defined
#define __BSD_VISIBLE 1
#define __EXT1_VISIBLE 1
//no

#elif defined(__OpenBSD__)
#define _POSIX_C_SOURCE 200809
#define _XOPEN_SOURCE 700
#define _XOPEN_SOURCE_EXTENDED 1
//force this here, /usr/include/sys/cdefs does not set these if _POSIX_C_SOURCE is defined
#define _BSD_SOURCE 1

#elif defined(__APPLE__)
#define _POSIX_C_SOURCE 200809
#define _XOPEN_SOURCE 700
#define _XOPEN_SOURCE_EXTENDED 1
#define _DARWIN_C_SOURCE 1
#endif


//#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__)
//#define _LARGEFILE64_SOURCE
//#endif

#include "jnhw-common.h"

#include "../../../config.h"

//include unistd.h to have _POSIX_VERSION defined...
#if HAVE_UNISTD_H
#include <unistd.h>
#endif

#if _POSIX_C_SOURCE
#include "jnhw-posix-datatypes.h"

#if defined(_JNHW__clock_t__IS__int32_t)
#if defined(__linux__)
//error if we use JNHW_FORMAT_STRING_int32_t, we will get: format ‘%d’ expects argument of type ‘int’, but argument 4 has type ‘clock_t’ {aka ‘long int’}
#define JNHW_FORMAT_STRING_clock_t "%ld"
#else
#define JNHW_FORMAT_STRING_clock_t JNHW_FORMAT_STRING_int32_t
#endif
#elif defined(_JNHW__clock_t__IS__int64_t)
#define JNHW_FORMAT_STRING_clock_t JNHW_FORMAT_STRING_int64_t
#else
#error expected clock_t is int32_t or int64_t
#endif

#if defined(_JNHW__mode_t__IS__uint16_t)
#define JNHW_FORMAT_STRING_mode_t JNHW_FORMAT_STRING_uint16_t
#elif defined(_JNHW__mode_t__IS__uint32_t)
#define JNHW_FORMAT_STRING_mode_t JNHW_FORMAT_STRING_uint32_t
#else
#error expected mode_t is uint16_t or uint32_t
#endif

#if defined(_JNHW__off_t__IS__int32_t)
#if defined(__linux__)
//error if we use JNHW_FORMAT_STRING_int32_t, we will get: format ‘%d’ expects argument of type ‘int’, but argument 4 has type ‘off_t’ {aka ‘long int’}
#define JNHW_FORMAT_STRING_off_t "%ld"
#else
#define JNHW_FORMAT_STRING_off_t JNHW_FORMAT_STRING_int32_t
#endif
#elif defined(_JNHW__off_t__IS__int64_t)
#define JNHW_FORMAT_STRING_off_t JNHW_FORMAT_STRING_int64_t
#else
#error expected off_t is int32_t or int64_t
#endif

#if defined(_JNHW__pid_t__IS__int32_t)
#define JNHW_FORMAT_STRING_pid_t JNHW_FORMAT_STRING_int32_t
#else
#error expected pid_t is int32_t
#endif

#if defined(_JNHW__size_t__IS__uint32_t)
#define JNHW_FORMAT_STRING_size_t JNHW_FORMAT_STRING_uint32_t
#elif defined(_JNHW__size_t__IS__uint64_t)
#if defined(__OpenBSD__)
//error if we use JNHW_FORMAT_STRING_uint64_t, we will get: format specifies type 'unsigned long long' but the argument has type 'size_t' (aka 'unsigned long')
#define JNHW_FORMAT_STRING_size_t "%lu"
#else
#define JNHW_FORMAT_STRING_size_t JNHW_FORMAT_STRING_uint64_t
#endif
#else
#error expected size_t is uint32_t or uint64_t
#endif

#if defined(_JNHW__ssize_t__IS__int32_t)
#define JNHW_FORMAT_STRING_ssize_t JNHW_FORMAT_STRING_int32_t
#elif defined(_JNHW__ssize_t__IS__int64_t)
#if defined(__OpenBSD__)
//error if we use JNHW_FORMAT_STRING_uint64_t, we will get: format specifies type 'long long' but the argument has type 'ssize_t' (aka 'long')
#define JNHW_FORMAT_STRING_ssize_t "%ld"
#else
#define JNHW_FORMAT_STRING_ssize_t JNHW_FORMAT_STRING_int64_t
#endif
#else
#error expected ssize_t is int32_t or int64_t
#endif

#if defined(_JNHW__time_t__IS__int32_t)
#if defined(__linux__)
//error if we use JNHW_FORMAT_STRING_int32_t, we will get: format ‘%d’ expects argument of type ‘int’, but argument 4 has type ‘time_t’ {aka ‘long int’}
#define JNHW_FORMAT_STRING_time_t "%ld"
#else
#define JNHW_FORMAT_STRING_time_t JNHW_FORMAT_STRING_int32_t
#endif
#elif defined(_JNHW__time_t__IS__int64_t)
#define JNHW_FORMAT_STRING_time_t JNHW_FORMAT_STRING_int64_t
#else
#error expected time_t is int32_t or int64_t
#endif

#if defined(_JNHW__uid_t__IS__uint32_t)
#define JNHW_FORMAT_STRING_uid_t JNHW_FORMAT_STRING_uint32_t
#else
#error expected uid_t is uint32_t
#endif


#ifdef __cplusplus
extern "C" {
#endif

#if __BYTE_ORDER__ == __ORDER_BIG_ENDIAN__
    //Convert a jlong to (long int *) the pointer must be shifted by sizeof(long int)
#define __jlong2long_PTR(value) ((long int *) &value) + 1
    //Convert a jlong to (long int *)
#elif __BYTE_ORDER__ == __ORDER_LITTLE_ENDIAN__
#define __jlong2long_PTR(value) (long int *) &value

#else
#error "Can't handle byte order"
#endif

#ifdef __cplusplus
}
#endif

#endif

#endif
