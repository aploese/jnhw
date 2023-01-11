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

import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__V___V;
import de.ibapl.jnhw.common.downcall.jni.JniMi__V___V;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.SymbolLookup;
import java.util.NoSuchElementException;

/**
 *
 * @author aploese
 */
public interface JnhwMh__V___V extends JnhwMethodHandle {

    public static JnhwMh__V___V ofOrNull(SymbolLookup symbolLookup, String name) {
        try {
            return of(symbolLookup, name);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    public static JnhwMh__V___V of(SymbolLookup symbolLookup, String name) {
        return NativeProvider.getProvider(
                () -> new JnhwMi__V___V(symbolLookup, name),
                () -> new JniMi__V___V(symbolLookup, name));
    }

    void invoke__V___V();

}
