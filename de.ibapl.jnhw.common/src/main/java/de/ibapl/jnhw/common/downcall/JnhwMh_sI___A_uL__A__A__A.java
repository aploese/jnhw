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
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__I___A__I__A__A__A;
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__I___A__L__A__A__A;
import de.ibapl.jnhw.common.downcall.jni.JniMi__I___A__I__A__A__A;
import de.ibapl.jnhw.common.downcall.jni.JniMi__I___A__L__A__A__A;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.Addressable;
import java.lang.foreign.SymbolLookup;
import java.util.NoSuchElementException;

/**
 *
 * @author aploese
 */
public interface JnhwMh_sI___A_uL__A__A__A extends JnhwMethodHandle {

    public static JnhwMh_sI___A_uL__A__A__A ofOrNull(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4, BaseDataType arg5) {
        try {
            return of(symbolLookup, name, result, arg1, arg2, arg3, arg4, arg5);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    public static JnhwMh_sI___A_uL__A__A__A of(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4, BaseDataType arg5) {
        return switch (result) {
            case int32_t ->
                switch (arg1) {
                    case intptr_t, uintptr_t ->
                        switch (arg2) {
                            case uint32_t ->
                                switch (arg3) {
                                    case intptr_t, uintptr_t ->
                                        switch (arg4) {
                                            case intptr_t, uintptr_t ->
                                                switch (arg5) {
                                                    case intptr_t, uintptr_t ->
                                                        NativeProvider.getProvider(
                                                        () -> new JnhwMi__I___A__I__A__A__A(symbolLookup, name),
                                                        () -> new JniMi__I___A__I__A__A__A(symbolLookup, name));
                                                    default ->
                                                        throw new IllegalArgumentException("arg5 unexpected data type: " + name + " " + arg5);
                                                };
                                            default ->
                                                throw new IllegalArgumentException("arg4 unexpected data type: " + name + " " + arg4);
                                        };
                                    default ->
                                        throw new IllegalArgumentException("arg3 unexpected data type: " + name + " " + arg3);
                                };
                            case uint64_t ->
                                switch (arg3) {
                                    case intptr_t, uintptr_t ->
                                        switch (arg4) {
                                            case intptr_t, uintptr_t ->
                                                switch (arg5) {
                                                    case intptr_t, uintptr_t ->
                                                        NativeProvider.getProvider(
                                                        () -> new JnhwMi__I___A__L__A__A__A(symbolLookup, name),
                                                        () -> new JniMi__I___A__L__A__A__A(symbolLookup, name));
                                                    default ->
                                                        throw new IllegalArgumentException("arg5 unexpected data type: " + name + " " + arg5);
                                                };
                                            default ->
                                                throw new IllegalArgumentException("arg4 unexpected data type: " + name + " " + arg4);
                                        };
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

    default int invoke_sI___P_uL_P__P__P(Pointer<?> arg1, long arg2, Pointer<?> arg3, Pointer<?> arg4, Pointer<?> arg5) {
        return invoke_sI___A_uL__A__A__A(arg1.toAddressable(), arg2, arg3.toAddressable(), arg4.toAddressable(), arg5.toAddressable());
    }

    default int invoke_sI___A_uL_A__P__P(Addressable arg1, long arg2, Addressable arg3, Pointer<?> arg4, Pointer<?> arg5) {
        return invoke_sI___A_uL__A__A__A(arg1, arg2, arg3, arg4.toAddressable(), arg5.toAddressable());
    }

    int invoke_sI___A_uL__A__A__A(Addressable arg1, long arg2, Addressable arg3, Addressable arg4, Addressable arg5);
}
