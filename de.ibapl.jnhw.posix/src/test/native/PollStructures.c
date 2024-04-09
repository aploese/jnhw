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
#include <poll.h>
#include <errno.h>
#include <unistd.h>

    //for offsetof
#include <stddef.h>


    //see jnhw-posix-datatypes.h why FreeBSD cant do this.
#if !defined(__FreeBSD__)
#include <assert.h>

    static_assert(sizeof (((struct pollfd *) 0)->events) == sizeof (int16_t), "pollfd.events not int16_t size");
    static_assert(sizeof (((struct pollfd *) 0)->revents) == sizeof (int16_t), "pollfd.revents not int16_t size");
    static_assert(sizeof (((struct pollfd *) 0)->fd) == sizeof (int32_t), "pollfd.fd not int32_t size");
    static_assert((typeof (((struct pollfd *) 0)->events)) - 1 < 0, "Not signed");
#endif


int32_t PollFd_alignof() {
    return __alignof__ (struct pollfd);
}

int32_t PollFd_sizeof() {
    return sizeof (struct pollfd);
}

int32_t PollFd_offsetof_fd() {
    return offsetof(struct pollfd, fd);
}

int32_t PollFd_offsetof_events() {
    return offsetof(struct pollfd, events);
}

int32_t PollFd_offsetof_revents() {
    return offsetof(struct pollfd, revents);
}

#endif