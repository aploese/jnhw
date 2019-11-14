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

import de.ibapl.jnhw.ByteRef;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.util.ByteBufferUtils;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import java.io.File;
import java.nio.ByteBuffer;

/**
 * Wrapper around the {@code<fileapi.h>} header.
 * See specs at: <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">fileapi.h</a>
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

    public final static native boolean HAVE_FILEAPI_H();

    @Define
    public final static native int OPEN_EXISTING();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew">CreateFileW</a>
     * 
     * @param lpFileName
     * @param dwDesiredAccess
     * @param dwShareMode
     * @param lpSecurityAttributes
     * @param dwCreationDisposition
     * @param dwFlagsAndAttributes
     * @param hTemplateFile
     * @return
     * @throws NativeErrorException 
     */
    public final static native HANDLE CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew">CreateFileW</a>
     * 
     * @param file
     * @param dwDesiredAccess
     * @param dwShareMode
     * @param lpSecurityAttributes
     * @param dwCreationDisposition
     * @param dwFlagsAndAttributes
     * @param hTemplateFile
     * @return
     * @throws NativeErrorException 
     */
    public final static HANDLE CreateFileW(File file, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws NativeErrorException {
        return CreateFileW(file.getAbsolutePath(), dwDesiredAccess, dwShareMode, lpSecurityAttributes, dwCreationDisposition, dwFlagsAndAttributes, hTemplateFile);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-flushfilebuffers">CreateFileW</a>
     * 
     * @param hFile
     * @throws NativeErrorException 
     */
    public final static native void FlushFileBuffers(HANDLE hFile) throws NativeErrorException;

    // No async Read with byte[] we cant copy back
    public static native int ReadFile(HANDLE hFile, byte[] lpBuffer, int offset, int len) throws NativeErrorException;

    public static void ReadFile(HANDLE hFile, byte[] lpBuffer, int offset, int len, IntRef lpNumberOfBytesRead) throws NativeErrorException {
        lpNumberOfBytesRead.value = ReadFile(hFile, lpBuffer, offset, len);
    }

    private static native int ReadFile_ArgsOK(HANDLE hFile, ByteBuffer lpBuffer, int offset, int len) throws NativeErrorException;

    private static native void ReadFile_ArgsOK(HANDLE hFile, ByteBuffer lpBuffer, int offset, int len, OVERLAPPED lpOVERLAPPED) throws NativeErrorException;

    public static native int ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, int offset, int len) throws NativeErrorException;

    public static void ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, IntRef lpNumberOfBytesRead) throws NativeErrorException {
        lpNumberOfBytesRead.value = ReadFile(hFile, lpBuffer, 0, lpBuffer.sizeInBytes);
    }

    public static native int ReadFile(HANDLE hFile, ByteRef b) throws NativeErrorException;

    public static native void ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, int offset, int len, OVERLAPPED lpOVERLAPPED) throws NativeErrorException;

    public static void ReadFile(HANDLE hFile, OpaqueMemory lpBuffer, OVERLAPPED lpOVERLAPPED) throws NativeErrorException {
        ReadFile(hFile, lpBuffer, 0, lpBuffer.sizeInBytes, lpOVERLAPPED);
    }

    // No async Write with byte[] we would write from memory which may not exist anymore ...
    public static native int WriteFile(HANDLE hFile, byte[] lpBuffer, int offset, int len) throws NativeErrorException;

    public static void WriteFile(HANDLE hFile, byte[] lpBuffer, int offset, int len, IntRef lpNumberOfBytesWritten) throws NativeErrorException {
        lpNumberOfBytesWritten.value = WriteFile(hFile, lpBuffer, offset, len);
    }

    private static native int WriteFile_ArgsOK(HANDLE hFile, ByteBuffer lpBuffer, int offset, int len) throws NativeErrorException;

    private static native void WriteFile_ArgsOK(HANDLE hFile, ByteBuffer lpBuffer, int offset, int len, OVERLAPPED lpOVERLAPPED) throws NativeErrorException;

    public static native int WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, int offset, int len) throws NativeErrorException;

    public static void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, int offset, int len, IntRef lpNumberOfBytesWritten) throws NativeErrorException {
        lpNumberOfBytesWritten.value = WriteFile(hFile, lpBuffer, offset, len);
    }

    public static void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, IntRef lpNumberOfBytesWritten) throws NativeErrorException {
        lpNumberOfBytesWritten.value = WriteFile(hFile, lpBuffer, 0, lpBuffer.sizeInBytes);
    }

    /**
     * Write a single byte.
     * @param hFile
     * @param b the byte to write.
     * @return bytes written, also 1.
     * @throws NativeErrorException 
     */
    public static native int WriteFile(HANDLE hFile, byte b) throws NativeErrorException;

    public static native void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, int offset, int len, OVERLAPPED lpOVERLAPPED) throws NativeErrorException;

    public static void WriteFile(HANDLE hFile, OpaqueMemory lpBuffer, OVERLAPPED lpOVERLAPPED) throws NativeErrorException {
        WriteFile(hFile, lpBuffer, 0, lpBuffer.sizeInBytes, lpOVERLAPPED);
    }

    public final static void ReadFile(HANDLE hFile, ByteBuffer lpBuffer) throws NativeErrorException {
        int numberOfBytesRead;
        if (lpBuffer.isDirect()) {
            if (hFile == null) {
                throw new NullPointerException("hFile is null!");
            }
            numberOfBytesRead = ReadFile_ArgsOK(hFile, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer));
        } else {
            numberOfBytesRead = ReadFile(hFile, lpBuffer.array(), lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer));
        }
        lpBuffer.position(lpBuffer.position() + numberOfBytesRead);
    }

    /**
     * use @see Ioapiset.GetOverlappedResult(HANDLE, OVERLAPPED, ByteBuffer) to
     * get the result and fix the ByteBuffers position.
     *
     * @param hFile
     * @param lpBuffer
     * @param lpOverlapped
     * @throws NativeErrorException
     */
    public final static void ReadFile(HANDLE hFile, ByteBuffer lpBuffer, OVERLAPPED lpOverlapped) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            if (hFile == null) {
                throw new NullPointerException("hFile is null!");
            }
            if (lpOverlapped == null) {
                throw new NullPointerException("lpOverlapped is null!");
            }
            ReadFile_ArgsOK(hFile, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer), lpOverlapped);
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous read ....");
        }
    }

    public final static void WriteFile(HANDLE hFile, ByteBuffer lpBuffer) throws NativeErrorException {
        int numberOfBytesWritten;
        if (lpBuffer.isDirect()) {
            if (hFile == null) {
                throw new NullPointerException("hFile is null!");
            }
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
     * use @see Ioapiset.GetOverlappedResult(HANDLE, OVERLAPPED, ByteBuffer) to
     * get the result and fix the ByteBuffers position.
     *
     * @param hFile
     * @param lpBuffer
     * @param lpOverlapped
     * @throws NativeErrorException
     */
    public final static void WriteFile(HANDLE hFile, ByteBuffer lpBuffer, OVERLAPPED lpOverlapped) throws NativeErrorException {
        if (lpBuffer.isDirect()) {
            if (hFile == null) {
                throw new NullPointerException("hFile is null!");
            }
            if (lpOverlapped == null) {
                throw new NullPointerException("lpOverlapped is null!");
            }
            WriteFile_ArgsOK(hFile, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer), lpOverlapped);
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous write ....");
        }
    }

}
