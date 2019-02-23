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

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.ByteBufferUtils;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import java.io.File;
import java.nio.ByteBuffer;

/**
 *
 * @author aploese
 */
@Include("fileapi.h")
public final class Fileapi extends LibJnhwWinApiLoader {

    public final static native boolean HAVE_FILEAPI_H();

    @Define
    public final static native int OPEN_EXISTING();

    private static native long CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, long lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, long hTemplateFile) throws NativeErrorException;

    public final static HANDLE CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws NativeErrorException {
        final long nativeHandle = CreateFileW(lpFileName, dwDesiredAccess, dwShareMode, lpSecurityAttributes != null ? lpSecurityAttributes.baseAddress : 0L, dwCreationDisposition, dwFlagsAndAttributes, hTemplateFile != null ? hTemplateFile.value : 0L);
        return new HANDLE(nativeHandle);
    }

    public final static HANDLE CreateFileW(File file, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws NativeErrorException {
        return CreateFileW(file.getAbsolutePath(), dwDesiredAccess, dwShareMode, lpSecurityAttributes, dwCreationDisposition, dwFlagsAndAttributes, hTemplateFile);
    }

    private static native void FlushFileBuffers(long hFile) throws NativeErrorException;

    public final static void FlushFileBuffers(HANDLE hFile) throws NativeErrorException {
        FlushFileBuffers(hFile.value);
    }

    // No async Read with byte[] we cant copy back
    private static native void ReadFile(long hFile, byte[] lpBuffer, int offset, int len, IntRef lpNumberOfBytesRead) throws NativeErrorException;

    private static native void ReadFile(long hFile, ByteBuffer lpBuffer, int offset, int len, IntRef lpNumberOfBytesRead) throws NativeErrorException;

    private static native void ReadFile(long hFile, ByteBuffer lpBuffer, int offset, int len, long lpOVERLAPPED) throws NativeErrorException;

    // No async Write with byte[] we would write from memory which may not exist anymore ...
    private static native void WriteFile(long hFile, byte[] lpBuffer, int offset, int len, IntRef lpNumberOfBytesWritten) throws NativeErrorException;

    private static native void WriteFile(long hFile, ByteBuffer lpBuffer, int offset, int len, IntRef lpNumberOfBytesWritten) throws NativeErrorException;

    private static native void WriteFile(long hFile, ByteBuffer lpBuffer, int offset, int len, long lpOVERLAPPED) throws NativeErrorException;

    public final static void ReadFile(HANDLE hFile, byte[] lpBuffer, int offset, int len, IntRef lpNumberOfBytesRead) throws NativeErrorException {
        ReadFile(hFile.value, lpBuffer, offset, len, lpNumberOfBytesRead);
    }

    public final static void ReadFile(HANDLE hFile, ByteBuffer lpBuffer) throws NativeErrorException {
        IntRef lpNumberOfBytesRead = new IntRef();
        if (lpBuffer.isDirect()) {
            ReadFile(hFile.value, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer), lpNumberOfBytesRead);
        } else {
            ReadFile(hFile.value, lpBuffer.array(), lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer), lpNumberOfBytesRead);
        }
        lpBuffer.position(lpBuffer.position() + lpNumberOfBytesRead.value);
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
            ReadFile(hFile.value, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferReadBytes(lpBuffer), lpOverlapped.baseAddress);
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous read ....");
        }
    }

    public final static void WriteFile(HANDLE hFile, ByteBuffer lpBuffer) throws NativeErrorException {
        IntRef lpNumberOfBytesWritten = new IntRef();
        if (lpBuffer.isDirect()) {
            WriteFile(hFile.value, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer), lpNumberOfBytesWritten);
        } else {
            if (lpBuffer.isReadOnly()) {
                // see buffer.array() why we do this is here.
                byte[] _buf = new byte[ByteBufferUtils.calcBufferWriteBytes(lpBuffer)];
                lpBuffer.get(_buf);
                //We haven't written anything yet, so fix the position for now.
                lpBuffer.position(lpBuffer.position() - _buf.length);
                WriteFile(hFile.value, _buf, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer), lpNumberOfBytesWritten);
            } else {
                WriteFile(hFile.value, lpBuffer.array(), lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer), lpNumberOfBytesWritten);
            }
        }
        lpBuffer.position(lpBuffer.position() + lpNumberOfBytesWritten.value);
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
            WriteFile(hFile.value, lpBuffer, lpBuffer.position(), ByteBufferUtils.calcBufferWriteBytes(lpBuffer), lpOverlapped.baseAddress);
        } else {
            // If Bytebuffer gets garbage collected the mem area would be dangeling somewhere ...
            throw new IllegalArgumentException("Can't wrap NonDirect byteBuffer for asynchronous write ....");
        }
    }

    public final static void WriteFile(HANDLE hFile, byte[] lpBuffer, int offset, int len, IntRef lpNumberOfBytesWritten) throws NativeErrorException {
        WriteFile(hFile.value, lpBuffer, offset, len, lpNumberOfBytesWritten);
    }

}
