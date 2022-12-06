/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.downcall.wrapper;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.JnhwMi_MA___A__A__L__I;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.SymbolLookup;
import java.util.NoSuchElementException;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh_MA___A__A_uL_uI extends JnhwMethodHandle {

    public static JnhwMh_MA___A__A_uL_uI ofOrNull(String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4) {
        return ofOrNull(NATIVE_LINKER.defaultLookup(), name, result, arg1, arg2, arg3, arg4);
    }

    public static JnhwMh_MA___A__A_uL_uI ofOrNull(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4) {
        try {
            return of(symbolLookup, name, result, arg1, arg2, arg3, arg4);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    public static JnhwMh_MA___A__A_uL_uI of(String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4) {
        return of(NATIVE_LINKER.defaultLookup(), name, result, arg1, arg2, arg3, arg4);
    }

    public static JnhwMh_MA___A__A_uL_uI of(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4) {
        switch (result) {
            case intptr_t, uintptr_t -> {
                switch (arg1) {
                    case intptr_t, uintptr_t -> {
                        switch (arg2) {
                            case intptr_t, uintptr_t -> {
                                switch (arg3) {
                                    case uint64_t -> {
                                        switch (arg4) {
                                            case uint32_t -> {
                                                return new JnhwMi_MA___A__A__L__I(symbolLookup, name);
                                            }
                                            default ->
                                                throw new IllegalArgumentException("arg4 unexpected data type: " + name + " " + arg4);
                                        }
                                    }
                                    default ->
                                        throw new IllegalArgumentException("arg3 unexpected data type: " + name + " " + arg3);
                                }
                            }
                            default ->
                                throw new IllegalArgumentException("arg2 unexpected data type: " + name + " " + arg2);
                        }
                    }
                    default ->
                        throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
                }
            }
            default ->
                throw new IllegalArgumentException("result unexpected data type: " + name + " " + result);
        }
    }

    MemoryAddress invoke_MA___P__P_uL_uI(Pointer<?> arg1, Pointer<?> arg2, long arg3, int arg4);

}
