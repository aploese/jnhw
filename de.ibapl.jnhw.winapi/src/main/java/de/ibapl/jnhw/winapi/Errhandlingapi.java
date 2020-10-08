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
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/errhandlingapi/">errhandlingapi.h</a>
 * header.
 *
 * @author aploese
 */
@Include("errhandlingapi.h")
public abstract class Errhandlingapi {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/errhandlingapi/nf-errhandlingapi-getlasterror">GetLastError</a>
     * Retrieves the calling thread's last-error code value. The last-error code
     * is maintained on a per-thread basis. Multiple threads do not overwrite
     * each other's last-error code.
     *
     * @return the calling thread's last-error code. The Return Value section of
     * the documentation for each function that sets the last-error code notes
     * the conditions under which the function sets the last-error code. Most
     * functions that set the thread's last-error code set it when they fail.
     * However, some functions also set the last-error code when they succeed.
     * If the function is not documented to set the last-error code, the value
     * returned by this function is simply the most recent last-error code to
     * have been set; some functions set the last-error code to 0 on success and
     * others do not.
     */
    public final static native int GetLastError();
    
    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/errhandlingapi/nf-errhandlingapi-setlasterror">GetLastError</a>
     * Sets the last-error code for the calling thread.
     *
     */
    public final static native void SetLastError(int dwErrCode);

    public final static native boolean HAVE_ERRHANDLINGAPI_H();

}
