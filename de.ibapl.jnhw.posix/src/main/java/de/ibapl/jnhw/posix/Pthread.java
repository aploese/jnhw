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

import de.ibapl.jnhw.annotation.posix.sys.types.clockid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.pthread_attr_t;
import de.ibapl.jnhw.annotation.posix.sys.types.pthread_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.io.IOException;

/**
 * Wrapper around the {@code <pthread.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">pthread.h
 * - threads</a>.
 *
 * @author aploese
 */
@Include("#include <pthread.h>")
public class Pthread {

    public static interface LinuxDefines {

        public final static int PTHREAD_EXPLICIT_SCHED = 1;
        public final static int PTHREAD_INHERIT_SCHED = 0;
        public final static int PTHREAD_CANCEL_DISABLE = 1;
        public final static int PTHREAD_CANCEL_ENABLE = 0;
        public final static int PTHREAD_CANCEL_DEFERRED = 0;
        public final static int PTHREAD_CANCEL_ASYNCHRONOUS = 1;

    }

    public static interface BsdDefines {

        public final static int PTHREAD_EXPLICIT_SCHED = 0;
        public final static int PTHREAD_INHERIT_SCHED = 4;
        public final static int PTHREAD_CANCEL_DISABLE = 1;
        public final static int PTHREAD_CANCEL_ENABLE = 0;
        public final static int PTHREAD_CANCEL_DEFERRED = 0;
        public final static int PTHREAD_CANCEL_ASYNCHRONOUS = 2;

    }

    public static interface FreeBsdDefines extends BsdDefines {

    }

    public static interface OpenBsdDefines extends BsdDefines {

    }

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
        switch (LibJnhwPosixLoader.getLoadResult().multiarchInfo.getOS()) {
            case LINUX:
                HAVE_PTHREAD_H = true;
                PTHREAD_CANCEL_ASYNCHRONOUS = LinuxDefines.PTHREAD_CANCEL_ASYNCHRONOUS;
                PTHREAD_CANCEL_DEFERRED = LinuxDefines.PTHREAD_CANCEL_DEFERRED;
                PTHREAD_CANCEL_DISABLE = LinuxDefines.PTHREAD_CANCEL_DISABLE;
                PTHREAD_CANCEL_ENABLE = LinuxDefines.PTHREAD_CANCEL_ENABLE;
                PTHREAD_EXPLICIT_SCHED = LinuxDefines.PTHREAD_EXPLICIT_SCHED;
                PTHREAD_INHERIT_SCHED = LinuxDefines.PTHREAD_INHERIT_SCHED;
                break;
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_PTHREAD_H = true;
                PTHREAD_CANCEL_ASYNCHRONOUS = BsdDefines.PTHREAD_CANCEL_ASYNCHRONOUS;
                PTHREAD_CANCEL_DEFERRED = BsdDefines.PTHREAD_CANCEL_DEFERRED;
                PTHREAD_CANCEL_DISABLE = BsdDefines.PTHREAD_CANCEL_DISABLE;
                PTHREAD_CANCEL_ENABLE = BsdDefines.PTHREAD_CANCEL_ENABLE;
                PTHREAD_EXPLICIT_SCHED = BsdDefines.PTHREAD_EXPLICIT_SCHED;
                PTHREAD_INHERIT_SCHED = BsdDefines.PTHREAD_INHERIT_SCHED;
                break;
            default:
                throw new NoClassDefFoundError("No pthread.h OS defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
        }
    }

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_EXPLICIT_SCHED;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_INHERIT_SCHED;

    public final static boolean HAVE_PTHREAD_H;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_CANCEL_DISABLE;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_CANCEL_ENABLE;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_CANCEL_DEFERRED;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_CANCEL_ASYNCHRONOUS;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_self.html">pthread_self
     * - get the calling thread ID</a>.
     */
    public final static Pthread_t pthread_self() {
        final Pthread_t result = new Pthread_t();
        pthread_self(AbstractNativeMemory.getAddress(result));
        return result;
    }

    private static native void pthread_self(long result);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_equal.html">pthread_equal
     * - pthread_equal - compare thread IDs</a>.
     */
    public final static boolean pthread_equal(Pthread_t t1, Pthread_t t2) {
        return pthread_equal(AbstractNativeMemory.getAddress(t1), AbstractNativeMemory.getAddress(t2));
    }

