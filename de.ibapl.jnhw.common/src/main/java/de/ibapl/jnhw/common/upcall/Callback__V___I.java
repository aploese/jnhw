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
package de.ibapl.jnhw.common.upcall;

import de.ibapl.jnhw.common.nativepointer.FunctionPtr__V___I;
import java.lang.foreign.MemoryAddress;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

/**
 *
 * @author aploese
 */
public abstract class Callback__V___I extends FunctionPtr__V___I {

    private static final List<WeakReference<Callback__V___I>> REFS = new LinkedList<>();

    /**
     * Iterate over weak references all instances oth this class and if the
     * reference is gone remove the weak reference. Return the first found
     * instance or null if none is found.
     *
     * @param callbackPtr
     * @return the first found instance or null if none is found.
     */
    public static Callback__V___I find(FunctionPtr__V___I callbackPtr) {
        return find(callbackPtr.toAddressable().address());
    }

    /**
     * Iterate over weak references all instances oth this class and if the
     * reference is gone remove the weak reference. Return the first found
     * instance or null if none is found.
     *
     * @param callbackPtr
     * @return the first found instance or null if none is found.
     */
    public static Callback__V___I find(MemoryAddress callbackPtr) {
        final ListIterator<WeakReference<Callback__V___I>> iter = REFS.listIterator();
        while (iter.hasNext()) {
            final WeakReference<Callback__V___I> weak = iter.next();
            final Callback__V___I result = weak.get();
            if (result == null) {
                iter.remove();
            } else {
                if (result.memoryAddress.equals(callbackPtr)) {
                    return result;
                }
            }
        }
        return null;
    }

    protected <T extends Callback__V___I> Callback__V___I(Function<T, MemoryAddress> producer) {
        super(producer);
        REFS.add(new WeakReference<>(this));
    }

    protected Callback__V___I(MemoryAddress address) {
        super(address);
        REFS.add(new WeakReference<>(this));
    }

    public Callback__V___I() {
        super(CallbackFactory__V___I::aquire);
        REFS.add(new WeakReference<>(this));
    }

    public void release() {
        CallbackFactory__V___I.release(this);
    }

    /**
     * this will be called from the native code.
     *
     * @param value
     */
    protected abstract void callback(int value);

}
