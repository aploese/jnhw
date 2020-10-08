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

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winerror/">winerror.h</a>
 * header with the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/debug/system-error-codes#system-error-codes">Systrem
 * Error Codes</a>.
 *
 *
 * @author aploese
 */
@Include("winerror.h")
public abstract class Winerror {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * The operation completed successfully.
     *
     * @return the native symbolic constant of ERROR_SUCCESS.
     */
    @Define
    public final static native int ERROR_SUCCESS();


    /**
     * Access is denied.
     *
     * @return the native symbolic constant of ERROR_ACCESS_DENIED.
     */
    @Define
    public final static native int ERROR_ACCESS_DENIED();

    /**
     * Cannot create a file when that file already exists.
     *
     * @return the native symbolic constant of ERROR_ALREADY_EXISTS.
     */
    @Define
    public final static native int ERROR_ALREADY_EXISTS();

    /**
     * The file exists.
     *
     * @return the native symbolic constant of ERROR_FILE_EXISTS.
     */
    @Define
    public final static native int ERROR_FILE_EXISTS();

    /**
     * The system cannot find the file specified.
     *
     * @return the native symbolic constant of ERROR_FILE_NOT_FOUND.
     */
    @Define
    public final static native int ERROR_FILE_NOT_FOUND();

    /**
     * The system cannot read from the specified device.
     *
     * @return the native symbolic constant of ERROR_GEN_FAILURE.
     */
    @Define
    public final static native int ERROR_GEN_FAILURE();

    /**
     * The handle is invalid.
     *
     * @return the native symbolic constant of ERROR_INVALID_HANDLE.
     */
    @Define
    public final static native int ERROR_INVALID_HANDLE();

    /**
     * The specified network password is not correct.
     *
     * @return the native symbolic constant of ERROR_INVALID_PARAMETER.
     */
    @Define
    public final static native int ERROR_INVALID_PARAMETER();

    /**
     * Overlapped I/O event is not in a signaled state.
     *
     * @return the native symbolic constant of ERROR_IO_INCOMPLETE.
     */
    @Define
    public final static native int ERROR_IO_INCOMPLETE();

    /**
     * Overlapped I/O operation is in progress.
     *
     * @return the native symbolic constant of ERROR_IO_PENDING.
     */
    @Define
    public final static native int ERROR_IO_PENDING();

    /**
     * More data is available.
     *
     * @return the native symbolic constant of ERROR_MORE_DATA.
     */
    @Define
    public final static native int ERROR_MORE_DATA();

    /**
     * Invalid access to memory location.
     *
     * @return the native symbolic constant of ERROR_NOACCESS.
     */
    @Define
    public final static native int ERROR_NOACCESS();

    /**
     * Element not found.
     *
     * @return the native symbolic constant of ERROR_NOT_FOUND.
     */
    @Define
    public final static native int ERROR_NOT_FOUND();

    /**
     * No more data is available.
     *
     * @return the native symbolic constant of ERROR_NO_MORE_ITEMS.
     */
    @Define
    public final static native int ERROR_NO_MORE_ITEMS();

    /**
     * All pipe instances are busy.
     *
     * @return the native symbolic constant of ERROR_PIPE_BUSY.
     */
    @Define
    public final static native int ERROR_PIPE_BUSY();

    /**
     * The process cannot access the file because it is being used by another
     * process.
     *
     * @return the native symbolic constant of ERROR_SHARING_VIOLATION.
     */
    @Define
    public final static native int ERROR_SHARING_VIOLATION();
    
    /**
     * The wait operation timed out.
     * 
     * @return the native symbolic constant of WAIT_TIMEOUT.
     */
    @Define
    public final static native int WAIT_TIMEOUT();
        
    /**
     * The specified procedure could not be found.
     *
     * @return the native symbolic constant of ERROR_PROC_NOT_FOUND.
     */
    @Define
    public final static native int ERROR_PROC_NOT_FOUND();

    public final static native boolean HAVE_WINERROR_H();

}
