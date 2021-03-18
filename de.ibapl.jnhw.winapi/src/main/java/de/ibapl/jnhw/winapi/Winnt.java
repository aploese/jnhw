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

import de.ibapl.jnhw.annotation.winapi.basetsd.ULONG_PTR;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.callback.Callback_IJ_V_Impl;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import de.ibapl.jnhw.util.winapi.memory.WinApiStruct32;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winnt/">winnt.h</a>
 * header.
 *
 *
 * @author aploese
 */
@Include("winnt.h")
public final class Winnt {

    /**
     * Make sure the native lib is loaded
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwWinApiLoader.touch();

        HAVE_WINNT_H = false;

        FILE_SHARE_DELETE = 0;
        FILE_SHARE_READ = 0;
        FILE_SHARE_WRITE = 0;

        GENERIC_ALL = 0;
        GENERIC_EXECUTE = 0;
        GENERIC_READ = 0;
        GENERIC_WRITE = 0;

        KEY_ALL_ACCESS = 0;
        KEY_CREATE_LINK = 0;
        KEY_CREATE_SUB_KEY = 0;
        KEY_ENUMERATE_SUB_KEYS = 0;
        KEY_EXECUTE = 0;
        KEY_NOTIFY = 0;
        KEY_QUERY_VALUE = 0;
        KEY_READ = 0;
        KEY_SET_VALUE = 0;

        MAXDWORD = 0;

        REG_BINARY = 0;
        REG_CREATED_NEW_KEY = 0;
        REG_DWORD = 0;
        REG_DWORD_BIG_ENDIAN = 0;
        REG_DWORD_LITTLE_ENDIAN = 0;
        REG_EXPAND_SZ = 0;
        REG_FULL_RESOURCE_DESCRIPTOR = 0;
        REG_LINK = 0;
        REG_MULTI_SZ = 0;
        REG_NONE = 0;
        REG_OPENED_EXISTING_KEY = 0;
        REG_OPTION_BACKUP_RESTORE = 0;
        REG_OPTION_CREATE_LINK = 0;
        REG_OPTION_NON_VOLATILE = 0;
        REG_OPTION_OPEN_LINK = 0;
        REG_OPTION_VOLATILE = 0;
        REG_QWORD = 0;
        REG_QWORD_LITTLE_ENDIAN = 0;
        REG_RESOURCE_LIST = 0;
        REG_RESOURCE_REQUIREMENTS_LIST = 0;
        REG_SZ = 0;

        initFields();
    }

    private static native void initFields();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">FILE_SHARE_DELETE</a>
     * Enables subsequent open operations on a file or device to request delete
     * access.
     *
     */
    @Define
    public final static int FILE_SHARE_DELETE;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">FILE_SHARE_READ</a>
     * Enables subsequent open operations on a file or device to request read
     * access.
     *
     */
    @Define
    public final static int FILE_SHARE_READ;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">FILE_SHARE_WRITE</a>
     * Enables subsequent open operations on a file or device to request write
     * access.
     *
     */
    @Define
    public final static int FILE_SHARE_WRITE;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/secauthz/generic-access-rights/">GENERIC_ALL</a>
     * All possible access rights
     *
     */
    @Define
    public final static int GENERIC_ALL;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/secauthz/generic-access-rights/">GENERIC_EXECUTE</a>
     * Execute access
     *
     */
    @Define
    public final static int GENERIC_EXECUTE;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/secauthz/generic-access-rights/">GENERIC_READ</a>
     * Read access
     *
     */
    @Define
    public final static int GENERIC_READ;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/secauthz/generic-access-rights/">GENERIC_WRITE</a>
     * Write access
     *
     */
    @Define
    public final static int GENERIC_WRITE;

