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

import de.ibapl.jnhw.common.memory.Int16_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class Int16_tTest {
    
    public Int16_tTest() {
    }
    
    /**
     * Test of sizeofInt16_t method, of class Int16_t.
     */
    @Test
    public void testSizeofInt16_t() {
        assertEquals(2, Int16_t.sizeof());
    }

    /**
     * Test of alignofInt16_t method, of class Int16_t.
     */
    @Test
    public void testAlignofInt16_t() {
        assertEquals(2, Int16_t.alignof());
    }

    /**
     * Test of rawInt16_t method, of class Int16_t.
     */
    @Test
    public void testRawInt16_t() {
        Int16_t instance = new Int16_t(true);
        short expResult = 0x2010;
        instance.rawInt16_t(expResult);
        assertEquals(expResult, instance.rawInt16_t());
    }

    @Test
    public void testNativeToString() {
        Int16_t instance = new Int16_t(true);
        instance.rawInt16_t((short)-2);
        assertEquals("-2", instance.nativeToString());
        assertEquals("fffe", instance.nativeToHexString());
    }
}
