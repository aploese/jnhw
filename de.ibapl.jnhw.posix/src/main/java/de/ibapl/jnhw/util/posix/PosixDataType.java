/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2025, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;

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
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case LP64 ->
                    BaseDataType.int64_t;
                case ILP32 ->
                    BaseDataType.int32_t;
                default ->
                    throw new NoClassDefFoundError("can't get datatype of clock_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case APPLE ->
            BaseDataType.uint64_t;
        case FREE_BSD ->
            BaseDataType.int32_t;
        case OPEN_BSD ->
            BaseDataType.int64_t;
        default ->
            throw new NoClassDefFoundError("can't get datatype of clock_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    //Apple Darwin datatype is enum.
    public final static BaseDataType clockid_t = BaseDataType.int32_t;
    public final static BaseDataType clockid_t_ptr = BaseDataType.C_pointer;
    public final static BaseDataType gid_t = BaseDataType.uint32_t;

    public final static BaseDataType locale_t = BaseDataType.C_pointer;

    public final static BaseDataType mode_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            BaseDataType.uint32_t;
        case APPLE, FREE_BSD ->
            BaseDataType.uint16_t;
        case OPEN_BSD ->
            BaseDataType.uint32_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of mode_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType nfds_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case LP64 ->
                    BaseDataType.uint64_t;
                case ILP32 ->
                    BaseDataType.uint32_t;
                default ->
                    throw new NoClassDefFoundError("can't get linux datatype of nfds_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case OPEN_BSD ->
            BaseDataType.uint64_t;
        case APPLE, FREE_BSD ->
            BaseDataType.uint32_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of nfds_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType off_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case LP64 ->
                    BaseDataType.int64_t;
                case ILP32 ->
                    Defines._FILE_OFFSET_BITS.equals(64) ? BaseDataType.int64_t : BaseDataType.int32_t;
                default ->
                    throw new NoClassDefFoundError("can't get linux datatype of off_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case APPLE, FREE_BSD, OPEN_BSD ->
            BaseDataType.int64_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of off_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    //TODO only set value on 32 bit off_t??
    public final static BaseDataType off64_t = BaseDataType.int64_t;

    public final static BaseDataType pid_t = BaseDataType.int32_t;

    public final static BaseDataType pthread_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            BaseDataType.C_unsigned_long_int;
        case APPLE, FREE_BSD, OPEN_BSD ->
            BaseDataType.C_struct_pointer;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of pthread_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType pthread_attr_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            BaseDataType.struct;
        case APPLE, FREE_BSD, OPEN_BSD ->
            BaseDataType.C_struct_pointer;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of pthread_attr_t on " + MultiarchTupelBuilder.getMultiarch());
    };
    public final static BaseDataType pthread_attr_t_pointer = BaseDataType.C_pointer;

    public final static BaseDataType size_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case LP64 ->
                    BaseDataType.uint64_t;
                case ILP32 ->
                    BaseDataType.uint32_t;
                default ->
                    throw new NoClassDefFoundError("can't get linux datatype of size_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case APPLE, FREE_BSD, OPEN_BSD ->
            BaseDataType.uint64_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of size_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType speed_t = switch (MultiarchTupelBuilder.getOS()) {
        case APPLE ->
            BaseDataType.uint64_t;
        case FREE_BSD, LINUX, OPEN_BSD ->
            BaseDataType.uint32_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of speed_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType ssize_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case LP64 ->
                    BaseDataType.int64_t;
                case ILP32 ->
                    BaseDataType.int32_t;
                default ->
                    throw new NoClassDefFoundError("can't get linux datatype of ssize_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case APPLE, FREE_BSD, OPEN_BSD ->
            BaseDataType.int64_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of ssize_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType tcflag_t = switch (MultiarchTupelBuilder.getOS()) {
        case APPLE ->
            BaseDataType.uint64_t;
        case FREE_BSD, LINUX, OPEN_BSD ->
            BaseDataType.uint32_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of tcflag_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType time_t = switch (MultiarchTupelBuilder.getOS()) {
        case LINUX ->
            switch (MultiarchTupelBuilder.getMemoryModel()) {
                case LP64 ->
                    BaseDataType.int64_t;
                case ILP32 ->
                    Defines._TIME_BITS.equals(64) ? BaseDataType.int64_t : BaseDataType.int32_t;
                default ->
                    throw new NoClassDefFoundError("can't get linux datatype of time_t on " + MultiarchTupelBuilder.getMultiarch());
            };
        case APPLE, FREE_BSD, OPEN_BSD ->
            BaseDataType.int64_t;
        default ->
            throw new NoClassDefFoundError("can't get OS datatype of time_t on " + MultiarchTupelBuilder.getMultiarch());
    };

    public final static BaseDataType timer_t = switch (MultiarchTupelBuilder.getOS()) {
        case APPLE ->
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
