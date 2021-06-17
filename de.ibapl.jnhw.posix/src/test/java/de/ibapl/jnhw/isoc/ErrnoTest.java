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
package de.ibapl.jnhw.isoc;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import de.ibapl.jnhw.util.posix.DefinesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ErrnoTest {

    public static class NativeDefines {

        public final static native boolean HAVE_ERRNO_H();

        public final static native int EDOM();

        public final static native int EILSEQ();

        public final static native int ERANGE();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }
    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @Test
    public void test_HAVE_ERRNO_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Errno.HAVE_ERRNO_H, "not expected to have errno.h");
        } else {
            Assertions.assertTrue(Errno.HAVE_ERRNO_H, "expected to have errno.h");
        }
    }

    @Test
    public void test_ErrnoDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Errno.class, NativeDefines.class, "HAVE_ERRNO_H");
    }

    @Test
    public void testErrno() throws Exception {
        Assertions.assertTrue(Errno.HAVE_ERRNO_H);
        Assertions.assertNotEquals(Errno.ERANGE, Errno.EILSEQ);
        Errno.errno(Errno.ERANGE);
        Assertions.assertEquals(Errno.ERANGE, Errno.errno(), "Can't Set errno");
        Errno.errno(Errno.EDOM);
        Assertions.assertEquals(Errno.EDOM, Errno.errno(), "Can't Set errno");
    }

}
