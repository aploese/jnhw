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
package de.ibapl.jnhw.util.posix;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.libloader.MultiarchInfo;

/**
 * The posix datatypes with their mapping to the base datatypes that we have
 * seen so far.
 *
 * the values are set in jnhw-posix-dataypes.h
 *
 *
 * @author aploese
 */
public enum PosixDataType {
    cc_t(dataTypeOf__CC_t()),
    clock_t(dataTypeOf__clock_t()),
    mode_t(dataTypeOf__mode_t()),
    off_t(dataTypeOf__off_t()),
    pid_t(dataTypeOf__pid_t()),
    size_t(dataTypeOf__size_t()),
    speed_t(dataTypeOf__speed_t()),
    ssize_t(dataTypeOf__ssize_t()),
    tcflag_t(dataTypeOf__tcflag_t()),
    time_t(dataTypeOf__time_t()),
    uid_t(dataTypeOf__uid_t());

    private static MultiarchInfo multiarchInfo;

    static MultiarchInfo getMultiarchInfo() {
        if (multiarchInfo == null) {
            LibJnhwPosixLoader.touch();
            multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
        }
        return multiarchInfo;
    }

    private PosixDataType(BaseDataType dataType) {
        this.baseDataType = dataType;
    }

    private static BaseDataType dataTypeOf__CC_t() {
        return dataTypeOf__CC_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__CC_t(final MultiarchInfo mi) {
        return BaseDataType.uint8_t;
    }

    private static BaseDataType dataTypeOf__clock_t() {
        return dataTypeOf__clock_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__clock_t(final MultiarchInfo mi) {
        switch (mi.getOS()) {
            case LINUX:
                switch (mi.getArch()) {
                    case AARCH64:
                        return BaseDataType.int64_t;
                    case ARM:
                    case I386:
                    case MIPS:
                        return BaseDataType.int32_t;
                    case MIPS_64:
                    case POWER_PC_64:
                    case RISC_V_64:
                    case S390_X:
                    case X86_64:
                        return BaseDataType.int64_t;
                    default:
                        throw new NoClassDefFoundError("can't get datatype of clock_t on " + mi);
                }
            case FREE_BSD:
                return BaseDataType.int32_t;
            default:
                throw new NoClassDefFoundError("can't get datatype of clock_t on " + mi);
        }

    }

    private static BaseDataType dataTypeOf__mode_t() {
        return dataTypeOf__mode_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__mode_t(final MultiarchInfo mi) {
        switch (mi.getOS()) {
            case LINUX:
                return BaseDataType.uint32_t;
            case FREE_BSD:
                return BaseDataType.uint16_t;
            case OPEN_BSD:
                return BaseDataType.uint32_t;
            default:
                throw new NoClassDefFoundError("can't get OS datatype of mode_t on " + mi);
        }
    }

    private static BaseDataType dataTypeOf__off_t() {
        return dataTypeOf__off_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__off_t(final MultiarchInfo mi) {
        switch (mi.getOS()) {
            case LINUX:
                switch (mi.getArch()) {
                    case AARCH64:
                        return BaseDataType.int64_t;
                    case ARM:
                    case I386:
                    case MIPS:
                        return BaseDataType.int32_t;
                    case MIPS_64:
                    case POWER_PC_64:
                    case RISC_V_64:
                    case S390_X:
                    case X86_64:
                        return BaseDataType.int64_t;
                    default:
                        throw new NoClassDefFoundError("can't get linux datatype of off_t on " + mi);
                }
            case FREE_BSD:
                return BaseDataType.int64_t;
            default:
                throw new NoClassDefFoundError("can't get OS datatype of off_t on " + mi);
        }
    }

    private static BaseDataType dataTypeOf__pid_t() {
        return dataTypeOf__pid_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__pid_t(final MultiarchInfo mi) {
        return BaseDataType.int32_t;
    }

    private static BaseDataType dataTypeOf__size_t() {
        return dataTypeOf__size_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__size_t(final MultiarchInfo mi) {
        switch (mi.getOS()) {
            case LINUX:
                switch (mi.getArch()) {
                    case AARCH64:
                        return BaseDataType.uint64_t;
                    case ARM:
                    case I386:
                    case MIPS:
                        return BaseDataType.uint32_t;
                    case MIPS_64:
                    case POWER_PC_64:
                    case RISC_V_64:
                    case S390_X:
                    case X86_64:
                        return BaseDataType.uint64_t;
                    default:
                        throw new NoClassDefFoundError("can't get linux datatype of size_t on " + mi);
                }
            case FREE_BSD:
                return BaseDataType.uint64_t;
            default:
                throw new NoClassDefFoundError("can't get OS datatype of size_t on " + mi);
        }
    }

    private static BaseDataType dataTypeOf__speed_t() {
        return dataTypeOf__speed_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__speed_t(final MultiarchInfo mi) {
        return BaseDataType.uint32_t;
    }

    private static BaseDataType dataTypeOf__ssize_t() {
        return dataTypeOf__ssize_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__ssize_t(final MultiarchInfo mi) {
        switch (mi.getOS()) {
            case LINUX:
                switch (mi.getArch()) {
                    case AARCH64:
                        return BaseDataType.int64_t;
                    case ARM:
                    case I386:
                    case MIPS:
                        return BaseDataType.int32_t;
                    case MIPS_64:
                    case POWER_PC_64:
                    case RISC_V_64:
                    case S390_X:
                    case X86_64:
                        return BaseDataType.int64_t;
                    default:
                        throw new NoClassDefFoundError("can't get linux datatype of ssize_t on " + mi);
                }
            case FREE_BSD:
                return BaseDataType.int64_t;
            default:
                throw new NoClassDefFoundError("can't get OS datatype of ssize_t on " + mi);
        }
    }

    private static BaseDataType dataTypeOf__tcflag_t() {
        return dataTypeOf__tcflag_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__tcflag_t(final MultiarchInfo mi) {
        return BaseDataType.uint32_t;
    }

    private static BaseDataType dataTypeOf__time_t() {
        return dataTypeOf__time_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__time_t(final MultiarchInfo mi) {
        switch (mi.getOS()) {
            case LINUX:
                switch (mi.getArch()) {
                    case AARCH64:
                        return BaseDataType.int64_t;
                    case ARM:
                    case I386:
                    case MIPS:
                        return BaseDataType.int32_t;
                    case MIPS_64:
                    case POWER_PC_64:
                    case RISC_V_64:
                    case S390_X:
                    case X86_64:
                        return BaseDataType.int64_t;
                    default:
                        throw new NoClassDefFoundError("can't get linux datatype of time_t on " + mi);
                }
            case FREE_BSD:
                return BaseDataType.int64_t;
            default:
                throw new NoClassDefFoundError("can't get OS datatype of time_t on " + mi);
        }
    }

    private static BaseDataType dataTypeOf__uid_t() {
        return dataTypeOf__uid_t(getMultiarchInfo());
    }

    public static BaseDataType dataTypeOf__uid_t(final MultiarchInfo mi) {
        return BaseDataType.uint32_t;
    }

    public final BaseDataType baseDataType;

}
