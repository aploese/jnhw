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

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LongRef;
import de.ibapl.jnhw.NativeAddressHolder;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.ObjectRef;
import de.ibapl.jnhw.OpaqueMemory;
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
        IntRef lpNumberOfBytesTransferred = new IntRef();
        LongRef lpCompletionKey = new LongRef();
        ObjectRef<NativeAddressHolder> lpOverlapped = new ObjectRef();
        final int dwNumberOfBytesTransferred = 42;
        long dwMilliseconds = 1000;
        new Thread(() -> {
            try {
                Thread.sleep(100);
                IoAPI.PostQueuedCompletionStatus(completionPort, dwNumberOfBytesTransferred, COMPLETION_KEY, overlapped);
            } catch (InterruptedException | NativeErrorException ex) {
                fail(ex);
            }
        }).start();
        IoAPI.GetQueuedCompletionStatus(completionPort, lpNumberOfBytesTransferred, lpCompletionKey, lpOverlapped, dwMilliseconds);

        assertEquals(COMPLETION_KEY, lpCompletionKey.value);
        lpCompletionKey.value = 0;
        assertEquals(dwNumberOfBytesTransferred, lpNumberOfBytesTransferred.value);
        lpNumberOfBytesTransferred.value = 0;
        assertTrue(OpaqueMemory.isSameAddress(lpOverlapped.value, overlapped));
        lpOverlapped.value = null;

        IoAPI.PostQueuedCompletionStatus(completionPort, dwNumberOfBytesTransferred, COMPLETION_KEY, null);
        IoAPI.GetQueuedCompletionStatus(completionPort, lpNumberOfBytesTransferred, lpCompletionKey, lpOverlapped, dwMilliseconds);
        assertEquals(COMPLETION_KEY, lpCompletionKey.value);
        assertEquals(dwNumberOfBytesTransferred, lpNumberOfBytesTransferred.value);
        assertNull(lpOverlapped.value);
    }

}
