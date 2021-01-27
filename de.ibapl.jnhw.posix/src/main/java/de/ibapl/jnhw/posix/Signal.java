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

import de.ibapl.jnhw.common.annotation.AlignOf;
import de.ibapl.jnhw.common.callback.Callback_I_Mem_Mem_V;
import de.ibapl.jnhw.common.callback.Callback_NativeRunnable;
import de.ibapl.jnhw.common.callback.Callback_Mem_V;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.common.exception.NotDefinedException;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.posix.Time.Timespec;
import de.ibapl.jnhw.annontation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annontation.posix.sys.types.uid_t;
import de.ibapl.jnhw.annontation.posix.sys.types.size_t;
import de.ibapl.jnhw.common.callback.Callback_I_V;
import de.ibapl.jnhw.common.nativecall.CallNative_I_Mem_Mem_V;
import de.ibapl.jnhw.common.nativecall.CallNative_I_V;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_I_Mem_Mem_V;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_I_V;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.util.posix.Callback__Sigval_int__V;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
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

    public static String sigNumber2String(int signalNumber) {
        if (Signal.SIGABRT() == signalNumber) {
            return "SIGABRT";
        }
        if (SIGALRM() == signalNumber) {
            return "SIGALRM";
        }
        if (SIGBUS() == signalNumber) {
            return "SIGBUS";
        }
        if (SIGCHLD() == signalNumber) {
            return "SIGCHLD";
        }
        if (SIGCONT() == signalNumber) {
            return "SIGCONT";
        }
        if (SIGFPE() == signalNumber) {
            return "SIGFPE";
        }
        if (SIGHUP() == signalNumber) {
            return "SIGHUP";
        }
        if (SIGILL() == signalNumber) {
            return "SIGILL";
        }
        if (SIGINT() == signalNumber) {
            return "SIGINT";
        }
        if (SIGKILL() == signalNumber) {
            return "SIGKILL";
        }
        if (SIGPIPE() == signalNumber) {
            return "SIGPIPE";
        }
        try {
            if (SIGPOLL() == signalNumber) {
                return "SIGPOLL";
            }
        } catch (NotDefinedException ex) {
            //no-op
        }
        if (SIGPROF() == signalNumber) {
            return "SIGPROF";
        }
        if (SIGQUIT() == signalNumber) {
            return "SIGQUIT";
        }
        if (SIGSEGV() == signalNumber) {
            return "SIGSEGV";
        }
        if (SIGSTOP() == signalNumber) {
            return "SIGSTOP";
        }
        if (SIGSYS() == signalNumber) {
            return "SIGSYS";
        }
        if (SIGTERM() == signalNumber) {
            return "SIGTERM";
        }
        if (SIGTRAP() == signalNumber) {
            return "SIGTRAP";
        }
        if (SIGTSTP() == signalNumber) {
            return "SIGTSTP";
        }
        if (SIGTTIN() == signalNumber) {
            return "SIGTTIN";
        }
        if (SIGTTOU() == signalNumber) {
            return "SIGTTOU";
        }
        if (SIGURG() == signalNumber) {
            return "SIGURG";
        }
        if (SIGUSR1() == signalNumber) {
            return "SIGUSR1";
        }
        if (SIGUSR2() == signalNumber) {
            return "SIGUSR2";
        }
        if (SIGVTALRM() == signalNumber) {
            return "SIGVTALRM";
        }
        if (SIGXCPU() == signalNumber) {
            return "SIGXCPU";
        }
        if (SIGXFSZ() == signalNumber) {
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

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct mcontext_t natively.
         *
         * @return the native value sizeof(struct mcontext_t).
         */
        @SizeOf
        public static native int sizeof() throws NoSuchNativeTypeException;

        @AlignOf
        public static native int alignof() throws NoSuchNativeTypeException;

        public Mcontext_t() throws NoSuchNativeTypeException {
            super(sizeof(), false);
        }

        public Mcontext_t(OpaqueMemory32 owner, int offset) throws NoSuchNativeTypeException {
            super(owner, offset, sizeof());
        }

        public Mcontext_t(NativeAddressHolder baseAddress) throws NoSuchNativeTypeException {
            super(baseAddress, sizeof());
        }

    }

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_SIGNAL_H();

    public static final class Sigset_t extends Struct32 {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct sigset_t natively.
         *
         * @return the native value sizeof(struct sigset_t).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Sigset_t() {
            super(sizeof(), false);
        }

        public Sigset_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
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
                if ((Signal.sigismember(this, Signal.SIGABRT()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGABRT");
                }
                if ((Signal.sigismember(this, Signal.SIGALRM()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGALRM");
                }
                if ((Signal.sigismember(this, Signal.SIGBUS()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGBUS");
                }
                if ((Signal.sigismember(this, Signal.SIGCHLD()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGCHLD");
                }
                if ((Signal.sigismember(this, Signal.SIGCONT()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGCONT");
                }
                if ((Signal.sigismember(this, Signal.SIGFPE()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGFPE");
                }
                if ((Signal.sigismember(this, Signal.SIGHUP()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGHUP");
                }
                if ((Signal.sigismember(this, Signal.SIGILL()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGILL");
                }
                if ((Signal.sigismember(this, Signal.SIGINT()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGINT");
                }
                if ((Signal.sigismember(this, Signal.SIGKILL()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGKILL");
                }
                if ((Signal.sigismember(this, Signal.SIGPIPE()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGPIPE");
                }
                try {
                    if ((Signal.sigismember(this, Signal.SIGPOLL()))) {
                        maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                        isFirst = false;
                        sb.append("SIGPOLL");
                    }
                } catch (NotDefinedException ex) {
                    //no-op
                }
                if ((Signal.sigismember(this, Signal.SIGPROF()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGPROF");
                }
                if ((Signal.sigismember(this, Signal.SIGQUIT()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGQUIT");
                }
                if ((Signal.sigismember(this, Signal.SIGSEGV()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGSEGV");
                }
                if ((Signal.sigismember(this, Signal.SIGSTOP()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGSTOP");
                }
                if ((Signal.sigismember(this, Signal.SIGSYS()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGSYS");
                }
                if ((Signal.sigismember(this, Signal.SIGTERM()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGTERM");
                }
                if ((Signal.sigismember(this, Signal.SIGTRAP()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGTRAP");
                }
                if ((Signal.sigismember(this, Signal.SIGTSTP()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGTSTP");
                }
                if ((Signal.sigismember(this, Signal.SIGTTIN()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGTTIN");
                }
                if ((Signal.sigismember(this, Signal.SIGTTOU()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGTTOU");
                }
                if ((Signal.sigismember(this, Signal.SIGURG()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGURG");
                }
                if ((Signal.sigismember(this, Signal.SIGUSR1()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGUSR1");
                }
                if ((Signal.sigismember(this, Signal.SIGUSR2()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGUSR2");
                }
                if ((Signal.sigismember(this, Signal.SIGVTALRM()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGVTALRM");
                }
                if ((Signal.sigismember(this, Signal.SIGXCPU()))) {
                    maybeDoFormatBeforeFirst(sb, isFirst, INDENT);
                    isFirst = false;
                    sb.append("SIGXCPU");
                }
                if ((Signal.sigismember(this, Signal.SIGXFSZ()))) {
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

        private native NativeAddressHolder sival_ptr();

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct sigval natively.
         *
         * @return the native value sizeof(struct sigval).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Sigval() {
            super(sizeof(), false);
        }

        public Sigval(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public Sigval(NativeAddressHolder baseAddress) {
            super(baseAddress, sizeof());
        }

        private T sival_ptr;

        /**
         * Integer signal value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code union sigval}</a>.
         *
         * @return the native value of sival_int.
         */
        public native int sival_int();

        /**
         * Integer signal value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code union sigval}</a>.
         *
         * @param sival_int the value of sival_int to be set natively.
         */
        public native void sival_int(int sival_int);

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

        private native void sival_ptr0(T sival_ptr);

        /**
         * Pointer signal value.
         * <b>POSIX:</b>
         * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code union sigval}</a>.
         *
         * @param sival_ptr the value of sival_ptr to be set natively.
         */
        public final void sival_ptr(T sival_ptr) {
            this.sival_ptr = sival_ptr;
            sival_ptr0(sival_ptr);
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

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        public static native int offsetof_Sigev_value() throws NoSuchNativeTypeException;

        /**
         * Get the real size of struct sigevent natively.
         *
         * @return the native value sizeof(struct sigevent).
         */
        @SizeOf
        public static native int sizeof() throws NoSuchNativeTypeException;

        @AlignOf
        public static native int alignof() throws NoSuchNativeTypeException;

        /**
         * Signal value.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigevents}</a>.
         *
         */
        public final Sigval<T> sigev_value;
        private NativeFunctionPointer sigev_notify_function;
        Pthread.Pthread_attr_t sigev_notify_attributes;

        @SuppressWarnings("unchecked")
        public Sigevent() throws NoSuchNativeTypeException {
            super(sizeof(), true);
            sigev_value = new Sigval(this, offsetof_Sigev_value());
        }

        @SuppressWarnings("unchecked")
        public Sigevent(NativeAddressHolder baseAddress) throws NoSuchNativeTypeException {
            super(baseAddress, sizeof());
            sigev_value = new Sigval(this, offsetof_Sigev_value());
        }

        @SuppressWarnings("unchecked")
        Sigevent(OpaqueMemory32 owner, int offset) throws NoSuchNativeTypeException {
            super(owner, offset, sizeof());
            sigev_value = new Sigval(this, offsetof_Sigev_value());
        }

        /**
         * Notification type
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigevents}</a>.
         *
         * @return the native value of sigev_notify.
         */
        public final native int sigev_notify() throws NoSuchNativeTypeException;

        public final native void sigev_notify(int value) throws NoSuchNativeTypeException;

        /**
         * Signal number. * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigevents}</a>.
         *
         * @return the native value of sigev_signo.
         */
        public final native int sigev_signo() throws NoSuchNativeTypeException;

        public final native void sigev_signo(int value) throws NoSuchNativeTypeException;

        private native NativeAddressHolder sigev_notify_attributes() throws NoSuchNativeTypeException;

        public final Pthread.Pthread_attr_t sigev_notify_attributes(OpaqueMemory32Producer<Pthread.Pthread_attr_t, Sigevent> producer) throws NoSuchNativeTypeException {
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

        private native void sigev_notify_attributes0(Pthread.Pthread_attr_t value) throws NoSuchNativeTypeException;

        public final void sigev_notify_attributes(Pthread.Pthread_attr_t value) throws NoSuchNativeTypeException {
            this.sigev_notify_attributes = value;
            sigev_notify_attributes0(value);
        }

        public final native NativeFunctionPointer sigev_notify_function() throws NoSuchNativeTypeException;

        private native void sigev_notify_function0(NativeFunctionPointer sigev_notify_function) throws NoSuchNativeTypeException;

        /**
         * Even if we can get away with an int we dont do this. BIG ENDIAN will
         * acces the other half of the union sigval.sival_ptr for
         * sigval.sival_int.
         *
         * @param sigev_notify_function
         * @throws NoSuchNativeTypeException
         */
        public final void sigev_notify_function(Callback__Sigval_int__V sigev_notify_function) throws NoSuchNativeTypeException {
            this.sigev_notify_function = sigev_notify_function;
            sigev_notify_function0(sigev_notify_function);
        }

        public final void sigev_notify_function(Callback_Mem_V<T> sigev_notify_function) throws NoSuchNativeTypeException {
            this.sigev_notify_function = sigev_notify_function;
            sigev_notify_function0(sigev_notify_function);
        }

        public final void sigev_notify_function(Callback_NativeRunnable sigev_notify_function) throws NoSuchNativeTypeException {
            this.sigev_notify_function = sigev_notify_function;
            sigev_notify_function0(sigev_notify_function);
        }

        public final Callback__Sigval_int__V sigev_notify_functionAsCallback__Sigval_int__V() throws NoSuchNativeTypeException {
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

        public final Callback_Mem_V sigev_notify_functionAsCallback_PtrOpaqueMemory_V() throws NoSuchNativeTypeException {
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

        public final Callback_NativeRunnable sigev_notify_functionAsCallback_NativeRunnable() throws NoSuchNativeTypeException {
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
            try {
                if (value == Signal.SIGEV_NONE()) {
                    return "SIGEV_NONE";
                }
                if (value == Signal.SIGEV_SIGNAL()) {
                    return "SIGEV_SIGNAL";
                } else if (value == Signal.SIGEV_THREAD()) {
                    return "SIGEV_THREAD";
                } else {
                    return String.format("0x%08x", value);
                }
            } catch (NotDefinedException ex) {
                throw new RuntimeException(ex);
            }
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            try {
                jsb.appendIntMember("sigev_notify", sigev_notify(), (value) -> sigev_notify2String(value));
                jsb.appendIntMember("sigev_signo", sigev_signo(), (value) -> Signal.sigNumber2String(value));
                //We do not dereference the pointer - just the memory address will do nicely.
                jsb.appendNativeAddressHolderMember("sigev_notify_attributes", sigev_notify_attributes());
                jsb.appendFunctionPtrMember("sigev_notify_function", sigev_notify_function);
                jsb.appendStruct32Member("sigev_value", sigev_value);
            } catch (NoSuchNativeTypeException nste) {
                throw new RuntimeException(nste);
            }
            jsb.close();
        }

    }

    /**
     *
     * <b>POSIX:</b> Request for default signal handling.
     *
     * @return the native symbolic constant of SIG_DFL.
     */
    @Define()
    public final static native FunctionPtr_I_V SIG_DFL();

    /**
     * <b>POSIX:</b> Return value from signal() in case of error.
     *
     * @return the native symbolic constant of SIG_ERR.
     */
    @Define()
    public final static native FunctionPtr_I_V SIG_ERR();

    /**
     * <b>POSIX:</b> Request that signal be held.
     *
     * @return the native symbolic constant of SIG_HOLD.
     * @throws NotDefinedException if SIG_HOLD is not defined natively.
     */
    @Define()
    public final static native FunctionPtr_I_V SIG_HOLD() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Request that signal be ignored.
     *
     * @return the native symbolic constant of SIG_IGN.
     */
    @Define()
    public final static native FunctionPtr_I_V SIG_IGN();

    /**
     * <b>POSIX:</b> No asynchronous notification is delivered when the event of
     * interest occurs.
     *
     *
     * @return the native symbolic constant of SIGEV_NONE.
     * @throws NotDefinedException if SIGEV_NONE is not defined natively.
     */
    @Define()
    public final static native int SIGEV_NONE() throws NotDefinedException;

    /**
     * <b>POSIX:</b> A queued signal , with an application -defined value, is
     * generated when the event of interest occurs.
     *
     *
     * @return the native symbolic constant of SIGEV_SIGNAL.
     * @throws NotDefinedException if SIGEV_SIGNAL is not defined natively.
     */
    @Define()
    public final static native int SIGEV_SIGNAL() throws NotDefinedException;

    /**
     * * <b>POSIX:</b> A notification function is called to perform
     * notification.
     *
     * @return the native symbolic constant of SIGEV_THREAD.
     * @throws NotDefinedException if SIGEV_THREAD is not defined natively.
     */
    @Define()
    public final static native int SIGEV_THREAD() throws NotDefinedException;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Process abort signal.
     *
     * @return the native symbolic constant of SIGABRT.
     */
    @Define()
    public final static native int SIGABRT();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Alarm clock.
     *
     * @return the native symbolic constant of SIGALRM.
     */
    @Define()
    public final static native int SIGALRM();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Access to an undefined portion of a memory object.
     *
     *
     * @return the native symbolic constant of SIGBUS.
     */
    @Define()

    public final static native int SIGBUS();

    /**
     * <b>POSIX:</b><i>Ignore the signal</i> Child process terminated, stopped,
     * or continued.
     *
     * @return the native symbolic constant of SIGCHLD.
     */
    @Define()
    public final static native int SIGCHLD();

    /**
     * <b>POSIX:</b><i>Continue the process, if it is stopped; otherwise, ignore
     * the signal.</i> Continue executing , if stopped.
     *
     * @return the native symbolic constant of SIGCONT.
     */
    @Define()
    public final static native int SIGCONT();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Erroneous arithmetic operation.
     *
     *
     * @return the native symbolic constant of SIGFPE.
     */
    @Define()

    public final static native int SIGFPE();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Hangup.
     *
     * @return the native symbolic constant of SIGHUP.
     */
    @Define()
    public final static native int SIGHUP();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Illegal instruction.
     *
     * @return the native symbolic constant of SIGILL.
     */
    @Define()
    public final static native int SIGILL();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Terminal
     * interrupt signal.
     *
     *
     * @return the native symbolic constant of SIGINT.
     */
    @Define()

    public final static native int SIGINT();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i>Kill(cannot be
     * caught or ignored).
     *
     * @return the native symbolic constant of SIGKILL.
     */
    @Define()
    public final static native int SIGKILL();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Write on a pipe
     * with no one to read it.
     *
     * @return the native symbolic constant of SIGPIPE.
     */
    @Define()
    public final static native int SIGPIPE();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Terminal quit signal.
     *
     *
     * @return the native symbolic constant of SIGQUIT.
     */
    @Define()

    public final static native int SIGQUIT();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Invalid memory reference.
     *
     * @return the native symbolic constant of SIGSEGV.
     */
    @Define()
    public final static native int SIGSEGV();

    /**
     * <b>POSIX:</b><i>Stop the process</i> Stop executing(cannot be caught or
     * ignored).
     *
     * @return the native symbolic constant of SIGSTOP.
     */
    @Define()
    public final static native int SIGSTOP();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Termination
     * signal.
     *
     * @return the native symbolic constant of SIGTERM.
     */
    @Define()
    public final static native int SIGTERM();

    /**
     * <b>POSIX:</b><i>Stop the process</i> Terminal stop signal.
     *
     *
     * @return the native symbolic constant of SIGTSTP.
     */
    @Define()

    public final static native int SIGTSTP();

    /**
     * <b>POSIX:</b><i>Stop the process</i> Background process attempting read.
     *
     * @return the native symbolic constant of SIGTTIN.
     */
    @Define()
    public final static native int SIGTTIN();

    /**
     * <b>POSIX:</b><i>Stop the process</i> Background process attempting write.
     *
     *
     * @return the native symbolic constant of SIGTTOU.
     */
    @Define()

    public final static native int SIGTTOU();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> User -defined
     * signal 1.
     *
     *
     * @return the native symbolic constant of SIGUSR1.
     */
    @Define()

    public final static native int SIGUSR1();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> User -defined
     * signal 2.
     *
     * @return the native symbolic constant of SIGUSR2.
     */
    @Define()
    public final static native int SIGUSR2();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Pollable event.
     *
     * @return the native symbolic constant of SIGPOLL.
     * @throws NotDefinedException if SIGPOLL is not defined natively.
     */
    @Define()
    public final static native int SIGPOLL() throws NotDefinedException;

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Profiling timer
     * expired.
     *
     * @return the native symbolic constant of SIGPROF.
     */
    @Define()
    public final static native int SIGPROF();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Bad system call.
     *
     * @return the native symbolic constant of SIGSYS.
     */
    @Define()
    public final static native int SIGSYS();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> Trace /breakpoint trap.
     *
     * @return the native symbolic constant of SIGTRAP.
     */
    @Define()
    public final static native int SIGTRAP();

    /**
     * <b>POSIX:</b><i>Ignore the signal</i> High bandwidth data is available at
     * a socket.
     *
     * @return the native symbolic constant of SIGURG.
     */
    @Define()
    public final static native int SIGURG();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process</i> Virtual timer
     * expired.
     *
     * @return the native symbolic constant of SIGVTALRM.
     */
    @Define()
    public final static native int SIGVTALRM();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> CPU time limit exceeded.
     *
     * @return the native symbolic constant of SIGXCPU.
     */
    @Define()
    public final static native int SIGXCPU();

    /**
     * <b>POSIX:</b><i>Abnormal termination of the process with additional
     * actions</i> File size limit exceeded.
     *
     *
     * @return the native symbolic constant of SIGXFSZ.
     */
    @Define()
    public final static native int SIGXFSZ();

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * sigaction}</a>.
     *
     * @param <T>
     */
    public static class Sigaction<T extends OpaqueMemory32> extends Struct32 {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct sigaction natively.
         *
         * @return the native value sizeof(struct sigaction).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public static native int offsetof_Sa_mask();

        public Sigaction() {
            super(sizeof(), false);
            sa_mask = new Sigset_t(this, offsetof_Sa_mask());
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
        public final native int sa_flags();

        /**
         * Special flags
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @param sa_flags the value of sa_flags to be set natively.
         */
        public final native void sa_flags(int sa_flags);

        /**
         * Pointer to a signal-catching function or one of the SIG_IGN or
         * SIG_DFL.<b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @return the native value of sa_handler.
         */
        public final native CallNative_I_V sa_handler();

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
        public final Callback_I_V sa_handlerAsCallback_I_V() {
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

        public final native void sa_handler0(FunctionPtr_I_V sa_handler);

        public final void sa_handler(FunctionPtr_I_V sa_handler) {
            cachedHandlerOrAction = sa_handler;
            sa_handler0(sa_handler);
        }

        /**
         * Pointer to a signal-catching function
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * sigaction}</a>.
         *
         * @return the native value of sa_sigaction.
         */
        public final native CallNative_I_Mem_Mem_V sa_sigaction();

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
        public final Callback_I_Mem_Mem_V<Siginfo_t, T> sa_sigactionAsCallback_I_Mem_Mem_V() {
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

        public final native <T extends OpaqueMemory32> void sa_sigaction0(FunctionPtr_I_Mem_Mem_V<Siginfo_t, T> sa_sigaction);

        public final <T extends OpaqueMemory32> void sa_sigaction(FunctionPtr_I_Mem_Mem_V<Siginfo_t, T> sa_sigaction) {
            cachedHandlerOrAction = sa_sigaction;
            sa_sigaction0(sa_sigaction);
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
     * @return the native symbolic constant of SIG_BLOCK.
     */
    @Define()
    public final static native int SIG_BLOCK();

    /**
     * <b>POSIX:</b> The resulting set is the intersection of the current set
     * and the complement of the signal set pointed to by the argument set.
     *
     * @return the native symbolic constant of SIG_UNBLOCK.
     */
    @Define()
    public final static native int SIG_UNBLOCK();

    /**
     * <b>POSIX:</b> The resulting set is the signal set pointed to by the
     * argument set.
     *
     * @return the native symbolic constant of SIG_SETMASK.
     */
    @Define()
    public final static native int SIG_SETMASK();

    /**
     * <b>POSIX:</b> Do not generate SIGCHLD when children stop or stopped
     * children continue
     *
     *
     * @return the native symbolic constant of SA_NOCLDSTOP.
     */
    @Define()

    public final static native int SA_NOCLDSTOP();

    /**
     * <b>POSIX:</b> Causes signal delivery to occur on an alternate stack.
     *
     * @return the native symbolic constant of SA_ONSTACK.
     */
    @Define()
    public final static native int SA_ONSTACK();

    /**
     * <b>POSIX:</b> Causes signal dispositions to be set to SIG_DFL on entry to
     * signal handlers.
     *
     * @return the native symbolic constant of SA_RESETHAND.
     */
    @Define()
    public final static native int SA_RESETHAND();

    /**
     * <b>POSIX:</b> Causes certain functions to become restartable.
     *
     * @return the native symbolic constant of SA_RESTART.
     */
    @Define()
    public final static native int SA_RESTART();

    /**
     * <b>POSIX:</b> Causes extra information to be passed to signal handlers at
     * the time of receipt of a signal.
     *
     * @return the native symbolic constant of SA_SIGINFO.
     */
    @Define()
    public final static native int SA_SIGINFO();

    /**
     * <b>POSIX:</b> Causes implementations not to create zombie processes or
     * status information on child termination. See sigaction.
     *
     * @return the native symbolic constant of SA_NOCLDWAIT.
     */
    @Define()
    public final static native int SA_NOCLDWAIT();

    /**
     * <b>POSIX:</b> Causes signal not to be automatically blocked on entry to
     * signal handler.
     *
     * @return the native symbolic constant of SA_NODEFER.
     */
    @Define()
    public final static native int SA_NODEFER();

    /**
     * <b>POSIX:</b> Process is executing on an alternate signal stack.
     *
     * @return the native symbolic constant of SS_ONSTACK.
     */
    @Define()
    public final static native int SS_ONSTACK();

    /**
     * <b>POSIX:</b> Alternate signal stack is disabled.
     *
     * @return the native symbolic constant of SS_DISABLE.
     */
    @Define()
    public final static native int SS_DISABLE();

    /**
     * <b>POSIX:</b> Minimum stack size for a signal handler.
     *
     * @return the native symbolic constant of MINSIGSTKSZ.
     */
    @Define()
    public final static native int MINSIGSTKSZ();

    /**
     * <b>POSIX:</b> Default size in bytes for the alternate signal stack.
     *
     * @return the native symbolic constant of SIGSTKSZ.
     */
    @Define()
    public final static native int SIGSTKSZ();

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
     * ucontext_t}</a>.
     *
     */
    public static class Ucontext_t extends Struct32 {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct ucontext_t natively.
         *
         * @return the native value sizeof(struct ucontext_t).
         */
        @SizeOf
        public static native int sizeof() throws NoSuchNativeTypeException;

        @AlignOf
        public static native int alignof() throws NoSuchNativeTypeException;

        public static native int offsetof_Uc_sigmask() throws NoSuchNativeTypeException;

        public static native int offsetof_Uc_stack() throws NoSuchNativeTypeException;

        public static native int offsetof_Uc_mcontext() throws NoSuchNativeTypeException;

        public Ucontext_t() throws NoSuchNativeTypeException {
            this(false);
        }

        public Ucontext_t(boolean clearMem) throws NoSuchNativeTypeException {
            super(sizeof(), clearMem);
            uc_sigmask = new Sigset_t(this, offsetof_Uc_sigmask());
            uc_stack = new Stack_t(this, offsetof_Uc_stack());
            uc_mcontext = new Mcontext_t(this, offsetof_Uc_mcontext());
        }

        public Ucontext_t(NativeAddressHolder baseAddress) throws NoSuchNativeTypeException {
            super(baseAddress, sizeof());
            uc_sigmask = new Sigset_t(this, offsetof_Uc_sigmask());
            uc_stack = new Stack_t(this, offsetof_Uc_stack());
            uc_mcontext = new Mcontext_t(this, offsetof_Uc_mcontext());
        }

        /**
         * Pointer to the context that is resumed when this context returns.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * ucontext_t}</a>.
         *
         * @return the native value of uc_link.
         */
        private native NativeAddressHolder uc_link0() throws NoSuchNativeTypeException;

        /**
         * Pointer to the context that is resumed when this context returns.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * ucontext_t}</a>.
         *
         */
        public final Ucontext_t uc_link(OpaqueMemory32Producer<Ucontext_t, Ucontext_t> producer) throws NoSuchNativeTypeException {
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
            try {
                jsb.appendNativeAddressHolderMember("uc_link: ", uc_link0());
            } catch (NoSuchNativeTypeException nsnte) {
                //noop...
            }
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
    public static class Stack_t<T extends OpaqueMemory32> extends Struct32 {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct stack_t natively.
         *
         * @return the native value sizeof(struct stack_t).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        private Stack_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public Stack_t() {
            super(sizeof(), false);
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

        private native void ss_flags(int ss_flags);

        private native NativeAddressHolder ss_sp0();

        private native void ss_size(long sizeInBytes);

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
        public final native @size_t
        long ss_size();

        /**
         * Flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * stack_t}</a>.
         *
         * @return the native value of ss_flags.
         */
        public final native int ss_flags();

        private native void ss_sp(T ss_sp);

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
    public static class Siginfo_t<T extends OpaqueMemory32> extends Struct32 {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct siginfo_t natively.
         *
         * @return the native value sizeof(struct siginfo_t).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public static native int offsetof_Si_value();

        @SuppressWarnings("unchecked")
        public Siginfo_t() {
            super(sizeof(), false);
            si_value = new Sigval(this, offsetof_Si_value());
        }

        /**
         * Create a wrapper around some unknown mem - it will NOT be freed
         *
         * @param address
         */
        @SuppressWarnings("unchecked")
        public Siginfo_t(NativeAddressHolder address) {
            super(address, sizeof());
            si_value = new Sigval(this, offsetof_Si_value());
        }

        /**
         * Signal number.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_signo.
         */
        public final native int si_signo();

        /**
         * Signal code.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_code.
         */
        public final native int si_code();

        /**
         * If non-zero, an errno value associated with this signal, as described
         * in &lt;errno.h&gt;.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_errno.
         */
        public final native int si_errno();

        /**
         * Sending process ID.pid_t si_pid Sending process ID..
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_pid.
         */
        public final native @pid_t
        int si_pid();

        /**
         * Sending process ID.uid_t si_uid Real user ID of sending process.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_pid.
         */
        public final native @uid_t
        int si_uid();

        /**
         * Address of faulting instruction.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_addr.
         */
        public final native long si_addr();

        /**
         * Exit value or signal.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_status.
         */
        public final native int si_status();

        /**
         * Band event for SIGPOLL.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/signal.h.html">{@code structure
         * siginfo_t}</a>.
         *
         * @return the native value of si_band.
         */
        public final native long si_band() throws NoSuchNativeTypeMemberException;
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

    }

    /**
     * <b>POSIX:</b>{@link SIGILL} Illegal opcode.
     *
     * @return the native symbolic constant of ILL_ILLOPC.
     */
    @Define()
    public final static native int ILL_ILLOPC();

    /**
     * <b>POSIX:</b>{@link SIGILL} Illegal addressing mode.
     *
     * @return the native symbolic constant of ILL_ILLOPN.
     */
    @Define()
    public final static native int ILL_ILLOPN();

    /**
     * <b>POSIX:</b>{@link SIGILL} Illegal operand.
     *
     * @return the native symbolic constant of ILL_ILLADR.
     */
    @Define()
    public final static native int ILL_ILLADR();

    /**
     * <b>POSIX:</b>{@link SIGILL} Illegal trap.
     *
     * @return the native symbolic constant of ILL_ILLTRP.
     */
    @Define()
    public final static native int ILL_ILLTRP();

    /**
     * <b>POSIX:</b>{@link SIGILL} Privileged opcode.
     *
     * @return the native symbolic constant of ILL_PRVOPC.
     */
    @Define()
    public final static native int ILL_PRVOPC();

    /**
     * <b>POSIX:</b>{@link SIGILL} Privileged register.
     *
     * @return the native symbolic constant of ILL_PRVREG.
     */
    @Define()
    public final static native int ILL_PRVREG();

    /**
     * <b>POSIX:</b>{@link SIGILL} Coprocessor error.
     *
     * @return the native symbolic constant of ILL_COPROC.
     */
    @Define()
    public final static native int ILL_COPROC();

    /**
     * <b>POSIX:</b>{@link SIGILL} Internal stack error.
     *
     * @return the native symbolic constant of ILL_BADSTK.
     */
    @Define()
    public final static native int ILL_BADSTK();

    /**
     * <b>POSIX:</b>{@link SIGFPE} Integer divide by zero.
     *
     * @return the native symbolic constant of FPE_INTDIV.
     */
    @Define()
    public final static native int FPE_INTDIV();

    /**
     * <b>POSIX:</b>{@link SIGFPE} Integer overflow.
     *
     * @return the native symbolic constant of FPE_INTOVF.
     */
    @Define()
    public final static native int FPE_INTOVF();

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating -point divide by zero.
     *
     * @return the native symbolic constant of FPE_FLTDIV.
     */
    @Define()
    public final static native int FPE_FLTDIV();

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating-point overflow.
     *
     * @return the native symbolic constant of FPE_FLTOVF.
     */
    @Define()
    public final static native int FPE_FLTOVF();

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating-point underflow.
     *
     * @return the native symbolic constant of FPE_FLTUND.
     */
    @Define()
    public final static native int FPE_FLTUND();

    /**
     * <b>POSIX:</b>{@link SIGFPE} Floating-point inexact result.
     *
     * @return the native symbolic constant of FPE_FLTRES.
     */
    @Define()
    public final static native int FPE_FLTRES();

    /**
     * <b>POSIX:</b>{@link SIGFPE} Invalid floating-point operation.
     *
     * @return the native symbolic constant of FPE_FLTINV.
     */
    @Define()
    public final static native int FPE_FLTINV();

    /**
     * <b>POSIX:</b>{@link SIGFPE} Subscript out of range.
     *
     * @return the native symbolic constant of FPE_FLTSUB.
     */
    @Define()
    public final static native int FPE_FLTSUB();

    /**
     * <b>POSIX:</b>{@link SIGSEGV} Address not mapped to object.
     *
     * @return the native symbolic constant of SEGV_MAPERR.
     */
    @Define()
    public final static native int SEGV_MAPERR();

    /**
     * <b>POSIX:</b>{@link SIGSEGV} Invalid permissions for mapped object.
     *
     * @return the native symbolic constant of SEGV_ACCERR.
     */
    @Define()
    public final static native int SEGV_ACCERR();

    /**
     * <b>POSIX:</b>{@link SIGBUS} Invalid address alignment.
     *
     * @return the native symbolic constant of BUS_ADRALN.
     */
    @Define()

    public final static native int BUS_ADRALN();

    /**
     * <b>POSIX:</b>{@link SIGBUS} Nonexistent physical address.
     *
     * @return the native symbolic constant of BUS_ADRERR.
     */
    @Define()
    public final static native int BUS_ADRERR();

    /**
     * <b>POSIX:</b>{@link SIGBUS} Object-specific hardware error.
     *
     *
     * @return the native symbolic constant of BUS_OBJERR.
     */
    @Define()

    public final static native int BUS_OBJERR();

    /**
     * <b>POSIX:</b>{@link SIGTRAP} Process breakpoint.
     *
     * @return the native symbolic constant of TRAP_BRKPT.
     */
    @Define()

    public final static native int TRAP_BRKPT();

    /**
     * <b>POSIX:</b>{@link SIGTRAP} Process trace trap.
     *
     * @return the native symbolic constant of TRAP_TRACE.
     */
    @Define()
    public final static native int TRAP_TRACE();

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Child has exited.
     *
     * @return the native symbolic constant of CLD_EXITED.
     */
    @Define()

    public final static native int CLD_EXITED();

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Child has terminated abnormally and did not
     * create a core file.
     *
     *
     * @return the native symbolic constant of CLD_KILLED.
     */
    @Define()

    public final static native int CLD_KILLED();

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Child has terminated abnormally and created
     * a core file.
     *
     *
     * @return the native symbolic constant of CLD_DUMPED.
     */
    @Define()

    public final static native int CLD_DUMPED();

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Traced child has trapped.
     *
     *
     * @return the native symbolic constant of CLD_TRAPPED.
     */
    @Define()

    public final static native int CLD_TRAPPED();

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Child has stopped.
     *
     * @return the native symbolic constant of CLD_STOPPED.
     */
    @Define()

    public final static native int CLD_STOPPED();

    /**
     * <b>POSIX:</b>{@link SIGCHLD} Stopped child has continued.
     *
     * @return the native symbolic constant of CLD_CONTINUED.
     */
    @Define()
    public final static native int CLD_CONTINUED();

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Data input available.
     *
     * @return the native symbolic constant of POLL_IN.
     * @throws NotDefinedException if POLL_IN is not defined natively.
     */
    @Define()
    public final static native int POLL_IN() throws NotDefinedException;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Output buffers available.
     *
     *
     * @return the native symbolic constant of POLL_OUT.
     * @throws NotDefinedException if POLL_OUT is not defined natively.
     */
    @Define()
    public final static native int POLL_OUT() throws NotDefinedException;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Input message available.
     *
     *
     * @return the native symbolic constant of POLL_MSG.
     * @throws NotDefinedException if POLL_MSG is not defined natively.
     */
    @Define()
    public final static native int POLL_MSG() throws NotDefinedException;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} I/O error.
     *
     *
     * @return the native symbolic constant of POLL_ERR.
     * @throws NotDefinedException if POLL_ERR is not defined natively.
     */
    @Define()
    public final static native int POLL_ERR() throws NotDefinedException;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} High priority input available.
     *
     * @return the native symbolic constant of POLL_PRI.
     * @throws NotDefinedException if POLL_PRI is not defined natively.
     */
    @Define()
    public final static native int POLL_PRI() throws NotDefinedException;

    /**
     * <b>POSIX:</b>{@link SIGPOLL} Device disconnected.
     *
     * @return the native symbolic constant of POLL_HUP.
     * @throws NotDefinedException if POLL_HUP is not defined natively.
     */
    @Define()
    public final static native int POLL_HUP() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Signal sent by kill().
     *
     * @return the native symbolic constant of SI_USER.
     */
    @Define()

    public final static native int SI_USER();

    /**
     * <b>POSIX:</b> Signal sent by sigqueue().
     *
     * @return the native symbolic constant of SI_QUEUE.
     */
    @Define()
    public final static native int SI_QUEUE();

    /**
     * <b>POSIX:</b> Signal generated by expiration of a timer set by
     * timer_settime().
     *
     * @return the native symbolic constant of SI_TIMER.
     */
    @Define()
    public final static native int SI_TIMER();

    /**
     * <b>POSIX:</b> Signal generated by completion of an asynchronous I/O
     * request.
     *
     * @return the native symbolic constant of SI_ASYNCIO.
     * @throws NotDefinedException if SI_ASYNCIO is not defined natively.
     */
    @Define()
    public final static native int SI_ASYNCIO() throws NotDefinedException;

    /**
     * <b>POSIX:</b> Signal generated by arrival of a message on an empty
     * message.
     *
     * @return the native symbolic constant of SI_MESGQ.
     * @throws NotDefinedException if SI_MESGQ is not defined natively.
     */
    @Define()
    public final static native int SI_MESGQ() throws NotDefinedException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/kill.html">kill
     * - send a signal to a process or a group of processes</a>.
     *
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
    public final static native void psiginfo(Siginfo_t pinfo, String message) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native void pthread_kill(Pthread.Pthread_t thread, int sig) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native void pthread_sigmask(int how, Sigset_t set,
            Sigset_t oset) throws NativeErrorException;

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
    public final static native void sigaction(int sig, Sigaction act, Sigaction oact) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigaddset.html">sigaddset
     * - add a signal to a signal set</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void sigaddset(Sigset_t set, int signo) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigaltstack.html">sigaltstack
     * - set and get signal alternate stack context</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void sigaltstack(Stack_t ss, Stack_t oss) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigdelset.html">sigdelset
     * - delete a signal from a signal set</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void sigdelset(Sigset_t set, int signo) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigemptyset.html">sigemptyset
     * - initialize and empty a signal set</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void sigemptyset(Sigset_t set) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigfillset.html">sigfillset
     * - initialize and fill a signal set</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void sigfillset(Sigset_t set) throws NativeErrorException;

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
    public final static native boolean sigismember(Sigset_t set, int signo) throws NativeErrorException;

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
    public final static native CallNative_I_V signal(int sig, FunctionPtr_I_V func) throws NativeErrorException;

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
    public final static native void sigpending(Sigset_t set) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigprocmask.html">pthread_sigmask,
     * sigprocmask - examine and change blocked signals</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void sigprocmask(int how, Sigset_t set, Sigset_t oset) throws NativeErrorException;

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
    public final static native void sigqueue(@pid_t int pid, int signo, Sigval value) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native CallNative_I_V sigset(int sig, FunctionPtr_I_V disp) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sigsuspend.html">sigsuspend
     * - wait for a signal</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * is -1 an errno is other than EINTR.
     */
    public final static native void sigsuspend(Sigset_t sigmask) throws NativeErrorException;

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
    public final static native int sigtimedwait(Sigset_t set, Siginfo_t info,
            Timespec timeout) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native int sigwait(Sigset_t set) throws NativeErrorException;

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
    public final static native int sigwaitinfo(Sigset_t set, Siginfo_t info) throws NativeErrorException, NoSuchNativeMethodException;
}
