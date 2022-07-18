/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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

import static de.ibapl.jnhw.common.datatypes.Arch.I386;
import static de.ibapl.jnhw.common.datatypes.Arch.MIPS;
import static de.ibapl.jnhw.common.datatypes.Arch.POWER_PC_64;
import static de.ibapl.jnhw.common.datatypes.Arch.RISC_V_64;
import static de.ibapl.jnhw.common.datatypes.Arch.S390_X;
import static de.ibapl.jnhw.common.datatypes.Arch.X86_64;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import static de.ibapl.jnhw.common.datatypes.OS.FREE_BSD;
import static de.ibapl.jnhw.common.datatypes.OS.LINUX;
import static de.ibapl.jnhw.common.datatypes.OS.OPEN_BSD;

/**
 * The posix datatypes with their mapping to the base datatypes that we have
 * seen so far.
 *
 * the values are set in jnhw-posix-dataypes.h
 *
 *
 * @author aploese
 */
public interface PosixDataType {

    public final static BaseDataType cc_t = BaseDataType.uint8_t;

    public final static BaseDataType clock_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getArch()) {
                case AARCH64, MIPS_64, POWER_PC_64, RISC_V_64, S390_X, X86_64 ->
                    BaseDataType.int64_t;
                case ARM, I386, MIPS ->
                    BaseDataType.int32_t;
                default ->
                    throw new NoClassDefFoundError("can't get datatype of clock_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case DARWIN ->
            BaseDataType.uint64_t;
        case FREE_BSD ->
            BaseDataType.int32_t;
        case OPEN_BSD ->
            BaseDataType.int64_t;
        default ->
            throw new NoClassDefFoundError("can't get datatype of clock_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType clockid_t = BaseDataType.int32_t;
    public final static BaseDataType clockid_t_ptr = BaseDataType.C_pointer;
    public final static BaseDataType gid_t = BaseDataType.uint32_t;

    public final static BaseDataType locale_t = BaseDataType.C_pointer;

    public final static BaseDataType mode_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            BaseDataType.uint32_t;
        case DARWIN, FREE_BSD ->
            BaseDataType.uint16_t;
        case OPEN_BSD ->
            BaseDataType.uint32_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of mode_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType nfds_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getArch()) {
                case AARCH64, MIPS_64, POWER_PC_64, RISC_V_64, S390_X, X86_64 ->
                    BaseDataType.uint64_t;
                case ARM, I386, MIPS ->
                    BaseDataType.uint32_t;
                default ->
                    throw new NoClassDefFoundError("can't get linux datatype of nfds_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case DARWIN, FREE_BSD, OPEN_BSD ->
            BaseDataType.uint64_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of nfds_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType off_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getArch()) {
                case AARCH64, MIPS_64, POWER_PC_64, RISC_V_64, S390_X, X86_64 ->
                    BaseDataType.int64_t;
                case ARM, I386, MIPS ->
                    BaseDataType.int32_t;
                default ->
                    throw new NoClassDefFoundError("can't get linux datatype of off_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case DARWIN, FREE_BSD, OPEN_BSD ->
            BaseDataType.int64_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of off_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType pid_t = BaseDataType.int32_t;

    public final static BaseDataType pthread_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            BaseDataType.C_unsigned_long_int;
        case FREE_BSD, OPEN_BSD ->
            BaseDataType.struct;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of pthread_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType pthread_attr_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            BaseDataType.struct;
        case FREE_BSD, OPEN_BSD ->
            BaseDataType.C_struct_pointer;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of pthread_attr_t on " + MultiarchTupelBuilder.getMultiarch());
    };
    public final static BaseDataType pthread_attr_t_pointer = BaseDataType.C_pointer;

    public final static BaseDataType size_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getArch()) {
                case AARCH64, MIPS_64, POWER_PC_64, RISC_V_64, S390_X, X86_64 ->
                    BaseDataType.uint64_t;
                case ARM, I386, MIPS ->
                    BaseDataType.uint32_t;
                default ->
                    throw new NoClassDefFoundError("can't get linux datatype of size_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case DARWIN, FREE_BSD, OPEN_BSD ->
            BaseDataType.uint64_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of size_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType speed_t = switch (MultiarchTupelBuilder.getOS()) {
        case DARWIN ->
            BaseDataType.uint64_t;
        case FREE_BSD, LINUX, OPEN_BSD ->
            BaseDataType.uint32_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of speed_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType ssize_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getArch()) {
                case AARCH64, MIPS_64, POWER_PC_64, RISC_V_64, S390_X, X86_64 ->
                    BaseDataType.int64_t;
                case ARM, I386, MIPS ->
                    BaseDataType.int32_t;
                default ->
                    throw new NoClassDefFoundError("can't get linux datatype of ssize_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case DARWIN, FREE_BSD, OPEN_BSD ->
            BaseDataType.int64_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of ssize_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType tcflag_t = switch (MultiarchTupelBuilder.getOS()) {
        case DARWIN ->
            BaseDataType.uint64_t;
        case FREE_BSD, LINUX, OPEN_BSD ->
            BaseDataType.uint32_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of tcflag_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType time_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getArch()) {
                case AARCH64, MIPS_64, POWER_PC_64, RISC_V_64, S390_X, X86_64 ->
                    BaseDataType.int64_t;
                case ARM, I386, MIPS ->
                    BaseDataType.int32_t;
                default ->
                    throw new NoClassDefFoundError("can't get linux datatype of time_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case DARWIN, FREE_BSD,OPEN_BSD ->
            BaseDataType.int64_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of time_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType timer_t = switch (MultiarchTupelBuilder.getOS()) {
        case DARWIN ->
            null;
        case LINUX, FREE_BSD ->
            BaseDataType.C_pointer;
        case OPEN_BSD ->
            BaseDataType.int32_t;
        default ->
            throw new NoClassDefFoundError("No time.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType struct_pollfd_array = BaseDataType.C_struct_array;
    public final static BaseDataType uid_t = BaseDataType.uint32_t;

}