    public final static boolean HAVE_WINNT_H;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_ALL_ACCESS</a>
     * Combines the STANDARD_RIGHTS_REQUIRED, KEY_QUERY_VALUE, KEY_SET_VALUE,
     * KEY_CREATE_SUB_KEY, KEY_ENUMERATE_SUB_KEYS, KEY_NOTIFY, and
     * KEY_CREATE_LINK access rights.
     *
     */
    @Define
    public final static int KEY_ALL_ACCESS;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_CREATE_LINK</a>
     * Reserved for system use.
     *
     */
    @Define
    public final static int KEY_CREATE_LINK;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_CREATE_SUB_KEY</a>
     * Required to create a subkey of a registry key.
     *
     */
    @Define
    public final static int KEY_CREATE_SUB_KEY;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_ENUMERATE_SUB_KEYS</a>
     * Required to enumerate the subkeys of a registry key.
     *
     */
    @Define
    public final static int KEY_ENUMERATE_SUB_KEYS;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_EXECUTE</a>
     * Equivalent to KEY_READ.
     *
     */
    @Define
    public final static int KEY_EXECUTE;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_NOTIFY</a>
     * Required to request change notifications for a registry key or for
     * subkeys of a registry key.
     *
     */
    @Define
    public final static int KEY_NOTIFY;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_QUERY_VALUE</a>
     * Required to query the values of a registry key.
     *
     */
    @Define
    public final static int KEY_QUERY_VALUE;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_READ</a>
     * Combines the STANDARD_RIGHTS_READ, KEY_QUERY_VALUE,
     * KEY_ENUMERATE_SUB_KEYS, and KEY_NOTIFY values.
     *
     */
    @Define
    public final static int KEY_READ;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_SET_VALUE</a>
     * ombines the STANDARD_RIGHTS_WRITE, KEY_SET_VALUE, and KEY_CREATE_SUB_KEY
     * access rights.
     *
     */
    @Define
    public final static int KEY_SET_VALUE;

    /**
     * unsigned long int so to preserve the signess use javas long
     */
    @Define
    public final static long MAXDWORD;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_BINARY</a>
     * Binary data in any form.
     *
     */
    @Define
    public final static int REG_BINARY;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_CREATED_NEW_KEY</a>
     * The key did not exist and was created.
     *
     */
    @Define
    public final static int REG_CREATED_NEW_KEY;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_BINARY</a>
     * A 32-bit number.
     *
     */
    @Define
    public final static int REG_DWORD;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_DWORD_BIG_ENDIAN</a>
     * A 32-bit number in big-endian format.
     *
     */
    @Define
    public final static int REG_DWORD_BIG_ENDIAN;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_DWORD_LITTLE_ENDIAN</a>
     * A 32-bit number in little-endian format.
     *
     */
    @Define
    public final static int REG_DWORD_LITTLE_ENDIAN;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_EXPAND_SZ</a>
     * A null-terminated string that contains unexpanded references to
     * environment variables (for example, "%PATH%").
     *
     */
    @Define
    public final static int REG_EXPAND_SZ;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">XXX</a>
     *
     */
    @Define
    public final static int REG_FULL_RESOURCE_DESCRIPTOR;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_LINK</a>
     * A null-terminated Unicode string that contains the target path of a
     * symbolic link that was created by calling the RegCreateKeyEx function
     * with {@link REG_OPTION_CREATE_LINK}.
     *
     */
    @Define
    public final static int REG_LINK;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_MULTI_SZ</a>
     * A sequence of null-terminated strings, terminated by an empty string
     * (\0).
     *
     */
    @Define
    public final static int REG_MULTI_SZ;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_NONE</a>
     * No defined value type.
     *
     */
    @Define
    public final static int REG_NONE;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_OPENED_EXISTING_KEY</a>
     * The key existed and was simply opened without being changed.
     *
     */
    @Define
    public final static int REG_OPENED_EXISTING_KEY;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_OPTION_BACKUP_RESTORE</a>
     * If this flag is set, the function ignores the samDesired parameter and
     * attempts to open the key with the access required to backup or restore
     * the key.The key is a symbolic link.
     *
     */
    @Define
    public final static int REG_OPTION_BACKUP_RESTORE;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_OPTION_CREATE_LINK</a>
     * This key is a symbolic link. The target path is assigned to the
     * L"SymbolicLinkValue" value of the key.
     *
     */
    @Define
    public final static int REG_OPTION_CREATE_LINK;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_OPTION_NON_VOLATILE</a>
     * This key is not volatile; this is the default.
     *
     */
    @Define
    public final static int REG_OPTION_NON_VOLATILE;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regopenkeyexw">REG_OPTION_OPEN_LINK</a>
     * The key is a symbolic link.
     *
     */
    @Define
    public final static int REG_OPTION_OPEN_LINK;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_OPTION_VOLATILE</a>
     * All keys created by the function are volatile.
     *
     */
    @Define
    public final static int REG_OPTION_VOLATILE;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_QWORD</a>
     * A 64-bit number.
     *
     */
    @Define
    public final static int REG_QWORD;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_QWORD_LITTLE_ENDIAN</a>
     * A 64-bit number in little-endian format.
     *
     */
    @Define
    public final static int REG_QWORD_LITTLE_ENDIAN;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">XXX</a>
     *
     */
    @Define
    public final static int REG_RESOURCE_LIST;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">XXX</a>
     *
     */
    @Define
    public final static int REG_RESOURCE_REQUIREMENTS_LIST;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_SZ</a>
     * A null-terminated string. This will be either a Unicode or an ANSI
     * string, depending on whether you use the Unicode or ANSI functions.
     *
     */
    @Define
    public final static int REG_SZ;

