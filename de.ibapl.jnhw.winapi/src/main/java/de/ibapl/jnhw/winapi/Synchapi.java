/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwWinApiLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 *
 * @author aploese
 */
@Include("synchapi.h")
public abstract class Synchapi extends LibJnhwWinApiLoader {

    public final static native boolean HAVE_SYNCHAPI_H();

    private static native long WaitForSingleObject(long hHandle, long dwMilliseconds);

    public final static long WaitForSingleObject(HANDLE hHandle, long dwMilliseconds) {
        return WaitForSingleObject(hHandle.value, dwMilliseconds);
    }

    private static native long CreateEventW(long lpEventAttributes, boolean bManualReset, boolean bInitialState, String lpName) throws NativeErrorException;

    public final static HANDLE CreateEventW(SECURITY_ATTRIBUTES lpEventAttributes, boolean bManualReset, boolean bInitialState, String lpName) throws NativeErrorException {
        final long result = CreateEventW(lpEventAttributes == null ? 0L : lpEventAttributes.baseAddress, bManualReset, bInitialState, lpName);
        return new HANDLE(result);
    }
    
    private static native boolean SetEvent(long hEvent);
    private static native boolean ResetEvent(long hEvent);
    
    public final static boolean SetEvent(HANDLE hEvent) {
        return SetEvent(hEvent.value);
    }
    
    public final static boolean ResetEvent(HANDLE hEvent) {
        return ResetEvent(hEvent.value);
    }
}
