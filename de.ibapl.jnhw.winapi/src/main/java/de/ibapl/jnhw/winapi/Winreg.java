package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.IntRef;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.winapi.Minwindef.HKEY;
import de.ibapl.jnhw.winapi.Winnt.LPWSTR;

@Include("winreg.h")
public abstract class Winreg {

    public static class REGSAM extends Winnt.ACCESS_MASK {

        public static REGSAM of(int value) {
            return new REGSAM(value);
        }

        private REGSAM(int value) {
            super(value);
        }

    }

    @Define
    public final static native HKEY HKEY_LOCAL_MACHINE();

    public final static native void RegEnumValueW(HKEY hKey, int dwIndex, LPWSTR lpValueName, IntRef lpType, Minwindef.LPBYTE lpData) throws  NativeErrorException;
    public final static native void RegOpenKeyExW(HKEY hKey, String lpSubKey, int ulOptions, REGSAM samDesired, Minwindef.PHKEY phkResult) throws NativeErrorException;
}
