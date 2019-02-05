/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw;

/**
 *
 * @author aploese
 */
public abstract class StructArray<T extends OpaqueMemory> extends OpaqueMemory {
    
    private final T[] pointers;

    public StructArray(T[] array, int elementSizeInBytes) {
        super(array.length, elementSizeInBytes);
        pointers = array;
        for (int i = 0; i < array.length; i++) {
            pointers[i] = createElement(baseAddress + i * elementSizeInBytes);
        }
    }

    public final T get(int index) {
        return pointers[index];
    }

    public final int length() {
        return pointers.length;
    }

    protected abstract T createElement(long elementBaseAddress);
    
}
