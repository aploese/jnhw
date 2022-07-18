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

#include <stdint.h>
#include <unistd.h>


int* tryGetValueOf__BSD_SOURCE(int* value) {
#if defined (_BSD_SOURCE)
    *value = _BSD_SOURCE;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf__FILE_OFFSET_BITS(int* value) {
#if defined (_FILE_OFFSET_BITS)
    *value = _FILE_OFFSET_BITS;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf__LARGEFILE64_SOURCE(int* value) {
#if defined(_LARGEFILE64_SOURCE)
    *value = _LARGEFILE64_SOURCE;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf__LARGEFILE_SOURCE(int* value) {
#if defined(_LARGEFILE_SOURCE)
    *value = _LARGEFILE_SOURCE;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf__POSIX_C_SOURCE(int* value) {
#if defined (_POSIX_C_SOURCE)
    *value = _POSIX_C_SOURCE;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf__XOPEN_SOURCE(int* value) {
#if defined (_XOPEN_SOURCE)
    *value = _XOPEN_SOURCE;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf__XOPEN_SOURCE_EXTENDED(int* value) {
#if defined (_XOPEN_SOURCE_EXTENDED)
    *value = _XOPEN_SOURCE_EXTENDED;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___aarch64__(int* value) {
#if defined(__aarch64__)
    *value = __aarch64__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___alpha__(int* value) {
#if defined(__alpha__)
    *value = __alpha__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___amd64__(int* value) {
#if defined(__amd64__)
    *value = __amd64__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___APPLE__(int* value) {
#if defined(__APPLE__)
    *value = __APPLE__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___arm__(int* value) {
#if defined(__arm__)
    *value = __arm__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___ARM_ARCH(int* value) {
#if defined(__ARM_ARCH)
    *value = __ARM_ARCH;
#else
    value = NULL;
#endif
    return value;
}

int getValueOf___BIGGEST_ALIGNMENT__() {
    return __BIGGEST_ALIGNMENT__;
}

int getValueOf___BYTE_ORDER__() {
    return __BYTE_ORDER__;
}

int* tryGetValueOf___FreeBSD__(int* value) {
#if defined(__FreeBSD__)
    *value = __FreeBSD__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___GLIBC_MINOR__(int* value) {
#if defined(__GLIBC_MINOR__)
    *value = __GLIBC_MINOR__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___GLIBC__(int* value) {
#if defined(__GLIBC__)
    *value = __GLIBC__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___GNU_LIBRARY__(int* value) {
#if defined(__GNU_LIBRARY__)
    *value = __GNU_LIBRARY__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___i386__(int* value) {
#if defined(__i386__)
    *value = __i386__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___i686__(int* value) {
#if defined(__i686__)
    *value = __i686__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___ILP32__(int* value) {
#if defined (__ILP32__)
    *value = __ILP32__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___linux__(int* value) {
#if defined(__linux__)
    *value = __linux__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___LP64__(int* value) {
#if defined (__LP64__)
    *value = __LP64__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___mips__(int* value) {
#if defined(__mips__)
    *value = __mips__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___mips64(int* value) {
#if defined(__mips64)
    *value = __mips64;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___MIPSEB__(int* value) {
#if defined(__MIPSEB__)
    *value = __MIPSEB__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___MIPSEL__(int* value) {
#if defined(__MIPSEL__)
    *value = __MIPSEL__;
#else
    value = NULL;
#endif
    return value;
}

int getValueOf___ORDER_BIG_ENDIAN__() {
    return __ORDER_BIG_ENDIAN__;
}

int getValueOf___ORDER_LITTLE_ENDIAN__() {
    return __ORDER_LITTLE_ENDIAN__;
}

int getValueOf___ORDER_PDP_ENDIAN__() {
    return __ORDER_PDP_ENDIAN__;
}

int* tryGetValueOf___OpenBSD__(int* value) {
#if defined(__OpenBSD__)
    *value = __OpenBSD__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___powerpc__(int* value) {
#if defined(__powerpc__)
    *value = __powerpc__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___powerpc64__(int* value) {
#if defined(__powerpc64__)
    *value = __powerpc64__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___riscv(int* value) {
#if defined( __riscv)
    *value = __riscv;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___SH4__(int* value) {
#if defined(__SH4__)
    *value = __SH4__;
#else
    value = NULL;
#endif
    return value;
}

int getValueOf___SIZEOF_LONG__() {
    return __SIZEOF_LONG__;
}

int getValueOf___SIZEOF_POINTER__() {
    return __SIZEOF_POINTER__;
}

int* tryGetValueOf___s390__(int* value) {
#if defined(__s390__)
    *value = __s390__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___s390x__(int* value) {
#if defined(__s390x__)
    *value = __s390x__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___sh__(int* value) {
#if defined(__sh__)
    *value = __sh__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___sparc64__(int* value) {
#if defined(__sparc64__)
    *value = __sparc64__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___sparc__(int* value) {
#if defined(__sparc__)
    *value = __sparc__;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___TIMESIZE(int* value) {
#if defined(__TIMESIZE)
    *value = __TIMESIZE;
#else
    value = NULL;
#endif
    return value;
}

int* tryGetValueOf___WORDSIZE(int* value) {
#if defined (__WIN32__) || defined(__OpenBSD__)
#if !defined(__WORDSIZE)
    value = NULL;
#else
#error "__WORDSIZE defined"
#endif
#else
    *value = __WORDSIZE;
#endif
    return value;
}

int* tryGetValueOf___x86_64__(int* value) {
#if defined(__x86_64__)
    *value = __x86_64__;
#else
    value = NULL;
#endif
    return value;
}