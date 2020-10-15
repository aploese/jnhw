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
public enum MultiarchInfo {

    X86_64__LINUX__GNU(WordSize._64_BIT, Endianess.LITTLE, Arch.X86_64, OS.LINUX, Abi.GNU),
    I386__LINUX__GNU(WordSize._32_BIT, Endianess.LITTLE, Arch.I386, OS.LINUX, Abi.GNU),
    ARM__LINUX__GNU_EABI_HF(WordSize._32_BIT, Endianess.LITTLE, Arch.ARM, OS.LINUX, Abi.GNU_EABI_HF),
    ARM__LINUX__GNU_EABI(WordSize._32_BIT, Endianess.LITTLE, Arch.ARM, OS.LINUX, Abi.GNU_EABI),
    AARCH64__LINUX__GNU(WordSize._64_BIT, Endianess.LITTLE, Arch.AARCH64, OS.LINUX, Abi.GNU),
    MIPS_EL__LINUX__GNU(WordSize._32_BIT, Endianess.LITTLE, Arch.MIPS_EL, OS.LINUX, Abi.GNU),
    MIPS__LINUX__GNU(WordSize._32_BIT, Endianess.BIG, Arch.MIPS, OS.LINUX, Abi.GNU),
    MIPS_64_EL__LINUX__GNU_ABI_64(WordSize._64_BIT, Endianess.LITTLE, Arch.MIPS_64_EL, OS.LINUX, Abi.GNU_ABI_64),
    MIPS_64__LINUX__GNU_ABI_64(WordSize._64_BIT, Endianess.BIG, Arch.MIPS_64, OS.LINUX, Abi.GNU_ABI_64),
    POWER_PC_64__LINUX__GNU(WordSize._64_BIT, Endianess.BIG, Arch.POWER_PC_64, OS.LINUX, Abi.GNU),
    POWER_PC_64_LE__LINUX__GNU(WordSize._64_BIT, Endianess.LITTLE, Arch.POWER_PC_64_LE, OS.LINUX, Abi.GNU),
    S390_X__LINUX__GNU(WordSize._64_BIT, Endianess.BIG, Arch.S390_X, OS.LINUX, Abi.GNU),
    SPARC_64__LINUX__GNU(WordSize._64_BIT, Endianess.BIG, Arch.SPARC_64, OS.LINUX, Abi.GNU),
    X86_64__WINDOWS__PE32_PLUS(WordSize._64_BIT, Endianess.LITTLE, Arch.X86_64, OS.WINDOWS, Abi.PE32_PLUS),
    X86__WINDOWS__PE32(WordSize._32_BIT, Endianess.LITTLE, Arch.X86, OS.WINDOWS, Abi.PE32),
    I386__WINDOWS__PE32(WordSize._32_BIT, Endianess.LITTLE, Arch.I386, OS.WINDOWS, Abi.PE32),
    X86_64__FREE_BSD__BSD(WordSize._64_BIT, Endianess.LITTLE, Arch.X86_64, OS.FREE_BSD, Abi.BSD),
    X86_64__OPEN_BSD__BSD(WordSize._64_BIT, Endianess.LITTLE, Arch.X86_64, OS.OPEN_BSD, Abi.BSD),
    X86_64__MAC_OS_X__BSD(WordSize._64_BIT, Endianess.LITTLE, Arch.X86_64, OS.MAC_OS_X, Abi.BSD);

    private MultiarchInfo(WordSize wordSize, Endianess endianess, Arch arch, OS os, Abi abi) {
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


    private final WordSize wordSize;
    private final Endianess endianess;
    private final OS os;
    private final Arch arch;
    private final Abi abi;

    public String getTupelName() {
        return String.format("%s-%s-%s", arch.archName, os.osName, abi.abiName);
    }

    public WordSize getWordSize() {
        return wordSize;
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
