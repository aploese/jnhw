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

import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Minwinbase.SECURITY_ATTRIBUTES;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 *
 * @author aploese
 */
@Include("synchapi.h")
public abstract class Synchapi extends LibJnhwWinApiLoader {

    public final static native boolean HAVE_SYNCHAPI_H();

    private static native long WaitForSingleObject(long hHandle, long dwMilliseconds);

    public final static long WaitForSingleObject(HANDLE hHandle, long dwMilliseconds) {
        return WaitForSingleObject(hHandle.value, dwMilliseconds);
    }

    private static native long CreateEventW(long lpEventAttributes, boolean bManualReset, boolean bInitialState, String lpName) throws NativeErrorException;

    public final static HANDLE CreateEventW(SECURITY_ATTRIBUTES lpEventAttributes, boolean bManualReset, boolean bInitialState, String lpName) throws NativeErrorException {
        final long result = CreateEventW(lpEventAttributes == null ? 0L : lpEventAttributes.baseAddress, bManualReset, bInitialState, lpName);
        return new HANDLE(result);
    }

    private static native boolean SetEvent(long hEvent);

    private static native boolean ResetEvent(long hEvent);

    public final static boolean SetEvent(HANDLE hEvent) {
        return SetEvent(hEvent.value);
    }

    public final static boolean ResetEvent(HANDLE hEvent) {
        return ResetEvent(hEvent.value);
    }
}
