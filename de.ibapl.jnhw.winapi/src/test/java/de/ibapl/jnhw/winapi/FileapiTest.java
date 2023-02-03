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

import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.UintPtr_t;
import de.ibapl.jnhw.common.util.ByteBufferUtils;
import java.io.File;
import java.io.FileInputStream;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class FileapiTest {

    private Arena ms;

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
        file = File.createTempFile("JNHW_FileapiTest", ".txt");
        ms = Arena.openConfined();
    }

    @AfterEach
    public void tearDown() throws Exception {
        ms.close();
    }

    @Test
    public void testByteArray() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);
        WinDef.LPDWORD lpNumberOfBytesWritten = WinDef.LPDWORD.allocateNative(ms.scope());
        Fileapi.WriteFile(hFile, WRITE_VALUE, 0, WRITE_VALUE.length, lpNumberOfBytesWritten);
        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesWritten.uint32_t());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);
        byte[] readBuffer = new byte[WRITE_VALUE.length];
        WinDef.LPDWORD lpNumberOfBytesRead = WinDef.LPDWORD.allocateNative(ms.scope());
        Fileapi.ReadFile(hFile, readBuffer, 0, readBuffer.length, lpNumberOfBytesRead);
        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesRead.uint32_t());
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
        }
    }

    @Test
    public void testByteBufferAcynchronousIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(ms.scope());
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
        byteBuffer.put(WRITE_VALUE);
        byteBuffer.flip();
        Fileapi.WriteFile(hFile, byteBuffer, overlapped);
        long waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE);
        Assertions.assertEquals(Winbase.WAIT_OBJECT_0, waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, byteBuffer, lpNumberOfBytesTransferred, false);
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
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        byteBuffer.clear();
        byteBuffer.limit(WRITE_VALUE.length);
        Fileapi.ReadFile(hFile, byteBuffer, overlapped);
        waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE);
        Assertions.assertEquals(Winbase.WAIT_OBJECT_0, waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, byteBuffer, lpNumberOfBytesTransferred, false);
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
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        final Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(ms.scope());
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
        byteBuffer.put(WRITE_VALUE);
        byteBuffer.flip();

        Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE overlappedCompletionRoutine = new Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE() {
            @Override
            protected void callback(int dwErrorCode, int dwNumberOfBytesTransferred, MemorySegment lpOverlapped) {
                Assertions.assertEquals(Winerror.ERROR_SUCCESS, dwErrorCode);
                Assertions.assertEquals(WRITE_VALUE.length, dwNumberOfBytesTransferred);
                Assertions.assertEquals(OpaqueMemory.getMemorySegment(overlapped).address(), lpOverlapped);
            }
        };

        Fileapi.WriteFileEx(hFile, byteBuffer, overlapped, overlappedCompletionRoutine);
        long waitResult = Synchapi.WaitForSingleObjectEx(overlapped.hEvent(), Winbase.INFINITE, true);
        Assertions.assertEquals(Winbase.WAIT_IO_COMPLETION, waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, byteBuffer, lpNumberOfBytesTransferred, false);
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
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        byteBuffer.clear();
        byteBuffer.limit(WRITE_VALUE.length);

        Fileapi.ReadFileEx(hFile, byteBuffer, overlapped, overlappedCompletionRoutine);
        waitResult = Synchapi.WaitForSingleObjectEx(overlapped.hEvent(), Winbase.INFINITE, true);
        Assertions.assertEquals(Winbase.WAIT_IO_COMPLETION, waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, byteBuffer, lpNumberOfBytesTransferred, false);
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
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        final Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(ms.scope());
        final long COMPLETION_KEY = 25;
        Winnt.HANDLE hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
        byteBuffer.put(WRITE_VALUE);
        byteBuffer.flip();

        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());
        BaseTsd.PULONG_PTR lpCompletionKey = BaseTsd.PULONG_PTR.allocateNative(ms.scope());

        Fileapi.WriteFile(hFile, byteBuffer, overlapped);

        UintPtr_t<Minwinbase.LPOVERLAPPED> lpOverlappedPtr = UintPtr_t.allocateNative(ms.scope());
        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, lpOverlappedPtr, 1000);

        Assertions.assertNotEquals(MemorySegment.NULL, lpOverlappedPtr.get());
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.PULONG_PTR());
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());
        ByteBufferUtils.fixBufferPos(byteBuffer, lpNumberOfBytesTransferred.uint32_t());

        Handleapi.CloseHandle(hIoCompletionPort);
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
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        byteBuffer.clear();
        byteBuffer.limit(WRITE_VALUE.length);

        Fileapi.ReadFile(hFile, byteBuffer, overlapped);

        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, lpOverlappedPtr, 1000);

        Assertions.assertNotEquals(MemorySegment.NULL, lpOverlappedPtr.get());
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.PULONG_PTR());
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());
        ByteBufferUtils.fixBufferPos(byteBuffer, lpNumberOfBytesTransferred.uint32_t());

        Handleapi.CloseHandle(hIoCompletionPort);
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
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        byteBuffer.put(WRITE_VALUE);
        byteBuffer.flip();
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());
        Fileapi.WriteFile(hFile, byteBuffer, lpNumberOfBytesTransferred);

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
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);
        byteBuffer.clear();
        byteBuffer.limit(WRITE_VALUE.length);
        Fileapi.ReadFile(hFile, byteBuffer, lpNumberOfBytesTransferred);
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
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
        byteBuffer.put(WRITE_VALUE);
        byteBuffer.flip();
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());
        Fileapi.WriteFile(hFile, byteBuffer, lpNumberOfBytesTransferred);
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
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);
        byteBuffer.clear();
        byteBuffer.limit(WRITE_VALUE.length);
        Fileapi.ReadFile(hFile, byteBuffer, lpNumberOfBytesTransferred);
        Handleapi.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());
        byteBuffer.flip();
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], byteBuffer.get());
        }
    }

    @Test
    public void testOpaqueMemoryAlertableIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(ms.scope());
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());

        MemoryHeap opaqueMemory = MemoryHeap.allocateNative(64, ms.scope());
        OpaqueMemory.copy(WRITE_VALUE, 0, opaqueMemory, 0, WRITE_VALUE.length);

        Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE overlappedCompletionRoutine = new Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE() {
            @Override
            protected void callback(int dwErrorCode, int dwNumberOfBytesTransferred, MemorySegment lpOverlapped) {
                Assertions.assertEquals(Winerror.ERROR_SUCCESS, dwErrorCode);
                Assertions.assertEquals(WRITE_VALUE.length, dwNumberOfBytesTransferred);
                Assertions.assertEquals(OpaqueMemory.getMemorySegment(overlapped).address(), lpOverlapped);
            }
        };

        Fileapi.WriteFileEx(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped, overlappedCompletionRoutine);
        long waitResult = Synchapi.WaitForSingleObjectEx(overlapped.hEvent(), Winbase.INFINITE, true);
        Assertions.assertEquals(Winbase.WAIT_IO_COMPLETION, waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, lpNumberOfBytesTransferred, false);
        Synchapi.ResetEvent(overlapped.hEvent());

        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);

        OpaqueMemory.clear(opaqueMemory);
        Fileapi.ReadFileEx(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped, overlappedCompletionRoutine);
        waitResult = Synchapi.WaitForSingleObjectEx(overlapped.hEvent(), Winbase.INFINITE, true);
        Assertions.assertEquals(Winbase.WAIT_IO_COMPLETION, waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, lpNumberOfBytesTransferred, false);

        Handleapi.CloseHandle(overlapped.hEvent());
        Handleapi.CloseHandle(hFile);

        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }

    @Test
    public void testOpaqueMemoryAsynchronousIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(ms.scope());
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());

        MemoryHeap opaqueMemory = MemoryHeap.allocateNative(64, ms.scope());
        OpaqueMemory.copy(WRITE_VALUE, 0, opaqueMemory, 0, WRITE_VALUE.length);
        Fileapi.WriteFile(hFile, opaqueMemory, overlapped);
        long waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE);
        Assertions.assertEquals(Winbase.WAIT_OBJECT_0, waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, lpNumberOfBytesTransferred, false);
        Synchapi.ResetEvent(overlapped.hEvent());

        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(opaqueMemory.sizeof(), lpNumberOfBytesTransferred.uint32_t());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);

        OpaqueMemory.clear(opaqueMemory);
        Fileapi.ReadFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped);
        waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE);
        Assertions.assertEquals(Winbase.WAIT_OBJECT_0, waitResult, "Error during wait");
        Ioapiset.GetOverlappedResult(hFile, overlapped, lpNumberOfBytesTransferred, false);

        Handleapi.CloseHandle(overlapped.hEvent());
        Handleapi.CloseHandle(hFile);

        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }

    @Test
    public void testOpaqueMemoryIOCompetitionPort() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        final Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(ms.scope());
        final long COMPLETION_KEY = 29;
        Winnt.HANDLE hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        MemoryHeap opaqueMemory = MemoryHeap.allocateNative(64, ms.scope());
        OpaqueMemory.copy(WRITE_VALUE, 0, opaqueMemory, 0, WRITE_VALUE.length);

        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());
        BaseTsd.PULONG_PTR lpCompletionKey = BaseTsd.PULONG_PTR.allocateNative(ms.scope());

        Fileapi.WriteFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped);

        UintPtr_t<Minwinbase.LPOVERLAPPED> overlappedPtr = UintPtr_t.allocateNative(ms.scope());

        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);

        Assertions.assertNotEquals(MemorySegment.NULL, overlappedPtr.get());
        Assertions.assertEquals(OpaqueMemory.getMemorySegment(overlapped).address(), overlappedPtr.get().address());
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.PULONG_PTR());
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());

        Handleapi.CloseHandle(hIoCompletionPort);
        Handleapi.CloseHandle(hFile);

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        OpaqueMemory.clear(opaqueMemory);

        Fileapi.ReadFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped);

        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);

        Assertions.assertNotEquals(MemorySegment.NULL, overlappedPtr.get());
        Assertions.assertEquals(OpaqueMemory.getMemorySegment(overlapped).address(), overlappedPtr.get());
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.PULONG_PTR());
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());

        Handleapi.CloseHandle(hIoCompletionPort);
        Handleapi.CloseHandle(hFile);
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }

    @Test
    public void testOpaqueMemorySynchronousIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());
        MemoryHeap opaqueMemory = MemoryHeap.allocateNative(64, ms.scope());
        OpaqueMemory.copy(WRITE_VALUE, 0, opaqueMemory, 0, WRITE_VALUE.length);
        Fileapi.WriteFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, lpNumberOfBytesTransferred);
        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);
        OpaqueMemory.clear(opaqueMemory);
        Fileapi.ReadFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, lpNumberOfBytesTransferred);
        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }

    @Test
    public void testOpaqueMemory64AlertableIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(ms.scope());
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());

        MemoryHeap opaqueMemory = MemoryHeap.allocateNative(64, ms.scope());
        OpaqueMemory.copy(WRITE_VALUE, 0, opaqueMemory, 0, WRITE_VALUE.length);

        Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE overlappedCompletionRoutine = new Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE() {
            @Override
            protected void callback(int dwErrorCode, int dwNumberOfBytesTransferred, MemorySegment lpOverlapped) {
                Assertions.assertEquals(Winerror.ERROR_SUCCESS, dwErrorCode);
                Assertions.assertEquals(WRITE_VALUE.length, dwNumberOfBytesTransferred);
                Assertions.assertEquals(OpaqueMemory.getMemorySegment(overlapped).address(), lpOverlapped);
            }
        };

        Fileapi.WriteFileEx(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped, overlappedCompletionRoutine);
        long waitResult = Synchapi.WaitForSingleObjectEx(overlapped.hEvent(), Winbase.INFINITE, true);
        Assertions.assertEquals(Winbase.WAIT_IO_COMPLETION, waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, lpNumberOfBytesTransferred, false);
        Synchapi.ResetEvent(overlapped.hEvent());

        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);

        OpaqueMemory.clear(opaqueMemory);
        Fileapi.ReadFileEx(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped, overlappedCompletionRoutine);
        waitResult = Synchapi.WaitForSingleObjectEx(overlapped.hEvent(), Winbase.INFINITE, true);
        Assertions.assertEquals(Winbase.WAIT_IO_COMPLETION, waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, lpNumberOfBytesTransferred, false);

        Handleapi.CloseHandle(overlapped.hEvent());
        Handleapi.CloseHandle(hFile);

        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }

    @Test
    public void testOpaqueMemory64AsynchronousIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(ms.scope());
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());

        MemoryHeap opaqueMemory = MemoryHeap.allocateNative(64, ms.scope());
        OpaqueMemory.copy(WRITE_VALUE, 0, opaqueMemory, 0, WRITE_VALUE.length);
        Fileapi.WriteFile(hFile, opaqueMemory, 0, (int) opaqueMemory.sizeof(), overlapped);
        long waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE);
        Assertions.assertEquals(Winbase.WAIT_OBJECT_0, waitResult, "Error during wait");

        Ioapiset.GetOverlappedResult(hFile, overlapped, lpNumberOfBytesTransferred, false);
        Synchapi.ResetEvent(overlapped.hEvent());

        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(opaqueMemory.sizeof(), lpNumberOfBytesTransferred.uint32_t());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);

        OpaqueMemory.clear(opaqueMemory);
        Fileapi.ReadFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped);
        waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE);
        Assertions.assertEquals(Winbase.WAIT_OBJECT_0, waitResult, "Error during wait");
        Ioapiset.GetOverlappedResult(hFile, overlapped, lpNumberOfBytesTransferred, false);

        Handleapi.CloseHandle(overlapped.hEvent());
        Handleapi.CloseHandle(hFile);

        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }

    @Test
    public void testOpaqueMemory64IOCompetitionPort() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        final Minwinbase.LPOVERLAPPED overlapped = Minwinbase.LPOVERLAPPED.allocateNative(ms.scope());
        final long COMPLETION_KEY = 27;
        Winnt.HANDLE hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        MemoryHeap opaqueMemory = MemoryHeap.allocateNative(64, ms.scope());
        OpaqueMemory.copy(WRITE_VALUE, 0, opaqueMemory, 0, WRITE_VALUE.length);

        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());
        BaseTsd.PULONG_PTR lpCompletionKey = BaseTsd.PULONG_PTR.allocateNative(ms.scope());

        Fileapi.WriteFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped);

        UintPtr_t<Minwinbase.LPOVERLAPPED> overlappedPtr = UintPtr_t.allocateNative(ms.scope());
        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);

        Assertions.assertNotEquals(MemorySegment.NULL, overlappedPtr.get());
        Assertions.assertEquals(OpaqueMemory.getMemorySegment(overlapped).address(), overlappedPtr.get().address());
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.PULONG_PTR());
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());

        Handleapi.CloseHandle(hIoCompletionPort);
        Handleapi.CloseHandle(hFile);

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                Winbase.FILE_FLAG_OVERLAPPED,
                null);
        hIoCompletionPort = IoAPI.CreateIoCompletionPort(hFile, null, COMPLETION_KEY, 0);

        OpaqueMemory.clear(opaqueMemory);

        Fileapi.ReadFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, overlapped);

        IoAPI.GetQueuedCompletionStatus(hIoCompletionPort, lpNumberOfBytesTransferred, lpCompletionKey, overlappedPtr, 1000);

        Assertions.assertNotEquals(MemorySegment.NULL, overlappedPtr.get());
        Assertions.assertEquals(OpaqueMemory.getMemorySegment(overlapped).address(), overlappedPtr.get());
        Assertions.assertEquals(COMPLETION_KEY, lpCompletionKey.PULONG_PTR());
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());

        Handleapi.CloseHandle(hIoCompletionPort);
        Handleapi.CloseHandle(hFile);
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }

    @Test
    public void testOpaqueMemory64SynchronousIO() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);
        MemoryHeap opaqueMemory = MemoryHeap.allocateNative(64, ms.scope());
        OpaqueMemory.copy(WRITE_VALUE, 0, opaqueMemory, 0, WRITE_VALUE.length);
        WinDef.LPDWORD lpNumberOfBytesTransferred = WinDef.LPDWORD.allocateNative(ms.scope());
        Fileapi.WriteFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, lpNumberOfBytesTransferred);
        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length; i++) {
                Assertions.assertEquals(WRITE_VALUE[i], readBuffer[i]);
            }
        }
        hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_READ,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);
        OpaqueMemory.clear(opaqueMemory);
        Fileapi.ReadFile(hFile, opaqueMemory, 0, WRITE_VALUE.length, lpNumberOfBytesTransferred);
        Handleapi.CloseHandle(hFile);
        Assertions.assertEquals(WRITE_VALUE.length, lpNumberOfBytesTransferred.uint32_t());
        for (int i = 0; i < WRITE_VALUE.length; i++) {
            Assertions.assertEquals(WRITE_VALUE[i], OpaqueMemory.getByte(opaqueMemory, i));
        }
    }
}
