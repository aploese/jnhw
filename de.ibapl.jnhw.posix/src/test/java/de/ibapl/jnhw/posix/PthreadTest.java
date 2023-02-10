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
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.posix.sys.Types;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.lang.foreign.Arena;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class PthreadTest {

    @BeforeAll
    public static void checkBeforeAll_HAVE_PTHREAD_H() throws Exception {
        JnhwTestLogger.logBeforeAllBegin("checkBeforeAll_HAVE_PTHREAD_H");
        Assertions.assertTrue(Pthread.HAVE_PTHREAD_H, "expected to have pthread.h");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_HAVE_PTHREAD_H");
    }

    @BeforeAll
    public static void checkBeforeAll_PthreadDefines() throws Exception {
        JnhwTestLogger.logBeforeAllBegin("checkBeforeAll_PthreadDefines");
        DefinesTest.testDefines(Pthread.class, "HAVE_PTHREAD_H");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_PthreadDefines");
    }

    @BeforeAll
    public static void checkBeforeAll_NativePthread_attr_t() throws Exception {
        JnhwTestLogger.logBeforeAllBegin("checkBeforeAll_NativePthread_attr_t");
        Assertions.assertAll(
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Pthread_attr_t_sizeof"), Pthread.Pthread_attr_t.sizeof, "sizeof"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Pthread_attr_t_alignof"), Pthread.Pthread_attr_t.alignof.alignof, "alignof")
        );
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_NativePthread_attr_t");
    }

    @BeforeAll
    public static void checkBeforeAll_NativePthread_t() throws Exception {
        JnhwTestLogger.logBeforeAllBegin("checkBeforeAll_NativePthread_t");
        Assertions.assertAll(
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Pthread_t_sizeof"), Pthread.Pthread_t.sizeof, "sizeof"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("Pthread_t_alignof"), Pthread.Pthread_t.alignof.alignof, "alignof")
        );
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_NativePthread_t");
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    private Arena ms;

    @BeforeEach
    public void setUp(TestInfo testInfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testInfo);
        ms = Arena.openConfined();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        ms.close();
        JnhwTestLogger.logAfterEach(testInfo);
    }

    /**
     * Test of pthread_self method, of class Pthread.
     */
    @Test
    public void testPthread_self() {
        Pthread.Pthread_t result = Pthread.pthread_self(ms.scope());
        Assertions.assertNotNull(result);
        JnhwTestLogger.logTest("PTHREAD ID: " + result);
    }

    /**
     * Test of pthread_equal method, of class Pthread.
     */
    @Test
    public void testPthread_equal() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_equal(null, Pthread.pthread_self(ms.scope()));
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_equal(Pthread.pthread_self(ms.scope()), null);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_equal(null, null);
        });
        final Pthread.Pthread_t t1 = Pthread.pthread_self(ms.scope());
        final Pthread.Pthread_t t2 = Pthread.pthread_self(ms.scope());

        Assertions.assertTrue(Pthread.pthread_equal(t1, t2));

        final Pthread.Pthread_t[] objectRef = new Pthread.Pthread_t[1];
