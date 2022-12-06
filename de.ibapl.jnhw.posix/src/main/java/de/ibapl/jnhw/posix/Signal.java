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

import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.size_t;
import de.ibapl.jnhw.annotation.posix.sys.types.uid_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.JnhwMethodInvoker;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMethodHandle;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh__A__sI__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh__V___A__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh__V__sI__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__A_sI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A__A__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI__A__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI_sI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI_sI__A;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___I;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___I_MA_MA;
import de.ibapl.jnhw.common.upcall.Callback__V__MA;
import de.ibapl.jnhw.common.upcall.Callback__V___I;
import de.ibapl.jnhw.common.upcall.Callback__V___I_MA_MA;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.common.util.ObjectDefine;
import de.ibapl.jnhw.posix.Time.Timespec;
import de.ibapl.jnhw.util.posix.LibrtLoader;
import de.ibapl.jnhw.util.posix.PosixDataType;
import de.ibapl.jnhw.util.posix.memory.PosixStruct;
import java.io.IOException;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;

/**
 * Wrapper around the {@code <signal.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">signal.h
 * - signals</a>.
 *
 * @author aploese
 */
@Include("#include <signal.h>")
public class Signal {

    private static interface JnhwPthreadKill extends JnhwMethodHandle {

        static class JnhwMethodInvoker_Int_Long_Int extends JnhwMethodInvoker implements JnhwPthreadKill {

            public JnhwMethodInvoker_Int_Long_Int(SymbolLookup symbolLookup, String name) {
                super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_INT));
            }

