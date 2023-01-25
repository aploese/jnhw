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
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.SizeInBit;
import java.lang.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public enum BaseDataType {
    int8_t(SizeInBit.of_1_Byte, ValueLayout.JAVA_BYTE, __ALIGN_OF_INT8_T, __ALIGN_OF_STRUCT_INT8_T, false),
    uint8_t(SizeInBit.of_1_Byte, ValueLayout.JAVA_BYTE, __ALIGN_OF_INT8_T, __ALIGN_OF_STRUCT_INT8_T, true),
    int16_t(SizeInBit.of_2_Byte, ValueLayout.JAVA_SHORT, __ALIGN_OF_INT16_T, __ALIGN_OF_STRUCT_INT16_T, false),
    uint16_t(SizeInBit.of_2_Byte, ValueLayout.JAVA_SHORT, __ALIGN_OF_INT16_T, __ALIGN_OF_STRUCT_INT16_T, true),
    int32_t(SizeInBit.of_4_Byte, ValueLayout.JAVA_INT, __ALIGN_OF_INT32_T, __ALIGN_OF_STRUCT_INT32_T, false),
    uint32_t(SizeInBit.of_4_Byte, ValueLayout.JAVA_INT, __ALIGN_OF_INT32_T, __ALIGN_OF_STRUCT_INT32_T, true),
    _float(MultiarchTupelBuilder.getMemoryModel().sizeOf_float, ValueLayout.JAVA_FLOAT, __ALIGN_OF_FLOAT, __ALIGN_OF_STRUCT_FLOAT, false),
    _double(MultiarchTupelBuilder.getMemoryModel().sizeOf_double, ValueLayout.JAVA_DOUBLE, __ALIGN_OF_DOUBLE, __ALIGN_OF_STRUCT_DOUBLE, false),
    _long_double(__SIZE_OF_LONG_DOUBLE, null, __ALIGN_OF_LONG_DOUBLE, __ALIGN_OF_STRUCT_LONG_DOUBLE, false),
    int64_t(SizeInBit.of_8_Byte, ValueLayout.JAVA_LONG, __ALIGN_OF_INT64_T, __ALIGN_OF_STRUCT_INT64_T, false),
    uint64_t(SizeInBit.of_8_Byte, ValueLayout.JAVA_LONG, __ALIGN_OF_INT64_T, __ALIGN_OF_STRUCT_INT64_T, true),
    struct(),
    union(),
    array(),
    intptr_t(MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer, ValueLayout.ADDRESS, __ALIGN_OF_INTPTR_T, __ALIGN_OF_STRUCT_INTPTR_T, false),
    uintptr_t(MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer, ValueLayout.ADDRESS, __ALIGN_OF_INTPTR_T, __ALIGN_OF_STRUCT_INTPTR_T, true),
    function(MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer, ValueLayout.ADDRESS, __ALIGN_OF_POINTER);

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

    private BaseDataType(SizeInBit sizeof, ValueLayout valueLayout, Alignment alignof, Alignment alignInStructure, boolean unsigned) {
        this.UNSIGNED = unsigned;
        this.ALIGN_OF = alignof;
        this.ALIGN_IN_STRUCT = alignInStructure;
        this.SIZE_OF = sizeof.sizeInByte;
        this.valueLayout = valueLayout;
    }

    private BaseDataType(SizeInBit sizeof, ValueLayout valueLayout, Alignment alignof) {
        this.UNSIGNED = null;
        this.ALIGN_OF = alignof;
        this.ALIGN_IN_STRUCT = null;
        this.SIZE_OF = sizeof.sizeInByte;
        this.valueLayout = valueLayout;
    }

    /**
     *
     * ALIGN_IN_STRUCT == ALIGN_OF
     *
     * @param sizeof
     * @param alignment
     */
    private BaseDataType() {
        this.UNSIGNED = null;
        this.SIZE_OF = 0;
        this.ALIGN_OF = null;
        this.ALIGN_IN_STRUCT = null;
        this.valueLayout = null;
    }

    public final Boolean UNSIGNED;
    public final Alignment ALIGN_OF;
    public final Alignment ALIGN_IN_STRUCT;
    public final int SIZE_OF;
    public final ValueLayout valueLayout;

}
