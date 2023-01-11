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
import de.ibapl.jnhw.common.downcall.JnhwMethodHandle;
import de.ibapl.jnhw.common.util.NativeProvider;
import de.ibapl.jnhw.posix.Pthread;
import de.ibapl.jnhw.util.posix.downcall.foreign.JnhwMi__I__PthreadTA;
import de.ibapl.jnhw.util.posix.downcall.foreign.JnhwMi__I__PthreadTI;
import de.ibapl.jnhw.util.posix.downcall.foreign.JnhwMi__I__PthreadTL;
import de.ibapl.jnhw.util.posix.downcall.jni.JniMi__I__PthreadTA;
import de.ibapl.jnhw.util.posix.downcall.jni.JniMi__I__PthreadTI;
import de.ibapl.jnhw.util.posix.downcall.jni.JniMi__I__PthreadTL;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
public interface JnhwMh_sI__PthreadT extends JnhwMethodHandle {

    static JnhwMh_sI__PthreadT of(SymbolLookup symbolLookup, String name, BaseDataType result, BaseDataType arg1) {
        return switch (result) {
            case int32_t ->
                switch (arg1) {
                    case uint32_t ->
                        NativeProvider.getProvider(
                        () -> new JnhwMi__I__PthreadTI(symbolLookup, name),
                        () -> new JniMi__I__PthreadTI(symbolLookup, name));
                    case uint64_t ->
                        NativeProvider.getProvider(
                        () -> new JnhwMi__I__PthreadTL(symbolLookup, name),
                        () -> new JniMi__I__PthreadTL(symbolLookup, name));
                    case uintptr_t, intptr_t ->
                        NativeProvider.getProvider(
                        () -> new JnhwMi__I__PthreadTA(symbolLookup, name),
                        () -> new JniMi__I__PthreadTA(symbolLookup, name));
                    default ->
                        throw new AssertionError("arg1 unexpected data type: " + name + " " + arg1);
                };
            default ->
                throw new AssertionError("result unexpected data type: " + name + " " + result);
        };
    }

    int invoke_sI__PthreadT(Pthread.Pthread_t arg1);

}
