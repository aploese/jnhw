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
package de.ibapl.jnhw.common.memory;

import java.nio.ByteOrder;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public final class MemoryAccessorImpl_L64 extends AbstractMemoryAccessorImpl {

    private final ValueLayout.OfLong LAYOUT__LONG;

    private final ValueLayout.OfLong LAYOUT__UNSIGNED_LONG;

    private final static int LONG_SIZE = 8;

    public MemoryAccessorImpl_L64(ByteOrder byteOrder) {
        super(byteOrder);
        LAYOUT__LONG = ValueLayout.JAVA_LONG.withOrder(byteOrder);
        LAYOUT__UNSIGNED_LONG = ValueLayout.JAVA_LONG.withOrder(byteOrder);
    }

    @Override
    public long signed_long(MemorySegment mem, long offset) {
        return mem.get(LAYOUT__LONG, offset);
    }

    @Override
    public void signed_long(MemorySegment mem, long offset, long value) {
        mem.set(LAYOUT__LONG, offset, value);
    }

    @Override
    public long unsigned_long(MemorySegment mem, long offset) {
        return mem.get(LAYOUT__UNSIGNED_LONG, offset);
    }

    @Override
    public void unsigned_long(MemorySegment mem, long offset, long value) {
        mem.set(LAYOUT__UNSIGNED_LONG, offset, value);
    }

    @Override
    public long signed_long_AtIndex(MemorySegment mem, long offset, int index) {
        return mem.get(LAYOUT__LONG, offset + LONG_SIZE * index);
    }

    @Override
    public void signed_long_AtIndex(MemorySegment mem, long offset, int index, long value) {
        mem.set(LAYOUT__LONG, offset + LONG_SIZE * index, value);
    }

    @Override
    public long unsigned_long_AtIndex(MemorySegment mem, long offset, int index) {
        return mem.get(LAYOUT__UNSIGNED_LONG, offset + LONG_SIZE * index);
    }

    @Override
    public void unsigned_long_AtIndex(MemorySegment mem, long offset, int index, long value) {
        mem.set(LAYOUT__UNSIGNED_LONG, offset + LONG_SIZE * index, value);
    }

    @Override
    public String intptr_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%08x", intptr_t(mem, offset));
    }

    @Override
    public String uintptr_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%08x", uint8_t(mem, offset));
    }

}
