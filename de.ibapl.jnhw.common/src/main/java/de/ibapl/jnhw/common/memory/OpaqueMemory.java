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

import de.ibapl.jnhw.common.annotation.uintptr_t;
import de.ibapl.jnhw.common.datatypes.Native;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.util.JnhwFormater;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Logger;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.ValueLayout;

/**
 *
 * The base class for any chunk (i.e. pointer to or structs) of native memory.
 * The run method in MemoryCleaner will clean up the allocated memory after
 * finalizing this instance - if this instance owns the memory.
 *
 * @author aploese
 */
public abstract class OpaqueMemory<T> implements Native, Pointer<T> {

    public static MemorySegment sliceMemorySegment(OpaqueMemory mem, long offset, long newSize) {
        return mem.memorySegment.asSlice(offset, newSize);
    }

    @FunctionalInterface
    public static interface OpaqueMemoryProducer<T extends OpaqueMemory, P extends OpaqueMemory> {

        /**
         *
         * @param address the address to use.
         * @param parent the parent of the result with given address.
         * @return a cached or new OpaqueMemory.
         */
        T produce(MemoryAddress address, ResourceScope rs, P parent);

    }

    public final long sizeof() {
        return memorySegment.byteSize();
    }

    protected final static Logger LOG = Logger.getLogger("de.ibapl.libjnhw-common");

    /**
     * Memory accessor with the natural byte order
     */
    protected final static MemoryAccessor MEM_ACCESS = MemoryAccessor.getMemoryAccessor(ByteOrder.nativeOrder());
    /**
     * Memory accessor with the little endian byte order
     */
    protected final static MemoryAccessor MEM_ACCESS_LE = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN ? MEM_ACCESS : MemoryAccessor.getMemoryAccessor(ByteOrder.LITTLE_ENDIAN);
    /**
     * Memory accessor with the big endian byte order
     */
    protected final static MemoryAccessor MEM_ACCESS_BE = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? MEM_ACCESS : MemoryAccessor.getMemoryAccessor(ByteOrder.BIG_ENDIAN);

    /**
     * Get the offset of member to direct parent.
     *
     * @param member the direct member of parent.
     * @return the offset om menber in its parent.
     */
    public static long offsetof(OpaqueMemory parent, OpaqueMemory member) {
        final long offset = member.memorySegment.address().toRawLongValue() - parent.memorySegment.address().toRawLongValue();
        if (offset < 0) {
            throw new IndexOutOfBoundsException("member start outside of parent");
        } else if (offset + member.sizeof() < parent.sizeof()) {
            return offset;
        } else {
            throw new IndexOutOfBoundsException("member end outside of parent");
        }
    }

    @Override
    public Addressable toAddressable() {
        return memorySegment;
    }

    /**
     * Needed for calculating baseaddress of onTheFly
     * <pre> {@code
     *  int8_t data0;
     *  struct onTheFly {
     *   int64_t first
     *  };
     * }</pre>
     *
     * @param mem the mem to put datat0 and onTheFly
     * @param structAlignment the alignment of onTheFly here ist will be 8 byte
     * from int64_t
     * @param startOffset the offset in mem where you intend to place onTheFly
     * @return the aligned offset
     */
    public static long calcOffsetForAlignment(final OpaqueMemory mem, final Alignment structAlignment, final long startOffset) {
        final long baseAddress = mem.memorySegment.address().toRawLongValue();
        return structAlignment.doAlignment(baseAddress + startOffset) - baseAddress;
    }

    protected final MemorySegment memorySegment;

    /**
     * test if adresses are the same. If either nativeAddress or om is null and
     * the other has a address of 0 it is considered as the same address.
     *
     * @param address
     * @param om
     * @return
     */
    public static boolean isSameAddress(MemoryAddress address, OpaqueMemory om) {
        if (address == null) {
            return om == null ? true : om.memorySegment.address() == MemoryAddress.NULL;
        } else {
            if (om == null) {
                return address.equals(MemoryAddress.NULL);
            } else {
                return Objects.equals(address, om.memorySegment.address());
            }
        }
    }

    /**
     *
     * if we will fit exact in the provided memorySegment just take it otherwise
     * take a new slice out of the proovided memorySegment.
     *
     * @param memorySegment the memory to use
     * @param offset
     * @param sizeInBytes
     */
    public OpaqueMemory(MemorySegment memorySegment, long offset, long sizeInBytes) {
        if ((offset == 0) && (sizeInBytes == memorySegment.byteSize())) {
            this.memorySegment = memorySegment;
        } else {
            this.memorySegment = memorySegment.asSlice(offset, sizeInBytes);
        }
    }

    public OpaqueMemory(OpaqueMemory mem, long offset, long sizeInBytes) {
        if ((offset == 0) && (sizeInBytes == mem.memorySegment.byteSize())) {
            this.memorySegment = mem.memorySegment;
        } else {
            this.memorySegment = mem.memorySegment.asSlice(offset, sizeInBytes);
        }
    }

    public OpaqueMemory(MemoryAddress baseAddress, ResourceScope rs, long sizeInBytes) {
        memorySegment = MemorySegment.ofAddress(baseAddress, sizeInBytes, rs);
    }

