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
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SET_MEM_TO_0;
import de.ibapl.jnhw.common.memory.AsUnsignedInt;
import de.ibapl.jnhw.common.memory.Uint32_t;
import de.ibapl.jnhw.common.memory.Uint64_t;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class AsUnsignedIntTest {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();

    public AsUnsignedIntTest() {
    }

    @Test
    public void testNative() {
        Uint32_t uint32_t = new Uint32_t(null, 0, null);
        AsUnsignedInt instance = new AsUnsignedInt(BaseDataType.uint16_t, uint32_t, 0, SET_MEM_TO_0);
        int input = 0x040302010;
        uint32_t.uint32_t(input);
        if (MULTIARCH_TUPEL_BUILDER.isBigEndian()) {
            assertEquals((input >>> 16), instance.getAsUnsignedInt());
        } else {
            assertEquals(input & 0x0000ffff, instance.getAsUnsignedInt());
        }
        instance.setFromUnsignedInt(33);
        assertEquals(33, instance.getAsUnsignedInt());
        assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(input));
        assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(-1));
        assertThrows(IllegalArgumentException.class, () -> new AsUnsignedInt(BaseDataType.int8_t, null, 0, null));
    }

    @Test
    public void testNativeToString() {
        Uint64_t uint64_t = new Uint64_t(null, 0, null);
        AsUnsignedInt instance = new AsUnsignedInt(BaseDataType.uint16_t, uint64_t, 0, SET_MEM_TO_0);
        if (MULTIARCH_TUPEL_BUILDER.isBigEndian()) {
            uint64_t.uint64_t(0xfffeffffffffffffL);
        } else {
            uint64_t.uint64_t(0xfffffffffffffffeL);
        }
        assertEquals("0xfffe", instance.nativeToHexString());
        assertEquals(Integer.toString(0xfffe), instance.nativeToString());
    }
}
