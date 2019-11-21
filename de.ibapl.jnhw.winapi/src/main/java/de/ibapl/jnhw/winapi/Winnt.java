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
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;

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
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">FILE_SHARE_DELETE</a>
     * Enables subsequent open operations on a file or device to request delete
     * access.
     *
     * @return the native symbolic constant of FILE_SHARE_DELETE.
     */
    @Define
    public final static native int FILE_SHARE_DELETE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">FILE_SHARE_READ</a>
     * Enables subsequent open operations on a file or device to request read
     * access.
     *
     * @return the native symbolic constant of FILE_SHARE_READ.
     */
    @Define
    public final static native int FILE_SHARE_READ();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/fileapi/">FILE_SHARE_WRITE</a>
     * Enables subsequent open operations on a file or device to request write
     * access.
     *
     * @return the native symbolic constant of FILE_SHARE_WRITE.
     */
    @Define
    public final static native int FILE_SHARE_WRITE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/secauthz/generic-access-rights/">GENERIC_ALL</a>
     * All possible access rights
     *
     * @return the native symbolic constant of GENERIC_ALL.
     */
    @Define
    public final static native int GENERIC_ALL();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/secauthz/generic-access-rights/">GENERIC_EXECUTE</a>
     * Execute access
     *
     * @return the native symbolic constant of GENERIC_EXECUTE.
     */
    @Define
    public final static native int GENERIC_EXECUTE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/secauthz/generic-access-rights/">GENERIC_READ</a>
     * Read access
     *
     * @return the native symbolic constant of GENERIC_READ.
     */
    @Define
    public final static native int GENERIC_READ();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/secauthz/generic-access-rights/">GENERIC_WRITE</a>
     * Write access
     *
     * @return the native symbolic constant of GENERIC_WRITE.
     */
    @Define
    public final static native int GENERIC_WRITE();

    public final static native boolean HAVE_WINNT_H();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_ALL_ACCESS</a>
     * Combines the STANDARD_RIGHTS_REQUIRED, KEY_QUERY_VALUE, KEY_SET_VALUE,
     * KEY_CREATE_SUB_KEY, KEY_ENUMERATE_SUB_KEYS, KEY_NOTIFY, and
     * KEY_CREATE_LINK access rights.
     *
     * @return the native symbolic constant of KEY_ALL_ACCESS.
     */
    @Define
    public final static native int KEY_ALL_ACCESS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_CREATE_LINK</a>
     * Reserved for system use.
     *
     * @return the native symbolic constant of KEY_CREATE_LINK.
     */
    @Define
    public final static native int KEY_CREATE_LINK();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_CREATE_SUB_KEY</a>
     * Required to create a subkey of a registry key.
     *
     * @return the native symbolic constant of KEY_CREATE_SUB_KEY.
     */
    @Define
    public final static native int KEY_CREATE_SUB_KEY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_ENUMERATE_SUB_KEYS</a>
     * Required to enumerate the subkeys of a registry key.
     *
     * @return the native symbolic constant of KEY_ENUMERATE_SUB_KEYS.
     */
    @Define
    public final static native int KEY_ENUMERATE_SUB_KEYS();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_EXECUTE</a>
     * Equivalent to KEY_READ.
     *
     * @return the native symbolic constant of KEY_EXECUTE.
     */
    @Define
    public final static native int KEY_EXECUTE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_NOTIFY</a>
     * Required to request change notifications for a registry key or for
     * subkeys of a registry key.
     *
     * @return the native symbolic constant of KEY_NOTIFY.
     */
    @Define
    public final static native int KEY_NOTIFY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_QUERY_VALUE</a>
     * Required to query the values of a registry key.
     *
     * @return the native symbolic constant of KEY_QUERY_VALUE.
     */
    @Define
    public final static native int KEY_QUERY_VALUE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_READ</a>
     * Combines the STANDARD_RIGHTS_READ, KEY_QUERY_VALUE,
     * KEY_ENUMERATE_SUB_KEYS, and KEY_NOTIFY values.
     *
     * @return the native symbolic constant of KEY_READ.
     */
    @Define
    public final static native int KEY_READ();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-key-security-and-access-rights/">KEY_SET_VALUE</a>
     * ombines the STANDARD_RIGHTS_WRITE, KEY_SET_VALUE, and KEY_CREATE_SUB_KEY
     * access rights.
     *
     * @return the native symbolic constant of KEY_SET_VALUE.
     */
    @Define
    public final static native int KEY_SET_VALUE();

    @Define
    public final static native long MAXDWORD();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_BINARY</a>
     * Binary data in any form.
     *
     * @return the native symbolic constant of REG_BINARY.
     */
    @Define
    public final static native int REG_BINARY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_CREATED_NEW_KEY</a>
     * The key did not exist and was created.
     *
     * @return the native symbolic constant of REG_CREATED_NEW_KEY.
     */
    @Define
    public final static native int REG_CREATED_NEW_KEY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_BINARY</a>
     * A 32-bit number.
     *
     * @return the native symbolic constant of REG_BINARY.
     */
    @Define
    public final static native int REG_DWORD();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_DWORD_BIG_ENDIAN</a>
     * A 32-bit number in big-endian format.
     *
     * @return the native symbolic constant of REG_DWORD_BIG_ENDIAN.
     */
    @Define
    public final static native int REG_DWORD_BIG_ENDIAN();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_DWORD_LITTLE_ENDIAN</a>
     * A 32-bit number in little-endian format.
     *
     * @return the native symbolic constant of REG_DWORD_LITTLE_ENDIAN.
     */
    @Define
    public final static native int REG_DWORD_LITTLE_ENDIAN();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_EXPAND_SZ</a>
     * A null-terminated string that contains unexpanded references to
     * environment variables (for example, "%PATH%").
     *
     * @return the native symbolic constant of REG_EXPAND_SZ.
     */
    @Define
    public final static native int REG_EXPAND_SZ();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">XXX</a>
     *
     *
     * @return the native symbolic constant of XXX.
     */
    @Define
    public final static native int REG_FULL_RESOURCE_DESCRIPTOR();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_LINK</a>
     * A null-terminated Unicode string that contains the target path of a
     * symbolic link that was created by calling the RegCreateKeyEx function
     * with {@link REG_OPTION_CREATE_LINK}.
     *
     * @return the native symbolic constant of REG_LINK.
     */
    @Define
    public final static native int REG_LINK();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_MULTI_SZ</a>
     * A sequence of null-terminated strings, terminated by an empty string
     * (\0).
     *
     * @return the native symbolic constant of REG_MULTI_SZ.
     */
    @Define
    public final static native int REG_MULTI_SZ();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_NONE</a>
     * No defined value type.
     *
     * @return the native symbolic constant of REG_NONE.
     */
    @Define
    public final static native int REG_NONE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_OPENED_EXISTING_KEY</a>
     * The key existed and was simply opened without being changed.
     *
     * @return the native symbolic constant of REG_OPENED_EXISTING_KEY.
     */
    @Define
    public final static native int REG_OPENED_EXISTING_KEY();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_OPTION_BACKUP_RESTORE</a>
     * If this flag is set, the function ignores the samDesired parameter and
     * attempts to open the key with the access required to backup or restore
     * the key.The key is a symbolic link.
     *
     * @return the native symbolic constant of REG_OPTION_BACKUP_RESTORE.
     */
    @Define
    public final static native int REG_OPTION_BACKUP_RESTORE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_OPTION_CREATE_LINK</a>
     * This key is a symbolic link. The target path is assigned to the
     * L"SymbolicLinkValue" value of the key.
     *
     * @return the native symbolic constant of REG_OPTION_CREATE_LINK.
     */
    @Define
    public final static native int REG_OPTION_CREATE_LINK();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_OPTION_NON_VOLATILE</a>
     * This key is not volatile; this is the default.
     *
     * @return the native symbolic constant of REG_OPTION_NON_VOLATILE.
     */
    @Define
    public final static native int REG_OPTION_NON_VOLATILE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regopenkeyexw">REG_OPTION_OPEN_LINK</a>
     * The key is a symbolic link.
     *
     * @return the native symbolic constant of REG_OPTION_OPEN_LINK.
     */
    @Define
    public final static native int REG_OPTION_OPEN_LINK();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regcreatekeyexw">REG_OPTION_VOLATILE</a>
     * All keys created by the function are volatile.
     *
     * @return the native symbolic constant of REG_OPTION_VOLATILE.
     */
    @Define
    public final static native int REG_OPTION_VOLATILE();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_QWORD</a>
     * A 64-bit number.
     *
     * @return the native symbolic constant of REG_QWORD.
     */
    @Define
    public final static native int REG_QWORD();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_QWORD_LITTLE_ENDIAN</a>
     * A 64-bit number in little-endian format.
     *
     * @return the native symbolic constant of REG_QWORD_LITTLE_ENDIAN.
     */
    @Define
    public final static native int REG_QWORD_LITTLE_ENDIAN();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">XXX</a>
     *
     *
     * @return the native symbolic constant of XXX.
     */
    @Define
    public final static native int REG_RESOURCE_LIST();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">XXX</a>
     *
     *
     * @return the native symbolic constant of XXX.
     */
    @Define
    public final static native int REG_RESOURCE_REQUIREMENTS_LIST();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types/">REG_SZ</a>
     * A null-terminated string. This will be either a Unicode or an ANSI
     * string, depending on whether you use the Unicode or ANSI functions.
     *
     * @return the native symbolic constant of REG_SZ.
     */
    @Define
    public final static native int REG_SZ();

    /**
     * Wrapper for
     * <a href="https://docs.microsoft.com/en-us/windows/win32/winprog/windows-data-types#handle">HANDLE</a>.<p>
     * A handle to an object.<br>
     * This type is declared in WinNT.h as follows:<br>
     * typedef PVOID HANDLE;
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

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

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
    public static class LPWSTR extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        public final static int SIZE_OF_WCHAR = 2;

        /**
         * Skip the last two 0 bytes aka the last 0 char
         *
         * @param lpData
         * @return
         */
        public static String stringValueOfNullTerminated(Minwindef.LPBYTE lpData) {
            return getString(lpData, lpData.bufferEnd / SIZE_OF_WCHAR - 1);
        }

        int bufferEnd;

        /**
         * Creates space for a Wide String (16 bit)
         *
         * @param elementLength
         * @param clearMemory
         */
        public LPWSTR(int elementLength, boolean clearMemory) {
            super(elementLength, SIZE_OF_WCHAR, clearMemory);
            bufferEnd = elementLength;
        }

//        private static native void setString(long baseAddress, String value);
//        public void set(String value) {
//            setString(baseAddress, value);
//        }
        private static native String getString(OpaqueMemory lpByte, int charLength);

        /**
         * return the NULL terminated string @baseaddress
         *
         * @return
         */
        public String getString() {
            return getString(this, bufferEnd);
        }

        public void clear() {
            OpaqueMemory.clear(this);
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
    public static class PHANDLE extends OpaqueMemory {

        @FunctionalInterface
        protected static interface CreateHandler {

            HANDLE create(long value);

        }

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwWinApiLoader.touch();
        }

        public final static native int sizeofHANDLE();

        HANDLE cachedHandle;

        protected PHANDLE(CreateHandler handler) {
            super(sizeofHANDLE(), true);
            cachedHandle = handler.create(getHandleValue());
        }

        protected PHANDLE(HANDLE handle) {
            super(sizeofHANDLE(), false);
            setHandleValue(handle.value);
            cachedHandle = handle;
        }

        private native long getHandleValue();

        private native void setHandleValue(long value);

        public HANDLE dereference() {
            final long currentValue = getHandleValue();
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
        public String toString() {
            return String.format("{value = 0x%08x}", getHandleValue());
        }

    }

}
