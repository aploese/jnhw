/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2022-2024, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.libloader.Arch;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.AddressLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/**
 *
 * @author aploese
 */
public sealed abstract class AbstractMemoryAccessorImpl implements MemoryAccessor permits MemoryAccessorImpl_ILP32, MemoryAccessorImpl_L64, MemoryAccessorImpl_LLP64, MemoryAccessorImpl_LP64 {

    private final ValueLayout.OfByte LAYOUT_INT8_T;
    private final ValueLayout.OfShort LAYOUT_INT16_T;
    private final ValueLayout.OfInt LAYOUT_INT32_T;
    private final ValueLayout.OfLong LAYOUT_INT64_T;

    private final ValueLayout.OfByte LAYOUT_UINT8_T;
    private final ValueLayout.OfShort LAYOUT_UINT16_T;
    private final ValueLayout.OfInt LAYOUT_UINT32_T;
    private final ValueLayout.OfLong LAYOUT_UINT64_T;

    private final AddressLayout LAYOUT_INTPTR_T;
    private final AddressLayout LAYOUT_UINTPTR_T;
    private final AddressLayout LAYOUT_ADDRESS;

    private final ValueLayout.OfChar LAYOUT_UTF16;

    @Override
    public void copyMemory(byte[] src, int srcIndex, MemorySegment destMem, long dstOffset, int elementCount) {
        MemorySegment.copy(src, srcIndex, destMem, ValueLayout.JAVA_BYTE, dstOffset, elementCount);
    }

    @Override
    public void copyMemory(MemorySegment srcMem, long srcOffset, byte[] dest, int dstIndex, int elementCount) {
        MemorySegment.copy(srcMem, ValueLayout.JAVA_BYTE, srcOffset, dest, dstIndex, elementCount);
    }

    public AbstractMemoryAccessorImpl(ByteOrder byteOrder) {
        LAYOUT_INT8_T = ValueLayout.JAVA_BYTE.withOrder(byteOrder);
        LAYOUT_UINT8_T = LAYOUT_INT8_T;
        LAYOUT_INT16_T = ValueLayout.JAVA_SHORT.withOrder(byteOrder);
        LAYOUT_UINT16_T = LAYOUT_INT16_T;
        LAYOUT_INT32_T = ValueLayout.JAVA_INT.withOrder(byteOrder);
        LAYOUT_UINT32_T = LAYOUT_INT32_T;
        //TODOO BUG OpenJDK ??? alignment in struct is 4 not 8 for memory model ILP32 at arch I386!
        if (MultiarchTupelBuilder.getArch() == Arch.I386) {
            LAYOUT_INT64_T = ValueLayout.JAVA_LONG.withOrder(byteOrder).withByteAlignment(4);
        } else {
            LAYOUT_INT64_T = ValueLayout.JAVA_LONG.withOrder(byteOrder);
        }
        LAYOUT_UINT64_T = LAYOUT_INT64_T;

        //TODO how to handle bounded addresses ???
        LAYOUT_ADDRESS = ValueLayout.ADDRESS.withOrder(byteOrder);
        LAYOUT_INTPTR_T = LAYOUT_ADDRESS;
        LAYOUT_UINTPTR_T = LAYOUT_ADDRESS;

        LAYOUT_UTF16 = ValueLayout.JAVA_CHAR.withOrder(byteOrder);
    }

    public AbstractMemoryAccessorImpl(ByteOrder byteOrder, long byteAlignment) {
        LAYOUT_INT8_T = ValueLayout.JAVA_BYTE.withOrder(byteOrder).withByteAlignment(byteAlignment);
        LAYOUT_UINT8_T = LAYOUT_INT8_T;
        LAYOUT_INT16_T = ValueLayout.JAVA_SHORT.withOrder(byteOrder).withByteAlignment(byteAlignment);
        LAYOUT_UINT16_T = LAYOUT_INT16_T;
        LAYOUT_INT32_T = ValueLayout.JAVA_INT.withOrder(byteOrder).withByteAlignment(byteAlignment);
        LAYOUT_UINT32_T = LAYOUT_INT32_T;
        LAYOUT_INT64_T = ValueLayout.JAVA_LONG.withOrder(byteOrder).withByteAlignment(byteAlignment);
        LAYOUT_UINT64_T = LAYOUT_INT64_T;

        //TODO how to handle bounded addresses ???
        LAYOUT_ADDRESS = ValueLayout.ADDRESS.withOrder(byteOrder).withByteAlignment(byteAlignment);
        LAYOUT_INTPTR_T = LAYOUT_ADDRESS;
        LAYOUT_UINTPTR_T = LAYOUT_ADDRESS;

        LAYOUT_UTF16 = ValueLayout.JAVA_CHAR.withOrder(byteOrder).withByteAlignment(byteAlignment);
    }

