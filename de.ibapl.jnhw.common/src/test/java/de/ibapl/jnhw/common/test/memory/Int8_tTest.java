/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class Int8_tTest {

    /**
     * Test of sizeofInt8_t method, of class Int8_t.
     */
    @Test
    public void testSizeofInt8_t() {
        assertEquals(1, Int8_t.DATA_TYPE.SIZE_OF);
    }

    /**
     * Test of alignofInt8_t method, of class Int8_t.
     */
    @Test
    public void testAlignofInt8_t() {
        assertEquals(Alignment.AT_1, Int8_t.DATA_TYPE.ALIGN_OF);
    }

    /**
     * Test of rawInt8_t method, of class Int8_t.
     */
    @Test
    public void testRawInt8_t() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            Int8_t instance = Int8_t.allocateNative(ms);
            byte expResult = 0x10;
            instance.int8_t(expResult);
            assertEquals(expResult, instance.int8_t());
        }
    }

    @Test
    public void testNativeToString() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            Int8_t instance = new Int8_t(MemorySegment.allocateNative(BaseDataType.int8_t.SIZE_OF, ms), 0);
            instance.int8_t((byte) -2);
            assertEquals("-2", instance.nativeToString());
            assertEquals("0xfe", instance.nativeToHexString());
        }
    }
}
