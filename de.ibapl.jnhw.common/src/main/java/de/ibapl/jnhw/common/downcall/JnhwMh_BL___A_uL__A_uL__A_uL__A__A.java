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
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__I___A__I__A__I__A__I__A__A;
import de.ibapl.jnhw.common.downcall.jni.JniMi__I___A__I__A__I__A__I__A__A;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.Addressable;
import java.lang.foreign.SymbolLookup;
import java.util.NoSuchElementException;

/**
 *
 * @author aploese
 */
public interface JnhwMh_BL___A_uL__A_uL__A_uL__A__A extends JnhwMethodHandle {

    public static JnhwMh_BL___A_uL__A_uL__A_uL__A__A ofOrNull(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4, BaseDataType arg5, BaseDataType arg6, BaseDataType arg7, BaseDataType arg8) {
        try {
            return of(symbolLookup, name, result, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    public static JnhwMh_BL___A_uL__A_uL__A_uL__A__A of(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4, BaseDataType arg5, BaseDataType arg6, BaseDataType arg7, BaseDataType arg8) {
        return switch (result) {
            case int32_t ->
                switch (arg1) {
                    case intptr_t, uintptr_t ->
                        switch (arg2) {
                            case uint32_t ->
                                switch (arg3) {
                                    case intptr_t, uintptr_t ->
                                        switch (arg4) {
                                            case uint32_t ->
                                                switch (arg5) {
                                                    case intptr_t, uintptr_t ->
                                                        switch (arg6) {
                                                            case uint32_t ->
                                                                switch (arg7) {
                                                                    case intptr_t, uintptr_t ->
                                                                        switch (arg8) {
                                                                            case intptr_t, uintptr_t ->
                                                                                NativeProvider.getProvider(
                                                                                () -> new JnhwMi__I___A__I__A__I__A__I__A__A(symbolLookup, name),
                                                                                () -> new JniMi__I___A__I__A__I__A__I__A__A(symbolLookup, name));
                                                                            default ->
                                                                                throw new IllegalArgumentException("arg8 unexpected data type: " + name + " " + arg8);
                                                                        };
                                                                    default ->
                                                                        throw new IllegalArgumentException("arg7 unexpected data type: " + name + " " + arg7);
                                                                };
                                                            default ->
                                                                throw new IllegalArgumentException("arg6 unexpected data type: " + name + " " + arg6);
                                                        };
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

    default boolean invoke_BL___P_uI__P_uL__P_uL__P__P(Pointer<?> arg1, int arg2, Pointer<?> arg3, long arg4, Pointer<?> arg5, long arg6, Pointer<?> arg7, Pointer<?> arg8) {
        return invoke_BL___A_uI__A_uL__A_uL__A__A(
                arg1.toAddressable(),
                arg2,
                arg3.toAddressable(),
                arg4,
                arg5.toAddressable(),
                arg6,
                arg7.toAddressable(),
                arg8.toAddressable());
    }

    boolean invoke_BL___A_uI__A_uL__A_uL__A__A(Addressable arg1, int arg2, Addressable arg3, long arg4, Addressable arg5, long arg6, Addressable arg7, Addressable arg8);
}