    @Override
    public byte int8_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_INT8_T, offset);
    }

    @Override
    public void int8_t(MemorySegment mem, long offset, byte value) {
        mem.set(LAYOUT_INT8_T, offset, value);
    }

    @Override
    public short int16_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_INT16_T, offset);
    }

    @Override
    public void int16_t(MemorySegment mem, long offset, short value) {
        mem.set(LAYOUT_INT16_T, offset, value);
    }

    @Override
    public int int32_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_INT32_T, offset);
    }

    @Override
    public void int32_t(MemorySegment mem, long offset, int value) {
        mem.set(LAYOUT_INT32_T, offset, value);
    }

    @Override
    public long int64_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_INT64_T, offset);
    }

    @Override
    public void int64_t(MemorySegment mem, long offset, long value) {
        mem.set(LAYOUT_INT64_T, offset, value);
    }

    @Override
    public MemorySegment intptr_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_INTPTR_T, offset);
    }

    @Override
    public void intptr_t(MemorySegment mem, long offset, MemorySegment value) {
        mem.set(LAYOUT_INTPTR_T, offset, value);
    }

    @Override
    public void intptr_t(MemorySegment mem, long offset, Pointer value) {
        mem.set(LAYOUT_INTPTR_T, offset, value.toMemorySegment());
    }

    @Override
    public String intptr_t_nativeToString(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_INTPTR_T, offset).toString();
    }

    @Override
    public MemorySegment intptr_t_AtIndex(MemorySegment mem, long index) {
        return mem.getAtIndex(LAYOUT_INTPTR_T, index);
    }

    @Override
    public void intptr_t_AtIndex(MemorySegment mem, long index, MemorySegment dest) {
        mem.setAtIndex(LAYOUT_INTPTR_T, index, dest);
    }

    @Override
    public byte uint8_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_UINT8_T, offset);
    }

    @Override
    public void uint8_t(MemorySegment mem, long offset, byte value) {
        mem.set(LAYOUT_UINT8_T, offset, value);
    }

    @Override
    public short uint16_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_UINT16_T, offset);
    }

    @Override
    public void uint16_t(MemorySegment mem, long offset, short value) {
        mem.set(LAYOUT_UINT16_T, offset, value);
    }

    @Override
    public int uint32_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_UINT32_T, offset);
    }

    @Override
    public void uint32_t(MemorySegment mem, long offset, int value) {
        mem.set(LAYOUT_UINT32_T, +offset, value);
    }

    @Override
    public long uint64_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_UINT64_T, offset);
    }

    @Override
    public void uint64_t(MemorySegment mem, long offset, long value) {
        mem.set(LAYOUT_UINT64_T, offset, value);
    }

    @Override
    public MemorySegment uintptr_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_INTPTR_T, offset);
    }

    @Override
    public void uintptr_t(MemorySegment mem, long offset, MemorySegment value) {
        mem.set(LAYOUT_UINTPTR_T, offset, value);
    }

    @Override
    public void uintptr_t(MemorySegment mem, long offset, ByteBuffer value) {
        mem.set(LAYOUT_UINTPTR_T, offset, MemorySegment.ofBuffer(value));
    }

    @Override
    public void uintptr_t(MemorySegment mem, long offset, NativeFunctionPointer value) {
        mem.set(LAYOUT_UINTPTR_T, offset, value.memoryAddress);
    }

    @Override
    public String uintptr_t_nativeToString(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_UINTPTR_T, offset).toString();
    }

    @Override
    public MemorySegment uintptr_t_AtIndex(MemorySegment mem, long index) {
        return mem.getAtIndex(LAYOUT_UINTPTR_T, index);
    }

    @Override
    public void uintptr_t_AtIndex(MemorySegment mem, long index, MemorySegment dest) {
        mem.setAtIndex(LAYOUT_UINTPTR_T, index, dest);
    }

    @Override
    public String getString(MemorySegment mem, long offset) {
        return mem.getString(offset);
    }

    @Override
    public void setString(MemorySegment mem, long offset, String s) {
        mem.setString(offset, s);
    }

    @Override
    public String getString(MemorySegment mem, long offset, Charset charset) {
        return mem.getString(offset, charset);
    }

    @Override
    public void setString(MemorySegment mem, long offset, String s, Charset charset) {
        mem.setString(offset, s, charset);
    }

    @Override
    public String getUnicodeString(MemorySegment mem, long offset, int len) {
        char[] c = new char[len];
        MemorySegment.copy(mem, LAYOUT_UTF16, offset, c, 0, len);
        return String.copyValueOf(c);
    }

    @Override
    public void setUnicodeString(MemorySegment mem, long offset, int len, String s) {
        final char[] c = new char[len];
        s.getChars(0, len, c, 0);
        MemorySegment.copy(c, 0, mem, LAYOUT_UTF16, offset, len);
    }
}
