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

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.util.IntDefine;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     * Access is denied.
     *
     */
    @Define
    public final static int ERROR_ACCESS_DENIED = 5;

    /**
     * Cannot create a file when that file already exists.
     *
     */
    @Define
    public final static int ERROR_ALREADY_EXISTS = 183;

    /**
     * The file exists.
     *
     */
    @Define
    public final static int ERROR_FILE_EXISTS = 80;

    /**
     * The system cannot find the file specified.
     *
     */
    @Define
    public final static int ERROR_FILE_NOT_FOUND = 0x88790002;

    /**
     * The system cannot read from the specified device.
     *
     */
    @Define
    public final static int ERROR_GEN_FAILURE = 31;

    /**
     * The handle is invalid.
     *
     */
    @Define
    public final static int ERROR_INVALID_HANDLE = 1609;

    /**
     * The specified network password is not correct.
     *
     */
    @Define
    public final static int ERROR_INVALID_PARAMETER = 87;

    /**
     * Overlapped I/O event is not in a signaled state.
     *
     */
    @Define
    public final static int ERROR_IO_INCOMPLETE = 996;

    /**
     * Overlapped I/O operation is in progress.
     *
     */
    @Define
    public final static int ERROR_IO_PENDING = 997;

    /**
     * More data is available.
     *
     */
    @Define
    public final static int ERROR_MORE_DATA = 0x887A0003;

    /**
     * No more data is available.
     *
     */
    @Define
    public final static int ERROR_NO_MORE_ITEMS = 259;

    /**
     * Invalid access to memory location.
     *
     */
    @Define
    public final static int ERROR_NOACCESS = 998;

    /**
     * Element not found.
     *
     */
    @Define
    public final static int ERROR_NOT_FOUND = 1168;

    /**
     * All pipe instances are busy.
     *
     */
    @Define
    public final static int ERROR_PIPE_BUSY = 231;

    /**
     * The specified procedure could not be found.
     *
     */
    @Define
    public final static int ERROR_PROC_NOT_FOUND = 127;

    /**
     * The process cannot access the file because it is being used by another
     * process.
     *
     */
    @Define
    public final static int ERROR_SHARING_VIOLATION = 32;

    /**
     * The operation completed successfully.
     *
     */
    @Define
    public final static int ERROR_SUCCESS = 0;

    /**
     * The wait operation timed out.
     *
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/synchapi/nf-synchapi-waitforsingleobject/">WAIT_TIMEOUT</a>
     * The time-out interval elapsed, and the object's state is nonsignaled.
     *
     */
    @Define
    public final static int WAIT_TIMEOUT = 258;

    /**
     * Translate the native errno to its symbolic constant name.
     *
     * @param errno
     * @return
     */
    public final static String getErrnoSymbol(int errno) {
        for (Field f : Winerror.class.getFields()) {
            if (f.getAnnotation(Define.class) != null) {
                try {
                    Object res = (Object) f.get(Winerror.class);
                    if (res instanceof Integer) {
                        if (errno == ((Integer) res)) {
                            return f.getName();
                        } else if (res instanceof IntDefine) {
                            final IntDefine i = (IntDefine) res;
                            if (i.isDefined()) {
                                if (errno == i.get()) {
                                    return f.getName();
                                }
                            }
                        }
                    }
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(Winerror.class.getName()).log(Level.SEVERE, "Unknown ex in Errno.getErrnoSymbol(int)", ex);
                }
            }
        }
        return "Unknown errno: " + errno;
    }

}
