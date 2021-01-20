/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exceptions.NativeErrorException;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import de.ibapl.jnhw.winapi.Winnt.ArrayOfHandle;

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
     * @throws NullPointerException if hHandle is {@code null}.
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
     * @throws NullPointerException if hHandle is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void SetEvent(HANDLE hEvent) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitformultipleobjects">WaitForSingleObject</a>
     * Waits until one or all of the specified objects are in the signaled state
     * or the time-out interval elapses.
     *
     * @param lpHandles An array of object handles.
     * @param bWaitAll If this parameter is TRUE, the function returns when the
     * state of all objects in the lpHandles array is signaled. If FALSE, the
     * function returns when the state of any one of the objects is set to
     * signaled. In the latter case, the return value indicates the object whose
     * state caused the function to return.
     * @param dwMilliseconds the time-out interval, in milliseconds.
     * @return If the function succeeds, the return value indicates the event
     * that caused the function to return. It can be one of the following
     * values. (Note that WAIT_OBJECT_0 is defined as 0 and WAIT_ABANDONED_0 is
     * defined as 0x00000080L.)
     *
     * @throws NullPointerException if hHandle is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static long WaitForMultipleObjects(ArrayOfHandle lpHandles, boolean bWaitAll, long dwMilliseconds) throws NativeErrorException {
        if (lpHandles == null) {
            throw new NullPointerException("lpHandles = null");
        }
        if (dwMilliseconds < 0) {
            throw new IllegalArgumentException("dwMilliseconds < 0");
        }
        return WaitForMultipleObjects_ArgsOK(lpHandles.length, lpHandles, bWaitAll, dwMilliseconds);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitformultipleobjectsex">WaitForSingleObjectEx</a>
     * Waits until the specified object is in the signaled state, an I/O
     * completion routine or asynchronous procedure call (APC) is queued to the
     * thread, or the time-out interval elapses.
     *
     * @param lpHandles An array of object handles.
     * @param bWaitAll If this parameter is TRUE, the function returns when the
     * state of all objects in the lpHandles array is signaled. If FALSE, the
     * function returns when the state of any one of the objects is set to
     * signaled. In the latter case, the return value indicates the object whose
     * state caused the function to return.
     * @param dwMilliseconds the time-out interval, in milliseconds.
     * @param bAlertable If this parameter is TRUE and the thread is in the
     * waiting state, the function returns when the system queues an I/O
     * completion routine or APC, and the thread runs the routine or function.
     * Otherwise, the function does not return, and the completion routine or
     * APC function is not executed.
     *
     * @return If the function succeeds, the return value indicates the event
     * that caused the function to return. It can be one of the following
     * values. (Note that WAIT_OBJECT_0 is defined as 0 and WAIT_ABANDONED_0 is
     * defined as 0x00000080L.)
     *
     * @throws NullPointerException if hHandle is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static long WaitForMultipleObjectsEx(ArrayOfHandle lpHandles, boolean bWaitAll, long dwMilliseconds, boolean bAlertable) throws NativeErrorException {
        if (lpHandles == null) {
            throw new NullPointerException("lpHandles = null");
        }
        if (dwMilliseconds < 0) {
            throw new IllegalArgumentException("dwMilliseconds < 0");
        }
        return WaitForMultipleObjectsEx_ArgsOK(lpHandles.length, lpHandles, bWaitAll, dwMilliseconds, bAlertable);
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobject">WaitForSingleObject</a>
     * Waits until the specified object is in the signaled state or the time-out
     * interval elapses.
     *
     * @param hHandle A handle to the object.
     * @param dwMilliseconds the time-out interval, in milliseconds.
     * @return on succes one of WAIT_ABANDONED, WAIT_OBJECT_0 or WAIT_TIMEOUT.
     *
     * @throws NullPointerException if hHandle is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native long WaitForSingleObject(HANDLE hHandle, long dwMilliseconds) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobjectex">WaitForSingleObjectEx</a>
     * Waits until the specified object is in the signaled state, an I/O
     * completion routine or asynchronous procedure call (APC) is queued to the
     * thread, or the time-out interval elapses.
     *
     * @param hHandle A handle to the object.
     * @param dwMilliseconds the time-out interval, in milliseconds.
     * @param bAlertable If this parameter is TRUE and the thread is in the
     * waiting state, the function returns when the system queues an I/O
     * completion routine or APC, and the thread runs the routine or function.
     * Otherwise, the function does not return, and the completion routine or
     * APC function is not executed.
     *
     * @return on succes one of WAIT_ABANDONED, WAIT_OBJECT_0 or WAIT_TIMEOUT.
     *
     * @throws NullPointerException if hHandle is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native long WaitForSingleObjectEx(HANDLE hHandle, long dwMilliseconds, boolean bAlertable) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-sleepex">SleepEx</a>
     * Sets the specified event object to the signaled state.
     *
     * @param dwMilliseconds The time interval for which execution is to be
     * suspended, in milliseconds.
     *
     * @param bAlertable enable/disable APC.
     * @return The return value is zero if the specified time interval expired.
     *
     * The return value is WAIT_IO_COMPLETION if the function returned due to
     * one or more I/O completion callback functions.
     *
     */
    public final static native long SleepEx(long dwMilliseconds, boolean bAlertable);

    private static native long WaitForMultipleObjects_ArgsOK(int nCount, ArrayOfHandle lpHandles, boolean bWaitAll, long dwMilliseconds) throws NativeErrorException;

    private static native long WaitForMultipleObjectsEx_ArgsOK(int nCount, ArrayOfHandle lpHandles, boolean bWaitAll, long dwMilliseconds, boolean bAlertable) throws NativeErrorException;
}
