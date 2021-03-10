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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *
 * @author aploese
 * @param <T>
 */
public abstract class StructArray32<T extends OpaqueMemory32> extends OpaqueMemory32 implements Iterable<T> {

    @FunctionalInterface
    protected interface ElementFactory<T extends OpaqueMemory32> {

        T create(StructArray32<T> parent, long offset);

    }

    private final T[] elements;

    protected StructArray32(T[] array, ElementFactory<T> factory, int elementSizeInBytes, Byte setMem) {
        super((OpaqueMemory32) null, 0, array.length * elementSizeInBytes, setMem);
        elements = array;
        for (int i = 0; i < array.length; i++) {
            elements[i] = factory.create(this, elementSizeInBytes * i);
        }
    }

    protected StructArray32(AbstractNativeMemory parent, long offset, T[] array, ElementFactory<T> factory, int elementSizeInBytes, Byte setMem) {
        super(parent, offset, array.length * elementSizeInBytes, setMem);
        elements = array;
        for (int i = 0; i < array.length; i++) {
            elements[i] = factory.create(this, elementSizeInBytes * i);
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
    public final int length() {
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
    public String nativeToHexString() {
        if (sizeInBytes > Integer.MAX_VALUE / 2) {
            throw new UnsupportedOperationException("memory block is too big!");
        } else {
            StringBuilder sb = new StringBuilder(sizeInBytes * 2);
            for (int i = 0; i < sizeInBytes; i++) {
                sb.append(String.format("%02x", OpaqueMemory32.getByte(this, i)));
            }
            return sb.toString();
        }
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
