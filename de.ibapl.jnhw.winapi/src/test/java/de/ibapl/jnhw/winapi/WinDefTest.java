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

import de.ibapl.jnhw.common.memory.OpaqueMemory;
import java.lang.foreign.MemorySession;
import java.nio.charset.Charset;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class WinDefTest {

    private MemorySession ms;

    @BeforeEach
    public void setUp() throws Exception {
        ms = MemorySession.openConfined();
    }

    @AfterEach
    public void tearDown() throws Exception {
        ms.close();
    }

    @Test
    public void test_LPBYTE_stringValueOfNullTerminated() throws Exception {
        byte[] data = "HELLO WORLD!\0".getBytes(Charset.forName("UTF-16LE"));
        WinDef.LPBYTE lpByte = WinDef.LPBYTE.allocateNative(64, ms);
        OpaqueMemory.copy(data, 0, lpByte, 0, data.length);
        Assertions.assertEquals("HELLO WORLD!", WinDef.LPBYTE.getUnicodeString(lpByte, true, data.length));
    }

}
