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
package de.ibapl.jnhw.util.winapi;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.winapi.Errhandlingapi;
import de.ibapl.jnhw.winapi.Fileapi;
import de.ibapl.jnhw.winapi.Handleapi;
import de.ibapl.jnhw.winapi.Ioapiset;
import de.ibapl.jnhw.winapi.Minwinbase;
import de.ibapl.jnhw.winapi.Minwindef;
import de.ibapl.jnhw.winapi.ProcessEnv;
import de.ibapl.jnhw.winapi.Synchapi;
import de.ibapl.jnhw.winapi.Winbase;
import de.ibapl.jnhw.winapi.Winerror;
import de.ibapl.jnhw.winapi.Winnt;
import de.ibapl.jnhw.winapi.Winreg;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

/**
 * Test all symbolic constants XXX that are defined with #define XXX
 *
 * @author aploese
 */
public class DefinesTest {

    private static MultiarchTupelBuilder multiarchTupelBuilder;

    @BeforeAll
    public static void setUpClass() {
        multiarchTupelBuilder = new MultiarchTupelBuilder();
    }

    public static void testDefines(Class clazz) throws Exception {
        System.out.println(clazz.getName() + " Defines: ");
        for (Method m : clazz.getMethods()) {
            try {
                final Define define = m.getAnnotation(Define.class);
                if (define != null) {
                    System.out.println("\t" + m.getName() + " = " + m.invoke(clazz));
                }
            } catch (InvocationTargetException ite) {
                if (ite.getTargetException() instanceof NotDefinedException) {
                    boolean found = false;
                    for (Class<?> et : m.getExceptionTypes()) {
                        if (et == NotDefinedException.class) {
                            found = true;
                            break;
                        }
                        if (found) {
                            System.out.println("\t" + m.getName() + " NOT DEFINED!");
                        } else {
                            Assertions.fail("Name: " + m.getName() + " throws NotDefinedException but dont declare it" + ite.getTargetException());
                        }
                    }
                } else {
                    Assertions.fail("Name: " + m.getName() + " throws InvocationTargetException: " + ite.getTargetException());
                }
            } catch (Throwable t) {
                Assertions.fail("Name: " + m.getName() + " throws unknown exception: " + t);
            }
        }
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testErrhandlingapiDefines() throws Exception {
        testDefines(Errhandlingapi.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testFileapiDefines() throws Exception {
        testDefines(Fileapi.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testHandleapiDefines() throws Exception {
        testDefines(Handleapi.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testIoapisetDefines() throws Exception {
        testDefines(Ioapiset.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testMinwinbaseDefines() throws Exception {
        testDefines(Minwinbase.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testMinwindefDefines() throws Exception {
        testDefines(Minwindef.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testProcessEnvDefines() throws Exception {
        testDefines(ProcessEnv.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testSynchapiDefines() throws Exception {
        testDefines(Synchapi.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testWinbaseDefines() throws Exception {
        testDefines(Winbase.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testWinerrorDefines() throws Exception {
        testDefines(Winerror.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testWinntDefines() throws Exception {
        testDefines(Winnt.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testWinregDefines() throws Exception {
        testDefines(Winreg.class);
    }

    @Test
    public void test_HAVE_ERRHANDLINGAPI_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Errhandlingapi.HAVE_ERRHANDLINGAPI_H(), "expected to have errhandlingapi.h");
        } else {
            Assertions.assertFalse(Errhandlingapi.HAVE_ERRHANDLINGAPI_H(), "expected not to have errhandlingapi.h");
        }
    }

    @Test
    public void test_HAVE_FILEAPI_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Fileapi.HAVE_FILEAPI_H(), "expected to have fileapi.h");
        } else {
            Assertions.assertFalse(Fileapi.HAVE_FILEAPI_H(), "expected not to have fileapi.h");
        }
    }

    @Test
    public void test_HAVE_HANDLEAPI_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Handleapi.HAVE_HANDLEAPI_H(), "expected to have handleapi.h");
        } else {
            Assertions.assertFalse(Handleapi.HAVE_HANDLEAPI_H(), "expected not to have handleapi.h");
        }
    }

    @Test
    public void test_HAVE_IOAPISET_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Ioapiset.HAVE_IOAPISET_H(), "expected to have ioapiset.h");
        } else {
            Assertions.assertFalse(Ioapiset.HAVE_IOAPISET_H(), "expected not to have ioapiset.h");
        }
    }

    @Test
    public void test_HAVE_MINWINBASE_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Minwinbase.HAVE_MINWINBASE_H(), "expected to have minwinbase.h");
        } else {
            Assertions.assertFalse(Minwinbase.HAVE_MINWINBASE_H(), "expected not to have minwinbase.h");
        }
    }

    @Test
    public void test_HAVE_MINWINDEF_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Minwindef.HAVE_MINWINDEF_H(), "expected to have minwindef.h");
        } else {
            Assertions.assertFalse(Minwindef.HAVE_MINWINDEF_H(), "expected not to have minwindef.h");
        }
    }

    @Test
    public void test_HAVE_PROCESSENV_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(ProcessEnv.HAVE_PROCESSENV_H(), "expected to have processenv.h");
        } else {
            Assertions.assertFalse(ProcessEnv.HAVE_PROCESSENV_H(), "expected not to have processenv.h");
        }
    }

    @Test
    public void test_HAVE_SYNCHAPI_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Synchapi.HAVE_SYNCHAPI_H(), "expected to have synchapi.h");
        } else {
            Assertions.assertFalse(Synchapi.HAVE_SYNCHAPI_H(), "expected not to have synchapi.h");
        }
    }

    @Test
    public void test_HAVE_WINBASE_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winbase.HAVE_WINBASE_H(), "expected to have winbase.h");
        } else {
            Assertions.assertFalse(Winbase.HAVE_WINBASE_H(), "expected not to have winbase.h");
        }
    }

    @Test
    public void test_HAVE_WINERROR_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winerror.HAVE_WINERROR_H(), "expected to have winerror.h");
        } else {
            Assertions.assertFalse(Winerror.HAVE_WINERROR_H(), "expected not to have winerror.h");
        }
    }

    @Test
    public void test_HAVE_WINNT_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winnt.HAVE_WINNT_H(), "expected to have winnt.h");
        } else {
            Assertions.assertFalse(Winnt.HAVE_WINNT_H(), "expected not to have winnt.h");
        }
    }

    @Test
    public void test_HAVE_WINREG_H() throws Exception {
        if (multiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winreg.HAVE_WINREG_H(), "expected to have winreg.h");
        } else {
            Assertions.assertFalse(Winreg.HAVE_WINREG_H(), "expected not to have winreg.h");
        }
    }

}