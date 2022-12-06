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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.annotation.int16_t;
import de.ibapl.jnhw.common.annotation.int32_t;
import de.ibapl.jnhw.common.annotation.int64_t;
import de.ibapl.jnhw.common.annotation.int8_t;
import de.ibapl.jnhw.common.annotation.intptr_t;
import de.ibapl.jnhw.common.annotation.uint16_t;
import de.ibapl.jnhw.common.annotation.uint32_t;
import de.ibapl.jnhw.common.annotation.uint64_t;
import de.ibapl.jnhw.common.annotation.uint8_t;
import de.ibapl.jnhw.common.annotation.uintptr_t;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.util.ConversionsJava2Native;
import de.ibapl.jnhw.common.util.ConversionsNative2Java;
import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author aploese
 */
public sealed interface MemoryAccessor permits AbstractMemoryAccessorImpl {

    static MemoryAccessor getMemoryAccessor(ByteOrder byteOrder) {
        return switch (MultiarchTupelBuilder.getMemoryModel()) {
            case ILP32 ->
                new MemoryAccessorImpl_ILP32(byteOrder);
            case L64 ->
                new MemoryAccessorImpl_L64(byteOrder);
            case LLP64 ->
                new MemoryAccessorImpl_LLP64(byteOrder);
            case LP64 ->
                new MemoryAccessorImpl_LP64(byteOrder);
            default ->
                throw new IllegalStateException("Unknow memory model: " + MultiarchTupelBuilder.getMemoryModel());
        };
    }

    static MemoryAccessor getMemoryAccessor(ByteOrder byteOrder, long alignmentBits) {
        return switch (MultiarchTupelBuilder.getMemoryModel()) {
            case ILP32 ->
                new MemoryAccessorImpl_ILP32(byteOrder, alignmentBits);
            case L64 ->
                new MemoryAccessorImpl_L64(byteOrder, alignmentBits);
            case LLP64 ->
                new MemoryAccessorImpl_LLP64(byteOrder, alignmentBits);
            case LP64 ->
                new MemoryAccessorImpl_LP64(byteOrder, alignmentBits);
            default ->
                throw new IllegalStateException("Unknow memory model: " + MultiarchTupelBuilder.getMemoryModel());
        };
    }

    void copyMemory(byte[] src, int srcIndex, MemorySegment destMem, long dstOffset, int elementCount);

    void copyMemory(MemorySegment srcMem, long srcOffset, byte[] dest, int dstIndex, int elementCount);

