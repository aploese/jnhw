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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.UintPtr_t;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class IoAPITest {

    private Arena arena;

    @BeforeEach
    public void setUp() throws Exception {
        arena = Arena.ofShared();
    }

    @AfterEach
    public void tearDown() throws Exception {
        arena.close();
    }

    /**
     * Test of PostQueuedCompletionStatus method, of class Ioapiset.
     */
    @Test
    public void testPostQueuedCompletionStatus() throws Exception {
        System.out.println("PostQueuedCompletionStatus");
        final long COMPLETION_KEY = 0xCAFE;
        final Winnt.HANDLE completionPort = IoAPI.CreateIoCompletionPort(Winnt.HANDLE.INVALID_HANDLE_VALUE, Winnt.HANDLE.NULL, COMPLETION_KEY, 0);
        final Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(arena);
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(arena);
        BaseTsd.PULONG_PTR lpCompletionKey = BaseTsd.PULONG_PTR.allocateNative(arena);
        UintPtr_t<Minwinbase.LPOVERLAPPED> lpOverlapped = UintPtr_t.allocateNative(arena);
        final int dwNumberOfBytesTransferred = 42;
        long dwMilliseconds = 5000;
        Throwable ta[] = new Throwable[1];
        new Thread(() -> {
            try {
                Thread.sleep(20);
                IoAPI.PostQueuedCompletionStatus(completionPort, dwNumberOfBytesTransferred, COMPLETION_KEY, overlapped);
                System.out.println("testPostQueuedCompletionStatus PostQueuedCompletionStatus called");
            } catch (Throwable t) {
                ta[0] = t;
            }
        }).start();
        Thread.yield();
        try {
            IoAPI.GetQueuedCompletionStatus(completionPort, lpNumberOfBytesTransferred, lpCompletionKey, lpOverlapped, dwMilliseconds);
        } finally {
            if (ta[0] != null) {
                fail(ta[0]);
            }
        }
        assertEquals(COMPLETION_KEY, lpCompletionKey.PULONG_PTR());
        lpCompletionKey.PULONG_PTR(0);
        assertEquals(dwNumberOfBytesTransferred, lpNumberOfBytesTransferred.uint32_t());
        lpNumberOfBytesTransferred.uint32_t(0);
        assertEquals(lpOverlapped.get().address(), OpaqueMemory.getMemorySegment(overlapped).address());
        UintPtr_t<Minwinbase.LPOVERLAPPED> lpOverlapped0 = UintPtr_t.allocateNative(arena);

        IoAPI.PostQueuedCompletionStatus(completionPort, dwNumberOfBytesTransferred, COMPLETION_KEY, null);
        IoAPI.GetQueuedCompletionStatus(completionPort, lpNumberOfBytesTransferred, lpCompletionKey, lpOverlapped0, dwMilliseconds);
        assertEquals(COMPLETION_KEY, lpCompletionKey.PULONG_PTR());
        assertEquals(dwNumberOfBytesTransferred, lpNumberOfBytesTransferred.uint32_t());
        assertEquals(MemorySegment.NULL, lpOverlapped0.get());

        Handleapi.CloseHandle(completionPort);

    }

}
