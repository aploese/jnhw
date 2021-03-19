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
public class StructLayoutFactoryImpl implements StructLayoutFactory {

    private long nextOffset;
    private Alignment structAlignment = Alignment.AT_1;
    private final boolean ALIGNMENT_IS_FIXED;
    private final Type type;

    public StructLayoutFactoryImpl(Type type, Alignment alignment) {
        ALIGNMENT_IS_FIXED = true;
        this.type = type;
        structAlignment = alignment;
    }

    public StructLayoutFactoryImpl(Type type) {
        ALIGNMENT_IS_FIXED = false;
        this.type = type;
    }

    protected long calcNextOffset(Alignment currentAlignment, long currentSizeInBytes) {
        if (ALIGNMENT_IS_FIXED) {
            //no-op
        } else if ((currentAlignment.alignof > structAlignment.alignof) && (currentAlignment.alignof <= Alignment.__BIGGEST_ALIGNMENT__.alignof)) {
            structAlignment = currentAlignment;
        }
        switch (type) {
            case STRUCT:
                final int intAlignment = Alignment.calcElementAlignmentInStruct(structAlignment, currentAlignment);
                final int reminder = (int) Long.remainderUnsigned(nextOffset, intAlignment);
                final long offset = (reminder == 0) ? nextOffset : nextOffset + intAlignment - reminder;
                nextOffset = offset + currentSizeInBytes;
                return offset;
            case UNION:
                if (nextOffset < currentSizeInBytes) {
                    nextOffset = currentSizeInBytes;
                }
                return 0;
            default:
                throw new IllegalStateException("Unknown type to build: " + type);
        }

    }

    @Override
    public long int8_t() {
        return calcNextOffset(BaseDataType.int8_t.ALIGN_IN_STRUCT, BaseDataType.int8_t.SIZE_OF);
    }

    @Override
    public long int16_t() {
        return calcNextOffset(BaseDataType.int16_t.ALIGN_IN_STRUCT, BaseDataType.int16_t.SIZE_OF);
    }

    @Override
    public long int32_t() {
        return calcNextOffset(BaseDataType.int32_t.ALIGN_IN_STRUCT, BaseDataType.int32_t.SIZE_OF);
    }

    @Override
    public long int64_t() {
        return calcNextOffset(BaseDataType.int64_t.ALIGN_IN_STRUCT, BaseDataType.int64_t.SIZE_OF);
    }

    @Override
    public long intptr_t() {
        return calcNextOffset(BaseDataType.intptr_t.ALIGN_IN_STRUCT, BaseDataType.intptr_t.SIZE_OF);
    }

    @Override
    public long uint8_t() {
        return calcNextOffset(BaseDataType.uint8_t.ALIGN_IN_STRUCT, BaseDataType.uint8_t.SIZE_OF);
    }

    @Override
    public long uint16_t() {
        return calcNextOffset(BaseDataType.uint16_t.ALIGN_IN_STRUCT, BaseDataType.uint16_t.SIZE_OF);
    }

    @Override
    public long uint32_t() {
        return calcNextOffset(BaseDataType.uint32_t.ALIGN_IN_STRUCT, BaseDataType.uint32_t.SIZE_OF);
    }

    @Override
    public long uint64_t() {
        return calcNextOffset(BaseDataType.uint64_t.ALIGN_IN_STRUCT, BaseDataType.uint64_t.SIZE_OF);
    }

    @Override
    public long uintptr_t() {
        return calcNextOffset(BaseDataType.uintptr_t.ALIGN_IN_STRUCT, BaseDataType.uintptr_t.SIZE_OF);
    }

    @Override
    public long getSizeof() {
        final int reminder = (int) Long.remainderUnsigned(nextOffset, structAlignment.alignof);
        return (reminder == 0) ? nextOffset : nextOffset + structAlignment.alignof - reminder;
    }

    @Override
    public Alignment getAlignment() {
        return structAlignment;
    }

    @Override
    public long struct(long sizeInBytes, Alignment alignment) {
        return calcNextOffset(alignment, sizeInBytes);
    }

    @Override
    public long union(long sizeInBytes, Alignment alignment) {
        return calcNextOffset(alignment, sizeInBytes);
    }
}
