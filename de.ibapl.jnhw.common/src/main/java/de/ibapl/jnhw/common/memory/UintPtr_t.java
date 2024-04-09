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
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.exception.InvalidCacheException;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 * @param <D>
 */
public class UintPtr_t<D extends Pointer> extends OpaqueMemory {

    public final static BaseDataType DATA_TYPE = BaseDataType.uintptr_t;

    public static <T extends Pointer> UintPtr_t<T> allocateNative(Arena arena) {
        return new UintPtr_t<>(arena.allocate(DATA_TYPE.SIZE_OF, DATA_TYPE.ALIGN_OF.alignof), 0);
    }

    public static <T extends Pointer> UintPtr_t<T> ofAddress(MemorySegment baseAddress, Arena arena) {
        return new UintPtr_t<>(baseAddress.reinterpret(DATA_TYPE.SIZE_OF, arena, null), 0);
    }

    private D cached;

    public UintPtr_t(MemorySegment memorySegment, long offset) {
        super(memorySegment, offset, DATA_TYPE.SIZE_OF);
    }

    public D getAs() throws InvalidCacheException {
        final MemorySegment result = get();
        if ((cached != null) && (cached.toAddress() == result.address())) {
            return cached;
        } else {
            throw new InvalidCacheException(cached, result);
        }
    }

    public MemorySegment get() {
        return MEM_ACCESS.uintptr_t(memorySegment, 0);
    }

    public void set(D value) {
        MEM_ACCESS.uintptr_t(memorySegment, 0, value.toMemorySegment());
        cached = value;
    }

    public void set(MemorySegment value) {
        MEM_ACCESS.uintptr_t(memorySegment, 0, value);
        cached = null;
    }

    @Override
    public String nativeToHexString() {
        return MEM_ACCESS.uintptr_t_AsHex(memorySegment, 0);
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        sb.append(MEM_ACCESS.uintptr_t_nativeToString(memorySegment, 0));
    }

    @Override
    public BaseDataType getBaseDataType() {
        return DATA_TYPE;
    }

}
