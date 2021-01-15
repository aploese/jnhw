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
package de.ibapl.jnhw.common.test.memory;

import de.ibapl.jnhw.common.memory.Uint8_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class Uint8_tTest {
    
    public Uint8_tTest() {
    }
    
    /**
     * Test of sizeofUint8_t method, of class Uint8_t.
     */
    @Test
    public void testSizeofUint8_t() {
        assertEquals(1, Uint8_t.sizeof());
    }

    /**
     * Test of alignofUint8_t method, of class Uint8_t.
     */
    @Test
    public void testAlignofUint8_t() {
        Uint8_t.alignof();
        assertEquals(1, Uint8_t.alignof());
    }

    /**
     * Test of rawUint8_t method, of class Uint8_t.
     */
    @Test
    public void testRawUint8_t() {
        Uint8_t instance = new Uint8_t(true);
        byte expResult = 0x10;
        instance.rawUint8_t(expResult);
        assertEquals(expResult, instance.rawUint8_t());
    }
   
    @Test
    public void testNativeToString() {
        Uint8_t instance = new Uint8_t(true);
        instance.rawUint8_t((byte)-2);
        assertEquals(String.valueOf(0x00FF & -2), instance.nativeToString());
        assertEquals(String.valueOf(Byte.toUnsignedInt((byte)-2)), instance.nativeToString());
        assertEquals("fe", instance.nativeToHexString());
    }
}
