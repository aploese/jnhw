/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2021, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.util.JnhwFormater;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import java.io.IOException;
import java.util.function.Function;

/**
 *
 * @author aploese
 */
public class NativeFunctionPointer {

    public static boolean isSameAddress(NativeFunctionPointer ptr1, NativeFunctionPointer ptr2) {
        return (ptr1 == ptr2) || (ptr1 != null && ptr1.nativeAddress == ptr2.nativeAddress);
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

    @SuppressWarnings("unchecked")
    public <T extends NativeFunctionPointer> NativeFunctionPointer(Function<T, NativeAddressHolder> producer) {
        this.nativeAddress = producer.apply((T) this).address;
    }

    public NativeFunctionPointer(NativeAddressHolder src) {
        this.nativeAddress = src.address;
    }

    public NativeFunctionPointer(NativeFunctionPointer src) {
        this.nativeAddress = src.nativeAddress;
    }

    protected NativeFunctionPointer(long nativeAddress) {
        this.nativeAddress = nativeAddress;
    }

    final long nativeAddress;

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
        return "{nativeAddress : " + JnhwFormater.formatAddress(nativeAddress) + "}";
    }

    public void nativeToString(Appendable sb, String INDENT_PREFIX, String INDENT) throws IOException {
        JsonStringBuilder jsb = new JsonStringBuilder(sb, INDENT_PREFIX, INDENT);
        jsb.appendAddressMember("nativeAddress", nativeAddress);
        jsb.close();
    }

    @FunctionalInterface
    public interface Producer<A extends NativeFunctionPointer> {

        A produce(NativeAddressHolder nativeAddressHolder);
    }

}
