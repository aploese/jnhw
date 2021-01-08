/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw;

import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.WordSize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AbstractMemoryTest {

    private static WordSize WORD_SIZE;
    private final int ALIGN8 = 1;
    private final int ALIGN16 = 2;
    private final int ALIGN32 = 4;
    private final int ALIGN64 = 8;
    

    @BeforeAll
    public static void setUpClass() {
        MultiarchInfo multiarchInfo = new MultiarchTupelBuilder().guessMultiarch().iterator().next();
        WORD_SIZE = multiarchInfo.getWordSize();
    }

    @Test
    public void testSizeOfS_i8() {
        Assertions.assertEquals(1, AbstractNativeMemory.sizeOfS_i8());
    }

    @Test
    public void testSizeOfS_s2xi8() {
        Assertions.assertEquals(2, AbstractNativeMemory.sizeOfS_s2xi8());
    }

    @Test
    public void testSizeOfS_3xi8() {
        Assertions.assertEquals(3, AbstractNativeMemory.sizeOfS_3xi8());
    }

    @Test
    public void testSizeOfS_si8_s3xi8() {
        Assertions.assertEquals(4, AbstractNativeMemory.sizeOfS_si8_s3xi8());
    }

    @Test
    public void testSizeOfS_s3xi8_si8() {
        Assertions.assertEquals(4, AbstractNativeMemory.sizeOfS_s3xi8_si8());
    }

    @Test
    public void testSizeOfS_i8_i16() {
        Assertions.assertEquals(4, AbstractNativeMemory.sizeOfS_i8_i16());
    }

    @Test
    public void testSizeOfS_i8_i32() {
        Assertions.assertEquals(8, AbstractNativeMemory.sizeOfS_i8_i32());
    }

    @Test
    public void testSizeOfS_i8_i64() {
        switch (WORD_SIZE) {
            case _32_BIT:
                Assertions.assertEquals(12, AbstractNativeMemory.sizeOfS_i8_i64());
                break;
            case _64_BIT:
                Assertions.assertEquals(16, AbstractNativeMemory.sizeOfS_i8_i64());
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + WORD_SIZE);
        }
    }

    @Test
    public void testSizeOfS_i16_i8() {
        Assertions.assertEquals(4, AbstractNativeMemory.sizeOfS_i16_i8());
    }

    @Test
    public void testSizeOfS_i32_i8() {
        Assertions.assertEquals(8, AbstractNativeMemory.sizeOfS_i32_i8());
    }

    @Test
    public void testSizeOfS_i64_i8() {
        switch (WORD_SIZE) {
            case _32_BIT:
                Assertions.assertEquals(12, AbstractNativeMemory.sizeOfS_i64_i8());
                break;
            case _64_BIT:
                Assertions.assertEquals(16, AbstractNativeMemory.sizeOfS_i64_i8());
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + WORD_SIZE);
        }
    }

    @Test
    public void testOffsetOfS_s2xi8__1_si8() {
        Assertions.assertEquals(ALIGN8, AbstractNativeMemory.offsetOfS_s2xi8__1_si8());
    }

    @Test
    public void testOffsetOfS_si8_s3xi8__1_s3xi8() {
        Assertions.assertEquals(ALIGN8, AbstractNativeMemory.offsetOfS_si8_s3xi8__1_s3xi8());
    }

    @Test
    public void testOffsetOfS_s3xi8_si8__1_si8() {
        Assertions.assertEquals(3, AbstractNativeMemory.offsetOfS_s3xi8_si8__1_si8());
    }

    @Test
    public void testOffsetOfS_i8_i16__1_i16() {
        Assertions.assertEquals(ALIGN16, AbstractNativeMemory.offsetOfS_i8_i16__1_i16());
    }

    @Test
    public void testOffsetOfS_i8_i32__1_i32() {
        Assertions.assertEquals(ALIGN32, AbstractNativeMemory.offsetOfS_i8_i32__1_i32());
    }

    @Test
    public void testOffsetOfS_i8_i64__1_i64() {
        switch (WORD_SIZE) {
            case _32_BIT:
                Assertions.assertEquals(ALIGN32, AbstractNativeMemory.offsetOfS_i8_i64__1_i64());
                break;
            case _64_BIT:
                Assertions.assertEquals(ALIGN64, AbstractNativeMemory.offsetOfS_i8_i64__1_i64());
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + WORD_SIZE);
        }
    }

    @Test
    public void testOffsetOfS_i16_i8__1_i8() {
        Assertions.assertEquals(ALIGN16, AbstractNativeMemory.offsetOfS_i16_i8__1_i8());
    }

    @Test
    public void testOffsetOfS_i32_i8__1_i8() {
        Assertions.assertEquals(ALIGN32, AbstractNativeMemory.offsetOfS_i32_i8__1_i8());
    }

    @Test
    public void testOffsetOfS_i64_i8__1_i8() {
        Assertions.assertEquals(ALIGN64, AbstractNativeMemory.offsetOfS_i64_i8__1_i8());
    }

    @Test
    public void test_i64_and_i8() {
        Assertions.assertEquals(AbstractNativeMemory.sizeOfS_i64_i8(), AbstractNativeMemory.sizeOfS_i8_i64());
        Assertions.assertEquals(ALIGN64, AbstractNativeMemory.offsetOfS_i64_i8__1_i8());
        switch (WORD_SIZE) {
            case _32_BIT:
                Assertions.assertNotEquals(AbstractNativeMemory.offsetOfS_i8_i64__1_i64(), AbstractNativeMemory.offsetOfS_i64_i8__1_i8());
                Assertions.assertEquals(ALIGN32, AbstractNativeMemory.offsetOfS_i8_i64__1_i64());
                break;
            case _64_BIT:
                Assertions.assertEquals(AbstractNativeMemory.offsetOfS_i8_i64__1_i64(), AbstractNativeMemory.offsetOfS_i64_i8__1_i8());
                Assertions.assertEquals(ALIGN64, AbstractNativeMemory.offsetOfS_i8_i64__1_i64());
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + WORD_SIZE);
        }
    }

    @Test
    public void test_i32_and_i8() {
        Assertions.assertEquals(AbstractNativeMemory.sizeOfS_i32_i8(), AbstractNativeMemory.sizeOfS_i8_i32());
        Assertions.assertEquals(AbstractNativeMemory.offsetOfS_i8_i32__1_i32(), AbstractNativeMemory.offsetOfS_i32_i8__1_i8());
    }

    @Test
    public void test_i16_and_i8() {
        Assertions.assertEquals(AbstractNativeMemory.sizeOfS_i16_i8(), AbstractNativeMemory.sizeOfS_i8_i16());
        Assertions.assertEquals(AbstractNativeMemory.offsetOfS_i8_i16__1_i16(), AbstractNativeMemory.offsetOfS_i16_i8__1_i8());
    }

    @Test
    public void test_Allignment() {
        Assertions.assertEquals(ALIGN8, AbstractNativeMemory.allignOfI8());
        Assertions.assertEquals(ALIGN16, AbstractNativeMemory.allignOfI16());
        Assertions.assertEquals(ALIGN32, AbstractNativeMemory.allignOfI32());
        switch (WORD_SIZE) {
            case _32_BIT:
        Assertions.assertEquals(ALIGN32, AbstractNativeMemory.allignOfI64());
                break;
            case _64_BIT:
        Assertions.assertEquals(ALIGN64, AbstractNativeMemory.allignOfI64());
                break;
            default:
                throw new RuntimeException("Unknown Wordsize " + WORD_SIZE);
        }
    }

}
