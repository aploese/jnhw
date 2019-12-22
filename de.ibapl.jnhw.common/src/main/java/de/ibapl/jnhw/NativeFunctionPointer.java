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

/**
 *
 * @author aploese
 * @param <T> must be an {@link FunctionalInterface}.
 */
public class NativeFunctionPointer<T> {

    public static void setAddress(NativeFunctionPointer<?> nativeFunctionPointer, long nativeAddress) {
        nativeFunctionPointer.nativeAddress = nativeAddress;
    }

    private long nativeAddress;

    public NativeFunctionPointer(long nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

    public NativeFunctionPointer() {
    }

    /**
     * cast to simple pointer...
     *
     * @param src
     */
    NativeFunctionPointer(NativeFunctionPointer<T> src) {
        this.nativeAddress = src.nativeAddress;
    }

    public boolean addressEquals(NativeFunctionPointer other) {
        return other != null ? this.nativeAddress == other.nativeAddress : false;
    }

    public static boolean addressEquals(NativeFunctionPointer a, NativeFunctionPointer b) {
        return (a == b) || (a != null && a.addressEquals(b));
    }

    @Override
    public String toString() {
        return String.format("{nativeAddress : 0x%08x}", nativeAddress);
    }

}
