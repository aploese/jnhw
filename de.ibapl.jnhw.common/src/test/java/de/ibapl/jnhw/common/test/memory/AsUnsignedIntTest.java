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
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.common.memory.AsUnsignedInt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class AsUnsignedIntTest {

    public AsUnsignedIntTest() {
    }

    @Test
    public void testNative() {
        AsUnsignedInt instance = new AsUnsignedInt(BaseDataType.uint16_t, null, 0, SetMem.TO_0x00);
        instance.setFromUnsignedInt(33);
        assertEquals(33, instance.getAsUnsignedInt());
        assertThrows(IllegalArgumentException.class, () -> instance.setFromUnsignedInt(-1));
        assertThrows(IllegalArgumentException.class, () -> new AsUnsignedInt(BaseDataType.int8_t, null, 0, SetMem.DO_NOT_SET));
    }

}
