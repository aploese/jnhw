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

    /*
    off_t
    off64_t
    mode_t
    ssize_t
    size_t
    useconds_t
    gid_t
    pid_t
    pthread_t
    pthread_attr_t
    clock_t
    time_t
    clockid_t
    timer_t
    uid_t
     */

    //We need the POSIX version ...
#if !defined(HAVE_SYS_TYPES_H) || !defined(_POSIX_VERSION)

int32_t getValueOf_HAVE_SYS_TYPES_H() {
    return 0;
}
#else
#include <sys/types.h>

int32_t getValueOf_HAVE_SYS_TYPES_H() {
    return 1;
}

#endif