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
package de.ibapl.jnhw.common.datatypes;

import de.ibapl.jnhw.common.LibJnhwCommonLoader;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import static de.ibapl.jnhw.common.memory.layout.Alignment.*;
import de.ibapl.jnhw.libloader.MultiarchInfo;

/**
 *
 * @author aploese
 */
public enum BaseDataType {
    int8_t(1, __ALIGN_OF_INT8_T, __ALIGN_OF_INT8_T, false),
    uint8_t(1, __ALIGN_OF_INT8_T, __ALIGN_OF_INT8_T, true),
    int16_t(2, __ALIGN_OF_INT16_T, __ALIGN_OF_STRUCT_INT16_T, false),
    uint16_t(2, __ALIGN_OF_INT16_T, __ALIGN_OF_STRUCT_INT16_T, true),
    int32_t(4, __ALIGN_OF_INT32_T, __ALIGN_OF_STRUCT_INT32_T, false),
    uint32_t(4, __ALIGN_OF_INT32_T, __ALIGN_OF_STRUCT_INT32_T, true),
    _long(getSizeOf_long(), __ALIGN_OF_LONG, __ALIGN_OF_STRUCT_LONG, false),
    _unsigned_long(getSizeOf_long(), __ALIGN_OF_LONG, __ALIGN_OF_STRUCT_LONG, false),
    _float(getSizeOf_float(), __ALIGN_OF_FLOAT, __ALIGN_OF_STRUCT_FLOAT, false),
    _double(getSizeOf_double(), __ALIGN_OF_DOUBLE, __ALIGN_OF_STRUCT_DOUBLE, false),
    _long_double(getSizeOf_long_double(), __ALIGN_OF_LONG_DOUBLE, __ALIGN_OF_STRUCT_LONG_DOUBLE, false),
    int64_t(8, __ALIGN_OF_INT64_T, __ALIGN_OF_STRUCT_INT64_T, false),
    uint64_t(8, __ALIGN_OF_INT64_T, __ALIGN_OF_STRUCT_INT64_T, true),
    struct(0, null),
    union(0, null),
    array(null, null),
    intptr_t(getSizeOfPointer(), __ALIGN_OF_INTPTR_T, __ALIGN_OF_STRUCT_INTPTR_T, false),
    uintptr_t(getSizeOfPointer(), __ALIGN_OF_INTPTR_T, __ALIGN_OF_STRUCT_INTPTR_T, true),
    function(getSizeOfPointer(), __ALIGN_OF_POINTER),
    /**
     * the infamous void*
     */
    pointer(getSizeOfPointer(), __ALIGN_OF_POINTER);

    public static BaseDataType getSigned_Long_Mapping() {
        switch (__SIZE_OF_LONG) {
            case 4:
                return int32_t;
            case 8:
                return int64_t;
            default:
                throw new RuntimeException("Unexpected size of long");
        }
    }

    public static BaseDataType getUnsigned_Long_Mapping() {
        switch (__SIZE_OF_LONG) {
            case 4:
                return uint32_t;
            case 8:
                return uint64_t;
            default:
                throw new RuntimeException("Unexpected size of long");
        }
    }

    private BaseDataType(int sizeof, Alignment alignof, Alignment alignInStructure, boolean unsigned) {
        this.UNSIGNED = unsigned;
        this.ALIGN_OF = alignof;
        this.ALIGN_IN_STRUCT = alignInStructure;
        this.SIZE_OF = sizeof;
    }

    /**
     *
     * ALIGN_IN_STRUCT == ALIGN_OF
     *
     * @param sizeof
     * @param alignment
     */
    private BaseDataType(Integer sizeof, Alignment alignment) {
        this.UNSIGNED = null;
        this.SIZE_OF = sizeof;
        this.ALIGN_OF = alignment;
        this.ALIGN_IN_STRUCT = alignment;
    }

    public final Boolean UNSIGNED;
    public final Alignment ALIGN_OF;
    public final Alignment ALIGN_IN_STRUCT;
    public final Integer SIZE_OF;

    public final static int __SIZE_OF_POINTER;
    public final static int __SIZE_OF_LONG;
    public final static int __SIZE_OF_FLOAT;
    public final static int __SIZE_OF_DOUBLE;
    public final static int __SIZE_OF_LONG_DOUBLE;

    private final static int getSizeOf_long() {
        LibJnhwCommonLoader.touch();
        final MultiarchInfo mi = LibJnhwCommonLoader.getLoadResult().multiarchInfo;
        switch (mi) {
            case ARM__LINUX__GNU_EABI:
            case ARM__LINUX__GNU_EABI_HF:
            case MIPS__LINUX__GNU:
            case MIPS_EL__LINUX__GNU:
            case I386__LINUX__GNU:
            case X86_64__WINDOWS__PE32_PLUS:
                return 4;
            case AARCH64__LINUX__GNU:
            case AARCH64__OPEN_BSD__BSD:
            case MIPS_64__LINUX__GNU_ABI_64:
            case MIPS_64_EL__LINUX__GNU_ABI_64:
            case POWER_PC_64_LE__LINUX__GNU:
            case RISC_V_64__LINUX__GNU:
            case S390_X__LINUX__GNU:
            case X86_64__FREE_BSD__BSD:
            case X86_64__LINUX__GNU:
            case X86_64__OPEN_BSD__BSD:
                return 8;
            default:
                throw new RuntimeException("No Sizeof long values for multiarch: " + mi);

        }

    }

