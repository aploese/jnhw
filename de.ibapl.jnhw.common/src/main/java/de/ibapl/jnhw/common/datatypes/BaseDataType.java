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
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Uint64_t;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import static de.ibapl.jnhw.common.memory.layout.Alignment.*;
import de.ibapl.jnhw.libloader.Endianess;

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
    public final static Endianess __ENDIANESS;

    /**
     * this for gcc will be the define __BIGGEST_ALIGNMENT__
     */
    static {
        // This get called after the Constructor of BaseDataType...
        LibJnhwCommonLoader.touch();
        __SIZE_OF_POINTER = getSizeOfPointer0();
        __SIZE_OF_LONG = getSizeOf_long0();
        __SIZE_OF_FLOAT = getSizeOf_float0();
        __SIZE_OF_DOUBLE = getSizeOf_double0();
        __SIZE_OF_LONG_DOUBLE = getSizeOf_long_double0();
        final Uint64_t uint64_t = new Uint64_t(null, 0, AbstractNativeMemory.SET_MEM_TO_0);
        OpaqueMemory32.setByte(uint64_t, 0, (byte) 0x01);
        OpaqueMemory32.setByte(uint64_t, 1, (byte) 0x02);
        OpaqueMemory32.setByte(uint64_t, 2, (byte) 0x03);
        OpaqueMemory32.setByte(uint64_t, 3, (byte) 0x04);
        OpaqueMemory32.setByte(uint64_t, 4, (byte) 0x05);
        OpaqueMemory32.setByte(uint64_t, 5, (byte) 0x06);
        OpaqueMemory32.setByte(uint64_t, 6, (byte) 0x07);
        OpaqueMemory32.setByte(uint64_t, 7, (byte) 0x08);
        if (0x0807060504030201L == uint64_t.uint64_t()) {
            __ENDIANESS = Endianess.LITTLE;
        } else if (0x0102030405060708L == uint64_t.uint64_t()) {
            __ENDIANESS = Endianess.BIG;
        } else {
            __ENDIANESS = null;
            throw new IllegalStateException("Cant figure out the endianess for result: 0x" + uint64_t.nativeToHexString());
        }
    }

    private final static native int getSizeOfPointer0();

    private final static int getSizeOfPointer() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return getSizeOfPointer0();
    }

    private final static native int getSizeOf_long0();

    private final static int getSizeOf_long() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return getSizeOf_long0();
    }

    private final static native int getSizeOf_float0();

    private final static int getSizeOf_float() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return getSizeOf_float0();
    }

    private final static native int getSizeOf_double0();

    private final static int getSizeOf_double() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return getSizeOf_double0();
    }

    private final static native int getSizeOf_long_double0();

    private final static int getSizeOf_long_double() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return getSizeOf_long_double0();
    }
}
