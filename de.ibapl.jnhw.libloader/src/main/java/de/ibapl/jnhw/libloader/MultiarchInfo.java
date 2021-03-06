/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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
 * Information on the current architecture, operating system and used
 * application binary interface.
 *
 * @author aploese
 */
public enum MultiarchInfo {

    X86_64__LINUX__GNU(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.LITTLE, Arch.X86_64, OS.LINUX, Abi.GNU),
    I386__LINUX__GNU(SizeInBit._32_BIT, SizeInBit._32_BIT, Endianess.LITTLE, Arch.I386, OS.LINUX, Abi.GNU),
    ARM__LINUX__GNU_EABI_HF(SizeInBit._32_BIT, SizeInBit._32_BIT, Endianess.LITTLE, Arch.ARM, OS.LINUX, Abi.GNU_EABI_HF),
    ARM__LINUX__GNU_EABI(SizeInBit._32_BIT, SizeInBit._32_BIT, Endianess.LITTLE, Arch.ARM, OS.LINUX, Abi.GNU_EABI),
    AARCH64__LINUX__GNU(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.LITTLE, Arch.AARCH64, OS.LINUX, Abi.GNU),
    AARCH64__OPEN_BSD__BSD(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.LITTLE, Arch.AARCH64, OS.OPEN_BSD, Abi.BSD),
    MIPS_EL__LINUX__GNU(SizeInBit._32_BIT, SizeInBit._32_BIT, Endianess.LITTLE, Arch.MIPS, OS.LINUX, Abi.GNU),
    MIPS__LINUX__GNU(SizeInBit._32_BIT, SizeInBit._32_BIT, Endianess.BIG, Arch.MIPS, OS.LINUX, Abi.GNU),
    MIPS_64_EL__LINUX__GNU_ABI_64(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.LITTLE, Arch.MIPS_64, OS.LINUX, Abi.GNU_ABI_64),
    MIPS_64__LINUX__GNU_ABI_64(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.BIG, Arch.MIPS_64, OS.LINUX, Abi.GNU_ABI_64),
    POWER_PC_64__LINUX__GNU(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.BIG, Arch.POWER_PC_64, OS.LINUX, Abi.GNU),
    POWER_PC_64_LE__LINUX__GNU(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.LITTLE, Arch.POWER_PC_64, OS.LINUX, Abi.GNU),
    RISC_V_64__LINUX__GNU(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.LITTLE, Arch.RISC_V_64, OS.LINUX, Abi.GNU),
    S390_X__LINUX__GNU(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.BIG, Arch.S390_X, OS.LINUX, Abi.GNU),
    SPARC_64__LINUX__GNU(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.BIG, Arch.SPARC_64, OS.LINUX, Abi.GNU),
    X86_64__WINDOWS__PE32_PLUS(SizeInBit._64_BIT, SizeInBit._32_BIT, Endianess.LITTLE, Arch.X86_64, OS.WINDOWS, Abi.PE32_PLUS),
    X86__WINDOWS__PE32(SizeInBit._32_BIT, SizeInBit._32_BIT, Endianess.LITTLE, Arch.X86, OS.WINDOWS, Abi.PE32),
    I386__WINDOWS__PE32(SizeInBit._32_BIT, SizeInBit._32_BIT, Endianess.LITTLE, Arch.I386, OS.WINDOWS, Abi.PE32),
    X86_64__FREE_BSD__BSD(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.LITTLE, Arch.X86_64, OS.FREE_BSD, Abi.BSD),
    X86_64__OPEN_BSD__BSD(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.LITTLE, Arch.X86_64, OS.OPEN_BSD, Abi.BSD),
    X86_64__DARWIN__BSD(SizeInBit._64_BIT, SizeInBit._64_BIT, Endianess.LITTLE, Arch.X86_64, OS.DARWIN, Abi.BSD);

    private MultiarchInfo(SizeInBit sizeOfPointer, SizeInBit sizeOfLong, Endianess endianess, Arch arch, OS os, Abi abi) {
        this.arch = arch;
        this.os = os;
        this.abi = abi;
        this.sizeOfPointer = sizeOfPointer;
        this.sizeOfLong = sizeOfLong;
        this.endianess = endianess;
    }

    private final SizeInBit sizeOfPointer;
    private final SizeInBit sizeOfLong;
    private final Endianess endianess;
    private final OS os;
    private final Arch arch;
    private final Abi abi;

    public String getTupelName() {
        return String.format("%s-%s-%s", arch.formatArchName(endianess), os.osName, abi.abiName);
    }

    public SizeInBit getSizeOfPointer() {
        return sizeOfPointer;
    }

    public SizeInBit getSizeOfLong() {
        return sizeOfLong;
    }

    public Endianess getEndianess() {
        return endianess;
    }

    public Arch getArch() {
        return arch;
    }

    public Abi getAbi() {
        return abi;
    }

    public OS getOS() {
        return os;
    }

    @Override
    public String toString() {
        return getTupelName();
    }
}
