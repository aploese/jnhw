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
import de.ibapl.jnhw.common.memory.layout.Alignment;
import java.io.IOException;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *
 * @author aploese
 * @param <T>
 */
public class MemoryArray<T extends OpaqueMemory> extends OpaqueMemory implements Iterable<T> {

    @FunctionalInterface
    protected interface ElementFactory<T extends OpaqueMemory> {

        /**
         *
         * @param memorySegment the memorySegment to use.
         * @param elementOffset the offset in memorySegment to be set as offset
         * for this element.
         * @param index the index of this element.
         * @return the new element at index
         */
        T create(MemorySegment memorySegment, long elementOffset, int index);

    }

    public static <T extends OpaqueMemory> MemoryArray<T> allocateNative(Arena arena, T[] array, ElementFactory<T> factory, Alignment alignment, long elementSizeInBytes) {
        return new MemoryArray<>(arena.allocate(array.length * elementSizeInBytes, alignment.alignof), 0, array, factory, elementSizeInBytes);
    }

    public static <T extends OpaqueMemory> MemoryArray<T> map(OpaqueMemory mem, long offset, T[] array, ElementFactory<T> factory, Alignment alignment, long elementSizeInBytes) {
        if (0 != mem.memorySegment.address() % alignment.alignof) {
            throw new IllegalArgumentException("alignment mismatch must be aligned at " + alignment.alignof);
        }
        return new MemoryArray<>(mem.memorySegment, offset, array, factory, elementSizeInBytes);
    }

    private final T[] elements;

    protected MemoryArray(MemorySegment memorySegment, long offset, T[] array, ElementFactory<T> factory, long elementSizeInBytes) {
        super(memorySegment, offset, array.length * elementSizeInBytes);
        elements = array;
        for (int i = 0; i < array.length; i++) {
            elements[i] = factory.create(memorySegment, elementSizeInBytes * i + offset, i);
            //TODO check alignment??
            if (elements[i].memorySegment.byteSize() != elementSizeInBytes) {
                throw new IllegalArgumentException("Size of element[" + i + "] " + elements[i].memorySegment.byteSize() + " != " + elementSizeInBytes);
            }
        }
    }

    public final T get(int index) {
        return elements[index];
    }

    /**
     * length is alway {@code >= 0}
     *
     * @return the length of this array of given struct.
     */
    public final long length() {
        return elements.length;
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
        for (T element : elements) {
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
        if (doIndent) {
            sb.append("\n").append(INDENT);
        }
        sb.append("]");
    }

    @Override
    public BaseDataType getBaseDataType() {
        return BaseDataType.array;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.asList(elements).iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Arrays.asList(elements).forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Arrays.asList(elements).spliterator();
    }

}
