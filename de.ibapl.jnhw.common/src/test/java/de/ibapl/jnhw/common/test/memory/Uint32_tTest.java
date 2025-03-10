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
import de.ibapl.jnhw.common.memory.Uint32_t;
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
public class Uint32_tTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    public Uint32_tTest() {
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
     * Test of sizeofUint32_t method, of class Uint32_t.
     */
    @Test
    public void testSizeofInt32_t() {
        assertEquals(4, Uint32_t.DATA_TYPE.byteSize);
    }

    /**
     * Test of alignofUint32_t method, of class Uint32_t.
     */
    @Test
    public void testAlignofUint32_t() {
        assertEquals(Alignment.AT_4, Uint32_t.DATA_TYPE.ALIGNMENT);
    }

    @ParameterizedTest
    @ValueSource(ints = {
        0x00000001,
        0x8fffffff,
        0x00000000,
        0xf0000000,
        0xffffffff})
    public void testSetGetUInt32_t(final int value) {
        LibJnhwCommonTestLoader.invokeExact_V__I("jnhw_uint32_t_set", value);
        assertEquals(value, LibJnhwCommonTestLoader.SYMBOL_LOOKUP.findOrThrow("jnhw_uint32_t_mem").reinterpret(ValueLayout.JAVA_INT.byteSize(), Arena.ofAuto(), null).get(ValueLayout.JAVA_INT, 0), "uint32_t mem");
        assertEquals(value, LibJnhwCommonTestLoader.invokeExact__I__V("jnhw_uint32_t_get"), "uint32_t get");
    }

    /**
     * Test of rawUint32_t method, of class Uint32_t.
     */
    @Test
    public void testRawUint32_t() {
        try (Arena arena = Arena.ofConfined()) {
            Uint32_t instance = Uint32_t.allocateNative(arena);
            int expResult = 0x40302010;
            instance.uint32_t(expResult);
            assertEquals(expResult, instance.uint32_t());
            instance.uint32_t(-1);
            assertEquals(0x00000000ffffffffL, instance.uint32_t_AsLong());
            assertThrows(IllegalArgumentException.class, () -> instance.uint32_t_FromLong(-1L));
        }
    }

    @Test
    public void testNativeToString() {
        try (Arena arena = Arena.ofConfined()) {
            Uint32_t instance = new Uint32_t(arena.allocate(BaseDataType.uint32_t.byteSize), 0);
            instance.uint32_t(-2);
            assertEquals(String.valueOf(0x00000000FFFFFFFFL & -2), instance.nativeToString());
            assertEquals(Integer.toUnsignedString(-2), instance.nativeToString());
            assertEquals("0xfffffffe", instance.nativeToHexString());
        }
    }
}
