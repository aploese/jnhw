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
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import de.ibapl.jnhw.winapi.Winnt.HANDLE;

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
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * Wrapper for
     * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types#hkey">HKEY</a>.<p>
     * A handle to a registry key.<br>
     * This type is declared in WinDef.h as follows:<br>
     * typedef HANDLE HKEY;
     * </p>
     */
    public static class HKEY extends HANDLE {

        public HKEY(long value) {
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
    public static class LPBYTE extends Struct32 {

        private final static int SIZE_OF_WCHAR = WinApiDataType.WCHAR.baseDataType.SIZE_OF;

        /**
         * if isNullTerminated do skip the last two 0 bytes aka the last 0 char.
         *
         * @param lpData
         * @return
         */
        public static String getUnicodeString(LPBYTE lpData, boolean isNullTerminated) {
            if (isNullTerminated) {
                return MEM_ACCESS.getUnicodeString(lpData, 0, 0, lpData.bufferEnd / SIZE_OF_WCHAR - 1);
            } else {
                return MEM_ACCESS.getUnicodeString(lpData, 0, 0, lpData.bufferEnd / SIZE_OF_WCHAR);
            }
        }

        int bufferEnd;

        public LPBYTE(int size, Byte setMem) {
            super((OpaqueMemory32) null, 0, size, setMem);
            bufferEnd = size;
        }

        public void clear() {
            OpaqueMemory32.clear(this);
            bufferEnd = sizeInBytes;
        }

        public void resetBufferEnd() {
            bufferEnd = sizeInBytes;
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
    public static class PHKEY extends Winnt.PHANDLE {

        public PHKEY() {
            super((value) -> {
                return new HKEY(value);
            });
        }

        @Override
        public HKEY dereference() {
            return (HKEY) super.dereference();
        }

        @Override
        protected HKEY createTarget(long value) {
            return new HKEY(value);
        }

        public void setFromHKEY(HKEY target) {
            setFromHANDLE(target);
        }

    }
}
