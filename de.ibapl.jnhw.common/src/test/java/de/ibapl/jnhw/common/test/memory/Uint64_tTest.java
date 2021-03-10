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

import de.ibapl.jnhw.common.memory.Uint64_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SET_MEM_TO_0;
import de.ibapl.jnhw.common.memory.layout.Alignment;

/**
 *
 * @author aploese
 */
public class Uint64_tTest {

    public Uint64_tTest() {
    }

    /**
     * Test of sizeofUint64_t method, of class Uint64_t.
     */
    @Test
    public void testSizeofUint64_t() {
        assertEquals(8, Uint64_t.DATA_TYPE.SIZE_OF);
    }

    /**
     * Test of alignofUint64_t method, of class Uint64_t.
     */
    @Test
    public void testAlignofUint64_t() {
        assertEquals(Alignment.AT_8, Uint64_t.DATA_TYPE.ALIGN_OF);
    }

    /**
     * Test of rawUint64_t method, of class Uint64_t.
     */
    @Test
    public void testRawUint64_t() {
        Uint64_t instance = new Uint64_t(null, 0, SET_MEM_TO_0);
        long expResult = 0x08070605040302010L;
        instance.uint64_t(expResult);
        assertEquals(expResult, instance.uint64_t());
    }

    @Test
    public void testNativeToString() {
        Uint64_t instance = new Uint64_t(null, 0, SET_MEM_TO_0);
        instance.uint64_t(-2);
        assertEquals(Long.toUnsignedString(-2), instance.nativeToString());
        assertEquals("0xfffffffffffffffe", instance.nativeToHexString());
    }
}
