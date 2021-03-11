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
package de.ibapl.jnhw.common.memory.layout;

import de.ibapl.jnhw.common.LibJnhwCommonLoader;
import java.lang.annotation.Native;

/**
 *
 * @author aploese
 */
public enum Alignment {
    AT_1(1), AT_2(2), AT_4(4), AT_8(8),
    /**
     * aarch64 POSIX->signal.h -> ucontext_t
     */
    AT_16(16);

    public static Alignment max(Alignment a1, Alignment a2) {
        return a1.alignof >= a2.alignof ? a1 : a2;
    }

    public static Alignment min(Alignment a1, Alignment a2) {
        return a1.alignof >= a2.alignof ? a2 : a1;
    }

    private Alignment(int alignof) {
        this.alignof = alignof;
    }

    public final int alignof;

    public static Alignment fromAlignof(int alignof) {
        switch (alignof) {
            case 1:
                return AT_1;
            case 2:
                return AT_2;
            case 4:
                return AT_4;
            case 8:
                return AT_8;
            case 16:
                return AT_16;
            default:
                throw new IllegalArgumentException("Can't get Alignment from alignof: " + alignof);
        }
    }

    public final static Alignment ALIGN_OF_LONG;
    public final static Alignment ALIGN_OF_STRUCT_LONG;
    public final static Alignment ALIGN_IN_STRUCT_LONG;

    public final static Alignment ALIGN_OF_POINTER;
    public final static Alignment ALIGN_OF_STRUCT_POINTER;
    public final static Alignment ALIGN_IN_STRUCT_POINTER;

    public final static Alignment ALIGN_OF_INT8_T;
    public final static Alignment ALIGN_OF_STRUCT_INT8_T;

    public final static Alignment ALIGN_OF_INT16_T;
    public final static Alignment ALIGN_OF_STRUCT_INT16_T;
    public final static Alignment ALIGN_IN_STRUCT_INT16_T;

    public final static Alignment ALIGN_OF_INT32_T;
    public final static Alignment ALIGN_OF_STRUCT_INT32_T;
    public final static Alignment ALIGN_IN_STRUCT_INT32_T;

    public final static Alignment ALIGN_OF_INT64_T;
    public final static Alignment ALIGN_OF_STRUCT_INT64_T;
    public final static Alignment ALIGN_IN_STRUCT_INT64_T;

    public final static Alignment ALIGN_OF_INTPTR_T;
    public final static Alignment ALIGN_OF_STRUCT_INTPTR_T;
    public final static Alignment ALIGN_IN_STRUCT_INTPTR_T;

    public final static Alignment __BIGGEST_ALIGNMENT__;

    /**
     * armhf uses 8 and __BIGGEST_ALIGNMENT__ == 8, _LP64 ? 8 but
     * __BIGGEST_ALIGNMENT__ == 8, i386 4 but __BIGGEST_ALIGNMENT__ == 8 .. It
     * just a guess
     */
    public final static Alignment JNHW_DEFAULT_STRUCT_ALIGNMENT;

    @Native
    private final static int REQ_ALIGNOF_INT8_T = 0x0001;
    @Native
    private final static int REQ_ALIGNOF_INT16_T = 0x0002;
    @Native
    private final static int REQ_ALIGNOF_INT32_T = 0x0003;
    @Native
    private final static int REQ_ALIGNOF_INT64_T = 0x0004;
    @Native
    private final static int REQ_ALIGNOF_INTPTR_T = 0x0005;
    @Native
    private final static int REQ_ALIGNOF_POINTER = 0x0006;
    @Native
    private final static int REQ_ALIGNOF_LONG = 0x0007;

    @Native
    private final static int STRUCT_ALIGN_OFFSET = 0x0010;

    @Native
    private final static int ALIGN_IN_STRUCT_OFFSET = 0x0020;

    @Native
    private final static int STRUCT_OFFSET = 0x0010;

    @Native
    private final static int REQ___BIGGEST_ALIGNMENT__ = 0x0300;

    static {
        // This get called after the Constructor of BaseDataType...
        LibJnhwCommonLoader.touch();
        ALIGN_OF_INT8_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT8_T));
        ALIGN_OF_INT16_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT16_T));
        ALIGN_OF_INT32_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT32_T));
        ALIGN_OF_INT64_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT64_T));
        ALIGN_OF_INTPTR_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INTPTR_T));

        ALIGN_OF_POINTER = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_POINTER));
        ALIGN_OF_LONG = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_LONG));

        ALIGN_OF_STRUCT_INT8_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT8_T | STRUCT_OFFSET));
        ALIGN_OF_STRUCT_INT16_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT16_T | STRUCT_OFFSET));
        ALIGN_OF_STRUCT_INT32_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT32_T | STRUCT_OFFSET));
        ALIGN_OF_STRUCT_INT64_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT64_T | STRUCT_OFFSET));
        ALIGN_OF_STRUCT_INTPTR_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INTPTR_T | STRUCT_OFFSET));

        ALIGN_OF_STRUCT_POINTER = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_POINTER | STRUCT_OFFSET));
        ALIGN_OF_STRUCT_LONG = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_LONG | STRUCT_OFFSET));

        ALIGN_IN_STRUCT_INT16_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT16_T | ALIGN_IN_STRUCT_OFFSET));
        ALIGN_IN_STRUCT_INT32_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT32_T | ALIGN_IN_STRUCT_OFFSET));
        ALIGN_IN_STRUCT_INT64_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT64_T | ALIGN_IN_STRUCT_OFFSET));
        ALIGN_IN_STRUCT_INTPTR_T = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INTPTR_T | ALIGN_IN_STRUCT_OFFSET));

        ALIGN_IN_STRUCT_POINTER = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_POINTER | ALIGN_IN_STRUCT_OFFSET));
        ALIGN_IN_STRUCT_LONG = Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_LONG | ALIGN_IN_STRUCT_OFFSET));

        __BIGGEST_ALIGNMENT__ = Alignment.fromAlignof(getFromNative(REQ___BIGGEST_ALIGNMENT__));
        JNHW_DEFAULT_STRUCT_ALIGNMENT = ALIGN_IN_STRUCT_INT64_T;
    }

    private final static native int getFromNative(int alignofReqXXX);

    /**
     * calculate the alignment of a field in a structure - the smalles alignment
     * wins.
     *
     * @param structAlignment
     * @param datayteAlignment
     * @return
     */
    public static int calcElementAlignmentInStruct(Alignment structAlignment, Alignment datayteAlignment) {
        if (structAlignment.alignof < datayteAlignment.alignof) {
            //We have a packed structure
            return structAlignment.alignof;
        } else {
            return datayteAlignment.alignof;
        }
    }

}
