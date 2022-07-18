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

import de.ibapl.jnhw.annotation.posix.sys.types.time_t;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.datatypes.OS;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NativeException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeException;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.upcall.Callback__V___I;
import de.ibapl.jnhw.posix.sys.Types;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatterBuilder;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.opentest4j.MultipleFailuresError;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class TimeTest {

    // just for vm in qemu...
    private final static long ONE_MINUTE = 60_000;
    private final static long ONE_SECOND = 1_000;
    @time_t
    private final static long TIME_T__20191203_142044 = 1575382844;

    @BeforeAll
    public static void checkBeforeAll_HAVE_TIME_H() throws Exception {
        switch (MultiarchTupelBuilder.getOS()) {
            case WINDOWS:
                Assertions.assertFalse(Time.HAVE_TIME_H, "expected not to have time.h");
                break;
            default:
                Assertions.assertTrue(Time.HAVE_TIME_H, "expected to have time.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_TimeDefines() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Time.class, "HAVE_TIME_H");
    }

    @BeforeAll
    public static void checkBeforeAll_StructItimespec() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Itimerspec_sizeof"), Time.Itimerspec.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Itimerspec_alignof"), Time.Itimerspec.alignof == null ? 0 : Time.Itimerspec.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Itimerspec_offsetof_it_value"), Time.Itimerspec.offsetof_It_value, "offsetof_It_value");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Itimerspec_offsetof_it_interval"), Time.Itimerspec.offsetof_It_interval, "offsetof_It_interval");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructTimespec() throws Exception {
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Timespec_sizeof"), Time.Timespec.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Timespec_alignof"), Time.Timespec.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Timespec_offsetof_tv_sec"), Time.Timespec.offsetof_Tv_sec, "offsetof_Tv_sec");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Timespec_offsetof_tv_nsec"), Time.Timespec.offsetof_Tv_nsec, "offsetof_Tv_nsec");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_StructTm() throws Exception {
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_sizeof"), Time.Tm.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_alignof"), Time.Tm.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_offsetof_tm_sec"), Time.Tm.offsetof_Tm_sec, "offsetof_Tm_sec");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_offsetof_tm_min"), Time.Tm.offsetof_Tm_min, "offsetof_Tm_min");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_offsetof_tm_hour"), Time.Tm.offsetof_Tm_hour, "offsetof_Tm_hour");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_offsetof_tm_mday"), Time.Tm.offsetof_Tm_mday, "offsetof_Tm_mday");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_offsetof_tm_mon"), Time.Tm.offsetof_Tm_mon, "offsetof_Tm_mon");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_offsetof_tm_year"), Time.Tm.offsetof_Tm_year, "offsetof_Tm_year");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_offsetof_tm_wday"), Time.Tm.offsetof_Tm_wday, "offsetof_Tm_wday");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_offsetof_tm_yday"), Time.Tm.offsetof_Tm_yday, "offsetof_Tm_yday");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Tm_offsetof_tm_isdst"), Time.Tm.offsetof_Tm_isdst, "offsetof_Tm_isdst");
                }
        );
    }

    @BeforeAll
    public static void checkBeforeAll_Timer_t() throws Exception {
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Timer_t_sizeof"), Time.Timer_t.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invokeExact_Int_V("Timer_t_alignof"), Time.Timer_t.alignof == null ? 0 : Time.Timer_t.alignof.alignof, "alignof");
                }
        );
    }

    private ResourceScope scope;

    @BeforeEach
    public void setUp() throws Exception {
        scope = ResourceScope.newConfinedScope();
        Errno.errno(0);
    }

    @AfterEach
    public void tearDown() throws Exception {
        scope.close();
    }

    /**
     * Test of asctime method, of class Time.
     */
    @Test
    public void testAsctime() {
        System.out.println("asctime");
        Time.Tm tm = Time.Tm.allocateNative(scope);
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
        Time.Tm tm = Time.Tm.allocateNative(scope);
        tm.tm_year(119);
        tm.tm_mon(11);
        tm.tm_mday(3);
        tm.tm_wday(3);
        tm.tm_hour(8);
        tm.tm_min(17);
        tm.tm_sec(7);
        tm.tm_isdst(0);

        final int BUF_SIZE = 26;
        MemoryHeap buf = MemoryHeap.wrap(MemorySegment.allocateNative(BUF_SIZE, scope));
        String result = Time.asctime_r(tm, buf);
        assertEquals("Wed Dec  3 08:17:07 2019\n", result);
        byte[] raw = OpaqueMemory.toBytes(buf);
        assertArrayEquals("Wed Dec  3 08:17:07 2019\n\0".getBytes(), raw);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.asctime_r(null, buf);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.asctime_r(tm, null);
        });
        //Test that there at least 26 bytes available in the buffer.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Time.asctime_r(tm, MemoryHeap.wrap(MemorySegment.allocateNative(25, scope)));
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
        Types.Clockid_t clock_id = Types.Clockid_t.allocateNative(scope);
        if (MultiarchTupelBuilder.getOS() == OS.DARWIN) {
            Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                Time.clock_getcpuclockid(0, clock_id);
            });
        } else {
            int pid = 0;
            Time.clock_getcpuclockid(pid, clock_id);
            Assertions.assertNotEquals(0, clock_id.getAsSignedLong());
        }
    }

    /**
     * Test of clock_getres method, of class Time.
     */
    @Test
    public void testClock_getres() throws Exception {
        System.out.println("clock_getres");

        Time.Timespec timespec = Time.Timespec.allocateNative(scope);
        Time.clock_getres(Time.CLOCK_MONOTONIC, timespec);

        assertEquals(0, timespec.tv_sec());
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                assertEquals(1, timespec.tv_nsec());
                break;
            case DARWIN:
                assertEquals(1000, timespec.tv_nsec());
                break;
            case FREE_BSD:
                assertEquals(280, timespec.tv_nsec());
                break;
            case OPEN_BSD:
                switch (MultiarchTupelBuilder.getArch()) {
                    case AARCH64:
                        //TODO virt env needs to be fixed??
                        assertEquals(15, timespec.tv_nsec());
                        break;
                    default:
                        fail("timespec.tv_nsec: " + timespec.tv_nsec());
                }
                break;
            default:
                fail("timespec.tv_nsec: " + timespec.tv_nsec());
        }
        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.clock_getres(Time.CLOCK_REALTIME, null);
        });
    }

    /**
     * Test of clock_gettime method, of class Time.
     */
    @Test
    public void testClock_gettime() throws Exception {
        System.out.println("clock_gettime");
        int clock_id = Time.CLOCK_MONOTONIC;
        Time.Timespec timespec = Time.Timespec.allocateNative(scope);
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
        switch (MultiarchTupelBuilder.getOS()) {
            case DARWIN:
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Time.clock_nanosleep(0, 0, Time.Timespec.allocateNative(scope));
                });
                break;
            default:
                int clock_id = Time.CLOCK_MONOTONIC;
                int flags = 0;
                Time.Timespec rqtp = Time.Timespec.allocateNative(scope);
                rqtp.tv_nsec(10_000_000L); //10ms
                Time.Timespec rmtp = Time.Timespec.allocateNative(scope);

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

        Time.Timespec timespec = Time.Timespec.allocateNative(scope);
        //We should not have the priveleges to set the CLOCK_REALTIME ... so a NativeErrorException with EPERM as errno should be thrown.
        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
            Time.clock_settime(Time.CLOCK_REALTIME, timespec);
        });
        assertEquals(Errno.EPERM, nee.errno, "EPERM expected but got " + Errno.getErrnoSymbol(nee.errno));

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.clock_settime(Time.CLOCK_REALTIME, null);
        });
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
        final Types.Time_t clock = Types.Time_t.allocateNative(scope);
        clock.setFromSignedLong(TIME_T__20191203_142044);
        String result = Time.ctime(clock);
        assertEquals(getCtimeFormated(clock.getAsSignedLong()), result);
    }

    /**
     * Test of ctime_r method, of class Time.
     */
    @Test
    public void testCtime_r() throws Exception {
        System.out.println("ctime_r  @" + ZoneId.systemDefault());
        final Types.Time_t clock = Types.Time_t.allocateNative(scope);
        clock.setFromSignedLong(TIME_T__20191203_142044);
        MemoryHeap buf = MemoryHeap.wrap(MemorySegment.allocateNative(32, scope));
        String result = Time.ctime_r(clock, buf);

        assertEquals(getCtimeFormated(clock.getAsSignedLong()), result);

        byte[] raw = new byte[result.length() + 1];
        OpaqueMemory.copy(buf, 0, raw, 0, raw.length);
        assertArrayEquals((getCtimeFormated(clock.getAsSignedLong()) + "\0").getBytes(), raw);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.ctime_r(clock, null);
        });
        //Test that there at least 26 bytes available in the buffer.
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Time.ctime_r(clock, MemoryHeap.wrap(MemorySegment.allocateNative(25, scope)));
        });
    }

    /**
     * Test of daylight method, of class Time.
     */
    @Test
    public void testDaylight() throws Exception {
        System.out.println("daylight");
        if (MultiarchTupelBuilder.getOS() == OS.FREE_BSD) {
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
        switch (MultiarchTupelBuilder.getOS()) {
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Time.Tm result = Time.getdate(string);
                });
                break;
            default:
                NativeException nee = Assertions.assertThrows(NativeException.class, () -> {
                    Time.Tm result = Time.getdate(string);
                });
                assertEquals(1, Time.getdate_err(), "getdate_err no DATEMSK expected");
        }
    }

    /**
     * Test of gmtime method, of class Time.
     */
    @Test
    public void testGmtime() throws Exception {
        System.out.println("gmtime");
        final Instant instant = Instant.now();
        final Types.Time_t timer = Types.Time_t.allocateNative(scope);
        timer.setFromSignedLong(instant.getEpochSecond());
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
        final Types.Time_t timer = Types.Time_t.allocateNative(scope);
        timer.setFromSignedLong(instant.getEpochSecond());
        Time.Tm tm = Time.Tm.allocateNative(scope);
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
        final Types.Time_t timer = Types.Time_t.allocateNative(scope);
        timer.setFromSignedLong(instant.getEpochSecond());

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
        final Types.Time_t timer = Types.Time_t.allocateNative(scope);
        timer.setFromSignedLong(instant.getEpochSecond());
        final Time.Tm tm = Time.Tm.allocateNative(scope);

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
        final Types.Time_t timer = Types.Time_t.allocateNative(scope);
        timer.setFromSignedLong(System.currentTimeMillis() / 1000);
        Time.Tm tm = Time.localtime(timer);
        long result = Time.mktime(tm);
        assertEquals(timer.getAsSignedLong(), result);//may fail too if Time.localtime is broken

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
        Time.Timespec timespec = Time.Timespec.allocateNative(scope);
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
        Time.Timespec rqtp = Time.Timespec.allocateNative(scope);
        rqtp.tv_nsec(10_000_000L); //10ms
        rqtp.tv_sec(0);

        Time.Timespec rmtp = Time.Timespec.allocateNative(scope);
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
        Time.Tm timeptr = Time.Tm.allocateNative(scope);
        timeptr.tm_year(2020 - 1900);
        timeptr.tm_mon(1);
        timeptr.tm_mday(19);
        timeptr.tm_hour(16);
        timeptr.tm_min(03);
        timeptr.tm_sec(47);
        String result = Time.strftime(maxsize, format, timeptr);
        assertEquals("2020-02-19 16:03:47", result);

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.strftime(maxsize, null, timeptr);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.strftime(maxsize, format, null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Time.strftime(-1, format, timeptr);
        });
    }

    /**
     * Test of strftime_l method, of class Time.
     */
    @Test
    public void testStrftime_l() throws Exception {
        System.out.println("strftime_l");
        long maxsize = 256;
        String format = "%Y-%m-%d %H:%M:%S";
        Time.Tm timeptr = Time.Tm.allocateNative(scope);
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
        Time.Tm tm = Time.Tm.allocateNative(scope);
        String expResult = "\nJNHW";

        String result = Time.strptime(buf, format, tm);
        assertEquals(2020 - 1900, tm.tm_year());
        assertEquals(0, tm.tm_mon());
        assertEquals(27, tm.tm_mday());
        assertEquals(9, tm.tm_hour());
        assertEquals(12, tm.tm_min());
        assertEquals(57, tm.tm_sec());
        if (MultiarchTupelBuilder.getOS() == OS.FREE_BSD) {
            //TODO Free BSD bug ???
            assertEquals(0, tm.tm_wday());
            assertEquals("Sun Jan 27 09:12:57 2020\n", Time.asctime(tm));
        } else {
            assertEquals(1, tm.tm_wday());
            assertEquals("Mon Jan 27 09:12:57 2020\n", Time.asctime(tm));
        }

        assertEquals(expResult, result, "Expected offset to String \"\\nJNHW\" in buf");

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
        assertEquals(expResult, result, 10);
    }

    /**
     * Test of timer_create method, of class Time.
     */
    @Test
    public void testTimer_create_delete() throws Exception {
        System.out.println("timer_create");
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Time.timer_create(0, Time.PtrTimer_t.tryAllocateNative(scope));
                });
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Time.timer_delete(Time.Timer_t.tryAllocateNative(scope));
                });
                return;
            case DARWIN:
                // precondition for tests not available
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Time.PtrTimer_t.allocateNative(scope);
                });
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Time.timer_create(0, Time.PtrTimer_t.tryAllocateNative(scope));
                });
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Time.timer_delete(Time.Timer_t.tryAllocateNative(scope));
                });
                return;
        }

        final Time.PtrTimer_t ptrTimerid = Time.PtrTimer_t.tryAllocateNative(scope);

        Time.timer_create(Time.CLOCK_MONOTONIC, ptrTimerid);
        try {
            System.out.println("timerid: " + ptrTimerid);
        } finally {
            Time.timer_delete(ptrTimerid.get(scope));
        }

        Assertions.assertThrows(NullPointerException.class, () -> {
            Time.timer_create(Time.CLOCK_MONOTONIC, null, null);
        });

        Signal.Sigevent evp = Signal.Sigevent.tryAllocateNative(scope);
        //Setup for signal delivery
        evp.sigev_notify(Signal.SIGEV_SIGNAL.get());
        evp.sigev_signo(Signal.SIGCHLD);

        Pthread.Pthread_attr_t attr = Pthread.Pthread_attr_t.allocateNative(scope);
        Pthread.pthread_attr_init(attr);
        evp.sigev_notify_attributes(attr);

        Time.timer_create(Time.CLOCK_MONOTONIC, evp, ptrTimerid);
        Time.Timer_t timerid = ptrTimerid.get(scope);
        try {

            //Setup for signal delivery
            evp.sigev_value.sival_ptr(timerid);

            System.out.println("timerid: " + timerid);
        } finally {
            Time.timer_delete(timerid);
        }

        if (MultiarchTupelBuilder.getOS() == OS.FREE_BSD) {
            //FreeBSD crashes here with a SIGSEGV ...
            fail("Placeholder to gracefully fail the test - Remove this to see if the vm still crashes as of now:  FreeBSD 12.1-RELEASE-p10 and openjdk15-15.0.0+36.1_1");
        } else {
            NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
                Time.timer_create(Time.CLOCK_MONOTONIC, evp, ptrTimerid);
                Time.timer_delete(ptrTimerid.get(scope));
                //And now the crash!!
                Time.timer_delete(ptrTimerid.get(scope));
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
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD:
                // precondition for tests not available
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Signal.Sigevent.tryAllocateNative(scope);
                });
                break;
            case DARWIN:
                // precondition for tests not available
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Time.PtrTimer_t.tryAllocateNative(scope);
                });
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Time.Itimerspec.tryAllocateNative(scope);
                });
                break;
            default:
                Time.PtrTimer_t ptrTimerid = Time.PtrTimer_t.tryAllocateNative(scope);
                Time.Itimerspec trigger = Time.Itimerspec.tryAllocateNative(scope);
                Signal.Sigevent sev = Signal.Sigevent.tryAllocateNative(scope);

                sev.sigev_notify(Signal.SIGEV_NONE.get());

                Time.timer_create(Time.CLOCK_REALTIME, sev, ptrTimerid);
                final Time.Timer_t timerid = ptrTimerid.get(scope);

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
        switch (MultiarchTupelBuilder.getOS()) {
            case OPEN_BSD:
                // precondition for tests not available
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Signal.Sigevent.tryAllocateNative(scope);
                });
                break;
            case DARWIN:
                // precondition for tests not available
                Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                    Time.Timer_t.tryAllocateNative(scope);
                });
                break;
            default:

                final int SIVAL_INT = 0x87654321;
                final Object[] intRef = new Object[1];
                Time.PtrTimer_t ptrTimerid = Time.PtrTimer_t.tryAllocateNative(scope);

                //Pthread.Pthread_attr_t attr = new Pthread.Pthread_attr_t();
                //Pthread.pthread_attr_init(attr);
                /*
        Sched.Sched_param parm = new Sched.Sched_param();
        parm.sched_priority(0); //TODO Was 255 but got EINVAL
        Pthread.pthread_attr_setschedparam(attr, parm);
                 */
                Signal.Sigevent<OpaqueMemory> evp = Signal.Sigevent.tryAllocateNative(scope);
                //evp.sigev_notify_attributes(attr);
                evp.sigev_notify(Signal.SIGEV_THREAD.get());
                evp.sigev_value.sival_int(SIVAL_INT);
                assertEquals(0x87654321, evp.sigev_value.sival_int());
                evp.sigev_notify_function(new Callback__V___I() {

                    @Override
                    protected void callback(int value) {
                        try {
                            synchronized (intRef) {
                                intRef[0] = value;
                                intRef.notifyAll();
                            }
                        } catch (Throwable t) {
                            synchronized (intRef) {
                                intRef[0] = t;
                                intRef.notifyAll();
                            }
                        }
                    }
                }
                );

                System.out.println(
                        "evp: " + evp);
                Time.timer_create(Time.CLOCK_REALTIME, evp, ptrTimerid);
                final Time.Timer_t timerid = ptrTimerid.get(scope);

                try {
                    Time.Itimerspec value = Time.Itimerspec.tryAllocateNative(scope);
//          Time.Itimerspec ovalue = new Time.Itimerspec(true);
                    value.it_value.tv_sec(2); // after 2 s
                    value.it_interval.tv_sec(1); //fire all 1s
                    System.out.println("timer_settime");

                    //TODO Errno.EINVAL() aka 22
                    Time.timer_settime(timerid, 0, value);
                    Time.Itimerspec itimerspec = Time.Itimerspec.tryAllocateNative(scope);
                    System.out.println("timer_gettime");
                    Time.timer_gettime(timerid, itimerspec);

//TODO 2s will be splitted...            assertEquals(value, itimerspec);
                    synchronized (intRef) {
                        if (intRef[0] == null) {
                            intRef.wait(ONE_SECOND);
                            if (intRef[0] == null) {
                                intRef.wait(ONE_MINUTE);
                            }
                        }
                    }
                    Assertions.assertNotNull(intRef[0]);
                    if (intRef[0] instanceof Throwable) {
                        throw (Throwable) intRef[0];
                    } else {
                        assertEquals(SIVAL_INT, intRef[0]);
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
    public void testTimezone() {
        Assumptions.assumeFalse(MultiarchTupelBuilder.getOS() == OS.FREE_BSD);
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
        if (MultiarchTupelBuilder.getOS() == OS.DARWIN) {
            Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                Time.PtrTimer_t.allocateNative(scope);
            });
        } else {
            Time.Timer_t timer_t = Time.Timer_t.tryAllocateNative(scope);
            switch (Time.Timer_t.sizeof) {
                case 4:
                    Assertions.assertEquals("0x00000000", timer_t.nativeToHexString());
                    break;
                case 8:
                    Assertions.assertEquals("0x0000000000000000", timer_t.nativeToHexString());
                    break;
                default:
                    fail("Timer_t.sizeof not supported");
            }
        }
    }

    @Test
    public void testItimerspec() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.DARWIN) {
            Assertions.assertThrows(NoSuchNativeTypeException.class, () -> {
                Time.Itimerspec.tryAllocateNative(scope);
            });
        } else {
            Time.Itimerspec itimerspec = Time.Itimerspec.tryAllocateNative(scope);
            Assertions.assertEquals("{it_value : {tv_sec : 0, tv_nsec : 0}, it_interval : {tv_sec : 0, tv_nsec : 0}}", itimerspec.nativeToString());
        }
    }

}
