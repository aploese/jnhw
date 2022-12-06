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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import java.io.IOException;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

/**
 *
 * @author aploese
 */
public class PtrChar extends OpaqueMemory {

    public final static BaseDataType DATA_TYPE = BaseDataType.C_char_pointer;

    public static PtrChar allocateNative(MemorySession ms) {
        return new PtrChar(MemorySegment.allocateNative(DATA_TYPE.SIZE_OF, ms), 0);
    }

    public PtrChar(MemorySegment memorySegment, long offset) {
        super(memorySegment, offset, DATA_TYPE.SIZE_OF);
    }

    public static PtrChar map(OpaqueMemory mem, long offset) {
        return new PtrChar(mem.memorySegment, offset);
    }

    public String get() {
        return MEM_ACCESS.getUTF_8String(memorySegment, 0);
    }

    public void set(String value) {
        MEM_ACCESS.setUTF_8String(memorySegment, 0, value);
    }

    @Override
    public String nativeToHexString() {
        return get();
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        sb.append(get());
    }

    @Override
    public BaseDataType getBaseDataType() {
        return DATA_TYPE;
    }

}
