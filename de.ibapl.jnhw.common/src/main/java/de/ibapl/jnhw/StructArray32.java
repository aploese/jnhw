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
public abstract class StructArray32<T extends OpaqueMemory32> extends OpaqueMemory32 {
    
    @FunctionalInterface
    protected interface ElementFactory<T extends OpaqueMemory32>{
        
        T create(StructArray32<T> parent, int offset);
        
    }
    
    private final T[] elements;

    public StructArray32(T[] array, ElementFactory<T> factory, int elementSizeInBytes, boolean clearMem) {
        super(array.length, elementSizeInBytes, clearMem);
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
     * @return the length of this array of given struct. 
     */
    public final int length() {
        return elements.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (T element : elements) {
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
