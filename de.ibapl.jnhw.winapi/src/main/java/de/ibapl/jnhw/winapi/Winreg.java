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

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Minwindef.HKEY;
import de.ibapl.jnhw.winapi.Minwindef.PHKEY;
import de.ibapl.jnhw.winapi.Minwindef.LPBYTE;
import de.ibapl.jnhw.winapi.Winnt.LPWSTR;

@Include("winreg.h")
public abstract class Winreg {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwWinApiLoader.touch();
    }

    public final static native boolean HAVE_WINREG_H();

    @Define
    public final static native HKEY HKEY_CLASSES_ROOT();

    @Define
    public final static native HKEY HKEY_CURRENT_USER();

    @Define
    public final static native HKEY HKEY_LOCAL_MACHINE();

    @Define
    public final static native HKEY HKEY_USERS();

    @Define
    public final static native HKEY HKEY_PERFORMANCE_DATA();

    @Define
    public final static native HKEY HKEY_PERFORMANCE_TEXT();

    @Define
    public final static native HKEY HKEY_PERFORMANCE_NLSTEXT();

    @Define
    public final static native HKEY HKEY_CURRENT_CONFIG();

    @Define
    public final static native HKEY HKEY_DYN_DATA();

    public final static native long RegEnumValueW(HKEY hKey, int dwIndex, LPWSTR lpValueName, IntRef lpType, LPBYTE lpData) throws NativeErrorException;

    public final static native long RegOpenKeyExW(HKEY hKey, String lpSubKey, int ulOptions, int samDesired, PHKEY phkResult) throws NativeErrorException;

    public final static native long RegCloseKey(HKEY hKey) throws NativeErrorException;
}
