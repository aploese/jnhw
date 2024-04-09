/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2020-2024, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.common.memory.MemoryArray;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.posix.sys.Stat;
import de.ibapl.jnhw.util.posix.Defines;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
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
        JnhwTestLogger.logBeforeAllBegin("setUpBeforeClass");
        f = File.createTempFile("jnhw-test", "");
        f.delete();
        JnhwTestLogger.logBeforeAllEnd("setUpBeforeClass");
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    private Arena arena;

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
    public void setUp(TestInfo testInfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testInfo);
        fd = -1;
        arena = Arena.ofConfined();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) throws Exception {
        f.delete();
        if (fd != -1) {
            Unistd.close(fd);
        }
        arena.close();
        JnhwTestLogger.logAfterEach(testInfo);
    }

    @BeforeAll
    public static void checkBeforeAll_HAVE_UNISTD_H() throws Exception {
        JnhwTestLogger.logBeforeAllBegin("checkBeforeAll_HAVE_UNISTD_H");
        Assertions.assertTrue(Unistd.HAVE_UNISTD_H, "expected to have unistd.h");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_HAVE_UNISTD_H");
    }

    @BeforeAll
    public static void checkBeforeAll_UnistdDefines() throws Exception {
        JnhwTestLogger.logBeforeAllBegin("checkBeforeAll_UnistdDefines");
        DefinesTest.testDefines(Unistd.class, "HAVE_UNISTD_H");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_UnistdDefines");
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
        Unistd.JnhwPipeFiledes filedes = Unistd.JnhwPipeFiledes.allocateNative(arena);
        Unistd.pipe(filedes);
        try {
            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.read(filedes.readFd(), (byte[]) null);
            });

            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.read(filedes.readFd(), (byte[]) null, 0, 1);
            });

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                Unistd.read(filedes.readFd(), new byte[8], 1, 10);
            });

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                Unistd.read(filedes.readFd(), new byte[8], -3, 10);
            });
        } finally {
            Unistd.close(filedes.readFd());
            Unistd.close(filedes.writeFd());
        }
    }

    @Test
    public void testBufWriteWrongArgs() throws Exception {
        Unistd.JnhwPipeFiledes filedes = Unistd.JnhwPipeFiledes.allocateNative(arena);
        Unistd.pipe(filedes);
        try {
            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.write(filedes.writeFd(), (byte[]) null);
            });

            Assertions.assertThrows(NullPointerException.class, () -> {
                Unistd.write(filedes.writeFd(), (byte[]) null, 0, 1);
            });

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                Unistd.write(filedes.writeFd(), new byte[8], 1, 10);
            });

            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                Unistd.write(filedes.writeFd(), new byte[8], -3, 10);
            });
        } finally {
            Unistd.close(filedes.readFd());
            Unistd.close(filedes.writeFd());
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
        JnhwTestLogger.logTest("real gid: " + gid + " effective gid: " + egid);
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
        JnhwTestLogger.logTest("real uid: " + uid + " effective uid: " + euid);
    }

    @Test
    public void testGetpid() throws Exception {
        int pid = Unistd.getpid();
        JnhwTestLogger.logTest("pid: " + pid);
    }

    @Test
    public void testGetppid() throws Exception {
        int ppid = Unistd.getppid();
        JnhwTestLogger.logTest("ppid: " + ppid);
    }

    @Test
    public void testGetpgrp() throws Exception {
        int pgrp = Unistd.getpgrp();
        JnhwTestLogger.logTest("pgrp: " + pgrp);
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
            ErrnoTest.assertErrnoEquals(Errno.EBADF, nee.errno);
        }
    }

    @Test
    public void testPipe() throws Exception {
        Unistd.JnhwPipeFiledes filedes = Unistd.JnhwPipeFiledes.allocateNative(arena);
        Unistd.pipe(filedes);
        try {
            int written = Unistd.write(filedes.writeFd(), writeBytes);
            int read = Unistd.read(filedes.readFd(), readBytes, 0, writeBytes.length);
            Assertions.assertEquals(writeBytes.length, written);
            Assertions.assertEquals(written, read);
            for (int i = 0; i < read; i++) {
                Assertions.assertEquals((char) writeBytes[i], (char) readBytes[i]);
            }
        } finally {
            Unistd.close(filedes.readFd());
            Unistd.close(filedes.writeFd());
        }
    }

    @Test
    public void testPipeWithHeapBufferOffset() throws Exception {
        Unistd.JnhwPipeFiledes filedes = Unistd.JnhwPipeFiledes.allocateNative(arena);
        Unistd.pipe(filedes);
        try {
            final int BYTES_TO_WRITE = 4;
            final int WRITE_OFFSET = 2;
            final int READ_OFFSET = 10;

            ByteBuffer writeBuffer = ByteBuffer.wrap(this.writeBytes).slice(WRITE_OFFSET, BYTES_TO_WRITE);

            byte[] readBackingArray = new byte[READ_OFFSET + BYTES_TO_WRITE];

            ByteBuffer readBuffer = ByteBuffer.wrap(readBackingArray).slice(READ_OFFSET, BYTES_TO_WRITE);

            int written = Unistd.write(filedes.writeFd(), writeBuffer);

            int read = Unistd.read(filedes.readFd(), readBuffer);
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
            Unistd.close(filedes.readFd());
            Unistd.close(filedes.writeFd());
        }
    }

    @Test
    public void testPipeWithReadOnlyBuffer() throws Exception {
        Unistd.JnhwPipeFiledes filedes = Unistd.JnhwPipeFiledes.allocateNative(arena);
        Unistd.pipe(filedes);
        try {
            final ByteBuffer writeBuffer = ByteBuffer.wrap(this.writeBytes).asReadOnlyBuffer();

            final ByteBuffer readBuffer = ByteBuffer.allocate(this.writeBytes.length).asReadOnlyBuffer();

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Unistd.write(filedes.writeFd(), writeBuffer);
            });
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                int read = Unistd.read(filedes.readFd(), readBuffer);
            });
        } finally {
            Unistd.close(filedes.readFd());
            Unistd.close(filedes.writeFd());
        }

    }

    public static class TestPipeFiledes_1 extends MemoryArray<Int32_t> {

        public final static int ARRAY_LENGTH = 1;

        private static Int32_t createAtOffset(MemorySegment memorySegment, long elementoffset, int index) {
            return new Int32_t(memorySegment, elementoffset);
        }

        public final static TestPipeFiledes_1 allocateNative(Arena arena) {
            return new TestPipeFiledes_1(arena.allocate(Int32_t.DATA_TYPE.SIZE_OF * ARRAY_LENGTH, Int32_t.DATA_TYPE.ALIGN_OF.alignof), 0);
        }

        public TestPipeFiledes_1(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, new Int32_t[ARRAY_LENGTH], TestPipeFiledes_1::createAtOffset, Int32_t.DATA_TYPE.SIZE_OF);
        }

    }

    @Test
    public void testPipeWriteWrongArgs() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Unistd.pipe(null);
        });
        TestPipeFiledes_1 filedes = TestPipeFiledes_1.allocateNative(arena);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Unistd.pipe(filedes);
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
        MemoryHeap om = MemoryHeap.wrap(arena.allocate(TEST_DATA.length));
        long read = Unistd.read(fd, om, POS, LEN);
        Assertions.assertEquals(LEN, read);
        byte[] result = OpaqueMemory.toBytes(om);
        compareData(result);
    }

    @Test
    public void testReadSingle() throws Exception {
        writeData();
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_RDONLY);
        byte[] result = new byte[TEST_DATA.length];
        Int8_t data = Int8_t.allocateNative(arena);
        for (int i = POS; i < POS + LEN; i++) {
            long read = Unistd.read(fd, data);
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
    public void testWriteOpaqueMemory() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_WRONLY, Stat.S_IRUSR | Stat.S_IWUSR);
        MemoryHeap om = MemoryHeap.wrap(arena.allocate(TEST_DATA.length));
        OpaqueMemory.copy(TEST_DATA, 0, om, 0, TEST_DATA.length);
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
        Int8_t srcData = Int8_t.allocateNative(arena);
        Int8_t destData = Int8_t.allocateNative(arena);
        srcData.int8_t((byte) 1);
        long written = 0;
        for (int i = 0; i < 1_000; i++) {
            written += Unistd.write(fd, srcData);
        }
        Assertions.assertEquals(1_000, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET);

        long read = 0;
        Int8_t data = Int8_t.allocateNative(arena);
        for (int i = 0; i < 1_000; i++) {
            read += Unistd.read(fd, data);
            Assertions.assertEquals(1, data.int8_t());
        }
        Assertions.assertEquals(1_000, read);
        read = Unistd.read(fd, destData);
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
        Int8_t srcData = Int8_t.allocateNative(arena);
        srcData.int8_t((byte) 1);
        Int8_t destData = Int8_t.allocateNative(arena);

        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_RDWR);
        long written = 0;
        for (int i = 0; i < 1_000; i++) {
            written += Unistd.write(fd, srcData);
        }
        Assertions.assertEquals(1_000, written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET);

        long read = 0;
        for (int i = 0; i < 1_000; i++) {
            final long result = Unistd.read(fd, destData);
            read += result;
            Assertions.assertEquals(srcData.sizeof(), result);
            Assertions.assertEquals(srcData.int8_t(), destData.int8_t());
        }
        Assertions.assertEquals(1_000, read);
        read = Unistd.read(fd, destData);
        Assertions.assertEquals(0, read);

    }

    /**
     * The size of the buffer would exceed the available stack space... th vm
     * would crash
     *
     * @throws Exception
     */
    @Test
    public void testSysconf() throws Exception {
        JnhwTestLogger.logTest("sysconf(_SC_AIO_LISTIO_MAX) = " + Unistd.sysconf(Unistd._SC_AIO_LISTIO_MAX));
        JnhwTestLogger.logTest("sysconf(_SC_AIO_MAX) = " + Unistd.sysconf(Unistd._SC_AIO_MAX));
        JnhwTestLogger.logTest("sysconf(_SC_AIO_PRIO_DELTA_MAX) = " + Unistd.sysconf(Unistd._SC_AIO_PRIO_DELTA_MAX));
        if (Unistd._SC_MINSIGSTKSZ.isDefined()) {
            JnhwTestLogger.logTest("sysconf(_SC_MINSIGSTKSZ) = " + Unistd.sysconf(Unistd._SC_MINSIGSTKSZ.get()));
        }
        if (Unistd._SC_SIGSTKSZ.isDefined()) {
            JnhwTestLogger.logTest("sysconf(_SC_SIGSTKSZ) = " + Unistd.sysconf(Unistd._SC_SIGSTKSZ.get()));
        }
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
    public void testWriteReadOpaqueMemory_10MB() throws Exception {
        fd = Fcntl.open(f.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_RDWR);
        MemoryHeap mem = MemoryHeap.wrap(arena.allocate(10_000_000));
        long written = Unistd.write(fd, mem);
        Assertions.assertEquals(mem.sizeof(), written);
        Unistd.lseek(fd, 0, Unistd.SEEK_SET);
        long read = Unistd.read(fd, mem);
        Assertions.assertEquals(mem.sizeof(), read);
    }

    @Test
    public void testWriteSingle() throws Exception {
        fd = Fcntl.creat(f.getAbsolutePath(), Stat.S_IRUSR | Stat.S_IWUSR);
        Int8_t srcData = Int8_t.allocateNative(arena);

        for (int i = POS; i < POS + LEN; i++) {
            srcData.int8_t(TEST_DATA[i]);
            long written = Unistd.write(fd, srcData);
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
