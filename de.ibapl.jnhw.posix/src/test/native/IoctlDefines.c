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

#ifndef HAVE_SYS_IOCTL_H

int32_t getValueOf_HAVE_SYS_IOCTL_H() {
    return 0;
}
#else
#include <sys/ioctl.h>
#ifdef  __OpenBSD__
    // for PAGE_SIZE
#include <sys/param.h>
#endif

int32_t getValueOf_HAVE_SYS_IOCTL_H() {
    return 1;
}

int32_t getValueOf_FIONREAD() {
#if defined(__linux__) && defined(__sh__)
    return (int32_t) FIONREAD))
#else
    return FIONREAD;
#endif
}

int32_t getValueOf_TIOCCBRK() {
    return TIOCCBRK;
}

int32_t getValueOf_TIOCEXCL() {
    return TIOCEXCL;
}

int32_t* tryGetValueOf_TIOCGICOUNT(int32_t* value) {
#if defined (__linux__)
    *value = TIOCGICOUNT;
#elif !defined(TIOCGICOUNT)
    value = NULL;
#else
#error "TIOCGICOUNT defined"
#endif
    return value;
}

int32_t* tryGetValueOf_TIOCGSOFTCAR(int32_t* value) {
#if defined (__linux__)
#if defined(__sh__)
    *value = (int32_t) TIOCGSOFTCAR;
#else
    *value =TIOCGSOFTCAR;
#endif
#elif !defined(TIOCGSOFTCAR)
    value = NULL;
#else
#error "TIOCGSOFTCAR defined"
#endif
    return value;
}

int32_t getValueOf_TIOCMBIC() {
#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
    //Just force the conversation or check at runtime sizeof??
    return (int32_t) TIOCMBIC;
#else
    return TIOCMBIC;
#endif
}

int32_t getValueOf_TIOCMBIS() {
#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
    //Just force the conversation or check at runtime sizeof??
    return (int32_t) TIOCMBIS;
#else
    return TIOCMBIS;
#endif
}

int32_t getValueOf_TIOCMGET() {
#if defined(__linux__) && defined(__sh__)
    return (int32_t) TIOCMGET;
#else
    return TIOCMGET;
#endif
}

int32_t* tryGetValueOf_TIOCMIWAIT(int32_t* value) {
#if defined (__linux__)
    *value = TIOCMIWAIT;
#elif !defined(TIOCMIWAIT)
    value = NULL;
#else
#error "TIOCMIWAIT defined"
#endif
    return value;
}

int32_t getValueOf_TIOCMSET() {
#if defined(__APPLE__) || defined (__FreeBSD__) || defined (__OpenBSD__) || (defined(__linux__) && defined(__sparc__))
    //Just force the conversation or check at runtime sizeof??
    return (int32_t) TIOCMSET;
#else
    return TIOCMSET;
#endif
}

int32_t getValueOf_TIOCM_CAR() {
    return TIOCM_CAR;
}

int32_t getValueOf_TIOCM_CD() {
    return TIOCM_CD;
}

int32_t getValueOf_TIOCM_CTS() {
    return TIOCM_CTS;
}

int32_t getValueOf_TIOCM_DSR() {
    return TIOCM_DSR;
}

int32_t getValueOf_TIOCM_DTR() {
    return TIOCM_DTR;
}

int32_t getValueOf_TIOCM_LE() {
    return TIOCM_LE;
}

int32_t getValueOf_TIOCM_RI() {
    return TIOCM_RI;
}

int32_t getValueOf_TIOCM_RNG() {
    return TIOCM_RNG;
}

int32_t getValueOf_TIOCM_RTS() {
    return TIOCM_RTS;
}

int32_t getValueOf_TIOCM_SR() {
    return TIOCM_SR;
}

int32_t getValueOf_TIOCM_ST() {
    return TIOCM_ST;
}

int32_t getValueOf_TIOCOUTQ() {
#if defined(__linux__) && defined(__sh__)
    return (int32_t) TIOCOUTQ;
#else
    return TIOCOUTQ;
#endif
}

int32_t getValueOf_TIOCSBRK() {
    return TIOCSBRK;
}

int32_t* tryGetValueOf_TIOCSSOFTCAR(int32_t* value) {
#if defined (__linux__)
#if defined (__linux__)
    *value = (int32_t) TIOCSSOFTCAR;
#else
    *value = TIOCSSOFTCAR;
#endif
#else
#if !defined(TIOCSSOFTCAR)
    value = NULL;
#else
#error "TIOCSSOFTCAR defined"
#endif
#endif
    return value;
}

int32_t* tryGetValueOf_IOCPARM_MASK(int32_t* value) {
#if defined (__OpenBSD__) || defined (__FreeBSD__) || defined(__APPLE__)
    *value = IOCPARM_MASK;
#elif !defined(IOCPARM_MASK)
    value = NULL;
#else
#error "IOCPARM_MASK defined"
#endif
    return value;
}

