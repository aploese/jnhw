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
package de.ibapl.jnhw.common.datatypes;

import de.ibapl.jnhw.common.memory.layout.Alignment;
import static de.ibapl.jnhw.common.memory.layout.Alignment.*;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.SizeInByte;
import static de.ibapl.jnhw.libloader.SizeInByte.*;
import java.lang.foreign.ValueLayout;
import static de.ibapl.jnhw.common.datatypes.Sign.*;

/**
 *
 * @author aploese
 */
public enum BaseDataType {
    int8_t(_8_Bit, ValueLayout.JAVA_BYTE, __ALIGN_OF_INT8_T, __ALIGN_OF_STRUCT_INT8_T, Signed),
    uint8_t(_8_Bit, ValueLayout.JAVA_BYTE, __ALIGN_OF_INT8_T, __ALIGN_OF_STRUCT_INT8_T, Unsigned),
    int16_t(_16_Bit, ValueLayout.JAVA_SHORT, __ALIGN_OF_INT16_T, __ALIGN_OF_STRUCT_INT16_T, Signed),
    uint16_t(_16_Bit, ValueLayout.JAVA_SHORT, __ALIGN_OF_INT16_T, __ALIGN_OF_STRUCT_INT16_T, Unsigned),
    int32_t(_32_Bit, ValueLayout.JAVA_INT, __ALIGN_OF_INT32_T, __ALIGN_OF_STRUCT_INT32_T, Signed),
    uint32_t(_32_Bit, ValueLayout.JAVA_INT, __ALIGN_OF_INT32_T, __ALIGN_OF_STRUCT_INT32_T, Unsigned),
    _float(MultiarchTupelBuilder.getMemoryModel().sizeOf_float, ValueLayout.JAVA_FLOAT, __ALIGN_OF_FLOAT, __ALIGN_OF_STRUCT_FLOAT, Signed),
    _double(MultiarchTupelBuilder.getMemoryModel().sizeOf_double, ValueLayout.JAVA_DOUBLE, __ALIGN_OF_DOUBLE, __ALIGN_OF_STRUCT_DOUBLE, Signed),
    _long_double(__SIZE_OF_LONG_DOUBLE, null, __ALIGN_OF_LONG_DOUBLE, __ALIGN_OF_STRUCT_LONG_DOUBLE, Signed),
    int64_t(_64_Bit, ValueLayout.JAVA_LONG, __ALIGN_OF_INT64_T, __ALIGN_OF_STRUCT_INT64_T, Signed),
    uint64_t(_64_Bit, ValueLayout.JAVA_LONG, __ALIGN_OF_INT64_T, __ALIGN_OF_STRUCT_INT64_T, Unsigned),
    struct(),
    union(),
    array(),
    intptr_t(MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer, ValueLayout.ADDRESS, __ALIGN_OF_INTPTR_T, __ALIGN_OF_STRUCT_INTPTR_T, Signed),
    uintptr_t(MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer, ValueLayout.ADDRESS, __ALIGN_OF_INTPTR_T, __ALIGN_OF_STRUCT_INTPTR_T, Unsigned),
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

    private BaseDataType(SizeInByte sizeof, ValueLayout valueLayout, Alignment alignof, Alignment alignInStructure, Sign sign) {
        this.sign = sign;
        this.ALIGNMENT = alignof;
        this.ALIGNMENT_IN_STRUCT = alignInStructure;
        this.byteSize = sizeof.sizeInByte;
        this.byteAlignment = ALIGNMENT.alignof;
        this.valueLayout = valueLayout;
    }

    private BaseDataType(SizeInByte sizeof, ValueLayout valueLayout, Alignment alignof) {
        this.sign = No_Sign;
        this.ALIGNMENT = alignof;
        this.ALIGNMENT_IN_STRUCT = null;
        this.byteSize = sizeof.sizeInByte;
        this.byteAlignment = ALIGNMENT.alignof;
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
        this.sign = No_Sign;
        this.byteSize = 0;
        this.byteAlignment = 0;
        this.ALIGNMENT = null;
        this.ALIGNMENT_IN_STRUCT = null;
        this.valueLayout = null;
    }

    public Sign sign;
    public final Alignment ALIGNMENT;
    public final Alignment ALIGNMENT_IN_STRUCT;
    public final int byteSize;
    public final int byteAlignment;
    public final ValueLayout valueLayout;

    public boolean isUnsigned() {
        return sign == Unsigned;
    }

    public boolean isSigned() {
        return sign == Signed;
    }
    
}
