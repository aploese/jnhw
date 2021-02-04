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

import de.ibapl.jnhw.annontation.posix.sys.types.pid_t;
import de.ibapl.jnhw.common.annotation.AlignOf;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

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

        HAVE_SCHED_H = false;

        SCHED_FIFO = 0;
        SCHED_OTHER = 0;
        SCHED_RR = 0;
        SCHED_SPORADIC = IntDefine.UNDEFINED;

        initFields();
    }

    private static native void initFields();

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
     * sched_param}</a>.
     *
     */
    public static class Sched_param extends Struct32 {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct sched_param natively.
         *
         * @return the native value sizeof(struct sched_param).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public static native int offsetof_Sched_ss_init_budget() throws NoSuchNativeTypeMemberException;

        public static native int offsetof_Sched_ss_repl_period() throws NoSuchNativeTypeMemberException;

        public Sched_param() {
            this(false);
        }

        public Sched_param(final boolean clearMem) {
            super(sizeof(), clearMem);
            Time.Timespec t;
            try {
                t = new Time.Timespec(this, offsetof_Sched_ss_init_budget());
            } catch (NoSuchNativeTypeMemberException nstme) {
                t = null;
            }
            sched_ss_init_budget = t;

            try {
                t = new Time.Timespec(this, offsetof_Sched_ss_repl_period());
            } catch (NoSuchNativeTypeMemberException nstme) {
                t = null;
            }
            sched_ss_repl_period = t;
        }

        /**
         * Process or thread execution scheduling priority.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         * @return the native value of sched_priority.
         */
        public native int sched_priority();

        /**
         * Process or thread execution scheduling priority.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         * @param sched_priority the value of sched_priority to be set natively.
         */
        public native void sched_priority(int sched_priority);

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
        public native int sched_ss_low_priority() throws NoSuchNativeTypeMemberException;

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
        public native void sched_ss_low_priority(int sched_ss_low_priority) throws NoSuchNativeTypeMemberException;
        /**
         * Replenishment period for sporadic server.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         */
        private final Time.Timespec sched_ss_repl_period;

        /**
         * Initial budget for sporadic server.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sched.h.html">{@code structure
         * sched_param}</a>.
         *
         */
        private final Time.Timespec sched_ss_init_budget;

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
        public native int sched_ss_max_repl() throws NoSuchNativeTypeMemberException;

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
        public native void sched_ss_max_repl(int sched_ss_max_repl) throws NoSuchNativeTypeMemberException;

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
     * <b>POSIX[PS|TPS]:</b> Another scheduling policy.
     *
     */
    @Define
    public final static int SCHED_OTHER;

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_get_priority_max.html">sched_get_priority_max,
     * sched_get_priority_min - get priority limits (REALTIME)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int sched_get_priority_max(int policy) throws NativeErrorException;

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_get_priority_max.html">sched_get_priority_max,
     * sched_get_priority_min - get priority limits (REALTIME)</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int sched_get_priority_min(int policy) throws NativeErrorException;

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
    public final static native void sched_getparam(@pid_t int pid, Sched_param param) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native int sched_getscheduler(@pid_t int pid) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native void sched_rr_get_interval(@pid_t int pid, Time.Timespec interval) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native void sched_setparam(@pid_t int pid, Sched_param param) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native int sched_setscheduler(@pid_t int pid, int policy, Sched_param param) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX[TPS]:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/sched_yield.html">sched_yield
     * - yield the processor</a>.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void sched_yield() throws NativeErrorException;

}
