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

import de.ibapl.jnhw.Callback_I_V;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.NativeFunctionPointer;
import de.ibapl.jnhw.ObjectRef;
import de.ibapl.jnhw.OpaqueMemory;
import java.lang.ref.Cleaner;
import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 *
 * @author aploese
 */
public class SignalTest {

    private final static Cleaner cleaner = Cleaner.create();

    public SignalTest() {
    }

    /**
     * Test of si_addr method, of class Signal.
     */
    @Test
    public void testSi_addr() {
        System.out.println("si_addr");
        long expResult = 0L;
        NativeFunctionPointer<?> result = Signal.si_addr();
        Assertions.assertNotNull(result);
    }

    /**
     * Test of si_pid method, of class Signal.
     */
    @Test
    public void testSi_pid() {
        System.out.println("si_pid");
        int expResult = 0;
        int result = Signal.si_pid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of si_status method, of class Signal.
     */
    @Test
    public void testSi_status() {
        System.out.println("si_status");
        int expResult = 0;
        int result = Signal.si_status();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of si_uid method, of class Signal.
     */
    @Test
    public void testSi_uid() {
        System.out.println("si_uid");
        int expResult = 0;
        int result = Signal.si_uid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of si_band method, of class Signal.
     */
    @Test
    public void testSi_band() {
        System.out.println("si_band");
        long expResult = 0L;
        long result = Signal.si_band();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kill method, of class Signal.
     */
    @Test
    public void testKill() throws Exception {
        System.out.println("kill");
        int pid = 0;
        int sig = 0;
        Signal.kill(pid, sig);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of killpg method, of class Signal.
     */
    @Test
    public void testKillpg() throws Exception {
        System.out.println("killpg");
        int pgrp = 0;
        int sig = 0;
        Signal.killpg(pgrp, sig);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of psiginfo method, of class Signal.
     */
    @Test
    public void testPsiginfo() throws Exception {
        System.out.println("psiginfo");
        Signal.Siginfo_t pinfo = null;
        String message = "";
        Signal.psiginfo(pinfo, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of psignal method, of class Signal.
     */
    @Test
    public void testPsignal() throws Exception {
        System.out.println("psignal");
        int signum = 0;
        String message = "";
        Signal.psignal(signum, message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pthread_kill method, of class Signal.
     */
    @Test
    public void testPthread_kill() throws Exception {
        System.out.println("pthread_kill");
        long thread = 0L;
        int sig = 0;
        Signal.pthread_kill(thread, sig);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pthread_sigmask method, of class Signal.
     */
    @Test
    public void testPthread_sigmask() throws Exception {
        System.out.println("pthread_sigmask");
        int how = 0;
        Signal.Sigset_t set = null;
        Signal.Sigset_t oset = null;
        Signal.pthread_sigmask(how, set, oset);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of raise method, of class Signal.
     */
    @Test
    public void testRaise() throws Exception {
        System.out.println("raise");
        Signal.raise(Signal.SIGCHLD());

        final IntRef sigRef = new IntRef();
        Signal.Sigaction sa = new Signal.Sigaction();
        sa.sa_flags(Signal.SA_RESTART());
        Signal.sigemptyset(sa.sa_mask);

        Callback_I_V sa_handler = new Callback_I_V() {
            @Override
            protected void callback(int sig) {
                sigRef.value = sig;
            }
        };

        sa.sa_handler(sa_handler);
        Signal.sigaction(Signal.SIGQUIT(), sa, null);
        Signal.raise(Signal.SIGQUIT());
    }

    /**
     * Test of sigaction method, of class Signal.
     */
    @Test
    public void testSigaction() throws Exception {
        System.out.println("sigaction");
        int sig = 0;
        Signal.Sigaction act = null;
        Signal.Sigaction oact = null;
        Signal.sigaction(sig, act, oact);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sigaltstack method, of class Signal.
     */
    @Test
    public void testSigaltstack() throws Exception {
        System.out.println("sigaltstack");
        Signal.Stack_t ss = null;
        Signal.Stack_t oss = null;
        Signal.sigaltstack(ss, oss);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        Assertions.assertFalse(Signal.sigismember(set, Signal.SIGKILL()));
        Assertions.assertFalse(Signal.sigismember(set, Signal.SIGUSR1()));
        Signal.sigaddset(set, Signal.SIGUSR1());
        Assertions.assertTrue(Signal.sigismember(set, Signal.SIGUSR1()));
        Signal.sigdelset(set, Signal.SIGUSR1());
        Assertions.assertFalse(Signal.sigismember(set, Signal.SIGUSR1()));

        Signal.sigemptyset(set);
        Signal.sigfillset(set);
        Assertions.assertTrue(Signal.sigismember(set, Signal.SIGKILL()));
        Assertions.assertTrue(Signal.sigismember(set, Signal.SIGABRT()));

    }

    /**
     * Test of sighold method, of class Signal.
     */
    @Test
    public void testSighold() throws Exception {
        System.out.println("sighold");
        int sig = 0;
        Signal.sighold(sig);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sigignore method, of class Signal.
     */
    @Test
    public void testSigignore() throws Exception {
        System.out.println("sigignore");
        int sig = 0;
        Signal.sigignore(sig);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of siginterrupt method, of class Signal.
     */
    @Test
    public void testSiginterrupt() throws Exception {
        System.out.println("siginterrupt");
        int sig = 0;
        int flag = 0;
        Signal.siginterrupt(sig, flag);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of signal method, of class Signal.
     */
    @Test
    public void testSignal() throws Exception {
        System.out.println("signal");

        final var funcIgnore = Signal.SIG_IGN();
        final var savedOld = Signal.signal(Signal.SIGABRT(), funcIgnore);
        if (Signal.SIG_DFL().addressEquals(savedOld)) {
            System.out.println("Old signal handler of SIGABRT is SIG_DFL!");
        } else if (Signal.SIG_ERR().addressEquals(savedOld)) {
            System.out.println("Old signal handler of SIGABRT is SIG_ERR!");
        } else if (Signal.SIG_HOLD().addressEquals(savedOld)) {
            System.out.println("Old signal handler of SIGABRT is SIG_HOLD!");
        } else if (Signal.SIG_IGN().addressEquals(savedOld)) {
            System.out.println("Old signal handler of SIGABRT is SIG_IGN!");
        } else {
            System.out.println("Old signal handler of SIGABRT is " + savedOld);
        }

        Signal.raise(Signal.SIGABRT());

        final IntRef raisedSignal = new IntRef();
        final Callback_I_V funcHandler = new Callback_I_V() {
            @Override
            protected void callback(int sig) {
                raisedSignal.value = sig;
                System.out.println("Got signal: " + sig);
            }
        };
        cleaner.register(funcHandler, () -> {
            try {
                Signal.signal(Signal.SIGABRT(), savedOld);
                System.err.println("Old signal Handler restored to: " + savedOld);
            } catch (NativeErrorException nee) {
                System.err.println("Cant set old signal Handler " + savedOld);
            }
        });

        var old = Signal.signal(Signal.SIGABRT(), funcHandler);
        Assertions.assertTrue(funcIgnore.addressEquals(old));

        Signal.raise(Signal.SIGABRT());
        Assertions.assertEquals(Signal.SIGABRT(), raisedSignal.value);

        old = Signal.signal(Signal.SIGABRT(), null);
        Assertions.assertTrue(funcHandler.addressEquals(old));

        //Restore the signal on error the cleaner shoult take care of restoring.
        old = Signal.signal(Signal.SIGABRT(), savedOld);
        Assertions.assertTrue(NativeFunctionPointer.addressEquals(old, new NativeFunctionPointer(0L)));
    }

    /**
     * Test of signal method, of class Signal.
     */
    @Test
    public void testTryToIgnoreSignal_SIGTERM() throws Exception {
        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
            var unexpected = Signal.signal(Signal.SIGTERM(), Signal.SIG_IGN());
        });
        assertEquals(0, nee.errno);
    }

    /**
     * Test of sigpause method, of class Signal.
     */
    @Test
    @DisabledOnOs(OS.LINUX) // sigpause does not work as expected ... it does not return
    public void testSigpause() throws Exception {
        System.out.println("sigpause");
        final ObjectRef<Boolean> boolRef = new ObjectRef(Boolean.FALSE);

        final Callback_I_V funcHandler = new Callback_I_V() {
            @Override
            protected void callback(int sig) {
                System.out.println("Got signal: " + sig);
            }
        };

        final var oldHandler = Signal.signal(Signal.SIGUSR2(), funcHandler);
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Signal.sigpause(Signal.SIGUSR2());
                        fail();
                    } catch (NativeErrorException nee) {
                        assertEquals("EINTR", Errno.getErrnoSymbol(nee.errno));
                        synchronized (boolRef) {
                            boolRef.value = Boolean.TRUE;
                            boolRef.notify();
                        }
                    }
                }
            }.start();
            Thread.sleep(100);
            Signal.raise(Signal.SIGUSR2());
            synchronized (boolRef) {
                if (!boolRef.value) {
                    boolRef.wait(500);
                }
            }
            Assertions.assertTrue(boolRef.value);
        });
        Signal.signal(Signal.SIGUSR1(), oldHandler);
    }

    /**
     * Test of sigpending method, of class Signal.
     */
    @Test
    public void testSigpending() throws Exception {
        System.out.println("sigpending");
        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
            Signal.sigpending(null);
        });
        assertEquals(Errno.EFAULT(), nee.errno);

        Signal.Sigset_t set = new Signal.Sigset_t();
        Signal.sigemptyset(set);
        Signal.sigpending(set);
        assertEquals("[]", set.toString());
        Assertions.assertArrayEquals(new byte[Signal.Sigset_t.sizeofSigset_t()], OpaqueMemory.toBytes(set));
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
        //make sure SIGUSR1 is in signak mask; we want to set it
        System.err.println("current sigprocmask: " + oset);
        Assertions.assertFalse(Signal.sigismember(oset, Signal.SIGUSR1()));
        Signal.Sigset_t set = new Signal.Sigset_t();
        Signal.sigemptyset(set);
        Signal.sigaddset(set, Signal.SIGUSR1());
        Signal.sigprocmask(Signal.SIG_BLOCK(), set, null);
        //Test that SIGUSR1 was set
        final Signal.Sigset_t changedSet = new Signal.Sigset_t();
        Signal.sigemptyset(changedSet);
        Signal.sigprocmask(0, null, changedSet);
        System.err.println("current sigprocmask: " + changedSet.toString());
        Assertions.assertTrue(Signal.sigismember(changedSet, Signal.SIGUSR1()));

        //restore old mask
        Signal.sigprocmask(Signal.SIG_SETMASK(), oset, null);

    }

    /**
     * Test of sigqueue method, of class Signal.
     */
    @Test
    public void testSigqueue() throws Exception {
        System.out.println("sigqueue");
        Signal.sigqueue();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sigrelse method, of class Signal.
     */
    @Test
    public void testSigrelse() throws Exception {
        System.out.println("sigrelse");
        Signal.sigrelse();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sigset method, of class Signal.
     */
    @Test
    public void testSigset() throws Exception {
        System.out.println("sigset");
        var result = Signal.sigset(Signal.SIGABRT(), null);
        Assertions.assertTrue(NativeFunctionPointer.addressEquals(Signal.SIG_DFL(), result));
        result = Signal.sigset(Signal.SIGABRT(), result);
        Assertions.assertTrue(NativeFunctionPointer.addressEquals(new NativeFunctionPointer(0L), result));
    }

    /**
     * Test of sigsuspend method, of class Signal.
     */
    @Test
    public void testSigsuspend() throws Exception {
        System.out.println("sigsuspend");
        System.out.println("sigpause");
        final ObjectRef<Boolean> boolRef = new ObjectRef(Boolean.FALSE);

        final Callback_I_V funcHandler = new Callback_I_V() {
            @Override
            protected void callback(int sig) {
                System.out.println("Got signal: " + sig);
            }
        };

        final var oldHandler = Signal.signal(Signal.SIGUSR1(), funcHandler);
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            new Thread() {
                @Override
                public void run() {
                    try {
                        Signal.Sigset_t sigmask = new Signal.Sigset_t();
                        Signal.sigemptyset(sigmask);
                        Signal.sigaddset(sigmask, Signal.SIGUSR2());
                        Signal.sigsuspend(sigmask);
                        fail();
                    } catch (NativeErrorException nee) {
                        synchronized (boolRef) {
                            boolRef.value = Boolean.TRUE;
                            boolRef.notify();
                        }
                    }
                }
            }.start();
            Thread.sleep(100);
            Signal.raise(Signal.SIGUSR2());
            synchronized (boolRef) {
                if (!boolRef.value) {
                    boolRef.wait(500);
                }
            }
            Assertions.assertTrue(boolRef.value);
        });
        Signal.signal(Signal.SIGUSR2(), oldHandler);
    }

    /**
     * Test of sigtimedwait method, of class Signal.
     */
    @Test
    public void testSigtimedwait() throws Exception {
        System.out.println("sigtimedwait");
        Signal.Sigset_t set = null;
        Signal.Siginfo_t info = null;
        Time.Timespec timeout = null;
        int expResult = 0;
        int result = Signal.sigtimedwait(set, info, timeout);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sigwait method, of class Signal.
     */
    @Test
    public void testSigwait() throws Exception {
        System.out.println("sigwait");
        Signal.sigwait();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sigwaitinfo method, of class Signal.
     */
    @Test
    public void testSigwaitinfo() throws Exception {
        System.out.println("sigwaitinfo");
        Signal.Sigset_t set = null;
        Signal.Siginfo_t info = null;
        int expResult = 0;
        int result = Signal.sigwaitinfo(set, info);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sigaction method, of class Signal.
     */
    @Test
    public void testStructSigaction() throws Exception {
        fail(" Signal_Sigaction.c \n"
                + " Signal_Sigevent.c \n"
                + " Signal_Siginfo.c \n"
                + " Signal_Sigval.c \n"
                + " Signal_Stack.c \n"
                + " Signal_Ucontext.c \n"
                + " Signal_Mcontext.c \n"
                + ".");
    }

}
