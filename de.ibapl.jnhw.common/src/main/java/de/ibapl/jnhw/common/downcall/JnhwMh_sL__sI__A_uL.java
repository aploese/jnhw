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
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__I___I__A__I;
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__L___I__A__L;
import de.ibapl.jnhw.common.downcall.jni.JniMi__I___I__A__I;
import de.ibapl.jnhw.common.downcall.jni.JniMi__L___I__A__L;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh_sL__sI__A_uL extends JnhwMethodHandle {

    @FunctionalInterface
    interface ExceptionErased extends JnhwMh_sL__sI__A_uL {

        @Override
        default long invoke_sL__sI__P_uL(int arg1, Pointer arg2, long arg3) {
            return invoke_sL__sI__A_uL(arg1, arg2.toMemorySegment(), arg3);
        }

        @Override
        long invoke_sL__sI__A_uL(int arg1, MemorySegment arg2, long arg3);
    }

    static JnhwMh_sL__sI__A_uL.ExceptionErased mandatoryOf(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3) {
        return Util.buidExistingMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result, arg1, arg2, arg3));
    }

    static JnhwMh_sL__sI__A_uL optionalOf(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3) {
        return Util.buidOptionalMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result, arg1, arg2, arg3),
                () -> (JnhwMh_sL__sI__A_uL) (cArg1, cArg2, cArg3) -> {
                    throw new NoSuchNativeMethodException(name);
                });
    }

    public static JnhwMh_sL__sI__A_uL.ExceptionErased of(MemorySegment methodAddress, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3) {
        return switch (result) {
            case int32_t ->
                switch (arg1) {
                    case int32_t ->
                        switch (arg2) {
                            case intptr_t, uintptr_t ->
                                switch (arg3) {
                                    case uint32_t ->
                                        NativeProvider.getProvider(
                                        () -> new JnhwMi__I___I__A__I(methodAddress, name),
                                        () -> new JniMi__I___I__A__I(methodAddress, name));
                                    default ->
                                        throw new IllegalArgumentException("arg3 unexpected data type: " + name + " " + arg3);
                                };
                            default ->
                                throw new IllegalArgumentException("arg2 unexpected data type: " + name + " " + arg2);
                        };
                    default ->
                        throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
                };
            case int64_t ->
                switch (arg1) {
                    case int32_t ->
                        switch (arg2) {
                            case intptr_t, uintptr_t ->
                                switch (arg3) {
                                    case uint64_t ->
                                        NativeProvider.getProvider(
                                        () -> new JnhwMi__L___I__A__L(methodAddress, name),
                                        () -> new JniMi__L___I__A__L(methodAddress, name));
                                    default ->
                                        throw new IllegalArgumentException("arg3 unexpected data type: " + name + " " + arg3);
                                };
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

    default long invoke_sL__sI__P_uL(int arg1, Pointer arg2, long arg3) throws NoSuchNativeMethodException {
        return invoke_sL__sI__A_uL(arg1, arg2.toMemorySegment(), arg3);
    }

    long invoke_sL__sI__A_uL(int arg1, MemorySegment arg2, long arg3) throws NoSuchNativeMethodException;
}
