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
import static de.ibapl.jnhw.common.datatypes.BaseDataType.uintptr_t;
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi_MA___V;
import de.ibapl.jnhw.common.downcall.jni.JniMi_MA___V;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh_MA___V extends JnhwMethodHandle {

    @FunctionalInterface
    interface ExceptionErased extends JnhwMh_MA___V {

        @Override
        MemorySegment invoke_MA___V();
    }

    static JnhwMh_MA___V.ExceptionErased mandatoryOf(SymbolLookup symbolLookup, String name, BaseDataType result, long resultTargetSize) {
        return Util.buidExistingMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result, resultTargetSize));
    }

    static JnhwMh_MA___V optionalOf(SymbolLookup symbolLookup, String name, BaseDataType result, long resultTargetSize) {
        return Util.buidOptionalMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result, resultTargetSize),
                () -> (JnhwMh_MA___V) () -> {
                    throw new NoSuchNativeMethodException(name);
                });
    }

    public static JnhwMh_MA___V.ExceptionErased of(MemorySegment methodAddress, String name, BaseDataType result, long resultTargetSize) {
        return switch (result) {
            case intptr_t, uintptr_t ->
                NativeProvider.getProvider(
                () -> new JnhwMi_MA___V(methodAddress, name, resultTargetSize),
                () -> new JniMi_MA___V(methodAddress, name, resultTargetSize));
            default ->
                throw new IllegalArgumentException("result unexpected data type: " + name + " " + result);
        };
    }

    MemorySegment invoke_MA___V() throws NoSuchNativeMethodException;

}
