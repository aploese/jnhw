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

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Int8_t;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.OpaqueMemory64;
import de.ibapl.jnhw.common.util.ByteBufferUtils;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Objects;

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
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">CREATE_NEW</a>
     * Creates a new file, only if it does not already exist.
     *
     */
    @Define
    public final static int CREATE_NEW = 1;
    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">CREATE_ALWAYS</a>
     * Creates a new file, always.
     *
     */
    @Define
    public final static int CREATE_ALWAYS = 2;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">OPEN_EXISTING</a>
     * Opens a file or device, only if it exists.
     *
     */
    @Define
    public final static int OPEN_EXISTING = 3;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">OPEN_ALWAYS</a>
     * Opens a file, always.
     *
     */
    @Define
    public final static int OPEN_ALWAYS = 4;
    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">TRUNCATE_EXISTING</a>
     * Opens a file and truncates it so that its size is zero bytes, only if it
     * exists.
     *
     */
    @Define
    public final static int TRUNCATE_EXISTING = 5;

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
        return HANDLE.of(CreateFileW(lpFileName, dwDesiredAccess, dwShareMode, AbstractNativeMemory.toUintptr_tOrNULL(lpSecurityAttributes), dwCreationDisposition, dwFlagsAndAttributes, HANDLE.getHandleValue(hTemplateFile)));
    }

    private static native long CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, long ptrLpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, long prtHTemplateFile) throws NativeErrorException;

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
        return HANDLE.of(CreateFileW(file.getAbsolutePath(), dwDesiredAccess, dwShareMode, AbstractNativeMemory.toUintptr_tOrNULL(lpSecurityAttributes), dwCreationDisposition, dwFlagsAndAttributes, HANDLE.getHandleValueOrNULL(hTemplateFile)));
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
        FlushFileBuffers(HANDLE.getHandleValue(hFile));
    }

    private static native void FlushFileBuffers(long ptrHFile) throws NativeErrorException;

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
     * @return {@code lpNumberOfBytesRead} the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if off and nNumberOfBytesToRead
     * are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int ReadFile(HANDLE hFile, byte[] lpBuffer, int off, int nNumberOfBytesToRead) throws NativeErrorException {
        Objects.checkFromIndexSize(off, nNumberOfBytesToRead, lpBuffer.length);
        return ReadFile(HANDLE.getHandleValue(hFile), lpBuffer, off, nNumberOfBytesToRead);
    }

    private static native int ReadFile(long ptrHFile, byte[] lpBuffer, int off, int nNumberOfBytesToRead) throws NativeErrorException;

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
     * @return {@code lpNumberOfBytesRead} the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if off and nNumberOfBytesToRead
     * are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static int ReadFile(HANDLE hFile, byte[] lpBuffer) throws NativeErrorException {
        return ReadFile(HANDLE.getHandleValue(hFile), lpBuffer, 0, lpBuffer.length);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device.Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the synchronous read for {@link OpaqueMemory32}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory32} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @return {@code lpNumberOfBytesRead} the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and nNumberOfBytesToRead
     * are outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int ReadFile(HANDLE hFile, OpaqueMemory32 lpBuffer, int off, int nNumberOfBytesToRead) throws NativeErrorException {
        OpaqueMemory32.checkIndex(lpBuffer, off, nNumberOfBytesToRead);
        return ReadFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToRead);
    }

    private static native int ReadFile(long ptrHFile, long ptrLpBuffer, int off, int nNumberOfBytesToRead) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device.Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the synchronous read for {@link OpaqueMemory32}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory32} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @return {@code lpNumberOfBytesRead} the number of bytes read.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws IndexOutOfBoundsException if pos and nNumberOfBytesToRead are
     * outside of lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int ReadFile(HANDLE hFile, OpaqueMemory64 lpBuffer, long off, int nNumberOfBytesToRead) throws NativeErrorException {
        OpaqueMemory64.checkIndex(lpBuffer, off, nNumberOfBytesToRead);
        return ReadFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToRead);
    }

    private static native int ReadFile(long ptrHFile, long ptrLpBuffer, long off, int nNumberOfBytesToRead) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads a single byte from the specified file or input/output (I/O)
     * device.Reads occur at the position specified by the file pointer if
     * supported by the device. This is the synchronous read.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param b a pointer to the {@link ByteRef} that receives the single byte
     * read from a file or device.
     * @return {@code lpNumberOfBytesRead} the number of bytes read.
     *
     * @throws NullPointerException if hFile or b is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int ReadFile(HANDLE hFile, Int8_t b) throws NativeErrorException {
        return ReadFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(b), 0, 1);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory32}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory32} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpOverlapped A pointer to an {@link OVERLAPPED} structure.
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
    public final static void ReadFile(HANDLE hFile, OpaqueMemory32 lpBuffer, int off, int nNumberOfBytesToRead, OVERLAPPED lpOverlapped) throws NativeErrorException {
        OpaqueMemory32.checkIndex(lpBuffer, off, nNumberOfBytesToRead);
        ReadFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToRead, AbstractNativeMemory.toUintptr_t(lpOverlapped));
    }

    private static native void ReadFile(long ptrHFile, long ptrLpBuffer, int off, int nNumberOfBytesToRead, long ptrLpOverlapped) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory32}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory32} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpOverlapped A pointer to an {@link OVERLAPPED} structure.
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
    public static void ReadFile(HANDLE hFile, OpaqueMemory64 lpBuffer, long off, int nNumberOfBytesToRead, OVERLAPPED lpOverlapped) throws NativeErrorException {
        OpaqueMemory64.checkIndex(lpBuffer, off, nNumberOfBytesToRead);
        ReadFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToRead, AbstractNativeMemory.toUintptr_t(lpOverlapped));
    }

    private static native void ReadFile(long ptrHFile, long ptrLpBuffer, long off, int nNumberOfBytesToRead, long ptrLpOverlapped) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfile">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory32}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory32} that receives all
     * data read from a file or device.
     * @param lpOverlapped A pointer to an {@link OVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void ReadFile(HANDLE hFile, OpaqueMemory32 lpBuffer, OVERLAPPED lpOverlapped) throws NativeErrorException {
        ReadFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), 0, lpBuffer.sizeInBytes, AbstractNativeMemory.toUintptr_t(lpOverlapped));
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
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFile(HANDLE hFile, ByteBuffer lpBuffer) throws NativeErrorException {
        int numberOfBytesRead;
        if (lpBuffer.isDirect()) {
            numberOfBytesRead = ReadFile(HANDLE.getHandleValue(hFile), lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer));
        } else {
            numberOfBytesRead = ReadFile(HANDLE.getHandleValue(hFile), lpBuffer.array(), lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer));
        }
        lpBuffer.position(lpBuffer.position() + numberOfBytesRead);
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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     *
     * @throws NullPointerException if {@code hFile} or {@code lpBuffer} or
     * {@code lpOverlapped} is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ReadFile(HANDLE hFile, ByteBuffer lpBuffer, OVERLAPPED lpOverlapped) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            ReadFile(HANDLE.getHandleValue(hFile), lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer), AbstractNativeMemory.toUintptr_t(lpOverlapped));
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous read ....");
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfileex">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory32}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory32} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpOverlapped A pointer to an {@link OVERLAPPED} structure.
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
    public final static void ReadFileEx(HANDLE hFile, OpaqueMemory32 lpBuffer, int off, int nNumberOfBytesToRead, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        OpaqueMemory32.checkIndex(lpBuffer, off, nNumberOfBytesToRead);
        ReadFileEx(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToRead, AbstractNativeMemory.toUintptr_t(lpOverlapped), NativeFunctionPointer.toUintptr_t(lpCompletionRoutine));
    }

    private static native void ReadFileEx(long ptrHFile, long ptrLpBuffer, int off, int nNumberOfBytesToRead, long ptrLpOverlapped, long ptrLpCompletionRoutine) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfileex">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory32}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory32} that receives the
     * data read from a file or device.
     * @param off the start offset in {@code buf} to which the data is
     * transferred.
     * @param nNumberOfBytesToRead the maximum number of bytes to read.
     * @param lpOverlapped A pointer to an {@link OVERLAPPED} structure.
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
    public final static void ReadFileEx(HANDLE hFile, OpaqueMemory64 lpBuffer, long off, int nNumberOfBytesToRead, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        OpaqueMemory64.checkIndex(lpBuffer, off, nNumberOfBytesToRead);
        ReadFileEx(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToRead, AbstractNativeMemory.toUintptr_t(lpOverlapped), NativeFunctionPointer.toUintptr_t(lpCompletionRoutine));
    }

    private static native void ReadFileEx(long ptrHFile, long ptrLpBuffer, long off, int nNumberOfBytesToRead, long ptrLpOverlapped, long ptrLpCompletionRoutine) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-readfileex">ReadFile</a>
     * Reads data from the specified file or input/output (I/O) device. Reads
     * occur at the position specified by the file pointer if supported by the
     * device. This is the asynchronous read for {@link OpaqueMemory32}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer a pointer to the {@link OpaqueMemory32} that receives all
     * data read from a file or device.
     * @param lpOverlapped A pointer to an {@link OVERLAPPED} structure.
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
    public static void ReadFileEx(HANDLE hFile, OpaqueMemory32 lpBuffer, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        ReadFileEx(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), 0, lpBuffer.sizeInBytes, AbstractNativeMemory.toUintptr_t(lpOverlapped), NativeFunctionPointer.toUintptr_t(lpCompletionRoutine));
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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
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
    public final static void ReadFileEx(HANDLE hFile, ByteBuffer lpBuffer, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            ReadFileEx(HANDLE.getHandleValue(hFile), lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer), AbstractNativeMemory.toUintptr_t(lpOverlapped), NativeFunctionPointer.toUintptr_t(lpCompletionRoutine));
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous read ....");
        }
    }

    private static native int ReadFile(long ptrHFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToRead) throws NativeErrorException;

    private static native void ReadFile(long ptrHFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToRead, long ptrLpOverlapped) throws NativeErrorException;

    private static native void ReadFileEx(long ptrHFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToRead, long ptrLpOverlapped, long ptrLpCompletionRoutine) throws NativeErrorException;

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
     * @return {@code lpNumberOfBytesWritten} the number of bytes written.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int WriteFile(HANDLE hFile, byte[] lpBuffer, int off, int nNumberOfBytesToWrite) throws NativeErrorException {
        Objects.checkFromIndexSize(off, nNumberOfBytesToWrite, lpBuffer.length);
        return WriteFile(HANDLE.getHandleValue(hFile), lpBuffer, off, nNumberOfBytesToWrite);
    }

    private static native int WriteFile(long ptrHFile, byte[] lpBuffer, int off, int nNumberOfBytesToWrite) throws NativeErrorException;

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
     * @return {@code lpNumberOfBytesWritten} the number of bytes written.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static int WriteFile(HANDLE hFile, byte[] lpBuffer) throws NativeErrorException {
        return WriteFile(HANDLE.getHandleValue(hFile), lpBuffer, 0, lpBuffer.length);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for {@link OpaqueMemory32}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory32} {@code lpBuffer} containing
     * the data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @return {@code lpNumberOfBytesWritten} the number of bytes written.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int WriteFile(HANDLE hFile, OpaqueMemory32 lpBuffer, int off, int nNumberOfBytesToWrite) throws NativeErrorException {
        OpaqueMemory32.checkIndex(lpBuffer, off, nNumberOfBytesToWrite);
        return WriteFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToWrite);
    }

    private static native int WriteFile(long ptrHFile, long ptrLpBuffer, int off, int nNumberOfBytesToWrite) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for {@link OpaqueMemory32}.
     *
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory32} {@code lpBuffer} containing
     * the data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @return {@code lpNumberOfBytesWritten} the number of bytes written.
     *
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws ArrayIndexOutOfBoundsException if pos and len are outside of
     * lpBuffer.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int WriteFile(HANDLE hFile, OpaqueMemory64 lpBuffer, long off, int nNumberOfBytesToWrite) throws NativeErrorException {
        OpaqueMemory64.checkIndex(lpBuffer, off, nNumberOfBytesToWrite);
        return WriteFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToWrite);
    }

    private static native int WriteFile(long ptrHFile, long ptrLpBuffer, long off, int nNumberOfBytesToWrite) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device. Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the synchronous write for a single byte .
     *
     * @param hFile a handle to the file or I/O device.
     * @param b the byte to write.
     * @return {@code lpNumberOfBytesWritten} the number of bytes written.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int WriteFile(HANDLE hFile, byte b) throws NativeErrorException {
        return WriteFile(HANDLE.getHandleValue(hFile), b);
    }

    private static native int WriteFile(long ptrHFile, byte b) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory32}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory32} {@code lpBuffer} containing
     * the data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
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
    public final static void WriteFile(HANDLE hFile, OpaqueMemory32 lpBuffer, int off, int nNumberOfBytesToWrite, OVERLAPPED lpOverlapped) throws NativeErrorException {
        OpaqueMemory32.checkIndex(lpBuffer, off, nNumberOfBytesToWrite);
        WriteFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToWrite, AbstractNativeMemory.toUintptr_t(lpOverlapped));
    }

    private static native void WriteFile(long ptrHFile, long ptrLpBuffer, int off, int nNumberOfBytesToWrite, long ptrLpOverlapped) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory32}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory32} {@code lpBuffer} containing
     * the data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
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
    public final static void WriteFile(HANDLE hFile, OpaqueMemory64 lpBuffer, long off, int nNumberOfBytesToWrite, OVERLAPPED lpOverlapped) throws NativeErrorException {
        OpaqueMemory64.checkIndex(lpBuffer, off, nNumberOfBytesToWrite);
        WriteFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToWrite, AbstractNativeMemory.toUintptr_t(lpOverlapped));
    }

    private static native void WriteFile(long ptrHFile, long ptrLpBuffer, long off, int nNumberOfBytesToWrite, long ptrLpOverlapped) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefile">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory32}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory32} {@code lpBuffer} containing
     * the data to be written to the file or device.
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public static void WriteFile(HANDLE hFile, OpaqueMemory32 lpBuffer, OVERLAPPED lpOverlapped) throws NativeErrorException {
        WriteFile(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), 0, lpBuffer.sizeInBytes, AbstractNativeMemory.toUintptr_t(lpOverlapped));
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
     * @throws NullPointerException if hFile or lpBuffer is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, ByteBuffer lpBuffer) throws NativeErrorException {
        int numberOfBytesWritten;
        if (lpBuffer.isDirect()) {
            numberOfBytesWritten = WriteFile(HANDLE.getHandleValue(hFile), lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer));
        } else {
            if (lpBuffer.isReadOnly()) {
                // see buffer.array() why we do this is here.
                byte[] _buf = new byte[ByteBufferUtils.calcBufferWriteBytes(lpBuffer)];
                lpBuffer.get(_buf);
                //We haven't written anything yet, so fix the position for now.
                lpBuffer.position(lpBuffer.position() - _buf.length);
                numberOfBytesWritten = WriteFile(HANDLE.getHandleValue(hFile), _buf, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer));
            } else {
                numberOfBytesWritten = WriteFile(HANDLE.getHandleValue(hFile), lpBuffer.array(), lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer));
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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
     *
     * @throws NullPointerException if hFile or lpBuffer or lpOverlapped is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void WriteFile(HANDLE hFile, ByteBuffer lpBuffer, OVERLAPPED lpOverlapped) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            WriteFile(HANDLE.getHandleValue(hFile), lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer), AbstractNativeMemory.toUintptr_t(lpOverlapped));
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous write ....");
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefileex">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory32}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory32} {@code lpBuffer} containing
     * the data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
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
    public final static void WriteFileEx(HANDLE hFile, OpaqueMemory32 lpBuffer, int off, int nNumberOfBytesToWrite, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        OpaqueMemory32.checkIndex(lpBuffer, off, nNumberOfBytesToWrite);
        WriteFileEx(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToWrite, AbstractNativeMemory.toUintptr_t(lpOverlapped), NativeFunctionPointer.toUintptr_t(lpCompletionRoutine));
    }

    private static native void WriteFileEx(long ptrHFile, long ptrLpBuffer, int off, int nNumberOfBytesToWrite, long ptrLpOverlapped, long ptrLpCompletionRoutine) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefileex">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device. This is the asynchronous write for {@link OpaqueMemory32}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory32} {@code lpBuffer} containing
     * the data to be written to the file or device.
     * @param off the start offset in {@code lpBuffer}.
     * @param nNumberOfBytesToWrite the number of bytes to write.
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
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
    public final static void WriteFileEx(HANDLE hFile, OpaqueMemory64 lpBuffer, long off, int nNumberOfBytesToWrite, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        OpaqueMemory64.checkIndex(lpBuffer, off, nNumberOfBytesToWrite);
        WriteFileEx(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), off, nNumberOfBytesToWrite, AbstractNativeMemory.toUintptr_t(lpOverlapped), NativeFunctionPointer.toUintptr_t(lpCompletionRoutine));
    }

    private static native void WriteFileEx(long ptrHFile, long ptrLpBuffer, long off, int nNumberOfBytesToWrite, long ptrLpOverlapped, long ptrLpCompletionRoutine) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-writefileex">WriteFile</a>
     * Writes data to the specified file or input/output (I/O) device.Writing
     * starts at the position specified by the file pointer if supported by the
     * device.This is the asynchronous write for {@link OpaqueMemory32}.
     *
     * @param hFile a handle to the file or I/O device.
     * @param lpBuffer the {@link OpaqueMemory32} {@code lpBuffer} containing
     * the data to be written to the file or device.
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
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
    public static void WriteFileEx(HANDLE hFile, OpaqueMemory32 lpBuffer, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        WriteFileEx(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpBuffer), 0, lpBuffer.sizeInBytes, AbstractNativeMemory.toUintptr_t(lpOverlapped), NativeFunctionPointer.toUintptr_t(lpCompletionRoutine));
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
     * @param lpOverlapped a pointer to an {@link OVERLAPPED} structure.
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
    public final static void WriteFileEx(HANDLE hFile, ByteBuffer lpBuffer, OVERLAPPED lpOverlapped, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE lpCompletionRoutine) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            WriteFileEx(HANDLE.getHandleValue(hFile), lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer), AbstractNativeMemory.toUintptr_t(lpOverlapped), NativeFunctionPointer.toUintptr_t(lpCompletionRoutine));
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous write ....");
        }
    }

    private static native int WriteFile(long ptrHFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToWrite) throws NativeErrorException;

    private static native void WriteFile(long ptrHFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToWrite, long ptrLpOverlapped) throws NativeErrorException;

    private static native void WriteFileEx(long ptrHFile, ByteBuffer lpBuffer, int off, int nNumberOfBytesToWrite, long ptrLpOverlapped, long ptrLpCompletionRoutine) throws NativeErrorException;

}
