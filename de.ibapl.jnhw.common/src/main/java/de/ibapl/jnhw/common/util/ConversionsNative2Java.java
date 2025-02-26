/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2022-2024, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.libloader.Endianess;
import de.ibapl.jnhw.libloader.MemoryModel;
import static de.ibapl.jnhw.libloader.MemoryModel.ILP32;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
public final class ConversionsNative2Java {

    /**
     * Convert an native address 32 or 64 bit to 32 bit int on address == 644
     * bit the int (32bit) BIG Endian the int will be in the upper 32 bit!!
     */
    @FunctionalInterface
    public interface Address2Int {

        int convert(final MemorySegment mem);
    }

    private final static MemoryModel MEMORY_MODEL = MultiarchTupelBuilder.getMemoryModel();
    private final static Endianess ENDIANESS = MultiarchTupelBuilder.getEndianess();

    public final static int convertAddressToIntDirect(final MemorySegment mem) {
        return (int) mem.address();
    }

    public final static int convertAddress64ToInt32Be(final MemorySegment mem) {
        return (int) (mem.address() >>> 32);
    }

    public final static Address2Int getAdress2Int() {
        switch (ENDIANESS) {
            case LITTLE -> {
                return ConversionsNative2Java::convertAddressToIntDirect;
            }
            case BIG -> {
                switch (MEMORY_MODEL) {
                    case ILP32 -> {
                        return ConversionsNative2Java::convertAddressToIntDirect;
                    }
                    case LP64 -> {
                        return ConversionsNative2Java::convertAddress64ToInt32Be;
                    }
                    default ->
                        throw new RuntimeException("Can't handle endianess: " + ENDIANESS + " and memory model: " + MEMORY_MODEL);
                }
            }
            default ->
                throw new RuntimeException("Can't handle endianess: " + ENDIANESS);
        }
    }

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
    public final static MemorySegment uintptr_t_TO_MemoryAddress(@uintptr_t long value) {
        return switch (MEMORY_MODEL) {
            case ILP32, LP32 ->
                MemorySegment.ofAddress(value & 0x00000000ffffffffL);
            case LP64, ILP64 ->
                MemorySegment.ofAddress(value);
            default ->
                throw new RuntimeException("Can't handle memory model: " + MEMORY_MODEL);
        };
    }

    public final static MemorySegment uintptr_t_TO_MemoryAddress(@uintptr_t int value) {
        return MemorySegment.ofAddress(value & 0x00000000ffffffffL);
    }
}
