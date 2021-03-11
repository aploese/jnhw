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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
public class BaseDataTypeTest {

    public BaseDataTypeTest() {
    }

    @Test
    public void testSizes() {
        MultiarchTupelBuilder mtb = new MultiarchTupelBuilder();
        for (MultiarchInfo mi : mtb.getMultiarchs()) {
            switch (mi) {
                case ARM__LINUX__GNU_EABI_HF:
                    //32 bit, but int64_t is aligned at 8 byte
                    assertEquals(4, BaseDataType.SIZE_OF_LONG);
                    assertEquals(Alignment.AT_4, BaseDataType.ALIGN_OF_LONG);
                    assertEquals(4, BaseDataType.SIZE_OF_POINTER);
                    assertEquals(Alignment.AT_4, BaseDataType.ALIGN_OF_POINTER);
                    assertEquals(Alignment.AT_8, BaseDataType.ALIGN_OF_INT64_T);
                    break;
                case I386__LINUX__GNU:
                    //classical 32bit anything is at 4 byte aligned
                    assertEquals(4, BaseDataType.SIZE_OF_LONG);
                    assertEquals(Alignment.AT_4, BaseDataType.ALIGN_OF_LONG);
                    assertEquals(4, BaseDataType.SIZE_OF_POINTER);
                    assertEquals(Alignment.AT_4, BaseDataType.ALIGN_OF_POINTER);
                    assertEquals(Alignment.AT_4, BaseDataType.ALIGN_OF_INT64_T);
                    break;
                case X86_64__LINUX__GNU:
                    //classical 64bit anything is at 8 byte aligned
                    assertEquals(8, BaseDataType.SIZE_OF_LONG);
                    assertEquals(Alignment.AT_8, BaseDataType.ALIGN_OF_LONG);
                    assertEquals(8, BaseDataType.SIZE_OF_POINTER);
                    assertEquals(Alignment.AT_8, BaseDataType.ALIGN_OF_POINTER);
                    assertEquals(Alignment.AT_8, BaseDataType.ALIGN_OF_INT64_T);
                    break;
                default:
                    //sorry, but we need proof.... so test an commit results ....
                    String msg = "No testvalues for multiarch: " + mi
                            + "\n\tSIZE_OF_LONG = " + BaseDataType.SIZE_OF_LONG
                            + "\n\tALIGN_OF_LONG = " + BaseDataType.ALIGN_OF_LONG
                            + "\n\tSIZE_OF_POINTER = " + BaseDataType.SIZE_OF_POINTER
                            + "\n\tALIGN_OF_POINTER = " + BaseDataType.ALIGN_OF_POINTER
                            + "\n\tALIGN_OF_INT64_T = " + BaseDataType.ALIGN_OF_INT64_T;
                    fail(msg);
            }
        }
    }
}
