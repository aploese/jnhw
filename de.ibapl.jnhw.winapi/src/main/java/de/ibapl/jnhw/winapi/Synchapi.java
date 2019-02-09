/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 *
 * @author aploese
 */
public abstract class Synchapi {

    public final static native int WaitForSingleObject(HANDLE hHandle, long dwMilliseconds) throws NativeErrorException;

    public final static native HANDLE CreateEventW(SECURITY_ATTRIBUTES lpEventAttributes, boolean bManualReset, boolean bInitialState, String lpName) throws NativeErrorException;
}
