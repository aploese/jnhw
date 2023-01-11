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
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__V___B__L;
import de.ibapl.jnhw.common.downcall.jni.JniMi__V___B__L;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.SymbolLookup;
import java.util.NoSuchElementException;

/**
 * @TODO move this to tests? its only needed there....
 * @author aploese
 */
public interface JnhwMh__V__BL_sL extends JnhwMethodHandle {

    static JnhwMh__V__BL_sL ofOrNull(SymbolLookup symbolLookup, String name, BaseDataType arg1, BaseDataType arg2) {
        try {
            return of(symbolLookup, name, arg1, arg2);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    static JnhwMh__V__BL_sL of(SymbolLookup symbolLookup, String name, BaseDataType arg1, BaseDataType arg2) {
        return switch (arg1) {
            case int8_t ->
                switch (arg2) {
                    case int64_t ->
                        NativeProvider.getProvider(
                        () -> new JnhwMi__V___B__L(symbolLookup, name),
                        () -> new JniMi__V___B__L(symbolLookup, name));
                    default ->
                        throw new IllegalArgumentException("arg2 unexpected data type: " + name + " " + arg2);
                };
            default ->
                throw new IllegalArgumentException("arg1 unexpected data type: " + name + " " + arg1);
        };
    }

    void invoke__V__BL_sL(boolean arg1, long arg2);

}
