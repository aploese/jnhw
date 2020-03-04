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

import java.util.function.Function;

/**
 *
 * @author aploese
 */
public class NativeFunctionPointer {

    public static boolean isSameAddress(long baseAddress, NativeFunctionPointer nativeFunctionPointer) {
        return nativeFunctionPointer.nativeAddress == baseAddress;
    }

    public static NativeAddressHolder toNativeAddressHolder(NativeFunctionPointer nativeFunctionPointer) {
        return new NativeAddressHolder(nativeFunctionPointer.nativeAddress);
    }

    public static NativeFunctionPointer wrap(NativeFunctionPointer nativeFunctionPointer) {
        return new NativeFunctionPointer(nativeFunctionPointer.nativeAddress);
    }

    public static NativeFunctionPointer wrap(NativeAddressHolder nativePointer) {
        return new NativeFunctionPointer(nativePointer.address);
    }

    public <T extends NativeFunctionPointer> NativeFunctionPointer(Function<T, NativeAddressHolder> producer) {
        this.nativeAddress = producer.apply((T) this).address;
    }

    protected NativeFunctionPointer(NativeAddressHolder src) {
        this.nativeAddress = src.address;
    }

    private NativeFunctionPointer(long nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

    private final long nativeAddress;

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
        if (!(obj instanceof NativeFunctionPointer)) {
            return false;
        }
        final NativeFunctionPointer other = (NativeFunctionPointer) obj;
        return this.nativeAddress == other.nativeAddress;
    }

    @Override
    public String toString() {
        return String.format("{nativeAddress : 0x%08x}", nativeAddress);
    }

    @FunctionalInterface
    public interface Producer<A extends NativeFunctionPointer> {

        A produce(NativeAddressHolder nativeAddressHolder);
    }

}
