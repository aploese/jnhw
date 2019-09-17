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

import de.ibapl.jnhw.libloader.NativeLibResolver;
import de.ibapl.jnhw.libloader.OS;
import static de.ibapl.jnhw.posix.Termios.CRTSCTS;
import static de.ibapl.jnhw.posix.Termios.CS8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class TermiosTests {

    @Test
    public void test_HAVE_TERMIOS_H() throws Exception {
        if (NativeLibResolver.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Termios.HAVE_TERMIOS_H(), "not expected to have termios.h");
        } else {
            Assertions.assertTrue(Termios.HAVE_TERMIOS_H(), "expected to have termios.h");
        }
    }
    
    @Test
    public void structTermiosToString() throws Exception {
        Termios.StructTermios termios = new Termios.StructTermios();
        Termios.StructTermios.clear(termios);
        
        Termios.cfsetspeed(termios, Termios.B9600());
        termios.c_cflag(Termios.CREAD() | Termios.CLOCAL() | CS8() | CRTSCTS());

        Assertions.assertFalse(termios.toString().isEmpty(), "Termios.StructTermios is empty");
    }

}
