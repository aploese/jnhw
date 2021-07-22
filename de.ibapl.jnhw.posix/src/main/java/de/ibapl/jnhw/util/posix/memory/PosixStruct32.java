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
package de.ibapl.jnhw.util.posix.memory;

import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.util.posix.PosixDataType;

/**
 *
 * @author aploese
 */
public abstract class PosixStruct32 extends Struct32 {

    protected static class Accessor_Off_t_As_int32_t implements Accessor_Off_t {

        @Override
        public long off_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.int32_t(mem, offset);
        }

        @Override
        public void off_t(OpaqueMemory32 mem, long offset, long value) {
            if ((value > Integer.MAX_VALUE) || (value < Integer.MIN_VALUE)) {
                throw new IllegalArgumentException("value outside of int32_t: " + value);
            }
            MEM_ACCESS.int32_t(mem, offset, (int) value);
        }

    }

    protected static class Accessor_Off_t_As_int64_t implements Accessor_Off_t {

        @Override
        public long off_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.int64_t(mem, offset);
        }

        @Override
        public void off_t(OpaqueMemory32 mem, long offset, long value) {
            MEM_ACCESS.int64_t(mem, offset, value);
        }

    }

    protected static class Accessor_Pid_t_As_int32_t implements Accessor_Pid_t {

        @Override
        public int pid_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.int32_t(mem, offset);
        }

        @Override
        public void pid_t(OpaqueMemory32 mem, long offset, int value) {
            MEM_ACCESS.int32_t(mem, offset, value);
        }

    }

    protected static class Accessor_Size_t_As_uint32_t implements Accessor_Size_t {

        @Override
        public long size_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint32_t_AsLong(mem, offset);
        }

        @Override
        public void size_t(OpaqueMemory32 mem, long offset, long value) {
            if (value > 0x00000000ffffffffL) {
                throw new IllegalArgumentException("value too big for uint32_t: " + value);
            }
            MEM_ACCESS.uint32_t_FromLong(mem, offset, (int) value);
        }

    }

    protected static class Accessor_Size_t_As_uint64_t implements Accessor_Size_t {

        @Override
        public long size_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint64_t(mem, offset);
        }

        @Override
        public void size_t(OpaqueMemory32 mem, long offset, long value) {
            MEM_ACCESS.uint64_t(mem, offset, value);
        }

    }

    protected static class Accessor_Speed_t_As_uint32_t implements Accessor_speed_t {

        @Override
        public long speed_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint32_t_AsLong(mem, offset);
        }

        @Override
        public void speed_t(OpaqueMemory32 mem, long offset, long value) {
            if (value > 0x00000000ffffffffL) {
                throw new IllegalArgumentException("value too big for uint32_t: " + value);
            }
            MEM_ACCESS.uint32_t_FromLong(mem, offset, (int) value);
        }

        @Override
        public int speed_tAsInt(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint32_t(mem, offset);
        }

        @Override
        public void speed_tFromInt(OpaqueMemory32 mem, long offset, int value) {
            MEM_ACCESS.uint32_t(mem, offset, value);
        }

    }

    protected static class Accessor_Speed_t_As_uint64_t implements Accessor_speed_t {

        @Override
        public long speed_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint64_t(mem, offset);
        }

        @Override
        public void speed_t(OpaqueMemory32 mem, long offset, long value) {
            MEM_ACCESS.uint64_t(mem, offset, value);
        }

        @Override
        public int speed_tAsInt(OpaqueMemory32 mem, long offset) {
            final long result = MEM_ACCESS.uint64_t(mem, offset);
            if ((result & 0xFFFFFFFF00000000L) == 0L) {
                return (int) result;
            } else {
                throw new IllegalArgumentException("speed_t is lager than int: " + result);
            }
        }

        @Override
        public void speed_tFromInt(OpaqueMemory32 mem, long offset, int value) {
            MEM_ACCESS.uint64_t(mem, offset, 0x00FFFFFFFFL & value);
        }

    }

    protected static class Accessor_Tcflag_t_As_uint32_t implements Accessor_tcflag_t {

        @Override
        public long tcflag_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint32_t_AsLong(mem, offset);
        }

        @Override
        public void tcflag_t(OpaqueMemory32 mem, long offset, long value) {
            if (value > 0x00000000ffffffffL) {
                throw new IllegalArgumentException("value too big for uint32_t: " + value);
            }
            MEM_ACCESS.uint32_t_FromLong(mem, offset, (int) value);
        }

        @Override
        public int tcflag_tAsInt(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint32_t(mem, offset);
        }

        @Override
        public void tcflag_tFromInt(OpaqueMemory32 mem, long offset, int value) {
            MEM_ACCESS.uint32_t(mem, offset, value);
        }

    }

    protected static class Accessor_Tcflag_t_As_uint64_t implements Accessor_tcflag_t {

        @Override
        public long tcflag_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint64_t(mem, offset);
        }

        @Override
        public void tcflag_t(OpaqueMemory32 mem, long offset, long value) {
            MEM_ACCESS.uint64_t(mem, offset, value);
        }

        @Override
        public int tcflag_tAsInt(OpaqueMemory32 mem, long offset) {
            final long result = MEM_ACCESS.uint64_t(mem, offset);
            if ((result & 0xFFFFFFFF00000000L) == 0L) {
                return (int) result;
            } else {
                throw new IllegalArgumentException("tcflag_t is lager than int: " + result);
            }
        }

        @Override
        public void tcflag_tFromInt(OpaqueMemory32 mem, long offset, int value) {
            MEM_ACCESS.uint64_t(mem, offset, 0x00FFFFFFFFL & value);
        }

    }

    protected static class Accessor_Time_t_As_int32_t implements Accessor_Time_t {

        @Override
        public long time_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.int32_t(mem, offset);
        }

        @Override
        public void time_t(OpaqueMemory32 mem, long offset, long value) {
            if ((value > Integer.MAX_VALUE) || (value < Integer.MIN_VALUE)) {
                throw new IllegalArgumentException("value outside of int32_t: " + value);
            }
            MEM_ACCESS.int32_t(mem, offset, (int) value);
        }

    }

    protected static class Accessor_Time_t_As_int64_t implements Accessor_Time_t {

        @Override
        public long time_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.int64_t(mem, offset);
        }

        @Override
        public void time_t(OpaqueMemory32 mem, long offset, long value) {
            MEM_ACCESS.int64_t(mem, offset, value);
        }

    }

    protected static class Accessor_Uid_t_As_uint32_t implements Accessor_Uid_t {

        @Override
        public long uid_t(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint32_t_AsLong(mem, offset);
        }

        @Override
        public void uid_t(OpaqueMemory32 mem, long offset, long value) {
            MEM_ACCESS.uint32_t_FromLong(mem, offset, (int) value);
        }

    }

    protected final static Accessor_Off_t ACCESSOR_OFF_T;

    protected final static Accessor_Pid_t ACCESSOR_PID_T;

    protected final static Accessor_Size_t ACCESSOR_SIZE_T;
    protected final static Accessor_speed_t ACCESSOR_SPEED_T;
    protected final static Accessor_tcflag_t ACCESSOR_TCFLAG_T;
    protected final static Accessor_Time_t ACCESSOR_TIME_T;
    protected final static Accessor_Uid_t ACCESSOR_UID_T;
    static {
        switch (PosixDataType.off_t.baseDataType) {
            case int64_t:
                ACCESSOR_OFF_T = new Accessor_Off_t_As_int64_t();
                break;
            case int32_t:
                ACCESSOR_OFF_T = new Accessor_Off_t_As_int32_t();
                break;
            default:
                throw new IllegalStateException("off_t is neither int64_t nor int32_t");
        }
        switch (PosixDataType.pid_t.baseDataType) {
            case int32_t:
                ACCESSOR_PID_T = new Accessor_Pid_t_As_int32_t();
                break;
            default:
                throw new IllegalStateException("pid_t is not int32_t");
        }
        switch (PosixDataType.size_t.baseDataType) {
            case uint64_t:
                ACCESSOR_SIZE_T = new Accessor_Size_t_As_uint64_t();
                break;
            case uint32_t:
                ACCESSOR_SIZE_T = new Accessor_Size_t_As_uint32_t();
                break;
            default:
                throw new IllegalStateException("size_t is neither int64_t nor int32_t");
        }
        switch (PosixDataType.speed_t.baseDataType) {
            case uint64_t:
                ACCESSOR_SPEED_T = new Accessor_Speed_t_As_uint64_t();
                break;
            case uint32_t:
                ACCESSOR_SPEED_T = new Accessor_Speed_t_As_uint32_t();
                break;
            default:
                throw new IllegalStateException("speed_t is neither int64_t nor int32_t");
        }
        switch (PosixDataType.tcflag_t.baseDataType) {
            case uint64_t:
                ACCESSOR_TCFLAG_T = new Accessor_Tcflag_t_As_uint64_t();
                break;
            case uint32_t:
                ACCESSOR_TCFLAG_T = new Accessor_Tcflag_t_As_uint32_t();
                break;
            default:
                throw new IllegalStateException("size_t is neither int64_t nor int32_t");
        }
        switch (PosixDataType.time_t.baseDataType) {
            case int64_t:
                ACCESSOR_TIME_T = new Accessor_Time_t_As_int64_t();
                break;
            case int32_t:
                ACCESSOR_TIME_T = new Accessor_Time_t_As_int32_t();
                break;
            default:
                throw new IllegalStateException("time_t is neither int64_t nor int32_t");
        }
        switch (PosixDataType.uid_t.baseDataType) {
            case uint32_t:
                ACCESSOR_UID_T = new Accessor_Uid_t_As_uint32_t();
                break;
            default:
                throw new IllegalStateException("uid_t is not uint32_t");
        }
    }
    public PosixStruct32(AbstractNativeMemory owner, long offset, int sizeInBytes, SetMem setMem) {
        super(owner, offset, sizeInBytes, setMem);
    }

    public PosixStruct32(NativeAddressHolder nativeAddressHolder, int sizeInBytes) {
        super(nativeAddressHolder, sizeInBytes);
    }

}
