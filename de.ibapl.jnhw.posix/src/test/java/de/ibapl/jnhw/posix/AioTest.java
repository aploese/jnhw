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

import de.ibapl.jnhw.common.callback.Callback_NativeRunnable;
import de.ibapl.jnhw.common.callback.Callback_Mem_V_Impl;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.callback.NativeRunnable;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.Callback__Sigval_int__V_Impl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class AioTest {

    // just for vm in qemu...
    private final static long ONE_MINUTE = 60_000;
    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    public AioTest() {
        super();
    }

    /**
     * Test of aio_cancel method, of class Aio.
     */
    @Test
    public void testAio_cancel() throws Exception {
        System.out.println("aio_cancel");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.aio_cancel(null);
                });
                break;
            default:

                Aio.Aiocb aiocbp = new Aio.Aiocb();
                aiocbp.aio_fildes(-1);

                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                    Aio.aio_cancel(aiocbp);
                });

                assertEquals(Errno.EBADF, nee.errno);

                nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                    Aio.aio_cancel(-1);
                });

                assertEquals(Errno.EBADF, nee.errno);
        }
    }

    /**
     * Test of aio_error method, of class Aio.
     */
    @Test
    public void testAio_error() throws Exception {
        System.out.println("aio_error");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.aio_error(null);
                });
                break;
            default:
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_fildes(-1);

                int result = Aio.aio_error(aiocb);
                if (MULTIARCHTUPEL_BUILDER.getOS() == OS.FREE_BSD) {
                    assertEquals(Errno.EINVAL, result);
                } else {
                    assertEquals(0, result);
                }

                Assertions.assertThrows(NullPointerException.class, () -> {
                    Aio.aio_error(null);
                });
        }
    }

    /**
     * Test of aio_fsync method, of class Aio.
     */
    @Test
    public void testAio_fsync() throws Exception {
        System.out.println("aio_fsync");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.aio_fsync(0, null);
                });
                break;
            default:
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_fildes(-1);

                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                    Aio.aio_fsync(Fcntl.O_SYNC, aiocb);
                });

                assertEquals(Errno.EBADF, nee.errno);
                Assertions.assertThrows(NullPointerException.class, () -> {
                    Aio.aio_fsync(0, null);
                });
        }
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_read_ByteBuffer() throws Exception {
        System.out.println("aio_read");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.aio_read(null);
                });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";

                final ObjectRef<Object> objRef = new ObjectRef<>(null);
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");
                FileWriter fw = new FileWriter(tmpFile);
                fw.append(HELLO_WORLD);
                fw.flush();
                fw.close();

                final Aio.Aiocb<Aio.Aiocb> aiocb = new Aio.Aiocb<>();
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD.get());
                aiocb.aio_sigevent.sigev_value.sival_ptr(aiocb);

                System.out.println("aio_read aiocb.aio_sigevent.sigev_value: " + aiocb.aio_sigevent.sigev_value);
                System.out.println("aio_read Pthread_t: " + Pthread.pthread_self());
                System.out.println("aio_read currentThread: " + Thread.currentThread());

                aiocb.aio_sigevent.sigev_notify_function(new Callback_Mem_V_Impl<Aio.Aiocb>() {

                    @Override
                    @SuppressWarnings("unchecked")
                    protected void callback(Aio.Aiocb a) {
                        try {
                            System.out.println("aio_read enter callback Pthread_t: " + Pthread.pthread_self());
                            System.out.println("aio_read in callback currentThread: " + Thread.currentThread());
                            int errno = Aio.aio_error(a);
                            if (errno != 0) {
                                throw new NativeErrorException(errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                            }
                            aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(a));
                            synchronized (objRef) {
                                objRef.value = a;
                                objRef.notify();
                            }
                            System.out.println("aio_read leave callback");
                        } catch (Exception ex) {
                            synchronized (objRef) {
                                objRef.value = ex;
                                objRef.notify();
                            }
                            throw new RuntimeException(ex);
                        }
                    }

                    @Override
                    protected Aio.Aiocb wrapA(NativeAddressHolder address) {
                        try {
                            return new Aio.Aiocb(address);
                        } catch (NoSuchNativeTypeException nste) {
                            synchronized (objRef) {
                                objRef.value = nste;
                                objRef.notify();
                            }
                            throw new RuntimeException(nste);
                        }
                    }

                });

                Aio.aio_read(aiocb);

                synchronized (objRef) {
                    if (objRef.value == null) {
                        objRef.wait(ONE_MINUTE);
                    }
                }

                Assertions.assertNotNull(objRef.value);
                if (objRef.value instanceof Exception) {
                    fail("in callback", (Exception) objRef.value);
                } else {
                    assertEquals(aiocb, objRef.value);
                }

                Unistd.close(aiocb.aio_fildes());
                int errno = Aio.aio_error(aiocb);
                assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                assertEquals(HELLO_WORLD.length(), aioBuffer.position());

                byte[] result = new byte[HELLO_WORLD.length()];
                aioBuffer.flip();
                aioBuffer.get(result);

                Assertions.assertArrayEquals(HELLO_WORLD.getBytes(), result);

                Assertions.assertThrows(NullPointerException.class, () -> {
                    Aio.aio_read(null);
                });
        }
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_readEmpty() throws Exception {
        System.out.println("aio_read empty file");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.aio_read(null);
                });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final int SIVAL_INT = 0x01234567;

                final ObjectRef<Object> intRef = new ObjectRef<>(null);
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");

                final Aio.Aiocb<Struct32> aiocb = new Aio.Aiocb<>();
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD.get());
                aiocb.aio_sigevent.sigev_value.sival_int(SIVAL_INT);

                System.out.println("aio_read aiocb.aio_sigevent.sigev_value: " + aiocb.aio_sigevent.sigev_value);
                System.out.println("aio_read Pthread_t: " + Pthread.pthread_self());
                System.out.println("aio_read currentThread: " + Thread.currentThread());

                aiocb.aio_sigevent.sigev_notify_function(new Callback__Sigval_int__V_Impl() {

                    @Override
                    protected void callback(int i) {
                        try {
                            System.out.println("aio_read enter callback Pthread_t: " + Pthread.pthread_self());
                            System.out.println("aio_read in callback i=" + i + " currentThread: " + Thread.currentThread());
                            int errno = Aio.aio_error(aiocb);
                            if (errno != 0) {
                                throw new NativeErrorException(errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                            }
                            aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(aiocb));
                            synchronized (intRef) {
                                intRef.value = i;
                                intRef.notify();
                            }
                            System.out.println("aio_read leave callback");
                        } catch (Exception ex) {
                            synchronized (intRef) {
                                intRef.value = ex;
                                intRef.notify();
                            }
                            throw new RuntimeException(ex);
                        }

                    }

                });

                int errno = Aio.aio_error(aiocb);
                assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                Aio.aio_read(aiocb);
                errno = Aio.aio_error(aiocb);
                assertEquals(Errno.EINPROGRESS, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));

                synchronized (intRef) {
                    if (intRef.value == null) {
                        intRef.wait(ONE_MINUTE);
                    }
                }
                Assertions.assertNotNull(intRef.value);
                if (intRef.value instanceof Exception) {
                    fail("in callback", (Exception) intRef.value);
                } else {
                    assertEquals(Integer.valueOf(SIVAL_INT), intRef.value);
                }

                errno = Aio.aio_error(aiocb);
                assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                assertEquals(0, Aio.aio_return(aiocb));
                assertEquals(0, aioBuffer.position());

                Unistd.close(aiocb.aio_fildes());
        }
    }

    /**
     * Test of aio_return method, of class Aio. is tested in read/write too
     */
    @Test
    public void testAio_return() throws Exception {
        System.out.println("aio_return");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.aio_return(null);
                });
                break;
            default:
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_fildes(-1);

                long expResult = 0L;
                long result = Aio.aio_return(aiocb);
                assertEquals(expResult, result);
                Assertions.assertThrows(NullPointerException.class, () -> {
                    Aio.aio_return(null);
                });
        }
    }

    /**
     * Test of aio_suspend method, of class Aio.
     */
    @Test
    public void testAio_suspend() throws Exception {
        System.out.println("aio_suspend");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.aio_suspend(null, null);
                });
                break;
            default:
                Aio.Aiocbs aiocbs = new Aio.Aiocbs(1, SetMem.DO_NOT_SET);
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_fildes(-1);
                aiocbs.set(0, aiocb);

                Time.Timespec timeout = new Time.Timespec(SetMem.TO_0x00);
                timeout.tv_sec(1);

                //Just a dry run....
                Aio.aio_suspend(aiocbs, timeout);

                Assertions.assertThrows(NullPointerException.class, () -> {
                    Aio.aio_suspend(null, timeout);
                });
                Assertions.assertThrows(NullPointerException.class, () -> {
                    Aio.aio_suspend(aiocbs, null);
                });
        }
    }

    /**
     * Test of aio_write method, of class Aio.
     */
    @Test
    public void testAio_write_ByteBuffer() throws Exception {
        System.out.println("aio_write");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.aio_write(null);
                });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";
                final int SIVAL_INT = 0x01234567;

                final ObjectRef<Object> intRef = new ObjectRef<>(null);
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Write", ".txt");

                final Aio.Aiocb<Struct32> aiocb = new Aio.Aiocb();
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);
                aioBuffer.put(HELLO_WORLD.getBytes());

                aioBuffer.flip();
                aiocb.aio_buf(aioBuffer);
                assertEquals(HELLO_WORLD.length(), aiocb.aio_nbytes());
                assertEquals(0, aioBuffer.position());
                assertEquals(HELLO_WORLD.length(), aioBuffer.remaining());

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD.get());
                aiocb.aio_sigevent.sigev_value.sival_int(SIVAL_INT);

                System.out.println("aio_write aiocb.aio_sigevent.sigev_value: " + aiocb.aio_sigevent.sigev_value);
                System.out.println("aio_write Pthread_t: " + Pthread.pthread_self());
                System.out.println("aio_write currentThread: " + Thread.currentThread());

                aiocb.aio_sigevent.sigev_notify_function(new Callback__Sigval_int__V_Impl() {

                    @Override
                    protected void callback(int i) {
                        try {
                            System.out.println("aio_write enter callback Pthread_t: " + Pthread.pthread_self());
                            System.out.println("aio_write in callback i=" + i + " currentThread: " + Thread.currentThread());
                            int errno = Aio.aio_error(aiocb);
                            if (errno != 0) {
                                throw new NativeErrorException(errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                            }
                            aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(aiocb));
                            synchronized (intRef) {
                                intRef.value = i;
                                intRef.notify();
                            }
                            System.out.println("aio_write leave callback");
                        } catch (Exception ex) {
                            synchronized (intRef) {
                                intRef.value = ex;
                                intRef.notify();
                            }
                            throw new RuntimeException(ex);
                        }
                    }

                });

                Aio.aio_write(aiocb);

                synchronized (intRef) {
                    if (intRef.value == null) {
                        intRef.wait(ONE_MINUTE);
                    }
                }
                Assertions.assertNotNull(intRef.value);
                if (intRef.value instanceof Exception) {
                    fail("in callback", (Exception) intRef.value);
                } else {
                    assertEquals(Integer.valueOf(SIVAL_INT), intRef.value);
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
    }

    /**
     * Test of lio_listio method, of class Aio.
     */
    @Test
    public void testLio_listio() throws Exception {
        System.out.println("lio_listio");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.lio_listio(0, null, null);
                });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                Aio.Aiocbs list = new Aio.Aiocbs(1, SetMem.DO_NOT_SET);
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_fildes(-1);
                list.set(0, aiocb);

                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                    Aio.lio_listio(Aio.LIO_WAIT.get(), list, null);
                });
                assertEquals(Errno.EIO, nee.errno, Errno.getErrnoSymbol(nee.errno));

                Assertions.assertThrows(NullPointerException.class, () -> {
                    Aio.lio_listio(Aio.LIO_WAIT.get(), null, null);
                });

                if (MULTIARCHTUPEL_BUILDER.getOS() == OS.FREE_BSD) {
                    nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                        Aio.lio_listio(Aio.LIO_NOWAIT.get(), list, null);
                    });
                    assertEquals(Errno.EIO, nee.errno, Errno.getErrnoSymbol(nee.errno));
                } else {
                    Aio.lio_listio(Aio.LIO_NOWAIT.get(), list, null);
                }
        }
    }

    /**
     * Test of lio_listio method, of class Aio.
     */
    @Test
    public void testReadLio_listio() throws Exception {
        System.out.println("lio_listio");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.lio_listio(0, null, null);
                });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";

                final ObjectRef objRef = new ObjectRef<>(null);
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");
                FileWriter fw = new FileWriter(tmpFile);
                fw.append(HELLO_WORLD);
                fw.flush();
                fw.close();

                final Aio.Aiocb<Aio.Aiocb> aiocb = new Aio.Aiocb();
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                aiocb.aio_lio_opcode(Aio.LIO_READ.get());
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());

                Aio.Aiocbs list = new Aio.Aiocbs(1, SetMem.DO_NOT_SET);
                list.set(0, aiocb);

                Aio.lio_listio(Aio.LIO_NOWAIT.get(), list, null);
                int errno = Aio.aio_error(aiocb);
                while (errno != 0) {
                    assertEquals(Errno.EINPROGRESS, errno, "Got errno from aio_error: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                    Thread.sleep(1000);
                    errno = Aio.aio_error(aiocb);
                }

                aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(aiocb));

                assertEquals(HELLO_WORLD.length(), aioBuffer.position());

                byte[] result = new byte[HELLO_WORLD.length()];
                aioBuffer.flip();
                aioBuffer.get(result);

                Assertions.assertArrayEquals(HELLO_WORLD.getBytes(), result);

                Unistd.close(aiocb.aio_fildes());
        }
    }

    /**
     * Test struct aiocb.
     */
    @Test
    public void testStructAiocb() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    new Aio.Aiocb();
                });
                break;
            default:
                Aio.Aiocb aiocb = new Aio.Aiocb();
                System.out.println("aiocb : " + aiocb.nativeToString());
                assertEquals(NativeAddressHolder.NULL, aiocb.aio_buf());

                ByteBuffer buf = ByteBuffer.allocateDirect(128);
                buf.position(16);
                buf.limit(64);
                aiocb.aio_fildes(-1);
                assertEquals(-1, aiocb.aio_fildes());
                aiocb.aio_buf(buf);
                Assertions.assertNotEquals(NativeAddressHolder.NULL, aiocb.aio_buf());
                assertEquals(0, aiocb.aio_offset());
                assertEquals(48, aiocb.aio_nbytes());
                aiocb.aio_offset(8);
                assertEquals(8, aiocb.aio_offset());

                System.out.println("aiocb : " + aiocb.nativeToString());
        }
    }

    /**
     * Test members of struct Aiocb[].
     */
    @Test
    public void testAiocbs() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertFalse(Aio.HAVE_AIO_H);
                break;
            default:
                Aio.Aiocbs aiocbs = new Aio.Aiocbs(1, SetMem.TO_0x00);

                Aio.Aiocb aiocb_null = aiocbs.get(0, null);
                Assertions.assertNull(aiocb_null);

                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_fildes(-1);
                aiocbs.set(0, aiocb);

                Aio.Aiocb aiocb_get = aiocbs.get(0, null);
                assertEquals(aiocb, aiocb_get);
        }

    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_read_ByteBuffer_NativeRunnable() throws Exception {
        System.out.println("aio_read");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Aio.aio_read(null);
                });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";

                final ObjectRef objRef = new ObjectRef<>(null);
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");
                FileWriter fw = new FileWriter(tmpFile);
                fw.append(HELLO_WORLD);
                fw.flush();
                fw.close();

                final Aio.Aiocb<NativeRunnable> aiocb = new Aio.Aiocb();
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD.get());

                System.out.println("aio_read aiocb.aio_sigevent.sigev_value: " + aiocb.aio_sigevent.sigev_value);
                System.out.println("aio_read Pthread_t: " + Pthread.pthread_self());
                System.out.println("aio_read currentThread: " + Thread.currentThread());

                aiocb.aio_sigevent.sigev_notify_function(Callback_NativeRunnable.INSTANCE);
                NativeRunnable callback = new NativeRunnable() {

                    @Override
                    @SuppressWarnings("unchecked")
                    protected void callback() {
                        System.out.println("aio_read enter callback Pthread_t: " + Pthread.pthread_self());
                        System.out.println("aio_read in callback currentThread: " + Thread.currentThread());
                        try {
                            int errno = Aio.aio_error(aiocb);
                            assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                            aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(aiocb));
                        } catch (NativeErrorException nee) {
                            fail("aio_read in callback NativeErrorException: " + nee, nee);
                        } catch (NoSuchNativeMethodException nsnme) {
                            fail(nsnme);
                        }
                        synchronized (objRef) {
                            objRef.value = aiocb;
                            objRef.notify();
                        }
                        System.out.println("aio_read leave callback");
                    }

                };
                aiocb.aio_sigevent.sigev_value.sival_ptr(callback);
                Aio.aio_read(aiocb);

                synchronized (objRef) {
                    if (objRef.value == null) {
                        objRef.wait(ONE_MINUTE);
                    }
                    assertEquals(aiocb, objRef.value);
                }

                Unistd.close(aiocb.aio_fildes());
                int errno = Aio.aio_error(aiocb);
                assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                assertEquals(HELLO_WORLD.length(), aioBuffer.position());

                byte[] result = new byte[HELLO_WORLD.length()];
                aioBuffer.flip();
                aioBuffer.get(result);

                Assertions.assertArrayEquals(HELLO_WORLD.getBytes(), result);

                Assertions.assertThrows(NullPointerException.class, () -> {
                    Aio.aio_read(null);
                });
        }
    }

    @Test
    public void testSizeOfAiocb() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
                    case _32_BIT:
                        Assertions.assertEquals(144, Aio.Aiocb.getLayoutOrThrow().sizeof);
                        break;
                    case _64_BIT:
                        Assertions.assertEquals(168, Aio.Aiocb.getLayoutOrThrow().sizeof);
                        break;
                    default:
                        Assertions.assertEquals(-1, Aio.Aiocb.getLayoutOrThrow().sizeof);
                }
                break;
            case FREE_BSD:
                Assertions.assertEquals(160, Aio.Aiocb.getLayoutOrThrow().sizeof);
                break;
            case OPEN_BSD:
                Assertions.assertNull(Aio.Aiocb.getLayoutOrThrow());
                break;
            default:
                Assertions.assertEquals(-1, Aio.Aiocb.getLayoutOrThrow().sizeof);
        }
    }

    @Test
    public void testAlignOfAiocb() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case FREE_BSD:
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
                    case _32_BIT:
                        Assertions.assertEquals(Alignment.AT_4, Aio.Aiocb.getLayoutOrThrow().alignment);
                        break;
                    case _64_BIT:
                        Assertions.assertEquals(Alignment.AT_8, Aio.Aiocb.getLayoutOrThrow().alignment);
                        break;
                    default:
                        Assertions.assertEquals(null, Aio.Aiocb.getLayoutOrThrow().alignment);
                }
                break;
            case OPEN_BSD:
                Assertions.assertNull(Aio.Aiocb.getLayoutOrThrow());
                break;
            default:
                Assertions.assertEquals(null, Aio.Aiocb.getLayoutOrThrow().alignment);
        }
    }

    @Test
    public void testOffsetOfAio_sigevent() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
                    case _32_BIT:
                        Assertions.assertEquals(20, Aio.Aiocb.getLayoutOrThrow().aio_sigevent);
                        break;
                    case _64_BIT:
                        Assertions.assertEquals(32, Aio.Aiocb.getLayoutOrThrow().aio_sigevent);
                        break;
                    default:
                        Assertions.assertEquals(-1, Aio.Aiocb.getLayoutOrThrow().aio_sigevent);
                }
                break;
            case FREE_BSD:
                Assertions.assertEquals(80, Aio.Aiocb.getLayoutOrThrow().aio_sigevent);
                break;
            case OPEN_BSD:
                Assertions.assertNull(Aio.Aiocb.getLayoutOrThrow());
                break;
            default:
                Assertions.assertEquals(-1, Aio.Aiocb.getLayoutOrThrow().aio_sigevent);
        }
    }

}
