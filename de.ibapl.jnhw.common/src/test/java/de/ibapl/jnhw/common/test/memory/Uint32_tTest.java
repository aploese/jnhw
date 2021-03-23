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

import de.ibapl.jnhw.common.memory.Uint32_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.common.memory.layout.Alignment;

/**
 *
 * @author aploese
 */
public class Uint32_tTest {

    public Uint32_tTest() {
    }

    /**
     * Test of sizeofUint32_t method, of class Uint32_t.
     */
    @Test
    public void testSizeofInt32_t() {
        assertEquals(4, Uint32_t.DATA_TYPE.SIZE_OF);
    }

    /**
     * Test of alignofUint32_t method, of class Uint32_t.
     */
    @Test
    public void testAlignofUint32_t() {
        assertEquals(Alignment.AT_4, Uint32_t.DATA_TYPE.ALIGN_OF);
    }

    /**
     * Test of rawUint32_t method, of class Uint32_t.
     */
    @Test
    public void testRawUint32_t() {
        Uint32_t instance = new Uint32_t(null, 0, SetMem.TO_0x00);
        int expResult = 0x40302010;
        instance.uint32_t(expResult);
        assertEquals(expResult, instance.uint32_t());
        instance.uint32_t(-1);
        assertEquals(0x00000000ffffffffL, instance.uint32_t_AsLong());
        assertThrows(IllegalArgumentException.class, () -> instance.uint32_t_FromLong(-1L));
    }

    @Test
    public void testNativeToString() {
        Uint32_t instance = new Uint32_t(null, 0, SetMem.TO_0x00);
        instance.uint32_t(-2);
        assertEquals(String.valueOf(0x00000000FFFFFFFFL & -2), instance.nativeToString());
        assertEquals(Integer.toUnsignedString(-2), instance.nativeToString());
        assertEquals("0xfffffffe", instance.nativeToHexString());
    }
}
