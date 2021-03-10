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
        Assertions.assertEquals(32, definedLayout.offsetEighth);

        Assertions.assertEquals(40, definedLayout.getSizeof());
        Assertions.assertEquals(Alignment.AT_8, definedLayout.getAlignment());

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
        Assertions.assertEquals(32, nativeLayout.offsetEighth);

        Assertions.assertEquals(40, nativeLayout.sizeof);
        Assertions.assertEquals(Alignment.AT_8, nativeLayout.alignment);

    }

}