    public final static native boolean pthread_equal(long ptrT1, long ptrT2);

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_getinheritsched.html">pthread_attr_getinheritsched,
     * pthread_attr_setinheritsched - get and set the inheritsched attribute
     * (REALTIME THREADS)</a>.
     *
     * @param attr
     *
     * @return the value of the native inheritsched arg.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int pthread_attr_getinheritsched(Pthread_attr_t attr) throws NativeErrorException {
        return pthread_attr_getinheritsched(AbstractNativeMemory.getAddress(attr));
    }

    protected static native int pthread_attr_getinheritsched(long ptrAttr) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_getschedparam.html">pthread_attr_getschedparam,
     * pthread_attr_setschedparam - get and set the schedparam attribute</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void pthread_attr_getschedparam(Pthread_attr_t attr, Sched.Sched_param param) throws NativeErrorException {
        pthread_attr_getschedparam(AbstractNativeMemory.getAddress(attr), AbstractNativeMemory.getAddress(param));
    }

    private static native void pthread_attr_getschedparam(long ptrAttr, long ptrParam) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_setinheritsched.html">pthread_attr_getinheritsched,
     * pthread_attr_setinheritsched - get and set the inheritsched attribute
     * (REALTIME THREADS)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void pthread_attr_setinheritsched(Pthread_attr_t attr, int inheritsched) throws NativeErrorException {
        pthread_attr_setinheritsched(AbstractNativeMemory.getAddress(attr), inheritsched);
    }

    private static native void pthread_attr_setinheritsched(long ptrAttr, int inheritsched) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_setschedparam.html">pthread_attr_getschedparam,
     * pthread_attr_setschedparam - get and set the schedparam attribute</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void pthread_attr_setschedparam(Pthread_attr_t attr, Sched.Sched_param param) throws NativeErrorException {
        pthread_attr_setschedparam(AbstractNativeMemory.getAddress(attr), AbstractNativeMemory.getAddress(param));
    }

    private static native void pthread_attr_setschedparam(long ptrAttr, long ptrParam) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_getschedparam.html">pthread_getschedparam,
     * pthread_setschedparam - dynamic thread scheduling parameters access
     * (REALTIME THREADS)</a>.
     *
     *
     * @param policyIN the policy as input - the result is the output
     *
     * @return the policy
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int pthread_getschedparam(Pthread_t thread, Sched.Sched_param param) throws NativeErrorException {
        return pthread_getschedparam(AbstractNativeMemory.getAddress(thread), AbstractNativeMemory.getAddress(param));
    }

    private static native int pthread_getschedparam(long ptrThread, long ptrParam) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_setschedparam.html">pthread_getschedparam,
     * pthread_setschedparam - dynamic thread scheduling parameters access
     * (REALTIME THREADS)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void pthread_setschedparam(Pthread_t thread, int policy, Sched.Sched_param param) throws NativeErrorException {
        pthread_setschedparam(AbstractNativeMemory.getAddress(thread), policy, AbstractNativeMemory.getAddress(param));
    }

    private static native void pthread_setschedparam(long ptrThread, int policy, long ptrParam) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_setschedprio.html">pthread_setschedprio
     * - dynamic thread scheduling parameters access (REALTIME THREADS)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method pthread_setschedprio is
     * not available natively.
     */
    public final static void pthread_setschedprio(Pthread_t thread, int prio) throws NativeErrorException, NoSuchNativeMethodException {
        pthread_setschedprio(AbstractNativeMemory.getAddress(thread), prio);
    }

    private static native void pthread_setschedprio(long ptrThread, int prio) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_getcpuclockid.html">pthread_getcpuclockid
     * - access a thread CPU-time clock (ADVANCED REALTIME THREADS)</a>.
     *
     * @param thread_id in
     * @return clock_id out
     */
    @clockid_t
    public final static int pthread_getcpuclockid(Pthread_t thread_id) throws NativeErrorException {
        return pthread_getcpuclockid(AbstractNativeMemory.getAddress(thread_id));
    }

    private static native int pthread_getcpuclockid(long ptrThread_id) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_destroy.html">pthread_attr_destroy,
     * pthread_attr_init - destroy and initialize the thread attributes
     * object</a>.
     */
    public final static void pthread_attr_destroy(Pthread_attr_t attr) {
        pthread_attr_destroy(AbstractNativeMemory.getAddress(attr));
    }

