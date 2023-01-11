/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.util.winapi.memory;

import de.ibapl.jnhw.annotation.winapi.basetsd.DWORD;
import de.ibapl.jnhw.common.memory.MemoryAccessor;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
@DWORD
public interface Accessor_DWORD {

    @DWORD
    int DWORD(MemorySegment memorySegment, long offset);

    void DWORD(MemorySegment memorySegment, long offset, @DWORD int value);

    @DWORD
    long DWORD_AsLong(MemorySegment memorySegment, long offset);

    void DWORD_FromLong(MemorySegment memorySegment, long offset, @DWORD long value);

    default boolean getBitAt(MemorySegment memorySegment, long offset, int bitpos) {
        return MemoryAccessor.getBitInInt(DWORD(memorySegment, offset), bitpos);
    }

    default int getBits(MemorySegment memorySegment, long offset, int bitpos, int bitsize) {
        return MemoryAccessor.getBitsInInt(DWORD(memorySegment, offset), bitpos, bitsize);
    }

    default void setBitAt(MemorySegment memorySegment, long offset, int bitpos, boolean bit) {
        DWORD(memorySegment, offset, MemoryAccessor.setBitInInt(DWORD(memorySegment, offset), bitpos, bit));
    }

    default void setBits(MemorySegment memorySegment, long offset, int bitpos, int bitsize, int value) {
        DWORD(memorySegment, offset, MemoryAccessor.setBitsInInt(DWORD(memorySegment, offset), bitpos, bitsize, value));
    }

}
