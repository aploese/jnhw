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

import de.ibapl.jnhw.common.memory.Int64_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class Int64_tTest {

    public Int64_tTest() {
    }

    /**
     * Test of sizeofInt64_t method, of class Int64_t.
     */
    @Test
    public void testSizeofInt64_t() {
        System.out.println("sizeofInt64_t");
        assertEquals(8, Int64_t.sizeof());
    }

    /**
     * Test of alignofInt64_t method, of class Int64_t.
     */
    @Test
    public void testAlignofInt64_t() {
        System.out.println("alignofInt64_t");
        assertEquals(8, Int64_t.alignof());
    }

    /**
     * Test of rawInt64_t method, of class Int64_t.
     */
    @Test
    public void testRawInt64_t() {
        System.out.println("rawInt64_t");
        Int64_t instance = new Int64_t(true);
        long expResult = 0x08070605040302010L;
        instance.rawInt64_t(expResult);
        assertEquals(expResult, instance.rawInt64_t());
    }

    @Test
    public void testNativeToString() {
        System.out.println("testNativeToString");
        Int64_t instance = new Int64_t(true);
        instance.rawInt64_t(-2);
        assertEquals("-2", instance.nativeToString());
        assertEquals("fffffffffffffffe", instance.nativeToHexString());
    }
}
