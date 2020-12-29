/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpaqueMemory32Test {

    @Test
    public void testAllocateDirtyMem() throws Exception {
        OpaqueMemory32 mem = new OpaqueMemory32(1024, false);
        Assertions.assertEquals(1024, mem.sizeInBytes);
        Assertions.assertEquals(mem, mem.memoryOwner);
        mem = null;
        System.gc();
        Thread.sleep(1000);
        System.gc();
    }

    @Test
    public void testAllocateCleanMem() throws Exception {
        OpaqueMemory32 mem = new OpaqueMemory32(1024, true);
        Assertions.assertEquals(1024, mem.sizeInBytes);
        Assertions.assertEquals(mem, mem.memoryOwner);
        mem = null;
        System.gc();
        Thread.sleep(1000);
        System.gc();
    }

    @Test
    public void testCAllocateDirtyMem() throws Exception {
        OpaqueMemory32 mem = new OpaqueMemory32(2, 512, false);
        Assertions.assertEquals(1024, mem.sizeInBytes);
        Assertions.assertEquals(mem, mem.memoryOwner);
        mem = null;
        System.gc();
        Thread.sleep(1000);
        System.gc();
    }

    @Test
    public void testCAllocateCleanMem() throws Exception {
        OpaqueMemory32 mem = new OpaqueMemory32(2, 512, true);
        Assertions.assertEquals(1024, mem.sizeInBytes);
        Assertions.assertEquals(mem, mem.memoryOwner);
        mem = null;
        System.gc();
        Thread.sleep(1000);
        System.gc();
    }

    private final static byte[] HELLO_WORLD = "Hello World!".getBytes();

    @Test
    public void testCopy() throws Exception {
        OpaqueMemory32 mem = new OpaqueMemory32(1024, false);
        final int MEM_POS = 753;
        OpaqueMemory32.copy(HELLO_WORLD, 0, mem, MEM_POS, HELLO_WORLD.length);
        byte[] received = new byte[HELLO_WORLD.length];
        OpaqueMemory32.copy(mem, MEM_POS, received, 0, received.length);
        Assertions.assertArrayEquals(HELLO_WORLD, received);
    }

    @Test
    public void testCopyIndex() throws Exception {
        final byte[] array = new byte[16];
        final OpaqueMemory32 mem = new OpaqueMemory32(array.length, false);
        Assertions.assertAll(() -> {
            //exact fit
            OpaqueMemory32.copy(mem, 0, array, 0, array.length);
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(mem, -1, array, 0, 1);
            }, "Destarray start outside srcmem");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(mem, 22, array, 0, 1);
            }, "Destarray start outside srcmem");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(mem, 8, array, 0, 16);
            }, "Destarray end outside srcmem");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.copy(mem, 0, array, -1, 1);
            }, "Srcmem start outside destarray");
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
                OpaqueMemory32.copy(array, 0, mem, 0, (int)mem.sizeInBytes);
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
        OpaqueMemory32 mem = new OpaqueMemory32(1024, false);
        OpaqueMemory32.setByte(mem, 67, (byte) 9);
        Assertions.assertEquals((byte) 9, OpaqueMemory32.getByte(mem, 67));
    }

    @Test
    public void testSetGetIndex() throws Exception {
        final OpaqueMemory32 mem = new OpaqueMemory32(16, false);
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
            OpaqueMemory32.setByte(mem, 0, (byte) 0);
            OpaqueMemory32.setByte(mem, 15, (byte) 0);
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.setByte(mem, -11, (byte) 0);
            });
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory32.setByte(mem, 33, (byte) 0);
            });
        });
    }

    @Test
    public void testClear() throws Exception {
        OpaqueMemory32 mem = new OpaqueMemory32(1024, false);
        OpaqueMemory32.clear(mem);
        for (int i = 0; i < mem.sizeInBytes; i++) {
            Assertions.assertEquals(0, OpaqueMemory32.getByte(mem, i));
        }
    }

    @Test
    public void testSetMem() throws Exception {
        OpaqueMemory32 mem = new OpaqueMemory32(1024, true);
        OpaqueMemory32.memset(mem, (byte) 42);
        for (int i = 0; i < mem.sizeInBytes; i++) {
            Assertions.assertEquals(42, OpaqueMemory32.getByte(mem, i));
        }
    }

    private class TestMem extends OpaqueMemory32 {

        private TestMem(NativeAddressHolder baseAddress, int sizeInBytes) {
            super(baseAddress, sizeInBytes);
        }

    }

    @Test
    public void testEquals() throws Exception {
        OpaqueMemory32 mem = new TestMem(new NativeAddressHolder(0x2aL), 8);
        OpaqueMemory32 mem1 = new OpaqueMemory32(new NativeAddressHolder(42L), 8);
        OpaqueMemory32 mem2 = new OpaqueMemory32(mem, 0, 8);
        Assertions.assertEquals("{baseAddress : 0x0000002a, sizeInBytes : 8, memoryOwner : null}", mem.toString());
        Assertions.assertEquals("{baseAddress : 0x0000002a, sizeInBytes : 8, memoryOwner : null}", mem1.toString());
        Assertions.assertEquals("{baseAddress : 0x0000002a, sizeInBytes : 8, memoryOwner : {baseAddress : 0x0000002a, sizeInBytes : 8, memoryOwner : null}}", mem2.toString());
        Assertions.assertEquals(mem, mem1);
        Assertions.assertEquals(mem1, mem2);
        Assertions.assertEquals(mem, mem2);
        Assertions.assertEquals(mem.hashCode(), mem1.hashCode());
        Assertions.assertEquals(mem.hashCode(), mem2.hashCode());
        Assertions.assertEquals(mem1.hashCode(), mem2.hashCode());
    }

}
