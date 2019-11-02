/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OpaqueMemoryTests {

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testAllocateMem() throws Exception {
        OpaqueMemory mem = new OpaqueMemory(1024, false);
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
        OpaqueMemory mem = new OpaqueMemory(1024, false);
        final int MEM_POS = 753;
        OpaqueMemory.copy(HELLO_WORLD, 0, mem, MEM_POS, HELLO_WORLD.length);
        byte[] received = new byte[HELLO_WORLD.length];
        OpaqueMemory.copy(mem, MEM_POS, received, 0, received.length);
        Assertions.assertArrayEquals(HELLO_WORLD, received);
    }

    @Test
    public void testCopyIndex() throws Exception {
        final OpaqueMemory mem = new OpaqueMemory(16, false);
        final byte[] array = new byte[16];
        Assertions.assertAll(() -> {
            //exact fit
            OpaqueMemory.copy(mem, 0, array, 0, array.length);
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(mem, -1, array, 0, 1);
            }, "Destarray start outside srcmem");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(mem, 22, array, 0, 1);
            }, "Destarray start outside srcmem");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(mem, 8, array, 0, 16);
            }, "Destarray end outside srcmem");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(mem, 0, array, -1, 1);
            }, "Srcmem start outside destarray");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(mem, 0, array, 22, 1);
            }, "Srcmem start outside destarray");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(mem, 0, array, 8, 16);
            }, "Srcmem end outside destarray");
        }, () -> {
            //exact fit    
            OpaqueMemory.copy(array, 0, mem, 0, mem.sizeInBytes);
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(array, -1, mem, 0, 1);
            }, "Destmem start outside srcarray");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(array, 22, mem, 0, 1);
            }, "Destmem start outside srcarray");
        }, () -> {
            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(array, 8, mem, 0, 16);
            }, "Destmem end outside srcarray");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(array, 0, mem, -1, 1);
            }, "Srcarray start outside destmem");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(array, 0, mem, 22, 1);
            }, "Srcarray start outside destmem");
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory.copy(array, 0, mem, 8, 16);
            }, "Srcarray end outside destmem");
        });
    }

    @Test
    public void testGetSetByte() throws Exception {
        OpaqueMemory mem = new OpaqueMemory(1024, false);
        OpaqueMemory.setByte(mem, 67, (byte) 9);
        Assertions.assertEquals((byte) 9, OpaqueMemory.getByte(mem, 67));
    }

    @Test
    public void testSetGetIndex() throws Exception {
        final OpaqueMemory mem = new OpaqueMemory(16, false);
        Assertions.assertAll(() -> {
            //Exact fit
            OpaqueMemory.getByte(mem, 0);
            OpaqueMemory.getByte(mem, 15);
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory.getByte(mem, -1);
            });
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory.getByte(mem, 22);
            });
        }, () -> {
            //Exact fit
            OpaqueMemory.setByte(mem, 0, (byte) 0);
            OpaqueMemory.setByte(mem, 15, (byte) 0);
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory.setByte(mem, -11, (byte) 0);
            });
        }, () -> {
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                OpaqueMemory.setByte(mem, 33, (byte) 0);
            });
        });
    }

    @Test
    public void testClear() throws Exception {
        OpaqueMemory mem = new OpaqueMemory(1024, false);
        OpaqueMemory.clear(mem);
        for (int i = 0; i < mem.sizeInBytes; i++) {
            Assertions.assertEquals(0, OpaqueMemory.getByte(mem, i));
        }
    }

    @Test
    public void testSetMem() throws Exception {
        OpaqueMemory mem = new OpaqueMemory(1024, true);
        OpaqueMemory.memset(mem, (byte) 42);
        for (int i = 0; i < mem.sizeInBytes; i++) {
            Assertions.assertEquals(42, OpaqueMemory.getByte(mem, i));
        }
    }
}
