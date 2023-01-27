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
 * Information on the current architecture, operating system and used
 * application binary interface.
 *
 * @author aploese
 */
public enum MultiarchInfo {

    AARCH64__APPLE_DARWIN(MemoryModel.LP64, Endianess.LITTLE, Arch.X86_64, OS.APPLE, Abi.DARWIN),
    AARCH64__FREE_BSD__BSD(MemoryModel.LP64, Endianess.LITTLE, Arch.AARCH64, OS.FREE_BSD, Abi.BSD),
    AARCH64__LINUX__GNU(MemoryModel.LP64, Endianess.LITTLE, Arch.AARCH64, OS.LINUX, Abi.GNU),
    AARCH64__OPEN_BSD__BSD(MemoryModel.LP64, Endianess.LITTLE, Arch.AARCH64, OS.OPEN_BSD, Abi.BSD),
    ARM__LINUX__GNU_EABI_HF(MemoryModel.ILP32, Endianess.LITTLE, Arch.ARM, OS.LINUX, Abi.GNU_EABI_HF),
    ARM__LINUX__GNU_EABI(MemoryModel.ILP32, Endianess.LITTLE, Arch.ARM, OS.LINUX, Abi.GNU_EABI),
    I386__LINUX__GNU(MemoryModel.ILP32, Endianess.LITTLE, Arch.I386, OS.LINUX, Abi.GNU),
    I386__WINDOWS__PE32(MemoryModel.ILP32, Endianess.LITTLE, Arch.I386, OS.WINDOWS, Abi.PE32),
    MIPS_EL__LINUX__GNU(MemoryModel.ILP32, Endianess.LITTLE, Arch.MIPS, OS.LINUX, Abi.GNU),
    MIPS__LINUX__GNU(MemoryModel.ILP32, Endianess.BIG, Arch.MIPS, OS.LINUX, Abi.GNU),
    MIPS_64_EL__LINUX__GNU_ABI_64(MemoryModel.LP64, Endianess.LITTLE, Arch.MIPS_64, OS.LINUX, Abi.GNU_ABI_64),
    MIPS_64__LINUX__GNU_ABI_64(MemoryModel.LP64, Endianess.BIG, Arch.MIPS_64, OS.LINUX, Abi.GNU_ABI_64),
    POWER_PC__LINUX__GNU(MemoryModel.ILP32, Endianess.BIG, Arch.POWER_PC, OS.LINUX, Abi.GNU),
    POWER_PC_64__LINUX__GNU(MemoryModel.LP64, Endianess.BIG, Arch.POWER_PC_64, OS.LINUX, Abi.GNU),
    POWER_PC_64_LE__LINUX__GNU(MemoryModel.LP64, Endianess.LITTLE, Arch.POWER_PC_64, OS.LINUX, Abi.GNU),
    RISC_V_64__LINUX__GNU(MemoryModel.LP64, Endianess.LITTLE, Arch.RISC_V_64, OS.LINUX, Abi.GNU),
    S390_X__LINUX__GNU(MemoryModel.LP64, Endianess.BIG, Arch.S390_X, OS.LINUX, Abi.GNU),
    SPARC_64__LINUX__GNU(MemoryModel.LP64, Endianess.BIG, Arch.SPARC_64, OS.LINUX, Abi.GNU),
    X86__WINDOWS__PE32(MemoryModel.ILP32, Endianess.LITTLE, Arch.X86, OS.WINDOWS, Abi.PE32),
    X86_64__APPLE_DARWIN(MemoryModel.LP64, Endianess.LITTLE, Arch.X86_64, OS.APPLE, Abi.DARWIN),
    X86_64__FREE_BSD__BSD(MemoryModel.LP64, Endianess.LITTLE, Arch.X86_64, OS.FREE_BSD, Abi.BSD),
    X86_64__LINUX__GNU(MemoryModel.LP64, Endianess.LITTLE, Arch.X86_64, OS.LINUX, Abi.GNU),
    X86_64__OPEN_BSD__BSD(MemoryModel.LP64, Endianess.LITTLE, Arch.X86_64, OS.OPEN_BSD, Abi.BSD),
    X86_64__WINDOWS__PE32_PLUS(MemoryModel.LLP64, Endianess.LITTLE, Arch.X86_64, OS.WINDOWS, Abi.PE32_PLUS);

    private MultiarchInfo(MemoryModel memoryModel, Endianess endianess, Arch arch, OS os, Abi abi) {
        this.arch = arch;
        this.os = os;
        this.abi = abi;
        this.memoryModel = memoryModel;
        this.endianess = endianess;
    }

    private final MemoryModel memoryModel;
    private final Endianess endianess;
    private final OS os;
    private final Arch arch;
    private final Abi abi;

    public String getTupelName() {
        return String.format("%s-%s-%s", arch.formatArchName(endianess), os.osName, abi.getAbiShortName(memoryModel));
    }

    public MemoryModel getMemoryModel() {
        return memoryModel;
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
