/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2025, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.charset.Charset;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class WinntTest {

    private Arena arena;

    @BeforeEach
    public void setUp() throws Exception {
        arena = Arena.ofConfined();
    }

    @AfterEach
    public void tearDown() throws Exception {
        arena.close();
    }

    @Test
    public void test_INVALID_HANDLE_VALUE() throws Exception {
        Winnt.HANDLE ivh = Handleapi.INVALID_HANDLE_VALUE;
        Assertions.assertTrue(ivh.is_INVALID_HANDLE_VALUE());
    }

    @Test
    public void test_LPWSTR_stringValueOfNullTerminated() throws Exception {
        final String str = "HELLO WORLD!\0";
        byte[] data = str.getBytes(Charset.forName("UTF-16LE"));
        Winnt.LPWSTR lpWStr = Winnt.LPWSTR.allocateNative(64, arena);
        OpaqueMemory.copy(data, 0, lpWStr, 0, data.length);
        Assertions.assertEquals("HELLO WORLD!", lpWStr.getUnicodeString(str.length() - 1));
        Assertions.assertEquals("HELLO WORLD!", lpWStr.getUnicodeString(data.length / WinApiDataType.WCHAR.byteSize - 1));
    }

    @Test
    public void testArrayOfHandle() throws Exception {
        Winnt.ArrayOfHandle aoh = Winnt.ArrayOfHandle.allocateNative(3, arena);
        Winnt.HANDLE h1 = Winnt.HANDLE.of(MemorySegment.ofAddress(42));
        aoh.set(1, h1);
        Winnt.HANDLE h2 = Winnt.HANDLE.INVALID_HANDLE_VALUE;
        aoh.set(2, h2);
        Assertions.assertEquals(Winnt.HANDLE.NULL, aoh.get(0));
        Assertions.assertEquals(h1, aoh.get(1));
        Assertions.assertEquals(h2, aoh.get(2));
    }

    @Test
    public void testMAXDWORD() throws Exception {
        assertEquals(0x00000000FFFFFFFFL, Winnt.MAXDWORD);
    }

}
