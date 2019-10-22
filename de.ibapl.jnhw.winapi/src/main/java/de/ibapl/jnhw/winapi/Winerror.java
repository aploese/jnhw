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

@Include("winerror.h")
public abstract class Winerror {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    public final static native boolean HAVE_WINERROR_H();

    @Define
    public final static native int ERROR_SUCCESS();

    @Define
    public final static native int ERROR_FILE_NOT_FOUND();

    @Define
    public final static native int ERROR_ACCESS_DENIED();

    @Define
    public final static native int ERROR_GEN_FAILURE();

    @Define
    public final static native int ERROR_INVALID_PARAMETER();
    
    @Define
    public final static native int ERROR_INVALID_HANDLE();

    @Define
    public final static native int ERROR_IO_PENDING();

    @Define
    public final static native int ERROR_NOACCESS();

    @Define
    public final static native int ERROR_NO_MORE_ITEMS();

    @Define
    public final static native int ERROR_MORE_DATA();

    @Define
    public final static native int ERROR_NOT_FOUND();

}
