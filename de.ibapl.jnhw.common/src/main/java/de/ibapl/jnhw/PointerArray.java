/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw;

/**
 *
 * @author aploese
 * @param <T>
 */
public class PointerArray<T extends OpaqueMemory> extends OpaqueMemory {
    
    public void set(int i, T element) {
        cachedReferences[i] = element;
        set0(i, element);
    }

    /**
     *
     * @param i the index must be in range.
     * @return
     */
    private native NativeAddressHolder get0(int i);

    /**
     *
     * @param i the index must be in range.
     * @param element
     */
    private native void set0(int i, T element);

    @FunctionalInterface
    public static interface ElementProducer<T extends OpaqueMemory> {

        /**
         *
         * @param baseAddress
         * @param index
         * @param cachedElement
         * @return
         */
        T produce(NativeAddressHolder baseAddress, int index, T cachedElement);

    }

    private final OpaqueMemory[] cachedReferences;

    public static native int sizeofPointer();

    public PointerArray(int length, boolean clearMem) {
        super(length, sizeofPointer(), clearMem);
        cachedReferences = new OpaqueMemory[length];
    }

    public final T get(int index, ElementProducer<T> p) {
        @SuppressWarnings("unchecked")
        final T ref = (T) cachedReferences[index];
        final NativeAddressHolder elementBaseAddress = get0(index);
        if (OpaqueMemory.isSameAddress(elementBaseAddress, ref)) {
            return ref;
        } else {
            final T newRef = p.produce(elementBaseAddress, index, ref);
            cachedReferences[index] = newRef;
            return newRef;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (Object element : cachedReferences) {
            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }
            sb.append(element);
        }
        sb.append("]");
        return sb.toString();
    }

}
