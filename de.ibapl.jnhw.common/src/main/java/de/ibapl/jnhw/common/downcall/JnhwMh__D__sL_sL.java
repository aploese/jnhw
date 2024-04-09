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
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__D___I__I;
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__D___L__L;
import de.ibapl.jnhw.common.downcall.jni.JniMi__D___I__I;
import de.ibapl.jnhw.common.downcall.jni.JniMi__D___L__L;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh__D__sL_sL extends JnhwMethodHandle {

    @FunctionalInterface
    interface ExceptionErased extends JnhwMh__D__sL_sL {

        @Override
        double invoke__D__sL_sL(long arg1, long arg2);
    }

    static JnhwMh__D__sL_sL.ExceptionErased mandatoryOf(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        return Util.buidExistingMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result, arg1, arg2));
    }

    static JnhwMh__D__sL_sL optionalOf(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        return Util.buidOptionalMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result, arg1, arg2),
                () -> (JnhwMh__D__sL_sL) (cArg1, cArg2) -> {
                    throw new NoSuchNativeMethodException(name);
                });
    }

    public static JnhwMh__D__sL_sL.ExceptionErased of(MemorySegment methodAddress, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        return switch (result) {
            case _double ->
                switch (arg1) {
                    case int32_t ->
                        switch (arg2) {
                            case int32_t ->
                                NativeProvider.getProvider(
                                () -> new JnhwMi__D___I__I(methodAddress, name),
                                () -> new JniMi__D___I__I(methodAddress, name));
                            default ->
                                throw new IllegalArgumentException("arg2 unexpected data type: " + name + " " + arg2);
                        };
                    case int64_t ->
                        switch (arg2) {
                            case int64_t ->
                                NativeProvider.getProvider(
                                () -> new JnhwMi__D___L__L(methodAddress, name),
                                () -> new JniMi__D___L__L(methodAddress, name));
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

    double invoke__D__sL_sL(long arg1, long arg2) throws NoSuchNativeMethodException;
}
