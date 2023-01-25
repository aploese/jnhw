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
package de.ibapl.jnhw.libloader;

/**
 * The wordsize to use.
 *
 * @author aploese
 */
public enum SizeInBit {
    _8_BIT(8), _16_BIT(16), _32_BIT(32), _64_BIT(64), _96_BIT(96), _128_BIT(128);
    public final int sizeInBit;
    public final int sizeInByte;

    private SizeInBit(int sizeInBit) {
        this.sizeInBit = sizeInBit;
        this.sizeInByte = sizeInBit / 8;
    }

    public final static SizeInBit of_1_Byte = SizeInBit._8_BIT;
    public final static SizeInBit of_2_Byte = SizeInBit._16_BIT;
    public final static SizeInBit of_4_Byte = SizeInBit._32_BIT;
    public final static SizeInBit of_8_Byte = SizeInBit._64_BIT;
    public final static SizeInBit of_12_Byte = SizeInBit._96_BIT;
    public final static SizeInBit of_16_Byte = SizeInBit._128_BIT;

}
