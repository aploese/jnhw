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
import de.ibapl.jnhw.common.memory.Int64_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

/**
 *
 * @author aploese
 */
public class Int64_tTest {

    /**
     * Test of sizeofInt64_t method, of class Int64_t.
     */
    @Test
    public void testSizeofInt64_t() {
        assertEquals(8, Int64_t.DATA_TYPE.SIZE_OF);
    }

    /**
     * Test of alignofInt64_t method, of class Int64_t.
     */
    @Test
    public void testAlignofInt64_t() {
        assertEquals(Alignment.AT_8, Int64_t.DATA_TYPE.ALIGN_OF);
    }

    /**
     * Test of rawInt64_t method, of class Int64_t.
     */
    @Test
    public void testRawInt64_t() {
        try ( ResourceScope rs = ResourceScope.newConfinedScope()) {
            Int64_t instance = Int64_t.allocateNative(rs);
            long expResult = 0x08070605040302010L;
            instance.int64_t(expResult);
            assertEquals(expResult, instance.int64_t());
        }
    }

    @Test
    public void testNativeToString() {
        try ( ResourceScope rs = ResourceScope.newConfinedScope()) {
            Int64_t instance = new Int64_t(MemorySegment.allocateNative(BaseDataType.int64_t.SIZE_OF, rs), 0);
            instance.int64_t(-2);
            assertEquals("-2", instance.nativeToString());
            assertEquals("0xfffffffffffffffe", instance.nativeToHexString());
        }
    }
}
