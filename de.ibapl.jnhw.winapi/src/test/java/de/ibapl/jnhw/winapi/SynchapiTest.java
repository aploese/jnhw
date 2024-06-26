/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.exception.NativeErrorException;
import java.lang.foreign.Arena;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class SynchapiTest {

    private Arena arena;

    @BeforeEach
    public void setUp() throws Exception {
        arena = Arena.ofShared();
    }

    @AfterEach
    public void tearDown() throws Exception {
        arena.close();
    }

    @Test
    public void testSleepEx() throws Exception {
        Synchapi.SleepEx(10, false);
        Synchapi.SleepEx(10, true);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Synchapi.SleepEx(-10, true);
        });
    }

    @Test
    public void testWaitForMultipleSignaled() throws Exception {
        final Winnt.HANDLE hEvent1 = Synchapi.CreateEventW(null, true, false, null);
        final Winnt.HANDLE hEvent2 = Synchapi.CreateEventW(null, true, false, null);
        final Winnt.ArrayOfHandle handles = Winnt.ArrayOfHandle.allocateNative(2, arena);
        handles.set(0, hEvent1);
        handles.set(1, hEvent2);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                    Synchapi.SetEvent(hEvent2);
                } catch (InterruptedException | NativeErrorException ie) {
                    throw new RuntimeException(ie);
                }

            }).start();
            long result = Synchapi.WaitForMultipleObjects(handles, false, 1000);
            Assertions.assertEquals(Winbase.WAIT_OBJECT_0 + 1, result);
            return result;
        });
        Handleapi.CloseHandle(hEvent1);
        Handleapi.CloseHandle(hEvent2);
    }

    @Test
    public void testWaitForMultipleTimeout() throws Exception {
        final Winnt.HANDLE hEvent1 = Synchapi.CreateEventW(null, true, false, null);
        final Winnt.HANDLE hEvent2 = Synchapi.CreateEventW(null, true, false, null);
        final Winnt.ArrayOfHandle handles = Winnt.ArrayOfHandle.allocateNative(2, arena);
        handles.set(0, hEvent1);
        handles.set(1, hEvent2);

        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            long result = Synchapi.WaitForMultipleObjects(handles, false, 100);
            Assertions.assertEquals(Winerror.WAIT_TIMEOUT, result);
            return result;
        });
        Handleapi.CloseHandle(hEvent1);
        Handleapi.CloseHandle(hEvent2);
    }

    @Test
    public void testWaitForSingleSignaled() throws Exception {
        final Winnt.HANDLE hEvent = Synchapi.CreateEventW(null, true, false, null);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5000), () -> {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                    Synchapi.SetEvent(hEvent);
                } catch (InterruptedException | NativeErrorException ie) {
                    throw new RuntimeException(ie);
                }

            }).start();
            long result = Synchapi.WaitForSingleObject(hEvent, 1000);
            Assertions.assertEquals(Winbase.WAIT_OBJECT_0, result);
            return null;
        });
        Handleapi.CloseHandle(hEvent);
    }

    @Test
    public void testWaitForSingleTimeout() throws Exception {
        final Winnt.HANDLE hEvent = Synchapi.CreateEventW(null, true, false, null);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            long result = Synchapi.WaitForSingleObject(hEvent, 100);
            Assertions.assertEquals(Winerror.WAIT_TIMEOUT, result);
            return null;
        });
        Handleapi.CloseHandle(hEvent);
    }

    @Test
    public void testWaitForSingleTimeoutEx() throws Exception {
        final Winnt.HANDLE hEvent = Synchapi.CreateEventW(null, true, false, null);
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            long result = Synchapi.WaitForSingleObjectEx(hEvent, 100, false);
            Assertions.assertEquals(Winerror.WAIT_TIMEOUT, result);
            return null;
        });
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(1000), () -> {
            long result = Synchapi.WaitForSingleObjectEx(hEvent, 100, true);
            Assertions.assertEquals(Winerror.WAIT_TIMEOUT, result);
            return null;
        });
        Handleapi.CloseHandle(hEvent);
    }

}
