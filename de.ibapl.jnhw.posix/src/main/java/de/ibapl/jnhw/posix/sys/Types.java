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
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.annontation.posix.sys.types.clock_t;
import de.ibapl.jnhw.annontation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annontation.posix.sys.types.mode_t;
import de.ibapl.jnhw.annontation.posix.sys.types.uid_t;
import de.ibapl.jnhw.annontation.posix.sys.types.ssize_t;
import de.ibapl.jnhw.annontation.posix.sys.types.off_t;
import de.ibapl.jnhw.annontation.posix.sys.types.time_t;
import de.ibapl.jnhw.annontation.posix.sys.types.size_t;
import de.ibapl.jnhw.common.annotation.AlignOf;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.annotation.Unsigned;
import de.ibapl.jnhw.common.datatypes.BaseDataTypes;
import de.ibapl.jnhw.common.memory.NativeIntNumber;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

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



    @mode_t
    public static class Mode_t extends NativeIntNumber {

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

        public Mode_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Mode_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @mode_t
        int getValue();

        public native void setValue(@mode_t int value);

        @Override
        public native String nativeToString();

        @Override
        public BaseDataTypes getBaseDataType() {
            return dataType;
        }
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




    @clock_t
    public static class Clock_t extends NativeIntNumber {

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

        public Clock_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Clock_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @clock_t
        long getValue();

        public native void setValue(@clock_t long value);

        @Override
        public native String nativeToString();

        @Override
        public BaseDataTypes getBaseDataType() {
            return dataType;
        }

    }


    @time_t
    public static class Time_t extends NativeIntNumber {

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

        public Time_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Time_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @time_t
        long getValue();

        public native void setValue(@time_t long value);

        @Override
        public native String nativeToString();

        @Override
        public BaseDataTypes getBaseDataType() {
            return dataType;
        }

    }




    @uid_t
    public static class Uid_t extends NativeIntNumber {

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

        public Uid_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Uid_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @uid_t
        int getValue();

        public native void setValue(@uid_t int value);

        @Override
        public native String nativeToString();

        @Override
        public BaseDataTypes getBaseDataType() {
            return dataType;
        }
    }

}
