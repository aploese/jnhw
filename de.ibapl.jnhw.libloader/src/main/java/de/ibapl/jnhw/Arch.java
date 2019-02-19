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
public enum Arch {
    X86_64("x86_64"), I386("i386"), ARM("arm"), AARCH64("aarch64"), MIPS_EL("mipsel"), MIPS("mips"), MIPS_64_EL("mips64el"), MIPS_64("mips64");

    public final String archName;

    private Arch(String archName) {
        this.archName = archName;
    }

    @Override
    public String toString() {
        return archName;
    }
}
