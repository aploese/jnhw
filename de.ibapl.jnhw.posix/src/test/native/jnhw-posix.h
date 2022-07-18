/**
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

#include "../../../config.h"

//include unistd.h to have _POSIX_VERSION defined...
#if HAVE_UNISTD_H
#include <unistd.h>
#endif

#if _POSIX_C_SOURCE
#include "jnhw-posix-datatypes.h"
#endif

#endif
