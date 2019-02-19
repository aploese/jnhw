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
public enum OS {
    LINUX("linux", "lib%1$s.so.%2$d"), 
    WINDOWS("windows", "lib%1$s-%2$d.dll"), 
    SOLARIS("solaris","lib%1$s.so.%2$d"), 
    FREE_BSD("freebsd", "lib%1$s.so.%2$d"), 
    MAC_OS_X("macosx","lib%1$s.%2$d.dylib");
    
    public final String osName;
    public final String formatLibNameString;
    
    private OS(String osName, String formatLibNameString) {
        this.osName = osName;
        this.formatLibNameString = formatLibNameString;
    }

    @Override
    public String toString() {
        return osName;
    }

    String formatLibName(String libName, int libToolInterfaceVersion) {
        return String.format(formatLibNameString, libName, libToolInterfaceVersion);
    }
    
}
