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

import de.ibapl.jnhw.annotation.winapi.basetsd.BYTE;
import de.ibapl.jnhw.annotation.winapi.basetsd.DWORD;
import de.ibapl.jnhw.annotation.winapi.basetsd.WORD;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayout;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactory;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.util.winapi.memory.WinApiStdStructLayoutFactory;
import de.ibapl.jnhw.util.winapi.memory.WinApiStruct32;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/">winbase.h</a>
 * header.
 *
 *
 * @author aploese
 */
@Include("WinBase.h")
public abstract class Winbase {

    /**
     * Make sure the native lib is loaded
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-setfilecompletionnotificationmodes">FILE_SKIP_COMPLETION_PORT_ON_SUCCESS</a>
     * If some conditions are true, the I/O Manager does not queue a completion
     * entry to the port, when it would ordinarily do so.
     *
     */
    @Define
    public final static byte FILE_SKIP_COMPLETION_PORT_ON_SUCCESS = 0x1;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-setfilecompletionnotificationmodes">FILE_SKIP_SET_EVENT_ON_HANDLE</a>
     * The I/O Manager does not set the event for the file object if a request
     * returns with a success code, or the error returned is ERROR_PENDING and
     * the function that is called is not a synchronous function.
     *
     */
    @Define
    public final static byte FILE_SKIP_SET_EVENT_ON_HANDLE = 0x2;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror/">CE_RXOVER</a>
     * An input buffer overflow has occurred. There is either no room in the
     * input buffer, or a character was received after the end-of-file (EOF)
     * character.
     *
     */
    @Define
    public final static byte CE_RXOVER = 0x1;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror/">CE_OVERRUN</a>
     * A character-buffer overrun has occurred. The next character is lost.
     *
     */
    @Define
    public final static byte CE_OVERRUN = 0x2;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror/">CE_RXPARITY</a>
     * The hardware detected a parity error.
     *
     */
    @Define
    public final static byte CE_RXPARITY = 0x4;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror/">CE_FRAME</a>
     * The hardware detected a framing error.
     *
     */
    @Define
    public final static byte CE_FRAME = 0x8;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror/">CE_BREAK</a>
     * The hardware detected a break condition.
     *
     */
    @Define
    public final static byte CE_BREAK = 0x10;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">SETXOFF</a>
     * Causes transmission to act as if an XOFF character has been received.
     *
     */
    @Define
    public final static int SETXOFF = 1;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">SETXON</a>
     * Causes transmission to act as if an XON character has been received.
     *
     */
    @Define
    public final static int SETXON = 2;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">SETRTS</a>
     * Sends the RTS (request-to-send) signal.
     *
     */
    @Define
    public final static int SETRTS = 3;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">CLRRTS</a>
     * Clears the RTS (request-to-send) signal.
     *
     */
    @Define
    public final static int CLRRTS = 4;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">SETDTR</a>
     * Sends the DTR (data-terminal-ready) signal.
     *
     */
    @Define
    public final static int SETDTR = 5;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">CLRDTR</a>
     * Clears the DTR (data-terminal-ready) signal.
     *
     */
    @Define
    public final static int CLRDTR = 6;

    @Define
    public final static int RESETDEV = 7;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">SETBREAK</a>
     * Suspends character transmission and places the transmission line in a
     * break state until the ClearCommBreak function is called (or
     * EscapeCommFunction is called with the CLRBREAK extended function code).
     *
     */
    @Define
    public final static int SETBREAK = 8;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">CLRBREAK</a>
     * Restores character transmission and places the transmission line in a
     * nonbreak state. The CLRBREAK extended function code is identical to the
     * ClearCommBreak function.
     *
     */
    @Define
    public final static int CLRBREAK = 9;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommbreak">ClearCommBreak</a>
     * Restores character transmission for a specified communications device and
     * places the transmission line in a nonbreak state.
     *
     * @param hFile a handle to the communications device.
     *
     * @throws NullPointerException if hFile is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ClearCommBreak(HANDLE hFile) throws NativeErrorException {
        ClearCommBreak(HANDLE.getHandleValue(hFile));
    }

