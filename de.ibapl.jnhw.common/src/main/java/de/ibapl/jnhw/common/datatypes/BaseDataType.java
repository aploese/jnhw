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
package de.ibapl.jnhw.common.datatypes;

import de.ibapl.jnhw.common.memory.layout.Alignment;
import static de.ibapl.jnhw.common.memory.layout.Alignment.*;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public enum BaseDataType {
    int8_t(1, ValueLayout.JAVA_BYTE, __ALIGN_OF_INT8_T, __ALIGN_OF_STRUCT_INT8_T, false),
    uint8_t(1, ValueLayout.JAVA_BYTE, __ALIGN_OF_INT8_T, __ALIGN_OF_STRUCT_INT8_T, true),
    int16_t(2, ValueLayout.JAVA_SHORT, __ALIGN_OF_INT16_T, __ALIGN_OF_STRUCT_INT16_T, false),
    uint16_t(2, ValueLayout.JAVA_SHORT, __ALIGN_OF_INT16_T, __ALIGN_OF_STRUCT_INT16_T, true),
    int32_t(4, ValueLayout.JAVA_INT, __ALIGN_OF_INT32_T, __ALIGN_OF_STRUCT_INT32_T, false),
    uint32_t(4, ValueLayout.JAVA_INT, __ALIGN_OF_INT32_T, __ALIGN_OF_STRUCT_INT32_T, true),
    _float(getSizeOf_float(), ValueLayout.JAVA_FLOAT, __ALIGN_OF_FLOAT, __ALIGN_OF_STRUCT_FLOAT, false),
    _double(getSizeOf_double(), ValueLayout.JAVA_DOUBLE, __ALIGN_OF_DOUBLE, __ALIGN_OF_STRUCT_DOUBLE, false),
    _long_double(getSizeOf_long_double(), null, __ALIGN_OF_LONG_DOUBLE, __ALIGN_OF_STRUCT_LONG_DOUBLE, false),
    int64_t(8, ValueLayout.JAVA_LONG, __ALIGN_OF_INT64_T, __ALIGN_OF_STRUCT_INT64_T, false),
    uint64_t(8, ValueLayout.JAVA_LONG, __ALIGN_OF_INT64_T, __ALIGN_OF_STRUCT_INT64_T, true),
    struct(0, ValueLayout.ADDRESS, null),
    union(0, ValueLayout.ADDRESS, null),
    array(0, ValueLayout.ADDRESS, null),
    intptr_t(MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer.sizeInByte, ValueLayout.ADDRESS, __ALIGN_OF_INTPTR_T, __ALIGN_OF_STRUCT_INTPTR_T, false),
    uintptr_t(MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer.sizeInByte, ValueLayout.ADDRESS, __ALIGN_OF_INTPTR_T, __ALIGN_OF_STRUCT_INTPTR_T, true),
    function(MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer.sizeInByte, ValueLayout.ADDRESS, __ALIGN_OF_POINTER);

    public final static BaseDataType C_char = int8_t;
    public final static BaseDataType C_unsigned_char = uint8_t;

    public final static BaseDataType C_short = int16_t;
    public final static BaseDataType C_unsigned_short = uint16_t;

    public final static BaseDataType C_int = switch (MultiarchTupelBuilder.getMemoryModel()) {
        case LP32 ->
            int16_t;
        case ILP32, L64, LLP64, LP64 ->
            int32_t;
        case ILP64 ->
            int64_t;
        default ->
            throw new AssertionError();
    };

    public final static BaseDataType C_unsigned_int = switch (MultiarchTupelBuilder.getMemoryModel()) {
        case LP32 ->
            uint16_t;
        case ILP32, L64, LLP64, LP64 ->
            uint32_t;
        case ILP64 ->
            uint64_t;
        default ->
            throw new AssertionError();
    };

    public final static BaseDataType C_long = switch (MultiarchTupelBuilder.getMemoryModel()) {
        case LP32, ILP32, LLP64 ->
            int32_t;
        case ILP64, L64, LP64 ->
            int64_t;
        default ->
            throw new AssertionError();
    };
    public final static BaseDataType C_long_int = C_long;

    public final static BaseDataType C_unsigned_long = switch (MultiarchTupelBuilder.getMemoryModel()) {
        case LP32, ILP32, LLP64 ->
            uint32_t;
        case ILP64, L64, LP64 ->
            uint64_t;
        default ->
            throw new AssertionError();
    };

    public final static BaseDataType C_unsigned_long_pointer = uintptr_t;

    public final static BaseDataType C_unsigned_long_int = C_unsigned_long;

    /**
     * the infamous void *
     */
    public final static BaseDataType C_pointer = intptr_t;
    public final static BaseDataType C_VaList = C_pointer;

    public final static BaseDataType C_long_long = int64_t;
    public final static BaseDataType C_unsigned_long_long = uint64_t;
    public final static BaseDataType C_char_pointer = BaseDataType.C_pointer;
    public final static BaseDataType C_const_char_pointer = BaseDataType.C_pointer;
    public final static BaseDataType C_const_pointer = BaseDataType.C_pointer;
    public final static BaseDataType C_int_pointer = intptr_t;
    public final static BaseDataType C_const_struct_array = BaseDataType.C_pointer;
    public final static BaseDataType C_struct_array = BaseDataType.C_pointer;
    public final static BaseDataType C_struct_pointer = BaseDataType.C_pointer;
    public final static BaseDataType C_const_struct_pointer = BaseDataType.C_pointer;
    public final static BaseDataType C_function_pointer = BaseDataType.C_pointer;

    private BaseDataType(int sizeof, ValueLayout valueLayout, Alignment alignof, Alignment alignInStructure, boolean unsigned) {
        this.UNSIGNED = unsigned;
        this.ALIGN_OF = alignof;
        this.ALIGN_IN_STRUCT = alignInStructure;
        this.SIZE_OF = sizeof;
        this.valueLayout = valueLayout;
    }

    /**
     *
     * ALIGN_IN_STRUCT == ALIGN_OF
     *
     * @param sizeof
     * @param alignment
     */
    private BaseDataType(int sizeof, ValueLayout valueLayout, Alignment alignment) {
        this.UNSIGNED = null;
        this.SIZE_OF = sizeof;
        this.ALIGN_OF = alignment;
        this.ALIGN_IN_STRUCT = alignment;
        this.valueLayout = valueLayout;
    }

    public final Boolean UNSIGNED;
    public final Alignment ALIGN_OF;
    public final Alignment ALIGN_IN_STRUCT;
    public final int SIZE_OF;

    private final static int getSizeOf_float() {
        final MultiarchInfo mi = MultiarchTupelBuilder.getMultiarch();
        return switch (mi) {
            case AARCH64__LINUX__GNU, AARCH64__OPEN_BSD__BSD, ARM__LINUX__GNU_EABI, ARM__LINUX__GNU_EABI_HF, I386__LINUX__GNU, MIPS__LINUX__GNU, MIPS_EL__LINUX__GNU, MIPS_64__LINUX__GNU_ABI_64, MIPS_64_EL__LINUX__GNU_ABI_64, POWER_PC_64_LE__LINUX__GNU, RISC_V_64__LINUX__GNU, S390_X__LINUX__GNU, X86_64__DARWIN__BSD, X86_64__FREE_BSD__BSD, X86_64__LINUX__GNU, X86_64__OPEN_BSD__BSD, X86_64__WINDOWS__PE32_PLUS ->
                4;
            default ->
                throw new RuntimeException("No sizeof float values for multiarch: " + mi);

        };
    }

    private final static int getSizeOf_double() {
        final MultiarchInfo mi = MultiarchTupelBuilder.getMultiarch();
        return switch (mi) {
            case AARCH64__LINUX__GNU, AARCH64__OPEN_BSD__BSD, ARM__LINUX__GNU_EABI, ARM__LINUX__GNU_EABI_HF, I386__LINUX__GNU, MIPS__LINUX__GNU, MIPS_EL__LINUX__GNU, MIPS_64__LINUX__GNU_ABI_64, MIPS_64_EL__LINUX__GNU_ABI_64, POWER_PC_64_LE__LINUX__GNU, RISC_V_64__LINUX__GNU, S390_X__LINUX__GNU, X86_64__DARWIN__BSD, X86_64__FREE_BSD__BSD, X86_64__LINUX__GNU, X86_64__OPEN_BSD__BSD, X86_64__WINDOWS__PE32_PLUS ->
                8;
            default ->
                throw new RuntimeException("No sizeof double values for multiarch: " + mi);
        };
    }

    private final static int getSizeOf_long_double() {
        final MultiarchInfo mi = MultiarchTupelBuilder.getMultiarch();
        return switch (mi) {
            case ARM__LINUX__GNU_EABI, ARM__LINUX__GNU_EABI_HF, MIPS__LINUX__GNU, MIPS_EL__LINUX__GNU ->
                8;
            case I386__LINUX__GNU ->
                12;
            case AARCH64__LINUX__GNU, AARCH64__OPEN_BSD__BSD, MIPS_64__LINUX__GNU_ABI_64, MIPS_64_EL__LINUX__GNU_ABI_64, POWER_PC_64_LE__LINUX__GNU, RISC_V_64__LINUX__GNU, S390_X__LINUX__GNU, X86_64__DARWIN__BSD, X86_64__FREE_BSD__BSD, X86_64__LINUX__GNU, X86_64__OPEN_BSD__BSD, X86_64__WINDOWS__PE32_PLUS ->
                16;
            default ->
                throw new RuntimeException("No sizeof long double values for multiarch: " + mi);
        };
    }

    public final ValueLayout valueLayout;

}
