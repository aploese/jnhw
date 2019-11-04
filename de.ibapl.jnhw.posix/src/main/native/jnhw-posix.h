/**
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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
#ifdef __linux__
//#define _GNU_SOURCE
#define _LARGEFILE64_SOURCE
#endif

#ifdef __FreeBSD__
#define _LARGEFILE64_SOURCE
#endif

//#if defined(__linux__) || defined(__APPLE__) || defined(__FreeBSD__)
//#define _LARGEFILE64_SOURCE
//#endif


#include "jnhw-common.h"
#include "../../../config.h"

#ifndef _jnhw_posix_H
#define _jnhw_posix_H

#ifdef __cplusplus
extern "C" {
#endif
    

#define UNWRAP_STRUCT_TERMIOS_PTR(structTermios) UNWRAP_OPAQUE_MEM_TO(struct termios*, structTermios)

#define UNWRAP_STRUCT_POLLFD_PTR(structPollFd) UNWRAP_OPAQUE_MEM_TO(struct pollfd*, structPollFd)

 #ifdef __cplusplus
}
#endif

#endif