            @Override
            public int invokeExact(Pthread.Pthread_t thread, int sig) {
                try {
                    return (int) methodHandle.invokeExact(thread.asUint64_t(), sig);
                } catch (Throwable t) {
                    throw createRuntimeExceptionInvoke(t);
                }
            }

        }

        public static JnhwPthreadKill of(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
            switch (result) {
                case int32_t:
                    switch (arg1) {
                        case uint64_t:
                            switch (arg2) {
                                case int32_t:
                                    return new JnhwMethodInvoker_Int_Long_Int(symbolLookup, name);
                                default:
                                    throw new IllegalArgumentException("arg2 unexpected data type: " + name + " " + arg2);
                            }
                        default:
                            throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
                    }
                default:
                    throw new IllegalArgumentException("result unexpected data type: " + name + " " + result);
            }
        }

        int invokeExact(Pthread.Pthread_t thread, int sig);

    }

    public static interface BsdDefines {

        public final static int BUS_ADRALN = 1;

        public final static int BUS_ADRERR = 2;
        public final static int BUS_OBJERR = 3;

        public final static int CLD_CONTINUED = 6;
        public final static int CLD_DUMPED = 3;
        public final static int CLD_EXITED = 1;

        public final static int CLD_KILLED = 2;
        public final static int CLD_STOPPED = 5;

        public final static int CLD_TRAPPED = 4;
        public final static int ILL_ILLOPC = 1;
        public final static int SA_NOCLDSTOP = 8;
        public final static int SA_NOCLDWAIT = 32;
        public final static int SA_NODEFER = 16;
        public final static int SA_ONSTACK = 1;

        public final static int SA_RESETHAND = 4;
        public final static int SA_RESTART = 2;
        public final static int SA_SIGINFO = 64;
        public final static int SEGV_ACCERR = 2;
        public final static int SEGV_MAPERR = 1;

        public final static int SIG_BLOCK = 1;
        public final static FunctionPtr__V___I SIG_DFL = new FunctionPtr__V___I(MemoryAddress.ofLong(0));

        public final static FunctionPtr__V___I SIG_ERR = new FunctionPtr__V___I(MemoryAddress.ofLong(-1));
        public final static FunctionPtr__V___I SIG_IGN = new FunctionPtr__V___I(MemoryAddress.ofLong(1));
        public final static int SIG_SETMASK = 3;

        public final static int SIG_UNBLOCK = 2;
        public final static int SIGABRT = 6;
        public final static int SIGALRM = 14;
        public final static int SIGBUS = 10;
        public final static int SIGCHLD = 20;
        public final static int SIGCONT = 19;
        public final static int SIGFPE = 8;
        public final static int SIGHUP = 1;
        public final static int SIGILL = 4;
        public final static int SIGINT = 2;
        public final static int SIGKILL = 9;
        public final static int SIGPIPE = 13;

        public final static int SIGPROF = 27;
        public final static int SIGQUIT = 3;
        public final static int SIGSEGV = 11;
        public final static int SIGSTOP = 17;
        public final static int SIGSYS = 12;

        public final static int SIGTERM = 15;
        public final static int SIGTRAP = 5;
        public final static int SIGTSTP = 18;
        public final static int SIGTTIN = 21;
        public final static int SIGTTOU = 22;
        public final static int SIGURG = 16;
        public final static int SIGUSR1 = 30;
        public final static int SIGUSR2 = 31;
        public final static int SIGVTALRM = 26;
        public final static int SIGXCPU = 24;
        public final static int SIGXFSZ = 25;
        public final static int SS_DISABLE = 4;
        public final static int SS_ONSTACK = 1;
        public final static int TRAP_BRKPT = 1;
        public final static int TRAP_TRACE = 2;
    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int FPE_FLTDIV = 1;
        public final static int FPE_FLTINV = 5;
        public final static int FPE_FLTOVF = 2;
        public final static int FPE_FLTRES = 4;
        public final static int FPE_FLTSUB = 6;
        public final static int FPE_FLTUND = 3;
        public final static int FPE_INTDIV = 7;
        public final static int FPE_INTOVF = 8;

        public final static int ILL_BADSTK = 8;
        public final static int ILL_COPROC = 7;
        public final static int ILL_ILLADR = 5;
        public final static int ILL_ILLOPN = 4;
        public final static int ILL_ILLTRP = 2;
        public final static int ILL_PRVOPC = 3;
        public final static int ILL_PRVREG = 6;
        public final static int MINSIGSTKSZ = 32768;
        public final static int POLL_ERR = 4;
        public final static int POLL_HUP = 6;
        public final static int POLL_IN = 1;
        public final static int POLL_MSG = 3;
        public final static int POLL_OUT = 2;
        public final static int POLL_PRI = 5;
        public final static int SI_ASYNCIO = 65540;
        public final static int SI_MESGQ = 65541;
        public final static int SI_QUEUE = 65538;
        public final static int SI_TIMER = 65539;
        public final static int SI_USER = 65537;
        public final static FunctionPtr__V___I SIG_HOLD = new FunctionPtr__V___I(MemoryAddress.ofLong(5));
        public final static int SIGEV_NONE = 0;
        public final static int SIGEV_SIGNAL = 1;
        public final static int SIGEV_THREAD = 3;
        public final static int SIGSTKSZ = 131072;

    }

    public static interface Defines__AARCH64__LINUX__GNU extends Linux_AllArchs_Defines, Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines, Linux_Aarc64_Defines, Linux_Aarc64_Ppc64_Defines {
    }

    public static interface Defines__MIPS_64__LINUX__GNU_ABI_64 extends Linux_AllArchs_Defines, Linux_Mips_Mips64_Defines {
    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int FPE_FLTDIV = 3;
        public final static int FPE_FLTINV = 7;
        public final static int FPE_FLTOVF = 4;
        public final static int FPE_FLTRES = 6;
        public final static int FPE_FLTSUB = 8;
        public final static int FPE_FLTUND = 5;
        public final static int FPE_INTDIV = 2;
        public final static int FPE_INTOVF = 1;
        public final static int ILL_BADSTK = 8;
        public final static int ILL_COPROC = 7;
        public final static int ILL_ILLADR = 3;
        public final static int ILL_ILLOPN = 2;
        public final static int ILL_ILLTRP = 4;
        public final static int ILL_PRVOPC = 5;
        public final static int ILL_PRVREG = 6;
        public final static int MINSIGSTKSZ = 2048;
        public final static int POLL_ERR = 4;
        public final static int POLL_HUP = 6;
        public final static int POLL_IN = 1;
        public final static int POLL_MSG = 3;
        public final static int POLL_OUT = 2;
        public final static int POLL_PRI = 5;
        public final static int SI_ASYNCIO = 65540;
        public final static int SI_MESGQ = 65541;
        public final static int SI_QUEUE = 65538;
        public final static int SI_TIMER = 65539;

        public final static int SI_USER = 65537;
        public final static FunctionPtr__V___I SIG_HOLD = new FunctionPtr__V___I(MemoryAddress.ofLong(3));
        public final static int SIGEV_NONE = 0;
        public final static int SIGEV_SIGNAL = 1;
        public final static int SIGEV_THREAD = 2;
        public final static int SIGSTKSZ = 34816;
    }

    public static interface Linux_Aarc64_Defines {

        public final static int MINSIGSTKSZ = 5120;
    }

    public static interface Linux_Aarc64_Ppc64_Defines {

        public final static int SIGSTKSZ = 16384;
    }

    public static interface Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines {

        public final static int SA_NOCLDWAIT = 2;
        public final static int SA_SIGINFO = 4;
        public final static int SI_ASYNCIO = -4;
        public final static int SI_MESGQ = -3;
        public final static int SI_TIMER = -2;
        public final static int SIG_BLOCK = 0;
        public final static int SIG_SETMASK = 2;
        public final static int SIG_UNBLOCK = 1;
        public final static int SIGBUS = 7;
        public final static int SIGCHLD = 17;
        public final static int SIGCONT = 18;
        public final static int SIGPOLL = 29;
        public final static int SIGPROF = 27;
        public final static int SIGSTOP = 19;
        public final static int SIGSYS = 31;
        public final static int SIGTSTP = 20;
        public final static int SIGTTIN = 21;
        public final static int SIGTTOU = 22;
        public final static int SIGURG = 23;
        public final static int SIGUSR1 = 10;
        public final static int SIGUSR2 = 12;
        public final static int SIGVTALRM = 26;
        public final static int SIGXCPU = 24;
        public final static int SIGXFSZ = 25;
    }

    public static interface Linux_AllArchs_Defines {

        public final static int BUS_ADRALN = 1;
        public final static int BUS_ADRERR = 2;
        public final static int BUS_OBJERR = 3;
        public final static int CLD_CONTINUED = 6;
        public final static int CLD_DUMPED = 3;
        public final static int CLD_EXITED = 1;
        public final static int CLD_KILLED = 2;
        public final static int CLD_STOPPED = 5;
        public final static int CLD_TRAPPED = 4;
        public final static int FPE_FLTDIV = 3;
        public final static int FPE_FLTINV = 7;
        public final static int FPE_FLTOVF = 4;
        public final static int FPE_FLTRES = 6;
        public final static int FPE_FLTSUB = 8;
        public final static int FPE_FLTUND = 5;
        public final static int FPE_INTDIV = 1;
        public final static int FPE_INTOVF = 2;
        public final static int ILL_BADSTK = 8;
        public final static int ILL_COPROC = 7;
        public final static int ILL_ILLADR = 3;
        public final static int ILL_ILLOPC = 1;
        public final static int ILL_ILLOPN = 2;
        public final static int ILL_ILLTRP = 4;
        public final static int ILL_PRVOPC = 5;
        public final static int ILL_PRVREG = 6;
        public final static int POLL_ERR = 4;
        public final static int POLL_HUP = 6;
        public final static int POLL_IN = 1;
        public final static int POLL_MSG = 3;
        public final static int POLL_OUT = 2;
        public final static int POLL_PRI = 5;
        public final static int SA_NOCLDSTOP = 1;
        public final static int SA_NODEFER = 0x40000000;
        public final static int SA_ONSTACK = 0x08000000;
        public final static int SA_RESETHAND = 0x80000000;
        public final static int SA_RESTART = 0x10000000;
        public final static int SEGV_ACCERR = 2;
        public final static int SEGV_MAPERR = 1;
        public final static int SI_QUEUE = -1;
        public final static int SI_USER = 0;
        public final static FunctionPtr__V___I SIG_DFL = new FunctionPtr__V___I(MemoryAddress.ofLong(0));
        public final static FunctionPtr__V___I SIG_ERR = new FunctionPtr__V___I(MemoryAddress.ofLong(-1));
        public final static FunctionPtr__V___I SIG_HOLD = new FunctionPtr__V___I(MemoryAddress.ofLong(2));
        public final static FunctionPtr__V___I SIG_IGN = new FunctionPtr__V___I(MemoryAddress.ofLong(1));
        public final static int SIGABRT = 6;
        public final static int SIGALRM = 14;
        public final static int SIGEV_NONE = 1;
        public final static int SIGEV_SIGNAL = 0;
        public final static int SIGEV_THREAD = 2;
        public final static int SIGFPE = 8;
        public final static int SIGHUP = 1;
        public final static int SIGILL = 4;
        public final static int SIGINT = 2;
        public final static int SIGKILL = 9;
        public final static int SIGPIPE = 13;
        public final static int SIGQUIT = 3;
        public final static int SIGSEGV = 11;
        public final static int SIGTERM = 15;
        public final static int SIGTRAP = 5;
        public final static int SS_DISABLE = 2;
        public final static int SS_ONSTACK = 1;
        public final static int TRAP_BRKPT = 1;
        public final static int TRAP_TRACE = 2;
    }

    public static interface Linux_Arm_I386_RiscV64_S390_X86_64_Defines {

        public final static int MINSIGSTKSZ = 2048;
        public final static int SIGSTKSZ = 8192;
    }

    public static interface Linux_Mips_Mips64_Defines {

        public final static int MINSIGSTKSZ = 2048;
        public final static int SA_NOCLDWAIT = 65536;
        public final static int SA_SIGINFO = 8;
        public final static int SI_ASYNCIO = -2;
        public final static int SI_MESGQ = -4;
        public final static int SI_TIMER = -3;
        public final static int SIG_BLOCK = 1;
        public final static int SIG_SETMASK = 3;
        public final static int SIG_UNBLOCK = 2;
        public final static int SIGBUS = 10;
        public final static int SIGCHLD = 18;
        public final static int SIGCONT = 25;
        public final static int SIGPOLL = 22;
        public final static int SIGPROF = 29;
        public final static int SIGSTKSZ = 8192;
        public final static int SIGSTOP = 23;
        public final static int SIGSYS = 12;
        public final static int SIGTSTP = 24;
        public final static int SIGTTIN = 26;
        public final static int SIGTTOU = 27;
        public final static int SIGURG = 21;
        public final static int SIGUSR1 = 16;
        public final static int SIGUSR2 = 17;
        public final static int SIGVTALRM = 28;
        public final static int SIGXCPU = 30;
        public final static int SIGXFSZ = 31;
    }

    public static interface Linux_Ppc64_Defines {

        public final static int MINSIGSTKSZ = 4096;
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code typedef
     * mcontext_t}</a>.
     *
     * @author aploese
     */
    public static final class Mcontext_t extends Struct {

        public final static Alignment alignof;
        public final static int sizeof;

        /**
         * Make sure the native lib is loaded
         */
        static {
            switch (MultiarchTupelBuilder.getOS()) {
                case LINUX:
                    switch (MultiarchTupelBuilder.getArch()) {
                        case AARCH64:
                            alignof = Alignment.AT_16;
                            sizeof = 4384;
                            break;
                        case ARM:
                            alignof = Alignment.AT_4;
                            sizeof = 84;
                            break;
                        case I386:
                            alignof = Alignment.AT_4;
                            sizeof = 88;
                            break;
                        case MIPS_64:
                            alignof = Alignment.AT_8;
                            sizeof = 600;
                            break;
                        case MIPS:
                            alignof = Alignment.AT_8;
                            sizeof = 592;
                            break;
                        case POWER_PC_64:
                            alignof = Alignment.AT_8;
                            sizeof = 1272;
                            break;
                        case RISC_V_64:
                            alignof = Alignment.AT_16;
                            sizeof = 784;
                            break;
                        case S390_X:
                            alignof = Alignment.AT_8;
                            sizeof = 344;
                            break;
                        case X86_64:
                            alignof = Alignment.AT_8;
                            sizeof = 256;
                            break;
                        default:
                            throw new NoClassDefFoundError("No signal.h linux defines for " + MultiarchTupelBuilder.getMultiarch());
                    }
                    break;
                case DARWIN:
                    alignof = Alignment.AT_8;
                    sizeof = 8;
                    break;
                case FREE_BSD:
                    alignof = Alignment.AT_16;
                    sizeof = 800;
                    break;
                case OPEN_BSD:
                    alignof = null;
                    sizeof = 0;
                    break;
                default:
                    throw new NoClassDefFoundError("No signal.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
            }

        }

        public final static Mcontext_t tryAllocateNative(MemorySession ms) throws NoSuchNativeTypeException {
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Mcontext_t");
            }
            return new Mcontext_t(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public static Mcontext_t tryOfAddress(MemoryAddress baseAddress, MemorySession ms) throws NoSuchNativeTypeException {
            return new Mcontext_t(MemorySegment.ofAddress(baseAddress, Mcontext_t.sizeof, ms), 0);
        }

        public Mcontext_t(MemorySegment memorySegment, long offset) throws NoSuchNativeTypeException {
            super(memorySegment, offset, Mcontext_t.sizeof);
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Mcontext_t");
            }
        }

    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int FPE_FLTDIV = 3;
        public final static int FPE_FLTINV = 7;
        public final static int FPE_FLTOVF = 4;
        public final static int FPE_FLTRES = 6;
        public final static int FPE_FLTSUB = 8;
        public final static int FPE_FLTUND = 5;
        public final static int FPE_INTDIV = 1;
        public final static int FPE_INTOVF = 2;
        public final static int ILL_BADSTK = 8;
        public final static int ILL_COPROC = 7;
        public final static int ILL_ILLADR = 3;
        public final static int ILL_ILLOPN = 2;
        public final static int ILL_ILLTRP = 4;
        public final static int ILL_PRVOPC = 5;

        public final static int ILL_PRVREG = 6;
        public final static int MINSIGSTKSZ = 12288;
        public final static int SI_QUEUE = -2;
        public final static int SI_TIMER = -3;
        public final static int SI_USER = 0;
        public final static int SIGSTKSZ = 28672;
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * sigaction}</a>.
     *
     * @param <T>
     */
    public final static class Sigaction<T extends OpaqueMemory> extends Struct {

        public final static Alignment alignof;
        public final static long offsetof_Sa_flags;
        public final static long offsetof_Sa_handler;
        public final static long offsetof_Sa_mask;
        public final static long offsetof_Sa_sigaction;
        public final static int sizeof;

        /**
         * Make sure the native lib is loaded
         */
        static {
            switch (MultiarchTupelBuilder.getOS()) {
                case LINUX:
                    switch (MultiarchTupelBuilder.getArch()) {
                        case AARCH64:
                            alignof = Alignment.AT_8;
                            sizeof = 152;
                            offsetof_Sa_handler = 0;
                            offsetof_Sa_mask = 8;
                            offsetof_Sa_flags = 136;
                            offsetof_Sa_sigaction = 0;
                            break;
                        case MIPS_64:
                            alignof = Alignment.AT_8;
                            sizeof = 152;
                            offsetof_Sa_handler = 8;
                            offsetof_Sa_mask = 16;
                            offsetof_Sa_flags = 0;
                            offsetof_Sa_sigaction = 8;
                            break;
                        case POWER_PC_64:
                            alignof = Alignment.AT_8;
                            sizeof = 152;
                            offsetof_Sa_handler = 0;
                            offsetof_Sa_mask = 8;
                            offsetof_Sa_flags = 136;
                            offsetof_Sa_sigaction = 0;
                            break;
                        case RISC_V_64:
                            alignof = Alignment.AT_8;
                            sizeof = 152;
                            offsetof_Sa_handler = 0;
                            offsetof_Sa_mask = 8;
                            offsetof_Sa_flags = 136;
                            offsetof_Sa_sigaction = 0;
                            break;
                        case S390_X:
                            alignof = Alignment.AT_8;
                            sizeof = 152;
                            offsetof_Sa_handler = 0;
                            offsetof_Sa_mask = 24;
                            offsetof_Sa_flags = 12;
                            offsetof_Sa_sigaction = 0;
                            break;
                        case X86_64:
                            alignof = Alignment.AT_8;
                            sizeof = 152;
                            offsetof_Sa_handler = 0;
                            offsetof_Sa_mask = 8;
                            offsetof_Sa_flags = 136;
                            offsetof_Sa_sigaction = 0;
                            break;
                        case ARM:
                            alignof = Alignment.AT_4;
                            sizeof = 140;
                            offsetof_Sa_handler = 0;
                            offsetof_Sa_mask = 4;
                            offsetof_Sa_flags = 132;
                            offsetof_Sa_sigaction = 0;
                            break;
                        case I386:
                            alignof = Alignment.AT_4;
                            sizeof = 140;
                            offsetof_Sa_handler = 0;
                            offsetof_Sa_mask = 4;
                            offsetof_Sa_flags = 132;
                            offsetof_Sa_sigaction = 0;
                            break;
                        case MIPS:
                            alignof = Alignment.AT_4;
                            sizeof = 144;
                            offsetof_Sa_handler = 4;
                            offsetof_Sa_mask = 8;
                            offsetof_Sa_flags = 0;
                            offsetof_Sa_sigaction = 4;
                            break;
                        default:
                            throw new NoClassDefFoundError("No signal.h linux defines for sigaction " + MultiarchTupelBuilder.getMultiarch());
                    }
                    break;
                case DARWIN:
                    alignof = Alignment.AT_8;
                    sizeof = 16;
                    offsetof_Sa_handler = 0;
                    offsetof_Sa_mask = 8;
                    offsetof_Sa_flags = 12;
                    offsetof_Sa_sigaction = 0;
                    break;
                case FREE_BSD:
                    alignof = Alignment.AT_8;
                    sizeof = 32;
                    offsetof_Sa_handler = 0;
                    offsetof_Sa_mask = 12;
                    offsetof_Sa_flags = 8;
                    offsetof_Sa_sigaction = 0;
                    break;
                case OPEN_BSD:
                    alignof = Alignment.AT_8;
                    sizeof = 16;
                    offsetof_Sa_handler = 0;
                    offsetof_Sa_mask = 8;
                    offsetof_Sa_flags = 12;
                    offsetof_Sa_sigaction = 0;
                    break;
                default:
                    throw new NoClassDefFoundError("No signal.h OS defines for sigaction " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        public final static Sigaction allocateNative(MemorySession ms) {
            return new Sigaction(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        private NativeFunctionPointer cachedHandlerOrAction;

        /**
         * Set of signals to be blocked during execution of the signal handling
         * function.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         */
        public final Sigset_t sa_mask;

        public Sigaction(MemorySegment memorySegment, int offset) {
            super(memorySegment, offset, Sigaction.sizeof);
            sa_mask = new Sigset_t(this.memorySegment, Sigaction.offsetof_Sa_mask);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendFunctionPtrMember("sa_handler", sa_handler());
            jsb.appendStruct32Member("sa_mask", sa_mask);
            jsb.appendHexIntMember("sa_flags", sa_flags());
            jsb.appendFunctionPtrMember("sa_sigaction", sa_sigaction());
            jsb.close();
        }

        /**
         * Special flags
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @return the native value of sa_flags.
         */
        public int sa_flags() {
            return MEM_ACCESS.int32_t(memorySegment, Sigaction.offsetof_Sa_flags);
        }

        /**
         * Special flags
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @param sa_flags the value of sa_flags to be set natively.
         */
        public void sa_flags(int sa_flags) {
            MEM_ACCESS.int32_t(memorySegment, Sigaction.offsetof_Sa_flags, sa_flags);
        }

        /**
         * Pointer to a signal-catching function or one of the SIG_IGN or
         * SIG_DFL.<b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @return the native value of sa_handler.
         */
        public FunctionPtr__V___I sa_handler() {
            return new FunctionPtr__V___I(MEM_ACCESS.uintptr_t(memorySegment, Sigaction.offsetof_Sa_handler));
        }

        public void sa_handler(FunctionPtr__V___I sa_handler) {
            cachedHandlerOrAction = sa_handler;
            MEM_ACCESS.uintptr_t(memorySegment, Sigaction.offsetof_Sa_handler, sa_handler);
        }

        /**
         * Pointer to a signal-catching function or one of the SIG_IGN or
         * SIG_DFL.<b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * TODO doc
         *
         * @return the native value of sa_handler if the cached value match
         * otherwise an exception is thrown.
         */
        public Callback__V___I sa_handlerAsCallback_I_V() {
            final NativeFunctionPointer sa_handler = sa_handler();
            if (cachedHandlerOrAction instanceof Callback__V___I) {
                if (Pointer.isSameAddress(sa_handler, cachedHandlerOrAction)) {
                    return (Callback__V___I) cachedHandlerOrAction;
                } else {
                    throw new RuntimeException("TODO not the same address");
                }
            } else {
                throw new RuntimeException("TODO not the same class");
            }
        }

        /**
         * Pointer to a signal-catching function
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @return the native value of sa_sigaction.
         */
        public final FunctionPtr__V___I_MA_MA sa_sigaction() {
            return new FunctionPtr__V___I_MA_MA(MEM_ACCESS.uintptr_t(memorySegment, Sigaction.offsetof_Sa_sigaction));
        }

        public <T extends OpaqueMemory> void sa_sigaction(FunctionPtr__V___I_MA_MA<Siginfo_t, T> sa_sigaction) {
            cachedHandlerOrAction = sa_sigaction;
            MEM_ACCESS.uintptr_t(memorySegment, Sigaction.offsetof_Sa_sigaction, sa_sigaction);
        }

        /**
         * Pointer to a signal-catching function
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * TODO doc
         *
         * @return the native value of sa_sigaction if the cached value match
         * otherwise an exception is thrown.
         */
        @SuppressWarnings("unchecked")
        public Callback__V___I_MA_MA<Siginfo_t, T> sa_sigactionAsCallback_I_Mem_Mem_V() {
            final NativeFunctionPointer sa_sigaction = sa_sigaction();
            if (cachedHandlerOrAction instanceof Callback__V___I_MA_MA) {
                if (Pointer.isSameAddress(sa_sigaction, cachedHandlerOrAction)) {
                    return (Callback__V___I_MA_MA) cachedHandlerOrAction;
                } else {
                    throw new RuntimeException("TODO not the same address");
                }
            } else {
                throw new RuntimeException("TODO not the same class");
            }
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * sigevent}</a>.
     *
     * TODO this should be opaque base class with a generic class and a
     * JavaCallback class ???
     *
     */
    public static final class Sigevent<T extends OpaqueMemory> extends Struct {

        public final static Alignment alignof;
        public final static long offsetof_Sigev_notify;
        public final static long offsetof_Sigev_notify_attributes;
        public final static long offsetof_Sigev_notify_function;
        public final static long offsetof_Sigev_signo;
        public final static long offsetof_Sigev_value;
        public final static int sizeof;

        static {
            switch (MultiarchTupelBuilder.getOS()) {
                case LINUX:
                    switch (MultiarchTupelBuilder.getMemoryModel()) {
                        case ILP32:
                            alignof = Alignment.AT_4;
                            offsetof_Sigev_notify = 8;
                            offsetof_Sigev_signo = 4;
                            offsetof_Sigev_value = 0;
                            offsetof_Sigev_notify_function = 12;
                            offsetof_Sigev_notify_attributes = 16;
                            break;
                        case LP64:
                            alignof = Alignment.AT_8;
                            offsetof_Sigev_notify = 12;
                            offsetof_Sigev_signo = 8;
                            offsetof_Sigev_value = 0;
                            offsetof_Sigev_notify_function = 16;
                            offsetof_Sigev_notify_attributes = 24;
                            break;
                        default:
                            throw new NoClassDefFoundError("No signal.h linux defines for sigevent " + MultiarchTupelBuilder.getMultiarch());
                    }

                    sizeof = 64;
                    break;
                case DARWIN:
                    switch (MultiarchTupelBuilder.getMemoryModel()) {
                        case ILP32:
                            alignof = Alignment.AT_4;
                            break;
                        case LP64:
                            alignof = Alignment.AT_8;
                            break;
                        default:
                            throw new NoClassDefFoundError("No signal.h free BSD defines for sigevent " + MultiarchTupelBuilder.getMultiarch());
                    }
                    sizeof = 32;
                    offsetof_Sigev_notify = 0;
                    offsetof_Sigev_signo = 4;
                    offsetof_Sigev_value = 8;
                    offsetof_Sigev_notify_function = 16;
                    offsetof_Sigev_notify_attributes = 24;
                    break;
                case FREE_BSD:
                    switch (MultiarchTupelBuilder.getMemoryModel()) {
                        case ILP32:
                            alignof = Alignment.AT_4;
                            break;
                        case LP64:
                            alignof = Alignment.AT_8;
                            break;
                        default:
                            throw new NoClassDefFoundError("No signal.h free BSD defines for sigevent " + MultiarchTupelBuilder.getMultiarch());
                    }
                    sizeof = 80;
                    offsetof_Sigev_notify = 0;
                    offsetof_Sigev_signo = 4;
                    offsetof_Sigev_value = 8;
                    offsetof_Sigev_notify_function = 16;
                    offsetof_Sigev_notify_attributes = 24;
                    break;
                case OPEN_BSD:
                    alignof = null;
                    sizeof = 0;
                    offsetof_Sigev_notify = -1;
                    offsetof_Sigev_signo = -1;
                    offsetof_Sigev_value = -1;
                    offsetof_Sigev_notify_function = -1;
                    offsetof_Sigev_notify_attributes = -1;
                    break;
                default:
                    throw new NoClassDefFoundError("No signal.h OS defines for sigevent " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        public static String sigev_notify2String(int value) {
            if (Signal.SIGEV_NONE.isEqualsTo(value)) {
                return "SIGEV_NONE";
            }
            if (Signal.SIGEV_SIGNAL.isEqualsTo(value)) {
                return "SIGEV_SIGNAL";
            } else if (Signal.SIGEV_THREAD.isEqualsTo(value)) {
                return "SIGEV_THREAD";
            } else {
                return String.format("0x%08x", value);
            }
        }

        public static <T extends OpaqueMemory> Sigevent<T> tryAllocateNative(MemorySession ms) throws NoSuchNativeTypeException {
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Sigevent");
            }
            return new Sigevent(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public static <T extends OpaqueMemory> Sigevent<T> tryOfAddress(MemoryAddress baseAddress, MemorySession ms) throws NoSuchNativeTypeException {
            return new Sigevent<>(MemorySegment.ofAddress(baseAddress, Sigevent.sizeof, ms), 0);
        }

        private Pthread.Pthread_attr_t sigev_notify_attributes;
        private NativeFunctionPointer sigev_notify_function;

        /**
         * Signal value.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigevents}</a>.
         *
         */
        public final Sigval<T> sigev_value;

        public Sigevent(MemorySegment memorySegment, long offset) throws NoSuchNativeTypeException {
            super(memorySegment, offset, Sigevent.sizeof);
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Sigevent");
            }
            sigev_value = new Sigval(this.memorySegment, Sigevent.offsetof_Sigev_value);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendIntMember("sigev_notify", sigev_notify(), (value) -> sigev_notify2String(value));
            jsb.appendIntMember("sigev_signo", sigev_signo(), (value) -> Signal.sigNumber2String(value));
            //We do not dereference the pointer - just the memory address will do nicely.
            jsb.appendAddressMember("sigev_notify_attributes", sigev_notify_attributes());
            jsb.appendFunctionPtrMember("sigev_notify_function", sigev_notify_function);
            jsb.appendStruct32Member("sigev_value", sigev_value);
            jsb.close();
        }

        /**
         * Notification type
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigevents}</a>.
         *
         * @return the native value of sigev_notify.
         */
        public int sigev_notify() {
            return MEM_ACCESS.int32_t(memorySegment, Sigevent.offsetof_Sigev_notify);
        }

        public void sigev_notify(int value) {
            MEM_ACCESS.int32_t(memorySegment, Sigevent.offsetof_Sigev_notify, value);
        }

        protected MemoryAddress sigev_notify_attributes() {
            return MEM_ACCESS.uintptr_t(memorySegment, Sigevent.offsetof_Sigev_notify_attributes);
        }

        public final Pthread.Pthread_attr_t sigev_notify_attributes(OpaqueMemoryProducer<Pthread.Pthread_attr_t, Sigevent> producer, MemorySession ms) {
            final MemoryAddress sigev_notify_attributesAddress = sigev_notify_attributes();
            if (sigev_notify_attributes != null) {
                if (!OpaqueMemory.isSameAddress(sigev_notify_attributesAddress, sigev_notify_attributes)) {
                    sigev_notify_attributes = producer.produce(sigev_notify_attributesAddress, ms, this);
                }
                return sigev_notify_attributes;
            } else {
                if (!sigev_notify_attributesAddress.equals(MemoryAddress.NULL)) {
                    sigev_notify_attributes = producer.produce(sigev_notify_attributesAddress, ms, this);
                }
                return sigev_notify_attributes;
            }
        }

        public void sigev_notify_attributes(Pthread.Pthread_attr_t value) {
            this.sigev_notify_attributes = value;
            MEM_ACCESS.uintptr_t(memorySegment, Sigevent.offsetof_Sigev_notify_attributes, OpaqueMemory.getMemorySegment(value));
        }

        public NativeFunctionPointer sigev_notify_function() {
            return new NativeFunctionPointer(MEM_ACCESS.uintptr_t(memorySegment, Sigevent.offsetof_Sigev_notify_function));
        }

        public final void sigev_notify_function(Callback__V__MA<T> sigev_notify_function) {
            this.sigev_notify_function = sigev_notify_function;
            MEM_ACCESS.uintptr_t(memorySegment, Sigevent.offsetof_Sigev_notify_function, sigev_notify_function);
        }

        public final Callback__V__MA sigev_notify_functionAsCallback__V_Adr() {
            if (sigev_notify_function instanceof Callback__V__MA result) {
                if (Pointer.isSameAddress(sigev_notify_function(), result)) {
                    return result;
                } else {
                    throw new RuntimeException("TODO not the same address");
                }
            } else {
                throw new RuntimeException("cached sigev_notify_function is not the class Callback_V_Adr");
            }
        }

        public final void sigev_notify_function(Callback__V___I sigev_notify_function) {
            this.sigev_notify_function = sigev_notify_function;
            MEM_ACCESS.uintptr_t(memorySegment, Sigevent.offsetof_Sigev_notify_function, sigev_notify_function);
        }

        public final Callback__V___I sigev_notify_functionAsCallback__V_I() {
            if (sigev_notify_function instanceof Callback__V___I result) {
                if (Pointer.isSameAddress(sigev_notify_function(), result)) {
                    return result;
                } else {
                    throw new RuntimeException("TODO not the same address");
                }
            } else {
                throw new RuntimeException("cached sigev_notify_function is not the class Callback_V_Adr");
            }
        }

        /**
         * Signal number. * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigevents}</a>.
         *
         * @return the native value of sigev_signo.
         */
        public int sigev_signo() {
            return MEM_ACCESS.int32_t(memorySegment, Sigevent.offsetof_Sigev_signo);
        }

        public void sigev_signo(int value) {
            MEM_ACCESS.int32_t(memorySegment, Sigevent.offsetof_Sigev_signo, value);
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * siginfo_t}</a>.
     *
     */
    public final static class Siginfo_t<T extends OpaqueMemory> extends PosixStruct {

        public final static Alignment alignof;
        public final static long offsetof_Si_addr;
        public final static long offsetof_Si_band;
        public final static long offsetof_Si_code;
        public final static long offsetof_Si_errno;
        public final static long offsetof_Si_pid;
        public final static long offsetof_Si_signo;
        public final static long offsetof_Si_status;
        public final static long offsetof_Si_uid;
        public final static long offsetof_Si_value;
        public final static int sizeof;

        /**
         * Make sure the native lib is loaded
         */
        static {

            switch (MultiarchTupelBuilder.getOS()) {
                case LINUX:
                    sizeof = 128;
                    switch (MultiarchTupelBuilder.getArch()) {
                        case ARM:
                        case I386:
                            alignof = Alignment.AT_4;
                            offsetof_Si_signo = 0;
                            offsetof_Si_code = 8;
                            offsetof_Si_errno = 4;
                            offsetof_Si_pid = 12;
                            offsetof_Si_uid = 16;
                            offsetof_Si_addr = 12;
                            offsetof_Si_status = 20;
                            offsetof_Si_band = 12;
                            offsetof_Si_value = 20;
                            break;
                        case MIPS:
                            alignof = Alignment.AT_4;
                            offsetof_Si_signo = 0;
                            offsetof_Si_code = 4;
                            offsetof_Si_errno = 8;
                            offsetof_Si_pid = 12;
                            offsetof_Si_uid = 16;
                            offsetof_Si_addr = 12;
                            offsetof_Si_status = 20;
                            offsetof_Si_band = 12;
                            offsetof_Si_value = 20;
                            break;
                        case AARCH64:
                        case POWER_PC_64:
                        case RISC_V_64:
                        case S390_X:
                        case X86_64:
                            alignof = Alignment.AT_8;
                            offsetof_Si_signo = 0;
                            offsetof_Si_code = 8;
                            offsetof_Si_errno = 4;
                            offsetof_Si_pid = 16;
                            offsetof_Si_uid = 20;
                            offsetof_Si_addr = 16;
                            offsetof_Si_status = 24;
                            offsetof_Si_band = 16;
                            offsetof_Si_value = 24;
                            break;
                        case MIPS_64:
                            alignof = Alignment.AT_8;
                            offsetof_Si_signo = 0;
                            offsetof_Si_code = 4;
                            offsetof_Si_errno = 8;
                            offsetof_Si_pid = 16;
                            offsetof_Si_uid = 20;
                            offsetof_Si_addr = 16;
                            offsetof_Si_status = 24;
                            offsetof_Si_band = 16;
                            offsetof_Si_value = 24;
                            break;
                        default:
                            throw new NoClassDefFoundError("No signal.h linux defines for siginfo_t " + MultiarchTupelBuilder.getMultiarch());
                    }
                    break;
                case DARWIN:
                    sizeof = 104;
                    alignof = Alignment.AT_8;
                    offsetof_Si_signo = 0;
                    offsetof_Si_code = 8;
                    offsetof_Si_errno = 4;
                    offsetof_Si_pid = 12;
                    offsetof_Si_uid = 16;
                    offsetof_Si_addr = 24;
                    offsetof_Si_status = 20;
                    offsetof_Si_band = 40;
                    offsetof_Si_value = 32;
                    break;
                case FREE_BSD:
                    sizeof = 80;
                    alignof = Alignment.AT_8;
                    offsetof_Si_signo = 0;
                    offsetof_Si_code = 8;
                    offsetof_Si_errno = 4;
                    offsetof_Si_pid = 12;
                    offsetof_Si_uid = 16;
                    offsetof_Si_addr = 24;
                    offsetof_Si_status = 20;
                    offsetof_Si_band = 40;
                    offsetof_Si_value = 32;
                    break;
                case OPEN_BSD:
                    sizeof = 136;
                    alignof = Alignment.AT_8;
                    offsetof_Si_signo = 0;
                    offsetof_Si_code = 4;
                    offsetof_Si_errno = 8;
                    offsetof_Si_pid = 16;
                    offsetof_Si_uid = 24;
                    offsetof_Si_addr = 16;
                    offsetof_Si_status = 40;
                    offsetof_Si_band = -1;
                    offsetof_Si_value = 32;
                    break;
                default:
                    throw new NoClassDefFoundError("No signal.h OS defines for siginfo_t " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        /**
         * Signal value.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         */
        public final Sigval<T> si_value;

        public static <T extends OpaqueMemory> Siginfo_t<T> allocateNative(MemorySession ms) {
            return new Siginfo_t<T>(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public static <T extends OpaqueMemory> Siginfo_t<T> ofAddress(MemoryAddress address, MemorySession ms) {
            return new Siginfo_t<>(MemorySegment.ofAddress(address, Siginfo_t.sizeof, ms), 0);
        }

        public Siginfo_t(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Siginfo_t.sizeof);
            si_value = new Sigval(this.memorySegment, Siginfo_t.offsetof_Si_value);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendAddressMember("si_addr", si_addr());
            try {
                jsb.appendHexLongMember("si_band", si_band());
            } catch (NoSuchNativeTypeMemberException nsntme) {
            }
            jsb.appendHexIntMember("si_code", si_code());
            jsb.appendIntMember("si_errno", si_errno());
            jsb.appendIntMember("si_pid", si_pid());
            jsb.appendIntMember("si_signo", si_signo(), (value) -> Signal.sigNumber2String(value));
            jsb.appendHexIntMember("si_status", si_status());
            jsb.appendStruct32Member("si_value", si_value);
        }

        /**
         * Address of faulting instruction.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_addr.
         */
        public final MemoryAddress si_addr() {
            return MEM_ACCESS.uintptr_t(memorySegment, Siginfo_t.offsetof_Si_addr);
        }

        /**
         * Band event for SIGPOLL.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_band.
         */
        public final long si_band() throws NoSuchNativeTypeMemberException {
            if (Siginfo_t.offsetof_Si_band == -1) {
                throw new NoSuchNativeTypeMemberException("siginfo_t", "si_band");
            }
            return MEM_ACCESS.signed_long(memorySegment, Siginfo_t.offsetof_Si_band);
        }

        /**
         * Signal code.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_code.
         */
        public final int si_code() {
            return MEM_ACCESS.int32_t(memorySegment, Siginfo_t.offsetof_Si_code);
        }

        /**
         * If non-zero, an errno value associated with this signal, as described
         * in &lt;errno.h&gt;.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_errno.
         */
        public final int si_errno() {
            return MEM_ACCESS.int32_t(memorySegment, Siginfo_t.offsetof_Si_errno);
        }

        /**
         * Sending process ID.pid_t si_pid Sending process ID..
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_pid.
         */
        @pid_t
        public final int si_pid() {
            return ACCESSOR_PID_T.pid_t(memorySegment, Siginfo_t.offsetof_Si_pid);
        }

        /**
         * Signal number.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_signo.
         */
        public final int si_signo() {
            return MEM_ACCESS.int32_t(memorySegment, Siginfo_t.offsetof_Si_signo);
        }

        /**
         * Exit value or signal.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_status.
         */
        public final int si_status() {
            return MEM_ACCESS.int32_t(memorySegment, Siginfo_t.offsetof_Si_status);
        }

        /**
         * Sending process ID.uid_t si_uid Real user ID of sending process.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_pid.
         */
        @uid_t
        public final long si_uid() {
            return ACCESSOR_UID_T.uid_t(memorySegment, Siginfo_t.offsetof_Si_uid);
        }

    }

    public static final class Sigset_t extends Struct {

        public final static Alignment alignof;
        public final static int sizeof;

        static {

            switch (MultiarchTupelBuilder.getOS()) {
                case LINUX:
                    switch (MultiarchTupelBuilder.getMemoryModel()) {
                        case ILP32:
                            alignof = Alignment.AT_4;
                            break;
                        case LP64:
                            alignof = Alignment.AT_8;
                            break;
                        default:
                            throw new NoClassDefFoundError("No signal.h linux defines for sigset_t " + MultiarchTupelBuilder.getMultiarch());
                    }
                    sizeof = 128;
                    break;
                case DARWIN:
                    alignof = Alignment.AT_4;
                    sizeof = 4;
                    break;
                case FREE_BSD:
                    alignof = Alignment.AT_4;
                    sizeof = 16;
                    break;
                case OPEN_BSD:
                    alignof = Alignment.AT_4;
                    sizeof = 4;
                    break;
                default:
                    throw new NoClassDefFoundError("No signal.h OS defines for sigset_t " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        public final static Sigset_t allocateNative(MemorySession ms) {
            return new Sigset_t(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public Sigset_t(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Sigset_t.sizeof);
        }

        private void maybeDoFormatBeforeFirst(Appendable sb, boolean first, final String indent) throws IOException {
            if (first) {
                sb.append(indent);
            } else {
                sb.append(", ");
                sb.append(indent);
            }
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            boolean isFirst = true;
            final String INDENT = indentPrefix + indent;
            final boolean doIndent = INDENT.length() > 0;
            sb.append("[");
            if (doIndent) {
                sb.append("\n").append(INDENT);
            }
            try {
                if ((Signal.sigismember(this, Signal.SIGABRT))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGABRT");
                }
                if ((Signal.sigismember(this, Signal.SIGALRM))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGALRM");
                }
                if ((Signal.sigismember(this, Signal.SIGBUS))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGBUS");
                }
                if ((Signal.sigismember(this, Signal.SIGCHLD))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGCHLD");
                }
                if ((Signal.sigismember(this, Signal.SIGCONT))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGCONT");
                }
                if ((Signal.sigismember(this, Signal.SIGFPE))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGFPE");
                }
                if ((Signal.sigismember(this, Signal.SIGHUP))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGHUP");
                }
                if ((Signal.sigismember(this, Signal.SIGILL))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGILL");
                }
                if ((Signal.sigismember(this, Signal.SIGINT))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGINT");
                }
                if ((Signal.sigismember(this, Signal.SIGKILL))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGKILL");
                }
                if ((Signal.sigismember(this, Signal.SIGPIPE))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGPIPE");
                }
                if (Signal.SIGPOLL.isDefined() && Signal.sigismember(this, Signal.SIGPOLL.get())) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGPOLL");
                }
                if ((Signal.sigismember(this, Signal.SIGPROF))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGPROF");
                }
                if ((Signal.sigismember(this, Signal.SIGQUIT))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGQUIT");
                }
                if ((Signal.sigismember(this, Signal.SIGSEGV))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGSEGV");
                }
                if ((Signal.sigismember(this, Signal.SIGSTOP))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGSTOP");
                }
                if ((Signal.sigismember(this, Signal.SIGSYS))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGSYS");
                }
                if ((Signal.sigismember(this, Signal.SIGTERM))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGTERM");
                }
                if ((Signal.sigismember(this, Signal.SIGTRAP))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGTRAP");
                }
                if ((Signal.sigismember(this, Signal.SIGTSTP))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGTSTP");
                }
                if ((Signal.sigismember(this, Signal.SIGTTIN))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGTTIN");
                }
                if ((Signal.sigismember(this, Signal.SIGTTOU))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGTTOU");
                }
                if ((Signal.sigismember(this, Signal.SIGURG))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGURG");
                }
                if ((Signal.sigismember(this, Signal.SIGUSR1))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGUSR1");
                }
                if ((Signal.sigismember(this, Signal.SIGUSR2))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGUSR2");
                }
                if ((Signal.sigismember(this, Signal.SIGVTALRM))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGVTALRM");
                }
                if ((Signal.sigismember(this, Signal.SIGXCPU))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGXCPU");
                }
                if ((Signal.sigismember(this, Signal.SIGXFSZ))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGXFSZ");
                }
            } catch (NativeErrorException nee) {
                throw new RuntimeException(nee);
            }
            sb.append("]");
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * sigval}</a>.
     *
     */
    public static final class Sigval<T extends OpaqueMemory> extends Struct {

        public final static Alignment alignof;
        public final static long offsetof_Sival_int = 0;
        public final static long offsetof_Sival_ptr = 0;
        public final static int sizeof;

        static {

            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32:
                    alignof = Alignment.AT_4;
                    sizeof = 4;
                    break;
                case LP64:
                    alignof = Alignment.AT_8;
                    sizeof = 8;
                    break;
                default:
                    throw new NoClassDefFoundError("No signal.h defines for sigval " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        public static <T extends OpaqueMemory> Sigval<T> allocateNative(MemorySession ms) {
            return new Sigval(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public static <T extends OpaqueMemory> Sigval<T> ofAddress(MemoryAddress baseAddress, MemorySession ms) {
            return new Sigval<>(MemorySegment.ofAddress(baseAddress, Sigval.sizeof, ms), 0);
        }

        private T sival_ptr;

        public Sigval(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Sigval.sizeof);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendIntMember("sival_int", sival_int());
            jsb.appendAddressMember("sival_ptr", sival_ptr());
            jsb.close();
        }

        /**
         * Integer signal value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code union sigval}</a>.
         *
         * @return the native value of sival_int.
         */
        public int sival_int() {
            return MEM_ACCESS.int32_t(memorySegment, Sigval.offsetof_Sival_int);
        }

        /**
         * Integer signal value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code union sigval}</a>.
         *
         * @param sival_int the value of sival_int to be set natively.
         */
        public void sival_int(int sival_int) {
            MEM_ACCESS.int32_t(memorySegment, Sigval.offsetof_Sival_int, sival_int);
        }

        private MemoryAddress sival_ptr() {
            return MEM_ACCESS.uintptr_t(memorySegment, offsetof_Sival_ptr);
        }

        /**
         * Pointer signal value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code union sigval}</a>.
         *
         * @return the native value of sival_ptr.
         */
        public T sival_ptr(OpaqueMemoryProducer<T, Sigval<T>> producer, MemorySession ms) {
            final MemoryAddress baseAddress = sival_ptr();
            if (sival_ptr != null) {
                if (!OpaqueMemory.isSameAddress(baseAddress, sival_ptr)) {
                    sival_ptr = producer.produce(baseAddress, ms, this);
                }
                return sival_ptr;
            } else {
                if (!MemoryAddress.NULL.equals(baseAddress)) {
                    sival_ptr = producer.produce(baseAddress, ms, this);
                }
                return sival_ptr;
            }
        }

        /**
         * Pointer signal value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code union sigval}</a>.
         *
         * @param sival_ptr the value of sival_ptr to be set natively.
         */
        public final void sival_ptr(T sival_ptr) {
            this.sival_ptr = sival_ptr;
            MEM_ACCESS.uintptr_t(memorySegment, Sigval.offsetof_Sival_ptr, sival_ptr.toAddressable());
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * stack_t}</a>.
     *
     */
    public final static class Stack_t<T extends OpaqueMemory> extends PosixStruct {

        public final static Alignment alignof;
        public final static long offsetof_Ss_flags;
        public final static long offsetof_Ss_size;
        public final static long offsetof_Ss_sp;
        public final static int sizeof;

        static {
            switch (MultiarchTupelBuilder.getOS()) {
                case LINUX:
                    switch (MultiarchTupelBuilder.getMemoryModel()) {
                        case ILP32:
                            alignof = Alignment.AT_4;
                            sizeof = 12;
                            offsetof_Ss_sp = 0;
                            switch (MultiarchTupelBuilder.getArch()) {
                                case MIPS:
                                    offsetof_Ss_size = 4;
                                    offsetof_Ss_flags = 8;
                                    break;
                                default:
                                    offsetof_Ss_size = 8;
                                    offsetof_Ss_flags = 4;
                            }
                            break;
                        case LP64:
                            alignof = Alignment.AT_8;
                            sizeof = 24;
                            offsetof_Ss_sp = 0;
                            switch (MultiarchTupelBuilder.getArch()) {
                                case MIPS_64:
                                    offsetof_Ss_size = 8;
                                    offsetof_Ss_flags = 16;
                                    break;
                                default:
                                    offsetof_Ss_size = 16;
                                    offsetof_Ss_flags = 8;
                            }
                            break;
                        default:
                            throw new NoClassDefFoundError("No signal.h linux defines for stack_t " + MultiarchTupelBuilder.getMultiarch());
                    }
                    break;
                case DARWIN:
                case FREE_BSD:
                case OPEN_BSD:
                    alignof = Alignment.AT_8;
                    sizeof = 24;
                    offsetof_Ss_sp = 0;
                    offsetof_Ss_size = 8;
                    offsetof_Ss_flags = 16;
                    break;
                default:
                    throw new NoClassDefFoundError("No signal.h OS defines for stack_t " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        public final static <T extends OpaqueMemory> Stack_t<T> allocateNative(MemorySession ms) {
            return new Stack_t(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        /**
         * Create a new Stack_t and set s_flags, ss_size and ss_sp.
         *
         * @param ss_flags
         * @param ss_sp
         * @return
         */
        public static <T extends OpaqueMemory> Stack_t<T> allocateNativeAndInit(MemorySession ms, int ss_flags, T ss_sp) {
            final Stack_t<T> result = allocateNative(ms);
            result.ss_flags(ss_flags);
            result.ss_sp(ss_sp);
            result.ss_size(ss_sp.sizeof());
            return result;
        }

        public Stack_t(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Stack_t.sizeof);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendAddressMember("ss_sp", ss_sp0());
            jsb.appendLongMember("ss_size", ss_size());
            jsb.appendHexIntMember("ss_flags", ss_flags());
            jsb.close();
        }

        /**
         * Flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * stack_t}</a>.
         *
         * @return the native value of ss_flags.
         */
        public final int ss_flags() {
            return MEM_ACCESS.int32_t(memorySegment, Stack_t.offsetof_Ss_flags);
        }

        private void ss_flags(int ss_flags) {
            MEM_ACCESS.int32_t(memorySegment, Stack_t.offsetof_Ss_flags, ss_flags);
        }

        /**
         * Stack size.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * stack_t}</a>.
         *
         * @return the native value of ss_size.
         */
        @size_t
        public final long ss_size() {
            return ACCESSOR_SIZE_T.size_t(memorySegment, Stack_t.offsetof_Ss_size);
        }

        private void ss_size(@size_t long ss_size) {
            ACCESSOR_SIZE_T.size_t(memorySegment, Stack_t.offsetof_Ss_size, ss_size);
        }

        /**
         * Stack base or pointer.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * stack_t}</a>.
         *
         * @return the native value of ss_sp.
         */
        //TODO this is a Pointer
        public final T ss_sp(OpaqueMemoryProducer<T, Stack_t<T>> producer, MemorySession ms) {
            return producer.produce(ss_sp0(), ms, this);
        }

        private void ss_sp(T ss_sp) {
            MEM_ACCESS.uintptr_t(memorySegment, Stack_t.offsetof_Ss_sp, OpaqueMemory.getMemorySegment(ss_sp));
        }

        private MemoryAddress ss_sp0() {
            return MEM_ACCESS.uintptr_t(memorySegment, Stack_t.offsetof_Ss_sp);
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * ucontext_t}</a>.
     *
     */
    public final static class Ucontext_t extends Struct {

        public final static Alignment alignof;
        public final static long offsetof_Uc_link;
        public final static long offsetof_Uc_mcontext;
        public final static long offsetof_Uc_sigmask;
        public final static long offsetof_Uc_stack;
        public final static int sizeof;

        static {

            switch (MultiarchTupelBuilder.getOS()) {
                case LINUX:
                    switch (MultiarchTupelBuilder.getArch()) {
                        case AARCH64:
                            alignof = Alignment.AT_16;
                            sizeof = 4560;
                            offsetof_Uc_link = 8;
                            offsetof_Uc_sigmask = 40;
                            offsetof_Uc_stack = 16;
                            offsetof_Uc_mcontext = 176;
                            break;
                        case ARM:
                            alignof = Alignment.AT_8;
                            sizeof = 744;
                            offsetof_Uc_link = 4;
                            offsetof_Uc_sigmask = 104;
                            offsetof_Uc_stack = 8;
                            offsetof_Uc_mcontext = 20;
                            break;
                        case I386:
                            alignof = Alignment.AT_4;
                            sizeof = 364;
                            offsetof_Uc_link = 4;
                            offsetof_Uc_sigmask = 108;
                            offsetof_Uc_stack = 8;
                            offsetof_Uc_mcontext = 20;
                            break;
                        case MIPS:
                            alignof = Alignment.AT_8;
                            sizeof = 744;
                            offsetof_Uc_link = 4;
                            offsetof_Uc_sigmask = 616;
                            offsetof_Uc_stack = 8;
                            offsetof_Uc_mcontext = 24;
                            break;
                        case MIPS_64:
                            alignof = Alignment.AT_8;
                            sizeof = 768;
                            offsetof_Uc_link = 8;
                            offsetof_Uc_sigmask = 640;
                            offsetof_Uc_stack = 16;
                            offsetof_Uc_mcontext = 40;
                            break;
                        case POWER_PC_64:
                            alignof = Alignment.AT_8;
                            sizeof = 1440;
                            offsetof_Uc_link = 8;
                            offsetof_Uc_sigmask = 40;
                            offsetof_Uc_stack = 16;
                            offsetof_Uc_mcontext = 168;
                            break;
                        case RISC_V_64:
                            alignof = Alignment.AT_16;
                            sizeof = 960;
                            offsetof_Uc_link = 8;
                            offsetof_Uc_sigmask = 40;
                            offsetof_Uc_stack = 16;
                            offsetof_Uc_mcontext = 176;
                            break;
                        case S390_X:
                            alignof = Alignment.AT_8;
                            sizeof = 512;
                            offsetof_Uc_link = 8;
                            offsetof_Uc_sigmask = 384;
                            offsetof_Uc_stack = 16;
                            offsetof_Uc_mcontext = 40;
                            break;
                        case X86_64:
                            alignof = Alignment.AT_8;
                            sizeof = 968;
                            offsetof_Uc_link = 8;
                            offsetof_Uc_sigmask = 296;
                            offsetof_Uc_stack = 16;
                            offsetof_Uc_mcontext = 40;
                            break;
                        default:
                            throw new NoClassDefFoundError("No signal.h linux defines for ucontext_t " + MultiarchTupelBuilder.getMultiarch());
                    }
                    break;
                case DARWIN:
                    alignof = null;
                    sizeof = 0;
                    offsetof_Uc_link = -1;
                    offsetof_Uc_sigmask = -1;
                    offsetof_Uc_stack = -1;
                    offsetof_Uc_mcontext = -1;
                    break;
                case FREE_BSD:
                    alignof = Alignment.AT_16;
                    sizeof = 880;
                    offsetof_Uc_link = 816;
                    offsetof_Uc_sigmask = 0;
                    offsetof_Uc_stack = 824;
                    offsetof_Uc_mcontext = 16;
                    break;
                case OPEN_BSD:
                    alignof = null;
                    sizeof = 0;
                    offsetof_Uc_link = -1;
                    offsetof_Uc_sigmask = -1;
                    offsetof_Uc_stack = -1;
                    offsetof_Uc_mcontext = -1;
                    break;
                default:
                    throw new NoClassDefFoundError("No signal.h OS defines for ucontext_t " + MultiarchTupelBuilder.getMultiarch());
            }

        }

        /**
         * A machine-specific representation of the saved context.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * ucontext_t}</a>.
         *
         */
        public final Mcontext_t uc_mcontext;

        /**
         * The set of signals that are blocked when this context is active.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * ucontext_t}</a>.
         *
         */
        public final Sigset_t uc_sigmask;

        /**
         * The stack used by this context.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * ucontext_t}</a>.
         *
         */
        public final Stack_t uc_stack;

        public static Ucontext_t tryAllocateNative(MemorySession ms) throws NoSuchNativeTypeException {
            if (Ucontext_t.alignof == null) {
                throw new NoSuchNativeTypeException("Ucontext_t");
            }
            return new Ucontext_t(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public static Ucontext_t tryOfAddress(MemoryAddress baseAddress, MemorySession ms) throws NoSuchNativeTypeException {
            return new Ucontext_t(MemorySegment.ofAddress(baseAddress, Ucontext_t.sizeof, ms), 0);
        }

        public Ucontext_t(MemorySegment memorySegment, long offset) throws NoSuchNativeTypeException {
            super(memorySegment, offset, Ucontext_t.sizeof);
            if (Ucontext_t.alignof == null) {
                throw new NoSuchNativeTypeException("Ucontext_t");
            }
            uc_sigmask = new Sigset_t(this.memorySegment, Ucontext_t.offsetof_Uc_sigmask);
            uc_stack = new Stack_t(this.memorySegment, Ucontext_t.offsetof_Uc_stack);
            uc_mcontext = new Mcontext_t(this.memorySegment, Ucontext_t.offsetof_Uc_mcontext);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendAddressMember("uc_link: ", uc_link0());
            jsb.appendStruct32Member("uc_sigmask", uc_sigmask);
            jsb.appendStruct32Member("uc_stack", uc_stack);
            jsb.appendStruct32Member("uc_mcontext", uc_mcontext);
            jsb.close();
        }

        /**
         * Pointer to the context that is resumed when this context returns.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * ucontext_t}</a>.
         *
         */
        public final Ucontext_t uc_link(OpaqueMemoryProducer<Ucontext_t, Ucontext_t> producer, MemorySession ms) {
            return producer.produce(uc_link0(), ms, this);
        }

        /**
         * Pointer to the context that is resumed when this context returns.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * ucontext_t}</a>.
         *
         * @return the native value of uc_link.
         */
        private MemoryAddress uc_link0() {
            return MEM_ACCESS.uintptr_t(memorySegment, Ucontext_t.offsetof_Uc_link);
        }

    }

    /**
     * <b>POSIX:</b>{@link SIGBUS} Invalid address alignment.
     *
     */
    @Define()
    public final static int BUS_ADRALN;

    /**
     * <b>POSIX:</b>{@link SIGBUS} Nonexistent physical address.
     *
     */
    @Define()
    public final static int BUS_ADRERR;

    /**
     * <b>POSIX:</b>{@link SIGBUS} Object-specific hardware error.
     *
     *
     */
    @Define()
    public final static int BUS_OBJERR;

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Stopped child has continued.
     *
     */
    @Define()
    public final static int CLD_CONTINUED;

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Child has terminated abnormally and created
     * a core file.
     *
     */
    @Define()
    public final static int CLD_DUMPED;

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Child has exited.
     *
     */
    @Define()
    public final static int CLD_EXITED;

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Child has terminated abnormally and did not
     * create a core file.
     *
     */
    @Define()
    public final static int CLD_KILLED;

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Child has stopped.
     *
     */
    @Define()
    public final static int CLD_STOPPED;

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Traced child has trapped.
     *
     */
    @Define()
    public final static int CLD_TRAPPED;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating -point divide by zero.
     *
     */
    @Define()
    public final static int FPE_FLTDIV;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Invalid floating-point operation.
     *
     */
    @Define()
    public final static int FPE_FLTINV;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating-point overflow.
     *
     */
    @Define()
    public final static int FPE_FLTOVF;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating-point inexact result.
     *
     */
    @Define()
    public final static int FPE_FLTRES;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Subscript out of range.
     *
     */
    @Define()
    public final static int FPE_FLTSUB;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating-point underflow.
     *
     */
    @Define()
    public final static int FPE_FLTUND;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Integer divide by zero.
     *
     */
    @Define()
    public final static int FPE_INTDIV;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Integer overflow.
     *
     */
    @Define()
    public final static int FPE_INTOVF;

    public final static boolean HAVE_SIGNAL_H;

    /**
     * <b>POSIX:</b>{@link SIGILL} Internal stack error.
     *
     */
    @Define()
    public final static int ILL_BADSTK;

    /**
     * <b>POSIX:</b>{@link SIGILL} Coprocessor error.
     *
     */
    @Define()
    public final static int ILL_COPROC;

    /**
     * <b>POSIX:</b>{@link SIGILL} Illegal operand.
     *
     */
    @Define()
    public final static int ILL_ILLADR;

    /**
     * <b>POSIX:</b>{@link SIGILL} Illegal opcode.
     *
     */
    @Define()
    public final static int ILL_ILLOPC;

    /**
     * <b>POSIX:</b>{@link SIGILL} Illegal addressing mode.
     *
     */
    @Define()
    public final static int ILL_ILLOPN;

    /**
     * <b>POSIX:</b>{@link SIGILL} Illegal trap.
     *
     */
    @Define()
    public final static int ILL_ILLTRP;

    /**
     * <b>POSIX:</b>{@link SIGILL} Privileged opcode.
     *
     */
    @Define()
    public final static int ILL_PRVOPC;

    /**
     * <b>POSIX:</b>{@link SIGILL} Privileged register.
     *
     */
    @Define()
    public final static int ILL_PRVREG;

    /**
     * <b>POSIX:</b> Minimum stack size for a signal handler.
     *
     */
    @Define()
    public final static int MINSIGSTKSZ;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} I/O error.
     *
     */
    @Define()
    public final static IntDefine POLL_ERR;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Device disconnected.
     *
     */
    @Define()
    public final static IntDefine POLL_HUP;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Data input available.
     *
     */
    @Define()
    public final static IntDefine POLL_IN;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Input message available.
     *
     *
     */
    @Define()
    public final static IntDefine POLL_MSG;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Output buffers available.
     *
     *
     */
    @Define()
    public final static IntDefine POLL_OUT;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} High priority input available.
     *
     */
    @Define()
    public final static IntDefine POLL_PRI;

    /**
     * <b>POSIX:</b> Do not generate SIGCHLD when children stop or stopped
     * children continue
     *
     *
     */
    @Define()
    public final static int SA_NOCLDSTOP;

    /**
     * <b>POSIX:</b> Causes implementations not to create zombie processes or
     * status information on child termination. See sigaction.
     *
     */
    @Define()
    public final static int SA_NOCLDWAIT;

    /**
     * <b>POSIX:</b> Causes signal not to be automatically blocked on entry to
     * signal handler.
     *
     */
    @Define()
    public final static int SA_NODEFER;

    /**
     * <b>POSIX:</b> Causes signal delivery to occur on an alternate stack.
     *
     */
    @Define()
    public final static int SA_ONSTACK;

    /**
     * <b>POSIX:</b> Causes signal dispositions to be set to SIG_DFL on entry to
     * signal handlers.
     *
     */
    @Define()
    public final static int SA_RESETHAND;

    /**
     * <b>POSIX:</b> Causes certain functions to become restartable.
     *
     */
    @Define()
    public final static int SA_RESTART;

    /**
     * <b>POSIX:</b> Causes extra information to be passed to signal handlers at
     * the time of receipt of a signal.
     *
     */
    @Define()
    public final static int SA_SIGINFO;

    /**
     * <b>POSIX:</b>{@link SIGSEGV} Invalid permissions for mapped object.
     *
     */
    @Define()
    public final static int SEGV_ACCERR;

    /**
     * <b>POSIX:</b>{@link SIGSEGV} Address not mapped to object.
     *
     */
    @Define()
    public final static int SEGV_MAPERR;

    /**
     * <b>POSIX:</b> Signal generated by completion of an asynchronous I/O
     * request.
     *
     */
    @Define()
    public final static IntDefine SI_ASYNCIO;

    /**
     * <b>POSIX:</b> Signal generated by arrival of a message on an empty
     * message.
     *
     */
    @Define()
    public final static IntDefine SI_MESGQ;

    /**
     * <b>POSIX:</b> Signal sent by sigqueue().
     *
     */
    @Define()
    public final static int SI_QUEUE;

    /**
     * <b>POSIX:</b> Signal generated by expiration of a timer set by
     * timer_settime().
     *
     */
    @Define()
    public final static int SI_TIMER;

    /**
     * <b>POSIX:</b> Signal sent by kill().
     *
     */
    @Define()
    public final static int SI_USER;

    /**
     * <b>POSIX:</b> The resulting set is the union of the current set and the
     * signal set pointed to by the argument set.
     *
     */
    @Define()
    public final static int SIG_BLOCK;

    /**
     *
     * <b>POSIX:</b> Request for default signal handling.
     *
     */
    @Define()
    public final static FunctionPtr__V___I SIG_DFL;

    /**
     * <b>POSIX:</b> Return value from signal() in case of error.
     *
     */
    @Define()
    public final static FunctionPtr__V___I SIG_ERR;

    /**
     * <b>POSIX:</b> Request that signal be held.
     *
     */
    @Define()
    public final static ObjectDefine<FunctionPtr__V___I> SIG_HOLD;

    /**
     * <b>POSIX:</b> Request that signal be ignored.
     *
     */
    @Define()
    public final static FunctionPtr__V___I SIG_IGN;

    /**
     * <b>POSIX:</b> The resulting set is the signal set pointed to by the
     * argument set.
     *
     */
    @Define()
    public final static int SIG_SETMASK;

    /**
     * <b>POSIX:</b> The resulting set is the intersection of the current set
     * and the complement of the signal set pointed to by the argument set.
     *
     */
    @Define()
    public final static int SIG_UNBLOCK;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Process abort signal.
     *
     */
    @Define()
    public final static int SIGABRT;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Alarm clock.
     *
     */
    @Define()
    public final static int SIGALRM;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Access to an undefined portion of a memory object.
     *
     */
    @Define()
    public final static int SIGBUS;

    /**
     * <b>POSIX:</b><i>Ignore the signal</i> Child process terminated, stopped,
     * or continued.
     *
     */
    @Define()
    public final static int SIGCHLD;

    /**
     * <b>POSIX:</b><i>Continue the process, if it is stopped; otherwise, ignore
     * the signal.</i> Continue executing , if stopped.
     *
     */
    @Define()
    public final static int SIGCONT;

    /**
     * <b>POSIX:</b> No asynchronous notification is delivered when the event of
     * interest occurs.
     *
     */
    @Define()
    public final static IntDefine SIGEV_NONE;

    /**
     * <b>POSIX:</b> A queued signal , with an application -defined value, is
     * generated when the event of interest occurs.
     *
     */
    @Define()
    public final static IntDefine SIGEV_SIGNAL;

    /**
     * * <b>POSIX:</b> A notification function is called to perform
     * notification.
     *
     */
    @Define()
    public final static IntDefine SIGEV_THREAD;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Erroneous arithmetic operation.
     *
     */
    @Define()
    public final static int SIGFPE;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Hangup.
     *
     */
    @Define()
    public final static int SIGHUP;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Illegal instruction.
     *
     */
    @Define()
    public final static int SIGILL;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Terminal
     * interrupt signal.
     *
     */
    @Define()
    public final static int SIGINT;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i>Kill(cannot be
     * caught or ignored).
     *
     */
    @Define()
    public final static int SIGKILL;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Write on a pipe
     * with no one to read it.
     *
     */
    @Define()
    public final static int SIGPIPE;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Pollable event.
     *
     */
    @Define()
    public final static IntDefine SIGPOLL;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Profiling timer
     * expired.
     *
     */
    @Define()
    public final static int SIGPROF;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Terminal quit signal.
     *
     */
    @Define()
    public final static int SIGQUIT;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Invalid memory reference.
     *
     */
    @Define()
    public final static int SIGSEGV;

    /**
     * <b>POSIX:</b> Default size in bytes for the alternate signal stack.
     *
     */
    @Define()
    public final static int SIGSTKSZ;

    /**
     * <b>POSIX:</b><i>Stop the process</i> Stop executing(cannot be caught or
     * ignored).
     *
     */
    @Define()
    public final static int SIGSTOP;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Bad system call.
     *
     */
    @Define()
    public final static int SIGSYS;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Termination
     * signal.
     *
     */
    @Define()
    public final static int SIGTERM;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Trace /breakpoint trap.
     *
     */
    @Define()
    public final static int SIGTRAP;

    /**
     * <b>POSIX:</b><i>Stop the process</i> Terminal stop signal.
     *
     *
     */
    @Define()
    public final static int SIGTSTP;

    /**
     * <b>POSIX:</b><i>Stop the process</i> Background process attempting read.
     *
     */
    @Define()
    public final static int SIGTTIN;

    /**
     * <b>POSIX:</b><i>Stop the process</i> Background process attempting write.
     *
     *
     */
    @Define()
    public final static int SIGTTOU;

    /**
     * <b>POSIX:</b><i>Ignore the signal</i> High bandwidth data is available at
     * a socket.
     *
     */
    @Define()
    public final static int SIGURG;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> User -defined
     * signal 1.
     *
     *
     */
    @Define()
    public final static int SIGUSR1;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> User -defined
     * signal 2.
     *
     */
    @Define()
    public final static int SIGUSR2;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Virtual timer
     * expired.
     *
     */
    @Define()
    public final static int SIGVTALRM;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> CPU time limit exceeded.
     *
     */
    @Define()
    public final static int SIGXCPU;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> File size limit exceeded.
     *
     *
     */
    @Define()
    public final static int SIGXFSZ;

    /**
     * <b>POSIX:</b> Alternate signal stack is disabled.
     *
     */
    @Define()
    public final static int SS_DISABLE;

    /**
     * <b>POSIX:</b> Process is executing on an alternate signal stack.
     *
     */
    @Define()
    public final static int SS_ONSTACK;

    /**
     * <b>POSIX:</b>{@link SIGTRAP} Process breakpoint.
     *
     */
    @Define()
    public final static int TRAP_BRKPT;

    /**
     * <b>POSIX:</b>{@link SIGTRAP} Process trace trap.
     *
     */
    @Define()
    public final static int TRAP_TRACE;

    /**
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                HAVE_SIGNAL_H = true;

                BUS_ADRALN = Linux_AllArchs_Defines.BUS_ADRALN;
                BUS_ADRERR = Linux_AllArchs_Defines.BUS_ADRERR;
                BUS_OBJERR = Linux_AllArchs_Defines.BUS_OBJERR;

                CLD_CONTINUED = Linux_AllArchs_Defines.CLD_CONTINUED;
                CLD_DUMPED = Linux_AllArchs_Defines.CLD_DUMPED;
                CLD_EXITED = Linux_AllArchs_Defines.CLD_EXITED;
                CLD_KILLED = Linux_AllArchs_Defines.CLD_KILLED;
                CLD_STOPPED = Linux_AllArchs_Defines.CLD_STOPPED;
                CLD_TRAPPED = Linux_AllArchs_Defines.CLD_TRAPPED;

                FPE_FLTDIV = Linux_AllArchs_Defines.FPE_FLTDIV;
                FPE_FLTINV = Linux_AllArchs_Defines.FPE_FLTINV;
                FPE_FLTOVF = Linux_AllArchs_Defines.FPE_FLTOVF;
                FPE_FLTRES = Linux_AllArchs_Defines.FPE_FLTRES;
                FPE_FLTSUB = Linux_AllArchs_Defines.FPE_FLTSUB;
                FPE_FLTUND = Linux_AllArchs_Defines.FPE_FLTUND;
                FPE_INTDIV = Linux_AllArchs_Defines.FPE_INTDIV;
                FPE_INTOVF = Linux_AllArchs_Defines.FPE_INTOVF;

                ILL_BADSTK = Linux_AllArchs_Defines.ILL_BADSTK;
                ILL_COPROC = Linux_AllArchs_Defines.ILL_COPROC;
                ILL_ILLADR = Linux_AllArchs_Defines.ILL_ILLADR;
                ILL_ILLOPC = Linux_AllArchs_Defines.ILL_ILLOPC;
                ILL_ILLOPN = Linux_AllArchs_Defines.ILL_ILLOPN;
                ILL_ILLTRP = Linux_AllArchs_Defines.ILL_ILLTRP;
                ILL_PRVOPC = Linux_AllArchs_Defines.ILL_PRVOPC;
                ILL_PRVREG = Linux_AllArchs_Defines.ILL_PRVREG;
                switch (MultiarchTupelBuilder.getArch()) {
                    case AARCH64:
                        MINSIGSTKSZ = Linux_Aarc64_Defines.MINSIGSTKSZ;
                        break;
                    case ARM:
                    case I386:
                    case RISC_V_64:
                    case S390_X:
                    case X86_64:
                        MINSIGSTKSZ = Linux_Arm_I386_RiscV64_S390_X86_64_Defines.MINSIGSTKSZ;
                        break;
                    case MIPS:
                    case MIPS_64:
                        MINSIGSTKSZ = Linux_Mips_Mips64_Defines.MINSIGSTKSZ;
                        break;
                    case POWER_PC_64:
                        MINSIGSTKSZ = Linux_Ppc64_Defines.MINSIGSTKSZ;
                        break;
                    default:
                        throw new NoClassDefFoundError("No signal.h linux defines for MINSIGSTKSZ " + MultiarchTupelBuilder.getMultiarch());
                }

                POLL_ERR = IntDefine.toIntDefine(Linux_AllArchs_Defines.POLL_ERR);
                POLL_HUP = IntDefine.toIntDefine(Linux_AllArchs_Defines.POLL_HUP);
                POLL_IN = IntDefine.toIntDefine(Linux_AllArchs_Defines.POLL_IN);
                POLL_MSG = IntDefine.toIntDefine(Linux_AllArchs_Defines.POLL_MSG);
                POLL_OUT = IntDefine.toIntDefine(Linux_AllArchs_Defines.POLL_OUT);
                POLL_PRI = IntDefine.toIntDefine(Linux_AllArchs_Defines.POLL_PRI);

                SA_NOCLDSTOP = Linux_AllArchs_Defines.SA_NOCLDSTOP;
                SA_NODEFER = Linux_AllArchs_Defines.SA_NODEFER;
                SA_ONSTACK = Linux_AllArchs_Defines.SA_ONSTACK;
                SA_RESETHAND = Linux_AllArchs_Defines.SA_RESETHAND;
                SA_RESTART = Linux_AllArchs_Defines.SA_RESTART;

                SEGV_ACCERR = Linux_AllArchs_Defines.SEGV_ACCERR;
                SEGV_MAPERR = Linux_AllArchs_Defines.SEGV_MAPERR;

                SIGABRT = Linux_AllArchs_Defines.SIGABRT;
                SIGALRM = Linux_AllArchs_Defines.SIGALRM;

                SIGEV_NONE = IntDefine.toIntDefine(Linux_AllArchs_Defines.SIGEV_NONE);
                SIGEV_SIGNAL = IntDefine.toIntDefine(Linux_AllArchs_Defines.SIGEV_SIGNAL);
                SIGEV_THREAD = IntDefine.toIntDefine(Linux_AllArchs_Defines.SIGEV_THREAD);

                SIGFPE = Linux_AllArchs_Defines.SIGFPE;
                SIGHUP = Linux_AllArchs_Defines.SIGHUP;
                SIGILL = Linux_AllArchs_Defines.SIGILL;
                SIGINT = Linux_AllArchs_Defines.SIGINT;
                SIGKILL = Linux_AllArchs_Defines.SIGKILL;
                SIGPIPE = Linux_AllArchs_Defines.SIGPIPE;
                SIGQUIT = Linux_AllArchs_Defines.SIGQUIT;
                SIGSEGV = Linux_AllArchs_Defines.SIGSEGV;
                switch (MultiarchTupelBuilder.getArch()) {
                    case AARCH64:
                    case POWER_PC_64:
                        SIGSTKSZ = Linux_Aarc64_Ppc64_Defines.SIGSTKSZ;
                        break;
                    case ARM:
                    case I386:
                    case RISC_V_64:
                    case S390_X:
                    case X86_64:
                        SIGSTKSZ = Linux_Arm_I386_RiscV64_S390_X86_64_Defines.SIGSTKSZ;
                        break;
                    case MIPS:
                    case MIPS_64:
                        SIGSTKSZ = Linux_Mips_Mips64_Defines.SIGSTKSZ;
                        break;
                    default:
                        throw new NoClassDefFoundError("No signal.h linux defines for SIGSTKSZ " + MultiarchTupelBuilder.getMultiarch());
                }
                SIGTERM = Linux_AllArchs_Defines.SIGTERM;
                SIGTRAP = Linux_AllArchs_Defines.SIGTRAP;
                SIG_DFL = Linux_AllArchs_Defines.SIG_DFL;
                SIG_ERR = Linux_AllArchs_Defines.SIG_ERR;
                SIG_HOLD = ObjectDefine.toObjectDefine(Linux_AllArchs_Defines.SIG_HOLD);
                SIG_IGN = Linux_AllArchs_Defines.SIG_IGN;
                SI_QUEUE = Linux_AllArchs_Defines.SI_QUEUE;
                SI_USER = Linux_AllArchs_Defines.SI_USER;

                SS_DISABLE = Linux_AllArchs_Defines.SS_DISABLE;
                SS_ONSTACK = Linux_AllArchs_Defines.SS_ONSTACK;

                TRAP_BRKPT = Linux_AllArchs_Defines.TRAP_BRKPT;
                TRAP_TRACE = Linux_AllArchs_Defines.TRAP_TRACE;

                switch (MultiarchTupelBuilder.getArch()) {
                    case MIPS:
                    case MIPS_64:
                        SA_NOCLDWAIT = Linux_Mips_Mips64_Defines.SA_NOCLDWAIT;
                        SA_SIGINFO = Linux_Mips_Mips64_Defines.SA_SIGINFO;

                        SIGBUS = Linux_Mips_Mips64_Defines.SIGBUS;
                        SIGCHLD = Linux_Mips_Mips64_Defines.SIGCHLD;
                        SIGCONT = Linux_Mips_Mips64_Defines.SIGCONT;
                        SIGPOLL = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.SIGPOLL);
                        SIGPROF = Linux_Mips_Mips64_Defines.SIGPROF;
                        SIGSTOP = Linux_Mips_Mips64_Defines.SIGSTOP;
                        SIGSYS = Linux_Mips_Mips64_Defines.SIGSYS;
                        SIGTSTP = Linux_Mips_Mips64_Defines.SIGTSTP;
                        SIGTTIN = Linux_Mips_Mips64_Defines.SIGTTIN;
                        SIGTTOU = Linux_Mips_Mips64_Defines.SIGTTOU;
                        SIGURG = Linux_Mips_Mips64_Defines.SIGURG;
                        SIGUSR1 = Linux_Mips_Mips64_Defines.SIGUSR1;
                        SIGUSR2 = Linux_Mips_Mips64_Defines.SIGUSR2;
                        SIGVTALRM = Linux_Mips_Mips64_Defines.SIGVTALRM;
                        SIGXCPU = Linux_Mips_Mips64_Defines.SIGXCPU;
                        SIGXFSZ = Linux_Mips_Mips64_Defines.SIGXFSZ;
                        SIG_BLOCK = Linux_Mips_Mips64_Defines.SIG_BLOCK;

                        SIG_SETMASK = Linux_Mips_Mips64_Defines.SIG_SETMASK;
                        SIG_UNBLOCK = Linux_Mips_Mips64_Defines.SIG_UNBLOCK;

                        SI_ASYNCIO = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.SI_ASYNCIO);
                        SI_MESGQ = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.SI_MESGQ);
                        SI_TIMER = Linux_Mips_Mips64_Defines.SI_TIMER;
                        break;
                    case AARCH64:
                    case ARM:
                    case I386:
                    case POWER_PC_64:
                    case RISC_V_64:
                    case S390_X:
                    case X86_64:
                        SA_NOCLDWAIT = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SA_NOCLDWAIT;
                        SA_SIGINFO = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SA_SIGINFO;

                        SIGBUS = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGBUS;
                        SIGCHLD = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGCHLD;
                        SIGCONT = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGCONT;
                        SIGPOLL = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGPOLL);
                        SIGPROF = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGPROF;
                        SIGSTOP = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGSTOP;
                        SIGSYS = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGSYS;
                        SIGTSTP = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGTSTP;
                        SIGTTIN = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGTTIN;
                        SIGTTOU = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGTTOU;
                        SIGURG = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGURG;
                        SIGUSR1 = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGUSR1;
                        SIGUSR2 = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGUSR2;
                        SIGVTALRM = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGVTALRM;
                        SIGXCPU = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGXCPU;
                        SIGXFSZ = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIGXFSZ;
                        SIG_BLOCK = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIG_BLOCK;

                        SIG_SETMASK = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIG_SETMASK;
                        SIG_UNBLOCK = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SIG_UNBLOCK;

                        SI_ASYNCIO = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SI_ASYNCIO);
                        SI_MESGQ = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SI_MESGQ);
                        SI_TIMER = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.SI_TIMER;
                        break;
                    default:
                        throw new NoClassDefFoundError("No signal.h linux defines for " + MultiarchTupelBuilder.getMultiarch());
                }
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_SIGNAL_H = true;

                BUS_ADRALN = BsdDefines.BUS_ADRALN;
                BUS_ADRERR = BsdDefines.BUS_ADRERR;
                BUS_OBJERR = BsdDefines.BUS_OBJERR;

                CLD_CONTINUED = BsdDefines.CLD_CONTINUED;
                CLD_DUMPED = BsdDefines.CLD_DUMPED;
                CLD_EXITED = BsdDefines.CLD_EXITED;
                CLD_KILLED = BsdDefines.CLD_KILLED;
                CLD_STOPPED = BsdDefines.CLD_STOPPED;
                CLD_TRAPPED = BsdDefines.CLD_TRAPPED;

                SA_NOCLDSTOP = BsdDefines.SA_NOCLDSTOP;
                SA_NODEFER = BsdDefines.SA_NODEFER;
                SA_ONSTACK = BsdDefines.SA_ONSTACK;
                SA_RESETHAND = BsdDefines.SA_RESETHAND;
                SA_RESTART = BsdDefines.SA_RESTART;

                SEGV_ACCERR = BsdDefines.SEGV_ACCERR;
                SEGV_MAPERR = BsdDefines.SEGV_MAPERR;

                SIGABRT = BsdDefines.SIGABRT;
                SIGALRM = BsdDefines.SIGALRM;

                SIGFPE = BsdDefines.SIGFPE;
                SIGHUP = BsdDefines.SIGHUP;
                SIGILL = BsdDefines.SIGILL;
                SIGINT = BsdDefines.SIGINT;
                SIGKILL = BsdDefines.SIGKILL;
                SIGPIPE = BsdDefines.SIGPIPE;
                SIGQUIT = BsdDefines.SIGQUIT;
                SIGSEGV = BsdDefines.SIGSEGV;
                SIGTERM = BsdDefines.SIGTERM;
                SIGTRAP = BsdDefines.SIGTRAP;
                SIG_DFL = BsdDefines.SIG_DFL;
                SIG_ERR = BsdDefines.SIG_ERR;
                SIG_IGN = BsdDefines.SIG_IGN;

                SS_DISABLE = BsdDefines.SS_DISABLE;
                SS_ONSTACK = BsdDefines.SS_ONSTACK;

                TRAP_BRKPT = BsdDefines.TRAP_BRKPT;
                TRAP_TRACE = BsdDefines.TRAP_TRACE;

                SA_NOCLDWAIT = BsdDefines.SA_NOCLDWAIT;
                SA_SIGINFO = BsdDefines.SA_SIGINFO;

                SIGBUS = BsdDefines.SIGBUS;
                SIGCHLD = BsdDefines.SIGCHLD;
                SIGCONT = BsdDefines.SIGCONT;
                SIGPOLL = IntDefine.UNDEFINED;
                SIGPROF = BsdDefines.SIGPROF;
                SIGSTOP = BsdDefines.SIGSTOP;
                SIGSYS = BsdDefines.SIGSYS;
                SIGTSTP = BsdDefines.SIGTSTP;
                SIGTTIN = BsdDefines.SIGTTIN;
                SIGTTOU = BsdDefines.SIGTTOU;
                SIGURG = BsdDefines.SIGURG;
                SIGUSR1 = BsdDefines.SIGUSR1;
                SIGUSR2 = BsdDefines.SIGUSR2;
                SIGVTALRM = BsdDefines.SIGVTALRM;
                SIGXCPU = BsdDefines.SIGXCPU;
                SIGXFSZ = BsdDefines.SIGXFSZ;
                SIG_BLOCK = BsdDefines.SIG_BLOCK;

                SIG_SETMASK = BsdDefines.SIG_SETMASK;
                SIG_UNBLOCK = BsdDefines.SIG_UNBLOCK;

                switch (MultiarchTupelBuilder.getOS()) {
                    case DARWIN:
                        FPE_INTDIV = DarwinDefines.FPE_INTDIV;
                        FPE_INTOVF = DarwinDefines.FPE_INTOVF;
                        MINSIGSTKSZ = DarwinDefines.MINSIGSTKSZ;
                        POLL_ERR = IntDefine.toIntDefine(DarwinDefines.POLL_ERR);
                        POLL_HUP = IntDefine.toIntDefine(DarwinDefines.POLL_HUP);
                        POLL_IN = IntDefine.toIntDefine(DarwinDefines.POLL_IN);
                        POLL_MSG = IntDefine.toIntDefine(DarwinDefines.POLL_MSG);
                        POLL_OUT = IntDefine.toIntDefine(DarwinDefines.POLL_OUT);
                        POLL_PRI = IntDefine.toIntDefine(DarwinDefines.POLL_PRI);
                        SIGEV_NONE = IntDefine.toIntDefine(DarwinDefines.SIGEV_NONE);
                        SIGEV_SIGNAL = IntDefine.toIntDefine(DarwinDefines.SIGEV_SIGNAL);
                        SIGEV_THREAD = IntDefine.toIntDefine(DarwinDefines.SIGEV_THREAD);
                        SIGSTKSZ = DarwinDefines.SIGSTKSZ;
                        SIG_HOLD = ObjectDefine.toObjectDefine(DarwinDefines.SIG_HOLD);
                        SI_QUEUE = DarwinDefines.SI_QUEUE;
                        SI_USER = DarwinDefines.SI_USER;
                        SI_ASYNCIO = IntDefine.toIntDefine(DarwinDefines.SI_ASYNCIO);
                        SI_MESGQ = IntDefine.toIntDefine(DarwinDefines.SI_MESGQ);
                        SI_TIMER = DarwinDefines.SI_TIMER;
                        FPE_FLTDIV = DarwinDefines.FPE_FLTDIV;
                        FPE_FLTINV = DarwinDefines.FPE_FLTINV;
                        FPE_FLTOVF = DarwinDefines.FPE_FLTOVF;
                        FPE_FLTRES = DarwinDefines.FPE_FLTRES;
                        FPE_FLTSUB = DarwinDefines.FPE_FLTSUB;
                        FPE_FLTUND = DarwinDefines.FPE_FLTUND;

                        ILL_BADSTK = DarwinDefines.ILL_BADSTK;
                        ILL_COPROC = DarwinDefines.ILL_COPROC;
                        ILL_ILLADR = DarwinDefines.ILL_ILLADR;
                        ILL_ILLOPC = DarwinDefines.ILL_ILLOPC;
                        ILL_ILLOPN = DarwinDefines.ILL_ILLOPN;
                        ILL_ILLTRP = DarwinDefines.ILL_ILLTRP;
                        ILL_PRVOPC = DarwinDefines.ILL_PRVOPC;
                        ILL_PRVREG = DarwinDefines.ILL_PRVREG;

                        break;
                    case FREE_BSD:
                        FPE_INTDIV = FreeBsdDefines.FPE_INTDIV;
                        FPE_INTOVF = FreeBsdDefines.FPE_INTOVF;
                        MINSIGSTKSZ = FreeBsdDefines.MINSIGSTKSZ;
                        POLL_ERR = IntDefine.toIntDefine(FreeBsdDefines.POLL_ERR);
                        POLL_HUP = IntDefine.toIntDefine(FreeBsdDefines.POLL_HUP);
                        POLL_IN = IntDefine.toIntDefine(FreeBsdDefines.POLL_IN);
                        POLL_MSG = IntDefine.toIntDefine(FreeBsdDefines.POLL_MSG);
                        POLL_OUT = IntDefine.toIntDefine(FreeBsdDefines.POLL_OUT);
                        POLL_PRI = IntDefine.toIntDefine(FreeBsdDefines.POLL_PRI);
                        SIGEV_NONE = IntDefine.toIntDefine(FreeBsdDefines.SIGEV_NONE);
                        SIGEV_SIGNAL = IntDefine.toIntDefine(FreeBsdDefines.SIGEV_SIGNAL);
                        SIGEV_THREAD = IntDefine.toIntDefine(FreeBsdDefines.SIGEV_THREAD);
                        SIGSTKSZ = FreeBsdDefines.SIGSTKSZ;
                        SIG_HOLD = ObjectDefine.toObjectDefine(FreeBsdDefines.SIG_HOLD);
                        SI_QUEUE = FreeBsdDefines.SI_QUEUE;
                        SI_USER = FreeBsdDefines.SI_USER;
                        SI_ASYNCIO = IntDefine.toIntDefine(FreeBsdDefines.SI_ASYNCIO);
                        SI_MESGQ = IntDefine.toIntDefine(FreeBsdDefines.SI_MESGQ);
                        SI_TIMER = FreeBsdDefines.SI_TIMER;
                        FPE_FLTDIV = FreeBsdDefines.FPE_FLTDIV;
                        FPE_FLTINV = FreeBsdDefines.FPE_FLTINV;
                        FPE_FLTOVF = FreeBsdDefines.FPE_FLTOVF;
                        FPE_FLTRES = FreeBsdDefines.FPE_FLTRES;
                        FPE_FLTSUB = FreeBsdDefines.FPE_FLTSUB;
                        FPE_FLTUND = FreeBsdDefines.FPE_FLTUND;

                        ILL_BADSTK = FreeBsdDefines.ILL_BADSTK;
                        ILL_COPROC = FreeBsdDefines.ILL_COPROC;
                        ILL_ILLADR = FreeBsdDefines.ILL_ILLADR;
                        ILL_ILLOPC = FreeBsdDefines.ILL_ILLOPC;
                        ILL_ILLOPN = FreeBsdDefines.ILL_ILLOPN;
                        ILL_ILLTRP = FreeBsdDefines.ILL_ILLTRP;
                        ILL_PRVOPC = FreeBsdDefines.ILL_PRVOPC;
                        ILL_PRVREG = FreeBsdDefines.ILL_PRVREG;

                        break;
                    case OPEN_BSD:
                        FPE_INTDIV = OpenBsdDefines.FPE_INTDIV;
                        FPE_INTOVF = OpenBsdDefines.FPE_INTOVF;
                        MINSIGSTKSZ = OpenBsdDefines.MINSIGSTKSZ;
                        POLL_ERR = IntDefine.UNDEFINED;
                        POLL_HUP = IntDefine.UNDEFINED;
                        POLL_IN = IntDefine.UNDEFINED;
                        POLL_MSG = IntDefine.UNDEFINED;
                        POLL_OUT = IntDefine.UNDEFINED;
                        POLL_PRI = IntDefine.UNDEFINED;
                        SIGEV_NONE = IntDefine.UNDEFINED;
                        SIGEV_SIGNAL = IntDefine.UNDEFINED;
                        SIGEV_THREAD = IntDefine.UNDEFINED;
                        SIGSTKSZ = OpenBsdDefines.SIGSTKSZ;
                        SIG_HOLD = ObjectDefine.UNDEFINED;
                        SI_QUEUE = OpenBsdDefines.SI_QUEUE;
                        SI_USER = OpenBsdDefines.SI_USER;
                        SI_ASYNCIO = IntDefine.UNDEFINED;
                        SI_MESGQ = IntDefine.UNDEFINED;
                        SI_TIMER = OpenBsdDefines.SI_TIMER;
                        FPE_FLTDIV = OpenBsdDefines.FPE_FLTDIV;
                        FPE_FLTINV = OpenBsdDefines.FPE_FLTINV;
                        FPE_FLTOVF = OpenBsdDefines.FPE_FLTOVF;
                        FPE_FLTRES = OpenBsdDefines.FPE_FLTRES;
                        FPE_FLTSUB = OpenBsdDefines.FPE_FLTSUB;
                        FPE_FLTUND = OpenBsdDefines.FPE_FLTUND;

                        ILL_BADSTK = OpenBsdDefines.ILL_BADSTK;
                        ILL_COPROC = OpenBsdDefines.ILL_COPROC;
                        ILL_ILLADR = OpenBsdDefines.ILL_ILLADR;
                        ILL_ILLOPC = OpenBsdDefines.ILL_ILLOPC;
                        ILL_ILLOPN = OpenBsdDefines.ILL_ILLOPN;
                        ILL_ILLTRP = OpenBsdDefines.ILL_ILLTRP;
                        ILL_PRVOPC = OpenBsdDefines.ILL_PRVOPC;
                        ILL_PRVREG = OpenBsdDefines.ILL_PRVREG;

                        break;
                    default:
                        throw new NoClassDefFoundError("No signal.h BSD defines for " + MultiarchTupelBuilder.getMultiarch());
                }
                break;
            default:
                throw new NoClassDefFoundError("No signal.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    private final static JnhwMh_sI__sI_sI kill = JnhwMh_sI__sI_sI.of(
            "kill",
            BaseDataType.C_int,
            PosixDataType.pid_t,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sI killpg = JnhwMh_sI__sI_sI.of(
            "killpg",
            BaseDataType.C_int,
            PosixDataType.pid_t,
            BaseDataType.C_int);

    private final static JnhwMh__V___A__A psiginfo = JnhwMh__V___A__A.ofOrNull(
            "psiginfo",
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_const_char_pointer);

    private final static JnhwMh__V__sI__A psignal = JnhwMh__V__sI__A.ofOrNull(
            "psignal",
            BaseDataType.C_int,
            BaseDataType.C_const_char_pointer);

    private final static JnhwPthreadKill pthread_kill = JnhwPthreadKill.of(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "pthread_kill",
            BaseDataType.C_int,
            PosixDataType.pthread_t,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI__A__A pthread_sigmask = JnhwMh_sI__sI__A__A.of(
            "pthread_sigmask",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__sI raise = JnhwMh_sI__sI.of(
            "raise",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI__A__A sigaction = JnhwMh_sI__sI__A__A.of(
            "sigaction",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__A_sI sigaddset = JnhwMh_sI__A_sI.of(
            "sigaddset",
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer,
            BaseDataType.C_int);

    private final static JnhwMh_sI___A__A sigaltstack = JnhwMh_sI___A__A.of(
            "sigaltstack",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__A_sI sigdelset = JnhwMh_sI__A_sI.of(
            "sigdelset",
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer,
            BaseDataType.C_int);

    private final static JnhwMh_sI___A sigemptyset = JnhwMh_sI___A.of(
            "sigemptyset",
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI___A sigfillset = JnhwMh_sI___A.of(
            "sigfillset",
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__sI sighold = JnhwMh_sI__sI.ofOrNull(
            "sighold",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI sigignore = JnhwMh_sI__sI.ofOrNull(
            "sigignore",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sI siginterrupt = JnhwMh_sI__sI_sI.of(
            "siginterrupt",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__A_sI sigismember = JnhwMh_sI__A_sI.of(
            "sigismember",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_int);

    private final static JnhwMh__A__sI__A signal = JnhwMh__A__sI__A.of(
            "signal",
            BaseDataType.C_pointer,
            BaseDataType.C_int,
            BaseDataType.C_pointer);

    private final static JnhwMh_sI__sI sigpause = JnhwMh_sI__sI.ofOrNull(
            "sigpause",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI___A sigpending = JnhwMh_sI___A.of(
            "sigpending",
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__sI__A__A sigprocmask = JnhwMh_sI__sI__A__A.of(
            "sigprocmask",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_struct_pointer);

    //sigval is union of int and pointer, so pointer will do here
    //TODO splitint call with int and pointer? BIG/LITTLE ENDIAN???
    private final static JnhwMh_sI__sI_sI__A sigqueue = JnhwMh_sI__sI_sI__A.ofOrNull(
            "sigqueue",
            BaseDataType.C_int,
            PosixDataType.pid_t,
            BaseDataType.C_int,
            BaseDataType.C_pointer);

    private final static JnhwMh_sI__sI sigrelse = JnhwMh_sI__sI.ofOrNull(
            "sigrelse",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh__A__sI__A sigset = JnhwMh__A__sI__A.ofOrNull(
            "sigset",
            BaseDataType.C_pointer,
            BaseDataType.C_int,
            BaseDataType.C_pointer);

    private final static JnhwMh_sI___A sigsuspend = JnhwMh_sI___A.of(
            "sigsuspend",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_sI___A__A__A sigtimedwait = JnhwMh_sI___A__A__A.ofOrNull(
            "sigtimedwait",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_struct_pointer,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_sI___A__A sigwait = JnhwMh_sI___A__A.of(
            "sigwait",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_int_pointer);

    private final static JnhwMh_sI___A__A sigwaitinfo = JnhwMh_sI___A__A.ofOrNull(
            "sigwaitinfo",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_int_pointer);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/kill.html">kill
     * - send a signal to a process or a group of processes</a>.
     *
     * @param pid the pid to which the signal is send.
     * @param sig the signal to send.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void kill(@pid_t int pid, int sig) throws NativeErrorException {
        if (kill.invoke_sI__sI_sI(pid, sig) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/killpg.html">killpg
     * - send a signal to a process group</a>.
     *
     * @param pgrp the group pid to which the signal is send.
     * @param sig the signal to send.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void killpg(@pid_t int pgrp, int sig) throws NativeErrorException {
        if (killpg.invoke_sI__sI_sI(pgrp, sig) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/psiginfo.html">psiginfo,
     * psignal - write signal information to standard error</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method psiginfo is not
     * available natively.
     */
    public final static void psiginfo(Siginfo_t pinfo, String message) throws NativeErrorException, NoSuchNativeMethodException {
        try ( MemorySession ms = MemorySession.openConfined()) {
            if (message == null) {
                message = "";
            }
            MemorySegment _message = MemorySegment.allocateNative(message.length() + 1, ms);
            _message.setUtf8String(0, message);
            final int old_errno = Errno.errno();
            Errno.errno(0);
            psiginfo.invoke_V__P_A(pinfo, _message);
            if (Errno.errno() != 0) {
                throw new NativeErrorException(Errno.errno());
            }
            Errno.errno(old_errno);
        } catch (NullPointerException npe) {
            if (psiginfo == null) {
                throw new NoSuchNativeMethodException("psiginfo");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/psignal.html">psiginfo,
     * psignal - write signal information to standard error</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void psignal(int signum, String message) throws NativeErrorException {
        try ( MemorySession ms = MemorySession.openConfined()) {
            if (message == null) {
                message = "";
            }
            MemorySegment _message = MemorySegment.allocateNative(message.length() + 1, ms);
            _message.setUtf8String(0, message);
            final int old_errno = Errno.errno();
            Errno.errno(0);
            psignal.invoke__V__sI__A(signum, _message);
            if (Errno.errno() != 0) {
                throw new NativeErrorException(Errno.errno());
            }
            Errno.errno(old_errno);
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_kill.html">pthread_kill
     * - send a signal to a thread</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error. This return value is the error number.
     */
    public final static void pthread_kill(Pthread.Pthread_t thread, int sig) throws NativeErrorException {
        final int result = pthread_kill.invokeExact(thread, sig);
        if (result != 0) {
            throw new NativeErrorException(result);
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_sigmask.html">pthread_sigmask,
     * sigprocmask - examine and change blocked signals</a>.
     *
     *
     * @param how indicates the way in which the set is changed. SIG_BLOCK
     * SIG_SETMASK SIG_UNBLOCK
     * @param set the mask to set
     * @param oset if not {@code null} it receives the old mask.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void pthread_sigmask(int how, Sigset_t set, Sigset_t oset) throws NativeErrorException {
        if (pthread_sigmask.invoke_sI__sI__P__P(how, set != null ? set : Pointer.NULL, oset != null ? oset : Pointer.NULL) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/raise.html">raise
     * - send a signal to the executing process</a>.
     *
     *
     * @param sig the signal to send.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void raise(int sig) throws NativeErrorException {
        if (raise.invoke_sI__sI(sig) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigaction.html">sigaction
     * - examine and change a signal action</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void sigaction(int sig, Sigaction act, Sigaction oact) throws NativeErrorException {
        if (sigaction.invoke_sI__sI__P__P(sig, act != null ? act : Pointer.NULL, oact != null ? oact : Pointer.NULL) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigaddset.html">sigaddset
     * - add a signal to a signal set</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void sigaddset(Sigset_t set, int signo) throws NativeErrorException {
        if (sigaddset.invoke_sI__P_sI(set, signo) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigaltstack.html">sigaltstack
     * - set and get signal alternate stack context</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void sigaltstack(Stack_t ss, Stack_t oss) throws NativeErrorException {
        if (sigaltstack.invoke_sI___P__P(ss != null ? ss : Pointer.NULL, oss != null ? oss : Pointer.NULL) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigdelset.html">sigdelset
     * - delete a signal from a signal set</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void sigdelset(Sigset_t set, int signo) throws NativeErrorException {
        if (sigdelset.invoke_sI__P_sI(set, signo) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigemptyset.html">sigemptyset
     * - initialize and empty a signal set</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void sigemptyset(Sigset_t set) throws NativeErrorException {
        if (sigemptyset.invoke_sI___P(set) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigfillset.html">sigfillset
     * - initialize and fill a signal set</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void sigfillset(Sigset_t set) throws NativeErrorException {
        if (sigfillset.invoke_sI___P(set) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sighold.html">sighold,
     * sigignore, sigpause, sigrelse, sigset - signal management</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sighold is not
     * available natively.
     */
    public final static void sighold(int sig) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (sighold.invoke_sI__sI(sig) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (sighold == null) {
                throw new NoSuchNativeMethodException("sighold");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigignore.html">sighold,
     * sigignore, sigpause, sigrelse, sigset - signal management</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sigignore is not
     * available natively.
     */
    public final static void sigignore(int sig) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (sigignore.invoke_sI__sI(sig) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (sigignore == null) {
                throw new NoSuchNativeMethodException("sigignore");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/siginterrupt.html">siginterrupt
     * - allow signals to interrupt functions</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void siginterrupt(int sig, boolean flag) throws NativeErrorException {
        if (siginterrupt.invoke_sI__sI_sI(sig, flag ? 1 : 0) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigismember.html">sigismember
     * - test for a signal in a signal set</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static boolean sigismember(Sigset_t set, int signo) throws NativeErrorException {
        switch (sigismember.invoke_sI__P_sI(set, signo)) {
            case -1:
                throw new NativeErrorException(Errno.errno());
            case 0:
                return false;
            case 1:
                return true;
            default:
                throw new RuntimeException("Unexpected result from: sigismember(" + signo + ")");
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/signal.html">signal
     * - signal management</a>.
     *
     *
     * @param sig
     * @param func
     * @return
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static FunctionPtr__V___I signal(int sig, FunctionPtr__V___I func) throws NativeErrorException {
        MemoryAddress result = signal.invoke_MA__sI_P(sig, func != null ? func : Pointer.NULL);
        if (SIG_ERR.toAddressable().equals(result)) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return new FunctionPtr__V___I(result);
        }
    }

    public static String sigNumber2String(int signalNumber) {
        if (Signal.SIGABRT == signalNumber) {
            return "SIGABRT";
        } else if (SIGALRM == signalNumber) {
            return "SIGALRM";
        } else if (SIGBUS == signalNumber) {
            return "SIGBUS";
        } else if (SIGCHLD == signalNumber) {
            return "SIGCHLD";
        } else if (SIGCONT == signalNumber) {
            return "SIGCONT";
        } else if (SIGFPE == signalNumber) {
            return "SIGFPE";
        } else if (SIGHUP == signalNumber) {
            return "SIGHUP";
        } else if (SIGILL == signalNumber) {
            return "SIGILL";
        } else if (SIGINT == signalNumber) {
            return "SIGINT";
        } else if (SIGKILL == signalNumber) {
            return "SIGKILL";
        } else if (SIGPIPE == signalNumber) {
            return "SIGPIPE";
        } else if (SIGPOLL.isEqualsTo(signalNumber)) {
            return "SIGPOLL";
        } else if (SIGPROF == signalNumber) {
            return "SIGPROF";
        } else if (SIGQUIT == signalNumber) {
            return "SIGQUIT";
        } else if (SIGSEGV == signalNumber) {
            return "SIGSEGV";
        } else if (SIGSTOP == signalNumber) {
            return "SIGSTOP";
        } else if (SIGSYS == signalNumber) {
            return "SIGSYS";
        } else if (SIGTERM == signalNumber) {
            return "SIGTERM";
        } else if (SIGTRAP == signalNumber) {
            return "SIGTRAP";
        } else if (SIGTSTP == signalNumber) {
            return "SIGTSTP";
        } else if (SIGTTIN == signalNumber) {
            return "SIGTTIN";
        } else if (SIGTTOU == signalNumber) {
            return "SIGTTOU";
        } else if (SIGURG == signalNumber) {
            return "SIGURG";
        } else if (SIGUSR1 == signalNumber) {
            return "SIGUSR1";
        } else if (SIGUSR2 == signalNumber) {
            return "SIGUSR2";
        } else if (SIGVTALRM == signalNumber) {
            return "SIGVTALRM";
        } else if (SIGXCPU == signalNumber) {
            return "SIGXCPU";
        } else if (SIGXFSZ == signalNumber) {
            return "SIGXFSZ";
        } else {
            return Integer.toString(signalNumber);
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigpause.html">sighold,
     * sigignore, sigpause, sigrelse, sigset - signal management</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * is -1 and errno is other than EINTR.
     * @throws NoSuchNativeMethodException if the method sigpause is not
     * available natively.
     */
    public final static void sigpause(int sig) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final int result = sigpause.invoke_sI__sI(sig);
            if (result == -1) {
                if (Errno.errno() == Errno.EINTR) {
                    //no-op, just return
                } else {
                    throw new NativeErrorException(Errno.errno());
                }
            } else {
                throw new RuntimeException("Result of sigpause not excpected: " + result);
            }
        } catch (NullPointerException npe) {
            if (sigpause == null) {
                throw new NoSuchNativeMethodException("sigpause");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigpending.html">sigpending
     * - examine pending signals</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void sigpending(Sigset_t set) throws NativeErrorException {
        if (sigpending.invoke_sI___P(set) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigprocmask.html">pthread_sigmask,
     * sigprocmask - examine and change blocked signals</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void sigprocmask(int how, Sigset_t set, Sigset_t oset) throws NativeErrorException {
        if (sigprocmask.invoke_sI__sI__P__P(how, set != null ? set : Pointer.NULL, oset != null ? oset : Pointer.NULL) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigqueue.html">sigqueue
     * - queue a signal to a process</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sigqueue is not
     * available natively.
     */
    public final static void sigqueue(@pid_t int pid, int signo, Sigval value) throws NativeErrorException, NoSuchNativeMethodException {
        //TODO is this right?? int and pointer???
        try {
            if (sigqueue.invoke_sI__sI_sI_A(pid, signo, value.sival_ptr()) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (sigqueue == null) {
                throw new NoSuchNativeMethodException("sigqueue");
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigrelse.html">sighold,
     * sigignore, sigpause, sigrelse, sigset - signal management</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sigrelse is not
     * available natively.
     */
    public final static void sigrelse(int sig) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (sigrelse.invoke_sI__sI(sig) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (sigrelse == null) {
                throw new NoSuchNativeMethodException("sigrelse");
            } else {
                throw npe;
            }

        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigrelse.html">sighold,
     * sigignore, sigpause, sigrelse, sigset - signal management</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sigset is not available
     * natively.
     *///TODO args missing ....
    public final static FunctionPtr__V___I sigset(int sig, FunctionPtr__V___I disp) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final MemoryAddress result = sigset.invoke_MA__sI_P(sig, disp != null ? disp : Pointer.NULL);
            if (SIG_ERR.toAddressable().equals(result)) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return new FunctionPtr__V___I(result);
            }
        } catch (NullPointerException npe) {
            if (sigset == null) {
                throw new NoSuchNativeMethodException("sigset");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigsuspend.html">sigsuspend
     * - wait for a signal</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * is -1 an errno is other than EINTR.
     */
    public final static void sigsuspend(Sigset_t sigmask) throws NativeErrorException {
        //TODO if not set to 0 it will not have EINTR!?.
        Errno.errno(0);
        if (sigsuspend.invoke_sI___P(sigmask) == -1) {
            final int errno = Errno.errno();
            if (errno != Errno.EINTR) {
                throw new NativeErrorException(errno);
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigtimedwait.html">sigtimedwait,
     * sigwaitinfo - wait for queued signals</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sigtimedwait is not
     * available natively.
     */
    public final static int sigtimedwait(Sigset_t set, Siginfo_t info, Timespec timeout) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final int result = sigtimedwait.invoke_sI___P__P__P(set, info != null ? info : Pointer.NULL, timeout);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        } catch (NullPointerException npe) {
            if (sigtimedwait == null) {
                throw new NoSuchNativeMethodException("sigtimedwait");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigwait.html">sigwait
     * - wait for queued signals</a>.
     *
     *
     * @param set
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void sigwait(Sigset_t set, Int32_t sig) throws NativeErrorException {
        if (sigwait.invoke_sI___P__P(set, sig) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigwaitinfo.html">sigtimedwait,
     * sigwaitinfo - wait for queued signals</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sigwaitinfo is not
     * available natively.
     */
    public final static int sigwaitinfo(Sigset_t set, Siginfo_t info) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final int result = sigwaitinfo.invoke_sI___P__P(set, info != null ? info : Pointer.NULL);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            } else {
                return result;
            }
        } catch (NullPointerException npe) {
            if (sigwaitinfo == null) {
                throw new NoSuchNativeMethodException("sigwaitinfo");
            } else {
                throw npe;
            }
        }
    }
}
