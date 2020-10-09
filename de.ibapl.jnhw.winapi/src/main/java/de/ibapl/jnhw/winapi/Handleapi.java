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
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/handleapi/">handleapi.h</a>
 * header.
 *
 * @author aploese
 */
@Include("handleapi.h")
public abstract class Handleapi {

    /**
     * cached instance.
     */
    private static HANDLE INVALID_HANDLE_VALUE;

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/handleapi/nf-handleapi-closehandle">CloseHandle</a>
     * Closes an open object handle.
     *
     * @param hObject a valid handle to an open object.
     *
     * @throws NullPointerException if hObject is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final native static void CloseHandle(HANDLE hObject) throws NativeErrorException;

    public final static native boolean HAVE_HANDLEAPI_H();

    /**
     *
     * @return the native symbolic constant of INVALID_HANDLE_VALUE as singleton.
     */
    @Define
    public final static HANDLE INVALID_HANDLE_VALUE() {
        if (INVALID_HANDLE_VALUE == null) {
            INVALID_HANDLE_VALUE = create_INVALID_HANDLE_VALUE();
        }
        return INVALID_HANDLE_VALUE;
    }

    private final static native HANDLE create_INVALID_HANDLE_VALUE();

}
