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
import de.ibapl.jnhw.common.memory.Uint8_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

/**
 *
 * @author aploese
 */
public class Uint8_tTest {

    public Uint8_tTest() {
    }

    /**
     * Test of sizeofInt8_t method, of class Uint8_t.
     */
    @Test
    public void testSizeofUint8_t() {
        assertEquals(1, Uint8_t.DATA_TYPE.SIZE_OF);
    }

    /**
     * Test of alignofInt8_t method, of class Uint8_t.
     */
    @Test
    public void testAlignofUint8_t() {
        assertEquals(Alignment.AT_1, Uint8_t.DATA_TYPE.ALIGN_OF);
    }

    /**
     * Test of rawUint8_t method, of class Uint8_t.
     */
    @Test
    public void testRawUint8_t() {
        try ( ResourceScope rs = ResourceScope.newConfinedScope()) {
            Uint8_t instance = Uint8_t.allocateNative(rs);
            byte expResult = 0x10;
            instance.uint8_t(expResult);
            assertEquals(expResult, instance.uint8_t());
            instance.uint8_t((byte) -1);
            assertEquals(0x00ff, instance.uint8_t_AsShort());
            assertThrows(IllegalArgumentException.class, () -> instance.uint8_t_FromShort((short) -1));
        }
    }

    @Test
    public void testNativeToString() {
        try ( ResourceScope rs = ResourceScope.newConfinedScope()) {
            Uint8_t instance = new Uint8_t(MemorySegment.allocateNative(BaseDataType.uint8_t.SIZE_OF, rs), 0);
            instance.uint8_t((byte) -2);
            assertEquals(String.valueOf(0x00FF & -2), instance.nativeToString());
            assertEquals(String.valueOf(Byte.toUnsignedInt((byte) -2)), instance.nativeToString());
            assertEquals("0xfe", instance.nativeToHexString());
        }
    }
}