    private native static void ClearCommBreak(long ptrHFile) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror">ClearCommError</a>
     * Retrieves information about a communications error and reports the
     * current status of a communications device.
     *
     * @param hFile a handle to the communications device.
     * @param lpErrors A pointer to a variable that receives a mask indicating
     * the type of error. This parameter can be one or more of the following
     * values:
     * {@link CE_BREAK}, {@link CE_FRAME}, {@link CE_OVERRUN}, {@link CE_RXOVER}, {@link CE_RXPARITY}.
     * @param lpStat A pointer to a {@link COMSTAT} structure in which the
     * device's status information is returned. If this parameter is
     * {@code NULL}, no status information is returned.
     *
     * @throws NullPointerException if hFile is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void ClearCommError(HANDLE hFile, Int32_t lpErrors, COMSTAT lpStat) throws NativeErrorException {
        ClearCommError(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpErrors), AbstractNativeMemory.toUintptr_tOrNULL(lpStat));
    }

    private static native void ClearCommError(long ptrHFile, long ptrLpErrors, long ptrLpStat) throws NativeErrorException;
    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">DTR_CONTROL_DISABLE</a>
     * Disables the DTR line when the device is opened and leaves it disabled.
     *
     */
    @Define
    public final static byte DTR_CONTROL_DISABLE = 0x0;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">DTR_CONTROL_ENABLE</a>
     * Enables the DTR line when the device is opened and leaves it on.
     *
     */
    @Define
    public final static byte DTR_CONTROL_ENABLE = 0x1;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">DTR_CONTROL_HANDSHAKE</a>
     * Enables DTR handshaking. If handshaking is enabled, it is an error for
     * the application to adjust the line by using the EscapeCommFunction
     * function.
     *
     */
    @Define
    public final static byte DTR_CONTROL_HANDSHAKE = 0x2;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">RTS_CONTROL_DISABLE</a>
     * Disables the RTS line when the device is opened and leaves it disabled.
     *
     */
    @Define
    public final static byte RTS_CONTROL_DISABLE = 0x0;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">RTS_CONTROL_ENABLE</a>
     * Enables the RTS line when the device is opened and leaves it on.
     *
     */
    @Define
    public final static byte RTS_CONTROL_ENABLE = 0x1;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">RTS_CONTROL_HANDSHAKE</a>
     * Enables RTS handshaking.
     *
     */
    @Define
    public final static byte RTS_CONTROL_HANDSHAKE = 0x3;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">RTS_CONTROL_TOGGLE</a>
     * Specifies that the RTS line will be high if bytes are available for
     * transmission.
     *
     */
    @Define
    public final static byte RTS_CONTROL_TOGGLE = 0x4;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">NOPARITY</a>
     * No parity.
     *
     */
    @Define
    public final static byte NOPARITY = 0;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">ODDPARITY</a>
     * Odd parity.
     *
     */
    @Define
    public final static byte ODDPARITY = 1;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">EVENPARITY</a>
     * Even parity.
     *
     */
    @Define
    public final static byte EVENPARITY = 2;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">MARKPARITY</a>
     * Mark parity.
     *
     */
    @Define
    public final static byte MARKPARITY = 3;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">SPACEPARITY</a>
     * Space parity.
     *
     */
    @Define
    public final static byte SPACEPARITY = 4;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">ONESTOPBIT</a>
     * 1 stop bit.
     *
     */
    @Define
    public final static byte ONESTOPBIT = 0;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">ONE5STOPBITS</a>
     * 1.5 stop bits.
     *
     */
    @Define
    public final static byte ONE5STOPBITS = 1;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">TWOSTOPBITS</a>
     * 2 stop bits.
     *
     */
    @Define
    public final static byte TWOSTOPBITS = 2;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommmodemstatus/">MS_CTS_ON</a>
     * The CTS (clear-to-send) signal is on.
     *
     */
    @Define
    public final static int MS_CTS_ON = 0x10;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommmodemstatus/">MS_DSR_ON</a>
     * The DSR (data-set-ready) signal is on.
     *
     */
    @Define
    public final static int MS_DSR_ON = 0x20;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommmodemstatus/">MS_RING_ON</a>
     * The ring indicator signal is on.
     *
     */
    @Define
    public final static int MS_RING_ON = 0x40;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommmodemstatus/">MS_RLSD_ON</a>
     * The RLSD (receive-line-signal-detect) signal is on.
     *
     */
    @Define
    public final static int MS_RLSD_ON = 0x80;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction">EscapeCommFunction</a>
     * Directs the specified communications device to perform an extended
     * function.
     *
     * @param hFile a handle to the communications device.
     * @param dwFunc The extended function to be performed. This parameter can
     * be one of the following values:
     * {@link CLRBREAK}, {@link CLRDTR}, {@link CLRRTS}, {@link SETBREAK}, {@link SETDTR}, {@link SETRTS}, {@link SETXOFF}, {@link SETXON}.
     *
     * @throws NullPointerException if hFile is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void EscapeCommFunction(HANDLE hFile, int dwFunc) throws NativeErrorException {
        EscapeCommFunction(HANDLE.getHandleValue(hFile), dwFunc);
    }

    private static native void EscapeCommFunction(long ptrHFile, int dwFunc) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommmodemstatus">GetCommModemStatus</a>
     * Directs the specified communications device to perform an extended
     * function.
     *
     * @param hFile a handle to the communications device.
     * @param lpModemStat The extended function to be performed. This parameter
     * can be one of the following values: MS_CTS_ON MS_DSR_ON MS_RING_ON
     * MS_RLSD_ON
     *
     * @throws NullPointerException if hFile is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void GetCommModemStatus(HANDLE hFile, Int32_t lpModemStat) throws NativeErrorException {
        GetCommModemStatus(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpModemStat));
    }

    private static native void GetCommModemStatus(long ptrHFile, long ptrLpModemStat) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommstate">GetCommState</a>
     * Retrieves the current control settings for a specified communications
     * device.
     *
     * @param hFile a handle to the communications device.
     * @param lpDCB A pointer to a {@link DCB} structure that receives the
     * control settings information.
     *
     * @throws NullPointerException if hFile or lpDCB is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void GetCommState(HANDLE hFile, DCB lpDCB) throws NativeErrorException {
        GetCommModemStatus(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpDCB));
    }

    private static native void GetCommState(long ptrHFile, long ptrLpDCB) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommtimeouts">GetCommTimeouts</a>
     * Retrieves the time-out parameters for all read and write operations on a
     * specified communications device.
     *
     * @param hFile a handle to the communications device.
     * @param lpCommTimeouts a pointer to a {@link COMMTIMEOUTS} structure in
     * which the time-out information is returned.
     *
     * @throws NullPointerException if hFile or lpCommTimeouts is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void GetCommTimeouts(HANDLE hFile, COMMTIMEOUTS lpCommTimeouts) throws NativeErrorException {
        GetCommTimeouts(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpCommTimeouts));
    }

    private static native void GetCommTimeouts(long ptrHFile, long ptrLpCommTimeouts) throws NativeErrorException;
    @Define
    public final static int INFINITE = 0xffffffff;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/console/getstdhandle">STD_INPUT_HANDLE</a>
     * The standard input device. Initially, this is the console input buffer,
     * CONIN$.
     *
     */
    @Define
    public final static int STD_INPUT_HANDLE = -10;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/console/getstdhandle">STD_OUTPUT_HANDLE</a>
     * The standard output device. Initially, this is the active console screen
     * buffer, CONOUT$.
     *
     */
    @Define
    public final static int STD_OUTPUT_HANDLE = -11;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/console/getstdhandle">STD_ERROR_HANDLE</a>
     * The standard error device. Initially, this is the active console screen
     * buffer, CONOUT$.
     *
     */
    @Define
    public final static int STD_ERROR_HANDLE = -12;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-setcommbreak">SetCommBreak</a>
     * Suspends character transmission for a specified communications device and
     * places the transmission line in a break state until the ClearCommBreak
     * function is called.
     *
     * @param hFile a handle to the communications device.
     *
     * @throws NullPointerException if hFile is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void SetCommBreak(HANDLE hFile) throws NativeErrorException {
        SetCommBreak(HANDLE.getHandleValue(hFile));
    }

    private static native void SetCommBreak(long ptrHFile) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-setcommstate">SetCommState</a>
     * Configures a communications device according to the specifications in a
     * device-control block (a {@link DCB} structure).
     *
     * @param hFile a handle to the communications device.
     * @param lpDCB a pointer to a {@link DCB} structure that contains the
     * configuration information for the specified communications device.
     *
     * @throws NullPointerException if hFile or lpDCB is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void SetCommState(HANDLE hFile, DCB lpDCB) throws NativeErrorException {
        SetCommState(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpDCB));
    }

    private static native void SetCommState(long ptrHFile, long ptrLpDCB) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-setcommtimeouts">SetCommTimeouts</a>
     * Sets the time-out parameters for all read and write operations on a
     * specified communications device.
     *
     * @param hFile a handle to the communications device.
     * @param lpCommTimeouts a pointer to a {@link COMMTIMEOUTS} structure that
     * contains the new time-out values.
     *
     * @throws NullPointerException if hFile or lpCommTimeouts is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void SetCommTimeouts(HANDLE hFile, COMMTIMEOUTS lpCommTimeouts) throws NativeErrorException {
        SetCommTimeouts(HANDLE.getHandleValue(hFile), AbstractNativeMemory.toUintptr_t(lpCommTimeouts));
    }

    private static native void SetCommTimeouts(long ptrHFile, long ptrLpCommTimeouts) throws NativeErrorException;
    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobject/">WAIT_FAILED</a>
     * The specified object is a mutex object that was not released by the
     * thread that owned the mutex object before the owning thread terminated.
     * The function has failed. To get extended error information, call
     * GetLastError.
     * <br> This is usually done in the native code which throws a
     * NativeErrorExcepotion instead of passing this back.
     *
     */
    @Define
    public final static int WAIT_FAILED = 0xffffffff;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobject/">WAIT_OBJECT_0</a>
     * The state of the specified object is signaled.
     *
     */
    @Define
    public final static int WAIT_OBJECT_0 = Winnt.STATUS_WAIT_0;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobject/">WAIT_ABANDONED</a>
     *
     */
    @Define
    public final static int WAIT_ABANDONED = Winnt.STATUS_ABANDONED_WAIT_0;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobjectEx/">WAIT_IO_COMPLETION</a>
     * The state of the specified object is signaled.
     *
     */
    @Define
    public final static int WAIT_IO_COMPLETION = Winnt.STATUS_USER_APC;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_WRITE_THROUGH</a>
     * Write operations will not go through any intermediate cache, they will go
     * directly to disk.
     *
     */
    @Define
    public final static int FILE_FLAG_WRITE_THROUGH = 0x80000000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_OVERLAPPED</a>
     * The file or device is being opened or created for asynchronous I/O.
     *
     */
    @Define
    public final static int FILE_FLAG_OVERLAPPED = 0x40000000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_NO_BUFFERING</a>
     * The file or device is being opened with no system caching for data reads
     * and writes.
     *
     */
    @Define
    public final static int FILE_FLAG_NO_BUFFERING = 0x20000000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_RANDOM_ACCESS</a>
     * Access is intended to be random. The system can use this as a hint to
     * optimize file caching.
     *
     */
    @Define
    public final static int FILE_FLAG_RANDOM_ACCESS = 0x10000000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_SEQUENTIAL_SCAN</a>
     * Access is intended to be sequential from beginning to end.
     *
     */
    @Define
    public final static int FILE_FLAG_SEQUENTIAL_SCAN = 0x8000000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_DELETE_ON_CLOSE</a>
     * The file is to be deleted immediately after all of its handles are
     * closed, which includes the specified handle and any other open or
     * duplicated handles.
     *
     */
    @Define
    public final static int FILE_FLAG_DELETE_ON_CLOSE = 0x4000000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_BACKUP_SEMANTICS</a>
     * The file is being opened or created for a backup or restore operation.
     *
     */
    @Define
    public final static int FILE_FLAG_BACKUP_SEMANTICS = 0x2000000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_POSIX_SEMANTICS</a>
     * Access will occur according to POSIX rules.
     *
     */
    @Define
    public final static int FILE_FLAG_POSIX_SEMANTICS = 0x1000000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_SESSION_AWARE</a>
     * The file or device is being opened with session awareness.
     *
     */
    @Define
    public final static int FILE_FLAG_SESSION_AWARE = 0x800000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_OPEN_REPARSE_POINT</a>
     * Normal reparse point processing will not occur; CreateFile will attempt
     * to open the reparse point.
     *
     */
    @Define
    public final static int FILE_FLAG_OPEN_REPARSE_POINT = 0x200000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_OPEN_NO_RECALL</a>
     * The file data is requested, but it should continue to be located in
     * remote storage.
     *
     */
    @Define
    public final static int FILE_FLAG_OPEN_NO_RECALL = 0x100000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_ANONYMOUS</a>
     * Impersonates a client at the Anonymous impersonation level.
     * Winnt.SecurityAnonymous << 16
     */
    @Define
    public final static int SECURITY_ANONYMOUS = 0 << 16;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_IDENTIFICATION</a>
     * Impersonates a client at the Identification impersonation level.
     * Winnt.SecurityIdentification << 16
     */
    @Define
    public final static int SECURITY_IDENTIFICATION = 1 << 16;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_IMPERSONATION</a>
     * Impersonate a client at the impersonation level.
     * Winnt.SecurityImpersonation << 16
     */
    @Define
    public final static int SECURITY_IMPERSONATION = 2 << 16;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_DELEGATION</a>
     * Impersonates a client at the Delegation impersonation level.
     * Winnt.SecurityDelegation << 16
     */
    @Define
    public final static int SECURITY_DELEGATION = 3 << 16;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_CONTEXT_TRACKING</a>
     * he security tracking mode is dynamic.
     *
     */
    @Define
    public final static int SECURITY_CONTEXT_TRACKING = 0x40000;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_EFFECTIVE_ONLY</a>
     * Only the enabled aspects of the client's security context are available
     * to the server.
     *
     */
    @Define
    public final static int SECURITY_EFFECTIVE_ONLY = 0x80000;

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-commtimeouts">{@code structure
     * COMMTIMEOUTS}</a>.
     *
     */
    public final static class COMMTIMEOUTS extends WinApiStruct32 {

        public static class Layout extends StructLayout {

            public final static long ReadIntervalTimeout;
            public final static long ReadTotalTimeoutMultiplier;
            public final static long ReadTotalTimeoutConstant;
            public final static long WriteTotalTimeoutMultiplier;
            public final static long WriteTotalTimeoutConstant;
            public final static Alignment alignment;
            public final static int sizeof;

            static {
                WinApiStdStructLayoutFactory slf = new WinApiStdStructLayoutFactory(StructLayoutFactory.Type.STRUCT);
                ReadIntervalTimeout = slf.DWORD();
                ReadTotalTimeoutMultiplier = slf.DWORD();
                ReadTotalTimeoutConstant = slf.DWORD();
                WriteTotalTimeoutMultiplier = slf.DWORD();
                WriteTotalTimeoutConstant = slf.DWORD();
                sizeof = (int) slf.getSizeof();
                alignment = slf.getAlignment();
            }

        }

        public COMMTIMEOUTS(SetMem setMem) {
            super((OpaqueMemory32) null, 0, Layout.sizeof, setMem);
        }

        /**
         *
         * @return the native value of ReadIntervalTimeout.
         */
        @DWORD
        public long ReadIntervalTimeout() {
            return ACCESSOR_DWORD.DWORD_AsLong(this, Layout.ReadIntervalTimeout);
        }

        /**
         * @param ReadIntervalTimeout the value of ReadIntervalTimeout to be set
         * natively.
         */
        public void ReadIntervalTimeout(@DWORD long ReadIntervalTimeout) {
            ACCESSOR_DWORD.DWORD_FromLong(this, Layout.ReadIntervalTimeout, ReadIntervalTimeout);
        }

        /**
         *
         * @return the native value of ReadTotalTimeoutMultiplier.
         */
        @DWORD
        public long ReadTotalTimeoutMultiplier() {
            return ACCESSOR_DWORD.DWORD_AsLong(this, Layout.ReadTotalTimeoutMultiplier);
        }

        /**
         * @param ReadTotalTimeoutMultiplier the value of
         * ReadTotalTimeoutMultiplier to be set natively.
         */
        public void ReadTotalTimeoutMultiplier(@DWORD long ReadTotalTimeoutMultiplier) {
            ACCESSOR_DWORD.DWORD_FromLong(this, Layout.ReadTotalTimeoutMultiplier, ReadTotalTimeoutMultiplier);
        }

        /**
         *
         * @return the native value of ReadTotalTimeoutConstant.
         */
        @DWORD
        public long ReadTotalTimeoutConstant() {
            return ACCESSOR_DWORD.DWORD_AsLong(this, Layout.ReadTotalTimeoutConstant);
        }

        /**
         * @param ReadTotalTimeoutConstant the value of ReadTotalTimeoutConstant
         * to be set natively.
         */
        public void ReadTotalTimeoutConstant(@DWORD long ReadTotalTimeoutConstant) {
            ACCESSOR_DWORD.DWORD_FromLong(this, Layout.ReadTotalTimeoutConstant, ReadTotalTimeoutConstant);
        }

        /**
         *
         * @return the native value of WriteTotalTimeoutMultiplier.
         */
        @DWORD
        public long WriteTotalTimeoutMultiplier() {
            return ACCESSOR_DWORD.DWORD_AsLong(this, Layout.WriteTotalTimeoutMultiplier);
        }

        /**
         * @param WriteTotalTimeoutMultiplier the value of
         * WriteTotalTimeoutMultiplier to be set natively.
         */
        public void WriteTotalTimeoutMultiplier(@DWORD long WriteTotalTimeoutMultiplier) {
            ACCESSOR_DWORD.DWORD_FromLong(this, Layout.WriteTotalTimeoutMultiplier, WriteTotalTimeoutMultiplier);
        }

        /**
         *
         * @return the native value of WriteTotalTimeoutConstant.
         */
        @DWORD
        public long WriteTotalTimeoutConstant() {
            return ACCESSOR_DWORD.DWORD_AsLong(this, Layout.WriteTotalTimeoutConstant);

        }

        /**
         * @param WriteTotalTimeoutConstant the value of
         * WriteTotalTimeoutConstant to be set natively.
         */
        public void WriteTotalTimeoutConstant(@DWORD long WriteTotalTimeoutConstant) {
            ACCESSOR_DWORD.DWORD_FromLong(this, Layout.WriteTotalTimeoutConstant, WriteTotalTimeoutConstant);
        }

    }

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-comstat">{@code structure
     * COMSTAT}</a>.
     *
     */
    public static class COMSTAT extends WinApiStruct32 {

        public static class Layout extends StructLayout {

            public final static long bitfield_Offset;
            public final static int BF_0_1__fCtsHold;
            public final static int BF_1_1__fDsrHold;
            public final static int BF_2_1__fRlsdHold;
            public final static int BF_3_1__fXoffHold;
            public final static int BF_4_1__fXoffSent;
            public final static int BF_5_1__fEof;
            public final static int BF_6_1__fTxim;
            public final static int BF_7_25__fReserved;
            public final static long cbInQue;
            public final static long cbOutQue;
            public final static Alignment alignment;
            public final static int sizeof;

            static {
                WinApiStdStructLayoutFactory slf = new WinApiStdStructLayoutFactory(StructLayoutFactory.Type.STRUCT);
                bitfield_Offset = slf.DWORD();
                BF_0_1__fCtsHold = 0;
                BF_1_1__fDsrHold = 1;
                BF_2_1__fRlsdHold = 2;
                BF_3_1__fXoffHold = 3;
                BF_4_1__fXoffSent = 4;
                BF_5_1__fEof = 5;
                BF_6_1__fTxim = 6;
                BF_7_25__fReserved = 7;
                cbInQue = slf.DWORD();
                cbOutQue = slf.DWORD();
                sizeof = (int) slf.getSizeof();
                alignment = slf.getAlignment();
            }

        }

        public COMSTAT(SetMem setMem) {
            super((OpaqueMemory32) null, 0, Layout.sizeof, setMem);
        }

        /**
         * @return the native value of fCtsHold.
         */
        public boolean fCtsHold() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_0_1__fCtsHold);
        }

        /**
         * @return the native value of fDsrHold.
         */
        public boolean fDsrHold() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_1_1__fDsrHold);
        }

        /**
         * @return the native value of fRlsdHold.
         */
        public boolean fRlsdHold() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_2_1__fRlsdHold);
        }

        /**
         * @return the native value of fXoffHold.
         */
        public boolean fXoffHold() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_3_1__fXoffHold);
        }

        /**
         * @return the native value of fXoffSent.
         */
        public boolean fXoffSent() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_4_1__fXoffSent);
        }

        /**
         *
         * @return the native value of fEof.
         */
        public boolean fEof() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_5_1__fEof);
        }

        /**
         *
         * @return the native value of fTxim.
         */
        public boolean fTxim() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_6_1__fTxim);
        }

        /**
         *
         * @return the native value of fReserved.
         */
        public int fReserved() {
            return ACCESSOR_DWORD.getBits(this, Layout.bitfield_Offset, Layout.BF_7_25__fReserved, 25);
        }

        /**
         *
         * @return the native value of cbInQue.
         */
        @DWORD
        public int cbInQue() {
            return ACCESSOR_DWORD.DWORD(this, Layout.cbInQue);
        }

        /**
         *
         * @return the native value of cbOutQue.
         */
        @DWORD
        public int cbOutQue() {
            return ACCESSOR_DWORD.DWORD(this, Layout.cbOutQue);
        }
    }

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb">{@code structure
     * DCB}</a>.
     *
     */
    public final static class DCB extends WinApiStruct32 {

        public static class Layout extends StructLayout {

            public final static long DCBlength;
            public final static long BaudRate;
            public final static long bitfield_Offset;
            public final static int BF_0_1__fBinary;
            public final static int BF_1_1__fParity;
            public final static int BF_2_1__fOutxCtsFlow;
            public final static int BF_3_1__fOutxDsrFlow;
            public final static int BF_4_2__fDtrControl;
            public final static int BF_6_1__fDsrSensitivity;
            public final static int BF_7_1__fTXContinueOnXoff;
            public final static int BF_8_1__fOutX;
            public final static int BF_9_1__fInX;
            public final static int BF_10_1__fErrorChar;
            public final static int BF_11_1__fNull;
            public final static int BF_12_2__fRtsControl;
            public final static int BF_14_1__fAbortOnError;
            public final static int BF_15_17__fDummy2;
            public final static long wReserved;
            public final static long XonLim;
            public final static long XoffLim;
            public final static long ByteSize;
            public final static long Parity;
            public final static long StopBits;
            public final static long XonChar;
            public final static long XoffChar;
            public final static long ErrorChar;
            public final static long EofChar;
            public final static long EvtChar;
            public final static long wReserved1;
            public final static Alignment alignment;
            public final static int sizeof;

            static {
                WinApiStdStructLayoutFactory slf = new WinApiStdStructLayoutFactory(StructLayoutFactory.Type.STRUCT);
                DCBlength = slf.DWORD();
                BaudRate = slf.DWORD();
                bitfield_Offset = slf.DWORD();
                BF_0_1__fBinary = 0;
                BF_1_1__fParity = 1;
                BF_2_1__fOutxCtsFlow = 2;
                BF_3_1__fOutxDsrFlow = 3;
                BF_4_2__fDtrControl = 4;
                BF_6_1__fDsrSensitivity = 6;
                BF_7_1__fTXContinueOnXoff = 7;
                BF_8_1__fOutX = 8;
                BF_9_1__fInX = 9;
                BF_10_1__fErrorChar = 10;
                BF_11_1__fNull = 11;
                BF_12_2__fRtsControl = 12;
                BF_14_1__fAbortOnError = 14;
                BF_15_17__fDummy2 = 15;
                wReserved = slf.WORD();
                XonLim = slf.WORD();
                XoffLim = slf.WORD();
                ByteSize = slf.BYTE();
                Parity = slf.BYTE();
                StopBits = slf.BYTE();
                XonChar = slf.int8_t();
                XoffChar = slf.int8_t();
                ErrorChar = slf.int8_t();
                EofChar = slf.int8_t();
                EvtChar = slf.int8_t();
                wReserved1 = slf.WORD();
                sizeof = (int) slf.getSizeof();
                alignment = slf.getAlignment();
            }

        }

        public DCB(SetMem setMem) {
            super(null, 0, Layout.sizeof, setMem);
            //set the current size explicitly.
            DCBlength(Layout.sizeof);
        }

        /**
         * @param DCBlength the value of DCBlength to be set natively.
         */
        public void DCBlength(@DWORD int DCBlength) {
            ACCESSOR_DWORD.DWORD(this, Layout.DCBlength, DCBlength);
        }

        /**
         *
         * @return the native value of DCBlength.
         */
        @DWORD
        public int DCBlength() {
            return ACCESSOR_DWORD.DWORD(this, Layout.DCBlength);
        }

        /**
         *
         * @return the native value of BaudRate.
         */
        @DWORD
        public int BaudRate() {
            return ACCESSOR_DWORD.DWORD(this, Layout.BaudRate);
        }

        /**
         * @param BaudRate the value of BaudRate to be set natively.
         */
        public void BaudRate(@DWORD int BaudRate) {
            ACCESSOR_DWORD.DWORD(this, Layout.BaudRate, BaudRate);
        }

        /**
         *
         * @return the native value of fBinary.
         */
        public boolean fBinary() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_0_1__fBinary);
        }

        /**
         *
         * @return the native value of fParity.
         */
        public boolean fParity() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_1_1__fParity);
        }

        /**
         *
         * @return the native value of fOutxCtsFlow.
         */
        public boolean fOutxCtsFlow() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_2_1__fOutxCtsFlow);
        }

        /**
         * @param fOutxCtsFlow the value of fOutxCtsFlow to be set natively.
         */
        public void fOutxCtsFlow(boolean fOutxCtsFlow) {
            ACCESSOR_DWORD.setBitAt(this, Layout.bitfield_Offset, Layout.BF_2_1__fOutxCtsFlow, fOutxCtsFlow);
        }

        /**
         *
         * @return the native value of fOutxDsrFlow.
         */
        public boolean fOutxDsrFlow() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_3_1__fOutxDsrFlow);
        }

        /**
         * Values: DTR_CONTROL_DISABLE DTR_CONTROL_ENABLE DTR_CONTROL_HANDSHAKE
         *
         * @return the native value of fDtrControl.
         */
        public byte fDtrControl() {
            return (byte) ACCESSOR_DWORD.getBits(this, Layout.bitfield_Offset, Layout.BF_4_2__fDtrControl, 2);
        }

        /**
         *
         * @return the native value of fDsrSensitivity.
         */
        public boolean fDsrSensitivity() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_6_1__fDsrSensitivity);
        }

        /**
         *
         * @return the native value of fTXContinueOnXoff.
         */
        public boolean fTXContinueOnXoff() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_7_1__fTXContinueOnXoff);
        }

        /**
         *
         * @return the native value of fOutX.
         */
        public boolean fOutX() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_8_1__fOutX);
        }

        /**
         * @param fOutX the value of fOutX to be set natively.
         */
        public void fOutX(boolean fOutX) {
            ACCESSOR_DWORD.setBitAt(this, Layout.bitfield_Offset, Layout.BF_8_1__fOutX, fOutX);
        }

        /**
         *
         * @return the native value of fInX.
         */
        public boolean fInX() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_9_1__fInX);
        }

        /**
         * @param fInX the value of fInX to be set natively.
         */
        public void fInX(boolean fInX) {
            ACCESSOR_DWORD.setBitAt(this, Layout.bitfield_Offset, Layout.BF_9_1__fInX, fInX);
        }

        /**
         *
         * @return the native value of fErrorChar.
         */
        public boolean fErrorChar() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_10_1__fErrorChar);
        }

        /**
         *
         * @return the native value of fNull.
         */
        public boolean fNull() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_11_1__fNull);
        }

        /**
         * Values: RTS_CONTROL_DISABLE RTS_CONTROL_ENABLE RTS_CONTROL_HANDSHAKE
         * RTS_CONTROL_TOGGLE
         *
         * @return the native value of fRtsControl.
         */
        public byte fRtsControl() {
            return (byte) ACCESSOR_DWORD.getBits(this, Layout.bitfield_Offset, Layout.BF_12_2__fRtsControl, 2);
        }

        /**
         * @param fRtsControl the value of fRtsControl to be set natively.
         */
        public void fRtsControl(byte fRtsControl) {
            ACCESSOR_DWORD.setBits(this, Layout.bitfield_Offset, Layout.BF_12_2__fRtsControl, 2, fRtsControl);
        }

        /**
         *
         * @return the native value of fAbortOnError.
         */
        public boolean fAbortOnError() {
            return ACCESSOR_DWORD.getBitAt(this, Layout.bitfield_Offset, Layout.BF_14_1__fAbortOnError);
        }

        /**
         *
         * @return the native value of fDummy2.
         */
        public int fDummy2() {
            return ACCESSOR_DWORD.getBits(this, Layout.bitfield_Offset, Layout.BF_15_17__fDummy2, 17);
        }

        /**
         *
         * @return the native value of wReserved.
         */
        @WORD
        public short wReserved() {
            return ACCESSOR_WORD.WORD(this, Layout.wReserved);
        }

        /**
         *
         * @return the native value of XonLim.
         */
        @WORD
        public short XonLim() {
            return ACCESSOR_WORD.WORD(this, Layout.XoffLim);
        }

        /**
         *
         * @return the native value of XoffLim.
         */
        @WORD
        public short XoffLim() {
            return ACCESSOR_WORD.WORD(this, Layout.XoffLim);
        }

        /**
         *
         * @return the native value of ByteSize.
         */
        @BYTE
        public byte ByteSize() {
            return ACCESSOR_BYTE.BYTE(this, Layout.ByteSize);
        }

        /**
         * @param ByteSize the value of ByteSize to be set natively.
         */
        public void ByteSize(@BYTE byte ByteSize) {
            ACCESSOR_BYTE.BYTE(this, Layout.ByteSize, ByteSize);
        }

        /**
         * Values: EVENPARITY MARKPARITY NOPARITY ODDPARITY SPACEPARITY
         *
         * @return the native value of Parity.
         */
        @BYTE
        public byte Parity() {
            return ACCESSOR_BYTE.BYTE(this, Layout.Parity);
        }

        /**
         * @param Parity the value of Parity to be set natively.
         */
        public void Parity(@BYTE byte Parity) {
            ACCESSOR_BYTE.BYTE(this, Layout.Parity, Parity);
        }

        /**
         * Values: ONESTOPBIT ONE5STOPBITS TWOSTOPBITS
         *
         * @return the native value of StopBits.
         */
        @BYTE
        public byte StopBits() {
            return ACCESSOR_BYTE.BYTE(this, Layout.StopBits);
        }

        /**
         * @param StopBits the value of StopBits to be set natively.
         */
        public void StopBits(@BYTE byte StopBits) {
            ACCESSOR_BYTE.BYTE(this, Layout.StopBits, StopBits);
        }

        /**
         *
         * @return the native value of XonChar.
         */
        public char XonChar() {
            return (char) MEM_ACCESS.int8_t(this, Layout.XonChar);
        }

        /**
         * @param XonChar the value of XonChar to be set natively.
         */
        public void XonChar(char XonChar) {
            MEM_ACCESS.int8_t(this, Layout.XonChar, (byte) XonChar);
        }

        /**
         *
         * @return the native value of XoffChar.
         */
        public char XoffChar() {
            return (char) MEM_ACCESS.int8_t(this, Layout.XoffChar);
        }

        /**
         * @param XoffChar the value of XoffChar to be set natively.
         */
        public void XoffChar(char XoffChar) {
            MEM_ACCESS.int8_t(this, Layout.XoffChar, (byte) XoffChar);
        }

        /**
         *
         * @return the native value of ErrorChar.
         */
        public char ErrorChar() {
            return (char) MEM_ACCESS.int8_t(this, Layout.ErrorChar);
        }

        /**
         *
         * @return the native value of EofChar.
         */
        public char EofChar() {
            return (char) MEM_ACCESS.int8_t(this, Layout.EofChar);
        }

        /**
         * @return the native value of EvtChar.
         */
        public char EvtChar() {
            return (char) MEM_ACCESS.int8_t(this, Layout.EvtChar);
        }

        /**
         *
         * @return the native value of wReserved1.
         */
        public short wReserved1() {
            return ACCESSOR_WORD.WORD(this, Layout.wReserved1);
        }

    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-setfilecompletionnotificationmodes">SetFileCompletionNotificationModes</a>
     * Sets the notification modes for a file handle, allowing you to specify
     * how completion notifications work for the specified file.
     *
     * @param hFile
     * @param uFlags
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    //TODO Test
    public final static void SetFileCompletionNotificationModes(HANDLE hFile, byte uFlags) throws NativeErrorException {
        SetFileCompletionNotificationModes(HANDLE.getHandleValue(hFile), uFlags);
    }

    private static native void SetFileCompletionNotificationModes(long ptrHFile, byte uFlags) throws NativeErrorException;

    /**
     * *
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-bindiocompletioncallback">BindIoCompletionCallback</a>
     * Associates the I/O completion port owned by the thread pool with the
     * specified file handle.
     *
     * @param FileHandle
     * @param Function
     * @param Flags
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    //TODO Test
    public final static void BindIoCompletionCallback(HANDLE FileHandle, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE Function, int Flags) throws NativeErrorException {
        BindIoCompletionCallback(HANDLE.getHandleValue(FileHandle), NativeFunctionPointer.toUintptr_t(Function), Flags);
    }

    private static native void BindIoCompletionCallback(long ptrFileHandle, long ptrFunction, int Flags) throws NativeErrorException;
}
