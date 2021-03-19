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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.annotation.int16_t;
import de.ibapl.jnhw.common.annotation.int32_t;
import de.ibapl.jnhw.common.annotation.int64_t;
import de.ibapl.jnhw.common.annotation.int8_t;
import de.ibapl.jnhw.common.annotation.uint16_t;
import de.ibapl.jnhw.common.annotation.uint32_t;
import de.ibapl.jnhw.common.annotation.uint64_t;
import de.ibapl.jnhw.common.annotation.uint8_t;
import java.nio.ByteBuffer;

/**
 *
 * @author aploese
 */
public interface MemoryAccessor {

    /**
     *
     * @param pos a position with in the array
     * @param len a length
     * @param arrayLength th length of the array
     *
     * @throws ArrayIndexOutOfBoundsException if pos or len < 0 or pos + len >
     * arrayLength
     */
    public static void outOfBoundsByteArray(int pos, int len, int arrayLength) {
        if (pos < 0) {
            throw new ArrayIndexOutOfBoundsException("pos: " + pos);
        } else if (len < 0) {
            throw new ArrayIndexOutOfBoundsException("len: " + len);
        } else if (arrayLength - pos < len) {
            throw new ArrayIndexOutOfBoundsException("pos + len > array.length " + (pos + len) + " > " + arrayLength);
        }
    }

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
    byte int8_t(OpaqueMemory32 mem, long offset);

    void int8_t(OpaqueMemory32 mem, long offset, @int8_t byte value);

    @int8_t
    byte int8_t(OpaqueMemory64 mem, long offset);

    void int8_t(OpaqueMemory64 mem, long offset, @int8_t byte value);

    String int8_t_AsHex(OpaqueMemory32 mem, long offset);

    String int8_t_nativeToString(OpaqueMemory32 mem, long offset);

    @int16_t
    short int16_t(OpaqueMemory32 mem, long offset);

    void int16_t(OpaqueMemory32 mem, long offset, @int16_t short value);

    String int16_t_AsHex(OpaqueMemory32 mem, long offset);

    String int16_t_nativeToString(OpaqueMemory32 mem, long offset);

    @int32_t
    int int32_t(OpaqueMemory32 mem, long offset);

    void int32_t(OpaqueMemory32 mem, long offset, @int32_t int value);

    String int32_t_AsHex(OpaqueMemory32 mem, long offset);

    String int32_t_nativeToString(OpaqueMemory32 mem, long offset);

    @int64_t
    long int64_t(OpaqueMemory32 mem, long offset);

    void int64_t(OpaqueMemory32 mem, long offset, @int64_t long value);

    String int64_t_AsHex(OpaqueMemory32 mem, long offset);

    String int64_t_nativeToString(OpaqueMemory32 mem, long offset);

    @uint8_t
    byte uint8_t(OpaqueMemory32 mem, long offset);

    @uint8_t
    short uint8_t_AsShort(OpaqueMemory32 mem, long offset);

    void uint8_t(OpaqueMemory32 mem, long offset, @uint8_t byte value);

    void uint8_t_FromShort(OpaqueMemory32 mem, long offset, @uint8_t short value);

    String uint8_t_AsHex(OpaqueMemory32 mem, long offset);

    String uint8_t_nativeToString(OpaqueMemory32 mem, long offset);

    @uint16_t
    short uint16_t(OpaqueMemory32 mem, long offset);

    @uint16_t
    int uint16_t_AsInt(OpaqueMemory32 mem, long offset);

    void uint16_t(OpaqueMemory32 mem, long offset, @uint16_t short value);

    void uint16_t_FromInt(OpaqueMemory32 mem, long offset, @uint16_t int value);

    String uint16_t_AsHex(OpaqueMemory32 mem, long offset);

    String uint16_t_nativeToString(OpaqueMemory32 mem, long offset);

    @uint32_t
    int uint32_t(OpaqueMemory32 mem, long offset);

    @uint32_t
    long uint32_t_AsLong(OpaqueMemory32 mem, long offset);

    void uint32_t(OpaqueMemory32 mem, long offset, @uint32_t int value);

    void uint32_t_FromLong(OpaqueMemory32 mem, long offset, @uint32_t long value);

    String uint32_t_AsHex(OpaqueMemory32 mem, long offset);

    String uint32_t_nativeToString(OpaqueMemory32 mem, long offset);

    /**
     * access the native long (signed long) datatype. It m,ay be 32 or 64bis
     *
     * @param mem
     * @param offset
     * @return
     */
    long signed_long(OpaqueMemory32 mem, long offset);

    /**
     * access the native long (signed long) datatype. It m,ay be 32 or 64bis
     *
     * @param mem
     * @param offset
     * @return
     */
    void signed_long(OpaqueMemory32 mem, long offset, long value);

    /**
     * access the ith native unsigned long datatype. It m,ay be 32 or 64bis
     *
     * @param mem
     * @param offset
     */
    long signed_long_AtIndex(OpaqueMemory32 mem, long offset, int index);

    /**
     * access the ith native unsigned long datatype. It m,ay be 32 or 64bis
     *
     * @param mem
     * @param offset
     */
    void signed_long_AtIndex(OpaqueMemory32 mem, long offset, int index, long value);

    /**
     * access the native unsigned long datatype. It m,ay be 32 or 64bis
     *
     * @param mem
     * @param offset
     * @return
     */
    long unsigned_long(OpaqueMemory32 mem, long offset);

    /**
     * access the native unsigned long datatype. It m,ay be 32 or 64bis
     *
     * @param mem
     * @param offset
     */
    void unsigned_long(OpaqueMemory32 mem, long offset, long value);

    /**
     * access the ith native unsigned long datatype. It m,ay be 32 or 64bis
     *
     * @param mem
     * @param offset
     */
    long unsigned_long_AtIndex(OpaqueMemory32 mem, long offset, int index);

