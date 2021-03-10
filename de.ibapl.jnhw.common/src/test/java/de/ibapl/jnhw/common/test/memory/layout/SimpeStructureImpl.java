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
package de.ibapl.jnhw.common.test.memory.layout;

import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayout;
import de.ibapl.jnhw.common.memory.layout.StdStructLayoutFactory;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactory;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;

/**
 *
 * @author aploese
 */
public class SimpeStructureImpl extends Struct32 implements SimpeStructure {

    public static native Layout getNativeDefinedLayout(Class<Layout> clazz);

    static {
        LibJnhwCommonTestLoader.touch();
    }
    protected final Layout LAYOUT;

    public SimpeStructureImpl(OpaqueMemory32 owner, int offset, Layout layout, Byte setMem) {
        super(owner, offset, layout.sizeof, setMem);
        this.LAYOUT = layout;
    }

    public static class Layout extends StructLayout {

        public final Alignment alignment;
        public final int sizeof;
        public final long offsetFirst;
        public final long offsetSecond;
        public final long offsetThird;
        public final long offsetForth;
        public final long offsetFifth;
        public final long offsetSixth;
        public final long offsetSeventh;
        public final long offsetEighth;

        public Layout() {
            super();
            StructLayoutFactory slf = new StdStructLayoutFactory();
            offsetFirst = slf.int8_t();
            offsetSecond = slf.int16_t();
            offsetThird = slf.int8_t();
            offsetForth = slf.uint32_t();
            offsetFifth = slf.int8_t();
            offsetSixth = slf.uint64_t();
            offsetSeventh = slf.int8_t();
            offsetEighth = slf.uint64_t();
            alignment = slf.getAlignment();
            sizeof = (int) slf.getSizeInBytes();
        }

        public Layout(long sizeof, int alignof) {
            super();
            offsetFirst = -1;
            offsetSecond = -1;
            offsetThird = -1;
            offsetForth = -1;
            offsetFifth = -1;
            offsetSixth = -1;
            offsetSeventh = -1;
            offsetEighth = -1;
            this.sizeof = (int) sizeof;
            this.alignment = Alignment.fromAlignof(alignof);
        }

        @Override
        public int getSizeof() {
            return sizeof;
        }

        @Override
        public Alignment getAlignment() {
            return alignment;
        }
    }

    @Override
    public byte first() {
        return MEM_ACCESS.int8_t(this, LAYOUT.offsetFirst);
    }

    @Override
    public void first(byte value) {
        MEM_ACCESS.int8_t(this, LAYOUT.offsetFirst, value);
    }

    @Override
    public short second() {
        return MEM_ACCESS.int16_t(this, LAYOUT.offsetSecond);
    }

    @Override
    public void second(short value) {
        MEM_ACCESS.int16_t(this, LAYOUT.offsetSecond, value);
    }

    @Override
    public byte third() {
        return MEM_ACCESS.int8_t(this, LAYOUT.offsetThird);
    }

    @Override
    public void third(byte value) {
        MEM_ACCESS.int8_t(this, LAYOUT.offsetThird, value);
    }

    @Override
    public int forth() {
        return MEM_ACCESS.int32_t(this, LAYOUT.offsetForth);
    }

    @Override
    public void forth(int value) {
        MEM_ACCESS.int32_t(this, LAYOUT.offsetForth, value);
    }

    @Override
    public byte fifth() {
        return MEM_ACCESS.int8_t(this, LAYOUT.offsetFifth);
    }

    @Override
    public void fifth(byte value) {
        MEM_ACCESS.int8_t(this, LAYOUT.offsetFifth, value);
    }

    @Override
    public long sixth() {
        return MEM_ACCESS.int64_t(this, LAYOUT.offsetSixth);
    }

    @Override
    public void sixth(long value) {
        MEM_ACCESS.int64_t(this, LAYOUT.offsetSixth, value);
    }

    @Override
    public byte seventh() {
        return MEM_ACCESS.int8_t(this, LAYOUT.offsetSeventh);
    }

    @Override
    public void seventh(byte value) {
        MEM_ACCESS.int8_t(this, LAYOUT.offsetSeventh, value);
    }

    @Override
    public long eighth() {
        return MEM_ACCESS.int64_t(this, LAYOUT.offsetEighth);
    }

    @Override
    public void eighth(long value) {
        MEM_ACCESS.int64_t(this, LAYOUT.offsetEighth, value);
    }
}
