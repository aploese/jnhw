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
public enum MultiarchInfo {
    
    X86_64__LINUX__GNU(64, Endianess.BIG, Arch.X86_64, OS.LINUX, Abi.GNU), 
    I386__LINUX__GNU(32, Endianess.BIG, Arch.I386, OS.LINUX, Abi.GNU), 
    ARM__LINUX__GNU_EABI_HF(32, Endianess.LITTLE, Arch.ARM, OS.LINUX, Abi.GNU_EABI_HF), 
    ARM__LINUX__GNU_EABI(32, Endianess.LITTLE, Arch.ARM, OS.LINUX, Abi.GNU_EABI),
    AARCH64__LINUX__GNU(64, Endianess.LITTLE, Arch.AARCH64, OS.LINUX, Abi.GNU), 
    MIPS_EL__LINUX__GNU(32, Endianess.LITTLE, Arch.MIPS_EL, OS.LINUX, Abi.GNU), 
    MIPS__LINUX__GNU(32, Endianess.BIG, Arch.MIPS, OS.LINUX, Abi.GNU), 
    MIPS_64_EL__LINUX__GNU_ABI_64(64, Endianess.LITTLE, Arch.MIPS_64_EL, OS.LINUX, Abi.GNU_ABI_64), 
    MIPS_64__LINUX__GNU_ABI_64(64, Endianess.BIG, Arch.MIPS_64, OS.LINUX, Abi.GNU_ABI_64), 
    X86_64__WINDOWS__PE_PLUS(64, Endianess.BIG, Arch.X86_64, OS.WINDOWS, Abi.PE_PLUS), 
    I386__WINDOWS__PE32(32, Endianess.BIG, Arch.I386, OS.WINDOWS, Abi.PE32);
    
    
    private MultiarchInfo(int wordSize, Endianess endianess, Arch arch, OS os, Abi abi) {
        this.arch = arch;
        this.os = os;
        this.abi = abi;
        this.wordSize = wordSize;
        this.endianess = endianess;
    } 
    
    public static enum Endianess {
        BIG,
        LITTLE;
    }
    
    private final int wordSize;
    private final Endianess endianess;
    private final OS os;
    private final Arch arch;
    private final Abi abi;
    
    public String getTupelName() {
        return String.format("%s-%s-%s", arch.archName, os.osName, abi.abiName);
    }
    
    public int getWordSize() {
        return wordSize;
    }
    
    public Endianess getEndianess() {
        return endianess;
    }
    
    public Arch getArch() {
        return arch;
    } 
    
    public Abi getAbi() {
        return  abi;
    }
    
    public OS getOS() {
        return os;
    }
    @Override
    public String toString() {
        return getTupelName();
    }
}
