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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_sI_uI;
import de.ibapl.jnhw.common.downcall.jni.JniMi__I___A__I__I;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.sys.Stat;
import de.ibapl.jnhw.util.posix.DefinesTest;
import de.ibapl.jnhw.util.posix.LibcLoader;
import de.ibapl.jnhw.util.posix.PosixDataType;
import java.io.File;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class FcntlTest {

    @BeforeAll
    public static void checkBeforeAll_HAVE_FCNTL_H() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Fcntl.HAVE_FCNTL_H, "not expected to have fcntl.h");
        } else {
            Assertions.assertTrue(Fcntl.HAVE_FCNTL_H, "expected to have locale.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_FcntlDefines() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Fcntl.class, "HAVE_FCNTL_H");
    }

    @Test
    public void testNPEOpen() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Fcntl.open(null, 0);
        });
    }

    @Test
    public void testNPECreat() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Fcntl.creat(null, 0);
        });
    }

    @Test
    public void testOpen() throws Exception {
        File file = File.createTempFile("jnhw-posix-fcntl-test", ".txt");
        NativeErrorException nee = Assertions.assertThrows(NativeErrorException.class, () -> {
            Fcntl.open(file.getAbsolutePath(), Fcntl.O_CREAT | Fcntl.O_EXCL, Stat.S_IRWXU | Stat.S_IRWXG);
        });
        switch (MultiarchTupelBuilder.getMultiarch()) {
            case AARCH64__LINUX__GNU, I386__LINUX__GNU, POWER_PC_64_LE__LINUX__GNU ->
                Assertions.assertEquals(Errno.ENOENT, Errno.errno());
            default ->
                Assertions.assertEquals(Errno.EEXIST, Errno.errno());
        }
    }

}
