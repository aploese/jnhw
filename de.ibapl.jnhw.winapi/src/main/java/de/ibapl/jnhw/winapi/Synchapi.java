/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.JnhwMh_BL___A;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___A_BL_BL__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_uI___A_uI;
import de.ibapl.jnhw.common.downcall.JnhwMh_uI___A_uI_BL;
import de.ibapl.jnhw.common.downcall.JnhwMh_uI__uI__A_BL_uI;
import de.ibapl.jnhw.common.downcall.JnhwMh_uI__uI__A_BL_uI_BL;
import de.ibapl.jnhw.common.downcall.JnhwMh_uL__uI_BL;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.util.winapi.Kernel32Loader;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Winnt.ArrayOfHandle;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

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

    private final static JnhwMh_MA___A_BL_BL__A.ExceptionErased CreateEventW = JnhwMh_MA___A_BL_BL__A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "CreateEventW",
            WinApiDataType.HANDLE,
            WinApiDataType.LPSECURITY_ATTRIBUTES,
            WinApiDataType.BOOL,
            WinApiDataType.BOOL,
            WinApiDataType.LPCWSTR,
            0L);//Just a pointer with length 0!

    private final static JnhwMh_BL___A.ExceptionErased ResetEvent = JnhwMh_BL___A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "ResetEvent",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE);

    private final static JnhwMh_BL___A.ExceptionErased SetEvent = JnhwMh_BL___A.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "SetEvent",
            WinApiDataType.BOOL,
            WinApiDataType.HANDLE);

    private final static JnhwMh_uL__uI_BL.ExceptionErased SleepEx = JnhwMh_uL__uI_BL.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "SleepEx",
            WinApiDataType.DWORD,
            WinApiDataType.DWORD,
            WinApiDataType.BOOL);

    private final static JnhwMh_uI__uI__A_BL_uI.ExceptionErased WaitForMultipleObjects = JnhwMh_uI__uI__A_BL_uI.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "WaitForMultipleObjects",
            WinApiDataType.DWORD,
            WinApiDataType.DWORD,
            WinApiDataType.const_HANDLE_pointer,
            WinApiDataType.BOOL,
            WinApiDataType.DWORD);

    private final static JnhwMh_uI__uI__A_BL_uI_BL.ExceptionErased WaitForMultipleObjectsEx = JnhwMh_uI__uI__A_BL_uI_BL.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "WaitForMultipleObjectsEx",
            WinApiDataType.DWORD,
            WinApiDataType.DWORD,
            WinApiDataType.const_HANDLE_pointer,
            WinApiDataType.BOOL,
            WinApiDataType.DWORD,
            WinApiDataType.BOOL);

    private final static JnhwMh_uI___A_uI.ExceptionErased WaitForSingleObject = JnhwMh_uI___A_uI.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "WaitForSingleObject",
            WinApiDataType.DWORD,
            WinApiDataType.HANDLE,
            WinApiDataType.DWORD);

    private final static JnhwMh_uI___A_uI_BL.ExceptionErased WaitForSingleObjectEx = JnhwMh_uI___A_uI_BL.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "WaitForSingleObjectEx",
            WinApiDataType.DWORD,
            WinApiDataType.HANDLE,
            WinApiDataType.DWORD,
            WinApiDataType.BOOL);

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
    public final static HANDLE CreateEventW(SECURITY_ATTRIBUTES lpEventAttributes, boolean bManualReset, boolean bInitialState, String lpName) throws NativeErrorException {
        try (Arena arena = Arena.ofConfined()) {
            MemorySegment result = CreateEventW.invoke_MA___P_BL_BL__P(
                    lpEventAttributes != null ? lpEventAttributes : Pointer.NULL,
                    bManualReset,
                    bInitialState,
                    lpName != null ? WinDef.LPWSTR.wrap(lpName, true, arena) : Pointer.NULL);
            if (result.address() == 0L) {
                throw new NativeErrorException(Errhandlingapi.GetLastError());
            }
            return HANDLE.of(result);
        }
    }

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
    public final static void ResetEvent(HANDLE hEvent) throws NativeErrorException {
        if (!ResetEvent.invoke_BL___P(hEvent)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

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
    public final static void SetEvent(HANDLE hEvent) throws NativeErrorException {
        if (!SetEvent.invoke_BL___P(hEvent)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }

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
    public final static long SleepEx(long dwMilliseconds, boolean bAlertable) {
        if ((dwMilliseconds < 0) && (dwMilliseconds != Winbase.INFINITE)) {
            throw new IllegalArgumentException("dwMilliseconds < 0");
        }
        return SleepEx.invoke_uL__uI_BL((int) dwMilliseconds, bAlertable);
    }

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
        if ((dwMilliseconds < 0) && (dwMilliseconds != Winbase.INFINITE)) {
            throw new IllegalArgumentException("dwMilliseconds < 0");
        }
        return WaitForMultipleObjects.invoke_uL__uI__P_BL_uI(
                lpHandles.length,
                lpHandles,
                bWaitAll,
                (int) dwMilliseconds);
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
    public final static int WaitForMultipleObjectsEx(ArrayOfHandle lpHandles, boolean bWaitAll, long dwMilliseconds, boolean bAlertable) throws NativeErrorException {
        if ((dwMilliseconds < 0) && (dwMilliseconds != Winbase.INFINITE)) {
            throw new IllegalArgumentException("dwMilliseconds < 0");
        }
        return WaitForMultipleObjectsEx.invoke_uI__uI__P_BL_uI_BL(
                lpHandles.length,
                lpHandles,
                bWaitAll,
                (int) dwMilliseconds,
                bAlertable);
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
    public final static int WaitForSingleObject(HANDLE hHandle, long dwMilliseconds) throws NativeErrorException {
        if ((dwMilliseconds < 0) && (dwMilliseconds != Winbase.INFINITE)) {
            throw new IllegalArgumentException("dwMilliseconds < 0");
        }
        return WaitForSingleObject.invoke_uI___P_uI(
                hHandle,
                (int) dwMilliseconds);
    }

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
    public final static int WaitForSingleObjectEx(HANDLE hHandle, long dwMilliseconds, boolean bAlertable) throws NativeErrorException {
        if ((dwMilliseconds < 0) && (dwMilliseconds != Winbase.INFINITE)) {
            throw new IllegalArgumentException("dwMilliseconds < 0");
        }
        return WaitForSingleObjectEx.invoke_uI___P_uI_BL(
                hHandle,
                (int) dwMilliseconds,
                bAlertable);
    }

}
