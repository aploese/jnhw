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
package de.ibapl.jnhw.common.test.memory.layout;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.layout.FieldLayout;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author aploese
 */
public class FieldLayoutTest {

    @BeforeAll
    public static void setup() {
        LibJnhwCommonTestLoader.touch();
    }

    public static native <T extends FieldLayout> T createLayout(Class<T> clazz, String name, long offset) throws NoSuchMethodError;

    /**
     * Define a new dataType
     */
    static class LinuxKernelFieldLayout extends FieldLayout {

        static FieldLayout __u8(long offset) {
            return new LinuxKernelFieldLayout(offset);
        }

        protected LinuxKernelFieldLayout(long offset) {
            super(offset);
        }

    }

    /**
     * Test of int8_t method, of class FieldLayout.
     */
    @Test
    public void testInt8_t() {
        System.out.println("int8_t");
        long offset = 12L;
        FieldLayout expResult = FieldLayout.int8_t(offset);
        //TODO assertEquals(BaseDataType.int8_t, expResult.datatype);
        assertEquals(offset, expResult.offset);
        FieldLayout result = createLayout(FieldLayout.class, "int8_t", offset);
        //TODO assertEquals(expResult.datatype, result.datatype);
        assertEquals(expResult.offset, result.offset);
    }

    /**
     * Test of int8_t method, of class FieldLayout.
     */
    @Test
    public void test__u8() {
        System.out.println("__u8");
        long offset = 2L;
        FieldLayout expResult = LinuxKernelFieldLayout.__u8(offset);
        //TODO assertEquals(BaseDataType.uint8_t, expResult.datatype);
        assertEquals(offset, expResult.offset);
        FieldLayout result = createLayout(LinuxKernelFieldLayout.class, "__u8", offset);
        //TODO assertEquals(expResult.datatype, result.datatype);
        assertEquals(expResult.offset, result.offset);
    }

}
