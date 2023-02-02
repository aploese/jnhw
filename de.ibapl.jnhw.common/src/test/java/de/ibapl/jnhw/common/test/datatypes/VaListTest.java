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
package de.ibapl.jnhw.common.test.datatypes;

import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.VaList;
import java.lang.foreign.ValueLayout;
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
public class VaListTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    public VaListTest() {
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
    public void testEmptyVaList() {
        switch (MultiarchTupelBuilder.getMultiarch()) {
            case AARCH64__LINUX__GNU, X86_64__APPLE_DARWIN, X86_64__FREE_BSD__BSD, X86_64__LINUX__GNU, X86_64__WINDOWS__PE32_PLUS -> {
                VaList vaList = VaList.empty();
            }
            default ->
                assertThrows(UnsupportedOperationException.class, VaList::empty);

        }
    }

    //TODO reenable and catch exception once bug in OpenJDK is fixed
    //@Test
    public void testVaListOfAddressCrash() {
        try (Arena ms = Arena.openConfined()) {
            MemorySegment mem = ms.allocate(128);
            mem.set(ValueLayout.JAVA_INT, 0, 42);
            VaList vaList = VaList.ofAddress(mem.address(), ms.scope());
            assertEquals(42, vaList.nextVarg(ValueLayout.JAVA_INT));
        }
    }

    @Test
    public void testVaListOfAddress() {
        try (Arena ms = Arena.openConfined()) {
            switch (MultiarchTupelBuilder.getMultiarch()) {
                case AARCH64__LINUX__GNU, X86_64__APPLE_DARWIN, X86_64__FREE_BSD__BSD, X86_64__LINUX__GNU, X86_64__WINDOWS__PE32_PLUS -> {
                    VaList mem = VaList.make((t) -> {
                        t.addVarg(ValueLayout.JAVA_INT, 42);
                    }, ms.scope());
                    VaList vaList = VaList.ofAddress(mem.segment().address(), ms.scope());
                    assertEquals(42, vaList.nextVarg(ValueLayout.JAVA_INT));
                    //TODO report this - no boundary checks - it crashes too
                    /*
                    for (int i = 0; i < 1024; i++) {
                        assertEquals(0, vaList.nextVarg(ValueLayout.JAVA_INT));
                    }
                     */
                }
                default ->
                    assertThrows(UnsupportedOperationException.class, () -> VaList.make((t) -> {
                        t.addVarg(ValueLayout.JAVA_INT, 42);
                    }, ms.scope()));
            }
        }
    }

    @Test
    public void testVaList() {
        try (Arena ms = Arena.openConfined()) {
            switch (MultiarchTupelBuilder.getMultiarch()) {
                case AARCH64__LINUX__GNU, X86_64__APPLE_DARWIN, X86_64__FREE_BSD__BSD, X86_64__LINUX__GNU, X86_64__WINDOWS__PE32_PLUS -> {
                    VaList vaList = VaList.make((t) -> {
                        t.addVarg(ValueLayout.JAVA_INT, 42);
                    }, ms.scope());
                    assertEquals(42, vaList.nextVarg(ValueLayout.JAVA_INT));

                }
                default ->
                    assertThrows(UnsupportedOperationException.class,
                            () -> VaList.make((t) -> {
                                t.addVarg(ValueLayout.JAVA_INT,
                                        42);
                            }, ms.scope()));

            }
        }
    }

}
