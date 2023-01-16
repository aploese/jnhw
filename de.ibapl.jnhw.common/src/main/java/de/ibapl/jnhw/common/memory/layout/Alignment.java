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
package de.ibapl.jnhw.common.memory.layout;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;

/**
 *
 * @author aploese
 */
public enum Alignment {
    AT_1(1) {
        public long doAlignment(long unaligned) {
            return unaligned;
        }

    },
    AT_2(2) {
        public long doAlignment(long unaligned) {
            return (unaligned & 0x1L) == 0 ? unaligned : unaligned + 1;
        }
    },
    AT_4(4) {
        public long doAlignment(long unaligned) {
            final long remainder = unaligned & 0x3L;
            return (remainder == 0) ? unaligned : unaligned + alignof - remainder;
        }
    },
    AT_8(8) {
        public long doAlignment(long unaligned) {
            final long remainder = unaligned & 0x5L;
            return (remainder == 0) ? unaligned : unaligned + alignof - remainder;
        }
    },
    /**
     * aarch64 POSIX->signal.h -> ucontext_t
     */
    AT_16(16) {
        public long doAlignment(long unaligned) {
            final long remainder = unaligned & 0xfL;
            return (remainder == 0) ? unaligned : unaligned + alignof - remainder;
        }
    };

    public static Alignment max(Alignment a1, Alignment a2) {
        return a1.alignof >= a2.alignof ? a1 : a2;
    }

    public static Alignment min(Alignment a1, Alignment a2) {
        return a1.alignof >= a2.alignof ? a2 : a1;
    }

    /**
     * AT_X enumn members will override this, it is basically an unsigned
     * division by zero so there is potential to optimize..
     *
     * @param unaligned
     * @return
     */
    public long doAlignment(long unaligned) {
        final int remainder = (int) Long.remainderUnsigned(unaligned, alignof);
        return (remainder == 0) ? unaligned : unaligned + alignof - remainder;
    }

    private Alignment(int alignof) {
        this.alignof = alignof;
    }

    public final int alignof;

    public static Alignment fromAlignof(int alignof) {
        return switch (alignof) {
            case 1 ->
                AT_1;
            case 2 ->
                AT_2;
            case 4 ->
                AT_4;
            case 8 ->
                AT_8;
            case 16 ->
                AT_16;
            default ->
                throw new IllegalArgumentException("Can't get alignment from alignof: " + alignof);
        };
    }

    public final static Alignment __ALIGN_OF_INT;
    public final static Alignment __ALIGN_OF_STRUCT_INT;

    public final static Alignment __ALIGN_OF_LONG;
    public final static Alignment __ALIGN_OF_STRUCT_LONG;

    public final static Alignment __ALIGN_OF_LONG_LONG;
    public final static Alignment __ALIGN_OF_STRUCT_LONG_LONG;

    public final static Alignment __ALIGN_OF_POINTER;
    public final static Alignment __ALIGN_OF_STRUCT_POINTER;

    public final static Alignment __ALIGN_OF_INT8_T;
    public final static Alignment __ALIGN_OF_STRUCT_INT8_T;

    public final static Alignment __ALIGN_OF_INT16_T;
    public final static Alignment __ALIGN_OF_STRUCT_INT16_T;

    public final static Alignment __ALIGN_OF_INT32_T;
    public final static Alignment __ALIGN_OF_STRUCT_INT32_T;

    public final static Alignment __ALIGN_OF_INT64_T;
    public final static Alignment __ALIGN_OF_STRUCT_INT64_T;

    public final static Alignment __ALIGN_OF_INTPTR_T;
    public final static Alignment __ALIGN_OF_STRUCT_INTPTR_T;

    public final static Alignment __ALIGN_OF_FLOAT;
    public final static Alignment __ALIGN_OF_STRUCT_FLOAT;

    public final static Alignment __ALIGN_OF_DOUBLE;
    public final static Alignment __ALIGN_OF_STRUCT_DOUBLE;