    private final static int getSizeOf_float() {
        final MultiarchInfo mi = LibJnhwCommonLoader.getLoadResult().multiarchInfo;
        switch (mi) {
            case AARCH64__LINUX__GNU:
            case AARCH64__OPEN_BSD__BSD:
            case ARM__LINUX__GNU_EABI:
            case ARM__LINUX__GNU_EABI_HF:
            case I386__LINUX__GNU:
            case MIPS__LINUX__GNU:
            case MIPS_EL__LINUX__GNU:
            case MIPS_64__LINUX__GNU_ABI_64:
            case MIPS_64_EL__LINUX__GNU_ABI_64:
            case POWER_PC_64_LE__LINUX__GNU:
            case RISC_V_64__LINUX__GNU:
            case S390_X__LINUX__GNU:
            case X86_64__LINUX__GNU:
            case X86_64__WINDOWS__PE32_PLUS:
            case X86_64__OPEN_BSD__BSD:
            case X86_64__FREE_BSD__BSD:
                return 4;
            default:
                throw new RuntimeException("No sizeof float values for multiarch: " + mi);

        }
    }

    private final static int getSizeOf_double() {
        final MultiarchInfo mi = LibJnhwCommonLoader.getLoadResult().multiarchInfo;
        switch (mi) {
            case AARCH64__LINUX__GNU:
            case AARCH64__OPEN_BSD__BSD:
            case ARM__LINUX__GNU_EABI:
            case ARM__LINUX__GNU_EABI_HF:
            case I386__LINUX__GNU:
            case MIPS__LINUX__GNU:
            case MIPS_EL__LINUX__GNU:
            case MIPS_64__LINUX__GNU_ABI_64:
            case MIPS_64_EL__LINUX__GNU_ABI_64:
            case POWER_PC_64_LE__LINUX__GNU:
            case RISC_V_64__LINUX__GNU:
            case S390_X__LINUX__GNU:
            case X86_64__LINUX__GNU:
            case X86_64__WINDOWS__PE32_PLUS:
            case X86_64__OPEN_BSD__BSD:
            case X86_64__FREE_BSD__BSD:
                return 8;
            default:
                throw new RuntimeException("No sizeof double values for multiarch: " + mi);

        }
    }

    private final static int getSizeOf_long_double() {
        final MultiarchInfo mi = LibJnhwCommonLoader.getLoadResult().multiarchInfo;
        switch (mi) {
            case ARM__LINUX__GNU_EABI:
            case ARM__LINUX__GNU_EABI_HF:
            case MIPS__LINUX__GNU:
            case MIPS_EL__LINUX__GNU:
                return 8;
            case I386__LINUX__GNU:
                return 12;
            case AARCH64__LINUX__GNU:
            case AARCH64__OPEN_BSD__BSD:
            case MIPS_64__LINUX__GNU_ABI_64:
            case MIPS_64_EL__LINUX__GNU_ABI_64:
            case POWER_PC_64_LE__LINUX__GNU:
            case RISC_V_64__LINUX__GNU:
            case S390_X__LINUX__GNU:
            case X86_64__LINUX__GNU:
            case X86_64__WINDOWS__PE32_PLUS:
            case X86_64__OPEN_BSD__BSD:
            case X86_64__FREE_BSD__BSD:
                return 16;
            default:
                throw new RuntimeException("No sizeof long double values for multiarch: " + mi);

        }
    }

    private final static int getSizeOfPointer() {
        LibJnhwCommonLoader.touch();
        final MultiarchInfo mi = LibJnhwCommonLoader.getLoadResult().multiarchInfo;
        switch (mi) {
            case ARM__LINUX__GNU_EABI:
            case ARM__LINUX__GNU_EABI_HF:
            case I386__LINUX__GNU:
            case MIPS__LINUX__GNU:
            case MIPS_EL__LINUX__GNU:
                return 4;
            case AARCH64__LINUX__GNU:
            case AARCH64__OPEN_BSD__BSD:
            case MIPS_64__LINUX__GNU_ABI_64:
            case MIPS_64_EL__LINUX__GNU_ABI_64:
            case POWER_PC_64_LE__LINUX__GNU:
            case RISC_V_64__LINUX__GNU:
            case S390_X__LINUX__GNU:
            case X86_64__LINUX__GNU:
            case X86_64__WINDOWS__PE32_PLUS:
            case X86_64__OPEN_BSD__BSD:
            case X86_64__FREE_BSD__BSD:
                return 8;
            default:
                throw new RuntimeException("No SizeOfPointer values for multiarch: " + mi);

        }

    }

    /**
     * this for gcc will be the define __BIGGEST_ALIGNMENT__
     */
    static {
        // This get called after the Constructor of BaseDataType...
        LibJnhwCommonLoader.touch();
        __SIZE_OF_POINTER = getSizeOfPointer();
        __SIZE_OF_LONG = getSizeOf_long();
        __SIZE_OF_FLOAT = getSizeOf_float();
        __SIZE_OF_DOUBLE = getSizeOf_double();
        __SIZE_OF_LONG_DOUBLE = getSizeOf_long_double();
    }

}
