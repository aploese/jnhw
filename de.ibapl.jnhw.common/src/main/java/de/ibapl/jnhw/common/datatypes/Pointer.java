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
package de.ibapl.jnhw.common.datatypes;

import de.ibapl.jnhw.common.util.JnhwFormater;
import java.io.IOException;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public interface Pointer {

    /**
     * The NULL pointer.
     */
    public final static Pointer NULL = new Pointer() {

        @Override
        public MemorySegment toMemorySegment() {
            return MemorySegment.NULL;
        }

        @Override
        public long toAddress() {
            return 0;
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

    MemorySegment toMemorySegment();

    long toAddress();

    /**
     * test if adresses are the same. If either {@code address} or {@code op} is
     * null and the other has a address of <b>{@code NULL}</b> it is considered
     * as the same address.
     *
     * @param address
     * @param op
     * @return
     */
    static boolean isSameAddress(MemorySegment address, Pointer op) {
        return address.address() == op.toAddress();
    }

    static boolean isSameAddress(Pointer ptr1, Pointer ptr2) {
        return ptr1.toAddress() == ptr2.toAddress();
    }

    boolean is_NULL();

    boolean is_Not_NULL();

    default void nativeToString(Appendable sb, String INDENT, String indent) throws IOException {
        sb.append(getClass().getSimpleName() + ": {address: " + JnhwFormater.formatAddress(toMemorySegment()) + "}");
    }

}
