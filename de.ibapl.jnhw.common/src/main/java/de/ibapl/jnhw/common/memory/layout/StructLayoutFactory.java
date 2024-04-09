/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2021-2024, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw.common.memory.layout;

/**
 *
 * @author aploese
 * @param <T>
 */
public interface StructLayoutFactory {

    public static enum Type {
        STRUCT,
        UNION;
    }

    long int8_t();

    long int16_t();

    long int32_t();

    long int64_t();

    long intptr_t();

    long uint8_t();

    long uint16_t();

    long uint32_t();

    long uint64_t();

    long uintptr_t();

    long getSizeof();

    Alignment getAlignment();

    long struct(long sizeInBytes, Alignment alignment);

    long union(long sizeInBytes, Alignment alignment);

}
