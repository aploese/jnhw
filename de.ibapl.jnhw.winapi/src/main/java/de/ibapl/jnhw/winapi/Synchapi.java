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

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/">synchapi.h</a>
 * header.
 *
 *
 * @author aploese
 */
@Include("synchapi.h")
public abstract class Synchapi {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-createeventw">CreateEventW</a>
     * Creates or opens a named or unnamed event object.
     *
     * @param lpEventAttributes a pointer to a SECURITY_ATTRIBUTES structure. If
     * this parameter is NULL, the handle cannot be inherited by child
     * processes.
     * @param bManualReset If this parameter is TRUE, the function creates a
     * manual-reset event object, which requires the use of the ResetEvent
     * function to set the event state to nonsignaled. If this parameter is
     * FALSE, the function creates an auto-reset event object, and system
     * automatically resets the event state to nonsignaled after a single
     * waiting thread has been released.
     * @param bInitialState If this parameter is TRUE, the initial state of the
     * event object is signaled; otherwise, it is nonsignaled.
     * @param lpName The name of the event object. The name is limited to
     * MAX_PATH characters. Name comparison is case sensitive. If lpName is
     * NULL, the event object is created without a name.
     * @return If the function succeeds, the return value is a handle to the
     * event object.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native HANDLE CreateEventW(SECURITY_ATTRIBUTES lpEventAttributes, boolean bManualReset, boolean bInitialState, String lpName) throws NativeErrorException;

    public final static native boolean HAVE_SYNCHAPI_H();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-resetevent">ResetEvent</a>
     * Sets the specified event object to the nonsignaled state.
     *
     * @param hEvent A handle to the object.
     *
     * @throws NullPointerException if hHandle is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void ResetEvent(HANDLE hEvent) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-setevent">SetEvent</a>
     * Sets the specified event object to the signaled state.
     *
     * @param hEvent A handle to the object.
     *
     * @throws NullPointerException if hHandle is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void SetEvent(HANDLE hEvent) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobject">WaitForSingleObject</a>
     * Waits until the specified object is in the signaled state or the time-out
     * interval elapses.
     *
     * @param hHandle A handle to the object.
     * @param dwMilliseconds the time-out interval, in milliseconds.
     * @return on succes one of WAIT_ABANDONED, WAIT_OBJECT_0 or WAIT_TIMEOUT.
     *
     * @throws NullPointerException if hHandle is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native long WaitForSingleObject(HANDLE hHandle, long dwMilliseconds) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-sleepex">SleepEx</a>
     * Sets the specified event object to the signaled state.
     *
     * @param dwMilliseconds The time interval for which execution is to be
     * suspended, in milliseconds.
     *
     * @param bAlertable enable/disable APC.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void SleepEx(long dwMilliseconds, boolean bAlertable) throws NativeErrorException;

}
