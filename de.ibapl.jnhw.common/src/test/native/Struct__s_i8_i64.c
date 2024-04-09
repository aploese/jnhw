/**
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
//for offsetof
#include <stddef.h>
#include <stdint.h>

struct s_i8_i64 {
    int8_t _0_i8;
    int16_t _1_i16;
    int8_t _2_i8;
    int32_t _3_i32;
    int8_t _4_i8;
    int64_t _5_i64;
    int8_t _6_i8;
    int64_t _7_i64;
    int8_t _8_i8;
    int32_t _9_i32;
    int8_t _10_i8;
    int16_t _11_i16;
    int8_t _12_i8;
};

int sizeOf_s_i8_i64() {
    return sizeof (struct s_i8_i64);
}

int alignOf_s_i8_i64() {
    return __alignof__ (struct s_i8_i64);
}

int offsetOf_s_i8_i64__0_i8() {
    return offsetof(struct s_i8_i64, _0_i8);
}

int offsetOf_s_i8_i64__1_i16() {
    return offsetof(struct s_i8_i64, _1_i16);
}

int offsetOf_s_i8_i64__2_i8() {
    return offsetof(struct s_i8_i64, _2_i8);
}

int offsetOf_s_i8_i64__3_i32() {
    return offsetof(struct s_i8_i64, _3_i32);
}

int offsetOf_s_i8_i64__4_i8() {
    return offsetof(struct s_i8_i64, _4_i8);
}

int offsetOf_s_i8_i64__5_i64() {
    return offsetof(struct s_i8_i64, _5_i64);
}

int offsetOf_s_i8_i64__6_i8() {
    return offsetof(struct s_i8_i64, _6_i8);
}

int offsetOf_s_i8_i64__7_i64() {
    return offsetof(struct s_i8_i64, _7_i64);
}

int offsetOf_s_i8_i64__8_i8() {
    return offsetof(struct s_i8_i64, _8_i8);
}

int offsetOf_s_i8_i64__9_i32() {
    return offsetof(struct s_i8_i64, _9_i32);
}

int offsetOf_s_i8_i64__10_i8() {
    return offsetof(struct s_i8_i64, _10_i8);
}

int offsetOf_s_i8_i64__11_i16() {
    return offsetof(struct s_i8_i64, _11_i16);
}

int offsetOf_s_i8_i64__12_i8() {
    return offsetof(struct s_i8_i64, _12_i8);
}