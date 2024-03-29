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

import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.downcall.JnhwMh_MA__uI;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.util.winapi.Kernel32Loader;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/processenv/">processenv.h</a>
 * header.
 *
 * @author aploese
 */
@Include("processenv.h")
public class ProcessEnv {

    private final static JnhwMh_MA__uI.ExceptionErased GetStdHandle = JnhwMh_MA__uI.mandatoryOf(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "GetStdHandle",
            WinApiDataType.HANDLE,
            WinApiDataType.DWORD,
            0L);//Just a pointer with length 0!

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/console/getstdhandle">GetStdHandle</a>
     *
     * @param nStdHandle The standard device. This parameter can be one of the
     * following values. STD_INPUT_HANDLE, STD_OUTPUT_HANDLE, STD_ERROR_HANDLE.
     * @return If the function succeeds, the return value is a handle to the
     * specified device, or a redirected handle set by a previous call to
     * SetStdHandle.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static HANDLE GetStdHandle(int nStdHandle) throws NativeErrorException {
        return HANDLE.of(GetStdHandle.invoke_MA__uI(nStdHandle));
    }

}
