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
package de.ibapl.jnhw.common.test.memory;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.Uint64_t;
import de.ibapl.jnhw.common.memory.layout.Alignment;
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
public class Uint64_tTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    public Uint64_tTest() {
    }

    @BeforeEach
    public void setUpBeforeEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testTnfo);
    }

    @AfterEach
    public void tearDownAfterEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterEach(testTnfo);
    }

    /**
     * Test of sizeofUint64_t method, of class Uint64_t.
     */
    @Test
    public void testSizeofUint64_t() {
        assertEquals(8, Uint64_t.DATA_TYPE.SIZE_OF);
    }

    /**
     * Test of alignofUint64_t method, of class Uint64_t.
     */
    @Test
    public void testAlignofUint64_t() {
        assertEquals(Alignment.AT_8, Uint64_t.DATA_TYPE.ALIGN_OF);
    }

    /**
     * Test of rawUint64_t method, of class Uint64_t.
     */
    @Test
    public void testRawUint64_t() {
        try (Arena arena = Arena.ofConfined()) {
            Uint64_t instance = Uint64_t.allocateNative(arena);
            long expResult = 0x08070605040302010L;
            instance.uint64_t(expResult);
            assertEquals(expResult, instance.uint64_t());
        }
    }

    @Test
    public void testNativeToString() {
        try (Arena arena = Arena.ofConfined()) {
            Uint64_t instance = new Uint64_t(arena.allocate(BaseDataType.uint64_t.SIZE_OF), 0);
            instance.uint64_t(-2);
            assertEquals(Long.toUnsignedString(-2), instance.nativeToString());
            assertEquals("0xfffffffffffffffe", instance.nativeToHexString());
        }
    }
}
