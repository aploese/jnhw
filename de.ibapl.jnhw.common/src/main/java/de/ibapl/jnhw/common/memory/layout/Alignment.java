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
