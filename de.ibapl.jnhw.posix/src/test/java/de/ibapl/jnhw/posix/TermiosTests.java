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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.Defined;
import de.ibapl.jnhw.NoSuchTypeMemberException;
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import static de.ibapl.jnhw.posix.Termios.CLOCAL;
import static de.ibapl.jnhw.posix.Termios.CREAD;
import static de.ibapl.jnhw.posix.Termios.CRTSCTS;
import static de.ibapl.jnhw.posix.Termios.CS8;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class TermiosTests {

    @Test
    public void CMSPAR() {
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                switch (NativeLibResolver.getLoadedArch()) {
                    case MIPS:
                    case MIPS_EL:
                    case MIPS_64:
                    case MIPS_64_EL:
                        assertFalse(Defined.defined(Termios::CMSPAR), "CMSPAR");
                        break;
                    default:
                        assertTrue(Defined.defined(Termios::CMSPAR), "CMSPAR");
                }
                break;
            case FREE_BSD:
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
                //Skip the test
                return;
            }
            break;
            case MAC_OS_X:
                //Do the test
                break;
            case FREE_BSD:
                //Do the test
                break;
            default:
                throw new RuntimeException("Add test wether struct termios has c_ispeed or not!");
        }
        try {
            structTermios.c_ispeed(9600);
            assertEquals(9600, structTermios.c_ispeed());
        } catch (NoSuchTypeMemberException nstme) {
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
                //Skip the test
                return;
            }
            break;
            case MAC_OS_X:
                //Do the test
                break;
            case FREE_BSD:
                //Do the test
                break;
            default:
                throw new RuntimeException("Add test wether struct termios has c_ospeed or not!");
        }
        try {
            structTermios.c_ospeed(9600);
            assertEquals(9600, structTermios.c_ospeed());
        } catch (NoSuchTypeMemberException nstme) {
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

}
