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

import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.nio.ByteBuffer;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/">ioapiset.h</a>
 * header.
 *
 * @author aploese
 */
@Include("ioapiset.h")
public final class Ioapiset {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();

        HAVE_IOAPISET_H = false;

        initFields();
    }

    private static native void initFields();

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
    public static native void CancelIo(HANDLE hFile) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/nf-ioapiset-cancelioex">CancelIoEx</a>
     * Marks any outstanding I/O operations for the specified file handle.
     *
     * @param hFile a handle to the file, named pipe, or communications device.
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} data structure
     * that contains the data used for asynchronous I/O.
     *
     * @throws NullPointerException if hFile or lpOverlapped is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native void CancelIoEx(HANDLE hFile, OVERLAPPED lpOverlapped) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/nf-ioapiset-getoverlappedresult">GetOverlappedResult</a>
     * retrieves the results of an overlapped operation on the specified file,
     * named pipe, or communications device.
     *
     * @param hFile a handle to the file, named pipe, or communications device.
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} data structure
     * that contains the data used for asynchronous I/O.
     * @param bWait If this parameter is {@code TRUE}, and the Internal member
     * of the lpOverlapped structure is STATUS_PENDING, the function does not
     * return until the operation has been completed. If this parameter is
     * {@code FALSE} and the operation is still pending, the function throws a
     * NativeErrorException with {@code ERROR_IO_INCOMPLETE} as errno.
     *
     * @return lpNumberOfBytesTransferred of the native call.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native int GetOverlappedResult(HANDLE hFile, OVERLAPPED lpOverlapped, boolean bWait) throws NativeErrorException;

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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} data structure
     * that contains the data used for asynchronous I/O.
     * @param bWait If this parameter is TRUE, and the Internal member of the
     * lpOverlapped structure is STATUS_PENDING, the function does not return
     * until the operation has been completed. If this parameter is FALSE and
     * the operation is still pending, the function returns FALSE and the
     * GetLastError function returns ERROR_IO_INCOMPLETE.
     * @return lpNumberOfBytesTransferred of the native call.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int GetOverlappedResult(HANDLE hFile, OVERLAPPED lpOverlapped, ByteBuffer lpBuffer, boolean bWait) throws NativeErrorException {
        int numberOfBytesTransferred = GetOverlappedResult(hFile, lpOverlapped, bWait);
        lpBuffer.position(lpBuffer.position() + numberOfBytesTransferred);
        return numberOfBytesTransferred;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/ioapiset/nf-ioapiset-deviceiocontrol">DeviceIoControl</a>
     * Sends a control code directly to a specified device driver, causing the
     * corresponding device to perform the corresponding operation.
     *
     * @return the value of lpBytesReturned.
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
    public static native int DeviceIoControl(HANDLE hDevice,
            int dwIoControlCode,
            OpaqueMemory32 lpInBuffer,
            OpaqueMemory32 lpOutBuffer,
            OVERLAPPED lpOverlapped
    ) throws NativeErrorException;

    public final static boolean HAVE_IOAPISET_H;

}
