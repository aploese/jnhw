/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.winapi.Minwindef.HANDLE;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import de.ibapl.jnhw.NativeErrorException;
import java.nio.ByteBuffer;

/**
 *
 * @author aploese
 */
public abstract class Fileapi {

    public static final int CREATE_NEW = 1;
    public static final int CREATE_ALWAYS = 2;
    public final static native int OPEN_EXISTING();
    public static final int OPEN_ALWAYS = 4;
    public static final int TRUNCATE_EXISTING = 5;

    public static final int INVALID_FILE_SIZE = 0xffffffff;
    public static final int INVALID_SET_FILE_POINTER = -1;
    public static final int INVALID_FILE_ATTRIBUTES = -1;

    public final static native Minwindef.HANDLE CreateFileW(String lpFileName, int dwDesiredAccess, int dwShareMode, SECURITY_ATTRIBUTES lpSecurityAttributes, int dwCreationDisposition, int dwFlagsAndAttributes, HANDLE hTemplateFile) throws  NativeErrorException;

    public final static native void FlushFileBuffers(HANDLE hFile) throws NativeErrorException;

    public final static native void ReadFile(HANDLE hFile, byte[] lpBuffer, int nNumberOfBytesToRead, IntRef lpNumberOfBytesRead, OVERLAPPED lpOverlapped) throws NativeErrorException;

    public final static native void ReadFile(HANDLE hFile, ByteBuffer lpBuffer, int nNumberOfBytesToRead, IntRef lpNumberOfBytesRead, OVERLAPPED lpOverlapped) throws NativeErrorException;

    public final static native void WriteFile(HANDLE hFile, ByteBuffer lpBuffer, int nNumberOfBytesToWrite, IntRef lpNumberOfBytesWritten, OVERLAPPED lpOverlapped) throws NativeErrorException;

    public final static native void WriteFile(HANDLE hFile, byte[] lpBuffer, int nNumberOfBytesToWrite, IntRef lpNumberOfBytesWritten, OVERLAPPED lpOverlapped) throws NativeErrorException;
}
