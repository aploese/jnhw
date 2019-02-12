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

    private static native long RegEnumValueW(long hKey, int dwIndex, long lpValueName, IntRef lpcchValueName, IntRef lpType, long lpData, IntRef lpccData);

    private static native long RegOpenKeyExW(long hKey, String lpSubKey, int ulOptions, int samDesired, LongRef phkResult);

    private static native long RegCloseKey(long hKey);
    
    public final static long RegEnumValueW(HKEY hKey, int dwIndex, LPWSTR lpValueName, IntRef lpType, LPBYTE lpData) {
        final long lpDataBaseAddress = lpData == null ? 0L : lpData.baseAddress;
        final IntRef lpDataBufferEnd = lpData == null ? null : lpData.bufferEnd;
        return RegEnumValueW(hKey.value, dwIndex, lpValueName.baseAddress, lpValueName.bufferEnd, lpType, lpDataBaseAddress, lpDataBufferEnd);
    }

    public final static long RegOpenKeyExW(HKEY hKey, String lpSubKey, int ulOptions, int samDesired, PHKEY phkResult) {
        return RegOpenKeyExW(hKey.value, lpSubKey, ulOptions, samDesired, phkResult);
    }

    public final static long RegCloseKey(HKEY hKey) throws NativeErrorException {
        return RegCloseKey(hKey.value);
    }
}
