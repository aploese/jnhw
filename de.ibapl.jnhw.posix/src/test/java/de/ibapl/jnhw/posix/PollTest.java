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

import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.DefinesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class PollTest {

    public static class NativeDefines {

        public final static native boolean HAVE_POLL_H();

        public final static native short POLLERR();

        public final static native short POLLHUP();

        public final static native short POLLIN();

        public final static native short POLLNVAL();

        public final static native short POLLOUT();

        public final static native short POLLPRI();

        public final static native short POLLRDBAND();

        public final static native short POLLRDNORM();

        public final static native short POLLWRBAND();

        public final static native short POLLWRNORM();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    public static class NativePollFd {

        public final static native int alignof();

        public final static native int sizeof();

        public final static native long fd();

        public final static native long events();

        public final static native long revents();

        static {
            LibJnhwPosixTestLoader.touch();
        }
    }

    @BeforeAll
    public static void checkBeforeAll_HAVE_POLL_H() throws Exception {
        if (DefinesTest.MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Poll.HAVE_POLL_H, "not expected to have poll.h");
        } else {
            Assertions.assertTrue(Poll.HAVE_POLL_H, "expected to have poll.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_PollDefines() throws Exception {
        if (DefinesTest.MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Poll.class, NativeDefines.class, "HAVE_POLL_H");
    }

    @BeforeAll
    public static void checkBeforeAll_StructPollFd() throws Exception {
        if (DefinesTest.MULTIARCHTUPEL_BUILDER.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(NativePollFd.sizeof(), Poll.PollFd.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(NativePollFd.alignof(), Poll.PollFd.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(NativePollFd.fd(), Poll.PollFd.offsetof_Fd, "offsetof_Fd");
                },
                () -> {
                    Assertions.assertEquals(NativePollFd.events(), Poll.PollFd.offsetof_Events, "offsetof_Events");
                },
                () -> {
                    Assertions.assertEquals(NativePollFd.revents(), Poll.PollFd.offsetof_Revents, "offsetof_Revents");
                }
        );
    }

    @Test
    public void testCreatePollFd() throws Exception {
        Poll.PollFds pollFds = new Poll.PollFds(2);
    }

    @Test
    public void testNPEpoll() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Poll.poll((Poll.PollFd) null, 1000);
        });
        Assertions.assertThrows(NullPointerException.class, () -> {
            Poll.poll((Poll.PollFd) null, 1000);
        });
    }

}
