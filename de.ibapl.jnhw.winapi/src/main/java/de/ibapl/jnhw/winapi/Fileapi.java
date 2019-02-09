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
import java.nio.ByteBuffer;

/**
 *
 * @author aploese
 */
@Include("fileapi.h")
public final class Fileapi {

    @Define
    public final static native int OPEN_EXISTING();

    private static native long CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, long lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, long hTemplateFile) throws  NativeErrorException;

    public final static HANDLE CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws  NativeErrorException  {
        final long nativeHandle = CreateFileW(lpFileName, dwDesiredAccess, dwShareMode, lpSecurityAttributes.baseAddress, dwCreationDisposition, dwFlagsAndAttributes, hTemplateFile.value);
        return new HANDLE(nativeHandle);
    }
 
    private static native void FlushFileBuffers(long hFile) throws NativeErrorException;

    public final static void FlushFileBuffers(HANDLE hFile) throws NativeErrorException {
        FlushFileBuffers(hFile.value);
    }

    public final static native void ReadFile(HANDLE hFile, byte[] lpBuffer, int nNumberOfBytesToRead, IntRef lpNumberOfBytesRead, OVERLAPPED lpOverlapped) throws NativeErrorException;

    public final static native void ReadFile(HANDLE hFile, ByteBuffer lpBuffer, int nNumberOfBytesToRead, IntRef lpNumberOfBytesRead, OVERLAPPED lpOverlapped) throws NativeErrorException;

    public final static native void WriteFile(HANDLE hFile, ByteBuffer lpBuffer, int nNumberOfBytesToWrite, IntRef lpNumberOfBytesWritten, OVERLAPPED lpOverlapped) throws NativeErrorException;

    public final static native void WriteFile(HANDLE hFile, byte[] lpBuffer, int nNumberOfBytesToWrite, IntRef lpNumberOfBytesWritten, OVERLAPPED lpOverlapped) throws NativeErrorException;
}
