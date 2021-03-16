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

import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.condition.EnabledOnOs;

/**
 *
 * @author aploese
 */
@EnabledOnOs(org.junit.jupiter.api.condition.OS.OTHER)
public class IoapisetTest {

    public IoapisetTest() {
    }

    /**
     * Test of CancelIo method, of class Ioapiset.
     */
    @Test
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
    public void testDeviceIoControl_9args() throws Exception {
        System.out.println("DeviceIoControl");
        Winnt.HANDLE hDevice = null;
        int dwIoControlCode = 0;
        OpaqueMemory32 lpInBuffer = null;
        int nInBufferOffset = 0;
        int nInBufferSize = 0;
        OpaqueMemory32 lpOutBuffer = null;
        int nOutBufferOffset = 0;
        int nOutBufferSize = 0;
        Minwinbase.OVERLAPPED lpOverlapped = null;
        Ioapiset instance = new Ioapiset();
        int expResult = 0;
        int result = instance.DeviceIoControl(hDevice, dwIoControlCode, lpInBuffer, nInBufferOffset, nInBufferSize, lpOutBuffer, nOutBufferOffset, nOutBufferSize, lpOverlapped);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeviceIoControl method, of class Ioapiset.
     */
    @Test
    public void testDeviceIoControl_5args() throws Exception {
        System.out.println("DeviceIoControl");
        Winnt.HANDLE hDevice = null;
        int dwIoControlCode = 0;
        ByteBuffer lpInBuffer = null;
        ByteBuffer lpOutBuffer = null;
        Minwinbase.OVERLAPPED lpOverlapped = null;
        Ioapiset instance = new Ioapiset();
        int expResult = 0;
        int result = instance.DeviceIoControl(hDevice, dwIoControlCode, lpInBuffer, lpOutBuffer, lpOverlapped);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
