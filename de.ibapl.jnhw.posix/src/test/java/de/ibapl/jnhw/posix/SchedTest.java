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

import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.util.posix.DefinesTest;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author aploese
 */
@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class SchedTest {

    public static class NativeDefines {

        public final static native boolean HAVE_SCHED_H();

        public final static native int SCHED_FIFO();

        public final static native int SCHED_OTHER();

        public final static native int SCHED_RR();

        public final static native Integer SCHED_SPORADIC();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeSched_param {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long sched_priority();

        public final static native long sched_ss_low_priority();

        public final static native long sched_ss_repl_period();

        public final static native long sched_ss_init_budget();

        public final static native long sched_ss_max_repl();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @BeforeAll
    public static void checkBeforeAll_HAVE_SCHED_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Sched.HAVE_SCHED_H, "not expected to have sched.h");
        } else {
            Assertions.assertTrue(Sched.HAVE_SCHED_H, "expected to have sched.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_SchedDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Sched.class, NativeDefines.class, "HAVE_SCHED_H");
    }

    @BeforeAll
    public static void checkBeforeAll_NativeSched_param() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(NativeSched_param.sizeof(), Sched.Sched_param.sizeof, "sizeof");
                },
                () -> {
                    Assertions.assertEquals(NativeSched_param.alignof(), Sched.Sched_param.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativeSched_param.sched_priority(), Sched.Sched_param.offsetof_Sched_priority, "offsetof_Sched_priority");
                },
                () -> {
                    Assertions.assertEquals(NativeSched_param.sched_ss_init_budget(), Sched.Sched_param.offsetof_Sched_ss_init_budget, "offsetof_Sched_ss_init_budget");
                },
                () -> {
                    Assertions.assertEquals(NativeSched_param.sched_ss_low_priority(), Sched.Sched_param.offsetof_Sched_ss_low_priority, "offsetof_Sched_ss_low_priority");
                },
                () -> {
                    Assertions.assertEquals(NativeSched_param.sched_ss_max_repl(), Sched.Sched_param.offsetof_Sched_ss_max_repl, "offsetof_Sched_ss_max_repl");
                },
                () -> {
                    Assertions.assertEquals(NativeSched_param.sched_ss_repl_period(), Sched.Sched_param.offsetof_Sched_ss_repl_period, "offsetof_Sched_ss_repl_period");
                }
        );
    }

    /**
     * Test of sched_get_priority_max method, of class Sched.
     */
    @Test
    public void testSched_get_priority_max() throws Exception {
        System.out.println("sched_get_priority_max");
        int result = Sched.sched_get_priority_max(Sched.SCHED_OTHER);
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case FREE_BSD:
                Assertions.assertEquals(103, result);
                break;
            case OPEN_BSD:
                Assertions.assertEquals(31, result);
                break;
            case DARWIN:
                Assertions.assertEquals(47, result);
                break;
            default:
                Assertions.assertEquals(0, result, "I dont know wthat to expect so assume 0 for Sched.sched_get_priority_max(Sched.SCHED_OTHER())");
        }
    }

    /**
     * Test of sched_get_priority_min method, of class Sched.
     */
    @Test
    public void testSched_get_priority_min() throws Exception {
        System.out.println("sched_get_priority_min");
        int result = Sched.sched_get_priority_min(Sched.SCHED_OTHER);
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case DARWIN:
                Assertions.assertEquals(15, result);
                break;
            default:
                Assertions.assertEquals(0, result);
        }
    }

    /**
     * Test of sched_getscheduler method, of class Sched.
     */
    @Test
    public void testSched_getscheduler() throws Exception {
        System.out.println("sched_getscheduler");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
            case DARWIN:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Sched.sched_getscheduler(Unistd.getpid());
                });
                break;
            default:
                int result = Sched.sched_getscheduler(Unistd.getpid());
                Assertions.assertEquals(Sched.SCHED_OTHER, result);
        }
    }

    /**
     * Test of sched_rr_get_interval method, of class Sched.
     */
    @Test
    public void testSched_rr_get_interval() throws Exception {
        System.out.println("sched_rr_get_interval");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
            case DARWIN:
                Assertions.assertThrows(NoSuchNativeMethodException.class, () -> {
                    Sched.sched_rr_get_interval(Unistd.getpid(), new Time.Timespec(SetMem.TO_0x00));
                });
                break;
            default:
                Assertions.assertThrows(NullPointerException.class, () -> {
                    Sched.sched_rr_get_interval(Unistd.getpid(), null);
                });

                Time.Timespec interval = new Time.Timespec(SetMem.DO_NOT_SET);
                Sched.sched_rr_get_interval(Unistd.getpid(), interval);
                switch (MULTIARCHTUPEL_BUILDER.getOS()) {
                    case LINUX:
                        if ((0L != interval.tv_nsec())
                                && (8_000_000L != interval.tv_nsec())
                                && (4_000_000L != interval.tv_nsec())) {
                            Assertions.fail("interval.tv_nsec() is :" + interval.tv_nsec());
                        }
                        break;
                    case FREE_BSD:
                        Assertions.assertEquals(90_000_000L, interval.tv_nsec(), "interval.tv_nsec()");
                        break;
                    default:
                        Assertions.assertEquals(0L, interval.tv_nsec(), "I dont know what to expect ... so just assume 0 for interval.tv_nsec()");
                }
                Assertions.assertEquals(0, interval.tv_sec());
        }
    }

    /**
     * Test of sched_setparam sched_getparam methods, of class Sched.
     */
    @Test
    public void testSched_setgetparam() throws Exception {
        System.out.println("sched_setparam");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
            case DARWIN:
                Assertions.assertThrows(NoSuchNativeMethodException.class,
                        () -> {
                            Sched.sched_setparam(Unistd.getpid(), new Sched.Sched_param(SetMem.TO_0x00));
                        });
                Assertions.assertThrows(NoSuchNativeMethodException.class,
                        () -> {
                            Sched.sched_getparam(Unistd.getpid(), new Sched.Sched_param(SetMem.TO_0x00));
                        });
                break;
            default:
                Assertions.assertThrows(NullPointerException.class,
                        () -> {
                            Sched.sched_setparam(Unistd.getpid(), null);
                        });
                Assertions.assertThrows(NullPointerException.class,
                        () -> {
                            Sched.sched_getparam(Unistd.getpid(), null);
                        });
                Sched.Sched_param param = new Sched.Sched_param(SetMem.DO_NOT_SET);
                param.sched_priority(0);
                Sched.Sched_param param1 = new Sched.Sched_param(SetMem.DO_NOT_SET);

                Sched.sched_setparam(Unistd.getpid(), param);
                Sched.sched_getparam(Unistd.getpid(), param1);
                Assertions.assertEquals(param.sched_priority(), param1.sched_priority());
        }
    }

    /**
     * Test of sched_setscheduler method, of class Sched.
     */
    @Test
    public void testSched_setscheduler() throws Exception {
        System.out.println("sched_setscheduler");
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case OPEN_BSD:
            case DARWIN:
                Assertions.assertThrows(NoSuchNativeMethodException.class,
                        () -> {
                            Sched.sched_setscheduler(Unistd.getpid(), Sched.SCHED_OTHER, new Sched.Sched_param(SetMem.TO_0x00));
                        });
                break;
            default:
                Assertions.assertThrows(NullPointerException.class,
                        () -> {
                            Sched.sched_setscheduler(Unistd.getpid(), Sched.SCHED_OTHER, null);
                        });
                Sched.Sched_param param = new Sched.Sched_param(SetMem.TO_0x00);
                if (MULTIARCHTUPEL_BUILDER.getOS() == OS.FREE_BSD) {
                    //Any idea why this is so?
                    NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class,
                            () -> {
                                Sched.sched_setscheduler(Unistd.getpid(), Sched.SCHED_OTHER, param);
                            });
                    assertEquals(Errno.EPERM, nee.errno, Errno.getErrnoSymbol(nee.errno));
                } else {
                    int result = Sched.sched_setscheduler(Unistd.getpid(), Sched.SCHED_OTHER, param);
                    Assertions.assertEquals(Sched.SCHED_OTHER, result);
                    result = Sched.sched_setscheduler(Unistd.getpid(), Sched.SCHED_OTHER, param);
                    Assertions.assertEquals(Sched.SCHED_OTHER, result);
                }
        }
    }

    /**
     * Test of sched_yield method, of class Sched.
     */
    @Test
    public void testSched_yield() throws Exception {
        System.out.println("sched_yield");
        Sched.sched_yield();
    }

    /**
     * Test of sched_yield method, of class Sched.
     */
    @Test
    public void teststruct_sched_param() throws Exception {
        System.out.println("struct sched_param");
        int memberSum = 0;
        Sched.Sched_param sched_param = new Sched.Sched_param(SetMem.DO_NOT_SET);
        sched_param.sched_priority(1);
        memberSum += sched_param.sched_priority();
        try {
            sched_param.sched_ss_low_priority(2);
            memberSum += sched_param.sched_ss_low_priority();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        try {
            sched_param.sched_ss_max_repl(3);
            memberSum += sched_param.sched_ss_max_repl();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        try {
            sched_param.sched_ss_init_budget().tv_sec(4);
            memberSum += sched_param.sched_ss_init_budget().tv_sec();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        try {
            sched_param.sched_ss_init_budget().tv_nsec(5);
            memberSum += sched_param.sched_ss_init_budget().tv_nsec();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        try {
            sched_param.sched_ss_repl_period().tv_sec(6);
            memberSum += sched_param.sched_ss_repl_period().tv_sec();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        try {
            sched_param.sched_ss_repl_period().tv_nsec(7);
            memberSum += sched_param.sched_ss_repl_period().tv_nsec();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }

        Assertions.assertEquals(1, sched_param.sched_priority());
        memberSum -= sched_param.sched_priority();
        try {
            Assertions.assertEquals(2, sched_param.sched_ss_low_priority());
            memberSum -= sched_param.sched_ss_low_priority();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        try {
            Assertions.assertEquals(3, sched_param.sched_ss_max_repl());
            memberSum -= sched_param.sched_ss_max_repl();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        try {
            Assertions.assertEquals(4, sched_param.sched_ss_init_budget().tv_sec());
            memberSum -= sched_param.sched_ss_init_budget().tv_sec();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        try {
            Assertions.assertEquals(5, sched_param.sched_ss_init_budget().tv_nsec());
            memberSum -= sched_param.sched_ss_init_budget().tv_nsec();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        try {
            Assertions.assertEquals(6, sched_param.sched_ss_repl_period().tv_sec());
            memberSum -= sched_param.sched_ss_repl_period().tv_sec();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        try {
            Assertions.assertEquals(7, sched_param.sched_ss_repl_period().tv_nsec());
            memberSum -= sched_param.sched_ss_repl_period().tv_nsec();
        } catch (NoSuchNativeTypeMemberException nstme) {
        }
        Assertions.assertEquals(0, memberSum);
    }

}
