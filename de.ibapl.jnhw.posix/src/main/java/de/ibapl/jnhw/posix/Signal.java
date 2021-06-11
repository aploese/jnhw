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
import de.ibapl.jnhw.common.callback.Callback_NativeRunnable;
import de.ibapl.jnhw.common.callback.Callback_Mem_V;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.posix.Time.Timespec;
import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.uid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.size_t;
import de.ibapl.jnhw.common.callback.Callback_I_V;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayout;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_I_Mem_Mem_V;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_I_V;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.common.util.ObjectDefine;
import de.ibapl.jnhw.util.posix.Callback__Sigval_int__V;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import de.ibapl.jnhw.util.posix.memory.PosixStruct32;
import java.io.IOException;

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

    /**
     * Make sure the native lib is loaded
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwPosixLoader.touch();

        HAVE_SIGNAL_H = false;

        BUS_ADRALN = 0;
        BUS_ADRERR = 0;
        BUS_OBJERR = 0;

        CLD_CONTINUED = 0;
        CLD_DUMPED = 0;
        CLD_EXITED = 0;
        CLD_KILLED = 0;
        CLD_STOPPED = 0;
        CLD_TRAPPED = 0;

        FPE_FLTDIV = 0;
        FPE_FLTINV = 0;
        FPE_FLTOVF = 0;
        FPE_FLTRES = 0;
        FPE_FLTSUB = 0;
        FPE_FLTUND = 0;
        FPE_INTDIV = 0;
        FPE_INTOVF = 0;

        ILL_BADSTK = 0;
        ILL_COPROC = 0;
        ILL_ILLADR = 0;
        ILL_ILLOPC = 0;
        ILL_ILLOPN = 0;
        ILL_ILLTRP = 0;
        ILL_PRVOPC = 0;
        ILL_PRVREG = 0;

        MINSIGSTKSZ = 0;

        POLL_ERR = IntDefine.UNDEFINED;
        POLL_HUP = IntDefine.UNDEFINED;
        POLL_IN = IntDefine.UNDEFINED;
        POLL_MSG = IntDefine.UNDEFINED;
        POLL_OUT = IntDefine.UNDEFINED;
        POLL_PRI = IntDefine.UNDEFINED;

        SA_NOCLDSTOP = 0;
        SA_NOCLDWAIT = 0;
        SA_NODEFER = 0;
        SA_ONSTACK = 0;
        SA_RESETHAND = 0;
        SA_RESTART = 0;
        SA_SIGINFO = 0;

        SEGV_ACCERR = 0;
        SEGV_MAPERR = 0;

        SIGABRT = 0;
        SIGALRM = 0;
        SIGBUS = 0;
        SIGCHLD = 0;
        SIGCONT = 0;

        SIGEV_NONE = IntDefine.UNDEFINED;
        SIGEV_SIGNAL = IntDefine.UNDEFINED;
        SIGEV_THREAD = IntDefine.UNDEFINED;

        SIGFPE = 0;
        SIGHUP = 0;
        SIGILL = 0;
        SIGINT = 0;
        SIGKILL = 0;
        SIGPIPE = 0;
        SIGPOLL = IntDefine.UNDEFINED;
        SIGPROF = 0;
        SIGQUIT = 0;
        SIGSEGV = 0;
        SIGSTKSZ = 0;
        SIGSTOP = 0;
        SIGSYS = 0;
        SIGTERM = 0;
        SIGTRAP = 0;
        SIGTSTP = 0;
        SIGTTIN = 0;
        SIGTTOU = 0;
        SIGURG = 0;
        SIGUSR1 = 0;
        SIGUSR2 = 0;
        SIGVTALRM = 0;
        SIGXCPU = 0;
        SIGXFSZ = 0;
        SIG_BLOCK = 0;
        SIG_DFL = null;
        SIG_ERR = null;
        SIG_HOLD = ObjectDefine.UNDEFINED;
        SIG_IGN = null;
        SIG_SETMASK = 0;
        SIG_UNBLOCK = 0;

        SI_ASYNCIO = IntDefine.UNDEFINED;
        SI_MESGQ = IntDefine.UNDEFINED;
        SI_QUEUE = 0;
        SI_TIMER = 0;
        SI_USER = 0;

        SS_DISABLE = 0;
        SS_ONSTACK = 0;

        TRAP_BRKPT = 0;
        TRAP_TRACE = 0;

        initFields();
    }

    private static native void initFields();

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
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code typedef
     * mcontext_t}</a>.
     *
     * @author aploese
     */
    public static final class Mcontext_t extends Struct32 {

        public static class Layout extends StructLayout {

            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        private final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        public static Layout getLayoutOrThrow() throws NoSuchNativeTypeException {
            if (LAYOUT == null) {
                throw new NoSuchNativeTypeException("Aio.Aiocb");
            }
            return LAYOUT;
        }

        public Mcontext_t() throws NoSuchNativeTypeException {
            this(null, 0, SetMem.DO_NOT_SET);
        }

        public Mcontext_t(AbstractNativeMemory owner, long offset, SetMem setMem) throws NoSuchNativeTypeException {
            super(owner, offset, getLayoutOrThrow().sizeof, setMem);
        }

        public Mcontext_t(NativeAddressHolder baseAddress) throws NoSuchNativeTypeException {
            super(baseAddress, getLayoutOrThrow().sizeof);
        }

    }

    public final static boolean HAVE_SIGNAL_H;

    public static final class Sigset_t extends Struct32 {

        public static class Layout extends StructLayout {

            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        public final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        public Sigset_t() {
            this(null, 0, SetMem.DO_NOT_SET);
        }

        public Sigset_t(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, LAYOUT.sizeof, setMem);
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
    public static final class Sigval<T extends OpaqueMemory32> extends Struct32 {

        public static class Layout extends StructLayout {

            public final long sival_int;
            public final long sival_ptr;
            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                sival_int = -1;
                sival_ptr = -1;
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        public final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        public Sigval() {
            this(null, 0, SetMem.DO_NOT_SET);
        }

        public Sigval(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, LAYOUT.sizeof, setMem);
        }

        public Sigval(NativeAddressHolder baseAddress) {
            super(baseAddress, LAYOUT.sizeof);
        }

        private T sival_ptr;

        private NativeAddressHolder sival_ptr() {
            return MEM_ACCESS.uintptr_t_AsNativeAddressHolder(this, LAYOUT.sival_ptr);
        }

        /**
         * Integer signal value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code union sigval}</a>.
         *
         * @return the native value of sival_int.
         */
        public int sival_int() {
            return MEM_ACCESS.int32_t(this, LAYOUT.sival_int);
        }

        /**
         * Integer signal value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code union sigval}</a>.
         *
         * @param sival_int the value of sival_int to be set natively.
         */
        public void sival_int(int sival_int) {
            MEM_ACCESS.int32_t(this, LAYOUT.sival_int, sival_int);
        }

        /**
         * Pointer signal value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code union sigval}</a>.
         *
         * @return the native value of sival_ptr.
         */
        public T sival_ptr(OpaqueMemory32Producer<T, Sigval<T>> producer) {
            final NativeAddressHolder baseAddress = sival_ptr();
            if (sival_ptr != null) {
                if (!OpaqueMemory32.isSameAddress(baseAddress, sival_ptr)) {
                    sival_ptr = producer.produce(baseAddress, this);
                }
                return sival_ptr;
            } else {
                if (!baseAddress.isNULL()) {
                    sival_ptr = producer.produce(baseAddress, this);
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
            MEM_ACCESS.uintptr_t(this, LAYOUT.sival_ptr, sival_ptr);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendIntMember("sival_int", sival_int());
            jsb.appendNativeAddressHolderMember("sival_ptr", sival_ptr());
            jsb.close();
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
    public static final class Sigevent<T extends OpaqueMemory32> extends Struct32 {

        public static class Layout extends StructLayout {

            public final long sigev_notify;
            public final long sigev_signo;
            public final long sigev_value;
            public final long sigev_notify_function;
            public final long sigev_notify_attributes;
            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                sigev_notify = -1;
                sigev_signo = -1;
                sigev_value = -1;
                sigev_notify_function = -1;
                sigev_notify_attributes = -1;
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        private final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        public static Layout getLayoutOrThrow() throws NoSuchNativeTypeException {
            if (LAYOUT == null) {
                throw new NoSuchNativeTypeException("Aio.Aiocb");
            }
            return LAYOUT;
        }

        /**
         * Signal value.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigevents}</a>.
         *
         */
        public final Sigval<T> sigev_value;
        private NativeFunctionPointer sigev_notify_function;
        private Pthread.Pthread_attr_t sigev_notify_attributes;

        @SuppressWarnings("unchecked")
        public Sigevent() throws NoSuchNativeTypeException {
            this(null, 0, SetMem.TO_0x00);
        }

        @SuppressWarnings("unchecked")
        public Sigevent(NativeAddressHolder baseAddress) throws NoSuchNativeTypeException {
            super(baseAddress, getLayoutOrThrow().sizeof);
            sigev_value = new Sigval(this, getLayoutOrThrow().sigev_value, SetMem.DO_NOT_SET);
        }

        public Sigevent(AbstractNativeMemory parent, long offset, SetMem setMem) throws NoSuchNativeTypeException {
            super(parent, offset, getLayoutOrThrow().sizeof, setMem);
            sigev_value = new Sigval(this, getLayoutOrThrow().sigev_value, SetMem.DO_NOT_SET);
        }

        /**
         * Notification type
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigevents}</a>.
         *
         * @return the native value of sigev_notify.
         */
        public int sigev_notify() {
            return MEM_ACCESS.int32_t(this, LAYOUT.sigev_notify);
        }

        public void sigev_notify(int value) {
            MEM_ACCESS.int32_t(this, LAYOUT.sigev_notify, value);
        }

        /**
         * Signal number. * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigevents}</a>.
         *
         * @return the native value of sigev_signo.
         */
        public int sigev_signo() {
            return MEM_ACCESS.int32_t(this, LAYOUT.sigev_signo);
        }

        public void sigev_signo(int value) {
            MEM_ACCESS.int32_t(this, LAYOUT.sigev_signo, value);
        }

        protected NativeAddressHolder sigev_notify_attributes() {
            return MEM_ACCESS.uintptr_t_AsNativeAddressHolder(this, LAYOUT.sigev_notify_attributes);
        }

        public final Pthread.Pthread_attr_t sigev_notify_attributes(OpaqueMemory32Producer<Pthread.Pthread_attr_t, Sigevent> producer) {
            final NativeAddressHolder sigev_notify_attributesAddress = sigev_notify_attributes();
            if (sigev_notify_attributes != null) {
                if (!OpaqueMemory32.isSameAddress(sigev_notify_attributesAddress, sigev_notify_attributes)) {
                    sigev_notify_attributes = producer.produce(sigev_notify_attributesAddress, this);
                }
                return sigev_notify_attributes;
            } else {
                if (!sigev_notify_attributesAddress.isNULL()) {
                    sigev_notify_attributes = producer.produce(sigev_notify_attributesAddress, this);
                }
                return sigev_notify_attributes;
            }
        }

        public void sigev_notify_attributes(Pthread.Pthread_attr_t value) {
            this.sigev_notify_attributes = value;
            MEM_ACCESS.uintptr_t(this, LAYOUT.sigev_notify_attributes, value);
        }

        public NativeFunctionPointer sigev_notify_function() {
            return new NativeFunctionPointer(MEM_ACCESS.uintptr_t_AsNativeAddressHolder(this, LAYOUT.sigev_notify_function));
        }

        /**
         * Even if we can get away with an int we dont do this. BIG ENDIAN will
         * acces the other half of the union sigval.sival_ptr for
         * sigval.sival_int.
         *
         * @param sigev_notify_function
         * @throws NoSuchNativeTypeException
         */
        public final void sigev_notify_function(Callback__Sigval_int__V sigev_notify_function) {
            this.sigev_notify_function = sigev_notify_function;
            MEM_ACCESS.uintptr_t(this, LAYOUT.sigev_notify_function, sigev_notify_function);
        }

        public final void sigev_notify_function(Callback_Mem_V<T> sigev_notify_function) {
            this.sigev_notify_function = sigev_notify_function;
            MEM_ACCESS.uintptr_t(this, LAYOUT.sigev_notify_function, sigev_notify_function);
        }

        public final void sigev_notify_function(Callback_NativeRunnable sigev_notify_function) {
            this.sigev_notify_function = sigev_notify_function;
            MEM_ACCESS.uintptr_t(this, LAYOUT.sigev_notify_function, sigev_notify_function);
        }

        public final Callback__Sigval_int__V sigev_notify_functionAsCallback__Sigval_int__V() {
            if (sigev_notify_function instanceof Callback__Sigval_int__V) {
                if (NativeFunctionPointer.isSameAddress(sigev_notify_function(), sigev_notify_function)) {
                    return (Callback__Sigval_int__V) sigev_notify_function;
                } else {
                    throw new RuntimeException("TODO not the same address");
                }
            } else {
                throw new RuntimeException("cached sigev_notify_function is not the class Callback__Sigval_int__V");
            }
        }

        public final Callback_Mem_V sigev_notify_functionAsCallback_PtrOpaqueMemory_V() {
            if (sigev_notify_function instanceof Callback_Mem_V) {
                if (NativeFunctionPointer.isSameAddress(sigev_notify_function(), sigev_notify_function)) {
                    return (Callback_Mem_V) sigev_notify_function;
                } else {
                    throw new RuntimeException("TODO not the same address");
                }
            } else {
                throw new RuntimeException("cached sigev_notify_function is not the class Callback_Mem_V");
            }
        }

        public final Callback_NativeRunnable sigev_notify_functionAsCallback_NativeRunnable() {
            if (sigev_notify_function instanceof Callback_NativeRunnable) {
                if (NativeFunctionPointer.isSameAddress(sigev_notify_function(), sigev_notify_function)) {
                    return (Callback_NativeRunnable) sigev_notify_function;
                } else {
                    throw new RuntimeException("TODO not the same address");
                }
            } else {
                throw new RuntimeException("cached sigev_notify_function is not the class Callback_NativeRunnable");
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

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendIntMember("sigev_notify", sigev_notify(), (value) -> sigev_notify2String(value));
            jsb.appendIntMember("sigev_signo", sigev_signo(), (value) -> Signal.sigNumber2String(value));
            //We do not dereference the pointer - just the memory address will do nicely.
            jsb.appendNativeAddressHolderMember("sigev_notify_attributes", sigev_notify_attributes());
            jsb.appendFunctionPtrMember("sigev_notify_function", sigev_notify_function);
            jsb.appendStruct32Member("sigev_value", sigev_value);
            jsb.close();
        }

    }

    /**
     *
     * <b>POSIX:</b> Request for default signal handling.
     *
     */
    @Define()
    public final static FunctionPtr_I_V SIG_DFL;

    /**
     * <b>POSIX:</b> Return value from signal() in case of error.
     *
     */
    @Define()
    public final static FunctionPtr_I_V SIG_ERR;

    /**
     * <b>POSIX:</b> Request that signal be held.
     *
     */
    @Define()
    public final static ObjectDefine<FunctionPtr_I_V> SIG_HOLD;

    /**
     * <b>POSIX:</b> Request that signal be ignored.
     *
     */
    @Define()
    public final static FunctionPtr_I_V SIG_IGN;

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
     * <b>POSIX:</b><i>Stop the process</i> Stop executing(cannot be caught or
     * ignored).
     *
     */
    @Define()
    public final static int SIGSTOP;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Termination
     * signal.
     *
     */
    @Define()
    public final static int SIGTERM;

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
     * actions</i> Bad system call.
     *
     */
    @Define()
    public final static int SIGSYS;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Trace /breakpoint trap.
     *
     */
    @Define()
    public final static int SIGTRAP;

    /**
     * <b>POSIX:</b><i>Ignore the signal</i> High bandwidth data is available at
     * a socket.
     *
     */
    @Define()
    public final static int SIGURG;

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
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * sigaction}</a>.
     *
     * @param <T>
     */
    public static class Sigaction<T extends OpaqueMemory32> extends Struct32 {

        public static class Layout extends StructLayout {

            public final long sa_handler;
            public final long sa_mask;
            public final long sa_flags;
            public final long sa_sigaction;
            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                sa_handler = -1;
                sa_mask = -1;
                sa_flags = -1;
                sa_sigaction = -1;
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        public final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        public Sigaction() {
            this(null, 0, SetMem.DO_NOT_SET);
        }

        public Sigaction(AbstractNativeMemory parent, int offset, SetMem setMem) {
            super(parent, offset, LAYOUT.sizeof, setMem);
            sa_mask = new Sigset_t(this, LAYOUT.sa_mask, SetMem.DO_NOT_SET);
        }

        /**
         * Set of signals to be blocked during execution of the signal handling
         * function.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         */
        public final Sigset_t sa_mask;

        private NativeFunctionPointer cachedHandlerOrAction;

        /**
         * Special flags
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @return the native value of sa_flags.
         */
        public int sa_flags() {
            return MEM_ACCESS.int32_t(this, LAYOUT.sa_flags);
        }

        /**
         * Special flags
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @param sa_flags the value of sa_flags to be set natively.
         */
        public void sa_flags(int sa_flags) {
            MEM_ACCESS.int32_t(this, LAYOUT.sa_flags, sa_flags);
        }

        /**
         * Pointer to a signal-catching function or one of the SIG_IGN or
         * SIG_DFL.<b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @return the native value of sa_handler.
         */
        public FunctionPtr_I_V sa_handler() {
            return new FunctionPtr_I_V(MEM_ACCESS.uintptr_t_AsNativeAddressHolder(this, LAYOUT.sa_handler));
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
        public Callback_I_V sa_handlerAsCallback_I_V() {
            final NativeFunctionPointer sa_handler = sa_handler();
            if (cachedHandlerOrAction instanceof Callback_I_V) {
                if (NativeFunctionPointer.isSameAddress(sa_handler, cachedHandlerOrAction)) {
                    return (Callback_I_V) cachedHandlerOrAction;
                } else {
                    throw new RuntimeException("TODO not the same address");
                }
            } else {
                throw new RuntimeException("TODO not the same class");
            }
        }

        public void sa_handler(FunctionPtr_I_V sa_handler) {
            cachedHandlerOrAction = sa_handler;
            MEM_ACCESS.uintptr_t(this, LAYOUT.sa_handler, sa_handler);
        }

        /**
         * Pointer to a signal-catching function
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @return the native value of sa_sigaction.
         */
        public final FunctionPtr_I_Mem_Mem_V sa_sigaction() {
            return new FunctionPtr_I_Mem_Mem_V(MEM_ACCESS.uintptr_t_AsNativeAddressHolder(this, LAYOUT.sa_sigaction));
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
        public Callback_I_Mem_Mem_V<Siginfo_t, T> sa_sigactionAsCallback_I_Mem_Mem_V() {
            final NativeFunctionPointer sa_sigaction = sa_sigaction();
            if (cachedHandlerOrAction instanceof Callback_I_Mem_Mem_V) {
                if (NativeFunctionPointer.isSameAddress(sa_sigaction, cachedHandlerOrAction)) {
                    return (Callback_I_Mem_Mem_V) cachedHandlerOrAction;
                } else {
                    throw new RuntimeException("TODO not the same address");
                }
            } else {
                throw new RuntimeException("TODO not the same class");
            }
        }

        public <T extends OpaqueMemory32> void sa_sigaction(FunctionPtr_I_Mem_Mem_V<Siginfo_t, T> sa_sigaction) {
            cachedHandlerOrAction = sa_sigaction;
            MEM_ACCESS.uintptr_t(this, LAYOUT.sa_sigaction, sa_sigaction);
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

    }

    /**
     * <b>POSIX:</b> The resulting set is the union of the current set and the
     * signal set pointed to by the argument set.
     *
     */
    @Define()
    public final static int SIG_BLOCK;

    /**
     * <b>POSIX:</b> The resulting set is the intersection of the current set
     * and the complement of the signal set pointed to by the argument set.
     *
     */
    @Define()
    public final static int SIG_UNBLOCK;

    /**
     * <b>POSIX:</b> The resulting set is the signal set pointed to by the
     * argument set.
     *
     */
    @Define()
    public final static int SIG_SETMASK;

    /**
     * <b>POSIX:</b> Do not generate SIGCHLD when children stop or stopped
     * children continue
     *
     *
     */
    @Define()
    public final static int SA_NOCLDSTOP;

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
     * <b>POSIX:</b> Process is executing on an alternate signal stack.
     *
     */
    @Define()
    public final static int SS_ONSTACK;

    /**
     * <b>POSIX:</b> Alternate signal stack is disabled.
     *
     */
    @Define()
    public final static int SS_DISABLE;

    /**
     * <b>POSIX:</b> Minimum stack size for a signal handler.
     *
     */
    @Define()
    public final static int MINSIGSTKSZ;

    /**
     * <b>POSIX:</b> Default size in bytes for the alternate signal stack.
     *
     */
    @Define()
    public final static int SIGSTKSZ;

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * ucontext_t}</a>.
     *
     */
    public static class Ucontext_t extends Struct32 {

        public static class Layout extends StructLayout {

            public final long uc_link;
            public final long uc_sigmask;
            public final long uc_stack;
            public final long uc_mcontext;
            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                uc_link = -1;
                uc_sigmask = -1;
                uc_stack = -1;
                uc_mcontext = -1;
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        private final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        public static Layout getLayoutOrThrow() throws NoSuchNativeTypeException {
            if (LAYOUT == null) {
                throw new NoSuchNativeTypeException("Aio.Aiocb");
            }
            return LAYOUT;
        }

        public Ucontext_t(SetMem setMem) throws NoSuchNativeTypeException {
            this(null, 0, setMem);
        }

        public Ucontext_t(AbstractNativeMemory parent, long offset, SetMem setMem) throws NoSuchNativeTypeException {
            super(parent, offset, getLayoutOrThrow().sizeof, setMem);
            uc_sigmask = new Sigset_t(this, getLayoutOrThrow().uc_sigmask, SetMem.DO_NOT_SET);
            uc_stack = new Stack_t(this, getLayoutOrThrow().uc_stack, SetMem.DO_NOT_SET);
            uc_mcontext = new Mcontext_t(this, getLayoutOrThrow().uc_mcontext, SetMem.DO_NOT_SET);
        }

        public Ucontext_t(NativeAddressHolder baseAddress) throws NoSuchNativeTypeException {
            super(baseAddress, getLayoutOrThrow().sizeof);
            uc_sigmask = new Sigset_t(this, getLayoutOrThrow().uc_sigmask, SetMem.DO_NOT_SET);
            uc_stack = new Stack_t(this, getLayoutOrThrow().uc_stack, SetMem.DO_NOT_SET);
            uc_mcontext = new Mcontext_t(this, getLayoutOrThrow().uc_mcontext, SetMem.DO_NOT_SET);
        }

        /**
         * Pointer to the context that is resumed when this context returns.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * ucontext_t}</a>.
         *
         * @return the native value of uc_link.
         */
        private NativeAddressHolder uc_link0() {
            return MEM_ACCESS.uintptr_t_AsNativeAddressHolder(this, LAYOUT.uc_link);
        }

        /**
         * Pointer to the context that is resumed when this context returns.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * ucontext_t}</a>.
         *
         */
        public final Ucontext_t uc_link(OpaqueMemory32Producer<Ucontext_t, Ucontext_t> producer) {
            return producer.produce(uc_link0(), this);
        }

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

        /**
         * A machine-specific representation of the saved context.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * ucontext_t}</a>.
         *
         */
        public final Mcontext_t uc_mcontext;

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendNativeAddressHolderMember("uc_link: ", uc_link0());
            jsb.appendStruct32Member("uc_sigmask", uc_sigmask);
            jsb.appendStruct32Member("uc_stack", uc_stack);
            jsb.appendStruct32Member("uc_mcontext", uc_mcontext);
            jsb.close();
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * stack_t}</a>.
     *
     */
    public static class Stack_t<T extends OpaqueMemory32> extends PosixStruct32 {

        public static class Layout extends StructLayout {

            public final long ss_sp;
            public final long ss_size;
            public final long ss_flags;
            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                ss_sp = -1;
                ss_size = -1;
                ss_flags = -1;
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        public final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        public Stack_t() {
            this(null, 0, SetMem.DO_NOT_SET);
        }

        public Stack_t(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, LAYOUT.sizeof, setMem);
        }

        /**
         * Create a new Stack_t and set s_flags, ss_size and ss_sp.
         *
         * @param ss_flags
         * @param ss_sp
         * @return
         */
        public static <T extends OpaqueMemory32> Stack_t<T> of(int ss_flags, T ss_sp) {
            Stack_t<T> result = new Stack_t<>();
            result.ss_flags(ss_flags);
            result.ss_sp(ss_sp);
            result.ss_size(ss_sp.sizeInBytes);
            return result;
        }

        private void ss_flags(int ss_flags) {
            MEM_ACCESS.int32_t(this, LAYOUT.ss_flags, ss_flags);
        }

        private NativeAddressHolder ss_sp0() {
            return MEM_ACCESS.uintptr_t_AsNativeAddressHolder(this, LAYOUT.ss_sp);
        }

        private void ss_size(@size_t long ss_size) {
            ACCESSOR_SIZE_T.size_t(this, LAYOUT.ss_size, ss_size);
        }

        /**
         * Stack base or pointer.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * stack_t}</a>.
         *
         * @return the native value of ss_sp.
         */
        //TODO this is a Pointer
        public final T ss_sp(OpaqueMemory32Producer<T, Stack_t<T>> producer) {
            return producer.produce(ss_sp0(), this);
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
            return ACCESSOR_SIZE_T.size_t(this, LAYOUT.ss_size);
        }

        /**
         * Flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * stack_t}</a>.
         *
         * @return the native value of ss_flags.
         */
        public final int ss_flags() {
            return MEM_ACCESS.int32_t(this, LAYOUT.ss_flags);
        }

        private void ss_sp(T ss_sp) {
            MEM_ACCESS.uintptr_t(this, LAYOUT.ss_sp, ss_sp);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendNativeAddressHolderMember("ss_sp", ss_sp0());
            jsb.appendLongMember("ss_size", ss_size());
            jsb.appendHexIntMember("ss_flags", ss_flags());
            jsb.close();
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * siginfo_t}</a>.
     *
     */
    public static class Siginfo_t<T extends OpaqueMemory32> extends PosixStruct32 {

        public static class Layout extends StructLayout {

            public final long si_signo;
            public final long si_code;
            public final long si_errno;
            public final long si_pid;
            public final long si_uid;
            public final long si_addr;
            public final long si_status;
            public final long si_band;
            public final long si_value;
            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                si_signo = -1;
                si_code = -1;
                si_errno = -1;
                si_pid = -1;
                si_uid = -1;
                si_addr = -1;
                si_status = -1;
                si_band = -1;
                si_value = -1;
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        public final static Layout LAYOUT;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        public Siginfo_t() {
            this(null, 0, SetMem.DO_NOT_SET);
        }

        public Siginfo_t(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, LAYOUT.sizeof, setMem);
            si_value = new Sigval(this, LAYOUT.si_value, SetMem.DO_NOT_SET);
        }

        /**
         * Create a wrapper around some unknown mem - it will NOT be freed
         *
         * @param address
         */
        public Siginfo_t(NativeAddressHolder address) {
            super(address, LAYOUT.sizeof);
            si_value = new Sigval(this, LAYOUT.si_value, SetMem.DO_NOT_SET);
        }

        /**
         * Signal number.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_signo.
         */
        public final int si_signo() {
            return MEM_ACCESS.int32_t(this, LAYOUT.si_signo);
        }

        /**
         * Signal code.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_code.
         */
        public final int si_code() {
            return MEM_ACCESS.int32_t(this, LAYOUT.si_code);
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
            return MEM_ACCESS.int32_t(this, LAYOUT.si_errno);
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
            return ACCESSOR_PID_T.pid_t(this, LAYOUT.si_pid);
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
            return ACCESSOR_UID_T.uid_t(this, LAYOUT.si_uid);
        }

        /**
         * Address of faulting instruction.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_addr.
         */
        public final NativeAddressHolder si_addr() {
            return MEM_ACCESS.uintptr_t_AsNativeAddressHolder(this, LAYOUT.si_addr);
        }

        /**
         * Exit value or signal.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_status.
         */
        public final int si_status() {
            return MEM_ACCESS.int32_t(this, LAYOUT.si_status);
        }

        /**
         * Band event for SIGPOLL.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_band.
         */
        public final long si_band() throws NoSuchNativeTypeMemberException {
            if (LAYOUT.si_band == -1) {
                throw new NoSuchNativeTypeMemberException("siginfo_t", "si_band");
            }
            return MEM_ACCESS.signed_long(this, LAYOUT.si_band);
        }
        /**
         * Signal value.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         */
        public final Sigval<T> si_value;

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendNativeAddressHolderMember("si_addr", si_addr());
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

    }

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
     * <b>POSIX:</b>{@link SIGILL} Illegal operand.
     *
     */
    @Define()
    public final static int ILL_ILLADR;

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
     * <b>POSIX:</b>{@link SIGILL} Coprocessor error.
     *
     */
    @Define()
    public final static int ILL_COPROC;

    /**
     * <b>POSIX:</b>{@link SIGILL} Internal stack error.
     *
     */
    @Define()
    public final static int ILL_BADSTK;

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

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating -point divide by zero.
     *
     */
    @Define()
    public final static int FPE_FLTDIV;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating-point overflow.
     *
     */
    @Define()
    public final static int FPE_FLTOVF;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating-point underflow.
     *
     */
    @Define()
    public final static int FPE_FLTUND;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating-point inexact result.
     *
     */
    @Define()
    public final static int FPE_FLTRES;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Invalid floating-point operation.
     *
     */
    @Define()
    public final static int FPE_FLTINV;

    /**
     * <b>POSIX:</b>{@link SIGFPE} Subscript out of range.
     *
     */
    @Define()
    public final static int FPE_FLTSUB;

    /**
     * <b>POSIX:</b>{@link SIGSEGV} Address not mapped to object.
     *
     */
    @Define()
    public final static int SEGV_MAPERR;

    /**
     * <b>POSIX:</b>{@link SIGSEGV} Invalid permissions for mapped object.
     *
     */
    @Define()
    public final static int SEGV_ACCERR;

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
     * <b>POSIX:</b>{@link SIGCHLD} Child has terminated abnormally and created
     * a core file.
     *
     */
    @Define()
    public final static int CLD_DUMPED;

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Traced child has trapped.
     *
     */
    @Define()
    public final static int CLD_TRAPPED;

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Child has stopped.
     *
     */
    @Define()
    public final static int CLD_STOPPED;

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Stopped child has continued.
     *
     */
    @Define()
    public final static int CLD_CONTINUED;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Data input available.
     *
     */
    @Define()
    public final static IntDefine POLL_IN;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Output buffers available.
     *
     *
     */
    @Define()
    public final static IntDefine POLL_OUT;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Input message available.
     *
     *
     */
    @Define()
    public final static IntDefine POLL_MSG;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} I/O error.
     *
     */
    @Define()
    public final static IntDefine POLL_ERR;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} High priority input available.
     *
     */
    @Define()
    public final static IntDefine POLL_PRI;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Device disconnected.
     *
     */
    @Define()
    public final static IntDefine POLL_HUP;

    /**
     * <b>POSIX:</b> Signal sent by kill().
     *
     */
    @Define()
    public final static int SI_USER;

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
    public final static native void kill(@pid_t int pid, int sig) throws NativeErrorException;

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
    public final static native void killpg(@pid_t int pgrp, int sig) throws NativeErrorException;

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
        psiginfo(AbstractNativeMemory.getAddress(pinfo), message);
    }

    private static native void psiginfo(long ptrPinfo, String message) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/psignal.html">psiginfo,
     * psignal - write signal information to standard error</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void psignal(int signum, String message) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_kill.html">pthread_kill
     * - send a signal to a thread</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method pthread_kill is not
     * available natively.
     */
    public final static void pthread_kill(Pthread.Pthread_t thread, int sig) throws NativeErrorException, NoSuchNativeMethodException {
        pthread_kill(AbstractNativeMemory.getAddress(thread), sig);
    }

    private static native void pthread_kill(long ptrThread, int sig) throws NativeErrorException, NoSuchNativeMethodException;

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
        pthread_sigmask(how, AbstractNativeMemory.getAddressOrNULL(set), AbstractNativeMemory.getAddressOrNULL(oset));
    }

    private static native void pthread_sigmask(int how, long ptrSet,
            long ptrOset) throws NativeErrorException;

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
    public final static native void raise(int sig) throws NativeErrorException;

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
        sigaction(sig, AbstractNativeMemory.getAddressOrNULL(act), AbstractNativeMemory.getAddressOrNULL(oact));
    }

    private static native void sigaction(int sig, long ptrAct, long ptrOact) throws NativeErrorException;

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
        sigaddset(AbstractNativeMemory.getAddress(set), signo);
    }

    private static native void sigaddset(long set, int signo) throws NativeErrorException;

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
        sigaltstack(AbstractNativeMemory.getAddressOrNULL(ss), AbstractNativeMemory.getAddressOrNULL(oss));
    }

    private static native void sigaltstack(long ptrSs, long ptrOss) throws NativeErrorException;

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
        sigdelset(AbstractNativeMemory.getAddress(set), signo);
    }

    private static native void sigdelset(long ptrSet, int signo) throws NativeErrorException;

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
        sigemptyset(AbstractNativeMemory.getAddress(set));
    }

    private static native void sigemptyset(long ptrSet) throws NativeErrorException;

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
        sigfillset(AbstractNativeMemory.getAddress(set));
    }

    private static native void sigfillset(long set) throws NativeErrorException;

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
    public final static native void sighold(int sig) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native void sigignore(int sig) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/siginterrupt.html">siginterrupt
     * - allow signals to interrupt functions</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void siginterrupt(int sig, boolean flag) throws NativeErrorException;

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
        return sigismember(AbstractNativeMemory.getAddress(set), signo);
    }

    private static native boolean sigismember(long ptrSet, int signo) throws NativeErrorException;

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
    public final static FunctionPtr_I_V signal(int sig, FunctionPtr_I_V func) throws NativeErrorException {
        return FunctionPtr_I_V.ofUintptr_t((signal(sig, NativeFunctionPointer.getNativeAddressOrNULL(func))));
    }

    private static native long signal(int sig, long ptrFunc) throws NativeErrorException;

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
    public final static native void sigpause(int sig) throws NativeErrorException, NoSuchNativeMethodException;

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
        sigpending(AbstractNativeMemory.getAddress(set));
    }

    private static native void sigpending(long ptrSet) throws NativeErrorException;

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
        sigprocmask(how, AbstractNativeMemory.getAddressOrNULL(set), AbstractNativeMemory.getAddressOrNULL(oset));
    }

    private static native void sigprocmask(int how, long ptrSet, long ptrOset) throws NativeErrorException;

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
        sigqueue(pid, signo, AbstractNativeMemory.getAddress(value));
    }

    private static native void sigqueue(int pid, int signo, long ptrValue) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native void sigrelse(int sig) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static FunctionPtr_I_V sigset(int sig, FunctionPtr_I_V disp) throws NativeErrorException, NoSuchNativeMethodException {
        return FunctionPtr_I_V.ofUintptr_t(sigset(sig, NativeFunctionPointer.getNativeAddressOrNULL(disp)));
    }

    private static native long sigset(int sig, long ptrDisp) throws NativeErrorException, NoSuchNativeMethodException;

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
        sigsuspend(AbstractNativeMemory.getAddress(sigmask));
    }

    private static native void sigsuspend(long ptrSigmask) throws NativeErrorException;

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
    public final static int sigtimedwait(Sigset_t set, Siginfo_t info,
            Timespec timeout) throws NativeErrorException, NoSuchNativeMethodException {
        return sigtimedwait(AbstractNativeMemory.getAddress(set), AbstractNativeMemory.getAddressOrNULL(info), AbstractNativeMemory.getAddress(timeout));
    }

    private static native int sigtimedwait(long ptrSet, long ptrInfo,
            long ptrTimeout) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigwait.html">sigwait
     * - wait for queued signals</a>.
     *
     *
     * @param set
     *
     * @return the signal number of the received signal.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int sigwait(Sigset_t set) throws NativeErrorException {
        return sigwait(AbstractNativeMemory.getAddress(set));
    }

    private static native int sigwait(long ptrSet) throws NativeErrorException;

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
        return sigwaitinfo(AbstractNativeMemory.getAddress(set), AbstractNativeMemory.getAddressOrNULL(info));
    }

    private static native int sigwaitinfo(long ptrSet, long ptrInfo) throws NativeErrorException, NoSuchNativeMethodException;
}
