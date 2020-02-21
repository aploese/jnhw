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

import de.ibapl.jnhw.Callback_I_V_Impl;
import de.ibapl.jnhw.Callback_PtrOpaqueMemory_V_Impl;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.ObjectRef;
import de.ibapl.jnhw.OpaqueMemory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class AioTest {

    public AioTest() {
    }

    /**
     * Test of aio_cancel method, of class Aio.
     */
    @Test
    public void testAio_cancel() throws Exception {
        System.out.println("aio_cancel");
        int fildes = 0;
        Aio.Aiocb aiocbp = null;
        int expResult = 0;
        int result = Aio.aio_cancel(fildes, aiocbp);
        assertEquals(expResult, result);
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_cancel(fildes, null);
        });

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aio_error method, of class Aio.
     */
    @Test
    public void testAio_error() throws Exception {
        System.out.println("aio_error");
        Aio.Aiocb aiocb = new Aio.Aiocb();
        int expResult = 0;
        int result = Aio.aio_error(aiocb);
        assertEquals(expResult, result);
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_error(null);
        });
    }

    /**
     * Test of aio_fsync method, of class Aio.
     */
    @Test
    public void testAio_fsync() throws Exception {
        System.out.println("aio_fsync");
        int op = 0;
        Aio.Aiocb aiocb = new Aio.Aiocb();
        Aio.aio_fsync(op, aiocb);
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_fsync(op, null);
        });

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_read() throws Exception {
        System.out.println("aio_read");
        final String HELLO_WORLD = "Hello world!\n";

        final ObjectRef objRef = new ObjectRef(null);
        File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");
        FileWriter fw = new FileWriter(tmpFile);
        fw.append(HELLO_WORLD);
        fw.flush();
        fw.close();

        final Aio.Aiocb<Aio.Aiocb> aiocb = new Aio.Aiocb();
        aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR()));
        final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

        aioBuffer.clear();
        aiocb.aio_buf(aioBuffer);
        assertEquals(0, aioBuffer.position());

        aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD());
        aiocb.aio_sigevent.sigev_value.sival_ptr(aiocb);

        System.out.println("aio_read aiocb.aio_sigevent.sigev_value: " + aiocb.aio_sigevent.sigev_value);
        System.out.println("aio_read Pthread_t: " + Pthread.pthread_self());
        System.out.println("aio_read currentThread: " + Thread.currentThread());

        aiocb.aio_sigevent.sigev_notify_function(new Callback_PtrOpaqueMemory_V_Impl<Aio.Aiocb>() {

            @Override
            protected void callback(Aio.Aiocb a) {
                System.out.println("aio_read enter callback Pthread_t: " + Pthread.pthread_self());
                System.out.println("aio_read in callback currentThread: " + Thread.currentThread());
                try {
                    int errno = Aio.aio_error(a);
                    assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                    aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(a));
                } catch (NativeErrorException nee) {
                    fail("aio_read in callback NativeErrorException: " + nee, nee);
                }
                synchronized (objRef) {
                    objRef.value = a;
                    objRef.notify();
                }
                System.out.println("aio_read leave callback");
            }

            @Override
            protected Aio.Aiocb wrapA(long address) {
                return new Aio.Aiocb(address);
            }

        });

        Aio.aio_read(aiocb);

        synchronized (objRef) {
            if (objRef.value == null) {
                objRef.wait(1000);
            }
            assertEquals(aiocb, objRef.value);
        }

        Unistd.close(aiocb.aio_fildes());
        int errno = Aio.aio_error(aiocb);
        assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
        assertEquals(HELLO_WORLD.length(), Aio.aio_return(aiocb));
        assertEquals(HELLO_WORLD.length(), aioBuffer.position());

        byte[] result = new byte[HELLO_WORLD.length()];
        aioBuffer.flip();
        aioBuffer.get(result);

        Assertions.assertArrayEquals(HELLO_WORLD.getBytes(), result);
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_read(null);
        });

    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_readEmpty() throws Exception {
        System.out.println("aio_read empty file");

        final int SIVAL_INT = 0x01234567;

        final IntRef intRef = new IntRef(0);
        File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");

        final Aio.Aiocb<OpaqueMemory> aiocb = new Aio.Aiocb();
        aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR()));
        final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

        aioBuffer.clear();
        aiocb.aio_buf(aioBuffer);
        assertEquals(0, aioBuffer.position());

        aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD());
        aiocb.aio_sigevent.sigev_value.sival_int(SIVAL_INT);

        System.out.println("aio_read aiocb.aio_sigevent.sigev_value: " + aiocb.aio_sigevent.sigev_value);
        System.out.println("aio_read Pthread_t: " + Pthread.pthread_self());
        System.out.println("aio_read currentThread: " + Thread.currentThread());

        aiocb.aio_sigevent.sigev_notify_function(new Callback_I_V_Impl() {

            @Override
            protected void callback(int i) {
                System.out.println("aio_read enter callback Pthread_t: " + Pthread.pthread_self());
                System.out.println("aio_read in callback currentThread: " + Thread.currentThread());
                try {
                    int errno = Aio.aio_error(aiocb);
                    assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                    aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(aiocb));
                } catch (NativeErrorException nee) {
                    fail("aio_read in callback NativeErrorException: " + nee, nee);
                }
                synchronized (intRef) {
                    intRef.value = i;
                    intRef.notify();
                }
                System.out.println("aio_read leave callback");
            }

        });

        int errno = Aio.aio_error(aiocb);
        assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
        Aio.aio_read(aiocb);
        errno = Aio.aio_error(aiocb);
        assertEquals(Errno.EINPROGRESS(), errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));

        synchronized (intRef) {
            if (intRef.value == 0) {
                intRef.wait(1000);
            }
            assertEquals(SIVAL_INT, intRef.value);
        }
        errno = Aio.aio_error(aiocb);
        assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
        assertEquals(0, Aio.aio_return(aiocb));
        assertEquals(0, aioBuffer.position());

        Unistd.close(aiocb.aio_fildes());

    }

    /**
     * Test of aio_return method, of class Aio.
     */
    @Test
    public void testAio_return() throws Exception {
        System.out.println("aio_return");
        Aio.Aiocb aiocb = null;
        long expResult = 0L;
        long result = Aio.aio_return(aiocb);
        assertEquals(expResult, result);
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_return(null);
        });
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aio_suspend method, of class Aio.
     */
    @Test
    public void testAio_suspend() throws Exception {
        System.out.println("aio_suspend");
        Aio.Aiocbs aiocbs = null;
        Time.Timespec timeout = null;
        Aio.aio_suspend(aiocbs, timeout);
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_suspend(null, timeout);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_suspend(aiocbs, null);
        });
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aio_write method, of class Aio.
     */
    @Test
    public void testAio_write_ByteBuffer() throws Exception {

        System.out.println("aio_write");

        final String HELLO_WORLD = "Hello world!\n";
        final int SIVAL_INT = 0x01234567;

        final IntRef intRef = new IntRef(0);
        File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Write", ".txt");

        final Aio.Aiocb<OpaqueMemory> aiocb = new Aio.Aiocb();
        aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR()));
        final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);
        aioBuffer.put(HELLO_WORLD.getBytes());

        aioBuffer.flip();
        aiocb.aio_buf(aioBuffer);
        assertEquals(HELLO_WORLD.length(), aiocb.aio_nbytes());
        assertEquals(0, aioBuffer.position());
        assertEquals(HELLO_WORLD.length(), aioBuffer.remaining());

        aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD());
        aiocb.aio_sigevent.sigev_value.sival_int(SIVAL_INT);

        System.out.println("aio_write aiocb.aio_sigevent.sigev_value: " + aiocb.aio_sigevent.sigev_value);
        System.out.println("aio_write Pthread_t: " + Pthread.pthread_self());
        System.out.println("aio_write currentThread: " + Thread.currentThread());

        aiocb.aio_sigevent.sigev_notify_function(new Callback_I_V_Impl() {

            @Override
            protected void callback(int i) {
                System.out.println("aio_write enter callback Pthread_t: " + Pthread.pthread_self());
                System.out.println("aio_write in callback currentThread: " + Thread.currentThread());
                try {
                    int errno = Aio.aio_error(aiocb);
                    assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                    aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(aiocb));
                } catch (NativeErrorException nee) {
                    fail("aio_read in callback NativeErrorException: " + nee, nee);
                }
                synchronized (intRef) {
                    intRef.value = i;
                    intRef.notify();
                }
                System.out.println("aio_write leave callback");
            }

        });

        Aio.aio_write(aiocb);

        synchronized (intRef) {
            if (intRef.value == 0) {
                intRef.wait(1000);
            }
            assertEquals(SIVAL_INT, intRef.value);
            Assertions.assertFalse(aioBuffer.hasRemaining());
        }
        Unistd.close(aiocb.aio_fildes());
        FileReader fr = new FileReader(tmpFile);
        BufferedReader br = new BufferedReader(fr);
        String result = br.readLine() + '\n';
        assertEquals(HELLO_WORLD, result);
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_write(null);
        });
    }

    /**
     * Test of lio_listio method, of class Aio.
     */
    @Test
    public void testLio_listio() throws Exception {
        System.out.println("lio_listio");
        int mode = 0;
        Aio.Aiocbs list = null;
        Signal.Sigevent sig = null;
        Aio.lio_listio(mode, list, sig);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.lio_listio(mode, null, sig);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.lio_listio(mode, list, null);
        });
    }

    /**
     * Test of sigaction method, of class Signal.
     */
    @Test
    public void testAiocbs() throws Exception {
        fail(" _AioAiocbs.c \n"
                + ".");
    }

}
