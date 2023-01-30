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
package de.ibapl.jnhw.common.test.foreign;

import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.libloader.MemoryModel;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
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
 * @author aploese
 */
public class JavaForeignTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    public JavaForeignTest() {
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
        try (MemorySession ms = MemorySession.openConfined()) {

            MemorySegment pointerArray = MemorySegment.allocateNative(128, ms);
            MemoryAddress expected = MemoryAddress.ofLong(0x0000000080000000L);

            pointerArray.setAtIndex(ValueLayout.ADDRESS, 0, expected);

            //on 32 bit an signed int is cast to long ...
            MemoryAddress actual = pointerArray.getAtIndex(ValueLayout.ADDRESS, 0);
            if (MultiarchTupelBuilder.getMemoryModel() == MemoryModel.ILP32) {
                Assertions.assertEquals(MemoryAddress.ofLong((int) expected.toRawLongValue()), actual);
            } else {
                Assertions.assertEquals(expected, actual);
            }
        }
    }

    @Test
    public void testGet_32BitAddress() {
        try (MemorySession ms = MemorySession.openConfined()) {

            MemorySegment pointerArray = MemorySegment.allocateNative(128, ms);
            MemoryAddress expected = MemoryAddress.ofLong(0x0000000080000000L);

            pointerArray.set(ValueLayout.ADDRESS, 0, expected);

            MemoryAddress actual = pointerArray.get(ValueLayout.ADDRESS, 0);

            //on 32 bit an signed int is cast to long ...
            if (MultiarchTupelBuilder.getMemoryModel() == MemoryModel.ILP32) {
                Assertions.assertEquals(MemoryAddress.ofLong((int) expected.toRawLongValue()), actual);
            } else {
                Assertions.assertEquals(expected, actual);
            }
        }
    }

}
