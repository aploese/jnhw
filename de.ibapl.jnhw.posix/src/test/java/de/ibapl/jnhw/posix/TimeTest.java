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

import de.ibapl.jnhw.annotation.posix.sys.types.time_t;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.Callback__Sigval_int__V_Impl;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatterBuilder;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.opentest4j.MultipleFailuresError;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.util.posix.DefinesTest;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class TimeTest {

    public static class NativeDefines {

        public final static native boolean HAVE_TIME_H();

        public final static native int CLOCKS_PER_SEC();

        public final static native int CLOCK_MONOTONIC();

        public final static native int CLOCK_PROCESS_CPUTIME_ID();

        public final static native int CLOCK_REALTIME();

        public final static native int CLOCK_THREAD_CPUTIME_ID();

        public final static native int TIMER_ABSTIME();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeItimerspec {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long it_interval();

        public final static native long it_value();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeTimespec {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long tv_sec();

        public final static native long tv_nsec();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeTm {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long tm_sec();

        public final static native long tm_min();

        public final static native long tm_hour();

        public final static native long tm_mday();

        public final static native long tm_mon();

        public final static native long tm_year();

        public final static native long tm_wday();

        public final static native long tm_yday();

        public final static native long tm_isdst();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeTimer_t {

        public final static native int alignof();

        public final static native int sizeof();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    // just for vm in qemu...
    private final static long ONE_MINUTE = 60_000;
    @time_t
    private final static long TIME_T__20191203_142044 = 1575382844;
    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @BeforeAll
    public static void checkBeforeAll_HAVE_AIO_H() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
            case WINDOWS:
                Assertions.assertFalse(Aio.HAVE_AIO_H, "expected not to have aio.h");
                break;
            default:
                Assertions.assertTrue(Aio.HAVE_AIO_H, "expected to have aio.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_AioDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Time.class, NativeDefines.class, "HAVE_TIME_H");
    }

    @BeforeAll
    public static void checkBeforeAll_StructItimespec() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(NativeItimerspec.sizeof(), Time.Itimerspec.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(NativeItimerspec.alignof(), Time.Itimerspec.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativeItimerspec.it_value(), Time.Itimerspec.offsetof_It_value, "offsetof_It_value");
                },
                () -> {
                    Assertions.assertEquals(NativeItimerspec.it_interval(), Time.Itimerspec.offsetof_It_interval, "offsetof_It_interval");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructTimespec() throws Exception {
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(NativeTimespec.sizeof(), Time.Timespec.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(NativeTimespec.alignof(), Time.Timespec.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativeTimespec.tv_sec(), Time.Timespec.offsetof_Tv_sec, "offsetof_Tv_sec");
                },
                () -> {
                    Assertions.assertEquals(NativeTimespec.tv_nsec(), Time.Timespec.offsetof_Tv_nsec, "offsetof_Tv_nsec");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructTm() throws Exception {
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(NativeTm.sizeof(), Time.Tm.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(NativeTm.alignof(), Time.Tm.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativeTm.tm_sec(), Time.Tm.offsetof_Tm_sec, "offsetof_Tm_sec");
                },
                () -> {
                    Assertions.assertEquals(NativeTm.tm_min(), Time.Tm.offsetof_Tm_min, "offsetof_Tm_min");
                },
                () -> {
                    Assertions.assertEquals(NativeTm.tm_hour(), Time.Tm.offsetof_Tm_hour, "offsetof_Tm_hour");
                },
                () -> {
                    Assertions.assertEquals(NativeTm.tm_mday(), Time.Tm.offsetof_Tm_mday, "offsetof_Tm_mday");
                },
                () -> {
                    Assertions.assertEquals(NativeTm.tm_mon(), Time.Tm.offsetof_Tm_mon, "offsetof_Tm_mon");
                },
                () -> {
                    Assertions.assertEquals(NativeTm.tm_year(), Time.Tm.offsetof_Tm_year, "offsetof_Tm_year");
                },
                () -> {
                    Assertions.assertEquals(NativeTm.tm_wday(), Time.Tm.offsetof_Tm_wday, "offsetof_Tm_wday");
                },
                () -> {
                    Assertions.assertEquals(NativeTm.tm_yday(), Time.Tm.offsetof_Tm_yday, "offsetof_Tm_yday");
                },
                () -> {
                    Assertions.assertEquals(NativeTm.tm_isdst(), Time.Tm.offsetof_Tm_isdst, "offsetof_Tm_isdst");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_Timer_t() throws Exception {
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(NativeTimer_t.sizeof(), Time.Timer_t.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(NativeTimer_t.alignof(), Time.Timer_t.alignof.alignof, "alignof");
                }
        );
    }

    /**
     * Test of asctime method, of class Time.
     */
    @Test
    public void testAsctime() {
        System.out.println("asctime");
        Time.Tm tm = new Time.Tm(SetMem.TO_0x00);
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
        Time.Tm tm = new Time.Tm(SetMem.TO_0x00);
        tm.tm_year(119);
        tm.tm_mon(11);
        tm.tm_mday(3);
        tm.tm_wday(3);
        tm.tm_hour(8);
        tm.tm_min(17);
        tm.tm_sec(7);
        tm.tm_isdst(0);

        final int BUF_SIZE = 26;
        Memory32Heap buf = new Memory32Heap((OpaqueMemory32) null, 0, BUF_SIZE, SetMem.TO_0x00);
        String result = Time.asctime_r(tm, buf);
        assertEquals("Wed Dec  3 08:17:07 2019\n", result);
        byte[] raw = OpaqueMemory32.toBytes(buf);
        assertArrayEquals("Wed Dec  3 08:17:07 2019\n\0".getBytes(), raw);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.asctime_r(null, buf);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.asctime_r(tm, null);
        });
        //Test that there at least 26 bytes available in the buffer.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Time.asctime_r(tm, new Memory32Heap((OpaqueMemory32) null, 0, 25, SetMem.TO_0x00));
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
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.MAC_OS_X) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Time.clock_getcpuclockid(0);
            });
        } else {
            int pid = 0;
            int clock_id = Time.clock_getcpuclockid(pid);
            Assertions.assertNotEquals(0, clock_id);
        }
    }

    /**
     * Test of clock_getres method, of class Time.
     */
    @Test
    public void testClock_getres() throws Exception {
        System.out.println("clock_getres");

        Time.Timespec timespec = new Time.Timespec(SetMem.TO_0x00);
        Time.clock_getres(Time.CLOCK_MONOTONIC, timespec);

        assertEquals(0, timespec.tv_sec());
        //TODO virt env needs to be fixed
        assertEquals(1, timespec.tv_nsec());

        Time.clock_getres(Time.CLOCK_REALTIME);
    }

    /**
     * Test of clock_gettime method, of class Time.
     */
    @Test
    public void testClock_gettime() throws Exception {
        System.out.println("clock_gettime");
        int clock_id = Time.CLOCK_MONOTONIC;
        Time.Timespec timespec = new Time.Timespec(SetMem.TO_0x00);
        Time.clock_gettime(clock_id, timespec);

        System.out.println("timespec: " + timespec);
        Assertions.assertTrue(timespec.tv_sec() > 0, "timespec.tv_sec() > 0");
        Assertions.assertTrue(timespec.tv_nsec() >= 0, "timespec.tv_nsec() >= 0");

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.clock_gettime(Time.CLOCK_REALTIME, null);
        });
    }

    /**
     * Test of clock_nanosleep method, of class Time.
     */
    @Test
    public void testClock_nanosleep() throws Exception {
        System.out.println("clock_nanosleep");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
            case MAC_OS_X:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Time.clock_nanosleep(0, 0, null, null);
                });
                break;
            default:
                int clock_id = Time.CLOCK_MONOTONIC;
                int flags = 0;
                Time.Timespec rqtp = new Time.Timespec(SetMem.TO_0x00);
                rqtp.tv_nsec(10_000_000L); //10ms
                Time.Timespec rmtp = new Time.Timespec(SetMem.DO_NOT_SET);

                long start = System.nanoTime();
                Time.clock_nanosleep(clock_id, flags, rqtp, rmtp);
                long end = System.nanoTime();

                Assertions.assertTrue(end - start < 13_000_000, "max 13ms but was " + (end - start) + "ns");
                Assertions.assertTrue(end - start > 9_000_000, "min 9ms");

                rqtp.tv_nsec(0);
                Time.clock_nanosleep(clock_id, flags, rqtp, rmtp);

                Time.clock_nanosleep(clock_id, flags, rqtp);

                Assertions.assertThrows(NullPointerException.class, () -> {
                    Time.clock_nanosleep(clock_id, flags, null, null);
                });
        }
    }

    /**
     * Test of clock_settime method, of class Time.
     */
    @Test
    public void testClock_settime() throws Exception {
        System.out.println("clock_settime");

        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.MAC_OS_X) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Time.clock_settime(0, null);
            });
        } else {
            Time.Timespec timespec = new Time.Timespec(SetMem.TO_0x00);
            //We should not habe the priveleges to set the CLOCK_REALTIME ... so a NativeErrorException with EPERM as errno should be thrown.
            NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                Time.clock_settime(Time.CLOCK_REALTIME, timespec);
            });
            assertEquals(Errno.EPERM, nee.errno, "EPERM expected but got " + Errno.getErrnoSymbol(nee.errno));

            Assertions.assertThrows(NullPointerException.class, () -> {
                Time.clock_settime(Time.CLOCK_REALTIME, null);
            });
        }
    }

    private String getCtimeFormated(long clock) {
        ZonedDateTime zdt = Instant.ofEpochMilli(clock * 1000L).atZone(ZoneOffset.systemDefault());
        DateTimeFormatterBuilder dtfb = new DateTimeFormatterBuilder();
        dtfb.appendPattern("E LLL  d HH:mm:ss y\n");
        return dtfb.toFormatter(java.util.Locale.ROOT).format(zdt);
    }

    /**
     * Test of ctime method, of class Time.
     */
    @Test
    public void testCtime() {
        System.out.println("ctime  @" + ZoneId.systemDefault());
        final long clock = TIME_T__20191203_142044;
        String result = Time.ctime(clock);
        assertEquals(getCtimeFormated(clock), result);
    }

    /**
     * Test of ctime_r method, of class Time.
     */
    @Test
    public void testCtime_r() throws Exception {
        System.out.println("ctime_r  @" + ZoneId.systemDefault());
        final long clock = TIME_T__20191203_142044;
        Memory32Heap buf = new Memory32Heap((OpaqueMemory32) null, 0, 32, SetMem.TO_0x00);
        String result = Time.ctime_r(clock, buf);

        assertEquals(getCtimeFormated(clock), result);

        byte[] raw = new byte[result.length() + 1];
        OpaqueMemory32.copy(buf, 0, raw, 0, raw.length);
        assertArrayEquals((getCtimeFormated(clock) + "\0").getBytes(), raw);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.ctime_r(clock, null);
        });
        //Test that there at least 26 bytes available in the buffer.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Time.ctime_r(clock, new Memory32Heap((OpaqueMemory32) null, 0, 25, SetMem.TO_0x00));
        });
    }

    /**
     * Test of daylight method, of class Time.
     */
    @Test
    public void testDaylight() throws Exception {
        System.out.println("daylight");
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.FREE_BSD) {
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
        double expResult = TIME_T__20191203_142044;
        double result = Time.difftime(TIME_T__20191203_142044, 0L);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getdate method, of class Time.
     */
    @Test
    public void testGetdate() {
        System.out.println("getdate");
        String string = "Tue Dec  3 15:20:44 2019\n";
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Time.Tm result = Time.getdate(string);
                });
                break;
            default:
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
        final Instant instant = Instant.now();
        final long timer = instant.getEpochSecond();
        Time.Tm result = Time.gmtime(timer);
        assertTm(instant, result, ZoneOffset.UTC);
    }

    /**
     * Test of gmtime_r method, of class Time.
     */
    @Test
    public void testGmtime_r() throws Exception {
        System.out.println("gmtime_r");
        final Instant instant = Instant.now();
        final long timer = instant.getEpochSecond();
        Time.Tm tm = new Time.Tm(SetMem.DO_NOT_SET);
        Time.gmtime_r(timer, tm);
        assertTm(instant, tm, ZoneOffset.UTC);

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
        final Instant instant = Instant.now();
        final long timer = instant.getEpochSecond();

        final Time.Tm result = Time.localtime(timer);
        Assertions.assertNotNull(result);
        System.out.println("time: " + timer + " localtime: " + result);
        assertTm(instant, result, ZoneId.systemDefault());
    }

    private void assertTm(final Instant instant, final Time.Tm tm, ZoneId zoneId) throws MultipleFailuresError {
        final LocalDateTime ldt = LocalDateTime.ofInstant(instant, zoneId);
        Assertions.assertAll("testLocaltime",
                () -> {
                    assertEquals(ldt.getYear(), tm.tm_year() + 1900, "Year");
                },
                () -> {
                    assertEquals(ldt.getDayOfYear(), tm.tm_yday() + 1, "DayOfYear");
                },
                () -> {
                    assertEquals(ldt.getMonthValue(), tm.tm_mon() + 1, "MonthValue");
                },
                () -> {
                    assertEquals(ldt.getDayOfMonth(), tm.tm_mday(), "DayOfMonth");
                },
                () -> {
                    if (ldt.getDayOfWeek() == DayOfWeek.SUNDAY) {
                        //Sunday java = 7; posix = 0
                        assertEquals(0, tm.tm_wday(), "DayOfWeek SUNDAY -> 0(sun)");
                    } else {
                        assertEquals(ldt.getDayOfWeek().getValue(), tm.tm_wday(), "DayOfWeek MONDAY to SATURDAY -> 1(mon) to 6(sat)");
                    }
                },
                () -> {
                    assertEquals(ldt.getHour(), tm.tm_hour(), "Hour");
                },
                () -> {
                    assertEquals(ldt.getMinute(), tm.tm_min(), "Minute");
                },
                () -> {
                    assertEquals(ldt.getSecond(), tm.tm_sec(), "Second");
                });
    }

    /**
     * Test of localtime_r method, of class Time.
     */
    @Test
    public void testLocaltime_r() throws Exception {
        System.out.println("localtime_r");
        final Instant instant = Instant.now();
        final long timer = instant.getEpochSecond();
        final Time.Tm tm = new Time.Tm(SetMem.DO_NOT_SET);

        Time.localtime_r(timer, tm);

        System.out.println("time: " + timer + " localtime: " + tm);

        assertTm(instant, tm, ZoneId.systemDefault());

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
        assertEquals(timer, result);//may fail too if Time.localtime is broken

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
        Time.Timespec timespec = new Time.Timespec(SetMem.DO_NOT_SET);
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
        Time.Timespec rqtp = new Time.Timespec(SetMem.DO_NOT_SET);
        rqtp.tv_nsec(10_000_000L); //10ms
        rqtp.tv_sec(0);

        Time.Timespec rmtp = new Time.Timespec(SetMem.DO_NOT_SET);
        rmtp.tv_nsec(42);
        rmtp.tv_sec(42);
        try {
            long start = System.nanoTime();
            Time.nanosleep(rqtp, rmtp);
            long end = System.nanoTime();

            Assertions.assertTrue(end - start < 13_000_000, "max 13ms but was " + (end - start) + "ns");
            Assertions.assertTrue(end - start > 9_000_000, "min 9ms");
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

        Time.nanosleep(rqtp);

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
        Time.Tm timeptr = new Time.Tm(SetMem.TO_0x00);
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
        Time.Tm timeptr = new Time.Tm(SetMem.TO_0x00);
        timeptr.tm_year(2020 - 1900);
        timeptr.tm_mon(1);
        timeptr.tm_mday(19);
        timeptr.tm_hour(16);
        timeptr.tm_min(03);
        timeptr.tm_sec(47);
        Locale.Locale_t locale = Locale.duplocale(Locale.LC_GLOBAL_LOCALE);
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
        Time.Tm tm = new Time.Tm(SetMem.DO_NOT_SET);
        String expResult = "\nJNHW";

        String result = Time.strptime(buf, format, tm);
        assertEquals(2020 - 1900, tm.tm_year());
        assertEquals(0, tm.tm_mon());
        assertEquals(27, tm.tm_mday());
        assertEquals(9, tm.tm_hour());
        assertEquals(12, tm.tm_min());
        assertEquals(57, tm.tm_sec());
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.FREE_BSD) {
            //TODO Free BSD bug ???
            assertEquals(0, tm.tm_wday());
            assertEquals("Sun Jan 27 09:12:57 2020\n", Time.asctime(tm));
        } else {
            assertEquals(1, tm.tm_wday());
            assertEquals("Mon Jan 27 09:12:57 2020\n", Time.asctime(tm));
        }

        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.OPEN_BSD) {
            System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXStrptimeXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx");
            for (byte b : result.getBytes()) {
                System.err.println(String.format("%c  0x%02x", b, b));
            }
            System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXStrptimeXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx");
        }
        assertEquals(expResult, result, "Expected pointer to String in buf");

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
        long expResult = System.currentTimeMillis() / 1000;
        long result = Time.time();
        assertEquals(expResult, result);
    }

    /**
     * Test of timer_create method, of class Time.
     */
    @Test
    public void testTimer_create_delete() throws Exception {
        System.out.println("timer_create");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Time.timer_create(0, null, null);
                });
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Time.timer_delete(null);
                });
                return;
            case MAC_OS_X:
                // precondition for tests not available
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    new Time.Timer_t(SetMem.TO_0x00);
                });
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Time.timer_create(0, null, null);
                });
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Time.timer_delete(null);
                });
                return;
        }

        final Time.Timer_t timerid = new Time.Timer_t(SetMem.TO_0x00);

        Time.timer_create(Time.CLOCK_MONOTONIC, timerid);
        try {
            System.out.println("timerid: " + timerid);
        } finally {
            Time.timer_delete(timerid);
        }

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.timer_create(Time.CLOCK_MONOTONIC, null, null);
        });

        Signal.Sigevent evp = new Signal.Sigevent();
        Pthread.Pthread_attr_t attr = new Pthread.Pthread_attr_t();
        Pthread.pthread_attr_init(attr);
        evp.sigev_notify_attributes(attr);

        //Setup for signal delivery
        evp.sigev_notify(Signal.SIGEV_SIGNAL.get());
        evp.sigev_signo(Signal.SIGCHLD);
        evp.sigev_value.sival_ptr(timerid);

        Time.timer_create(Time.CLOCK_MONOTONIC, evp, timerid);

        try {
            System.out.println("timerid: " + timerid);
        } finally {
            Time.timer_delete(timerid);
        }

        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.FREE_BSD) {
            //FreeBSD crashes here with a SIGSEGV ...
            fail("Praceholder to gracefully fail the test - Remove this to see if the vm still crashes as of now:  FreeBSD 12.1-RELEASE-p10 and openjdk15-15.0.0+36.1_1");
        } else {
            NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                Time.timer_delete(timerid);
            });
            assertEquals(Errno.EINVAL, nee.errno);
        }

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
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                // precondition for tests not available
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    new Signal.Sigevent();
                });
                break;
            case FREE_BSD:
            case MAC_OS_X:
                // precondition for tests not available
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    new Time.Timer_t(SetMem.TO_0x00);
                });
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    new Time.Itimerspec(SetMem.TO_0x00);
                });
                break;
            default:
                Time.Timer_t timerid = new Time.Timer_t(SetMem.TO_0x00);
                Time.Itimerspec trigger = new Time.Itimerspec(SetMem.TO_0x00);
                Signal.Sigevent sev = new Signal.Sigevent();

                sev.sigev_notify(Signal.SIGEV_NONE.get());

                Time.timer_create(Time.CLOCK_REALTIME, sev, timerid);

                assertEquals(0, Time.timer_getoverrun(timerid));

                Time.timer_gettime(timerid, trigger);

                trigger.it_value.tv_nsec(30000);
                trigger.it_interval.tv_sec(1000);

                Time.timer_settime(timerid, 0, trigger);

                Thread.sleep(1000);

                Time.timer_delete(timerid);
        }
    }

    /**
     * Test of timer_* methods, of class Time.
     */
    @Test
    public void testTimer() throws Throwable {
        System.out.println("timer_create");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
                // precondition for tests not available
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    new Signal.Sigevent();
                });
                break;
            case MAC_OS_X:
                // precondition for tests not available
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    new Time.Timer_t(SetMem.TO_0x00);
                });
                break;
            default:

                final Object[] intRef = new Object[1];
                Time.Timer_t timerid = new Time.Timer_t(SetMem.DO_NOT_SET);

                //Pthread.Pthread_attr_t attr = new Pthread.Pthread_attr_t();
                //Pthread.pthread_attr_init(attr);
                /*
        Sched.Sched_param parm = new Sched.Sched_param();
        parm.sched_priority(0); //TODO Was 255 but got EINVAL
        Pthread.pthread_attr_setschedparam(attr, parm);
                 */
                Signal.Sigevent<OpaqueMemory32> evp = new Signal.Sigevent<>();
                //evp.sigev_notify_attributes(attr);
                evp.sigev_notify(Signal.SIGEV_THREAD.get());
                evp.sigev_value.sival_int(0x12345678);
                assertEquals(0x12345678, evp.sigev_value.sival_int());
                evp.sigev_notify_function(new Callback__Sigval_int__V_Impl() {

                    @Override
                    protected void callback(int sigval) {
                        try {
                            synchronized (intRef) {
                                intRef[0] = (int) sigval;
                                intRef.notifyAll();
                            }
                        } catch (Exception ex) {
                            synchronized (intRef) {
                                intRef[0] = ex;
                                intRef.notifyAll();
                            }
                            throw ex;
                        }
                    }

                });

                System.out.println("evp: " + evp);
                Time.timer_create(Time.CLOCK_REALTIME, evp, timerid);
                try {
                    Time.Itimerspec value = new Time.Itimerspec(SetMem.TO_0x00);
//          Time.Itimerspec ovalue = new Time.Itimerspec(true);
                    value.it_value.tv_sec(2); // after 2 s
                    value.it_interval.tv_sec(1); //fire all 1s
                    System.out.println("timer_settime");

                    //TODO Errno.EINVAL() aka 22
                    Time.timer_settime(timerid, 0, value);
                    Time.Itimerspec itimerspec = new Time.Itimerspec(SetMem.DO_NOT_SET);
                    System.out.println("timer_gettime");
                    Time.timer_gettime(timerid, itimerspec);

//TODO 2s will be splitted...            assertEquals(value, itimerspec);
                    synchronized (intRef) {
                        if (intRef[0] == null) {
                            intRef.wait(ONE_MINUTE);
                        }
                        Assertions.assertNotNull(intRef[0]);
                        if (intRef[0] instanceof Throwable) {
                            fail("in callback", (Exception) intRef[0]);
                        } else {
                            assertEquals(0x12345678, intRef[0]);
                        }
                    }

                    System.out.println("timer_getoverrun");
                    int count = Time.timer_getoverrun(timerid);

                    assertEquals(0, count);

                    NullPointerException nee = Assertions.assertThrows(NullPointerException.class, () -> {
                        Time.timer_settime(timerid, 0, null, null);
                    });
                } finally {
                    System.out.println("timer_delete");
                    Time.timer_delete(timerid);
                }
        }
    }

    /**
     * Test of timezone method, of class Time.
     */
    @Test
    public void testTimezone() throws Exception {
        Assumptions.assumeFalse(MULTIARCHTUPEL_BUILDER.getOS() == OS.FREE_BSD);
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
        Time.Timer_t timer_t = new Time.Timer_t(SetMem.TO_0x00);
        switch (MULTIARCHTUPEL_BUILDER.getSizeOfPointer()) {
            case _32_BIT:
                Assertions.assertEquals("0x00000000", timer_t.nativeToString());
                break;
            case _64_BIT:
                Assertions.assertEquals("0x0000000000000000", timer_t.nativeToString());
                break;
            default:
                fail("Wordsize not supported");
        }
    }

    @Test
    public void testItimerspec() throws Exception {
        Time.Itimerspec itimerspec = new Time.Itimerspec(SetMem.TO_0x00);
        Assertions.assertEquals("{it_value : {tv_sec : 0, tv_nsec : 0}, it_interval : {tv_sec : 0, tv_nsec : 0}}", itimerspec.nativeToString());
    }

}
