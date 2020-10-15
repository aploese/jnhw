/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.ByteRef;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.util.ByteBufferUtils;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.io.File;
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
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">CREATE_ALWAYS</a>
     * Creates a new file, always.
     *
     * @return the native symbolic constant of CREATE_ALWAYS.
     */
    @Define
    public final static native int CREATE_ALWAYS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">CREATE_NEW</a>
     * Creates a new file, only if it does not already exist.
     *
     * @return the native symbolic constant of CREATE_NEW.
     */
    @Define
    public final static native int CREATE_NEW();

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
     * @throws NullPointerException if lpFileName is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native HANDLE CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws NativeErrorException;

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
     * @throws NullPointerException if file is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static HANDLE CreateFileW(File file, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws NativeErrorException {
        return CreateFileW(file.getAbsolutePath(), dwDesiredAccess, dwShareMode, lpSecurityAttributes, dwCreationDisposition, dwFlagsAndAttributes, hTemplateFile);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-flushfilebuffers">FlushFileBuffers</a>
     * Flushes the buffers of a specified file and causes all buffered data to
     * be written to a file.
     *
     * @param hFile A handle to the open file.
     *
     * @throws NullPointerException if hFile is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void FlushFileBuffers(HANDLE hFile) throws NativeErrorException;

    public final static native boolean HAVE_FILEAPI_H();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">OPEN_ALWAYS</a>
     * Opens a file, always.
     *
     * @return the native symbolic constant of OPEN_ALWAYS.
     */
    @Define
    public final static native int OPEN_ALWAYS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">OPEN_EXISTING</a>
     * Opens a file or device, only if it exists.
     *
     * @return the native symbolic constant of OPEN_EXISTING.
     */
    @Define
    public final static native int OPEN_EXISTING();

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
     * @return the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null].
     *
     * @throws ArrayIndexOutOfBoundsException if off and nNumberOfBytesToRead are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native int ReadFile(HANDLE hFile, byte[] lpBuffer, int off, int nNumberOfBytesToRead) throws NativeErrorException;

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
     * @return the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null].
     *
     * @throws ArrayIndexOutOfBoundsException if pos and nNumberOfBytesToRead are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native int ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToRead) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads a single byte from the specified file or input/output (I/O)
     * device.Reads occur at the position specified by the file pointer if
     * supported by the device. This is the synchronous read.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param b a pointer to the {@link ByterRef} that receives the single byte
     * read from a file or device.
     * @return on succes 1.
     *
     * @throws NullPointerException if hFile or b is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native int ReadFile(HANDLE hFile, ByteRef b) throws NativeErrorException;

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
     * @param lpOverlapped A pointer to an {@link OVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native void ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToRead, OVERLAPPED lpOverlapped) throws NativeErrorException;

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
     * @param lpOverlapped A pointer to an {@link OVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, OVERLAPPED lpOverlapped) throws NativeErrorException {
        ReadFile(hFile, lpBuffer, 0, lpBuffer.sizeInBytes, lpOverlapped);
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
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFile(HANDLE hFile, ByteBuffer lpBuffer) throws NativeErrorException {
        if (hFile == null) {
            throw new NullPointerException("hFile is null!");
        }
        int numberOfBytesRead;
        if (lpBuffer.isDirect()) {
            numberOfBytesRead = ReadFile_ArgsOK(hFile, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer));
        } else {
            numberOfBytesRead = ReadFile(hFile, lpBuffer.array(), lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer));
        }
        lpBuffer.position(lpBuffer.position() + numberOfBytesRead);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for direct {@link ByteBuffer}.
     *
     * Use {@link IoAPI.GetOverlappedResult(HANDLE, OVERLAPPED, ByteBuffer)} to
     * get the result and update the ByteBuffers position.      <code>
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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFile(HANDLE hFile, ByteBuffer lpBuffer, OVERLAPPED lpOverlapped) throws NativeErrorException {
        if (hFile == null) {
            throw new NullPointerException("hFile is null!");
        }
        if (lpOverlapped == null) {
            throw new NullPointerException("lpOverlapped is null!");
        }
        if (lpBuffer.isDirect()) {
            ReadFile_ArgsOK(hFile, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer), lpOverlapped);
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
     * @param lpOverlapped A pointer to an {@link OVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the read operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native void ReadFileEx(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToRead, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException;

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
     * @param lpOverlapped A pointer to an {@link OVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the read operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void ReadFileEx(HANDLE hFile, OpaqueMemory lpBuffer, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        ReadFileEx(hFile, lpBuffer, 0, lpBuffer.sizeInBytes, lpOverlapped, lpCompletionRoutine);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfileex">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for direct {@link ByteBuffer}.
     *
     * Use {@link IoAPI.GetOverlappedResult(HANDLE, OVERLAPPED, ByteBuffer)} to
     * get the result and update the ByteBuffers position.      <code>
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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the read operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFileEx(HANDLE hFile, ByteBuffer lpBuffer, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (hFile == null) {
            throw new NullPointerException("hFile is null!");
        }
        if (lpOverlapped == null) {
            throw new NullPointerException("lpOverlapped is null!");
        }
        if (lpCompletionRoutine == null) {
            throw new NullPointerException("lpCompletionRoutine");
        }
        if (lpBuffer.isDirect()) {
            ReadFileEx_ArgsOK(hFile, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer), lpOverlapped, lpCompletionRoutine);
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous read ....");
        }
    }

    private static native int ReadFile_ArgsOK(HANDLE hFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToRead) throws NativeErrorException;

    private static native void ReadFile_ArgsOK(HANDLE hFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToRead, OVERLAPPED lpOverlapped) throws NativeErrorException;

    private static native void ReadFileEx_ArgsOK(HANDLE hFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToRead, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">TRUNCATE_EXISTING</a>
     * Opens a file and truncates it so that its size is zero bytes, only if it
     * exists.
     *
     * @return the native symbolic constant of TRUNCATE_EXISTING.
     */
    @Define
    public final static native int TRUNCATE_EXISTING();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device. Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for a byte array.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the byte array {@code lpBuffer} containing the data to be
     * written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null].
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native int WriteFile(HANDLE hFile, byte[] lpBuffer, int off, int nNumberOfBytesToWrite) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device. Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for {@link OpaqueMemory}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null].
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native int WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToWrite) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device. Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for a single byte .
     *
     * @param hFile a handle to the file or I/O device.
     * @param b the byte to write.
     * @return on success 1.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native int WriteFile(HANDLE hFile, byte b) throws NativeErrorException;

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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToWrite, OVERLAPPED lpOverlapped) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, OVERLAPPED lpOverlapped) throws NativeErrorException {
        WriteFile(hFile, lpBuffer, 0, lpBuffer.sizeInBytes, lpOverlapped);
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
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, ByteBuffer lpBuffer) throws NativeErrorException {
        if (hFile == null) {
            throw new NullPointerException("hFile is null!");
        }
        int numberOfBytesWritten;
        if (lpBuffer.isDirect()) {
            numberOfBytesWritten = WriteFile_ArgsOK(hFile, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer));
        } else {
            if (lpBuffer.isReadOnly()) {
                // see buffer.array() why we do this is here.
                byte[] _buf = new byte[ByteBufferUtils.calcBufferWriteBytes(lpBuffer)];
                lpBuffer.get(_buf);
                //We haven't written anything yet, so fix the position for now.
                lpBuffer.position(lpBuffer.position() - _buf.length);
                numberOfBytesWritten = WriteFile(hFile, _buf, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer));
            } else {
                numberOfBytesWritten = WriteFile(hFile, lpBuffer.array(), lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer));
            }
        }
        lpBuffer.position(lpBuffer.position() + numberOfBytesWritten);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device. Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link ByteBuffer}.
     *
     *
     * Use {@link IoAPI.GetOverlappedResult(HANDLE, OVERLAPPED, ByteBuffer)} to
     * get the result and update the ByteBuffers position.      <code>
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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, ByteBuffer lpBuffer, OVERLAPPED lpOverlapped) throws NativeErrorException {
        if (hFile == null) {
            throw new NullPointerException("hFile is null!");
        }
        if (lpOverlapped == null) {
            throw new NullPointerException("lpOverlapped is null!");
        }
        if (lpBuffer.isDirect()) {
            WriteFile_ArgsOK(hFile, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer), lpOverlapped);
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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the write operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static native void WriteFileEx(HANDLE hFile, OpaqueMemory lpBuffer, int off, int nNumberOfBytesToWrite, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefileex">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device.This is the asynchronous write for {@link OpaqueMemory}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory} {@code lpBuffer} containing the
     * data to be written to the file or device.
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the write operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void WriteFileEx(HANDLE hFile, OpaqueMemory lpBuffer, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        WriteFileEx(hFile, lpBuffer, 0, lpBuffer.sizeInBytes, lpOverlapped, lpCompletionRoutine);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefileex">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device. Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link ByteBuffer}.
     *
     *
     * Use {@link IoAPI.GetOverlappedResult(HANDLE, OVERLAPPED, ByteBuffer)} to
     * get the result and update the ByteBuffers position.      <code>
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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     * @param lpCompletionRoutine A pointer to a completion routine to be called
     * when the write operation has been completed and the calling thread is in
     * an alertable wait state.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFileEx(HANDLE hFile, ByteBuffer lpBuffer, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (hFile == null) {
            throw new NullPointerException("hFile is null!");
        }
        if (lpOverlapped == null) {
            throw new NullPointerException("lpOverlapped is null!");
        }
        if (lpCompletionRoutine == null) {
            throw new NullPointerException("lpCompletionRoutine");
        }
        if (lpBuffer.isDirect()) {
            WriteFileEx_ArgsOK(hFile, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer), lpOverlapped, lpCompletionRoutine);
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous write ....");
        }
    }

    private static native int WriteFile_ArgsOK(HANDLE hFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToWrite) throws NativeErrorException;

    private static native void WriteFile_ArgsOK(HANDLE hFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToWrite, OVERLAPPED lpOverlapped) throws NativeErrorException;

    private static native void WriteFileEx_ArgsOK(HANDLE hFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToWrite, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException;

}
