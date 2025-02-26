/*
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
package de.ibapl.jnhw.common.memory.layout;

import de.ibapl.jnhw.common.annotation.Define;
import static de.ibapl.jnhw.libloader.Arch.S390_X;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.SizeInByte;

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

    public final static Alignment __ALIGN_OF_INT = AT_4;
    public final static Alignment __ALIGN_OF_STRUCT_INT = AT_4;

    public final static Alignment __ALIGN_OF_LONG;
    public final static Alignment __ALIGN_OF_STRUCT_LONG;

    public final static Alignment __ALIGN_OF_LONG_LONG = AT_8;
    public final static Alignment __ALIGN_OF_STRUCT_LONG_LONG = AT_8;

    public final static Alignment __ALIGN_OF_POINTER;
    public final static Alignment __ALIGN_OF_STRUCT_POINTER;

    public final static Alignment __ALIGN_OF_INT8_T = AT_1;
    public final static Alignment __ALIGN_OF_STRUCT_INT8_T = AT_1;

    public final static Alignment __ALIGN_OF_INT16_T = AT_2;
    public final static Alignment __ALIGN_OF_STRUCT_INT16_T = AT_2;

    public final static Alignment __ALIGN_OF_INT32_T = AT_4;
    public final static Alignment __ALIGN_OF_STRUCT_INT32_T = AT_4;

    public final static Alignment __ALIGN_OF_INT64_T;
    public final static Alignment __ALIGN_OF_STRUCT_INT64_T;

    public final static Alignment __ALIGN_OF_INTPTR_T;
    public final static Alignment __ALIGN_OF_STRUCT_INTPTR_T;

    public final static Alignment __ALIGN_OF_FLOAT = AT_4;
    public final static Alignment __ALIGN_OF_STRUCT_FLOAT = AT_4;

    public final static Alignment __ALIGN_OF_DOUBLE;
    public final static Alignment __ALIGN_OF_STRUCT_DOUBLE;

    public final static SizeInByte __SIZE_OF_LONG_DOUBLE;
    public final static Alignment __ALIGN_OF_LONG_DOUBLE;
    public final static Alignment __ALIGN_OF_STRUCT_LONG_DOUBLE;

    @Define
    public final static Alignment __BIGGEST_ALIGNMENT__;

    static {
        //We need this to init enum BaseDataType
        switch (MultiarchTupelBuilder.getMemoryModel()) {
            case ILP32 -> {
                __BIGGEST_ALIGNMENT__ = switch (MultiarchTupelBuilder.getArch()) {
                    case I386, POWER_PC ->
                        Alignment.AT_16;
                    default ->
                        Alignment.AT_8;
                };
                __ALIGN_OF_LONG = AT_4;
                __ALIGN_OF_STRUCT_LONG = AT_4;
                __ALIGN_OF_INT64_T = AT_8;
                __ALIGN_OF_STRUCT_INT64_T = switch (MultiarchTupelBuilder.getArch()) {
                    case I386 ->
                        //Why is int64_t aligned at 8, but in struct at 4 on i386?
                        AT_4;
                    default ->
                        AT_8;
                };
                __ALIGN_OF_POINTER = AT_4;
                __ALIGN_OF_STRUCT_POINTER = AT_4;

                __ALIGN_OF_DOUBLE = AT_8;
                __ALIGN_OF_STRUCT_DOUBLE = switch (MultiarchTupelBuilder.getArch()) {
                    case I386 ->
                        //Why is double aligned at 8, but in struct at 4 on i386?
                        AT_4;
                    default ->
                        AT_8;
                };
                switch (MultiarchTupelBuilder.getArch()) {
                    case POWER_PC -> {
                        __SIZE_OF_LONG_DOUBLE = SizeInByte._16_Byte;
                        __ALIGN_OF_LONG_DOUBLE = AT_16;
                        __ALIGN_OF_STRUCT_LONG_DOUBLE = AT_16;
                    }
                    case I386 -> {
                        __SIZE_OF_LONG_DOUBLE = SizeInByte._12_Byte;
                        __ALIGN_OF_LONG_DOUBLE = AT_4;
                        __ALIGN_OF_STRUCT_LONG_DOUBLE = AT_4;
                    }
                    default -> {
                        __SIZE_OF_LONG_DOUBLE = SizeInByte._8_Byte;
                        __ALIGN_OF_LONG_DOUBLE = AT_8;
                        __ALIGN_OF_STRUCT_LONG_DOUBLE = AT_8;
                    }
                }
            }
            case LP64 -> {
                __BIGGEST_ALIGNMENT__ = switch (MultiarchTupelBuilder.getArch()) {
                    case S390_X ->
                        AT_8;
                    default ->
                        AT_16;
                };
                __ALIGN_OF_LONG = AT_8;
                __ALIGN_OF_STRUCT_LONG = AT_8;
                __ALIGN_OF_INT64_T = AT_8;
                __ALIGN_OF_STRUCT_INT64_T = AT_8;
                __ALIGN_OF_POINTER = AT_8;
                __ALIGN_OF_STRUCT_POINTER = AT_8;

                __ALIGN_OF_DOUBLE = AT_8;
                __ALIGN_OF_STRUCT_DOUBLE = AT_8;
                __SIZE_OF_LONG_DOUBLE = SizeInByte._16_Byte;
                switch (MultiarchTupelBuilder.getArch()) {
                    case S390_X -> {
                        __ALIGN_OF_LONG_DOUBLE = AT_8;
                        __ALIGN_OF_STRUCT_LONG_DOUBLE = AT_8;
                    }
                    default -> {
                        __ALIGN_OF_LONG_DOUBLE = AT_16;
                        __ALIGN_OF_STRUCT_LONG_DOUBLE = AT_16;
                    }
                };
            }
            case LLP64 -> {
                __BIGGEST_ALIGNMENT__ = AT_16;
                __ALIGN_OF_LONG = AT_4;
                __ALIGN_OF_STRUCT_LONG = AT_4;
                __ALIGN_OF_INT64_T = AT_8;
                __ALIGN_OF_STRUCT_INT64_T = AT_8;
                __ALIGN_OF_POINTER = AT_8;
                __ALIGN_OF_STRUCT_POINTER = AT_8;

                __ALIGN_OF_DOUBLE = AT_8;
                __ALIGN_OF_STRUCT_DOUBLE = AT_8;
                __SIZE_OF_LONG_DOUBLE = SizeInByte._16_Byte;
                __ALIGN_OF_LONG_DOUBLE = AT_16;
                __ALIGN_OF_STRUCT_LONG_DOUBLE = AT_16;
            }
            default ->
                throw new RuntimeException("No alignment values for memorymodel: " + MultiarchTupelBuilder.getMemoryModel() + " of multiarch: " + MultiarchTupelBuilder.getMultiarch());
        }
        __ALIGN_OF_INTPTR_T = __ALIGN_OF_POINTER;
        __ALIGN_OF_STRUCT_INTPTR_T = __ALIGN_OF_STRUCT_POINTER;
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
