/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2022-2024, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.util.JnhwFormater;
import java.lang.foreign.MemorySegment;
import java.util.Objects;

/**
 *
 * The base class for any pointer like win api HANDLE.
 *
 * @author aploese
 */
public abstract class OpaquePointer implements Pointer {

    protected final MemorySegment nativeValue;

    public OpaquePointer(MemorySegment address) {
        nativeValue = address;
    }

    @Override
    final public MemorySegment toMemorySegment() {
        return nativeValue;
    }

    @Override
    final public long toAddress() {
        return nativeValue.address();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (obj instanceof OpaquePointer other) {
            return this.nativeValue.address() == other.nativeValue.address();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nativeValue);
        return hash;
    }

    @Override
    public String toString() {
        return "{nativeValue : " + JnhwFormater.formatAddress(nativeValue) + "}";
    }

    @Override
    public boolean is_NULL() {
        return nativeValue.address() == 0L;
    }

    @Override
    public boolean is_Not_NULL() {
        return nativeValue.address() != 0L;
    }

}
