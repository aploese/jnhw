/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2025, Arne Plöse and individual contributors as indicated
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
    X86_64(SizeInByte._64_Bit, "x86_64", "%s", null),
    X86(SizeInByte._32_Bit, "x86", "%s", null),
    I386(SizeInByte._32_Bit, "i386", "%s", null),
    ARM(SizeInByte._32_Bit, "arm", "%s", null),
    AARCH64(SizeInByte._64_Bit, "aarch64", "%s", null),
    MIPS(SizeInByte._64_Bit, "mips", "%sel", "%s"),
    MIPS_64(SizeInByte._64_Bit, "mips64", "%sel", "%s"),
    POWER_PC(SizeInByte._32_Bit, "powerpc", "%s", "%s"),
    POWER_PC_64(SizeInByte._64_Bit, "powerpc64", "%sle", "%s"),
    RISC_V_64(SizeInByte._64_Bit, "riscv64", "%s", null),
    S390_X(SizeInByte._64_Bit, "s390x", null, "%s"),
    SPARC_64(SizeInByte._64_Bit, "sparc64", null, "%s");

    public final String archName;
    public final String fmtLittleEndian;
    public final String fmtBigEndian;
    public final SizeInByte wordSize;

    private Arch(SizeInByte wordSize, String archName, String fmtLittleEndian, String fmtBigEndian) {
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
