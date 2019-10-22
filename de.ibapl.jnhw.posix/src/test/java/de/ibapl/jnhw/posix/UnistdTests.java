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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.ByteRef;
import java.nio.ByteBuffer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.OpaqueMemory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class UnistdTests {

    public final static byte[] TEST_DATA = new byte[1024];
    public final static int POS = 111;
    public final static int LEN = 239;
    
    byte[] writeBytes = "Hello world".getBytes();
    byte[] readBytes = new byte[1024];


    static {
        for (int i = 0; i < TEST_DATA.length; i++) {
            TEST_DATA[i] = (byte) i;
        }
    }

    private int fd;
    private File f;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        f = File.createTempFile("jnhw-test", "");
        f.deleteOnExit();
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDWR());

    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void test_HAVE_UNISTD_H() throws Exception {
        Assertions.assertTrue(Unistd.HAVE_UNISTD_H(), "expected to have unistd.h");
    }

    private void writeData() throws Exception {
        try (FileOutputStream fos = new FileOutputStream(f)) {
            fos.write(TEST_DATA, POS, LEN);
        }
    }

    public byte[] readData() throws Exception {
        byte[] result = new byte[TEST_DATA.length];
        int length = 0;
        try (FileInputStream fis = new FileInputStream(f)) {
            length = fis.read(result, POS, LEN);
        }
        Assertions.assertEquals(LEN, length);
        return result;
    }

    public void compareData(byte[] data) throws Exception {
        for (int i = 0; i < POS; i++) {
            Assertions.assertEquals(0, data[i]);
        }
        for (int i = POS; i < LEN; i++) {
            Assertions.assertEquals(TEST_DATA[i], data[i]);
        }
        for (int i = POS + LEN; i < data.length; i++) {
            Assertions.assertEquals(0, data[i]);
        }
    }

    @Test
    public void selfTest() throws Exception {
        writeData();
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testReadArrayBuffer() throws Exception {
        writeData();
        byte[] result = new byte[TEST_DATA.length];
        int read = Unistd.read(fd, result, POS, LEN);
        Assertions.assertEquals(LEN, read);
        compareData(result);
    }

    @Test
    public void testWriteArrayBuffer() throws Exception {
        Unistd.write(fd, TEST_DATA, POS, LEN);
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testReadArrayBufferCritical() throws Exception {
        writeData();
        byte[] result = new byte[TEST_DATA.length];
        int read = Unistd.JnhwPrimitiveArrayCritical.read(fd, result, POS, LEN);
        Assertions.assertEquals(LEN, read);
        compareData(result);
    }

    @Test
    public void testWriteArrayBufferCritical() throws Exception {
        Unistd.JnhwPrimitiveArrayCritical.write(fd, TEST_DATA, POS, LEN);
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testReadSingle() throws Exception {
        writeData();
        byte[] result = new byte[TEST_DATA.length];
        ByteRef byteRef = new ByteRef();
        for (int i = POS; i < POS + LEN; i++) {
            int read = Unistd.read(fd, byteRef);
            Assertions.assertEquals(1, read);
            result[i] = byteRef.value;
        }
        compareData(result);
    }

    @Test
    public void testWriteSingle() throws Exception {
        for (int i = POS; i < POS + LEN; i++) {
            int written = Unistd.write(fd, TEST_DATA[i]);
            Assertions.assertEquals(1, written);
        }
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testReadByteBuffer() throws Exception {
        writeData();
        ByteBuffer buff = ByteBuffer.allocateDirect(TEST_DATA.length);
        buff.position(POS);
        buff.limit(POS + LEN);
        int read = Unistd.read(fd, buff);
        Assertions.assertEquals(LEN, read);
        buff.position(0);
        buff.limit(TEST_DATA.length);
        byte[] result = new byte[TEST_DATA.length];
        buff.get(result);
        compareData(result);
    }

    @Test
    public void testWriteByteBuffer() throws Exception {
        ByteBuffer buff = ByteBuffer.allocateDirect(TEST_DATA.length);
        buff.put(TEST_DATA);
        buff.position(POS);
        buff.limit(POS + LEN);
        Unistd.write(fd, buff);
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testReadOpaqueMemory() throws Exception {
        writeData();
        OpaqueMemory om = new OpaqueMemory(1024, true);
        int read = Unistd.read(fd, om, POS, LEN);
        Assertions.assertEquals(LEN, read);
        byte[] result = new byte[TEST_DATA.length];
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());
        int written = Unistd.write(fd, om, POS, LEN);
        Assertions.assertEquals(LEN, written);
        // no access to Opaquememory so read it back for comparision
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testWriteOpaqueMemory() throws Exception {
        ByteBuffer buff = ByteBuffer.allocateDirect(1024);
        buff.put(TEST_DATA, POS, LEN);
        buff.flip();
        Unistd.write(fd, buff);
        byte[] data = readData();
        compareData(data);
    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadArrayBuffer10MB() throws Exception {
        byte[] buffer = new byte[10_000_000];
        int written = Unistd.write(fd, buffer);
        Assertions.assertEquals(buffer.length, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());
        int read = Unistd.read(fd, buffer);
        Assertions.assertEquals(buffer.length, read);
    }

    @Test
    public void testWriteReadArrayBufferPerformance() throws Exception {
        byte[] buffer = new byte[512];
        for (int i = 0; i < 100_000; i++) {
            int written = Unistd.write(fd, buffer);
            Assertions.assertEquals(buffer.length, written);
        }
    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadArrayBufferCritical10MB() throws Exception {
        File f = File.createTempFile("jnhw-test", "");
        f.deleteOnExit();
        int fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDWR());
        byte[] buffer = new byte[10_000_000];
        int written = Unistd.JnhwPrimitiveArrayCritical.write(fd, buffer);
        Assertions.assertEquals(buffer.length, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());
        int read = Unistd.JnhwPrimitiveArrayCritical.read(fd, buffer);
        Assertions.assertEquals(buffer.length, read);
    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadByteBuffer10MB() throws Exception {
        File f = File.createTempFile("jnhw-test", "");
        f.deleteOnExit();
        int fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDWR());
        ByteBuffer buffer = ByteBuffer.allocateDirect(10_000_000);
        buffer.position(0);
        buffer.limit(buffer.capacity());
        int written = Unistd.write(fd, buffer);
        Assertions.assertEquals(buffer.capacity(), written);
        Assertions.assertEquals(buffer.position(), written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());
        buffer.position(0);
        buffer.limit(buffer.capacity());
        int read = Unistd.read(fd, buffer);
        Assertions.assertEquals(buffer.capacity(), written);
        Assertions.assertEquals(buffer.position(), written);
    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadOpaqueMemory10MB() throws Exception {
        File f = File.createTempFile("jnhw-test", "");
        f.deleteOnExit();
        int fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDWR());
        OpaqueMemory mem = new OpaqueMemory(10_000_000, false);
        int written = Unistd.write(fd, mem);
        Assertions.assertEquals(mem.sizeInBytes, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDWR());
        int read = Unistd.read(fd, mem);
        Assertions.assertEquals(mem.sizeInBytes, written);
    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadByte10MB() throws Exception {
        File f = File.createTempFile("jnhw-test", "");
        f.deleteOnExit();
        int fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDWR());
        int written = 0;
        for (int i = 0; i < 1_000; i++) {
            written += Unistd.write(fd, (byte) 1);
        }
        Assertions.assertEquals(1_000, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());

        int read = 0;
        ByteRef byteRef = new ByteRef();
        for (int i = 0; i < 1_000; i++) {
            read += Unistd.read(fd, byteRef);
        }
        Assertions.assertEquals(1_000, read);
        read = Unistd.read(fd, byteRef);
        Assertions.assertEquals(0, read);

    }

    @Test
    public void testPipe() throws Exception {
        IntRef reaDFD = new IntRef();
        IntRef writeFD = new IntRef();
        Unistd.pipe(reaDFD, writeFD);
        int written = Unistd.write(writeFD.value, writeBytes);
        int read = Unistd.read(reaDFD.value, readBytes, 0, writeBytes.length);
        Assertions.assertEquals(writeBytes.length, written);
        Assertions.assertEquals(written, read);
        for (int i = 0; i < read; i++) {
            Assertions.assertEquals((char) writeBytes[i], (char) readBytes[i]);
        }
    }

    @Test
    public void testPipeWriteWrongArgs() throws Exception {
        IntRef readFD = new IntRef();
        IntRef writeFD = new IntRef();
        Assertions.assertThrows(NullPointerException.class, () -> {
            Unistd.pipe(null, writeFD);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Unistd.pipe(readFD, null);
        });
    }

    @Test
    public void testBufWriteWrongArgs() throws Exception {
        IntRef readFD = new IntRef();
        IntRef writeFD = new IntRef();

        Unistd.pipe(readFD, writeFD);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Unistd.write(writeFD.value, (byte[]) null);
        });

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Unistd.write(writeFD.value, new byte[8], 1, 10);
        });

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Unistd.write(writeFD.value, new byte[8], -3, 10);
        });

    }

    @Test
    public void testBufReadWrongArgs() throws Exception {
        IntRef readFD = new IntRef();
        IntRef writeFD = new IntRef();

        Unistd.pipe(readFD, writeFD);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Unistd.read(readFD.value, (byte[]) null);
        });

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Unistd.read(readFD.value, new byte[8], 1, 10);
        });

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            Unistd.read(readFD.value, new byte[8], -3, 10);
        });

    }

    @Test
    public void testPipeWithHeapBuffer() throws Exception {
        IntRef reaDFD = new IntRef();
        IntRef writeFD = new IntRef();
        Unistd.pipe(reaDFD, writeFD);
        ByteBuffer writeBuffer = ByteBuffer.allocate(this.writeBytes.length);
        writeBuffer.put(writeBytes);
        writeBuffer.flip();
        writeBuffer = writeBuffer.asReadOnlyBuffer();

        ByteBuffer readBuffer = ByteBuffer.allocate(this.writeBytes.length);

        int written = Unistd.write(writeFD.value, writeBuffer);
        int read = Unistd.read(reaDFD.value, readBuffer);
        Assertions.assertEquals(written, read);

        Assertions.assertEquals(writeBytes.length, writeBuffer.position());
        Assertions.assertEquals(writeBytes.length, readBuffer.position());
        readBuffer.flip();
        readBuffer.get(readBytes, 0, writeBytes.length);

        for (int i = 0; i < read; i++) {
            Assertions.assertEquals((char) writeBytes[i], (char) readBytes[i]);
        }
    }

}
