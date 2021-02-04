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
package de.ibapl.jnhw.util.winapi;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.winapi.BaseTsd;
import de.ibapl.jnhw.winapi.Errhandlingapi;
import de.ibapl.jnhw.winapi.Fileapi;
import de.ibapl.jnhw.winapi.Handleapi;
import de.ibapl.jnhw.winapi.IoAPI;
import de.ibapl.jnhw.winapi.Ioapiset;
import de.ibapl.jnhw.winapi.Minwinbase;
import de.ibapl.jnhw.winapi.ProcessEnv;
import de.ibapl.jnhw.winapi.Processthreadsapi;
import de.ibapl.jnhw.winapi.Synchapi;
import de.ibapl.jnhw.winapi.WinDef;
import de.ibapl.jnhw.winapi.Winbase;
import de.ibapl.jnhw.winapi.Winerror;
import de.ibapl.jnhw.winapi.Winnt;
import de.ibapl.jnhw.winapi.Winreg;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

/**
 * Test all symbolic constants XXX that are defined with #define XXX
 *
 * @author aploese
 */
public class DefinesTest {

    private final static MultiarchTupelBuilder MULTIARCH_TUPEL_BUILDER = new MultiarchTupelBuilder();

    public static void testDefines(Class clazz) throws Exception {
        System.out.println(clazz.getName() + " Defines: >>>");
        for (Field f : clazz.getFields()) {
            final Define define = f.getAnnotation(Define.class);
            if (define != null) {
                Class type = f.getType();
                if (Long.class.equals(type) || long.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$016x | %2$d", f.getName(), f.getLong(clazz)));
                } else if (Integer.class.equals(type) || int.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$08x | %2$d", f.getName(), f.getInt(clazz)));
                } else if (Short.class.equals(type) || short.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$04x | %2$d", f.getName(), f.getShort(clazz)));
                } else if (Byte.class.equals(type) || byte.class.equals(type)) {
                    System.out.println(String.format("\t%-30s = 0x%2$02x | %2$d", f.getName(), f.getByte(clazz)));
                } else if (IntDefine.class.equals(type)) {
                    IntDefine def = (IntDefine) f.get(clazz);
                    assertNotNull(def, clazz.getName() + "#" + f.getName());
                    if (def.isDefined()) {
                        System.out.println(String.format("\t%-30s = 0x%2$08x | %2$d", f.getName(), def.get()));
                    } else {
                        System.out.println(String.format("\t%-30s ... is not defined", f.getName()));
                    }
                } else {
                    System.out.println(String.format("\t%-30s = \"%s\"", f.getName(), f.get(clazz)));
                }
            }
        }
        System.out.println("<<< " + clazz.getName() + " Defines");
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testBaseTsdDefines() throws Exception {
        testDefines(BaseTsd.class);
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
    public void testIoAPIDefines() throws Exception {
        testDefines(IoAPI.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testMinwinbaseDefines() throws Exception {
        testDefines(Minwinbase.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testWinDefDefines() throws Exception {
        testDefines(WinDef.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testProcessEnvDefines() throws Exception {
        testDefines(ProcessEnv.class);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testProcessthreadsapiDefines() throws Exception {
        testDefines(Processthreadsapi.class);
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
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Errhandlingapi.HAVE_ERRHANDLINGAPI_H, "expected to have errhandlingapi.h");
        } else {
            Assertions.assertFalse(Errhandlingapi.HAVE_ERRHANDLINGAPI_H, "expected not to have errhandlingapi.h");
        }
    }

    @Test
    public void test_HAVE_BASETSD_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(BaseTsd.HAVE_BASETSD_H, "expected to have BaseTsd.h");
        } else {
            Assertions.assertFalse(BaseTsd.HAVE_BASETSD_H, "expected not to have BaseTsd.h");
        }
    }

    @Test
    public void test_HAVE_FILEAPI_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Fileapi.HAVE_FILEAPI_H, "expected to have fileapi.h");
        } else {
            Assertions.assertFalse(Fileapi.HAVE_FILEAPI_H, "expected not to have fileapi.h");
        }
    }

    @Test
    public void test_HAVE_HANDLEAPI_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Handleapi.HAVE_HANDLEAPI_H, "expected to have handleapi.h");
        } else {
            Assertions.assertFalse(Handleapi.HAVE_HANDLEAPI_H, "expected not to have handleapi.h");
        }
    }

    @Test
    public void test_HAVE_IOAPI_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(IoAPI.HAVE_IOAPI_H, "expected to have IoAPI.h");
        } else {
            Assertions.assertFalse(IoAPI.HAVE_IOAPI_H, "expected not to have IoAPI.h");
        }
    }

    @Test
    public void test_HAVE_IOAPISET_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Ioapiset.HAVE_IOAPISET_H, "expected to have ioapiset.h");
        } else {
            Assertions.assertFalse(Ioapiset.HAVE_IOAPISET_H, "expected not to have ioapiset.h");
        }
    }

    @Test
    public void test_HAVE_MINWINBASE_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Minwinbase.HAVE_MINWINBASE_H, "expected to have minwinbase.h");
        } else {
            Assertions.assertFalse(Minwinbase.HAVE_MINWINBASE_H, "expected not to have minwinbase.h");
        }
    }

    @Test
    public void test_HAVE_WINDEF_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(WinDef.HAVE_WINDEF_H, "expected to have WinDef.h");
        } else {
            Assertions.assertFalse(WinDef.HAVE_WINDEF_H, "expected not to have WinDef.h");
        }
    }

    @Test
    public void test_HAVE_PROCESSENV_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(ProcessEnv.HAVE_PROCESSENV_H, "expected to have processenv.h");
        } else {
            Assertions.assertFalse(ProcessEnv.HAVE_PROCESSENV_H, "expected not to have processenv.h");
        }
    }

    @Test
    public void test_HAVE_PROCESSTHREADSAPI_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Processthreadsapi.HAVE_PROCESSTHREADSAPI_H, "expected to have processthreadsapi.h");
        } else {
            Assertions.assertFalse(Processthreadsapi.HAVE_PROCESSTHREADSAPI_H, "expected not to have processthreadsapi.h");
        }
    }

    @Test
    public void test_HAVE_SYNCHAPI_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Synchapi.HAVE_SYNCHAPI_H, "expected to have synchapi.h");
        } else {
            Assertions.assertFalse(Synchapi.HAVE_SYNCHAPI_H, "expected not to have synchapi.h");
        }
    }

    @Test
    public void test_HAVE_WINBASE_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winbase.HAVE_WINBASE_H, "expected to have winbase.h");
        } else {
            Assertions.assertFalse(Winbase.HAVE_WINBASE_H, "expected not to have winbase.h");
        }
    }

    @Test
    public void test_HAVE_WINERROR_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winerror.HAVE_WINERROR_H, "expected to have winerror.h");
        } else {
            Assertions.assertFalse(Winerror.HAVE_WINERROR_H, "expected not to have winerror.h");
        }
    }

    @Test
    public void test_HAVE_WINNT_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winnt.HAVE_WINNT_H, "expected to have winnt.h");
        } else {
            Assertions.assertFalse(Winnt.HAVE_WINNT_H, "expected not to have winnt.h");
        }
    }

    @Test
    public void test_HAVE_WINREG_H() throws Exception {
        if (MULTIARCH_TUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winreg.HAVE_WINREG_H, "expected to have winreg.h");
        } else {
            Assertions.assertFalse(Winreg.HAVE_WINREG_H, "expected not to have winreg.h");
        }
    }

}
