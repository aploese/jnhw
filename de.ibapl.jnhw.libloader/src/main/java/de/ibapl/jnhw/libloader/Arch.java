/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package de.ibapl.jnhw.libloader;

/**
 *
 * @author aploese
 */
public enum Arch {
    X86_64(WordSize._64_BIT, "x86_64"), 
    X86(WordSize._32_BIT, "x86"), 
    I386(WordSize._64_BIT, "i386"), 
    ARM(WordSize._32_BIT, "arm"), 
    AARCH64(WordSize._64_BIT, "aarch64"), 
    MIPS_EL(WordSize._64_BIT, "mipsel"), 
    MIPS(WordSize._32_BIT, "mips"), 
    MIPS_64_EL(WordSize._64_BIT, "mips64el"), 
    MIPS_64(WordSize._64_BIT, "mips64"),
    POWER_PC_64(WordSize._64_BIT, "powerpc64"),
    POWER_PC_64_LE(WordSize._64_BIT, "powerpc64le"),
    S390_X(WordSize._64_BIT, "s390x"),
    SPARC_64(WordSize._64_BIT, "sparc64");

    public final String archName;
    public final WordSize wordSize;
    
    private Arch(WordSize wordSize, String archName) {
        this.wordSize = wordSize;
        this.archName = archName;
    }

    @Override
    public String toString() {
        return archName;
    }
    
    
}
