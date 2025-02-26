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
import de.ibapl.jnhw.common.memory.Uint8_t;
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
public class Uint8_tTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    public Uint8_tTest() {
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
     * Test of sizeofInt8_t method, of class Uint8_t.
     */
    @Test
    public void testSizeofUint8_t() {
        assertEquals(1, Uint8_t.DATA_TYPE.byteSize);
    }

    /**
     * Test of alignofInt8_t method, of class Uint8_t.
     */
    @Test
    public void testAlignofUint8_t() {
        assertEquals(Alignment.AT_1, Uint8_t.DATA_TYPE.ALIGNMENT);
    }

    @ParameterizedTest
    @ValueSource(bytes = {
        (byte)0x01,
        (byte)0x8f,
        (byte)0x00,
        (byte)0xf0,
        (byte)0xff})
    public void testSetGetUInt8_t(final byte value) {
        LibJnhwCommonTestLoader.invokeExact_V__B("jnhw_uint8_t_set", value);
        assertEquals(value, LibJnhwCommonTestLoader.SYMBOL_LOOKUP.findOrThrow("jnhw_uint8_t_mem").reinterpret(ValueLayout.JAVA_BYTE.byteSize(), Arena.ofAuto(), null).get(ValueLayout.JAVA_BYTE, 0), "uint8_t mem");
        assertEquals(value, LibJnhwCommonTestLoader.invokeExact__B__V("jnhw_uint8_t_get"), "uint8_t get");
    }
    
    /**
     * Test of rawUint8_t method, of class Uint8_t.
     */
    @Test
    public void testRawUint8_t() {
        try (Arena arena = Arena.ofConfined()) {
            Uint8_t instance = Uint8_t.allocateNative(arena);
            byte expResult = 0x10;
            instance.uint8_t(expResult);
            assertEquals(expResult, instance.uint8_t());
            instance.uint8_t((byte) -1);
            assertEquals(0x00ff, instance.uint8_t_AsShort());
            assertThrows(IllegalArgumentException.class, () -> instance.uint8_t_FromShort((short) -1));
        }
    }

    @Test
    public void testNativeToString() {
        try (Arena arena = Arena.ofConfined()) {
            Uint8_t instance = new Uint8_t(arena.allocate(BaseDataType.uint8_t.byteSize), 0);
            instance.uint8_t((byte) -2);
            assertEquals(String.valueOf(0x00FF & -2), instance.nativeToString());
            assertEquals(String.valueOf(Byte.toUnsignedInt((byte) -2)), instance.nativeToString());
            assertEquals("0xfe", instance.nativeToHexString());
        }
    }
}
