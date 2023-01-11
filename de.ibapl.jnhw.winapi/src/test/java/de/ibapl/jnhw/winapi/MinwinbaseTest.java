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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class MinwinbaseTest {

    @Test
    public void testOVERLAPPED() {
        System.out.println("test OVERLAPPED");
        switch (MultiarchTupelBuilder.getMemoryModel()) {
            case ILP32:
                assertEquals(32, Minwinbase.LPOVERLAPPED.Layout.sizeof);
                assertEquals(Alignment.AT_4, Minwinbase.LPOVERLAPPED.Layout.alignment);
                break;
            case LLP64:
                assertEquals(32, Minwinbase.LPOVERLAPPED.Layout.sizeof);
                assertEquals(Alignment.AT_8, Minwinbase.LPOVERLAPPED.Layout.alignment);
                break;
            default:
                throw new RuntimeException("Can't handle SizeOfPointer " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    @Test
    public void testSECURITY_ATTRIBUTES() {
        System.out.println("test SECURITY_ATTRIBUTES");
        switch (MultiarchTupelBuilder.getMemoryModel()) {
            case ILP32:
                assertEquals(24, Minwinbase.SECURITY_ATTRIBUTES.Layout.sizeof);
                assertEquals(Alignment.AT_4, Minwinbase.SECURITY_ATTRIBUTES.Layout.alignment);
                break;
            case LLP64:
                assertEquals(24, Minwinbase.SECURITY_ATTRIBUTES.Layout.sizeof);
                assertEquals(Alignment.AT_8, Minwinbase.SECURITY_ATTRIBUTES.Layout.alignment);
                break;
            default:
                throw new RuntimeException("Can't handle SizeOfPointer " + MultiarchTupelBuilder.getMultiarch());
        }
    }

}
