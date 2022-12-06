/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

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

    private final ValueLayout.OfAddress LAYOUT_INTPTR_T;
    private final ValueLayout.OfAddress LAYOUT_UINTPTR_T;
    private final ValueLayout.OfAddress LAYOUT_ADDRESS;

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
        LAYOUT_INT16_T = ValueLayout.JAVA_SHORT.withOrder(byteOrder);
        LAYOUT_INT32_T = ValueLayout.JAVA_INT.withOrder(byteOrder);
        LAYOUT_INT64_T = ValueLayout.JAVA_LONG.withOrder(byteOrder);

        LAYOUT_UINT8_T = ValueLayout.JAVA_BYTE.withOrder(byteOrder);
        LAYOUT_UINT16_T = ValueLayout.JAVA_SHORT.withOrder(byteOrder);
        LAYOUT_UINT32_T = ValueLayout.JAVA_INT.withOrder(byteOrder);
        LAYOUT_UINT64_T = ValueLayout.JAVA_LONG.withOrder(byteOrder);

        LAYOUT_ADDRESS = ValueLayout.ADDRESS.withOrder(byteOrder);
        LAYOUT_INTPTR_T = LAYOUT_ADDRESS;
        LAYOUT_UINTPTR_T = LAYOUT_ADDRESS;

        LAYOUT_UTF16 = ValueLayout.JAVA_CHAR.withOrder(byteOrder);
    }

    public AbstractMemoryAccessorImpl(ByteOrder byteOrder, long alignmentBits) {
        LAYOUT_INT8_T = ValueLayout.JAVA_BYTE.withOrder(byteOrder).withBitAlignment(alignmentBits);
        LAYOUT_INT16_T = ValueLayout.JAVA_SHORT.withOrder(byteOrder).withBitAlignment(alignmentBits);
        LAYOUT_INT32_T = ValueLayout.JAVA_INT.withOrder(byteOrder).withBitAlignment(alignmentBits);
        LAYOUT_INT64_T = ValueLayout.JAVA_LONG.withOrder(byteOrder).withBitAlignment(alignmentBits);

        LAYOUT_UINT8_T = ValueLayout.JAVA_BYTE.withOrder(byteOrder).withBitAlignment(alignmentBits);
        LAYOUT_UINT16_T = ValueLayout.JAVA_SHORT.withOrder(byteOrder).withBitAlignment(alignmentBits);
        LAYOUT_UINT32_T = ValueLayout.JAVA_INT.withOrder(byteOrder).withBitAlignment(alignmentBits);
        LAYOUT_UINT64_T = ValueLayout.JAVA_LONG.withOrder(byteOrder).withBitAlignment(alignmentBits);

        LAYOUT_ADDRESS = ValueLayout.ADDRESS.withOrder(byteOrder).withBitAlignment(alignmentBits);
        LAYOUT_INTPTR_T = LAYOUT_ADDRESS;
        LAYOUT_UINTPTR_T = LAYOUT_ADDRESS;

        LAYOUT_UTF16 = ValueLayout.JAVA_CHAR.withOrder(byteOrder).withBitAlignment(alignmentBits);
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
    public MemoryAddress intptr_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_INTPTR_T, offset);
    }

    @Override
    public void intptr_t(MemorySegment mem, long offset, Addressable value) {
        mem.set(LAYOUT_INTPTR_T, offset, value);
    }

    @Override
    public void intptr_t(MemorySegment mem, long offset, Pointer value) {
        mem.set(LAYOUT_INTPTR_T, offset, value.toAddressable());
    }

    @Override
    public String intptr_t_nativeToString(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_INTPTR_T, offset).toString();
    }

    @Override
    public MemoryAddress intptr_t_AtIndex(MemorySegment mem, long index) {
        return mem.getAtIndex(LAYOUT_INTPTR_T, index);
    }

    @Override
    public void intptr_t_AtIndex(MemorySegment mem, long index, Addressable dest) {
        mem.setAtIndex(LAYOUT_INTPTR_T, index, dest);
    }

    @Override
    public void intptr_t_AtIndex(MemorySegment mem, long index, Pointer dest) {
        mem.setAtIndex(LAYOUT_INTPTR_T, index, dest.toAddressable());
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
    public MemoryAddress uintptr_t(MemorySegment mem, long offset) {
        return mem.get(LAYOUT_INTPTR_T, offset);
    }

    @Override
    public void uintptr_t(MemorySegment mem, long offset, Addressable value) {
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
    public MemoryAddress uintptr_t_AtIndex(MemorySegment mem, long index) {
        return mem.getAtIndex(LAYOUT_UINTPTR_T, index);
    }

    @Override
    public void uintptr_t_AtIndex(MemorySegment mem, long index, MemoryAddress dest) {
        mem.setAtIndex(LAYOUT_UINTPTR_T, index, dest);
    }

    @Override
    public void uintptr_t_AtIndex(MemorySegment mem, long index, MemorySegment dest) {
        mem.setAtIndex(LAYOUT_UINTPTR_T, index, dest);
    }

    @Override
    public String getUTF_8String(MemorySegment mem, long offset) {
        return mem.getUtf8String(offset);
    }

    @Override
    public void setUTF_8String(MemorySegment mem, long offset, String s) {
        mem.setUtf8String(offset, s);
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
