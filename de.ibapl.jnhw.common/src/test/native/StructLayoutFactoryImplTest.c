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

#include <stdint.h>
//for offsetof
#include <stddef.h>
#include <assert.h>

/** If this is not compilable, then the failed asserts indicate the wrong behavior of StructFactoryImpl
 * at that point.
 *
 */

struct s1 {
    uint8_t f0;
    uint16_t f1;
};

static_assert(4 == sizeof (struct s1), "4 != sizeof(struct s1)");
static_assert(2 == offsetof(struct s1, f1), "2 != offsetof(struct s1, f1)");
static_assert(2 == __alignof__ (struct s1), "2 != __alignof__(struct s1)");

struct s1_fields_reversed {
    uint16_t f0;
    uint8_t f1;
};

static_assert(4 == sizeof (struct s1_fields_reversed), "4 != sizeof(struct s1_fields_reversed)");
static_assert(2 == offsetof(struct s1_fields_reversed, f1), "2 != offsetof(struct s1_fields_reversed, f1)");
static_assert(2 == __alignof__ (struct s1_fields_reversed), "2 != __alignof__(struct s1_fields_reversed)");

struct s2 {
    uint8_t f0;
    struct s1 f1;
};

static_assert(6 == sizeof (struct s2), "6 != sizeof(struct s2)");
static_assert(2 == offsetof(struct s2, f1), "2 != offsetof(struct s2, f1)");
static_assert(2 == __alignof__ (struct s2), "2 != __alignof__(struct s2)");

struct s3 {
    uint8_t f0;
    struct s1 f1;
} __attribute__ ((packed));

static_assert(5 == sizeof (struct s3), "5 != sizeof(struct s3)");
static_assert(1 == offsetof(struct s3, f1), "1 == offsetof(struct s2, f1)");
static_assert(1 == __alignof__ (struct s3), "1 != __alignof__(struct s3)");