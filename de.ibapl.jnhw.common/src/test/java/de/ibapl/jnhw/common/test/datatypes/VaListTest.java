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

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.VaList;
import java.lang.foreign.ValueLayout;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class VaListTest {

    public VaListTest() {
    }

    @Test
    public void testEmptyVaList() {
        switch (MultiarchTupelBuilder.getMultiarch()) {
            case AARCH64__LINUX__GNU, X86_64__LINUX__GNU, X86_64__WINDOWS__PE32_PLUS -> {
                VaList vaList = VaList.empty();
            }
            default ->
                assertThrows(UnsupportedOperationException.class, VaList::empty);

        }
    }

    //TODO reenable and catch exception once bug in OpenJDK is fixed
    //@Test
    public void testVaListOfAddressCrash() {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment mem = MemorySegment.allocateNative(128, ms);
            mem.set(ValueLayout.JAVA_INT, 0, 42);
            VaList vaList = VaList.ofAddress(mem.address(), ms);
            assertEquals(42, vaList.nextVarg(ValueLayout.JAVA_INT));
        }
    }

    @Test
    public void testVaListOfAddress() {
        try (MemorySession ms = MemorySession.openConfined()) {
            switch (MultiarchTupelBuilder.getMultiarch()) {
                case AARCH64__LINUX__GNU, X86_64__LINUX__GNU, X86_64__WINDOWS__PE32_PLUS -> {
                    VaList mem = VaList.make((t) -> {
                        t.addVarg(ValueLayout.JAVA_INT, 42);
                    }, ms);
                    VaList vaList = VaList.ofAddress(mem.address(), ms);
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
                    }, ms));
            }
        }
    }

    @Test
    public void testVaList() {
        try (MemorySession ms = MemorySession.openConfined()) {
            switch (MultiarchTupelBuilder.getMultiarch()) {
                case AARCH64__LINUX__GNU, X86_64__LINUX__GNU, X86_64__WINDOWS__PE32_PLUS -> {
                    VaList vaList = VaList.make((t) -> {
                        t.addVarg(ValueLayout.JAVA_INT, 42);
                    }, ms);
                    assertEquals(42, vaList.nextVarg(ValueLayout.JAVA_INT));

                }
                default ->
                    assertThrows(UnsupportedOperationException.class,
                            () -> VaList.make((t) -> {
                                t.addVarg(ValueLayout.JAVA_INT,
                                        42);
                            }, ms));

            }
        }
    }

}