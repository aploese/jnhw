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

import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.OS;
import de.ibapl.jnhw.util.posix.DefinesTest;
import de.ibapl.jnhw.util.posix.PosixDataType;
import java.lang.foreign.MemorySession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

@DisabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class PollTest {

    @BeforeAll
    public static void checkBeforeAll_HAVE_POLL_H() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            Assertions.assertFalse(Poll.HAVE_POLL_H, "not expected to have poll.h");
        } else {
            Assertions.assertTrue(Poll.HAVE_POLL_H, "expected to have poll.h");
        }
    }

    @BeforeAll
    public static void checkBeforeAll_PollDefines() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        DefinesTest.testDefines(Poll.class, "HAVE_POLL_H");
    }

    @BeforeAll
    public static void checkBeforeAll_StructPollFd() throws Exception {
        if (MultiarchTupelBuilder.getOS() == OS.WINDOWS) {
            return;
        }
        Assertions.assertAll(() -> {
            Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("PollFd_sizeof"), Poll.PollFd.sizeof, "sizeof");
        },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("PollFd_alignof"), Poll.PollFd.alignof.alignof, "alignof");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("PollFd_offsetof_fd"), Poll.PollFd.offsetof_Fd, "offsetof_Fd");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("PollFd_offsetof_events"), Poll.PollFd.offsetof_Events, "offsetof_Events");
                },
                () -> {
                    Assertions.assertEquals(LibJnhwPosixTestLoader.invoke_sI___V("PollFd_offsetof_revents"), Poll.PollFd.offsetof_Revents, "offsetof_Revents");
                }
        );
    }

    private MemorySession ms;

    @BeforeEach
    public void setUp() {
        ms = MemorySession.openConfined();
    }

    @AfterEach
    public void tearDown() {
        ms.close();
    }

    @Test
    public void testCreatePollFd() throws Exception {
        Poll.PollFds pollFds = Poll.PollFds.allocateNative(ms, 2);
    }

    @Test
    public void testNPEpoll() throws Exception {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Poll.poll((Poll.PollFd) null, 1000);
        });
    }

    @Test
    public void testNfds_t() {
        switch (MultiarchTupelBuilder.getMemoryModel()) {
            case ILP32 -> {
                Assertions.assertEquals(4, PosixDataType.nfds_t.SIZE_OF);
                Assertions.assertEquals(Alignment.AT_4, PosixDataType.nfds_t.ALIGN_OF);
                Assertions.assertTrue(PosixDataType.nfds_t.UNSIGNED);
                Poll.Nfds_t instance = Poll.Nfds_t.allocateNative(ms);
                Assertions.assertThrows(
                        IllegalArgumentException.class,
                        () -> instance.setFromUnsignedLong(0x8070605040302010L));
                instance.setFromUnsignedLong(0x0000000040302010L);
                assertEquals(0x0000000040302010L, instance.getAsUnsignedLong());
                assertEquals(Long.toUnsignedString(0x0000000040302010L), instance.nativeToString());
                assertEquals("0x40302010", instance.nativeToHexString());
                //This is unsigned so this is really
                instance.setFromUnsignedLong(0x00000000ffffffffL);
                assertEquals(0x00000000ffffffffL, instance.getAsUnsignedLong());
                assertEquals("4294967295", instance.nativeToString());
                assertEquals("0xffffffff", instance.nativeToHexString());
            }
            case LP64 -> {
                Assertions.assertEquals(8, PosixDataType.nfds_t.SIZE_OF);
                Assertions.assertEquals(Alignment.AT_8, PosixDataType.nfds_t.ALIGN_OF);
                Assertions.assertTrue(PosixDataType.nfds_t.UNSIGNED);
                Poll.Nfds_t instance = Poll.Nfds_t.allocateNative(ms);
                instance.setFromUnsignedLong(0x8070605040302010L);
                assertEquals(0x8070605040302010L, instance.getAsUnsignedLong());
                assertEquals(Long.toUnsignedString(0x8070605040302010L), instance.nativeToString());
                assertEquals("0x8070605040302010", instance.nativeToHexString());
                //This is unsigned so this is really
                instance.setFromUnsignedLong(-1L);
                assertEquals(-1, instance.getAsUnsignedLong());
                assertEquals("18446744073709551615", instance.nativeToString());
                assertEquals("0xffffffffffffffff", instance.nativeToHexString());
            }
            default ->
                Assertions.fail();
        }
    }

}
