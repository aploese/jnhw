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

import de.ibapl.jnhw.common.memory.AbstractNativeMemory.SetMem;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.util.winapi.WinApiDataType;
import de.ibapl.jnhw.winapi.WinDef.LPBYTE;
import de.ibapl.jnhw.winapi.WinDef.LPDWORD;
import de.ibapl.jnhw.winapi.Winnt.LPWSTR;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;

@EnabledOnOs(org.junit.jupiter.api.condition.OS.WINDOWS)
public class WinregTest {

    @Test
    public void testRegOpenKey() throws Exception {
        String testKeyStr = "HARDWARE\\DESCRIPTION\\System";
        try (WinDef.RegistryHKEY testKey = Winreg.RegOpenKeyExW(Winreg.HKEY_LOCAL_MACHINE, testKeyStr, 0, Winnt.KEY_READ)) {
            Assertions.assertFalse(testKey.is_INVALID_HANDLE_VALUE(), "RegistryHKEY is not valid");
            int dwIndex = 0;
            LPWSTR lpValueName = new LPWSTR(256, SetMem.TO_0x00);
            LPDWORD lpcchValueName = new LPDWORD();
            lpcchValueName.uint32_t(LPWSTR.getWCHAR_Length(lpValueName));
            LPBYTE lpData = new LPBYTE(256, SetMem.TO_0x00);
            LPDWORD lpccData = new LPDWORD();
            lpccData.uint32_t(lpData.sizeInBytes);
            LPDWORD lpType = new LPDWORD();
            boolean collecting = true;
            do {
                long result = Winreg.RegEnumValueW(testKey, dwIndex, lpValueName, lpcchValueName, lpType, lpData, lpccData);
                if (result == Winerror.ERROR_SUCCESS) {
                    System.out.print("lpValueName: " + lpValueName.getUnicodeString(lpcchValueName.uint32_t()));
                    switch (lpType.uint32_t()) {
                        case Winnt.REG_SZ:
                            System.out.println(" = " + LPBYTE.getUnicodeString(lpData, true, lpccData.uint32_t()));
                            break;
                        case Winnt.REG_MULTI_SZ:
                            System.out.println(" = " + LPBYTE.getUnicodeString(lpData, true, lpccData.uint32_t()));
                            break;
                        default:
                            System.out.println(" ... Winnt.Reg*:" + lpType.uint32_t());
                    }
                    lpcchValueName.uint32_t(LPWSTR.getWCHAR_Length(lpValueName));
                    lpccData.uint32_t(lpData.sizeInBytes);
                    dwIndex++;
                } else if (result == Winerror.ERROR_NO_MORE_ITEMS) {
                    collecting = false;
                } else if (result == Winerror.ERROR_MORE_DATA) {
                    lpccData.uint32_t(lpData.sizeInBytes);
                }
            } while (collecting);
        }
    }

}
