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
package de.ibapl.jnhw.common.util;

import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.WordSize;

/**
 *
 * @author aploese
 */
public class JnhwFormater {

    private final static WordSize WORD_SIZE = new MultiarchTupelBuilder().getWordSize();

    /**
     * formats an Address accorfing to 32 or 64 bit
     *
     * @param address
     * @return
     */
    public static String formatAddress(long address) {
        switch (WORD_SIZE) {
            case _64_BIT:
                return String.format("0x%016x", address);
            case _32_BIT:
                final long upper32 = address & 0xFFFFFFFF00000000L;
                if (upper32 == 0L) {
                    return String.format("0x%08x", address);
                } else {
                    //Error?? on 32 bit we got the upper 32 set?? 
                    return String.format("0x(!>>>)%08x(<<<!)0x%08x", upper32 >>> 32, address &0x00000000FFFFFFFFL);
                }
            default:
                throw new RuntimeException("UnknownWordsize");
        }

    }
}
