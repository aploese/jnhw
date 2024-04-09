/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2020-2024, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.posix.JnhwTestLogger;
import de.ibapl.jnhw.posix.Unistd;
import de.ibapl.jnhw.util.posix.DefinesTest;
import java.lang.foreign.Arena;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.LINUX)
public class EventfdTest {

    @BeforeAll
    public static void checkBeforeAll_HAVE_SYS_EVENTFD_H() throws Exception {
        JnhwTestLogger.logBeforeAllBegin("checkBeforeAll_HAVE_SYS_EVENTFD_H");
        Assertions.assertTrue(Eventfd.HAVE_SYS_EVENTFD_H, "expected to have sys/eventfd.h");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_HAVE_SYS_EVENTFD_H");
    }

    @BeforeAll
    public static void checkBeforeAll_EventFdDefines() throws Exception {
        JnhwTestLogger.logBeforeAllBegin("checkBeforeAll_EventFdDefines");
        DefinesTest.testDefines(Eventfd.class, "HAVE_SYS_EVENTFD_H");
        JnhwTestLogger.logBeforeAllEnd("checkBeforeAll_EventFdDefines");
    }

    @AfterAll
    public static void tearDownAfterClass(TestInfo testTnfo) throws Exception {
        JnhwTestLogger.logAfterAll(testTnfo);
    }

    private Arena arena;

    @BeforeEach
    public void setUp(TestInfo testInfo) throws Exception {
        JnhwTestLogger.logBeforeEach(testInfo);
        arena = Arena.ofConfined();
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        arena.close();
        JnhwTestLogger.logBeforeEach(testInfo);
    }

    @Test
    public void testEventFD() throws Exception {
        int fd = Eventfd.eventfd(42, 0);
        Eventfd.PtrEventfd_t readValue = Eventfd.PtrEventfd_t.allocateNative(arena);

        Eventfd.eventfd_read(fd, readValue);
        Assertions.assertEquals(42, readValue.uint64_t());

        Eventfd.eventfd_write(fd, 25);
        Eventfd.eventfd_write(fd, 30);
        Eventfd.eventfd_read(fd, readValue);
        Assertions.assertEquals(55, readValue.uint64_t());

        Eventfd.eventfd_write(fd, 33);
        Eventfd.eventfd_read(fd, readValue);
        Assertions.assertEquals(33, readValue.uint64_t());

        Unistd.close(fd);
    }

    @Test
    public void testEventFD_0() throws Exception {
        int fd = Eventfd.eventfd(0, 0);
        Eventfd.PtrEventfd_t readValue = Eventfd.PtrEventfd_t.allocateNative(arena);

        Eventfd.eventfd_write(fd, 1);
        Eventfd.eventfd_read(fd, readValue);
        Assertions.assertEquals(1, readValue.uint64_t());

        Eventfd.eventfd_write(fd, 2);
        Eventfd.eventfd_read(fd, readValue);
        Assertions.assertEquals(2, readValue.uint64_t());

        Eventfd.eventfd_write(fd, 3);
        Eventfd.eventfd_read(fd, readValue);
        Assertions.assertEquals(3, readValue.uint64_t());

        Eventfd.eventfd_write(fd, 1);
        Eventfd.eventfd_read(fd, readValue);
        Assertions.assertEquals(1, readValue.uint64_t());

        Unistd.close(fd);
    }

}
