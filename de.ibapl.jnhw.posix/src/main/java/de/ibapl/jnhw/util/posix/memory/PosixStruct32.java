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

    public PosixStruct32(NativeAddressHolder nativeAddressHolder, int sizeInBytes) {
        super(nativeAddressHolder, sizeInBytes);
    }

    public PosixStruct32(AbstractNativeMemory owner, long offset, int sizeInBytes, Byte setMem) {
        super(owner, offset, sizeInBytes, setMem);
    }

    protected final static Accessor_Time_t ACCESSOR_TIME_T;

    static {
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
    }

}
