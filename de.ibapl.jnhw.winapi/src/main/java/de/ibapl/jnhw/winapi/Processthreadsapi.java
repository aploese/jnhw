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

import de.ibapl.jnhw.annotation.winapi.basetsd.ULONG_PTR;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.downcall.JnhwMh_BL___A__A_uL;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA___V;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.util.winapi.Kernel32Loader;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import de.ibapl.jnhw.winapi.Winnt.PAPCFUNC;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/processthreadsapi/">processthreadsapi.h</a>
 * header.
 *
 * @author aploese
 */
@Include("processthreadsapi.h")
public abstract class Processthreadsapi {

    private final static JnhwMh_MA___V.ExceptionErased GetCurrentThread = JnhwMh_MA___V.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "GetCurrentThread",
            WinApiDataType.HANDLE,
            0L);//Just a pointer with length 0!

    private final static JnhwMh_BL___A__A_uL.ExceptionErased QueueUserAPC = JnhwMh_BL___A__A_uL.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "QueueUserAPC",
            WinApiDataType.BOOL,
            WinApiDataType.PAPCFUNC,
            WinApiDataType.HANDLE,
            WinApiDataType.ULONG_PTR);

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/processthreadsapi/nf-processthreadsapi-getcurrentthread">GetCurrentThread</a>
     * Retrieves a pseudo handle for the calling thread.
     *
     * @return a pseudo handle for the current thread.
     *
     */
    public final static HANDLE GetCurrentThread() {
        return HANDLE.of(GetCurrentThread.invoke_MA___V());
    }

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
    public final static void QueueUserAPC(PAPCFUNC pfnAPC, HANDLE hThread, @ULONG_PTR long dwData) throws NativeErrorException {
        if (!QueueUserAPC.invoke_BL___P__P_uL(pfnAPC, hThread, dwData)) {
            throw new NativeErrorException(Errhandlingapi.GetLastError());
        }
    }
}
