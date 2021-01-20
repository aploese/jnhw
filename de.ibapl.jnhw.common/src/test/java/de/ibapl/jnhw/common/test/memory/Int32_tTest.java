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

import de.ibapl.jnhw.common.memory.Int32_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class Int32_tTest {
    
    public Int32_tTest() {
    }
    
    /**
     * Test of sizeofInt32_t method, of class Int32_t.
     */
    @Test
    public void testSizeofInt32_t() {
        assertEquals(4, Int32_t.sizeof());
    }

    /**
     * Test of alignofInt32_t method, of class Int32_t.
     */
    @Test
    public void testAlignofInt32_t() {
        assertEquals(4, Int32_t.alignof());
    }

    /**
     * Test of rawInt32_t method, of class Int32_t.
     */
    @Test
    public void testRawInt32_t() {
        Int32_t instance = new Int32_t(true);
        int expResult = 0x40302010;
        instance.rawInt32_t(expResult);
        assertEquals(expResult, instance.rawInt32_t());
    }

    @Test
    public void testNativeToString() {
        Int32_t instance = new Int32_t(true);
        instance.rawInt32_t(-2);
        assertEquals("-2", instance.nativeToString());
        assertEquals("fffffffe", instance.nativeToHexString());
    }
}