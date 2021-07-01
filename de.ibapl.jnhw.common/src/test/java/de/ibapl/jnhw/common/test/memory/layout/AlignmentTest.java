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
import java.lang.annotation.Native;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class AlignmentTest {

    static {
        LibJnhwCommonTestLoader.touch();
    }

    @Native
    private final static int REQ_ALIGNOF_INT8_T = 0x0001;
    @Native
    private final static int REQ_ALIGNOF_INT16_T = 0x0002;
    @Native
    private final static int REQ_ALIGNOF_INT32_T = 0x0003;
    @Native
    private final static int REQ_ALIGNOF_INT64_T = 0x0004;
    @Native
    private final static int REQ_ALIGNOF_INTPTR_T = 0x0005;
    @Native
    private final static int REQ_ALIGNOF_POINTER = 0x0006;
    @Native
    private final static int REQ_ALIGNOF_LONG = 0x0007;
    @Native
    private final static int REQ_ALIGNOF_FLOAT = 0x0008;
    @Native
    private final static int REQ_ALIGNOF_DOUBLE = 0x0009;
    @Native
    private final static int REQ_ALIGNOF_LONG_DOUBLE = 0x000a;

    @Native
    private final static int STRUCT_OFFSET = 0x0010;

    @Native
    private final static int REQ___BIGGEST_ALIGNMENT__ = 0x0300;

    private static native int getFromNative(int alignofReqXXX);

    public AlignmentTest() {
    }

    @Test
    public void testValues() {
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT8_T)), Alignment.__ALIGN_OF_INT8_T);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT16_T)), Alignment.__ALIGN_OF_INT16_T);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT32_T)), Alignment.__ALIGN_OF_INT32_T);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT64_T)), Alignment.__ALIGN_OF_INT64_T);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INTPTR_T)), Alignment.__ALIGN_OF_INTPTR_T);

        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_POINTER)), Alignment.__ALIGN_OF_POINTER);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_LONG)), Alignment.__ALIGN_OF_LONG);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_FLOAT)), Alignment.__ALIGN_OF_FLOAT);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_DOUBLE)), Alignment.__ALIGN_OF_DOUBLE);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_LONG_DOUBLE)), Alignment.__ALIGN_OF_LONG_DOUBLE);

        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT8_T | STRUCT_OFFSET)), Alignment.__ALIGN_OF_STRUCT_INT8_T);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT16_T | STRUCT_OFFSET)), Alignment.__ALIGN_OF_STRUCT_INT16_T);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT32_T | STRUCT_OFFSET)), Alignment.__ALIGN_OF_STRUCT_INT32_T);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INT64_T | STRUCT_OFFSET)), Alignment.__ALIGN_OF_STRUCT_INT64_T);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_INTPTR_T | STRUCT_OFFSET)), Alignment.__ALIGN_OF_STRUCT_INTPTR_T);

        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_POINTER | STRUCT_OFFSET)), Alignment.__ALIGN_OF_STRUCT_POINTER);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_LONG | STRUCT_OFFSET)), Alignment.__ALIGN_OF_STRUCT_LONG);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_FLOAT | STRUCT_OFFSET)), Alignment.__ALIGN_OF_STRUCT_FLOAT);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_LONG | STRUCT_OFFSET)), Alignment.__ALIGN_OF_STRUCT_DOUBLE);
        assertEquals(Alignment.fromAlignof(getFromNative(REQ_ALIGNOF_LONG_DOUBLE | STRUCT_OFFSET)), Alignment.__ALIGN_OF_STRUCT_LONG_DOUBLE);

        assertEquals(Alignment.fromAlignof(getFromNative(REQ___BIGGEST_ALIGNMENT__)), Alignment.__BIGGEST_ALIGNMENT__);
    }

}
