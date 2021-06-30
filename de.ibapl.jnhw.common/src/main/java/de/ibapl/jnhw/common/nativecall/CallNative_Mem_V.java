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
package de.ibapl.jnhw.common.nativecall;

import de.ibapl.jnhw.common.LibJnhwCommonLoader;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_Mem_V;

/**
 * Call a native function pointer.
 *
 * @author aploese
 */
public class CallNative_Mem_V<A extends AbstractNativeMemory> extends FunctionPtr_Mem_V<A> {

    static {
        LibJnhwCommonLoader.touch();
    }

    public static CallNative_Mem_V wrap(NativeFunctionPointer src) {
        return new CallNative_Mem_V(src);
    }

    public static CallNative_Mem_V wrap(NativeAddressHolder src) {
        return new CallNative_Mem_V(src);
    }

    public CallNative_Mem_V(NativeFunctionPointer src) {
        super(src);
    }

    public CallNative_Mem_V(NativeAddressHolder src) {
        super(src);
    }

    /**
     * call the native function.
     *
     * @param value
     */
    public void call(A a) {
        call(nativeAddress, AbstractNativeMemory.getAddress(a));
    }

    public native void call(long ptrAddress, long ptrA);
}
