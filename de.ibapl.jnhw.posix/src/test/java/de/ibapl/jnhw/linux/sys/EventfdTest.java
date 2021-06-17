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
package de.ibapl.jnhw.linux.sys;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.posix.LibJnhwPosixTestLoader;
import de.ibapl.jnhw.posix.Unistd;
import de.ibapl.jnhw.util.posix.DefinesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.LINUX)
public class EventfdTest {

    public static class NativeDefines {

        public final static native boolean HAVE_SYS_EVENTFD_H();

        public final static native int EFD_CLOEXEC();

        public final static native int EFD_NONBLOCK();

        public final static native int EFD_SEMAPHORE();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }
    private final static MultiarchTupelBuilder MULTIARCHTUPEL_BUILDER = new MultiarchTupelBuilder();

    @BeforeAll
    public static void checkBeforeAll_HAVE_SYS_EVENTFD_H() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.LINUX) {
            Assertions.assertTrue(Eventfd.HAVE_SYS_EVENTFD_H, "expected to have sys/eventfd.h");
        } else {
            Assertions.assertFalse(Eventfd.HAVE_SYS_EVENTFD_H, "not expected to have sys/eventfd.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_FcntlDefines() throws Exception {
        if (MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Eventfd.class, NativeDefines.class, "HAVE_SYS_EVENTFD_H");
    }

    @Test
    public void testEventFD() throws Exception {
        int fd = Eventfd.eventfd(42, 0);

        long result = Eventfd.eventfd_read(fd);
        Assertions.assertEquals(42, result);

        Eventfd.eventfd_write(fd, 25);
        Eventfd.eventfd_write(fd, 30);
        result = Eventfd.eventfd_read(fd);
        Assertions.assertEquals(55, result);

        Eventfd.eventfd_write(fd, 33);
        result = Eventfd.eventfd_read(fd);
        Assertions.assertEquals(33, result);

        Unistd.close(fd);
    }

    @Test
    public void testEventFD_0() throws Exception {
        int fd = Eventfd.eventfd(0, 0);

        Eventfd.eventfd_write(fd, 1);
        long result = Eventfd.eventfd_read(fd);
        Assertions.assertEquals(1, result);

        Eventfd.eventfd_write(fd, 2);
        result = Eventfd.eventfd_read(fd);
        Assertions.assertEquals(2, result);

        Eventfd.eventfd_write(fd, 3);
        result = Eventfd.eventfd_read(fd);
        Assertions.assertEquals(3, result);

        Eventfd.eventfd_write(fd, 1);
        result = Eventfd.eventfd_read(fd);
        Assertions.assertEquals(1, result);

        Unistd.close(fd);
    }

}
