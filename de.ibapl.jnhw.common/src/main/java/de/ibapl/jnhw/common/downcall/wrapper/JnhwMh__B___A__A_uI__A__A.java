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

import de.ibapl.jnhw.common.downcall.JnhwMi__I___A__A__I__A__A;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.Pointer;
import java.util.NoSuchElementException;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
public interface JnhwMh__B___A__A_uI__A__A extends JnhwMethodHandle {

    public static JnhwMh__B___A__A_uI__A__A ofOrNull(String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4, BaseDataType arg5) {
        return ofOrNull(C_LINKER, name, result, arg1, arg2, arg3, arg4, arg5);
    }

    public static JnhwMh__B___A__A_uI__A__A ofOrNull(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4, BaseDataType arg5) {
        try {
            return of(symbolLookup, name, result, arg1, arg2, arg3, arg4, arg5);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    public static JnhwMh__B___A__A_uI__A__A of(String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4, BaseDataType arg5) {
        return of(C_LINKER, name, result, arg1, arg2, arg3, arg4, arg5);
    }

    public static JnhwMh__B___A__A_uI__A__A of(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3, BaseDataType arg4, BaseDataType arg5) {
        switch (result) {
            case int32_t:
                switch (arg1) {
                    case intptr_t:
                        switch (arg2) {
                            case intptr_t:
                                switch (arg3) {
                                    case uint32_t:
                                        switch (arg4) {
                                            case intptr_t:
                                                switch (arg5) {
                                                    case intptr_t:
                                                        return new JnhwMi__I___A__A__I__A__A(symbolLookup, name);
                                                    default:
                                                        throw new IllegalArgumentException("arg5 unexpected data type: " + name + " " + arg5);
                                                }
                                            default:
                                                throw new IllegalArgumentException("arg4 unexpected data type: " + name + " " + arg4);
                                        }
                                    default:
                                        throw new IllegalArgumentException("arg3 unexpected data type: " + name + " " + arg3);
                                }
                            default:
                                throw new IllegalArgumentException("arg2 unexpected data type: " + name + " " + arg2);
                        }
                    default:
                        throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
                }
            default:
                throw new IllegalArgumentException("result unexpected data type: " + name + " " + result);
        }
    }

    boolean invoke__B___P__A_uI__P__P(Pointer<?> arg1, Addressable arg2, int arg3, Pointer<?> arg4, Pointer<?> arg5);

    boolean invoke__B___P__P_uI__P__P(Pointer<?> arg1, Pointer<?> arg2, int arg3, Pointer<?> arg4, Pointer<?> arg5);
}