    /**
     * access the ith native unsigned long datatype. It m,ay be 32 or 64bis
     *
     * @param mem
     * @param offset
     */
    void unsigned_long_AtIndex(OpaqueMemory32 mem, long offset, int index, long value);

    @uint64_t
    long uint64_t(OpaqueMemory32 mem, long offset);

    void uint64_t(OpaqueMemory32 mem, long offset, @uint64_t long value);

    String uint64_t_AsHex(OpaqueMemory32 mem, long offset);

    String uint64_t_nativeToString(OpaqueMemory32 mem, long offset);

    default int getSignedIntOf(OpaqueMemory32 mem, long offset, int realSize) {
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

    default void setSignedIntOf(final OpaqueMemory32 mem, long offset, final int realSize, final int value) {
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

    default void setUnsignedIntOf(final OpaqueMemory32 mem, long offset, final int realSize, final int value) {
        switch (realSize) {
            case 1:
                if (value > 0x00ff) {
                    throw new IllegalArgumentException("value too big for uint8_t: " + value);
                }
                uint8_t_FromShort(mem, offset, (short) value);
                break;
            case 2:
                if (value > 0x00ffff) {
                    throw new IllegalArgumentException("value too big for uint16_t: " + value);
                }
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
    default int getUnsignedIntOf(OpaqueMemory32 mem, long offset, int realSize) {
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

    default String getUnsignedIntOf_AsHex(OpaqueMemory32 mem, long offset, int realSize) {
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

    default String getSignedIntOf_AsHex(OpaqueMemory32 mem, long offset, int realSize) {
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

    default String getUnsignedIntOf_nativeToString(OpaqueMemory32 mem, long offset, int realSize) {
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

    default String getSignedIntOf_nativeToString(OpaqueMemory32 mem, long offset, int realSize) {
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
    default long getSignedLongOf(OpaqueMemory32 mem, long offset, int realSize) {
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

    default void setSignedLongOf(final OpaqueMemory32 mem, long offset, final int realSize, final long value) {
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

    default void setUnsignedLongOf(final OpaqueMemory32 mem, long offset, final int realSize, final long value) {
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
    default long getUnsignedLongOf(OpaqueMemory32 mem, long offset, int realSize) {
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

    default String getUnsignedLongOf_AsHex(OpaqueMemory32 mem, long offset, int realSize) {
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

    default String getSignedLongOf_AsHex(OpaqueMemory32 mem, long offset, int realSize) {
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

    default String getUnsignedLongOf_nativeToString(OpaqueMemory32 mem, long offset, int realSize) {
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

    default String getSignedLongOf_nativeToString(OpaqueMemory32 mem, long offset, int realSize) {
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

    long allocateMemory(AbstractNativeMemory mem, long sizeInBytes);

    void setMemory32(OpaqueMemory32 mem, byte value);

    void setMemory64(OpaqueMemory64 mem, byte value);

    void copyMemory32(byte[] src, int srcPos, OpaqueMemory32 destMem, int destPos, int length);

    void copyMemory64(byte[] src, int srcPos, OpaqueMemory64 destMem, long destPos, int length);

    void copyMemory32(OpaqueMemory32 srcMem, int srcPos, byte[] dest, int destPos, int length);

    void copyMemory64(OpaqueMemory64 srcMem, long srcPos, byte[] dest, int destPos, int length);

    long intptr_t(OpaqueMemory32 mem, long offset);

    void intptr_t(OpaqueMemory32 mem, long offset, long dest);

    String intptr_t_AsHex(OpaqueMemory32 mem, long offset);

    long intptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index);

    void intptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index, long dest);

    long uintptr_t(OpaqueMemory32 mem, long offset);

    NativeAddressHolder uintptr_t_AsNativeAddressHolder(OpaqueMemory32 mem, long offset);

    void uintptr_t(OpaqueMemory32 mem, long offset, long dest);

    void uintptr_t(OpaqueMemory32 mem, long offset, OpaqueMemory32 dest);

    void uintptr_t(OpaqueMemory32 mem, long offset, OpaqueMemory32 dest, long destOffset);

    void uintptr_t(OpaqueMemory32 mem, long offset, ByteBuffer dest);

    void uintptr_t(OpaqueMemory32 mem, long offset, NativeAddressHolder dest);

    void uintptr_t(OpaqueMemory32 mem, long offset, NativeFunctionPointer dest);

    String uintptr_t_AsHex(OpaqueMemory32 mem, long offset);

    long uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index);

    NativeAddressHolder uintptr_t_AtIndex_AsNativeAddressHolder(OpaqueMemory32 mem, long offset, int index);

    void uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index, long dest);

    void uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index, OpaqueMemory32 dest);

    void uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index, NativeAddressHolder dest);

    /**
     * this is a NULL terminated string, so we have to fetch the complete
     * string.
     *
     * @param mem
     * @param offset
     * @return
     */
    String getUTF_8String(OpaqueMemory32 mem, long offset);

    void setUTF_8String(String s, int srcStart, OpaqueMemory32 mem, long offset, int len);

    /**
     * In order to calculate the needed size in bytes, add a 1 for NULL
     * termination!
     *
     * @param s
     * @return
     */
    int getUTF_8StringLength(String s);

    String getUnicodeString(OpaqueMemory32 mem, long offset, int start, int len);

    void setUnicodeString(String s, int srcStart, OpaqueMemory32 mem, long offset, int destStart, int len);

    /**
     * underlying datatype is 16 bit wide, so multiply this by 2 for bytes
     * needed! this will not be NULL terminated!
     *
     * @param s
     * @return
     */
    int getUnicodeStringLength(String s);

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
