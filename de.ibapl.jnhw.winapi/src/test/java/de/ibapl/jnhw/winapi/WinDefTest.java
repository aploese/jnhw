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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class WinDefTest {

        private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();

    @Test
    public void testLPBYTE() {
        System.out.println("test LPBYTE");
        switch (MULTIARCH_TUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                assertEquals(4, WinDef.LPBYTE.sizeof());
                assertEquals(4, WinDef.LPBYTE.alignof());
                break;
            case _64_BIT:
                assertEquals(8, WinDef.LPBYTE.sizeof());
                assertEquals(8, WinDef.LPBYTE.alignof());
                break;
            default:
                throw new RuntimeException("Can't handle Wordsize " + MULTIARCH_TUPEL_BUILDER.getWordSize());
        }
    }

}
