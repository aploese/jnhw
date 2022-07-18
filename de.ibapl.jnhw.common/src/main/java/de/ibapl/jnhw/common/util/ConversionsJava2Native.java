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
package de.ibapl.jnhw.common.util;

import de.ibapl.jnhw.common.annotation.int16_t;
import de.ibapl.jnhw.common.annotation.int32_t;
import de.ibapl.jnhw.common.annotation.int8_t;
import de.ibapl.jnhw.common.annotation.uint32_t;

/**
 *
 * @author aploese
 */
public final class ConversionsJava2Native {

    @int32_t
    public final static int boolean_TO_int32_t(boolean value) {
        return value ? 1 : 0;
    }

    @uint32_t
    public final static int long_TO_uint32_t(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must not be negative: " + value);
        } else if (value > 0x00000000ffffffffL) {
            throw new IllegalArgumentException("value must not be bigger than  4294967295 (0xffffffff): " + value);
        } else {
            return (int) value;
        }
    }

    @int16_t
    public final static short int_TO_uint16_t(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must not be negative: " + value);
        } else if (value > 0x0000ffff) {
            throw new IllegalArgumentException("value must not be bigger than  65535 (0xffff): " + value);
        } else {
            return (short) value;
        }
    }

    @int8_t
    public final static byte short_TO_uint8_t_(short value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must not be negative: " + value);
        } else if (value > (short) 0x00ff) {
            throw new IllegalArgumentException("value must not be bigger than 255 (0xff): " + value);
        } else {
            return (byte) value;
        }
    }

}
