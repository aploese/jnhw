/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
 * The Architecture used.
 *
 * @author aploese
 */
public enum Arch {
    X86_64(SizeInBit._64_BIT, "x86_64", "%s", null),
    X86(SizeInBit._32_BIT, "x86", "%s", null),
    I386(SizeInBit._32_BIT, "i386", "%s", null),
    ARM(SizeInBit._32_BIT, "arm", "%s", null),
    AARCH64(SizeInBit._64_BIT, "aarch64", "%s", null),
    MIPS(SizeInBit._64_BIT, "mips", "%sel", "%s"),
    MIPS_64(SizeInBit._64_BIT, "mips64", "%sel", "%s"),
    POWER_PC(SizeInBit._32_BIT, "powerpc", "%s", "%s"),
    POWER_PC_64(SizeInBit._64_BIT, "powerpc64", "%sle", "%s"),
    RISC_V_64(SizeInBit._64_BIT, "riscv64", "%s", null),
    S390_X(SizeInBit._64_BIT, "s390x", null, "%s"),
    SPARC_64(SizeInBit._64_BIT, "sparc64", null, "%s");

    public final String archName;
    public final String fmtLittleEndian;
    public final String fmtBigEndian;
    public final SizeInBit wordSize;

    private Arch(SizeInBit wordSize, String archName, String fmtLittleEndian, String fmtBigEndian) {
        this.wordSize = wordSize;
        this.archName = archName;
        this.fmtLittleEndian = fmtLittleEndian;
        this.fmtBigEndian = fmtBigEndian;
    }

    @Override
    public String toString() {
        return archName;
    }

    public String formatArchName(Endianess endianess) {
        return switch (endianess) {
            case BIG ->
                String.format(fmtBigEndian, archName);
            case LITTLE ->
                String.format(fmtLittleEndian, archName);
            default ->
                throw new RuntimeException("Can*t handle endiuaness: " + endianess);
        };
    }
}
