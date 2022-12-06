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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.util.JnhwFormater;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import java.io.IOException;
import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.util.Objects;
import java.util.function.Function;

/**
 *
 * @author aploese
 */
public class NativeFunctionPointer implements Pointer {

    @Override
    public final Addressable toAddressable() {
        return memoryAddress;
    }

    public final MemoryAddress toAddress() {
        return memoryAddress;
    }

    public static NativeFunctionPointer wrap(MemoryAddress memoryAddress) {
        return new NativeFunctionPointer(memoryAddress);
    }

    @SuppressWarnings("unchecked")
    public <T extends NativeFunctionPointer> NativeFunctionPointer(Function<T, MemoryAddress> producer) {
        this.memoryAddress = producer.apply((T) this);
    }

    public NativeFunctionPointer(MemoryAddress src) {
        this.memoryAddress = src;
    }

    protected final MemoryAddress memoryAddress;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.memoryAddress);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NativeFunctionPointer other) {
            return Objects.equals(this.memoryAddress, other.memoryAddress);
        } else {
            return false;
        }
    }

    @Override
    public final boolean is_NULL() {
        return memoryAddress == MemoryAddress.NULL;
    }

    @Override
    public final boolean is_Not_NULL() {
        return memoryAddress != MemoryAddress.NULL;
    }

    @Override
    public String toString() {
        return "{nativeAddress : " + JnhwFormater.formatAddress(memoryAddress) + "}";
    }

    public void nativeToString(Appendable sb, String INDENT_PREFIX, String INDENT) throws IOException {
        JsonStringBuilder jsb = new JsonStringBuilder(sb, INDENT_PREFIX, INDENT);
        jsb.appendAddressMember("nativeAddress", memoryAddress);
        jsb.close();
    }

    @FunctionalInterface
    public interface Producer<A extends NativeFunctionPointer> {

        A produce(MemoryAddress address);
    }

}
