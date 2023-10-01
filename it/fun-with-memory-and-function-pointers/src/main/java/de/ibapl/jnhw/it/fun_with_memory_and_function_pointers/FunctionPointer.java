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
package de.ibapl.jnhw.it.fun_with_memory_and_function_pointers;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh__V__sI;
import de.ibapl.jnhw.common.upcall.Callback__V___I;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public class FunctionPointer {

    public static void call_I__V() {
        System.out.println("\n\nFunctionPointer.call_I__V()\n");
        Callback__V___I cb = new Callback__V___I() {

            @Override
            protected void callback(int value) {
                System.out.println("From callback value: " + value + " Stacktrace:");
                new Throwable().printStackTrace();
                System.out.println("End of stacktrace... called via pointer in native memory");
            }
        };
        System.out.println("cb: " + cb.toString());

        //get the native address and encapsulate it in an NativeAddressHolder..
        System.out.println("nah: " + cb.toAddress());
        JnhwMh__V__sI.ExceptionErased cn = JnhwMh__V__sI.of(
                MemorySegment.ofAddress(cb.toAddress()),
                "testCallback",
                BaseDataType.C_int);
        System.out.println("cn: " + cn.toString());

        System.out.println("Do the call!>>>");
        cn.invoke__V__sI(42);
        System.out.println("<<<Done!");

    }

}
