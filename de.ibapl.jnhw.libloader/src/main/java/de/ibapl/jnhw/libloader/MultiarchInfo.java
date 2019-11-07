/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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

    X86_64__LINUX__GNU(64, Endianess.LITTLE, Arch.X86_64, OS.LINUX, Abi.GNU),
    I386__LINUX__GNU(32, Endianess.LITTLE, Arch.I386, OS.LINUX, Abi.GNU),
    ARM__LINUX__GNU_EABI_HF(32, Endianess.LITTLE, Arch.ARM, OS.LINUX, Abi.GNU_EABI_HF),
    ARM__LINUX__GNU_EABI(32, Endianess.LITTLE, Arch.ARM, OS.LINUX, Abi.GNU_EABI),
    AARCH64__LINUX__GNU(64, Endianess.LITTLE, Arch.AARCH64, OS.LINUX, Abi.GNU),
    MIPS_EL__LINUX__GNU(32, Endianess.LITTLE, Arch.MIPS_EL, OS.LINUX, Abi.GNU),
    MIPS__LINUX__GNU(32, Endianess.BIG, Arch.MIPS, OS.LINUX, Abi.GNU),
    MIPS_64_EL__LINUX__GNU_ABI_64(64, Endianess.LITTLE, Arch.MIPS_64_EL, OS.LINUX, Abi.GNU_ABI_64),
    MIPS_64__LINUX__GNU_ABI_64(64, Endianess.BIG, Arch.MIPS_64, OS.LINUX, Abi.GNU_ABI_64),
    X86_64__WINDOWS__PE32_PLUS(64, Endianess.LITTLE, Arch.X86_64, OS.WINDOWS, Abi.PE32_PLUS),
    I386__WINDOWS__PE32(32, Endianess.LITTLE, Arch.I386, OS.WINDOWS, Abi.PE32),
    X86_64__FREE_BSD__BSD(64, Endianess.LITTLE, Arch.X86_64, OS.FREE_BSD, Abi.BSD),
    X86_64__MAC_OS_X__BSD(64, Endianess.LITTLE, Arch.X86_64, OS.MAC_OS_X, Abi.BSD);

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
