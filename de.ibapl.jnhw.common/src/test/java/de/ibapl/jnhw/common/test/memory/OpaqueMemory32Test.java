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
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SET_MEM_TO_0;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.test.memory.layout.SimpeStructureOnTheFlyImpl;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.WordSize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpaqueMemory32Test {

    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    private class MemToTest extends OpaqueMemory32 {

        MemToTest(NativeAddressHolder baseAddress, int sizeInBytes) {
            super(baseAddress, sizeInBytes);
        }

        MemToTest(OpaqueMemory32 mem, int offset, int sizeInBytes, Byte setMem) {
            super(mem, offset, sizeInBytes, setMem);
        }

        @Override
        public BaseDataType getBaseDataType() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String nativeToHexString() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        long getBaseAddress() {
            return baseAddress;
        }

    }

    @Test
    public void testAllocateDirtyMem() throws Exception {
        OpaqueMemory32 mem = new MemToTest(null, 0, 1024, null);
        Assertions.assertEquals(1024, mem.sizeInBytes);
        Assertions.assertEquals(mem, mem.parent);
        mem = null;
        System.gc();
        Thread.sleep(1000);
        System.gc();
    }

    @Test
    public void testAllocateCleanMem() throws Exception {
        OpaqueMemory32 mem = new MemToTest(null, 0, 1024, SET_MEM_TO_0);
        Assertions.assertEquals(1024, mem.sizeInBytes);
        Assertions.assertEquals(mem, mem.parent);
        mem = null;
        System.gc();
        Thread.sleep(1000);
        System.gc();
    }

    private final static byte[] HELLO_WORLD = "Hello World!".getBytes();

    @Test
    public void testCopy() throws Exception {
        OpaqueMemory32 mem = new MemToTest(null, 0, 1024, null);
        final int MEM_POS = 753;
        OpaqueMemory32.copy(HELLO_WORLD, 0, mem, MEM_POS, HELLO_WORLD.length);
        byte[] received = new byte[HELLO_WORLD.length];
        OpaqueMemory32.copy(mem, MEM_POS, received, 0, received.length);
        Assertions.assertArrayEquals(HELLO_WORLD, received);
    }

    @Test
    public void testCopyIndex() throws Exception {
        final byte[] array = new byte[16];
        final OpaqueMemory32 mem = new MemToTest(null, 0, array.length, null);
        Assertions.assertAll(() -> {
            //exact fit
            OpaqueMemory32.copy(mem, 0, array, 0, array.length);
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(mem, -1, array, 0, 1);
            }, "srcPos == -1");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(mem, 22, array, 0, 1);
            }, "srcPos > src.sizeInBytes");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(mem, 8, array, 0, 16);
            }, "srcPos + len > src.sizeInBytes");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(mem, 0, array, -1, 1);
            }, "destPos == -1");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(mem, 0, array, 22, 1);
            }, "Srcmem start outside destarray");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(mem, 0, array, 8, 16);
            }, "Srcmem end outside destarray");
        }, () -> {
            //exact fit
            if (mem.sizeInBytes <= Integer.MAX_VALUE) {
                OpaqueMemory32.copy(array, 0, mem, 0, (int) mem.sizeInBytes);
            } else {
                throw new RuntimeException("Cant execute test because mem.sizeInBytes > Integer.MAX_VALUE");
            }
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(array, -1, mem, 0, 1);
            }, "Destmem start outside srcarray");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(array, 22, mem, 0, 1);
            }, "Destmem start outside srcarray");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(array, 8, mem, 0, 16);
            }, "Destmem end outside srcarray");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(array, 0, mem, -1, 1);
            }, "Srcarray start outside destmem");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(array, 0, mem, 22, 1);
            }, "Srcarray start outside destmem");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(array, 0, mem, 8, 16);
            }, "Srcarray end outside destmem");
        });
    }

    @Test
    public void testGetSetByte() throws Exception {
        OpaqueMemory32 mem = new MemToTest(null, 0, 1024, null);
        OpaqueMemory32.setByte(mem, 67, (byte) 9);
        Assertions.assertEquals((byte) 9, OpaqueMemory32.getByte(mem, 67));
    }

    @Test
    public void testSetGetIndex() throws Exception {
        final OpaqueMemory32 mem = new MemToTest(null, 0, 16, null);
        Assertions.assertAll(() -> {
            //Exact fit
            OpaqueMemory32.getByte(mem, 0);
            OpaqueMemory32.getByte(mem, 15);
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.getByte(mem, -1);
            });
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.getByte(mem, 22);
            });
        }, () -> {
            //Exact fit
            OpaqueMemory32.setByte(mem, 0, SET_MEM_TO_0);
            OpaqueMemory32.setByte(mem, 15, SET_MEM_TO_0);
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.setByte(mem, -11, SET_MEM_TO_0);
            });
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.setByte(mem, 33, SET_MEM_TO_0);
            });
        });
    }

    @Test
    public void testClear() throws Exception {
        OpaqueMemory32 mem = new MemToTest(null, 0, 1024, null);
        OpaqueMemory32.clear(mem);
        for (int i = 0; i < mem.sizeInBytes; i++) {
            Assertions.assertEquals(0, OpaqueMemory32.getByte(mem, i));
        }
    }

    @Test
    public void testSetMem() throws Exception {
        OpaqueMemory32 mem = new MemToTest(null, 0, 1024, SET_MEM_TO_0);
        OpaqueMemory32.memset(mem, (byte) 42);
        for (int i = 0; i < mem.sizeInBytes; i++) {
            Assertions.assertEquals(42, OpaqueMemory32.getByte(mem, i));
        }
    }

    @Test
    public void testEquals() throws Exception {
        OpaqueMemory32 mem = new MemToTest(new NativeAddressHolder(0x2aL), 8);
        OpaqueMemory32 mem1 = new MemToTest(new NativeAddressHolder(42L), 8);
        OpaqueMemory32 mem2 = new MemToTest(mem, 0, 8, null);
        switch (MULTIARCHTUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                Assertions.assertEquals("{baseAddress : 0x0000002a, sizeInBytes : 8, memoryOwner : null}", mem.toString());
                Assertions.assertEquals("{baseAddress : 0x0000002a, sizeInBytes : 8, memoryOwner : null}", mem1.toString());
                Assertions.assertEquals("{baseAddress : 0x0000002a, sizeInBytes : 8, memoryOwner : {baseAddress : 0x0000002a, sizeInBytes : 8, memoryOwner : null}}", mem2.toString());
                break;
            case _64_BIT:
                Assertions.assertEquals("{baseAddress : 0x000000000000002a, sizeInBytes : 8, memoryOwner : null}", mem.toString());
                Assertions.assertEquals("{baseAddress : 0x000000000000002a, sizeInBytes : 8, memoryOwner : null}", mem1.toString());
                Assertions.assertEquals("{baseAddress : 0x000000000000002a, sizeInBytes : 8, memoryOwner : {baseAddress : 0x000000000000002a, sizeInBytes : 8, memoryOwner : null}}", mem2.toString());
                break;
            default:
                throw new RuntimeException();
        }
        Assertions.assertEquals(mem, mem1);
        Assertions.assertEquals(mem1, mem2);
        Assertions.assertEquals(mem, mem2);
        Assertions.assertEquals(mem.hashCode(), mem1.hashCode());
        Assertions.assertEquals(mem.hashCode(), mem2.hashCode());
        Assertions.assertEquals(mem1.hashCode(), mem2.hashCode());
    }

    @Test
    public void testAddressOn32BitNotNegative() {
        MemToTest parent = new MemToTest(null, 0, 48, SET_MEM_TO_0);
        if (MULTIARCHTUPEL_BUILDER.getWordSize() == WordSize._32_BIT) {
            Assertions.assertTrue(parent.getBaseAddress() > 0, "baseaddress is not positive");
        }
    }

    @Test
    public void testCalcNextOffset() {
        SimpeStructureOnTheFlyImpl struct = new SimpeStructureOnTheFlyImpl(null, 0, 48, SET_MEM_TO_0);

        Assertions.assertEquals(0, AbstractNativeMemory.offsetof(struct.first));
        struct.first((byte) 0x11);

        Assertions.assertEquals(2, AbstractNativeMemory.offsetof(struct.second));
        struct.second((short) 0x2222);

        Assertions.assertEquals(4, AbstractNativeMemory.offsetof(struct.third));
        struct.third((byte) 0x33);

        Assertions.assertEquals(8, AbstractNativeMemory.offsetof(struct.forth));
        struct.forth(0x44444444);

        Assertions.assertEquals(12, AbstractNativeMemory.offsetof(struct.fifth));
        struct.fifth((byte) 0x55);

        Assertions.assertEquals(16, AbstractNativeMemory.offsetof(struct.sixth));
        struct.sixth(0x6666666666666666L);

        Assertions.assertEquals(24, AbstractNativeMemory.offsetof(struct.seventh));
        struct.seventh((byte) 0x77);

        String expected = null;
        switch (Alignment.ALIGN_OF_INT64_T) {
            case AT_8:
                Assertions.assertEquals(32, AbstractNativeMemory.offsetof(struct.eighth));
                expected = "11002222 33000000  44444444 55000000 |  \"\"3   DDDDU   \n"
                        + "66666666 66666666  77000000 00000000 | ffffffffw       \n"
                        + "88888888 88888888  00000000 00000000 | ﾈﾈﾈﾈﾈﾈﾈﾈ        ";
                break;
            case AT_4:
                Assertions.assertEquals(28, AbstractNativeMemory.offsetof(struct.eighth));
                expected = "11002222 33000000  44444444 55000000 |  \"\"3   DDDDU   \n"
                        + "66666666 66666666  77000000 88888888 | ffffffffw   ﾈﾈﾈﾈ\n"
                        + "88888888 00000000  00000000 00000000 | ﾈﾈﾈﾈ            ";
                break;
            default:
                Assertions.fail();
        }
        struct.eighth(0x8888888888888888L);

        Assertions.assertEquals(expected, OpaqueMemory32.printMemory(struct, false));
        byte[] result = OpaqueMemory32.toBytes(struct);

        Assertions.assertEquals(0x11, result[0]);
        Assertions.assertEquals(0x00, result[1]);
        Assertions.assertEquals(0x22, result[2]);
        Assertions.assertEquals(0x22, result[3]);

        Assertions.assertEquals(0x33, result[4]);
        Assertions.assertEquals(0x00, result[5]);
        Assertions.assertEquals(0x00, result[6]);
        Assertions.assertEquals(0x00, result[7]);

        Assertions.assertEquals(0x44, result[8]);
        Assertions.assertEquals(0x44, result[9]);
        Assertions.assertEquals(0x44, result[10]);
        Assertions.assertEquals(0x44, result[11]);

        Assertions.assertEquals(0x55, result[12]);
        Assertions.assertEquals(0x00, result[13]);
        Assertions.assertEquals(0x00, result[14]);
        Assertions.assertEquals(0x00, result[15]);

        Assertions.assertEquals(0x66, result[16]);
        Assertions.assertEquals(0x66, result[17]);
        Assertions.assertEquals(0x66, result[18]);
        Assertions.assertEquals(0x66, result[19]);

        Assertions.assertEquals(0x66, result[20]);
        Assertions.assertEquals(0x66, result[21]);
        Assertions.assertEquals(0x66, result[22]);
        Assertions.assertEquals(0x66, result[23]);

        Assertions.assertEquals(0x77, result[24]);
        Assertions.assertEquals(0x00, result[25]);
        Assertions.assertEquals(0x00, result[26]);
        Assertions.assertEquals(0x00, result[27]);

        switch (Alignment.ALIGN_OF_INT64_T) {
            case AT_8:
                Assertions.assertEquals(0x00, result[28]);
                Assertions.assertEquals(0x00, result[29]);
                Assertions.assertEquals(0x00, result[30]);
                Assertions.assertEquals(0x00, result[31]);

                Assertions.assertEquals((byte) 0x88, result[32]);
                Assertions.assertEquals((byte) 0x88, result[33]);
                Assertions.assertEquals((byte) 0x88, result[34]);
                Assertions.assertEquals((byte) 0x88, result[35]);

                Assertions.assertEquals((byte) 0x88, result[36]);
                Assertions.assertEquals((byte) 0x88, result[37]);
                Assertions.assertEquals((byte) 0x88, result[38]);
                Assertions.assertEquals((byte) 0x88, result[39]);

                Assertions.assertEquals(0x00, result[40]);
                Assertions.assertEquals(0x00, result[41]);
                Assertions.assertEquals(0x00, result[42]);
                Assertions.assertEquals(0x00, result[43]);

                Assertions.assertEquals(0x00, result[44]);
                Assertions.assertEquals(0x00, result[45]);
                Assertions.assertEquals(0x00, result[46]);
                Assertions.assertEquals(0x00, result[47]);
                break;
            case AT_4:
                Assertions.assertEquals((byte) 0x88, result[28]);
                Assertions.assertEquals((byte) 0x88, result[29]);
                Assertions.assertEquals((byte) 0x88, result[30]);
                Assertions.assertEquals((byte) 0x88, result[31]);

                Assertions.assertEquals((byte) 0x88, result[32]);
                Assertions.assertEquals((byte) 0x88, result[33]);
                Assertions.assertEquals((byte) 0x88, result[34]);
                Assertions.assertEquals((byte) 0x88, result[35]);

                Assertions.assertEquals(0x00, result[36]);
                Assertions.assertEquals(0x00, result[37]);
                Assertions.assertEquals(0x00, result[38]);
                Assertions.assertEquals(0x00, result[39]);

                Assertions.assertEquals(0x00, result[40]);
                Assertions.assertEquals(0x00, result[41]);
                Assertions.assertEquals(0x00, result[42]);
                Assertions.assertEquals(0x00, result[43]);

                Assertions.assertEquals(0x00, result[44]);
                Assertions.assertEquals(0x00, result[45]);
                Assertions.assertEquals(0x00, result[46]);
                Assertions.assertEquals(0x00, result[47]);
                break;
            default:
                Assertions.fail();
        }

    }

}
