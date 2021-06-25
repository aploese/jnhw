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

    public BaseDataTypeTest() {
    }

    @Test
    public void testSizes() {
        MultiarchTupelBuilder mtb = new MultiarchTupelBuilder();
        for (MultiarchInfo mi : mtb.getMultiarchs()) {
            assertEquals(mi.getSizeOfLong().sizeInBit, BaseDataType.__SIZE_OF_LONG * 8);
            assertEquals(mi.getSizeOfPointer().sizeInBit, BaseDataType.__SIZE_OF_POINTER * 8);
            assertEquals(mi.getEndianess(), BaseDataType.__ENDIANESS);
            switch (mi) {
                case ARM__LINUX__GNU_EABI:
                case ARM__LINUX__GNU_EABI_HF:
                case MIPS__LINUX__GNU:
                case MIPS_EL__LINUX__GNU:
                    assertEquals(Endianess.LITTLE, BaseDataType.__ENDIANESS);
                    //32 bit, but __BIGGEST_ALIGNMENT__ is 8
                    assertEquals(Alignment.AT_8, Alignment.__BIGGEST_ALIGNMENT__);

                    assertEquals(4, BaseDataType.__SIZE_OF_LONG);
                    assertEquals(4, BaseDataType.__SIZE_OF_POINTER);

                    assertEquals(4, BaseDataType.__SIZE_OF_FLOAT);
                    assertEquals(8, BaseDataType.__SIZE_OF_DOUBLE);
                    assertEquals(8, BaseDataType.__SIZE_OF_LONG_DOUBLE);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_LONG);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_LONG);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_POINTER);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_POINTER);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_FLOAT);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_FLOAT);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_DOUBLE);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_DOUBLE);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_LONG_DOUBLE);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_LONG_DOUBLE);

                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_INT8_T);
                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_STRUCT_INT8_T);

                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_INT16_T);
                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_STRUCT_INT16_T);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_INT32_T);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_INT32_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INT64_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INT64_T);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_INTPTR_T);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_INTPTR_T);
                    break;
                case I386__LINUX__GNU:
                    //classical 32bit anything is at 4 byte aligned
                    assertEquals(Alignment.AT_16, Alignment.__BIGGEST_ALIGNMENT__);

                    assertEquals(4, BaseDataType.__SIZE_OF_LONG);
                    assertEquals(4, BaseDataType.__SIZE_OF_POINTER);

                    assertEquals(4, BaseDataType.__SIZE_OF_FLOAT);
                    assertEquals(8, BaseDataType.__SIZE_OF_DOUBLE);
                    assertEquals(12, BaseDataType.__SIZE_OF_LONG_DOUBLE);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_LONG);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_LONG);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_POINTER);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_POINTER);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_FLOAT);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_FLOAT);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_DOUBLE);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_DOUBLE);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_LONG_DOUBLE);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_LONG_DOUBLE);

                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_INT8_T);
                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_STRUCT_INT8_T);

                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_INT16_T);
                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_STRUCT_INT16_T);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_INT32_T);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_INT32_T);

                    //Why is int64_t alighned at 8, but in struct at 4 ????
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INT64_T);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_INT64_T);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_INTPTR_T);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_INTPTR_T);
                    break;
                case S390_X__LINUX__GNU:
                    assertEquals(Alignment.AT_8, Alignment.__BIGGEST_ALIGNMENT__);

                    assertEquals(8, BaseDataType.__SIZE_OF_LONG);
                    assertEquals(8, BaseDataType.__SIZE_OF_POINTER);

                    assertEquals(4, BaseDataType.__SIZE_OF_FLOAT);
                    assertEquals(8, BaseDataType.__SIZE_OF_DOUBLE);
                    assertEquals(16, BaseDataType.__SIZE_OF_LONG_DOUBLE);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_LONG);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_LONG);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_POINTER);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_POINTER);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_FLOAT);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_FLOAT);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_DOUBLE);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_DOUBLE);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_LONG_DOUBLE);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_LONG_DOUBLE);

                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_INT8_T);
                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_STRUCT_INT8_T);

                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_INT16_T);
                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_STRUCT_INT16_T);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_INT32_T);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_INT32_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INT64_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INT64_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INTPTR_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INTPTR_T);
                    break;
                case MIPS_64__LINUX__GNU_ABI_64:
                case MIPS_64_EL__LINUX__GNU_ABI_64:
                    assertEquals(Alignment.AT_16, Alignment.__BIGGEST_ALIGNMENT__);

                    assertEquals(8, BaseDataType.__SIZE_OF_LONG);
                    assertEquals(8, BaseDataType.__SIZE_OF_POINTER);

                    assertEquals(4, BaseDataType.__SIZE_OF_FLOAT);
                    assertEquals(8, BaseDataType.__SIZE_OF_DOUBLE);
                    assertEquals(16, BaseDataType.__SIZE_OF_LONG_DOUBLE);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_LONG);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_LONG);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_POINTER);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_POINTER);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_FLOAT);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_FLOAT);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_DOUBLE);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_DOUBLE);

                    assertEquals(Alignment.AT_16, Alignment.__ALIGN_OF_LONG_DOUBLE);
                    assertEquals(Alignment.AT_16, Alignment.__ALIGN_OF_STRUCT_LONG_DOUBLE);

                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_INT8_T);
                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_STRUCT_INT8_T);

                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_INT16_T);
                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_STRUCT_INT16_T);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_INT32_T);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_INT32_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INT64_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INT64_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INTPTR_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INTPTR_T);
                    break;
                case AARCH64__LINUX__GNU:
                case POWER_PC_64_LE__LINUX__GNU:
                case RISC_V_64__LINUX__GNU:
                case X86_64__LINUX__GNU:
                    //classical 64bit anything is at 8 byte aligned
                    assertEquals(Alignment.AT_16, Alignment.__BIGGEST_ALIGNMENT__);

                    assertEquals(8, BaseDataType.__SIZE_OF_LONG);
                    assertEquals(8, BaseDataType.__SIZE_OF_POINTER);

                    assertEquals(4, BaseDataType.__SIZE_OF_FLOAT);
                    assertEquals(8, BaseDataType.__SIZE_OF_DOUBLE);
                    assertEquals(16, BaseDataType.__SIZE_OF_LONG_DOUBLE);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_LONG);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_LONG);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_POINTER);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_POINTER);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_FLOAT);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_FLOAT);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_DOUBLE);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_DOUBLE);

                    assertEquals(Alignment.AT_16, Alignment.__ALIGN_OF_LONG_DOUBLE);
                    assertEquals(Alignment.AT_16, Alignment.__ALIGN_OF_STRUCT_LONG_DOUBLE);

                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_INT8_T);
                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_STRUCT_INT8_T);

                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_INT16_T);
                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_STRUCT_INT16_T);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_INT32_T);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_INT32_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INT64_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INT64_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INTPTR_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INTPTR_T);
                    break;
                case X86_64__WINDOWS__PE32_PLUS:
                    //classical 64bit anything is at 8 byte aligned long is 4 bytes long ...
                    assertEquals(Alignment.AT_16, Alignment.__BIGGEST_ALIGNMENT__);

                    assertEquals(4, BaseDataType.__SIZE_OF_LONG);
                    assertEquals(8, BaseDataType.__SIZE_OF_POINTER);

                    assertEquals(4, BaseDataType.__SIZE_OF_FLOAT);
                    assertEquals(8, BaseDataType.__SIZE_OF_DOUBLE);
                    assertEquals(16, BaseDataType.__SIZE_OF_LONG_DOUBLE);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_LONG);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_LONG);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_POINTER);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_POINTER);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_FLOAT);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_FLOAT);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_DOUBLE);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_DOUBLE);

                    assertEquals(Alignment.AT_16, Alignment.__ALIGN_OF_LONG_DOUBLE);
                    assertEquals(Alignment.AT_16, Alignment.__ALIGN_OF_STRUCT_LONG_DOUBLE);

                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_INT8_T);
                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_STRUCT_INT8_T);

                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_INT16_T);
                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_STRUCT_INT16_T);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_INT32_T);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_INT32_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INT64_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INT64_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INTPTR_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INTPTR_T);
                    break;
                case X86_64__OPEN_BSD__BSD:
                case X86_64__FREE_BSD__BSD:
                    //classical 64bit anything is at 8 byte aligned
                    assertEquals(Alignment.AT_16, Alignment.__BIGGEST_ALIGNMENT__);

                    assertEquals(8, BaseDataType.__SIZE_OF_LONG);
                    assertEquals(8, BaseDataType.__SIZE_OF_POINTER);

                    assertEquals(4, BaseDataType.__SIZE_OF_FLOAT);
                    assertEquals(8, BaseDataType.__SIZE_OF_DOUBLE);
                    assertEquals(16, BaseDataType.__SIZE_OF_LONG_DOUBLE);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_LONG);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_LONG);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_POINTER);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_POINTER);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_FLOAT);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_FLOAT);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_DOUBLE);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_DOUBLE);

                    assertEquals(Alignment.AT_16, Alignment.__ALIGN_OF_LONG_DOUBLE);
                    assertEquals(Alignment.AT_16, Alignment.__ALIGN_OF_STRUCT_LONG_DOUBLE);

                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_INT8_T);
                    assertEquals(Alignment.AT_1, Alignment.__ALIGN_OF_STRUCT_INT8_T);

                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_INT16_T);
                    assertEquals(Alignment.AT_2, Alignment.__ALIGN_OF_STRUCT_INT16_T);

                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_INT32_T);
                    assertEquals(Alignment.AT_4, Alignment.__ALIGN_OF_STRUCT_INT32_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INT64_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INT64_T);

                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_INTPTR_T);
                    assertEquals(Alignment.AT_8, Alignment.__ALIGN_OF_STRUCT_INTPTR_T);
                    break;
                default:
                    //sorry, but we need proof.... so test an commit results ....
                    StringBuilder sb = new StringBuilder();
                    sb.append("No testvalues for multiarch:  ").append(mi).append("\n");
                    sb.append("__BIGGEST_ALIGNMENT__       = ").append(Alignment.__BIGGEST_ALIGNMENT__).append("\n");

                    sb.append("SIZE_OF_LONG                = ").append(BaseDataType.__SIZE_OF_LONG).append("\n");
                    sb.append("SIZE_OF_POINTER             = ").append(BaseDataType.__SIZE_OF_POINTER).append("\n");

                    sb.append("SIZE_OF_FLOAT               = ").append(BaseDataType.__SIZE_OF_FLOAT).append("\n");
                    sb.append("SIZE_OF_DOUBLE              = ").append(BaseDataType.__SIZE_OF_DOUBLE).append("\n");
                    sb.append("SIZE_OF_LONG_DOUBLE         = ").append(BaseDataType.__SIZE_OF_LONG_DOUBLE).append("\n");

                    sb.append("ALIGN_OF_LONG               = ").append(Alignment.__ALIGN_OF_LONG).append("\n");
                    sb.append("ALIGN_OF_STRUCT_LONG        = ").append(Alignment.__ALIGN_OF_STRUCT_LONG).append("\n");

                    sb.append("ALIGN_OF_POINTER            = ").append(Alignment.__ALIGN_OF_POINTER).append("\n");
                    sb.append("ALIGN_OF_STRUCT_POINTER     = ").append(Alignment.__ALIGN_OF_STRUCT_POINTER).append("\n");

                    sb.append("ALIGN_OF_FLOAT              = ").append(Alignment.__ALIGN_OF_FLOAT).append("\n");
                    sb.append("ALIGN_OF_STRUCT_FLOAT       = ").append(Alignment.__ALIGN_OF_STRUCT_FLOAT).append("\n");

                    sb.append("ALIGN_OF_DOUBLE             = ").append(Alignment.__ALIGN_OF_DOUBLE).append("\n");
                    sb.append("ALIGN_OF_STRUCT_DOUBLE      = ").append(Alignment.__ALIGN_OF_STRUCT_DOUBLE).append("\n");

                    sb.append("ALIGN_OF_LONG_DOUBLE        = ").append(Alignment.__ALIGN_OF_LONG_DOUBLE).append("\n");
                    sb.append("ALIGN_OF_STRUCT_LONG_DOUBLE = ").append(Alignment.__ALIGN_OF_STRUCT_LONG_DOUBLE).append("\n");

                    sb.append("ALIGN_OF_INT8_T             = ").append(Alignment.__ALIGN_OF_INT8_T).append("\n");
                    sb.append("ALIGN_OF_STRUCT_INT8_T      = ").append(Alignment.__ALIGN_OF_STRUCT_INT8_T).append("\n");

                    sb.append("ALIGN_OF_INT16_T            = ").append(Alignment.__ALIGN_OF_INT16_T).append("\n");
                    sb.append("ALIGN_OF_STRUCT_INT16_T     = ").append(Alignment.__ALIGN_OF_STRUCT_INT16_T).append("\n");

                    sb.append("ALIGN_OF_INT32_T            = ").append(Alignment.__ALIGN_OF_INT32_T).append("\n");
                    sb.append("ALIGN_OF_STRUCT_INT32_T     = ").append(Alignment.__ALIGN_OF_STRUCT_INT32_T).append("\n");

                    sb.append("ALIGN_OF_INT64_T            = ").append(Alignment.__ALIGN_OF_INT64_T).append("\n");
                    sb.append("ALIGN_OF_STRUCT_INT64_T     = ").append(Alignment.__ALIGN_OF_STRUCT_INT64_T).append("\n");

                    sb.append("ALIGN_OF_INTPTR_T           = ").append(Alignment.__ALIGN_OF_INTPTR_T).append("\n");
                    sb.append("ALIGN_OF_STRUCT_INTPTR_T    = ").append(Alignment.__ALIGN_OF_STRUCT_INTPTR_T).append("\n");

                    fail(sb.toString());
            }
        }
    }
}
