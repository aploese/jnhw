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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.ByteRef;
import de.ibapl.jnhw.Defined;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.NoSuchNativeMethodException;
import de.ibapl.jnhw.OpaqueMemory32;
import de.ibapl.jnhw.OpaqueMemory64;
import de.ibapl.jnhw.posix.sys.Stat;
import de.ibapl.jnhw.util.posix.Defines;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class UnistdTest {

    public final static int LEN = 239;
    public final static int POS = 111;
    public final static byte[] TEST_DATA = new byte[1024];
    private static File f;

    static {
        for (int i = 0; i < TEST_DATA.length; i++) {
            TEST_DATA[i] = (byte) i;
        }
    }

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        f = File.createTempFile("jnhw-test", "");
        f.delete();
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }
    private int fd;
    byte[] readBytes = new byte[1024];
    byte[] writeBytes = "Hello world".getBytes();

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

    public byte[] readData() throws Exception {
        byte[] result = new byte[TEST_DATA.length];
        int length = 0;
        try (FileInputStream fis = new FileInputStream(f.getAbsoluteFile())) {
            length = fis.read(result, POS, LEN);
        }
        Assertions.assertEquals(LEN, length);
        return result;
    }

    @Test
    public void selfTest() throws Exception {
        writeData();
        byte[] data = readData();
        compareData(data);
    }

    @BeforeEach
    public void setUp() throws Exception {
        fd = -1;
    }

    @AfterEach
    public void tearDown() throws Exception {
        f.delete();
        if (fd != -1) {
            Unistd.close(fd);
        }
    }

    @Test
    public void test64() throws Exception {
        final long SEEK_TO = 1L + Integer.MAX_VALUE;
        if (Defined.defined(Defines::_LARGEFILE64_SOURCE)) {
            f.delete();

            long seekResult;

            fd = Fcntl.creat64(f.getAbsolutePath(), Stat.S_IRUSR() | Stat.S_IWUSR());

            seekResult = Unistd.lseek64(fd, SEEK_TO, Unistd.SEEK_SET());
            Assertions.assertEquals(SEEK_TO, seekResult, "result of seek");
            Unistd.close(fd);
            f.delete();

            fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_LARGEFILE() | Fcntl.O_RDWR(), Stat.S_IRUSR() | Stat.S_IWUSR());
            seekResult = Unistd.lseek64(fd, SEEK_TO, Unistd.SEEK_SET());
            Assertions.assertEquals(SEEK_TO, seekResult, "result of seek");
            Unistd.close(fd);

            fd = Fcntl.open64(f.getAbsolutePath(), Fcntl.O_RDWR());
            seekResult = Unistd.lseek64(fd, SEEK_TO, Unistd.SEEK_SET());
            Assertions.assertEquals(SEEK_TO, seekResult, "result of seek");
        } else {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Unistd.lseek64(-1, 1, Unistd.SEEK_SET());
            });
        }
    }

    @Test
    public void testBufReadWrongArgs() throws Exception {
        IntRef readFD = new IntRef();
        IntRef writeFD = new IntRef();

        Unistd.pipe(readFD, writeFD);
        try {
            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.read(readFD.value, (byte[]) null);
            });

            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.read(readFD.value, (byte[]) null, 0, 1);
            });

            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                Unistd.read(readFD.value, new byte[8], 1, 10);
            });

            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                Unistd.read(readFD.value, new byte[8], -3, 10);
            });
        } finally {
            Unistd.close(readFD.value);
            Unistd.close(writeFD.value);
        }

    }

    @Test
    public void testBufWriteWrongArgs() throws Exception {
        IntRef readFD = new IntRef();
        IntRef writeFD = new IntRef();

        Unistd.pipe(readFD, writeFD);
        try {
            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.write(writeFD.value, (byte[]) null);
            });

            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.write(writeFD.value, (byte[]) null, 0, 1);
            });

            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                Unistd.write(writeFD.value, new byte[8], 1, 10);
            });

            Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                Unistd.write(writeFD.value, new byte[8], -3, 10);
            });
        } finally {
            Unistd.close(readFD.value);
            Unistd.close(writeFD.value);
        }

    }

    @Test
    public void testGetegid() throws Exception {
        System.out.println("getegid");
        int egid = Unistd.getegid();
    }

    @Test
    public void testGeteuid() throws Exception {
        System.out.println("geteuid");
        int euid = Unistd.geteuid();
    }

    @Test
    public void testGetgid() throws Exception {
        System.out.println("getgid");
        int gid = Unistd.getgid();
    }

    @Test
    public void testGetpid() throws Exception {
        System.out.println("getpid");
        int pid = Unistd.getpid();
    }

    @Test
    public void testGetppid() throws Exception {
        System.out.println("getppid");
        int ppid = Unistd.getppid();
    }

    @Test
    public void testGetuid() throws Exception {
        System.out.println("getuid");
        int uid = Unistd.getuid();
    }

    @Test
    public void testLseek() throws Exception {
        if (Defines.__SIZEOF_LONG__() == 4) {
            IndexOutOfBoundsException ioobe = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                Unistd.lseek(-1, 1L + Integer.MAX_VALUE, Unistd.SEEK_SET());
            });
        } else if (Defines.__SIZEOF_LONG__() == 8) {
            NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                Unistd.lseek(-1, 1L + Integer.MAX_VALUE, Unistd.SEEK_SET());
            });
            Assertions.assertEquals(Errno.EBADF(), nee.errno, "-1 is not a valid FD so EBADF is expected");
        }
    }

    @Test
    public void testPipe() throws Exception {
        IntRef reaDFD = new IntRef();
        IntRef writeFD = new IntRef();
        Unistd.pipe(reaDFD, writeFD);
        try {
            int written = Unistd.write(writeFD.value, writeBytes);
            int read = Unistd.read(reaDFD.value, readBytes, 0, writeBytes.length);
            Assertions.assertEquals(writeBytes.length, written);
            Assertions.assertEquals(written, read);
            for (int i = 0; i < read; i++) {
                Assertions.assertEquals((char) writeBytes[i], (char) readBytes[i]);
            }
        } finally {
            Unistd.close(reaDFD.value);
            Unistd.close(writeFD.value);
        }
    }

    //TODO JDK > 13  will support slice(pos, lim) so we could refert to 
    // ByteBuffer writeBuffer = ByteBuffer.wrap(this.writeBytes).slice(WRITE_OFFSET, BYTES_TO_WRITE);
    // ByteBuffer readBuffer = ByteBuffer.wrap(readBackingArray).slice(READ_OFFSET, BYTES_TO_WRITE);
    @Test
    public void testPipeWithHeapBufferOffset() throws Exception {
        IntRef readFD = new IntRef();
        IntRef writeFD = new IntRef();
        Unistd.pipe(readFD, writeFD);
        try {
            final int BYTES_TO_WRITE = 4;
            final int WRITE_OFFSET = 2;
            final int READ_OFFSET = 10;
            
            ByteBuffer writeBuffer = ByteBuffer.wrap(this.writeBytes);
            writeBuffer.position(WRITE_OFFSET);
            writeBuffer = writeBuffer.slice();
            writeBuffer.limit(BYTES_TO_WRITE);
            
            byte[] readBackingArray = new byte[READ_OFFSET + BYTES_TO_WRITE];


            ByteBuffer readBuffer = ByteBuffer.wrap(readBackingArray);
            readBuffer.position(READ_OFFSET);
            readBuffer = readBuffer.slice();
            readBuffer.limit(BYTES_TO_WRITE);
            
            int written = Unistd.write(writeFD.value, writeBuffer);

            int read = Unistd.read(readFD.value, readBuffer);
            Assertions.assertEquals(written, read);

            Assertions.assertEquals(BYTES_TO_WRITE, writeBuffer.position());
            Assertions.assertEquals(BYTES_TO_WRITE, readBuffer.position());
            readBuffer.flip();
            readBuffer.get(readBytes, 0, BYTES_TO_WRITE);

            for (int i = 0; i < read; i++) {
                Assertions.assertEquals((char) writeBytes[WRITE_OFFSET + i], (char) readBytes[i]);
                Assertions.assertEquals((char) writeBytes[WRITE_OFFSET + i], (char) readBackingArray[i + READ_OFFSET]);
            }
        } finally {
            Unistd.close(readFD.value);
            Unistd.close(writeFD.value);
        }
    }

    @Test
    public void testPipeWithReadOnlyBuffer() throws Exception {
        final IntRef readFD = new IntRef();
        final IntRef writeFD = new IntRef();
        Unistd.pipe(readFD, writeFD);
        try {
            final ByteBuffer writeBuffer = ByteBuffer.wrap(this.writeBytes).asReadOnlyBuffer();

            final ByteBuffer readBuffer = ByteBuffer.allocate(this.writeBytes.length).asReadOnlyBuffer();

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Unistd.write(writeFD.value, writeBuffer);
            });
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                int read = Unistd.read(readFD.value, readBuffer);
            });
        } finally {
            Unistd.close(readFD.value);
            Unistd.close(writeFD.value);
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
    public void testReadArrayBuffer() throws Exception {
        writeData();
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY());
        byte[] result = new byte[TEST_DATA.length];
        int read = Unistd.read(fd, result, POS, LEN);
        Assertions.assertEquals(LEN, read);
        compareData(result);
    }

    @Test
    public void testReadArrayBufferCritical() throws Exception {
        writeData();
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY());
        byte[] result = new byte[TEST_DATA.length];
        int read = Unistd.JnhwPrimitiveArrayCritical.read(fd, result, POS, LEN);
        Assertions.assertEquals(LEN, read);
        compareData(result);
    }

    @Test
    public void testReadByteBuffer() throws Exception {
        writeData();
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY());
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
    public void testReadOpaqueMemory() throws Exception {
        writeData();
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY());
        OpaqueMemory32 om = new OpaqueMemory32(TEST_DATA.length, true);
        long read = Unistd.read(fd, om, POS, LEN);
        Assertions.assertEquals(LEN, read);
        byte[] result = OpaqueMemory32.toBytes(om);
        compareData(result);
    }

    @Test
    public void testReadSingle() throws Exception {
        writeData();
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY());
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
    public void testWriteArrayBuffer() throws Exception {
        fd = Fcntl.creat(f.getAbsolutePath(), Stat.S_IRUSR() | Stat.S_IWUSR());
        Unistd.write(fd, TEST_DATA, POS, LEN);
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testWriteArrayBufferCritical() throws Exception {
        fd = Fcntl.creat(f.getAbsolutePath(), Stat.S_IRUSR() | Stat.S_IWUSR());
        Unistd.JnhwPrimitiveArrayCritical.write(fd, TEST_DATA, POS, LEN);
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testWriteByteBuffer() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_WRONLY(), Stat.S_IRUSR() | Stat.S_IWUSR());
        ByteBuffer buff = ByteBuffer.allocateDirect(TEST_DATA.length);
        buff.put(TEST_DATA);
        buff.position(POS);
        buff.limit(POS + LEN);
        Unistd.write(fd, buff);
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testWriteOpaqueMemory32() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_WRONLY(), Stat.S_IRUSR() | Stat.S_IWUSR());
        OpaqueMemory32 om = new OpaqueMemory32(TEST_DATA.length, true);
        OpaqueMemory32.copy(TEST_DATA, 0, om, 0, TEST_DATA.length);
        Unistd.write(fd, om, POS, LEN);
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testWriteOpaqueMemory64() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_WRONLY(), Stat.S_IRUSR() | Stat.S_IWUSR());
        OpaqueMemory64 om = new OpaqueMemory64(TEST_DATA.length, true);
        OpaqueMemory64.copy(TEST_DATA, 0, om, 0, TEST_DATA.length);
        Unistd.write(fd, om, POS, LEN);
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
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_RDWR(), Stat.S_IRUSR() | Stat.S_IWUSR());
        byte[] buffer = new byte[10_000_000];
        int written = Unistd.write(fd, buffer);
        Assertions.assertEquals(buffer.length, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());
        int read = Unistd.read(fd, buffer);
        Assertions.assertEquals(buffer.length, read);
    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadArrayBufferCritical10MB() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_RDWR());
        byte[] buffer = new byte[10_000_000];
        int written = Unistd.JnhwPrimitiveArrayCritical.write(fd, buffer);
        Assertions.assertEquals(buffer.length, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());
        int read = Unistd.JnhwPrimitiveArrayCritical.read(fd, buffer);
        Assertions.assertEquals(buffer.length, read);
    }

    @Test
    public void testWriteReadArrayBufferPerformance() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_RDWR());
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
    public void testWriteReadByteRef10MB() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_RDWR());
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
            Assertions.assertEquals(1, byteRef.value);
        }
        Assertions.assertEquals(1_000, read);
        read = Unistd.read(fd, byteRef);
        Assertions.assertEquals(0, read);

    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadByte10MB() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_RDWR());
        int written = 0;
        for (int i = 0; i < 1_000; i++) {
            written += Unistd.write(fd, (byte) 1);
        }
        Assertions.assertEquals(1_000, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());

        int read = 0;
        for (int i = 0; i < 1_000; i++) {
            short result = Unistd.read(fd);
            read += Unistd.jnhwIsSingeByteRead(result) ? 1 : 0;
            Assertions.assertEquals(1, Unistd.jnhwSingeByteReadToByte(result));
        }
        Assertions.assertEquals(1_000, read);
        read = Unistd.read(fd);
        Assertions.assertFalse(Unistd.jnhwIsSingeByteRead((short) read)); //OK we read nothing and size is 0 too.

    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadByteBuffer10MB() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_RDWR());
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
        Assertions.assertEquals(buffer.capacity(), read);
        Assertions.assertEquals(buffer.position(), read);
    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadOpaqueMemory32_10MB() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_RDWR());
        OpaqueMemory32 mem = new OpaqueMemory32(10_000_000, false);
        long written = Unistd.write(fd, mem);
        Assertions.assertEquals(mem.sizeInBytes, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());
        long read = Unistd.read(fd, mem);
        Assertions.assertEquals(mem.sizeInBytes, read);
    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadOpaqueMemory64_10MB() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT() | Fcntl.O_RDWR());
        OpaqueMemory64 mem = new OpaqueMemory64(10_000_000, false);
        long written = Unistd.write(fd, mem);
        Assertions.assertEquals(mem.sizeInBytes, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET());
        long read = Unistd.read(fd, mem);
        Assertions.assertEquals(mem.sizeInBytes, read);
    }

    @Test
    public void testWriteSingle() throws Exception {
        fd = Fcntl.creat(f.getAbsolutePath(), Stat.S_IRUSR() | Stat.S_IWUSR());
        for (int i = POS; i < POS + LEN; i++) {
            int written = Unistd.write(fd, TEST_DATA[i]);
            Assertions.assertEquals(1, written);
        }
        byte[] data = readData();
        compareData(data);
    }

    private void writeData() throws Exception {
        try (FileOutputStream fos = new FileOutputStream(f.getAbsoluteFile())) {
            fos.write(TEST_DATA, POS, LEN);
        }
    }

}
