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
package de.ibapl.jnhw.common.util;

import de.ibapl.jnhw.common.annotation.int32_t;
import de.ibapl.jnhw.common.annotation.uint16_t;
import de.ibapl.jnhw.common.annotation.uint32_t;
import de.ibapl.jnhw.common.annotation.uint8_t;
import de.ibapl.jnhw.common.annotation.uintptr_t;
import de.ibapl.jnhw.libloader.MemoryModel;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.MemoryAddress;

/**
 *
 * @author aploese
 */
public final class ConversionsNative2Java {

    private final static MemoryModel MEMORY_MODEL = MultiarchTupelBuilder.getMemoryModel();

    public final static long uint32_t_TO_long(@uint32_t int value) {
        return 0x00000000ffffffffL & value;
    }

    public final static boolean int32_t_TO_boolean(@int32_t int value) {
        return value != 0;
    }

    public final static int uint16_t_TO_int(@uint16_t short value) {
        return 0x0000ffff & value;
    }

    public final static short uint8_t_TO_short(@uint8_t byte value) {
        return (short) (0x00ff & value);
    }

    /**
     * if the result is 32 bit int mask the upper half
     *
     * @param value
     * @return
     */
    public final static MemoryAddress uintptr_t_TO_MemoryAddress(@uintptr_t long value) {
        return switch (MEMORY_MODEL) {
            case ILP32, LP32 ->
                MemoryAddress.ofLong(value & 0x00000000ffffffffL);
            case LP64, ILP64 ->
                MemoryAddress.ofLong(value);
            default ->
                throw new RuntimeException("Can't handle memory model: " + MEMORY_MODEL);
        };
    }

    public final static MemoryAddress uintptr_t_TO_MemoryAddress(@uintptr_t int value) {
        return MemoryAddress.ofLong(value & 0x00000000ffffffffL);
    }
}
