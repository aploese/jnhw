/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.posix.util.methodhandles;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMethodInvoker;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMethodHandle;
import de.ibapl.jnhw.posix.Pthread;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public interface JnhwMethodHandle_Sint_PthreadT_PthreadT extends JnhwMethodHandle {

    static class JnhwMethodInvoker_Int_Long_Long extends JnhwMethodInvoker implements JnhwMethodHandle_Sint_PthreadT_PthreadT {

        private JnhwMethodInvoker_Int_Long_Long(SymbolLookup symbolLookup, String name) {
            super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG));
        }

        @Override
        public int invokeExact(Pthread.Pthread_t arg1, Pthread.Pthread_t arg2) {
            try {
                return (int) methodHandle.invokeExact(arg1.asUint64_t(), arg2.asUint64_t());
            } catch (NullPointerException npe) {
                throw npe;
            } catch (Throwable t) {
                throw createRuntimeExceptionInvoke(t);
            }
        }
    }

    static class JnhwMethodInvoker_Int_Adr_Adr extends JnhwMethodInvoker implements JnhwMethodHandle_Sint_PthreadT_PthreadT {

        private JnhwMethodInvoker_Int_Adr_Adr(SymbolLookup symbolLookup, String name) {
            super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS));
        }

        @Override
        public int invokeExact(Pthread.Pthread_t arg1, Pthread.Pthread_t arg2) {
            try {
                return (int) methodHandle.invokeExact(arg1.toAddressable(), arg2.toAddressable());
            } catch (Throwable t) {
                throw createRuntimeExceptionInvoke(t);
            }
        }
    }

    static JnhwMethodHandle_Sint_PthreadT_PthreadT of(String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        return of(NATIVE_LINKER.defaultLookup(), name, result, arg1, arg2);
    }

    static JnhwMethodHandle_Sint_PthreadT_PthreadT of(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        switch (result) {
            case int32_t:
                switch (arg1) {
                    case uint64_t:
                        switch (arg2) {
                            case uint64_t:
                                return new JnhwMethodInvoker_Int_Long_Long(symbolLookup, name);
                            default:
                                throw new AssertionError("arg2 unexpected data type: " + name + " " + arg2);
                        }
                    case intptr_t:
                        switch (arg2) {
                            case intptr_t:
                                return new JnhwMethodInvoker_Int_Adr_Adr(symbolLookup, name);
                            default:
                                throw new AssertionError("arg2 unexpected data type: " + name + " " + arg2);
                        }
                    default:
                        throw new AssertionError("arg1 unexpected data type: " + name + " " + arg1);
                }
            default:
                throw new AssertionError("result unexpected data type: " + name + " " + result);
        }
    }

    int invokeExact(Pthread.Pthread_t arg1, Pthread.Pthread_t arg2);

}
