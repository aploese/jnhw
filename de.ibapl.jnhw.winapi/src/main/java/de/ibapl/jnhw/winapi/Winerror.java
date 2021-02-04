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
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwWinApiLoader.touch();

        HAVE_WINERROR_H = false;

        ERROR_ACCESS_DENIED = 0;
        ERROR_ALREADY_EXISTS = 0;

        ERROR_FILE_EXISTS = 0;
        ERROR_FILE_NOT_FOUND = 0;

        ERROR_GEN_FAILURE = 0;

        ERROR_INVALID_HANDLE = 0;
        ERROR_INVALID_PARAMETER = 0;
        ERROR_IO_INCOMPLETE = 0;
        ERROR_IO_PENDING = 0;

        ERROR_MORE_DATA = 0;

        ERROR_NOACCESS = 0;
        ERROR_NOT_FOUND = 0;
        ERROR_NO_MORE_ITEMS = 0;

        ERROR_PIPE_BUSY = 0;
        ERROR_PROC_NOT_FOUND = 0;

        ERROR_SHARING_VIOLATION = 0;
        ERROR_SUCCESS = 0;

        WAIT_TIMEOUT = 0;

        initFields();
    }

    private static native void initFields();

    /**
     * The operation completed successfully.
     *
     */
    @Define
    public final static int ERROR_SUCCESS;

    /**
     * Access is denied.
     *
     */
    @Define
    public final static int ERROR_ACCESS_DENIED;

    /**
     * Cannot create a file when that file already exists.
     *
     */
    @Define
    public final static int ERROR_ALREADY_EXISTS;

    /**
     * The file exists.
     *
     */
    @Define
    public final static int ERROR_FILE_EXISTS;

    /**
     * The system cannot find the file specified.
     *
     */
    @Define
    public final static int ERROR_FILE_NOT_FOUND;

    /**
     * The system cannot read from the specified device.
     *
     */
    @Define
    public final static int ERROR_GEN_FAILURE;

    /**
     * The handle is invalid.
     *
     */
    @Define
    public final static int ERROR_INVALID_HANDLE;

    /**
     * The specified network password is not correct.
     *
     */
    @Define
    public final static int ERROR_INVALID_PARAMETER;

    /**
     * Overlapped I/O event is not in a signaled state.
     *
     */
    @Define
    public final static int ERROR_IO_INCOMPLETE;

    /**
     * Overlapped I/O operation is in progress.
     *
     */
    @Define
    public final static int ERROR_IO_PENDING;

    /**
     * More data is available.
     *
     */
    @Define
    public final static int ERROR_MORE_DATA;

    /**
     * Invalid access to memory location.
     *
     */
    @Define
    public final static int ERROR_NOACCESS;

    /**
     * Element not found.
     *
     */
    @Define
    public final static int ERROR_NOT_FOUND;

    /**
     * No more data is available.
     *
     */
    @Define
    public final static int ERROR_NO_MORE_ITEMS;

    /**
     * All pipe instances are busy.
     *
     */
    @Define
    public final static int ERROR_PIPE_BUSY;

    /**
     * The process cannot access the file because it is being used by another
     * process.
     *
     */
    @Define
    public final static int ERROR_SHARING_VIOLATION;

    /**
     * The wait operation timed out.
     *
     */
    @Define
    public final static int WAIT_TIMEOUT;

    /**
     * The specified procedure could not be found.
     *
     */
    @Define
    public final static int ERROR_PROC_NOT_FOUND;

    public final static boolean HAVE_WINERROR_H;

}
