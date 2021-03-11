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

/**
 *
 * @author aploese
 */
public enum BaseDataType {
    int8_t(1, Alignment.AT_1, false),
    uint8_t(1, Alignment.AT_1, true),
    int16_t(2, Alignment.AT_2, false),
    uint16_t(2, Alignment.AT_2, true),
    int32_t(4, Alignment.AT_4, false),
    uint32_t(4, Alignment.AT_4, true),
    int64_t(8, getAlignOfInt64_t(), false),
    uint64_t(8, getAlignOfInt64_t(), true),
    struct(0, null),
    union(0, null),
    array(null, null),
    intptr_t(getSizeOfPointer(), getAlignOfPointer(), false),
    uintptr_t(getSizeOfPointer(), getAlignOfPointer(), true),
    function(getSizeOfPointer(), getAlignOfPointer()),
    /**
     * the infamous void*
     */
    pointer(getSizeOfPointer(), getAlignOfPointer());

    public static BaseDataType getSigned_Long_Mapping() {
        switch (SIZE_OF_LONG) {
            case 4:
                return int32_t;
            case 8:
                return int64_t;
            default:
                throw new RuntimeException("Unexpected size of long");
        }
    }

    public static BaseDataType getUnsigned_Long_Mapping() {
        switch (SIZE_OF_LONG) {
            case 4:
                return uint32_t;
            case 8:
                return uint64_t;
            default:
                throw new RuntimeException("Unexpected size of long");
        }
    }

    private BaseDataType(int sizeof, Alignment align, boolean unsigned) {
        this.UNSIGNED = unsigned;
        this.ALIGN_OF = align;
        this.SIZE_OF = sizeof;
    }

    private BaseDataType(Integer sizeof, Alignment alignment) {
        this.UNSIGNED = null;
        this.SIZE_OF = sizeof;
        this.ALIGN_OF = alignment;
    }

    public final Boolean UNSIGNED;
    public final Alignment ALIGN_OF;
    public final Integer SIZE_OF;

    public final static int SIZE_OF_POINTER;
    public final static Alignment ALIGN_OF_POINTER;
    public final static int SIZE_OF_LONG;
    public final static Alignment ALIGN_OF_LONG;

    public final static Alignment ALIGN_OF_INT64_T;

    /**
     * this for gcc will be the define __BIGGEST_ALIGNMENT__
     */
    public final static Alignment __BIGGEST_ALIGNMENT__;

    static {
        // This get called after the Constructor of BaseDataType...
        LibJnhwCommonLoader.touch();
        SIZE_OF_POINTER = getSizeOfPointer();
        ALIGN_OF_POINTER = getAlignOfPointer();
        SIZE_OF_LONG = getSizeOfLong();
        ALIGN_OF_LONG = getAlignOfLong();
        ALIGN_OF_INT64_T = getAlignOfInt64_t();
        __BIGGEST_ALIGNMENT__ = get__BIGGEST_ALIGNMENT__();
    }

    private final static native int getSizeOfPointer0();

    private final static native int getAlignOfPointer0();

    private final static int getSizeOfPointer() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return getSizeOfPointer0();
    }

    private final static Alignment getAlignOfPointer() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return Alignment.fromAlignof(getAlignOfPointer0());
    }

    private final static native int getSizeOfLong0();

    private final static native int getAlignOfLong0();

    private final static int getSizeOfLong() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return getSizeOfLong0();
    }

    private final static Alignment getAlignOfLong() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return Alignment.fromAlignof(getAlignOfLong0());
    }

    private final static native int getAlignOfInt64_t0();

    private final static Alignment getAlignOfInt64_t() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return Alignment.fromAlignof(getAlignOfInt64_t0());
    }

    private final static native int get__BIGGEST_ALIGNMENT__0();

    private final static Alignment get__BIGGEST_ALIGNMENT__() {
        // this gets called befire any static initializers of the implementing class gets called ... enum stuff.
        LibJnhwCommonLoader.touch();
        return Alignment.fromAlignof(get__BIGGEST_ALIGNMENT__0());
    }

}
