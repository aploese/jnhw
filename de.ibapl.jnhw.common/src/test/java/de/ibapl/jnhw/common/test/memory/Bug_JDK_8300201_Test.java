/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2023-2025, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.annotation.Bug_JDK_8300201;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___V;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.SizeInByte;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 *
 * As long as Bug
 * <a href="https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8300201">JDK-8300201</a>
 * is alive the test should pass.
 *
 * @author aploese
 */
@Bug_JDK_8300201
public class Bug_JDK_8300201_Test {

    final static long TEST_VALUE = 0x0000000080000000L;
    final static MemorySegment BUGGY_VALUE = MemorySegment.ofAddress(0xffffffff00000000L | TEST_VALUE);

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
    public void testGetAtIndex_32BitAddress() {
        if (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer != SizeInByte._32_Bit) {
            //Nothing to test ... only 32bit are of interest here.
            return;
        }
        try (Arena arena = Arena.ofConfined()) {

            MemorySegment pointerArray = arena.allocate(128);
            MemorySegment expected = MemorySegment.ofAddress(TEST_VALUE);

            pointerArray.setAtIndex(ValueLayout.ADDRESS, 0, expected);

            MemorySegment actual = pointerArray.getAtIndex(ValueLayout.ADDRESS, 0);

            Assertions.assertEquals(BUGGY_VALUE, actual);
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals(TEST_VALUE, actual.address());
        }
    }

    @Test
    public void testGet_32BitAddress() {
        if (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer != SizeInByte._32_Bit) {
            //Nothing to test ... only 32bit are of interest here.
            return;
        }
        try (Arena arena = Arena.ofConfined()) {

            MemorySegment pointerArray = arena.allocate(128);
            MemorySegment expected = MemorySegment.ofAddress(TEST_VALUE);

            pointerArray.set(ValueLayout.ADDRESS, 0, expected);

            MemorySegment actual = pointerArray.get(ValueLayout.ADDRESS, 0);

            Assertions.assertEquals(BUGGY_VALUE, actual);
            Assertions.assertEquals(expected, actual);
            Assertions.assertEquals(TEST_VALUE, actual.address());
        }
    }

    /**
     * This test must pass on all pointer sizes - currently (as of JDK 19 -
     * there is in foreign impl of this)
     */
    @Test
    public void testReturnFromCall_32BitAddress() {
        JnhwMh_MA___V.ExceptionErased call_uintptr_t = JnhwMh_MA___V.mandatoryOf(
                LibJnhwCommonTestLoader.SYMBOL_LOOKUP,
                "JnhwUintptrT__MA___V_0x0000000080000000L",
                BaseDataType.uintptr_t,
                0);

        MemorySegment actual = call_uintptr_t.invoke_MA___V();
        Assertions.assertEquals(TEST_VALUE, actual.address());

        JnhwMh_MA___V.ExceptionErased call_intptr_t = JnhwMh_MA___V.mandatoryOf(
                LibJnhwCommonTestLoader.SYMBOL_LOOKUP,
                "JnhwIntptrT__MA___V_0x0000000080000000L",
                BaseDataType.intptr_t,
                0);

        actual = call_intptr_t.invoke_MA___V();
        Assertions.assertEquals(TEST_VALUE, actual.address());
    }

}
