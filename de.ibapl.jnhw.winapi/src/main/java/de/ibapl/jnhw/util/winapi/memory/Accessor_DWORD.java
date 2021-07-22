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
package de.ibapl.jnhw.util.winapi.memory;

import de.ibapl.jnhw.annotation.winapi.basetsd.DWORD;
import de.ibapl.jnhw.common.memory.MemoryAccessor;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.winapi.Winbase;

/**
 *
 * @author aploese
 */
@DWORD
public interface Accessor_DWORD {

    @DWORD
    int DWORD(OpaqueMemory32 mem, long offset);

    void DWORD(OpaqueMemory32 mem, long offset, @DWORD int value);

    @DWORD
    long DWORD_AsLong(OpaqueMemory32 mem, long offset);

    void DWORD_FromLong(OpaqueMemory32 mem, long offset, @DWORD long value);

    default boolean getBitAt(OpaqueMemory32 mem, long offset, int bitpos) {
        return MemoryAccessor.getBitInInt(DWORD(mem, offset), bitpos);
    }

    default int getBits(OpaqueMemory32 mem, long offset, int bitpos, int bitsize) {
        return MemoryAccessor.getBitsInInt(DWORD(mem, offset), bitpos, bitsize);
    }

    default void setBitAt(OpaqueMemory32 mem, long offset, int bitpos, boolean bit) {
        DWORD(mem, offset, MemoryAccessor.setBitInInt(DWORD(mem, offset), bitpos, bit));
    }

    default void setBits(OpaqueMemory32 mem, long offset, int bitpos, int bitsize, int value) {
        DWORD(mem, offset, MemoryAccessor.setBitsInInt(DWORD(mem, offset), bitpos, bitsize, value));
    }

}
