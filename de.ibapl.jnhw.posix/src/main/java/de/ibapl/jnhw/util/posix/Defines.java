/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.libloader.Arch;
import de.ibapl.jnhw.libloader.Endianess;
import de.ibapl.jnhw.libloader.MemoryModel;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;

/**
 * get the defines with gcc: create an empty file c.c run
 * {@code gcc -dD -dI -E c.c &gt; c.txt} c.txt contains all macros. add an
 * {@code #include &lt;headerFileName.h>} to get the defines for that header.
 *
 * @author aploese
 */
public class Defines {

    @Define
    public final static IntDefine __aarch64__;

    @Define
    public final static IntDefine __alpha__;

    @Define
    public final static IntDefine __amd64__;

    /**
     */
    @Define
    public final static IntDefine __APPLE__;

    @Define
    public final static IntDefine __arm__;

    @Define
    public final static IntDefine __ARM_ARCH;

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
    public final static int __BYTE_ORDER__;

    /**
     * the major version at compile time
     */
    @Define
    public final static IntDefine __FreeBSD__;

    @Define
    public final static IntDefine __GLIBC__;

    @Define
    public final static IntDefine __GLIBC_MINOR__;

    @Define
    public final static IntDefine __GNU_LIBRARY__;

    @Define
    public final static IntDefine __i386__;

    @Define
    public final static IntDefine __i686__;

    @Define
    public final static IntDefine __ILP32__;

    @Define
    public final static IntDefine __linux__;

    @Define
    public final static IntDefine __LP64__;

    @Define
    public final static IntDefine __mips__;

    @Define
    public final static IntDefine __mips64;

    @Define
    public final static IntDefine __MIPSEB__;

    @Define
    public final static IntDefine __MIPSEL__;

    /**
     *
     */
    @Define
    public final static IntDefine __OpenBSD__;

    @Define
    public final static int __ORDER_BIG_ENDIAN__;

    @Define
    public final static int __ORDER_LITTLE_ENDIAN__;

    @Define
    public final static int __ORDER_PDP_ENDIAN__;

    @Define
    public final static IntDefine __powerpc__;

    @Define
    public final static IntDefine __powerpc64__;

    @Define
    public final static IntDefine __riscv;

    @Define
    public final static IntDefine __s390__;

    @Define
    public final static IntDefine __s390x__;

    @Define
    public final static IntDefine __sh__;

    @Define
    public final static IntDefine __SH4__;

    @Define
    public final static int __SIZEOF_LONG__;

    @Define
    public final static int __SIZEOF_POINTER__;

    @Define
    public final static IntDefine __sparc__;

    @Define
    public final static IntDefine __sparc64__;

    /**
     * size of time_t glibc bits/timesize.h
     *
     */
    @Define
    public final static IntDefine __TIMESIZE;

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

    @Define
    public final static IntDefine __x86_64__;

    @Define
    public final static IntDefine _BSD_SOURCE;

    /**
     * maybe defined in jnhw-posix.h
     *
     */
    @Define
    public final static IntDefine _FILE_OFFSET_BITS;

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

