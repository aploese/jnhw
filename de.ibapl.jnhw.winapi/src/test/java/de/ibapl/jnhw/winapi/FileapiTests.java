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
import de.ibapl.jnhw.libloader.NativeLibLoader;
import de.ibapl.jnhw.libloader.OS;
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

public class FileapiTests {

    private File file;
    private final static String WRITE_VALUE = "Hello world!";

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        file = File.createTempFile("JNHW_FileapiTests", ".txt");
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void test_HAVE_FILEAPI_H() throws Exception {
        if (NativeLibLoader.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Fileapi.HAVE_FILEAPI_H(), "expected to have fileapi.h");
        } else {
            Assertions.assertFalse(Fileapi.HAVE_FILEAPI_H(), "not expected to have fileapi.h");
        }
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testByteBufferSynchron() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                0,
                null);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
        byteBuffer.put(WRITE_VALUE.getBytes());
        byteBuffer.flip();
        Fileapi.WriteFile(hFile, byteBuffer);
        Winbase.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length()];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length(); i++) {
                Assertions.assertEquals(WRITE_VALUE.charAt(i), (char) readBuffer[i]);
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
        byteBuffer.limit(WRITE_VALUE.length());
        Fileapi.ReadFile(hFile, byteBuffer);
        Winbase.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());
    }

    @Test
    @EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
    public void testByteBufferASynchron() throws Exception {
        Winnt.HANDLE hFile = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE(),
                0,
                null,
                Fileapi.OPEN_EXISTING(),
                0,
                null);
        Minwinbase.OVERLAPPED overlapped = new Minwinbase.OVERLAPPED(true);
        overlapped.hEvent(Synchapi.CreateEventW(null, true, false, null));

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(64);
        byteBuffer.put(WRITE_VALUE.getBytes());
        byteBuffer.flip();
        Fileapi.WriteFile(hFile, byteBuffer, overlapped);
        long waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE());
        if (waitResult != Winbase.WAIT_OBJECT_0()) {
            Assertions.fail("Error during wait");
        }
        IntRef dwBytesTransferred = new IntRef(0);
        Ioapiset.GetOverlappedResult(hFile, overlapped, dwBytesTransferred, false, byteBuffer);
        Synchapi.ResetEvent(hFile);

        Winbase.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());

        try (FileInputStream fio = new FileInputStream(file)) {
            byte[] readBuffer = new byte[WRITE_VALUE.length()];
            fio.read(readBuffer);
            for (int i = 0; i < WRITE_VALUE.length(); i++) {
                Assertions.assertEquals(WRITE_VALUE.charAt(i), (char) readBuffer[i]);
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
        byteBuffer.limit(WRITE_VALUE.length());
        Fileapi.ReadFile(hFile, byteBuffer, overlapped);
        waitResult = Synchapi.WaitForSingleObject(overlapped.hEvent(), Winbase.INFINITE());
        if (waitResult != Winbase.WAIT_OBJECT_0()) {
            Assertions.fail("Error during wait");
        }
        Ioapiset.GetOverlappedResult(hFile, overlapped, dwBytesTransferred, false, byteBuffer);
        Winbase.CloseHandle(hFile);
        Assertions.assertFalse(byteBuffer.hasRemaining());
    }

}
