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
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh__V___V;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.util.posix.PosixDataType;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI_sI__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI__sI__A;

/**
 * Wrapper around the {@code <pthread.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">sched.h
 * - execution scheduling</a>.
 *
 * @author aploese
 */
@Include("#include <sched.h>")
public class Sched {

    public static interface BsdDefines {

    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int SCHED_FIFO = 4;
        public final static int SCHED_OTHER = 1;
        public final static int SCHED_RR = 2;

    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int SCHED_FIFO = 1;
        public final static int SCHED_OTHER = 2;
        public final static int SCHED_RR = 3;

    }

    public static interface LinuxDefines {

        public final static int SCHED_FIFO = 1;
        public final static int SCHED_OTHER = 0;
        public final static int SCHED_RR = 2;
    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int SCHED_FIFO = 1;
        public final static int SCHED_OTHER = 2;
        public final static int SCHED_RR = 3;

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
     * sched_param}</a>.
     *
     */
    public final static class Sched_param extends Struct {

        public final static Alignment alignof;
        public final static long offsetof_Sched_priority;
        public final static long offsetof_Sched_ss_init_budget;
        public final static long offsetof_Sched_ss_low_priority;
        public final static long offsetof_Sched_ss_max_repl;
        public final static long offsetof_Sched_ss_repl_period;
        public final static int sizeof;

        static {
            switch (MultiarchTupelBuilder.getOS()) {
                case DARWIN:
                    sizeof = 8;
                    break;
                default:
                    sizeof = 4;
            }
            alignof = Alignment.AT_4;
            offsetof_Sched_priority = 0;
            offsetof_Sched_ss_init_budget = -1;
            offsetof_Sched_ss_low_priority = -1;
            offsetof_Sched_ss_max_repl = -1;
            offsetof_Sched_ss_repl_period = -1;
        }

        public final static Sched_param allocateNative(ResourceScope scope) {
            return new Sched_param(MemorySegment.allocateNative(sizeof, scope), 0);
        }

        /**
         * Initial budget for sporadic server.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         */
        private final Time.Timespec sched_ss_init_budget;

        /**
         * Replenishment period for sporadic server.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         */
        private final Time.Timespec sched_ss_repl_period;

        public Sched_param(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Sched_param.sizeof);
            sched_ss_init_budget = Sched_param.offsetof_Sched_ss_init_budget == -1 ? null : new Time.Timespec(this.memorySegment, Sched_param.offsetof_Sched_ss_init_budget);
            sched_ss_repl_period = Sched_param.offsetof_Sched_ss_repl_period == -1 ? null : new Time.Timespec(this.memorySegment, Sched_param.offsetof_Sched_ss_repl_period);
        }

        /**
         * Process or thread execution scheduling priority.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         * @return the native value of sched_priority.
         */
        public int sched_priority() {
            return MEM_ACCESS.int32_t(memorySegment, Sched_param.offsetof_Sched_priority);
        }

        /**
         * Process or thread execution scheduling priority.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         * @param sched_priority the value of sched_priority to be set natively.
         */
        public void sched_priority(int sched_priority) {
            MEM_ACCESS.int32_t(memorySegment, Sched_param.offsetof_Sched_priority, sched_priority);
        }

        public Time.Timespec sched_ss_init_budget() throws NoSuchNativeTypeMemberException {
            if (sched_ss_init_budget == null) {
                throw new NoSuchNativeTypeMemberException("sched_param", "sched_ss_init_budget");
            } else {
                return sched_ss_init_budget;
            }
        }

        /**
         * Low scheduling priority for sporadic server.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         * @return the native value of sched_ss_low_priority.
         *
         * @throws NoSuchNativeTypeMemberException if sched_ss_low_priority does
         * not exists.
         */
        public int sched_ss_low_priority() throws NoSuchNativeTypeMemberException {
            if (Sched_param.offsetof_Sched_ss_low_priority == -1) {
                throw new NoSuchNativeTypeMemberException("sched_param", "sched_ss_low_priority");
            }
            return MEM_ACCESS.int32_t(memorySegment, Sched_param.offsetof_Sched_ss_low_priority);
        }

