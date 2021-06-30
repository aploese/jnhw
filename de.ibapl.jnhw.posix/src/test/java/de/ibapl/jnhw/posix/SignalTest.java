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
import de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_I_V;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.Callback__Sigval_int__V;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.lang.ref.Cleaner;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class SignalTest {

    public static class NativeDefines {

        public final static native boolean HAVE_SIGNAL_H();

        public final static native int ILL_ILLOPC();

        public final static native int ILL_ILLOPN();

        public final static native int ILL_ILLADR();

        public final static native int ILL_ILLTRP();

        public final static native int ILL_PRVOPC();

        public final static native int ILL_PRVREG();

        public final static native int ILL_COPROC();

        public final static native int ILL_BADSTK();

        public final static native int FPE_INTDIV();

        public final static native int FPE_INTOVF();

        public final static native int FPE_FLTDIV();

        public final static native int FPE_FLTOVF();

        public final static native int FPE_FLTUND();

        public final static native int FPE_FLTRES();

        public final static native int FPE_FLTINV();

        public final static native int FPE_FLTSUB();

        public final static native int SEGV_MAPERR();

        public final static native int SEGV_ACCERR();

        public final static native int BUS_ADRALN();

        public final static native int BUS_ADRERR();

        public final static native int BUS_OBJERR();

        public final static native int TRAP_BRKPT();

        public final static native int TRAP_TRACE();

        public final static native int CLD_EXITED();

        public final static native int CLD_KILLED();

        public final static native int CLD_DUMPED();

        public final static native int CLD_TRAPPED();

        public final static native int CLD_STOPPED();

        public final static native int CLD_CONTINUED();

        public final static native Integer POLL_IN();

        public final static native Integer POLL_OUT();

        public final static native Integer POLL_MSG();

        public final static native Integer POLL_ERR();

        public final static native Integer POLL_PRI();

        public final static native Integer POLL_HUP();

        public final static native int SI_USER();

        public final static native int SI_QUEUE();

        public final static native int SI_TIMER();

        public final static native Integer SI_ASYNCIO();

        public final static native Integer SI_MESGQ();

        public final static native int SIG_BLOCK();

        public final static native int SIG_UNBLOCK();

        public final static native int SIG_SETMASK();

        public final static native int SA_NOCLDSTOP();

        public final static native int SA_ONSTACK();

        public final static native int SA_RESETHAND();

        public final static native int SA_RESTART();

        public final static native int SA_SIGINFO();

        public final static native int SA_NOCLDWAIT();

        public final static native int SA_NODEFER();

        public final static native int SS_ONSTACK();

        public final static native int SS_DISABLE();

        public final static native int MINSIGSTKSZ();

        public final static native int SIGSTKSZ();

        public final static native long SIG_DFL0();

        public final static FunctionPtr_I_V SIG_DFL() {
            return new FunctionPtr_I_V(NativeAddressHolder.ofUintptr_t(SIG_DFL0()));
        }

        public final static native long SIG_ERR0();

        public final static FunctionPtr_I_V SIG_ERR() {
            return new FunctionPtr_I_V(NativeAddressHolder.ofUintptr_t(SIG_ERR0()));
        }

        public final static native Long SIG_HOLD0();

        public final static FunctionPtr_I_V SIG_HOLD() {
            final Long addr = SIG_HOLD0();
            if (addr == null) {
                return null;
            } else {
                return new FunctionPtr_I_V(NativeAddressHolder.ofUintptr_t(addr));
            }
        }

        public final static native long SIG_IGN0();

        public final static FunctionPtr_I_V SIG_IGN() {
            return new FunctionPtr_I_V(NativeAddressHolder.ofUintptr_t(SIG_IGN0()));
        }

        public final static native Integer SIGEV_NONE();

        public final static native Integer SIGEV_SIGNAL();

        public final static native Integer SIGEV_THREAD();

        public final static native int SIGABRT();

        public final static native int SIGALRM();

        public final static native int SIGBUS();

        public final static native int SIGCHLD();

        public final static native int SIGCONT();

        public final static native int SIGFPE();

        public final static native int SIGHUP();

        public final static native int SIGILL();

        public final static native int SIGINT();

        public final static native int SIGKILL();

        public final static native int SIGPIPE();

        public final static native int SIGQUIT();

        public final static native int SIGSEGV();

        public final static native int SIGSTOP();

        public final static native int SIGTERM();

        public final static native int SIGTSTP();

        public final static native int SIGTTIN();

        public final static native int SIGTTOU();

        public final static native int SIGUSR1();

        public final static native int SIGUSR2();

        public final static native Integer SIGPOLL();

        public final static native int SIGPROF();

        public final static native int SIGSYS();

        public final static native int SIGTRAP();

        public final static native int SIGURG();

        public final static native int SIGVTALRM();

        public final static native int SIGXCPU();

        public final static native int SIGXFSZ();

    }

    public static class NativeMcontext_t {

        public final static native int alignof();

        public final static native int sizeof();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeSigset_t {

        public final static native int alignof();

        public final static native int sizeof();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeSigval {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long sival_int();

        public final static native long sival_ptr();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeSigevent {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long sigev_notify();

        public final static native long sigev_signo();

        public final static native long sigev_value();

        public final static native long sigev_notify_function();

        public final static native long sigev_notify_attributes();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeSigaction {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long sa_handler();

        public final static native long sa_mask();

        public final static native long sa_flags();

        public final static native long sa_sigaction();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeStack_t {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long ss_sp();

        public final static native long ss_size();

        public final static native long ss_flags();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeSiginfo_t {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long si_signo();

        public final static native long si_code();

        public final static native long si_errno();

        public final static native long si_pid();

        public final static native long si_uid();

        public final static native long si_addr();

        public final static native long si_status();

        public final static native long si_band();

        public final static native long si_value();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeUcontext_t {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long uc_link();

        public final static native long uc_sigmask();

        public final static native long uc_stack();

        public final static native long uc_mcontext();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    @BeforeAll
    public static void checkBeforeAll_HAVE_SIGNAL_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Signal.HAVE_SIGNAL_H, "not expected to have signal.h");
        } else {
            Assertions.assertTrue(Signal.HAVE_SIGNAL_H, "expected to have signal.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_SignalDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Signal.class, NativeDefines.class, "HAVE_SIGNAL_H");
    }

    @BeforeAll
    public static void checkBeforeAll_StructMcontext_t() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(NativeMcontext_t.sizeof(), Signal.Mcontext_t.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(NativeMcontext_t.alignof(), Signal.Mcontext_t.alignof == null ? 0 : Signal.Mcontext_t.alignof.alignof, "alignof");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructSigset_t() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(NativeSigset_t.sizeof(), Signal.Sigset_t.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(NativeSigset_t.alignof(), Signal.Sigset_t.alignof.alignof, "alignof");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructSigval() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(NativeSigval.sizeof(), Signal.Sigval.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(NativeSigval.alignof(), Signal.Sigval.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativeSigval.sival_int(), Signal.Sigval.offsetof_Sival_int, "offsetof_Sival_int");
                },
                () -> {
                    Assertions.assertEquals(NativeSigval.sival_ptr(), Signal.Sigval.offsetof_Sival_ptr, "offsetof_Sival_ptr");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructSigevent() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(NativeSigevent.sizeof(), Signal.Sigevent.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(NativeSigevent.alignof(), Signal.Sigevent.alignof == null ? 0 : Signal.Sigevent.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativeSigevent.sigev_notify(), Signal.Sigevent.offsetof_Sigev_notify, "offsetof_Sigev_notify");
                },
                () -> {
                    Assertions.assertEquals(NativeSigevent.sigev_notify_attributes(), Signal.Sigevent.offsetof_Sigev_notify_attributes, "offsetof_Sigev_notify_attributes");
                },
                () -> {
                    Assertions.assertEquals(NativeSigevent.sigev_notify_function(), Signal.Sigevent.offsetof_Sigev_notify_function, "offsetof_Sigev_notify_function");
                },
                () -> {
                    Assertions.assertEquals(NativeSigevent.sigev_signo(), Signal.Sigevent.offsetof_Sigev_signo, "offsetof_Sigev_signo");
                },
                () -> {
                    Assertions.assertEquals(NativeSigevent.sigev_value(), Signal.Sigevent.offsetof_Sigev_value, "offsetof_Sigev_value");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructSigaction() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(NativeSigaction.sizeof(), Signal.Sigaction.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(NativeSigaction.alignof(), Signal.Sigaction.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativeSigaction.sa_handler(), Signal.Sigaction.offsetof_Sa_handler, "offsetof_Sa_handler");
                },
                () -> {
                    Assertions.assertEquals(NativeSigaction.sa_mask(), Signal.Sigaction.offsetof_Sa_mask, "offsetof_Sa_mask");
                },
                () -> {
                    Assertions.assertEquals(NativeSigaction.sa_flags(), Signal.Sigaction.offsetof_Sa_flags, "offsetof_Sa_flags");
                },
                () -> {
                    Assertions.assertEquals(NativeSigaction.sa_sigaction(), Signal.Sigaction.offsetof_Sa_sigaction, "offsetof_Sa_sigaction");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructStack_t() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(NativeStack_t.sizeof(), Signal.Stack_t.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(NativeStack_t.alignof(), Signal.Stack_t.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativeStack_t.ss_sp(), Signal.Stack_t.offsetof_Ss_sp, "offsetof_Ss_sp");
                },
                () -> {
                    Assertions.assertEquals(NativeStack_t.ss_size(), Signal.Stack_t.offsetof_Ss_size, "offsetof_Ss_size");
                },
                () -> {
                    Assertions.assertEquals(NativeStack_t.ss_flags(), Signal.Stack_t.offsetof_Ss_flags, "offsetof_Ss_flags");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructSiginfo() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(NativeSiginfo_t.sizeof(), Signal.Siginfo_t.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(NativeSiginfo_t.alignof(), Signal.Siginfo_t.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativeSiginfo_t.si_signo(), Signal.Siginfo_t.offsetof_Si_signo, "offsetof_Si_signo");
                },
                () -> {
                    Assertions.assertEquals(NativeSiginfo_t.si_code(), Signal.Siginfo_t.offsetof_Si_code, "offsetof_Si_code");
                },
                () -> {
                    Assertions.assertEquals(NativeSiginfo_t.si_errno(), Signal.Siginfo_t.offsetof_Si_errno, "offsetof_Si_errno");
                },
                () -> {
                    Assertions.assertEquals(NativeSiginfo_t.si_pid(), Signal.Siginfo_t.offsetof_Si_pid, "offsetof_Si_pid");
                },
                () -> {
                    Assertions.assertEquals(NativeSiginfo_t.si_uid(), Signal.Siginfo_t.offsetof_Si_uid, "offsetof_Si_uid");
                },
                () -> {
                    Assertions.assertEquals(NativeSiginfo_t.si_addr(), Signal.Siginfo_t.offsetof_Si_addr, "offsetof_Si_addr");
                },
                () -> {
                    Assertions.assertEquals(NativeSiginfo_t.si_status(), Signal.Siginfo_t.offsetof_Si_status, "offsetof_Si_status");
                },
                () -> {
                    Assertions.assertEquals(NativeSiginfo_t.si_band(), Signal.Siginfo_t.offsetof_Si_band, "offsetof_Si_band");
                },
                () -> {
                    Assertions.assertEquals(NativeSiginfo_t.si_value(), Signal.Siginfo_t.offsetof_Si_value, "offsetof_Si_value");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructUcontext_t() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(NativeUcontext_t.sizeof(), Signal.Ucontext_t.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(NativeUcontext_t.alignof(), Signal.Ucontext_t.alignof == null ? 0 : Signal.Ucontext_t.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativeUcontext_t.uc_link(), Signal.Ucontext_t.offsetof_Uc_link, "offsetof_Uc_link");
                },
                () -> {
                    Assertions.assertEquals(NativeUcontext_t.uc_sigmask(), Signal.Ucontext_t.offsetof_Uc_sigmask, "offsetof_Uc_sigmask");
                },
                () -> {
                    Assertions.assertEquals(NativeUcontext_t.uc_stack(), Signal.Ucontext_t.offsetof_Uc_stack, "offsetof_Uc_stack");
                },
                () -> {
                    Assertions.assertEquals(NativeUcontext_t.uc_mcontext(), Signal.Ucontext_t.offsetof_Uc_mcontext, "offsetof_Uc_mcontext");
                }
        );
    }

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

        final Integer[] sigRef = new Integer[1];
        final Signal.Sigaction act = new Signal.Sigaction();
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback_I_V_Impl sa_handler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
                synchronized (sigRef) {
                    System.out.println("pthread_t of signalhadler: " + Pthread.pthread_self() + " Java thread ID: " + Thread.currentThread().getId());
                    sigRef[0] = sig;
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
        final Signal.Sigaction act = new Signal.Sigaction();
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback_I_V_Impl sa_handler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
                synchronized (sigRef) {
                    sigRef[0] = sig;
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

        final Integer[] sigRef = new Integer[1];
        final Throwable[] error = new Throwable[1];
        final Signal.Sigaction act = new Signal.Sigaction();
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback_I_V_Impl sa_handler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
                sigRef[0] = sig;
                System.out.println("pthread_t of signalhadler: " + Pthread.pthread_self() + " Java thread ID: " + Thread.currentThread().getId() + " signal: " + sig);
            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction oact = new Signal.Sigaction();
        Signal.sigaction(sig, act, oact);
        try {
            Thread t = new Thread(() -> {
                try {
                    System.out.println("pthread_t of thread: " + Pthread.pthread_self() + " Java thread ID: " + Thread.currentThread().getId());
                    Signal.pthread_kill(Pthread.pthread_self(), sig);
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

        final Integer[] sigRef = new Integer[1];
        final Signal.Sigaction act = new Signal.Sigaction();
        act.sa_flags(0);
        Signal.sigemptyset(act.sa_mask);

        Callback_I_V_Impl sa_handler = new Callback_I_V_Impl() {
            @Override
            protected void callback(int sig) {
                sigRef[0] = sig;
            }
        };
        act.sa_handler(sa_handler);

        final Signal.Sigaction oact = new Signal.Sigaction<>();
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
        final Memory32Heap ss_sp = new Memory32Heap((OpaqueMemory32) null, 0, Signal.MINSIGSTKSZ, SetMem.TO_0x00);
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

        final Integer[] raisedSignal = new Integer[1];
        final Callback_I_V_Impl funcHandler = new Callback_I_V_Impl() {
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

        Signal.Sigset_t set = new Signal.Sigset_t();
        Signal.sigemptyset(set);
        Signal.sigpending(set);
        assertEquals("[]", set.nativeToString());
        Assertions.assertArrayEquals(new byte[Signal.Sigset_t.sizeof], OpaqueMemory32.toBytes(set));
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
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> Signal.sigqueue(Unistd.getpid(), SIG, new Signal.Sigval()));
        } else {

            final Signal.Sigaction act = OpaqueMemory32.setMemTo(new Signal.Sigaction(), (byte) 0);
            act.sa_flags(Signal.SA_SIGINFO);
            Signal.sigemptyset(act.sa_mask);

            final Signal.Siginfo_t[] siginfo_tRef = new Signal.Siginfo_t[]{null};
            final Signal.Ucontext_t[] opmRef = new Signal.Ucontext_t[]{null};
            final Integer[] valueRef = new Integer[]{null};

            Callback_I_Mem_Mem_V_Impl<Signal.Siginfo_t, Signal.Ucontext_t> sa_handler = new Callback_I_Mem_Mem_V_Impl<>() {

                @Override
                protected void callback(int value, Signal.Siginfo_t a, Signal.Ucontext_t b) {
                    siginfo_tRef[0] = a;
                    opmRef[0] = b;
                    valueRef[0] = value;
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
            Signal.sigaction(SIG, act, oact);

            final OpaqueMemory32 data = new Memory32Heap(null, 0, 128, SetMem.TO_0x00);

            Signal.Sigval sigval = new Signal.Sigval();
            sigval.sival_ptr(data);

            Signal.sigqueue(Unistd.getpid(), SIG, sigval);

            Thread.sleep(100);

            System.out.println("de.ibapl.jnhw.posix.SignalTest.testSigqueue() siginfo_tRef.value: " + siginfo_tRef[0]);
            try {
                Assertions.assertNotNull(valueRef[0]);
                Assertions.assertAll(
                        () -> {
                            Assertions.assertEquals(SIG, valueRef[0], "value");
                        },
                        () -> {
                            Assertions.assertEquals(0, siginfo_tRef[0].si_errno(), "siginfo_tRef.value.si_errno()");
                        },
                        () -> {
                            Assertions.assertEquals(SIG, siginfo_tRef[0].si_signo(), "siginfo_tRef.value.si_signo()");
                        },
                        () -> {
                            Assertions.assertEquals(data, siginfo_tRef[0].si_value.sival_ptr((baseAddress, size) -> {
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
            final Signal.Sigset_t set = new Signal.Sigset_t();
            Signal.sigemptyset(set);
            Signal.sigaddset(set, Signal.SIGALRM);
            final Signal.Siginfo_t info = new Signal.Siginfo_t();
            final Time.Timespec timeout = new Time.Timespec(SetMem.DO_NOT_SET);

            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Signal.sigtimedwait(set, info, timeout);
            });
            return;
        }

        final int SIG = Signal.SIGALRM;

        final Signal.Sigset_t set = new Signal.Sigset_t();
        Signal.sigemptyset(set);
        Signal.sigaddset(set, SIG);

        final Signal.Sigset_t oset = new Signal.Sigset_t();

        final Signal.Siginfo_t info = new Signal.Siginfo_t();

        final Time.Timespec timeout = new Time.Timespec(SetMem.DO_NOT_SET);
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
            final int signal = Signal.sigwait(set, SIG);
            assertEquals(SIG, signal);

            Assertions.assertThrows(NullPointerException.class, () -> {
                Signal.sigwait(null, SIG);
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
            final Signal.Sigset_t set = new Signal.Sigset_t();
            Signal.sigemptyset(set);
            Signal.sigaddset(set, Signal.SIGALRM);
            final Signal.Siginfo_t info = new Signal.Siginfo_t();
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Signal.sigwaitinfo(set, info);
            });
            return;
        }

        final int SIG = Signal.SIGALRM;

        Signal.signal(SIG, Signal.SIG_DFL);
        final Signal.Sigset_t set = new Signal.Sigset_t();
        Signal.sigemptyset(set);
        Signal.sigaddset(set, SIG);
        final Signal.Sigset_t oset = new Signal.Sigset_t();

        Signal.sigprocmask(Signal.SIG_BLOCK, set, oset);
        try {
            final Signal.Sigset_t testSet = new Signal.Sigset_t();
            Signal.sigemptyset(testSet);
            /*
             If the test fails after raising the signal
             and before processing the signal in the test,
             the whole testsuite will crash!
             */
            Signal.raise(SIG);
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

    @Test
    public void testUnionSigval() throws Exception {
        Memory32Heap mem = new Memory32Heap((OpaqueMemory32) null, 0, 2, SetMem.DO_NOT_SET);
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
            Assertions.assertThrows(NoSuchNativeTypeException.class, () -> new Signal.Ucontext_t(SetMem.DO_NOT_SET));
        } else {
            Signal.Ucontext_t ucontext_t = new Signal.Ucontext_t(SetMem.TO_0x00);
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

}
