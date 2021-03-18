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

import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Memory32Heap;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Uint16_t;
import de.ibapl.jnhw.common.memory.Uint8_t;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.Disabled;
import java.io.File;

/**
 *
 * @author aploese
 */
@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class IoapisetTest {

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
        Minwinbase.OVERLAPPED lpOverlapped = null;
        Ioapiset.CancelIoEx(hFile, lpOverlapped);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetOverlappedResult method, of class Ioapiset.
     */
    @Test
    @Disabled
    public void testGetOverlappedResult_3args() throws Exception {
        System.out.println("GetOverlappedResult");
        Winnt.HANDLE hFile = null;
        Minwinbase.OVERLAPPED lpOverlapped = null;
        boolean bWait = false;
        int expResult = 0;
        int result = Ioapiset.GetOverlappedResult(hFile, lpOverlapped, bWait);
        assertEquals(expResult, result);
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
        Minwinbase.OVERLAPPED lpOverlapped = null;
        ByteBuffer lpBuffer = null;
        boolean bWait = false;
        int expResult = 0;
        int result = Ioapiset.GetOverlappedResult(hFile, lpOverlapped, lpBuffer, bWait);
        assertEquals(expResult, result);
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

        Memory32Heap lpOutBuffer = new Memory32Heap(null, 0, 128, AbstractNativeMemory.SET_MEM_TO_0);

        int lpBytesReturned = Ioapiset.DeviceIoControl(hDevice, Winioctl.FSCTL_GET_COMPRESSION, null, lpOutBuffer, null);

        assertEquals(2, lpBytesReturned);
        Uint16_t uint16_t = new Uint16_t(lpOutBuffer, 0, AbstractNativeMemory.MEM_UNINITIALIZED);
        assertEquals(Winnt.COMPRESSION_FORMAT_NONE, uint16_t.uint16_t());

        Uint8_t uint8_t = new Uint8_t(null, 0, AbstractNativeMemory.SET_MEM_TO_0);
        NativeErrorException nee = assertThrows(NativeErrorException.class, () -> Ioapiset.DeviceIoControl(hDevice, Winioctl.FSCTL_GET_COMPRESSION, null, uint8_t, null));
        assertEquals(Winerror.ERROR_INVALID_PARAMETER, nee.errno);

        Handleapi.CloseHandle(hDevice);
    }

}
