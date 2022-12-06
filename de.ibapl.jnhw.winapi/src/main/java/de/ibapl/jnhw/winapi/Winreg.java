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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A__A_uI_uI__A;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A_uI__A__A__A__A__A__A;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.util.winapi.Kernel32Loader;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import de.ibapl.jnhw.winapi.WinDef.HKEY;
import de.ibapl.jnhw.winapi.WinDef.LPBYTE;
import de.ibapl.jnhw.winapi.WinDef.LPDWORD;
import de.ibapl.jnhw.winapi.Winnt.LPWSTR;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;

/**
 * Wrapper around the
 * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/">winreg.h</a>
 * header.
 *
 *
 * @author aploese
 */
@Include("winreg.h")
public abstract class Winreg {

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_CLASSES_ROOT</a>
     * Registry entries subordinate to this key define types (or classes) of
     * documents and the properties associated with those types.
     *
     */
    @Define
    public final static HKEY HKEY_CLASSES_ROOT = HKEY.of(MemoryAddress.ofLong(0x80000000L));

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_CURRENT_CONFIG</a>
     * Registry entries subordinate to this key define types (or classes) of
     * documents and the properties associated with those types.
     *
     */
    @Define
    public final static HKEY HKEY_CURRENT_CONFIG = HKEY.of(MemoryAddress.ofLong(0x80000005L));

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_CURRENT_USER</a>
     * Registry entries subordinate to this key define types (or classes) of
     * documents and the properties associated with those types.
     *
     */
    @Define
    public final static HKEY HKEY_CURRENT_USER = HKEY.of(MemoryAddress.ofLong(0x80000001L));

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_CURRENT_USER_LOCAL_SETTINGS</a>
     * Registry entries subordinate to this key define preferences of the
     * current user that are local to the machine.
     *
     */
    @Define
    public final static HKEY HKEY_CURRENT_USER_LOCAL_SETTINGS = HKEY.of(MemoryAddress.ofLong(0x80000007L));

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_CLASSES_ROOT</a>
     * Registry entries subordinate to this key define types (or classes) of
     * documents and the properties associated with those types.
     *
     */
    @Define
    public final static HKEY HKEY_DYN_DATA = HKEY.of(MemoryAddress.ofLong(0x80000006L));

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_LOCAL_MACHINE</a>
     * Registry entries subordinate to this key define the physical state of the
     * computer, including data about the bus type, system memory, and installed
     * hardware and software.
     *
     */
    @Define
    public final static HKEY HKEY_LOCAL_MACHINE = HKEY.of(MemoryAddress.ofLong(0x80000002L));

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_PERFORMANCE_DATA</a>
     * Registry entries subordinate to this key allow you to access performance
     * data.
     *
     */
    @Define
    public final static HKEY HKEY_PERFORMANCE_DATA = HKEY.of(MemoryAddress.ofLong(0x80000004L));

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_PERFORMANCE_NLSTEXT</a>
     * Registry entries subordinate to this key reference the text strings that
     * describe counters in the local language of the area in which the computer
     * system is running.
     *
     */
    @Define
    public final static HKEY HKEY_PERFORMANCE_NLSTEXT = HKEY.of(MemoryAddress.ofLong(0x80000060L));

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_PERFORMANCE_TEXT</a>
     * Registry entries subordinate to this key reference the text strings that
     * describe counters in US English.
     *
     */
    @Define
    public final static HKEY HKEY_PERFORMANCE_TEXT = HKEY.of(MemoryAddress.ofLong(0x80000050L));

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_USERS</a>
     * Registry entries subordinate to this key define the default user
     * configuration for new users on the local computer and the user
     * configuration for the current user.
     *
     */
    @Define
    public final static HKEY HKEY_USERS = HKEY.of(MemoryAddress.ofLong(0x80000003L));

    private final static JnhwMh_sI___A RegCloseKey = JnhwMh_sI___A.of(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "RegCloseKey",
            WinApiDataType.LSTATUS,
            WinApiDataType.HKEY);

    private final static JnhwMh_sI___A_uI__A__A__A__A__A__A RegEnumValueW = JnhwMh_sI___A_uI__A__A__A__A__A__A.of(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "RegEnumValueW",
            WinApiDataType.LSTATUS,
            WinApiDataType.HKEY,
            WinApiDataType.DWORD,
            WinApiDataType.LPWSTR,
            WinApiDataType.LPDWORD,
            WinApiDataType.LPDWORD,
            WinApiDataType.LPDWORD,
            WinApiDataType.LPBYTE,
            WinApiDataType.LPDWORD);

