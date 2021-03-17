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

import de.ibapl.jnhw.common.callback.Callback_I_Mem_Mem_V;
import de.ibapl.jnhw.common.callback.Callback_I_Mem_Mem_V_Impl;
import de.ibapl.jnhw.common.callback.Callback_I_V;
import de.ibapl.jnhw.common.callback.Callback_I_V_Impl;
import de.ibapl.jnhw.common.callback.Callback_NativeRunnable;
import de.ibapl.jnhw.common.callback.Callback_Mem_V;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.SET_MEM_TO_0;
import static de.ibapl.jnhw.common.memory.AbstractNativeMemory.MEM_UNINITIALIZED;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_I_V;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.Callback__Sigval_int__V;
import java.lang.ref.Cleaner;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class SignalTest {

    // just for vm in qemu...
    private final static long ONE_MINUTE = 60_000;

    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    private final static Cleaner cleaner = Cleaner.create();

    public SignalTest() {
    }

    /**
     * Test of kill method, of class Signal.
     */
    @Test
    public void testKill() throws Exception {
        System.out.println("kill");

        final int sig = Signal.SIGCHLD; //TODO SIGQUIT blows anything away .... WHY??? pthread_kill

        final ObjectRef<Integer> sigRef = new ObjectRef<>();
        final Signal.Sigaction act = new Signal.Sigaction();
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback_I_V_Impl sa_handler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
                synchronized (sigRef) {
                    System.out.println("pthread_t of signalhadler: " + Pthread.pthread_self() + " Java thread ID: " + Thread.currentThread().getId());
                    sigRef.value = sig;
                    sigRef.notifyAll();
                }

            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction oact = new Signal.Sigaction();
        Signal.sigaction(sig, act, oact);
        try {
            System.out.println("pthread_t of testKill: " + Pthread.pthread_self() + " Java thread ID: " + Thread.currentThread().getId());
            Signal.kill(Unistd.getpid(), sig);
            synchronized (sigRef) {
                if (sigRef.value == null) {
                    sigRef.wait(ONE_MINUTE);
                }
            }
            assertEquals(sig, sigRef.value);
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

        final ObjectRef<Integer> sigRef = new ObjectRef<>();
        final Signal.Sigaction act = new Signal.Sigaction();
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback_I_V_Impl sa_handler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
                synchronized (sigRef) {
                    sigRef.value = sig;
                    sigRef.notifyAll();
                }
            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction oact = new Signal.Sigaction();
        Signal.sigaction(sig, act, oact);
        try {
            Signal.killpg(Unistd.getpgrp(), sig);
            synchronized (sigRef) {
                if (sigRef.value == null) {
                    sigRef.wait(ONE_MINUTE);
                }
            }
            assertEquals(sig, sigRef.value);
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
        Signal.Siginfo_t pinfo = new Signal.Siginfo_t();
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
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
        System.out.println("pthread_t of testPthread_kill: " + Pthread.pthread_self() + " Java thread ID: " + Thread.currentThread().getId());

        final int sig = Signal.SIGCHLD; //TODO SIGQUIT blows anything away .... WHY??? pthread_kill

        final ObjectRef<Integer> sigRef = new ObjectRef<>();
        final Signal.Sigaction act = new Signal.Sigaction();
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback_I_V_Impl sa_handler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
                sigRef.value = sig;
                System.out.println("pthread_t of signalhadler: " + Pthread.pthread_self() + " Java thread ID: " + Thread.currentThread().getId());
            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction oact = new Signal.Sigaction();
        Signal.sigaction(sig, act, oact);
        try {
            Thread t = new Thread(() -> {
                try {
                    System.out.println("pthread_t of thread: " + Pthread.pthread_self() + " Java thread ID: " + Thread.currentThread().getId());
                    try {
                        Signal.pthread_kill(Pthread.pthread_self(), sig);
                    } catch (NoSuchNativeMethodException nsnme) {
                        throw new RuntimeException(nsnme);
                    }
                } catch (NativeErrorException nee) {
                    //no-op
                }
            });
            t.start();
            t.join();
            assertEquals(sig, sigRef.value);
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

        final Signal.Sigset_t oset = new Signal.Sigset_t();
        Signal.sigemptyset(oset);
        Signal.pthread_sigmask(0, null, oset);
        try {
            //make sure SIGUSR1 is in signak mask; we want to set it
            System.err.println("current sigprocmask: " + oset);
            Assertions.assertFalse(Signal.sigismember(oset, Signal.SIGUSR1));
            Signal.Sigset_t set = new Signal.Sigset_t();
            Signal.sigemptyset(set);
            Signal.sigaddset(set, Signal.SIGUSR1);
            Signal.pthread_sigmask(Signal.SIG_BLOCK, set, null);
            //Test that SIGUSR1 was set
            final Signal.Sigset_t changedSet = new Signal.Sigset_t();
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

        final ObjectRef<Integer> sigRef = new ObjectRef<>();
        final Signal.Sigaction act = new Signal.Sigaction();
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback_I_V_Impl sa_handler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
                sigRef.value = sig;
            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction oact = new Signal.Sigaction<>();
        Signal.sigaction(sig, act, oact);
        try {
            Signal.raise(sig);
            assertEquals(sig, sigRef.value);
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

        final Signal.Sigaction<OpaqueMemory32> act = new Signal.Sigaction<>();
        act.sa_flags(Signal.SA_RESTART);
        Signal.sigemptyset(act.sa_mask);

        Callback_I_V_Impl sa_handler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction<OpaqueMemory32> oact = new Signal.Sigaction<>();
        Signal.sigaction(SIG, null, oact);
        try {
            Signal.sigaction(SIG, act, oact);
            Signal.sigaction(SIG, act, null);
            if ((oact.sa_flags() & Signal.SA_SIGINFO) == Signal.SA_SIGINFO) {
                Assertions.assertEquals(Signal.SIG_DFL, oact.sa_sigaction());
            } else {
                Assertions.assertEquals(Signal.SIG_DFL, oact.sa_handler());
            }

            final Signal.Sigaction<OpaqueMemory32> actOut = new Signal.Sigaction<>();
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
        final Memory32Heap ss_sp = new Memory32Heap((OpaqueMemory32) null, 0, Signal.MINSIGSTKSZ, SET_MEM_TO_0);
        Signal.Stack_t ss = Signal.Stack_t.of(Signal.SS_DISABLE, ss_sp);
        Signal.Stack_t oss = new Signal.Stack_t();
        Signal.sigaltstack(null, oss);
        try {
            Signal.sigaltstack(null, null);
            Signal.sigaltstack(ss, oss);
        } finally {
            Signal.sigaltstack(oss, null);
        }
    }

    /**
     * Test of sigemptyset, sigdelset, sigfillset, sigaddset, sigismember
     * methods of Sigset_t, of class Signal.
     */
    @Test
    public void testSigset_t() throws Exception {
        System.out.println("Sigset_t");
        Signal.Sigset_t set = new Signal.Sigset_t();

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
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.sighold(sig));
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.sigrelse(sig));
        } else {
            Signal.sighold(sig);
            Signal.Sigset_t mask = new Signal.Sigset_t();
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
            if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
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
        Signal.Sigaction oact = new Signal.Sigaction();
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

        final ObjectRef<Integer> raisedSignal = new ObjectRef<>(null);
        final Callback_I_V_Impl funcHandler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
                raisedSignal.value = sig;
                System.out.println("Got signal: " + sig);
            }
        };

        var old = Signal.signal(SIG, funcHandler);
        try {
            Assertions.assertEquals(funcIgnore, old);

            Signal.raise(SIG);
            Assertions.assertEquals(Integer.valueOf(SIG), raisedSignal.value);

            old = Signal.signal(SIG, null);
            Assertions.assertEquals(funcHandler, old);

        } finally {
            //Restore the signal on error the cleaner shoult take care of restoring.
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
            Signal.signal(Signal.SIGSTOP, oldSignalHandler);
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

        final ObjectRef<Object> resultRef = new ObjectRef<>();

        new Thread() {
            @Override
            public void run() {
                try {
                    Signal.sigpause(SIG);
                    synchronized (resultRef) {
                        resultRef.value = Boolean.TRUE;
                        resultRef.notify();
                    }
                } catch (NoSuchNativeMethodException nsnme) {
                    synchronized (resultRef) {
                        resultRef.value = nsnme;
                        resultRef.notify();
                    }
                } catch (NativeErrorException nee) {
                    synchronized (resultRef) {
                        resultRef.value = nee;
                        resultRef.notify();
                    }
                }
            }
        }.start();
        Thread.sleep(10000);
        Signal.raise(SIG);
        synchronized (resultRef) {
            if (resultRef.value == null) {
                resultRef.wait(ONE_MINUTE);
            }
        }
        Assertions.assertNotNull(resultRef.value);
        Assertions.assertEquals(Boolean.class, resultRef.value.getClass(), "value was: " + resultRef.value);
        Assertions.assertEquals(Boolean.TRUE, resultRef.value);
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

        Signal.Sigset_t set = new Signal.Sigset_t();
        Signal.sigemptyset(set);
        Signal.sigpending(set);
        assertEquals("[]", set.nativeToString());
        Assertions.assertArrayEquals(new byte[Signal.Sigset_t.LAYOUT.sizeof], OpaqueMemory32.toBytes(set));
    }

    /**
     * Test of sigprocmask method, of class Signal.
     */
    @Test
    public void testSigprocmask() throws Exception {
        System.out.println("sigprocmask");

        Signal.sigprocmask(0, null, null);

        final Signal.Sigset_t oset = new Signal.Sigset_t();
        Signal.sigemptyset(oset);
        Signal.sigprocmask(0, null, oset);
        try {
            //make sure SIGUSR1 is in signak mask; we want to set it
            System.err.println("current sigprocmask: " + oset);
            Assertions.assertFalse(Signal.sigismember(oset, Signal.SIGUSR1));
            Signal.Sigset_t set = new Signal.Sigset_t();
            Signal.sigemptyset(set);
            Signal.sigaddset(set, Signal.SIGUSR1);
            Signal.sigprocmask(Signal.SIG_BLOCK, set, null);
            //Test that SIGUSR1 was set
            final Signal.Sigset_t changedSet = new Signal.Sigset_t();
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
    public void testSigqueue() throws Exception {
        System.out.println("sigqueue");
        final int SIG = Signal.SIGUSR2;
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.sigqueue(Unistd.getpid(), SIG, null));
        } else {

            final Signal.Sigaction act = new Signal.Sigaction();
            act.sa_flags(Signal.SA_SIGINFO);
            Signal.sigemptyset(act.sa_mask);

            final ObjectRef<Signal.Siginfo_t> siginfo_tRef = new ObjectRef<>(null);
            final ObjectRef<Signal.Ucontext_t> opmRef = new ObjectRef<>(null);

            Callback_I_Mem_Mem_V_Impl<Signal.Siginfo_t, Signal.Ucontext_t> sa_handler = new Callback_I_Mem_Mem_V_Impl<>() {

                @Override
                protected void callback(int value, Signal.Siginfo_t a, Signal.Ucontext_t b) {
                    siginfo_tRef.value = a;
                    opmRef.value = b;
                }

                @Override
                protected Signal.Siginfo_t wrapA(NativeAddressHolder address) {
                    return new Signal.Siginfo_t(address);
                }

                @Override
                protected Signal.Ucontext_t wrapB(NativeAddressHolder address) {
                    try {
                        return new Signal.Ucontext_t(address);
                    } catch (NoSuchNativeTypeException nste) {
                        Assertions.fail(nste);
                        throw new RuntimeException(nste);
                    }
                }
            };

            act.sa_sigaction(sa_handler);

            final Signal.Sigaction oact = new Signal.Sigaction();
            final Signal.Sigaction actOut = new Signal.Sigaction();
            Signal.sigaction(SIG, act, oact);

            OpaqueMemory32 data = new Memory32Heap((OpaqueMemory32) null, 0, 128, SET_MEM_TO_0);

            Signal.Sigval sigval = new Signal.Sigval();
            sigval.sival_ptr(data);

            Signal.sigqueue(Unistd.getpid(), SIG, sigval);

            Thread.sleep(100);

            System.out.println("de.ibapl.jnhw.posix.SignalTest.testSigqueue() siginfo_tRef.value: " + siginfo_tRef.value);
            try {
                Assertions.assertNotNull(siginfo_tRef.value);
                Assertions.assertAll(
                        () -> {
                            Assertions.assertEquals(0, siginfo_tRef.value.si_errno(), "siginfo_tRef.value.si_errno()");
                        },
                        () -> {
                            Assertions.assertEquals(SIG, siginfo_tRef.value.si_signo(), "siginfo_tRef.value.si_signo()");
                        },
                        () -> {
                            Assertions.assertEquals(data, siginfo_tRef.value.si_value.sival_ptr((baseAddress, size) -> {
                                return new Memory32Heap(baseAddress, data.sizeInBytes) {
                                };
                            }), "siginfo_tRef.value.si_value.sival_ptr()");
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
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.sigset(Signal.SIGABRT, null));
        } else {
            FunctionPtr_I_V result = Signal.sigset(Signal.SIGABRT, null);
            Assertions.assertEquals(Signal.SIG_DFL, result);
            result = Signal.sigset(Signal.SIGABRT, result);
            Assertions.assertEquals(NativeAddressHolder.NULL, NativeFunctionPointer.toNativeAddressHolder(result), "result.address ");
        }
    }

    /**
     * Test of sigsuspend method, of class Signal.
     */
    @Test
    public void testSigsuspend() throws Exception {
        System.out.println("sigsuspend");
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            Assertions.fail("OPEN BSD will crash during test SIGALRM??");
        }
        final int SIG = Signal.SIGALRM;

        final Callback_I_V_Impl funcHandler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
                System.out.println("Got signal: " + sig);
            }
        };
        final var oldHandler = Signal.signal(SIG, funcHandler);

        final var act = new Signal.Sigset_t();
        Signal.sigemptyset(act);
        Signal.sigaddset(act, SIG);

        final var oact = new Signal.Sigset_t();
        Signal.sigemptyset(oact);
        Signal.sigprocmask(Signal.SIG_BLOCK, act, oact);

        try {
            final Signal.Sigset_t sigmask = new Signal.Sigset_t();
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
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            Assertions.fail("OPEN BSD will crash during test SIGALRM??");
        }
        final int SIG = Signal.SIGALRM;

        final Signal.Sigset_t set = new Signal.Sigset_t();
        Signal.sigemptyset(set);
        Signal.sigaddset(set, SIG);

        final Signal.Sigset_t oset = new Signal.Sigset_t();

        final Signal.Siginfo_t info = new Signal.Siginfo_t();

        final Time.Timespec timeout = new Time.Timespec(MEM_UNINITIALIZED);
        timeout.tv_nsec(0);
        timeout.tv_sec(10);

        Signal.sigprocmask(Signal.SIG_BLOCK, set, oset);
        try {
            Signal.pthread_kill(Pthread.pthread_self(), SIG); //We need to fire in this thread ...
            int signal = Signal.sigtimedwait(set, info, timeout);

            assertEquals(SIG, signal);
            assertEquals(SIG, info.si_signo());
            if (MULTIARCHTUPEL_BUILDER.getOS() == de.ibapl.jnhw.libloader.OS.FREE_BSD) {
                //#define SI_LWP                   /* Signal sent by thr_kill */ from /usr/include/sys/signal.h
                assertEquals(0x10007, info.si_code());
            } else {
                assertEquals(0, info.si_code());
            }

            Signal.raise(SIG);
            signal = Signal.sigtimedwait(set, null, timeout);

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

    /**
     * Test of sigwait method, of class Signal.
     */
    @Test
    public void testSigwait() throws Exception {
        System.out.println("sigwait");
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            Assertions.fail("OPEN BSD will crash during test SIGALRM??");
        }
        final int SIG = Signal.SIGALRM;

        Signal.signal(SIG, Signal.SIG_DFL);
        final Signal.Sigset_t set = new Signal.Sigset_t();
        Signal.sigemptyset(set);
        Signal.sigaddset(set, SIG);
        final Signal.Sigset_t oset = new Signal.Sigset_t();

        Signal.sigprocmask(Signal.SIG_BLOCK, set, oset);
        try {
            Signal.raise(SIG);
            final Signal.Sigset_t testSet = new Signal.Sigset_t();
            Signal.sigemptyset(testSet);

            Signal.sigpending(testSet);
            Assertions.assertTrue(Signal.sigismember(testSet, SIG), "Signal must be pending");
            final int signal = Signal.sigwait(set);
            assertEquals(SIG, signal);

            Assertions.assertThrows(NullPointerException.class, () -> {
                Signal.sigwait(null);
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
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            Assertions.fail("OPEN BSD will crash during test SIGALRM??");
        }

        final int SIG = Signal.SIGALRM;

        Signal.signal(SIG, Signal.SIG_DFL);
        final Signal.Sigset_t set = new Signal.Sigset_t();
        Signal.sigemptyset(set);
        Signal.sigaddset(set, SIG);
        final Signal.Sigset_t oset = new Signal.Sigset_t();

        Signal.sigprocmask(Signal.SIG_BLOCK, set, oset);
        try {
            /*
             If the test fails after raising the signal
             and before processing the signal in the test,
             the whole testsuite will crash!
             */
            Signal.raise(SIG);
            final Signal.Sigset_t testSet = new Signal.Sigset_t();
            Signal.sigemptyset(testSet);

            Signal.sigpending(testSet);
            Assertions.assertTrue(Signal.sigismember(testSet, SIG), "Signal must be pending");
            final Signal.Siginfo_t info = new Signal.Siginfo_t();
            final int signal = Signal.sigwaitinfo(set, info);
            assertEquals(SIG, signal);
            assertEquals(SIG, info.si_signo());
            if (MULTIARCHTUPEL_BUILDER.getOS() == de.ibapl.jnhw.libloader.OS.FREE_BSD) {
                //#define SI_LWP                   /* Signal sent by thr_kill */ from /usr/include/sys/signal.h
                assertEquals(0x10007, info.si_code());
            } else {
                assertEquals(0, info.si_code());
            }
            //TODO more???

            Signal.raise(SIG);
            Signal.sigemptyset(testSet);

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

    @Test
    public void testUnionSigval() throws Exception {
        Memory32Heap mem = new Memory32Heap((OpaqueMemory32) null, 0, 2, null);
        Signal.Sigval<Memory32Heap> sigval = new Signal.Sigval<>();
        sigval.sival_int(22);
        assertEquals(22, sigval.sival_int());
        sigval.sival_ptr(mem);
        assertEquals(mem, sigval.sival_ptr((baseAddress, size) -> {
            return new Memory32Heap(baseAddress, mem.sizeInBytes) {
            };
        }));
        Assertions.assertNotEquals(22, sigval.sival_int()); //Its is a union, so it must now be different
    }

    @Test
    public void testStructSiginfo_t() throws Exception {
        Signal.Siginfo_t<OpaqueMemory32> siginfo_t = new Signal.Siginfo_t<>();
        Assertions.assertNotNull(siginfo_t.si_addr());
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
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
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeTypeException.class, () -> new Signal.Sigevent<>());
        } else {
            Signal.Sigevent<OpaqueMemory32> sigevent = new Signal.Sigevent<>();
            Assertions.assertNotNull(sigevent.sigev_notify());
            Assertions.assertNotNull(sigevent.sigev_signo());
            sigevent.sigev_value.sival_int(66);

            sigevent.sigev_notify(Signal.SIGEV_SIGNAL.get());
            assertEquals(Signal.SIGEV_SIGNAL.get(), sigevent.sigev_notify());
            sigevent.sigev_signo(Signal.SIGBUS);
            assertEquals(Signal.SIGBUS, sigevent.sigev_signo());

            Callback__Sigval_int__V sigev_notify_functionLong = new Callback__Sigval_int__V(NativeAddressHolder.ofUintptr_t(44)) {
                @Override
                protected void callback(int value) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            sigevent.sigev_notify_function(sigev_notify_functionLong);
            Assertions.assertSame(sigev_notify_functionLong, sigevent.sigev_notify_functionAsCallback__Sigval_int__V());

            @SuppressWarnings("unchecked")
            Callback_Mem_V<OpaqueMemory32> sigev_notify_functionPtr = new Callback_Mem_V<>(NativeAddressHolder.ofUintptr_t(44)) {
                @Override
                protected void callback(OpaqueMemory32 a) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            sigevent.sigev_notify_function(sigev_notify_functionPtr);
            Assertions.assertSame(sigev_notify_functionPtr, sigevent.sigev_notify_functionAsCallback_PtrOpaqueMemory_V());

            Callback_NativeRunnable sigev_notify_functionRunnable = Callback_NativeRunnable.INSTANCE;
            sigevent.sigev_notify_function(sigev_notify_functionRunnable);
            Assertions.assertSame(sigev_notify_functionRunnable, sigevent.sigev_notify_functionAsCallback_NativeRunnable());

            Pthread.Pthread_attr_t pthread_attr_t = new Pthread.Pthread_attr_t();
            Pthread.pthread_attr_init(pthread_attr_t);
            sigevent.sigev_notify_attributes(pthread_attr_t);
            final Pthread.Pthread_attr_t pthread_attr_t1
                    = sigevent.sigev_notify_attributes((baseAddress, parent) -> {
                        return new Pthread.Pthread_attr_t(baseAddress);
                    });
            Assertions.assertSame(pthread_attr_t, pthread_attr_t1);
            Pthread.pthread_attr_destroy(pthread_attr_t);
        }
    }

    @Test
    public void testStructStack_t() throws Exception {
        Signal.Stack_t<OpaqueMemory32> stack_t = new Signal.Stack_t<>();
        Assertions.assertNotNull(stack_t.ss_flags());
        Assertions.assertNotNull(stack_t.ss_size());
        Assertions.assertNotNull(stack_t.ss_sp((baseAddress, parent) -> {
            return new Memory32Heap(baseAddress, (int) parent.ss_size()) {
            };
        }));
    }

    @Test
    public void testStructUcontext_t() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeTypeException.class, () -> new Signal.Ucontext_t(MEM_UNINITIALIZED));
        } else {
            Signal.Ucontext_t ucontext_t = new Signal.Ucontext_t(SET_MEM_TO_0);
            Assertions.assertNull(ucontext_t.uc_link((baseAddress, parent) -> {
                try {
                    return baseAddress.isNULL() ? null : new Signal.Ucontext_t(baseAddress);
                } catch (NoSuchNativeTypeException nste) {
                    Assertions.fail(nste);
                    throw new RuntimeException(nste);
                }
            })); //Maybe fail sometimes....
            Assertions.assertNotNull(ucontext_t.uc_mcontext);
            Assertions.assertNotNull(ucontext_t.uc_sigmask);
            Assertions.assertNotNull(ucontext_t.uc_stack);
        }
    }

    @Test
    public void testStructMcontext_t() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            Assertions.assertThrows(NoSuchNativeTypeException.class, () -> new Signal.Mcontext_t());
        } else {
            Signal.Mcontext_t mcontext_t = new Signal.Mcontext_t();
            Assertions.assertNotNull(mcontext_t); //Opaque to us
        }
    }

    @Test
    public void testStructSigaction() throws Exception {
        Signal.Sigaction<OpaqueMemory32> sigaction = new Signal.Sigaction<>();

        sigaction.sa_flags(22);
        assertEquals(22, sigaction.sa_flags());

        Callback_I_V sa_handler = new Callback_I_V(NativeAddressHolder.ofUintptr_t(33)) {
            @Override
            protected void callback(int value) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        sigaction.sa_handler(sa_handler);
        Assertions.assertSame(sa_handler, sigaction.sa_handlerAsCallback_I_V());

        @SuppressWarnings("unchecked")
        Callback_I_Mem_Mem_V<Signal.Siginfo_t, OpaqueMemory32> sa_sigaction = new Callback_I_Mem_Mem_V<>(NativeAddressHolder.ofUintptr_t(44)) {
            @Override
            protected void callback(int value, Signal.Siginfo_t a, OpaqueMemory32 b) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        sigaction.sa_sigaction(sa_sigaction);
        Assertions.assertSame(sa_sigaction, sigaction.sa_sigactionAsCallback_I_Mem_Mem_V());

        RuntimeException rt = Assertions.assertThrows(RuntimeException.class, () -> {
            sigaction.sa_handlerAsCallback_I_V();
        });

    }

    @Test
    public void testSizeOfMcontext_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getArch()) {
                    case AARCH64:
                        Assertions.assertEquals(4384, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case ARM:
                        Assertions.assertEquals(84, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case I386:
                        Assertions.assertEquals(88, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case MIPS_64:
                        Assertions.assertEquals(600, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case MIPS:
                        Assertions.assertEquals(592, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case POWER_PC_64:
                        Assertions.assertEquals(1272, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case S390_X:
                        Assertions.assertEquals(344, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case X86_64:
                        Assertions.assertEquals(256, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
                        break;
                    default:
                        Assertions.assertEquals(-1, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
                }
                break;
            case FREE_BSD:
                Assertions.assertEquals(800, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, Signal.Mcontext_t::getLayoutOrThrow);
                break;
            default:
                Assertions.assertEquals(-1, Signal.Mcontext_t.getLayoutOrThrow().sizeof);
        }
    }

    @Test
    public void testAlignOfMcontext_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getArch()) {
                    case AARCH64:
                        Assertions.assertEquals(Alignment.AT_16, Signal.Mcontext_t.getLayoutOrThrow().alignment);
                        break;
                    case ARM:
                    case I386:
                        Assertions.assertEquals(Alignment.AT_4, Signal.Mcontext_t.getLayoutOrThrow().alignment);
                        break;
                    case MIPS_64:
                    case MIPS:
                    case POWER_PC_64:
                    case S390_X:
                    case X86_64:
                        Assertions.assertEquals(Alignment.AT_8, Signal.Mcontext_t.getLayoutOrThrow().alignment);
                        break;
                    default:
                        Assertions.fail("Signal.Mcontext_t.getLayoutOrThrow().alignment " + Signal.Mcontext_t.getLayoutOrThrow().alignment);
                }
                break;
            case FREE_BSD:
                Assertions.assertEquals(Alignment.AT_16, Signal.Mcontext_t.getLayoutOrThrow().alignment);
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, Signal.Mcontext_t::getLayoutOrThrow);
                break;
            default:
                Assertions.fail("Signal.Mcontext_t.getLayoutOrThrow().alignment " + Signal.Mcontext_t.getLayoutOrThrow().alignment);
        }
    }

    @Test
    public void testSizeOfSigaction() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getArch()) {
                    case AARCH64:
                    case MIPS_64:
                    case POWER_PC_64:
                    case S390_X:
                    case X86_64:
                        Assertions.assertEquals(152, Signal.Sigaction.LAYOUT.sizeof);
                        break;
                    case ARM:
                    case I386:
                        Assertions.assertEquals(140, Signal.Sigaction.LAYOUT.sizeof);
                        break;
                    case MIPS:
                        Assertions.assertEquals(144, Signal.Sigaction.LAYOUT.sizeof);
                        break;
                    default:
                        Assertions.assertEquals(-1, Signal.Sigaction.LAYOUT.sizeof);
                }
                break;
            case FREE_BSD:
                Assertions.assertEquals(32, Signal.Sigaction.LAYOUT.sizeof);
                break;
            case OPEN_BSD:
                Assertions.assertEquals(16, Signal.Sigaction.LAYOUT.sizeof);
                break;
            default:
                Assertions.fail("Signal.Sigaction.LAYOUT.sizeof " + Signal.Sigaction.LAYOUT.sizeof);
        }
    }

    @Test
    public void testAlignOfSigaction() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                Assertions.assertEquals(Alignment.AT_4, Signal.Sigaction.LAYOUT.alignment);
                break;
            case _64_BIT:
                Assertions.assertEquals(Alignment.AT_8, Signal.Sigaction.LAYOUT.alignment);
                break;
            default:
                Assertions.fail("Signal.Sigaction.LAYOUT.alignment " + Signal.Sigaction.LAYOUT.alignment);
        }
    }

    @Test
    public void testOffsetofSa_mask() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getArch()) {
                    case AARCH64:
                    case MIPS:
                    case POWER_PC_64:
                    case X86_64:
                        Assertions.assertEquals(8, Signal.Sigaction.LAYOUT.sa_mask);
                        break;
                    case ARM:
                    case I386:
                        Assertions.assertEquals(4, Signal.Sigaction.LAYOUT.sa_mask);
                        break;
                    case MIPS_64:
                        Assertions.assertEquals(16, Signal.Sigaction.LAYOUT.sa_mask);
                        break;
                    case S390_X:
                        Assertions.assertEquals(24, Signal.Sigaction.LAYOUT.sa_mask);
                        break;
                    default:
                        Assertions.assertEquals(-1, Signal.Sigaction.LAYOUT.sa_mask);
                }
                break;
            case FREE_BSD:
                Assertions.assertEquals(12, Signal.Sigaction.LAYOUT.sa_mask);
                break;
            case OPEN_BSD:
                Assertions.assertEquals(8, Signal.Sigaction.LAYOUT.sa_mask);
                break;
            default:
                Assertions.assertEquals(-1, Signal.Sigaction.LAYOUT.sa_mask);
        }
    }

    @Test
    public void testSizeOfSigevent() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                Assertions.assertEquals(64, Signal.Sigevent.getLayoutOrThrow().sizeof);
                break;
            case FREE_BSD:
                Assertions.assertEquals(80, Signal.Sigevent.getLayoutOrThrow().sizeof);
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, Signal.Sigevent::getLayoutOrThrow);
                break;
            default:
                Assertions.fail("Signal.Sigevent.getLayoutOrThrow().sizeof " + Signal.Sigevent.getLayoutOrThrow().sizeof);
        }
    }

    @Test
    public void testAlignOfSigevent() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case FREE_BSD:
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
                    case _32_BIT:
                        Assertions.assertEquals(Alignment.AT_4, Signal.Sigevent.getLayoutOrThrow().alignment);
                        break;
                    case _64_BIT:
                        Assertions.assertEquals(Alignment.AT_8, Signal.Sigevent.getLayoutOrThrow().alignment);
                        break;
                    default:
                        Assertions.fail("Signal.Sigevent.getLayoutOrThrow().alignment " + Signal.Sigevent.getLayoutOrThrow().alignment);
                }
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, Signal.Sigevent::getLayoutOrThrow);
                break;
            default:
                Assertions.fail("Signal.Sigevent.getLayoutOrThrow().alignment " + Signal.Sigevent.getLayoutOrThrow().alignment);
        }
    }

    @Test
    public void testOffsetOfSigev_value() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                Assertions.assertEquals(0, Signal.Sigevent.getLayoutOrThrow().sigev_value);
                break;
            case FREE_BSD:
                Assertions.assertEquals(8, Signal.Sigevent.getLayoutOrThrow().sigev_value);
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, Signal.Sigevent::getLayoutOrThrow);
                break;
            default:
                Assertions.fail("Signal.Sigevent.getLayoutOrThrow().sigev_value " + Signal.Sigevent.getLayoutOrThrow().sigev_value);
        }
    }

    @Test
    public void testSizeOfSiginfo_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                Assertions.assertEquals(128, Signal.Siginfo_t.LAYOUT.sizeof);
                break;
            case FREE_BSD:
                Assertions.assertEquals(80, Signal.Siginfo_t.LAYOUT.sizeof);
                break;
            case OPEN_BSD:
                Assertions.assertEquals(136, Signal.Siginfo_t.LAYOUT.sizeof);
                break;
            default:
                Assertions.fail("Signal.Siginfo_t.LAYOUT.sizeof " + Signal.Siginfo_t.LAYOUT.sizeof);
        }
    }

    @Test
    public void testAlignOfSiginfo_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                Assertions.assertEquals(Alignment.AT_4, Signal.Siginfo_t.LAYOUT.alignment);
                break;
            case _64_BIT:
                Assertions.assertEquals(Alignment.AT_8, Signal.Siginfo_t.LAYOUT.alignment);
                break;
            default:
                Assertions.fail("Signal.Siginfo_t.LAYOUT.alignment " + Signal.Siginfo_t.LAYOUT.alignment);
        }
    }

    @Test
    public void testOffsetOfSi_value() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
                    case _64_BIT:
                        Assertions.assertEquals(24, Signal.Siginfo_t.LAYOUT.si_value);
                        break;
                    case _32_BIT:
                        Assertions.assertEquals(20, Signal.Siginfo_t.LAYOUT.si_value);
                        break;
                    default:
                        Assertions.fail("Signal.Siginfo_t.LAYOUT.si_value " + Signal.Siginfo_t.LAYOUT.si_value);
                }
                break;
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertEquals(32, Signal.Siginfo_t.LAYOUT.si_value);
                break;
            default:
                Assertions.fail("Signal.Siginfo_t.LAYOUT.si_value " + Signal.Siginfo_t.LAYOUT.si_value);
        }
    }

    @Test
    public void testSizeOfSigset_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                Assertions.assertEquals(128, Signal.Sigset_t.LAYOUT.sizeof);
                break;
            case FREE_BSD:
                Assertions.assertEquals(16, Signal.Sigset_t.LAYOUT.sizeof);
                break;
            case OPEN_BSD:
                Assertions.assertEquals(4, Signal.Sigset_t.LAYOUT.sizeof);
                break;
            default:
                Assertions.fail("Signal.Sigset_t.LAYOUT.sizeof " + Signal.Sigset_t.LAYOUT.sizeof);
        }
    }

    @Test
    public void testAlignOfSigset_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
                    case _32_BIT:
                        Assertions.assertEquals(Alignment.AT_4, Signal.Sigset_t.LAYOUT.alignment);
                        break;
                    case _64_BIT:
                        Assertions.assertEquals(Alignment.AT_8, Signal.Sigset_t.LAYOUT.alignment);
                        break;
                    default:
                        Assertions.fail("Signal.Sigset_t.LAYOUT.alignment " + Signal.Sigset_t.LAYOUT.alignment);
                }
                break;
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertEquals(Alignment.AT_4, Signal.Sigset_t.LAYOUT.alignment);
                break;
            default:
                Assertions.fail("Signal.Sigset_t.LAYOUT.alignment " + Signal.Sigset_t.LAYOUT.alignment);
        }
    }

    @Test
    public void testSizeOfSigval() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                Assertions.assertEquals(4, Signal.Sigval.LAYOUT.sizeof);
                break;
            case _64_BIT:
                Assertions.assertEquals(8, Signal.Sigval.LAYOUT.sizeof);
                break;
            default:
                Assertions.fail("Signal.Sigval.LAYOUT.sizeof " + Signal.Sigval.LAYOUT.sizeof);
        }
    }

    @Test
    public void testAlignOfSigval() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                Assertions.assertEquals(Alignment.AT_4, Signal.Sigval.LAYOUT.alignment);
                break;
            case _64_BIT:
                Assertions.assertEquals(Alignment.AT_8, Signal.Sigval.LAYOUT.alignment);
                break;
            default:
                Assertions.fail("Signal.Sigval.LAYOUT.alignment " + Signal.Sigval.LAYOUT.alignment);
        }
    }

    @Test
    public void testSizeOfStack_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                Assertions.assertEquals(12, Signal.Stack_t.LAYOUT.sizeof);
                break;
            case _64_BIT:
                Assertions.assertEquals(24, Signal.Stack_t.LAYOUT.sizeof);
                break;
            default:
                Assertions.fail("Signal.Stack_t.LAYOUT.sizeof " + Signal.Stack_t.LAYOUT.sizeof);
        }
    }

    @Test
    public void testAlignOfStack_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                Assertions.assertEquals(Alignment.AT_4, Signal.Stack_t.LAYOUT.alignment);
                break;
            case _64_BIT:
                Assertions.assertEquals(Alignment.AT_8, Signal.Stack_t.LAYOUT.alignment);
                break;
            default:
                Assertions.fail("Signal.Stack_t.LAYOUT.alignment " + Signal.Stack_t.LAYOUT.alignment);
        }
    }

    @Test
    public void testSizeOfUcontext_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getArch()) {
                    case AARCH64:
                        Assertions.assertEquals(4560, Signal.Ucontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case ARM:
                        Assertions.assertEquals(744, Signal.Ucontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case I386:
                        Assertions.assertEquals(364, Signal.Ucontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case MIPS_64:
                        Assertions.assertEquals(768, Signal.Ucontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case MIPS:
                        Assertions.assertEquals(744, Signal.Ucontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case POWER_PC_64:
                        Assertions.assertEquals(1440, Signal.Ucontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case S390_X:
                        Assertions.assertEquals(512, Signal.Ucontext_t.getLayoutOrThrow().sizeof);
                        break;
                    case X86_64:
                        Assertions.assertEquals(968, Signal.Ucontext_t.getLayoutOrThrow().sizeof);
                        break;
                    default:
                        Assertions.assertEquals(-1, Signal.Ucontext_t.getLayoutOrThrow().sizeof);
                }
                break;
            case FREE_BSD:
                Assertions.assertEquals(880, Signal.Ucontext_t.getLayoutOrThrow().sizeof);
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, Signal.Ucontext_t::getLayoutOrThrow);
                break;
            default:
                Assertions.fail("Signal.Ucontext_t.getLayoutOrThrow().sizeof " + Signal.Ucontext_t.getLayoutOrThrow().sizeof);
        }
    }

    @Test
    public void testAlignOfUcontext_t() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getArch()) {
                    case AARCH64:
                        Assertions.assertEquals(Alignment.AT_16, Signal.Ucontext_t.getLayoutOrThrow().alignment);
                        break;
                    case ARM:
                    case MIPS:
                    case MIPS_64:
                    case POWER_PC_64:
                    case S390_X:
                    case X86_64:
                        Assertions.assertEquals(Alignment.AT_8, Signal.Ucontext_t.getLayoutOrThrow().alignment);
                        break;
                    case I386:
                        Assertions.assertEquals(Alignment.AT_4, Signal.Ucontext_t.getLayoutOrThrow().alignment);
                        break;
                    default:
                        Assertions.fail("Signal.Ucontext_t.getLayoutOrThrow().alignment " + Signal.Ucontext_t.getLayoutOrThrow().alignment);
                }
                break;
            case FREE_BSD:
                Assertions.assertEquals(Alignment.AT_16, Signal.Ucontext_t.getLayoutOrThrow().alignment);
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, Signal.Ucontext_t::getLayoutOrThrow);
                break;
            default:
                Assertions.fail("Signal.Ucontext_t.getLayoutOrThrow().alignment " + Signal.Ucontext_t.getLayoutOrThrow().alignment);
        }
    }

    @Test
    public void testOffsetofUc_mcontext() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getArch()) {
                    case AARCH64:
                        Assertions.assertEquals(176, Signal.Ucontext_t.getLayoutOrThrow().uc_mcontext);
                        break;
                    case ARM:
                    case I386:
                        Assertions.assertEquals(20, Signal.Ucontext_t.getLayoutOrThrow().uc_mcontext);
                        break;
                    case POWER_PC_64:
                        Assertions.assertEquals(168, Signal.Ucontext_t.getLayoutOrThrow().uc_mcontext);
                        break;
                    case MIPS_64:
                    case S390_X:
                    case X86_64:
                        Assertions.assertEquals(40, Signal.Ucontext_t.getLayoutOrThrow().uc_mcontext);
                        break;
                    case MIPS:
                        Assertions.assertEquals(24, Signal.Ucontext_t.getLayoutOrThrow().uc_mcontext);
                        break;
                    default:
                        Assertions.fail("Signal.Ucontext_t.getLayoutOrThrow().uc_mcontext" + Signal.Ucontext_t.getLayoutOrThrow().uc_mcontext);
                }
                break;

            case FREE_BSD:
                Assertions.assertEquals(16, Signal.Ucontext_t.getLayoutOrThrow().uc_mcontext);
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, Signal.Ucontext_t::getLayoutOrThrow);
                break;
            default:
                Assertions.fail("Signal.Ucontext_t.getLayoutOrThrow().uc_mcontext" + Signal.Ucontext_t.getLayoutOrThrow().uc_mcontext);
        }
    }

    @Test
    public void testOffsetofUc_sigmask() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getArch()) {
                    case AARCH64:
                    case POWER_PC_64:
                        Assertions.assertEquals(40, Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask);
                        break;
                    case ARM:
                        Assertions.assertEquals(104, Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask);
                        break;
                    case I386:
                        Assertions.assertEquals(108, Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask);
                        break;
                    case MIPS:
                        Assertions.assertEquals(616, Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask);
                        break;
                    case MIPS_64:
                        Assertions.assertEquals(640, Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask);
                        break;
                    case S390_X:
                        Assertions.assertEquals(384, Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask);
                        break;
                    case X86_64:
                        Assertions.assertEquals(296, Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask);
                        break;
                    default:
                        Assertions.fail("Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask" + Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask);
                }
                break;
            case FREE_BSD:
                Assertions.assertEquals(0, Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask);
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, Signal.Ucontext_t::getLayoutOrThrow);
                break;
            default:
                Assertions.fail("Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask" + Signal.Ucontext_t.getLayoutOrThrow().uc_sigmask);
        }
    }

    @Test
    public void testOffsetofUc_stack() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
                    case _32_BIT:
                        Assertions.assertEquals(8, Signal.Ucontext_t.getLayoutOrThrow().uc_stack);
                        break;
                    case _64_BIT:
                        Assertions.assertEquals(16, Signal.Ucontext_t.getLayoutOrThrow().uc_stack);
                        break;
                    default:
                        Assertions.fail("Signal.Ucontext_t.getLayoutOrThrow().uc_stack " + Signal.Ucontext_t.getLayoutOrThrow().uc_stack);
                }
                break;
            case FREE_BSD:
                Assertions.assertEquals(824, Signal.Ucontext_t.getLayoutOrThrow().uc_stack);
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeException.class, Signal.Ucontext_t::getLayoutOrThrow);
                break;
            default:
                Assertions.fail("Signal.Ucontext_t.getLayoutOrThrow().uc_stack " + Signal.Ucontext_t.getLayoutOrThrow().uc_stack);
        }
    }

}
