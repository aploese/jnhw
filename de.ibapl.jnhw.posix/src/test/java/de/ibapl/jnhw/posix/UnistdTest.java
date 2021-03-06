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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.Memory64Heap;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.OpaqueMemory64;
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
import de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.DefinesTest;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class UnistdTest {

    public static class NativeDefines {

        public final static native boolean HAVE_UNISTD_H();

        public final static native long _POSIX_VERSION();

        public final static native int _SC_AIO_LISTIO_MAX();

        public final static native int _SC_AIO_MAX();

        public final static native int _SC_AIO_PRIO_DELTA_MAX();

        public final static native int SEEK_CUR();

        public final static native Integer SEEK_DATA();

        public final static native int SEEK_END();

        public final static native Integer SEEK_HOLE();

        public final static native int SEEK_SET();

        public final static native int STDERR_FILENO();

        public final static native int STDIN_FILENO();

        public final static native int STDOUT_FILENO();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

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

    @BeforeAll
    public static void checkBeforeAll_HAVE_UNISTD_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Unistd.HAVE_UNISTD_H, "not expected to have unistd.h");
        } else {
            Assertions.assertTrue(Unistd.HAVE_UNISTD_H, "expected to have unistd.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_UnistdDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Unistd.class, NativeDefines.class, "HAVE_UNISTD_H");
    }

    @Test
    public void test64() throws Exception {
        final long SEEK_TO = 1L + Integer.MAX_VALUE;
        if (Defines._LARGEFILE64_SOURCE.isDefined()) {
            f.delete();

            long seekResult;

            fd = Fcntl.creat64(f.getAbsolutePath(), Stat.S_IRUSR | Stat.S_IWUSR);

            seekResult = Unistd.lseek64(fd, SEEK_TO, Unistd.SEEK_SET);
            Assertions.assertEquals(SEEK_TO, seekResult, "result of seek");
            Unistd.close(fd);
            f.delete();

            fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_LARGEFILE.get() | Fcntl.O_RDWR, Stat.S_IRUSR | Stat.S_IWUSR);
            seekResult = Unistd.lseek64(fd, SEEK_TO, Unistd.SEEK_SET);
            Assertions.assertEquals(SEEK_TO, seekResult, "result of seek");
            Unistd.close(fd);

            fd = Fcntl.open64(f.getAbsolutePath(), Fcntl.O_RDWR);
            seekResult = Unistd.lseek64(fd, SEEK_TO, Unistd.SEEK_SET);
            Assertions.assertEquals(SEEK_TO, seekResult, "result of seek");
        } else {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Unistd.lseek64(-1, 1, Unistd.SEEK_SET);
            });
        }
    }

    @Test
    public void testBufReadWrongArgs() throws Exception {
        Int32_t readFD = new Int32_t();
        Int32_t writeFD = new Int32_t();

        Unistd.pipe(readFD, writeFD);
        try {
            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.read(readFD.int32_t(), (byte[]) null);
            });

            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.read(readFD.int32_t(), (byte[]) null, 0, 1);
            });

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                Unistd.read(readFD.int32_t(), new byte[8], 1, 10);
            });

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                Unistd.read(readFD.int32_t(), new byte[8], -3, 10);
            });
        } finally {
            Unistd.close(readFD.int32_t());
            Unistd.close(writeFD.int32_t());
        }

    }

    @Test
    public void testBufWriteWrongArgs() throws Exception {
        Int32_t readFD = new Int32_t();
        Int32_t writeFD = new Int32_t();

        Unistd.pipe(readFD, writeFD);
        try {
            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.write(writeFD.int32_t(), (byte[]) null);
            });

            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.write(writeFD.int32_t(), (byte[]) null, 0, 1);
            });

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                Unistd.write(writeFD.int32_t(), new byte[8], 1, 10);
            });

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                Unistd.write(writeFD.int32_t(), new byte[8], -3, 10);
            });
        } finally {
            Unistd.close(readFD.int32_t());
            Unistd.close(writeFD.int32_t());
        }

    }

    @Test
    public void testGid() throws Exception {
        final int gid = Unistd.getgid();
        final int egid = Unistd.getegid();
        Unistd.setgid(gid);
        Assertions.assertEquals(gid, Unistd.getgid());
        Assertions.assertEquals(egid, Unistd.getegid());
        Unistd.setegid(egid);
        Assertions.assertEquals(gid, Unistd.getgid());
        Assertions.assertEquals(egid, Unistd.getegid());
        Unistd.setregid(gid, egid);
        Assertions.assertEquals(gid, Unistd.getgid());
        Assertions.assertEquals(egid, Unistd.getegid());
        System.out.println("real gid: " + gid + " effective gid: " + egid);
    }

    @Test
    public void testUid() throws Exception {
        final int uid = Unistd.getuid();
        final int euid = Unistd.geteuid();
        Unistd.setuid(uid);
        Assertions.assertEquals(uid, Unistd.getuid());
        Assertions.assertEquals(euid, Unistd.geteuid());
        Unistd.seteuid(euid);
        Assertions.assertEquals(uid, Unistd.getuid());
        Assertions.assertEquals(euid, Unistd.geteuid());
        Unistd.setreuid(uid, euid);
        Assertions.assertEquals(uid, Unistd.getuid());
        Assertions.assertEquals(euid, Unistd.geteuid());
        System.out.println("real uid: " + uid + " effective uid: " + euid);
    }

    @Test
    public void testGetpid() throws Exception {
        int pid = Unistd.getpid();
        System.out.println("pid: " + pid);
    }

    @Test
    public void testGetppid() throws Exception {
        int ppid = Unistd.getppid();
        System.out.println("ppid: " + ppid);
    }

    @Test
    public void testGetpgrp() throws Exception {
        int pgrp = Unistd.getpgrp();
        System.out.println("pgrp: " + pgrp);
    }

    @Test
    public void testLseek() throws Exception {
        if (Defines.__SIZEOF_LONG__ == 4) {
            IllegalArgumentException iae = Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Unistd.lseek(-1, 1L + Integer.MAX_VALUE, Unistd.SEEK_SET);
            });
        } else if (Defines.__SIZEOF_LONG__ == 8) {
            NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                Unistd.lseek(-1, 1L + Integer.MAX_VALUE, Unistd.SEEK_SET);
            });
            Assertions.assertEquals(Errno.EBADF, nee.errno, "-1 is not a valid FD so EBADF is expected");
        }
    }

    @Test
    public void testPipe() throws Exception {
        Int32_t reaDFD = new Int32_t();
        Int32_t writeFD = new Int32_t();
        Unistd.pipe(reaDFD, writeFD);
        try {
            int written = Unistd.write(writeFD.int32_t(), writeBytes);
            int read = Unistd.read(reaDFD.int32_t(), readBytes, 0, writeBytes.length);
            Assertions.assertEquals(writeBytes.length, written);
            Assertions.assertEquals(written, read);
            for (int i = 0; i < read; i++) {
                Assertions.assertEquals((char) writeBytes[i], (char) readBytes[i]);
            }
        } finally {
            Unistd.close(reaDFD.int32_t());
            Unistd.close(writeFD.int32_t());
        }
    }

    //TODO JDK > 13  will support slice(pos, lim) so we could refert to
    // ByteBuffer writeBuffer = ByteBuffer.wrap(this.writeBytes).slice(WRITE_OFFSET, BYTES_TO_WRITE);
    // ByteBuffer readBuffer = ByteBuffer.wrap(readBackingArray).slice(READ_OFFSET, BYTES_TO_WRITE);
    @Test
    public void testPipeWithHeapBufferOffset() throws Exception {
        Int32_t readFD = new Int32_t();
        Int32_t writeFD = new Int32_t();
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

            int written = Unistd.write(writeFD.int32_t(), writeBuffer);

            int read = Unistd.read(readFD.int32_t(), readBuffer);
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
            Unistd.close(readFD.int32_t());
            Unistd.close(writeFD.int32_t());
        }
    }

    @Test
    public void testPipeWithReadOnlyBuffer() throws Exception {
        final Int32_t readFD = new Int32_t();
        final Int32_t writeFD = new Int32_t();
        Unistd.pipe(readFD, writeFD);
        try {
            final ByteBuffer writeBuffer = ByteBuffer.wrap(this.writeBytes).asReadOnlyBuffer();

            final ByteBuffer readBuffer = ByteBuffer.allocate(this.writeBytes.length).asReadOnlyBuffer();

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Unistd.write(writeFD.int32_t(), writeBuffer);
            });
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                int read = Unistd.read(readFD.int32_t(), readBuffer);
            });
        } finally {
            Unistd.close(readFD.int32_t());
            Unistd.close(writeFD.int32_t());
        }

    }

    @Test
    public void testPipeWriteWrongArgs() throws Exception {
        Int32_t readFD = new Int32_t();
        Int32_t writeFD = new Int32_t();
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
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY);
        byte[] result = new byte[TEST_DATA.length];
        int read = Unistd.read(fd, result, POS, LEN);
        Assertions.assertEquals(LEN, read);
        compareData(result);
    }

    @Test
    public void testReadArrayBufferCritical() throws Exception {
        writeData();
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY);
        byte[] result = new byte[TEST_DATA.length];
        int read = Unistd.JnhwPrimitiveArrayCritical.read(fd, result, POS, LEN);
        Assertions.assertEquals(LEN, read);
        compareData(result);
    }

    @Test
    public void testReadByteBuffer() throws Exception {
        writeData();
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY);
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
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY);
        Memory32Heap om = new Memory32Heap((OpaqueMemory32) null, 0, TEST_DATA.length, SetMem.TO_0x00);
        long read = Unistd.read(fd, om, POS, LEN);
        Assertions.assertEquals(LEN, read);
        byte[] result = OpaqueMemory32.toBytes(om);
        compareData(result);
    }

    @Test
    public void testReadSingle() throws Exception {
        writeData();
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY);
        byte[] result = new byte[TEST_DATA.length];
        Int8_t data = new Int8_t();
        for (int i = POS; i < POS + LEN; i++) {
            int read = Unistd.read(fd, data);
            Assertions.assertEquals(1, read);
            result[i] = data.int8_t();
        }
        compareData(result);
    }

    @Test
    public void testWriteArrayBuffer() throws Exception {
        fd = Fcntl.creat(f.getAbsolutePath(), Stat.S_IRUSR | Stat.S_IWUSR);
        Unistd.write(fd, TEST_DATA, POS, LEN);
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testWriteArrayBufferCritical() throws Exception {
        fd = Fcntl.creat(f.getAbsolutePath(), Stat.S_IRUSR | Stat.S_IWUSR);
        Unistd.JnhwPrimitiveArrayCritical.write(fd, TEST_DATA, POS, LEN);
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testWriteByteBuffer() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_WRONLY, Stat.S_IRUSR | Stat.S_IWUSR);
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
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_WRONLY, Stat.S_IRUSR | Stat.S_IWUSR);
        Memory32Heap om = new Memory32Heap((OpaqueMemory32) null, 0, TEST_DATA.length, SetMem.TO_0x00);
        OpaqueMemory32.copy(TEST_DATA, 0, om, 0, TEST_DATA.length);
        Unistd.write(fd, om, POS, LEN);
        byte[] data = readData();
        compareData(data);
    }

    @Test
    public void testWriteOpaqueMemory64() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_WRONLY, Stat.S_IRUSR | Stat.S_IWUSR);
        Memory64Heap om = new Memory64Heap((OpaqueMemory64) null, 0, TEST_DATA.length, SetMem.TO_0x00);
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
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_RDWR, Stat.S_IRUSR | Stat.S_IWUSR);
        byte[] buffer = new byte[10_000_000];
        int written = Unistd.write(fd, buffer);
        Assertions.assertEquals(buffer.length, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET);
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
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_RDWR);
        byte[] buffer = new byte[10_000_000];
        int written = Unistd.JnhwPrimitiveArrayCritical.write(fd, buffer);
        Assertions.assertEquals(buffer.length, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET);
        int read = Unistd.JnhwPrimitiveArrayCritical.read(fd, buffer);
        Assertions.assertEquals(buffer.length, read);
    }

    @Test
    public void testWriteReadArrayBufferPerformance() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_RDWR);
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
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_RDWR);
        int written = 0;
        for (int i = 0; i < 1_000; i++) {
            written += Unistd.write(fd, (byte) 1);
        }
        Assertions.assertEquals(1_000, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET);

        int read = 0;
        Int8_t data = new Int8_t();
        for (int i = 0; i < 1_000; i++) {
            read += Unistd.read(fd, data);
            Assertions.assertEquals(1, data.int8_t());
        }
        Assertions.assertEquals(1_000, read);
        read = Unistd.read(fd, data);
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
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_RDWR);
        int written = 0;
        for (int i = 0; i < 1_000; i++) {
            written += Unistd.write(fd, (byte) 1);
        }
        Assertions.assertEquals(1_000, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET);

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
    public void testSysconf() throws Exception {
        System.out.println("sysconf(_SC_AIO_LISTIO_MAX) = " + Unistd.sysconf(Unistd._SC_AIO_LISTIO_MAX));
        System.out.println("sysconf(_SC_AIO_MAX) = " + Unistd.sysconf(Unistd._SC_AIO_MAX));
        System.out.println("sysconf(_SC_AIO_PRIO_DELTA_MAX) = " + Unistd.sysconf(Unistd._SC_AIO_PRIO_DELTA_MAX));
    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testWriteReadByteBuffer10MB() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_RDWR);
        ByteBuffer buffer = ByteBuffer.allocateDirect(10_000_000);
        buffer.position(0);
        buffer.limit(buffer.capacity());
        int written = Unistd.write(fd, buffer);
        Assertions.assertEquals(buffer.capacity(), written);
        Assertions.assertEquals(buffer.position(), written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET);
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
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_RDWR);
        Memory32Heap mem = new Memory32Heap((OpaqueMemory32) null, 0, 10_000_000, SetMem.DO_NOT_SET);
        long written = Unistd.write(fd, mem);
        Assertions.assertEquals(mem.sizeInBytes, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET);
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
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_RDWR);
        Memory64Heap mem = new Memory64Heap((OpaqueMemory64) null, 0, 10_000_000, SetMem.DO_NOT_SET);
        long written = Unistd.write(fd, mem);
        Assertions.assertEquals(mem.sizeInBytes, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET);
        long read = Unistd.read(fd, mem);
        Assertions.assertEquals(mem.sizeInBytes, read);
    }

    @Test
    public void testWriteSingle() throws Exception {
        fd = Fcntl.creat(f.getAbsolutePath(), Stat.S_IRUSR | Stat.S_IWUSR);
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
