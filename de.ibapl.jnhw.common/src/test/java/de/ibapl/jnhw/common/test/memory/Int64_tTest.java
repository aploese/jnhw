/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2025, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.memory.Int64_t;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author aploese
 */
public class Int64_tTest {

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

    /**
     * Test of sizeofInt64_t method, of class Int64_t.
     */
    @Test
    public void testSizeofInt64_t() {
        assertEquals(8, Int64_t.DATA_TYPE.byteSize);
    }

    /**
     * Test of alignofInt64_t method, of class Int64_t.
     */
    @Test
    public void testAlignofInt64_t() {
        assertEquals(Alignment.AT_8, Int64_t.DATA_TYPE.ALIGNMENT);
    }

    @ParameterizedTest
    @ValueSource(longs = {
        0x0000000000000001L,
        0x8fffffffffffffffL,
        0x0000000000000000L,
        0xf000000000000000L,
        0xffffffffffffffffL})
    public void testSetGetInt64_t(final long value) {
        LibJnhwCommonTestLoader.invokeExact_V__L("jnhw_int64_t_set", value);
        assertEquals(value, LibJnhwCommonTestLoader.SYMBOL_LOOKUP.findOrThrow("jnhw_int64_t_mem").reinterpret(ValueLayout.JAVA_LONG.byteSize(), Arena.ofAuto(), null).get(ValueLayout.JAVA_LONG, 0), "int64_t mem");
        assertEquals(value, LibJnhwCommonTestLoader.invokeExact__L__V("jnhw_int64_t_get"), "int64_t get");
    }

    /**
     * Test of rawInt64_t method, of class Int64_t.
     */
    @Test
    public void testRawInt64_t() {
        try (Arena arena = Arena.ofConfined()) {
            Int64_t instance = Int64_t.allocateNative(arena);
            long expResult = 0x08070605040302010L;
            instance.int64_t(expResult);
            assertEquals(expResult, instance.int64_t());
        }
    }

    @Test
    public void testNativeToString() {
        try (Arena arena = Arena.ofConfined()) {
            Int64_t instance = new Int64_t(arena.allocate(BaseDataType.int64_t.byteSize), 0);
            instance.int64_t(-2);
            assertEquals("-2", instance.nativeToString());
            assertEquals("0xfffffffffffffffe", instance.nativeToHexString());
        }
    }
}
