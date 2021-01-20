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

import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import de.ibapl.jnhw.winapi.Winnt.PAPCFUNC;
import de.ibapl.jnhw.winapi.BaseTsd.ULONG_PTR;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/processthreadsapi/">processthreadsapi.h</a>
 * header.
 *
 * @author aploese
 */
@Include("processthreadsapi.h")
public abstract class Processthreadsapi {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    public static final native boolean HAVE_PROCESSTHREADSAPI_H();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/processthreadsapi/nf-processthreadsapi-queueuserapc">QueueUserAPC</a>
     * Adds a user-mode asynchronous procedure call (APC) object to the APC
     * queue of the specified thread.
     *
     * @param pfnAPC A pointer to the application-supplied APC function to be
     * called when the specified thread performs an alertable wait operation.
     * @param hThread A handle to the thread.
     * @param dwData A single value that is passed to the APC function pointed
     * to by the pfnAPC parameter.
     *
     * @throws NullPointerException if pfnAPC is {@code null}.
     * @throws NullPointerException if hThread is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void QueueUserAPC(PAPCFUNC pfnAPC, HANDLE hThread, @ULONG_PTR long dwData);
    
        /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/processthreadsapi/nf-processthreadsapi-getcurrentthread">GetCurrentThread</a>
     * Retrieves a pseudo handle for the calling thread.
     *
     * @return  a pseudo handle for the current thread.
     *
     */
    public final static native HANDLE GetCurrentThread();
}
