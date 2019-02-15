/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LibJnhwWinApiLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import static de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.nio.ByteBuffer;

/**
 *
 * @author aploese
 */
@Include("ioapiset.h")
public final class Ioapiset extends LibJnhwWinApiLoader {

    public final static native boolean HAVE_IOAPISET_H();

    private static native void GetOverlappedResult(long hFile, long lpOverlapped, IntRef lpNumberOfBytesTransferred, boolean bWait) throws NativeErrorException;

    private static native void CancelIoEx(long hFile, long lpOverlapped) throws NativeErrorException;

    private static native void CancelIo(long hFile) throws NativeErrorException;

    public final static void GetOverlappedResult(HANDLE hFile, OVERLAPPED lpOverlapped, IntRef lpNumberOfBytesTransferred, boolean bWait) throws NativeErrorException {
        GetOverlappedResult(hFile.value, lpOverlapped.baseAddress, lpNumberOfBytesTransferred, bWait);
    }

    public final static void GetOverlappedResult(HANDLE hFile, OVERLAPPED overlapped, IntRef lpNumberOfBytesTransferred, boolean bWait, ByteBuffer lpBuffer) throws NativeErrorException {
        GetOverlappedResult(hFile.value, overlapped.baseAddress, lpNumberOfBytesTransferred, bWait);
        lpBuffer.position(lpBuffer.position() + lpNumberOfBytesTransferred.value);
    }

    public final static void CancelIoEx(HANDLE hFile, OVERLAPPED lpOverlapped) throws NativeErrorException {
        CancelIoEx(hFile.value, lpOverlapped != null ? lpOverlapped.baseAddress : 0L);
    }

    public final static void CancelIo(HANDLE hFile) throws NativeErrorException {
        CancelIo(hFile.value);
    }
}