        /**
         * Low scheduling priority for sporadic server.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         * @param sched_ss_low_priority the value of sched_ss_low_priority to be
         * set natively.
         *
         * @throws NoSuchNativeTypeMemberException if sched_ss_low_priority does
         * not exists.
         */
        public void sched_ss_low_priority(int sched_ss_low_priority) throws NoSuchNativeTypeMemberException {
            if (Sched_param.offsetof_Sched_ss_low_priority == -1) {
                throw new NoSuchNativeTypeMemberException("sched_param", "sched_ss_low_priority");
            }
            MEM_ACCESS.int32_t(memorySegment, Sched_param.offsetof_Sched_ss_low_priority, sched_ss_low_priority);
        }

        /**
         * Maximum pending replenishments for sporadic server.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         * @return the native value of sched_ss_max_repl.
         *
         * @throws NoSuchNativeTypeMemberException if sched_ss_max_repl does not
         * exists.
         */
        public int sched_ss_max_repl() throws NoSuchNativeTypeMemberException {
            if (Sched_param.offsetof_Sched_ss_max_repl == -1) {
                throw new NoSuchNativeTypeMemberException("sched_param", "sched_ss_max_repl");
            }
            return MEM_ACCESS.int32_t(memorySegment, Sched_param.offsetof_Sched_ss_max_repl);
        }

        /**
         * Maximum pending replenishments for sporadic server.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         * @param sched_ss_max_repl the value of sched_ss_max_repl to be set
         * natively.
         *
         * @throws NoSuchNativeTypeMemberException if sched_ss_max_repl does not
         * exists.
         */
        public void sched_ss_max_repl(int sched_ss_max_repl) throws NoSuchNativeTypeMemberException {
            if (Sched_param.offsetof_Sched_ss_max_repl == -1) {
                throw new NoSuchNativeTypeMemberException("sched_param", "sched_ss_max_repl");
            }
            MEM_ACCESS.int32_t(memorySegment, Sched_param.offsetof_Sched_ss_max_repl, sched_ss_max_repl);
        }