//        final ResourceScope sharedScope = scope;
//        final ResourceScope sharedScope = ResourceScope.newSharedScope();
//        scope.keepAlive(sharedScope);
        Thread t3 = new Thread(() -> {
            try {
                //TODO move outside - currently junit will crash
                final Arena sharedSession = Arena.openShared();
                objectRef[0] = Pthread.pthread_self(sharedSession.scope());
            } catch (Throwable t) {
                Assertions.fail(t);
            }
        });
        t3.start();
        t3.join();

        Assertions.assertNotEquals(t3.toString(), objectRef[0].toString());
        boolean result = Pthread.pthread_equal(t1, objectRef[0]);
        Assertions.assertFalse(result);

    }

    /**
     * Test of pthread_getcpuclockid method, of class Pthread.
     */
    @Test
    public void testPthread_getcpuclockid() throws Exception {
        Types.Clockid_t clock_id = Types.Clockid_t.allocateNative(ms.scope());
        switch (MultiarchTupelBuilder.getOS()) {
            case APPLE ->
                Assertions.assertThrows(NoSuchNativeMethodException.class,
                        () -> Pthread.pthread_getcpuclockid(Pthread.pthread_self(ms.scope()), clock_id));
            default -> {
                Assertions.assertThrows(NullPointerException.class,
                        () -> Pthread.pthread_getcpuclockid(null, clock_id));
//This will crash with SIGSEV
//            Pthread.pthread_getcpuclockid(Pthread.Pthread_t.ofAddress(MemorySegment.ofAddress(1024), scope), clock_id);
                Pthread.pthread_getcpuclockid(Pthread.pthread_self(ms.scope()), clock_id);
            }
        }
    }

    @Test
    public void testPthread_t() {
        Pthread.Pthread_t pthread_t = Pthread.Pthread_t.allocateNative(ms.scope());
        Assertions.assertNotNull(pthread_t.toString());
        Assertions.assertNotNull(pthread_t.nativeToString());
    }

    @Test
    public void testPthread_attr_t() throws Exception {
        Pthread.Pthread_attr_t pthread_attr_t = Pthread.Pthread_attr_t.allocateNative(ms.scope());
        Pthread.pthread_attr_init(pthread_attr_t);
        Assertions.assertNotNull(pthread_attr_t.toString());
        Assertions.assertNotNull(pthread_attr_t.nativeToString());
        Pthread.pthread_attr_destroy(pthread_attr_t);
    }

    @Test
    public void testPthread_attr_setget_schedparam() throws Exception {
        Pthread.Pthread_attr_t attr = Pthread.Pthread_attr_t.allocateNative(ms.scope());
        Pthread.pthread_attr_init(attr);
        Sched.Sched_param param = Sched.Sched_param.allocateNative(ms.scope());
        param.sched_priority(0); //TODO Any other will give a EINVAL ????
        try {
            JnhwTestLogger.logTest("pthread_attr_setschedparam ");
            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_attr_setschedparam(null, param);
            });
            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_attr_setschedparam(attr, null);
            });
            Pthread.pthread_attr_setschedparam(attr, param);

            JnhwTestLogger.logTest("pthread_attr_getschedparam");
            Sched.Sched_param param1 = Sched.Sched_param.allocateNative(ms.scope());
            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_attr_getschedparam(null, param1);
            });
            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_attr_getschedparam(attr, null);
            });
            Pthread.pthread_attr_getschedparam(attr, param1);
            Assertions.assertEquals(param.sched_priority(), param1.sched_priority());
        } finally {
            Pthread.pthread_attr_destroy(attr);
        }
    }

    @Test
    public void testPthread_attr_setget_inheritsched() throws Exception {
        Pthread.Pthread_attr_t attr = Pthread.Pthread_attr_t.allocateNative(ms.scope());
        Pthread.pthread_attr_init(attr);
        Int32_t inheritsched = Int32_t.allocateNative(ms.scope());
        try {
            JnhwTestLogger.logTest("pthread_attr_getinheritsched");
            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_attr_getinheritsched(null, inheritsched);
            });
            Pthread.pthread_attr_getinheritsched(attr, inheritsched);
            Assertions.assertEquals(Pthread.PTHREAD_INHERIT_SCHED, inheritsched.int32_t());

            JnhwTestLogger.logTest("pthread_attr_setinheritsched");

            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_attr_setinheritsched(null, 0);
            });

            Pthread.pthread_attr_setinheritsched(attr, Pthread.PTHREAD_EXPLICIT_SCHED);
        } finally {
            Pthread.pthread_attr_destroy(attr);
        }
    }

    @Test
    public void testPthread_setget_schedparam() throws NativeErrorException {
        Sched.Sched_param param = Sched.Sched_param.allocateNative(ms.scope());
        Int32_t policy = Int32_t.allocateNative(ms.scope());

        JnhwTestLogger.logTest("pthread_getschedparam");

        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_getschedparam(Pthread.pthread_self(ms.scope()), policy, null);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_getschedparam(null, policy, param);
        });

        Pthread.pthread_getschedparam(Pthread.pthread_self(ms.scope()), policy, param);
        Assertions.assertEquals(Sched.SCHED_OTHER, policy.int32_t());

        JnhwTestLogger.logTest("pthread_setschedparam");

        Pthread.pthread_setschedparam(Pthread.pthread_self(ms.scope()), policy.int32_t(), param);

        param.sched_priority(Integer.MAX_VALUE);
        switch (MultiarchTupelBuilder.getOS()) {
            case FREE_BSD, OPEN_BSD ->
                Pthread.pthread_setschedparam(Pthread.pthread_self(ms.scope()), policy.int32_t(), param);
            default -> {
                NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                    Pthread.pthread_setschedparam(Pthread.pthread_self(ms.scope()), policy.int32_t(), param);
                });
                switch (MultiarchTupelBuilder.getOS()) {
                    case APPLE ->
                        //TODO ?why?
                        ErrnoTest.assertErrnoEquals(0, nee.errno);
                    default ->
                        ErrnoTest.assertErrnoEquals(Errno.EINVAL, nee.errno);
                }
            }
        }

        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_setschedparam(Pthread.pthread_self(ms.scope()), 0, null);
        });

        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_setschedparam(null, 0, param);
        });

    }

    @Test
    public void testPthread_setschedprio() throws Exception {
        JnhwTestLogger.logTest("pthread_setschedprio(");
        switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD, OPEN_BSD ->
                Assertions.assertThrows(NoSuchNativeMethodException.class,
                        () -> Pthread.pthread_setschedprio(Pthread.pthread_self(ms.scope()), 0));
            default -> {
                Assertions.assertThrows(NullPointerException.class, () -> {
                    Pthread.pthread_setschedprio(null, 0);
                });
                Pthread.pthread_setschedprio(Pthread.pthread_self(ms.scope()), 0);
            }
        }
    }

    @Test
    @Disabled //It looks, that running this test will screw up the system internally - later tests will hang.
    //TODO What is going on?
    public void testPthread_t_Cancel() throws Exception {
        Pthread.Pthread_t me = Pthread.pthread_self(ms.scope());
        Int32_t oldstate = Int32_t.allocateNative(ms.scope());
        Int32_t oldtype = Int32_t.allocateNative(ms.scope());

        Pthread.pthread_setcancelstate(Pthread.PTHREAD_CANCEL_DISABLE, oldstate);
        Pthread.pthread_setcancelstate(oldstate.int32_t(), oldstate);
        Assertions.assertEquals(Pthread.PTHREAD_CANCEL_ENABLE, oldstate);

        Pthread.pthread_setcanceltype(Pthread.PTHREAD_CANCEL_ASYNCHRONOUS, oldtype);
        Pthread.pthread_setcanceltype(oldtype.int32_t(), oldtype);
        Assertions.assertEquals(Pthread.PTHREAD_CANCEL_DEFERRED, oldtype);

        Assertions.assertThrows(NullPointerException.class, () -> Pthread.pthread_cancel(null));

        final Pthread.Pthread_t[] objectRef = new Pthread.Pthread_t[1];
        final int[] intRef = new int[]{1000};
        Thread t2 = new Thread(() -> {
            try {
                Pthread.pthread_testcancel();

                objectRef[0] = Pthread.pthread_self(ms.scope());
                synchronized (objectRef) {
                    objectRef.notifyAll();
                }
                while (intRef[0]-- > 0) {
                    JnhwTestLogger.logTest("LOOPING in testPthread_t_Cancel()");
                    Thread.sleep(200);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(PthreadTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NativeErrorException ex) {
                Logger.getLogger(PthreadTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            JnhwTestLogger.logTest("LOOPING STOPPED WITHOUT CANCEL!");
        });
        t2.start();

        //Id we remove this at least on linux x86_64 the following test will hang...?
        Thread.sleep(1);

        if (objectRef[0] == null) {
            synchronized (objectRef) {
                objectRef.wait();
            }
        }

        Pthread.pthread_cancel(objectRef[0]);
        final int value = intRef[0];
        Thread.sleep(1000);
        Assertions.assertEquals(value, intRef[0]);
    }
}
