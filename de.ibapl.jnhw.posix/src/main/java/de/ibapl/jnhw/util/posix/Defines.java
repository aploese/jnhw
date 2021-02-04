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
import de.ibapl.jnhw.common.util.IntDefine;

/**
 * get the defines with gcc: create an empty file c.c run
 * {@code gcc -dD -dI -E c.c &gt; c.txt} c.txt contains all macros. add an
 * {@code #include &lt;headerFileName.h>} to get the defines for that header.
 *
 * @author aploese
 */
public class Defines {

    /**
     * Make sure the native lib is loaded
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwPosixLoader.touch();

        _BSD_SOURCE = IntDefine.UNDEFINED;
        _FILE_OFFSET_BITS = IntDefine.UNDEFINED;
        _LARGEFILE64_SOURCE = IntDefine.UNDEFINED;
        _LARGEFILE_SOURCE = IntDefine.UNDEFINED;
        _POSIX_C_SOURCE = IntDefine.UNDEFINED;
        _XOPEN_SOURCE = IntDefine.UNDEFINED;
        _XOPEN_SOURCE_EXTENDED = IntDefine.UNDEFINED;

        __aarch64__ = IntDefine.UNDEFINED;
        __alpha__ = IntDefine.UNDEFINED;
        __amd64__ = IntDefine.UNDEFINED;
        __APPLE__ = IntDefine.UNDEFINED;
        __arm__ = IntDefine.UNDEFINED;
        __ARM_ARCH = IntDefine.UNDEFINED;

        __BIGGEST_ALIGNMENT__ = 0;
        __BYTE_ORDER__ = 0;

        __FreeBSD__ = IntDefine.UNDEFINED;

        __GLIBC_MINOR__ = IntDefine.UNDEFINED;
        __GLIBC__ = IntDefine.UNDEFINED;
        __GNU_LIBRARY__ = IntDefine.UNDEFINED;

        __i386__ = IntDefine.UNDEFINED;
        __i686__ = IntDefine.UNDEFINED;
        __ILP32__ = IntDefine.UNDEFINED;

        __linux__ = IntDefine.UNDEFINED;
        __LP64__ = IntDefine.UNDEFINED;

        __mips__ = IntDefine.UNDEFINED;
        __mips64 = IntDefine.UNDEFINED;
        __MIPSEB__ = IntDefine.UNDEFINED;
        __MIPSEL__ = IntDefine.UNDEFINED;
        __MIPS_ARCH = IntDefine.UNDEFINED;

        __ORDER_BIG_ENDIAN__ = 0;
        __ORDER_LITTLE_ENDIAN__ = 0;
        __ORDER_PDP_ENDIAN__ = 0;
        __OpenBSD__ = IntDefine.UNDEFINED;

        __powerpc__ = IntDefine.UNDEFINED;
        __powerpc64__ = IntDefine.UNDEFINED;

        __riscv__ = IntDefine.UNDEFINED;

        __SH4__ = IntDefine.UNDEFINED;
        __SIZEOF_LONG__ = 0;
        __SIZEOF_POINTER__ = 0;
        __s390__ = IntDefine.UNDEFINED;
        __s390x__ = IntDefine.UNDEFINED;
        __sh__ = IntDefine.UNDEFINED;
        __sparc64__ = IntDefine.UNDEFINED;
        __sparc__ = IntDefine.UNDEFINED;

        __TIMESIZE = IntDefine.UNDEFINED;

        __WORDSIZE = IntDefine.UNDEFINED;

        __x86_64__ = IntDefine.UNDEFINED;

        initFields();
    }

    private static native void initFields();

    /**
     * maybe defined in jnhw-posix.h
     *
     */
    @Define
    public final static IntDefine _LARGEFILE_SOURCE;

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
     */
    @Define
    public final static IntDefine _LARGEFILE64_SOURCE;

    /**
     */
    @Define
    public final static IntDefine __APPLE__;

    /**
     * the major version at compile time
     */
    @Define
    public final static IntDefine __FreeBSD__;

    /**
     *
     */
    @Define
    public final static IntDefine __OpenBSD__;

    /**
     * Its defined at different places: glibc: bits/wordsize.h FreeBSD:
     * sys/stdint.h
     *
     * but not at OpenBSD
     *
     * so we keep his here for the moment. _POSIX_C_SOURCE
     *
     */
    @Define
    public final static IntDefine __WORDSIZE;

    /**
     * size of time_t glibc bits/timesize.h
     *
     */
    @Define
    public final static IntDefine __TIMESIZE;

    @Define
    public final static IntDefine __GNU_LIBRARY__;

    @Define
    public final static IntDefine __GLIBC__;

    @Define
    public final static IntDefine __GLIBC_MINOR__;

    @Define
    public final static int __SIZEOF_LONG__;

    @Define
    public final static int __SIZEOF_POINTER__;

    @Define
    public final static IntDefine __LP64__;

    @Define
    public final static IntDefine __ILP32__;

    /**
     * The biggest alignemnt used. If sizeof(struct) is bigger than
     * {@code __BIGGEST_ALIGNMENT__} use an address that is a multiple of
     * {@code __BIGGEST_ALIGNMENT__} as {@code baseaddress}.
     *
     * @return
     */
    @Define
    public final static int __BIGGEST_ALIGNMENT__;

    @Define
    public final static int __ORDER_LITTLE_ENDIAN__;

    @Define
    public final static int __ORDER_BIG_ENDIAN__;

    @Define
    public final static int __ORDER_PDP_ENDIAN__;

    @Define
    public final static int __BYTE_ORDER__;

    /**
     * maybe defined in jnhw-posix.h
     *
     */
    @Define
    public final static IntDefine _FILE_OFFSET_BITS;

    @Define
    public final static IntDefine _BSD_SOURCE;

    /**
     * maybe defined in jnhw-posix.h
     *
     */
    @Define
    public final static IntDefine _POSIX_C_SOURCE;

    /**
     * maybe defined in jnhw-posix.h
     *
     */
    @Define
    public final static IntDefine _XOPEN_SOURCE;

    /**
     * maybe defined in jnhw-posix.h
     *
     */
    @Define
    public final static IntDefine _XOPEN_SOURCE_EXTENDED;

    @Define
    public final static IntDefine __linux__;

    @Define
    public final static IntDefine __aarch64__;

    @Define
    public final static IntDefine __alpha__;

    @Define
    public final static IntDefine __arm__;

    @Define
    public final static IntDefine __ARM_ARCH;

    @Define
    public final static IntDefine __powerpc__;

    @Define
    public final static IntDefine __powerpc64__;

    @Define
    public final static IntDefine __mips__;

    @Define
    public final static IntDefine __mips64;

    @Define
    public final static IntDefine __MIPS_ARCH;

    @Define
    public final static IntDefine __MIPSEB__;

    @Define
    public final static IntDefine __MIPSEL__;

    @Define
    public final static IntDefine __riscv__;

    @Define
    public final static IntDefine __s390__;

    @Define
    public final static IntDefine __s390x__;

    @Define
    public final static IntDefine __sh__;

    @Define
    public final static IntDefine __SH4__;

    @Define
    public final static IntDefine __sparc__;

    @Define
    public final static IntDefine __sparc64__;

    @Define
    public final static IntDefine __i386__;

    @Define
    public final static IntDefine __i686__;

    @Define
    public final static IntDefine __amd64__;

    @Define
    public final static IntDefine __x86_64__;

}
