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
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi_MA___I;
import de.ibapl.jnhw.common.downcall.jni.JniMi_MA___I;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh_MA__uI extends JnhwMethodHandle {

    @FunctionalInterface
    interface ExceptionErased extends JnhwMh_MA__uI {

        @Override
        MemorySegment invoke_MA__uI(int arg1);
    }

    static JnhwMh_MA__uI.ExceptionErased mandatoryOf(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, long targetByteSize) {
        return Util.buidExistingMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result, arg1, targetByteSize));
    }

    static JnhwMh_MA__uI optionalOf(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, long targetByteSize) {
        return Util.buidOptionalMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result, arg1, targetByteSize),
                () -> (JnhwMh_MA__uI) (cArg1) -> {
                    throw new NoSuchNativeMethodException(name);
                });
    }

    static JnhwMh_MA__uI.ExceptionErased of(MemorySegment memoryAddress, String name, BaseDataType result, BaseDataType arg1, long targetByteSize) {
        return switch (result) {
            case intptr_t, uintptr_t ->
                switch (arg1) {
                    case uint32_t ->
                        NativeProvider.getProvider(
                        () -> new JnhwMi_MA___I(memoryAddress, name, targetByteSize),
                        () -> new JniMi_MA___I(memoryAddress, name, targetByteSize));
                    default ->
                        throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
                };
            default ->
                throw new IllegalArgumentException("result unexpected data type: " + name + " " + result);
        };
    }

    MemorySegment invoke_MA__uI(int arg1) throws NoSuchNativeMethodException;

}
