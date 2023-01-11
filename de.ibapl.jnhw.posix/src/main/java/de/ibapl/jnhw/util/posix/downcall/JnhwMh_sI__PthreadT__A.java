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
package de.ibapl.jnhw.util.posix.downcall;

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.downcall.JnhwMethodHandle;
import de.ibapl.jnhw.common.util.NativeProvider;
import de.ibapl.jnhw.posix.Pthread;
import de.ibapl.jnhw.util.posix.downcall.foreign.JnhwMi__I__PthreadTA__A;
import de.ibapl.jnhw.util.posix.downcall.foreign.JnhwMi__I__PthreadTI__A;
import de.ibapl.jnhw.util.posix.downcall.foreign.JnhwMi__I__PthreadTL__A;
import de.ibapl.jnhw.util.posix.downcall.jni.JniMi__I__PthreadTA__A;
import de.ibapl.jnhw.util.posix.downcall.jni.JniMi__I__PthreadTI__A;
import de.ibapl.jnhw.util.posix.downcall.jni.JniMi__I__PthreadTL__A;
import java.lang.foreign.Addressable;
import java.lang.foreign.SymbolLookup;
import java.util.NoSuchElementException;

/**
 *
 * @author aploese
 */
public interface JnhwMh_sI__PthreadT__A extends JnhwMethodHandle {

    public static JnhwMh_sI__PthreadT__A ofOrNull(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        try {
            return of(symbolLookup, name, result, arg1, arg2);
        } catch (NoSuchElementException elementException) {
            return null;
        }
    }

    static JnhwMh_sI__PthreadT__A of(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1, BaseDataType arg2) {
        return switch (result) {
            case int32_t ->
                switch (arg1) {
                    case uint32_t ->
                        switch (arg2) {
                            case uintptr_t, intptr_t ->
                                NativeProvider.getProvider(
                                () -> new JnhwMi__I__PthreadTI__A(symbolLookup, name),
                                () -> new JniMi__I__PthreadTI__A(symbolLookup, name));
                            default ->
                                throw new AssertionError("arg2 unexpected data type: " + name + " " + arg2);
                        };
                    case uint64_t ->
                        switch (arg2) {
                            case uintptr_t, intptr_t ->
                                NativeProvider.getProvider(
                                () -> new JnhwMi__I__PthreadTL__A(symbolLookup, name),
                                () -> new JniMi__I__PthreadTL__A(symbolLookup, name));
                            default ->
                                throw new AssertionError("arg2 unexpected data type: " + name + " " + arg2);
                        };
                    case uintptr_t, intptr_t ->
                        switch (arg2) {
                            case uintptr_t, intptr_t ->
                                NativeProvider.getProvider(
                                () -> new JnhwMi__I__PthreadTA__A(symbolLookup, name),
                                () -> new JniMi__I__PthreadTA__A(symbolLookup, name));
                            default ->
                                throw new AssertionError("arg2 unexpected data type: " + name + " " + arg2);
                        };
                    default ->
                        throw new AssertionError("arg1 unexpected data type: " + name + " " + arg1);
                };
            default ->
                throw new AssertionError("result unexpected data type: " + name + " " + result);
        };
    }

    default int invoke_sI__PthreadT__P(Pthread.Pthread_t arg1, Pointer<?> arg2) {
        return invoke_sI__PthreadT__A(arg1, arg2.toAddressable());
    }

    int invoke_sI__PthreadT__A(Pthread.Pthread_t arg1, Addressable arg2);
}