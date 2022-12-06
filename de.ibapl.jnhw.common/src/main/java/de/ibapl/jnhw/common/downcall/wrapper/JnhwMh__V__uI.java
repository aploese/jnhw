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
import de.ibapl.jnhw.common.downcall.JnhwMi__V___I;
import java.lang.foreign.SymbolLookup;
import java.util.NoSuchElementException;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh__V__uI extends JnhwMethodHandle {

    static JnhwMh__V__uI ofOrNull(String name, BaseDataType arg1) {
        return ofOrNull(NATIVE_LINKER.defaultLookup(), name, arg1);
    }

    static JnhwMh__V__uI ofOrNull(SymbolLookup symbolLookup, String name, BaseDataType arg1) {
        try {
            return of(symbolLookup, name, arg1);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    static JnhwMh__V__uI of(String name, BaseDataType arg1) {
        return of(NATIVE_LINKER.defaultLookup(), name, arg1);
    }

    static JnhwMh__V__uI of(SymbolLookup symbolLookup, String name, BaseDataType arg1) {
        switch (arg1) {
            case uint32_t:
                return new JnhwMi__V___I(symbolLookup, name);
            default:
                throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
        }
    }

    void invoke__V__uI(int arg1);

}
