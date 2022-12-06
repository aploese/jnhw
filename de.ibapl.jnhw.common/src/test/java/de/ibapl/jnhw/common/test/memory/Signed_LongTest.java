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
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Int64_t;
import de.ibapl.jnhw.common.memory.Signed_Long;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class Signed_LongTest {

    @Test
    public void testNative() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            Signed_Long instance = Signed_Long.allocateNative(ms);
            long input64 = 0x8070605040302010L;
            if (BaseDataType.C_long.SIZE_OF == 8) {
                instance.signed_long(input64);
                assertEquals(input64, instance.signed_long());
            } else {
                //Big Endian so the layout of the bytes is different.... from Little Endian
                instance.signed_long(input64 >> 32); // shift with sign
                assertEquals(input64 >> 32, instance.signed_long());
            }
            instance.signed_long(-33);
            assertEquals(-33, instance.signed_long());
            if (BaseDataType.C_long.SIZE_OF == 8) {
                instance.signed_long(input64);
                assertEquals(input64, instance.signed_long());
            } else {
                assertThrows(IllegalArgumentException.class, () -> instance.signed_long(input64));
            }
        }
    }

    @Test
    public void testNativeToString() {
        try ( MemorySession ms = MemorySession.openConfined()) {
            Signed_Long instance = new Signed_Long(MemorySegment.allocateNative(Signed_Long.DATA_TYPE.SIZE_OF, ms), 0);
            if (BaseDataType.C_long.SIZE_OF == 8) {
                Int64_t int64_t = Int64_t.map(instance, 0);
                int64_t.int64_t(0xfffffffffffffffeL);
                assertEquals(Integer.toString(0xfffffffe), instance.nativeToString());
                assertEquals("0xfffffffffffffffe", instance.nativeToHexString());
            } else {
                Int32_t int32_t = Int32_t.map(instance, 0);
                int32_t.int32_t(0xfffffffe);
                assertEquals(Integer.toString(0xfffffffe), instance.nativeToString());
                assertEquals("0xfffffffe", instance.nativeToHexString());
            }
        }
    }
}
