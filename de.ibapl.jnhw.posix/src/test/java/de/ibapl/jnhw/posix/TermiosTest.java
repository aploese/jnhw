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

import de.ibapl.jnhw.common.datatypes.BaseDataTypes;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import static de.ibapl.jnhw.posix.Termios.CLOCAL;
import static de.ibapl.jnhw.posix.Termios.CREAD;
import static de.ibapl.jnhw.posix.Termios.CRTSCTS;
import static de.ibapl.jnhw.posix.Termios.CS8;
import de.ibapl.jnhw.util.posix.Defines;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
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
    public void testSizeOfTermios() throws Exception {
        switch (MULTIARCHTUPEL_BUILDER.getOS()) {
            case LINUX:
                switch (MULTIARCHTUPEL_BUILDER.getArch()) {
                    case MIPS:
                    case MIPS_64:
                        Assertions.assertEquals(52, Termios.StructTermios.sizeof());
                        break;
                    default:
                        Assertions.assertEquals(60, Termios.StructTermios.sizeof());
                }
                break;
            case FREE_BSD:
            case OPEN_BSD:
                Assertions.assertEquals(44, Termios.StructTermios.sizeof());
                break;
            default:
                Assertions.assertEquals(-1, Termios.StructTermios.sizeof());
        }
    }

    @Test
    public void testAlignOfTermios() throws Exception {
        Assertions.assertEquals(4, Termios.StructTermios.alignof());
    }

    @Test
    public void testCc_t() {
        Assertions.assertEquals(1, Termios.Cc_t.sizeof());
        Assertions.assertEquals(1, Termios.Cc_t.alignof());
        assertTrue(Termios.Cc_t.unsigned());
        Termios.Cc_t instance = new Termios.Cc_t(true);
        assertEquals(BaseDataTypes.uint8_t, instance.getBaseDataType());
        instance.setValue((byte) 0x80);
        assertEquals((byte) 0x80, instance.getValue());
        assertEquals(0xFFFFFF80, instance.getValue());
        assertEquals(String.valueOf((char) (byte) 0x80), instance.nativeToString());
        assertEquals("80", instance.nativeToHexString());
    }

    @Test
    public void testSpeed_t() {
        Assertions.assertEquals(4, Termios.Speed_t.sizeof());
        Assertions.assertEquals(4, Termios.Speed_t.alignof());
        assertTrue(Termios.Speed_t.unsigned());
        Termios.Speed_t instance = new Termios.Speed_t(true);
        assertEquals(BaseDataTypes.uint32_t, instance.getBaseDataType());
        instance.setValue(0x80706050);
        assertEquals(0x80706050, instance.getValue());
        instance.setValue(0xFFFFFF80);
        assertEquals(0xFFFFFF80, instance.getValue());
        assertEquals("ffffff80", instance.nativeToHexString());
        instance.setValue(Termios.B9600);
        assertEquals("9600", instance.nativeToString());
    }

    @Test
    public void testTcflag_t() {
        Assertions.assertEquals(4, Termios.Tcflag_t.sizeof());
        Assertions.assertEquals(4, Termios.Tcflag_t.alignof());
        Assertions.assertTrue(Termios.Tcflag_t.unsigned());
        Termios.Tcflag_t instance = new Termios.Tcflag_t(true);
        assertEquals(BaseDataTypes.uint32_t, instance.getBaseDataType());
        instance.setValue(0x80706050);
        assertEquals(0x80706050, instance.getValue());
        instance.setValue(0xFFFFFF80);
        assertEquals(0xFFFFFF80, instance.getValue());
        assertEquals("ffffff80", instance.nativeToHexString());
        assertEquals(instance.nativeToHexString(), instance.nativeToString());
    }

}
