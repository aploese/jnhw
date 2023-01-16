/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.annotation.posix.sys.types.clock_t;
import de.ibapl.jnhw.annotation.posix.sys.types.clockid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.size_t;
import de.ibapl.jnhw.annotation.posix.sys.types.time_t;
import de.ibapl.jnhw.annotation.posix.sys.types.timer_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___A__A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh__D__sL_sL;
import de.ibapl.jnhw.common.downcall.JnhwMh__V___V;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_sI__A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_uL__A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_uL__A__A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI__A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_sI__A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sL___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sL___V;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NativeException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeSymbolException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.IntPtr_t;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.posix.Signal.Sigevent;
import de.ibapl.jnhw.posix.sys.Types;
import de.ibapl.jnhw.posix.sys.Types.Clockid_t;
import de.ibapl.jnhw.libloader.librarys.LibcLoader;
import de.ibapl.jnhw.libloader.librarys.LibrtLoader;
import de.ibapl.jnhw.util.posix.PosixDataType;
import de.ibapl.jnhw.util.posix.memory.PosixStruct;
import java.io.IOException;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.ValueLayout;
import java.util.Objects;
import java.util.Optional;

/**
 * Wrapper around the {@code <time.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">time.h
 * - time types</a>.
 *
 * @author aploese
 */
@Include("#include <time.h>")
public class Time {

    public static interface BsdDefines {

        public final static int CLOCK_REALTIME = 0;

    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int CLOCK_MONOTONIC = 6;
        public final static int CLOCK_PROCESS_CPUTIME_ID = 12;
        public final static int CLOCK_THREAD_CPUTIME_ID = 16;
        public final static int CLOCKS_PER_SEC = 1000000;
    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int CLOCK_MONOTONIC = 4;
        public final static int CLOCK_PROCESS_CPUTIME_ID = 15;
        public final static int CLOCK_THREAD_CPUTIME_ID = 14;
        public final static int CLOCKS_PER_SEC = 128;
        public final static int TIMER_ABSTIME = 1;
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
     * itimerspec}</a>.
     *
     */
    public final static class Itimerspec extends Struct {

        public final static Alignment alignof;
        public final static long offsetof_It_interval;
        public final static long offsetof_It_value;
        public final static int sizeof;

        /**
         * Make sure the native lib is loaded
         */
        static {

            switch (MultiarchTupelBuilder.getOS()) {
                case DARWIN -> {
                    offsetof_It_interval = -1;
                    offsetof_It_value = -1;
                    alignof = null;
                    sizeof = 0;
                }
                default -> {
                    offsetof_It_interval = 0;
                    switch (MultiarchTupelBuilder.getMemoryModel()) {
                        case ILP32 -> {
                            offsetof_It_value = 8;
                            alignof = Alignment.AT_4;
                            sizeof = 16;
                        }
                        case LP64 -> {
                            offsetof_It_value = 16;
                            alignof = Alignment.AT_8;
                            sizeof = 32;
                        }
                        default ->
                            throw new NoClassDefFoundError("No time.h defines for " + MultiarchTupelBuilder.getMultiarch());
                    }
                }
            }
        }

        public final static Itimerspec tryAllocateNative(MemorySession ms) throws NoSuchNativeTypeException {
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Itimerspec");
            }
            return new Itimerspec(MemorySegment.allocateNative(sizeof, ms), 0);
        }
        /**
         * Timer period. After the timer expires after it_value, it will fire
         * periodically with the it_interval value.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * itimerspec}</a>.
         *
         */
        public final Timespec it_interval;

        /**
         * Timer expiration. After the timer expires after it_value, it will
         * fire periodically with the it_interval value.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * itimerspec}</a>.
         *
         */
        public final Timespec it_value;

