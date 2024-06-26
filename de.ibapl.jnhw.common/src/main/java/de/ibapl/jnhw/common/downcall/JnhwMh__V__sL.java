/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2023-2024, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__V___L;
import de.ibapl.jnhw.common.downcall.jni.JniMi__V___L;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh__V__sL extends JnhwMethodHandle {

    @FunctionalInterface
    interface ExceptionErased extends JnhwMh__V__sL {

        @Override
        void invoke__V__sL(long arg1);
    }

    static JnhwMh__V__sL.ExceptionErased mandatoryOf(SymbolLookup symbolLookup, String name, BaseDataType arg1) {
        return Util.buidExistingMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, arg1));
    }

    static JnhwMh__V__sL optionalOf(SymbolLookup symbolLookup, String name, BaseDataType arg1) {
        return Util.buidOptionalMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, arg1),
                () -> (JnhwMh__V__sL) (cArg1) -> {
                    throw new NoSuchNativeMethodException(name);
                });
    }

    static JnhwMh__V__sL.ExceptionErased of(MemorySegment methodAddress, String name, BaseDataType arg1) {
        return switch (arg1) {
            case int64_t ->
                NativeProvider.getProvider(
                () -> new JnhwMi__V___L(methodAddress, name),
                () -> new JniMi__V___L(methodAddress, name));

            default ->
                throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
        };
    }

    void invoke__V__sL(long arg1) throws NoSuchNativeMethodException;
}
