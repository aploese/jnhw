/*
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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.Pointer;
import java.io.IOException;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

/**
 *
 * @author aploese
 * @param <D> the destination to point to
 */
public class IntPtr_t<D extends Pointer> extends OpaqueMemory {

    public final static BaseDataType DATA_TYPE = BaseDataType.intptr_t;

    public static <T extends Pointer> IntPtr_t<T> allocateNative(MemorySession ms) {
        return new IntPtr_t<>(MemorySegment.allocateNative(DATA_TYPE.SIZE_OF, ms), 0);
    }

    public static <T extends Pointer> IntPtr_t<T> ofAddress(MemoryAddress baseAddress, MemorySession ms) {
        return new IntPtr_t<>(MemorySegment.ofAddress(baseAddress, DATA_TYPE.SIZE_OF, ms), 0);
    }

    private D cached;

    public IntPtr_t(MemorySegment memorySegment, long offset) {
        super(memorySegment, offset, DATA_TYPE.SIZE_OF);
    }

    public <O extends OpaqueMemory> O getAsOpaqueMemory(OpaqueMemoryProducer<O, IntPtr_t<D>> opaqueMemoryProducer, MemorySession ms) {
        final MemoryAddress result = get();
        if (cached instanceof OpaqueMemory cachedOM) {
            if (OpaqueMemory.isSameAddress(result, cachedOM)) {
                //no-op
            } else {
                cached = (D) opaqueMemoryProducer.produce(result, ms, this);
            }
        } else {
            cached = (D) opaqueMemoryProducer.produce(result, ms, this);
        }
        return (O) cached;
    }

    public MemoryAddress get() {
        return MEM_ACCESS.intptr_t(memorySegment, 0);
    }

    public void set(D value) {
        MEM_ACCESS.intptr_t(memorySegment, 0, value.toAddressable());
        cached = value;
    }

    public void set(MemoryAddress value) {
        MEM_ACCESS.intptr_t(memorySegment, 0, value);
    }

    @Override
    public String nativeToHexString() {
        return MEM_ACCESS.intptr_t_AsHex(memorySegment, 0);
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        sb.append(MEM_ACCESS.intptr_t_nativeToString(memorySegment, 0));
    }

    @Override
    public BaseDataType getBaseDataType() {
        return DATA_TYPE;
    }

}
