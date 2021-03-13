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
import de.ibapl.jnhw.common.memory.AsSignedInt;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Int64_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SET_MEM_TO_0;
import de.ibapl.jnhw.common.memory.JnhwMemoryAccessor;
import de.ibapl.jnhw.common.memory.UnsafeMemoryAccessor;
import de.ibapl.jnhw.common.memory.UnsafeMemoryAccessor32;
import de.ibapl.jnhw.common.memory.UnsafeMemoryAccessor64;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.WordSize;

/**
 *
 * @author aploese
 */
public class AsSignedIntTest {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();
    private UnsafeMemoryAccessor unsafeMemAccess = MULTIARCH_TUPEL_BUILDER.getWordSize() == WordSize._64_BIT ? new UnsafeMemoryAccessor64() : new UnsafeMemoryAccessor32();
    private JnhwMemoryAccessor jnhwMemAccess = new JnhwMemoryAccessor();

    public AsSignedIntTest() {
    }

    @Test
    public void testNative() {
        Int32_t int32_t = new Int32_t(null, 0, AbstractNativeMemory.MEM_UNINITIALIZED);
        AsSignedInt instance = new AsSignedInt(BaseDataType.int16_t, int32_t, 0, SET_MEM_TO_0);
        int input = 0x40302010;
        int32_t.int32_t(input);
        assertEquals(unsafeMemAccess.int16_t(instance, 0), jnhwMemAccess.int16_t(instance, 0));
        if (MULTIARCH_TUPEL_BUILDER.isBigEndian()) {
            assertEquals((input >>> 16), instance.getAsSignedInt());
        } else {
            assertEquals(input & 0x0000ffff, instance.getAsSignedInt());
        }
        instance.setFromSignedInt(-33);
        assertEquals(-33, instance.getAsSignedInt());
        assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedInt(input));
        assertThrows(IllegalArgumentException.class, () -> new AsSignedInt(BaseDataType.uint8_t, null, 0, null));
    }

    @Test
    public void testNativeToString() {
        Int64_t int64_t = new Int64_t(null, 0, AbstractNativeMemory.MEM_UNINITIALIZED);
        AsSignedInt instance = new AsSignedInt(BaseDataType.int16_t, int64_t, 0, SET_MEM_TO_0);
        if (MULTIARCH_TUPEL_BUILDER.isBigEndian()) {
            int64_t.int64_t(0x0808060504030201L); // Just to see where we land.... on s390...
//            int64_t.int64_t(0xfffffffeffffffffL);
        } else {
            int64_t.int64_t(0xfffffffffffffffeL);
        }
        assertEquals("0xfffe", instance.nativeToHexString());
        assertEquals(Integer.toString(0xfffffffe), instance.nativeToString());
    }
}
