/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2025, Arne Plöse and individual contributors as indicated
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
public enum SizeInByte {
    _8_Bit(1), _16_Bit(2), _32_Bit(4), _64_Bit(8), _96_Bit(12), _128_Bit(16);
    public final int sizeInByte;

    private SizeInByte(int sizeInByte) {
        this.sizeInByte = sizeInByte;
    }

    public int sizeInBit() {
        return sizeInByte *8;
    }
    
    public final static SizeInByte _1_Byte = _8_Bit;
    public final static SizeInByte _2_Byte = _16_Bit;
    public final static SizeInByte _4_BYte = _32_Bit;
    public final static SizeInByte _8_Byte = _64_Bit;
    public final static SizeInByte _12_Byte = _96_Bit;
    public final static SizeInByte _16_Byte = _128_Bit;

}
