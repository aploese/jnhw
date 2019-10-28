/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jnr.posix.POSIX;
import jnr.posix.POSIXFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class JnrPosixComparisionTests {

    @BeforeAll
    public static void beforeAll() {
        Unistd.HAVE_UNISTD_H();
    }

    final static int BUFF_SIZE = 1024 * 1024;
    final static int ROUNDS = 1_000;

    @Test
    public void JnrPosixPipe() throws Exception {
        POSIX posix = POSIXFactory.getPOSIX();
        int[] fds = new int[2];
        if (posix.pipe(fds) != 0) {
            throw new RuntimeException();
        }
        final byte[] writeBuffer = getWriteBuffer();
        doRead = true;
        Thread t = new Thread() {
            byte[] readBuffer = new byte[BUFF_SIZE];

            @Override
            public void run() {
                while (doRead) {
                    final int read = posix.read(fds[0], readBuffer, readBuffer.length);
                    if (read < 0) {
                        Assertions.fail("Error JNR read");
                    }
//                    Assertions.assertEquals(BUFF_SIZE, read);
//                    Assertions.assertArrayEquals(writeBuffer, readBuffer);
                }
            }

        };
        t.start();
        for (int i = 0; i < ROUNDS; i++) {
            final int written = posix.write(fds[1], writeBuffer, writeBuffer.length);
//            Assertions.assertEquals(BUFF_SIZE, written);
            if (written < 0) {
                Assertions.fail("Error JNR write " + posix.errno());
            }
        }
        doRead = false;
        posix.close(fds[0]);
        posix.close(fds[1]);
    }

    private boolean doRead;

    @Test
    public void JnhwPosixPipe() throws Exception {
        final IntRef readFdRef = new IntRef();
        final IntRef writeFdRef = new IntRef();
        Unistd.pipe(readFdRef, writeFdRef);
        final int writeFd = writeFdRef.value;
        final byte[] writeBuffer = getWriteBuffer();

        doRead = true;
        Thread t = new Thread() {
            final byte[] readBuffer = new byte[BUFF_SIZE];
            final int readFd = readFdRef.value;

            @Override
            public void run() {
                while (doRead) {
                    try {
                        final int read = Unistd.read(readFd, readBuffer, 0, readBuffer.length);
//                        Assertions.assertEquals(BUFF_SIZE, read);
//                        Assertions.assertArrayEquals(writeBuffer, readBuffer);
                    } catch (NativeErrorException nee) {
                        Assertions.fail("Error JNHW read: " + Errno.getErrnoSymbol(nee.errno));
                    }
                }
            }
        };
        t.start();
        for (int i = 0; i < ROUNDS; i++) {
            try {
                final int written = Unistd.write(writeFd, writeBuffer, 0, writeBuffer.length);
//                Assertions.assertEquals(BUFF_SIZE, written);
            } catch (NativeErrorException nee) {
                Assertions.fail("Error JNHW write: " + Errno.getErrnoSymbol(nee.errno));
            }
        }
        doRead = false;
        Unistd.close(readFdRef.value);
        Unistd.close(writeFdRef.value);
    }

    public static void main(String[] args) {

    }

    private static byte[] getWriteBuffer() {
        byte[] result = new byte[BUFF_SIZE];
        for (int i = 0; i < BUFF_SIZE; i++) {
            result[i] = (byte) i;
        }
        return result;
    }

}
