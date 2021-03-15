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

    public AsSignedIntTest() {
    }

    @Test
    public void testNative() {
        AsSignedInt instance = new AsSignedInt(BaseDataType.int16_t, null, 0, SET_MEM_TO_0);
        short expResult = 0x2010;
        instance.setFromSignedInt(expResult);
        assertEquals(expResult, instance.getAsSignedInt());
        assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedInt(Integer.MAX_VALUE));
        assertThrows(IllegalArgumentException.class, () -> new AsSignedInt(BaseDataType.uint8_t, null, 0, null));
    }

}
