/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2022-2024, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public abstract class Struct extends OpaqueMemory {

    public Struct(MemorySegment memorySegment, long offset, long sizeInBytes) {
        super(memorySegment, offset, sizeInBytes);
    }

    public Struct(OpaqueMemory mem, long offset, long sizeInBytes) {
        super(mem, offset, sizeInBytes);
    }

    public Struct(long baseAddress, Arena arena, long sizeInBytes) {
        super(baseAddress, arena, sizeInBytes);
    }

    @Override
    public final BaseDataType getBaseDataType() {
        return BaseDataType.struct;
    }

}