        public Time.Timespec sched_ss_repl_period() throws NoSuchNativeTypeMemberException {
            if (sched_ss_repl_period == null) {
                throw new NoSuchNativeTypeMemberException("sched_param", "sched_ss_repl_period");
            } else {
                return sched_ss_repl_period;
            }
        }

    }

    public final static boolean HAVE_SCHED_H;

    /**
     * <b>POSIX[PS|TPS]:</b> First in -first out(FIFO) scheduling policy.
     *
     */
    @Define
    public final static int SCHED_FIFO;

    /**
     * <b>POSIX[PS|TPS]:</b> Another scheduling policy.
     *
     */
    @Define
    public final static int SCHED_OTHER;

    /**
     * <b>POSIX[PS|TPS]:</b> Round robin scheduling policy.
     *
     */
    @Define
    public final static int SCHED_RR;

    /**
     * <b>POSIX[SS|TPS]:</b> Sporadic server scheduling policy.
     *
     */
    @Define
    public final static IntDefine SCHED_SPORADIC;

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
                HAVE_SCHED_H = true;
                SCHED_FIFO = LinuxDefines.SCHED_FIFO;
                SCHED_OTHER = LinuxDefines.SCHED_OTHER;
                SCHED_RR = LinuxDefines.SCHED_RR;
                SCHED_SPORADIC = IntDefine.UNDEFINED;
                break;
            case DARWIN:
                HAVE_SCHED_H = true;
                SCHED_FIFO = DarwinDefines.SCHED_FIFO;
                SCHED_OTHER = DarwinDefines.SCHED_OTHER;
                SCHED_RR = DarwinDefines.SCHED_RR;
                SCHED_SPORADIC = IntDefine.UNDEFINED;
                break;
            case FREE_BSD:
                HAVE_SCHED_H = true;
                SCHED_FIFO = FreeBsdDefines.SCHED_FIFO;
                SCHED_OTHER = FreeBsdDefines.SCHED_OTHER;
                SCHED_RR = FreeBsdDefines.SCHED_RR;
                SCHED_SPORADIC = IntDefine.UNDEFINED;
                break;
            case OPEN_BSD:
                HAVE_SCHED_H = true;
                SCHED_FIFO = OpenBsdDefines.SCHED_FIFO;
                SCHED_OTHER = OpenBsdDefines.SCHED_OTHER;
                SCHED_RR = OpenBsdDefines.SCHED_RR;
                SCHED_SPORADIC = IntDefine.UNDEFINED;
                break;
            default:
                throw new NoClassDefFoundError("No sched.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    private final static JnhwMh_sI__sI sched_get_priority_max = JnhwMh_sI__sI.of(
            "sched_get_priority_max",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI sched_get_priority_min = JnhwMh_sI__sI.of(
            "sched_get_priority_min",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI__A sched_getparam = JnhwMh_sI__sI__A.ofOrNull(
            "sched_getparam",
            BaseDataType.C_int,
            PosixDataType.pid_t,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__sI sched_getscheduler = JnhwMh_sI__sI.ofOrNull(
            "sched_getscheduler",
            BaseDataType.C_int,
            PosixDataType.pid_t);

    private final static JnhwMh_sI__sI__A sched_rr_get_interval = JnhwMh_sI__sI__A.ofOrNull(
            "sched_rr_get_interval",
            BaseDataType.C_int,
            PosixDataType.pid_t,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__sI__A sched_setparam = JnhwMh_sI__sI__A.ofOrNull(
            "sched_setparam",
            BaseDataType.C_int,
            PosixDataType.pid_t,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_sI__sI_sI__A sched_setscheduler = JnhwMh_sI__sI_sI__A.ofOrNull(
            "sched_setscheduler",
            BaseDataType.C_int,
            PosixDataType.pid_t,
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh__V___V sched_yield = JnhwMh__V___V.of(
            "sched_yield");

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_get_priority_max.html">sched_get_priority_max,
     * sched_get_priority_min - get priority limits (REALTIME)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int sched_get_priority_max(int policy) throws NativeErrorException {
        final int result = sched_get_priority_max.invoke_sI__sI(policy);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_get_priority_max.html">sched_get_priority_max,
     * sched_get_priority_min - get priority limits (REALTIME)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int sched_get_priority_min(int policy) throws NativeErrorException {
        final int result = sched_get_priority_min.invoke_sI__sI(policy);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_getparam.html">sched_getparam
     * - get scheduling parameters (REALTIME)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sched_getparam is not
     * available natively.
     */
    public final static void sched_getparam(@pid_t int pid, Sched_param param) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (sched_getparam.invoke_sI__sI__P(pid, param) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (sched_getparam == null) {
                throw new NoSuchNativeMethodException("sched_getparam");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_getscheduler.html">sched_getscheduler
     * - get scheduling policy (REALTIME)
     * </a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sched_getscheduler is
     * not available natively.
     */
    public final static int sched_getscheduler(@pid_t int pid) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final int result = sched_getscheduler.invoke_sI__sI(pid);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            return result;
        } catch (NullPointerException npe) {
            if (sched_getscheduler == null) {
                throw new NoSuchNativeMethodException("sched_getscheduler");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_rr_get_interval.html">sched_rr_get_interval
     * - get execution time limits (REALTIME)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sched_rr_get_interval
     * is not available natively.
     */
    public final static void sched_rr_get_interval(@pid_t int pid, Time.Timespec interval) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (sched_rr_get_interval.invoke_sI__sI__P(pid, interval) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (sched_rr_get_interval == null) {
                throw new NoSuchNativeMethodException("sched_rr_get_interval");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_setparam.html">sched_setparam
     * - set scheduling parameters (REALTIME)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sched_setparam is not
     * available natively.
     */
    public final static void sched_setparam(@pid_t int pid, Sched_param param) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            if (sched_setparam.invoke_sI__sI__P(pid, param) != 0) {
                throw new NativeErrorException(Errno.errno());
            }
        } catch (NullPointerException npe) {
            if (sched_setparam == null) {
                throw new NoSuchNativeMethodException("sched_setparam");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_setscheduler.html">sched_setscheduler
     * - set scheduling policy and parameters (REALTIME)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method sched_setscheduler is
     * not available natively.
     */
    public final static int sched_setscheduler(@pid_t int pid, int policy, Sched_param param) throws NativeErrorException, NoSuchNativeMethodException {
        try {
            final int result = sched_setscheduler.invoke_sI__sI_sI_P(pid, policy, param);
            if (result == -1) {
                throw new NativeErrorException(Errno.errno());
            }
            return result;
        } catch (NullPointerException npe) {
            if (sched_setscheduler == null) {
                throw new NoSuchNativeMethodException("sched_setscheduler");
            } else {
                throw npe;
            }
        }
    }

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_yield.html">sched_yield
     * - yield the processor</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void sched_yield() throws NativeErrorException {
        sched_yield.invoke__V___V();
    }

}
