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

import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.MemoryHeap;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Uint16_t;
import de.ibapl.jnhw.common.memory.Uint8_t;
import java.io.File;
import java.lang.foreign.Arena;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

/**
 *
 * @author aploese
 */
@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class IoapisetTest {

    private Arena ms;

    @BeforeEach
    public void setUp() throws Exception {
        ms = Arena.openConfined();
    }

    @AfterEach
    public void tearDown() throws Exception {
        ms.close();
    }

    public IoapisetTest() {
    }

    /**
     * Test of CancelIo method, of class Ioapiset.
     */
    @Test
    @Disabled
    public void testCancelIo() throws Exception {
        System.out.println("CancelIo");
        Winnt.HANDLE hFile = null;
        Ioapiset.CancelIo(hFile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CancelIoEx method, of class Ioapiset.
     */
    @Test
    @Disabled
    public void testCancelIoEx() throws Exception {
        System.out.println("CancelIoEx");
        Winnt.HANDLE hFile = null;
        Minwinbase.LPOVERLAPPED lpOverlapped = null;
        Ioapiset.CancelIoEx(hFile, lpOverlapped);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeviceIoControl method, of class Ioapiset.
     */
    @Test
    public void testDeviceIoControl() throws Exception {
        System.out.println("DeviceIoControl");
        File file = File.createTempFile("JNHW_Ioapiset_DeviceIoControl", ".txt");
        Winnt.HANDLE hDevice = Fileapi.CreateFileW(file,
                Winnt.GENERIC_WRITE,
                0,
                null,
                Fileapi.OPEN_EXISTING,
                0,
                null);

        MemoryHeap lpOutBuffer = MemoryHeap.allocateNative(128, ms.scope());

        WinDef.LPDWORD lpBytesReturned = WinDef.LPDWORD.allocateNative(ms.scope());

        Ioapiset.DeviceIoControl(hDevice, Winioctl.FSCTL_GET_COMPRESSION, null, lpOutBuffer, lpBytesReturned, null);

        assertEquals(2, lpBytesReturned.uint32_t());
        Uint16_t uint16_t = new Uint16_t(OpaqueMemory.getMemorySegment(lpOutBuffer), 0);
        assertEquals(Winnt.COMPRESSION_FORMAT_NONE, uint16_t.uint16_t());

        Uint8_t uint8_t = Uint8_t.allocateNative(ms.scope());
        NativeErrorException nee = assertThrows(NativeErrorException.class, ()
                -> Ioapiset.DeviceIoControl(hDevice, Winioctl.FSCTL_GET_COMPRESSION, null, uint8_t, lpBytesReturned, null)
        );
        assertEquals(Winerror.ERROR_INVALID_PARAMETER, nee.errno);
        assertEquals(Winerror.ERROR_INVALID_PARAMETER, Errhandlingapi.GetLastError());

        Handleapi.CloseHandle(hDevice);
    }

    /**
     * Test of GetOverlappedResult method, of class Ioapiset.
     */
    @Test
    @Disabled
    public void testGetOverlappedResult_3args() throws Exception {
        System.out.println("GetOverlappedResult");
        Winnt.HANDLE hFile = null;
        Minwinbase.LPOVERLAPPED lpOverlapped = null;
        boolean bWait = false;
        int expResult = 0;
        WinDef.LPDWORD lpBytesReturned = WinDef.LPDWORD.allocateNative(ms.scope());
        Ioapiset.GetOverlappedResult(hFile, lpOverlapped, lpBytesReturned, bWait);
        assertEquals(expResult, lpBytesReturned.uint32_t());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetOverlappedResult method, of class Ioapiset.
     */
    @Test
    @Disabled
    public void testGetOverlappedResult_4args() throws Exception {
        System.out.println("GetOverlappedResult");
        Winnt.HANDLE hFile = null;
        Minwinbase.LPOVERLAPPED lpOverlapped = null;
        ByteBuffer lpBuffer = null;
        boolean bWait = false;
        int expResult = 0;
        WinDef.LPDWORD lpBytesReturned = WinDef.LPDWORD.allocateNative(ms.scope());
        Ioapiset.GetOverlappedResult(hFile, lpOverlapped, lpBuffer, lpBytesReturned, bWait);
        assertEquals(expResult, lpBytesReturned.uint32_t());
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
