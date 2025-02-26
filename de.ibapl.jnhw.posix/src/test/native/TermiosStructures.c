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

#ifdef _POSIX_VERSION
#include <termios.h>

    //for offsetof
#include <stddef.h>

int32_t StructTermios_alignof() {
    return __alignof__ (struct termios);
}

int32_t StructTermios_sizeof() {
    return sizeof(struct termios);
}

int32_t StructTermios_offsetof_c_iflag() {
    return offsetof(struct termios, c_iflag);
    }

int32_t StructTermios_offsetof_c_oflag() {
    return offsetof(struct termios, c_oflag);
}

int32_t StructTermios_offsetof_c_cflag() {
    return offsetof(struct termios, c_cflag);
}

int32_t StructTermios_offsetof_c_lflag() {
    return offsetof(struct termios, c_lflag);
}

int32_t StructTermios_offsetof_c_cc() {
    return offsetof(struct termios, c_cc);
}

int32_t StructTermios_offsetof_c_line() {
#if defined(__FreeBSD__) || defined(__OpenBSD__)|| defined(__APPLE__)
    return -1;
#else
    return offsetof(struct termios, c_line);
#endif
}

int32_t StructTermios_offsetof_c_ispeed() {
#if (defined(_HAVE_STRUCT_TERMIOS_C_ISPEED) && _HAVE_STRUCT_TERMIOS_C_ISPEED != 0) || defined(__APPLE__) || defined(__FreeBSD__)
    return offsetof(struct termios, c_ispeed);
#else
    return -1;
#endif
}

int32_t StructTermios_offsetof_c_ospeed() {
#if (defined(_HAVE_STRUCT_TERMIOS_C_OSPEED) && _HAVE_STRUCT_TERMIOS_C_OSPEED != 0) || defined(__APPLE__) || defined(__FreeBSD__)
    return offsetof(struct termios, c_ospeed);
#else
    return -1;
#endif
}

#endif