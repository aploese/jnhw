/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.memory.Uint32_t;
import de.ibapl.jnhw.common.memory.Uint64_t;
import de.ibapl.jnhw.common.memory.Unsigned_Long;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class Unsigned_LongTest {

    @Test
    public void testNative() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            Unsigned_Long instance = Unsigned_Long.allocateNative(ms);
            final long input = 0x8070605040302010L;
            if (BaseDataType.C_unsigned_long.SIZE_OF == 8) {
                instance.unsigned_long(input);
                assertEquals(input, instance.unsigned_long());
            } else {
                //Big Endian so the layout of the bytes is different.... from Little Endian
                instance.unsigned_long(input >>> 32); // shift without sign
                assertEquals(input >>> 32, instance.unsigned_long());
            }
            instance.unsigned_long(33);
            assertEquals(33, instance.unsigned_long());
            if (BaseDataType.C_unsigned_long.SIZE_OF == 8) {
                instance.unsigned_long(input);
                assertEquals(input, instance.unsigned_long());
                instance.unsigned_long(-1);
                assertEquals(-1, instance.unsigned_long());
            } else {
                assertThrows(IllegalArgumentException.class, () -> instance.unsigned_long(input));
                assertThrows(IllegalArgumentException.class, () -> instance.unsigned_long(-1));
            }
        }
    }

    @Test
    public void testNativeToString() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            Unsigned_Long instance = new Unsigned_Long(MemorySegment.allocateNative(BaseDataType.C_unsigned_long.SIZE_OF, ms), 0);
            if (BaseDataType.C_unsigned_long.SIZE_OF == 8) {
                Uint64_t uint64_t = Uint64_t.map(instance, 0);
                uint64_t.uint64_t(0xfffffffffffffffeL);
                assertEquals(Long.toUnsignedString(0xfffffffffffffffeL), instance.nativeToString());
                assertEquals("0xfffffffffffffffe", instance.nativeToHexString());
            } else {
                Uint32_t uint32_t = Uint32_t.map(instance, 0);
                uint32_t.uint32_t(0xfffffffe);
                assertEquals(Long.toString(0xfffffffeL), instance.nativeToString());
                assertEquals("0xfffffffe", instance.nativeToHexString());
            }
        }
    }

    @Test
    public void testNative_1() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            AsUnsignedLong instance = new AsUnsignedLong(BaseDataType.uint32_t, MemorySegment.allocateNative(BaseDataType.uint32_t.SIZE_OF, ms), 0);
            instance.setFromUnsignedLong(33);
            assertEquals(33, instance.getAsUnsignedLong());
            assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedLong(-1));
            assertThrows(IllegalArgumentException.class, () -> new AsUnsignedLong(BaseDataType.int8_t, MemorySegment.allocateNative(BaseDataType.int8_t.SIZE_OF, ms), 0));
        }
    }

}
