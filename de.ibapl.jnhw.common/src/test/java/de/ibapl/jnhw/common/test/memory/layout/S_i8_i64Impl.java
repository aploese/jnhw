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
package de.ibapl.jnhw.common.test.memory.layout;

import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayout;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactoryImpl;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactory;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class S_i8_i64Impl extends Struct implements S_i8_i64 {

    public static int offsetOf_0_i8() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__0_i8");
    }

    public static int offsetOf_1_i16() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__1_i16");
    }

    public static int offsetOf_2_i8() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__2_i8");
    }

    public static int offsetOf_3_i32() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__3_i32");
    }

    public static int offsetOf_4_i8() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__4_i8");
    }

    public static int offsetOf_5_i64() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__5_i64");
    }

    public static int offsetOf_6_i8() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__6_i8");
    }

    public static int offsetOf_7_i64() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__7_i64");
    }

    public static int offsetOf_8_i8() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__8_i8");
    }

    public static int offsetOf_9_i32() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__9_i32");
    }

    public static int offsetOf_10_i8() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__10_i8");
    }

    public static int offsetOf_11_i16() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__11_i16");
    }

    public static int offsetOf_12_i8() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("offsetOf_s_i8_i64__12_i8");
    }

    public static int sizeOf() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_s_i8_i64");
    }

    public static int alignOf() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_s_i8_i64");
    }

    protected final Layout LAYOUT;

    public S_i8_i64Impl(MemorySegment memorySegment, int offset, Layout layout) {
        super(memorySegment, offset, layout.sizeof);
        this.LAYOUT = layout;
    }

    public static class Layout extends StructLayout {

        public final long offsetof_0_i8;
        public final long offsetof_1_i16;
        public final long offsetof_2_i8;
        public final long offsetof_3_i32;
        public final long offsetof_4_i8;
        public final long offsetof_5_i64;
        public final long offsetof_6_i8;
        public final long offsetof_7_i64;
        public final long offsetof_8_i8;
        public final long offsetof_9_i32;
        public final long offsetof_10_i8;
        public final long offsetof_11_i16;
        public final long offsetof_12_i8;
        public final Alignment alignment;
        public final int sizeof;

        public Layout() {
            super();
            StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactoryImpl.Type.STRUCT);
            offsetof_0_i8 = slf.int8_t();
            offsetof_1_i16 = slf.int16_t();
            offsetof_2_i8 = slf.int8_t();
            offsetof_3_i32 = slf.int32_t();
            offsetof_4_i8 = slf.int8_t();
            offsetof_5_i64 = slf.int64_t();
            offsetof_6_i8 = slf.int8_t();
            offsetof_7_i64 = slf.int64_t();
            offsetof_8_i8 = slf.int8_t();
            offsetof_9_i32 = slf.int32_t();
            offsetof_10_i8 = slf.int8_t();
            offsetof_11_i16 = slf.int16_t();
            offsetof_12_i8 = slf.int8_t();
            alignment = slf.getAlignment();
            sizeof = (int) slf.getSizeof();
        }

    }

    @Override
    public byte _0_i8() {
        return MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_0_i8);
    }

    @Override
    public void _0_i8(byte value) {
        MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_0_i8, value);
    }

    @Override
    public short _1_i16() {
        return MEM_ACCESS.int16_t(memorySegment, LAYOUT.offsetof_1_i16);
    }

    @Override
    public void _1_i16(short value) {
        MEM_ACCESS.int16_t(memorySegment, LAYOUT.offsetof_1_i16, value);
    }

    @Override
    public byte _2_i8() {
        return MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_2_i8);
    }

    @Override
    public void _2_i8(byte value) {
        MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_2_i8, value);
    }

    @Override
    public int _3_i32() {
        return MEM_ACCESS.int32_t(memorySegment, LAYOUT.offsetof_3_i32);
    }

    @Override
    public void _3_i32(int value) {
        MEM_ACCESS.int32_t(memorySegment, LAYOUT.offsetof_3_i32, value);
    }

    @Override
    public byte _4_i8() {
        return MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_4_i8);
    }

    @Override
    public void _4_i8(byte value) {
        MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_4_i8, value);
    }

    @Override
    public long _5_i64() {
        return MEM_ACCESS.int64_t(memorySegment, LAYOUT.offsetof_5_i64);
    }

    @Override
    public void _5_i64(long value) {
        MEM_ACCESS.int64_t(memorySegment, LAYOUT.offsetof_5_i64, value);
    }

    @Override
    public byte _6_i8() {
        return MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_6_i8);
    }

    @Override
    public void _6_i8(byte value) {
        MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_6_i8, value);
    }

    @Override
    public long _7_i64() {
        return MEM_ACCESS.int64_t(memorySegment, LAYOUT.offsetof_7_i64);
    }

    @Override
    public void _7_i64(long value) {
        MEM_ACCESS.int64_t(memorySegment, LAYOUT.offsetof_7_i64, value);
    }

    @Override
    public byte _8_i8() {
        return MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_8_i8);
    }

    @Override
    public void _8_i8(byte value) {
        MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_8_i8);
    }

    @Override
    public int _9_i32() {
        return MEM_ACCESS.int32_t(memorySegment, LAYOUT.offsetof_9_i32);
    }

    @Override
    public void _9_i32(int value) {
        MEM_ACCESS.int32_t(memorySegment, LAYOUT.offsetof_9_i32);
    }

    @Override
    public byte _10_i8() {
        return MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_10_i8);
    }

    @Override
    public void _10_i8(byte value) {
        MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_10_i8);
    }

    @Override
    public short _11_i16() {
        return MEM_ACCESS.int16_t(memorySegment, LAYOUT.offsetof_11_i16);
    }

    @Override
    public void _11_i16(short value) {
        MEM_ACCESS.int16_t(memorySegment, LAYOUT.offsetof_11_i16);
    }

    @Override
    public byte _12_i8() {
        return MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_12_i8);
    }

    @Override
    public void _12_i8(byte value) {
        MEM_ACCESS.int8_t(memorySegment, LAYOUT.offsetof_12_i8);
    }

}
