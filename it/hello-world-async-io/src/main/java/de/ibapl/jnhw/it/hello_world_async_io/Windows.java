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
package de.ibapl.jnhw.it.hello_world_async_io;

import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.references.IntRef;
import de.ibapl.jnhw.common.references.LongRef;
import de.ibapl.jnhw.common.references.ObjectRef;
import de.ibapl.jnhw.winapi.Fileapi;
//Import only the needed define from the wrapper of processenv.h
import de.ibapl.jnhw.winapi.Handleapi;
import de.ibapl.jnhw.winapi.IoAPI;
import de.ibapl.jnhw.winapi.Minwinbase;
import de.ibapl.jnhw.winapi.Winbase;
import de.ibapl.jnhw.winapi.Winnt;
import java.io.File;
import java.io.IOException;

public class Windows {

    public static void aio(File file, OpaqueMemory32 aioBuffer, final boolean debug) throws NativeErrorException, IOException {

        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);

        final Minwinbase.OVERLAPPED overlapped = new Minwinbase.OVERLAPPED();
        final long COMPLETION_KEY = 24;
        Winnt.HANDLE hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        IntRef lpNumberOfBytesTransferred = new IntRef();
        LongRef lpCompletionKey = new LongRef();

        ObjectRef<NativeAddressHolder> overlappedPtr = new ObjectRef<>();

        Fileapi.WriteFile(hFile, aioBuffer, overlapped);

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

        OpaqueMemory32.clear(aioBuffer);

        Fileapi.ReadFile(hFile, aioBuffer, overlapped);

        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);

        /*
        Assertions.assertNotNull(overlappedPtr.value);
        Assertions.assertTrue(OpaqueMemory32.isSameAddress(overlappedPtr.value, overlapped));
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.value);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.value);
         */
        Handleapi.CloseHandle(hFile);

        StringBuilder sb = new StringBuilder(aioBuffer.sizeInBytes);
        for (int i = 0; i < aioBuffer.sizeInBytes; i++) {
            sb.append((char) OpaqueMemory32.getByte(aioBuffer, i));
        }

        System.out.println(sb.toString());
    }

}
