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
import de.ibapl.jnhw.common.downcall.JnhwMi__V___I__I__A;
import java.lang.foreign.SymbolLookup;
import java.util.NoSuchElementException;

/**
 *
 * @author aploese
 */
public interface JnhwMh__V__sI_sI__A extends JnhwMethodHandle {

    static JnhwMh__V__sI_sI__A ofOrNull(String name, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3) {
        return ofOrNull(NATIVE_LINKER.defaultLookup(), name, arg1, arg2, arg3);
    }

    static JnhwMh__V__sI_sI__A ofOrNull(SymbolLookup symbolLookup, String name, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3) {
        try {
            return of(symbolLookup, name, arg1, arg2, arg3);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    static JnhwMh__V__sI_sI__A of(String name, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3) {
        return of(NATIVE_LINKER.defaultLookup(), name, arg1, arg2, arg3);
    }

    static JnhwMh__V__sI_sI__A of(SymbolLookup symbolLookup, String name, BaseDataType arg1, BaseDataType arg2, BaseDataType arg3) {
        switch (arg1) {
            case int32_t:
                switch (arg2) {
                    case int32_t:
                        switch (arg3) {
                            case intptr_t:
                                return new JnhwMi__V___I__I__A(symbolLookup, name);
                            default:
                                throw new IllegalArgumentException("arg3 unexpected data type: " + name + " " + arg3);
                        }
                    default:
                        throw new IllegalArgumentException("arg2 unexpected data type: " + name + " " + arg2);
                }
            default:
                throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
        }
    }

    void invoke__V__sI_sI__P(int arg1, int arg2, Pointer<?> arg3);

}
