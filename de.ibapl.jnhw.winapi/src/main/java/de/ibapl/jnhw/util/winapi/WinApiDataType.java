/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.datatypes.MemoryModel;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;

/**
 * The windows datatypes with their mapping to the base datatypes that we have
 * seen so far.
 * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types">Windows
 * Data Types</a>
 *
 * @author aploese
 */
public interface WinApiDataType {

    /**
     * 32 bit signed
     */
    public final static BaseDataType BOOL = BaseDataType.C_int;
    /**
     * 32 bit unsigned
     */
    public final static BaseDataType DWORD = BaseDataType.C_unsigned_long;
    /**
     * 32 bit signed
     */
    public final static BaseDataType LONG = BaseDataType.C_long;
    /**
     * 32 bit unsigned
     */
    public final static BaseDataType ULONG = BaseDataType.C_unsigned_long;
    public final static BaseDataType ULONG_PTR = switch (MultiarchTupelBuilder.getMemoryModel()) {
        case ILP32 ->
            BaseDataType.int32_t;
        case LLP64 ->
            BaseDataType.int64_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of ULONG_PTR on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType HANDLE = BaseDataType.C_pointer;
    public final static BaseDataType const_HANDLE_pointer = BaseDataType.C_pointer;
    public final static BaseDataType HKEY = HANDLE;
    public final static BaseDataType LSTATUS = LONG;
    public final static BaseDataType ACCESS_MASK = DWORD;
    public final static BaseDataType REGSAM = ACCESS_MASK;
    //Pointer of types
    public final static BaseDataType PAPCFUNC = BaseDataType.C_pointer;
    public final static BaseDataType PHANDLE = BaseDataType.C_pointer;
    public final static BaseDataType PHKEY = BaseDataType.C_pointer;
    public final static BaseDataType LPBYTE = BaseDataType.C_char_pointer;
    public final static BaseDataType LPDWORD = BaseDataType.C_unsigned_long_pointer;
    public final static BaseDataType LPWSTR = BaseDataType.C_char_pointer;
    public final static BaseDataType LPOVERLAPPED = BaseDataType.C_struct_pointer;
    public final static BaseDataType LPOVERLAPPED_COMPLETION_ROUTINE = BaseDataType.C_function_pointer;
    public final static BaseDataType LPVOID = BaseDataType.C_pointer;
    public final static BaseDataType PVOID = BaseDataType.C_pointer;
    public final static BaseDataType PULONG_PTR = BaseDataType.C_pointer;
    public final static BaseDataType WCHAR = BaseDataType.uint16_t;
    public final static BaseDataType LPCWSTR = BaseDataType.C_char_pointer;
    public final static BaseDataType LPSECURITY_ATTRIBUTES = BaseDataType.C_struct_pointer;
    public final static BaseDataType LPCOMSTAT = BaseDataType.C_struct_pointer;
    public final static BaseDataType LPDCB = BaseDataType.C_struct_pointer;

}