    private static native void pthread_attr_destroy(long ptrAttr);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_destroy.html">pthread_attr_destroy,
     * pthread_attr_init - destroy and initialize the thread attributes
     * object</a>.
     */
    public final static void pthread_attr_init(Pthread_attr_t attr) {
        pthread_attr_init(AbstractNativeMemory.getAddress(attr));
    }

    private static native void pthread_attr_init(long attr);

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">{@code typedef
     * pthread_attr_t}</a>.
     *
     * @author aploese
     */
    @pthread_attr_t
    public static final class Pthread_attr_t extends Struct32 {

        public final static Alignment alignof;
        public final static int sizeof;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();

            switch (LibJnhwPosixLoader.getLoadResult().multiarchInfo.getOS()) {
                case LINUX:
                    switch (LibJnhwPosixLoader.getLoadResult().multiarchInfo.getArch()) {
                        case AARCH64:
                            sizeof = 64;
                            break;
                        case ARM:
                        case I386:
                        case MIPS:
                            sizeof = 36;
                            break;
                        case MIPS_64:
                        case POWER_PC_64:
                        case RISC_V_64:
                        case S390_X:
                        case X86_64:
                            sizeof = 56;
                            break;
                        default:
                            throw new NoClassDefFoundError("No pthread.h linux defines for Pthread_attr_t " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                    }
                    break;
                case FREE_BSD:
                case OPEN_BSD:
                    sizeof = 8;
                    break;
                default:
                    throw new NoClassDefFoundError("No pthread.h OS defines for Pthread_attr_t " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
            }
            switch (LibJnhwPosixLoader.getLoadResult().multiarchInfo.getSizeOfPointer()) {
                case _32_BIT:
                    alignof = Alignment.AT_4;
                    break;
                case _64_BIT:
                    alignof = Alignment.AT_8;
                    break;
                default:
                    throw new NoClassDefFoundError("No pthread.h defines for Pthread_attr_t" + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
            }

        }

        public Pthread_attr_t() {
            this(null, 0, SetMem.DO_NOT_SET);
        }

        public Pthread_attr_t(NativeAddressHolder baseAddress) {
            super(baseAddress, Pthread_attr_t.sizeof);
        }

        public Pthread_attr_t(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, Pthread_attr_t.sizeof, setMem);
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">{@code typedef
     * pthread_t}</a>.
     *
     * @author aploese
     */
    @pthread_t
    public static final class Pthread_t extends Struct32 {

        public final static Alignment alignof;
        public final static int sizeof;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();

            switch (LibJnhwPosixLoader.getLoadResult().multiarchInfo.getSizeOfPointer()) {
                case _32_BIT:
                    alignof = Alignment.AT_4;
                    sizeof = 4;
                    break;
                case _64_BIT:
                    alignof = Alignment.AT_8;
                    sizeof = 8;
                    ;
                    break;
                default:
                    throw new NoClassDefFoundError("No pthread.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
            }
        }

        public Pthread_t() {
            this(null, 0, SetMem.DO_NOT_SET);
        }

        public Pthread_t(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, Pthread_t.sizeof, setMem);
        }

        public Pthread_t(NativeAddressHolder baseAddress) {
            super(baseAddress, Pthread_t.sizeof);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            sb.append(nativeToString());
        }

        @Override
        public String nativeToString() {
            return MEM_ACCESS.uintptr_t_AsHex(this, 0);
        }

    }

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_cancel.html">pthread_cancel
     * - cancel execution of a thread</a>.
     *
     * TEST CRASHES
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    final static void pthread_cancel(Pthread_t thread) throws NativeErrorException {
        pthread_cancel(AbstractNativeMemory.getAddress(thread));
    }

    private static native void pthread_cancel(long thread) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_testcancel.html">pthread_setcancelstate,
     * pthread_setcanceltype, pthread_testcancel - set cancelability state</a>.
     *
     * TEST CRASHES
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    final static native void pthread_testcancel() throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_setcancelstate.html">pthread_setcancelstate,
     * pthread_setcanceltype, pthread_testcancel - set cancelability state</a>.
     *
     * TEST CRASHES
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @return oldstate - the 2. argument int *oldstate.
     */
    final static native int pthread_setcancelstate(int state) throws NativeErrorException;

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_setcanceltype.html">pthread_setcancelstate,
     * pthread_setcanceltype, pthread_testcancel - set cancelability state</a>.
     *
     * TEST CRASHES
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @return oldtype - the 2. argument int *oldtype.
     */
    final static native int pthread_setcanceltype(int type) throws NativeErrorException;

}
