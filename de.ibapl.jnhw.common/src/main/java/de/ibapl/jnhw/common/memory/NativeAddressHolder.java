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

import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.util.JnhwFormater;

/**
 *
 * @author aploese
 */
public final class NativeAddressHolder {

    public final static NativeAddressHolder NULL = new NativeAddressHolder(0L);

    final long address;

    /**
     * Called from native code and test classes only
     *
     * @param address
     */
    protected NativeAddressHolder(long address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.address ^ (this.address >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NativeAddressHolder)) {
            return false;
        }
        final NativeAddressHolder other = (NativeAddressHolder) obj;
        return this.address == other.address;
    }

    public boolean isNULL() {
        return address == 0L;
    }

    @Override
    public String toString() {
        return "{address : " + JnhwFormater.formatAddress(address) + "}";
    }

    public static NativeAddressHolder of(long address) {
        if ((BaseDataType.uintptr_t.SIZE_OF == 32) && ((address < 0) || (address > 0x00000000ffffffffL))) {
            throw new IllegalArgumentException("address outside range");
        }
        if (address == 0L) {
            return NULL;
        } else {
            return new NativeAddressHolder(address);
        }
    }

}
