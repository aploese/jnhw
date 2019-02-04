package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.isoc.Errno;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnistdTests {

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

    byte[] writeBytes = "Hello world".getBytes();
    byte[] readBytes = new byte[1024];

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