    public final static Alignment __ALIGN_OF_LONG_DOUBLE;
    public final static Alignment __ALIGN_OF_STRUCT_LONG_DOUBLE;

    @Define
    public final static Alignment __BIGGEST_ALIGNMENT__;

    static {
        // This get called after the Constructor of BaseDataType...

        switch (MultiarchTupelBuilder.getMultiarch()) {
            case ARM__LINUX__GNU_EABI, ARM__LINUX__GNU_EABI_HF, MIPS__LINUX__GNU, MIPS_EL__LINUX__GNU -> {
                //32 bit, but __BIGGEST_ALIGNMENT__ is 8
                __BIGGEST_ALIGNMENT__ = Alignment.AT_8;
                __ALIGN_OF_INT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT = Alignment.AT_4;
                __ALIGN_OF_LONG = Alignment.AT_4;
                __ALIGN_OF_STRUCT_LONG = Alignment.AT_4;
                __ALIGN_OF_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_POINTER = Alignment.AT_4;
                __ALIGN_OF_STRUCT_POINTER = Alignment.AT_4;
                __ALIGN_OF_FLOAT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_FLOAT = Alignment.AT_4;
                __ALIGN_OF_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_STRUCT_DOUBLE = switch (MultiarchTupelBuilder.getMultiarch()) {
                    case MIPS_EL__LINUX__GNU, ARM__LINUX__GNU_EABI_HF ->
                        Alignment.AT_8;
                    default ->
                        Alignment.AT_4;
                };
                __ALIGN_OF_LONG_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_INT8_T = Alignment.AT_1;
                __ALIGN_OF_STRUCT_INT8_T = Alignment.AT_1;
                __ALIGN_OF_INT16_T = Alignment.AT_2;
                __ALIGN_OF_STRUCT_INT16_T = Alignment.AT_2;
                __ALIGN_OF_INT32_T = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT32_T = Alignment.AT_4;
                __ALIGN_OF_INT64_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INT64_T = Alignment.AT_8;
                __ALIGN_OF_INTPTR_T = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INTPTR_T = Alignment.AT_4;
            }
            case I386__LINUX__GNU -> {
                //classical 32bit anything is at 4 byte aligned
                __BIGGEST_ALIGNMENT__ = Alignment.AT_16;
                __ALIGN_OF_INT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT = Alignment.AT_4;
                __ALIGN_OF_LONG = Alignment.AT_4;
                __ALIGN_OF_STRUCT_LONG = Alignment.AT_4;
                __ALIGN_OF_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_POINTER = Alignment.AT_4;
                __ALIGN_OF_STRUCT_POINTER = Alignment.AT_4;
                __ALIGN_OF_FLOAT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_FLOAT = Alignment.AT_4;
                __ALIGN_OF_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_STRUCT_DOUBLE = Alignment.AT_4;
                __ALIGN_OF_LONG_DOUBLE = Alignment.AT_4;
                __ALIGN_OF_STRUCT_LONG_DOUBLE = Alignment.AT_4;
                __ALIGN_OF_INT8_T = Alignment.AT_1;
                __ALIGN_OF_STRUCT_INT8_T = Alignment.AT_1;
                __ALIGN_OF_INT16_T = Alignment.AT_2;
                __ALIGN_OF_STRUCT_INT16_T = Alignment.AT_2;
                __ALIGN_OF_INT32_T = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT32_T = Alignment.AT_4;
                //Why is int64_t alighned at 8, but in struct at 4 ????
                __ALIGN_OF_INT64_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INT64_T = Alignment.AT_4;
                __ALIGN_OF_INTPTR_T = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INTPTR_T = Alignment.AT_4;
            }
            case S390_X__LINUX__GNU -> {
                __BIGGEST_ALIGNMENT__ = Alignment.AT_8;
                __ALIGN_OF_INT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT = Alignment.AT_4;
                __ALIGN_OF_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG = Alignment.AT_8;
                __ALIGN_OF_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_POINTER = Alignment.AT_8;
                __ALIGN_OF_STRUCT_POINTER = Alignment.AT_8;
                __ALIGN_OF_FLOAT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_FLOAT = Alignment.AT_4;
                __ALIGN_OF_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_STRUCT_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_LONG_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_INT8_T = Alignment.AT_1;
                __ALIGN_OF_STRUCT_INT8_T = Alignment.AT_1;
                __ALIGN_OF_INT16_T = Alignment.AT_2;
                __ALIGN_OF_STRUCT_INT16_T = Alignment.AT_2;
                __ALIGN_OF_INT32_T = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT32_T = Alignment.AT_4;
                __ALIGN_OF_INT64_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INT64_T = Alignment.AT_8;
                __ALIGN_OF_INTPTR_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INTPTR_T = Alignment.AT_8;
            }
            case MIPS_64__LINUX__GNU_ABI_64, MIPS_64_EL__LINUX__GNU_ABI_64 -> {
                __BIGGEST_ALIGNMENT__ = Alignment.AT_16;
                __ALIGN_OF_INT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT = Alignment.AT_4;
                __ALIGN_OF_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG = Alignment.AT_8;
                __ALIGN_OF_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_POINTER = Alignment.AT_8;
                __ALIGN_OF_STRUCT_POINTER = Alignment.AT_8;
                __ALIGN_OF_FLOAT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_FLOAT = Alignment.AT_4;
                __ALIGN_OF_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_STRUCT_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_LONG_DOUBLE = Alignment.AT_16;
                __ALIGN_OF_STRUCT_LONG_DOUBLE = Alignment.AT_16;
                __ALIGN_OF_INT8_T = Alignment.AT_1;
                __ALIGN_OF_STRUCT_INT8_T = Alignment.AT_1;
                __ALIGN_OF_INT16_T = Alignment.AT_2;
                __ALIGN_OF_STRUCT_INT16_T = Alignment.AT_2;
                __ALIGN_OF_INT32_T = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT32_T = Alignment.AT_4;
                __ALIGN_OF_INT64_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INT64_T = Alignment.AT_8;
                __ALIGN_OF_INTPTR_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INTPTR_T = Alignment.AT_8;
            }
            case AARCH64__LINUX__GNU, POWER_PC_64_LE__LINUX__GNU, RISC_V_64__LINUX__GNU, X86_64__LINUX__GNU -> {
                //classical 64bit anything is at 8 byte aligned
                __BIGGEST_ALIGNMENT__ = Alignment.AT_16;
                __ALIGN_OF_INT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT = Alignment.AT_4;
                __ALIGN_OF_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG = Alignment.AT_8;
                __ALIGN_OF_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_POINTER = Alignment.AT_8;
                __ALIGN_OF_STRUCT_POINTER = Alignment.AT_8;
                __ALIGN_OF_FLOAT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_FLOAT = Alignment.AT_4;
                __ALIGN_OF_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_STRUCT_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_LONG_DOUBLE = Alignment.AT_16;
                __ALIGN_OF_STRUCT_LONG_DOUBLE = Alignment.AT_16;
                __ALIGN_OF_INT8_T = Alignment.AT_1;
                __ALIGN_OF_STRUCT_INT8_T = Alignment.AT_1;
                __ALIGN_OF_INT16_T = Alignment.AT_2;
                __ALIGN_OF_STRUCT_INT16_T = Alignment.AT_2;
                __ALIGN_OF_INT32_T = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT32_T = Alignment.AT_4;
                __ALIGN_OF_INT64_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INT64_T = Alignment.AT_8;
                __ALIGN_OF_INTPTR_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INTPTR_T = Alignment.AT_8;
            }
            case X86_64__WINDOWS__PE32_PLUS -> {
                //classical 64bit anything is at 8 byte aligned long is 4 bytes long ...
                __BIGGEST_ALIGNMENT__ = Alignment.AT_16;
                __ALIGN_OF_INT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT = Alignment.AT_4;
                __ALIGN_OF_LONG = Alignment.AT_4;
                __ALIGN_OF_STRUCT_LONG = Alignment.AT_4;
                __ALIGN_OF_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_POINTER = Alignment.AT_8;
                __ALIGN_OF_STRUCT_POINTER = Alignment.AT_8;
                __ALIGN_OF_FLOAT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_FLOAT = Alignment.AT_4;
                __ALIGN_OF_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_STRUCT_DOUBLE = Alignment.AT_4;
                __ALIGN_OF_LONG_DOUBLE = Alignment.AT_16;
                __ALIGN_OF_STRUCT_LONG_DOUBLE = Alignment.AT_16;
                __ALIGN_OF_INT8_T = Alignment.AT_1;
                __ALIGN_OF_STRUCT_INT8_T = Alignment.AT_1;
                __ALIGN_OF_INT16_T = Alignment.AT_2;
                __ALIGN_OF_STRUCT_INT16_T = Alignment.AT_2;
                __ALIGN_OF_INT32_T = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT32_T = Alignment.AT_4;
                __ALIGN_OF_INT64_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INT64_T = Alignment.AT_8;
                __ALIGN_OF_INTPTR_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INTPTR_T = Alignment.AT_8;
            }
            case AARCH64__OPEN_BSD__BSD, X86_64__DARWIN__BSD, X86_64__FREE_BSD__BSD, X86_64__OPEN_BSD__BSD -> {
                //classical 64bit anything is at 8 byte aligned
                __BIGGEST_ALIGNMENT__ = Alignment.AT_16;
                __ALIGN_OF_INT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT = Alignment.AT_4;
                __ALIGN_OF_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG = Alignment.AT_8;
                __ALIGN_OF_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_STRUCT_LONG_LONG = Alignment.AT_8;
                __ALIGN_OF_POINTER = Alignment.AT_8;
                __ALIGN_OF_STRUCT_POINTER = Alignment.AT_8;
                __ALIGN_OF_FLOAT = Alignment.AT_4;
                __ALIGN_OF_STRUCT_FLOAT = Alignment.AT_4;
                __ALIGN_OF_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_STRUCT_DOUBLE = Alignment.AT_8;
                __ALIGN_OF_LONG_DOUBLE = Alignment.AT_16;
                __ALIGN_OF_STRUCT_LONG_DOUBLE = Alignment.AT_16;
                __ALIGN_OF_INT8_T = Alignment.AT_1;
                __ALIGN_OF_STRUCT_INT8_T = Alignment.AT_1;
                __ALIGN_OF_INT16_T = Alignment.AT_2;
                __ALIGN_OF_STRUCT_INT16_T = Alignment.AT_2;
                __ALIGN_OF_INT32_T = Alignment.AT_4;
                __ALIGN_OF_STRUCT_INT32_T = Alignment.AT_4;
                __ALIGN_OF_INT64_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INT64_T = Alignment.AT_8;
                __ALIGN_OF_INTPTR_T = Alignment.AT_8;
                __ALIGN_OF_STRUCT_INTPTR_T = Alignment.AT_8;
            }
            default ->
                throw new RuntimeException("No alignment values for multiarch: " + MultiarchTupelBuilder.getMultiarch());

        }
    }

    /**
     * calculate the alignment of a field in a structure - the smalles alignment
     * wins.
     *
     * @param structAlignment
     * @param dataTypeAlignment
     * @return
     */
    public static Alignment calcElementAlignmentInStruct(Alignment structAlignment, Alignment dataTypeAlignment) {
        if (structAlignment.alignof < dataTypeAlignment.alignof) {
            //We have a packed structure
            return structAlignment;
        } else {
            return dataTypeAlignment;
        }
    }

}
