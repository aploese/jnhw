/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.test.memory;

import de.ibapl.jnhw.common.memory.Uint16_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class Uint16_tTest {
    
    public Uint16_tTest() {
    }
    
    /**
     * Test of sizeofUInt16_t method, of class Uint16_t.
     */
    @Test
    public void testSizeofUInt16_t() {
        assertEquals(2, Uint16_t.sizeof());
    }

    /**
     * Test of alignofUInt16_t method, of class Uint16_t.
     */
    @Test
    public void testAlignofUInt16_t() {
        assertEquals(2, Uint16_t.alignof());
    }

    /**
     * Test of rawUint16_t method, of class Uint16_t.
     */
    @Test
    public void testRawUint16_t() {
        Uint16_t instance = new Uint16_t(true);
        short expResult = 0x2010;
        instance.rawUint16_t(expResult);
        assertEquals(expResult, instance.rawUint16_t());
    }

    @Test
    public void testNativeToString() {
        Uint16_t instance = new Uint16_t(true);
        instance.rawUint16_t((short)-2);
        assertEquals(String.valueOf(0x0000FFFF & -2), instance.nativeToString());
        assertEquals(String.valueOf(Short.toUnsignedInt((short)-2)), instance.nativeToString());
        assertEquals("fffe", instance.nativeToHexString());
    }
}
