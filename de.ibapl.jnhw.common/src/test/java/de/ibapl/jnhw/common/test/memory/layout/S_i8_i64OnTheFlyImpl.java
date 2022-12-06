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
package de.ibapl.jnhw.common.test.memory.layout;

import de.ibapl.jnhw.common.memory.Int16_t;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Int64_t;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactoryImpl;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactory;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class S_i8_i64OnTheFlyImpl extends Struct implements S_i8_i64 {

    public final Int8_t _0_i8;
    public final Int16_t _1_i16;
    public final Int8_t _2_i8;
    public final Int32_t _3_i32;
    public final Int8_t _4_i8;
    public final Int64_t _5_i64;
    public final Int8_t _6_i8;
    public final Int64_t _7_i64;
    public final Int8_t _8_i8;
    public final Int32_t _9_i32;
    public final Int8_t _10_i8;
    public final Int16_t _11_i16;
    public final Int8_t _12_i8;
    public final int sizeof;
    public final Alignment alignment;

    public S_i8_i64OnTheFlyImpl(MemorySegment memorySegment, long offset, long sizeInBytes) {
        super(memorySegment, offset, sizeInBytes);
        StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactoryImpl.Type.STRUCT);
        _0_i8 = Int8_t.map(this, slf.int8_t());
        _1_i16 = Int16_t.map(this, slf.int16_t());
        _2_i8 = Int8_t.map(this, slf.int8_t());
        _3_i32 = Int32_t.map(this, slf.int32_t());
        _4_i8 = Int8_t.map(this, slf.int8_t());
        _5_i64 = Int64_t.map(this, slf.int64_t());
        _6_i8 = Int8_t.map(this, slf.int8_t());
        _7_i64 = Int64_t.map(this, slf.int64_t());
        _8_i8 = Int8_t.map(this, slf.int8_t());
        _9_i32 = Int32_t.map(this, slf.int32_t());
        _10_i8 = Int8_t.map(this, slf.int8_t());
        _11_i16 = Int16_t.map(this, slf.int16_t());
        _12_i8 = Int8_t.map(this, slf.int8_t());
        alignment = slf.getAlignment();
        sizeof = (int) slf.getSizeof();
    }

    @Override
    public byte _0_i8() {
        return _0_i8.int8_t();
    }

    @Override
    public void _0_i8(byte value) {
        _0_i8.int8_t(value);
    }

    @Override
    public short _1_i16() {
        return _1_i16.int16_t();
    }

    @Override
    public void _1_i16(short value) {
        _1_i16.int16_t(value);
    }

    @Override
    public byte _2_i8() {
        return _2_i8.int8_t();
    }

    @Override
    public void _2_i8(byte value) {
        _2_i8.int8_t(value);
    }

    @Override
    public int _3_i32() {
        return _3_i32.int32_t();
    }

    @Override
    public void _3_i32(int value) {
        _3_i32.int32_t(value);
    }

    @Override
    public byte _4_i8() {
        return _4_i8.int8_t();
    }

    @Override
    public void _4_i8(byte value) {
        _4_i8.int8_t(value);
    }

    @Override
    public long _5_i64() {
        return _5_i64.int64_t();
    }

    @Override
    public void _5_i64(long value) {
        _5_i64.int64_t(value);
    }

    @Override
    public byte _6_i8() {
        return _6_i8.int8_t();
    }

    @Override
    public void _6_i8(byte value) {
        _6_i8.int8_t(value);
    }

    @Override
    public long _7_i64() {
        return _7_i64.int64_t();
    }

    @Override
    public void _7_i64(long value) {
        _7_i64.int64_t(value);
    }

    @Override
    public byte _8_i8() {
        return _8_i8.int8_t();
    }

    @Override
    public void _8_i8(byte value) {
        _8_i8.int8_t(value);
    }

    @Override
    public int _9_i32() {
        return _9_i32.int32_t();
    }

    @Override
    public void _9_i32(int value) {
        _9_i32.int32_t(value);
    }

    @Override
    public byte _10_i8() {
        return _10_i8.int8_t();
    }

    @Override
    public void _10_i8(byte value) {
        _10_i8.int8_t(value);
    }

    @Override
    public short _11_i16() {
        return _11_i16.int16_t();
    }

    @Override
    public void _11_i16(short value) {
        _11_i16.int16_t(value);
    }

    @Override
    public byte _12_i8() {
        return _12_i8.int8_t();
    }

    @Override
    public void _12_i8(byte value) {
        _12_i8.int8_t(value);
    }

}
