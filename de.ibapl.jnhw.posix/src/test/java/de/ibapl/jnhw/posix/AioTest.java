/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.libloader.librarys.LibrtLoader;
import de.ibapl.jnhw.util.posix.DefinesTest;
import de.ibapl.jnhw.util.posix.upcall.CallbackFactory__V__UnionSigval;
import de.ibapl.jnhw.util.posix.upcall.Callback__V__UnionSigval;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class AioTest {

    // just for vm in qemu...
    private final static long ONE_MINUTE = 60_000;
    private final static long ONE_SECOND = 1_000;

    @BeforeAll
    public static void checkBeforeAll_HAVE_AIO_H() throws Exception {
        JnhwTestLogger.logBeforeAllBeginn("checkBeforeAll_HAVE_AIO_H");
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD, WINDOWS ->
                assertFalse(Aio.HAVE_AIO_H, "expected not to have aio.h");
            default ->
                assertTrue(Aio.HAVE_AIO_H, "expected to have aio.h");
        }
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_HAVE_AIO_H");
    }

    @BeforeAll
    public static void checkBeforeAll_AioDefines() throws Exception {
        JnhwTestLogger.logBeforeAllBeginn("checkBeforeAll_AioDefines");
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Aio.class, "HAVE_AIO_H");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_AioDefines");
    }

    @BeforeAll
    public static void checkBeforeAll_StructAiocb() throws Exception {
        JnhwTestLogger.logBeforeAllBeginn("checkBeforeAll_StructAiocb");
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_StructAiocb");
            return;
        }
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD ->
                assertThrows(NoSuchNativeTypeException.class, () -> {
                    try (MemorySession ms = MemorySession.openConfined()) {
                        Aio.Aiocb.tryAllocateNative(ms);
                    }
                });
            default ->
                assertAll(
                        () -> assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Aiocb_sizeof"), Aio.Aiocb.sizeof, "sizeof"),
                        () -> assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Aiocb_alignof"), Aio.Aiocb.alignof.alignof, "alignof"),
                        () -> assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Aiocb_offsetof_aio_fildes"), Aio.Aiocb.offsetof_Aio_fildes, "offsetof_Aio_fildes"),
                        () -> assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Aiocb_offsetof_aio_offset"), Aio.Aiocb.offsetof_Aio_offset, "offsetof_Aio_offset"),
                        () -> assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Aiocb_offsetof_aio_buf"), Aio.Aiocb.offsetof_Aio_buf, "offsetof_Aio_buf"),
                        () -> assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Aiocb_offsetof_aio_nbytes"), Aio.Aiocb.offsetof_Aio_nbytes, "offsetof_Aio_nbytes"),
                        () -> assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Aiocb_offsetof_aio_reqprio"), Aio.Aiocb.offsetof_Aio_reqprio, "offsetof_Aio_reqprio"),
                        () -> assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Aiocb_offsetof_aio_sigevent"), Aio.Aiocb.offsetof_Aio_sigevent, "offsetof_Aio_sigevent"),
                        () -> assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Aiocb_offsetof_aio_lio_opcode"), Aio.Aiocb.offsetof_Aio_lio_opcode, "offsetof_Aio_lio_opcode")
                );
        }
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_StructAiocb");
    }

    private MemorySession sharedSession;

    @BeforeEach
    public void setUp(TestInfo testInfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testInfo);
        assertEquals(CallbackFactory__V__UnionSigval.MAX_CALL_BACKS, CallbackFactory__V__UnionSigval.callbacksAvailable());
        sharedSession = MemorySession.openShared();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        sharedSession.close();
        assertEquals(CallbackFactory__V__UnionSigval.MAX_CALL_BACKS, CallbackFactory__V__UnionSigval.callbacksAvailable());
        JnhwTestLogger.logAfterEach(testInfo);
    }

    /**
     * Test struct aiocb.
     */
    @Test
    public void testStructAiocb() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD ->
                assertThrows(NoSuchNativeTypeException.class, () -> {
                    Aio.Aiocb.tryAllocateNative(sharedSession);
                });
            default -> {
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                JnhwTestLogger.logTest("aiocb : " + aiocb.nativeToString());
                assertEquals(MemoryAddress.NULL, aiocb.aio_buf());

                ByteBuffer buf = ByteBuffer.allocateDirect(128);
                buf.position(16);
                buf.limit(64);
                aiocb.aio_fildes(-1);
                assertEquals(-1, aiocb.aio_fildes());
                aiocb.aio_buf(buf);
                assertNotEquals(MemoryAddress.NULL, aiocb.aio_buf());
                assertEquals(0, aiocb.aio_offset());
                assertEquals(48, aiocb.aio_nbytes());
                aiocb.aio_offset(8);
                assertEquals(8, aiocb.aio_offset());

                JnhwTestLogger.logTest("aiocb : " + aiocb.nativeToString());
            }
        }
    }

    /**
     * Test members of struct Aiocb[].
     */
    @Test
    public void testAiocbs() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD ->
                assertFalse(Aio.HAVE_AIO_H);
            default -> {
                Aio.Aiocbs aiocbs = Aio.Aiocbs.tryAllocateNative(sharedSession, 1);

                Aio.Aiocb aiocb_null = aiocbs.get(0, null);
                assertNull(aiocb_null);

                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_fildes(-1);
                aiocbs.set(0, aiocb);

                Aio.Aiocb aiocb_get = aiocbs.get(0, null);
                assertEquals(aiocb, aiocb_get);
            }
        }

    }

    /**
     * Test of aio_cancel method, of class Aio.
     */
    @Test
    public void testAio_cancel() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN -> {
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                int result = Aio.aio_cancel(aiocb);
                assertEquals(Aio.AIO_ALLDONE.get(), result);

                result = Aio.aio_cancel(-1);
                assertEquals(Aio.AIO_ALLDONE.get(), result);
            }
            case OPEN_BSD ->
                // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_cancel").isEmpty(), "aio_cancel is available");
            default -> {
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                NativeErrorException nee = assertThrows(NativeErrorException.class,
                        () -> Aio.aio_cancel(aiocb));
                assertEquals(Errno.EBADF, nee.errno);

                nee = assertThrows(NativeErrorException.class, () -> Aio.aio_cancel(-1));
                assertEquals(Errno.EBADF, nee.errno);
            }
        }
    }

    /**
     * Test of aio_error method, of class Aio.
     */
    @Test
    public void testAio_error() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN -> {
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);
                NativeErrorException nee = assertThrows(NativeErrorException.class,
                        () -> Aio.aio_error(aiocb));
                assertEquals(Errno.EINVAL, nee.errno);
            }
            case FREE_BSD -> {
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);
                assertEquals(Errno.EINVAL, Aio.aio_error(aiocb));
            }
            case OPEN_BSD -> {
                // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_error").isEmpty(), "aio_error is available");
                return;
            }
            default -> {
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);
                assertEquals(0, Aio.aio_error(aiocb));
            }
        }
        assertThrows(NullPointerException.class, () -> Aio.aio_error(null));
    }

    /**
     * Test of aio_fsync method, of class Aio.
     */
    @Test
    public void testAio_fsync() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN -> {
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                NativeErrorException nee = assertThrows(NativeErrorException.class, () -> {
                    Aio.aio_fsync(Fcntl.O_SYNC, aiocb);
                });

                assertEquals(Errno.EWOULDBLOCK, nee.errno);
            }
            case OPEN_BSD -> {
                // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_fsync").isEmpty(), "aio_fsync is available");
                return;
            }
            default -> {
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                NativeErrorException nee = assertThrows(NativeErrorException.class,
                        () -> Aio.aio_fsync(Fcntl.O_SYNC, aiocb));

                assertEquals(Errno.EBADF, nee.errno, "errno != EBADF");
            }
        }
        assertThrows(NullPointerException.class, () -> Aio.aio_fsync(0, null));
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_read_ByteBuffer() throws Throwable {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD ->
                // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_read").isEmpty(), "aio_read is available");
            default -> {
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";

                final Object[] objRef = new Object[1];
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");
                try (FileWriter fw = new FileWriter(tmpFile)) {
                    fw.append(HELLO_WORLD);
                    fw.flush();
                }

                @SuppressWarnings("unchecked")
                final Aio.Aiocb<Aio.Aiocb> aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
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

                JnhwTestLogger.logTest("aio_read aiocb.aio_sigevent.sigev_value: " + aiocb.aio_sigevent.sigev_value);
                JnhwTestLogger.logTest("aio_read Pthread_t: " + Pthread.pthread_self(sharedSession));
                JnhwTestLogger.logTest("aio_read currentThread: " + Thread.currentThread());

                Callback__V__UnionSigval cb = new Callback__V__UnionSigval<Aio.Aiocb>() {

                    @Override
                    @SuppressWarnings("unchecked")
                    protected void callback(MemoryAddress sival_ptr, int sival_int) {
                        try {
                            assertEquals(OpaqueMemory.getMemorySegment(aiocb).address().toRawLongValue(), sival_ptr.toRawLongValue(), "testAio_read_ByteBuffer callback MemoryAddress mismatch");
                            final Aio.Aiocb callback_aiocb;
                            callback_aiocb = Aio.Aiocb.tryOfAddress(sival_ptr, sharedSession);

                            JnhwTestLogger.logTest("aio_read enter callback Pthread_t: " + Pthread.pthread_self(sharedSession));
                            JnhwTestLogger.logTest("aio_read in callback currentThread: " + Thread.currentThread());
                            assertEquals(0, Aio.aio_error(callback_aiocb));

                            aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(callback_aiocb));
                            synchronized (objRef) {
                                objRef[0] = sival_ptr;
                                objRef.notify();
                            }
                            JnhwTestLogger.logTest("aio_read leave callback");
                        } catch (Throwable t) {
                            synchronized (objRef) {
                                objRef[0] = t;
                                objRef.notify();
                            }
                        }
                    }

                };
                try {
                    aiocb.aio_sigevent.sigev_notify_function(cb);

                    switch (MultiarchTupelBuilder.getOS()) {
                        case DARWIN -> {
                            NativeErrorException nee = assertThrows(NativeErrorException.class, () -> {
                                Aio.aio_read(aiocb);
                            });
                            assertEquals(Errno.EAGAIN, nee.errno);
                            //Stop the test here for darwin it cant handle aio with threaded callbacks
                            return;
                        }
                        default ->
                            Aio.aio_read(aiocb);
                    }

                    synchronized (objRef) {
                        if (objRef[0] == null) {
                            objRef.wait(ONE_SECOND);
                            if (objRef[0] == null) {
                                objRef.wait(ONE_MINUTE);
                            }
                        }
                    }

                    assertNotNull(objRef[0]);
                    if (objRef[0] instanceof Throwable throwable) {
                        throw throwable;
                    } else {
                        assertEquals(aiocb.toAddressable().address(), objRef[0]);
                    }

                    Unistd.close(aiocb.aio_fildes());
                    if (MultiarchTupelBuilder.getOS() == OS.FREE_BSD) {
                        assertEquals(Errno.EINVAL, Aio.aio_error(aiocb));
                    } else {
                        assertEquals(0, Aio.aio_error(aiocb));
                    }
                    assertEquals(HELLO_WORLD.length(), aioBuffer.position());

                    byte[] result = new byte[HELLO_WORLD.length()];
                    aioBuffer.flip();
                    aioBuffer.get(result);

                    assertArrayEquals(HELLO_WORLD.getBytes(), result);

                    assertThrows(NullPointerException.class,
                            () -> Aio.aio_read(null));
                } finally {
                    cb.release();
                }
            }

        }
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_read_ByteBuffer_NoSignal() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD ->
                // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_read").isEmpty(), "aio_read is available");
            default -> {
                final String HELLO_WORLD = "Hello world!\n";

                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");
                try (FileWriter fw = new FileWriter(tmpFile)) {
                    fw.append(HELLO_WORLD);
                    fw.flush();
                }

                @SuppressWarnings("unchecked")
                final Aio.Aiocb<Aio.Aiocb> aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);

                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());
                assertEquals(1024, aioBuffer.remaining());
                assertEquals(1024, aiocb.aio_nbytes());

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());

                JnhwTestLogger.logTest("aio_read Pthread_t: " + Pthread.pthread_self(sharedSession));
                JnhwTestLogger.logTest("aio_read currentThread: " + Thread.currentThread());

                Aio.aio_read(aiocb);

                assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
                    while (Errno.EINPROGRESS == Aio.aio_error(aiocb)) {
                        Thread.sleep(10);
                    }
                });
                assertEquals(0, Aio.aio_error(aiocb));
                long bytesWritten = Aio.aio_return(aiocb);
                aioBuffer.position(aioBuffer.position() + (int) bytesWritten);

                Unistd.close(aiocb.aio_fildes());

                assertEquals(HELLO_WORLD.length(), aioBuffer.position());

                byte[] result = new byte[HELLO_WORLD.length()];
                aioBuffer.flip();
                aioBuffer.get(result);

                assertArrayEquals(HELLO_WORLD.getBytes(), result);

                assertThrows(NullPointerException.class,
                        () -> Aio.aio_read(null));
            }

        }
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_readEmpty() throws Throwable {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD ->
                // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_read").isEmpty(), "aio_read is available");
            default -> {
                //Clean up references to Callbacks
                System.gc();

                final int SIVAL_INT = 0x01234321;

                final Object[] intRef = new Object[1];
                final File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");

                @SuppressWarnings("unchecked")
                final Aio.Aiocb<Struct> aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_THREAD.get());
                aiocb.aio_sigevent.sigev_value.sival_int(SIVAL_INT);

                JnhwTestLogger.logTest("aio_read aiocb.aio_sigevent.sigev_value: " + aiocb.aio_sigevent.sigev_value);
                JnhwTestLogger.logTest("aio_read Pthread_t: " + Pthread.pthread_self(sharedSession));
                JnhwTestLogger.logTest("aio_read currentThread: " + Thread.currentThread());

                Callback__V__UnionSigval cb = new Callback__V__UnionSigval() {

                    @Override
                    protected void callback(MemoryAddress sival_ptr, int sival_int) {
                        try {
                            assertEquals(SIVAL_INT, sival_int);
                            JnhwTestLogger.logTest("aio_read enter callback Pthread_t: " + Pthread.pthread_self(sharedSession));
                            JnhwTestLogger.logTest("aio_read in callback currentThread: " + Thread.currentThread());
                            assertEquals(0, Aio.aio_error(aiocb));
                            aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(aiocb));
                            synchronized (intRef) {
                                intRef[0] = sival_int;
                                intRef.notify();
                            }
                            JnhwTestLogger.logTest("aio_read leave callback");
                        } catch (Throwable t) {
                            synchronized (intRef) {
                                intRef[0] = t;
                                intRef.notify();
                            }
                        }

                    }
                };
                try {
                    aiocb.aio_sigevent.sigev_notify_function(cb);

                    //No read or write executed....
                    switch (MultiarchTupelBuilder.getOS()) {
                        case DARWIN -> {
                            NativeErrorException nee = assertThrows(NativeErrorException.class, () -> {
                                Aio.aio_error(aiocb);
                            });
                            assertEquals(Errno.EINVAL, nee.errno);
                            nee = assertThrows(NativeErrorException.class, () -> {
                                Aio.aio_read(aiocb);
                            });
                            assertEquals(Errno.EAGAIN, nee.errno);
                            //Stop the test here for darwin it cant handle aio with threaded callbacks
                            return;
                        }
                        case FREE_BSD -> {
                            assertEquals(Errno.EINVAL, Aio.aio_error(aiocb));
                            fail("TODO I dont knwo what to expect");
                            return;
                        }
                        default -> {
                            assertEquals(0, Aio.aio_error(aiocb));
                            Aio.aio_read(aiocb);
                        }
                    }

                    switch (MultiarchTupelBuilder.getOS()) {
                        case FREE_BSD ->
                            assertEquals(Errno.EINVAL, Aio.aio_error(aiocb));
                        case LINUX ->
                            assertEquals(Errno.EINPROGRESS, Aio.aio_error(aiocb));
                        default ->
                            //catch any new OS here ....
                            assertEquals(-1, Aio.aio_error(aiocb));
                    }

                    synchronized (intRef) {
                        if (intRef[0] == null) {
                            intRef.wait(ONE_SECOND);
                            if (intRef[0] == null) {
                                intRef.wait(ONE_MINUTE);
                            }
                        }
                    }
                    assertNotNull(intRef[0]);
                    if (intRef[0] instanceof Throwable throwable) {
                        throw throwable;
                    } else {
                        assertEquals(SIVAL_INT, intRef[0]);
                    }

                    assertEquals(0, Aio.aio_error(aiocb));
                    assertEquals(0, Aio.aio_return(aiocb));
                    assertEquals(0, aioBuffer.position());

                    Unistd.close(aiocb.aio_fildes());
                } finally {
                    cb.release();
                    tmpFile.delete();
                }
            }
        }
    }

    /**
     * Test of aio_read method, of class Aio.
     */
    @Test
    public void testAio_readEmpty_NoSignal() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD ->
                // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_read").isEmpty(), "aio_read is available");
            default -> {
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");

                @SuppressWarnings("unchecked")
                final Aio.Aiocb<Struct> aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());

                JnhwTestLogger.logTest("aio_read Pthread_t: " + Pthread.pthread_self(sharedSession));
                JnhwTestLogger.logTest("aio_read currentThread: " + Thread.currentThread());

                //No read or write executed....
                switch (MultiarchTupelBuilder.getOS()) {
                    case DARWIN -> {
                        NativeErrorException nee = assertThrows(NativeErrorException.class,
                                () -> Aio.aio_error(aiocb));
                        assertEquals(Errno.EINVAL, nee.errno);
                    }
                    case FREE_BSD -> {
                        assertEquals(Errno.EINVAL, Aio.aio_error(aiocb));
                    }
                    default -> {
                        assertEquals(0, Aio.aio_error(aiocb));
                    }
                }
                Aio.aio_read(aiocb);

                assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
                    while (Errno.EINPROGRESS == Aio.aio_error(aiocb)) {
                        Thread.sleep(10);
                    }
                });
                long bytesRead = Aio.aio_return(aiocb);
                assertEquals(0, bytesRead);
                assertEquals(0, aioBuffer.position());

                Unistd.close(aiocb.aio_fildes());
            }
        }
    }

    /**
     * Test of aio_return method, of class Aio. is tested in read/write too
     */
    @Test
    public void testAio_return() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN -> {
                final Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                long expResult = 0L;
                NativeErrorException nee = assertThrows(NativeErrorException.class,
                        () -> Aio.aio_return(aiocb));
                assertEquals(Errno.EINVAL, nee.errno);
            }
            case FREE_BSD -> {
                final Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                NativeErrorException nee = assertThrows(NativeErrorException.class,
                        () -> Aio.aio_return(aiocb));
                assertEquals(Errno.EINVAL, nee.errno);
            }
            case OPEN_BSD ->
                // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_return").isEmpty(), "aio_return is available");
            default -> {
                final Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);

                long expResult = 0L;
                long result = Aio.aio_return(aiocb);
                assertEquals(expResult, result);
            }
        }
    }

    /**
     * Test of aio_suspend method, of class Aio.
     */
    @Test
    public void testAio_suspend() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN -> {
                Aio.Aiocbs aiocbs = Aio.Aiocbs.tryAllocateNative(sharedSession, 1);
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);
                aiocbs.set(0, aiocb);
                Time.Timespec timeout = Time.Timespec.allocateNative(sharedSession);
                timeout.tv_sec(1);

                NativeErrorException nee = assertThrows(NativeErrorException.class,
                        () -> Aio.aio_suspend(aiocbs, timeout));
                assertEquals(Errno.EINVAL, nee.errno);
            }
            case OPEN_BSD -> {
                // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_suspend").isEmpty(), "aio_suspend is available");
                return;
            }
            default -> {
                Aio.Aiocbs aiocbs = Aio.Aiocbs.tryAllocateNative(sharedSession, 1);
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);
                aiocbs.set(0, aiocb);
                Time.Timespec timeout = Time.Timespec.allocateNative(sharedSession);
                timeout.tv_sec(1);

                //Just a dry run....
                Aio.aio_suspend(aiocbs, timeout);
            }
        }

        Aio.Aiocbs aiocbs = Aio.Aiocbs.tryAllocateNative(sharedSession, 1);
        Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
        aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
        aiocb.aio_fildes(-1);
        aiocbs.set(0, aiocb);
        Time.Timespec timeout = Time.Timespec.allocateNative(sharedSession);
        timeout.tv_sec(1);

        assertThrows(NullPointerException.class,
                () -> Aio.aio_suspend(null, timeout));
        assertThrows(NullPointerException.class,
                () -> Aio.aio_suspend(aiocbs, null));
    }

    /**
     * Test of aio_write method, of class Aio.
     */
    @Test
    public void testAio_write_ByteBuffer() throws Throwable {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD -> // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_write").isEmpty(), "aio_write is available");
            default -> {
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";
                final int SIVAL_INT = 0x01234567;

                final Object[] ref = new Object[1];
                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Write", ".txt");

                @SuppressWarnings("unchecked")
                final Aio.Aiocb<Struct> aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
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

                JnhwTestLogger.logTest("aio_write aiocb.aio_sigevent.sigev_value: " + aiocb.aio_sigevent.sigev_value);
                JnhwTestLogger.logTest("aio_write Pthread_t: " + Pthread.pthread_self(sharedSession));
                JnhwTestLogger.logTest("aio_write currentThread: " + Thread.currentThread());

                Callback__V__UnionSigval cb = new Callback__V__UnionSigval() {

                    @Override
                    protected void callback(MemoryAddress sival_ptr, int sival_int) {
                        try {
                            assertEquals(SIVAL_INT, sival_int);
                            JnhwTestLogger.logTest("aio_write enter callback Pthread_t: " + Pthread.pthread_self(sharedSession));
                            JnhwTestLogger.logTest("aio_write in callback currentThread: " + Thread.currentThread());
                            assertEquals(0, Aio.aio_error(aiocb));
                            aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(aiocb));
                            synchronized (ref) {
                                ref[0] = sival_int;
                                ref.notify();
                            }
                            JnhwTestLogger.logTest("aio_write leave callback");
                        } catch (Throwable t) {
                            synchronized (ref) {
                                ref[0] = t;
                                ref.notify();
                            }
                        }
                    }

                };
                try {
                    aiocb.aio_sigevent.sigev_notify_function(cb);

                    switch (MultiarchTupelBuilder.getOS()) {
                        case DARWIN -> {
                            NativeErrorException nee = assertThrows(NativeErrorException.class,
                                    () -> Aio.aio_write(aiocb));
                            assertEquals(Errno.EAGAIN, nee.errno);
                            //Stop the test here for darwin it cant handle aio with threaded callbacks
                            return;
                        }
                        default ->
                            Aio.aio_write(aiocb);
                    }

                    synchronized (ref) {
                        if (ref[0] == null) {
                            ref.wait(ONE_SECOND);
                            if (ref[0] == null) {
                                ref.wait(ONE_MINUTE);
                            }
                        }
                    }
                    assertNotNull(ref[0]);
                    if (ref[0] instanceof Throwable throwable) {
                        throw throwable;
                    } else {
                        assertEquals(SIVAL_INT, ref[0]);
                    }

                    Unistd.close(aiocb.aio_fildes());
                    FileReader fr = new FileReader(tmpFile);
                    BufferedReader br = new BufferedReader(fr);
                    String result = br.readLine() + '\n';
                    assertEquals(HELLO_WORLD, result);
                    assertThrows(NullPointerException.class,
                            () -> Aio.aio_write(null));
                } finally {
                    cb.release();
                }
            }
        }
    }

    /**
     * Test of aio_write method, of class Aio.
     */
    @Test
    public void testAio_write_Buffer_NoSignal() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD -> // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("aio_write").isEmpty(), "aio_write is available");
            default -> {
                final String HELLO_WORLD = "Hello world!\n";

                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Write", ".txt");

                @SuppressWarnings("unchecked")
                final Aio.Aiocb<Struct> aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);
                aioBuffer.put(HELLO_WORLD.getBytes());

                aioBuffer.flip();
                aiocb.aio_buf(aioBuffer);
                assertEquals(HELLO_WORLD.length(), aiocb.aio_nbytes());
                assertEquals(0, aioBuffer.position());
                assertEquals(HELLO_WORLD.length(), aioBuffer.remaining());

                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());

                JnhwTestLogger.logTest("aio_write Pthread_t: " + Pthread.pthread_self(sharedSession));
                JnhwTestLogger.logTest("aio_write currentThread: " + Thread.currentThread());

                Aio.aio_write(aiocb);

                assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
                    while (Errno.EINPROGRESS == Aio.aio_error(aiocb)) {
                        Thread.sleep(10);
                    }
                });
                long bytesWritten = Aio.aio_return(aiocb);
                assertEquals(HELLO_WORLD.length(), bytesWritten);

                Unistd.close(aiocb.aio_fildes());
                FileReader fr = new FileReader(tmpFile);
                BufferedReader br = new BufferedReader(fr);
                String result = br.readLine() + '\n';
                assertEquals(HELLO_WORLD, result);
                assertThrows(NullPointerException.class,
                        () -> Aio.aio_write(null));
            }
        }
    }

    /**
     * Test of lio_listio method, of class Aio.
     */
    @Test
    public void testLio_listio() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD -> // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("lio_listio").isEmpty(), "lio_listio is available");
            default -> {
                //Clean up references to Callbacks
                System.gc();

                final Aio.Aiocbs list = Aio.Aiocbs.tryAllocateNative(sharedSession, 1);
                Aio.Aiocb aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(-1);
                list.set(0, aiocb);

                assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
                    if (MultiarchTupelBuilder.getOS() == OS.DARWIN) {
                        //TODO qeued, but invalid file descriptor...
                        Aio.lio_listio(Aio.LIO_WAIT.get(), list);
                        NativeErrorException nee = assertThrows(NativeErrorException.class,
                                () -> Aio.aio_error(aiocb));
                        assertEquals(Errno.EINVAL, nee.errno);
                    } else {
                        NativeErrorException nee = assertThrows(NativeErrorException.class,
                                () -> Aio.lio_listio(Aio.LIO_WAIT.get(), list));
                        assertEquals(Errno.EIO, nee.errno, Errno.getErrnoSymbol(nee.errno));
                    }
                });

                assertThrows(NullPointerException.class,
                        () -> Aio.lio_listio(Aio.LIO_WAIT.get(), null));

                if (MultiarchTupelBuilder.getOS() == OS.FREE_BSD) {
                    NativeErrorException nee = assertThrows(NativeErrorException.class,
                            () -> Aio.lio_listio(Aio.LIO_NOWAIT.get(), list));
                    assertEquals(Errno.EIO, nee.errno, Errno.getErrnoSymbol(nee.errno));
                } else {
                    //Darwin ignores Aio.LIO_NOWAIT so we enforce a timeout here
                    assertTimeoutPreemptively(Duration.ofSeconds(1),
                            () -> Aio.lio_listio(Aio.LIO_NOWAIT.get(), list)
                    );
                }
            }
        }
    }

    /**
     * Test of lio_listio method, of class Aio.
     */
    @Test
    public void testReadLio_listio() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD -> // preconditions not met can only test this this way.
                assertTrue(LibrtLoader.LIB_RT_SYMBOL_LOOKUP.lookup("lio_listio").isEmpty(), "lio_listio is available");
            default -> {
                //Clean up references to Callbacks
                System.gc();

                final String HELLO_WORLD = "Hello world!\n";

                File tmpFile = File.createTempFile("Jnhw-Posix-Aio-Test-Read", ".txt");
                try (FileWriter fw = new FileWriter(tmpFile)) {
                    fw.append(HELLO_WORLD);
                    fw.flush();
                }

                @SuppressWarnings("unchecked")
                final Aio.Aiocb<Aio.Aiocb> aiocb = Aio.Aiocb.tryAllocateNative(sharedSession);
                aiocb.aio_sigevent.sigev_notify(Signal.SIGEV_NONE.get());
                aiocb.aio_fildes(Fcntl.open(tmpFile.getAbsolutePath(), Fcntl.O_RDWR));
                aiocb.aio_lio_opcode(Aio.LIO_READ.get());
                final ByteBuffer aioBuffer = ByteBuffer.allocateDirect(1024);

                aioBuffer.clear();
                aiocb.aio_buf(aioBuffer);
                assertEquals(0, aioBuffer.position());

                Aio.Aiocbs list = Aio.Aiocbs.tryAllocateNative(sharedSession, 1);
                list.set(0, aiocb);

                Aio.lio_listio(Aio.LIO_NOWAIT.get(), list);
                assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
                    while (Errno.EINPROGRESS == Aio.aio_error(aiocb)) {
                        Thread.sleep(10);
                    }
                });

                aioBuffer.position(aioBuffer.position() + (int) Aio.aio_return(aiocb));

                assertEquals(HELLO_WORLD.length(), aioBuffer.position());

                byte[] result = new byte[HELLO_WORLD.length()];
                aioBuffer.flip();
                aioBuffer.get(result);

                assertArrayEquals(HELLO_WORLD.getBytes(), result);

                Unistd.close(aiocb.aio_fildes());
            }

        }
    }

}
