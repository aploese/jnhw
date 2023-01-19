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
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__I___I__I;
import de.ibapl.jnhw.common.downcall.jni.JniMi__I___I__I;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh_uL__uI_BL extends JnhwMethodHandle {

    @FunctionalInterface
    interface ExceptionErased extends JnhwMh_uL__uI_BL {

        @Override
        long invoke_uL__uI_BL(int arg1, boolean arg2);
    }

    static JnhwMh_uL__uI_BL.ExceptionErased mandatoryOf(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        return Util.buidExistingMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result, arg1, arg2));
    }

    static JnhwMh_uL__uI_BL optionalOf(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        return Util.buidOptionalMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result, arg1, arg2),
                () -> (JnhwMh_uL__uI_BL) (cArg1, cArg2) -> {
                    throw new NoSuchNativeMethodException(name);
                });
    }

    public static JnhwMh_uL__uI_BL.ExceptionErased of(MemorySegment methodAddress, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        return switch (result) {
            case uint32_t ->
                switch (arg1) {
                    case uint32_t ->
                        switch (arg2) {
                            case int32_t ->
                                NativeProvider.getProvider(
                                () -> new JnhwMi__I___I__I(methodAddress, name),
                                () -> new JniMi__I___I__I(methodAddress, name));
                            default ->
                                throw new IllegalArgumentException("arg2 unexpected data type: " + name + " " + arg2);
                        };
                    default ->
                        throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
                };
            default ->
                throw new IllegalArgumentException("result unexpected data type: " + name + " " + result);
        };
    }

    long invoke_uL__uI_BL(int arg1, boolean arg2) throws NoSuchNativeMethodException;
}