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
package de.ibapl.jnhw.common.test.memory.layout;

import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.test.LibJnhwCommonTestLoader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class AlignmentTest {

    private int alignOf_int8_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_int8_t");
    }

    private int alignOf_int16_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_int16_t");
    }

    private int alignOf_int32_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_int32_t");
    }

    private int alignOf_int64_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_int64_t");
    }

    private int alignOf_intptr_t() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_intptr_t");
    }

    private int alignOf_pointer() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_pointer");
    }

    private int alignOf_int() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_int");
    }

    private int alignOf_long() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_long");
    }

    private int alignOf_long_long() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_long_long");
    }

    private int alignOf_float() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_float");
    }

    private int alignOf_double() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_double");
    }

    private int alignOf_long_double() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("alignOf_long_double");
    }

    private int get__BIGGEST_ALIGNMENT__() {
        return LibJnhwCommonTestLoader.invokeExact_Int_V("get__BIGGEST_ALIGNMENT__");
    }

    @Test
    public void testValues() {
        assertEquals(Alignment.fromAlignof(alignOf_int8_t()), Alignment.__ALIGN_OF_INT8_T);
        assertEquals(Alignment.fromAlignof(alignOf_int16_t()), Alignment.__ALIGN_OF_INT16_T);
        assertEquals(Alignment.fromAlignof(alignOf_int32_t()), Alignment.__ALIGN_OF_INT32_T);
        assertEquals(Alignment.fromAlignof(alignOf_int64_t()), Alignment.__ALIGN_OF_INT64_T);
        assertEquals(Alignment.fromAlignof(alignOf_intptr_t()), Alignment.__ALIGN_OF_INTPTR_T);

        assertEquals(Alignment.fromAlignof(alignOf_pointer()), Alignment.__ALIGN_OF_POINTER);
        assertEquals(Alignment.fromAlignof(alignOf_int()), Alignment.__ALIGN_OF_INT);
        assertEquals(Alignment.fromAlignof(alignOf_long()), Alignment.__ALIGN_OF_LONG);
        assertEquals(Alignment.fromAlignof(alignOf_long_long()), Alignment.__ALIGN_OF_LONG_LONG);
        assertEquals(Alignment.fromAlignof(alignOf_float()), Alignment.__ALIGN_OF_FLOAT);
        assertEquals(Alignment.fromAlignof(alignOf_double()), Alignment.__ALIGN_OF_DOUBLE);
        assertEquals(Alignment.fromAlignof(alignOf_long_double()), Alignment.__ALIGN_OF_LONG_DOUBLE);

        assertEquals(Alignment.fromAlignof(get__BIGGEST_ALIGNMENT__()), Alignment.__BIGGEST_ALIGNMENT__);
    }

}
