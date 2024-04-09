/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2022-2024, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.test.JnhwTestLogger;
import de.ibapl.jnhw.common.test.memory.layout.S_i8_i64OnTheFlyImpl;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.SizeInBit;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class OpaqueMemoryTest {

    @BeforeAll
    public static void setUpBeforeClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeAll(testTnfo);
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    @BeforeEach
    public void setUpBeforeEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testTnfo);
    }

    @AfterEach
    public void tearDownAfterEach(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterEach(testTnfo);
    }

    private static class MemToTest extends OpaqueMemory {

        MemToTest(int sizeInBytes, Arena arena) {
            super(arena.allocate(sizeInBytes), 0, sizeInBytes);
        }

        private MemToTest(MemorySegment memorySegment) {
            super(memorySegment, 0, memorySegment.byteSize());
        }

        @Override
        public BaseDataType getBaseDataType() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String nativeToHexString() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    @Test
    public void testAllocateDirtyMem() throws Exception {
        try (Arena arena = Arena.ofConfined()) {
            OpaqueMemory mem = new MemToTest(1024, arena);
            Assertions.assertEquals(1024, mem.sizeof());
        }
        System.gc();
        Thread.sleep(1000);
        System.gc();
    }

    @Test
    public void testAllocateCleanMem() throws Exception {
        try (Arena arena = Arena.ofConfined()) {
            OpaqueMemory mem = new MemToTest(1024, arena);
            Assertions.assertEquals(1024, mem.sizeof());
        }
        System.gc();
        Thread.sleep(1000);
        System.gc();
    }

    private final static byte[] HELLO_WORLD = "Hello World!".getBytes();

    @Test
    public void testCopy() throws Exception {
        try (Arena arena = Arena.ofConfined()) {
            OpaqueMemory mem = new MemToTest(1024, arena);
            final int MEM_POS = 753;
            OpaqueMemory.copy(HELLO_WORLD, 0, mem, MEM_POS, HELLO_WORLD.length);
            byte[] received = new byte[HELLO_WORLD.length];
            OpaqueMemory.copy(mem, MEM_POS, received, 0, received.length);
            Assertions.assertArrayEquals(HELLO_WORLD, received);
        }
    }

    @Test
    public void testCopyIndex() throws Exception {
        try (Arena arena = Arena.ofConfined()) {
            final byte[] array = new byte[16];
            final OpaqueMemory mem = new MemToTest(array.length, arena);
            Assertions.assertAll(() -> {
                //exact fit
                OpaqueMemory.copy(mem, 0, array, 0, array.length);
            }, () -> {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                    OpaqueMemory.copy(mem, -1, array, 0, 1);
                }, "srcPos == -1");
            }, () -> {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                    OpaqueMemory.copy(mem, 22, array, 0, 1);
                }, "srcPos > src.sizeInBytes");
            }, () -> {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                    OpaqueMemory.copy(mem, 8, array, 0, 16);
                }, "srcPos + len > src.sizeInBytes");
            }, () -> {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                    OpaqueMemory.copy(mem, 0, array, -1, 1);
                }, "destPos == -1");
            }, () -> {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                    OpaqueMemory.copy(mem, 0, array, 22, 1);
                }, "Srcmem start outside destarray");
            }, () -> {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                    OpaqueMemory.copy(mem, 0, array, 8, 16);
                }, "Srcmem end outside destarray");
            }, () -> {
                //exact fit
                if (mem.sizeof() <= Integer.MAX_VALUE) {
                    OpaqueMemory.copy(array, 0, mem, 0, (int) mem.sizeof());
                } else {
                    throw new RuntimeException("Cant execute test because mem.sizeInBytes > Integer.MAX_VALUE");
                }
            }, () -> {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                    OpaqueMemory.copy(array, -1, mem, 0, 1);
                }, "Destmem start outside srcarray");
            }, () -> {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                    OpaqueMemory.copy(array, 22, mem, 0, 1);
                }, "Destmem start outside srcarray");
            }, () -> {
                Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
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
    }

    @Test
    public void testGetSetByte() throws Exception {
        try (Arena arena = Arena.ofConfined()) {
            OpaqueMemory mem = new MemToTest(1024, arena);
            OpaqueMemory.setByte(mem, 67, (byte) 9);
            Assertions.assertEquals((byte) 9, OpaqueMemory.getByte(mem, 67));
        }
    }

    @Test
    public void testSetGetIndex() throws Exception {
        try (Arena arena = Arena.ofConfined()) {
            final OpaqueMemory mem = new MemToTest(16, arena);
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
    }

    @Test
    public void testClear() throws Exception {
        try (Arena arena = Arena.ofConfined()) {
            OpaqueMemory mem = new MemToTest(1024, arena);
            OpaqueMemory.clear(mem);
            for (int i = 0; i < mem.sizeof(); i++) {
                Assertions.assertEquals(0, OpaqueMemory.getByte(mem, i));
            }
        }
    }

    @Test
    public void testSetMem() throws Exception {
        try (Arena arena = Arena.ofConfined()) {
            OpaqueMemory mem = new MemToTest(1024, arena);
            OpaqueMemory.memset(mem, (byte) 42);
            for (int i = 0; i < mem.sizeof(); i++) {
                Assertions.assertEquals(42, OpaqueMemory.getByte(mem, i));
            }
        }
    }

    @Test
    public void testEquals() throws Exception {
        try (Arena arena = Arena.ofConfined()) {
            OpaqueMemory mem = new MemToTest(MemorySegment.ofAddress(0x2aL).reinterpret(8, arena, null));
            OpaqueMemory mem1 = new MemToTest(MemorySegment.ofAddress(42L).reinterpret(8, arena, null));
            OpaqueMemory mem2 = new MemToTest(OpaqueMemory.getMemorySegment(mem));
            switch (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer) {
                case _32_BIT -> {
                    Assertions.assertEquals("{baseAddress : 0x0000002a, sizeof : 8}", mem.toString());
                    Assertions.assertEquals("{baseAddress : 0x0000002a, sizeof : 8}", mem1.toString());
                    Assertions.assertEquals("{baseAddress : 0x0000002a, sizeof : 8}", mem2.toString());
                }
                case _64_BIT -> {
                    Assertions.assertEquals("{baseAddress : 0x000000000000002a, sizeof : 8}", mem.toString());
                    Assertions.assertEquals("{baseAddress : 0x000000000000002a, sizeof : 8}", mem1.toString());
                    Assertions.assertEquals("{baseAddress : 0x000000000000002a, sizeof : 8}", mem2.toString());
                }
                default ->
                    throw new RuntimeException();
            }
            Assertions.assertEquals(mem, mem1);
            Assertions.assertEquals(mem1, mem2);
            Assertions.assertEquals(mem, mem2);
            Assertions.assertEquals(mem.hashCode(), mem1.hashCode());
            Assertions.assertEquals(mem.hashCode(), mem2.hashCode());
            Assertions.assertEquals(mem1.hashCode(), mem2.hashCode());
        }
    }

    @Test
    public void testAddressOn32BitNotNegative() {
        try (Arena arena = Arena.ofConfined()) {
            MemToTest parent = new MemToTest(48, arena);
            if (MultiarchTupelBuilder.getMemoryModel().sizeOf_pointer == SizeInBit._32_BIT) {
                Assertions.assertTrue(parent.toAddress() > 0, "baseaddress must not be negative");
            }
        }
    }

    @Test
    public void testCalcNextOffset() {
        try (Arena arena = Arena.ofConfined()) {
            S_i8_i64OnTheFlyImpl struct = new S_i8_i64OnTheFlyImpl(arena.allocate(56), 0, 56);

            Assertions.assertEquals(0, OpaqueMemory.offsetof(struct, struct._0_i8));
            struct._0_i8((byte) 0x11);

            Assertions.assertEquals(2, OpaqueMemory.offsetof(struct, struct._1_i16));
            struct._1_i16((short) 0x2222);

            Assertions.assertEquals(4, OpaqueMemory.offsetof(struct, struct._2_i8));
            struct._2_i8((byte) 0x33);

            Assertions.assertEquals(8, OpaqueMemory.offsetof(struct, struct._3_i32));
            struct._3_i32(0x44444444);

            Assertions.assertEquals(12, OpaqueMemory.offsetof(struct, struct._4_i8));
            struct._4_i8((byte) 0x55);

            Assertions.assertEquals(16, OpaqueMemory.offsetof(struct, struct._5_i64));
            struct._5_i64(0x6666666666666666L);

            Assertions.assertEquals(24, OpaqueMemory.offsetof(struct, struct._6_i8));
            struct._6_i8((byte) 0x77);

            switch (MultiarchTupelBuilder.getArch()) {
                case I386 -> {
                    //int64_t is aligned at 4
                    Assertions.assertEquals(28, OpaqueMemory.offsetof(struct, struct._7_i64));
                    struct._7_i64(0x8888888888888888L);

                    Assertions.assertEquals(36, OpaqueMemory.offsetof(struct, struct._8_i8));
                    struct._8_i8((byte) 0x88);

                    Assertions.assertEquals(40, OpaqueMemory.offsetof(struct, struct._9_i32));
                    struct._9_i32(0x55555555);

                    Assertions.assertEquals(44, OpaqueMemory.offsetof(struct, struct._10_i8));
                    struct._10_i8((byte) 0x99);

                    Assertions.assertEquals(46, OpaqueMemory.offsetof(struct, struct._11_i16));
                    struct._11_i16((short) 0xAAAA);

                    Assertions.assertEquals(48, OpaqueMemory.offsetof(struct, struct._12_i8));
                    struct._12_i8((byte) 0xBB);
                }
                default -> {
                    Assertions.assertEquals(32, OpaqueMemory.offsetof(struct, struct._7_i64));
                    struct._7_i64(0x8888888888888888L);

                    Assertions.assertEquals(40, OpaqueMemory.offsetof(struct, struct._8_i8));
                    struct._8_i8((byte) 0x88);

                    Assertions.assertEquals(44, OpaqueMemory.offsetof(struct, struct._9_i32));
                    struct._9_i32(0x55555555);

                    Assertions.assertEquals(48, OpaqueMemory.offsetof(struct, struct._10_i8));
                    struct._10_i8((byte) 0x99);

                    Assertions.assertEquals(50, OpaqueMemory.offsetof(struct, struct._11_i16));
                    struct._11_i16((short) 0xAAAA);

                    Assertions.assertEquals(52, OpaqueMemory.offsetof(struct, struct._12_i8));
                    struct._12_i8((byte) 0xBB);
                    Assertions.assertEquals(56, struct.sizeof);
                }
            }
            String expected = null;
            switch (MultiarchTupelBuilder.getArch()) {
                case I386 -> {
                    Assertions.assertEquals(52, struct.sizeof);
                    Assertions.assertEquals(Alignment.AT_4, struct.alignment);
                    expected = """
                                                   11002222 33000000  44444444 55000000 | \u0011\u0000\u0022\u0022\u0033\u0000\u0000\u0000\u0044\u0044\u0044\u0044\u0055\u0000\u0000\u0000
                                                   66666666 66666666  77000000 88888888 | \u0066\u0066\u0066\u0066\u0066\u0066\u0066\u0066\u0077\u0000\u0000\u0000\u0088\u0088\u0088\u0088
                                                   88888888 88000000  55555555 9900aaaa | \u0088\u0088\u0088\u0088\u0088\u0000\u0000\u0000\u0055\u0055\u0055\u0055\u0099\u0000\u00aa\u00aa
                                                   bb000000 00000000  00000000 00000000 | \u00bb\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000""";
                }
                default -> {
                    Assertions.assertEquals(56, struct.sizeof);
                    Assertions.assertEquals(Alignment.AT_8, struct.alignment);
                    expected = """
                                                   11002222 33000000  44444444 55000000 | \u0011\u0000\u0022\u0022\u0033\u0000\u0000\u0000\u0044\u0044\u0044\u0044\u0055\u0000\u0000\u0000
                                                   66666666 66666666  77000000 00000000 | \u0066\u0066\u0066\u0066\u0066\u0066\u0066\u0066\u0077\u0000\u0000\u0000\u0000\u0000\u0000\u0000
                                                   88888888 88888888  88000000 55555555 | \u0088\u0088\u0088\u0088\u0088\u0088\u0088\u0088\u0088\u0000\u0000\u0000\u0055\u0055\u0055\u0055
                                                   9900aaaa bb000000  00000000 00000000 | \u0099\u0000\u00aa\u00aa\u00bb\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000""";
                }
            }

            Assertions.assertEquals(expected, OpaqueMemory.printMemory(struct, false));
            byte[] result = OpaqueMemory.toBytes(struct);

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

            switch (MultiarchTupelBuilder.getArch()) {
                case I386 -> {
                    Assertions.assertEquals((byte) 0x88, result[28]);
                    Assertions.assertEquals((byte) 0x88, result[29]);
                    Assertions.assertEquals((byte) 0x88, result[30]);
                    Assertions.assertEquals((byte) 0x88, result[31]);

                    Assertions.assertEquals((byte) 0x88, result[32]);
                    Assertions.assertEquals((byte) 0x88, result[33]);
                    Assertions.assertEquals((byte) 0x88, result[34]);
                    Assertions.assertEquals((byte) 0x88, result[35]);

                    Assertions.assertEquals((byte) 0x88, result[36]);
                    Assertions.assertEquals(0x00, result[37]);
                    Assertions.assertEquals(0x00, result[38]);
                    Assertions.assertEquals(0x00, result[39]);

                    Assertions.assertEquals((byte) 0x55, result[40]);
                    Assertions.assertEquals((byte) 0x55, result[41]);
                    Assertions.assertEquals((byte) 0x55, result[42]);
                    Assertions.assertEquals((byte) 0x55, result[43]);

                    Assertions.assertEquals((byte) 0x99, result[44]);
                    Assertions.assertEquals(0x00, result[45]);
                    Assertions.assertEquals((byte) 0xaa, result[46]);
                    Assertions.assertEquals((byte) 0xaa, result[47]);

                    Assertions.assertEquals((byte) 0xbb, result[48]);
                    Assertions.assertEquals(0x00, result[49]);
                    Assertions.assertEquals(0x00, result[50]);
                    Assertions.assertEquals(0x00, result[51]);

                }
                default -> {
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

                    Assertions.assertEquals((byte) 0x88, result[40]);
                    Assertions.assertEquals(0x00, result[41]);
                    Assertions.assertEquals(0x00, result[42]);
                    Assertions.assertEquals(0x00, result[43]);

                    Assertions.assertEquals((byte) 0x55, result[44]);
                    Assertions.assertEquals((byte) 0x55, result[45]);
                    Assertions.assertEquals((byte) 0x55, result[46]);
                    Assertions.assertEquals((byte) 0x55, result[47]);

                    Assertions.assertEquals((byte) 0x99, result[48]);
                    Assertions.assertEquals(0x00, result[49]);
                    Assertions.assertEquals((byte) 0xaa, result[50]);
                    Assertions.assertEquals((byte) 0xaa, result[51]);

                    Assertions.assertEquals((byte) 0xbb, result[52]);
                    Assertions.assertEquals(0x00, result[53]);
                    Assertions.assertEquals(0x00, result[54]);
                    Assertions.assertEquals(0x00, result[55]);
                }
            }
        }
    }

    @Test
    public void testNULLinConstructor() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new OpaqueMemory(MemorySegment.NULL, 0, 0) {
            @Override
            public BaseDataType getBaseDataType() {
                throw new RuntimeException();
            }
        });

        Assertions.assertThrows(NullPointerException.class,
                () -> new OpaqueMemory(0, Arena.global(), 0) {
            @Override
            public BaseDataType getBaseDataType() {
                throw new RuntimeException();
            }
        });
    }

}
