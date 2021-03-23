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

import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.common.memory.Int16_t;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Int64_t;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactoryImpl;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactory;

/**
 *
 * @author aploese
 */
public class SimpeStructureOnTheFlyImpl extends Struct32 implements SimpeStructure {

    public final Int8_t first;
    public final Int16_t second;
    public final Int8_t third;
    public final Int32_t forth;
    public final Int8_t fifth;
    public final Int64_t sixth;
    public final Int8_t seventh;
    public final Int64_t eighth;
    public final int sizeof;
    public final Alignment alignment;

    public SimpeStructureOnTheFlyImpl(OpaqueMemory32 parent, int offset, int sizeInBytes, SetMem setMem) {
        super(parent, offset, sizeInBytes, setMem);
        StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactoryImpl.Type.STRUCT);
        first = new Int8_t(this, slf.int8_t(), SetMem.DO_NOT_SET);
        second = new Int16_t(this, slf.int16_t(), SetMem.DO_NOT_SET);
        third = new Int8_t(this, slf.int8_t(), SetMem.DO_NOT_SET);
        forth = new Int32_t(this, slf.int32_t(), SetMem.DO_NOT_SET);
        fifth = new Int8_t(this, slf.int8_t(), SetMem.DO_NOT_SET);
        sixth = new Int64_t(this, slf.int64_t(), SetMem.DO_NOT_SET);
        seventh = new Int8_t(this, slf.int8_t(), SetMem.DO_NOT_SET);
        eighth = new Int64_t(this, slf.int64_t(), SetMem.DO_NOT_SET);
        alignment = slf.getAlignment();
        sizeof = (int) slf.getSizeof();
    }

    @Override
    public byte first() {
        return first.int8_t();
    }

    @Override
    public void first(byte value) {
        first.int8_t(value);
    }

    @Override
    public short second() {
        return second.int16_t();
    }

    @Override
    public void second(short value) {
        second.int16_t(value);
    }

    @Override
    public byte third() {
        return third.int8_t();
    }

    @Override
    public void third(byte value) {
        third.int8_t(value);
    }

    @Override
    public int forth() {
        return forth.int32_t();
    }

    @Override
    public void forth(int value) {
        forth.int32_t(value);
    }

    @Override
    public byte fifth() {
        return fifth.int8_t();
    }

    @Override
    public void fifth(byte value) {
        fifth.int8_t(value);
    }

    @Override
    public long sixth() {
        return sixth.int64_t();
    }

    @Override
    public void sixth(long value) {
        sixth.int64_t(value);
    }

    @Override
    public byte seventh() {
        return seventh.int8_t();
    }

    @Override
    public void seventh(byte value) {
        seventh.int8_t(value);
    }

    @Override
    public long eighth() {
        return eighth.int64_t();
    }

    @Override
    public void eighth(long value) {
        eighth.int64_t(value);
    }

}
