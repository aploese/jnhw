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

import de.ibapl.jnhw.winapi.WinDef.LPBYTE;
import de.ibapl.jnhw.winapi.WinDef.LPDWORD;
import de.ibapl.jnhw.winapi.Winnt.LPWSTR;
import java.lang.foreign.Arena;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class WinregTest {

    private Arena ms;

    @BeforeEach
    public void setUp() throws Exception {
        ms = Arena.openConfined();
    }

    @AfterEach
    public void tearDown() throws Exception {
        ms.close();
    }

    @Test
    public void testRegOpenKey() throws Exception {
        String testKeyStr = "HARDWARE\\DESCRIPTION\\System";
        WinDef.PHKEY phkResult = WinDef.PHKEY.allocateNative(ms.scope());
        Winreg.RegOpenKeyExW(Winreg.HKEY_LOCAL_MACHINE, testKeyStr, 0, Winnt.KEY_READ, phkResult);
        WinDef.HKEY testKey = phkResult.dereference();
        try {
            Assertions.assertFalse(testKey.is_INVALID_HANDLE_VALUE(), "RegistryHKEY is not valid");
            int dwIndex = 0;
            LPWSTR lpValueName = LPWSTR.allocateNative(256, ms.scope());
            LPDWORD lpcchValueName = LPDWORD.allocateNative(ms.scope());
            lpcchValueName.uint32_t(LPWSTR.getWCHAR_Length(lpValueName));
            LPBYTE lpData = LPBYTE.allocateNative(256, ms.scope());
            LPDWORD lpccData = LPDWORD.allocateNative(ms.scope());
            lpccData.uint32_t((int) lpData.sizeof());
            LPDWORD lpType = LPDWORD.allocateNative(ms.scope());
            boolean collecting = true;
            do {
                long result = Winreg.RegEnumValueW(testKey, dwIndex, lpValueName, lpcchValueName, lpType, lpData, lpccData);
                if (result == Winerror.ERROR_SUCCESS) {
                    System.out.print("lpValueName: " + lpValueName.getUnicodeString(lpcchValueName.uint32_t()));
                    switch (lpType.uint32_t()) {
                        case Winnt.REG_SZ ->
                            System.out.println(" = " + LPBYTE.getUnicodeString(lpData, true, lpccData.uint32_t()));
                        case Winnt.REG_MULTI_SZ ->
                            System.out.println(" = " + LPBYTE.getUnicodeString(lpData, true, lpccData.uint32_t()));
                        default ->
                            System.out.println(" ... Winnt.Reg*:" + lpType.uint32_t());
                    }
                    lpcchValueName.uint32_t(LPWSTR.getWCHAR_Length(lpValueName));
                    lpccData.uint32_t((int) lpData.sizeof());
                    dwIndex++;
                } else if (result == Winerror.ERROR_NO_MORE_ITEMS) {
                    collecting = false;
                } else if (result == Winerror.ERROR_MORE_DATA) {
                    lpccData.uint32_t((int) lpData.sizeof());
                }
            } while (collecting);
        } finally {
            Winreg.RegCloseKey(testKey);
        }
    }

}
