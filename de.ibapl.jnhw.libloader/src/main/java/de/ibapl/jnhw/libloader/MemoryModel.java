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
package de.ibapl.jnhw.libloader;

import static de.ibapl.jnhw.libloader.SizeInBit.*;

/**
 *
 * @author aploese
 */
public enum MemoryModel {
    L64(_8_BIT, _16_BIT, _32_BIT, _64_BIT, _64_BIT, _32_BIT),
    LP64(_8_BIT, _16_BIT, _32_BIT, _64_BIT, _64_BIT, _64_BIT),
    ILP64(_8_BIT, _16_BIT, _64_BIT, _64_BIT, _64_BIT, _64_BIT),
    LLP64(_8_BIT, _16_BIT, _32_BIT, _32_BIT, _64_BIT, _64_BIT),
    ILP32(_8_BIT, _16_BIT, _32_BIT, _32_BIT, _64_BIT, _32_BIT),
    LP32(_8_BIT, _16_BIT, _16_BIT, _32_BIT, _64_BIT, _32_BIT);

    private MemoryModel(SizeInBit sizeOf_char, SizeInBit sizeOf_short, SizeInBit sizeOf_int, SizeInBit sizeOf_long, SizeInBit sizeOf_long_long, SizeInBit sizeOf_pointer) {
        this.sizeOf_char = sizeOf_char.sizeInByte;
        this.sizeOf_short = sizeOf_short.sizeInByte;
        this.sizeOf_int = sizeOf_int.sizeInByte;
        this.sizeOf_long = sizeOf_long.sizeInByte;
        this.sizeOf_long_long = sizeOf_long_long.sizeInByte;
        this.sizeOf_pointer = sizeOf_pointer.sizeInByte;
    }

    public final int sizeOf_char;
    public final int sizeOf_short;
    public final int sizeOf_int;
    public final int sizeOf_long;
    public final int sizeOf_long_long;
    public final int sizeOf_pointer;

}
