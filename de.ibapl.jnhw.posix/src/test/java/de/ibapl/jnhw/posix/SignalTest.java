/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.datatypes.OS;
import de.ibapl.jnhw.common.upcall.Callback__V___I_MA_MA;
import de.ibapl.jnhw.common.upcall.Callback__V___I;
import de.ibapl.jnhw.common.util.ObjectDefine;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___I;
import de.ibapl.jnhw.common.upcall.Callback__V__MA;
import de.ibapl.jnhw.util.posix.DefinesTest;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class SignalTest {

    @BeforeAll
    public static void checkBeforeAll_HAVE_SIGNAL_H() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Signal.HAVE_SIGNAL_H, "not expected to have signal.h");
        } else {
            Assertions.assertTrue(Signal.HAVE_SIGNAL_H, "expected to have signal.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_SignalDefines() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Signal.class, "HAVE_SIGNAL_H", (name) -> switch (name) {
            case "SIG_DFL", "SIG_ERR", "SIG_IGN" ->
                new FunctionPtr__V___I(LibJnhwPosixTestLoader.getAdrDefine(name));
            case "SIG_HOLD" ->
                (LibJnhwPosixTestLoader.tryGetAdrDefine(name) == null) ? ObjectDefine.UNDEFINED : ObjectDefine.toObjectDefine(new FunctionPtr__V___I(LibJnhwPosixTestLoader.tryGetAdrDefine(name)));
            default ->
                throw new RuntimeException("Can't find " + name);
        });
    }

    @BeforeAll
    public static void checkBeforeAll_StructMcontext_t() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Mcontext_t_sizeof"), Signal.Mcontext_t.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Mcontext_t_alignof"), Signal.Mcontext_t.alignof == null ? 0 : Signal.Mcontext_t.alignof.alignof, "alignof");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructSigset_t() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigset_t_sizeof"), Signal.Sigset_t.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigset_t_alignof"), Signal.Sigset_t.alignof.alignof, "alignof");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructSigval() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigval_sizeof"), Signal.Sigval.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigval_alignof"), Signal.Sigval.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigval_offsetof_sival_int"), Signal.Sigval.offsetof_Sival_int, "offsetof_Sival_int");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigval_offsetof_sival_ptr"), Signal.Sigval.offsetof_Sival_ptr, "offsetof_Sival_ptr");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructSigevent() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigevent_sizeof"), Signal.Sigevent.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigevent_alignof"), Signal.Sigevent.alignof == null ? 0 : Signal.Sigevent.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigevent_offsetof_sigev_notify"), Signal.Sigevent.offsetof_Sigev_notify, "offsetof_Sigev_notify");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigevent_offsetof_sigev_notify_attributes"), Signal.Sigevent.offsetof_Sigev_notify_attributes, "offsetof_Sigev_notify_attributes");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigevent_offsetof_sigev_notify_function"), Signal.Sigevent.offsetof_Sigev_notify_function, "offsetof_Sigev_notify_function");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigevent_offsetof_sigev_signo"), Signal.Sigevent.offsetof_Sigev_signo, "offsetof_Sigev_signo");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigevent_offsetof_sigev_value"), Signal.Sigevent.offsetof_Sigev_value, "offsetof_Sigev_value");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructSigaction() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigaction_sizeof"), Signal.Sigaction.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigaction_alignof"), Signal.Sigaction.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigaction_offsetof_sa_handler"), Signal.Sigaction.offsetof_Sa_handler, "offsetof_Sa_handler");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigaction_offsetof_sa_mask"), Signal.Sigaction.offsetof_Sa_mask, "offsetof_Sa_mask");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigaction_offsetof_sa_flags"), Signal.Sigaction.offsetof_Sa_flags, "offsetof_Sa_flags");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Sigaction_offsetof_sa_sigaction"), Signal.Sigaction.offsetof_Sa_sigaction, "offsetof_Sa_sigaction");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructStack_t() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Stack_t_sizeof"), Signal.Stack_t.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Stack_t_alignof"), Signal.Stack_t.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Stack_t_offsetof_ss_sp"), Signal.Stack_t.offsetof_Ss_sp, "offsetof_Ss_sp");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Stack_t_offsetof_ss_size"), Signal.Stack_t.offsetof_Ss_size, "offsetof_Ss_size");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Stack_t_offsetof_ss_flags"), Signal.Stack_t.offsetof_Ss_flags, "offsetof_Ss_flags");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructSiginfo() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_sizeof"), Signal.Siginfo_t.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_alignof"), Signal.Siginfo_t.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_offsetof_si_signo"), Signal.Siginfo_t.offsetof_Si_signo, "offsetof_Si_signo");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_offsetof_si_code"), Signal.Siginfo_t.offsetof_Si_code, "offsetof_Si_code");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_offsetof_si_errno"), Signal.Siginfo_t.offsetof_Si_errno, "offsetof_Si_errno");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_offsetof_si_pid"), Signal.Siginfo_t.offsetof_Si_pid, "offsetof_Si_pid");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_offsetof_si_uid"), Signal.Siginfo_t.offsetof_Si_uid, "offsetof_Si_uid");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_offsetof_si_addr"), Signal.Siginfo_t.offsetof_Si_addr, "offsetof_Si_addr");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_offsetof_si_status"), Signal.Siginfo_t.offsetof_Si_status, "offsetof_Si_status");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_offsetof_si_band"), Signal.Siginfo_t.offsetof_Si_band, "offsetof_Si_band");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Siginfo_t_offsetof_si_value"), Signal.Siginfo_t.offsetof_Si_value, "offsetof_Si_value");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructUcontext_t() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Ucontext_t_sizeof"), Signal.Ucontext_t.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Ucontext_t_alignof"), Signal.Ucontext_t.alignof == null ? 0 : Signal.Ucontext_t.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Ucontext_t_offsetof_uc_link"), Signal.Ucontext_t.offsetof_Uc_link, "offsetof_Uc_link");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Ucontext_t_offsetof_uc_sigmask"), Signal.Ucontext_t.offsetof_Uc_sigmask, "offsetof_Uc_sigmask");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Ucontext_t_offsetof_uc_stack"), Signal.Ucontext_t.offsetof_Uc_stack, "offsetof_Uc_stack");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Ucontext_t_offsetof_uc_mcontext"), Signal.Ucontext_t.offsetof_Uc_mcontext, "offsetof_Uc_mcontext");
                }
        );
    }

    private ResourceScope scope;

    @BeforeEach
    public void setUp() {
        scope = ResourceScope.newSharedScope();
    }

    @AfterEach
    public void tearDown() {
        scope.close();
    }

    // just for vm in qemu...
    private final static long ONE_MINUTE = 60_000;

    public SignalTest() {
    }

    /**
     * Test of kill method, of class Signal.
     */
    @Test
    public void testKill() throws Exception {
        System.out.println("kill");

        final int sig = Signal.SIGCHLD; //TODO SIGQUIT blows anything away .... WHY??? pthread_kill

        final Integer[] sigRef = new Integer[1];
        final Signal.Sigaction act = Signal.Sigaction.allocateNative(scope);
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback__V___I sa_handler = new Callback__V___I() {
            @Override
            protected void callback(int sig) {
                synchronized (sigRef) {
                    System.out.println("pthread_t of signalhadler: " + Pthread.pthread_self(scope) + " Java thread ID: " + Thread.currentThread().getId());
                    sigRef[0] = sig;
                    sigRef.notifyAll();
                }

            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction oact = Signal.Sigaction.allocateNative(scope);
        Signal.sigaction(sig, act, oact);
        try {
            System.out.println("pthread_t of testKill: " + Pthread.pthread_self(scope) + " Java thread ID: " + Thread.currentThread().getId());
            Signal.kill(Unistd.getpid(), sig);
            synchronized (sigRef) {
                if (sigRef[0] == null) {
                    sigRef.wait(ONE_MINUTE);
                }
            }
            assertEquals(sig, sigRef[0]);
        } finally {
            Signal.sigaction(sig, oact, null);
        }
    }

    /**
     * Test of killpg method, of class Signal.
     */
    @Test
    public void testKillpg() throws Exception {
        System.out.println("killpg");
        final int sig = Signal.SIGCHLD;

        final Integer[] sigRef = new Integer[1];
        final Signal.Sigaction act = Signal.Sigaction.allocateNative(scope);
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback__V___I sa_handler = new Callback__V___I() {
            @Override
            protected void callback(int sig) {
                synchronized (sigRef) {
                    sigRef[0] = sig;
                    sigRef.notifyAll();
                }
            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction oact = Signal.Sigaction.allocateNative(scope);
        Signal.sigaction(sig, act, oact);
        try {
            Signal.killpg(Unistd.getpgrp(), sig);
            synchronized (sigRef) {
                if (sigRef[0] == null) {
                    sigRef.wait(ONE_MINUTE);
                }
            }
            assertEquals(sig, sigRef[0]);
        } finally {
            Signal.sigaction(sig, oact, null);
        }
    }

    /**
     * Test of psiginfo method, of class Signal.
     */
    @Test
    public void testPsiginfo() throws Exception {
        System.out.println("psiginfo");
        Signal.Siginfo_t pinfo = Signal.Siginfo_t.allocateNative(scope);
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.psiginfo(pinfo, "JNHW Test for Signal.psiginfo"));
                break;
            default:
                System.err.print("psiginfo MSG >>>");
                Signal.psiginfo(pinfo, "JNHW Test for Signal.psiginfo");
                System.err.println("<<< psiginfo MSG");
                System.err.flush();
                System.out.flush();
                Signal.psiginfo(pinfo, null);
                Assertions.assertThrows(NullPointerException.class, () -> {
                    Signal.psiginfo(null, "JNHW Test for Signal.psiginfo");
                });
        }
        //TODO mark as not executing as expected but do not fail??
    }

    /**
     * Test of psignal method, of class Signal.
     */
    //TODO Does work, no output...
    @Test
    public void testPsignal() throws Exception {
        System.out.println("psignal");
        System.err.print("psignal MSG >>>");
        Signal.psignal(Signal.SIGUSR1, "Send SIGUSR1 to std err");
        System.err.println("<<< psignal MSG");
        System.err.flush();
        System.out.flush();
        Signal.psignal(Signal.SIGUSR1, null);
        //TODO mark as not executing as expected but do not fail??
    }

    /**
     * Test of pthread_kill method, of class Signal.
     */
    @Test
    public void testPthread_kill() throws Exception {
        System.out.println("pthread_kill");
        System.out.println("pthread_t of testPthread_kill: " + Pthread.pthread_self(scope) + " Java thread ID: " + Thread.currentThread().getId());

        final int sig = Signal.SIGCHLD; //TODO SIGQUIT blows anything away .... WHY??? pthread_kill

        final Integer[] sigRef = new Integer[1];
        final Throwable[] error = new Throwable[1];
        final Signal.Sigaction act = Signal.Sigaction.allocateNative(scope);
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback__V___I sa_handler = new Callback__V___I() {
            @Override
            protected void callback(int sig) {
                sigRef[0] = sig;
                System.out.println("pthread_t of signalhadler: " + Pthread.pthread_self(scope) + " Java thread ID: " + Thread.currentThread().getId() + " signal: " + sig);
            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction oact = Signal.Sigaction.allocateNative(scope);
        Signal.sigaction(sig, act, oact);
        try {
            Thread t = new Thread(() -> {
                try {
                    System.out.println("pthread_t of thread: " + Pthread.pthread_self(scope) + " Java thread ID: " + Thread.currentThread().getId());
                    Signal.pthread_kill(Pthread.pthread_self(scope), sig);
                } catch (NativeErrorException nee) {
                    error[0] = nee;
                }
            });
            t.start();
            t.join();
            Assertions.assertNull(error[0]);
            assertEquals(sig, sigRef[0]);
        } finally {
            Signal.sigaction(sig, oact, null);
        }
    }

    /**
     * Test of pthread_sigmask method, of class Signal.
     */
    @Test
    public void testPthread_sigmask() throws Exception {
        System.out.println("pthread_sigmask");

        Signal.pthread_sigmask(0, null, null);

        final Signal.Sigset_t oset = Signal.Sigset_t.allocateNative(scope);
        Signal.sigemptyset(oset);
        Signal.pthread_sigmask(0, null, oset);
        try {
            //make sure SIGUSR1 is in signak mask; we want to set it
            System.err.println("current sigprocmask: " + oset);
            Assertions.assertFalse(Signal.sigismember(oset, Signal.SIGUSR1));
            Signal.Sigset_t set = Signal.Sigset_t.allocateNative(scope);
            Signal.sigemptyset(set);
            Signal.sigaddset(set, Signal.SIGUSR1);
            Signal.pthread_sigmask(Signal.SIG_BLOCK, set, null);
            //Test that SIGUSR1 was set
            final Signal.Sigset_t changedSet = Signal.Sigset_t.allocateNative(scope);
            Signal.sigemptyset(changedSet);
            Signal.pthread_sigmask(0, null, changedSet);
            System.err.println("current sigprocmask: " + changedSet.toString());
            Assertions.assertTrue(Signal.sigismember(changedSet, Signal.SIGUSR1));
        } finally {
            //restore old mask
            Signal.pthread_sigmask(Signal.SIG_SETMASK, oset, null);
        }
    }

    /**
     * Test of raise method, of class Signal.
     */
    @Test
    public void testRaise() throws Exception {
        System.out.println("raise");
        final int sig = Signal.SIGCHLD;

        final Integer[] sigRef = new Integer[1];
        final Signal.Sigaction act = Signal.Sigaction.allocateNative(scope);
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback__V___I sa_handler = new Callback__V___I() {
            @Override
            protected void callback(int sig) {
                sigRef[0] = sig;
            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction oact = Signal.Sigaction.allocateNative(scope);
        Signal.sigaction(sig, act, oact);
        try {
            Signal.raise(sig);
            assertEquals(sig, sigRef[0]);
        } finally {
            Signal.sigaction(sig, oact, null);
        }
    }

    /**
     * Test of sigaction method, of class Signal.
     */
    @Test
    public void testSigaction() throws Exception {
        System.out.println("sigaction");
        final int SIG = Signal.SIGCHLD;

        final Signal.Sigaction<OpaqueMemory> act = Signal.Sigaction.allocateNative(scope);
        act.sa_flags(Signal.SA_RESTART);
        Signal.sigemptyset(act.sa_mask);

        Callback__V___I sa_handler = new Callback__V___I() {
            @Override
            protected void callback(int sig) {
            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction<OpaqueMemory> oact = Signal.Sigaction.allocateNative(scope);
        Signal.sigaction(SIG, null, oact);
        try {
            Signal.sigaction(SIG, act, oact);
            Signal.sigaction(SIG, act, null);
            if ((oact.sa_flags() & Signal.SA_SIGINFO) == Signal.SA_SIGINFO) {
                Assertions.assertEquals(Signal.SIG_DFL, oact.sa_sigaction());
            } else {
                Assertions.assertEquals(Signal.SIG_DFL, oact.sa_handler());
            }

            final Signal.Sigaction<OpaqueMemory> actOut = Signal.Sigaction.allocateNative(scope);
            Signal.sigaction(SIG, oact, actOut);

            Assertions.assertEquals(act.sa_handler(), actOut.sa_handler());
            Signal.sigaction(SIG, null, null);
        } finally {
            Signal.sigaction(SIG, oact, null);
        }
    }

    /**
     * Test of sigaltstack method, of class Signal.
     */
    @Test
    public void testSigaltstack() throws Exception {
        System.out.println("sigaltstack");
        final MemoryHeap ss_sp = MemoryHeap.wrap(MemorySegment.allocateNative(Signal.MINSIGSTKSZ, scope));
        Signal.Stack_t ss = Signal.Stack_t.allocateNativeAndInit(scope, Signal.SS_DISABLE, ss_sp);
        Signal.Stack_t oss = Signal.Stack_t.allocateNative(scope);
        Signal.sigaltstack(null, oss);
        try {
            Signal.sigaltstack(null, null);
            Signal.sigaltstack(ss, oss);
        } finally {
            try {
                Signal.sigaltstack(oss, null);
            } catch (NativeErrorException nee) {
                if (nee.errno == Errno.ENOMEM) {
                    if ((oss.ss_flags() & Signal.SS_DISABLE) == Signal.SS_DISABLE) {
                        //no-op
                        //this is DARWIN Why???
                    } else {
                        if (Signal.MINSIGSTKSZ <= oss.ss_size()) {
                            throw nee;
                        }
                    }
                }
            }
        }
    }

    /**
     * Test of sigemptyset, sigdelset, sigfillset, sigaddset, sigismember
     * methods of Sigset_t, of class Signal.
     */
    @Test
    public void testSigset_t() throws Exception {
        System.out.println("Sigset_t");
        Signal.Sigset_t set = Signal.Sigset_t.allocateNative(scope);

        Signal.sigemptyset(set);
        Assertions.assertFalse(Signal.sigismember(set, Signal.SIGKILL));
        Assertions.assertFalse(Signal.sigismember(set, Signal.SIGUSR1));
        Signal.sigaddset(set, Signal.SIGUSR1);
        Assertions.assertTrue(Signal.sigismember(set, Signal.SIGUSR1));
        Signal.sigdelset(set, Signal.SIGUSR1);
        Assertions.assertFalse(Signal.sigismember(set, Signal.SIGUSR1));

        Signal.sigemptyset(set);
        Signal.sigfillset(set);
        Assertions.assertTrue(Signal.sigismember(set, Signal.SIGKILL));
        Assertions.assertTrue(Signal.sigismember(set, Signal.SIGABRT));

    }

    /**
     * Test of sighold method, of class Signal.
     */
    @Test
    public void testSighold_sigrelse() throws Exception {
        System.out.println("sighold");
        final int sig = Signal.SIGCHLD;
        if (MultiarchTupelBuilder.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.sighold(sig));
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.sigrelse(sig));
        } else {
            Signal.sighold(sig);
            Signal.Sigset_t mask = Signal.Sigset_t.allocateNative(scope);
            Signal.sigemptyset(mask);
            Signal.sigprocmask(0, null, mask);
            Assertions.assertTrue(Signal.sigismember(mask, sig), "Signal is not in mask");
            System.out.println("sigrelse");
            Signal.sigrelse(sig);
            Signal.sigprocmask(0, null, mask);
            Assertions.assertFalse(Signal.sigismember(mask, sig), "Signal is still in mask");
        }
    }

    /**
     * Test of sigignore method, of class Signal.
     */
    @Test
    public void testSigignore() throws Exception {
        System.out.println("sigignore");
        final int sig = Signal.SIGCHLD;
        final var old = Signal.signal(sig, null);
        try {
            if (MultiarchTupelBuilder.getOS() == OS.OPEN_BSD) {
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.sigignore(sig));
            } else {
                Signal.sigignore(sig);
                assertEquals(Signal.SIG_IGN, Signal.signal(sig, null));
            }
        } finally {
            Signal.signal(sig, old);
        }
    }

    /**
     * Test of siginterrupt method, of class Signal.
     */
    @Test
    public void testSiginterrupt() throws Exception {
        System.out.println("siginterrupt");
        int sig = Signal.SIGCHLD;
        Signal.Sigaction oact = Signal.Sigaction.allocateNative(scope);
        Signal.sigaction(sig, null, oact);
        try {
            Signal.siginterrupt(sig, true);
        } finally {
            Signal.sigaction(sig, oact, null);
        }
    }

    /**
     * Test of signal method, of class Signal.
     */
    @Test
    public void testSignal() throws Exception {
        System.out.println("signal");

        final int SIG = Signal.SIGCHLD;
        final var funcIgnore = Signal.SIG_IGN;
        final var savedOld = Signal.signal(SIG, funcIgnore);
        if (Signal.SIG_DFL.equals(savedOld)) {
            System.out.println("Old signal handler of SIG is SIG_DFL!");
        } else if (Signal.SIG_ERR.equals(savedOld)) {
            System.out.println("Old signal handler of SIG is SIG_ERR!");
        } else if (Signal.SIG_HOLD.equals(savedOld)) {
            System.out.println("Old signal handler of SIG is SIG_HOLD!");
        } else if (Signal.SIG_IGN.equals(savedOld)) {
            System.out.println("Old signal handler of SIG is SIG_IGN!");
        } else {
            System.out.println("Old signal handler of SIG is " + savedOld);
        }

        Signal.raise(SIG);

        final Integer[] raisedSignal = new Integer[1];
        final Callback__V___I funcHandler = new Callback__V___I() {
            @Override
            protected void callback(int sig) {
                raisedSignal[0] = sig;
                System.out.println("Got signal: " + sig);
            }
        };

        var old = Signal.signal(SIG, funcHandler);
        try {
            Assertions.assertEquals(funcIgnore, old);

            Signal.raise(SIG);
            Assertions.assertEquals(Integer.valueOf(SIG), raisedSignal[0]);

            old = Signal.signal(SIG, null);
            Assertions.assertEquals(funcHandler, old);

        } finally {
            //Restore the signal on error.
            Signal.signal(SIG, savedOld);
        }
    }

    /**
     * Test of signal method, of class Signal.
     */
    @Test
    public void testTryToIgnoreSignal_SIGTERM() throws Exception {
        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
            var oldSignalHandler = Signal.signal(Signal.SIGSTOP, Signal.SIG_IGN);
            // We expect not to arrive here, but if we are here we must rstore the signal handler
            try {
                Signal.signal(Signal.SIGSTOP, oldSignalHandler);
            } catch (NativeErrorException neex) {
                Assertions.fail(neex);
            }
        });
        assertEquals("EINVAL", Errno.getErrnoSymbol(nee.errno));
    }

    /**
     * Test of sigpause method, of class Signal.
     */
    @Test
    @Disabled // it does not return from sigpause - what is wrong...
    public void testSigpause() throws Exception {
        System.out.println("sigpause");
        final int SIG = Signal.SIGUSR2;

        final Object[] resultRef = new Object[1];

        new Thread() {
            @Override
            public void run() {
                try {
                    Signal.sigpause(SIG);
                    synchronized (resultRef) {
                        resultRef[0] = Boolean.TRUE;
                        resultRef.notify();
                    }
                } catch (NoSuchNativeMethodException nsnme) {
                    synchronized (resultRef) {
                        resultRef[0] = nsnme;
                        resultRef.notify();
                    }
                } catch (NativeErrorException nee) {
                    synchronized (resultRef) {
                        resultRef[0] = nee;
                        resultRef.notify();
                    }
                }
            }
        }.start();
        Thread.sleep(10000);
        Signal.raise(SIG);
        synchronized (resultRef) {
            if (resultRef[0] == null) {
                resultRef.wait(ONE_MINUTE);
            }
        }
        Assertions.assertNotNull(resultRef[0]);
        Assertions.assertEquals(Boolean.class, resultRef[0].getClass(), "value was: " + resultRef[0]);
        Assertions.assertEquals(Boolean.TRUE, resultRef[0]);
    }

    /**
     * Test of sigpending method, of class Signal.
     */
    @Test
    public void testSigpending() throws Exception {
        System.out.println("sigpending");
        NullPointerException nee = Assertions.assertThrows(NullPointerException.class, () -> {
            Signal.sigpending(null);
        });

        Signal.Sigset_t set = Signal.Sigset_t.allocateNative(scope);
        // Just make sure all bytes are set to 0 otherwise linux s390x may fail at byte comparision).
        OpaqueMemory.clear(set);
        Signal.sigemptyset(set);
        Assertions.assertArrayEquals(new byte[Signal.Sigset_t.sizeof], OpaqueMemory.toBytes(set));
        Signal.sigpending(set);
        assertEquals("[]", set.nativeToString());
        Assertions.assertArrayEquals(new byte[Signal.Sigset_t.sizeof], OpaqueMemory.toBytes(set));
    }

    /**
     * Test of sigprocmask method, of class Signal.
     */
    @Test
    public void testSigprocmask() throws Exception {
        System.out.println("sigprocmask");

        Signal.sigprocmask(0, null, null);

        final Signal.Sigset_t oset = Signal.Sigset_t.allocateNative(scope);
        Signal.sigemptyset(oset);
        Signal.sigprocmask(0, null, oset);
        try {
            //make sure SIGUSR1 is in signak mask; we want to set it
            System.err.println("current sigprocmask: " + oset);
            Assertions.assertFalse(Signal.sigismember(oset, Signal.SIGUSR1));
            Signal.Sigset_t set = Signal.Sigset_t.allocateNative(scope);
            Signal.sigemptyset(set);
            Signal.sigaddset(set, Signal.SIGUSR1);
            Signal.sigprocmask(Signal.SIG_BLOCK, set, null);
            //Test that SIGUSR1 was set
            final Signal.Sigset_t changedSet = Signal.Sigset_t.allocateNative(scope);
            Signal.sigemptyset(changedSet);
            Signal.sigprocmask(0, null, changedSet);
            System.err.println("current sigprocmask: " + changedSet.toString());
            Assertions.assertTrue(Signal.sigismember(changedSet, Signal.SIGUSR1));
        } finally {
            //restore old mask
            Signal.sigprocmask(Signal.SIG_SETMASK, oset, null);
        }
    }

    /**
     * Test of sigqueue method, of class Signal.
     */
    @Test
    public void testSigqueue() throws Throwable {
        System.out.println("sigqueue");
        final int SIG = Signal.SIGUSR2;
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN:
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.sigqueue(Unistd.getpid(), SIG, Signal.Sigval.allocateNative(scope)));
                break;
            default:
                final Signal.Sigaction act = Signal.Sigaction.allocateNative(scope);
                OpaqueMemory.clear(act);
                act.sa_flags(Signal.SA_SIGINFO);
                Signal.sigemptyset(act.sa_mask);

                final Throwable[] throwableRef = new Throwable[]{null};
                final Signal.Siginfo_t[] siginfo_tRef = new Signal.Siginfo_t[]{null};
                final Signal.Ucontext_t[] opmRef = new Signal.Ucontext_t[]{null};
                final Integer[] valueRef = new Integer[]{null};

                Callback__V___I_MA_MA<Signal.Siginfo_t, Signal.Ucontext_t> sa_handler = new Callback__V___I_MA_MA<>() {

                    @Override
                    protected void callback(int value, MemoryAddress a, MemoryAddress b) {
                        try {
                            siginfo_tRef[0] = Signal.Siginfo_t.ofAddress(a, scope);
                            try {
                                opmRef[0] = Signal.Ucontext_t.tryOfAddress(b, scope);
                            } catch (NoSuchNativeTypeException nste) {
                                Assertions.fail(nste);

                            }
                            valueRef[0] = value;
                        } catch (Throwable t) {
                            throwableRef[0] = t;
                        }
                    }

                };

                act.sa_sigaction(sa_handler);

                final Signal.Sigaction oact = Signal.Sigaction.allocateNative(scope);
                Signal.sigaction(SIG, act, oact);

                final MemoryHeap data = MemoryHeap.wrap(MemorySegment.allocateNative(128, scope));

                Signal.Sigval sigval = Signal.Sigval.allocateNative(scope);
                sigval.sival_ptr(data);

                Signal.sigqueue(Unistd.getpid(), SIG, sigval);

                Thread.sleep(100);
                System.out.println("de.ibapl.jnhw.posix.SignalTest.testSigqueue() siginfo_tRef.value: " + siginfo_tRef[0].nativeToString());
                try {
                    if (throwableRef[0] != null) {
                        throw throwableRef[0];
                    }
                    Assertions.assertNotNull(valueRef[0]);

                    Assertions.assertAll(() -> {
                        Assertions.assertEquals(SIG, valueRef[0], "value");
                    },
                            () -> {
                                Assertions.assertEquals(0, siginfo_tRef[0].si_errno(), "siginfo_tRef.value.si_errno()");
                            },
                            () -> {
                                Assertions.assertEquals(SIG, siginfo_tRef[0].si_signo(), "siginfo_tRef.value.si_signo()");
                            },
                            () -> {
                                Assertions.assertEquals(data, siginfo_tRef[0].si_value.sival_ptr((baseAddress, scope, parent) -> {
                                    return new MemoryHeap(baseAddress, scope, data.sizeof());
                                }, scope), "siginfo_tRef.value.si_value.sival_ptr()");
                            });
                } finally {
                    Signal.sigaction(SIG, oact, null);
                }
        }
    }

    /**
     * Test of sigset method, of class Signal.
     */
    @Test
    public void testSigset() throws Exception {
        System.out.println("sigset");
        if (MultiarchTupelBuilder.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.sigset(Signal.SIGABRT, null));
        } else {
            FunctionPtr__V___I result = Signal.sigset(Signal.SIGABRT, null);
            Assertions.assertEquals(Signal.SIG_DFL, result);
            result = Signal.sigset(Signal.SIGABRT, result);
            Assertions.assertEquals(MemoryAddress.NULL, result.toAddressable().address(), "result.address ");
        }
    }

    /**
     * Test of sigsuspend method, of class Signal.
     */
    @Test
    public void testSigsuspend() throws Exception {
        System.out.println("sigsuspend");
        final int SIG = Signal.SIGALRM;

        final Callback__V___I funcHandler = new Callback__V___I() {
            @Override
            protected void callback(int sig) {
                System.out.println("Got signal: " + sig);
            }
        };
        final var oldHandler = Signal.signal(SIG, funcHandler);

        final var act = Signal.Sigset_t.allocateNative(scope);
        Signal.sigemptyset(act);
        Signal.sigaddset(act, SIG);

        final var oact = Signal.Sigset_t.allocateNative(scope);
        Signal.sigemptyset(oact);
        Signal.sigprocmask(Signal.SIG_BLOCK, act, oact);

        try {
            final Signal.Sigset_t sigmask = Signal.Sigset_t.allocateNative(scope);
            Signal.sigemptyset(sigmask);
            Signal.sigaddset(sigmask, Signal.SIGUSR1);

            Signal.raise(SIG);
            Signal.sigsuspend(sigmask);
            Assertions.assertTrue(true, "Return from sigsuspend as expected");
        } finally {
            Signal.signal(SIG, oldHandler);
            Signal.sigprocmask(Signal.SIG_SETMASK, oact, null);
        }
    }

    /**
     * Test of sigtimedwait method, of class Signal.
     */
    @Test
    public void testSigtimedwait() throws Exception {
        System.out.println("sigtimedwait");
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN:
            case OPEN_BSD: {
                final Signal.Sigset_t set = Signal.Sigset_t.allocateNative(scope);
                Signal.sigemptyset(set);
                Signal.sigaddset(set, Signal.SIGALRM);
                final Signal.Siginfo_t info = Signal.Siginfo_t.allocateNative(scope);
                final Time.Timespec timeout = Time.Timespec.allocateNative(scope);

                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Signal.sigtimedwait(set, info, timeout);
                });
            }
            break;
            default:

                final int SIG = Signal.SIGALRM;

                final Signal.Sigset_t set = Signal.Sigset_t.allocateNative(scope);
                Signal.sigemptyset(set);
                Signal.sigaddset(set, SIG);

                final Signal.Sigset_t oset = Signal.Sigset_t.allocateNative(scope);

                final Signal.Siginfo_t info = Signal.Siginfo_t.allocateNative(scope);

                final Time.Timespec timeout = Time.Timespec.allocateNative(scope);
                timeout.tv_nsec(0);
                timeout.tv_sec(10);

                Signal.sigprocmask(Signal.SIG_BLOCK, set, oset);
                try {
                    Signal.pthread_kill(Pthread.pthread_self(scope), SIG); //We need to fire in this thread ...
                    try {
                        int signal = Signal.sigtimedwait(set, info, timeout);

                        assertEquals(SIG, signal);
                        assertEquals(SIG, info.si_signo());
                        if (MultiarchTupelBuilder.getOS() == OS.FREE_BSD) {
                            //#define SI_LWP                   /* Signal sent by thr_kill */ from /usr/include/sys/signal.h
                            assertEquals(0x10007, info.si_code());
                        } else {
                            assertEquals(0, info.si_code());
                        }

                        Signal.raise(SIG);
                        signal = Signal.sigtimedwait(set, null, timeout);
                    } catch (NoSuchNativeMethodException nsnme) {
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.println("XXX");
                        System.err.println("XXX  de.ibapl.jnhw.posix.SignalTest.testSigtimedwait() " + nsnme);
                        System.err.println("XXX  The test suite will crash competely after this - Fix this testcase");
                        System.err.println("XXX");
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.flush();
                        Thread.sleep(1000);
                        System.err.flush();
                        //Do the exit here - so wee actually see the message above - otherwise the message will not be visible.
                        System.exit(23);
                    }
                    Assertions.assertThrows(NullPointerException.class, () -> {
                        Signal.sigtimedwait(set, info, null);
                    });
                    Assertions.assertThrows(NullPointerException.class, () -> {
                        Signal.sigtimedwait(null, info, timeout);
                    });

                } finally {
                    //Restore signal mask
                    Signal.sigprocmask(Signal.SIG_SETMASK, oset, null);
                }
        }
    }

    /**
     * Test of sigwait method, of class Signal.
     */
    @Test
    public void testSigwait() throws Exception {
        System.out.println("sigwait");
        final int SIG = Signal.SIGALRM;

        Signal.signal(SIG, Signal.SIG_DFL);
        final Signal.Sigset_t set = Signal.Sigset_t.allocateNative(scope);
        Signal.sigemptyset(set);
        Signal.sigaddset(set, SIG);
        final Signal.Sigset_t oset = Signal.Sigset_t.allocateNative(scope);

        Signal.sigprocmask(Signal.SIG_BLOCK, set, oset);
        try {
            Signal.raise(SIG);
            final Signal.Sigset_t testSet = Signal.Sigset_t.allocateNative(scope);
            Signal.sigemptyset(testSet);

            Signal.sigpending(testSet);
            Assertions.assertTrue(Signal.sigismember(testSet, SIG), "Signal must be pending");

            final Int32_t signal = Int32_t.allocateNative(scope);
            Signal.sigwait(set, signal);
            assertEquals(SIG, signal.int32_t());

            Assertions.assertThrows(NullPointerException.class, () -> {
                Signal.sigwait(null, signal);
            });
        } finally {
            //Restore signal mask
            Signal.sigprocmask(Signal.SIG_SETMASK, oset, null);
        }
    }

    /**
     * Test of sigwaitinfo method, of class Signal.
     *
     * If the test fails after raising the signal and before processing the
     * signal in the test, the whole testsuite will crash!
     */
    @Test
    public void testSigwaitinfo() throws Exception {
        System.out.println("sigwaitinfo");

        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN:
            case OPEN_BSD: {
                final Signal.Sigset_t set = Signal.Sigset_t.allocateNative(scope);
                Signal.sigemptyset(set);
                Signal.sigaddset(set, Signal.SIGALRM);
                final Signal.Siginfo_t info = Signal.Siginfo_t.allocateNative(scope);
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Signal.sigwaitinfo(set, info);
                });
            }
            break;
            default:

                final int SIG = Signal.SIGALRM;

                Signal.signal(SIG, Signal.SIG_DFL);
                final Signal.Sigset_t set = Signal.Sigset_t.allocateNative(scope);
                Signal.sigemptyset(set);
                Signal.sigaddset(set, SIG);
                final Signal.Sigset_t oset = Signal.Sigset_t.allocateNative(scope);

                Signal.sigprocmask(Signal.SIG_BLOCK, set, oset);
                try {
                    final Signal.Sigset_t testSet = Signal.Sigset_t.allocateNative(scope);
                    Signal.sigemptyset(testSet);
                    /*
             If the test fails after raising the signal
             and before processing the signal in the test,
             the whole testsuite will crash!
                     */
                    Signal.raise(SIG);
                    Signal.sigpending(testSet);

                    Assertions.assertTrue(Signal.sigismember(testSet, SIG), "Signal must be pending");

                    final Signal.Siginfo_t info = Signal.Siginfo_t.allocateNative(scope);
                    try {
                        final int signal = Signal.sigwaitinfo(set, info);

                        assertEquals(SIG, signal);
                    } catch (NoSuchNativeMethodException nsnme) {
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.println("XXX");
                        System.err.println("XXX  de.ibapl.jnhw.posix.SignalTest.testSigwaitinfo() " + nsnme);
                        System.err.println("XXX  The test suite will crash competely after this - Fix this testcase");
                        System.err.println("XXX");
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.err.flush();
                        Thread.sleep(1000);
                        System.err.flush();
                        //Do the exit here - so wee actually see the message above - otherwise the message will not be visible.
                        System.exit(23);
                    }

                    assertEquals(SIG, info.si_signo());
                    if (MultiarchTupelBuilder.getOS() == OS.FREE_BSD) {
                        //#define SI_LWP                   /* Signal sent by thr_kill */ from /usr/include/sys/signal.h
                        assertEquals(0x10007, info.si_code());
                    } else {
                        assertEquals(0, info.si_code());
                    }
                    //TODO more???

                    Signal.sigemptyset(testSet);

                    Signal.raise(SIG);
                    Signal.sigpending(testSet);

                    Assertions.assertTrue(Signal.sigismember(testSet, SIG), "Signal must be pending");
                    Signal.sigwaitinfo(set, null);
                    Assertions.assertThrows(NullPointerException.class, () -> {
                        Signal.sigwaitinfo(null, info);
                    });
                } finally {
                    //Restore signal mask
                    Signal.sigprocmask(Signal.SIG_SETMASK, oset, null);
                }
        }
    }

    @Test
    public void testUnionSigval() throws Exception {
        MemoryHeap mem = MemoryHeap.wrap(MemorySegment.allocateNative(2, scope));
        Signal.Sigval<MemoryHeap> sigval = Signal.Sigval.allocateNative(scope);
        sigval.sival_int(0x0223344);
        assertEquals(0x0223344, sigval.sival_int());
        sigval.sival_ptr(mem);
        assertEquals(mem, sigval.sival_ptr((baseAddress, scope, parent) -> {
            return new MemoryHeap(baseAddress, scope, mem.sizeof());
        }, scope));
        Assertions.assertNotEquals(22, sigval.sival_int()); //Its is a union, so it must now be different
    }

    @Test
    public void testStructSiginfo_t() throws Exception {
        Signal.Siginfo_t<OpaqueMemory> siginfo_t = Signal.Siginfo_t.allocateNative(scope);
        Assertions.assertNotNull(siginfo_t.si_addr());
        if (MultiarchTupelBuilder.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> siginfo_t.si_band());
        } else {
            Assertions.assertNotNull(siginfo_t.si_band());
        }
        Assertions.assertNotNull(siginfo_t.si_code());
        Assertions.assertNotNull(siginfo_t.si_errno());
        Assertions.assertNotNull(siginfo_t.si_pid());
        Assertions.assertNotNull(siginfo_t.si_uid());
        Assertions.assertNotNull(siginfo_t.si_signo());
        Assertions.assertNotNull(siginfo_t.si_status());
        siginfo_t.si_value.sival_int(55);
    }

    @Test
    public void testStructSigevent_t() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeTypeException.class, () -> Signal.Sigevent.tryAllocateNative(scope));
        } else {
            Signal.Sigevent<OpaqueMemory> sigevent = Signal.Sigevent.tryAllocateNative(scope);
            Assertions.assertNotNull(sigevent.sigev_notify());
            Assertions.assertNotNull(sigevent.sigev_signo());
            sigevent.sigev_value.sival_int(66);

            sigevent.sigev_notify(Signal.SIGEV_SIGNAL.get());
            assertEquals(Signal.SIGEV_SIGNAL.get(), sigevent.sigev_notify());
            sigevent.sigev_signo(Signal.SIGBUS);
            assertEquals(Signal.SIGBUS, sigevent.sigev_signo());

            Callback__V__MA<OpaqueMemory> sigev_notify_function_dummy = new Callback__V__MA<>(MemoryAddress.ofLong(44)) {
                @Override
                protected void callback(MemoryAddress address) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            sigevent.sigev_notify_function(sigev_notify_function_dummy);
            Assertions.assertSame(sigev_notify_function_dummy, sigevent.sigev_notify_functionAsCallback__V_Adr());

            Pthread.Pthread_attr_t pthread_attr_t = Pthread.Pthread_attr_t.allocateNative(scope);
            Pthread.pthread_attr_init(pthread_attr_t);
            sigevent.sigev_notify_attributes(pthread_attr_t);
            final Pthread.Pthread_attr_t pthread_attr_t1
                    = sigevent.sigev_notify_attributes((baseAddress, scope, parent) -> {
                        return new Pthread.Pthread_attr_t(baseAddress, scope);
                    }, scope);
            Assertions.assertSame(pthread_attr_t, pthread_attr_t1);
            Pthread.pthread_attr_destroy(pthread_attr_t);
        }
    }

    @Test
    public void testStructStack_t() throws Exception {
        Signal.Stack_t<OpaqueMemory> stack_t = Signal.Stack_t.allocateNative(scope);
        Assertions.assertEquals(0, stack_t.ss_flags());
        Assertions.assertEquals(0, stack_t.ss_size());
        Assertions.assertNull(stack_t.ss_sp((baseAddress, scope, parent) -> {
            if (parent.ss_size() > 0) {
                return new MemoryHeap(baseAddress, scope, parent.ss_size());
            } else {
                return null;
            }
        }, scope));
    }

    @Test
    public void testStructUcontext_t() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN:
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class,
                        () -> Signal.Ucontext_t.tryAllocateNative(scope));
                break;
            default:
                Signal.Ucontext_t ucontext_t = Signal.Ucontext_t.tryAllocateNative(scope);
                Assertions.assertNull(ucontext_t.uc_link((baseAddress, scope, parent) -> {
                    try {
                        return MemoryAddress.NULL.equals(baseAddress) ? null : Signal.Ucontext_t.tryOfAddress(baseAddress, scope);
                    } catch (NoSuchNativeTypeException nste) {
                        Assertions.fail(nste);
                        throw new RuntimeException(nste);
                    }
                }, scope)); //Maybe fail sometimes....
                Assertions.assertNotNull(ucontext_t.uc_mcontext);
                Assertions.assertNotNull(ucontext_t.uc_sigmask);
                Assertions.assertNotNull(ucontext_t.uc_stack);
        }
    }

    @Test
    public void testStructMcontext_t() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeTypeException.class,
                    () -> Signal.Mcontext_t.tryAllocateNative(scope));
        } else {
            Signal.Mcontext_t mcontext_t = Signal.Mcontext_t.tryAllocateNative(scope);
            Assertions.assertNotNull(mcontext_t); //Opaque to us
        }
    }

    @Test
    public void testStructSigaction() throws Exception {
        Signal.Sigaction<OpaqueMemory> sigaction = Signal.Sigaction.allocateNative(scope);

        sigaction.sa_flags(22);
        assertEquals(22, sigaction.sa_flags());

        Callback__V___I sa_handler = new Callback__V___I(MemoryAddress.ofLong(33)) {
            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        sigaction.sa_handler(sa_handler);
        Assertions.assertSame(sa_handler, sigaction.sa_handlerAsCallback_I_V());

        @SuppressWarnings("unchecked")
        Callback__V___I_MA_MA<Signal.Siginfo_t, OpaqueMemory> sa_sigaction = new Callback__V___I_MA_MA<>(MemoryAddress.ofLong(44)) {
            @Override
            protected void callback(int value, MemoryAddress a, MemoryAddress b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        sigaction.sa_sigaction(sa_sigaction);
        Assertions.assertSame(sa_sigaction, sigaction.sa_sigactionAsCallback_I_Mem_Mem_V());

        RuntimeException rt = Assertions.assertThrows(RuntimeException.class,
                () -> {
                    sigaction.sa_handlerAsCallback_I_V();
                }
        );

    }

}
