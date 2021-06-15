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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import static de.ibapl.jnhw.posix.Termios.CLOCAL;
import static de.ibapl.jnhw.posix.Termios.CREAD;
import static de.ibapl.jnhw.posix.Termios.CRTSCTS;
import static de.ibapl.jnhw.posix.Termios.CS8;
import de.ibapl.jnhw.util.posix.Defines;
import de.ibapl.jnhw.util.posix.DefinesTest;
import de.ibapl.jnhw.util.posix.PosixDataType;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class TermiosTest {

    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @Test
    public void CMSPAR() {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                if (Defines.__mips__.isDefined()) {
                    assertFalse(Termios.CMSPAR.isDefined(), "CMSPAR");
                    break;
                } else {
                    assertTrue(Termios.CMSPAR.isDefined(), "CMSPAR");
                }
                break;
            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
                assertFalse(Termios.CMSPAR.isDefined(), "CMSPAR");
                break;
            default:
                fail("CMSPAR unknown on: " + MULTIARCHTUPEL_BUILDER.getOS());
        }
    }

    @Test
    public void PAREXT() {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
            case FREE_BSD:
            case OPEN_BSD:
            case MAC_OS_X:
                assertFalse(Termios.PAREXT.isDefined(), "PAREXT");
                break;
            default:
                fail("PAREXT unknown on: " + MULTIARCHTUPEL_BUILDER.getOS());
        }
    }

    public static class NativeDefines {

        public final static native boolean HAVE_TERMIOS_H();

        public final static native Integer _HAVE_STRUCT_TERMIOS_C_ISPEED();

        public final static native Integer _HAVE_STRUCT_TERMIOS_C_OSPEED();

        public final static native int B0();

        public final static native Integer B1000000();

        public final static native int B110();

        public final static native int B115200();

        public final static native Integer B1152000();

        public final static native int B1200();

        public final static native int B134();

        public final static native int B150();

        public final static native Integer B1500000();

        public final static native int B1800();

        public final static native int B19200();

        public final static native int B200();

        public final static native Integer B2000000();

        public final static native int B230400();

        public final static native int B2400();

        public final static native Integer B2500000();

        public final static native int B300();

        public final static native Integer B3000000();

        public final static native Integer B3500000();

        public final static native int B38400();

        public final static native Integer B4000000();

        public final static native Integer B460800();

        public final static native int B4800();

        public final static native int B50();

        public final static native Integer B500000();

        public final static native int B57600();

        public final static native Integer B576000();

        public final static native int B600();

        public final static native int B75();

        public final static native Integer B921600();

        public final static native int B9600();

        public final static native int BRKINT();

        public final static native Integer BS0();

        public final static native Integer BS1();

        public final static native Integer BSDLY();

        public final static native int CLOCAL();

        public final static native Integer CMSPAR();

        public final static native Integer CR0();

        public final static native Integer CR1();

        public final static native Integer CR2();

        public final static native Integer CR3();

        public final static native Integer CRDLY();

        public final static native int CREAD();

        public final static native int CRTSCTS();

        public final static native int CS5();

        public final static native int CS6();

        public final static native int CS7();

        public final static native int CS8();

        public final static native int CSIZE();

        public final static native int CSTOPB();

        public final static native int ECHO();

        public final static native int ECHOE();

        public final static native int ECHOK();

        public final static native int ECHONL();

        public final static native Integer FF0();

        public final static native Integer FF1();

        public final static native Integer FFDLY();

        public final static native int HUPCL();

        public final static native int ICANON();

        public final static native int ICRNL();

        public final static native int IEXTEN();

        public final static native int IGNBRK();

        public final static native int IGNCR();

        public final static native int IGNPAR();

        public final static native int INLCR();

        public final static native int INPCK();

        public final static native int ISIG();

        public final static native int ISTRIP();

        public final static native int IXANY();

        public final static native int IXOFF();

        public final static native int IXON();

        public final static native int NCCS();

        public final static native Integer NL0();

        public final static native Integer NL1();

        public final static native Integer NLDLY();

        public final static native int NOFLSH();

        public final static native int OCRNL();

        public final static native Integer OFDEL();

        public final static native Integer OFILL();

        public final static native int ONLCR();

        public final static native int ONLRET();

        public final static native int ONOCR();

        public final static native int OPOST();

        public final static native int PARENB();

        public final static native Integer PAREXT();

        public final static native int PARMRK();

        public final static native int PARODD();

        public final static native Integer TAB0();

        public final static native Integer TAB1();

        public final static native Integer TAB2();

        public final static native Integer TAB3();

        public final static native Integer TABDLY();

        public final static native int TCIFLUSH();

        public final static native int TCIOFF();

        public final static native int TCIOFLUSH();

        public final static native int TCION();

        public final static native int TCOFLUSH();

        public final static native int TCOOFF();

        public final static native int TCOON();

        public final static native int TCSADRAIN();

        public final static native int TCSAFLUSH();

        public final static native int TCSANOW();

        public final static native int TOSTOP();

        public final static native int VEOF();

        public final static native int VEOL();

        public final static native int VERASE();

        public final static native int VINTR();

        public final static native int VKILL();

        public final static native int VMIN();

        public final static native int VQUIT();

        public final static native int VSTART();

        public final static native int VSTOP();

        public final static native int VSUSP();

        public final static native Integer VT0();

        public final static native Integer VT1();

        public final static native Integer VTDLY();

        public final static native int VTIME();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativeStructTermios {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long c_iflag();

        public final static native long c_oflag();

        public final static native long c_cflag();

        public final static native long c_lflag();

        public final static native long c_cc();

        public final static native long c_line();

        public final static native long c_ispeed();

        public final static native long c_ospeed();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    @BeforeAll
    public static void checkBeforeAll_HAVE_TERMIOS_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            assertFalse(Termios.HAVE_TERMIOS_H, "not expected to have termios.h");
        } else {
            assertTrue(Termios.HAVE_TERMIOS_H, "expected to have termios.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_TermiosDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Termios.class, NativeDefines.class, "HAVE_TERMIOS_H");
    }

    @BeforeAll
    public static void checkBeforeAll_StructTermios() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
            default:
                Assertions.assertAll(
                        () -> {
                            Assertions.assertEquals(NativeStructTermios.sizeof(), Termios.StructTermios.sizeof, "sizeof");
                        },
                        () -> {
                            Assertions.assertEquals(NativeStructTermios.alignof(), Termios.StructTermios.alignof.alignof, "alignof");
                        },
                        () -> {
                            Assertions.assertEquals(NativeStructTermios.c_iflag(), Termios.StructTermios.offsetof_C_iflag, "offsetof_C_iflag");
                        },
                        () -> {
                            Assertions.assertEquals(NativeStructTermios.c_oflag(), Termios.StructTermios.offsetof_C_oflag, "offsetof_C_oflag");
                        },
                        () -> {
                            Assertions.assertEquals(NativeStructTermios.c_cflag(), Termios.StructTermios.offsetof_C_cflag, "offsetof_C_cflag");
                        },
                        () -> {
                            Assertions.assertEquals(NativeStructTermios.c_lflag(), Termios.StructTermios.offsetof_C_lflag, "offsetof_C_lflag");
                        },
                        () -> {
                            Assertions.assertEquals(NativeStructTermios.c_cc(), Termios.StructTermios.offsetof_C_cc, "offsetof_C_cc");
                        },
                        () -> {
                            Assertions.assertEquals(NativeStructTermios.c_line(), Termios.StructTermios.offsetof_C_line, "offsetof_C_line");
                        },
                        () -> {
                            Assertions.assertEquals(NativeStructTermios.c_ispeed(), Termios.StructTermios.offsetof_C_ispeed, "offsetof_C_ispeed");
                        },
                        () -> {
                            Assertions.assertEquals(NativeStructTermios.c_ospeed(), Termios.StructTermios.offsetof_C_ospeed, "offsetof_C_ospeed");
                        }
                );
        }
    }

    @Test
    public void structTermios_c_ispeed() throws Exception {
        Termios.StructTermios structTermios = new Termios.StructTermios();
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                if (!Termios._HAVE_STRUCT_TERMIOS_C_ISPEED.isDefined()) {
                    Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                        structTermios.c_ispeed();
                    });
                    return;
                }
                break;
            case FREE_BSD:
                //Do the test
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                    structTermios.c_ispeed();
                });
                return;
            case MAC_OS_X:
                //Do the test
                break;
            default:
                throw new RuntimeException("Add test wether struct termios has c_ispeed or not!");
        }
        try {
            structTermios.c_ispeed(9600);
            assertEquals(9600, structTermios.c_ispeed());
        } catch (NoSuchNativeTypeMemberException nstme) {
            fail("Expected to have termios.c_ispeed but got this: " + nstme.getMessage());
        }
    }

    @Test
    public void structTermios_c_ospeed() throws Exception {
        Termios.StructTermios structTermios = new Termios.StructTermios();
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                if (!Termios._HAVE_STRUCT_TERMIOS_C_OSPEED.isDefined()) {
                    Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                        structTermios.c_ospeed();
                    });
                    return;
                }
                break;
            case FREE_BSD:
                //Do the test
                break;
            case OPEN_BSD:
                Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                    structTermios.c_ospeed();
                });
                return;
            case MAC_OS_X:
                //Do the test
                break;
            default:
                throw new RuntimeException("Add test wether struct termios has c_ospeed or not!");
        }
        try {
            structTermios.c_ospeed(9600);
            assertEquals(9600, structTermios.c_ospeed());
        } catch (NoSuchNativeTypeMemberException nstme) {
            fail("Expected to have termios.c_ospeed but got this: " + nstme.getMessage());
        }
    }

    @Test
    public void structTermiosToString() throws Exception {
        Termios.StructTermios termios = new Termios.StructTermios();
        Termios.StructTermios.clear(termios);

        Termios.cfsetspeed(termios, Termios.B9600);
        termios.c_cflag(CREAD | CLOCAL | CS8 | CRTSCTS);

        assertFalse(termios.toString().isEmpty(), "Termios.StructTermios is empty");
    }

    @Test
    public void testCc_t() {
        Assertions.assertEquals(1, PosixDataType.cc_t.baseDataType.SIZE_OF);
        Assertions.assertEquals(Alignment.AT_1, PosixDataType.cc_t.baseDataType.ALIGN_OF);
        assertTrue(PosixDataType.cc_t.baseDataType.UNSIGNED);
        Termios.Cc_t instance = new Termios.Cc_t(null, 0, SetMem.TO_0x00);
        assertEquals(BaseDataType.uint8_t, instance.getBaseDataType());
        instance.uint8_t((byte) 0x80);
        assertEquals((byte) 0x80, instance.uint8_t());
        assertEquals(0xFFFFFF80, instance.uint8_t());
        assertEquals(String.valueOf((char) (byte) 0x80), instance.nativeToString());
        assertEquals("0x80", instance.nativeToHexString());
    }

    @Test
    public void testSpeed_t() {
        Assertions.assertEquals(4, PosixDataType.speed_t.baseDataType.SIZE_OF);
        Assertions.assertEquals(Alignment.AT_4, PosixDataType.speed_t.baseDataType.ALIGN_OF);
        assertTrue(PosixDataType.speed_t.baseDataType.UNSIGNED);
        Termios.Speed_t instance = new Termios.Speed_t(null, 0, SetMem.TO_0x00);
        assertEquals(BaseDataType.uint32_t, instance.getBaseDataType());
        instance.uint32_t(0x80706050);
        assertEquals(0x80706050, instance.uint32_t());
        instance.uint32_t(0xFFFFFF80);
        assertEquals(0xFFFFFF80, instance.uint32_t());
        assertEquals("0xffffff80", instance.nativeToHexString());
        instance.uint32_t(Termios.B9600);
        assertEquals("9600", instance.nativeToString());
    }

    @Test
    public void testTcflag_t() {
        Assertions.assertEquals(4, PosixDataType.tcflag_t.baseDataType.SIZE_OF);
        Assertions.assertEquals(Alignment.AT_4, PosixDataType.tcflag_t.baseDataType.ALIGN_OF);
        Assertions.assertTrue(PosixDataType.tcflag_t.baseDataType.UNSIGNED);
        Termios.Tcflag_t instance = new Termios.Tcflag_t(null, 0, SetMem.TO_0x00);
        assertEquals(BaseDataType.uint32_t, instance.getBaseDataType());
        instance.uint32_t(0x80706050);
        assertEquals(0x80706050, instance.uint32_t());
        instance.uint32_t(0xFFFFFF80);
        assertEquals(0xFFFFFF80, instance.uint32_t());
        assertEquals("0xffffff80", instance.nativeToHexString());
        assertEquals(instance.nativeToHexString(), instance.nativeToString());
    }

}
