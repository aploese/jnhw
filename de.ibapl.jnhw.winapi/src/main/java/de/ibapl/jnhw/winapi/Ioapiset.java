/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.winapi.Minwinbase.OVERLAPPED;
import static de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 *
 * @author aploese
 */
public final class Ioapiset {

    public final static native boolean HAVE_IOAPISET_H();

    private static native void GetOverlappedResult(long hFile, long lpOverlapped, IntRef lpNumberOfBytesTransferred, boolean bWait) throws NativeErrorException;
    
    public final static void GetOverlappedResult(HANDLE hFile, OVERLAPPED lpOverlapped, IntRef lpNumberOfBytesTransferred, boolean bWait) throws NativeErrorException {
        GetOverlappedResult(hFile.value, lpOverlapped.baseAddress, lpNumberOfBytesTransferred, bWait);
    }
}
