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
package de.ibapl.jnhw.common.downcall;

import java.lang.invoke.MethodHandle;
import java.util.NoSuchElementException;
import java.util.Optional;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.NativeSymbol;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SymbolLookup;

/**
 *
 * @author aploese
 */
public abstract class JnhwMethodInvoker {

    public final static CLinker C_LINKER = CLinker.systemCLinker();

    protected final MethodHandle methodHandle;
    private final NativeSymbol ns;
    private final String name;

    public JnhwMethodInvoker(SymbolLookup symbolLookup, String name, FunctionDescriptor fd) {
        this.name = name;
        final Optional<NativeSymbol> ons = symbolLookup.lookup(name);
        if (ons.isEmpty()) {
            throw new NoSuchElementException("Native symbol: \"" + name + "\" not found!");
        }
        ns = ons.get();
        methodHandle = C_LINKER.downcallHandle(ns, fd);
    }

    public JnhwMethodInvoker(Addressable srcm, FunctionDescriptor fd, ResourceScope scope) {
        this.name = String.format("%s@0x%08x", getClass().getSimpleName(), srcm.address().toRawLongValue());
        ns = NativeSymbol.ofAddress(name, srcm.address(), scope);
        methodHandle = C_LINKER.downcallHandle(ns, fd);
    }

    protected RuntimeException createRuntimeExceptionInvoke(Throwable t) {
        throw new RuntimeException("Native call to: \"" + name + "=>" + methodHandle.toString() + "\" failed!", t);
    }

}
