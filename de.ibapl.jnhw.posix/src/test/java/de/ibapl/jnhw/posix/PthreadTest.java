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

import de.ibapl.jnhw.common.references.IntRef;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class PthreadTest {

    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    public PthreadTest() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of pthread_self method, of class Pthread.
     */
    @Test
    public void testPthread_self() {
        System.out.println("pthread_self");
        Pthread.Pthread_t result = Pthread.pthread_self();
        Assertions.assertNotNull(result);
        System.out.println("PTHREAD ID: " + result);
    }

    /**
     * Test of pthread_equal method, of class Pthread.
     */
    @Test
    public void testPthread_equal() throws Exception {
        System.out.println("pthread_equal");
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_equal(null, Pthread.pthread_self());
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_equal(Pthread.pthread_self(), null);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_equal(null, null);
        });
        final Pthread.Pthread_t t1 = Pthread.pthread_self();
        Assertions.assertTrue(Pthread.pthread_equal(t1, Pthread.pthread_self()));

        final ObjectRef<Pthread.Pthread_t> objectRef = new ObjectRef();
        Thread t2 = new Thread(() -> {
            objectRef.value = Pthread.pthread_self();
        });
        t2.start();
        t2.join();

        Assertions.assertNotEquals(t2.toString(), objectRef.value.toString());
        boolean result = Pthread.pthread_equal(t1, objectRef.value);
        Assertions.assertFalse(result);

    }

    /**
     * Test of pthread_getcpuclockid method, of class Pthread.
     */
    @Test
    public void testPthread_getcpuclockid() throws Exception {
        System.out.println("pthread_getcpuclockid");
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.MAC_OS_X) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Pthread.pthread_getcpuclockid(null, null);
            });
        } else {
            IntRef clock_id = new IntRef();
            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_getcpuclockid(null, clock_id);
            });

            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_getcpuclockid(Pthread.pthread_self(), null);
            });

            Pthread.pthread_getcpuclockid(Pthread.pthread_self(), clock_id);
            Assertions.assertNotNull(clock_id.value);
        }
    }

    @Test
    public void testPthread_t() {
        Pthread.Pthread_t pthread_t = new Pthread.Pthread_t();
        Assertions.assertNotNull(pthread_t.toString());
        Assertions.assertNotNull(pthread_t.nativeToString());
    }

    @Test
    public void testPthread_attr_t() {
        Pthread.Pthread_attr_t pthread_attr_t = new Pthread.Pthread_attr_t();
        Pthread.pthread_attr_init(pthread_attr_t);
        Assertions.assertNotNull(pthread_attr_t.toString());
        Assertions.assertNotNull(pthread_attr_t.nativeToString());
        Pthread.pthread_attr_destroy(pthread_attr_t);
    }

    @Test
    public void testPthread_attr_setget_schedparam() throws Exception {
        Pthread.Pthread_attr_t attr = new Pthread.Pthread_attr_t();
        Pthread.pthread_attr_init(attr);
        Sched.Sched_param param = new Sched.Sched_param(true);
        param.sched_priority(0); //TODO Any other will give a EINVAL ????
        try {
            System.out.println("pthread_attr_setschedparam ");
            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_attr_setschedparam(null, param);
            });
            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_attr_setschedparam(attr, null);
            });
            Pthread.pthread_attr_setschedparam(attr, param);

            System.out.println("pthread_attr_getschedparam");
            Sched.Sched_param param1 = new Sched.Sched_param(true);
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
        Pthread.Pthread_attr_t attr = new Pthread.Pthread_attr_t();
        Pthread.pthread_attr_init(attr);
        try {
            System.out.println("pthread_attr_setinheritsched");

            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_attr_setinheritsched(null, 0);
            });

            Pthread.pthread_attr_setinheritsched(attr, 0);
            System.out.println("pthread_attr_getinheritsched");
            Assertions.assertThrows(NullPointerException.class, () -> {
                Pthread.pthread_attr_getinheritsched(null);
            });
            int result = Pthread.pthread_attr_getinheritsched(attr);
            Assertions.assertEquals(0, result);
        } finally {
            Pthread.pthread_attr_destroy(attr);
        }
    }

    @Test
    public void testPthread_setget_schedparam() throws NativeErrorException {
        Sched.Sched_param param = new Sched.Sched_param(true);
        param.sched_priority(127);

        System.out.println("pthread_setschedparam");
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_setschedparam(Pthread.pthread_self(), 0, null);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_setschedparam(null, 0, param);
        });
        if (MULTIARCHTUPEL_BUILDER.getOS() == de.ibapl.jnhw.libloader.OS.LINUX) {
            //TODO Why??? EINVAL
            NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                Pthread.pthread_setschedparam(Pthread.pthread_self(), 0, param);
            });
            Assertions.assertEquals(Errno.EINVAL, nee.errno);
        } else {
            Pthread.pthread_setschedparam(Pthread.pthread_self(), 0, param);
        }

        System.out.println("pthread_getschedparam");
        IntRef intRef = new IntRef();

        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_getschedparam(Pthread.pthread_self(), intRef, null);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_getschedparam(Pthread.pthread_self(), null, param);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Pthread.pthread_getschedparam(null, intRef, param);
        });

        Pthread.pthread_getschedparam(Pthread.pthread_self(), intRef, param);
        Assertions.assertEquals(0, intRef.value);

    }

    @Test
    public void testPthread_setschedprio() throws Exception {
        System.out.println("pthread_setschedprio(");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Pthread.pthread_setschedprio(null, 0);
                });
                break;
            default:
                Assertions.assertThrows(NullPointerException.class, () -> {
                    Pthread.pthread_setschedprio(null, 0);
                });
                Pthread.pthread_setschedprio(Pthread.pthread_self(), 0);
        }
    }

    @Test
    public void testSizeOfPthread_attr_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getArch()) {
                    case AARCH64:
                        Assertions.assertEquals(64, Pthread.Pthread_attr_t.sizeof());
                        break;
                    case ARM:
                    case I386:
                    case MIPS:
                        Assertions.assertEquals(36, Pthread.Pthread_attr_t.sizeof());
                        break;
                    case MIPS_64:
                    case POWER_PC_64:
                    case S390_X:
                    case X86_64:
                        Assertions.assertEquals(56, Pthread.Pthread_attr_t.sizeof());
                        break;
                    default:
                        Assertions.assertEquals(-1, Pthread.Pthread_attr_t.sizeof());
                }
                break;
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertEquals(8, Pthread.Pthread_attr_t.sizeof());
                break;
            default:
                Assertions.assertEquals(-1, Pthread.Pthread_attr_t.sizeof());
        }
    }

    @Test
    public void testAlignOfPthread_attr_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                Assertions.assertEquals(4, Pthread.Pthread_attr_t.alignof());
                break;
            case _64_BIT:
                Assertions.assertEquals(8, Pthread.Pthread_attr_t.alignof());
                break;
            default:
                Assertions.assertEquals(-1, Pthread.Pthread_attr_t.alignof());
        }
    }

    @Test
    public void testSizeOfPthread_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                Assertions.assertEquals(4, Pthread.Pthread_t.sizeof());
                break;
            case _64_BIT:
                Assertions.assertEquals(8, Pthread.Pthread_t.sizeof());
                break;
            default:
                Assertions.assertEquals(-1, Pthread.Pthread_t.sizeof());
        }
    }

    @Test
    public void testAlignOfPthread_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getWordSize()) {
            case _32_BIT:
                Assertions.assertEquals(4, Pthread.Pthread_t.alignof());
                break;
            case _64_BIT:
                Assertions.assertEquals(8, Pthread.Pthread_t.alignof());
                break;
            default:
                Assertions.assertEquals(-1, Pthread.Pthread_t.alignof());
        }
    }

    @Test
    @Disabled //It looks, that running this test will screw up the system internally - later tests will hang.
    //TODO What is going on?
    public void testPthread_t_Cancel() throws Exception {
        System.out.println("Start testPthread_t_Cancel");
        Pthread.Pthread_t me = Pthread.pthread_self();

        int oldCancelstate = Pthread.pthread_setcancelstate(Pthread.PTHREAD_CANCEL_DISABLE);
        Pthread.pthread_setcancelstate(oldCancelstate);
        Assertions.assertEquals(Pthread.PTHREAD_CANCEL_ENABLE, oldCancelstate);

        int oldCanceltype = Pthread.pthread_setcanceltype(Pthread.PTHREAD_CANCEL_ASYNCHRONOUS);
        Pthread.pthread_setcanceltype(oldCanceltype);
        Assertions.assertEquals(Pthread.PTHREAD_CANCEL_DEFERRED, oldCanceltype);

        Assertions.assertThrows(NullPointerException.class, () -> Pthread.pthread_cancel(null));

        final ObjectRef<Pthread.Pthread_t> objectRef = new ObjectRef();
        final IntRef intRef = new IntRef(1000);
        Thread t2 = new Thread(() -> {
            try {
                Pthread.pthread_testcancel();

                objectRef.value = Pthread.pthread_self();
                synchronized (objectRef) {
                    objectRef.notifyAll();
                }
                while (intRef.value-- > 0) {
                    System.err.println("LOOPING in testPthread_t_Cancel()");
                    Thread.sleep(200);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(PthreadTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NativeErrorException ex) {
                Logger.getLogger(PthreadTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.err.println("LOOPING STOPPED WITHOUT CANCEL!");
        });
        t2.start();

        //Id we remove this at least on linux x86_64 the following test will hang...?
        Thread.sleep(1);

        if (objectRef.value == null) {
            synchronized (objectRef) {
                objectRef.wait();
            }
        }

        Pthread.pthread_cancel(objectRef.value);
        final int value = intRef.value;
        Thread.sleep(1000);
        Assertions.assertEquals(value, intRef.value);

        System.out.println("testPthread_t_Cancel - finished");
    }
}
