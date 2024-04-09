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
package de.ibapl.jnhw.it.hello_world_async_io;

import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.UintPtr_t;
import de.ibapl.jnhw.winapi.BaseTsd;
import de.ibapl.jnhw.winapi.Fileapi;
import de.ibapl.jnhw.winapi.Handleapi;
import de.ibapl.jnhw.winapi.IoAPI;
import de.ibapl.jnhw.winapi.Minwinbase;
import de.ibapl.jnhw.winapi.WinDef;
import de.ibapl.jnhw.winapi.Winbase;
import de.ibapl.jnhw.winapi.Winnt;
import java.io.File;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;

public class Windows {

    private final static Arena arena = Arena.ofShared();

    public static void aio(File file, MemorySegment aioBuffer, final boolean debug) throws NativeErrorException, IOException {

        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);

        final Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(arena);
        final long COMPLETION_KEY = 24;
        Winnt.HANDLE hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(arena);
        BaseTsd.PULONG_PTR lpCompletionKey = BaseTsd.PULONG_PTR.allocateNative(arena);

        Fileapi.WriteFile(hFile, aioBuffer, overlapped);

        UintPtr_t<Minwinbase.LPOVERLAPPED> overlappedPtr = UintPtr_t.allocateNative(arena);
        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);

        /*
        Assertions.assertNotNull(overlappedPtr.value);
        Assertions.assertTrue(OpaqueMemory32.isSameAddress(overlappedPtr.value, overlapped));
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.value);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.value);
         */
        Handleapi.CloseHandle(hFile);

        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        aioBuffer.fill((byte) 0);

        Fileapi.ReadFile(hFile, aioBuffer, overlapped);

        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);

        /*
        Assertions.assertNotNull(overlappedPtr.value);
        Assertions.assertTrue(OpaqueMemory32.isSameAddress(overlappedPtr.value, overlapped));
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.value);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.value);
         */
        Handleapi.CloseHandle(hFile);

        StringBuilder sb = new StringBuilder((int) aioBuffer.byteSize());
        for (int i = 0; i < aioBuffer.byteSize(); i++) {
            sb.append((char) aioBuffer.get(ValueLayout.JAVA_BYTE, i));
        }

        System.out.println(sb.toString());
    }

}
