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
import de.ibapl.jnhw.ObjectRef;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.util.ByteBufferUtils;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class FileapiTests {

    private final static byte[] WRITE_VALUE = "Hello world!".getBytes();

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }
    private File file;

    @BeforeEach
    public void setUp() throws Exception {
        file = File.createTempFile("JNHW_FileapiTests", ".txt");
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testByteArray() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                0,
                null);
        int bytesWritten = Fileapi.WriteFile(hFile, WRITE_VALUE, 0, WRITE_VALUE.length);
        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, bytesWritten);

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                0,
                null);
        byte[] readBuffer = new byte[WRITE_VALUE.length];
        int bytesRead = Fileapi.ReadFile(hFile, readBuffer, 0, readBuffer.length);
        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, bytesRead);
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
        }
    }

    @Test
    public void testByteBufferAcynchronousIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(), 
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);
        Minwinbase.OVERLAPPED overlapped = new Minwinbase.OVERLAPPED();
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
        byteBuffer.put(WRITE_VALUE);
        byteBuffer.flip();
        Fileapi.WriteFile(hFile, byteBuffer, overlapped);
        long waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE());
        Assertions.assertEquals(Winbase.WAIT_OBJECT_0(), waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, byteBuffer, false);
        Synchapi.ResetEvent(overlapped.hEvent());

        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);
        byteBuffer.clear();
        byteBuffer.limit(WRITE_VALUE.length);
        Fileapi.ReadFile(hFile, byteBuffer, overlapped);
        waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE());
        Assertions.assertEquals(Winbase.WAIT_OBJECT_0(), waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, byteBuffer, false);
        Handleapi.CloseHandle(overlapped.hEvent());
        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());
        byteBuffer.flip();
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], byteBuffer.get());
        }
    }

    @Test
    public void testByteBufferAlertableIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(), 
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);
        final Minwinbase.OVERLAPPED overlapped = new Minwinbase.OVERLAPPED();
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
        byteBuffer.put(WRITE_VALUE);
        byteBuffer.flip();
        
        Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE overlappedCompletionRoutine = new Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE() {
            @Override
            protected void callback(int dwErrorCode, int dwNumberOfBytesTransfered, Minwinbase.OVERLAPPED lpOverlapped) {
                Assertions.assertEquals(Winerror.ERROR_SUCCESS(), dwErrorCode);
                Assertions.assertEquals(WRITE_VALUE.length, dwNumberOfBytesTransfered);
            }

            @Override
            protected Minwinbase.OVERLAPPED wrapC(NativeAddressHolder address) {
                if (OpaqueMemory.isSameAddress(address, overlapped)) {
                    return overlapped;
                } else {
                    throw new RuntimeException("Address mismatch was: " + address + " bgut expected " + overlapped);
                } 
            }
        };
                
        Fileapi.WriteFileEx(hFile, byteBuffer, overlapped, overlappedCompletionRoutine);
        long waitResult = Synchapi.WaitForSingleObjectEx(overlapped.hEvent(), Winbase.INFINITE(), true);
        Assertions.assertEquals(Winbase.WAIT_IO_COMPLETION(), waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, byteBuffer, false);
        Synchapi.ResetEvent(overlapped.hEvent());

        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);
        byteBuffer.clear();
        byteBuffer.limit(WRITE_VALUE.length);
        
        Fileapi.ReadFileEx(hFile, byteBuffer, overlapped, overlappedCompletionRoutine);
        waitResult = Synchapi.WaitForSingleObjectEx(overlapped.hEvent(), Winbase.INFINITE(), true);
        Assertions.assertEquals(Winbase.WAIT_IO_COMPLETION(), waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, byteBuffer, false);
        Handleapi.CloseHandle(overlapped.hEvent());
        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());
        byteBuffer.flip();
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], byteBuffer.get());
        }
    }

    @Test
    public void testByteBufferIOCompetitionPort() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(), 
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);
        final Minwinbase.OVERLAPPED overlapped = new Minwinbase.OVERLAPPED();
        final long COMPLETION_KEY = 24;
        Winnt.HANDLE hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);
        
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
        byteBuffer.put(WRITE_VALUE);
        byteBuffer.flip();
        
        IntRef lpNumberOfBytesTransferred = new IntRef();
        LongRef lpCompletionKey = new LongRef();
        
        ObjectRef<NativeAddressHolder> overlappedPtr = new ObjectRef();
        
        Fileapi.WriteFile(hFile, byteBuffer, overlapped);
        
        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);
        
        Assertions.assertNotNull(overlappedPtr.value);
        Assertions.assertTrue(OpaqueMemory.isSameAddress(overlappedPtr.value, overlapped));
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.value);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.value);
        ByteBufferUtils.fixBufferPos(byteBuffer, lpNumberOfBytesTransferred.value);

        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);
        hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        byteBuffer.clear();
        byteBuffer.limit(WRITE_VALUE.length);
        
        Fileapi.ReadFile(hFile, byteBuffer, overlapped);

        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);
        
        Assertions.assertNotNull(overlappedPtr.value);
        Assertions.assertTrue(OpaqueMemory.isSameAddress(overlappedPtr.value, overlapped));
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.value);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.value);
        ByteBufferUtils.fixBufferPos(byteBuffer, lpNumberOfBytesTransferred.value);

        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());
        byteBuffer.flip();
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], byteBuffer.get());
        }
    }
    
    @Test
    public void testByteBufferNotDirect() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                0,
                null);

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.put(WRITE_VALUE);
        byteBuffer.flip();
        Fileapi.WriteFile(hFile, byteBuffer);

        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                0,
                null);
        byteBuffer.clear();
        byteBuffer.limit(WRITE_VALUE.length);
        Fileapi.ReadFile(hFile, byteBuffer);
        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());
        byteBuffer.flip();
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], byteBuffer.get());
        }
    }

    @Test
    public void testByteBufferSynchronousIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                0,
                null);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
        byteBuffer.put(WRITE_VALUE);
        byteBuffer.flip();
        Fileapi.WriteFile(hFile, byteBuffer);
        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                0,
                null);
        byteBuffer.clear();
        byteBuffer.limit(WRITE_VALUE.length);
        Fileapi.ReadFile(hFile, byteBuffer);
        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());
        byteBuffer.flip();
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], byteBuffer.get());
        }
    }

    @Test
    public void testOpaqueMemoryAsynchronousIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);
        Minwinbase.OVERLAPPED overlapped = new Minwinbase.OVERLAPPED();
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));

        OpaqueMemory opaqueMemory = new OpaqueMemory(64, true);
        OpaqueMemory.copy(opaqueMemory, 0, WRITE_VALUE, 0, WRITE_VALUE.length);
        Fileapi.WriteFile(hFile, opaqueMemory, overlapped);
        long waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE());
        Assertions.assertEquals(Winbase.WAIT_OBJECT_0(), waitResult, "Error during wait");

        int bytesTransferred = Ioapiset.GetOverlappedResult(hFile, overlapped, false);
        Synchapi.ResetEvent(overlapped.hEvent());

        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(opaqueMemory.sizeInBytes, bytesTransferred);

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);

        OpaqueMemory.clear(opaqueMemory);
        Fileapi.ReadFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped);
        waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE());
        Assertions.assertEquals(Winbase.WAIT_OBJECT_0(), waitResult, "Error during wait");
        bytesTransferred = Ioapiset.GetOverlappedResult(hFile, overlapped, false);

        Handleapi.CloseHandle(overlapped.hEvent());
        Handleapi.CloseHandle(hFile);

        Assertions.assertEquals(WRITE_VALUE.length, bytesTransferred);
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }

    @Test
    public void testOpaqueMemoryAlertableIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);
        Minwinbase.OVERLAPPED overlapped = new Minwinbase.OVERLAPPED();
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));

        OpaqueMemory opaqueMemory = new OpaqueMemory(64, true);
        OpaqueMemory.copy(opaqueMemory, 0, WRITE_VALUE, 0, WRITE_VALUE.length);

        Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE overlappedCompletionRoutine = new Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE() {
            @Override
            protected void callback(int dwErrorCode, int dwNumberOfBytesTransfered, Minwinbase.OVERLAPPED lpOverlapped) {
                Assertions.assertEquals(Winerror.ERROR_SUCCESS(), dwErrorCode);
                Assertions.assertEquals(WRITE_VALUE.length, dwNumberOfBytesTransfered);
            }

            @Override
            protected Minwinbase.OVERLAPPED wrapC(NativeAddressHolder address) {
                if (OpaqueMemory.isSameAddress(address, overlapped)) {
                    return overlapped;
                } else {
                    throw new RuntimeException("Address mismatch was: " + address + " bgut expected " + overlapped);
                } 
            }
        };
                

        Fileapi.WriteFileEx(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped, overlappedCompletionRoutine);
        long waitResult = Synchapi.WaitForSingleObjectEx(overlapped.hEvent(), Winbase.INFINITE(), true);
        Assertions.assertEquals(Winbase.WAIT_IO_COMPLETION(), waitResult, "Error during wait");
        
        int bytesTransferred = Ioapiset.GetOverlappedResult(hFile, overlapped, false);
        Synchapi.ResetEvent(overlapped.hEvent());

        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, bytesTransferred);

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);

        OpaqueMemory.clear(opaqueMemory);
        Fileapi.ReadFileEx(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped, overlappedCompletionRoutine);
        waitResult = Synchapi.WaitForSingleObjectEx(overlapped.hEvent(), Winbase.INFINITE(), true);
        Assertions.assertEquals(Winbase.WAIT_IO_COMPLETION(), waitResult, "Error during wait");
        
        bytesTransferred = Ioapiset.GetOverlappedResult(hFile, overlapped, false);

        Handleapi.CloseHandle(overlapped.hEvent());
        Handleapi.CloseHandle(hFile);

        Assertions.assertEquals(WRITE_VALUE.length, bytesTransferred);
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }

    @Test
    public void testOpaqueMemoryIOCompetitionPort() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(), 
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);
        final Minwinbase.OVERLAPPED overlapped = new Minwinbase.OVERLAPPED();
        final long COMPLETION_KEY = 24;
        Winnt.HANDLE hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);
        
        OpaqueMemory opaqueMemory = new OpaqueMemory(64, true);
        OpaqueMemory.copy(opaqueMemory, 0, WRITE_VALUE, 0, WRITE_VALUE.length);
        
        IntRef lpNumberOfBytesTransferred = new IntRef();
        LongRef lpCompletionKey = new LongRef();
        
        ObjectRef<NativeAddressHolder> overlappedPtr = new ObjectRef();
        
        Fileapi.WriteFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped);
        
        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);
        
        Assertions.assertNotNull(overlappedPtr.value);
        Assertions.assertTrue(OpaqueMemory.isSameAddress(overlappedPtr.value, overlapped));
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.value);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.value);

        Handleapi.CloseHandle(hFile);

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                Winbase.FILE_FLAG_OVERLAPPED(),
                null);
        hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        OpaqueMemory.clear(opaqueMemory);
        
        Fileapi.ReadFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped);

        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);
        
        Assertions.assertNotNull(overlappedPtr.value);
        Assertions.assertTrue(OpaqueMemory.isSameAddress(overlappedPtr.value, overlapped));
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.value);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.value);

        Handleapi.CloseHandle(hFile);
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }
    
    @Test
    public void testOpaqueMemorySynchronousIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                0,
                null);
        OpaqueMemory opaqueMemory = new OpaqueMemory(64, true);
        OpaqueMemory.copy(opaqueMemory, 0, WRITE_VALUE, 0, WRITE_VALUE.length);
        int bytesWritten = Fileapi.WriteFile(hFile, opaqueMemory, 0, WRITE_VALUE.length);
        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, bytesWritten);

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                0,
                null);
        OpaqueMemory.clear(opaqueMemory);
        int bytesRead = Fileapi.ReadFile(hFile, opaqueMemory, 0, WRITE_VALUE.length);
        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(bytesWritten, bytesRead);
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }

}
