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
import de.ibapl.jnhw.winapi.Winioctl;
import de.ibapl.jnhw.winapi.Winnt;
import de.ibapl.jnhw.winapi.Winreg;
import java.lang.reflect.Field;
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
            if (f.getAnnotation(Define.class) != null) {
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
    public void testWinioctlDefines() throws Exception {
        testDefines(Winioctl.class);
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

}
