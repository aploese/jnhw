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
    LINUX("linux"), WINDOWS("windows"), SOLARIS("solaris"), DARWIN("darwin");
    public final String osName;

    private OS(String osName) {
        this.osName = osName;
    }

    @Override
    public String toString() {
        return osName;
    }
    
}
