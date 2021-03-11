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
package de.ibapl.jnhw.common.memory;

/**
 *
 * @author aploese
 */
class UnsafeMemoryAccessor32 extends UnsafeMemoryAccessor {

    @Override
    public long signed_long(OpaqueMemory32 mem, long offset) {
        return unsafe.getInt(mem.baseAddress + offset);
    }

    @Override
    public void signed_long(OpaqueMemory32 mem, long offset, long value) {
        if ((value > Integer.MAX_VALUE) || (value < Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("value outside of int32_t: " + value);
        }
        unsafe.putInt(mem.baseAddress + offset, (int) value);
    }

    @Override
    public long unsigned_long(OpaqueMemory32 mem, long offset) {
        return (long) (unsafe.getInt(mem.baseAddress + offset) & 0x00000000ffffffffL);
    }

    @Override
    public void unsigned_long(OpaqueMemory32 mem, long offset, long value) {
        if (value > 0x00000000ffffffffL) {
            throw new IllegalArgumentException("value too big for uint32_t: " + value);
        }
        if (value < 0) {
            throw new IllegalArgumentException("value must not be nagative");
        }
        unsafe.putInt(mem.baseAddress + offset, (int) value);
    }

}