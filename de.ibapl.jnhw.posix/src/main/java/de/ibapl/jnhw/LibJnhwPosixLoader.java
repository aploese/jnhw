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
public abstract class LibJnhwPosixLoader extends LibJnhwLoader {
    
    public final static String LIB_JNHW_POSIX = "jnhw-posix";

    public static boolean isLibJnhwPosixLoaded() {
        return isLibLoaded(LIB_JNHW_POSIX);
    }

    public static String getLibJnhwPosixLoadedName() {
        return getLibLoadedName(LIB_JNHW_POSIX);
    }

    

    static {
        loadLibJnhwPosix();
    }

    public final static void loadLibJnhwPosix() {
        loadNativeLib(LIB_JNHW_POSIX);
    }

    protected LibJnhwPosixLoader() {
    }

}
