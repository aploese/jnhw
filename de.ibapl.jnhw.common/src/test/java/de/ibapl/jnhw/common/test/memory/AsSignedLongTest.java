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
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.AsSignedLong;
import de.ibapl.jnhw.common.memory.Int64_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SET_MEM_TO_0;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;

/**
 *
 * @author aploese
 */
public class AsSignedLongTest {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();

    public AsSignedLongTest() {
    }

    @Test
    public void testNative() {
        Int64_t int64_t = new Int64_t(null, 0, AbstractNativeMemory.MEM_UNINITIALIZED);
        AsSignedLong instance = new AsSignedLong(BaseDataType.int32_t, int64_t, 0, SET_MEM_TO_0);
        long input = 0x08070605040302010L;
        int64_t.int64_t(input);
        if (MULTIARCH_TUPEL_BUILDER.isBigEndian()) {
            assertEquals((input >>> 32), instance.getAsSignedLong());
        } else {
            assertEquals(input & 0x00000000ffffffffL, instance.getAsSignedLong());
        }

        instance.setFromSignedLong(-33);
        assertEquals(-33, instance.getAsSignedLong());
        assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedLong(input));
        assertThrows(IllegalArgumentException.class, () -> new AsSignedLong(BaseDataType.uint8_t, null, 0, null));
    }

    @Test
    public void testNativeToString() {
        Int64_t int64_t = new Int64_t(null, 0, AbstractNativeMemory.MEM_UNINITIALIZED);
        AsSignedLong instance = new AsSignedLong(BaseDataType.int32_t, int64_t, 0, SET_MEM_TO_0);
        if (MULTIARCH_TUPEL_BUILDER.isBigEndian()) {
            int64_t.int64_t(0xfffffffeffffffffL);
        } else {
            int64_t.int64_t(0xfffffffffffffffeL);
        }
        assertEquals("0xfffffffe", instance.nativeToHexString());
        assertEquals(Integer.toString(0xfffffffe), instance.nativeToString());
    }
}
