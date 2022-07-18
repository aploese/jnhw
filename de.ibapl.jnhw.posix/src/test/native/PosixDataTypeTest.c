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
#if defined(HAVE_SYS_TYPES_H) && defined(_POSIX_VERSION)
#include <sys/types.h>
#include <termios.h>
#include <poll.h>

char JNHW__cc_t__IS__uint8_t() {
#ifdef _JNHW__cc_t__IS__uint8_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__clock_t__IS__int64_t() {
#ifdef _JNHW__clock_t__IS__int64_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__clock_t__IS__uint64_t() {
#ifdef _JNHW__clock_t__IS__uint64_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__clock_t__IS__int32_t() {
#ifdef _JNHW__clock_t__IS__int32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__clockid_t__IS__int32_t() {
#ifdef _JNHW__clockid_t__IS__int32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__off_t__IS__int64_t() {
#ifdef _JNHW__off_t__IS__int64_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__off_t__IS__int32_t() {
#ifdef _JNHW__off_t__IS__int32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__mode_t__IS__uint16_t() {
#ifdef _JNHW__mode_t__IS__uint16_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__mode_t__IS__uint32_t() {
#ifdef _JNHW__mode_t__IS__uint32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__nfds_t__IS__uint32_t() {
#ifdef _JNHW__nfds_t__IS__uint32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__nfds_t__IS__uint64_t() {
#ifdef _JNHW__nfds_t__IS__uint64_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__pid_t__IS__int32_t() {
#ifdef _JNHW__pid_t__IS__int32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__speed_t__IS__uint32_t() {
#ifdef _JNHW__speed_t__IS__uint32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__speed_t__IS__uint64_t() {
#ifdef _JNHW__speed_t__IS__uint64_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__size_t__IS__uint64_t() {
#ifdef _JNHW__size_t__IS__uint64_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__size_t__IS__uint32_t() {
#ifdef _JNHW__size_t__IS__uint32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__ssize_t__IS__int64_t() {
#ifdef _JNHW__ssize_t__IS__int64_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__ssize_t__IS__int32_t() {
#ifdef _JNHW__ssize_t__IS__int32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__tcflag_t__IS__uint32_t() {
#ifdef _JNHW__tcflag_t__IS__uint32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__tcflag_t__IS__uint64_t() {
#ifdef _JNHW__tcflag_t__IS__uint64_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__time_t__IS__int64_t() {
#ifdef _JNHW__time_t__IS__int64_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__time_t__IS__int32_t() {
#ifdef _JNHW__time_t__IS__int32_t
    return 1;
#else
    return 0;
#endif
}

char JNHW__uid_t__IS__uint32_t() {
#ifdef _JNHW__uid_t__IS__uint32_t
    return 1;
#else
    return 0;
#endif
}

#define TEST_PATTERN 0x8000000080008080L;

char JNHW__cc_t__isUnsigned() {
    return 0 < (cc_t) - 1;
}

uint64_t JNHW__cc_t__AS_Uint64_t() {
    return (uint64_t) (cc_t) TEST_PATTERN;
}

char JNHW__clock_t__isSigned() {
    return 0 > (clock_t) - 1;
}

char JNHW__clock_t__isUnsigned() {
    return 0 < (clock_t) - 1;
}

uint64_t JNHW__clock_t__AS_Uint64_t() {
    return (uint64_t) (clock_t) TEST_PATTERN;
}

char JNHW__clockid_t__isSigned() {
    return 0 > (clockid_t) - 1;
}

uint64_t JNHW__clockid_t__AS_Uint64_t() {
    return (uint64_t) (clockid_t) TEST_PATTERN;
}

char JNHW__mode_t__isUnsigned() {
    return 0 < (mode_t) - 1;
}

uint64_t JNHW__mode_t__AS_Uint64_t() {
    return (uint64_t) (mode_t) TEST_PATTERN;
}

char JNHW__nfds_t__isUnsigned() {
    return 0 < (nfds_t) - 1;
}

uint64_t JNHW__nfds_t__AS_Uint64_t() {
    return (uint64_t) (nfds_t) TEST_PATTERN;
}

char JNHW__off_t__isSigned() {
    return 0 > (off_t) - 1;
}

uint64_t JNHW__off_t__AS_Uint64_t() {
    return (uint64_t) (off_t) TEST_PATTERN;
}

char JNHW__pid_t__isSigned() {
    return 0 > (pid_t) - 1;
}

uint64_t JNHW__pid_t__AS_Uint64_t() {
    return (uint64_t) (pid_t) TEST_PATTERN;
}

char JNHW__size_t__isUnsigned() {
    return 0 < (size_t) - 1;
}

uint64_t JNHW__size_t__AS_Uint64_t() {
    return (uint64_t) (size_t) TEST_PATTERN;
}

char JNHW__speed_t__isUnsigned() {
    return 0 < (speed_t) - 1;
}

uint64_t JNHW__speed_t__AS_Uint64_t() {
    return (uint64_t) (speed_t) TEST_PATTERN;
}

char JNHW__ssize_t__isSigned() {
    return 0 > (ssize_t) - 1;
}

uint64_t JNHW__ssize_t__AS_Uint64_t() {
    return (uint64_t) (ssize_t) TEST_PATTERN;
}

char JNHW__tcflag_t__isUnsigned() {
    return 0 < (tcflag_t) - 1;
}

uint64_t JNHW__tcflag_t__AS_Uint64_t() {
    return (uint64_t) (tcflag_t) TEST_PATTERN;
}

char JNHW__time_t__isSigned() {
    return 0 > (time_t) - 1;
}

uint64_t JNHW__time_t__AS_Uint64_t() {
    return (uint64_t) (time_t) TEST_PATTERN;
}

char JNHW__uid_t__isUnsigned() {
    return 0 < (uid_t) - 1;
}

uint64_t JNHW__uid_t__AS_Uint64_t() {
    return (uint64_t) (uid_t) TEST_PATTERN;
}

#endif