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
    X86_64(64, "x86_64"), X86(64, "x86"), I386(32, "i386"), ARM(32, "arm"), AARCH64(64, "aarch64"), MIPS_EL(32, "mipsel"), MIPS(32, "mips"), MIPS_64_EL(64, "mips64el"), MIPS_64(64, "mips64");

    public final String archName;
    public final int wordSize;
    
    private Arch(int wordSize, String archName) {
        this.wordSize = wordSize;
        this.archName = archName;
    }

    @Override
    public String toString() {
        return archName;
    }
    
    
}
