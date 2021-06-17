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
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import de.ibapl.jnhw.util.posix.DefinesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class StatTest {

    public static class NativeDefines {

        public final static native boolean HAVE_SYS_STAT_H();

        public final static native int S_IRGRP();

        public final static native int S_IROTH();

        public final static native int S_IRUSR();

        public final static native int S_IRWXG();

        public final static native int S_IRWXO();

        public final static native int S_IRWXU();

        public final static native int S_ISGID();

        public final static native int S_ISUID();

        public final static native int S_ISVTX();

        public final static native int S_IWGRP();

        public final static native int S_IWOTH();

        public final static native int S_IWUSR();

        public final static native int S_IXGRP();

        public final static native int S_IXOTH();

        public final static native int S_IXUSR();

        static {
            LibJnhwPosixTestLoader.touch();
        }

    }
    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @Test
    public static void test_HAVE_SYS_STAT_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Stat.HAVE_SYS_STAT_H, "not expected to have sys/stat.h");
        } else {
            Assertions.assertTrue(Stat.HAVE_SYS_STAT_H, "expected to have sys/stat.h");
        }
    }

    @Test
    public void test_StatDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Stat.class, NativeDefines.class, "HAVE_SYS_STAT_H");
    }

}
