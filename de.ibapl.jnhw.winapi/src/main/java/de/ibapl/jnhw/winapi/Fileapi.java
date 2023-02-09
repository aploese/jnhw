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

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.JnhwMh_BL___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_BL___A__A_uI__A__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___A_uI_uI__A_uI_uI__A;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.util.ByteBufferUtils;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import de.ibapl.jnhw.util.winapi.Kernel32Loader;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import de.ibapl.jnhw.winapi.Minwinbase.LPOVERLAPPED;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.io.File;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">fileapi.h</a>
 * header.
 *
 * @author aploese
 */
@Include("fileapi.h")
public final class Fileapi {

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">CREATE_ALWAYS</a>
     * Creates a new file, always.
     *
     */
    @Define
    public final static int CREATE_ALWAYS = 2;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">CREATE_NEW</a>
     * Creates a new file, only if it does not already exist.
     *
     */
    @Define
    public final static int CREATE_NEW = 1;
    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">OPEN_ALWAYS</a>
     * Opens a file, always.
     *
     */
    @Define
    public final static int OPEN_ALWAYS = 4;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">OPEN_EXISTING</a>
     * Opens a file or device, only if it exists.
     *
     */
    @Define
    public final static int OPEN_EXISTING = 3;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">TRUNCATE_EXISTING</a>
     * Opens a file and truncates it so that its size is zero bytes, only if it
     * exists.
     *
     */
    @Define
    public final static int TRUNCATE_EXISTING = 5;

