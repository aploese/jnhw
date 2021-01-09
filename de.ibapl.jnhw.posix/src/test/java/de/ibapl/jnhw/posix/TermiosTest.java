/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.Defined;
import de.ibapl.jnhw.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import static de.ibapl.jnhw.posix.Termios.CLOCAL;
import static de.ibapl.jnhw.posix.Termios.CREAD;
import static de.ibapl.jnhw.posix.Termios.CRTSCTS;
import static de.ibapl.jnhw.posix.Termios.CS8;
import de.ibapl.jnhw.util.posix.Defines;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class TermiosTest {

    private final static MultiarchTupelBuilder multiarchTupelBuilder = new MultiarchTupelBuilder();

    @Test
    public void CMSPAR() {
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                if (Defined.defined(Defines::__mips__)) {
                    assertFalse(Defined.defined(Termios::CMSPAR), "CMSPAR");
                    break;
                } else {
                    assertTrue(Defined.defined(Termios::CMSPAR), "CMSPAR");
                }
                break;
            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
                assertFalse(Defined.defined(Termios::CMSPAR), "CMSPAR");
                break;
            default:
                fail("CMSPAR unknown on: " + NativeLibResolver.getOS());
        }
    }

    @Test
    public void PAREXT() {
        switch (NativeLibResolver.getOS()) {
            case LINUX:
            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
                assertFalse(Defined.defined(Termios::PAREXT), "PAREXT");
                break;
            default:
                fail("PAREXT unknown on: " + NativeLibResolver.getOS());
        }
    }

    @Test
    public void PARMRK() {
        switch (NativeLibResolver.getOS()) {
            case LINUX:
            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
                assertTrue(Defined.defined(Termios::PARMRK), "PARMRK");
                break;
            default:
                fail("PARMRK unknown on: " + NativeLibResolver.getOS());
        }
    }

    @Test
    public void structTermios_c_ispeed() throws Exception {
        Termios.StructTermios structTermios = new Termios.StructTermios();
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                try {
                Termios._HAVE_STRUCT_TERMIOS_C_ISPEED();
                //Do the test
            } catch (NotDefinedException nee) {
                Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                    structTermios.c_ispeed();
                });
                return;
            }
            break;
            case FREE_BSD:
                //Do the test
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                    structTermios.c_ispeed();
                });
                return;
            case MAC_OS_X:
                //Do the test
                break;
            default:
                throw new RuntimeException("Add test wether struct termios has c_ispeed or not!");
        }
        try {
            structTermios.c_ispeed(9600);
            assertEquals(9600, structTermios.c_ispeed());
        } catch (NoSuchNativeTypeMemberException nstme) {
            fail("Expected to have termios.c_ispeed but got this: " + nstme.getMessage());
        }
    }

    @Test
    public void structTermios_c_ospeed() throws Exception {
        Termios.StructTermios structTermios = new Termios.StructTermios();
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                try {
                Termios._HAVE_STRUCT_TERMIOS_C_OSPEED();
                //Do the test
            } catch (NotDefinedException nee) {
                Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                    structTermios.c_ospeed();
                });
                return;
            }
            break;
            case FREE_BSD:
                //Do the test
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                    structTermios.c_ospeed();
                });
                return;
            case MAC_OS_X:
                //Do the test
                break;
            default:
                throw new RuntimeException("Add test wether struct termios has c_ospeed or not!");
        }
        try {
            structTermios.c_ospeed(9600);
            assertEquals(9600, structTermios.c_ospeed());
        } catch (NoSuchNativeTypeMemberException nstme) {
            fail("Expected to have termios.c_ospeed but got this: " + nstme.getMessage());
        }
    }

    @Test
    public void structTermiosToString() throws Exception {
        Termios.StructTermios termios = new Termios.StructTermios();
        Termios.StructTermios.clear(termios);

        Termios.cfsetspeed(termios, Termios.B9600());
        termios.c_cflag(CREAD() | CLOCAL() | CS8() | CRTSCTS());

        assertFalse(termios.toString().isEmpty(), "Termios.StructTermios is empty");
    }

    @Test
    public void testSizeOfTermios() throws Exception {
        switch (multiarchTupelBuilder.guessMultiarch().iterator().next()) {
            case AARCH64__LINUX__GNU:
            case ARM__LINUX__GNU_EABI:
            case ARM__LINUX__GNU_EABI_HF:
            case I386__LINUX__GNU:
            case POWER_PC_64_LE__LINUX__GNU:
            case POWER_PC_64__LINUX__GNU:
            case S390_X__LINUX__GNU:
            case X86_64__LINUX__GNU:
                Assertions.assertEquals(60, Termios.StructTermios.sizeofTermios());
                break;
            case MIPS_64_EL__LINUX__GNU_ABI_64:
            case MIPS_64__LINUX__GNU_ABI_64:
                Assertions.assertEquals(52, Termios.StructTermios.sizeofTermios());
                break;
            case X86_64__FREE_BSD__BSD:
                Assertions.assertEquals(44, Termios.StructTermios.sizeofTermios());
                break;
            default:
                Assertions.assertEquals(-1, Termios.StructTermios.sizeofTermios());
        }
    }

    @Test
    public void testAlignOfTermios() throws Exception {
        Assertions.assertEquals(4, Termios.StructTermios.alignofTermios());
    }

}
