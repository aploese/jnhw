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

import java.util.function.ToLongFunction;

/**
 *
 * @author aploese
 */
public abstract class Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A extends OpaqueMemory, B extends OpaqueMemory> extends NativeFunctionPointer {

    public static Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V wrap(long nativeAddress) {
        Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V result = new Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V(nativeAddress) {

            @Override
            protected void callback(int value, OpaqueMemory a, OpaqueMemory b) {
                throw new UnsupportedOperationException("This is a wrapper for an unknown function. Only the address is known to us, but not the Type!");
            }

        };
        return result;
    }

    public <T extends Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V<A, B>> Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V(ToLongFunction<T> producer) {
        super(producer);
    }

    public Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V(long nativeAddress) {
        super(nativeAddress);
    }

    public Callback_I_PtrOpaqueMemory_PtrOpaqueMemory_V(NativePointer src) {
        super(src);
    }

    /**
     * this will be called from the native code.
     *
     * @param value
     * @param a
     * @param b
     */
    protected abstract void callback(int value, A a, B b);

}
