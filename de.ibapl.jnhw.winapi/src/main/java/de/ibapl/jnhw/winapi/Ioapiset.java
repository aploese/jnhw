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

import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.JnhwMh_BL___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_BL___A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_BL___A_uL__A_uL__A_uL__A__A;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.util.winapi.Kernel32Loader;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import de.ibapl.jnhw.winapi.Minwinbase.LPOVERLAPPED;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.nio.ByteBuffer;
import de.ibapl.jnhw.common.downcall.JnhwMh_BL___A__A__A_BL;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/">ioapiset.h</a>
 * header.
 *
 * @author aploese
 */
@Include("ioapiset.h")
public final class Ioapiset {

    private final static JnhwMh_BL___A.ExceptionErased CancelIo = JnhwMh_BL___A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "CancelIo",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE);

    private final static JnhwMh_BL___A__A.ExceptionErased CancelIoEx = JnhwMh_BL___A__A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "CancelIo",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE,
            WinApiDataType.LPOVERLAPPED);

    private final static JnhwMh_BL___A_uL__A_uL__A_uL__A__A.ExceptionErased DeviceIoControl = JnhwMh_BL___A_uL__A_uL__A_uL__A__A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "DeviceIoControl",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE,
            WinApiDataType.DWORD,
            WinApiDataType.LPVOID,
            WinApiDataType.DWORD,
            WinApiDataType.LPVOID,
            WinApiDataType.DWORD,
            WinApiDataType.LPDWORD,
            WinApiDataType.LPOVERLAPPED);

    private final static JnhwMh_BL___A__A__A_BL.ExceptionErased GetOverlappedResult = JnhwMh_BL___A__A__A_BL.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "GetOverlappedResult",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE,
            WinApiDataType.LPOVERLAPPED,
            WinApiDataType.LPDWORD,
            WinApiDataType.BOOL);

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/nf-ioapiset-cancelio">CancelIo</a>
     * Marks any outstanding I/O operations for the specified file handle.
     *
     * @param hFile a handle to the file, named pipe, or communications device.
     *
     * @throws NullPointerException if hFile is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void CancelIo(HANDLE hFile) throws NativeErrorException {
        if (!CancelIo.invoke_BL___P(hFile)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/nf-ioapiset-cancelioex">CancelIoEx</a>
     * Marks any outstanding I/O operations for the specified file handle.
     *
     * @param hFile a handle to the file, named pipe, or communications device.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} data structure
     * that contains the data used for asynchronous I/O.
     *
     * @throws NullPointerException if hFile or lpOverlapped is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void CancelIoEx(HANDLE hFile, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (!CancelIoEx.invoke_BL___P__P(hFile, lpOverlapped)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/nf-ioapiset-deviceiocontrol">DeviceIoControl</a>
     * Sends a control code directly to a specified device driver, causing the
     * corresponding device to perform the corresponding operation.
     *
     * @throws NullPointerException if hDevice or lpInBuffer or lpOutBuffer is
     * {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if nInBufferOffset or
     * nInBufferSize or nOutBufferOffset are nOutBufferSize outside of
     * lpInBuffer resp lpOutBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void DeviceIoControl(HANDLE hDevice, int dwIoControlCode, OpaqueMemory lpInBuffer, OpaqueMemory lpOutBuffer, WinDef.LPDWORD lpBytesReturned, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
//TODO Not setting or reading LastError will fail the call to DeviceIoControl
        Errhandlingapi.SetLastError(Winerror.ERROR_SUCCESS);
//        System.err.println("de.ibapl.jnhw.winapi.Ioapiset.DeviceIOControl()" + Errhandlingapi.GetLastError());
        if (!DeviceIoControl.invoke_BL___P_uI__P_uL__P_uL__P__P(
                hDevice,
                dwIoControlCode,
                lpInBuffer != null ? lpInBuffer : Pointer.NULL,
                lpInBuffer == null ? 0 : lpInBuffer.sizeof(),
                lpOutBuffer != null ? lpOutBuffer : Pointer.NULL,
                lpOutBuffer == null ? 0 : lpOutBuffer.sizeof(),
                lpBytesReturned,
                lpOverlapped != null ? lpOverlapped : Pointer.NULL)) {
            if (Errhandlingapi.GetLastError() == Winerror.ERROR_IO_PENDING) {
                if (lpOverlapped == null) {
                    //if lpOverlapped is not NULL and GetLastError() == ERROR_IO_PENDING is not an error condition
                    throw new NativeErrorException(Errhandlingapi.GetLastError());
                }
            } else {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/nf-ioapiset-getoverlappedresult">GetOverlappedResult</a>
     * retrieves the results of an overlapped operation on the specified file,
     * named pipe, or communications device.
     *
     * @param hFile a handle to the file, named pipe, or communications device.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} data structure
     * that contains the data used for asynchronous I/O.
     * @param bWait If this parameter is {@code TRUE}, and the Internal member
     * of the lpOverlapped structure is STATUS_PENDING, the function does not
     * return until the operation has been completed. If this parameter is
     * {@code FALSE} and the operation is still pending, the function throws a
     * NativeErrorException with {@code ERROR_IO_INCOMPLETE} as errno.
     *
     * @param lpNumberOfBytesTransferred of the native call.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void GetOverlappedResult(HANDLE hFile, LPOVERLAPPED lpOverlapped, WinDef.LPDWORD lpNumberOfBytesTransferred, boolean bWait) throws NativeErrorException {
        if (!GetOverlappedResult.invoke_BL___P__P__P_BL(
                hFile,
                lpOverlapped,
                lpNumberOfBytesTransferred,
                bWait)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/nf-ioapiset-getoverlappedresult">GetOverlappedResult</a>
     * retrieves the results of an overlapped operation on the specified file,
     * named pipe, or communications device.
     * <br>
     * The position of {@link ByteBuffer} is also updated.
     *
     * @param hFile a handle to the file, named pipe, or communications device.
     * @param lpBuffer a pointer to the {@link ByteBuffer} that used for IO and
     * which position must be updated.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} data structure
     * that contains the data used for asynchronous I/O.
     * @param bWait If this parameter is TRUE, and the Internal member of the
     * lpOverlapped structure is STATUS_PENDING, the function does not return
     * until the operation has been completed. If this parameter is FALSE and
     * the operation is still pending, the function returns FALSE and the
     * GetLastError function returns ERROR_IO_INCOMPLETE.
     * @param lpNumberOfBytesTransferred of the native call.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void GetOverlappedResult(HANDLE hFile, LPOVERLAPPED lpOverlapped, ByteBuffer lpBuffer, WinDef.LPDWORD lpNumberOfBytesTransferred, boolean bWait) throws NativeErrorException {
        if (!GetOverlappedResult.invoke_BL___P__P__P_BL(
                hFile,
                lpOverlapped,
                lpNumberOfBytesTransferred,
                bWait)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
        // lpNumberOfBytesTransferred is always < Interger.MAX_VALUE
        lpBuffer.position(lpBuffer.position() + lpNumberOfBytesTransferred.uint32_t());
    }

}
