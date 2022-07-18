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
import de.ibapl.jnhw.common.memory.AsSignedInt;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class AsSignedIntTest {

    @Test
    public void testNative() {
        try ( ResourceScope rs = ResourceScope.newConfinedScope()) {
            AsSignedInt instance = AsSignedInt.allocateNative(BaseDataType.int16_t, rs);
            short expResult = 0x2010;
            instance.setFromSignedInt(expResult);
            assertEquals(expResult, instance.getAsSignedInt());
            assertThrows(IllegalArgumentException.class, () -> instance.setFromSignedInt(Integer.MAX_VALUE));
            assertThrows(IllegalArgumentException.class, () -> new AsSignedInt(BaseDataType.uint8_t, MemorySegment.allocateNative(BaseDataType.uint8_t.SIZE_OF, rs), 0));
        }
    }
}
