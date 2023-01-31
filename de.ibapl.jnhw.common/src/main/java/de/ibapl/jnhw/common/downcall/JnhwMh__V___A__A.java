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
import static de.ibapl.jnhw.common.datatypes.BaseDataType.uintptr_t;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__V___A__A;
import de.ibapl.jnhw.common.downcall.jni.JniMi__V___A__A;
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
public interface JnhwMh__V___A__A extends JnhwMethodHandle {

    @FunctionalInterface
    interface ExceptionErased extends JnhwMh__V___A__A {

        @Override
        default void invoke__V___P__P(Pointer arg1, Pointer arg2) {
            invoke__V___A__A(arg1.toAddressable(), arg2.toAddressable());
        }

        @Override
        default void invoke__V___P__A(Pointer arg1, Addressable arg2) {
            invoke__V___A__A(arg1.toAddressable(), arg2);
        }

        @Override
        void invoke__V___A__A(Addressable arg1, Addressable arg2);
    }

    static JnhwMh__V___A__A.ExceptionErased mandatoryOf(SymbolLookup symbolLookup, String name, BaseDataType arg1, BaseDataType arg2) {
        return Util.buidExistingMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, arg1, arg2));
    }

    static JnhwMh__V___A__A optionalOf(SymbolLookup symbolLookup, String name, BaseDataType arg1, BaseDataType arg2) {
        return Util.buidOptionalMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, arg1, arg2),
                () -> (JnhwMh__V___A__A) (cArg1, cArg2) -> {
                    throw new NoSuchNativeMethodException(name);
                });
    }

    static JnhwMh__V___A__A.ExceptionErased of(MemorySegment methodAddress, String name, BaseDataType arg1, BaseDataType arg2) {
        return switch (arg1) {
            case intptr_t, uintptr_t ->
                switch (arg2) {
                    case intptr_t, uintptr_t ->
                        NativeProvider.getProvider(
                        () -> new JnhwMi__V___A__A(methodAddress, name),
                        () -> new JniMi__V___A__A(methodAddress, name));
                    default ->
                        throw new IllegalArgumentException("arg2 unexpected data type: " + name + " " + arg2);
                };
            default ->
                throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
        };
    }

    default void invoke__V___P__P(Pointer arg1, Pointer arg2) throws NoSuchNativeMethodException {
        invoke__V___A__A(arg1.toAddressable(), arg2.toAddressable());
    }

    default void invoke__V___P__A(Pointer arg1, Addressable arg2) throws NoSuchNativeMethodException {
        invoke__V___A__A(arg1.toAddressable(), arg2);
    }

    void invoke__V___A__A(Addressable arg1, Addressable arg2) throws NoSuchNativeMethodException;
}