    private final static JnhwMh_MA___A_uI_uI__A_uI_uI__A.ExceptionErased CreateFileW = JnhwMh_MA___A_uI_uI__A_uI_uI__A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "CreateFileW",
            WinApiDataType.HANDLE,
            WinApiDataType.LPCWSTR,
            WinApiDataType.DWORD,
            WinApiDataType.DWORD,
            WinApiDataType.LPSECURITY_ATTRIBUTES,
            WinApiDataType.DWORD,
            WinApiDataType.DWORD,
            WinApiDataType.HANDLE);

    private final static JnhwMh_BL___A.ExceptionErased FlushFileBuffers = JnhwMh_BL___A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "FlushFileBuffers",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE);

    private final static JnhwMh_BL___A__A_uI__A__A.ExceptionErased ReadFile = JnhwMh_BL___A__A_uI__A__A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "ReadFile",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE,
            WinApiDataType.LPVOID,
            WinApiDataType.DWORD,
            WinApiDataType.LPDWORD,
            WinApiDataType.LPOVERLAPPED);

    private final static JnhwMh_BL___A__A_uI__A__A.ExceptionErased ReadFileEx = JnhwMh_BL___A__A_uI__A__A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "ReadFileEx",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE,
            WinApiDataType.LPVOID,
            WinApiDataType.DWORD,
            WinApiDataType.LPOVERLAPPED,
            WinApiDataType.LPOVERLAPPED_COMPLETION_ROUTINE);

    private final static JnhwMh_BL___A__A_uI__A__A.ExceptionErased WriteFile = JnhwMh_BL___A__A_uI__A__A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "WriteFile",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE,
            WinApiDataType.LPVOID,
            WinApiDataType.DWORD,
            WinApiDataType.LPDWORD,
            WinApiDataType.LPOVERLAPPED);

    private final static JnhwMh_BL___A__A_uI__A__A.ExceptionErased WriteFileEx = JnhwMh_BL___A__A_uI__A__A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "WriteFileEx",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE,
            WinApiDataType.LPVOID,
            WinApiDataType.DWORD,
            WinApiDataType.LPOVERLAPPED,
            WinApiDataType.LPOVERLAPPED_COMPLETION_ROUTINE);

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew">CreateFileW</a>
     * Creates or opens a file or I/O device.
     *
     * @param file The {@link File} of the file or device to be created or
     * opened.
     * @param dwDesiredAccess The requested access to the file or device, which
     * can be summarized as read, write, both or neither zero.
     * @param dwShareMode The requested sharing mode of the file or device,
     * which can be read, write, both, delete, all of these, or none.
     * @param lpSecurityAttributes A pointer to a {@link SECURITY_ATTRIBUTES}
     * structure that contains two separate but related data members: an
     * optional security descriptor, and a Boolean value that determines whether
     * the returned handle can be inherited by child processes.
     * @param dwCreationDisposition An action to take on a file or device that
     * exists or does not exist.
     * @param dwFlagsAndAttributes The file or device attributes and flags,
     * FILE_ATTRIBUTE_NORMAL being the most common default value for files.
     * @param hTemplateFile A valid handle to a template file with the
     * GENERIC_READ access right. The template file supplies file attributes and
     * extended attributes for the file that is being created.
     * @return If the function succeeds, the return value is an open handle to
     * the specified file, device, named pipe, or mail slot.
     *
     * @throws NullPointerException if file is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static HANDLE CreateFileW(File file, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws NativeErrorException {
        return CreateFileW(
                file.getAbsolutePath(),
                dwDesiredAccess,
                dwShareMode,
                lpSecurityAttributes,
                dwCreationDisposition,
                dwFlagsAndAttributes,
                hTemplateFile);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew">CreateFileW</a>
     * Creates or opens a file or I/O device.
     *
     * @param lpFileName The name of the file or device to be created or opened.
     * @param dwDesiredAccess The requested access to the file or device, which
     * can be summarized as read, write, both or neither zero.
     * @param dwShareMode The requested sharing mode of the file or device,
     * which can be read, write, both, delete, all of these, or none.
     * @param lpSecurityAttributes A pointer to a {@link SECURITY_ATTRIBUTES}
     * structure that contains two separate but related data members: an
     * optional security descriptor, and a Boolean value that determines whether
     * the returned handle can be inherited by child processes.
     * @param dwCreationDisposition An action to take on a file or device that
     * exists or does not exist.
     * @param dwFlagsAndAttributes The file or device attributes and flags,
     * FILE_ATTRIBUTE_NORMAL being the most common default value for files.
     * @param hTemplateFile A valid handle to a template file with the
     * GENERIC_READ access right. The template file supplies file attributes and
     * extended attributes for the file that is being created.
     * @return If the function succeeds, the return value is an open handle to
     * the specified file, device, named pipe, or mail slot.
     *
     * @throws NullPointerException if lpFileName is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static HANDLE CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws NativeErrorException {
        try (Arena ms = Arena.openConfined()) {
            WinDef.LPWSTR _lpFileName = WinDef.LPWSTR.wrap(lpFileName, true, ms.scope());
            final MemorySegment result = CreateFileW.invoke_MA___P_uI_uI__P_uI_uI__P(
                    _lpFileName,
                    dwDesiredAccess,
                    dwShareMode,
                    lpSecurityAttributes != null ? lpSecurityAttributes : Pointer.NULL,
                    dwCreationDisposition,
                    dwFlagsAndAttributes,
                    hTemplateFile != null ? hTemplateFile : Pointer.NULL);
            if (HANDLE.isInvalid(result)) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
            return HANDLE.of(result);
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-flushfilebuffers">FlushFileBuffers</a>
     * Flushes the buffers of a specified file and causes all buffered data to
     * be written to a file.
     *
     * @param hFile A handle to the open file.
     *
     * @throws NullPointerException if hFile is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void FlushFileBuffers(HANDLE hFile) throws NativeErrorException {
        if (!FlushFileBuffers.invoke_BL___P(hFile)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the synchronous read - for byte[] there is no
     * asynchronous read.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the byte array that receives the data read from a file or
     * device.
     * @param lpNumberOfBytesRead the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if off and nNumberOfBytesToRead
     * are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void ReadFile(HANDLE hFile, byte[] lpBuffer, WinDef.LPDWORD lpNumberOfBytesRead) throws NativeErrorException {
        try (Arena ms = Arena.openConfined()) {
            final MemorySegment _lpBuffer = ms.allocate(lpBuffer.length, 1);
            if (!ReadFile.invoke_BL___P__A_uI__P__P(
                    hFile,
                    _lpBuffer,
                    lpBuffer.length,
                    lpNumberOfBytesRead,
                    Pointer.NULL)) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
            MemorySegment.ofArray(lpBuffer).copyFrom(_lpBuffer);
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the synchronous read - for byte[] there is no
     * asynchronous read.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the byte array that receives the data read from a file or
     * device.
     * @param off the start offset in {@code lpBuffer} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpNumberOfBytesRead the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if off and nNumberOfBytesToRead
     * are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFile(HANDLE hFile, byte[] lpBuffer, int off, int nNumberOfBytesToRead, WinDef.LPDWORD lpNumberOfBytesRead) throws NativeErrorException {
        try (Arena ms = Arena.openConfined()) {
            final MemorySegment _lpBuffer = ms.allocate(nNumberOfBytesToRead, 1);
            if (!ReadFile.invoke_BL___P__A_uI__P__P(
                    hFile,
                    _lpBuffer,
                    nNumberOfBytesToRead,
                    lpNumberOfBytesRead,
                    Pointer.NULL)) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
            MemorySegment.ofArray(lpBuffer).asSlice(off, nNumberOfBytesToRead).copyFrom(_lpBuffer);
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the synchronous read for direct {@link ByteBuffer}. the
     * position of lpBuffer is updated after successful read.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to an direct {@link ByteBuffer} that receives
     * the data read from a file or device.
     * @param lpNumberOfBytesRead the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFile(HANDLE hFile, ByteBuffer lpBuffer, WinDef.LPDWORD lpNumberOfBytesRead) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            if (!ReadFile.invoke_BL___P__A_uI__P__P(
                    hFile,
                    MemorySegment.ofBuffer(lpBuffer),
                    lpBuffer.remaining(),
                    lpNumberOfBytesRead,
                    Pointer.NULL)) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        } else {
            ReadFile(
                    hFile,
                    lpBuffer.array(),
                    lpBuffer.position(),
                    ByteBufferUtils.calcBufferReadBytes(lpBuffer),
                    lpNumberOfBytesRead);
        }
        // lpNumberOfBytesRead is always < Interger.MAX_VALUE
        lpBuffer.position(lpBuffer.position() + lpNumberOfBytesRead.uint32_t());
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for direct {@link ByteBuffer}.
     *
     * Use
     * {@link Ioapiset#GetOverlappedResult(HANDLE, OVERLAPPED, ByteBuffer, boolean)}
     * to get the result and update the ByteBuffers position.      <code>
     *  ReadFile(hFile, lpBuffer, lpOverlapped);
     *  final long waitResult = WaitForSingleObject(lpOverlapped.hEvent(), INFINITE());
     *  if (waitResult == WAIT_OBJECT_0()) {
     *  //success
     *    int bytesRead = GetOverlappedResult(hFile, readOverlapped, lpBuffer, false);
     *  } else {
     *  //error
     *  }
     * </code>
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to an direct {@link ByteBuffer} that receives
     * the data read from a file or device.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     *
     * @throws NullPointerException if {@code hFile} or {@code lpBuffer} or
     * {@code lpOverlapped} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFile(HANDLE hFile, ByteBuffer lpBuffer, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            if (!ReadFile.invoke_BL___P__A_uI__P__P(
                    hFile,
                    MemorySegment.ofBuffer(lpBuffer),
                    lpBuffer.remaining(),
                    Pointer.NULL,
                    lpOverlapped)) {
                if (Errhandlingapi.GetLastError() != Winerror.ERROR_IO_PENDING) {
                    throw new NativeErrorException(Errhandlingapi.GetLastError());
                }
            }
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous read ....");
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device.Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the synchronous read for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpNumberOfBytesRead the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and nNumberOfBytesToRead
     * are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToRead, WinDef.LPDWORD lpNumberOfBytesRead) throws NativeErrorException {
        if (!ReadFile.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToRead),
                nNumberOfBytesToRead,
                lpNumberOfBytesRead,
                Pointer.NULL)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpOverlapped A pointer to an {@link LPOVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToRead, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (!ReadFile.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToRead),
                nNumberOfBytesToRead,
                Pointer.NULL,
                lpOverlapped)) {
            if (Errhandlingapi.GetLastError() != Winerror.ERROR_IO_PENDING) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory} that receives all
     * data read from a file or device.
     * @param lpOverlapped A pointer to an {@link LPOVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (!ReadFile.invoke_BL___P__P_uI__P__P(
                hFile,
                lpBuffer,
                ConversionsJava2Native.long_TO_uint32_t(lpBuffer.sizeof()),
                Pointer.NULL,
                lpOverlapped)) {
            if (Errhandlingapi.GetLastError() != Winerror.ERROR_IO_PENDING) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory} that receives all
     * data read from a file or device.
     * @param lpOverlapped A pointer to an {@link LPOVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void ReadFile(HANDLE hFile, MemorySegment lpBuffer, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (!ReadFile.invoke_BL___P__A_uI__P__P(
                hFile,
                lpBuffer,
                ConversionsJava2Native.long_TO_uint32_t(lpBuffer.byteSize()),
                Pointer.NULL,
                lpOverlapped)) {
            if (Errhandlingapi.GetLastError() != Winerror.ERROR_IO_PENDING) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device.Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the synchronous read for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpNumberOfBytesRead the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws IndexOutOfBoundsException if pos and nNumberOfBytesToRead are
     * outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, long off, int nNumberOfBytesToRead, WinDef.LPDWORD lpNumberOfBytesRead) throws NativeErrorException {
        if (!ReadFile.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToRead),
                nNumberOfBytesToRead,
                lpNumberOfBytesRead,
                Pointer.NULL)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpOverlapped A pointer to an {@link LPOVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, long off, int nNumberOfBytesToRead, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (!ReadFile.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToRead),
                nNumberOfBytesToRead,
                Pointer.NULL,
                lpOverlapped)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfileex">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for direct {@link ByteBuffer}.
     *
     * Use
     * {@link Ioapiset#GetOverlappedResult(HANDLE, OVERLAPPED, ByteBuffer, boolean)}
     * to get the result and update the ByteBuffers position.      <code>
     *  ReadFile(hFile, lpBuffer, lpOverlapped);
     *  final long waitResult = WaitForSingleObject(lpOverlapped.hEvent(), INFINITE());
     *  if (waitResult == WAIT_OBJECT_0()) {
     *  //success
     *    int bytesRead = GetOverlappedResult(hFile, readOverlapped, lpBuffer, false);
     *  } else {
     *  //error
     *  }
     * </code>
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to an direct {@link ByteBuffer} that receives
     * the data read from a file or device.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the read operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFileEx(HANDLE hFile, ByteBuffer lpBuffer, LPOVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            if (!ReadFileEx.invoke_BL___P__A_uI__P__P(
                    hFile,
                    MemorySegment.ofBuffer(lpBuffer),
                    lpBuffer.remaining(),
                    lpOverlapped,
                    lpCompletionRoutine)) {
                if (Errhandlingapi.GetLastError() != Winerror.ERROR_IO_PENDING) {
                    throw new NativeErrorException(Errhandlingapi.GetLastError());
                }
            }
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous read ....");
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfileex">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpOverlapped A pointer to an {@link LPOVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the read operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFileEx(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToRead, LPOVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (!ReadFileEx.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToRead),
                nNumberOfBytesToRead,
                lpOverlapped,
                lpCompletionRoutine)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfileex">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory} that receives all
     * data read from a file or device.
     * @param lpOverlapped A pointer to an {@link LPOVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the read operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void ReadFileEx(HANDLE hFile, OpaqueMemory lpBuffer, LPOVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (!ReadFileEx.invoke_BL___P__P_uI__P__P(
                hFile,
                lpBuffer,
                ConversionsJava2Native.long_TO_uint32_t(lpBuffer.sizeof()),
                lpOverlapped,
                lpCompletionRoutine)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfileex">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpOverlapped A pointer to an {@link LPOVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the read operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFileEx(HANDLE hFile, OpaqueMemory lpBuffer, long off, int nNumberOfBytesToRead, LPOVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (!ReadFileEx.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToRead),
                nNumberOfBytesToRead,
                lpOverlapped,
                lpCompletionRoutine)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for a byte array.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the byte array {@code lpBuffer} containing the data to be
     * written to the file or device.
     * @param lpNumberOfBytesWritten the number of bytes written.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void WriteFile(HANDLE hFile, byte[] lpBuffer, WinDef.LPDWORD lpNumberOfBytesWritten) throws NativeErrorException {
        try (Arena ms = Arena.openConfined()) {
            final MemorySegment _lpBuffer = ms.allocate(lpBuffer.length, 1);
            _lpBuffer.copyFrom(MemorySegment.ofArray(lpBuffer));
            if (!WriteFile.invoke_BL___P__A_uI__P__P(
                    hFile,
                    _lpBuffer,
                    lpBuffer.length,
                    lpNumberOfBytesWritten,
                    Pointer.NULL)) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for a byte array.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the byte array {@code lpBuffer} containing the data to be
     * written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpNumberOfBytesWritten the number of bytes written.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, byte[] lpBuffer, int off, int nNumberOfBytesToWrite, WinDef.LPDWORD lpNumberOfBytesWritten) throws NativeErrorException {
        try (Arena ms = Arena.openConfined()) {
            final MemorySegment _lpBuffer = ms.allocate(nNumberOfBytesToWrite, 1);
            _lpBuffer.copyFrom(MemorySegment.ofArray(lpBuffer).asSlice(off, nNumberOfBytesToWrite));
            if (!WriteFile.invoke_BL___P__A_uI__P__P(
                    hFile,
                    _lpBuffer,
                    nNumberOfBytesToWrite,
                    lpNumberOfBytesWritten,
                    Pointer.NULL)) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device. Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for {@link ByteBuffer}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link ByteBuffer} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param lpNumberOfBytesWritten the number of bytes written.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, ByteBuffer lpBuffer, WinDef.LPDWORD lpNumberOfBytesWritten) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            if (!WriteFile.invoke_BL___P__A_uI__P__P(
                    hFile,
                    MemorySegment.ofBuffer(lpBuffer),
                    lpBuffer.remaining(),
                    lpNumberOfBytesWritten,
                    Pointer.NULL)) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        } else {
            if (lpBuffer.isReadOnly()) {
                // see buffer.array() why we do this is here. Hint: isReadOnly ...
                byte[] _buf = new byte[ByteBufferUtils.calcBufferWriteBytes(lpBuffer)];
                lpBuffer.get(_buf);
                //We haven't written anything yet, so fix the position for now.
                lpBuffer.position(lpBuffer.position() - _buf.length);
                WriteFile(hFile,
                        _buf,
                        lpBuffer.position(),
                        lpBuffer.remaining(),
                        lpNumberOfBytesWritten);
            } else {
                WriteFile(
                        hFile,
                        lpBuffer.array(),
                        lpBuffer.position(),
                        lpBuffer.remaining(),
                        lpNumberOfBytesWritten);
            }
        }
        // lpNumberOfBytesWritten is always < Interger.MAX_VALUE
        lpBuffer.position(lpBuffer.position() + lpNumberOfBytesWritten.uint32_t());
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device. Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link ByteBuffer}.
     *
     *
     * Use
     * {@link Ioapiset#GetOverlappedResult(HANDLE, OVERLAPPED, ByteBuffer, boolean)}
     * to get the result and update the ByteBuffers position.      <code>
     *  WriteFile(hFile, lpBuffer, lpOverlapped);
     *  final long waitResult = WaitForSingleObject(lpOverlapped.hEvent(), INFINITE());
     *  if (waitResult == WAIT_OBJECT_0()) {
     *  //success
     *    int bytesWritten = GetOverlappedResult(hFile, readOverlapped, lpBuffer, false);
     *  } else {
     *  //error
     *  }
     * </code>
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link ByteBuffer} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, ByteBuffer lpBuffer, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
//TODO Not setting or reading LastError will fail the call to writeFile
//            Errhandlingapi.SetLastError(Winerror.ERROR_SUCCESS);
            System.err.println("de.ibapl.jnhw.winapi.Fileapi.WriteFile()" + Errhandlingapi.GetLastError());
            if (!WriteFile.invoke_BL___P__A_uI__P__P(
                    hFile,
                    MemorySegment.ofBuffer(lpBuffer),
                    lpBuffer.remaining(),
                    Pointer.NULL,
                    lpOverlapped)) {
                if (Errhandlingapi.GetLastError() != Winerror.ERROR_IO_PENDING) {
                    throw new NativeErrorException(Errhandlingapi.GetLastError());
                }
            }
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous write ....");
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpNumberOfBytesWritten the number of bytes written.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToWrite, WinDef.LPDWORD lpNumberOfBytesWritten) throws NativeErrorException {
        if (!WriteFile.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToWrite),
                nNumberOfBytesToWrite,
                lpNumberOfBytesWritten,
                Pointer.NULL)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToWrite, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (!WriteFile.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToWrite),
                nNumberOfBytesToWrite,
                Pointer.NULL,
                lpOverlapped)) {
            if (Errhandlingapi.GetLastError() != Winerror.ERROR_IO_PENDING) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (!WriteFile.invoke_BL___P__P_uI__P__P(
                hFile,
                lpBuffer,
                ConversionsJava2Native.long_TO_uint32_t(lpBuffer.sizeof()),
                Pointer.NULL,
                lpOverlapped)) {
            if (Errhandlingapi.GetLastError() != Winerror.ERROR_IO_PENDING) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void WriteFile(HANDLE hFile, MemorySegment lpBuffer, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (!WriteFile.invoke_BL___P__A_uI__P__P(
                hFile,
                lpBuffer,
                ConversionsJava2Native.long_TO_uint32_t(lpBuffer.byteSize()),
                Pointer.NULL,
                lpOverlapped)) {
            if (Errhandlingapi.GetLastError() != Winerror.ERROR_IO_PENDING) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpNumberOfBytesWritten the number of bytes written.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, long off, int nNumberOfBytesToWrite, WinDef.LPDWORD lpNumberOfBytesWritten) throws NativeErrorException {
        if (!WriteFile.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToWrite),
                nNumberOfBytesToWrite,
                lpNumberOfBytesWritten,
                Pointer.NULL)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, long off, int nNumberOfBytesToWrite, LPOVERLAPPED lpOverlapped) throws NativeErrorException {
        if (!WriteFile.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToWrite),
                nNumberOfBytesToWrite,
                Pointer.NULL,
                lpOverlapped)) {
            if (Errhandlingapi.GetLastError() != Winerror.ERROR_IO_PENDING) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefileex">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device. Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link ByteBuffer}.
     *
     *
     * Use
     * {@link Ioapiset#GetOverlappedResult(HANDLE, OVERLAPPED, ByteBuffer, boolean)}
     * to get the result and update the ByteBuffers position.      <code>
     *  WriteFile(hFile, lpBuffer, lpOverlapped);
     *  final long waitResult = WaitForSingleObject(lpOverlapped.hEvent(), INFINITE());
     *  if (waitResult == WAIT_OBJECT_0()) {
     *  //success
     *    int bytesWritten = GetOverlappedResult(hFile, readOverlapped, lpBuffer, false);
     *  } else {
     *  //error
     *  }
     * </code>
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link ByteBuffer} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the write operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFileEx(HANDLE hFile, ByteBuffer lpBuffer, LPOVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            if (!WriteFileEx.invoke_BL___P__A_uI__P__P(
                    hFile,
                    MemorySegment.ofBuffer(lpBuffer),
                    lpBuffer.remaining(),
                    lpOverlapped,
                    lpCompletionRoutine)) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous write ....");
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefileex">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the write operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFileEx(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToWrite, LPOVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (!WriteFileEx.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToWrite),
                nNumberOfBytesToWrite,
                lpOverlapped,
                lpCompletionRoutine)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefileex">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device.This is the asynchronous write for {@link OpaqueMemory}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the write operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void WriteFileEx(HANDLE hFile, OpaqueMemory lpBuffer, LPOVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (!WriteFileEx.invoke_BL___P__P_uI__P__P(
                hFile,
                lpBuffer,
                ConversionsJava2Native.long_TO_uint32_t(lpBuffer.sizeof()),
                lpOverlapped,
                lpCompletionRoutine)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefileex">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpOverlapped a pointer to an {@link LPOVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the write operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFileEx(HANDLE hFile, OpaqueMemory lpBuffer, long off, int nNumberOfBytesToWrite, LPOVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (!WriteFileEx.invoke_BL___P__A_uI__P__P(
                hFile,
                OpaqueMemory.sliceMemorySegment(lpBuffer, off, nNumberOfBytesToWrite),
                nNumberOfBytesToWrite,
                lpOverlapped,
                lpCompletionRoutine)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

}
