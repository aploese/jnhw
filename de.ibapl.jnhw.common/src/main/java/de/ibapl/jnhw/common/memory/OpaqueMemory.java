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
package de.ibapl.jnhw.common.memory;

import de.ibapl.jnhw.common.datatypes.Native;
import de.ibapl.jnhw.common.datatypes.Pointer;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.util.JnhwFormater;
import java.io.IOException;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentScope;
import java.lang.foreign.ValueLayout;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 *
 * The base class for any chunk (i.e.pointer to or structs) of native memory.
 * The run method in MemoryCleaner will clean up the allocated memory after
 * finalizing this instance - if this instance owns the memory. The NULL address
 * for the backing MemorySegment is not allowed a NullPointerException will be
 * thrown in the constructor.
 *
 * @author aploese
 */
public abstract class OpaqueMemory implements Native, Pointer {

    protected final static Logger LOG = Logger.getLogger("de.ibapl.libjnhw-common");

    /**
     * Memory accessor with the natural byte order and natural alignemnt
     */
    protected final static MemoryAccessor MEM_ACCESS = MemoryAccessor.getMemoryAccessor(ByteOrder.nativeOrder());

    public static MemorySegment sliceMemorySegment(OpaqueMemory mem, long offset, long newSize) {
        return mem.memorySegment.asSlice(offset, newSize);
    }

    /**
     * Get the offset of member to direct parent.
     *
     * @param parent
     * @param member the direct member of parent.
     * @return the offset om menber in its parent.
     */
    public static long offsetof(OpaqueMemory parent, OpaqueMemory member) {
        final long offset = member.toAddress() - parent.toAddress();
        if (offset < 0) {
            throw new IndexOutOfBoundsException("member start outside of parent");
        } else if (offset + member.sizeof() < parent.sizeof()) {
            return offset;
        } else {
            throw new IndexOutOfBoundsException("member end outside of parent");
        }
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
        final long baseAddress = mem.toAddress();
        return structAlignment.doAlignment(baseAddress + startOffset) - baseAddress;
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
        final long BASE_ADDRESS = mem.toAddress();
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
                sb.append(JnhwFormater.formatAddress(MemorySegment.ofAddress(BASE_ADDRESS + BLOCK_SIZE * i))).append(": ");
            }
            for (int j = 0; j < BLOCK_SIZE; j++) {
                ascii.append((char) (block[j] & 0x00ff));
                switch (j) {
                    case 4, 12 -> {
                        if (j < SIZE_IN_BYTES) {
                            sb.append(String.format(" %02x", block[j]));
                        } else {
                            sb.append("   ");
                        }
                    }
                    case 8 -> {
                        if (j < SIZE_IN_BYTES) {
                            sb.append(String.format("  %02x", block[j]));
                        } else {
                            sb.append("    ");
                        }
                    }
                    default -> {
                        if (j < SIZE_IN_BYTES) {
                            sb.append(String.format("%02x", block[j]));
                        } else {
                            sb.append("  ");
                        }
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
    protected final MemorySegment memorySegment;

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
        if (memorySegment.address() == 0L) {
            throw new NullPointerException("memorySegemnt points to NULL!");
        }
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

    public OpaqueMemory(long baseAddress, SegmentScope ms, long sizeInBytes) {
        if (baseAddress == 0L) {
            throw new NullPointerException("baseAddress points to NULL!");
        }
        memorySegment = MemorySegment.ofAddress(baseAddress, sizeInBytes, ms);
    }

    public final long sizeof() {
        return memorySegment.byteSize();
    }

    @Override
    public final MemorySegment toMemorySegment() {
        return memorySegment;
    }

    @Override
    public final long toAddress() {
        return memorySegment.address();
    }

    @Override
    public int hashCode() {
        long hash = 5;
        hash = 37 * hash + this.toAddress();
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
            if (this.toAddress() == other.toAddress()) {
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
        return memorySegment.address() == 0L;
    }

    @Override
    public boolean is_Not_NULL() {
        return memorySegment.address() != 0L;
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

    @Override
    final public String toString() {
        return String.format("{baseAddress : %s, sizeof : %d}", JnhwFormater.formatAddress(memorySegment), sizeof());
    }

    @FunctionalInterface
    public static interface OpaqueMemoryProducer<T extends OpaqueMemory, P extends OpaqueMemory> {

        /**
         *
         * @param address the address to use.
         * @param ms the SegmentScope to use
         * @param parent the parent of the result with given address.
         * @return a cached or new OpaqueMemory.
         */
        T produce(MemorySegment address, SegmentScope ms, P parent);

    }

}
