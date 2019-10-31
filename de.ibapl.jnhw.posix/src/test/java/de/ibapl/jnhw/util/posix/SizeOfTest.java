/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.util.posix;

import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import de.ibapl.jnhw.libloader.OS;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class SizeOfTest {

    public SizeOfTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of off_t method, of class SizeOf.
     */
    @Test
    public void testOff_t() {
        System.out.println("off_t");
        for (MultiarchInfo mi : NativeLibResolver.getMultiArchInfos()) {
            switch (mi) {
                case X86_64__LINUX__GNU:
                case X86_64__MAC_OS_X__BSD:
                case X86_64__FREE_BSD__BSD:
                    assertEquals(8, SizeOf.off_t(), "off_t");
                    break;
                case ARM__LINUX__GNU_EABI:
                case ARM__LINUX__GNU_EABI_HF:
                case I386__LINUX__GNU:
                    assertEquals(4, SizeOf.off_t(), "off_t");
                    break;
                case I386__WINDOWS__PE32:
                case X86_64__WINDOWS__PE32_PLUS:
                    assertEquals(0, SizeOf.off_t(), "off_t");
                    break;
                default:
                    fail("no known test value for off_t in multiarch: " + mi);
            }
        }
    }

    /**
     * Test of cc_t method, of class SizeOf.
     */
    @Test
    public void testCc_t() {
        System.out.println("cc_t");
        for (MultiarchInfo mi : NativeLibResolver.getMultiArchInfos()) {
            switch (mi) {
                case X86_64__LINUX__GNU:
                case ARM__LINUX__GNU_EABI:
                case ARM__LINUX__GNU_EABI_HF:
                case I386__LINUX__GNU:
                case X86_64__MAC_OS_X__BSD:
                case X86_64__FREE_BSD__BSD:
                    assertEquals(1, SizeOf.cc_t(), "cc_t");
                    break;
                case I386__WINDOWS__PE32:
                case X86_64__WINDOWS__PE32_PLUS:
                    assertEquals(0, SizeOf.off_t(), "cc_t");
                    break;
                default:
                    fail("no known test value for cc_t in multiarch: " + mi);
            }
        }
    }

    /**
     * Test of tcflag_t method, of class SizeOf.
     */
    @Test
    public void testTcflag_t() {
        System.out.println("tcflag_t");
        for (MultiarchInfo mi : NativeLibResolver.getMultiArchInfos()) {
            switch (mi) {
                case X86_64__LINUX__GNU:
                case ARM__LINUX__GNU_EABI:
                case ARM__LINUX__GNU_EABI_HF:
                case I386__LINUX__GNU:
                case X86_64__MAC_OS_X__BSD:
                case X86_64__FREE_BSD__BSD:
                    assertEquals(4, SizeOf.tcflag_t(), "tcflag_t");
                    break;
                case I386__WINDOWS__PE32:
                case X86_64__WINDOWS__PE32_PLUS:
                    assertEquals(0, SizeOf.off_t(), "tcflag_t");
                    break;
                default:
                    fail("no known test value for tcflag_t in multiarch: " + mi);
            }
        }
    }

    /**
     * Test of speed_t method, of class SizeOf.
     */
    @Test
    public void testSpeed_t() {
        System.out.println("speed_t");
        for (MultiarchInfo mi : NativeLibResolver.getMultiArchInfos()) {
            switch (mi) {
                case X86_64__LINUX__GNU:
                case ARM__LINUX__GNU_EABI:
                case ARM__LINUX__GNU_EABI_HF:
                case I386__LINUX__GNU:
                case X86_64__MAC_OS_X__BSD:
                case X86_64__FREE_BSD__BSD:
                    assertEquals(4, SizeOf.speed_t(), "speed_t");
                    break;
                case I386__WINDOWS__PE32:
                case X86_64__WINDOWS__PE32_PLUS:
                    assertEquals(0, SizeOf.off_t(), "speed_t");
                    break;
                default:
                    fail("no known test value for speed_t in multiarch: " + mi);
            }
        }
    }

    /**
     * Test of eventfd_t method, of class SizeOf.
     */
    @Test
    public void testEventfd_t() {
        System.out.println("eventfd_t");
        if (NativeLibResolver.getOS() == OS.LINUX) {
            assertEquals(8, SizeOf.eventfd_t(), "eventfd_t");
        } else {
            assertEquals(0, SizeOf.eventfd_t(), "eventfd_t");
        }
    }
}
