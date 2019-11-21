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
import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Minwindef.HKEY;
import de.ibapl.jnhw.winapi.Minwindef.LPBYTE;
import de.ibapl.jnhw.winapi.Minwindef.PHKEY;
import de.ibapl.jnhw.winapi.Winnt.LPWSTR;

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

    private static HKEY HKEY_CLASSES_ROOT;
    private static HKEY HKEY_CURRENT_CONFIG;
    private static HKEY HKEY_CURRENT_USER;
    private static HKEY HKEY_CURRENT_USER_LOCAL_SETTINGS;
    private static HKEY HKEY_DYN_DATA;
    private static HKEY HKEY_LOCAL_MACHINE;
    private static HKEY HKEY_PERFORMANCE_DATA;
    private static HKEY HKEY_PERFORMANCE_NLSTEXT;
    private static HKEY HKEY_PERFORMANCE_TEXT;
    private static HKEY HKEY_USERS;

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    public static native boolean HAVE_WINREG_H();

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_CLASSES_ROOT</a>
     * Registry entries subordinate to this key define types (or classes) of
     * documents and the properties associated with those types.
     *
     * @return the native symbolic constant of HKEY_CLASSES_ROOT.
     */
    @Define
    public static HKEY HKEY_CLASSES_ROOT() {
        if (HKEY_CLASSES_ROOT == null) {
            HKEY_CLASSES_ROOT = create_HKEY_CLASSES_ROOT();
        }
        return HKEY_CLASSES_ROOT;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_CURRENT_CONFIG</a>
     * Registry entries subordinate to this key define types (or classes) of
     * documents and the properties associated with those types.
     *
     * @return the native symbolic constant of HKEY_CURRENT_CONFIG.
     */
    @Define
    public static HKEY HKEY_CURRENT_CONFIG() {
        if (HKEY_CURRENT_CONFIG == null) {
            HKEY_CURRENT_CONFIG = create_HKEY_CURRENT_CONFIG();
        }
        return HKEY_CURRENT_CONFIG;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_CURRENT_USER</a>
     * Registry entries subordinate to this key define types (or classes) of
     * documents and the properties associated with those types.
     *
     * @return the native symbolic constant of HKEY_CURRENT_USER.
     */
    @Define
    public static HKEY HKEY_CURRENT_USER() {
        if (HKEY_CURRENT_USER == null) {
            HKEY_CURRENT_USER = create_HKEY_CURRENT_USER();
        }
        return HKEY_CURRENT_USER;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_CURRENT_USER_LOCAL_SETTINGS</a>
     * Registry entries subordinate to this key define preferences of the
     * current user that are local to the machine.
     *
     * @return the native symbolic constant of HKEY_CURRENT_USER_LOCAL_SETTINGS.
     */
    @Define
    public static HKEY HKEY_CURRENT_USER_LOCAL_SETTINGS() {
        if (HKEY_CURRENT_USER_LOCAL_SETTINGS == null) {
            HKEY_CURRENT_USER_LOCAL_SETTINGS = create_HKEY_CURRENT_USER_LOCAL_SETTINGS();
        }
        return HKEY_CURRENT_USER_LOCAL_SETTINGS;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_CLASSES_ROOT</a>
     * Registry entries subordinate to this key define types (or classes) of
     * documents and the properties associated with those types.
     *
     * @return the native symbolic constant of HKEY_CLASSES_ROOT.
     */
    @Define
    public static HKEY HKEY_DYN_DATA() {
        if (HKEY_DYN_DATA == null) {
            HKEY_DYN_DATA = create_HKEY_DYN_DATA();
        }
        return HKEY_DYN_DATA;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_LOCAL_MACHINE</a>
     * Registry entries subordinate to this key define the physical state of the
     * computer, including data about the bus type, system memory, and installed
     * hardware and software.
     *
     * @return the native symbolic constant of HKEY_LOCAL_MACHINE.
     */
    @Define
    public static HKEY HKEY_LOCAL_MACHINE() {
        if (HKEY_LOCAL_MACHINE == null) {
            HKEY_LOCAL_MACHINE = create_HKEY_LOCAL_MACHINE();
        }
        return HKEY_LOCAL_MACHINE;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_PERFORMANCE_DATA</a>
     * Registry entries subordinate to this key allow you to access performance
     * data.
     *
     * @return the native symbolic constant of HKEY_PERFORMANCE_DATA.
     */
    @Define
    public static HKEY HKEY_PERFORMANCE_DATA() {
        if (HKEY_PERFORMANCE_DATA == null) {
            HKEY_PERFORMANCE_DATA = create_HKEY_PERFORMANCE_DATA();
        }
        return HKEY_PERFORMANCE_DATA;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_PERFORMANCE_NLSTEXT</a>
     * Registry entries subordinate to this key reference the text strings that
     * describe counters in the local language of the area in which the computer
     * system is running.
     *
     * @return the native symbolic constant of HKEY_PERFORMANCE_NLSTEXT.
     */
    @Define
    public static HKEY HKEY_PERFORMANCE_NLSTEXT() {
        if (HKEY_PERFORMANCE_NLSTEXT == null) {
            HKEY_PERFORMANCE_NLSTEXT = create_HKEY_PERFORMANCE_NLSTEXT();
        }
        return HKEY_PERFORMANCE_NLSTEXT;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_PERFORMANCE_TEXT</a>
     * Registry entries subordinate to this key reference the text strings that
     * describe counters in US English.
     *
     * @return the native symbolic constant of HKEY_PERFORMANCE_TEXT.
     */
    @Define
    public static HKEY HKEY_PERFORMANCE_TEXT() {
        if (HKEY_PERFORMANCE_TEXT == null) {
            HKEY_PERFORMANCE_TEXT = create_HKEY_PERFORMANCE_TEXT();
        }
        return HKEY_PERFORMANCE_TEXT;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/predefined-keys/">HKEY_USERS</a>
     * Registry entries subordinate to this key define the default user
     * configuration for new users on the local computer and the user
     * configuration for the current user.
     *
     * @return the native symbolic constant of HKEY_USERS.
     */
    @Define
    public static HKEY HKEY_USERS() {
        if (HKEY_USERS == null) {
            HKEY_USERS = create_HKEY_USERS();
        }
        return HKEY_USERS;
    }

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regclosekey">RegCloseKey</a>
     * Closes a handle to the specified registry key.
     *
     * @param hKey a handle to an open registry key.
     *
     * @throws NullPointerException if hKey is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void RegCloseKey(HKEY hKey) throws NativeErrorException;

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
     * @param lpType A pointer to a variable that receives a code indicating the
     * type of data stored in the specified value.
     * <a href="https://docs.microsoft.com/en-us/windows/win32/sysinfo/registry-value-types=>Registry
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
     * @throws NullPointerException if hKey or lpValueName or lpType is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native long RegEnumValueW(HKEY hKey, int dwIndex, LPWSTR lpValueName, IntRef lpType, LPBYTE lpData) throws NativeErrorException;

    /**
     * <a href="https://docs.microsoft.com/en-us/windows/win32/api/winreg/nf-winreg-regopenkeyexw">RegOpenKeyExW</a>
     * Opens the specified registry key. Note that key names are not case
     * sensitive.
     *
     * @param hKey a handle to an open registry key.
     * @param lpSubKey the name of the registry subkey to be opened.
     * @param ulOptions specifies the option to apply when opening the key. Set
     * this parameter to zero or the following: {@link REG_OPTION_OPEN_LINK}
     * @param samDesired a mask that specifies the desired access rights to the
     * key to be opened. The function fails if the security descriptor of the
     * key does not permit the requested access for the calling process.
     * @param phkResult a pointer to a variable that receives a handle to the
     * opened key.
     *
     * @throws NullPointerException if hKey or lpSubKey or phkResult is {@code null].
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void RegOpenKeyExW(HKEY hKey, String lpSubKey, int ulOptions, int samDesired, PHKEY phkResult) throws NativeErrorException;

    public static native HKEY create_HKEY_CLASSES_ROOT();

    private static native HKEY create_HKEY_CURRENT_CONFIG();

    private static native HKEY create_HKEY_CURRENT_USER();

    private static native HKEY create_HKEY_CURRENT_USER_LOCAL_SETTINGS();

    private static native HKEY create_HKEY_DYN_DATA();

    private static native HKEY create_HKEY_LOCAL_MACHINE();

    private static native HKEY create_HKEY_PERFORMANCE_DATA();

    private static native HKEY create_HKEY_PERFORMANCE_NLSTEXT();

    private static native HKEY create_HKEY_PERFORMANCE_TEXT();

    private static native HKEY create_HKEY_USERS();
}
