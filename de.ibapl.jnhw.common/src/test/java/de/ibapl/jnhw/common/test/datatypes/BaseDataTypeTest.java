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
package de.ibapl.jnhw.common.test.datatypes;

import de.ibapl.jnhw.common.*;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Uint64_t;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import de.ibapl.jnhw.libloader.Endianess;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class BaseDataTypeTest {

    static {
        LibJnhwCommonTestLoader.touch();
    }

    private final static native int getSizeOfPointer();

    private final static native int getSizeOf_long();

    private final static native int getSizeOf_float();

    private final static native int getSizeOf_double();

    private final static native int getSizeOf_long_double();

    public BaseDataTypeTest() {
    }

    @Test
    public void testEndianes() {
        final MultiarchInfo mi = LibJnhwCommonLoader.getLoadResult().multiarchInfo;
        final Uint64_t uint64_t = new Uint64_t(null, 0, AbstractNativeMemory.SetMem.TO_0x00);
        OpaqueMemory32.setByte(uint64_t, 0, (byte) 0x01);
        OpaqueMemory32.setByte(uint64_t, 1, (byte) 0x02);
        OpaqueMemory32.setByte(uint64_t, 2, (byte) 0x03);
        OpaqueMemory32.setByte(uint64_t, 3, (byte) 0x04);
        OpaqueMemory32.setByte(uint64_t, 4, (byte) 0x05);
        OpaqueMemory32.setByte(uint64_t, 5, (byte) 0x06);
        OpaqueMemory32.setByte(uint64_t, 6, (byte) 0x07);
        OpaqueMemory32.setByte(uint64_t, 7, (byte) 0x08);
        if (0x0807060504030201L == uint64_t.uint64_t()) {
            assertEquals(Endianess.LITTLE, mi.getEndianess());
        } else if (0x0102030405060708L == uint64_t.uint64_t()) {
            assertEquals(Endianess.BIG, mi.getEndianess());
        } else {
            fail("Can't figure out the endianess for result: 0x" + uint64_t.nativeToHexString() + " multiarchinfo: " + mi);
        }

    }

    @Test
    public void testSizes() {
        assertAll(
                () -> {
                    assertEquals(getSizeOf_long(), BaseDataType.__SIZE_OF_LONG, "__SIZE_OF_LONG");
                }, () -> {
                    assertEquals(getSizeOfPointer(), BaseDataType.__SIZE_OF_POINTER, "__SIZE_OF_POINTER");
                }, () -> {
                    assertEquals(getSizeOf_float(), BaseDataType.__SIZE_OF_FLOAT, "__SIZE_OF_FLOAT");
                }, () -> {
                    assertEquals(getSizeOf_double(), BaseDataType.__SIZE_OF_DOUBLE, "__SIZE_OF_DOUBLE");
                }, () -> {
                    assertEquals(getSizeOf_long_double(), BaseDataType.__SIZE_OF_LONG_DOUBLE, "__SIZE_OF_LONG_DOUBLE");
                });

        MultiarchTupelBuilder mtb = new MultiarchTupelBuilder();
        for (MultiarchInfo mi : mtb.getMultiarchs()) {

            assertAll(
                    () -> {
                        assertEquals(mi.getSizeOfLong().sizeInBit, BaseDataType.__SIZE_OF_LONG * 8, "__SIZE_OF_LONG");
                    }, () -> {
                        assertEquals(mi.getSizeOfPointer().sizeInBit, BaseDataType.__SIZE_OF_POINTER * 8, "__SIZE_OF_POINTER");
                    });
        }
    }
}
