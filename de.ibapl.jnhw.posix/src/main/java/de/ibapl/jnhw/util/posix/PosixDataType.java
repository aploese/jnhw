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

    private PosixDataType(BaseDataType dataType) {
        this.baseDataType = dataType;
    }

    private static native boolean JNHW__cc_t__IS__uint8_t();

    private static native boolean JNHW__clock_t__IS__int64_t();

    private static native boolean JNHW__clock_t__IS__int32_t();

    private static native boolean JNHW__off_t__IS__int64_t();

    private static native boolean JNHW__off_t__IS__int32_t();

    private static native boolean JNHW__mode_t__IS__uint16_t();

    private static native boolean JNHW__mode_t__IS__uint32_t();

    private static native boolean JNHW__pid_t__IS__int32_t();

    private static native boolean JNHW__speed_t__IS__uint32_t();

    private static native boolean JNHW__size_t__IS__uint64_t();

    private static native boolean JNHW__size_t__IS__uint32_t();

    private static native boolean JNHW__ssize_t__IS__int64_t();

    private static native boolean JNHW__ssize_t__IS__int32_t();

    private static native boolean JNHW__tcflag_t__IS__uint32_t();

    private static native boolean JNHW__time_t__IS__int64_t();

    private static native boolean JNHW__time_t__IS__int32_t();

    private static native boolean JNHW__uid_t__IS__uint32_t();

    private static BaseDataType dataTypeOf__CC_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__cc_t__IS__uint8_t()) {
            return BaseDataType.uint8_t;
        } else {
            return null;
        }
    }

    private static BaseDataType dataTypeOf__clock_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__clock_t__IS__int64_t()) {
            return BaseDataType.int64_t;
        } else if (JNHW__clock_t__IS__int32_t()) {
            return BaseDataType.int32_t;
        } else {
            return null;
        }
    }

    private static BaseDataType dataTypeOf__mode_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__mode_t__IS__uint16_t()) {
            return BaseDataType.uint16_t;
        } else if (JNHW__mode_t__IS__uint32_t()) {
            return BaseDataType.uint32_t;
        } else {
            return null;
        }
    }

    private static BaseDataType dataTypeOf__off_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__off_t__IS__int64_t()) {
            return BaseDataType.int64_t;
        } else if (JNHW__off_t__IS__int32_t()) {
            return BaseDataType.int32_t;
        } else {
            return null;
        }
    }

    private static BaseDataType dataTypeOf__pid_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__pid_t__IS__int32_t()) {
            return BaseDataType.int32_t;
        } else {
            return null;
        }
    }

    private static BaseDataType dataTypeOf__size_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__size_t__IS__uint64_t()) {
            return BaseDataType.uint64_t;
        } else if (JNHW__size_t__IS__uint32_t()) {
            return BaseDataType.uint32_t;
        } else {
            return null;
        }
    }

    private static BaseDataType dataTypeOf__speed_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__speed_t__IS__uint32_t()) {
            return BaseDataType.uint32_t;
        } else {
            return null;
        }
    }

    private static BaseDataType dataTypeOf__ssize_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__ssize_t__IS__int64_t()) {
            return BaseDataType.int64_t;
        } else if (JNHW__ssize_t__IS__int32_t()) {
            return BaseDataType.int32_t;
        } else {
            return null;
        }
    }

    private static BaseDataType dataTypeOf__tcflag_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__tcflag_t__IS__uint32_t()) {
            return BaseDataType.uint32_t;
        } else {
            return null;
        }
    }

    private static BaseDataType dataTypeOf__time_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__time_t__IS__int64_t()) {
            return BaseDataType.int64_t;
        } else if (JNHW__time_t__IS__int32_t()) {
            return BaseDataType.int32_t;
        } else {
            return null;
        }
    }

    private static BaseDataType dataTypeOf__uid_t() {
        LibJnhwPosixLoader.touch();
        if (JNHW__uid_t__IS__uint32_t()) {
            return BaseDataType.uint32_t;
        } else {
            return null;
        }
    }

    public final BaseDataType baseDataType;

}
