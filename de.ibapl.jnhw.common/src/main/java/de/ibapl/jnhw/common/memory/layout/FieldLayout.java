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
package de.ibapl.jnhw.common.memory.layout;

import de.ibapl.jnhw.common.datatypes.BaseDataType;

/**
 *
 * @author aploese
 */
public class FieldLayout {

    protected FieldLayout(long offset) {
        this.offset = offset;
    }

    public static class BitField extends FieldLayout {

        public final long mask;
        public final int shift;
        public final int bits;

        protected BitField(long offset, int bits, int bitoffset) {
            super(offset);
            this.mask = -1;
            this.shift = 0;
            this.bits = bits;
        }

    }

    public static class StructField extends FieldLayout {

        /**
         * Only for PRAGMA PACKED...
         *
         * @param offset
         */
        protected StructField(long offset) {
            super(offset);
        }

    }

    public static class UnionField extends FieldLayout {

        protected UnionField(long offset) {
            super(offset);
        }

    }

    public static FieldLayout int8_t(long offset) {
        return new FieldLayout(offset);
    }

    public static FieldLayout int16_t(long offset) {
        return new FieldLayout(offset);
    }

    public static FieldLayout int32_t(long offset) {
        return new FieldLayout(offset);
    }

    public static FieldLayout int64_t(long offset) {
        return new FieldLayout(offset);
    }

    public static FieldLayout intptr_t(long offset) {
        return new FieldLayout(offset);
    }

    public static FieldLayout uint8_t(long offset) {
        return new FieldLayout(offset);
    }

    public static FieldLayout uint16_t(long offset) {
        return new FieldLayout(offset);
    }

    public static FieldLayout uint32_t(long offset) {
        return new FieldLayout(offset);
    }

    public static FieldLayout uint64_t(long offset) {
        return new FieldLayout(offset);
    }

    public static FieldLayout uintptr_t(long offset) {
        return new FieldLayout(offset);
    }

    public static StructField struct(long offset, long sizeInBytes) {
        return new StructField(offset);
    }

    public static FieldLayout function(long offset) {
        return new FieldLayout(offset);
    }

    public static FieldLayout array(long offset, long sizeInBytes) {
        return new FieldLayout(offset);
    }

    public static UnionField union(long offset, long sizeInBytes) {
        return new UnionField(offset);
    }

    public static BitField bitfield__uint8_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, bits, bitOffset);
    }

    public static BitField bitfield__uint16_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, bits, bitOffset);
    }

    public static BitField bitfield__uint32_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, bits, bitOffset);
    }

    public static BitField bitfield__uint64_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, bits, bitOffset);
    }

    public static BitField bitfield__int8_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, bits, bitOffset);
    }

    public static BitField bitfield__int16_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, bits, bitOffset);
    }

    public static BitField bitfield__int32_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, bits, bitOffset);
    }

    public static BitField bitfield__int64_t(long offset, int bits, int bitOffset) {
        return new BitField(offset, bits, bitOffset);
    }

    public final long offset;

}
