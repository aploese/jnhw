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
package de.ibapl.jnhw.util.winapi;

import de.ibapl.jnhw.common.datatypes.BaseDataType;

/**
 * The windows datatypes with their mapping to the base datatypes that we have
 * seen so far.
 *
 * @author aploese
 */
public enum WinApiDataType {

    BOOL(BaseDataType.int32_t),
    DWORD(BaseDataType.uint32_t),
    HANDLE(BaseDataType.intptr_t),
    ULONG_PTR(BaseDataType.uintptr_t),
    WCHAR(BaseDataType.uint16_t),
    //Pointer of types
    PHANDLE(BaseDataType.uintptr_t, HANDLE),
    PVOID(BaseDataType.uintptr_t);

    private WinApiDataType(BaseDataType dataType) {
        this.baseDataType = dataType;
        this.pointerOf = null;
    }

    private WinApiDataType(BaseDataType dataType, WinApiDataType pointerOf) {
        this.baseDataType = dataType;
        this.pointerOf = pointerOf;
    }

    public final BaseDataType baseDataType;
    public final WinApiDataType pointerOf;

}
