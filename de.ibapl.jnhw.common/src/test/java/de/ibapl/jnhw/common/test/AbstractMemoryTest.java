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
package de.ibapl.jnhw.common.test;

import de.ibapl.jnhw.common.memory.AbstractNativeMemory.NativeMemoryAlignment;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbstractMemoryTest {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();
    private final int ALIGN8 = 1;
    private final int ALIGN16 = 2;
    private final int ALIGN32 = 4;
    private final int ALIGN64 = 8;

    @Test
    public void testSizeOfS_i8() {
        Assertions.assertEquals(1, NativeMemoryAlignment.sizeOfS_i8());
    }

    @Test
    public void testSizeOfS_s2xi8() {
        Assertions.assertEquals(2, NativeMemoryAlignment.sizeOfS_s2xi8());
    }

    @Test
    public void testSizeOfS_3xi8() {
        Assertions.assertEquals(3, NativeMemoryAlignment.sizeOfS_3xi8());
    }

    @Test
    public void testSizeOfS_si8_s3xi8() {
        Assertions.assertEquals(4, NativeMemoryAlignment.sizeOfS_si8_s3xi8());
    }

    @Test
    public void testSizeOfS_s3xi8_si8() {
        Assertions.assertEquals(4, NativeMemoryAlignment.sizeOfS_s3xi8_si8());
    }

    @Test
    public void testS_i8_i16() {
        Assertions.assertEquals(2, NativeMemoryAlignment.offsetOfS_i8_i16__1_i16());
        Assertions.assertEquals(4, NativeMemoryAlignment.offsetOfS_i8_i16__2_i8());
        Assertions.assertEquals(2, NativeMemoryAlignment.alignOfS_i8_i16());
        Assertions.assertEquals(6, NativeMemoryAlignment.sizeOfS_i8_i16());
    }

    @Test
    public void testS_i8_i32() {
        Assertions.assertEquals(2, NativeMemoryAlignment.offsetOfS_i8_i32__1_i16());
        Assertions.assertEquals(4, NativeMemoryAlignment.offsetOfS_i8_i32__2_i8());
        Assertions.assertEquals(8, NativeMemoryAlignment.offsetOfS_i8_i32__3_i32());
        Assertions.assertEquals(12, NativeMemoryAlignment.offsetOfS_i8_i32__4_i8());
        Assertions.assertEquals(16, NativeMemoryAlignment.offsetOfS_i8_i32__5_i32());
        Assertions.assertEquals(24, NativeMemoryAlignment.offsetOfS_i8_i32__6_i8());
        Assertions.assertEquals(22, NativeMemoryAlignment.offsetOfS_i8_i32__7_i16());
        Assertions.assertEquals(24, NativeMemoryAlignment.offsetOfS_i8_i32__8_i8());
        Assertions.assertEquals(4, NativeMemoryAlignment.alignOfS_i8_i32());
        Assertions.assertEquals(28, NativeMemoryAlignment.sizeOfS_i8_i32());
    }

    @Test
    public void testS_i8_i64() {
        Assertions.assertEquals(2, NativeMemoryAlignment.offsetOfS_i8_i64__1_i16());
        Assertions.assertEquals(4, NativeMemoryAlignment.offsetOfS_i8_i64__2_i8());
        Assertions.assertEquals(8, NativeMemoryAlignment.offsetOfS_i8_i64__3_i32());
        Assertions.assertEquals(12, NativeMemoryAlignment.offsetOfS_i8_i64__4_i8());
        Assertions.assertEquals(16, NativeMemoryAlignment.offsetOfS_i8_i64__5_i64());
        Assertions.assertEquals(24, NativeMemoryAlignment.offsetOfS_i8_i64__6_i8());
        switch (MULTIARCH_TUPEL_BUILDER.getArch()) {
            case I386:
                Assertions.assertEquals(28, NativeMemoryAlignment.offsetOfS_i8_i64__7_i64());
                Assertions.assertEquals(36, NativeMemoryAlignment.offsetOfS_i8_i64__8_i8());
                Assertions.assertEquals(40, NativeMemoryAlignment.offsetOfS_i8_i64__9_i32());
                Assertions.assertEquals(44, NativeMemoryAlignment.offsetOfS_i8_i64__10_i8());
                Assertions.assertEquals(46, NativeMemoryAlignment.offsetOfS_i8_i64__11_i16());
                Assertions.assertEquals(48, NativeMemoryAlignment.offsetOfS_i8_i64__12_i8());
                Assertions.assertEquals(4, NativeMemoryAlignment.alignOfS_i8_i64());
                Assertions.assertEquals(52, NativeMemoryAlignment.sizeOfS_i8_i64());
                break;
            default:
                Assertions.assertEquals(32, NativeMemoryAlignment.offsetOfS_i8_i64__7_i64());
                Assertions.assertEquals(40, NativeMemoryAlignment.offsetOfS_i8_i64__8_i8());
                Assertions.assertEquals(44, NativeMemoryAlignment.offsetOfS_i8_i64__9_i32());
                Assertions.assertEquals(48, NativeMemoryAlignment.offsetOfS_i8_i64__10_i8());
                Assertions.assertEquals(50, NativeMemoryAlignment.offsetOfS_i8_i64__11_i16());
                Assertions.assertEquals(52, NativeMemoryAlignment.offsetOfS_i8_i64__12_i8());
                Assertions.assertEquals(8, NativeMemoryAlignment.alignOfS_i8_i64());
                Assertions.assertEquals(56, NativeMemoryAlignment.sizeOfS_i8_i64());
        }
    }

    public void testSizeOfS_i8_i64() {
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                Assertions.assertEquals(12, NativeMemoryAlignment.sizeOfS_i8_i64());
                break;
            case _64_BIT:
                Assertions.assertEquals(16, NativeMemoryAlignment.sizeOfS_i8_i64());
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + MULTIARCH_TUPEL_BUILDER.getWordSize());
        }
    }

    @Test
    public void testOffsetOfS_s2xi8__1_si8() {
        Assertions.assertEquals(ALIGN8, NativeMemoryAlignment.offsetOfS_s2xi8__1_si8());
    }

    @Test
    public void testOffsetOfS_si8_s3xi8__1_s3xi8() {
        Assertions.assertEquals(ALIGN8, NativeMemoryAlignment.offsetOfS_si8_s3xi8__1_s3xi8());
    }

    @Test
    public void testOffsetOfS_s3xi8_si8__1_si8() {
        Assertions.assertEquals(3, NativeMemoryAlignment.offsetOfS_s3xi8_si8__1_si8());
    }

    @Test
    public void testOffsetOfS_i8_i16__1_i16() {
        Assertions.assertEquals(ALIGN16, NativeMemoryAlignment.offsetOfS_i8_i16__1_i16());
    }

    @Test
    public void test_Allignment() {
        Assertions.assertEquals(ALIGN8, NativeMemoryAlignment.allignOfI8());
        Assertions.assertEquals(ALIGN16, NativeMemoryAlignment.allignOfI16());
        Assertions.assertEquals(ALIGN32, NativeMemoryAlignment.allignOfI32());
        Assertions.assertEquals(ALIGN64, NativeMemoryAlignment.allignOfI64());
    }

}
