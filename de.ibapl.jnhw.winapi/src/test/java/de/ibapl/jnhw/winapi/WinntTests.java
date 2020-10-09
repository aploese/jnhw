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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.OpaqueMemory;
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
        OpaqueMemory.copy(data, 0, lpByte, 0, data.length);
        lpByte.bufferEnd = data.length;
        Assertions.assertEquals("HELLO WORLD!", Winnt.LPWSTR.stringValueOfNullTerminated(lpByte));
    }
    
}