        public Itimerspec(MemorySegment memorySegment, int offset) throws NoSuchNativeTypeException {
            super(memorySegment, offset, Itimerspec.sizeof);
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Itimerspec");
            }
            it_interval = new Timespec(this.memorySegment, Itimerspec.offsetof_It_interval);
            it_value = new Timespec(this.memorySegment, Itimerspec.offsetof_It_value);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Itimerspec other = (Itimerspec) obj;
            if (!Objects.equals(this.it_interval, other.it_interval)) {
                return false;
            }
            return Objects.equals(this.it_value, other.it_value);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 23 * hash + Objects.hashCode(this.it_interval);
            hash = 23 * hash + Objects.hashCode(this.it_value);
            return hash;
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendStruct32Member("it_value", it_value);
            jsb.appendStruct32Member("it_interval", it_interval);
            jsb.close();
        }

    }

    public static interface LinuxDefines {

        public final static int CLOCK_MONOTONIC = 1;
        public final static int CLOCK_PROCESS_CPUTIME_ID = 2;
        public final static int CLOCK_REALTIME = 0;
        public final static int CLOCK_THREAD_CPUTIME_ID = 3;
        public final static int CLOCKS_PER_SEC = 1000000;
        public final static int TIMER_ABSTIME = 1;
    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int CLOCK_MONOTONIC = 3;
        public final static int CLOCK_PROCESS_CPUTIME_ID = 2;
        public final static int CLOCK_THREAD_CPUTIME_ID = 4;
        public final static int CLOCKS_PER_SEC = 100;
        public final static int TIMER_ABSTIME = 1;
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code typedef
     * timer_t}</a>.
     *
     * @author aploese
     */
    @timer_t
    public static final class Timer_t extends OpaqueMemory {

        public final static Alignment alignof = PosixDataType.timer_t.ALIGN_OF;
        public final static int sizeof = PosixDataType.timer_t.SIZE_OF;

        public final static Timer_t tryAllocateNative(MemorySession ms) throws NoSuchNativeTypeException {
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Timer_t");
            }
            return new Timer_t(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public final static Timer_t ofAddress(MemoryAddress address, MemorySession ms) throws NoSuchNativeTypeException {
            return new Timer_t(MemorySegment.ofAddress(address, sizeof, ms), 0);
        }

        public Timer_t(MemorySegment memorySegment, long offset) throws NoSuchNativeTypeException {
            super(memorySegment, offset, Timer_t.sizeof);
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Timer_t");
            }
        }

        @Override
        public String nativeToHexString() {
            return switch (PosixDataType.timer_t) {
                case intptr_t ->
                    MEM_ACCESS.intptr_t_AsHex(memorySegment, 0);
                case int32_t ->
                    MEM_ACCESS.int32_t_AsHex(memorySegment, 0);
                default ->
                    throw new AssertionError("Cant handle native datatype of timer_t: " + PosixDataType.timer_t);
            };
        }

        @Override
        public String nativeToString() {
            return MEM_ACCESS.intptr_t_nativeToString(memorySegment, 0);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            sb.append(nativeToString());
        }

        @Override
        public BaseDataType getBaseDataType() {
            return PosixDataType.timer_t;
        }

    }

    public final static class PtrTimer_t extends IntPtr_t<Timer_t> {

        public static PtrTimer_t tryAllocateNative(MemorySession ms) throws NoSuchNativeTypeException {
            if (Timer_t.alignof == null) {
                throw new NoSuchNativeTypeException("Timer_t");
            }
            return new PtrTimer_t(MemorySegment.allocateNative(DATA_TYPE.SIZE_OF, ms), 0);
        }

        public PtrTimer_t(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset);
        }

        public Timer_t get(final MemorySession ms) {
            return get((address, _ms, parent) -> {
                try {
                    return Timer_t.ofAddress(address, _ms);
                } catch (NoSuchNativeTypeException e) {
                    throw new RuntimeException(e);
                }
            }, ms);
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
     * timespec}</a>.
     *
     */
    public final static class Timespec extends PosixStruct {

        public final static Alignment alignof;
        public final static long offsetof_Tv_nsec;
        public final static long offsetof_Tv_sec = 0;
        public final static int sizeof;

        static {
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 -> {
                    offsetof_Tv_nsec = 4;
                    alignof = Alignment.AT_4;
                    sizeof = 8;
                }
                case LP64 -> {
                    offsetof_Tv_nsec = 8;
                    alignof = Alignment.AT_8;
                    sizeof = 16;
                }
                default ->
                    throw new NoClassDefFoundError("No time.h defines for " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        public final static Timespec allocateNative(MemorySession ms) {
            return new Timespec(MemorySegment.allocateNative(Timespec.sizeof, ms), 0);
        }

        public final static Timespec wrap(OpaqueMemory mem, long offset) {
            return new Timespec(OpaqueMemory.sliceMemorySegment(mem, offset, Timespec.sizeof), 0);
        }

        public Timespec(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Timespec.sizeof);
        }

        public Timespec(OpaqueMemory mem, long offset) {
            super(mem, offset, Timespec.sizeof);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Timespec other = (Timespec) obj;
            if (this.tv_sec() != other.tv_sec()) {
                return false;
            }
            return this.tv_nsec() == other.tv_nsec();
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 97 * hash + (int) (this.tv_sec() ^ (this.tv_sec() >>> 32));
            hash = 97 * hash + (int) (this.tv_nsec() ^ (this.tv_nsec() >>> 32));
            return hash;
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendLongMember("tv_sec", tv_sec());
            jsb.appendLongMember("tv_nsec", tv_nsec());
            jsb.close();
        }

        /**
         * Nanoseconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @return the native value of tv_nsec.
         */
        public long tv_nsec() {
            return MEM_ACCESS.signed_long(memorySegment, Timespec.offsetof_Tv_nsec);
        }

        /**
         * Nanoseconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @param tv_nsec the value of tv_nsec to be set natively.
         */
        public void tv_nsec(long tv_nsec) {
            MEM_ACCESS.signed_long(memorySegment, Timespec.offsetof_Tv_nsec, tv_nsec);
        }

        /**
         * Seconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @return the native value of tv_sec.
         */
        @time_t
        public long tv_sec() {
            return ACCESSOR_TIME_T.time_t(memorySegment, Timespec.offsetof_Tv_sec);
        }

        /**
         * Seconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @param tv_sec the value of tv_sec to be set natively.
         */
        public void tv_sec(@time_t long tv_sec) {
            ACCESSOR_TIME_T.time_t(memorySegment, Timespec.offsetof_Tv_sec, tv_sec);
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
     * tm}</a>.
     *
     */
    public final static class Tm extends Struct {

        public final static Alignment alignof;
        public final static long offsetof_Tm_hour;
        public final static long offsetof_Tm_isdst;
        public final static long offsetof_Tm_mday;
        public final static long offsetof_Tm_min;
        public final static long offsetof_Tm_mon;
        public final static long offsetof_Tm_sec = 0;
        public final static long offsetof_Tm_wday;
        public final static long offsetof_Tm_yday;
        public final static long offsetof_Tm_year;
        public final static int sizeof;

        static {

            offsetof_Tm_min = 4;
            offsetof_Tm_hour = 8;
            offsetof_Tm_mday = 12;
            offsetof_Tm_mon = 16;
            offsetof_Tm_year = 20;
            offsetof_Tm_wday = 24;
            offsetof_Tm_yday = 28;
            offsetof_Tm_isdst = 32;
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case ILP32 -> {
                    alignof = Alignment.AT_4;
                    sizeof = 44;
                }
                case LP64 -> {
                    alignof = Alignment.AT_8;
                    sizeof = 56;
                }
                default ->
                    throw new NoClassDefFoundError("No time.h defines for " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        public final static Tm allocateNative(MemorySession ms) {
            return new Tm(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public Tm(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Tm.sizeof);
        }

        public Tm(MemoryAddress baseAddress, MemorySession ms) {
            super(baseAddress, ms, Tm.sizeof);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendIntMember("tm_year", tm_year());
            jsb.appendIntMember("tm_yday", tm_yday());
            jsb.appendIntMember("tm_mon", tm_mon());
            jsb.appendIntMember("tm_mday", tm_mday());
            jsb.appendIntMember("tm_wday", tm_wday());
            jsb.appendIntMember("tm_hour", tm_hour());
            jsb.appendIntMember("tm_min", tm_min());
            jsb.appendIntMember("tm_sec", tm_sec());
            jsb.appendIntMember("tm_isdst", tm_isdst());
            jsb.close();
        }

        /**
         * Hour [0,23].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_hour.
         */
        public int tm_hour() {
            return MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_hour);
        }

        /**
         * Hour [0,23].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_hour the value of tm_hour to be set natively.
         */
        public void tm_hour(int tm_hour) {
            MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_hour, tm_hour);
        }

        /**
         * Daylight Savings flag.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_isdst.
         */
        public int tm_isdst() {
            return MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_isdst);
        }

        /**
         * Daylight Savings flag.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_isdst the value of tm_isdst to be set natively.
         */
        public void tm_isdst(int tm_isdst) {
            MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_isdst, tm_isdst);
        }

        /**
         * Day of month [1,31].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_mday.
         */
        public int tm_mday() {
            return MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_mday);
        }

        /**
         * Day of month [1,31].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_mday the value of tm_mday to be set natively.
         */
        public void tm_mday(int tm_mday) {
            MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_mday, tm_mday);
        }

        /**
         * Minutes [0,59].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_min.
         */
        public int tm_min() {
            return MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_min);
        }

        /**
         * Minutes [0,59].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_min the value of tm_min to be set natively.
         */
        public void tm_min(int tm_min) {
            MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_min, tm_min);
        }

        /**
         * Month of year [0,11].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_mon.
         */
        public int tm_mon() {
            return MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_mon);
        }

        /**
         * Month of year [0,11].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_mon the value of tm_mon to be set natively.
         */
        public void tm_mon(int tm_mon) {
            MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_mon, tm_mon);
        }

        /**
         * Seconds [0,60].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_sec.
         */
        public int tm_sec() {
            return MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_sec);
        }

        /**
         * Seconds [0,60].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_sec the value of tm_sec to be set natively.
         */
        public void tm_sec(int tm_sec) {
            MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_sec, tm_sec);
        }

        /**
         * Day of week [0,6] (Sunday = 0 ).
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_wday.
         */
        public int tm_wday() {
            return MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_wday);
        }

        /**
         * Day of week [0,6] (Sunday = 0 ).
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_wday the value of tm_wday to be set natively.
         */
        public void tm_wday(int tm_wday) {
            MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_wday, tm_wday);
        }

        /**
         * Day of year [0,365].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_yday.
         */
        public int tm_yday() {
            return MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_yday);
        }

        /**
         * Day of year [0,365].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_yday the value of tm_yday to be set natively.
         */
        public void tm_yday(int tm_yday) {
            MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_yday, tm_yday);
        }

        /**
         * Years since 1900.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_year.
         */
        public int tm_year() {
            return MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_year);
        }

        /**
         * Years since 1900.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_year the value of tm_year to be set natively.
         */
        public void tm_year(int tm_year) {
            MEM_ACCESS.int32_t(memorySegment, Tm.offsetof_Tm_year, tm_year);
        }

    }

    /**
     * <b>POSIX:</b> The identifier for the system-wide monotonic clock, which
     * is defined as a clock measuring real time, whose value cannot be set via
     * clock_settime() and which cannot have negative clock jumps.The maximum
     * possible clock jump shall be implementation-defined..
     *
     */
    @Define()
    @clockid_t
    public final static int CLOCK_MONOTONIC;

    /**
     * <b>POSIX:</b> The identifier of the CPU-time clock associated with the
     * process making a clock() or timer*() function call..
     *
     */
    @Define()
    @clockid_t
    public final static int CLOCK_PROCESS_CPUTIME_ID;

    /**
     * <b>POSIX:</b> The identifier of the system-wide clock measuring real
     * time.
     *
     */
    @Define()
    @clockid_t
    public final static int CLOCK_REALTIME;

    /**
     * <b>POSIX:</b> The identifier of the CPU-time clock associated with the
     * thread making a clock() or timer*() function call..
     *
     */
    @Define()
    @clockid_t
    public final static int CLOCK_THREAD_CPUTIME_ID;

    /**
     * <b>POSIX:</b> A number used to convert the value returned by the clock()
     * function into seconds. The value shall be an expression with type
     * clock_t. [XSI] [Option Start] The value of CLOCKS_PER_SEC shall be 1
     * million on XSI-conformant systems. However, it may be variable on other
     * systems, and it should not be assumed that CLOCKS_PER_SEC is a
     * compile-time constant. .
     *
     */
    @Define()
    @clock_t
    public final static int CLOCKS_PER_SEC;

    public final static boolean HAVE_TIME_H;

    /**
     * <b>POSIX:</b> Flag indicating time is absolute.For functions taking timer
     * objects, this refers to the clock associated with the timer.
     *
     */
    @Define()
    public final static IntDefine TIMER_ABSTIME;

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
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                HAVE_TIME_H = true;
                CLOCKS_PER_SEC = LinuxDefines.CLOCKS_PER_SEC;
                CLOCK_MONOTONIC = LinuxDefines.CLOCK_MONOTONIC;
                CLOCK_PROCESS_CPUTIME_ID = LinuxDefines.CLOCK_PROCESS_CPUTIME_ID;
                CLOCK_REALTIME = LinuxDefines.CLOCK_REALTIME;
                CLOCK_THREAD_CPUTIME_ID = LinuxDefines.CLOCK_THREAD_CPUTIME_ID;
                TIMER_ABSTIME = IntDefine.toIntDefine(LinuxDefines.TIMER_ABSTIME);
            }
            case DARWIN, FREE_BSD, OPEN_BSD -> {
                HAVE_TIME_H = true;
                CLOCK_REALTIME = BsdDefines.CLOCK_REALTIME;
                switch (MultiarchTupelBuilder.getOS()) {
                    case DARWIN -> {
                        CLOCKS_PER_SEC = DarwinDefines.CLOCKS_PER_SEC;
                        CLOCK_MONOTONIC = DarwinDefines.CLOCK_MONOTONIC;
                        CLOCK_PROCESS_CPUTIME_ID = DarwinDefines.CLOCK_PROCESS_CPUTIME_ID;
                        CLOCK_THREAD_CPUTIME_ID = DarwinDefines.CLOCK_THREAD_CPUTIME_ID;
                        TIMER_ABSTIME = IntDefine.UNDEFINED;
                    }
                    case FREE_BSD -> {
                        CLOCKS_PER_SEC = FreeBsdDefines.CLOCKS_PER_SEC;
                        CLOCK_MONOTONIC = FreeBsdDefines.CLOCK_MONOTONIC;
                        CLOCK_PROCESS_CPUTIME_ID = FreeBsdDefines.CLOCK_PROCESS_CPUTIME_ID;
                        CLOCK_THREAD_CPUTIME_ID = FreeBsdDefines.CLOCK_THREAD_CPUTIME_ID;
                        TIMER_ABSTIME = IntDefine.toIntDefine(FreeBsdDefines.TIMER_ABSTIME);
                    }
                    case OPEN_BSD -> {
                        CLOCKS_PER_SEC = OpenBsdDefines.CLOCKS_PER_SEC;
                        CLOCK_MONOTONIC = OpenBsdDefines.CLOCK_MONOTONIC;
                        CLOCK_PROCESS_CPUTIME_ID = OpenBsdDefines.CLOCK_PROCESS_CPUTIME_ID;
                        CLOCK_THREAD_CPUTIME_ID = OpenBsdDefines.CLOCK_THREAD_CPUTIME_ID;
                        TIMER_ABSTIME = IntDefine.toIntDefine(OpenBsdDefines.TIMER_ABSTIME);
                    }
                    default ->
                        throw new NoClassDefFoundError("No time.h BSD defines for " + MultiarchTupelBuilder.getMultiarch());
                }
            }
            default ->
                throw new NoClassDefFoundError("No time.h Os defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    private final static JnhwMh_MA___A.ExceptionErased asctime = JnhwMh_MA___A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "asctime",
            BaseDataType.C_char_pointer,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_MA___A__A.ExceptionErased asctime_r = JnhwMh_MA___A__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "asctime_r",
            BaseDataType.C_char_pointer,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_char_pointer);

    private final static JnhwMh_sL___V.ExceptionErased clock = JnhwMh_sL___V.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "clock",
            PosixDataType.clock_t);

    private final static JnhwMh_sI__sI__A clock_getcpuclockid = JnhwMh_sI__sI__A.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "clock_getcpuclockid",
            BaseDataType.C_int,
            PosixDataType.pid_t,
            PosixDataType.clockid_t_ptr);

    private final static JnhwMh_sI__sI__A.ExceptionErased clock_getres = JnhwMh_sI__sI__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "clock_getres",
            BaseDataType.C_int,
            PosixDataType.clockid_t,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__sI__A.ExceptionErased clock_gettime = JnhwMh_sI__sI__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "clock_gettime",
            BaseDataType.C_int,
            PosixDataType.clockid_t,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__sI_sI__A__A clock_nanosleep = JnhwMh_sI__sI_sI__A__A.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "clock_nanosleep",
            BaseDataType.C_int,
            PosixDataType.clockid_t,
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__sI__A.ExceptionErased clock_settime = JnhwMh_sI__sI__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "clock_settime",
            BaseDataType.C_int,
            PosixDataType.clockid_t,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_MA___A.ExceptionErased ctime = JnhwMh_MA___A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "ctime",
            BaseDataType.C_char_pointer,
            BaseDataType.C_const_pointer);

    private final static JnhwMh_MA___A__A.ExceptionErased ctime_r = JnhwMh_MA___A__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "ctime_r",
            BaseDataType.C_char_pointer,
            BaseDataType.C_const_pointer,
            BaseDataType.C_char_pointer);

    private final static JnhwMh__D__sL_sL.ExceptionErased difftime = JnhwMh__D__sL_sL.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "difftime",
            BaseDataType._double,
            PosixDataType.time_t,
            PosixDataType.time_t);

    private final static JnhwMh_MA___A getdate = JnhwMh_MA___A.optionalOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "getdate",
            BaseDataType.C_struct_pointer,
            BaseDataType.C_char_pointer);

    private final static JnhwMh_MA___A.ExceptionErased gmtime = JnhwMh_MA___A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "gmtime",
            BaseDataType.C_struct_pointer,
            BaseDataType.C_pointer);

    private final static JnhwMh_MA___A__A.ExceptionErased gmtime_r = JnhwMh_MA___A__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "gmtime_r",
            BaseDataType.C_struct_pointer,
            BaseDataType.C_pointer,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_MA___A.ExceptionErased localtime = JnhwMh_MA___A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "localtime",
            BaseDataType.C_struct_pointer,
            BaseDataType.C_pointer);

    private final static JnhwMh_MA___A__A.ExceptionErased localtime_r = JnhwMh_MA___A__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "localtime_r",
            BaseDataType.C_struct_pointer,
            BaseDataType.C_pointer,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sL___A.ExceptionErased mktime = JnhwMh_sL___A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "mktime",
            PosixDataType.time_t,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI___A__A.ExceptionErased nanosleep = JnhwMh_sI___A__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "nanosleep",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI___A_uL__A__A.ExceptionErased strftime = JnhwMh_sI___A_uL__A__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "strftime",
            BaseDataType.C_int,
            BaseDataType.C_char_pointer,
            PosixDataType.size_t,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_sI___A_uL__A__A__A.ExceptionErased strftime_l = JnhwMh_sI___A_uL__A__A__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "strftime_l",
            BaseDataType.C_int,
            BaseDataType.C_char_pointer,
            PosixDataType.size_t,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_MA___A__A__A.ExceptionErased strptime = JnhwMh_MA___A__A__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "strptime",
            BaseDataType.C_char_pointer,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_const_char_pointer,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sL___A.ExceptionErased time = JnhwMh_sL___A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "time",
            PosixDataType.time_t,
            BaseDataType.C_pointer);

    private final static JnhwMh_sI__sI__A__A timer_create = JnhwMh_sI__sI__A__A.optionalOf(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "timer_create",
            BaseDataType.C_int,
            PosixDataType.clockid_t,
            BaseDataType.C_struct_pointer,
            BaseDataType.C_pointer);

    private final static JnhwMh_sI___A timer_delete = JnhwMh_sI___A.optionalOf(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "timer_delete",
            BaseDataType.C_int,
            PosixDataType.timer_t);

    private final static JnhwMh_sI___A timer_getoverrun = JnhwMh_sI___A.optionalOf(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "timer_getoverrun",
            BaseDataType.C_int,
            PosixDataType.timer_t);

    private final static JnhwMh_sI___A__A timer_gettime = JnhwMh_sI___A__A.optionalOf(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "timer_gettime",
            BaseDataType.C_int,
            PosixDataType.timer_t,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI___A_sI__A__A timer_settime = JnhwMh_sI___A_sI__A__A.optionalOf(
            LibrtLoader.LIB_RT_SYMBOL_LOOKUP,
            "timer_settime",
            BaseDataType.C_int,
            PosixDataType.timer_t,
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh__V___V.ExceptionErased tzset = JnhwMh__V___V.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "tzset");

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/asctime.html">asctime,
     * asctime_r - convert date and time to a string</a>.
     *
     * @param tm the time to convert.
     *
     * @return on succes the converted date and time, otherwise {@code null}
     */
    public final static String asctime(Tm tm) {
        final MemoryAddress resultAdr = asctime.invoke_MA___P(tm);
        if (resultAdr == MemoryAddress.NULL) {
            return null;
        } else {
            return resultAdr.getUtf8String(0);
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/asctime_r.html">asctime,
     * asctime_r - convert date and time to a string</a>.
     *
     * @param tm the time to convert.
     * @param buf buffer to place the converted time string too. Must be at
     * least 26 bytes long.
     *
     * @return on succes the converted date and time, otherwise {@code null}
     */
    public final static String asctime_r(Tm tm, OpaqueMemory buf) {
        if (buf.sizeof() < 26) {
            throw new IllegalArgumentException("buf is too small 26 bytes are the minimum");
        }
        final MemoryAddress resultAdr = asctime_r.invoke_MA___P__P(tm, buf);
        if (resultAdr == MemoryAddress.NULL) {
            return null;
        } else {
            return resultAdr.getUtf8String(0);
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/clock.html">clock
     * - report CPU time used</a>.
     *
     * @return the processor time used by the process.
     */
    @clock_t
    public final static long clock() {
        return clock.invoke_sL___V();
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/clock_getcpuclockid.html">clock_getcpuclockid
     * - access a process CPU-time clock (ADVANCED REALTIME)</a>.
     *
     *
     * @param pid the pid to get the cpu time of. If zero the pid of the calling
     * process is used.
     * @param clock_id the clock ID of the pid will be placed here.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method clock_getcpuclockid is
     * not available natively.
     */
    public final static void clock_getcpuclockid(@pid_t int pid, Clockid_t clock_id) throws NativeErrorException, NoSuchNativeMethodException {
        int result = clock_getcpuclockid.invoke_sI__sI__P(pid, clock_id);
        if (result != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/clock_getres.html">clock_getres,
     * clock_gettime, clock_settime - clock and timer functions</a>.The
     * clock_getres() function shall return the resolution of any clock.
     *
     * @param clock_id the ID of the clock to use.
     * @param timespec if not {@code null} the timespec of clock_is is returned.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void clock_getres(@clockid_t int clock_id, Timespec timespec) throws NativeErrorException {
        if (clock_getres.invoke_sI__sI__P(clock_id, timespec) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/clock_gettime.html">clock_getres,
     * clock_gettime, clock_settime - clock and timer functions</a>.The
     * clock_gettime() function shall return the current value tp for the
     * specified clock, clock_id.
     *
     * @param clock_id the ID of the clock to use.
     * @param timespec the timespect to get.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void clock_gettime(@clockid_t int clock_id, Timespec timespec) throws NativeErrorException {
        if (clock_gettime.invoke_sI__sI__P(clock_id, timespec) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    public final static void clock_nanosleep(@clockid_t int clock_id, int flags, Timespec rqtp) throws NativeErrorException, NoSuchNativeMethodException {
        if (clock_nanosleep.invoke_sI__sI_sI__P__P(clock_id, flags, rqtp, Pointer.NULL) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/clock_nanosleep.html">clock_nanosleep
     * - high resolution sleep with specifiable clock</a>.
     *
     *
     * @param clock_id the ID of the clock to use.
     * @param flags the flags arguent.
     * @param rqtp the time to wait.
     * @param rmtp if not {@code null} the remaining time, if interruped.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method clock_nanosleep is not
     * available natively.
     */
    public final static void clock_nanosleep(@clockid_t int clock_id, int flags, Timespec rqtp, Timespec rmtp) throws NativeErrorException, NoSuchNativeMethodException {
        if (clock_nanosleep.invoke_sI__sI_sI__P__P(clock_id, flags, rqtp, rmtp) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/clock_settime.html">clock_getres,
     * clock_gettime, clock_settime - clock and timer functions</a>.The
     * clock_settime() function shall set the specified clock, clock_id, to the
     * value specified by tp.
     *
     * @param clock_id the ID of the clock to use.
     * @param timespec the timespec to set.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void clock_settime(@clockid_t int clock_id, Timespec timespec) throws NativeErrorException {
        if (clock_settime.invoke_sI__sI__P(clock_id, timespec) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/ctime.html">ctime,
     * ctime_r - convert a time value to a date and time string</a>.
     *
     *
     * @param clock the time to convert.
     *
     * @return on succes the converted time, otherwise {@code null}
     */
    public final static String ctime(Types.Time_t clock) {
        final MemoryAddress resultAdr = ctime.invoke_MA___P(clock);
        if (resultAdr == MemoryAddress.NULL) {
            return null;
        } else {
            return resultAdr.getUtf8String(0);
        }

    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/ctime.html">ctime,
     * ctime_r - convert a time value to a date and time string</a>.
     *
     *
     * @param clock the time to convert.
     * @param buf buffer to place the converted time string too. Must be at
     * least 26 bytes long.
     *
     * @return on succes the converted time, otherwise {@code null}
     */
    public final static String ctime_r(Types.Time_t clock, OpaqueMemory buf) {
        if (buf.sizeof() < 26) {
            throw new IllegalArgumentException("buf is too small 26 bytes are the minimum");
        }
        final MemoryAddress resultAdr = ctime_r.invoke_MA___P__P(clock, buf);
        if (resultAdr == MemoryAddress.NULL) {
            return null;
        } else {
            return resultAdr.getUtf8String(0);
        }
    }

    private final static Optional<MemorySegment> daylight = LibcLoader.lookup("daylight");

    /**
     * <b>POSIX.XSI:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/daylight.html">daylight,
     * timezone, tzname, tzset - set timezone conversion information</a>.
     *
     * @throws de.ibapl.jnhw.common.exception.NoSuchNativeSymbolException
     */
    public final static int daylight() throws NoSuchNativeSymbolException {
        return daylight.orElseThrow(
                () -> new NoSuchNativeSymbolException("daylight")
        ).address().get(ValueLayout.JAVA_INT, 0);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/difftime.html">difftime
     * - compute the difference between two calendar time values</a>.
     *
     *
     * @param time1
     * @param time0
     * @return time1 - time0 expressed in seconds as a type double.
     */
    public final static double difftime(@time_t long time1, @time_t long time0) {
        return difftime.invoke__D__sL_sL(time1, time0);
    }

    private final static Optional<MemorySegment> getdate_err = LibcLoader.LIB_C_SYMBOL_LOOKUP.lookup("getdate_err");

    /**
     * <b>POSIX.XSI:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getdate_err.html">getdate
     * - convert user format date and time</a>.
     *
     * @throws de.ibapl.jnhw.common.exception.NoSuchNativeSymbolException
     */
    public final static int getdate_err() throws NoSuchNativeSymbolException {
        return getdate_err.orElseThrow(
                () -> new NoSuchNativeSymbolException("getdate_err")
        ).address().get(ValueLayout.JAVA_INT, 0);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getdate.html">getdate
     * - convert user format date and time</a>.
     *
     * @param string the string to convert.
     *
     * @return Upon successful completion, a pointer to a struct tm.
     *
     * @throws NativeException. The error wil be set in getdate_err with the
     * getdate_err error codes.
     * @throws NoSuchNativeMethodException if the method getdate is not
     * available natively.
     */
    public final static Tm getdate(String string) throws NativeException, NoSuchNativeMethodException {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _string = MemorySegment.allocateNative(string.length() + 1, ms);
            _string.setUtf8String(0, string);
            final MemoryAddress result
                    = getdate.invoke_MA___A(_string);
            if (result == MemoryAddress.NULL) {
                throw new NativeException("getdate");
            } else {
                // getdate returns static memory - so do not attempt to free it...
                return new Tm(result, MemorySession.global());
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/gmtime.html">gmtime,
     * gmtime_r - convert a time value to a broken-down UTC time</a>.
     *
     *
     * @param timer time in seconds since the Epoch
     *
     * @return
     */
    public final static Tm gmtime(Types.Time_t timer) throws NativeErrorException {
        final MemoryAddress result = gmtime.invoke_MA___P(timer);
        if (result == MemoryAddress.NULL) {
            throw new NativeErrorException(Errno.errno());
        } else {
            // gmtime returns static memory - so do not attempt to free it...
            return new Tm(result, MemorySession.global());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/gmtime.html">gmtime,
     * gmtime_r - convert a time value to a broken-down UTC time</a>.
     *
     *
     * @param timer time in seconds since the Epoch
     * @param result a sruct tm ({@link Tm}) to hold the result.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void gmtime_r(Types.Time_t timer, Tm result) throws NativeErrorException {
        final MemoryAddress _result = gmtime_r.invoke_MA___P__P(timer, result);
        if (_result == MemoryAddress.NULL) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/localtime.html">localtime,
     * localtime_r - convert a time value to a broken-down local time</a>.
     *
     *
     * @param timer the time in seconds since the Epoch.
     * @return on successful completion, a pointer to the broken-down time
     * structure.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static Tm localtime(Types.Time_t timer) throws NativeErrorException {
        final MemoryAddress result = localtime.invoke_MA___P(timer);
        if (result == MemoryAddress.NULL) {
            throw new NativeErrorException(Errno.errno());
        } else {
            // localtime returns static memory - so do not attempt to free it...
            return new Tm(result, MemorySession.global());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/localtime_r.html">poll
     * - input/output multiplexing</a>.
     *
     * @param timer the time in seconds since the Epoch.
     * @param result a sruct tm ({@link Tm}) to hold the result.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void localtime_r(Types.Time_t timer, Tm result) throws NativeErrorException {
        final MemoryAddress _result = localtime_r.invoke_MA___P__P(timer, result);
        if (_result == MemoryAddress.NULL) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/mktime.html">mktime
     * - convert broken-down time into time since the Epoch</a>.
     *
     *
     * @param timeptr the time since the epoch in a {@code Tm} structure.
     * @return the time in seconds since the Epoch
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @time_t
    public final static long mktime(Tm timeptr) throws NativeErrorException {
        final long result = mktime.invoke_sL___P(timeptr);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    public final static void nanosleep(Timespec rqtp) throws NativeErrorException {
        if (nanosleep.invoke_sI___P__P(rqtp, Pointer.NULL) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/nanosleep.html">nanosleep
     * - high resolution sleep</a>.
     *
     *
     * @param rqtp the time to sleep
     * @param rmtp if not {@code null} the remaining time.
     *
     * @throws NativeErrorException if the requested time has not elapsed.
     */
    public final static void nanosleep(Timespec rqtp, Timespec rmtp) throws NativeErrorException {
        if (nanosleep.invoke_sI___P__P(rqtp, rmtp) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/strftime.html">strftime,
     * strftime_l - convert date and time to a string</a>.
     *
     *
     * @param maxsize the max size of the buffer.
     * @param format a format string.
     * @param timeptr the time.
     *
     * @return on succes the converted time otherwise {@code null}.
     */
    public final static String strftime(@size_t long maxsize, String format, Tm timeptr) {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment s = MemorySegment.allocateNative(maxsize, ms);
            MemorySegment _format = MemorySegment.allocateNative(format.length() + 1, ms);
            _format.setUtf8String(0, format);
            final int result = strftime.invoke_sI___A_uL__A__P(s, maxsize, _format, timeptr);
            if (result == 0) {
                return null;
            } else {
                return s.getUtf8String(0);
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/strftime.html">strftime,
     * strftime_l - convert date and time to a string</a>.
     *
     *
     * @param maxsize the max size of the buffer.
     * @param format a format string.
     * @param timeptr the time.
     * @param locale the locale to use.
     *
     * @return on succes the converted time otherwise {@code null}.
     */
    public final static String strftime_l(@size_t long maxsize, String format, Tm timeptr, Locale.Locale_t locale) {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment s = MemorySegment.allocateNative(maxsize, ms);
            MemorySegment _format = MemorySegment.allocateNative(format.length() + 1, ms);
            _format.setUtf8String(0, format);
            final int result = strftime_l.invoke_sI___A_uL_A__P__P(s, maxsize, _format, timeptr, locale);
            if (result == 0) {
                return null;
            } else {
                return s.getUtf8String(0);
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/strptime.html">strptime
     * - date and time conversion</a>.
     *
     *
     * @param buf the character string to convert
     * @param format the format to use
     * @param tm the target of the conversation.
     *
     * @return the index of the character in{@code buf}, following the last
     * character parsed.
     */
    public final static String strptime(String buf, String format, Tm tm) {
        try (MemorySession ms = MemorySession.openConfined()) {
            MemorySegment _format = MemorySegment.allocateNative(format.length() + 1, ms);
            _format.setUtf8String(0, format);
            MemorySegment _buf = MemorySegment.allocateNative(buf.length() + 1, ms);
            _buf.setUtf8String(0, buf);
            final MemoryAddress result = strptime.invoke_MA__A_A_P(_buf, _format, tm);
            if (result == MemoryAddress.NULL) {
                return null;
            } else {
                return result.getUtf8String(0);
            }
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/time.html">time
     * - get time</a>.
     *
     * @return the value of time.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @time_t
    public final static long time() throws NativeErrorException {
        final long result = time.invoke_sL___P(Pointer.NULL);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timer_create.html">timer_create
     * - create a per-process timer</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NullPointerException if
     * {@code ((evp != null) && (evp.sigev_notify_attributes == null))}
     * otherwise we will get a SIGSEV.
     * @throws NoSuchNativeMethodException if the method timer_create is not
     * available natively.
     */
    public final static void timer_create(@clockid_t int clockid, Sigevent evp, PtrTimer_t timerid) throws NativeErrorException, NoSuchNativeMethodException {
        if (timer_create.invoke_sI__sI__P__P(clockid, evp, timerid) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    public final static void timer_create(@clockid_t int clockid, PtrTimer_t timerid) throws NativeErrorException, NoSuchNativeMethodException {
        if (timer_create.invoke_sI__sI__P__P(clockid, Pointer.NULL, timerid) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timer_delete.html">timer_delete
     * - delete a per-process timer</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method timer_delete is not
     * available natively.
     */
    public final static void timer_delete(Timer_t timerid) throws NativeErrorException, NoSuchNativeMethodException {
        if (timer_delete.invoke_sI___P(timerid) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timer_getoverrun.html">timer_getoverrun,
     * timer_gettime, timer_settime - per-process timers</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method timer_getoverrun is not
     * available natively.
     */
    public final static int timer_getoverrun(Timer_t timerid) throws NativeErrorException, NoSuchNativeMethodException {
        final int result = timer_getoverrun.invoke_sI___P(timerid);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timer_gettime.html">timer_getoverrun,
     * timer_gettime, timer_settime - per-process timers</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method timer_gettime is not
     * available natively.
     */
    public final static void timer_gettime(Timer_t timerid, Itimerspec value) throws NativeErrorException, NoSuchNativeMethodException {
        if (timer_gettime.invoke_sI___P__P(timerid, value) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    public final static void timer_settime(Timer_t timerid, int flags, Itimerspec value) throws NativeErrorException, NoSuchNativeMethodException {
        if (timer_settime.invoke_sI___P_sI__P__P(timerid, flags, value, Pointer.NULL) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timer_settime.html">timer_getoverrun,
     * timer_gettime, timer_settime - per-process timers</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void timer_settime(Timer_t timerid, int flags, Itimerspec value, Itimerspec ovalue) throws NativeErrorException, NoSuchNativeMethodException {
        if (timer_settime.invoke_sI___P_sI__P__P(timerid, flags, value, ovalue) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX.XSI:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timezone.html">daylight,
     * timezone, tzname, tzset - set timezone conversion information</a>.
     *
     * @return the native value of timezone.
     * @throws NoSuchNativeMethodException if the method timezone is not
     * available natively.
     */
    public final static long timezone() {
        return timezone.address().get(ValueLayout.JAVA_LONG, 0);
    }

    private final static MemorySegment timezone = LibcLoader.lookup("timezone").get();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tzname.html">daylight,
     * timezone, tzname, tzset - set timezone conversion information</a>.
     *
     * @return the native value of tzname.
     *
     */
    public final static String[] tzname() {
        final String[] result = new String[2];
        for (int i = 0; i < result.length; i++) {
            result[i] = tzname.address().getUtf8String(i * BaseDataType.C_pointer.SIZE_OF);
        }
        return result;
    }

    private final static MemorySegment tzname = LibcLoader.lookup("tzname").get();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tzset.html">daylight,
     * timezone, tzname, tzset - set timezone conversion information</a>.
     *
     *
     */
    public final static void tzset() {
        tzset.invoke__V___V();
    }

}
