package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.LibJnhwLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.OS;
import de.ibapl.jnhw.winapi.Minwindef.LPBYTE;
import de.ibapl.jnhw.winapi.Minwindef.PHKEY;
import de.ibapl.jnhw.winapi.Winnt.LPWSTR;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinregTests {

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void test_HAVE_WINREG_H() throws Exception {
        if (LibJnhwLoader.getOS() == OS.WINDOWS) {
            Assertions.assertTrue(Winreg.HAVE_WINREG_H(), "expected to have winreg.h");
        } else {
            Assertions.assertFalse(Winreg.HAVE_WINREG_H(), "not expected to have winreg.h");
        }
    }

    @Test
    public void testRegOpenKey() throws Exception {
        Assumptions.assumeTrue(LibJnhwLoader.getOS() == OS.WINDOWS);
        String testKeyStr = "HARDWARE\\DESCRIPTION\\System";
        PHKEY testKey = new PHKEY();
        Winreg.RegOpenKeyExW(Winreg.HKEY_LOCAL_MACHINE(), testKeyStr, 0, Winnt.KEY_READ(), testKey);
        assertFalse(testKey.value == 0, "PHKEY is 0");
        int dwIndex = 0;
        LPWSTR lpValueName = new LPWSTR(256, true);
        LPBYTE lpData = new LPBYTE(256, false);
        IntRef lpType = new IntRef();
        boolean collecting = true;
        do {
            long result = Winreg.RegEnumValueW(testKey, dwIndex, lpValueName, lpType, lpData);
            if (result == Winerror.ERROR_SUCCESS()) {
                System.out.print("lpValueName: " + lpValueName.getString());
                if (lpType.value == Winnt.REG_SZ()) {
                System.out.println(" = " + LPWSTR.stringValueOf(lpData));
                } else if (lpType.value == Winnt.REG_MULTI_SZ()) {
                    System.out.println(" = " + LPWSTR.stringValueOf(lpData));
                } else {
                    System.out.println(" = ???");
                }
                lpValueName.resetBufferEnd();
                //TODO test bufferEnd  =1 ...
                lpData.resetBufferEnd();;
                dwIndex++;
            } else if (result == Winerror.ERROR_NO_MORE_ITEMS()) {
                collecting = false;
            } else if (result == Winerror.ERROR_MORE_DATA()) {
                lpData.resetBufferEnd();

            }
        } while (collecting);

        Winreg.RegCloseKey(testKey);

    }

}
