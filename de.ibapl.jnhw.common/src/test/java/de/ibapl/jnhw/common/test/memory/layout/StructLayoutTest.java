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
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author aploese
 */
public class StructLayoutTest {

    @BeforeAll
    public static void setup() {
        LibJnhwCommonTestLoader.touch();
    }

    private native int getAlignOfEmptyStruct();

    private native int getAlignOfStruct_Int8_t();

    private native int getAlignOfStruct_Int16_t();

    private native int getAlignOfStruct_Int32_t();

    private native int getAlignOfStruct_Int64_t();

    private native int getAlignOf_Int8_t();

    private native int getAlignOf_Int16_t();

    private native int getAlignOf_Int32_t();

    private native int getAlignOf_Int64_t();

    @Test
    public void testAlignOfEmptyStruct() {
        Assertions.assertEquals(1, getAlignOfEmptyStruct());
    }

    @Test
    public void testAlignOfStruct_Int8_t() {
        Assertions.assertEquals(1, getAlignOfStruct_Int8_t());
    }

    @Test
    public void testAlignOfStruct_Int16_t() {
        Assertions.assertEquals(2, getAlignOfStruct_Int16_t());
    }

    @Test
    public void testAlignOfStruct_Int32_t() {
        Assertions.assertEquals(4, getAlignOfStruct_Int32_t());
    }

    @Test
    public void testAlignOfStruct_Int64_t() {
        Assertions.assertEquals(BaseDataType.ALIGN_OF_INT64_T.alignof, getAlignOfStruct_Int64_t());
    }

    @Test
    public void testAlignOf_Int8_t() {
        Assertions.assertEquals(1, getAlignOf_Int8_t());
    }

    @Test
    public void testAlignOf_Int16_t() {
        Assertions.assertEquals(2, getAlignOf_Int16_t());
    }

    @Test
    public void testAlignOf_Int32_t() {
        Assertions.assertEquals(4, getAlignOf_Int32_t());
    }

    @Test
    public void testAlignOf_Int64_t() {
        Assertions.assertEquals(BaseDataType.ALIGN_OF_INT64_T.alignof, getAlignOf_Int64_t());
    }

    @Test
    public void testDefinedLayout() {
        SimpeStructureImpl.Layout definedLayout = new SimpeStructureImpl.Layout();

        Assertions.assertEquals(0, definedLayout.offsetFirst);
        Assertions.assertEquals(2, definedLayout.offsetSecond);
        Assertions.assertEquals(4, definedLayout.offsetThird);
        Assertions.assertEquals(8, definedLayout.offsetForth);
        Assertions.assertEquals(12, definedLayout.offsetFifth);
        Assertions.assertEquals(16, definedLayout.offsetSixth);
        Assertions.assertEquals(24, definedLayout.offsetSeventh);
        switch (BaseDataType.ALIGN_OF_INT64_T) {
            case AT_8:
                Assertions.assertEquals(32, definedLayout.offsetEighth);

                Assertions.assertEquals(40, definedLayout.sizeof);
                Assertions.assertEquals(Alignment.AT_8, definedLayout.alignment);
                break;
            case AT_4:
                Assertions.assertEquals(28, definedLayout.offsetEighth);

                Assertions.assertEquals(36, definedLayout.sizeof);
                Assertions.assertEquals(Alignment.AT_4, definedLayout.alignment);
                break;
            default:
                Assertions.fail();
        }
    }

    @Test
    public void testNativeLayout() {
        SimpeStructureImpl.Layout nativeLayout = SimpeStructureImpl.getNativeDefinedLayout(SimpeStructureImpl.Layout.class);

        Assertions.assertEquals(0, nativeLayout.offsetFirst);
        Assertions.assertEquals(2, nativeLayout.offsetSecond);
        Assertions.assertEquals(4, nativeLayout.offsetThird);
        Assertions.assertEquals(8, nativeLayout.offsetForth);
        Assertions.assertEquals(12, nativeLayout.offsetFifth);
        Assertions.assertEquals(16, nativeLayout.offsetSixth);
        Assertions.assertEquals(24, nativeLayout.offsetSeventh);
        switch (BaseDataType.ALIGN_OF_INT64_T) {
            case AT_8:
                Assertions.assertEquals(32, nativeLayout.offsetEighth);

                Assertions.assertEquals(40, nativeLayout.sizeof);
                Assertions.assertEquals(Alignment.AT_8, nativeLayout.alignment);
                break;
            case AT_4:
                Assertions.assertEquals(28, nativeLayout.offsetEighth);

                Assertions.assertEquals(36, nativeLayout.sizeof);
                Assertions.assertEquals(Alignment.AT_4, nativeLayout.alignment);
                break;
            default:
                Assertions.fail();
        }

    }

}
