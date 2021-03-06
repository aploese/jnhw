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

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.posix.Signal.Sigevent;
import de.ibapl.jnhw.annotation.posix.sys.types.clock_t;
import de.ibapl.jnhw.annotation.posix.sys.types.clockid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.size_t;
import de.ibapl.jnhw.annotation.posix.sys.types.time_t;
import de.ibapl.jnhw.annotation.posix.sys.types.timer_t;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import de.ibapl.jnhw.util.posix.memory.PosixStruct32;
import java.io.IOException;
import java.util.Objects;

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

    public static interface LinuxDefines {

        public final static int CLOCKS_PER_SEC = 1000000;
        public final static int CLOCK_MONOTONIC = 1;
        public final static int CLOCK_PROCESS_CPUTIME_ID = 2;
        public final static int CLOCK_REALTIME = 0;
        public final static int CLOCK_THREAD_CPUTIME_ID = 3;
        public final static int TIMER_ABSTIME = 1;

    }

    public static interface BsdDefines {

        public final static int CLOCK_REALTIME = 0;

    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int CLOCKS_PER_SEC = 1000000;
        public final static int CLOCK_MONOTONIC = 6;
        public final static int CLOCK_PROCESS_CPUTIME_ID = 12;
        public final static int CLOCK_THREAD_CPUTIME_ID = 16;

    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int CLOCKS_PER_SEC = 128;
        public final static int CLOCK_MONOTONIC = 4;
        public final static int CLOCK_PROCESS_CPUTIME_ID = 15;
        public final static int CLOCK_THREAD_CPUTIME_ID = 14;
        public final static int TIMER_ABSTIME = 1;

    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int CLOCKS_PER_SEC = 100;
        public final static int CLOCK_MONOTONIC = 3;
        public final static int CLOCK_PROCESS_CPUTIME_ID = 2;
        public final static int CLOCK_THREAD_CPUTIME_ID = 4;
        public final static int TIMER_ABSTIME = 1;

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
        final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
        switch (multiarchInfo.getOS()) {
            case LINUX:
                HAVE_TIME_H = true;
                CLOCKS_PER_SEC = LinuxDefines.CLOCKS_PER_SEC;
                CLOCK_MONOTONIC = LinuxDefines.CLOCK_MONOTONIC;
                CLOCK_PROCESS_CPUTIME_ID = LinuxDefines.CLOCK_PROCESS_CPUTIME_ID;
                CLOCK_REALTIME = LinuxDefines.CLOCK_REALTIME;
                CLOCK_THREAD_CPUTIME_ID = LinuxDefines.CLOCK_THREAD_CPUTIME_ID;
                TIMER_ABSTIME = IntDefine.toIntDefine(LinuxDefines.TIMER_ABSTIME);
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_TIME_H = true;
                CLOCK_REALTIME = BsdDefines.CLOCK_REALTIME;
                switch (multiarchInfo.getOS()) {
                    case DARWIN:
                        CLOCKS_PER_SEC = DarwinDefines.CLOCKS_PER_SEC;
                        CLOCK_MONOTONIC = DarwinDefines.CLOCK_MONOTONIC;
                        CLOCK_PROCESS_CPUTIME_ID = DarwinDefines.CLOCK_PROCESS_CPUTIME_ID;
                        CLOCK_THREAD_CPUTIME_ID = DarwinDefines.CLOCK_THREAD_CPUTIME_ID;
                        TIMER_ABSTIME = IntDefine.UNDEFINED;
                        break;
                    case FREE_BSD:
                        CLOCKS_PER_SEC = FreeBsdDefines.CLOCKS_PER_SEC;
                        CLOCK_MONOTONIC = FreeBsdDefines.CLOCK_MONOTONIC;
                        CLOCK_PROCESS_CPUTIME_ID = FreeBsdDefines.CLOCK_PROCESS_CPUTIME_ID;
                        CLOCK_THREAD_CPUTIME_ID = FreeBsdDefines.CLOCK_THREAD_CPUTIME_ID;
                        TIMER_ABSTIME = IntDefine.toIntDefine(FreeBsdDefines.TIMER_ABSTIME);
                        break;
                    case OPEN_BSD:
                        CLOCKS_PER_SEC = OpenBsdDefines.CLOCKS_PER_SEC;
                        CLOCK_MONOTONIC = OpenBsdDefines.CLOCK_MONOTONIC;
                        CLOCK_PROCESS_CPUTIME_ID = OpenBsdDefines.CLOCK_PROCESS_CPUTIME_ID;
                        CLOCK_THREAD_CPUTIME_ID = OpenBsdDefines.CLOCK_THREAD_CPUTIME_ID;
                        TIMER_ABSTIME = IntDefine.toIntDefine(OpenBsdDefines.TIMER_ABSTIME);
                        break;
                    default:
                        throw new NoClassDefFoundError("No time.h BSD defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                }
                break;
            default:
                throw new NoClassDefFoundError("No time.h Os defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
        }
    }

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

    /**
     * <b>POSIX:</b> The identifier for the system-wide monotonic clock, which
     * is defined as a clock measuring real time, whose value cannot be set via
     * clock_settime() and which cannot have negative clock jumps.The maximum
     * possible clock jump shall be implementation-defined..
     *
     */
    @Define()
    public final static int CLOCK_MONOTONIC;

    /**
     * <b>POSIX:</b> The identifier of the CPU-time clock associated with the
     * process making a clock() or timer*() function call..
     *
     */
    @Define()
    public final static int CLOCK_PROCESS_CPUTIME_ID;

    /**
     * <b>POSIX:</b> The identifier of the system-wide clock measuring real
     * time.
     *
     */
    @Define()
    public final static int CLOCK_REALTIME;

    /**
     * <b>POSIX:</b> The identifier of the CPU-time clock associated with the
     * thread making a clock() or timer*() function call..
     *
     */
    @Define()
    public final static int CLOCK_THREAD_CPUTIME_ID;

    public final static boolean HAVE_TIME_H;

    /**
     * <b>POSIX:</b> Flag indicating time is absolute.For functions taking timer
     * objects, this refers to the clock associated with the timer.
     *
     */
    @Define()
    public final static IntDefine TIMER_ABSTIME;

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
        return asctime(AbstractNativeMemory.toUintptr_t(tm));
    }

    private static native String asctime(long ptrTm);

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
    public final static String asctime_r(Tm tm, OpaqueMemory32 buf) {
        if (buf.sizeInBytes < 26) {
            throw new IllegalArgumentException("buf is too small 26 bytes are the minimum");
        }
        return asctime_r(AbstractNativeMemory.toUintptr_t(tm), AbstractNativeMemory.toUintptr_t(buf));
    }

    private static native String asctime_r(long ptrTm, long ptrBuf);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/clock.html">clock
     * - report CPU time used</a>.
     *
     * @return the processor time used by the process.
     */
    @clock_t
    public final static native long clock();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/clock_getcpuclockid.html">clock_getcpuclockid
     * - access a process CPU-time clock (ADVANCED REALTIME)</a>.
     *
     *
     * @param pid the pid to get the cpu time of. If zero the pid of the calling
     * process is used.
     * @return param clock_id the clock ID of the pid will be placed here.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     * @throws NoSuchNativeMethodException if the method clock_getcpuclockid is
     * not available natively.
     */
    @clockid_t
    public final static native int clock_getcpuclockid(@pid_t int pid) throws NativeErrorException, NoSuchNativeMethodException;

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
        clock_getres(clock_id, AbstractNativeMemory.toUintptr_t(timespec));
    }

    private static native void clock_getres(@clockid_t int clock_id, long ptrTimespec) throws NativeErrorException;

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
        clock_gettime(clock_id, AbstractNativeMemory.toUintptr_t(timespec));
    }

    private static native void clock_gettime(int clock_id, long ptrTimespec) throws NativeErrorException;

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
        clock_nanosleep(clock_id, flags, AbstractNativeMemory.toUintptr_t(rqtp), AbstractNativeMemory.toUintptr_t(rmtp));
    }

    public final static void clock_nanosleep(@clockid_t int clock_id, int flags, Timespec rqtp) throws NativeErrorException, NoSuchNativeMethodException {
        clock_nanosleep(clock_id, flags, AbstractNativeMemory.toUintptr_t(rqtp), AbstractNativeMemory.NULL);
    }

    private static native void clock_nanosleep(@clockid_t int clock_id, int flags, long ptrRqtp, long ptrRmtp) throws NativeErrorException, NoSuchNativeMethodException;

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
        clock_settime(clock_id, AbstractNativeMemory.toUintptr_t(timespec));
    }

    private static native void clock_settime(@clockid_t int clock_id, long ptrTimespec) throws NativeErrorException;

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
    public final static native String ctime(@time_t long clock);

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
    public final static String ctime_r(@time_t long clock, OpaqueMemory32 buf) {
        if (buf.sizeInBytes < 26) {
            throw new IllegalArgumentException("buf is too small 26 bytes are the minimum");
        }
        return ctime_r(clock, AbstractNativeMemory.toUintptr_t(buf));
    }

    private static native String ctime_r(@time_t long clock, long ptrBuf);

    /**
     * <b>POSIX.XSI:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/daylight.html">daylight,
     * timezone, tzname, tzset - set timezone conversion information</a>.
     *
     * @return the native value of daylight.
     * @throws NoSuchNativeMethodException if the method daylight is not
     * available natively.
     */
    public final static native int daylight() throws NoSuchNativeMethodException;

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
    public final static native double difftime(@time_t long time1, @time_t long time0);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/getdate.html">getdate
     * - convert user format date and time</a>.
     *
     * @param string the string to convert.
     *
     * @return Upon successful completion, a pointer to a struct tm.
     *
     * @throws de.ibapl.jnhw.common.exception.NativeErrorException returns the
     * getdate_err error codes.
     * @throws NoSuchNativeMethodException if the method getdate is not
     * available natively.
     */
    public final static Tm getdate(String string) throws NativeErrorException, NoSuchNativeMethodException {
        if (string == null) {
            throw new NullPointerException("string is NULL");
        }
        return new Tm(NativeAddressHolder.ofUintptr_t(getdate0(string)));
    }

    private static native long getdate0(String string) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static Tm gmtime(@time_t long timer) {
        return new Tm(NativeAddressHolder.ofUintptr_t(gmtime0(timer)));
    }

    private static native long gmtime0(@time_t long timer);

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
    public final static void gmtime_r(@time_t long timer, Tm result) throws NativeErrorException {
        gmtime_r(timer, AbstractNativeMemory.toUintptr_t(result));
    }

    private static native void gmtime_r(@time_t long timer, long ptrResult) throws NativeErrorException;

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
    public final static Tm localtime(@time_t long timer) throws NativeErrorException {
        return new Tm(NativeAddressHolder.ofUintptr_t(localtime0(timer)));
    }

    private static native long localtime0(@time_t long timer) throws NativeErrorException;

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
    public final static void localtime_r(@time_t long timer, Tm result) throws NativeErrorException {
        localtime_r(timer, AbstractNativeMemory.toUintptr_t(result));
    }

    private static native void localtime_r(@time_t long timer, long ptrResult) throws NativeErrorException;

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
        return mktime(AbstractNativeMemory.toUintptr_t(timeptr));
    }

    private static native long mktime(long timeptr) throws NativeErrorException;

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
        nanosleep(AbstractNativeMemory.toUintptr_t(rqtp), AbstractNativeMemory.toUintptr_t(rmtp));
    }

    public final static void nanosleep(Timespec rqtp) throws NativeErrorException {
        nanosleep(AbstractNativeMemory.toUintptr_t(rqtp), AbstractNativeMemory.NULL);
    }

    private static native void nanosleep(long ptrRqtp, long ptrRmtp) throws NativeErrorException;

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
        if (maxsize < 0) {
            throw new IllegalArgumentException("maxsize < 0");
        }
        if (format == null) {
            throw new NullPointerException("format is NULL");
        }
        return strftime(maxsize, format, AbstractNativeMemory.toUintptr_t(timeptr));
    }

    private static native String strftime(@size_t long maxsize, String format, long timeptr);

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
        if (maxsize < 0) {
            throw new IllegalArgumentException("maxsize < 0");
        }
        if (format == null) {
            throw new NullPointerException("format is NULL");
        }
        return strftime_l(maxsize, format, AbstractNativeMemory.toUintptr_t(timeptr), Locale.Locale_t.getNativeValue(locale));
    }

    private static native String strftime_l(@size_t long maxsize, String format, long ptrTimeptr, long ptrLocale);

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
    public final static int strptime(String buf, String format, Tm tm) {
        if (buf == null) {
            throw new NullPointerException("buf is NULL");
        }
        if (format == null) {
            throw new NullPointerException("format is NULL");
        }
        return strptime(buf, format, AbstractNativeMemory.toUintptr_t(tm));
    }

    private static native int strptime(String buf, String format, long tm);

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
    public final static native long time() throws NativeErrorException;

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
    public final static void timer_create(@clockid_t int clockid, Sigevent evp, Timer_t timerid) throws NativeErrorException, NoSuchNativeMethodException {
        timer_create(clockid, AbstractNativeMemory.toUintptr_t(evp), AbstractNativeMemory.toUintptr_t(timerid));
    }

    public final static void timer_create(@clockid_t int clockid, Timer_t timerid) throws NativeErrorException, NoSuchNativeMethodException {
        timer_create(clockid, AbstractNativeMemory.NULL, AbstractNativeMemory.toUintptr_t(timerid));
    }

    private static native void timer_create(@clockid_t int clockid, long ptrEvp, long ptrTimerid) throws NativeErrorException, NoSuchNativeMethodException;

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
        timer_delete(AbstractNativeMemory.toUintptr_t(timerid));
    }

    private static native void timer_delete(long timerid) throws NativeErrorException, NoSuchNativeMethodException;

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
        return timer_getoverrun(AbstractNativeMemory.toUintptr_t(timerid));
    }

    private static native int timer_getoverrun(long ptrTimerid) throws NativeErrorException, NoSuchNativeMethodException;

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
        timer_gettime(AbstractNativeMemory.toUintptr_t(timerid), AbstractNativeMemory.toUintptr_t(value));
    }

    private static native void timer_gettime(long ptrTimerid, long ptrValue) throws NativeErrorException, NoSuchNativeMethodException;

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
        timer_settime(AbstractNativeMemory.toUintptr_t(timerid), flags, AbstractNativeMemory.toUintptr_t(value), AbstractNativeMemory.toUintptr_t(ovalue));
    }

    public final static void timer_settime(Timer_t timerid, int flags, Itimerspec value) throws NativeErrorException, NoSuchNativeMethodException {
        timer_settime(AbstractNativeMemory.toUintptr_t(timerid), flags, AbstractNativeMemory.toUintptr_t(value), AbstractNativeMemory.NULL);
    }

    private static native void timer_settime(long ptrTimerid, int flags, long ptrValue, long ptrOvalue) throws NativeErrorException, NoSuchNativeMethodException;

    /**
     * <b>POSIX.XSI:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timezone.html">daylight,
     * timezone, tzname, tzset - set timezone conversion information</a>.
     *
     * @return the native value of timezone.
     * @throws NoSuchNativeMethodException if the method timezone is not
     * available natively.
     */
    public final static native long timezone() throws NoSuchNativeMethodException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tzname.html">daylight,
     * timezone, tzname, tzset - set timezone conversion information</a>.
     *
     * @return the native value of tzname.
     *
     */
    public final static native String[] tzname();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tzset.html">daylight,
     * timezone, tzname, tzset - set timezone conversion information</a>.
     *
     *
     */
    public final static native void tzset();

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
     * itimerspec}</a>.
     *
     */
    public static class Itimerspec extends Struct32 {

        public final static long offsetof_It_interval;
        public final static long offsetof_It_value;
        public final static Alignment alignof;
        public final static int sizeof;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();

            final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
            switch (multiarchInfo.getOS()) {
                case DARWIN:
                    offsetof_It_interval = -1;
                    offsetof_It_value = -1;
                    alignof = null;
                    sizeof = 0;
                    break;
                default:
                    offsetof_It_interval = 0;
                    switch (multiarchInfo.getSizeOfPointer()) {
                        case _32_BIT:
                            offsetof_It_value = 8;
                            alignof = Alignment.AT_4;
                            sizeof = 16;
                            break;
                        case _64_BIT:
                            offsetof_It_value = 16;
                            alignof = Alignment.AT_8;
                            sizeof = 32;
                            break;
                        default:
                            throw new NoClassDefFoundError("No time.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                    }
            }
        }

        public Itimerspec(SetMem setMem) throws NoSuchNativeTypeException {
            this(null, 0, setMem);
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Itimerspec");
            }
        }

        public Itimerspec(OpaqueMemory32 owner, int offset, SetMem setMem) throws NoSuchNativeTypeException {
            super((OpaqueMemory32) owner, 0, Itimerspec.sizeof, setMem);
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Itimerspec");
            }
            it_interval = new Timespec(this, Itimerspec.offsetof_It_interval, SetMem.DO_NOT_SET);//mem is already initialized by parent
            it_value = new Timespec(this, Itimerspec.offsetof_It_value, SetMem.DO_NOT_SET);//mem is already initialized by parent
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

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 23 * hash + Objects.hashCode(this.it_interval);
            hash = 23 * hash + Objects.hashCode(this.it_value);
            return hash;
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
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendStruct32Member("it_value", it_value);
            jsb.appendStruct32Member("it_interval", it_interval);
            jsb.close();
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
     * timespec}</a>.
     *
     */
    public static class Timespec extends PosixStruct32 {

        public final static long offsetof_Tv_sec = 0;
        public final static long offsetof_Tv_nsec;
        public final static Alignment alignof;
        public final static int sizeof;

        static {
            LibJnhwPosixLoader.touch();
            final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
            switch (multiarchInfo.getSizeOfPointer()) {
                case _32_BIT:
                    offsetof_Tv_nsec = 4;
                    alignof = Alignment.AT_4;
                    sizeof = 8;
                    break;
                case _64_BIT:
                    offsetof_Tv_nsec = 8;
                    alignof = Alignment.AT_8;
                    sizeof = 16;
                    break;
                default:
                    throw new NoClassDefFoundError("No time.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
            }
        }

        public Timespec(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, Timespec.sizeof, setMem);
        }

        public Timespec(SetMem setMem) {
            this(null, 0, setMem);
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
            return ACCESSOR_TIME_T.time_t(this, Timespec.offsetof_Tv_sec);
        }

        /**
         * Seconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @param tv_sec the value of tv_sec to be set natively.
         */
        public void tv_sec(@time_t long tv_sec) {
            ACCESSOR_TIME_T.time_t(this, Timespec.offsetof_Tv_sec, tv_sec);
        }

        /**
         * Nanoseconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @return the native value of tv_nsec.
         */
        public long tv_nsec() {
            return MEM_ACCESS.signed_long(this, Timespec.offsetof_Tv_nsec);
        }

        /**
         * Nanoseconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @param tv_nsec the value of tv_nsec to be set natively.
         */
        public void tv_nsec(long tv_nsec) {
            MEM_ACCESS.signed_long(this, Timespec.offsetof_Tv_nsec, tv_nsec);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendLongMember("tv_sec", tv_sec());
            jsb.appendLongMember("tv_nsec", tv_nsec());
            jsb.close();
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 97 * hash + (int) (this.tv_sec() ^ (this.tv_sec() >>> 32));
            hash = 97 * hash + (int) (this.tv_nsec() ^ (this.tv_nsec() >>> 32));
            return hash;
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

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
     * tm}</a>.
     *
     */
    public static class Tm extends Struct32 {

        public final static long offsetof_Tm_sec = 0;
        public final static long offsetof_Tm_min;
        public final static long offsetof_Tm_hour;
        public final static long offsetof_Tm_mday;
        public final static long offsetof_Tm_mon;
        public final static long offsetof_Tm_year;
        public final static long offsetof_Tm_wday;
        public final static long offsetof_Tm_yday;
        public final static long offsetof_Tm_isdst;
        public final static Alignment alignof;
        public final static int sizeof;

        static {
            LibJnhwPosixLoader.touch();

            final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
            offsetof_Tm_min = 4;
            offsetof_Tm_hour = 8;
            offsetof_Tm_mday = 12;
            offsetof_Tm_mon = 16;
            offsetof_Tm_year = 20;
            offsetof_Tm_wday = 24;
            offsetof_Tm_yday = 28;
            offsetof_Tm_isdst = 32;
            switch (multiarchInfo.getSizeOfPointer()) {
                case _32_BIT:
                    alignof = Alignment.AT_4;
                    sizeof = 44;
                    break;
                case _64_BIT:
                    alignof = Alignment.AT_8;
                    sizeof = 56;
                    break;
                default:
                    throw new NoClassDefFoundError("No time.h defines for " + multiarchInfo);
            }
        }

        public Tm(NativeAddressHolder addressHolder) {
            super(addressHolder, Tm.sizeof);
        }

        public Tm(SetMem setMem) {
            this(null, 0, setMem);
        }

        public Tm(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, Tm.sizeof, setMem);
        }

        /**
         * Seconds [0,60].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_sec.
         */
        public int tm_sec() {
            return MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_sec);
        }

        /**
         * Minutes [0,59].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_min.
         */
        public int tm_min() {
            return MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_min);
        }

        /**
         * Hour [0,23].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_hour.
         */
        public int tm_hour() {
            return MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_hour);
        }

        /**
         * Day of month [1,31].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_mday.
         */
        public int tm_mday() {
            return MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_mday);
        }

        /**
         * Month of year [0,11].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_mon.
         */
        public int tm_mon() {
            return MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_mon);
        }

        /**
         * Years since 1900.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_year.
         */
        public int tm_year() {
            return MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_year);
        }

        /**
         * Day of week [0,6] (Sunday = 0 ).
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_wday.
         */
        public int tm_wday() {
            return MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_wday);
        }

        /**
         * Day of year [0,365].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_yday.
         */
        public int tm_yday() {
            return MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_yday);
        }

        /**
         * Daylight Savings flag.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_isdst.
         */
        public int tm_isdst() {
            return MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_isdst);
        }

        /**
         * Seconds [0,60].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_sec the value of tm_sec to be set natively.
         */
        public void tm_sec(int tm_sec) {
            MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_sec, tm_sec);
        }

        /**
         * Minutes [0,59].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_min the value of tm_min to be set natively.
         */
        public void tm_min(int tm_min) {
            MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_min, tm_min);
        }

        /**
         * Hour [0,23].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_hour the value of tm_hour to be set natively.
         */
        public void tm_hour(int tm_hour) {
            MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_hour, tm_hour);
        }

        /**
         * Day of month [1,31].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_mday the value of tm_mday to be set natively.
         */
        public void tm_mday(int tm_mday) {
            MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_mday, tm_mday);
        }

        /**
         * Month of year [0,11].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_mon the value of tm_mon to be set natively.
         */
        public void tm_mon(int tm_mon) {
            MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_mon, tm_mon);
        }

        /**
         * Years since 1900.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_year the value of tm_year to be set natively.
         */
        public void tm_year(int tm_year) {
            MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_year, tm_year);
        }

        /**
         * Day of week [0,6] (Sunday = 0 ).
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_wday the value of tm_wday to be set natively.
         */
        public void tm_wday(int tm_wday) {
            MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_wday, tm_wday);
        }

        /**
         * Day of year [0,365].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_yday the value of tm_yday to be set natively.
         */
        public void tm_yday(int tm_yday) {
            MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_yday, tm_yday);
        }

        /**
         * Daylight Savings flag.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_isdst the value of tm_isdst to be set natively.
         */
        public void tm_isdst(int tm_isdst) {
            MEM_ACCESS.int32_t(this, Tm.offsetof_Tm_isdst, tm_isdst);
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

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">{@code typedef
     * pthread_t}</a>.
     *
     * @author aploese
     */
    @timer_t
    public static final class Timer_t extends Struct32 {

        public final static Alignment alignof;
        public final static int sizeof;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
            switch (multiarchInfo.getOS()) {
                case DARWIN:
                    alignof = null;
                    sizeof = 0;
                    break;
                case LINUX:
                case FREE_BSD:
                    switch (multiarchInfo.getSizeOfPointer()) {
                        case _32_BIT:
                            alignof = Alignment.AT_4;
                            sizeof = 4;
                            break;
                        case _64_BIT:
                            alignof = Alignment.AT_8;
                            sizeof = 8;
                            break;
                        default:
                            throw new NoClassDefFoundError("No time.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                    }
                    break;
                case OPEN_BSD:
                    alignof = Alignment.AT_4;
                    sizeof = 4;
                    break;
                default:
                    throw new NoClassDefFoundError("No time.h OS defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
            }
        }

        public Timer_t(SetMem setMem) throws NoSuchNativeTypeException {
            this(null, 0, setMem);
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Timer_t");
            }
        }

        public Timer_t(AbstractNativeMemory parent, long offset, SetMem setMem) throws NoSuchNativeTypeException {
            super(parent, offset, Timer_t.sizeof, setMem);
            if (alignof == null) {
                throw new NoSuchNativeTypeException("Timer_t");
            }
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            sb.append(nativeToString());
        }

        @Override
        public String nativeToString() {
            switch (Timer_t.sizeof) {
                case 4:
                    return MEM_ACCESS.uint32_t_AsHex(this, 0);
                case 8:
                    return MEM_ACCESS.uint64_t_AsHex(this, 0);
                default:
                    throw new RuntimeException("cant handle Time_t nativeToString current size: " + Timer_t.sizeof);
            }
        }

    }

}
