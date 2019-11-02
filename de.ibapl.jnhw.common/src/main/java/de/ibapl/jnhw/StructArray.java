/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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
public abstract class StructArray<T extends OpaqueMemory> extends OpaqueMemory {

    private final T[] pointers;

    public StructArray(T[] array, int elementSizeInBytes, boolean clearMem) {
        super(array.length, elementSizeInBytes, clearMem);
        pointers = array;
        for (int i = 0; i < array.length; i++) {
            pointers[i] = createElementAtOffset(elementSizeInBytes * i);
        }
    }

    public final T get(int index) {
        return pointers[index];
    }

    /**
     * length is alway >= 0
     * @return 
     */
    public final int length() {
        return pointers.length;
    }

    protected abstract T createElementAtOffset(int offset);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (T element : pointers) {
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
