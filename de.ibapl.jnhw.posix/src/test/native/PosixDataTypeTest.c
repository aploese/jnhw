/**
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2025, Arne Plöse and individual contributors as indicated
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
#if defined(HAVE_SYS_TYPES_H) && defined(_POSIX_VERSION)
#include <sys/types.h>
#include <termios.h>
#include <poll.h>

#define SIGNED 0x01
#define UNSIGNED 0x02
#define NO_SIGN 0x04


#define DATA_TYPE_TEST(name, type) \
int8_t JNHW__ ## name ## __Sign() {return 0 > ((type) - 1) ? SIGNED :  0 < ((type) - 1) ? UNSIGNED : NO_SIGN;} \
int32_t JNHW__sizeof__ ## name () {return sizeof(type);} \
int32_t JNHW__alignof__ ## name () {return __alignof__ (type);}

DATA_TYPE_TEST(cc_t, cc_t)
DATA_TYPE_TEST(clock_t, clock_t)

#ifdef __APPLE__
//TODO clockid_t is an enum
    DATA_TYPE_TEST(clockid_t, int32_t);
#else
    DATA_TYPE_TEST(clockid_t, clockid_t)
#endif

DATA_TYPE_TEST(mode_t, mode_t)
DATA_TYPE_TEST(nfds_t, nfds_t)
DATA_TYPE_TEST(off_t, off_t)
DATA_TYPE_TEST(pid_t, pid_t)
DATA_TYPE_TEST(size_t, size_t)
DATA_TYPE_TEST(speed_t, speed_t)
DATA_TYPE_TEST(ssize_t, ssize_t)
DATA_TYPE_TEST(tcflag_t, tcflag_t)
DATA_TYPE_TEST(time_t, time_t)
DATA_TYPE_TEST(uid_t, uid_t)

#endif