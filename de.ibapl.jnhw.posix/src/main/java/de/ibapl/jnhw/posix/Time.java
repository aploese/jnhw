/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LongRef;
import de.ibapl.jnhw.NativeAddressHolder;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.posix.Signal.Sigevent;
import de.ibapl.jnhw.posix.sys.Types;
import de.ibapl.jnhw.posix.sys.Types.clock_t;
import de.ibapl.jnhw.posix.sys.Types.clockid_t;
import de.ibapl.jnhw.posix.sys.Types.pid_t;
import de.ibapl.jnhw.posix.sys.Types.size_t;
import de.ibapl.jnhw.posix.sys.Types.time_t;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
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

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    /**
     * <b>POSIX:</b> A number used to convert the value returned by the clock()
     * function into seconds. The value shall be an expression with type
     * clock_t. [XSI] [Option Start] The value of CLOCKS_PER_SEC shall be 1
     * million on XSI-conformant systems. However, it may be variable on other
     * systems, and it should not be assumed that CLOCKS_PER_SEC is a
     * compile-time constant. .
     *
     * @return the native symbol of CLOCKS_PER_SEC.
     */
    @Define()
    public final static native @clock_t
    int CLOCKS_PER_SEC();

    /**
     * <b>POSIX:</b> The identifier for the system-wide monotonic clock, which
     * is defined as a clock measuring real time, whose value cannot be set via
     * clock_settime() and which cannot have negative clock jumps. The maximum
     * possible clock jump shall be implementation-defined..
     *
     * @return the native symbolic constant of CLOCK_MONOTONIC.
     */
    @Define()
    public final static native int CLOCK_MONOTONIC();

    /**
     * <b>POSIX:</b> The identifier of the CPU-time clock associated with the
     * process making a clock() or timer*() function call..
     *
     * @return the native symbolic constant of CLOCK_PROCESS_CPUTIME_ID.
     */
    @Define()
    public final static native int CLOCK_PROCESS_CPUTIME_ID();

    /**
     * <b>POSIX:</b> The identifier of the system-wide clock measuring real
     * time.
     *
     * @return the native symbolic constant of CLOCK_REALTIME.
     */
    @Define()
    public final static native int CLOCK_REALTIME();

    /**
     * <b>POSIX:</b> The identifier of the CPU-time clock associated with the
     * thread making a clock() or timer*() function call..
     *
     * @return the native symbolic constant of CLOCK_THREAD_CPUTIME_ID.
     */
    @Define()
    public final static native int CLOCK_THREAD_CPUTIME_ID();

    public final static native boolean HAVE_TIME_H();

    /**
     * <b>POSIX:</b> Flag indicating time is absolute. For functions taking
     * timer objects, this refers to the clock associated with the timer.
     *
     * @return the native symbolic constant of TIMER_ABSTIME.
     */
    @Define()
    public final static native int TIMER_ABSTIME();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/asctime.html">asctime,
     * asctime_r - convert date and time to a string</a>.
     *
     * @param tm the time to convert.
     *
     * @return on succes the converted date and time, otherwise {@code null}
     */
    public final static native String asctime(Tm tm);

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
    public final static native String asctime_r(Tm tm, OpaqueMemory buf);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/clock.html">clock
     * - report CPU time used</a>.
     *
     * @return the processor time used by the process.
     */
    public final static native @clock_t
    long clock();

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
     * @throws NullPointerException if clock_id is {@code null}
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void clock_getcpuclockid(@pid_t int pid, @clockid_t IntRef clock_id) throws NativeErrorException;

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
    public final static native void clock_getres(@clockid_t int clock_id, Timespec timespec) throws NativeErrorException;

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
    public final static native void clock_gettime(@clockid_t int clock_id, Timespec timespec) throws NativeErrorException;

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
     */
    public final static native void clock_nanosleep(@clockid_t int clock_id, int flags, Timespec rqtp, Timespec rmtp) throws NativeErrorException;

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
    public final static native void clock_settime(@clockid_t int clock_id, Timespec timespec) throws NativeErrorException;

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
    public final static native String ctime_r(@time_t long clock, OpaqueMemory buf);

    /**
     * <b>POSIX.XSI:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/daylight.html">daylight,
     * timezone, tzname, tzset - set timezone conversion information</a>.
     *
     * @return the native value of daylight.
     * @throws NoSuchNativeMethodException
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
     * @throws de.ibapl.jnhw.NativeErrorException returns the getdate_err error
     * codes.
     * @throws NoSuchNativeMethodException
     */
    public final static native Tm getdate(String string) throws NativeErrorException, NoSuchNativeMethodException;

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
    public final static native Tm gmtime(@time_t long timer);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/gmtime.html">gmtime,
     * gmtime_r - convert a time value to a broken-down UTC time</a>.
     *
     *
     * @param timer time in seconds since the Epoch
     * @param result a sruct tm ({@link Tm}) to hold the result.
     * @return on successful completion, {@code result}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native Tm gmtime_r(@time_t long timer, Tm result) throws NativeErrorException;

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
    public final static native Tm localtime(@time_t long timer) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/localtime_r.html">poll
     * - input/output multiplexing</a>.
     *
     * @param timer the time in seconds since the Epoch.
     * @param result a sruct tm ({@link Tm}) to hold the result.
     * @return on successful completion, a pointer to the broken-down time
     * structure {@code result}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native Tm localtime_r(@time_t long timer, Tm result) throws NativeErrorException;

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
    public final static native @time_t
    long mktime(Tm timeptr) throws NativeErrorException;

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
    public final static native void nanosleep(Timespec rqtp, Timespec rmtp) throws NativeErrorException;

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
    public final static native String strftime(@size_t long maxsize, String format, Tm timeptr);

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
    public final static native String strftime_l(@size_t long maxsize, String format, Tm timeptr, Locale.Locale_t locale);

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
    public final static native String strptime(String buf, String format, Tm tm);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/time.html">time
     * - get time</a>.
     *
     *
     * @param tloc an area where the return value is also stored.
     * @return the value of time.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native @time_t
    long time(@time_t LongRef tloc) throws NativeErrorException;

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
     *
     */
    public final static native void timer_create(@clockid_t int clockid, Sigevent evp, Timer_t timerid) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timer_delete.html">timer_delete
     * - delete a per-process timer</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void timer_delete(Timer_t timerid) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timer_getoverrun.html">timer_getoverrun,
     * timer_gettime, timer_settime - per-process timers</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int timer_getoverrun(Timer_t timerid) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timer_gettime.html">timer_getoverrun,
     * timer_gettime, timer_settime - per-process timers</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void timer_gettime(Timer_t timerid, Itimerspec value) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timer_settime.html">timer_getoverrun,
     * timer_gettime, timer_settime - per-process timers</a>.
     *
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void timer_settime(Timer_t timerid, int flags, Itimerspec value, Itimerspec ovalue) throws NativeErrorException;

    /**
     * <b>POSIX.XSI:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/timezone.html">daylight,
     * timezone, tzname, tzset - set timezone conversion information</a>.
     *
     * @return the native value of timezone.
     * @throws NoSuchNativeMethodException
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
    public static class Itimerspec extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct itimerspec natively.
         *
         * @return the native value sizeof(struct itimerspec).
         */
        public static native int sizeof_itimerspec();

        public static native int offsetof_it_interval();

        public static native int offsetof_it_value();

        public Itimerspec(boolean clearMem) {
            super(sizeof_itimerspec(), clearMem);
            it_interval = new Timespec(this, offsetof_it_interval());
            it_value = new Timespec(this, offsetof_it_value());
        }

        public Itimerspec() {
            this(true);
        }

        /**
         * Timer period.
         * After the timer expires after it_value, it will fire
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
            if (!Objects.equals(this.it_value, other.it_value)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return String.format("{it_value : %s, it_interval : %s}", it_value, it_interval);
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
     * timespec}</a>.
     *
     */
    public static class Timespec extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        public static native int sizeofTimespec();

        public Timespec() {
            super(sizeofTimespec(), false);
        }

        public Timespec(OpaqueMemory parent, int offset) {
            super(parent, offset, sizeofTimespec());
        }

        public Timespec(boolean cleanMem) {
            super(sizeofTimespec(), cleanMem);
        }

        /**
         * Seconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @return the native value of tv_sec.
         */
        public native @time_t
        long tv_sec();

        /**
         * Seconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @param tv_sec the value of tv_sec to be set natively.
         */
        public native void tv_sec(@time_t long tv_sec);

        /**
         * Nanoseconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @return the native value of tv_nsec.
         */
        public native long tv_nsec();

        /**
         * Nanoseconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @param tv_nsec the value of tv_nsec to be set natively.
         */
        public native void tv_nsec(long tv_nsec);

        @Override
        public String toString() {
            return String.format("{tv_sec : %d, tv_nsec : %d}", tv_sec(), tv_nsec());
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
            if (this.tv_nsec() != other.tv_nsec()) {
                return false;
            }
            return true;
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
     * tm}</a>.
     *
     */
    public static class Tm extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct tm natively.
         *
         * @return the native value sizeof(struct tm).
         */
        public static native int sizeofTm();

        /**
         * To be called only from native code ...
         *
         * @param addressHolder
         */
        private Tm(NativeAddressHolder addressHolder, int sizeof) {
            super(addressHolder, sizeof);
        }

        public Tm() {
            super(sizeofTm(), false);
        }

        /**
         * Seconds [0,60].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_sec.
         */
        public native int tm_sec();

        /**
         * Minutes [0,59].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_min.
         */
        public native int tm_min();

        /**
         * Hour [0,23].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_hour.
         */
        public native int tm_hour();

        /**
         * Day of month [1,31].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_mday.
         */
        public native int tm_mday();

        /**
         * Month of year [0,11].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_mon.
         */
        public native int tm_mon();

        /**
         * Years since 1900.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_year.
         */
        public native int tm_year();

        /**
         * Day of week [0,6] (Sunday = 0 ).
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_wday.
         */
        public native int tm_wday();

        /**
         * Day of year [0,365].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_yday.
         */
        public native int tm_yday();

        /**
         * Daylight Savings flag.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @return the native value of tm_isdst.
         */
        public native int tm_isdst();

        /**
         * Seconds [0,60].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_sec the value of tm_sec to be set natively.
         */
        public native void tm_sec(int tm_sec);

        /**
         * Minutes [0,59].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_min the value of tm_min to be set natively.
         */
        public native void tm_min(int tm_min);

        /**
         * Hour [0,23].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_hour the value of tm_hour to be set natively.
         */
        public native void tm_hour(int tm_hour);

        /**
         * Day of month [1,31].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_mday the value of tm_mday to be set natively.
         */
        public native void tm_mday(int tm_mday);

        /**
         * Month of year [0,11].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_mon the value of tm_mon to be set natively.
         */
        public native void tm_mon(int tm_mon);

        /**
         * Years since 1900.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_year the value of tm_year to be set natively.
         */
        public native void tm_year(int tm_year);

        /**
         * Day of week [0,6] (Sunday = 0 ).
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_wday the value of tm_wday to be set natively.
         */
        public native void tm_wday(int tm_wday);

        /**
         * Day of year [0,365].
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_yday the value of tm_yday to be set natively.
         */
        public native void tm_yday(int tm_yday);

        /**
         * Daylight Savings flag.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * tm}</a>.
         *
         * @param tm_isdst the value of tm_isdst to be set natively.
         */
        public native void tm_isdst(int tm_isdst);

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{tm_year : " + tm_year());
            sb.append(", tm_yday : " + tm_yday());
            sb.append(", tm_mon : " + tm_mon());
            sb.append(", tm_mday : " + tm_mday());
            sb.append(", tm_wday : " + tm_wday());
            sb.append(", tm_hour : " + tm_hour());
            sb.append(", tm_min : " + tm_min());
            sb.append(", tm_sec : " + tm_sec());
            sb.append(", tm_isdst : " + tm_isdst());
            sb.append("}");
            return sb.toString();
        }

    }
    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/pthread.h.html">{@code typedef
     * pthread_t}</a>.
     *
     * @author aploese
     */
    @Types.timer_t
    public static final class Timer_t extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of timer_t natively.
         *
         * @return the native value sizeof(timer_t).
         */
        public static native int sizeofTimer_t();

        public Timer_t() {
            super(sizeofTimer_t(), false);
        }

        public Timer_t(boolean cleanMem) {
            super(sizeofTimer_t(), cleanMem);
        }

        @Override
        public native String toString();

    }

}
