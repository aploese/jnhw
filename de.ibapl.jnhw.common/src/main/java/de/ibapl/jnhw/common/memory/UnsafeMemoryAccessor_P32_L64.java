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
public class UnsafeMemoryAccessor_P32_L64 extends UnsafeMemoryAccessor {

    @Override
    public long signed_long(OpaqueMemory32 mem, long offset) {
        return unsafe.getLong(mem.baseAddress + offset);
    }

    @Override
    public void signed_long(OpaqueMemory32 mem, long offset, long value) {
        unsafe.putLong(mem.baseAddress + offset, value);
    }

    @Override
    public long unsigned_long(OpaqueMemory32 mem, long offset) {
        return unsafe.getLong(mem.baseAddress + offset);
    }

    @Override
    public void unsigned_long(OpaqueMemory32 mem, long offset, long value) {
        unsafe.putLong(mem.baseAddress + offset, value);
    }

    @Override
    public long signed_long_AtIndex(OpaqueMemory32 mem, long offset, int index) {
        return unsafe.getLong(mem.baseAddress + offset + 8 * index);
    }

    @Override
    public void signed_long_AtIndex(OpaqueMemory32 mem, long offset, int index, long value) {
        unsafe.putLong(mem.baseAddress + offset + 8 * index, value);
    }

    @Override
    public long unsigned_long_AtIndex(OpaqueMemory32 mem, long offset, int index) {
        return unsafe.getLong(mem.baseAddress + offset + 8 * index);
    }

    @Override
    public void unsigned_long_AtIndex(OpaqueMemory32 mem, long offset, int index, long value) {
        unsafe.putLong(mem.baseAddress + offset + 8 * index, value);
    }

    @Override
    public long intptr_t(OpaqueMemory32 mem, long offset) {
        //restore the sign in the bitspace of int
        return (int)unsafe.getAddress(mem.baseAddress + offset);
    }

    @Override
    public void intptr_t(OpaqueMemory32 mem, long offset, long dest) {
        if ((dest > Integer.MAX_VALUE) || (dest < Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("value outside of int32_t: " + dest);
        }
        unsafe.putAddress(mem.baseAddress + offset, dest);
    }

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, long dest) {
        if (dest > 0x00000000ffffffffL) {
            throw new IllegalArgumentException("value too big for uint32_t: " + dest);
        }
        if (dest < 0) {
            throw new IllegalArgumentException("value must not be nagative");
        }
        unsafe.putAddress(mem.baseAddress + offset, dest);
    }

    @Override
    public String uintptr_t_AsHex(OpaqueMemory32 mem, long offset) {
        return String.format("0x%08x", unsafe.getAddress(mem.baseAddress + offset));
    }

}
