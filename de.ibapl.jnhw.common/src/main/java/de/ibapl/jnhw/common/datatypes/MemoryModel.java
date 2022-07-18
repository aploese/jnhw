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

import static de.ibapl.jnhw.common.datatypes.SizeInBit.*;

/**
 *
 * @author aploese
 */
public enum MemoryModel {
    /**
     * char is 8 bit. <br>
     * short is 16 bit. <br>
     * int is 32 bit. <br>
     * long is 64 bit. <br>
     * long long is 64 bit. <br>
     * pointer is 32 bit. <br>
     */
    L64(_8_BIT, _16_BIT, _32_BIT, _64_BIT, _64_BIT, _32_BIT),
    /**
     * char is 8 bit. <br>
     * short is 16 bit. <br>
     * int is 32 bit. <br>
     * long is 64 bit. <br>
     * long long is 64 bit. <br>
     * pointer is 64 bit. <br>
     */
    LP64(_8_BIT, _16_BIT, _32_BIT, _64_BIT, _64_BIT, _64_BIT),
    /**
     * Unix 64 bit. <br>
     *
     * char is 8 bit. <br>
     * short is 16 bit. <br>
     * int is 64 bit. <br>
     * long is 64 bit. <br>
     * long long is 64 bit. <br>
     * pointer is 64 bit. <br>
     */
    ILP64(_8_BIT, _16_BIT, _64_BIT, _64_BIT, _64_BIT, _64_BIT),
    /**
     * char is 8 bit. <br>
     * short is 16 bit. <br>
     * int is 32 bit. <br>
     * long is 32 bit. <br>
     * long long is 64 bit. <br>
     * pointer is 64 bit. <br>
     */
    LLP64(_8_BIT, _16_BIT, _32_BIT, _32_BIT, _64_BIT, _64_BIT),
    /**
     * Windows 64 bit. <br>
     *
     * char is 8 bit. <br>
     * short is 16 bit. <br>
     * int is 32 bit. <br>
     * long is 32 bit. <br>
     * long long is 64 bit. <br>
     * pointer is 32 bit. <br>
     */
    ILP32(_8_BIT, _16_BIT, _32_BIT, _32_BIT, _64_BIT, _32_BIT),
    /**
     * Unix 32 bit and Windows 32 bit. <br>
     *
     * char is 8 bit. <br>
     * short is 16 bit. <br>
     * int is 16 bit. <br>
     * long is 32 bit. <br>
     * long long is 64 bit. <br>
     * pointer is 32 bit. <br>
     */
    LP32(_8_BIT, _16_BIT, _16_BIT, _32_BIT, _64_BIT, _32_BIT);

    private MemoryModel(SizeInBit sizeOf_char, SizeInBit sizeOf_short, SizeInBit sizeOf_int, SizeInBit sizeOf_long, SizeInBit sizeOf_long_long, SizeInBit sizeOf_pointer) {
        this.sizeOf_char = sizeOf_char;
        this.sizeOf_short = sizeOf_short;
        this.sizeOf_int = sizeOf_int;
        this.sizeOf_long = sizeOf_long;
        this.sizeOf_long_long = sizeOf_long_long;
        this.sizeOf_pointer = sizeOf_pointer;
    }

    public final SizeInBit sizeOf_char;
    public final SizeInBit sizeOf_short;
    public final SizeInBit sizeOf_int;
    public final SizeInBit sizeOf_long;
    public final SizeInBit sizeOf_long_long;
    public final SizeInBit sizeOf_pointer;

}
