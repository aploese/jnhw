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
package de.ibapl.jnhw.common.datatypes;

import java.util.Objects;
import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;

/**
 *
 * @author aploese
 * @param <T>
 */
public interface Pointer<T> {

    /**
     * The NULL pointer.
     */
    public final static Pointer NULL = new Pointer() {

        @Override
        public Addressable toAddressable() {
            return MemoryAddress.NULL;
        }

        @Override
        public boolean is_NULL() {
            return true;
        }

        @Override
        public boolean is_Not_NULL() {
            return false;
        }

    };

    Addressable toAddressable();

    /**
     * test if adresses are the same. If either {@code address} or {@code op} is
     * null and the other has a address of <b>{@code NULL}</b> it is considered
     * as the same address.
     *
     * @param address
     * @param op
     * @return
     */
    public static boolean isSameAddress(MemoryAddress address, Pointer op) {
        if (address == null) {
            return op == null ? true : op.toAddressable().address() == MemoryAddress.NULL;
        } else {
            if (op == null) {
                return address.equals(MemoryAddress.NULL);
            } else {
                return Objects.equals(address, op.toAddressable().address());
            }
        }
    }

    public static boolean isSameAddress(Pointer ptr1, Pointer ptr2) {
        return (ptr1 == ptr2) || (ptr1 != null && ptr1.toAddressable().address().equals(ptr2.toAddressable().address()));
    }

    public boolean is_NULL();

    public boolean is_Not_NULL();

    default public T to() {
        return (T) this;
    }

}
