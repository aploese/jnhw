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

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.references.IntRef;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
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
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-setfilecompletionnotificationmodes">FILE_SKIP_SET_EVENT_ON_HANDLE</a>
     * The I/O Manager does not set the event for the file object if a request
     * returns with a success code, or the error returned is ERROR_PENDING and
     * the function that is called is not a synchronous function.
     *
     * @return the native symbolic constant of FILE_SKIP_SET_EVENT_ON_HANDLE.
     */
    @Define
    public final static native byte FILE_SKIP_SET_EVENT_ON_HANDLE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-setfilecompletionnotificationmodes">FILE_SKIP_COMPLETION_PORT_ON_SUCCESS</a>
     * If some conditions are true, the I/O Manager does not queue a completion
     * entry to the port, when it would ordinarily do so.
     *
     * @return the native symbolic constant of
     * FILE_SKIP_COMPLETION_PORT_ON_SUCCESS.
     */
    @Define
    public final static native byte FILE_SKIP_COMPLETION_PORT_ON_SUCCESS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror/">CE_BREAK</a>
     * The hardware detected a break condition.
     *
     * @return the native symbolic constant of CE_BREAK.
     */
    @Define
    public final static native byte CE_BREAK();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror/">CE_FRAME</a>
     * The hardware detected a framing error.
     *
     * @return the native symbolic constant of CE_FRAME.
     */
    @Define
    public final static native byte CE_FRAME();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror/">CE_OVERRUN</a>
     * A character-buffer overrun has occurred. The next character is lost.
     *
     * @return the native symbolic constant of CE_OVERRUN.
     */
    @Define
    public final static native byte CE_OVERRUN();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror/">CE_RXOVER</a>
     * An input buffer overflow has occurred. There is either no room in the
     * input buffer, or a character was received after the end-of-file (EOF)
     * character.
     *
     * @return the native symbolic constant of CE_RXOVER.
     */
    @Define
    public final static native byte CE_RXOVER();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-clearcommerror/">CE_RXPARITY</a>
     * The hardware detected a parity error.
     *
     * @return the native symbolic constant of CE_RXPARITY.
     */
    @Define
    public final static native byte CE_RXPARITY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">CLRBREAK</a>
     * Restores character transmission and places the transmission line in a
     * nonbreak state. The CLRBREAK extended function code is identical to the
     * ClearCommBreak function.
     *
     * @return the native symbolic constant of CLRBREAK.
     */
    @Define
    public final static native int CLRBREAK();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">CLRDTR</a>
     * Clears the DTR (data-terminal-ready) signal.
     *
     * @return the native symbolic constant of CLRDTR.
     */
    @Define
    public final static native int CLRDTR();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">CLRRTS</a>
     * Clears the RTS (request-to-send) signal.
     *
     * @return the native symbolic constant of CLRRTS.
     */
    @Define
    public final static native int CLRRTS();

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
    public final native static void ClearCommBreak(HANDLE hFile) throws NativeErrorException;

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
    public final static native void ClearCommError(HANDLE hFile, IntRef lpErrors, COMSTAT lpStat) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">DTR_CONTROL_DISABLE</a>
     * Disables the DTR line when the device is opened and leaves it disabled.
     *
     * @return the native symbolic constant of DTR_CONTROL_DISABLE.
     */
    @Define
    public final static native byte DTR_CONTROL_DISABLE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">DTR_CONTROL_ENABLE</a>
     * Enables the DTR line when the device is opened and leaves it on.
     *
     * @return the native symbolic constant of DTR_CONTROL_ENABLE.
     */
    @Define
    public final static native byte DTR_CONTROL_ENABLE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">DTR_CONTROL_HANDSHAKE</a>
     * Enables DTR handshaking. If handshaking is enabled, it is an error for
     * the application to adjust the line by using the EscapeCommFunction
     * function.
     *
     * @return the native symbolic constant of DTR_CONTROL_HANDSHAKE.
     */
    @Define
    public final static native byte DTR_CONTROL_HANDSHAKE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">EVENPARITY</a>
     * Even parity.
     *
     * @return the native symbolic constant of EVENPARITY.
     */
    @Define
    public final static native byte EVENPARITY();

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
    public final static native void EscapeCommFunction(HANDLE hFile, int dwFunc) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_ATTRIBUTE_ARCHIVE</a>
     * The file should be archived. Applications use this attribute to mark
     * files for backup or removal.
     *
     * @return the native symbolic constant of FILE_ATTRIBUTE_ARCHIVE.
     */
    @Define
    public final static native int FILE_ATTRIBUTE_ARCHIVE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_ATTRIBUTE_ENCRYPTED</a>
     * The file or directory is encrypted. For a file, this means that all data
     * in the file is encrypted.
     *
     * @return the native symbolic constant of FILE_ATTRIBUTE_ENCRYPTED.
     */
    @Define
    public final static native int FILE_ATTRIBUTE_ENCRYPTED();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_ATTRIBUTE_HIDDEN</a>
     * The file is hidden. Do not include it in an ordinary directory listing.
     *
     * @return the native symbolic constant of FILE_ATTRIBUTE_HIDDEN.
     */
    @Define
    public final static native int FILE_ATTRIBUTE_HIDDEN();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_ATTRIBUTE_NORMAL</a>
     * The file does not have other attributes set. This attribute is valid only
     * if used alone.
     *
     * @return the native symbolic constant of FILE_ATTRIBUTE_NORMAL.
     */
    @Define
    public final static native int FILE_ATTRIBUTE_NORMAL();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_ATTRIBUTE_OFFLINE</a>
     * The data of a file is not immediately available.
     *
     * @return the native symbolic constant of FILE_ATTRIBUTE_OFFLINE.
     */
    @Define
    public final static native int FILE_ATTRIBUTE_OFFLINE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_ATTRIBUTE_READONLY</a>
     * The file is read only. Applications can read the file, but cannot write
     * to or delete it.
     *
     * @return the native symbolic constant of FILE_ATTRIBUTE_READONLY.
     */
    @Define
    public final static native int FILE_ATTRIBUTE_READONLY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_ATTRIBUTE_SYSTEM</a>
     * The file is part of or used exclusively by an operating system.
     *
     * @return the native symbolic constant of FILE_ATTRIBUTE_SYSTEM.
     */
    @Define
    public final static native int FILE_ATTRIBUTE_SYSTEM();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_ATTRIBUTE_TEMPORARY</a>
     * The file is being used for temporary storage.
     *
     * @return the native symbolic constant of FILE_ATTRIBUTE_TEMPORARY.
     */
    @Define
    public final static native int FILE_ATTRIBUTE_TEMPORARY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_BACKUP_SEMANTICS</a>
     * The file is being opened or created for a backup or restore operation.
     *
     * @return the native symbolic constant of FILE_FLAG_BACKUP_SEMANTICS.
     */
    @Define
    public final static native int FILE_FLAG_BACKUP_SEMANTICS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_DELETE_ON_CLOSE</a>
     * The file is to be deleted immediately after all of its handles are
     * closed, which includes the specified handle and any other open or
     * duplicated handles.
     *
     * @return the native symbolic constant of FILE_FLAG_DELETE_ON_CLOSE.
     */
    @Define
    public final static native int FILE_FLAG_DELETE_ON_CLOSE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_NO_BUFFERING</a>
     * The file or device is being opened with no system caching for data reads
     * and writes.
     *
     * @return the native symbolic constant of FILE_FLAG_NO_BUFFERING.
     */
    @Define
    public final static native int FILE_FLAG_NO_BUFFERING();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_OPEN_NO_RECALL</a>
     * The file data is requested, but it should continue to be located in
     * remote storage.
     *
     * @return the native symbolic constant of FILE_FLAG_OPEN_NO_RECALL.
     */
    @Define
    public final static native int FILE_FLAG_OPEN_NO_RECALL();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_OPEN_REPARSE_POINT</a>
     * Normal reparse point processing will not occur; CreateFile will attempt
     * to open the reparse point.
     *
     * @return the native symbolic constant of FILE_FLAG_OPEN_REPARSE_POINT.
     */
    @Define
    public final static native int FILE_FLAG_OPEN_REPARSE_POINT();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_OVERLAPPED</a>
     * The file or device is being opened or created for asynchronous I/O.
     *
     * @return the native symbolic constant of FILE_FLAG_OVERLAPPED.
     */
    @Define
    public final static native int FILE_FLAG_OVERLAPPED();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_POSIX_SEMANTICS</a>
     * Access will occur according to POSIX rules.
     *
     * @return the native symbolic constant of FILE_FLAG_POSIX_SEMANTICS.
     */
    @Define
    public final static native int FILE_FLAG_POSIX_SEMANTICS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_RANDOM_ACCESS</a>
     * Access is intended to be random. The system can use this as a hint to
     * optimize file caching.
     *
     * @return the native symbolic constant of FILE_FLAG_RANDOM_ACCESS.
     */
    @Define
    public final static native int FILE_FLAG_RANDOM_ACCESS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_SEQUENTIAL_SCAN</a>
     * Access is intended to be sequential from beginning to end.
     *
     * @return the native symbolic constant of FILE_FLAG_SEQUENTIAL_SCAN.
     */
    @Define
    public final static native int FILE_FLAG_SEQUENTIAL_SCAN();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_SESSION_AWARE</a>
     * The file or device is being opened with session awareness.
     *
     * @return the native symbolic constant of FILE_FLAG_SESSION_AWARE.
     */
    @Define
    public final static native int FILE_FLAG_SESSION_AWARE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/nf-fileapi-createfilew/">FILE_FLAG_WRITE_THROUGH</a>
     * Write operations will not go through any intermediate cache, they will go
     * directly to disk.
     *
     * @return the native symbolic constant of FILE_FLAG_WRITE_THROUGH.
     */
    @Define
    public final static native int FILE_FLAG_WRITE_THROUGH();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_ANONYMOUS</a>
     * Impersonates a client at the Anonymous impersonation level.
     *
     * @return the native symbolic constant of SECURITY_ANONYMOUS.
     */
    @Define
    public final static native int SECURITY_ANONYMOUS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_CONTEXT_TRACKING</a>
     * he security tracking mode is dynamic.
     *
     * @return the native symbolic constant of SECURITY_CONTEXT_TRACKING.
     */
    @Define
    public final static native int SECURITY_CONTEXT_TRACKING();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_DELEGATION</a>
     * Impersonates a client at the Delegation impersonation level.
     *
     * @return the native symbolic constant of SECURITY_DELEGATION.
     */
    @Define
    public final static native int SECURITY_DELEGATION();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_EFFECTIVE_ONLY</a>
     * Only the enabled aspects of the client's security context are available
     * to the server.
     *
     * @return the native symbolic constant of SECURITY_EFFECTIVE_ONLY.
     */
    @Define
    public final static native int SECURITY_EFFECTIVE_ONLY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_IDENTIFICATION</a>
     * Impersonates a client at the Identification impersonation level.
     *
     * @return the native symbolic constant of SECURITY_IDENTIFICATION.
     */
    @Define
    public final static native int SECURITY_IDENTIFICATION();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">SECURITY_IMPERSONATION</a>
     * Impersonate a client at the impersonation level.
     *
     * @return the native symbolic constant of SECURITY_IMPERSONATION.
     */
    @Define
    public final static native int SECURITY_IMPERSONATION();

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
    public final static native void GetCommModemStatus(HANDLE hFile, IntRef lpModemStat) throws NativeErrorException;

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
    public final static native void GetCommState(HANDLE hFile, DCB lpDCB) throws NativeErrorException;

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
    public final static native void GetCommTimeouts(HANDLE hFile, COMMTIMEOUTS lpCommTimeouts) throws NativeErrorException;

    public final static native boolean HAVE_WINBASE_H();

    @Define
    public final static native int INFINITE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">MARKPARITY</a>
     * Mark parity.
     *
     * @return the native symbolic constant of MARKPARITY.
     */
    @Define
    public final static native byte MARKPARITY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommmodemstatus/">MS_CTS_ON</a>
     * The CTS (clear-to-send) signal is on.
     *
     * @return the native symbolic constant of MS_CTS_ON.
     */
    @Define
    public final static native int MS_CTS_ON();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommmodemstatus/">MS_DSR_ON</a>
     * The DSR (data-set-ready) signal is on.
     *
     * @return the native symbolic constant of MS_DSR_ON.
     */
    @Define
    public final static native int MS_DSR_ON();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommmodemstatus/">MS_RING_ON</a>
     * The ring indicator signal is on.
     *
     * @return the native symbolic constant of MS_RING_ON.
     */
    @Define
    public final static native int MS_RING_ON();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-getcommmodemstatus/">MS_RLSD_ON</a>
     * The RLSD (receive-line-signal-detect) signal is on.
     *
     * @return the native symbolic constant of MS_RLSD_ON.
     */
    @Define
    public final static native int MS_RLSD_ON();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">NOPARITY</a>
     * No parity.
     *
     * @return the native symbolic constant of NOPARITY.
     */
    @Define
    public final static native byte NOPARITY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">ODDPARITY</a>
     * Odd parity.
     *
     * @return the native symbolic constant of ODDPARITY.
     */
    @Define
    public final static native byte ODDPARITY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">ONE5STOPBITS</a>
     * 1.5 stop bits.
     *
     * @return the native symbolic constant of ONE5STOPBITS.
     */
    @Define
    public final static native byte ONE5STOPBITS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">ONESTOPBIT</a>
     * 1 stop bit.
     *
     * @return the native symbolic constant of ONESTOPBIT.
     */
    @Define
    public final static native byte ONESTOPBIT();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">RTS_CONTROL_DISABLE</a>
     * Disables the RTS line when the device is opened and leaves it disabled.
     *
     * @return the native symbolic constant of RTS_CONTROL_DISABLE.
     */
    @Define
    public final static native byte RTS_CONTROL_DISABLE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">RTS_CONTROL_ENABLE</a>
     * Enables the RTS line when the device is opened and leaves it on.
     *
     * @return the native symbolic constant of RTS_CONTROL_ENABLE.
     */
    @Define
    public final static native byte RTS_CONTROL_ENABLE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">RTS_CONTROL_HANDSHAKE</a>
     * Enables RTS handshaking.
     *
     * @return the native symbolic constant of RTS_CONTROL_HANDSHAKE.
     */
    @Define
    public final static native byte RTS_CONTROL_HANDSHAKE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">RTS_CONTROL_TOGGLE</a>
     * Specifies that the RTS line will be high if bytes are available for
     * transmission.
     *
     * @return the native symbolic constant of RTS_CONTROL_TOGGLE.
     */
    @Define
    public final static native byte RTS_CONTROL_TOGGLE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">SETBREAK</a>
     * Suspends character transmission and places the transmission line in a
     * break state until the ClearCommBreak function is called (or
     * EscapeCommFunction is called with the CLRBREAK extended function code).
     *
     * @return the native symbolic constant of SETBREAK.
     */
    @Define
    public final static native int SETBREAK();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">SETDTR</a>
     * Sends the DTR (data-terminal-ready) signal.
     *
     * @return the native symbolic constant of SETDTR.
     */
    @Define
    public final static native int SETDTR();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">SETRTS</a>
     * Sends the RTS (request-to-send) signal.
     *
     * @return the native symbolic constant of SETRTS.
     */
    @Define
    public final static native int SETRTS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">SETXOFF</a>
     * Causes transmission to act as if an XOFF character has been received.
     *
     * @return the native symbolic constant of SETXOFF.
     */
    @Define
    public final static native int SETXOFF();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/nf-winbase-escapecommfunction/">SETXON</a>
     * Causes transmission to act as if an XON character has been received.
     *
     * @return the native symbolic constant of SETXON.
     */
    @Define
    public final static native int SETXON();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">SPACEPARITY</a>
     * Space parity.
     *
     * @return the native symbolic constant of SPACEPARITY.
     */
    @Define
    public final static native byte SPACEPARITY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/console/getstdhandle">STD_ERROR_HANDLE</a>
     * The standard error device. Initially, this is the active console screen
     * buffer, CONOUT$.
     *
     * @return the native symbolic constant of STD_ERROR_HANDLE.
     */
    @Define
    public final static native int STD_ERROR_HANDLE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/console/getstdhandle">STD_INPUT_HANDLE</a>
     * The standard input device. Initially, this is the console input buffer,
     * CONIN$.
     *
     * @return the native symbolic constant of STD_INPUT_HANDLE.
     */
    @Define
    public final static native int STD_INPUT_HANDLE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/console/getstdhandle">STD_OUTPUT_HANDLE</a>
     * The standard output device. Initially, this is the active console screen
     * buffer, CONOUT$.
     *
     * @return the native symbolic constant of STD_OUTPUT_HANDLE.
     */
    @Define
    public final static native int STD_OUTPUT_HANDLE();

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
    public final static native void SetCommBreak(HANDLE hFile) throws NativeErrorException;

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
    public final static native void SetCommState(HANDLE hFile, DCB lpDCB) throws NativeErrorException;

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
    public final static native void SetCommTimeouts(HANDLE hFile, COMMTIMEOUTS lpCommTimeouts) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb/">TWOSTOPBITS</a>
     * 2 stop bits.
     *
     * @return the native symbolic constant of TWOSTOPBITS.
     */
    @Define
    public final static native byte TWOSTOPBITS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitformultipleobjects/">MAXIMUM_WAIT_OBJECTS</a>
     * The state of the specified object is signaled.
     *
     * @return the native symbolic constant of MAXIMUM_WAIT_OBJECTS.
     */
    @Define
    public final static native int MAXIMUM_WAIT_OBJECTS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobject/">WAIT_ABANDONED</a>
     *
     * @return the native symbolic constant of WAIT_ABANDONED.
     */
    @Define
    public final static native int WAIT_ABANDONED();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobject/">WAIT_FAILED</a>
     * The specified object is a mutex object that was not released by the
     * thread that owned the mutex object before the owning thread terminated.
     * The function has failed. To get extended error information, call
     * GetLastError.
     * <br> This is usually done in the native code which throws a
     * NativeErrorExcepotion instead of passing this back.
     *
     * @return the native symbolic constant of WAIT_FAILED.
     */
    @Define
    public final static native int WAIT_FAILED();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobject/">WAIT_OBJECT_0</a>
     * The state of the specified object is signaled.
     *
     * @return the native symbolic constant of WAIT_OBJECT_0.
     */
    @Define
    public final static native int WAIT_OBJECT_0();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobjectEx/">WAIT_IO_COMPLETION</a>
     * The state of the specified object is signaled.
     *
     * @return the native symbolic constant of WAIT_IO_COMPLETION.
     */
    @Define
    public final static native int WAIT_IO_COMPLETION();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobject/">WAIT_TIMEOUT</a>
     * The time-out interval elapsed, and the object's state is nonsignaled.
     *
     * @return the native symbolic constant of WAIT_TIMEOUT.
     */
    @Define
    public final static native int WAIT_TIMEOUT();

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-commtimeouts">{@code structure
     * COMMTIMEOUTS}</a>.
     *
     */
    public final static class COMMTIMEOUTS extends Struct32 {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        @SizeOf
        public final static native int sizeof();

        public COMMTIMEOUTS(boolean clearMemory) {
            super(sizeof(), clearMemory);
        }

        /**
         *
         * @return the native value of ReadIntervalTimeout.
         */
        public native long ReadIntervalTimeout();

        /**
         * @param ReadIntervalTimeout the value of ReadIntervalTimeout to be set
         * natively.
         */
        public native void ReadIntervalTimeout(long ReadIntervalTimeout);

        /**
         *
         * @return the native value of ReadTotalTimeoutMultiplier.
         */
        public native long ReadTotalTimeoutMultiplier();

        /**
         * @param ReadTotalTimeoutMultiplier the value of
         * ReadTotalTimeoutMultiplier to be set natively.
         */
        public native void ReadTotalTimeoutMultiplier(long ReadTotalTimeoutMultiplier);

        /**
         *
         * @return the native value of ReadTotalTimeoutConstant.
         */
        public native long ReadTotalTimeoutConstant();

        /**
         * @param ReadTotalTimeoutConstant the value of ReadTotalTimeoutConstant
         * to be set natively.
         */
        public native void ReadTotalTimeoutConstant(long ReadTotalTimeoutConstant);

        /**
         *
         * @return the native value of WriteTotalTimeoutMultiplier.
         */
        public native long WriteTotalTimeoutMultiplier();

        /**
         * @param WriteTotalTimeoutMultiplier the value of
         * WriteTotalTimeoutMultiplier to be set natively.
         */
        public native void WriteTotalTimeoutMultiplier(long WriteTotalTimeoutMultiplier);

        /**
         *
         * @return the native value of WriteTotalTimeoutConstant.
         */
        public native long WriteTotalTimeoutConstant();

        /**
         * @param WriteTotalTimeoutConstant the value of
         * WriteTotalTimeoutConstant to be set natively.
         */
        public native void WriteTotalTimeoutConstant(long WriteTotalTimeoutConstant);

    }

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-comstat">{@code structure
     * COMSTAT}</a>.
     *
     */
    public static class COMSTAT extends Struct32 {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        @SizeOf
        public final static native int sizeof();

        public COMSTAT(boolean clearMemory) {
            super(sizeof(), clearMemory);
        }

        /**
         * @return the native value of fCtsHold.
         */
        public native boolean fCtsHold();

        /**
         * @return the native value of fDsrHold.
         */
        public native boolean fDsrHold();

        /**
         * @return the native value of fRlsdHold.
         */
        public native boolean fRlsdHold();

        /**
         * @return the native value of fXoffHold.
         */
        public native boolean fXoffHold();

        /**
         * @return the native value of fXoffSent.
         */
        public native boolean fXoffSent();

        /**
         *
         * @return the native value of fEof.
         */
        public native boolean fEof();

        /**
         *
         * @return the native value of fTxim.
         */
        public native boolean fTxim();

        /**
         *
         * @return the native value of fReserved.
         */
        public native int fReserved();

        /**
         *
         * @return the native value of cbInQue.
         */
        public native int cbInQue();

        /**
         *
         * @return the native value of cbOutQue.
         */
        public native int cbOutQue();
    }

    /**
     * <b>WIN:</b> <a href="https://docs.microsoft.com/en-us/windows/win32/api/winbase/ns-winbase-dcb">{@code structure
     * DCB}</a>.
     *
     */
    public final static class DCB extends Struct32 {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        public DCB(boolean clearMemory) {
            super(sizeof(), clearMemory);
            //set the current size explicitly.
            DCBlength(sizeof());
        }

        @SizeOf
        public final static native int sizeof();

        /**
         * @param DCBlength the value of DCBlength to be set natively.
         */
        public native void DCBlength(int DCBlength);

        /**
         *
         * @return the native value of DCBlength.
         */
        public native int DCBlength();

        /**
         *
         * @return the native value of BaudRate.
         */
        public native int BaudRate();

        /**
         * @param BaudRate the value of BaudRate to be set natively.
         */
        public native void BaudRate(int BaudRate);

        /**
         *
         * @return the native value of fBinary.
         */
        public native boolean fBinary();

        /**
         *
         * @return the native value of fParity.
         */
        public native boolean fParity();

        /**
         *
         * @return the native value of fOutxCtsFlow.
         */
        public native boolean fOutxCtsFlow();

        /**
         * @param fOutxCtsFlow the value of fOutxCtsFlow to be set natively.
         */
        public native void fOutxCtsFlow(boolean fOutxCtsFlow);

        /**
         *
         * @return the native value of fOutxDsrFlow.
         */
        public native boolean fOutxDsrFlow();

        /**
         * Values: DTR_CONTROL_DISABLE DTR_CONTROL_ENABLE DTR_CONTROL_HANDSHAKE
         *
         * @return the native value of fDtrControl.
         */
        public native byte fDtrControl();

        /**
         *
         * @return the native value of fDsrSensitivity.
         */
        public native boolean fDsrSensitivity();

        /**
         *
         * @return the native value of fTXContinueOnXoff.
         */
        public native boolean fTXContinueOnXoff();

        /**
         *
         * @return the native value of fOutX.
         */
        public native boolean fOutX();

        /**
         * @param fOutX the value of fOutX to be set natively.
         */
        public native void fOutX(boolean fOutX);

        /**
         *
         * @return the native value of fInX.
         */
        public native boolean fInX();

        /**
         * @param fInX the value of fInX to be set natively.
         */
        public native void fInX(boolean fInX);

        /**
         *
         * @return the native value of fErrorChar.
         */
        public native boolean fErrorChar();

        /**
         *
         * @return the native value of fNull.
         */
        public native boolean fNull();

        /**
         * Values: RTS_CONTROL_DISABLE RTS_CONTROL_ENABLE RTS_CONTROL_HANDSHAKE
         * RTS_CONTROL_TOGGLE
         *
         * @return the native value of fRtsControl.
         */
        public native byte fRtsControl();

        /**
         * @param fRtsControl the value of fRtsControl to be set natively.
         */
        public native void fRtsControl(byte fRtsControl);

        /**
         *
         * @return the native value of fAbortOnError.
         */
        public native boolean fAbortOnError();

        /**
         *
         * @return the native value of fDummy2.
         */
        public native int fDummy2();

        /**
         *
         * @return the native value of wReserved.
         */
        public native short wReserved();

        /**
         *
         * @return the native value of XonLim.
         */
        public native short XonLim();

        /**
         *
         * @return the native value of XoffLim.
         */
        public native short XoffLim();

        /**
         *
         * @return the native value of ByteSize.
         */
        public native byte ByteSize();

        /**
         * @param ByteSize the value of ByteSize to be set natively.
         */
        public native void ByteSize(byte ByteSize);

        /**
         * Values: EVENPARITY MARKPARITY NOPARITY ODDPARITY SPACEPARITY
         *
         * @return the native value of Parity.
         */
        public native byte Parity();

        /**
         * @param Parity the value of Parity to be set natively.
         */
        public native void Parity(byte Parity);

        /**
         * Values: ONESTOPBIT ONE5STOPBITS TWOSTOPBITS
         *
         * @return the native value of StopBits.
         */
        public native byte StopBits();

        /**
         * @param StopBits the value of StopBits to be set natively.
         */
        public native void StopBits(byte StopBits);

        /**
         *
         * @return the native value of XonChar.
         */
        public native char XonChar();

        /**
         * @param XonChar the value of XonChar to be set natively.
         */
        public native void XonChar(char XonChar);

        /**
         *
         * @return the native value of XoffChar.
         */
        public native char XoffChar();

        /**
         * @param XoffChar the value of XoffChar to be set natively.
         */
        public native void XoffChar(char XoffChar);

        /**
         *
         * @return the native value of ErrorChar.
         */
        public native char ErrorChar();

        /**
         *
         * @return the native value of EofChar.
         */
        public native char EofChar();

        /**
         * @return the native value of EvtChar.
         */
        public native char EvtChar();

        /**
         *
         * @return the native value of wReserved1.
         */
        public native short wReserved1();

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
    public static native void SetFileCompletionNotificationModes(HANDLE hFile, byte uFlags) throws NativeErrorException;

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
    public static native void BindIoCompletionCallback(HANDLE FileHandle, Minwinbase.LPOVERLAPPED_COMPLETION_ROUTINE Function, int Flags) throws NativeErrorException;

}
