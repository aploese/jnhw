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
import de.ibapl.jnhw.common.downcall.JnhwMi__I___A;
import de.ibapl.jnhw.common.downcall.JnhwMi__L___A;
import java.util.NoSuchElementException;
import jdk.incubator.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh_uL___A extends JnhwMethodHandle {

    public static JnhwMh_uL___A ofOrNull(String name, BaseDataType result, BaseDataType arg1) {
        return ofOrNull(C_LINKER, name, result, arg1);
    }

    public static JnhwMh_uL___A ofOrNull(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1) {
        try {
            return of(symbolLookup, name, result, arg1);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    public static JnhwMh_uL___A of(String name, BaseDataType result, BaseDataType arg1) {
        return of(C_LINKER, name, result, arg1);
    }

    public static JnhwMh_uL___A of(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1) {
        switch (result) {
            case uint64_t:
                switch (arg1) {
                    case intptr_t:
                        return new JnhwMi__L___A(symbolLookup, name);
                    default:
                        throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
                }
            case uint32_t:
                switch (arg1) {
                    case intptr_t:
                        return new JnhwMi__I___A(symbolLookup, name);
                    default:
                        throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
                }
            default:
                throw new IllegalArgumentException("result unexpected data type: " + name + " " + result);
        }
    }

    long invoke_uL___P(Pointer<?> arg1);

}
