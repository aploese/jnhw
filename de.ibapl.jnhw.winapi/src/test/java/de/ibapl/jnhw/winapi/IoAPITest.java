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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.Uint32_t;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aploese
 */
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class IoAPITest {

    public IoAPITest() {
    }

    /**
     * Test of PostQueuedCompletionStatus method, of class Ioapiset.
     */
    @Test
    public void testPostQueuedCompletionStatus() throws Exception {
        System.out.println("PostQueuedCompletionStatus");
        final long COMPLETION_KEY = 0xCAFE;
        final Winnt.HANDLE completionPort = IoAPI.CreateIoCompletionPort(Winnt.HANDLE.INVALID_HANDLE_VALUE, Winnt.HANDLE.NULL, COMPLETION_KEY, 0);
        final Minwinbase.OVERLAPPED overlapped = new Minwinbase.OVERLAPPED();
        Int32_t lpNumberOfBytesTransferred = new Int32_t();
        Uint32_t lpCompletionKey = new Uint32_t();
        NativeAddressHolder<Minwinbase.OVERLAPPED> lpOverlapped;
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
        lpOverlapped = IoAPI.GetQueuedCompletionStatus(completionPort, lpNumberOfBytesTransferred, lpCompletionKey, dwMilliseconds);

        assertEquals(COMPLETION_KEY, lpCompletionKey.uint32_t());
        lpCompletionKey.uint32_t(0);
        assertEquals(dwNumberOfBytesTransferred, lpNumberOfBytesTransferred.int32_t());
        lpNumberOfBytesTransferred.int32_t(0);
        assertEquals(lpOverlapped, AbstractNativeMemory.toNativeAddressHolder(overlapped));
        lpOverlapped = null;

        IoAPI.PostQueuedCompletionStatus(completionPort, dwNumberOfBytesTransferred, COMPLETION_KEY, null);
        lpOverlapped = IoAPI.GetQueuedCompletionStatus(completionPort, lpNumberOfBytesTransferred, lpCompletionKey, dwMilliseconds);
        assertEquals(COMPLETION_KEY, lpCompletionKey.uint32_t());
        assertEquals(dwNumberOfBytesTransferred, lpNumberOfBytesTransferred.int32_t());
        assertEquals(NativeAddressHolder.NULL, lpOverlapped);

        Handleapi.CloseHandle(completionPort);

    }

}
