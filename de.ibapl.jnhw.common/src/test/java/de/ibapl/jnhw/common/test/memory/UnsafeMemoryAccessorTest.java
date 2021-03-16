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
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import de.ibapl.jnhw.libloader.OS;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class UnsafeMemoryAccessorTest {

    public UnsafeMemoryAccessorTest() {
    }

    @Test
    public void testSizes() {
        //We rely on this to figure out 32 or 64 for long
        switch (NativeLibResolver.getSizeOfPointer()) {
            case _32_BIT:
                assertEquals(4, BaseDataType.SIZE_OF_POINTER);
                assertEquals(Alignment.AT_4, Alignment.ALIGN_OF_POINTER);
                break;
            case _64_BIT:
                assertEquals(8, BaseDataType.SIZE_OF_POINTER);
                assertEquals(Alignment.AT_8, Alignment.ALIGN_OF_POINTER);
                break;
            default:
                fail();
        }
        switch (NativeLibResolver.getSizeOfLong()) {
            case _32_BIT:
                assertEquals(4, BaseDataType.SIZE_OF_LONG);
                assertEquals(Alignment.AT_4, Alignment.ALIGN_OF_LONG);
                break;
            case _64_BIT:
                assertEquals(8, BaseDataType.SIZE_OF_LONG);
                assertEquals(Alignment.AT_8, Alignment.ALIGN_OF_LONG);
                break;
            default:
                fail();
        }
    }

}
