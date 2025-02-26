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
package de.ibapl.jnhw.common.test.datatypes;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Uint64_t;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.libloader.Endianess;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
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
public class BaseDataTypeTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    private static int getSizeOfPointer() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_pointer");
    }

    private static int getSizeOf_int() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_int");
    }

    private static int getSizeOf_long() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_long");
    }

    private static int getSizeOf_long_long() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_long_long");
    }

    private static int getSizeOf_float() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_float");
    }

    private static int getSizeOf_double() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_double");
    }

    private static int getSizeOf_long_double() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("sizeOf_long_double");
    }

    private static boolean _L64() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("isDefined__L64") != 0;
    }

    private static boolean _LP64() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("isDefined__LP64") != 0;
    }

    private static boolean _ILP64() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("isDefined__ILP64") != 0;
    }

    private static boolean _LLP64() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("isDefined__LLP64") != 0;
    }

    private static boolean _ILP32() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("isDefined__ILP32") != 0;
    }

    private static boolean _LP32() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("isDefined__LP32") != 0;
    }

    public BaseDataTypeTest() {
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
    public void testMemoryModel() {

        switch (MultiarchTupelBuilder.getMemoryModel()) {
            case L64 -> {
                assertFalse(_LP32());
                assertFalse(_ILP32());
                assertTrue(_L64());
                assertFalse(_LP64());
                assertFalse(_LLP64());
                assertFalse(_ILP64());
            }
            case LP64 -> {
                assertFalse(_LP32());
                assertFalse(_ILP32());
                assertFalse(_L64());
                assertTrue(_LP64());
                assertFalse(_LLP64());
                assertFalse(_ILP64());
            }
            case ILP64 -> {
                assertFalse(_LP32());
                assertFalse(_ILP32());
                assertFalse(_L64());
                assertFalse(_LP64());
                assertFalse(_LLP64());
                assertTrue(_ILP64());
            }
            case LLP64 -> {
                assertFalse(_LP32());
                assertFalse(_ILP32());
                assertFalse(_L64());
                assertFalse(_LP64());
                assertFalse(_ILP64());
                if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
                    //mingw does not define __LLP64 on 64 bit, but define __ILP32 on 32 bit!
                    assertFalse(_LLP64());
                } else {
                    assertTrue(_LLP64());
                }
            }
            case ILP32 -> {
                assertFalse(_LP32());
                switch (MultiarchTupelBuilder.getMultiarch()) {
                    case MIPS_EL__LINUX__GNU, ARM__LINUX__GNU_EABI_HF, POWER_PC__LINUX__GNU ->
                        //TODO bug ?? GCC does not define this !?
                        assertFalse(_ILP32());
                    default ->
                        assertTrue(_ILP32());
                }
                assertFalse(_L64());
                assertFalse(_LP64());
                assertFalse(_LLP64());
                assertFalse(_ILP64());
            }
            case LP32 -> {
                assertTrue(_LP32());
                assertFalse(_ILP32());
                assertFalse(_L64());
                assertFalse(_LP64());
                assertFalse(_LLP64());
                assertFalse(_ILP64());
            }
            default ->
                throw new AssertionError("Unknown memory model: " + MultiarchTupelBuilder.getMemoryModel());
        }
    }

    @Test
    public void testEndianes() {
        try (Arena arena = Arena.ofConfined()) {
            final Uint64_t uint64_t = new Uint64_t(arena.allocate(BaseDataType.uint64_t.byteSize), 0);
            OpaqueMemory.setByte(uint64_t, 0, (byte) 0x01);
            OpaqueMemory.setByte(uint64_t, 1, (byte) 0x02);
            OpaqueMemory.setByte(uint64_t, 2, (byte) 0x03);
            OpaqueMemory.setByte(uint64_t, 3, (byte) 0x04);
            OpaqueMemory.setByte(uint64_t, 4, (byte) 0x05);
            OpaqueMemory.setByte(uint64_t, 5, (byte) 0x06);
            OpaqueMemory.setByte(uint64_t, 6, (byte) 0x07);
            OpaqueMemory.setByte(uint64_t, 7, (byte) 0x08);
            if (0x0807060504030201L == uint64_t.uint64_t()) {
                assertEquals(Endianess.LITTLE, MultiarchTupelBuilder.getEndianess());
            } else if (0x0102030405060708L == uint64_t.uint64_t()) {
                assertEquals(Endianess.BIG, MultiarchTupelBuilder.getEndianess());
            } else {
                fail("Can't figure out the endianess for result: 0x" + uint64_t.nativeToHexString() + " multiarchinfo: " + MultiarchTupelBuilder.getMultiarchs());
            }
        }
    }

    @Test
    public void testSizes() {
        assertAll(
                () -> assertEquals(getSizeOf_int(), BaseDataType.C_int.byteSize, "sizeof int"),
                () -> assertEquals(getSizeOf_long(), BaseDataType.C_long.byteSize, "sizeof long"),
                () -> assertEquals(getSizeOf_long_long(), BaseDataType.C_long_long.byteSize, "sizeof long long"),
                () -> assertEquals(getSizeOfPointer(), BaseDataType.C_pointer.byteSize, "sizeof void*"),
                () -> assertEquals(getSizeOf_float(), BaseDataType._float.byteSize, "sizeof float"),
                () -> assertEquals(getSizeOf_double(), BaseDataType._double.byteSize, "sizeof double"),
                () -> assertEquals(getSizeOf_long_double(), BaseDataType._long_double.byteSize, "sizeof long double")
        );
    }

}
