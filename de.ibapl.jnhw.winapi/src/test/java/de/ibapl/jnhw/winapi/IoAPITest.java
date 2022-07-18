/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.UintPtr_t;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class IoAPITest {

    private ResourceScope scope;

    @BeforeEach
    public void setUp() throws Exception {
        scope = ResourceScope.newConfinedScope();
    }

    @AfterEach
    public void tearDown() throws Exception {
        scope.close();
    }

    /**
     * Test of PostQueuedCompletionStatus method, of class Ioapiset.
     */
    @Test
    public void testPostQueuedCompletionStatus() throws Exception {
        System.out.println("PostQueuedCompletionStatus");
        final long COMPLETION_KEY = 0xCAFE;
        final Winnt.HANDLE completionPort = IoAPI.CreateIoCompletionPort(Winnt.HANDLE.INVALID_HANDLE_VALUE, Winnt.HANDLE.NULL, COMPLETION_KEY, 0);
        final Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(scope);
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(scope);
        BaseTsd.PULONG_PTR lpCompletionKey = BaseTsd.PULONG_PTR.allocateNative(scope);
        UintPtr_t<Minwinbase.LPOVERLAPPED> lpOverlapped = UintPtr_t.allocateNative(scope);
        final int dwNumberOfBytesTransferred = 42;
        long dwMilliseconds = 5000;
        new Thread(() -> {
            try {
                Thread.sleep(20);
                IoAPI.PostQueuedCompletionStatus(completionPort, dwNumberOfBytesTransferred, COMPLETION_KEY, overlapped);
                System.out.println("testPostQueuedCompletionStatus PostQueuedCompletionStatus called");
            } catch (InterruptedException | NativeErrorException ex) {
                fail(ex);
            }
        }).start();
        IoAPI.GetQueuedCompletionStatus(completionPort, lpNumberOfBytesTransferred, lpCompletionKey, lpOverlapped, dwMilliseconds);

        assertEquals(COMPLETION_KEY, lpCompletionKey.PULONG_PTR());
        lpCompletionKey.PULONG_PTR(0);
        assertEquals(dwNumberOfBytesTransferred, lpNumberOfBytesTransferred.uint32_t());
        lpNumberOfBytesTransferred.uint32_t(0);
        assertEquals(lpOverlapped.get(), OpaqueMemory.getMemorySegment(overlapped).address());
        lpOverlapped = null;

        IoAPI.PostQueuedCompletionStatus(completionPort, dwNumberOfBytesTransferred, COMPLETION_KEY, null);
        IoAPI.GetQueuedCompletionStatus(completionPort, lpNumberOfBytesTransferred, lpCompletionKey, lpOverlapped, dwMilliseconds);
        assertEquals(COMPLETION_KEY, lpCompletionKey.PULONG_PTR());
        assertEquals(dwNumberOfBytesTransferred, lpNumberOfBytesTransferred.uint32_t());
        assertEquals(MemoryAddress.NULL, OpaqueMemory.getMemorySegment(lpOverlapped).address());

        Handleapi.CloseHandle(completionPort);

    }

}
