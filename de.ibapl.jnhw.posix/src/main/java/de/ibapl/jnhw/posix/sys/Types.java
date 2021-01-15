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
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.common.annotations.AlignOf;
import de.ibapl.jnhw.common.annotations.Include;
import de.ibapl.jnhw.common.annotations.SizeOf;
import de.ibapl.jnhw.common.annotations.Unsigned;
import de.ibapl.jnhw.common.annotations.int8_t;
import de.ibapl.jnhw.common.datatypes.BaseDataTypes;
import de.ibapl.jnhw.common.datatypes.Native;
import de.ibapl.jnhw.common.memory.NativeIntNumber;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Wrapper around the {@code  <sys/stat.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">sys/types.h
 * - data types</a>.
 *
 * @author aploese
 */
@Include("#include <sys/types.h>")
public class Types {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_SYS_TYPES_H();

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * off_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
    public static @interface off_t {
    }

    @off_t
    public static class Off_t extends NativeIntNumber {

        public final static BaseDataTypes dataType;
        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
            //First we must load the native lib...
            dataType = getIntegerType(sizeof(), unsigned());
        }

        @SizeOf
        public final static native int sizeof();

        @AlignOf
        public final static native int alignof();

        @Unsigned
        public final static native boolean unsigned();

        public Off_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Off_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @off_t
        long getValue();

        public native void setValue(@off_t long value);

        @Override
        public native String nativeToString();

        @Override
        public BaseDataTypes getBaseDataType() {
            return dataType;
        }

    }

    /**
     * <b>Linux:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * off_t}</a>, but 64 bit wide.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface off64_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * mode_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface mode_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * ssize_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
    public static @interface ssize_t {
    }

    @ssize_t
    public static class Ssize_t extends NativeIntNumber {

        public final static BaseDataTypes dataType;
        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
            //First we must load the native lib...
            dataType = getIntegerType(sizeof(), unsigned());
        }


        @SizeOf
        public final static native int sizeof();

        @AlignOf
        public final static native int alignof();

        @Unsigned
        public final static native boolean unsigned();

        public Ssize_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Ssize_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @ssize_t
        long getValue();

        public native void setValue(@ssize_t long value);

        @Override
        public native String nativeToString();

        @Override
        public BaseDataTypes getBaseDataType() {
            return dataType;
        }
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * size_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
    public static @interface size_t {
    }

    @size_t
    public static class Size_t extends NativeIntNumber {

        public final static BaseDataTypes dataType;
        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
            //First we must load the native lib...
            dataType = getIntegerType(sizeof(), unsigned());
        }

        @SizeOf
        public final static native int sizeof();

        @AlignOf
        public final static native int alignof();

        @Unsigned
        public final static native boolean unsigned();

        public Size_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Size_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @size_t
        long getValue();

        public native void setValue(@pid_t long value);

        @Override
        public native String nativeToString();

        @Override
        public BaseDataTypes getBaseDataType() {
            return dataType;
        }
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * useconds_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface useconds_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * gid_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface gid_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * pid_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
    public static @interface pid_t {
    }

    @pid_t
    public static class Pid_t extends NativeIntNumber {

        public final static BaseDataTypes dataType;
        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
            //First we must load the native lib...
            dataType = getIntegerType(sizeof(), unsigned());
        }


        @SizeOf
        public final static native int sizeof();

        @AlignOf
        public final static native int alignof();

        @Unsigned
        public final static native boolean unsigned();

        public Pid_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Pid_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @pid_t
        int getValue();

        public native void setValue(@pid_t int value);

        @Override
        public native String nativeToString();

        @Override
        public BaseDataTypes getBaseDataType() {
            return dataType;
        }
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * pthread_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    public static @interface pthread_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * pthread_attr_t Used to identify a thread attribute object.}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    public static @interface pthread_attr_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * clock_t}</a>.
     *
     * shall be an integer or real-floating type.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface clock_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * time_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface time_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * clockid_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface clockid_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * timer_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE})
    public static @interface timer_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">{@code typedef
     * uid_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface uid_t {
    }

}