    /**
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {

        final Arch arch = MultiarchTupelBuilder.getArch();
        final OS os = MultiarchTupelBuilder.getOS();
        final Endianess e = MultiarchTupelBuilder.getEndianess();

        __aarch64__ = arch == Arch.AARCH64 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __alpha__ = IntDefine.UNDEFINED;
        __amd64__ = arch == Arch.X86_64 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __arm__ = arch == Arch.ARM ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __ARM_ARCH = switch (arch) {
            case AARCH64 ->
                IntDefine.toIntDefine(8);
            case ARM ->
                IntDefine.toIntDefine(7);
            default ->
                IntDefine.UNDEFINED;
        };
        __i386__ = arch == Arch.I386 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __i686__ = arch == Arch.I386 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __mips__ = (arch == Arch.MIPS) || (arch == Arch.MIPS_64) ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __mips64 = arch == Arch.MIPS_64 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __MIPSEB__ = ((arch == Arch.MIPS) || (arch == Arch.MIPS_64)) && e == Endianess.BIG ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __MIPSEL__ = ((arch == Arch.MIPS) || (arch == Arch.MIPS_64)) && e == Endianess.LITTLE ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __powerpc__ = arch == Arch.POWER_PC_64 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __powerpc64__ = arch == Arch.POWER_PC_64 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __riscv = arch == Arch.RISC_V_64 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __SH4__ = IntDefine.UNDEFINED;
        __s390__ = arch == Arch.S390_X ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __s390x__ = arch == Arch.S390_X ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __sh__ = IntDefine.UNDEFINED;
        __sparc64__ = arch == Arch.SPARC_64 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __sparc__ = arch == Arch.SPARC_64 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __x86_64__ = arch == Arch.X86_64 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;

        __APPLE__ = os == OS.DARWIN ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        _BSD_SOURCE = os == OS.OPEN_BSD ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __FreeBSD__ = os == OS.FREE_BSD ? IntDefine.toIntDefine(13) : IntDefine.UNDEFINED;
        __linux__ = os == OS.LINUX ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;
        __OpenBSD__ = os == OS.OPEN_BSD ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;

        _FILE_OFFSET_BITS = IntDefine.UNDEFINED;
        switch (os) {
            case DARWIN, FREE_BSD, OPEN_BSD -> {
                _LARGEFILE64_SOURCE = IntDefine.UNDEFINED;
                _LARGEFILE_SOURCE = IntDefine.UNDEFINED;
            }
            case LINUX -> {
                _LARGEFILE64_SOURCE = IntDefine.toIntDefine(1);
                _LARGEFILE_SOURCE = IntDefine.toIntDefine(1);
            }
            case WINDOWS -> {
                _LARGEFILE64_SOURCE = IntDefine.UNDEFINED;
                _LARGEFILE_SOURCE = IntDefine.UNDEFINED;
            }
            default ->
                throw new NoClassDefFoundError("No default value for _LARGEFILE64_SOURCE and _LARGEFILE_SOURCE " + MultiarchTupelBuilder.getMultiarch());
        }
        switch (os) {
            case DARWIN, FREE_BSD, OPEN_BSD, LINUX -> {
                _POSIX_C_SOURCE = IntDefine.toIntDefine(200809);
                _XOPEN_SOURCE = IntDefine.toIntDefine(700);
                _XOPEN_SOURCE_EXTENDED = IntDefine.toIntDefine(1);
            }
            case WINDOWS -> {
                _POSIX_C_SOURCE = IntDefine.UNDEFINED;
                _XOPEN_SOURCE = IntDefine.UNDEFINED;
                _XOPEN_SOURCE_EXTENDED = IntDefine.UNDEFINED;
            }
            default ->
                throw new NoClassDefFoundError("No default value for _POSIX_C_SOURCE,_XOPEN_SOURCE and _XOPEN_SOURCE_EXTENDED " + MultiarchTupelBuilder.getMultiarch());
        }

        switch (arch) {
            case AARCH64, I386, MIPS_64, X86_64, POWER_PC_64, RISC_V_64 ->
                __BIGGEST_ALIGNMENT__ = 16;
            case S390_X ->
                __BIGGEST_ALIGNMENT__ = 8;
            case ARM, MIPS ->
                __BIGGEST_ALIGNMENT__ = 8;
            default ->
                throw new NoClassDefFoundError("No default value for __BIGGEST_ALIGNMENT__ " + MultiarchTupelBuilder.getMultiarch());
        }

        switch (os) {
            case LINUX -> {
                __GLIBC_MINOR__ = IntDefine.toIntDefine(36);
                __GLIBC__ = IntDefine.toIntDefine(2);
                __GNU_LIBRARY__ = IntDefine.toIntDefine(6);
            }
            case DARWIN, FREE_BSD, OPEN_BSD -> {
                __GLIBC_MINOR__ = IntDefine.UNDEFINED;
                __GLIBC__ = IntDefine.UNDEFINED;
                __GNU_LIBRARY__ = IntDefine.UNDEFINED;
            }
            case WINDOWS -> {
                __GLIBC_MINOR__ = IntDefine.UNDEFINED;
                __GLIBC__ = IntDefine.UNDEFINED;
                __GNU_LIBRARY__ = IntDefine.UNDEFINED;
            }
            default ->
                throw new NoClassDefFoundError("No default value for __GLIBC__, __GLIBC_MINOR__ and __GNU_LIBRARY__ " + MultiarchTupelBuilder.getMultiarch());
        }

        __ILP32__ = switch (MultiarchTupelBuilder.getMemoryModel()) {
            case ILP32 ->
                switch (MultiarchTupelBuilder.getMultiarch()) {
                    case MIPS_EL__LINUX__GNU, ARM__LINUX__GNU_EABI_HF ->
                        IntDefine.UNDEFINED;
                    default ->
                        IntDefine.toIntDefine(1);
                };
            default ->
                IntDefine.UNDEFINED;
        };
        __LP64__ = MultiarchTupelBuilder.getMemoryModel() == MemoryModel.LP64 ? IntDefine.toIntDefine(1) : IntDefine.UNDEFINED;

        switch (e) {
            case BIG ->
                __BYTE_ORDER__ = 4321;
            case LITTLE ->
                __BYTE_ORDER__ = 1234;
            default ->
                throw new NoClassDefFoundError("No default value for __BYTE_ORDER__  " + MultiarchTupelBuilder.getMultiarch());
        }
        __ORDER_BIG_ENDIAN__ = 4321;
        __ORDER_LITTLE_ENDIAN__ = 1234;
        __ORDER_PDP_ENDIAN__ = 3412;

        __SIZEOF_LONG__ = MultiarchTupelBuilder.getMemoryModel().sizeOf_long.sizeInByte;
        __SIZEOF_POINTER__ = MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer.sizeInByte;

        // __TIMESIZE = IntDefine.UNDEFINED; // glibc > 2.31? IntDefine.toIntDefine(mi.getSizeOfPointer().sizeInBit);
        //Linux
        __TIMESIZE = switch (os) {
            case LINUX ->
                switch (MultiarchTupelBuilder.getMemoryModel()) {
                    case ILP32 ->
                        IntDefine.toIntDefine(BaseDataType.uint64_t.SIZE_OF * 4);
                    case LP64 ->
                        IntDefine.toIntDefine(BaseDataType.uint64_t.SIZE_OF * 8);
                    default ->
                        throw new RuntimeException("Cant handle memory model: " + MultiarchTupelBuilder.getMemoryModel());
                };
            case WINDOWS ->
                IntDefine.UNDEFINED;
            default ->
                throw new NoClassDefFoundError("No default value for __TIMESIZE  " + MultiarchTupelBuilder.getMultiarch());
        };
        __WORDSIZE = switch (os) {
            case OPEN_BSD, WINDOWS ->
                IntDefine.UNDEFINED;
            default ->
                IntDefine.toIntDefine(MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer.sizeInBit);
        };

    }

}
