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
public abstract class LibJnhwWinApiLoader extends LibJnhwLoader {
    
    public final static String LIB_JNHW_WIN_API = "jnhw-winapi";

    public static boolean isLibJnhwWinApiLoaded() {
        return isLibLoaded(LIB_JNHW_WIN_API);
    }

    public static String getLibJnhwWinApiLoadedName() {
        return getLibLoadedName(LIB_JNHW_WIN_API);
    }

    static {
        loadLibJnhwWinApi();
    }

    public final static void loadLibJnhwWinApi() {
        loadNativeLib(LIB_JNHW_WIN_API);
    }

    protected LibJnhwWinApiLoader() {
    }

}
