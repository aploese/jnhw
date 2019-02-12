package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwWinApiLoader;
import de.ibapl.jnhw.LongRef;
import de.ibapl.jnhw.winapi.Minwindef.HKEY;
import de.ibapl.jnhw.winapi.Minwindef.PHKEY;
import de.ibapl.jnhw.winapi.Minwindef.LPBYTE;
import de.ibapl.jnhw.winapi.Winnt.LPWSTR;

@Include("winreg.h")
public abstract class Winreg extends LibJnhwWinApiLoader {

    public static class REGSAM extends Winnt.ACCESS_MASK {

        public REGSAM(int value) {
            super(value);
        }

    }

    public final static native boolean HAVE_WINREG_H();

    /**
     * Cached value ... so == will work...
     */
    private static HKEY HKEY_LOCAL_MACHINE;

    @Define
    private static native long HKEY_LOCAL_MACHINE0();

    public final static HKEY HKEY_LOCAL_MACHINE() {
        if (HKEY_LOCAL_MACHINE == null) {
            HKEY_LOCAL_MACHINE = new HKEY(HKEY_LOCAL_MACHINE0());
        }
        return HKEY_LOCAL_MACHINE;
    }

    private static native void RegEnumValueW(long hKey, int dwIndex, long lpValueName, IntRef lpcchValueName, IntRef lpType, long lpData, IntRef lpccData) throws NativeErrorException;

    private static native void RegOpenKeyExW(long hKey, CharSequence lpSubKey, int ulOptions, int samDesired, LongRef phkResult) throws NativeErrorException;

    private static native void RegCloseKey(long hKey);
    
    public final static void RegEnumValueW(HKEY hKey, int dwIndex, LPWSTR lpValueName, IntRef lpcchValueName, IntRef lpType, LPBYTE lpData, IntRef lpccData) throws NativeErrorException {
        final long lpDataBaseAddress = lpData == null ? 0L : lpData.baseAddress;
        RegEnumValueW(hKey.value, dwIndex, lpValueName.baseAddress, lpcchValueName, lpType, lpDataBaseAddress, lpccData);
    }

    public final static void RegOpenKeyExW(HKEY hKey, CharSequence lpSubKey, int ulOptions, REGSAM samDesired, PHKEY phkResult) throws NativeErrorException {
        RegOpenKeyExW(hKey.value, lpSubKey, ulOptions, samDesired.value, phkResult);
    }

    public final static void RegCloseKey(HKEY hKey) throws NativeErrorException {
        RegCloseKey(hKey.value);
    }
}
