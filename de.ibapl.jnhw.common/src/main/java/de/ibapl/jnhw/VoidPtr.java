/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw;

import java.util.function.ToLongFunction;

/**
 *
 * @author aploese
 */
public class NativePointer {

    public static NativePointer wrap(long nativeAddress) {
        return new NativePointer(nativeAddress);
    }

    private final long nativeAddress;

    protected <T extends NativePointer> NativePointer(ToLongFunction<T> producer) {
        this.nativeAddress = producer.applyAsLong((T) this);
    }

    protected NativePointer(long nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

    /**
     * cast to simple pointer...
     *
     * @param src
     */
    protected NativePointer(NativePointer src) {
        this.nativeAddress = src.nativeAddress;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.nativeAddress ^ (this.nativeAddress >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NativePointer)) {
            return false;
        }
        final NativePointer other = (NativePointer) obj;
        return this.nativeAddress == other.nativeAddress;
    }

    @Override
    public String toString() {
        return String.format("{nativeAddress : 0x%08x}", nativeAddress);
    }

}