int32_t* tryGetValueOf_IOCPARM_MAX(int32_t* value) {
#if defined (__OpenBSD__) || defined (__FreeBSD__) || defined(__APPLE__)
    *value = IOCPARM_MAX;
#elif !defined(IOCPARM_MAX)
    value = NULL;
#else
#error "IOCPARM_MAX defined"
#endif
    return value;
}

int32_t* tryGetValueOf_IOC_VOID(int32_t* value) {
#if defined (__OpenBSD__) || defined (__FreeBSD__) || defined(__APPLE__)
    *value = IOC_VOID;
#elif !defined(IOC_VOID)
    value = NULL;
#else
#error "IOC_VOID defined"
#endif
    return value;
}

int32_t getValueOf_IOC_OUT() {
    return (int32_t) IOC_OUT;
}

int32_t getValueOf_IOC_IN() {
#if defined (__linux__) && (defined(__mips__) || defined(__powerpc__)) || defined(__FreeBSD__)|| defined(__OpenBSD__) || defined(__APPLE__)
    return (int32_t) IOC_IN;
#else
    return IOC_IN;
#endif
}

int32_t getValueOf_IOC_INOUT() {
    return (int32_t) IOC_INOUT;
}

int32_t* tryGetValueOf_IOC_DIRMASK(int32_t* value) {
#if defined (__OpenBSD__)|| defined (__FreeBSD__)|| defined(__APPLE__)
    *value = (int32_t) IOC_DIRMASK;
#elif !defined(IOC_DIRMASK)
    value = NULL;
#else
#error "IOC_DIRMASK defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_NRBITS(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_NRBITS;
#elif !defined(_IOC_NRBITS)
    value = NULL;
#else
#error "_IOC_NRBITS defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_TYPEBITS(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_TYPEBITS;
#elif !defined(_IOC_TYPEBITS)
    value = NULL;
#else
#error "_IOC_TYPEBITS defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_SIZEBITS(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_SIZEBITS;
#elif !defined(_IOC_SIZEBITS)
    value = NULL;
#else
#error "_IOC_SIZEBITS defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_DIRBITS(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_DIRBITS;
#elif !defined(_IOC_DIRBITS)
    value = NULL;
#else
#error "_IOC_DIRBITS defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_NRMASK(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_NRMASK;
#elif !defined(_IOC_NRMASK)
    value = NULL;
#else
#error "_IOC_NRMASK defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_TYPEMASK(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_TYPEMASK;
#elif !defined(_IOC_TYPEMASK)
    value = NULL;
#else
#error "_IOC_TYPEMASK defined"
#endif
    return value;
}


int32_t* tryGetValueOf__IOC_SIZEMASK(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_SIZEMASK;
#elif !defined(_IOC_SIZEMASK)
    value = NULL;
#else
#error "_IOC_SIZEMASK defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_DIRMASK(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_DIRMASK;
#elif !defined(_IOC_DIRMASK)
    value = NULL;
#else
#error "_IOC_DIRMASK defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_NRSHIFT(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_NRSHIFT;
#elif !defined(_IOC_NRSHIFT)
    value = NULL;
#else
#error "_IOC_NRSHIFT defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_TYPESHIFT(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_TYPESHIFT;
#elif !defined(_IOC_TYPESHIFT)
    value = NULL;
#else
#error "_IOC_TYPESHIFT defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_SIZESHIFT(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_SIZESHIFT;
#elif !defined(_IOC_SIZESHIFT)
    value = NULL;
#else
#error "_IOC_SIZESHIFT defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_DIRSHIFT(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_DIRSHIFT;
#elif !defined(_IOC_DIRSHIFT)
    value = NULL;
#else
#error "_IOC_DIRSHIFT defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_NONE(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_NONE;
#elif !defined(_IOC_NONE)
    value = NULL;
#else
#error "_IOC_NONE defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_READ(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_READ;
#elif !defined(_IOC_READ)
    value = NULL;
#else
#error "_IOC_READ defined"
#endif
    return value;
}

int32_t* tryGetValueOf__IOC_WRITE(int32_t* value) {
#if defined (__linux__)
    *value = _IOC_WRITE;
#elif !defined(_IOC_WRITE)
    value = NULL;
#else
#error "_IOC_WRITE defined"
#endif
    return value;
}

int32_t* tryGetValueOf_IOCSIZE_MASK(int32_t* value) {
#if defined (__linux__)
    *value = IOCSIZE_MASK;
#elif !defined(IOCSIZE_MASK)
    value = NULL;
#else
#error "IOCSIZE_MASK defined"
#endif
    return value;
}

int32_t* tryGetValueOf_IOCSIZE_SHIFT(int32_t* value) {
#if defined (__linux__)
    *value = IOCSIZE_SHIFT;
#elif !defined(IOCSIZE_SHIFT)
    value = NULL;
#else
#error "IOCSIZE_SHIFT defined"
#endif
    return value;
}

#endif