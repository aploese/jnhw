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

/**
 * the underlaying struct shall be defined as follows:
 * <pre>{@code
 * struct s_i8_i64 {
 * int8_t _0_i8;
 * int16_t _1_i16;
 * int8_t _2_i8;
 * int32_t _3_i32;
 * int8_t _4_i8;
 * int64_t _5_i64;
 * int8_t _6_i8;
 * int64_t _7_i64;
 * int8_t _8_i8;
 * int32_t _9_i32;
 * int8_t _10_i8;
 * int16_t _11_i16;
 * int8_t _12_i8;
 * };
 * }</pre> struct SimpleStructure {
 *
 * @author aploese
 */
interface S_i8_i64 {

    byte _0_i8();

    void _0_i8(byte value);

    short _1_i16();

    void _1_i16(short value);

    byte _2_i8();

    void _2_i8(byte value);

    int _3_i32();

    void _3_i32(int value);

    byte _4_i8();

    void _4_i8(byte value);

    long _5_i64();

    void _5_i64(long value);

    byte _6_i8();

    void _6_i8(byte value);

    long _7_i64();

    void _7_i64(long value);

    byte _8_i8();

    void _8_i8(byte value);

    int _9_i32();

    void _9_i32(int value);

    byte _10_i8();

    void _10_i8(byte value);

    short _11_i16();

    void _11_i16(short value);

    byte _12_i8();

    void _12_i8(byte value);

}
