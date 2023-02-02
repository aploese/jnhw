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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.annotation.Bug_JDK_8300201;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteOrder;

/**
 *
 * @author aploese
 */
public final class MemoryAccessorImpl_ILP32 extends AbstractMemoryAccessorImpl {

    private final ValueLayout.OfInt LAYOUT__LONG;

    private final ValueLayout.OfInt LAYOUT__UNSIGNED_LONG;

    private final ValueLayout.OfInt LAYOUT_UINTPTR_T;

    private final static int LONG_SIZE = 4;

    public MemoryAccessorImpl_ILP32(ByteOrder byteOrder) {
        super(byteOrder);
        LAYOUT__LONG = ValueLayout.JAVA_INT.withOrder(byteOrder);
        LAYOUT__UNSIGNED_LONG = ValueLayout.JAVA_INT.withOrder(byteOrder);
        LAYOUT_UINTPTR_T = ValueLayout.JAVA_INT.withOrder(byteOrder);
    }

    public MemoryAccessorImpl_ILP32(ByteOrder byteOrder, long alignmentBits) {
        super(byteOrder, alignmentBits);
        LAYOUT__LONG = ValueLayout.JAVA_INT.withOrder(byteOrder).withBitAlignment(alignmentBits);
        LAYOUT__UNSIGNED_LONG = ValueLayout.JAVA_INT.withOrder(byteOrder).withBitAlignment(alignmentBits);
        LAYOUT_UINTPTR_T = ValueLayout.JAVA_INT.withOrder(byteOrder).withBitAlignment(alignmentBits);
    }

    @Override
    public long signed_long(MemorySegment mem, long offset) {
        return mem.get(LAYOUT__LONG, offset);
    }

    @Override
    public void signed_long(MemorySegment mem, long offset, long value) {
        if ((value > Integer.MAX_VALUE) || (value < Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("value outside of int32_t: " + value);
        }
        mem.set(LAYOUT__LONG, offset, (int) value);
    }

    @Override
    public long signed_long_AtIndex(MemorySegment mem, long offset, int index) {
        return mem.get(LAYOUT__LONG, offset + LONG_SIZE * index);
    }

    @Override
    public void signed_long_AtIndex(MemorySegment mem, long offset, int index, long value) {
        if ((value > Integer.MAX_VALUE) || (value < Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("value outside of int32_t: " + value);
        }
        mem.set(LAYOUT__LONG, offset + LONG_SIZE * index, (int) value);
    }

    @Override
    public long unsigned_long(MemorySegment mem, long offset) {
        return (long) (mem.get(LAYOUT__UNSIGNED_LONG, offset) & 0x00000000ffffffffL);
    }

    @Override
    public void unsigned_long(MemorySegment mem, long offset, long value) {
        if (value > 0x00000000ffffffffL) {
            throw new IllegalArgumentException("value too big for uint32_t: " + value);
        }
        if (value < 0) {
            throw new IllegalArgumentException("value must not be negative");
        }
        mem.set(LAYOUT__UNSIGNED_LONG, offset, (int) value);
    }

    @Override
    public long unsigned_long_AtIndex(MemorySegment mem, long offset, int index) {
        return (long) (mem.get(LAYOUT__UNSIGNED_LONG, offset + LONG_SIZE * index) & 0x00000000ffffffffL);
    }

    @Override
    public void unsigned_long_AtIndex(MemorySegment mem, long offset, int index, long value) {
        if (value > 0x00000000ffffffffL) {
            throw new IllegalArgumentException("value too big for uint32_t: " + value);
        }
        if (value < 0) {
            throw new IllegalArgumentException("value must not be negative");
        }
        mem.set(LAYOUT__UNSIGNED_LONG, offset + LONG_SIZE * index, (int) value);
    }

    @Override
    @Bug_JDK_8300201
    public MemorySegment uintptr_t_AtIndex(MemorySegment mem, long index) {
        return MemorySegment.ofAddress(0xffffffffL & mem.getAtIndex(LAYOUT_UINTPTR_T, index));
    }

    @Override
    @Bug_JDK_8300201
    public MemorySegment uintptr_t(MemorySegment mem, long offset) {
        return MemorySegment.ofAddress(0xffffffffL & mem.get(LAYOUT_UINTPTR_T, offset));
    }

    @Override
    public String intptr_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%08x", (int) intptr_t(mem, offset).address());
    }

    @Override
    public String uintptr_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%08x", (int) uintptr_t(mem, offset).address());
    }

}
