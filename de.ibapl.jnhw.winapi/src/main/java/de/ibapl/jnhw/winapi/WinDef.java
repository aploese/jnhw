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
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.common.memory.Uint32_t;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/windef/">WinDef.h</a>
 * header.
 *
 * @author aploese
 */
@Include("WinDef.h")
public abstract class WinDef {

    /**
     * Wrapper for
     * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types#hkey">HKEY</a>.<p>
     * A handle to a registry key.<br>
     * This type is declared in WinDef.h as follows:<br>
     * typedef HANDLE HKEY;
     * </p>
     */
    public static class HKEY extends HANDLE {

        public final static HKEY NULL = new HKEY(MemoryAddress.NULL);

        public final static HKEY INVALID_HANDLE_VALUE = new HKEY(MemoryAddress.ofLong(_INVALID_HANDLE_VALUE));

        public static HKEY of(MemoryAddress value) {
            if (value == MemoryAddress.NULL) {
                return NULL;
            } else if (value.toRawLongValue() == _INVALID_HANDLE_VALUE) {
                return INVALID_HANDLE_VALUE;
            } else {
                return new HKEY(value);
            }
        }

        protected HKEY(MemoryAddress value) {
            super(value);
        }

    }

    /**
     * Wrapper for
     * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types#lpbyte">LPBYTE</a>.<p>
     * A pointer to a BYTE.<br>
     * This type is declared in WinDef.h as follows:<br>
     * typedef BYTE far *LPBYTE;
     * </p>
     */
    public static class LPBYTE extends OpaqueMemory {

        private final static int SIZE_OF_WCHAR = WinApiDataType.WCHAR.SIZE_OF;

        public static LPBYTE allocateNative(int size, MemorySession ms) {
            return new LPBYTE(MemorySegment.allocateNative(size, ms), 0, size);
        }

        /**
         * if isNullTerminated do skip the last two 0 bytes aka the last 0 char.
         *
         * @param lpData
         * @return
         */
        public static String getUnicodeString(LPBYTE lpData, boolean isNullTerminated, int bufferEnd) {
            if (isNullTerminated) {
                return MEM_ACCESS.getUnicodeString(OpaqueMemory.getMemorySegment(lpData), 0, bufferEnd / SIZE_OF_WCHAR - 1);
            } else {
                return MEM_ACCESS.getUnicodeString(OpaqueMemory.getMemorySegment(lpData), 0, bufferEnd / SIZE_OF_WCHAR);
            }
        }

        public LPBYTE(MemorySegment memorySegment, long offset, int size) {
            super(memorySegment, offset, size);
        }

        @Override
        public BaseDataType getBaseDataType() {
            return BaseDataType.uint8_t;
        }

    }

    /**
     * Wrapper for
     * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types#lpdword">LPDWORD</a>.<p>
     * A pointer to a DWORD.<br>
     * This type is declared in WinDef.h as follows:<br>
     * typedef DWORD *LPDWORD;
     * </p>
     */
    public static class LPDWORD extends Uint32_t {

        public static LPDWORD allocateNative(MemorySession ms) {
            return new LPDWORD(MemorySegment.allocateNative(DATA_TYPE.SIZE_OF, ms), 0);
        }

        public LPDWORD(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset);
        }

    }

    /**
     * Wrapper for
     * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types#lpbyte">LPBYTE</a>.<p>
     * A pointer to a BYTE.<br>
     * This type is declared in WinDef.h as follows:<br>
     * typedef BYTE far *LPBYTE;
     * </p>
     */
    public static class LPWSTR extends Struct {

        public static LPWSTR wrap(String value, boolean isNullTerminated, MemorySession ms) {
            final int length = value.length() * 2 + (isNullTerminated ? 2 : 0);
            final LPWSTR result = new LPWSTR(MemorySegment.allocateNative(length, ms), 0, length);
            result.setString(value, isNullTerminated);
            return result;
        }

        private final static int SIZE_OF_WCHAR = WinApiDataType.WCHAR.SIZE_OF;

        /**
         * if isNullTerminated do skip the last two 0 bytes aka the last 0 char.
         *
         */
        public String getString(boolean isNullTerminated, int bufferEnd) {
            if (isNullTerminated) {
                return MEM_ACCESS.getUnicodeString(memorySegment, 0, bufferEnd / SIZE_OF_WCHAR - 1);
            } else {
                return MEM_ACCESS.getUnicodeString(memorySegment, 0, bufferEnd / SIZE_OF_WCHAR);
            }
        }

        /**
         * if isNullTerminated do skip the last two 0 bytes aka the last 0 char.
         *
         */
        public void setString(String value, boolean isNullTerminated) {
            if (isNullTerminated) {
                MEM_ACCESS.setUnicodeString(memorySegment, 0, value.length(), value);
                //write the trailing 0
                MEM_ACCESS.uint16_t(memorySegment, value.length() * SIZE_OF_WCHAR, (short) 0);
            } else {
                MEM_ACCESS.setUnicodeString(memorySegment, 0, value.length(), value);
            }
        }

        public LPWSTR(MemorySegment memorySegment, long offset, int size) {
            super(memorySegment, offset, size);
        }

    }

    /**
     * Wrapper for
     * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types#phkey">PHKEY</a>.<p>
     * A pointer to an HKEY.<br>
     * This type is declared in WinDef.h as follows:<br>
     * typedef HKEY *PHKEY;
     * </p>
     */
    public final static class PHKEY extends Winnt.PHANDLE {

        public static PHKEY allocateNative(MemorySession ms) {
            return new PHKEY(MemorySegment.allocateNative(SIZE_OF, ms), 0);
        }

        public static PHKEY allocateNative(HKEY value, MemorySession ms) {
            return new PHKEY(MemorySegment.allocateNative(SIZE_OF, ms), 0, value);
        }

        public PHKEY(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset);
        }

        public PHKEY(MemorySegment memorySegment, long offset, HKEY value) {
            super(memorySegment, offset, value);
        }

        @Override
        protected HKEY createTarget(MemoryAddress value) {
            return HKEY.of(value);
        }

        @Override
        public HKEY dereference() {
            return (HKEY) super.dereference();
        }

        public void setFromHKEY(HKEY target) {
            setFromHANDLE(target);
        }

    }

}
