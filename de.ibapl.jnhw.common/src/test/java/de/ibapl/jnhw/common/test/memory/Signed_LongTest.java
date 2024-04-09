/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.test.memory;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Int64_t;
import de.ibapl.jnhw.common.memory.Signed_Long;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import java.lang.foreign.Arena;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 *
 * @author aploese
 */
public class Signed_LongTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    @BeforeEach
    public void setUpBeforeEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testTnfo);
    }

    @AfterEach
    public void tearDownAfterEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterEach(testTnfo);
    }

    @Test
    public void testNative() {
        try (Arena arena = Arena.ofConfined()) {
            Signed_Long instance = Signed_Long.allocateNative(arena);
            long input64 = 0x8070605040302010L;
            if (BaseDataType.C_long.SIZE_OF == 8) {
                instance.signed_long(input64);
                assertEquals(input64, instance.signed_long());
            } else {
                //Big Endian so the layout of the bytes is different.... from Little Endian
                instance.signed_long(input64 >> 32); // shift with sign
                assertEquals(input64 >> 32, instance.signed_long());
            }
            instance.signed_long(-33);
            assertEquals(-33, instance.signed_long());
            if (BaseDataType.C_long.SIZE_OF == 8) {
                instance.signed_long(input64);
                assertEquals(input64, instance.signed_long());
            } else {
                assertThrows(IllegalArgumentException.class, () -> instance.signed_long(input64));
            }
        }
    }

    @Test
    public void testNativeToString() {
        try (Arena arena = Arena.ofConfined()) {
            Signed_Long instance = new Signed_Long(arena.allocate(Signed_Long.DATA_TYPE.SIZE_OF), 0);
            if (BaseDataType.C_long.SIZE_OF == 8) {
                Int64_t int64_t = Int64_t.map(instance, 0);
                int64_t.int64_t(0xfffffffffffffffeL);
                assertEquals(Integer.toString(0xfffffffe), instance.nativeToString());
                assertEquals("0xfffffffffffffffe", instance.nativeToHexString());
            } else {
                Int32_t int32_t = Int32_t.map(instance, 0);
                int32_t.int32_t(0xfffffffe);
                assertEquals(Integer.toString(0xfffffffe), instance.nativeToString());
                assertEquals("0xfffffffe", instance.nativeToHexString());
            }
        }
    }
}
