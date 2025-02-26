/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2025, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.annotation.posix.sys.types.clock_t;
import de.ibapl.jnhw.annotation.posix.sys.types.clockid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.gid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.mode_t;
import de.ibapl.jnhw.annotation.posix.sys.types.off_t;
import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.size_t;
import de.ibapl.jnhw.annotation.posix.sys.types.ssize_t;
import de.ibapl.jnhw.annotation.posix.sys.types.time_t;
import de.ibapl.jnhw.annotation.posix.sys.types.uid_t;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.AsSignedLong;
import de.ibapl.jnhw.common.memory.AsUnsignedInt;
import de.ibapl.jnhw.common.memory.AsUnsignedLong;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.NativeIntNumber;
import de.ibapl.jnhw.common.memory.Uint32_t;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.util.posix.PosixDataType;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

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

    @clock_t
    public final static class Clock_t extends NativeIntNumber {

        private final static BaseDataType dataType = PosixDataType.clock_t;

        public final static Clock_t allocateNative(Arena arena) {
            return new Clock_t(arena.allocate(dataType.byteSize, dataType.byteAlignment), 0);
        }

        public Clock_t(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, dataType.byteSize);
            if (dataType.byteSize > BaseDataType.int64_t.byteSize) {
                throw new IllegalArgumentException("Data type is too big, a smaller data type was expected");
            }
        }

        public long getAsSignedLong() {
            return MEM_ACCESS.getSignedLongOf(memorySegment, 0, dataType.byteSize);
        }

        public long getAsUnsignedLong() {
            return MEM_ACCESS.getUnsignedLongOf(memorySegment, 0, dataType.byteSize);
        }

        @Override
        public BaseDataType getBaseDataType() {
            return dataType;
        }

        @Override
        public String nativeToHexString() {
            if (dataType.isUnsigned()) {
                return MEM_ACCESS.getUnsignedLongOf_AsHex(memorySegment, 0, dataType.byteSize);
            } else {
                return MEM_ACCESS.getSignedLongOf_AsHex(memorySegment, 0, dataType.byteSize);
            }
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            if (dataType.isUnsigned()) {
                sb.append(MEM_ACCESS.getUnsignedLongOf_nativeToString(memorySegment, 0, dataType.byteSize));
            } else {
                sb.append(MEM_ACCESS.getSignedLongOf_nativeToString(memorySegment, 0, dataType.byteSize));
            }
        }

        public void setFromSignedLong(long value) {
            MEM_ACCESS.setSignedLongOf(memorySegment, 0, dataType.byteSize, value);
        }

        public void setFromUnsignedLong(long value) {
            MEM_ACCESS.setUnsignedLongOf(memorySegment, 0, dataType.byteSize, value);
        }
    }

    @clockid_t
    public final static class Clockid_t extends NativeIntNumber {

        private final static BaseDataType dataType = PosixDataType.clockid_t;

        public final static Clockid_t allocateNative(Arena arena) {
            return new Clockid_t(arena.allocate(dataType.byteSize, dataType.byteAlignment), 0);
        }

        public Clockid_t(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, dataType.byteSize);
            if (dataType.byteSize > BaseDataType.int64_t.byteSize) {
                throw new IllegalArgumentException("Data type is too big, a smaller data type was expected");
            }
        }

        public long getAsSignedLong() {
            return MEM_ACCESS.getSignedLongOf(memorySegment, 0, dataType.byteSize);
        }

        public long getAsUnsignedLong() {
            return MEM_ACCESS.getUnsignedLongOf(memorySegment, 0, dataType.byteSize);
        }

        @Override
        public BaseDataType getBaseDataType() {
            return dataType;
        }

        @Override
        public String nativeToHexString() {
            if (dataType.isUnsigned()) {
                return MEM_ACCESS.getUnsignedLongOf_AsHex(memorySegment, 0, dataType.byteSize);
            } else {
                return MEM_ACCESS.getSignedLongOf_AsHex(memorySegment, 0, dataType.byteSize);
            }
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            if (dataType.isUnsigned()) {
                sb.append(MEM_ACCESS.getUnsignedLongOf_nativeToString(memorySegment, 0, dataType.byteSize));
            } else {
                sb.append(MEM_ACCESS.getSignedLongOf_nativeToString(memorySegment, 0, dataType.byteSize));
            }
        }

        public void setFromSignedLong(long value) {
            MEM_ACCESS.setSignedLongOf(memorySegment, 0, dataType.byteSize, value);
        }

        public void setFromUnsignedLong(long value) {
            MEM_ACCESS.setUnsignedLongOf(memorySegment, 0, dataType.byteSize, value);
        }
    }

    @gid_t
    public final static class Gid_t extends Uint32_t {

        public static Gid_t allocateNative(Arena arena) {
            return new Gid_t(arena.allocate(PosixDataType.gid_t.byteSize, PosixDataType.gid_t.byteAlignment), 0);
        }

        public Gid_t(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset);
        }
    }

    @mode_t
    public static class Mode_t extends AsUnsignedInt {

        public final static Mode_t allocateNative(Arena arena) {
            return new Mode_t(arena.allocate(PosixDataType.mode_t.byteSize, PosixDataType.mode_t.byteAlignment), 0);
        }

        public Mode_t(MemorySegment memorySegment, int offset) {
            super(PosixDataType.mode_t, memorySegment, offset);
        }

    }

    @off_t
    public static class Off_t extends AsSignedLong {

        public final static Off_t allocateNative(Arena arena) {
            return new Off_t(arena.allocate(PosixDataType.off_t.byteSize, PosixDataType.off_t.byteAlignment), 0);
        }

        public Off_t(MemorySegment memorySegment, int offset) {
            super(PosixDataType.off_t, memorySegment, offset);
        }

    }

    @pid_t
    public static class Pid_t extends Int32_t {

        public static Pid_t allocateNative(Arena arena) {
            return new Pid_t(arena.allocate(PosixDataType.pid_t.byteSize, PosixDataType.pid_t.byteAlignment), 0);
        }

        public Pid_t(MemorySegment memorySegment, int offset) {
            super(memorySegment, offset);
        }

    }

    @size_t
    public static class Size_t extends AsUnsignedLong {

        public static Size_t allocateNative(Arena arena) {
            return new Size_t(arena.allocate(PosixDataType.size_t.byteSize, PosixDataType.size_t.byteAlignment), 0);
        }

        public Size_t(MemorySegment memorySegment, int offset) {
            super(PosixDataType.size_t, memorySegment, offset);
        }
    }

    @ssize_t
    public static class Ssize_t extends AsSignedLong {

        public static Ssize_t allocateNative(Arena arena) {
            return new Ssize_t(arena.allocate(PosixDataType.ssize_t.byteSize, PosixDataType.ssize_t.byteAlignment), 0);
        }

        public Ssize_t(MemorySegment memorySegment, int offset) {
            super(PosixDataType.ssize_t, memorySegment, offset);
        }

    }

    @time_t
    public static class Time_t extends AsSignedLong {

        public static Time_t allocateNative(Arena arena) {
            return new Time_t(arena.allocate(PosixDataType.time_t.byteSize, PosixDataType.time_t.byteAlignment), 0);
        }

        public Time_t(MemorySegment memorySegment, int offset) {
            super(PosixDataType.time_t, memorySegment, offset);
        }

    }

    @uid_t
    public static class Uid_t extends Uint32_t {

        public static Uid_t allocateNative(Arena arena) {
            return new Uid_t(arena.allocate(PosixDataType.uid_t.byteSize, PosixDataType.uid_t.byteAlignment), 0);
        }

        public Uid_t(MemorySegment memorySegment, int offset) {
            super(memorySegment, offset);
        }
    }

    public final static boolean HAVE_SYS_TYPES_H;

    /**
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD, LINUX, OPEN_BSD ->
                HAVE_SYS_TYPES_H = true;
            case WINDOWS ->
                HAVE_SYS_TYPES_H = false;
            default ->
                throw new NoClassDefFoundError("No sys/types.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

}
