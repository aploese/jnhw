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
import de.ibapl.jnhw.common.exception.InvalidCacheException;
import java.io.IOException;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 * @param <D>
 */
public class PointerArray<D extends Pointer> extends OpaqueMemory {

    private final D[] cachedReferences;

    public PointerArray(MemorySegment memorySegment, long offset, int arrayLength) {
        super(memorySegment, offset, arrayLength * BaseDataType.uintptr_t.SIZE_OF);
        cachedReferences = (D[]) new Pointer[arrayLength];
    }

    public void set(int i, D element) throws IndexOutOfBoundsException {
        MEM_ACCESS.uintptr_t_AtIndex(memorySegment, i, element.toMemorySegment());
        cachedReferences[i] = element;
    }

    @Override
    public BaseDataType getBaseDataType() {
        return BaseDataType.array;
    }

    @Override
    public String nativeToHexString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public final MemorySegment get(int index) throws IndexOutOfBoundsException {
        return MEM_ACCESS.uintptr_t_AtIndex(memorySegment, index);
    }

    public final D getAs(int index) throws InvalidCacheException, IndexOutOfBoundsException {
        final MemorySegment elementBaseAddress = MEM_ACCESS.uintptr_t_AtIndex(memorySegment, index);
        final D ref = cachedReferences[index];
        if ((ref != null) && (ref.toAddress() == elementBaseAddress.address())) {
            return ref;
        } else {
            throw new InvalidCacheException(ref, elementBaseAddress);
        }
    }

    /**
     * length is alway {@code >= 0}
     *
     * @return the length of this array of pointer.
     */
    public final int length() {
        return cachedReferences.length;
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        final String INDENT = indentPrefix + indent;
        final boolean doIndent = INDENT.length() > 0;
        sb.append("[");
        if (doIndent) {
            sb.append("\n").append(INDENT);
        }
        boolean first = true;
        for (Pointer element : cachedReferences) {
            if (first) {
                first = false;
            } else {
                if (doIndent) {
                    sb.append(",\n").append(INDENT);
                } else {
                    sb.append(", ");
                }
            }
            if (element == null) {
                sb.append("null");
            } else {
                element.nativeToString(sb, INDENT, indent);
            }
        }
        sb.append("]");
    }
}
