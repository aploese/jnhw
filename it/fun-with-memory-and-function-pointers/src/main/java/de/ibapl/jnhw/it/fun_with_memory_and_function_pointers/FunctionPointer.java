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
package de.ibapl.jnhw.it.fun_with_memory_and_function_pointers;

import de.ibapl.jnhw.common.callback.Callback_I_V;
import de.ibapl.jnhw.common.callback.Callback_I_V_Impl;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.NativeFunctionPointer;
import de.ibapl.jnhw.common.nativecall.CallNative_I_V;
import de.ibapl.jnhw.common.nativepointer.FunctionPtr_I_V;

/**
 *
 * @author aploese
 */
public class FunctionPointer {

    public static void call_I__V() {
        System.out.println("\n\nFunctionPointer.call_I__V()\n");
        Callback_I_V cb = new Callback_I_V_Impl() {

            @Override
            protected void callback(int value) {
                System.out.println("From callback value: " + value + " Stacktrace:");
                new Throwable().printStackTrace();
                System.out.println("End of stacktrace... called via pointer in native memory");
            }
        };
        System.out.println("cb: " + cb.toString());

        //get the native address and encapsulate it in an NativeAddressHolder..
        NativeAddressHolder nah = NativeFunctionPointer.toNativeAddressHolder(cb);
        System.out.println("nah: " + nah.toString());
        CallNative_I_V cn = new CallNative_I_V(nah);
        System.out.println("cn: " + cn.toString());

        System.out.println("Do the call!>>>");
        cn.call(42);
        System.out.println("<<<Done!");

        //both can be interchangeable used ... in struct members or function calls
        FunctionPtr_I_V ptr_cb = cb;
        FunctionPtr_I_V ptr_cn = cn;

    }

}
