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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.libloader.NativeLibResolver;
import de.ibapl.jnhw.libloader.OS;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

public class SynchapiTests {

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void test_HAVE_SYNCAPI_H() throws Exception {
        if (NativeLibResolver.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Synchapi.HAVE_SYNCHAPI_H(), "expected to have synchapi.h");
        } else {
            Assertions.assertFalse(Synchapi.HAVE_SYNCHAPI_H(), "not expected to have synchapi.h");
        }
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testWaitForSingleTimeout() throws Exception {
        final Winnt.HANDLE hEvent = Synchapi.CreateEventW(null, true, false, null);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            long result = Synchapi.WaitForSingleObject(hEvent, 1000);
            Assertions.assertEquals(Winbase.WAIT_TIMEOUT(), result);
            return null;
        });
        Winbase.CloseHandle(hEvent);
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testWaitForSingleSignaled() throws Exception {
        final Winnt.HANDLE hEvent = Synchapi.CreateEventW(null, true, false, null);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                    Synchapi.SetEvent(hEvent);
                } catch (InterruptedException ie) {
                    throw new RuntimeException(ie);
                }

            }).start();
            long result = Synchapi.WaitForSingleObject(hEvent, 1000);
            Assertions.assertEquals(Winbase.WAIT_OBJECT_0(), result);
            return null;
        });
        Winbase.CloseHandle(hEvent);
    }
}