    @Deprecated //Use OpaqueMemory.sliceMemorySegment(mem, destOff, nbyte)
    public static void checkIndex(OpaqueMemory mem, long offset, long length) {
        if ((offset < 0)
                || (length < 0)
                || // We are very careful to avoid signed integer overflow,
                // the result of which is undefined in C.
                (mem.sizeof() - offset < length)) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void clear(OpaqueMemory mem) {
        memset(mem, (byte) 0);
    }

    public static void copy(byte[] src, int srcPos, OpaqueMemory dest, long destPos, int length) {
        MemorySegment.copy(src, srcPos, dest.memorySegment, ValueLayout.JAVA_BYTE, destPos, length);
    }

    public static void copy(OpaqueMemory src, long srcPos, byte[] dest, int destPos, int length) {
        MemorySegment.copy(src.memorySegment, ValueLayout.JAVA_BYTE, srcPos, dest, destPos, length);
    }

    public static void memset(final OpaqueMemory mem, byte c) {
        mem.memorySegment.fill(c);
    }

    public static byte getByte(final OpaqueMemory mem, long index) {
        return mem.memorySegment.get(ValueLayout.JAVA_BYTE, index);
    }

    public static void setByte(final OpaqueMemory mem, long index, byte value) {
        mem.memorySegment.set(ValueLayout.JAVA_BYTE, index, value);
    }

    public static byte[] toBytes(final OpaqueMemory mem, long pos, int size) {
        final byte[] result = new byte[size];
        copy(mem, pos, result, 0, size);
        return result;
    }

    public static byte[] toBytes(final OpaqueMemory mem) {
        final long size = mem.sizeof();
        if (size > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("size of mem is > Integer.MAX_VALUE");
        }
        final byte[] result = new byte[(int) size];
        copy(mem, 0, result, 0, (int) size);
        return result;
    }

    public final static MemorySegment getMemorySegment(OpaqueMemory mem) {
        return mem.memorySegment;
    }

    @Override
    public int hashCode() {
        long hash = 5;
        hash = 37 * hash + this.memorySegment.address().toRawLongValue();
        hash = 37 * hash + this.sizeof();
        return (int) (hash ^ (hash >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof OpaqueMemory other) {
            if (Objects.equals(this.memorySegment.address(), other.memorySegment.address())) {
                return (this.sizeof() == other.sizeof());
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException("Unknown class:  " + obj);
        }
    }

    @Override
    public boolean is_NULL() {
        return memorySegment.address() == MemoryAddress.NULL;
    }

    @Override
    public boolean is_Not_NULL() {
        return memorySegment.address() != MemoryAddress.NULL;
    }

    @Override
    public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        printMemory(sb, this, true);
    }

    @Override
    public String nativeToString() {
        StringBuilder sb = new StringBuilder();
        try {
            nativeToString(sb, "", "");
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return sb.toString();
    }

    @Override
    public String nativeToHexString() {
        if (sizeof() > Integer.MAX_VALUE / 2) {
            throw new UnsupportedOperationException("memory block is too big!");
        } else {
            if (sizeof() < Integer.MAX_VALUE) {
                StringBuilder sb = new StringBuilder((int) sizeof() * 2);
                for (int i = 0; i < (int) sizeof(); i++) {
                    sb.append(String.format("%02x", OpaqueMemory.getByte(this, i)));
                }
                return sb.toString();
            } else {
                throw new RuntimeException("sizeInBytes too big: " + sizeof());
            }
        }
    }

    public final static String printMemory(final OpaqueMemory mem, final boolean printAddress) {
        StringBuilder sb = new StringBuilder();
        try {
            printMemory(sb, mem, printAddress);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
        return sb.toString();
    }

    public static void printMemory(Appendable sb, final OpaqueMemory mem, final boolean printAddress) throws IOException {
        final StringBuilder ascii = new StringBuilder();
        final long SIZE_IN_BYTES = mem.sizeof();
        final long BASE_ADDRESS = mem.memorySegment.address().toRawLongValue();
        final int BLOCK_SIZE = 16;
        final int BLOCK_REMINDER = (int) (SIZE_IN_BYTES % BLOCK_SIZE);
        final long BLOCK_COUNT = SIZE_IN_BYTES / BLOCK_SIZE + (BLOCK_REMINDER == 0 ? 0 : 1);
        byte[] block = new byte[BLOCK_SIZE];
        for (long i = 0; i < BLOCK_COUNT; i++) {
            if (i == BLOCK_COUNT - 1) {
                Arrays.fill(block, (byte) 0);
                copy(mem, i * BLOCK_SIZE, block, 0, BLOCK_REMINDER == 0 ? BLOCK_SIZE : BLOCK_REMINDER);
            } else {
                copy(mem, i * BLOCK_SIZE, block, 0, BLOCK_SIZE);
            }
            if (printAddress) {
                sb.append(JnhwFormater.formatAddress(BASE_ADDRESS + BLOCK_SIZE * i)).append(": ");
            }
            for (int j = 0; j < BLOCK_SIZE; j++) {
                ascii.append((char) block[j]);
                switch (j) {
                    case 4:
                    case 12:
                        if (j < SIZE_IN_BYTES) {
                            sb.append(String.format(" %02x", block[j]));
                        } else {
                            sb.append("   ");
                        }
                        break;
                    case 8:
                        if (j < SIZE_IN_BYTES) {
                            sb.append(String.format("  %02x", block[j]));
                        } else {
                            sb.append("    ");
                        }
                        break;
                    default:
                        if (j < SIZE_IN_BYTES) {
                            sb.append(String.format("%02x", block[j]));
                        } else {
                            sb.append("  ");
                        }
                }
            }
            sb.append(" | ");
            sb.append(ascii);
            if (i != BLOCK_COUNT - 1) {
                ascii.delete(0, ascii.length());
                sb.append('\n');
            }
        }
    }

    @Override
    final public String toString() {
        return String.format("{baseAddress : %s, sizeof : %d}", JnhwFormater.formatAddress(memorySegment.address().toRawLongValue()), sizeof());
    }

}
