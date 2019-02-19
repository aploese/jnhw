/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw;

/**
 *
 * @author aploese
 */
public abstract class LibJnhwLoader {

    public final static String LIB_JNHW = "jnhw";
    public final static int LIB_JNHW_VERSION = 0;
    public final static String LIB_JNHW_COMMON = "jnhw-common";
    public final static int LIB_JNHW_COMMON_VERSION = 0;

    static {
        loadLibJnhw();
    }

    protected LibJnhwLoader() {

    }

    protected static void loadLibJnhw() {
        NativeLibLoader.loadNativeLib(LIB_JNHW_COMMON, LIB_JNHW_COMMON_VERSION);
        NativeLibLoader.loadNativeLib(LIB_JNHW, LIB_JNHW_VERSION);
    }

    public static boolean isLibJnhwLoaded() {
        return NativeLibLoader.isLibLoaded(LIB_JNHW);
    }

    public static String getLibJnhwLoadedName() {
            return NativeLibLoader.getLibLoadedName(LIB_JNHW);            
    }
}
