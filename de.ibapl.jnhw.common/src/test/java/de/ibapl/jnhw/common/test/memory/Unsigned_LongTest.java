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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.AsUnsignedLong;
import de.ibapl.jnhw.common.memory.Uint64_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SET_MEM_TO_0;
import de.ibapl.jnhw.common.memory.Unsigned_Long;

/**
 *
 * @author aploese
 */
public class Unsigned_LongTest {

    public Unsigned_LongTest() {
    }

    @Test
    public void testNative() {
        Uint64_t uint64_t = new Uint64_t(null, 0, null);
        Unsigned_Long instance = new Unsigned_Long(uint64_t, 0, SET_MEM_TO_0);
        final long input = 0x08070605040302010L;
        uint64_t.uint64_t(input);
        if (BaseDataType.SIZE_OF_LONG == 8) {
            assertEquals(input, instance.unsigned_long());
        } else {
            assertEquals(input & 0x00000000ffffffffL, instance.unsigned_long());
        }
        instance.unsigned_long(33);
        assertEquals(33, instance.unsigned_long());
        if (BaseDataType.SIZE_OF_LONG == 8) {
            instance.unsigned_long(input);
            assertEquals(input, instance.unsigned_long());
            instance.unsigned_long(-1);
            assertEquals(-1, instance.unsigned_long());
        } else {
            assertThrows(IllegalArgumentException.class, () -> instance.unsigned_long(input));
            assertThrows(IllegalArgumentException.class, () -> instance.unsigned_long(-1));
        }
    }

    @Test
    public void testNativeToString() {
        Uint64_t uint64_t = new Uint64_t(null, 0, null);
        Unsigned_Long instance = new Unsigned_Long(uint64_t, 0, SET_MEM_TO_0);
        uint64_t.uint64_t(0xfffffffffffffffeL);
        if (BaseDataType.SIZE_OF_LONG == 8) {
            assertEquals(Long.toUnsignedString(0xfffffffffffffffeL), instance.nativeToString());
            assertEquals("0xfffffffffffffffe", instance.nativeToHexString());
        } else {
            assertEquals(Long.toString(0xfffffffeL), instance.nativeToString());
            assertEquals("0xfffffffe", instance.nativeToHexString());
        }
    }
}