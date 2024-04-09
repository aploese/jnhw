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

//We need the POSIX version ...
#if !defined(HAVE_UNISTD_H) || !defined(_POSIX_VERSION)

int32_t getValueOf_HAVE_UNISTD_H() {
    return 0;
}

#else
#include <unistd.h>
#include <errno.h>

int32_t getValueOf_HAVE_UNISTD_H() {
    return 1;
}

int64_t getValueOf__POSIX_VERSION() {
    return _POSIX_VERSION;
}

int32_t getValueOf__SC_AIO_LISTIO_MAX() {
    return _SC_AIO_LISTIO_MAX;
}

int32_t getValueOf__SC_AIO_MAX() {
    return _SC_AIO_MAX;
}
int32_t getValueOf__SC_AIO_PRIO_DELTA_MAX() {
    return _SC_AIO_PRIO_DELTA_MAX;
}

int32_t* tryGetValueOf_SEEK_DATA(int32_t* value) {
#if defined(__OpenBSD__)
#if defined(SEEK_DATA)
#error "SEEK_DATA defined"
#endif
    value = NULL;
#else
    *value = SEEK_DATA;
#endif
    return value;
}

int32_t* tryGetValueOf_SEEK_HOLE(int32_t* value) {
#if defined(__OpenBSD__)
#if defined(SEEK_HOLE)
#error "SEEK_HOLE defined"
#endif
    value = NULL;
#else
    *value = SEEK_HOLE;
#endif
    return value;
}

int32_t getValueOf_STDERR_FILENO() {
    return STDERR_FILENO;
}

int32_t getValueOf_STDIN_FILENO() {
    return STDIN_FILENO;
}

int32_t getValueOf_STDOUT_FILENO() {
    return STDOUT_FILENO;
}

int32_t* tryGetValueOf__SC_MINSIGSTKSZ(int32_t* value) {
#if ! defined(_SC_MINSIGSTKSZ)
    value = NULL;
#else
    *value = _SC_MINSIGSTKSZ;
#endif
    return value;
}

int32_t* tryGetValueOf__SC_SIGSTKSZ(int32_t* value) {
#if ! defined(_SC_SIGSTKSZ)
    value = NULL;
#else
    *value = _SC_SIGSTKSZ;
#endif
    return value;
}

#endif