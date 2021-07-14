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
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.Callback__Sigval_int__V_Impl;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class AioTest {

    public static class NativeDefines {

        public final static native boolean HAVE_AIO_H();

        public final static native Integer AIO_ALLDONE();

        public final static native Integer AIO_CANCELED();

        public final static native Integer AIO_NOTCANCELED();

        public final static native Integer LIO_NOP();

        public final static native Integer LIO_NOWAIT();

        public final static native Integer LIO_READ();

        public final static native Integer LIO_WAIT();

        public final static native Integer LIO_WRITE();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeAiocb {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long aio_fildes();

        public final static native long aio_offset();

        public final static native long aio_buf();

        public final static native long aio_nbytes();

        public final static native long aio_reqprio();

        public final static native long aio_sigevent();

        public final static native long aio_lio_opcode();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    // just for vm in qemu...
    private final static long ONE_MINUTE = 60_000;
    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @BeforeAll
    public static void checkBeforeAll_HAVE_AIO_H() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
            case WINDOWS:
                Assertions.assertFalse(Aio.HAVE_AIO_H, "expected not to have aio.h");
                break;
            default:
                Assertions.assertTrue(Aio.HAVE_AIO_H, "expected to have aio.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_AioDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Aio.class, NativeDefines.class, "HAVE_AIO_H");
    }

    @BeforeAll
    public static void checkBeforeAll_StructAiocb() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    new Aio.Aiocb();
                });
                break;
            default:
                Assertions.assertAll(
                        () -> {
                            Assertions.assertEquals(NativeAiocb.sizeof(), Aio.Aiocb.sizeof, "sizeof");
                        },
                        () -> {
                            Assertions.assertEquals(NativeAiocb.alignof(), Aio.Aiocb.alignof.alignof, "alignof");
                        },
                        () -> {
                            Assertions.assertEquals(NativeAiocb.aio_fildes(), Aio.Aiocb.offsetof_Aio_fildes, "offsetof_Aio_fildes");
                        },
                        () -> {
                            Assertions.assertEquals(NativeAiocb.aio_offset(), Aio.Aiocb.offsetof_Aio_offset, "offsetof_Aio_offset");
                        },
                        () -> {
                            Assertions.assertEquals(NativeAiocb.aio_buf(), Aio.Aiocb.offsetof_Aio_buf, "offsetof_Aio_buf");
                        },
                        () -> {
                            Assertions.assertEquals(NativeAiocb.aio_nbytes(), Aio.Aiocb.offsetof_Aio_nbytes, "offsetof_Aio_nbytes");
                        },
                        () -> {
                            Assertions.assertEquals(NativeAiocb.aio_reqprio(), Aio.Aiocb.offsetof_Aio_reqprio, "offsetof_Aio_reqprio");
                        },
                        () -> {
                            Assertions.assertEquals(NativeAiocb.aio_sigevent(), Aio.Aiocb.offsetof_Aio_sigevent, "offsetof_Aio_sigevent");
                        },
                        () -> {
                            Assertions.assertEquals(NativeAiocb.aio_lio_opcode(), Aio.Aiocb.offsetof_Aio_lio_opcode, "offsetof_Aio_lio_opcode");
                        }
                );
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
     * Test of aio_cancel method, of class Aio.
     */
    @Test
    public void testAio_cancel() throws Exception {
        System.out.println("aio_cancel");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case DARWIN: {
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                int result = Aio.aio_cancel(aiocb);
                assertEquals(Aio.AIO_ALLDONE.get(), result);

                result = Aio.aio_cancel(-1);
                assertEquals(Aio.AIO_ALLDONE.get(), result);
            }
            break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Aio.aio_cancel(new Aio.Aiocb());
                });
                break;
            default:
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                    Aio.aio_cancel(aiocb);
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
            case DARWIN: {
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);
                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class,
                        () -> {
                            Aio.aio_error(aiocb);
                        });
                assertEquals(Errno.EINVAL, nee.errno);
            }
            break;
            case FREE_BSD: {
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                int result = Aio.aio_error(aiocb);
                assertEquals(Errno.EINVAL, result);
            }
            break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> {
                            Aio.aio_error(new Aio.Aiocb());
                        });
                return;
            default:
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                int result = Aio.aio_error(aiocb);
                assertEquals(0, result);
        }
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
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case DARWIN: {
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                    Aio.aio_fsync(Fcntl.O_SYNC, aiocb);
                });

                assertEquals(Errno.EWOULDBLOCK, nee.errno);
            }
            break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Aio.aio_fsync(0, new Aio.Aiocb());
                });
                return;
            default:
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                    Aio.aio_fsync(Fcntl.O_SYNC, aiocb);
                });

                assertEquals(Errno.EBADF, nee.errno);
        }
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_fsync(0, null);
        });
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_read_ByteBuffer() throws Exception {
        System.out.println("aio_read");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> {
                            Aio.aio_read(new Aio.Aiocb());
                        });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";

                final Object[] objRef = new Object[1];
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");
                FileWriter fw = new FileWriter(tmpFile);
                fw.append(HELLO_WORLD);
                fw.flush();
                fw.close();

                final Aio.Aiocb<Aio.Aiocb> aiocb = new Aio.Aiocb<>();
                aiocb.aio_reqprio((int) Unistd.sysconf(Unistd._SC_AIO_PRIO_DELTA_MAX));

                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());
                assertEquals(1024, aioBuffer.remaining());
                assertEquals(1024, aiocb.aio_nbytes());

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
                                objRef[0] = a;
                                objRef.notify();
                            }
                            System.out.println("aio_read leave callback");
                        } catch (Exception ex) {
                            synchronized (objRef) {
                                objRef[0] = ex;
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
                                objRef[0] = nste;
                                objRef.notify();
                            }
                            throw new RuntimeException(nste);
                        }
                    }

                });

                switch (MULTIARCHTUPEL_BUILDER.getOS()) {
                    case DARWIN: {
                        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                            Aio.aio_read(aiocb);
                        });
                        assertEquals(Errno.EAGAIN, nee.errno);
                        //Stop the test here for darwin it cant handle aio with threaded callbacks
                        return;
                    }
                    case FREE_BSD: {
                        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                            Aio.aio_read(aiocb);
                        });
                        assertEquals(Errno.EINVAL, nee.errno);
                        //Stop the test here for FreeBSD it cant handle aio with threaded callbacks
                        return;
                    }
                    case LINUX:
                    default:
                        Aio.aio_read(aiocb);
                }

                synchronized (objRef) {
                    if (objRef[0] == null) {
                        objRef.wait(ONE_MINUTE);
                    }
                }

                Assertions.assertNotNull(objRef[0]);
                if (objRef[0] instanceof Exception) {
                    fail("in callback", (Exception) objRef[0]);
                } else {
                    assertEquals(aiocb, objRef[0]);
                }

                Unistd.close(aiocb.aio_fildes());
                int errno = Aio.aio_error(aiocb);
                assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                assertEquals(HELLO_WORLD.length(), aioBuffer.position());

                byte[] result = new byte[HELLO_WORLD.length()];
                aioBuffer.flip();
                aioBuffer.get(result);

                Assertions.assertArrayEquals(HELLO_WORLD.getBytes(), result);

                Assertions.assertThrows(NullPointerException.class,
                        () -> {
                            Aio.aio_read(null);
                        });
        }
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_read_ByteBuffer_NoSignal() throws Exception {
        System.out.println("aio_read");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> {
                            Aio.aio_read(new Aio.Aiocb());
                        });
                break;
            default:

                final String HELLO_WORLD = "Hello world!\n";

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
                assertEquals(1024, aioBuffer.remaining());
                assertEquals(1024, aiocb.aio_nbytes());

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());

                System.out.println("aio_read Pthread_t: " + Pthread.pthread_self());
                System.out.println("aio_read currentThread: " + Thread.currentThread());

                Aio.aio_read(aiocb);

                Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
                    int result;
                    do {
                        result = Aio.aio_error(aiocb);
                        if (result == Errno.EINPROGRESS) {
                            //no-op just wait
                        } else if (result == 0) {
                            break;
                        } else {
                            fail("testAio_write_Buffer_NoSignal errno: " + Errno.getErrnoSymbol(result));
                        }
                    } while (result == 0);
                });
                long bytesWritten = Aio.aio_return(aiocb);
                aioBuffer.position(aioBuffer.position() + (int) bytesWritten);

                Unistd.close(aiocb.aio_fildes());

                assertEquals(HELLO_WORLD.length(), aioBuffer.position());

                byte[] result = new byte[HELLO_WORLD.length()];
                aioBuffer.flip();
                aioBuffer.get(result);

                Assertions.assertArrayEquals(HELLO_WORLD.getBytes(), result);

                Assertions.assertThrows(NullPointerException.class,
                        () -> {
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
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> {
                            Aio.aio_read(new Aio.Aiocb());
                        });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final int SIVAL_INT = 0x01234567;

                final Object[] intRef = new Object[1];
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
                                intRef[0] = i;
                                intRef.notify();
                            }
                            System.out.println("aio_read leave callback");
                        } catch (Exception ex) {
                            synchronized (intRef) {
                                intRef[0] = ex;
                                intRef.notify();
                            }
                            throw new RuntimeException(ex);
                        }

                    }

                });

                //No read or write executed....
                switch (MULTIARCHTUPEL_BUILDER.getOS()) {
                    case DARWIN: {
                        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                            Aio.aio_error(aiocb);
                        });
                        assertEquals(Errno.EINVAL, nee.errno);
                        nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                            Aio.aio_read(aiocb);
                        });
                        assertEquals(Errno.EAGAIN, nee.errno);
                        //Stop the test here for darwin it cant handle aio with threaded callbacks
                        return;
                    }
                    case FREE_BSD: {
                        int errno = Aio.aio_error(aiocb);
                        assertEquals(Errno.EINVAL, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                            Aio.aio_read(aiocb);
                        });
                        assertEquals(Errno.EINVAL, nee.errno);
                        //Stop the test here for FreeBSD it cant handle aio with threaded callbacks
                        return;
                    }
                    case LINUX:
                    default:
                        int errno = Aio.aio_error(aiocb);
                        assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                        Aio.aio_read(aiocb);
                }

                int errno = Aio.aio_error(aiocb);
                if (errno == 0) {
                    //no-op read already finished
                } else {
                    assertEquals(Errno.EINPROGRESS, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                }

                synchronized (intRef) {
                    if (intRef[0] == null) {
                        intRef.wait(ONE_MINUTE);
                    }
                }
                Assertions.assertNotNull(intRef[0]);
                if (intRef[0] instanceof Exception) {
                    fail("in callback", (Exception) intRef[0]);
                } else {
                    assertEquals(Integer.valueOf(SIVAL_INT), intRef[0]);
                }

                errno = Aio.aio_error(aiocb);
                assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                assertEquals(0, Aio.aio_return(aiocb));
                assertEquals(0, aioBuffer.position());

                Unistd.close(aiocb.aio_fildes());
        }
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_readEmpty_NoSignal() throws Exception {
        System.out.println("aio_read empty file");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> {
                            Aio.aio_read(new Aio.Aiocb());
                        });
                break;
            default:
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");

                final Aio.Aiocb<Struct32> aiocb = new Aio.Aiocb<>();
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());

                System.out.println("aio_read Pthread_t: " + Pthread.pthread_self());
                System.out.println("aio_read currentThread: " + Thread.currentThread());

                //No read or write executed....
                if (MULTIARCHTUPEL_BUILDER.getOS() == OS.DARWIN) {
                    NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                        Aio.aio_error(aiocb);
                    });
                    assertEquals(Errno.EINVAL, nee.errno);
                } else {
                    int errno = Aio.aio_error(aiocb);
                    switch (MULTIARCHTUPEL_BUILDER.getOS()) {
                        case FREE_BSD:
                            assertEquals(Errno.EINVAL, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                            break;
                        default:
                            assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                    }
                }
                Aio.aio_read(aiocb);

                Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
                    int result;
                    do {
                        result = Aio.aio_error(aiocb);
                        if (result == Errno.EINPROGRESS) {
                            //no-op just wait
                        } else if (result == 0) {
                            break;
                        } else {
                            fail("testAio_write_Buffer_NoSignal errno: " + Errno.getErrnoSymbol(result));
                        }
                    } while (result == 0);
                });
                long bytesWritten = Aio.aio_return(aiocb);
                assertEquals(0, bytesWritten);
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
            case DARWIN: {
                final Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                long expResult = 0L;
                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                    Aio.aio_return(aiocb);
                });
                assertEquals(Errno.EINVAL, nee.errno);
            }
            break;
            case FREE_BSD: {
                final Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class,
                        () -> {
                            Aio.aio_return(aiocb);
                        });
                assertEquals(Errno.EINVAL, nee.errno);
            }
            break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> {
                            Aio.aio_return(new Aio.Aiocb());
                        });
                break;
            case LINUX:
            default:
                final Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                long expResult = 0L;
                long result = Aio.aio_return(aiocb);
                assertEquals(expResult, result);
        }
    }

    /**
     * Test of aio_suspend method, of class Aio.
     */
    @Test
    public void testAio_suspend() throws Exception {
        System.out.println("aio_suspend");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case DARWIN: {
                Aio.Aiocbs aiocbs = new Aio.Aiocbs(1, SetMem.DO_NOT_SET);
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);
                aiocbs.set(0, aiocb);
                Time.Timespec timeout = new Time.Timespec(SetMem.TO_0x00);
                timeout.tv_sec(1);

                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                    Aio.aio_suspend(aiocbs, timeout);
                });
                assertEquals(Errno.EINVAL, nee.errno);
            }
            break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> {
                            Aio.aio_suspend(new Aio.Aiocbs(0, SetMem.TO_0x00), new Time.Timespec(SetMem.TO_0x00));
                        });
                return;
            case LINUX:
            default: {
                Aio.Aiocbs aiocbs = new Aio.Aiocbs(1, SetMem.DO_NOT_SET);
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);
                aiocbs.set(0, aiocb);
                Time.Timespec timeout = new Time.Timespec(SetMem.TO_0x00);
                timeout.tv_sec(1);

                //Just a dry run....
                Aio.aio_suspend(aiocbs, timeout);
            }
        }

        Aio.Aiocbs aiocbs = new Aio.Aiocbs(1, SetMem.DO_NOT_SET);
        Aio.Aiocb aiocb = new Aio.Aiocb();
        aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
        aiocb.aio_fildes(-1);
        aiocbs.set(0, aiocb);
        Time.Timespec timeout = new Time.Timespec(SetMem.TO_0x00);
        timeout.tv_sec(1);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_suspend(null, timeout);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Aio.aio_suspend(aiocbs, null);
        });
    }

    /**
     * Test of aio_write method, of class Aio.
     */
    @Test
    public void testAio_write_ByteBuffer() throws Exception {
        System.out.println("aio_write");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> {
                            Aio.aio_write(new Aio.Aiocb());
                        });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";
                final int SIVAL_INT = 0x01234567;

                final Object[] intRef = new Object[1];
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
                                intRef[0] = i;
                                intRef.notify();
                            }
                            System.out.println("aio_write leave callback");
                        } catch (Exception ex) {
                            synchronized (intRef) {
                                intRef[0] = ex;
                                intRef.notify();
                            }
                            throw new RuntimeException(ex);
                        }
                    }

                });

                switch (MULTIARCHTUPEL_BUILDER.getOS()) {
                    case DARWIN: {
                        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                            Aio.aio_write(aiocb);
                        });
                        assertEquals(Errno.EAGAIN, nee.errno);
                        //Stop the test here for darwin it cant handle aio with threaded callbacks
                        return;
                    }
                    case FREE_BSD: {
                        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                            Aio.aio_write(aiocb);
                        });
                        assertEquals(Errno.EINVAL, nee.errno);
                        //Stop the test here for FreeBSD it cant handle aio with threaded callbacks
                        return;
                    }
                    case LINUX:
                    default:
                        Aio.aio_write(aiocb);
                }

                synchronized (intRef) {
                    if (intRef[0] == null) {
                        intRef.wait(ONE_MINUTE);
                    }
                }
                Assertions.assertNotNull(intRef[0]);
                if (intRef[0] instanceof Exception) {
                    fail("in callback", (Exception) intRef[0]);
                } else {
                    assertEquals(Integer.valueOf(SIVAL_INT), intRef[0]);
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
     * Test of aio_write method, of class Aio.
     */
    @Test
    public void testAio_write_Buffer_NoSignal() throws Exception {
        System.out.println("aio_write");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> {
                            Aio.aio_write(new Aio.Aiocb());
                        });
                break;
            default:
                final String HELLO_WORLD = "Hello world!\n";

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

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());

                System.out.println("aio_write Pthread_t: " + Pthread.pthread_self());
                System.out.println("aio_write currentThread: " + Thread.currentThread());

                Aio.aio_write(aiocb);

                Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
                    int result;
                    do {
                        result = Aio.aio_error(aiocb);
                        if (result == Errno.EINPROGRESS) {
                            //no-op just wait
                        } else if (result == 0) {
                            break;
                        } else {
                            fail("testAio_write_Buffer_NoSignal errno: " + Errno.getErrnoSymbol(result));
                        }
                    } while (result == 0);
                });
                long bytesWritten = Aio.aio_return(aiocb);
                assertEquals(HELLO_WORLD.length(), bytesWritten);

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
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Aio.lio_listio(0, new Aio.Aiocbs(0, SetMem.TO_0x00), new Signal.Sigevent());
                });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final Aio.Aiocbs list = new Aio.Aiocbs(1, SetMem.DO_NOT_SET);
                Aio.Aiocb aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);
                list.set(0, aiocb);

                if (MULTIARCHTUPEL_BUILDER.getOS() == OS.DARWIN) {
                    final boolean[] lock = new boolean[]{false};
                    new Thread(() -> {
                        try {
                            Aio.lio_listio(Aio.LIO_WAIT.get(), list);
                        } catch (Throwable t) {
                            fail(t);
                        }
                        synchronized (lock) {
                            lock[0] = true;
                            lock.notifyAll();
                        }
                    }).start();
                    synchronized (lock) {
                        lock.wait(1000);
                    }
                    Assertions.assertFalse(lock[0]);
                } else {
                    NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                        Aio.lio_listio(Aio.LIO_WAIT.get(), list);
                    });
                    assertEquals(Errno.EIO, nee.errno, Errno.getErrnoSymbol(nee.errno));
                }
                Assertions.assertThrows(NullPointerException.class, () -> {
                    Aio.lio_listio(Aio.LIO_WAIT.get(), null);
                });

                if (MULTIARCHTUPEL_BUILDER.getOS() == OS.FREE_BSD) {
                    NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                        Aio.lio_listio(Aio.LIO_NOWAIT.get(), list);
                    });
                    assertEquals(Errno.EIO, nee.errno, Errno.getErrnoSymbol(nee.errno));
                } else {
                    //Darwin ignores Aio.LIO_NOWAIT so we enforce a timeout here
                    Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
                        Aio.lio_listio(Aio.LIO_NOWAIT.get(), list);
                    });
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
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Aio.lio_listio(0, new Aio.Aiocbs(0, SetMem.TO_0x00), new Signal.Sigevent());
                });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";

                final Object[] objRef = new Object[0];
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");
                FileWriter fw = new FileWriter(tmpFile);
                fw.append(HELLO_WORLD);
                fw.flush();
                fw.close();

                final Aio.Aiocb<Aio.Aiocb> aiocb = new Aio.Aiocb();
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                aiocb.aio_lio_opcode(Aio.LIO_READ.get());
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());

                Aio.Aiocbs list = new Aio.Aiocbs(1, SetMem.DO_NOT_SET);
                list.set(0, aiocb);

                Aio.lio_listio(Aio.LIO_NOWAIT.get(), list);
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
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_read_ByteBuffer_NativeRunnable() throws Exception {
        System.out.println("aio_read");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> {
                            Aio.aio_read(new Aio.Aiocb());
                        });
                break;
            default:
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";

                final Object[] objRef = new Object[1];
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
                            objRef[0] = aiocb;
                            objRef.notify();
                        }
                        System.out.println("aio_read leave callback");
                    }

                };
                aiocb.aio_sigevent.sigev_value.sival_ptr(callback);
                switch (MULTIARCHTUPEL_BUILDER.getOS()) {
                    case DARWIN: {
                        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                            Aio.aio_read(aiocb);
                        });
                        assertEquals(Errno.EAGAIN, nee.errno);
                        //Stop the test here for darwin it cant handle aio with threaded callbacks
                        return;
                    }
                    case FREE_BSD: {
                        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                            Aio.aio_read(aiocb);
                        });
                        assertEquals(Errno.EINVAL, nee.errno);
                        //Stop the test here for FreeBSD it cant handle aio with threaded callbacks
                        return;
                    }
                    case LINUX:
                    default:
                        Aio.aio_read(aiocb);
                }

                synchronized (objRef) {
                    if (objRef[0] == null) {
                        objRef.wait(ONE_MINUTE);
                    }
                    assertEquals(aiocb, objRef[0]);
                }

                Unistd.close(aiocb.aio_fildes());
                int errno = Aio.aio_error(aiocb);
                assertEquals(0, errno, "Got errno from aio_read: " + Errno.getErrnoSymbol(errno) + ": " + StringHeader.strerror(errno));
                assertEquals(HELLO_WORLD.length(), aioBuffer.position());

                byte[] result = new byte[HELLO_WORLD.length()];
                aioBuffer.flip();
                aioBuffer.get(result);

                Assertions.assertArrayEquals(HELLO_WORLD.getBytes(), result);

                Assertions.assertThrows(NullPointerException.class,
                        () -> {
                            Aio.aio_read(null);
                        });
        }
    }

}
