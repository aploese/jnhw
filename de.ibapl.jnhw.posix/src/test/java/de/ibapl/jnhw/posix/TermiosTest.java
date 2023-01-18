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

import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import static de.ibapl.jnhw.posix.Termios.CLOCAL;
import static de.ibapl.jnhw.posix.Termios.CREAD;
import static de.ibapl.jnhw.posix.Termios.CRTSCTS;
import static de.ibapl.jnhw.posix.Termios.CS8;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.lang.foreign.MemorySession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class TermiosTest {

    @BeforeAll
    public static void checkBeforeAll_HAVE_TERMIOS_H() throws Exception {
        JnhwTestLogger.logBeforeAllBeginn("checkBeforeAll_HAVE_TERMIOS_H");
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            assertFalse(Termios.HAVE_TERMIOS_H, "not expected to have termios.h");
        } else {
            assertTrue(Termios.HAVE_TERMIOS_H, "expected to have termios.h");
        }
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_HAVE_TERMIOS_H");
    }

    @BeforeAll
    public static void checkBeforeAll_TermiosDefines() throws Exception {
        JnhwTestLogger.logBeforeAllBeginn("checkBeforeAll_TermiosDefines");
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_TermiosDefines");
            return;
        }
        DefinesTest.testDefines(Termios.class, "HAVE_TERMIOS_H");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_TermiosDefines");
    }

    @BeforeAll
    public static void checkBeforeAll_StructTermios() throws Exception {
        JnhwTestLogger.logBeforeAllBeginn("checkBeforeAll_StructTermios");
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_StructTermios");
            return;
        }
        Assertions.assertAll(
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("StructTermios_sizeof"), Termios.StructTermios.sizeof, "sizeof"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("StructTermios_alignof"), Termios.StructTermios.alignof.alignof, "alignof"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("StructTermios_offsetof_c_iflag"), Termios.StructTermios.offsetof_C_iflag, "offsetof_C_iflag"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("StructTermios_offsetof_c_oflag"), Termios.StructTermios.offsetof_C_oflag, "offsetof_C_oflag"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("StructTermios_offsetof_c_cflag"), Termios.StructTermios.offsetof_C_cflag, "offsetof_C_cflag"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("StructTermios_offsetof_c_lflag"), Termios.StructTermios.offsetof_C_lflag, "offsetof_C_lflag"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("StructTermios_offsetof_c_cc"), Termios.StructTermios.offsetof_C_cc, "offsetof_C_cc"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("StructTermios_offsetof_c_line"), Termios.StructTermios.offsetof_C_line, "offsetof_C_line"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("StructTermios_offsetof_c_ispeed"), Termios.StructTermios.offsetof_C_ispeed, "offsetof_C_ispeed"),
                () -> Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("StructTermios_offsetof_c_ospeed"), Termios.StructTermios.offsetof_C_ospeed, "offsetof_C_ospeed")
        );
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_StructTermios");
    }

    private MemorySession ms;

    @BeforeEach
    public void setUp(TestInfo testInfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testInfo);
        ms = MemorySession.openConfined();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) throws Exception {
        ms.close();
        JnhwTestLogger.logAfterEach(testInfo);
    }

    @Test
    public void structTermios_c_ispeed() throws Exception {
        Termios.StructTermios structTermios = Termios.StructTermios.allocateNative(ms);
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                if (!Termios._HAVE_STRUCT_TERMIOS_C_ISPEED.isDefined() | Termios._HAVE_STRUCT_TERMIOS_C_ISPEED.isEqualsTo(0)) {
                    Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                        structTermios.c_ispeed();
                    });
                    return;
                }
            }
            case FREE_BSD -> {
                //Do the test
            }
            case OPEN_BSD -> {
                Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                    structTermios.c_ispeed();
                });
                return;
            }
            case DARWIN -> {
                //Do the test
            }
            default ->
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
        Termios.StructTermios structTermios = Termios.StructTermios.allocateNative(ms);
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                if (!Termios._HAVE_STRUCT_TERMIOS_C_OSPEED.isDefined() | Termios._HAVE_STRUCT_TERMIOS_C_OSPEED.isEqualsTo(0)) {
                    Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                        structTermios.c_ospeed();
                    });
                    return;
                }
            }
            case FREE_BSD -> {
                //Do the test
            }
            case OPEN_BSD -> {
                Assertions.assertThrows(NoSuchNativeTypeMemberException.class, () -> {
                    structTermios.c_ospeed();
                });
                return;
            }
            case DARWIN -> {
                //Do the test
            }
            default ->
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
        Termios.StructTermios termios = Termios.StructTermios.allocateNative(ms);
        Termios.StructTermios.clear(termios);

        Termios.cfsetspeed(termios, Termios.B9600);
        termios.c_cflag(CREAD | CLOCAL | CS8 | CRTSCTS);

        assertFalse(termios.toString().isEmpty(), "Termios.StructTermios is empty");
    }

}
