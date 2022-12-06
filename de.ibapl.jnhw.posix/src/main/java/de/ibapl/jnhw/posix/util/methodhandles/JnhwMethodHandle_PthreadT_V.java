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
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMethodHandle;
import de.ibapl.jnhw.posix.Pthread;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;

/**
 *
 * @author aploese
 */
public interface JnhwMethodHandle_PthreadT_V extends JnhwMethodHandle {

    static class JnhwMethodInvoker_Long_V extends JnhwMethodInvoker implements JnhwMethodHandle_PthreadT_V {

        private JnhwMethodInvoker_Long_V(SymbolLookup symbolLookup, String name) {
            super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.JAVA_LONG));
        }

        @Override
        public Pthread.Pthread_t invokeExact(MemorySession ms) {
            try {
                return Pthread.Pthread_t.wrap(
                        (long) methodHandle.invokeExact(),
                        ms);
            } catch (Throwable t) {
                throw createRuntimeExceptionInvoke(t);
            }
        }
    }

    static class JnhwMethodInvoker_Adr_V extends JnhwMethodInvoker implements JnhwMethodHandle_PthreadT_V {

        private JnhwMethodInvoker_Adr_V(SymbolLookup symbolLookup, String name) {
            super(symbolLookup, name, FunctionDescriptor.of(ValueLayout.ADDRESS));
        }

        @Override
        public Pthread.Pthread_t invokeExact(MemorySession ms) {
            try {
                return Pthread.Pthread_t.ofAddress((MemoryAddress) methodHandle.invokeExact(), ms);
            } catch (Throwable t) {
                throw createRuntimeExceptionInvoke(t);
            }
        }
    }

    static JnhwMethodHandle_PthreadT_V of(String name, BaseDataType result) {
        return of(NATIVE_LINKER.defaultLookup(), name, result);
    }

    static JnhwMethodHandle_PthreadT_V of(SymbolLookup symbolLookup, String name, BaseDataType result) {
        switch (result) {
            case uint64_t:
                return new JnhwMethodInvoker_Long_V(symbolLookup, name);
            case intptr_t:
                return new JnhwMethodInvoker_Adr_V(symbolLookup, name);
            default:
                throw new AssertionError("result unexpected data type: " + name + " " + result);
        }
    }

    Pthread.Pthread_t invokeExact(MemorySession ms);

}
