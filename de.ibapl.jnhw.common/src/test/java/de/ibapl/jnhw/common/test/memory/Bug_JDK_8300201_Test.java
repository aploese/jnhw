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

import de.ibapl.jnhw.common.annotation.Bug_JDK_8300201;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.SizeInBit;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.ValueLayout;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___V;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import org.junit.jupiter.api.BeforeAll;

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

    public Bug_JDK_8300201_Test() {
    }

    final static long TEST_VALUE = 0x0000000080000000L;
    final static MemoryAddress BUGGY_VALUE = MemoryAddress.ofLong(0xffffffff00000000L | TEST_VALUE);

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        LibJnhwCommonTestLoader.touch();
    }

    @Test
    public void testGetAtIndex_32BitAddress() {
        if (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer != SizeInBit._32_BIT) {
            //Nothing to test ... only 32bit are of interest here.
            return;
        }
        try (MemorySession ms = MemorySession.openConfined()) {

            MemorySegment pointerArray = MemorySegment.allocateNative(128, ms);
            MemoryAddress expected = MemoryAddress.ofLong(TEST_VALUE);

            pointerArray.setAtIndex(ValueLayout.ADDRESS, 0, expected);

            MemoryAddress actual = pointerArray.getAtIndex(ValueLayout.ADDRESS, 0);

            Assertions.assertEquals(BUGGY_VALUE, actual);
//            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    public void testGet_32BitAddress() {
        if (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer != SizeInBit._32_BIT) {
            //Nothing to test ... only 32bit are of interest here.
            return;
        }
        try (MemorySession ms = MemorySession.openConfined()) {

            MemorySegment pointerArray = MemorySegment.allocateNative(128, ms);
            MemoryAddress expected = MemoryAddress.ofLong(TEST_VALUE);

            pointerArray.set(ValueLayout.ADDRESS, 0, expected);

            MemoryAddress actual = pointerArray.get(ValueLayout.ADDRESS, 0);

            Assertions.assertEquals(BUGGY_VALUE, actual);
//            Assertions.assertEquals(expected, actual);
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
                BaseDataType.uintptr_t);

        MemoryAddress actual = call_uintptr_t.invoke_MA___V();
        Assertions.assertEquals(TEST_VALUE, actual.toRawLongValue());

        JnhwMh_MA___V.ExceptionErased call_intptr_t = JnhwMh_MA___V.mandatoryOf(
                LibJnhwCommonTestLoader.SYMBOL_LOOKUP,
                "JnhwIntptrT__MA___V_0x0000000080000000L",
                BaseDataType.intptr_t);

        actual = call_intptr_t.invoke_MA___V();
        Assertions.assertEquals(TEST_VALUE, actual.toRawLongValue());
    }

}
