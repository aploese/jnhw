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
package de.ibapl.jnhw.common.downcall;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__V___A;
import de.ibapl.jnhw.common.downcall.jni.JniMi__V___A;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.Addressable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh__V___A extends JnhwMethodHandle {

    @FunctionalInterface
    interface ExceptionErased extends JnhwMh__V___A {

        @Override
        default void invoke__V___P(Pointer arg1) {
            invoke__V___A(arg1.toAddressable());
        }

        @Override
        void invoke__V___A(Addressable arg1);
    }

    static JnhwMh__V___A.ExceptionErased mandatoryOf(SymbolLookup symbolLookup, String name, BaseDataType arg1) {
        return Util.buidExistingMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, arg1));
    }

    static JnhwMh__V___A optionalOf(SymbolLookup symbolLookup, String name, BaseDataType arg1) {
        return Util.buidOptionalMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, arg1),
                () -> (JnhwMh__V___A) (cArg1) -> {
                    throw new NoSuchNativeMethodException(name);
                });
    }

    static JnhwMh__V___A.ExceptionErased of(MemorySegment methodAddress, String name, BaseDataType arg1) {
        return switch (arg1) {
            case intptr_t, uintptr_t ->
                NativeProvider.getProvider(
                () -> new JnhwMi__V___A(methodAddress, name),
                () -> new JniMi__V___A(methodAddress, name));
            default ->
                throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
        };
    }

    default void invoke__V___P(Pointer arg1) throws NoSuchNativeMethodException {
        invoke__V___A(arg1.toAddressable());
    }

    void invoke__V___A(Addressable arg1) throws NoSuchNativeMethodException;
}
