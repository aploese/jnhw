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
import de.ibapl.jnhw.common.memory.Int16_t;
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
public class Int16_tTest {

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
     * Test of sizeofInt16_t method, of class Int16_t.
     */
    @Test
    public void testSizeofInt16_t() {
        assertEquals(2, Int16_t.DATA_TYPE.byteSize);
    }

    /**
     * Test of alignofInt16_t method, of class Int16_t.
     */
    @Test
    public void testAlignofInt16_t() {
        assertEquals(Alignment.AT_2, Int16_t.DATA_TYPE.ALIGNMENT);
    }

    @ParameterizedTest
    @ValueSource(shorts = {
        (short)0x0001,
        (short)0x8fff,
        (short)0x0000,
        (short)0xf000,
        (short)0xffff})
    public void testSetGetInt16_t(final short value) {
        LibJnhwCommonTestLoader.invokeExact_V__S("jnhw_int16_t_set", value);
        assertEquals(value, LibJnhwCommonTestLoader.SYMBOL_LOOKUP.findOrThrow("jnhw_int16_t_mem").reinterpret(ValueLayout.JAVA_SHORT.byteSize(), Arena.ofAuto(), null).get(ValueLayout.JAVA_SHORT, 0), "int16_t mem");
        assertEquals(value, LibJnhwCommonTestLoader.invokeExact__S__V("jnhw_int16_t_get"), "int16_t get");
    }
    
    /**
     * Test of rawInt16_t method, of class Int16_t.
     */
    @Test
    public void testRawInt16_t() {
        try (Arena arena = Arena.ofConfined()) {
            Int16_t instance = Int16_t.allocateNative(arena);
            short expResult = 0x2010;
            instance.int16_t(expResult);
            assertEquals(expResult, instance.int16_t());
        }
    }

    @Test
    public void testNativeToString() {
        try (Arena arena = Arena.ofConfined()) {
            Int16_t instance = new Int16_t(arena.allocate(BaseDataType.int16_t.byteSize), 0);
            instance.int16_t((short) -2);
            assertEquals("-2", instance.nativeToString());
            assertEquals("0xfffe", instance.nativeToHexString());
        }
    }
}