    /**
     * Wrapper for
     * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types#handle">HANDLE</a>.<p>
     * A handle to an object.<br>
     * This type is declared in WinNT.h as follows:<br>
     * typedef PVOID HANDLE; LONG_PTR is used for INVALID_HANDLE_VALUE == -1.
     * </p>
     */
    public static class HANDLE {

        final static long INVALID_HANDLE_VALUE__VALUE = -1L;

        final static long NULL__VALUE = 0L;

        public final static HANDLE NULL = new HANDLE(NULL__VALUE);
        /**
         * Handleapi.INVALID_HANDLE_VALUE()
         */
        public final static HANDLE INVALID_HANDLE_VALUE = new HANDLE(INVALID_HANDLE_VALUE__VALUE);

        private final long value;

        protected HANDLE(long value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 11 * hash + (int) (this.value ^ (this.value >>> 32));
            return hash;
        }

        /**
         * TODO implement Windows equals system...
         *
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final HANDLE other = (HANDLE) obj;
            return this.value == other.value;
        }

        @Override
        public String toString() {
            return String.format("{value = 0x%08x}", value);
        }

        public boolean isNot_INVALID_HANDLE_VALUE() {
            return value != INVALID_HANDLE_VALUE__VALUE;
        }

        public boolean is_INVALID_HANDLE_VALUE() {
            return value == INVALID_HANDLE_VALUE__VALUE;
        }

        public boolean is_NULL() {
            return value == NULL__VALUE;
        }

        public boolean isNot_NULL() {
            return value != NULL__VALUE;
        }

        public static HANDLE of(long value) {
            if (value == 0L) {
                return NULL;
            } else {
                return new HANDLE(value);
            }
        }

        public static long getHandleValue(HANDLE handle) {
            return handle.value;
        }

    }

    public static class ArrayOfHandle extends WinApiStruct32 {

        public final int length;

        public void set(int i, HANDLE element) {
            if (i < 0) {
                throw new IllegalArgumentException("i < 0");
            } else if (i >= length) {
                throw new IllegalArgumentException("i >= length");
            }
            MEM_ACCESS.uintptr_t_AtIndex(this, 0, i, element.value);
        }

        public ArrayOfHandle(int length, Byte setMem) {
            super((OpaqueMemory32) null, 0, length * WinApiDataType.HANDLE.baseDataType.SIZE_OF, setMem);
            this.length = length;
        }

        public final HANDLE get(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("i < 0");
            } else if (i >= length) {
                throw new IllegalArgumentException("i >= length");
            }
            return new HANDLE(MEM_ACCESS.uintptr_t_AtIndex(this, 0, i));
        }

        @Override
        public String nativeToString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                } else {
                    sb.append(", ");
                }
                sb.append(get(i));
            }
            sb.append("]");
            return sb.toString();
        }

    }

    /**
     * Wrapper for
     * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types#lpwstr">LPWSTR</a>.<p>
     *
     * A pointer to a null-terminated string of 16-bit Unicode characters. For
     * more information, see
     * <a href="https://docs.microsoft.com/en-us/windows/win32/gdi/character-sets-used-by-fonts">Character
     * Sets Used By Fonts</a>.<br>
     * This type is declared in WinNT.h as follows:<br>
     * typedef WCHAR *LPWSTR;
     * </p>
     *
     * The wrapper for a byte buffer. The position of the buffer is always 0! It
     * must be reset to 0 if changed. The limit of the buffer is always amount
     * of valid bytes in the buffer and must be set if the amount of valid bytes
     * changed.
     */
    public static class LPWSTR extends WinApiStruct32 {

