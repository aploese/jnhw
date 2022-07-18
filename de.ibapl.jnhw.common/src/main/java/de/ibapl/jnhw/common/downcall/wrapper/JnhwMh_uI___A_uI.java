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
import de.ibapl.jnhw.common.downcall.JnhwMi__I___A__I;
import java.util.NoSuchElementException;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
public interface JnhwMh_uI___A_uI extends JnhwMethodHandle {

    public static JnhwMh_uI___A_uI ofOrNull(String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        return ofOrNull(C_LINKER, name, result, arg1, arg2);
    }

    public static JnhwMh_uI___A_uI ofOrNull(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        try {
            return of(symbolLookup, name, result, arg1, arg2);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    public static JnhwMh_uI___A_uI of(String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        return of(C_LINKER, name, result, arg1, arg2);
    }

    public static JnhwMh_uI___A_uI of(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        switch (result) {
            case int32_t:
                switch (arg1) {
                    case intptr_t:
                        switch (arg2) {
                            case uint32_t:
                                return new JnhwMi__I___A__I(symbolLookup, name);
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

    int invoke_uI__P_uI(Pointer<?> arg1, int arg2);

    int invoke_uI__P_uL(Pointer<?> arg1, long arg2);

    int invoke_uI__A_uI(Addressable arg1, int arg2);

}
