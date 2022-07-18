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
#if defined(HAVE_SYS_IOCTL_H)

#include <sys/ioctl.h>

int get_IOR_int32_t(char arg1, int arg2) {
    return (int32_t) _IOR((uint32_t) arg1, (uint32_t) arg2, int32_t);
}

int get_IOW_int32_t(char arg1, int arg2) {
    return (int32_t) _IOW((uint32_t) arg1, (uint32_t) arg2, int32_t);
}

int get_IOWR_int32_t(char arg1, int arg2) {
    return (int32_t) _IOWR((uint32_t) arg1, (uint32_t) arg2, int32_t);
}

int get_IO(char arg1, int arg2) {
    return (int32_t) _IO((uint32_t) arg1, (uint32_t) arg2);
}

int get_IOC(int arg1, char arg2, int arg3, int arg4) {
    return (int32_t) _IOC((uint32_t) arg1, (uint32_t) arg2, (uint32_t) arg3, (uint32_t) arg4);
}

int* tryGet_IOC_DIR(int* result, int arg1) {
#if defined(__linux__)
    *result = (int32_t) _IOC_DIR((uint32_t) arg1);
#else
    result = NULL;
#endif
    return result;
}

int* tryGet_IOC_NR(int* result, int arg1) {
#if defined(__linux__)
    *result = (int32_t) _IOC_NR((uint32_t) arg1);
#else
    result = NULL;
#endif
    return result;
}

int* tryGet_IOC_SIZE(int* result, int arg1) {
#if defined(__linux__)
    *result = (int32_t) _IOC_SIZE((uint32_t) arg1);
#else
    result = NULL;
#endif
    return result;
}

int* tryGet_IOC_TYPE(int* result, int arg1) {
#if defined(__linux__)
    *result = (int32_t) _IOC_TYPE((uint32_t) arg1);
#else
    result = NULL;
#endif
    return result;
}

int* tryGet_IOCPARM_LEN(int* result, __attribute__ ((unused))int arg1) {
#if defined(__FreeBSD__) || defined(__OpenBSD__) || defined(__APPLE__)
    *result = IOCPARM_LEN((uint32_t) arg1);
#else
    result = NULL;
#endif
    return result;
}

int* tryGet_IOCBASECMD(int* result, __attribute__ ((unused))int arg1) {
#if defined(__FreeBSD__)|| defined(__APPLE__)
    *result = IOCBASECMD(arg1);
#elif defined(__OpenBSD__)
    *result = (int32_t) IOCBASECMD((uint32_t) arg1);
#else
    result = NULL;
#endif
    return result;
}

int* tryGet_IOCGROUP(int* result, __attribute__ ((unused))int arg1) {
#if defined(__FreeBSD__) || defined(__OpenBSD__)|| defined(__APPLE__)
    *result = IOCGROUP((uint32_t) arg1);
#else
    result = NULL;
#endif
    return result;
}


#endif