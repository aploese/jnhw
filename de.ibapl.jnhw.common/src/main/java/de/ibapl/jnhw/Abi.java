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
public enum Abi {
    GNU("gnu"), GNU_EABI_HF("gnueabihf"), GNU_EABI("gnueabi"), GNU_ABI_64("gnuabi64"), PE32_PLUS("pe32+"), PE32("pe32");
    
    public final String abiName;

    private Abi(String abiName) {
        this.abiName = abiName;
    }
    
    
    @Override
    public String toString() {
        return abiName;
    }

    
}
