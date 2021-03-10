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

import de.ibapl.jnhw.common.datatypes.BaseDataType;

/**
 *
 * @author aploese
 */
public class StdStructLayoutFactory implements StructLayoutFactory {

    private long nextOffset;
    private Alignment structAlignment;

    protected long calcNextOffset(Alignment currentAlignment, long currentSizeInBytes) {
        if ((structAlignment == null) || (currentAlignment.alignof > structAlignment.alignof)) {
            structAlignment = currentAlignment;

        }
        final int intAlignment = Alignment.calcElementAlignmentInStruct(structAlignment, currentAlignment);
        final int reminder = (int) Long.remainderUnsigned(nextOffset, intAlignment);
        final long offset = (reminder == 0) ? nextOffset : nextOffset + intAlignment - reminder;
        nextOffset = offset + currentSizeInBytes;
        return offset;
    }

    @Override
    public long int8_t() {
        return calcNextOffset(BaseDataType.int8_t.ALIGN_OF, BaseDataType.int8_t.SIZE_OF);
    }

    @Override
    public long int16_t() {
        return calcNextOffset(BaseDataType.int16_t.ALIGN_OF, BaseDataType.int16_t.SIZE_OF);
    }

    @Override
    public long int32_t() {
        return calcNextOffset(BaseDataType.int32_t.ALIGN_OF, BaseDataType.int32_t.SIZE_OF);
    }

    @Override
    public long int64_t() {
        return calcNextOffset(BaseDataType.int64_t.ALIGN_OF, BaseDataType.int64_t.SIZE_OF);
    }

    @Override
    public long intptr_t() {
        return calcNextOffset(BaseDataType.intptr_t.ALIGN_OF, BaseDataType.intptr_t.SIZE_OF);
    }

    @Override
    public long uint8_t() {
        return calcNextOffset(BaseDataType.uint8_t.ALIGN_OF, BaseDataType.uint8_t.SIZE_OF);
    }

    @Override
    public long uint16_t() {
        return calcNextOffset(BaseDataType.uint16_t.ALIGN_OF, BaseDataType.uint16_t.SIZE_OF);
    }

    @Override
    public long uint32_t() {
        return calcNextOffset(BaseDataType.uint32_t.ALIGN_OF, BaseDataType.uint32_t.SIZE_OF);
    }

    @Override
    public long uint64_t() {
        return calcNextOffset(BaseDataType.uint64_t.ALIGN_OF, BaseDataType.uint64_t.SIZE_OF);
    }

    @Override
    public long uintptr_t() {
        return calcNextOffset(BaseDataType.uintptr_t.ALIGN_OF, BaseDataType.uintptr_t.SIZE_OF);
    }

    /*
    public FieldLayout function() {
        return new FieldLayout(offset, BaseDataType.pointer.SIZE_OF);
    }

    public FieldLayout array(long sizeInBytes) {
        return new FieldLayout(offset, sizeInBytes);
    }

    public UnionField union(long offset, long sizeInBytes) {
        return new UnionField(offset, sizeInBytes);
    }

    public static BitField bitfield__uint8_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, BaseDataType.uint8_t.SIZE_OF, bits, bitOffset);
    }

    public static BitField bitfield__uint16_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, BaseDataType.uint16_t.SIZE_OF, bits, bitOffset);
    }

    public static BitField bitfield__uint32_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, BaseDataType.uint32_t.SIZE_OF, bits, bitOffset);
    }

    public static BitField bitfield__uint64_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, BaseDataType.uint64_t.SIZE_OF, bits, bitOffset);
    }

    public static BitField bitfield__int8_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, BaseDataType.int8_t.SIZE_OF, bits, bitOffset);
    }

    public static BitField bitfield__int16_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, BaseDataType.int16_t.SIZE_OF, bits, bitOffset);
    }

    public static BitField bitfield__int32_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, BaseDataType.int32_t.SIZE_OF, bits, bitOffset);
    }

    public static BitField bitfield__int64_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, BaseDataType.int64_t.SIZE_OF, bits, bitOffset);
    }
     */
    @Override
    public long getSizeInBytes() {
        return nextOffset;
    }

    @Override
    public Alignment getAlignment() {
        return structAlignment;
    }
}
