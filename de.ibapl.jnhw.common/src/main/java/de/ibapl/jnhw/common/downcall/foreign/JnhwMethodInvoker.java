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
package de.ibapl.jnhw.common.downcall.foreign;

import java.lang.foreign.Addressable;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

import java.lang.invoke.MethodHandle;
import java.util.Objects;

/**
 *
 * @author aploese
 */
public abstract class JnhwMethodInvoker {

    public final static Linker NATIVE_LINKER = Linker.nativeLinker();

    protected final MethodHandle methodHandle;
    private final MemorySegment methodAddress;
    private final String name;

    public JnhwMethodInvoker(MemorySegment methodAddress, String name, FunctionDescriptor fd) {
        if (methodAddress == null) {
            throw new IllegalArgumentException("methodAddress of: \"" + name + "\" is null!");
        }
        this.name = name;
        this.methodAddress = methodAddress;
        methodHandle = NATIVE_LINKER.downcallHandle(methodAddress, fd);
    }

    protected RuntimeException createRuntimeExceptionInvoke(Throwable t) {
        throw new RuntimeException("Native call to: \"" + name + "=>" + methodHandle.toString() + "\" failed!", t);
    }

    @Override
    public String toString() {
        return "{name=\"" + name + "\"" + " ns: " + methodAddress + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.methodAddress);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof JnhwMethodInvoker that
                && Objects.equals(methodAddress, that.methodAddress);
    }

}
