/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2023-2024, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__I___V;
import de.ibapl.jnhw.common.downcall.foreign.JnhwMi__L___V;
import de.ibapl.jnhw.common.downcall.jni.JniMi__I___V;
import de.ibapl.jnhw.common.downcall.jni.JniMi__L___V;
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.NativeProvider;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * @author aploese
 */
@FunctionalInterface
public interface JnhwMh_sL___V extends JnhwMethodHandle {

    @FunctionalInterface
    interface ExceptionErased extends JnhwMh_sL___V {

        @Override
        long invoke_sL___V();
    }

    static JnhwMh_sL___V.ExceptionErased mandatoryOf(SymbolLookup symbolLookup, String name, BaseDataType result) {
        return Util.buidExistingMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result));
    }

    static JnhwMh_sL___V optionalOf(SymbolLookup symbolLookup, String name, BaseDataType result) {
        return Util.buidOptionalMethod(symbolLookup,
                name,
                (oms) -> of(oms, name, result),
                () -> (JnhwMh_sL___V) () -> {
                    throw new NoSuchNativeMethodException(name);
                });
    }

    static JnhwMh_sL___V.ExceptionErased of(MemorySegment methodAddress, String name, BaseDataType result) {
        return switch (result) {
            case int32_t ->
                NativeProvider.getProvider(
                () -> new JnhwMi__I___V(methodAddress, name),
                () -> new JniMi__I___V(methodAddress, name));
            case int64_t ->
                NativeProvider.getProvider(
                () -> new JnhwMi__L___V(methodAddress, name),
                () -> new JniMi__L___V(methodAddress, name));
            default ->
                throw new IllegalArgumentException("result unexpected data type: " + name + " " + name + " " + result);
        };
    }

    long invoke_sL___V() throws NoSuchNativeMethodException;

}
