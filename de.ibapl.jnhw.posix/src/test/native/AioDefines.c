/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
#if !defined(HAVE_AIO_H) || !defined(_POSIX_VERSION)

int32_t getValueOf_HAVE_AIO_H() {
    return 0;
}

#else

#if defined(__OpenBSD__)
#error OpenBSD and aio.h
#endif

#include <aio.h>

int32_t getValueOf_HAVE_AIO_H() {
    return 1;
}


int32_t* tryGetValueOf_AIO_ALLDONE(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__) || defined(__APPLE__)
    *value = AIO_ALLDONE;
#else
#if !defined(AIO_ALLDONE)
    value = NULL;
#else
#error "AIO_ALLDONE defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_AIO_CANCELED(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__) || defined(__APPLE__)
    *value = AIO_CANCELED;
#else
#if !defined(AIO_CANCELED)
    value = NULL;
#else
#error "AIO_CANCELED defined"
#endif
#endif
    return value;
}


int32_t* tryGetValueOf_AIO_NOTCANCELED(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__) || defined(__APPLE__)
    *value = AIO_NOTCANCELED;
#else
#if !defined(AIO_NOTCANCELED)
    value = NULL;
#else
#error "AIO_NOTCANCELED defined"
#endif
#endif
    return value;
}


int32_t* tryGetValueOf_LIO_NOP(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__) || defined(__APPLE__)
    *value = LIO_NOP;
#else
#if !defined(LIO_NOP)
    value = NULL;
#else
#error "LIO_NOP defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_LIO_NOWAIT(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__) || defined(__APPLE__)
    *value = LIO_NOWAIT;
#else
#if !defined(LIO_NOWAIT)
    value = NULL;
#else
#error "LIO_NOWAIT defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_LIO_READ(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__) || defined(__APPLE__)
    *value = LIO_READ;
#else
#if !defined(LIO_READ)
    value = NULL;
#else
#error "LIO_READ defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_LIO_WAIT(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__) || defined(__APPLE__)
    *value = LIO_WAIT;
#else
#if !defined(LIO_WAIT)
    value = NULL;
#else
#error "LIO_WAIT defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_LIO_WRITE(int32_t* value) {
#if defined (__linux__) || defined(__FreeBSD__) || defined(__APPLE__)
    *value = LIO_WRITE;
#else
#if !defined(LIO_WRITE)
    value = NULL;
#else
#error "LIO_WRITE defined"
#endif
#endif
    return value;
}

#endif
