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

import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import java.nio.charset.Charset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class WinntTests {

    @Test
    public void testMAXDWORD() throws Exception {
        Winnt.MAXDWORD();
    }

    @Test
    public void test_INVALID_HANDLE_VALUE() throws Exception {
        Winnt.HANDLE ivh = Handleapi.INVALID_HANDLE_VALUE();
        Assertions.assertTrue(ivh.is_INVALID_HANDLE_VALUE());
    }

    @Test
    public void test_LPWSTR_stringValueOfNullTerminated() throws Exception {
        byte[] data = "HELLO WORLD!\0".getBytes(Charset.forName("UTF-16LE"));
        WinDef.LPBYTE lpByte = new WinDef.LPBYTE(64, true);
        OpaqueMemory32.copy(data, 0, lpByte, 0, data.length);
        lpByte.bufferEnd = data.length;
        Assertions.assertEquals("HELLO WORLD!", Winnt.LPWSTR.stringValueOfNullTerminated(lpByte));
    }
    
    @Test
    public void testArrayOfHandle() throws Exception {
        Winnt.ArrayOfHandle aoh = new Winnt.ArrayOfHandle(3, true);
        Winnt.HANDLE h1 = new Winnt.HANDLE(42);
        aoh.set(1, h1);
        Winnt.HANDLE h2 = Winnt.HANDLE.INVALID_HANDLE_VALUE;
        aoh.set(2, h2);
        Assertions.assertEquals(Winnt.HANDLE.NULL, aoh.get(0));
        Assertions.assertEquals(h1, aoh.get(1));
        Assertions.assertEquals(h2, aoh.get(2));
    }
    
}
