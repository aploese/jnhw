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

import de.ibapl.jnhw.Callback_I_V_Impl;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LongRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.NoSuchNativeMethodException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.Defines;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class TimeTest {

    private static MultiarchTupelBuilder multiarchTupelBuilder;

    @BeforeAll
    public static void setUpClass() {
        multiarchTupelBuilder = new MultiarchTupelBuilder();
    }

    public TimeTest() {
    }

    /**
     * Test of asctime method, of class Time.
     */
    @Test
    public void testAsctime() {
        System.out.println("asctime");
        Time.Tm tm = new Time.Tm();
        tm.tm_year(119);
        tm.tm_mon(11);
        tm.tm_mday(3);
        tm.tm_wday(3);
        tm.tm_hour(8);
        tm.tm_min(17);
        tm.tm_sec(7);
        tm.tm_isdst(0);

        String result = Time.asctime(tm);
        assertEquals("Wed Dec  3 08:17:07 2019\n", result);
        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.asctime(null);
        });
    }

    /**
     * Test of asctime_r method, of class Time.
     */
    @Test
    public void testAsctime_r() {
        System.out.println("asctime_r");
        Time.Tm tm = new Time.Tm();
        tm.tm_year(119);
        tm.tm_mon(11);
        tm.tm_mday(3);
        tm.tm_wday(3);
        tm.tm_hour(8);
        tm.tm_min(17);
        tm.tm_sec(7);
        tm.tm_isdst(0);

        OpaqueMemory buf = new OpaqueMemory(26, true);
        String result = Time.asctime_r(tm, buf);
        assertEquals("Wed Dec  3 08:17:07 2019\n", result);
        byte[] raw = new byte[buf.sizeInBytes];
        OpaqueMemory.copy(buf, 0, raw, 0, raw.length);
        assertArrayEquals("Wed Dec  3 08:17:07 2019\n\0".getBytes(), raw);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.asctime_r(null, buf);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.asctime_r(tm, null);
        });
        //Test that there at least 26 bytes available in the buffer.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Time.asctime_r(tm, new OpaqueMemory(25, true));
        });
    }

    /**
     * Test of clock method, of class Time.
     */
    @Test
    public void testClock() {
        System.out.println("clock");
        long result = Time.clock();
        Assertions.assertNotEquals(-1, result);
    }

    /**
     * Test of clock_getcpuclockid method, of class Time.
     */
    @Test
    public void testClock_getcpuclockid() throws Exception {
        System.out.println("clock_getcpuclockid");
        int pid = 0;
        IntRef clock_id = new IntRef();
        Time.clock_getcpuclockid(pid, clock_id);
        Assertions.assertNotEquals(0, clock_id.value);
    }

    /**
     * Test of clock_getres method, of class Time.
     */
    @Test
    public void testClock_getres() throws Exception {
        System.out.println("clock_getres");
        Time.Timespec timespec = new Time.Timespec(true);
        Time.clock_getres(Time.CLOCK_MONOTONIC(), timespec);

        assertEquals(0, timespec.tv_sec());
        if (multiarchTupelBuilder.getOS() == de.ibapl.jnhw.libloader.OS.FREE_BSD) {
            //is this true? it was running in a virt environment
            assertEquals(280, timespec.tv_nsec());
        } else {
            assertEquals(1, timespec.tv_nsec());
        }

        Time.clock_getres(Time.CLOCK_REALTIME(), null);

    }

    /**
     * Test of clock_gettime method, of class Time.
     */
    @Test
    public void testClock_gettime() throws Exception {
        System.out.println("clock_gettime");
        int clock_id = Time.CLOCK_MONOTONIC();
        Time.Timespec timespec = new Time.Timespec(true);
        Time.clock_gettime(clock_id, timespec);

        System.out.println("timespec: " + timespec);
        Assertions.assertTrue(timespec.tv_sec() > 0, "timespec.tv_sec() > 0");
        Assertions.assertTrue(timespec.tv_nsec() >= 0, "timespec.tv_nsec() >= 0");

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.clock_gettime(Time.CLOCK_REALTIME(), null);
        });
    }

    /**
     * Test of clock_nanosleep method, of class Time.
     */
    @Test
    public void testClock_nanosleep() throws Exception {
        System.out.println("clock_nanosleep");

        int clock_id = Time.CLOCK_MONOTONIC();
        int flags = 0;
        Time.Timespec rqtp = new Time.Timespec(true);
        rqtp.tv_nsec(10_000_000L); //10ms
        Time.Timespec rmtp = new Time.Timespec();

        long start = System.nanoTime();
        Time.clock_nanosleep(clock_id, flags, rqtp, rmtp);
        long end = System.nanoTime();

        Assertions.assertTrue(end - start < 12_000_000, "max 12ms but was " + (end - start) + "ns");
        Assertions.assertTrue(end - start > 9_000_000, "min 9ms");

        rqtp.tv_nsec(0);
        Time.clock_nanosleep(clock_id, flags, rqtp, rmtp);

        Time.clock_nanosleep(clock_id, flags, rqtp, null);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.clock_nanosleep(clock_id, flags, null, null);
        });
    }

    /**
     * Test of clock_settime method, of class Time.
     */
    @Test
    public void testClock_settime() throws Exception {
        System.out.println("clock_settime");

        Time.Timespec timespec = new Time.Timespec(true);

        //We should not habe the priveleges to set the CLOCK_REALTIME ... so a NativeErrorException with EPERM as errno should be thrown.
        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
            Time.clock_settime(Time.CLOCK_REALTIME(), timespec);
        });
        assertEquals(Errno.EPERM(), nee.errno, "EPERM expected but got " + Errno.getErrnoSymbol(nee.errno));

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.clock_settime(Time.CLOCK_REALTIME(), null);
        });
    }

    /**
     * Test of ctime method, of class Time.
     */
    @Test
    public void testCtime() {
        System.out.println("ctime");
        long clock = 1575382844;
        String result = Time.ctime(clock);
        ZonedDateTime zdt = Instant.ofEpochMilli(clock * 1000L).atZone(ZoneOffset.systemDefault());
        DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();
        dtfb.appendPattern("E LLL  d H:m:s y\n");
        assertEquals(dtfb.toFormatter(java.util.Locale.ROOT).format(zdt), result);
    }

    /**
     * Test of ctime_r method, of class Time.
     */
    @Test
    public void testCtime_r() {
        System.out.println("ctime_r");
        long clock = 1575382844;
        OpaqueMemory buf = new OpaqueMemory(26, true);
        String result = Time.ctime_r(clock, buf);
        assertEquals("Tue Dec  3 15:20:44 2019\n", result);

        byte[] raw = new byte[buf.sizeInBytes];
        OpaqueMemory.copy(buf, 0, raw, 0, raw.length);
        assertArrayEquals("Tue Dec  3 15:20:44 2019\n\0".getBytes(), raw);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.ctime_r(clock, null);
        });
        //Test that there at least 26 bytes available in the buffer.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Time.ctime_r(clock, new OpaqueMemory(25, true));
        });
    }

    /**
     * Test of daylight method, of class Time.
     */
    @Test
    public void testDaylight() throws Exception {
        System.out.println("daylight");
        if (multiarchTupelBuilder.getOS() == OS.FREE_BSD) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Time.daylight();
            });
        } else {
            final int oldDaylight = Time.daylight();
            assertEquals(oldDaylight, Time.daylight());
        }
    }

    /**
     * Test of difftime method, of class Time.
     */
    @Test
    public void testDifftime() {
        System.out.println("difftime");
        long time1 = 0L;
        long time0 = 1L;
        double expResult = -1.0;
        double result = Time.difftime(time1, time0);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getdate method, of class Time.
     */
    @Test
    public void testGetdate() {
        System.out.println("getdate");
        String string = "Tue Dec  3 15:20:44 2019\n";
        if (multiarchTupelBuilder.getOS() == OS.FREE_BSD) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Time.Tm result = Time.getdate(string);
            });
        } else {
            NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                Time.Tm result = Time.getdate(string);
            });
            assertEquals(1, nee.errno, "getdate_err no DATEMSK expected");
        }
    }

    /**
     * Test of gmtime method, of class Time.
     */
    @Test
    public void testGmtime() {
        System.out.println("gmtime");
        long timer = 1575382844;
        Time.Tm result = Time.gmtime(timer);

        assertEquals(119, result.tm_year(), "Year");
        assertEquals(336, result.tm_yday(), "DayOfYear");
        assertEquals(11, result.tm_mon(), "MonthValue");
        assertEquals(3, result.tm_mday(), "DayOfMonth");
        assertEquals(2, result.tm_wday(), "DayOfWeek");
        assertEquals(14, result.tm_hour(), "Hour");
        assertEquals(20, result.tm_min(), "Minute");
        assertEquals(44, result.tm_sec(), "Second");
    }

    /**
     * Test of gmtime_r method, of class Time.
     */
    @Test
    public void testGmtime_r() throws Exception {
        System.out.println("gmtime_r");
        long timer = 1575382844;
        Time.Tm tm = new Time.Tm();
        Time.Tm result = Time.gmtime_r(timer, tm);

        assertEquals(119, result.tm_year(), "Year");
        assertEquals(336, result.tm_yday(), "DayOfYear");
        assertEquals(11, result.tm_mon(), "MonthValue");
        assertEquals(3, result.tm_mday(), "DayOfMonth");
        assertEquals(2, result.tm_wday(), "DayOfWeek");
        assertEquals(14, result.tm_hour(), "Hour");
        assertEquals(20, result.tm_min(), "Minute");
        assertEquals(44, result.tm_sec(), "Second");

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.gmtime_r(timer, null);
        });

    }

    /**
     * Test of localtime method, of class Time.
     */
    @Test
    public void testLocaltime() throws Exception {
        System.out.println("localtime");
        final LocalDateTime ldt = LocalDateTime.now();
        long timer = new Date().getTime() / 1000;
        Time.Tm result = Time.localtime(timer);
        Assertions.assertNotNull(result);
        System.out.println("time: " + timer + " localtime: " + result);
        assertEquals(ldt.getYear(), result.tm_year() + 1900, "Year");
        assertEquals(ldt.getDayOfYear(), result.tm_yday() + 1, "DayOfYear");
        assertEquals(ldt.getMonthValue(), result.tm_mon() + 1, "MonthValue");
        assertEquals(ldt.getDayOfMonth(), result.tm_mday(), "DayOfMonth");
        if (ldt.getDayOfWeek() == DayOfWeek.SUNDAY) {
            //Sunday java = 7; posix = 0
            assertEquals(0, result.tm_wday(), "DayOfWeek SUNDAY -> 0(sun)");
        } else {
            assertEquals(ldt.getDayOfWeek().getValue(), result.tm_wday(), "DayOfWeek MONDAY to SATURDAY -> 1(mon) to 6(sat)");
        }
        assertEquals(ldt.getHour(), result.tm_hour(), "Hour");
        assertEquals(ldt.getMinute(), result.tm_min(), "Minute");
        assertEquals(ldt.getSecond(), result.tm_sec(), "Second");
    }

    /**
     * Test of localtime_r method, of class Time.
     */
    @Test
    public void testLocaltime_r() throws Exception {
        System.out.println("localtime_r");
        final LocalDateTime ldt = LocalDateTime.now();
        long timer = System.currentTimeMillis() / 1000;
        Time.Tm tm = new Time.Tm();

        Time.Tm result = Time.localtime_r(timer, tm);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(tm, result);

        System.out.println("time: " + timer + " localtime: " + result);
        assertEquals(ldt.getYear(), result.tm_year() + 1900, "Year");
        assertEquals(ldt.getDayOfYear(), result.tm_yday() + 1, "DayOfYear");
        assertEquals(ldt.getMonthValue(), result.tm_mon() + 1, "MonthValue");
        assertEquals(ldt.getDayOfMonth(), result.tm_mday(), "DayOfMonth");
        if (ldt.getDayOfWeek() == DayOfWeek.SUNDAY) {
            //Sunday java = 7; posix = 0
            assertEquals(0, result.tm_wday(), "DayOfWeek SUNDAY -> 0(sun)");
        } else {
            assertEquals(ldt.getDayOfWeek().getValue(), result.tm_wday(), "DayOfWeek MONDAY to SATURDAY -> 1(mon) to 6(sat)");
        }
        assertEquals(ldt.getHour(), result.tm_hour(), "Hour");
        assertEquals(ldt.getMinute(), result.tm_min(), "Minute");
        assertEquals(ldt.getSecond(), result.tm_sec(), "Second");

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.localtime_r(timer, null);
        });
    }

    /**
     * Test of mktime method, of class Time.
     */
    @Test
    public void testMktime() throws Exception {
        System.out.println("mktime");
        long timer = System.currentTimeMillis() / 1000;
        Time.Tm tm = Time.localtime(timer);
        long result = Time.mktime(tm);
        assertEquals(timer, result);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.mktime(null);
        });
    }

    /**
     * Test Time.Timespec
     */
    @Test
    public void testStructTimespec() {
        System.out.println("struct timespec");
        Time.Timespec timespec = new Time.Timespec();
        timespec.tv_nsec(10_000_000L); //10ms
        timespec.tv_sec(42);
        assertEquals(10_000_000L, timespec.tv_nsec(), "tv_sec");
        assertEquals(42, timespec.tv_sec(), "tv_nsec");
    }

    /**
     * Test of nanosleep method, of class Time.
     */
    @Test
    public void testNanosleep() throws Exception {
        System.out.println("nanosleep");
        Time.Timespec rqtp = new Time.Timespec();
        rqtp.tv_nsec(10_000_000L); //10ms
        rqtp.tv_sec(0);

        Time.Timespec rmtp = new Time.Timespec();
        rmtp.tv_nsec(42);
        rmtp.tv_sec(42);
        try {
            long start = System.nanoTime();
            Time.nanosleep(rqtp, rmtp);
            long end = System.nanoTime();

            Assertions.assertTrue(end - start < 11_000_000, "max 10ms but was " + (end - start) + "ns");
            Assertions.assertTrue(end - start > 9_000_000, "min 8ms");
        } catch (NativeErrorException nee) {
            fail(Errno.getErrnoSymbol(nee.errno));
            Assertions.assertTrue(rmtp.tv_sec() <= rqtp.tv_sec(), "tv_sec");
            Assertions.assertTrue(rmtp.tv_nsec() <= rqtp.tv_nsec(), "tv_nsec");
        }
        //on succes rmtp will not be set
        assertEquals(42, rmtp.tv_sec());
        assertEquals(42, rmtp.tv_nsec());

        rqtp.tv_nsec(0);
        Time.nanosleep(rqtp, rmtp);

        Time.nanosleep(rqtp, null);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.nanosleep(null, null);
        });

    }

    /**
     * Test of strftime method, of class Time.
     */
    @Test
    public void testStrftime() {
        System.out.println("strftime");
        long maxsize = 1024;
        String format = "%Y-%m-%d %H:%M:%S";
        Time.Tm timeptr = new Time.Tm();
        timeptr.tm_year(2020 - 1900);
        timeptr.tm_mon(1);
        timeptr.tm_mday(19);
        timeptr.tm_hour(16);
        timeptr.tm_min(03);
        timeptr.tm_sec(47);
        String result = Time.strftime(maxsize, format, timeptr);
        assertEquals("2020-02-19 16:03:47", result);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Time.strftime(-1, format, timeptr);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.strftime(maxsize, null, timeptr);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.strftime(maxsize, format, null);
        });
    }

    /**
     * Test of strftime method, of class Time.
     */
    @Test
    public void testStrftime_l() throws Exception {
        System.out.println("strftime_l");
        long maxsize = 256;
        String format = "%Y-%m-%d %H:%M:%S";
        Time.Tm timeptr = new Time.Tm();
        timeptr.tm_year(2020 - 1900);
        timeptr.tm_mon(1);
        timeptr.tm_mday(19);
        timeptr.tm_hour(16);
        timeptr.tm_min(03);
        timeptr.tm_sec(47);
        Locale.Locale_t locale = Locale.duplocale(Locale.LC_GLOBAL_LOCALE());
        try {
            String result = Time.strftime_l(maxsize, format, timeptr, locale);
            assertEquals("2020-02-19 16:03:47", result);

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Time.strftime_l(-1, format, timeptr, locale);
            });
            Assertions.assertThrows(NullPointerException.class, () -> {
                Time.strftime_l(maxsize, null, timeptr, locale);
            });
            Assertions.assertThrows(NullPointerException.class, () -> {
                Time.strftime_l(maxsize, format, null, locale);
            });
            Assertions.assertThrows(NullPointerException.class, () -> {
                Time.strftime_l(maxsize, format, timeptr, null);
            });
        } finally {
            Locale.freelocale(locale);
        }
    }

    /**
     * Test of strptime method, of class Time.
     */
    @Test
    public void testStrptime() {
        System.out.println("strptime");
        String buf = "2020-01-27 09:12:57\nJNHW";
        String format = "%Y-%m-%d %H:%M:%S";
        Time.Tm tm = new Time.Tm();
        String expResult = "\nJNHW";

        String result = Time.strptime(buf, format, tm);
        assertEquals(expResult, result);
        assertEquals(2020 - 1900, tm.tm_year());
        assertEquals(0, tm.tm_mon());
        assertEquals(27, tm.tm_mday());
        assertEquals(9, tm.tm_hour());
        assertEquals(12, tm.tm_min());
        assertEquals(57, tm.tm_sec());
        if (multiarchTupelBuilder.getOS() == OS.FREE_BSD) {
            //TODO Free BSD bug ???
            assertEquals(0, tm.tm_wday());
            assertEquals("Sun Jan 27 09:12:57 2020\n", Time.asctime(tm));
        } else {
            assertEquals(1, tm.tm_wday());
            assertEquals("Mon Jan 27 09:12:57 2020\n", Time.asctime(tm));
        }

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.strptime(null, format, tm);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.strptime(buf, null, tm);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.strptime(buf, format, null);
        });

    }

    /**
     * Test of time method, of class Time.
     */
    @Test
    public void testTime() throws Exception {
        System.out.println("time");
        LongRef tloc = new LongRef();
        long expResult = System.currentTimeMillis() / 1000;
        long result = Time.time(tloc);
        assertEquals(expResult, tloc.value);
        assertEquals(expResult, result);
        result = Time.time(null);
        assertEquals(expResult, result);
    }

    /**
     * Test of timer_create method, of class Time.
     */
    @Test
    public void testTimer_create_delete() throws Exception {
        System.out.println("timer_create");

        final Time.Timer_t timerid = new Time.Timer_t(true);

        Time.timer_create(Time.CLOCK_MONOTONIC(), null, timerid);
        try {
            System.out.println("timerid: " + timerid);
        } finally {
            Time.timer_delete(timerid);
        }

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.timer_create(Time.CLOCK_MONOTONIC(), null, null);
        });

        Signal.Sigevent evp = new Signal.Sigevent();
        Pthread.Pthread_attr_t attr = new Pthread.Pthread_attr_t();
        Pthread.pthread_attr_init(attr);
        evp.sigev_notify_attributes(attr);

        //Setup for signal delivery
        evp.sigev_notify(Signal.SIGEV_SIGNAL());
        evp.sigev_signo(Signal.SIGCHLD());
        evp.sigev_value.sival_ptr(timerid);

        Time.timer_create(Time.CLOCK_MONOTONIC(), evp, timerid);

        try {
            System.out.println("timerid: " + timerid);
        } finally {
            Time.timer_delete(timerid);
        }

        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
            Time.timer_delete(timerid);
        });
        assertEquals(Errno.EINVAL(), nee.errno);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.timer_delete(null);
        });

    }

    /**
     * Test of timer_* methods, of class Time.
     */
    @Test
    public void testTimer_SIGEV_NONE() throws Exception {
        System.out.println("timer_create Signal");
        Time.Timer_t timerid = new Time.Timer_t(true);
        Time.Itimerspec trigger = new Time.Itimerspec(true);
        Signal.Sigevent sev = new Signal.Sigevent();

        sev.sigev_notify(Signal.SIGEV_NONE());

        Time.timer_create(Time.CLOCK_REALTIME(), sev, timerid);

        assertEquals(0, Time.timer_getoverrun(timerid));

        Time.timer_gettime(timerid, trigger);

        trigger.it_value.tv_nsec(30000);
        trigger.it_interval.tv_sec(1000);

        Time.timer_settime(timerid, 0, trigger, null);

        Thread.sleep(1000);

        Time.timer_delete(timerid);
    }

    /**
     * Test of timer_* methods, of class Time.
     */
    @Test
    public void testTimer() throws Exception {
        System.out.println("timer_create");

        final IntRef intRef = new IntRef(0);
        Time.Timer_t timerid = new Time.Timer_t();

        //Pthread.Pthread_attr_t attr = new Pthread.Pthread_attr_t();
        //Pthread.pthread_attr_init(attr);
        /*
        Sched.Sched_param parm = new Sched.Sched_param();
        parm.sched_priority(0); //TODO Was 255 but got EINVAL
        Pthread.pthread_attr_setschedparam(attr, parm);
         */
        Signal.Sigevent<OpaqueMemory> evp = new Signal.Sigevent<>();
        //evp.sigev_notify_attributes(attr);
        evp.sigev_notify(Signal.SIGEV_THREAD());
        evp.sigev_value.sival_int(42);
        evp.sigev_notify_function(new Callback_I_V_Impl() {

            @Override
            protected void callback(int sigval) {
                synchronized (intRef) {
                    intRef.value = sigval;
                    intRef.notifyAll();
                }
            }

        });

        System.out.println("evp: " + evp);
        Time.timer_create(Time.CLOCK_REALTIME(), evp, timerid);
        try {
            Time.Itimerspec value = new Time.Itimerspec(true);
//          Time.Itimerspec ovalue = new Time.Itimerspec(true);
            value.it_value.tv_sec(2); // after 2 s
            value.it_interval.tv_sec(1); //fire all 1s
            System.out.println("timer_settime");

            //TODO Errno.EINVAL() aka 22
            Time.timer_settime(timerid, 0, value, null);
            Time.Itimerspec itimerspec = new Time.Itimerspec();
            System.out.println("timer_gettime");
            Time.timer_gettime(timerid, itimerspec);

//TODO 2s will be splitted...            assertEquals(value, itimerspec);
            synchronized (intRef) {
                if (intRef.value == 0) {
                    intRef.wait();
                }
                assertEquals(42, intRef.value);
            }

            System.out.println("timer_getoverrun");
            int count = Time.timer_getoverrun(timerid);

            assertEquals(0, count);

            NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                Time.timer_settime(timerid, 0, null, null);
            });
            if (multiarchTupelBuilder.getOS() == de.ibapl.jnhw.libloader.OS.FREE_BSD) {
                assertEquals(Errno.EFAULT(), nee.errno);
            } else {
                assertEquals(Errno.EINVAL(), nee.errno);
            }
        } finally {
            System.out.println("timer_delete");
            Time.timer_delete(timerid);
        }
    }

    /**
     * Test of timezone method, of class Time.
     */
    @Test
    public void testTimezone() throws Exception {
        Assumptions.assumeFalse(multiarchTupelBuilder.getOS() == OS.FREE_BSD);
        System.out.println("timezone");
        final long oldTimezone = Time.timezone();
        assertEquals(oldTimezone, Time.timezone());
    }

    /**
     * Test of tzname method, of class Time.
     */
    @Test
    public void testTzname() {
        System.out.println("tzname");
        String[] tzname = Time.tzname();
        Assertions.assertNotNull(tzname);
        Assertions.assertEquals(2, tzname.length);
        for (int i = 0; i < tzname.length; i++) {
            Assertions.assertNotNull(tzname[i]);
            System.out.printf("\ttzname[%d] = %s\n", i, tzname[i]);
        }
    }

    /**
     * Test of tzset method, of class Time.
     */
    @Test
    public void testTzset() {
        System.out.println("tzset");
        String[] tzname = Time.tzname();
        for (int i = 0; i < tzname.length; i++) {
            System.out.printf("\ttzname[%d] = %s\n", i, tzname[i]);
        }
        //TODO set TZ to environment ...
        Time.tzset();
        System.out.println("tzset()");
        tzname = Time.tzname();
        for (int i = 0; i < tzname.length; i++) {
            System.out.printf("\ttzname[%d] = %s\n", i, tzname[i]);
        }
    }

    @Test
    public void testTimer_t() throws Exception {
        Time.Timer_t timer_t = new Time.Timer_t(true);
        switch (Defines.__WORDSIZE()) {
            case 32:
                Assertions.assertEquals("0x00000000", timer_t.toString());
                break;
            case 64:
                Assertions.assertEquals("0x0000000000000000", timer_t.toString());
                break;
            default:
                fail("Wordsize not supported");
        }
    }

}
