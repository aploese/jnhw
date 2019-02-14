/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.nio.ByteBuffer;

/**
 *
 * @author aploese
 */
@Include("fileapi.h")
public final class Fileapi {

    public final static native boolean HAVE_FILEAPI_H();

    @Define
    public final static native int OPEN_EXISTING();

    private static native long CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, long lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, long hTemplateFile) throws NativeErrorException;

    public final static HANDLE CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws NativeErrorException {
        final long nativeHandle = CreateFileW(lpFileName, dwDesiredAccess, dwShareMode, lpSecurityAttributes.baseAddress, dwCreationDisposition, dwFlagsAndAttributes, hTemplateFile.value);
        return new HANDLE(nativeHandle);
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

    public final static void jnhw_fix_bufferPosition(ByteBuffer lpBuffer, HANDLE hFile, OVERLAPPED overlapped) throws NativeErrorException {
        IntRef dwBytesRead = new IntRef(0);
        Ioapiset.GetOverlappedResult(hFile, overlapped, dwBytesRead, false);
        lpBuffer.position(lpBuffer.position() + dwBytesRead.value);
    }

    /**
     * jnhw_fix_bufferPosition is needed...
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

    public final static void WriteFile(HANDLE hFile, ByteBuffer lpBuffer, IntRef lpNumberOfBytesWritten) throws NativeErrorException {
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