    /**
     *
     * @param pos a position with in the array
     * @param len a length
     * @param arrayLength th length of the array
     *
     * @throws ArrayIndexOutOfBoundsException if pos or len < 0 or pos + len >
     * arrayLength
     */
    @Deprecated
    public static void outOfBoundsByteArray(int pos, int len, int arrayLength) {
        if (pos < 0) {
            throw new ArrayIndexOutOfBoundsException("pos: " + pos);
        } else if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("len: " + len);
        } else if (arrayLength - pos < len) {
            throw new ArrayIndexOutOfBoundsException("pos + len > array.length " + (pos + len) + " > " + arrayLength);
        }
    }

    @Deprecated
    public static void outOfBoundsMem(long pos, long len, long memLength) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException("pos: " + pos);
        } else if (len < 0) {
            throw new IndexOutOfBoundsException("len: " + len);
        } else if (memLength - pos < len) {
            throw new IndexOutOfBoundsException("pos + len > mem.length " + (pos + len) + " > " + memLength);
        }
    }

    @int8_t
    byte int8_t(MemorySegment mem, long offset);

    void int8_t(MemorySegment mem, long offset, @int8_t byte value);

    default String int8_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%02x", int8_t(mem, offset));
    }

    default String int8_t_nativeToString(MemorySegment mem, long offset) {
        return String.valueOf(int8_t(mem, offset));
    }

    @int16_t
    short int16_t(MemorySegment mem, long offset);

    void int16_t(MemorySegment mem, long offset, @int16_t short value);

    default String int16_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%04x", int16_t(mem, offset));
    }

    default String int16_t_nativeToString(MemorySegment mem, long offset) {
        return String.valueOf(int16_t(mem, offset));
    }

    @int32_t
    int int32_t(MemorySegment mem, long offset);

    void int32_t(MemorySegment mem, long offset, @int32_t int value);

    default String int32_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%08x", int32_t(mem, offset));
    }

    default String int32_t_nativeToString(MemorySegment mem, long offset) {
        return String.valueOf(int32_t(mem, offset));
    }

    @int64_t
    long int64_t(MemorySegment mem, long offset);

    void int64_t(MemorySegment mem, long offset, @int64_t long value);

    default String int64_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%016x", int64_t(mem, offset));
    }

    default String int64_t_nativeToString(MemorySegment mem, long offset) {
        return String.valueOf(int64_t(mem, offset));
    }

    @intptr_t
    MemoryAddress intptr_t(MemorySegment mem, long offset);

    void intptr_t(MemorySegment mem, long offset, @intptr_t Addressable value);

    void intptr_t(MemorySegment mem, long offset, @intptr_t Pointer value);

    String intptr_t_AsHex(MemorySegment mem, long offset);

    String intptr_t_nativeToString(MemorySegment mem, long offset);

    @intptr_t
    MemoryAddress intptr_t_AtIndex(MemorySegment mem, long index);

    @intptr_t
    void intptr_t_AtIndex(MemorySegment mem, long index, Addressable dest);

    @intptr_t
    void intptr_t_AtIndex(MemorySegment mem, long index, Pointer dest);

    @uint8_t
    byte uint8_t(MemorySegment mem, long offset);

    @uint8_t
    default short uint8_t_AsShort(MemorySegment mem, long offset) {
        return ConversionsNative2Java.uint8_t_TO_short(uint8_t(mem, offset));
    }

    void uint8_t(MemorySegment mem, long offset, @uint8_t byte value);

    default void uint8_t_FromShort(MemorySegment mem, long offset, @uint8_t short value) {
        uint8_t(mem, offset, ConversionsJava2Native.short_TO_uint8_t_(value));
    }

    default String uint8_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%02x", uint8_t(mem, offset));
    }

    default String uint8_t_nativeToString(MemorySegment mem, long offset) {
        return String.valueOf(uint8_t_AsShort(mem, offset));
    }

    @uint16_t
    short uint16_t(MemorySegment mem, long offset);

    @uint16_t
    default int uint16_t_AsInt(MemorySegment mem, long offset) {
        return ConversionsNative2Java.uint16_t_TO_int(uint16_t(mem, offset));
    }

    void uint16_t(MemorySegment mem, long offset, @uint16_t short value);

    default void uint16_t_FromInt(MemorySegment mem, long offset, @uint16_t int value) {
        uint16_t(mem, offset, ConversionsJava2Native.int_TO_uint16_t(value));
    }

    default String uint16_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%04x", uint16_t(mem, offset));
    }

    default String uint16_t_nativeToString(MemorySegment mem, long offset) {
        return String.valueOf(uint16_t_AsInt(mem, offset));
    }

    @uint32_t
    int uint32_t(MemorySegment mem, long offset);

    @uint32_t
    default long uint32_t_AsLong(MemorySegment mem, long offset) {
        return ConversionsNative2Java.uint32_t_TO_long(uint32_t(mem, offset));
    }

    void uint32_t(MemorySegment mem, long offset, @uint32_t int value);

    default void uint32_t_FromLong(MemorySegment mem, long offset, @uint32_t long value) {
        uint32_t(mem, offset, ConversionsJava2Native.long_TO_uint32_t(value));
    }

    default String uint32_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%08x", uint32_t(mem, offset));
    }

    default String uint32_t_nativeToString(MemorySegment mem, long offset) {
        return Integer.toUnsignedString(uint32_t(mem, offset));
    }

    /**
     * access the native long (signed long) datatype. It may be 32 or 64 bit.
     *
     * @param mem
     * @param offset
     * @return
     */
    long signed_long(MemorySegment mem, long offset);

    /**
     * access the native long (signed long) datatype. It may be 32 or 64 bit.
     *
     * @param mem
     * @param offset
     * @return
     */
    void signed_long(MemorySegment mem, long offset, long value);

    /**
     * access the ith native unsigned long datatype. It may be 32 or 64 bit.
     *
     * @param mem
     * @param offset
     */
    long signed_long_AtIndex(MemorySegment mem, long offset, int index);

    /**
     * access the ith native unsigned long datatype. It may be 32 or 64 bit.
     *
     * @param mem
     * @param offset
     */
    void signed_long_AtIndex(MemorySegment mem, long offset, int index, long value);

    /**
     * access the native unsigned long datatype. It may be 32 or 64 bit.
     *
     * @param mem
     * @param offset
     * @return
     */
    long unsigned_long(MemorySegment mem, long offset);

    /**
     * access the native unsigned long datatype. It may be 32 or 64 bit.
     *
     * @param mem
     * @param offset
     */
    void unsigned_long(MemorySegment mem, long offset, long value);

    /**
     * access the ith native unsigned long datatype. It may be 32 or 64 bit.
     *
     * @param mem
     * @param offset
     */
    long unsigned_long_AtIndex(MemorySegment mem, long offset, int index);

    /**
     * access the ith native unsigned long datatype. It may be 32 or 64 bit.
     *
     * @param mem
     * @param offset
     */
    void unsigned_long_AtIndex(MemorySegment mem, long offset, int index, long value);

    @uint64_t
    long uint64_t(MemorySegment mem, long offset);

    void uint64_t(MemorySegment mem, long offset, @uint64_t long value);

    default String uint64_t_AsHex(MemorySegment mem, long offset) {
        return String.format("0x%016x", uint64_t(mem, offset));
    }

    default String uint64_t_nativeToString(MemorySegment mem, long offset) {
        return Long.toUnsignedString(uint64_t(mem, offset));
    }

    @uintptr_t
    MemoryAddress uintptr_t(MemorySegment mem, long offset);

    void uintptr_t(MemorySegment mem, long offset, @uintptr_t Addressable dest);

    void uintptr_t(MemorySegment mem, long offset, @uintptr_t ByteBuffer dest);

    void uintptr_t(MemorySegment mem, long offset, @uintptr_t NativeFunctionPointer dest);

    String uintptr_t_nativeToString(MemorySegment mem, long offset);

    String uintptr_t_AsHex(MemorySegment mem, long offset);

    @uintptr_t
    MemoryAddress uintptr_t_AtIndex(MemorySegment mem, long index);

    //TODO use Addressable BUT Addressable is not found by junit
    void uintptr_t_AtIndex(MemorySegment mem, long index, @uintptr_t MemoryAddress dest);

    //TODO use Addressable BUT Addressable is not found by junit
    void uintptr_t_AtIndex(MemorySegment mem, long index, @uintptr_t MemorySegment dest);

    default int getSignedIntOf(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return int8_t(mem, offset);
            case 2:
                return int16_t(mem, offset);
            case 4:
                return int32_t(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default void setSignedIntOf(final MemorySegment mem, long offset, final int realSize, final int value) {
        switch (realSize) {
            case 1:
                if ((value > Byte.MAX_VALUE) || (value < Byte.MIN_VALUE)) {
                    throw new IllegalArgumentException("value outside of int8_t: " + value);
                }
                int8_t(mem, offset, (byte) value);
                break;
            case 2:
                if ((value > Short.MAX_VALUE) || (value < Short.MIN_VALUE)) {
                    throw new IllegalArgumentException("value outside of int16_t: " + value);
                }
                int16_t(mem, offset, (short) value);
                break;
            case 4:
                int32_t(mem, offset, value);
                break;
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default void setUnsignedIntOf(final MemorySegment mem, long offset, final int realSize, final int value) {
        switch (realSize) {
            case 1:
                if (value > 0x00ff) {
                    throw new IllegalArgumentException("value too big for uint8_t: " + value);
                } else if (value < 0) {
                    throw new IllegalArgumentException("value is negative: " + value);
                }
                uint8_t_FromShort(mem, offset, (short) value);
                break;
            case 2:
                uint16_t_FromInt(mem, offset, value);
                break;
            case 4:
                uint32_t(mem, offset, value);
                break;
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    /**
     * Read any native mem, offset with tes size realsize and cast the result to
     * long. so if realSize is 4, it will read 4 bytes (uint32_t) and cast the
     * result to long. The conversation of unsigned applys from
     * uint8_t->short,uint16_t->int, uint32_t->long. uint_64 is a long the
     * signedness must be hancled someplace else.
     *
     * @param mem, offset
     * @param realSize
     * @return
     */
    default int getUnsignedIntOf(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return uint8_t_AsShort(mem, offset);
            case 2:
                return uint16_t_AsInt(mem, offset);
            case 4:
                return uint32_t(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default String getUnsignedIntOf_AsHex(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return uint8_t_AsHex(mem, offset);
            case 2:
                return uint16_t_AsHex(mem, offset);
            case 4:
                return uint32_t_AsHex(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default String getSignedIntOf_AsHex(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return int8_t_AsHex(mem, offset);
            case 2:
                return int16_t_AsHex(mem, offset);
            case 4:
                return int32_t_AsHex(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default String getUnsignedIntOf_nativeToString(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return uint8_t_nativeToString(mem, offset);
            case 2:
                return uint16_t_nativeToString(mem, offset);
            case 4:
                return uint32_t_nativeToString(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default String getSignedIntOf_nativeToString(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return int8_t_nativeToString(mem, offset);
            case 2:
                return int16_t_nativeToString(mem, offset);
            case 4:
                return int32_t_nativeToString(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    /**
     *
     * Read any native mem, offset with tes size realsize and cast the result to
     * long. so if realSize is 4, it will read 4 bytes (int32_t) and cast the
     * result to long.
     *
     * @param mem, offset the mem, offset to read from
     * @param realSize the real byte size of the data this happens on 32/64
     * archs in 32 its 4 byte and on 64 8 byte long
     * @return
     */
    default long getSignedLongOf(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return int8_t(mem, offset);
            case 2:
                return int16_t(mem, offset);
            case 4:
                return int32_t(mem, offset);
            case 8:
                return int64_t(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default void setSignedLongOf(final MemorySegment mem, long offset, final int realSize, final long value) {
        switch (realSize) {
            case 1:
                if ((value > Byte.MAX_VALUE) || (value < Byte.MIN_VALUE)) {
                    throw new IllegalArgumentException("value outside of int8_t: " + value);
                }
                int8_t(mem, offset, (byte) value);
                break;
            case 2:
                if ((value > Short.MAX_VALUE) || (value < Short.MIN_VALUE)) {
                    throw new IllegalArgumentException("value outside of int16_t: " + value);
                }
                int16_t(mem, offset, (short) value);
                break;
            case 4:
                if ((value > Integer.MAX_VALUE) || (value < Integer.MIN_VALUE)) {
                    throw new IllegalArgumentException("value outside of int32_t: " + value);
                }
                int32_t(mem, offset, (int) value);
                break;
            case 8:
                int64_t(mem, offset, value);
                break;
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default void setUnsignedLongOf(final MemorySegment mem, long offset, final int realSize, final long value) {
        switch (realSize) {
            case 1:
                if (value > 0x00ff) {
                    throw new IllegalArgumentException("value too big for uint8_t: " + value);
                }
                uint8_t_FromShort(mem, offset, (short) value);
                break;
            case 2:
                if (value > 0x0000ffff) {
                    throw new IllegalArgumentException("value too big for uint16_t: " + value);
                }
                uint16_t_FromInt(mem, offset, (int) value);
                break;
            case 4:
                if (value > 0x00000000ffffffffL) {
                    throw new IllegalArgumentException("value too big for uint32_t: " + value);
                }
                uint32_t_FromLong(mem, offset, value);
                break;
            case 8:
                uint64_t(mem, offset, value);
                break;
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    /**
     * Read any native mem, offset with tes size realsize and cast the result to
     * long. so if realSize is 4, it will read 4 bytes (uint32_t) and cast the
     * result to long. The conversation of unsigned applys from
     * uint8_t->short,uint16_t->int, uint32_t->long. uint_64 is a long the
     * signedness must be hancled someplace else.
     *
     * @param mem, offset
     * @param realSize
     * @return
     */
    default long getUnsignedLongOf(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return uint8_t_AsShort(mem, offset);
            case 2:
                return uint16_t_AsInt(mem, offset);
            case 4:
                return uint32_t_AsLong(mem, offset);
            case 8:
                return uint64_t(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default String getUnsignedLongOf_AsHex(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return uint8_t_AsHex(mem, offset);
            case 2:
                return uint16_t_AsHex(mem, offset);
            case 4:
                return uint32_t_AsHex(mem, offset);
            case 8:
                return uint64_t_AsHex(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default String getSignedLongOf_AsHex(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return int8_t_AsHex(mem, offset);
            case 2:
                return int16_t_AsHex(mem, offset);
            case 4:
                return int32_t_AsHex(mem, offset);
            case 8:
                return int64_t_AsHex(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default String getUnsignedLongOf_nativeToString(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return uint8_t_nativeToString(mem, offset);
            case 2:
                return uint16_t_nativeToString(mem, offset);
            case 4:
                return uint32_t_nativeToString(mem, offset);
            case 8:
                return uint64_t_nativeToString(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    default String getSignedLongOf_nativeToString(MemorySegment mem, long offset, int realSize) {
        switch (realSize) {
            case 1:
                return int8_t_nativeToString(mem, offset);
            case 2:
                return int16_t_nativeToString(mem, offset);
            case 4:
                return int32_t_nativeToString(mem, offset);
            case 8:
                return int64_t_nativeToString(mem, offset);
            default:
                throw new IllegalArgumentException("size is not supported: " + realSize);
        }
    }

    /**
     * this is a NULL terminated string, so we have to fetch the complete
     * string.
     *
     * @param mem
     * @param offset
     * @return
     */
    String getUTF_8String(MemorySegment mem, long offset);

    void setUTF_8String(MemorySegment mem, long offset, String s);

    String getUnicodeString(MemorySegment mem, long offset, int len);

    void setUnicodeString(MemorySegment mem, long offset, int len, String s);

    static long getBitsInLong(long value, int bitpos, int bitsize) {
        final long mask = (0xffffffffffffffffL >>> (64 - bitsize)); // just shift the mask...
        return (value >> bitpos) & mask;
    }

    static long setBitsInLong(long value, int bitpos, int bitsize, long bitsToSet) {
        final long maskValue = (0xffffffffffffffffL >>> (64 - bitsize)); // just shift the mask...
        final long mask = maskValue << bitpos;
        if ((bitsToSet & ~maskValue) != 0) {
            throw new IllegalArgumentException("value has bits outside of range");
        }
        return (value & ~mask) | ((bitsToSet << bitpos) & mask);
    }

    static boolean getBitInInt(int value, int bitpos) {
        return (value & (1 << bitpos)) != 0;
    }

    static int setBitInInt(int value, int bitpos, boolean bit) {
        if (bit) {
            //set bit at pos
            return value | (1 << bitpos);
        } else {
            //clear bit at pos
            return value & ~(1 << bitpos);
        }
    }

    static int getBitsInInt(int value, int bitpos, int bitsize) {
        final int mask = (0xffffffff >>> (32 - bitsize)); // just shift the mask...
        return (value >> bitpos) & mask;
    }

    static int setBitsInInt(int value, int bitpos, int bitsize, int bitsToSet) {
        final int maskValue = (0xffffffff >>> (32 - bitsize)); // just shift the mask...
        final int mask = maskValue << bitpos;
        if ((bitsToSet & ~maskValue) != 0) {
            throw new IllegalArgumentException("value has bits outside of range");
        }
        return (value & ~mask) | ((bitsToSet << bitpos) & mask);
    }

    static short getBitsInShort(short value, int bitpos, int bitsize) {
        final short mask = (short) (0xffff >>> (16 - bitsize)); // just shift the mask...
        return (short) ((value >> bitpos) & mask);
    }

    static short setBitsInShort(short value, int bitpos, int bitsize, short bitsToSet) {
        final short maskValue = (short) (0xffff >>> (16 - bitsize)); // just shift the mask...
        final short mask = (short) (maskValue << bitpos);
        if ((bitsToSet & ~maskValue) != 0) {
            throw new IllegalArgumentException("value has bits outside of range");
        }
        return (short) ((value & ~mask) | ((bitsToSet << bitpos) & mask));
    }

    static byte getBitsInByte(byte value, int bitpos, int bitsize) {
        final byte mask = (byte) (0xff >>> (8 - bitsize)); // just shift the mask...
        return (byte) ((value >> bitpos) & mask);
    }

    static byte setBitsInByte(byte value, int bitpos, int bitsize, byte bitsToSet) {
        final byte maskValue = (byte) (0xff >>> (8 - bitsize)); // just shift the mask...
        final byte mask = (byte) (maskValue << bitpos);
        if ((bitsToSet & ~maskValue) != 0) {
            throw new IllegalArgumentException("value has bits outside of range");
        }
        return (byte) ((value & ~mask) | ((bitsToSet << bitpos) & mask));
    }

}