    private final static JnhwMh_sI___A__A_uI_uI__A RegOpenKeyExW = JnhwMh_sI___A__A_uI_uI__A.of(
            Kernel32Loader.DLL_KERNEL32_SYMBOL_LOOKUP,
            "RegOpenKeyExW",
            WinApiDataType.LSTATUS,
            WinApiDataType.HKEY,
            WinApiDataType.LPCWSTR,
            WinApiDataType.DWORD,
            WinApiDataType.REGSAM,
            WinApiDataType.PHKEY);

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regclosekey">RegCloseKey</a>
     * Closes a handle to the specified registry key.
     *
     * @param hKey a handle to an open registry key.
     *
     * @throws NullPointerException if hKey is {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void RegCloseKey(HKEY hKey) throws NativeErrorException {
        final int result = RegCloseKey.invoke_sI___P(hKey);
        if (result != Winerror.ERROR_SUCCESS) {
            throw new NativeErrorException(result);
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regenumvaluew">RegEnumValueW</a>
     * Enumerates the values for the specified open registry key.The function
     * copies one indexed value name and data block for the key each time it is
     * called.
     *
     * @param hKey A handle to an open registry key. The key must have been
     * opened with the KEY_QUERY_VALUE access right.
     * @param dwIndex The index of the value to be retrieved. This parameter
     * should be zero for the first call to the RegEnumValue function and then
     * be incremented for subsequent calls.
     * @param lpValueName A pointer to a buffer that receives the name of the
     * value as a null-terminated string.
     * @param lpcchValueName A pointer to a variable that specifies the size of
     * the buffer pointed to by the lpValueName parameter, in characters. When
     * the function returns, the variable receives the number of characters
     * stored in the buffer, not including the terminating null character.
     * @param lpType A pointer to a variable that receives a code indicating the
     * type of data stored in the specified value.
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types">Registry
     * Value Types</a>
     * @param lpData A pointer to a buffer that receives the data for the value
     * entry. This parameter can be NULL if the data is not required.
     * @return
     * <ul>
     * <li>ERROR_SUCCESS</li>
     * <li>ERROR_NO_MORE_ITEMS if there are no more values available</li>
     * <li>ERROR_MORE_DATA if the lpData buffer is too small to receive the
     * value.</li>
     * </ul>
     *
     * @throws NullPointerException if hKey or lpValueName or lpType is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int RegEnumValueW(HKEY hKey, int dwIndex, LPWSTR lpValueName, LPDWORD lpcchValueName, LPDWORD lpType, LPBYTE lpData, LPDWORD lpccData) throws NativeErrorException {
        final int result = RegEnumValueW.invoke_sI___P_uI__P__P__P__P__P__P(
                hKey,
                dwIndex,
                lpValueName,
                lpcchValueName,
                Pointer.NULL,
                lpType,
                lpData,
                lpccData);
        switch (result) {
            case Winerror.ERROR_SUCCESS, Winerror.ERROR_NO_MORE_ITEMS, Winerror.ERROR_MORE_DATA -> {
                return result;
            }
            default ->
                throw new NativeErrorException(result);
        }
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regopenkeyexw">RegOpenKeyExW</a>
     * Opens the specified registry key. Note that key names are not case
     * sensitive. The RegistryHKEY is designd for try-with-resource it
     * implements the interface AutoClosable.
     *
     * @param hKey a handle to an open registry key.
     * @param lpSubKey the name of the registry subkey to be opened.
     * @param ulOptions specifies the option to apply when opening the key. Set
     * this parameter to zero or the following:
     * {@link Winnt#REG_OPTION_OPEN_LINK()}
     * @param samDesired a mask that specifies the desired access rights to the
     * key to be opened. The function fails if the security descriptor of the
     * key does not permit the requested access for the calling process.
     * @param phkResult a pointer to a variable that receives a handle to the
     * opened key.
     *
     * @throws NullPointerException if hKey or lpSubKey or phkResult is
     * {@code null}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void RegOpenKeyExW(HKEY hKey, String lpSubKey, int ulOptions, int samDesired, WinDef.PHKEY phkResult) throws NativeErrorException {
        try ( MemorySession ms = MemorySession.openConfined()) {
            Pointer<WinDef.LPWSTR> _lpSubKey = lpSubKey != null ? WinDef.LPWSTR.wrap(lpSubKey, true, ms) : Pointer.NULL;
            final int result = RegOpenKeyExW.invoke_sI___P__P_uI_uI__P(
                    hKey,
                    _lpSubKey,
                    ulOptions,
                    samDesired,
                    phkResult);
            if (result != Winerror.ERROR_SUCCESS) {
                throw new NativeErrorException(result);
            }
        }
    }

}
