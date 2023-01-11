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
import de.ibapl.jnhw.util.posix.downcall.foreign.JnhwMi_PthreadTI___V;
import de.ibapl.jnhw.util.posix.downcall.foreign.JnhwMi_PthreadTL___V;
import de.ibapl.jnhw.util.posix.downcall.foreign.JnhwMi_PthreadTMA___V;
import de.ibapl.jnhw.util.posix.downcall.jni.JniMi_PthreadTI___V;
import de.ibapl.jnhw.util.posix.downcall.jni.JniMi_PthreadTL___V;
import de.ibapl.jnhw.util.posix.downcall.jni.JniMi_PthreadTMA___V;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
public interface JnhwMh_PthreadT___V extends JnhwMethodHandle {

    static JnhwMh_PthreadT___V of(SymbolLookup symbolLookup, String name, BaseDataType result) {
        return switch (result) {
            case uint32_t ->
                NativeProvider.getProvider(
                () -> new JnhwMi_PthreadTI___V(symbolLookup, name),
                () -> new JniMi_PthreadTI___V(symbolLookup, name));
            case uint64_t ->
                NativeProvider.getProvider(
                () -> new JnhwMi_PthreadTL___V(symbolLookup, name),
                () -> new JniMi_PthreadTL___V(symbolLookup, name));
            case uintptr_t, intptr_t ->
                NativeProvider.getProvider(
                () -> new JnhwMi_PthreadTMA___V(symbolLookup, name),
                () -> new JniMi_PthreadTMA___V(symbolLookup, name));
            default ->
                throw new AssertionError("result unexpected data type: " + name + " " + result);
        };
    }

    Pthread.Pthread_t invoke_PthreadT___V(MemorySession ms);

}
