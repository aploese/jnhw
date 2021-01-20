/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.util.posix;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.exceptions.NotDefinedException;

/**
 * get the defines with gcc: create an empty file c.c run
 * {@code gcc -dD -dI -E c.c &gt; c.txt} c.txt contains all macros. add an
 * {@code #include &lt;headerFileName.h>} to get the defines for that header.
 *
 * @author aploese
 */
public class Defines {

    static {
        LibJnhwPosixLoader.touch();
    }

    /**
     * maybe defined in jnhw-posix.h
     *
     * @throws NotDefinedException if _LARGEFILE_SOURCE is not defined natively.
     */
    @Define
    public static native int _LARGEFILE_SOURCE() throws NotDefinedException;

    /**
     * maybe defined in jnhw-posix.h
     *
     * _LARGEFILE64_SOURCE was defined at native compile time. If
     * _LARGEFILE64_SOURCE was defined then all largefile64 functions (i.e.
     * open64, read64, fseek64, ...) are available.
     *
     *
     * time of the native code.
     *
     * @throws NotDefinedException if _LARGEFILE64_SOURCE is not defined
     * natively.
     */
    @Define
    public static native int _LARGEFILE64_SOURCE() throws NotDefinedException;

    /**
     * @throws NotDefinedException if __APPLE__ is not defined natively.
     */
    @Define
    public static native int __APPLE__() throws NotDefinedException;

    /**
     *
     * @return the major version at compile time
     * @throws NotDefinedException if __FreeBSD__ is not defined natively.
     */
    @Define
    public static native int __FreeBSD__() throws NotDefinedException;

    /**
     *
     * @return the major version at compile time
     * @throws NotDefinedException if __OpenBSD__ is not defined natively.
     */
    @Define
    public static native int __OpenBSD__() throws NotDefinedException;

    /**
     * Its defined at different places: glibc: bits/wordsize.h FreeBSD:
     * sys/stdint.h
     *
     * but not at OpenBSD
     *
     * so we keep his here for the moment. _POSIX_C_SOURCE
     *
     * @throws NotDefinedException if __WORDSIZE is not defined natively.
     */
    @Define
    public static native int __WORDSIZE() throws NotDefinedException;

    /**
     * size of time_t glibc bits/timesize.h
     *
     * @return
     * @throws NotDefinedException
     */
    @Define
    public static native int __TIMESIZE() throws NotDefinedException;

    @Define
    public static native int __GNU_LIBRARY__() throws NotDefinedException;

    @Define
    public static native int __GLIBC__() throws NotDefinedException;

    @Define
    public static native int __GLIBC_MINOR__() throws NotDefinedException;

    @Define
    public static native int __SIZEOF_LONG__();

    @Define
    public static native int __SIZEOF_POINTER__();

    @Define
    public static native int __LP64__() throws NotDefinedException;

    @Define
    public static native int __ILP32__() throws NotDefinedException;

    /**
     * The biggest alignemnt used. If sizeof(struct) is bigger than
     * {@code __BIGGEST_ALIGNMENT__} use an address that is a multiple of
     * {@code __BIGGEST_ALIGNMENT__} as {@code baseaddress}.
     *
     * @return 
     */
    @Define
    public static native int __BIGGEST_ALIGNMENT__();

    @Define
    public static native int __ORDER_LITTLE_ENDIAN__();

    @Define
    public static native int __ORDER_BIG_ENDIAN__();

    @Define
    public static native int __ORDER_PDP_ENDIAN__();

    @Define
    public static native int __BYTE_ORDER__();

    /**
     * maybe defined in jnhw-posix.h
     *
     * @throws NotDefinedException if _FILE_OFFSET_BITS is not defined natively.
     */
    @Define
    public static native int _FILE_OFFSET_BITS() throws NotDefinedException;

    /**
     *
     * @throws NotDefinedException if _BSD_SOURCE is not defined natively.
     */
    @Define
    public static native int _BSD_SOURCE() throws NotDefinedException;

    /**
     * maybe defined in jnhw-posix.h
     *
     * @throws NotDefinedException if _POSIX_C_SOURCE is not defined natively.
     */
    @Define
    public static native int _POSIX_C_SOURCE() throws NotDefinedException;

    /**
     * maybe defined in jnhw-posix.h
     *
     * @throws NotDefinedException if _XOPEN_SOURCE is not defined natively.
     */
    @Define
    public static native int _XOPEN_SOURCE() throws NotDefinedException;

    /**
     * maybe defined in jnhw-posix.h
     *
     * @throws NotDefinedException if _XOPEN_SOURCE_EXTENDED is not defined
     * natively.
     */
    @Define
    public static native int _XOPEN_SOURCE_EXTENDED() throws NotDefinedException;

    /**
     * @throws NotDefinedException if __linux__ is not defined natively.
     */
    @Define
    public static native int __linux__() throws NotDefinedException;

    @Define
    public static native int __aarch64__() throws NotDefinedException;

    @Define
    public static native int __alpha__() throws NotDefinedException;

    @Define
    public static native int __arm__() throws NotDefinedException;

    @Define
    public static native int __ARM_ARCH() throws NotDefinedException;

    @Define
    public static native int __powerpc__() throws NotDefinedException;

    @Define
    public static native int __powerpc64__() throws NotDefinedException;

    @Define
    public static native int __mips__() throws NotDefinedException;

    @Define
    public static native int __mips64() throws NotDefinedException;

    @Define
    public static native int __MIPS_ARCH() throws NotDefinedException;

    @Define
    public static native int __MIPSEB__() throws NotDefinedException;

    @Define
    public static native int __MIPSEL__() throws NotDefinedException;

    @Define
    public static native int __riscv__() throws NotDefinedException;

    @Define
    public static native int __s390__() throws NotDefinedException;

    @Define
    public static native int __s390x__() throws NotDefinedException;

    @Define
    public static native int __sh__() throws NotDefinedException;

    @Define
    public static native int __SH4__() throws NotDefinedException;

    @Define
    public static native int __sparc__() throws NotDefinedException;

    @Define
    public static native int __sparc64__() throws NotDefinedException;

    @Define
    public static native int __i386__() throws NotDefinedException;

    @Define
    public static native int __i686__() throws NotDefinedException;

    @Define
    public static native int __amd64__() throws NotDefinedException;

    @Define
    public static native int __x86_64__() throws NotDefinedException;

}