        private final static int SIZE_OF_WCHAR = WinApiDataType.WCHAR.baseDataType.SIZE_OF;

        int bufferEnd;

        /**
         * Creates space for a Wide String (16 bit)
         *
         * @param elementLength
         */
        public LPWSTR(int elementLength, Byte setMem) {
            super((OpaqueMemory32) null, 0, elementLength * SIZE_OF_WCHAR, setMem);
            bufferEnd = elementLength;
        }

        /**
         * return the NULL terminated string @baseaddress
         *
         * @return
         */
        public String getUnicodeString() {
            return MEM_ACCESS.getUnicodeString(this, 0, 0, bufferEnd);
        }

        public void clear() {
            OpaqueMemory32.clear(this);
            bufferEnd = sizeInBytes / SIZE_OF_WCHAR;
        }

        public void resetBufferEnd() {
            bufferEnd = sizeInBytes;
        }

    }

    /**
     * Wrapper for
     * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types#phandle">PHANDLE</a>.<p>
     * A pointer to a HANDLE.<br>
     * This type is declared in WinNT.h as follows:<br>
     * typedef HANDLE *PHANDLE;
     * </p>
     */
    public static class PHANDLE extends OpaqueMemory32 {

        private final static int SIZE_OF = WinApiDataType.PHANDLE.baseDataType.SIZE_OF;

        @Override
        public BaseDataType getBaseDataType() {
            return WinApiDataType.PHANDLE.baseDataType;
        }

        @Override
        public String nativeToHexString() {
            return MEM_ACCESS.uintptr_t_AsHex(this, 0);
        }

        @FunctionalInterface
        protected static interface CreateHandler {

            HANDLE create(long value);

        }

        HANDLE cachedHandle;

        private void setHandleValue(long value) {
            MEM_ACCESS.uintptr_t(this, 0, value);
        }

        private long getHandleValue() {
            return MEM_ACCESS.uintptr_t(this, 0);
        }

        protected PHANDLE(CreateHandler handler) {
            super((OpaqueMemory32) null, 0, SIZE_OF, SET_MEM_TO_0);
            cachedHandle = handler.create(getHandleValue());
        }

        protected PHANDLE(HANDLE handle) {
            super((OpaqueMemory32) null, 0, SIZE_OF, MEM_UNINITIALIZED);
            setHandleValue(handle.value);
            cachedHandle = handle;
        }

        public HANDLE dereference() {
            final long currentValue = MEM_ACCESS.uintptr_t(this, 0);
            if (cachedHandle.value != currentValue) {
                //cached is not valid anymore, create new one...
                cachedHandle = createTarget(currentValue);
            }
            return cachedHandle;
        }

        /**
         * Must be overwritten in subclasses.
         *
         * @param value
         * @return
         */
        protected HANDLE createTarget(long value) {
            return new HANDLE(value);
        }

        public void setFromHANDLE(HANDLE target) {
            setHandleValue(((HANDLE) target).value);
        }

        @Override
        public String nativeToString() {
            return String.format("{value = 0x%08x}", getHandleValue());
        }

    }

    public abstract static class PAPCFUNC extends Callback_IJ_V_Impl {

        /**
         * this will be called from the native code on 32 bit.
         *
         * @param value
         */
        protected abstract void callback(@ULONG_PTR long value);

        /**
         * this will be called from the native code on 64 bit.
         *
         * @param value
         */
        protected abstract void callback(@ULONG_PTR int value);

    }

}
