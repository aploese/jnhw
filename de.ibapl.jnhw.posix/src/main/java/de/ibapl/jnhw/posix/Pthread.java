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

import de.ibapl.jnhw.annotation.posix.sys.types.pthread_attr_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh__V___V;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__A_sI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI__A;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.posix.sys.Types;
import de.ibapl.jnhw.posix.util.methodhandles.JnhwMethodHandle_PthreadT_V;
import de.ibapl.jnhw.posix.util.methodhandles.JnhwMethodHandle_Sint_PthreadT;
import de.ibapl.jnhw.posix.util.methodhandles.JnhwMethodHandle_Sint_PthreadT_Adr;
import de.ibapl.jnhw.posix.util.methodhandles.JnhwMethodHandle_Sint_PthreadT_Adr_Adr;
import de.ibapl.jnhw.posix.util.methodhandles.JnhwMethodHandle_Sint_PthreadT_PthreadT;
import de.ibapl.jnhw.posix.util.methodhandles.JnhwMethodHandle_Sint_PthreadT_Sint;
import de.ibapl.jnhw.posix.util.methodhandles.JnhwMethodHandle_Sint_PthreadT_Sint_Adr;
import de.ibapl.jnhw.util.posix.LibrtLoader;
import de.ibapl.jnhw.util.posix.PosixDataType;
import java.io.IOException;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

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

    public static interface BsdDefines {

    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int PTHREAD_CANCEL_ASYNCHRONOUS = 0;
        public final static int PTHREAD_CANCEL_DEFERRED = 2;
        public final static int PTHREAD_CANCEL_DISABLE = 0;
        public final static int PTHREAD_CANCEL_ENABLE = 1;
        public final static int PTHREAD_EXPLICIT_SCHED = 2;
        public final static int PTHREAD_INHERIT_SCHED = 1;

    }

    public static interface FreeBsd_OpenBsd_Defines extends BsdDefines {

        public final static int PTHREAD_CANCEL_ASYNCHRONOUS = 2;
        public final static int PTHREAD_CANCEL_DEFERRED = 0;
        public final static int PTHREAD_CANCEL_DISABLE = 1;
        public final static int PTHREAD_CANCEL_ENABLE = 0;
        public final static int PTHREAD_EXPLICIT_SCHED = 0;
        public final static int PTHREAD_INHERIT_SCHED = 4;

    }

    public static interface FreeBsdDefines extends FreeBsd_OpenBsd_Defines {

    }

    public static interface LinuxDefines {

        public final static int PTHREAD_CANCEL_ASYNCHRONOUS = 1;
        public final static int PTHREAD_CANCEL_DEFERRED = 0;
        public final static int PTHREAD_CANCEL_DISABLE = 1;
        public final static int PTHREAD_CANCEL_ENABLE = 0;
        public final static int PTHREAD_EXPLICIT_SCHED = 1;
        public final static int PTHREAD_INHERIT_SCHED = 0;

    }

    public static interface OpenBsdDefines extends FreeBsd_OpenBsd_Defines {

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">{@code typedef
     * pthread_attr_t}</a>.
     *
     * @author aploese
     */
    @pthread_attr_t
    public final static class Pthread_attr_t extends Struct {

        public final static Alignment alignof;
        public final static int sizeof;

        static {

            switch (MultiarchTupelBuilder.getOS()) {
                case LINUX:
                    switch (MultiarchTupelBuilder.getArch()) {
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
                            throw new NoClassDefFoundError("No pthread.h linux defines for Pthread_attr_t " + MultiarchTupelBuilder.getMultiarch());
                    }
                    break;
                case DARWIN:
                    sizeof = 64;
                    break;
                case FREE_BSD:
                case OPEN_BSD:
                    sizeof = 8;
                    break;
                default:
                    throw new NoClassDefFoundError("No pthread.h OS defines for Pthread_attr_t " + MultiarchTupelBuilder.getMultiarch());
            }
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32:
                    alignof = Alignment.AT_4;
                    break;
                case LP64:
                    alignof = Alignment.AT_8;
                    break;
                default:
                    throw new NoClassDefFoundError("No pthread.h defines for Pthread_attr_t" + MultiarchTupelBuilder.getMultiarch());
            }

        }

        public final static Pthread_attr_t allocateNative(MemorySession ms) {
            return new Pthread_attr_t(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public final static Pthread_attr_t ofAddress(MemoryAddress address, MemorySession ms) {
            return new Pthread_attr_t(MemorySegment.ofAddress(address, sizeof, ms), 0);
        }

        public Pthread_attr_t(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Pthread_attr_t.sizeof);
        }

        public Pthread_attr_t(MemoryAddress baseAddress, MemorySession ms) {
            super(baseAddress, ms, Pthread_attr_t.sizeof);
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">{@code typedef
     * pthread_t}</a>.
     *
     * @author aploese
     */
    public static final class Pthread_t extends OpaqueMemory {

        public final static Alignment alignof = PosixDataType.pthread_t.ALIGN_OF;
        public final static int sizeof = PosixDataType.pthread_t.SIZE_OF;

        public final static Pthread_t allocateNative(MemorySession ms) {
            return new Pthread_t(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public final static Pthread_t ofAddress(MemoryAddress address, MemorySession ms) {
            return new Pthread_t(MemorySegment.ofAddress(address, sizeof, ms), 0);
        }

        public static Pthread_t wrap(long value, MemorySession ms) {
            Pthread_t result = Pthread_t.allocateNative(ms);
            result.asUint64_t(value);
            return result;
        }

        public Pthread_t(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Pthread_t.sizeof);
        }

        public Pthread_t(MemoryAddress baseAddress, MemorySession ms) {
            super(baseAddress, ms, Pthread_t.sizeof);
        }

        public long asUint64_t() {
            if (PosixDataType.pthread_t == BaseDataType.uint64_t) {
                return MEM_ACCESS.uint64_t(memorySegment, 0);
            } else {
                throw new IllegalStateException("pthread_t is not uint64_t but: " + PosixDataType.pthread_t);
            }
        }

        public void asUint64_t(long value) {
            if (PosixDataType.pthread_t == BaseDataType.uint64_t) {
                MEM_ACCESS.uint64_t(memorySegment, 0, value);
            } else {
                throw new IllegalStateException("pthread_t is not uint64_t but: " + PosixDataType.pthread_t);
            }
        }

        @Override
        public String nativeToString() {
            switch (PosixDataType.pthread_t) {
                case uint64_t:
                    return MEM_ACCESS.uint64_t_nativeToString(memorySegment, 0);
                default:
                    throw new AssertionError();
            }
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            sb.append(nativeToString());
        }

        @Override
        public BaseDataType getBaseDataType() {
            return PosixDataType.pthread_t;
        }

    }

    private final static JnhwMethodHandle_PthreadT_V pthread_self = JnhwMethodHandle_PthreadT_V.of(
            "pthread_self",
            PosixDataType.pthread_t);

    private final static JnhwMethodHandle_Sint_PthreadT pthread_cancel = JnhwMethodHandle_Sint_PthreadT.of(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "pthread_cancel",
            BaseDataType.C_int,
            PosixDataType.pthread_t);

    private final static JnhwMethodHandle_Sint_PthreadT_PthreadT pthread_equal = JnhwMethodHandle_Sint_PthreadT_PthreadT.of(
            "pthread_equal",
            BaseDataType.C_int,
            PosixDataType.pthread_t,
            PosixDataType.pthread_t);

    private final static JnhwMethodHandle_Sint_PthreadT_Adr pthread_getcpuclockid = JnhwMethodHandle_Sint_PthreadT_Adr.ofOrNull(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "pthread_getcpuclockid",
            BaseDataType.C_int,
            PosixDataType.pthread_t,
            BaseDataType.C_pointer);

    private final static JnhwMethodHandle_Sint_PthreadT_Adr_Adr pthread_getschedparam = JnhwMethodHandle_Sint_PthreadT_Adr_Adr.of(
            "pthread_getschedparam",
            BaseDataType.C_int,
            PosixDataType.pthread_t,
            BaseDataType.C_pointer,
            BaseDataType.C_pointer);

    private final static JnhwMh_sI__sI__A pthread_setcancelstate = JnhwMh_sI__sI__A.of(
            "pthread_setcancelstate",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int_pointer);

    private final static JnhwMh_sI__sI__A pthread_setcanceltype = JnhwMh_sI__sI__A.of(
            "pthread_setcanceltype",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int_pointer);

    private final static JnhwMh__V___V pthread_testcancel = JnhwMh__V___V.of(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "pthread_testcancel");

    private final static JnhwMethodHandle_Sint_PthreadT_Sint_Adr pthread_setschedparam = JnhwMethodHandle_Sint_PthreadT_Sint_Adr.of(
            "pthread_setschedparam",
            BaseDataType.C_int,
            PosixDataType.pthread_t,
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_sI___A pthread_attr_destroy = JnhwMh_sI___A.of(
            "pthread_attr_destroy",
            BaseDataType.C_int,
            PosixDataType.pthread_attr_t_pointer);

    private final static JnhwMh_sI___A pthread_attr_init = JnhwMh_sI___A.of(
            "pthread_attr_init",
            BaseDataType.C_int,
            PosixDataType.pthread_attr_t_pointer);

    private final static JnhwMh_sI__A_sI pthread_attr_setinheritsched = JnhwMh_sI__A_sI.of(
            "pthread_attr_setinheritsched",
            BaseDataType.C_int,
            PosixDataType.pthread_attr_t_pointer,
            BaseDataType.C_int);

    private final static JnhwMh_sI___A__A pthread_attr_getinheritsched = JnhwMh_sI___A__A.of(
            "pthread_attr_getinheritsched",
            BaseDataType.C_int,
            PosixDataType.pthread_attr_t_pointer,
            BaseDataType.C_int_pointer);

    private final static JnhwMethodHandle_Sint_PthreadT_Sint pthread_setschedprio = JnhwMethodHandle_Sint_PthreadT_Sint.ofOrNull(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "pthread_setschedprio",
            BaseDataType.C_int,
            PosixDataType.pthread_t,
            BaseDataType.C_int);

    private final static JnhwMh_sI___A__A pthread_attr_getschedparam = JnhwMh_sI___A__A.of(
            "pthread_attr_getschedparam",
            BaseDataType.C_int,
            PosixDataType.pthread_attr_t_pointer,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI___A__A pthread_attr_setschedparam = JnhwMh_sI___A__A.of(
            "pthread_attr_setschedparam",
            BaseDataType.C_int,
            PosixDataType.pthread_attr_t_pointer,
            BaseDataType.C_struct_pointer);

    public final static boolean HAVE_PTHREAD_H;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_CANCEL_ASYNCHRONOUS;

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
    public final static int PTHREAD_EXPLICIT_SCHED;

    /**
     * <b>POSIX.TPS:</b>
     *
     */
    @Define
    public final static int PTHREAD_INHERIT_SCHED;

    /**
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                HAVE_PTHREAD_H = true;
                PTHREAD_CANCEL_ASYNCHRONOUS = LinuxDefines.PTHREAD_CANCEL_ASYNCHRONOUS;
                PTHREAD_CANCEL_DEFERRED = LinuxDefines.PTHREAD_CANCEL_DEFERRED;
                PTHREAD_CANCEL_DISABLE = LinuxDefines.PTHREAD_CANCEL_DISABLE;
                PTHREAD_CANCEL_ENABLE = LinuxDefines.PTHREAD_CANCEL_ENABLE;
                PTHREAD_EXPLICIT_SCHED = LinuxDefines.PTHREAD_EXPLICIT_SCHED;
                PTHREAD_INHERIT_SCHED = LinuxDefines.PTHREAD_INHERIT_SCHED;
                break;
            case DARWIN:
                HAVE_PTHREAD_H = true;
                PTHREAD_CANCEL_ASYNCHRONOUS = DarwinDefines.PTHREAD_CANCEL_ASYNCHRONOUS;
                PTHREAD_CANCEL_DEFERRED = DarwinDefines.PTHREAD_CANCEL_DEFERRED;
                PTHREAD_CANCEL_DISABLE = DarwinDefines.PTHREAD_CANCEL_DISABLE;
                PTHREAD_CANCEL_ENABLE = DarwinDefines.PTHREAD_CANCEL_ENABLE;
                PTHREAD_EXPLICIT_SCHED = DarwinDefines.PTHREAD_EXPLICIT_SCHED;
                PTHREAD_INHERIT_SCHED = DarwinDefines.PTHREAD_INHERIT_SCHED;
                break;
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_PTHREAD_H = true;
                PTHREAD_CANCEL_ASYNCHRONOUS = FreeBsd_OpenBsd_Defines.PTHREAD_CANCEL_ASYNCHRONOUS;
                PTHREAD_CANCEL_DEFERRED = FreeBsd_OpenBsd_Defines.PTHREAD_CANCEL_DEFERRED;
                PTHREAD_CANCEL_DISABLE = FreeBsd_OpenBsd_Defines.PTHREAD_CANCEL_DISABLE;
                PTHREAD_CANCEL_ENABLE = FreeBsd_OpenBsd_Defines.PTHREAD_CANCEL_ENABLE;
                PTHREAD_EXPLICIT_SCHED = FreeBsd_OpenBsd_Defines.PTHREAD_EXPLICIT_SCHED;
                PTHREAD_INHERIT_SCHED = FreeBsd_OpenBsd_Defines.PTHREAD_INHERIT_SCHED;
                break;
            default:
                throw new NoClassDefFoundError("No pthread.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_destroy.html">pthread_attr_destroy,
     * pthread_attr_init - destroy and initialize the thread attributes
     * object</a>.
     */
    public final static void pthread_attr_destroy(Pthread_attr_t attr) throws NativeErrorException {
        if (pthread_attr_destroy.invoke_sI___P(attr) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_getinheritsched.html">pthread_attr_getinheritsched,
     * pthread_attr_setinheritsched - get and set the inheritsched attribute
     * (REALTIME THREADS)</a>.
     *
     * @param attr
     *
     * @param inheritsched.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void pthread_attr_getinheritsched(Pthread_attr_t attr, Int32_t inheritsched) throws NativeErrorException {
        if (pthread_attr_getinheritsched.invoke_sI___P__P(attr, inheritsched) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_getschedparam.html">pthread_attr_getschedparam,
     * pthread_attr_setschedparam - get and set the schedparam attribute</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void pthread_attr_getschedparam(Pthread_attr_t attr, Sched.Sched_param param) throws NativeErrorException {
        if (pthread_attr_getschedparam.invoke_sI___P__P(attr, param) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_destroy.html">pthread_attr_destroy,
     * pthread_attr_init - destroy and initialize the thread attributes
     * object</a>.
     */
    public final static void pthread_attr_init(Pthread_attr_t attr) throws NativeErrorException {
        if (pthread_attr_init.invoke_sI___P(attr) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

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
        if (pthread_attr_setinheritsched.invoke_sI__P_sI(attr, inheritsched) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_attr_setschedparam.html">pthread_attr_getschedparam,
     * pthread_attr_setschedparam - get and set the schedparam attribute</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void pthread_attr_setschedparam(Pthread_attr_t attr, Sched.Sched_param param) throws NativeErrorException {
        if (pthread_attr_setschedparam.invoke_sI___P__P(attr, param) != 0) {
            throw new NativeErrorException(Errno.errno());
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
        if (pthread_cancel.invokeExact(thread) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_equal.html">pthread_equal
     * - pthread_equal - compare thread IDs</a>.
     */
    public final static boolean pthread_equal(Pthread_t t1, Pthread_t t2) {
        return pthread_equal.invokeExact(t1, t2) != 0;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_getcpuclockid.html">pthread_getcpuclockid
     * - access a thread CPU-time clock (ADVANCED REALTIME THREADS)</a>.
     *
     * @param thread_id in
     * @param clock_id out
     * @throws NoSuchNativeMethodException if the method pthread_getcpuclockid
     * is not available natively.
     */
    public final static void pthread_getcpuclockid(Pthread_t thread_id, Types.Clockid_t clock_id) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (pthread_getcpuclockid.invokeExact(thread_id, clock_id) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (pthread_getcpuclockid == null) {
                throw new NoSuchNativeMethodException("pthread_getcpuclockid");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_getschedparam.html">pthread_getschedparam,
     * pthread_setschedparam - dynamic thread scheduling parameters access
     * (REALTIME THREADS)</a>.
     *
     *
     * @param policy
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void pthread_getschedparam(Pthread_t thread, Int32_t policy, Sched.Sched_param param) throws NativeErrorException {
        if (pthread_getschedparam.invokeExact(thread, policy, param) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /** <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_self.html">pthread_self
     * - get the calling thread ID</a>.
     *
     * @param ms
     * @return
     */
    public final static Pthread_t pthread_self(MemorySession ms) {
        return pthread_self.invokeExact(ms);
    }

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_setcancelstate.html">pthread_setcancelstate,
     * pthread_setcanceltype, pthread_testcancel - set cancelability state</a>.
     *
     * TODO TEST CRASHES
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    final static void pthread_setcancelstate(int state, Int32_t oldstate) throws NativeErrorException {
        if (pthread_setcancelstate.invoke_sI__sI__P(state, oldstate) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX.TPS:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/pthread_setcanceltype.html">pthread_setcancelstate,
     * pthread_setcanceltype, pthread_testcancel - set cancelability state</a>.
     *
     * TODO TEST CRASHES
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @return oldtype - the 2. argument int *oldtype.
     */
    final static void pthread_setcanceltype(int type, Int32_t oldtype) throws NativeErrorException {
        if (pthread_setcanceltype.invoke_sI__sI__P(type, oldtype) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

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
        if (pthread_setschedparam.invokeExact(thread, policy, param) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

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
        try {
            if (pthread_setschedprio.invokeExact(thread, prio) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (pthread_setschedprio == null) {
                throw new NoSuchNativeMethodException("pthread_setschedprio");
            } else {
                throw npe;
            }
        }
    }

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
    final static void pthread_testcancel() throws NativeErrorException {
        pthread_testcancel.invoke__V___V();
    }

}
