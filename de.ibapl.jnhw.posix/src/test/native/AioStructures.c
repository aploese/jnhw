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

#if defined(_POSIX_VERSION) 
#if defined(__OpenBSD__) && defined(HAVE_AIO_H)
#error OpenBSD and aio.h
#endif


#include <aio.h>

    //for offsetof
#include <stddef.h>

int32_t Aiocb_alignof() {
    return __alignof__ (struct aiocb);
}

int32_t Aiocb_sizeof() {
    return sizeof (struct aiocb);
}

int32_t Aiocb_offsetof_aio_fildes() {
    return offsetof(struct aiocb, aio_fildes);
}

int32_t Aiocb_offsetof_aio_offset() {
    return offsetof(struct aiocb, aio_offset);
}

int32_t Aiocb_offsetof_aio_buf() {
    return offsetof(struct aiocb, aio_buf);
}

int32_t Aiocb_offsetof_aio_nbytes() {
    return offsetof(struct aiocb, aio_nbytes);
}

int32_t Aiocb_offsetof_aio_reqprio() {
    return offsetof(struct aiocb, aio_reqprio);
}

int32_t Aiocb_offsetof_aio_sigevent() {
    return offsetof(struct aiocb, aio_sigevent);
}

int32_t Aiocb_offsetof_aio_lio_opcode() {
    return offsetof(struct aiocb, aio_lio_opcode);
}

#endif
