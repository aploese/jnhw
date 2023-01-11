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
package de.ibapl.jnhw.syscall.linux;

import de.ibapl.jnhw.common.memory.MemoryAccessor;
import de.ibapl.jnhw.common.memory.Struct;
import java.lang.foreign.MemorySegment;
import java.nio.ByteOrder;

/**
 *
 * @author aploese
 */
public abstract class AbstractLinuxSyscallStruct extends Struct {

    /**
     * Memory accessor with the natural byte order and byte alignment
     */
    protected final static MemoryAccessor MEM_ACCESS_BYTE_ALIGNED = MemoryAccessor.getMemoryAccessor(ByteOrder.nativeOrder(), 8);
    /**
     * Memory accessor with the little endian byte order and byte alignment
     */
    protected final static MemoryAccessor MEM_ACCESS_LE_BYTE_ALIGNED = MemoryAccessor.getMemoryAccessor(ByteOrder.LITTLE_ENDIAN, 8);
    /**
     * Memory accessor with the big endian byte order and byte alignment
     */
    protected final static MemoryAccessor MEM_ACCESS_BE_BYTE_ALIGNED = MemoryAccessor.getMemoryAccessor(ByteOrder.BIG_ENDIAN, 8);

    public AbstractLinuxSyscallStruct(MemorySegment memorySegment, long offset, int sizeInBytes) {
        super(memorySegment, offset, sizeInBytes);
    }

}
