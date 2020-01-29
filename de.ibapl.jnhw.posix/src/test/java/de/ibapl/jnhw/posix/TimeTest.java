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

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LongRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.posix.sys.Types;
import java.time.LocalDateTime;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class TimeTest {

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
        int clock_id = 0;
        Time.Timespec timespec = null;
        Time.clock_getres(clock_id, timespec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clock_gettime method, of class Time.
     */
    @Test
    public void testClock_gettime() throws Exception {
        System.out.println("clock_gettime");
        Types.clockid_t clock_id = null;
        Time.Timespec timespec = null;
        Time.clock_gettime(clock_id, timespec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clock_nanosleep method, of class Time.
     */
    @Test
    public void testClock_nanosleep() throws Exception {
        System.out.println("clock_nanosleep");
        int clock_id = 0;
        int flags = 0;
        Time.Timespec rqtp = null;
        Time.Timespec rmtp = null;
        Time.clock_nanosleep(clock_id, flags, rqtp, rmtp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clock_settime method, of class Time.
     */
    @Test
    public void testClock_settime() throws Exception {
        System.out.println("clock_settime");
        Types.clockid_t clock_id = null;
        Time.Timespec timespec = null;
        Time.clock_settime(clock_id, timespec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ctime method, of class Time.
     */
    @Test
    public void testCtime() {
        System.out.println("ctime");
        long clock = 1575382844;
        String result = Time.ctime(clock);
        assertEquals("Tue Dec  3 15:20:44 2019\n", result);
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
    public void testDaylight() {
        System.out.println("daylight");
        final int oldDaylight = Time.daylight();
        assertEquals(oldDaylight, Time.daylight());
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
        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
            Time.Tm result = Time.getdate(string);
        });
        assertEquals(1, nee.errno, "getdate_err no DATEMSK expected");
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
        assertEquals(ldt.getDayOfWeek().getValue(), result.tm_wday(), "DayOfWeek");
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
        assertEquals(ldt.getDayOfWeek().getValue(), result.tm_wday(), "DayOfWeek");
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
     * Test of nanosleep method, of class Time.
     */
    @Test
    public void testNanosleep() throws Exception {
        System.out.println("nanosleep");
        Time.Timespec rqtp = null;
        Time.Timespec rmtp = null;
        Time.nanosleep(rqtp, rmtp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of strftime method, of class Time.
     */
    @Test
    public void testStrftime_3args() {
        System.out.println("strftime");
        long maxsize = 0L;
        String format = "";
        Time.Tm timeptr = null;
        String expResult = "";
        String result = Time.strftime(maxsize, format, timeptr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of strftime method, of class Time.
     */
    @Test
    public void testStrftime_4args() {
        System.out.println("strftime");
        long maxsize = 0L;
        String format = "";
        Time.Tm timeptr = null;
        int locale = 0;
        String expResult = "";
        String result = Time.strftime(maxsize, format, timeptr, locale);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        assertEquals("Mon Jan 27 09:12:57 2020\n", Time.asctime(tm));
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
    public void testTimer_create() throws Exception {
        System.out.println("timer_create");
        int clockid = 0;
        Signal.Sigevent evp = null;
        int timerid = 0;
        int expResult = 0;
        int result = Time.timer_create(clockid, evp, timerid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timer_delete method, of class Time.
     */
    @Test
    public void testTimer_delete() throws Exception {
        System.out.println("timer_delete");
        int timerid = 0;
        Time.timer_delete(timerid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timer_getoverrun method, of class Time.
     */
    @Test
    public void testTimer_getoverrun() throws Exception {
        System.out.println("timer_getoverrun");
        int timerid = 0;
        int expResult = 0;
        int result = Time.timer_getoverrun(timerid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timer_gettime method, of class Time.
     */
    @Test
    public void testTimer_gettime() throws Exception {
        System.out.println("timer_gettime");
        int timerid = 0;
        Time.Itimerspec value = null;
        Time.timer_gettime(timerid, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timer_settime method, of class Time.
     */
    @Test
    public void testTimer_settime() throws Exception {
        System.out.println("timer_settime");
        int timerid = 0;
        int flags = 0;
        Time.Itimerspec value = null;
        Time.Itimerspec ovalue = null;
        Time.timer_settime(timerid, flags, value, ovalue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of timezone method, of class Time.
     */
    @Test
    public void testTimezone() {
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

}
