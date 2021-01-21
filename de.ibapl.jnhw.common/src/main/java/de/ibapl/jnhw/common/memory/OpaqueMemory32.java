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

import de.ibapl.jnhw.common.datatypes.Native;
import de.ibapl.jnhw.common.exceptions.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.JnhwFormater;

/**
 *
 * The base class for any chunk (i.e. pointer to or structs) of native memory.
 * The run method in MemoryCleaner will clean up the allocated memory after
 * finalizing this instance - if this instance owns the memory.
 *
 * @author aploese
 */
public abstract class OpaqueMemory32 extends AbstractNativeMemory implements Native {

    /**
     * Get the offset of member to direct parent.
     *
     * @param parent the direct parent of member.
     * @param member the direct member of parent.
     * @return the offset om menber in parent.
     */
    public static int offsetof(OpaqueMemory32 parent, OpaqueMemory32 member) {
        if (member.memoryOwner != parent) {
            throw new RuntimeException("member is no direct member of parent!");
        }
        return (int) (member.baseAddress - parent.baseAddress);
    }

    @FunctionalInterface
    public static interface OpaqueMemory32Producer<T extends OpaqueMemory32, P extends AbstractNativeMemory> {

        /**
         *
         * @param address the address to use.
         * @param parent the parent of the result with given address.
         * @return a cached or new OpaqueMemory.
         */
        T produce(NativeAddressHolder address, P parent);

    }

    public static void clear(OpaqueMemory32 mem) {
        memset(mem, (byte) 0);
    }

    public static native void copy(byte[] src, int srcPos, OpaqueMemory32 dest, int destPos, int length);

    public static native void copy(OpaqueMemory32 src, int srcPos, byte[] dest, int destPos, int length);

    public static native void memset(OpaqueMemory32 mem, byte c);

    public static native byte getByte(OpaqueMemory32 opaqueMemory, int index);

    public static native void setByte(OpaqueMemory32 opaqueMemory, int index, byte value);

    public static byte[] toBytes(OpaqueMemory32 mem) {
        final byte[] result = new byte[mem.sizeInBytes];
        copy(mem, 0, result, 0, mem.sizeInBytes);
        return result;
    }

    public static int calcNextOffset(OpaqueMemory32 parent, OpaqueMemory32 prev, int alignAt) {
        if (parent != prev.memoryOwner) {
            throw new RuntimeException("Parent is not prev.memoryOwner");
        }
        final int reminder = (int) Long.remainderUnsigned(prev.baseAddress + prev.sizeInBytes, alignAt);
        if (reminder == 0) {
            return (int) (prev.baseAddress - parent.baseAddress) + prev.sizeInBytes;
        } else {
            return (int) (prev.baseAddress - parent.baseAddress) + prev.sizeInBytes + alignAt - reminder;
        }
    }

    public final int sizeInBytes;

    /**
     * Create a static memory slice which will NOT be freed - its static.
     *
     * @param addressHolder the base address.
     * @param sizeInBytes the size.
     */
    protected OpaqueMemory32(NativeAddressHolder addressHolder, int sizeInBytes) {
        super(addressHolder);
        this.sizeInBytes = sizeInBytes;
    }

    /**
     * Creates a new memory which will be freed at the end of life.
     *
     * @param sizeInBytes
     * @param clearMem
     */
    protected OpaqueMemory32(int sizeInBytes, boolean clearMem) {
        super(sizeInBytes, clearMem);
        this.sizeInBytes = sizeInBytes;
    }

    /**
     *
     * @param elements
     * @param elementSizeInBytes
     * @param clearMem
     */
    protected OpaqueMemory32(int elements, int elementSizeInBytes, boolean clearMem) {
        super(elements, elementSizeInBytes, clearMem);
        this.sizeInBytes = elementSizeInBytes * elements;
    }

    /**
     *
     * @param elements
     * @param elementSizeInBytes
     */
    protected OpaqueMemory32(OpaqueMemory32 owner, int offset, int elements, int elementSizeInBytes) {
        super(owner, offset);
        if (elements < 0) {
            throw new IllegalArgumentException("negative elements");
        }
        if (elementSizeInBytes < 0) {
            throw new IllegalArgumentException("negative elementSizeInBytes");
        }
        this.sizeInBytes = elementSizeInBytes * elements;
        if (offset + this.sizeInBytes > owner.sizeInBytes) {
            throw new IllegalArgumentException("end will be outside (after)) of owner");
        }
    }

    /**
     *
     * @param elements
     * @param elementSizeInBytes
     * @param clearMem
     */
    protected OpaqueMemory32(OpaqueMemory64 owner, long offset, int elements, int elementSizeInBytes) {
        super(owner, offset);
        if (elements < 0) {
            throw new IllegalArgumentException("negative elements");
        }
        if (elementSizeInBytes < 0) {
            throw new IllegalArgumentException("negative elementSizeInBytes");
        }
        this.sizeInBytes = elementSizeInBytes * elements;
        if (offset + this.sizeInBytes > owner.sizeInBytes) {
            throw new IllegalArgumentException("end will be outside (after)) of owner");
        }
    }

    /**
     *
     * @param owner
     * @param offset
     * @param sizeInBytes
     */
    protected OpaqueMemory32(OpaqueMemory32 owner, int offset, int sizeInBytes) {
        super(owner, offset);
        if (sizeInBytes < 0) {
            throw new IllegalArgumentException("negative size");
        }
        if (offset + sizeInBytes > owner.sizeInBytes) {
            throw new IllegalArgumentException(String.format("End will be outside (after)) of owner; owner.sizeInBytes=%d, offset=%d, sizeInBytes=%d", owner.sizeInBytes, offset, sizeInBytes));
        }
        this.sizeInBytes = sizeInBytes;
    }

    /**
     *
     * @param owner
     * @param offset
     * @param sizeInBytes
     */
    protected OpaqueMemory32(OpaqueMemory64 owner, long offset, int sizeInBytes) throws NoSuchNativeMethodException {
        super(owner, offset);
        if (sizeInBytes < 0) {
            throw new IllegalArgumentException("negative size");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("start outside (before) mem area");
        }
        if (offset + sizeInBytes > owner.sizeInBytes) {
            throw new IllegalArgumentException("end will be outside (after)) of owner");
        }
        this.sizeInBytes = sizeInBytes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.baseAddress ^ (this.baseAddress >>> 32));
        hash = 37 * hash + this.sizeInBytes;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof OpaqueMemory64) {
            final OpaqueMemory64 other = (OpaqueMemory64) obj;
            if (this.baseAddress != other.baseAddress) {
                return false;
            }
            return this.sizeInBytes == other.sizeInBytes;
        } else if (obj instanceof OpaqueMemory32) {
            final OpaqueMemory32 other = (OpaqueMemory32) obj;
            if (this.baseAddress != other.baseAddress) {
                return false;
            }
            return this.sizeInBytes == other.sizeInBytes;
        }
        return false;
    }

    @Override
    public String nativeToString() {
        return printMemory(this, true);
    }

    public static String printMemory(final OpaqueMemory32 mem, final boolean printAddress) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ascii = new StringBuilder();
        final int BLOCK_SIZE = 16;
        final int BLOCK_REMINDER = mem.sizeInBytes % BLOCK_SIZE;
        final int BLOCK_COUNT = mem.sizeInBytes / BLOCK_SIZE + (BLOCK_REMINDER == 0 ? 0 : 1);
        byte[] block = new byte[BLOCK_SIZE];
        for (int i = 0; i < BLOCK_COUNT; i++) {
            if (i == BLOCK_COUNT - 1) {
                copy(mem, mem.sizeInBytes - BLOCK_REMINDER, block, 0, BLOCK_REMINDER);
            } else {
                copy(mem, i * BLOCK_SIZE, block, 0, BLOCK_SIZE);
            }
            if (printAddress) {
                sb.append(JnhwFormater.formatAddress(mem.baseAddress + BLOCK_SIZE * i)).append(": ");
            }
            for (int j = 0; j < BLOCK_SIZE; j++) {
                ascii.append((char) block[j]);
                switch (j) {
                    case 4:
                    case 12:
                        if (j < mem.sizeInBytes) {
                            sb.append(String.format(" %02x", block[j]));
                        } else {
                            sb.append("   ");
                        }
                        break;
                    case 8:
                        if (j < mem.sizeInBytes) {
                            sb.append(String.format("  %02x", block[j]));
                        } else {
                            sb.append("    ");
                        }
                        break;
                    default:
                        if (j < mem.sizeInBytes) {
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
        return sb.toString();
    }

    @Override
    final public String toString() {
        return String.format("{baseAddress : %s, sizeInBytes : %d, memoryOwner : %s}", JnhwFormater.formatAddress(baseAddress), sizeInBytes, memoryOwner == this ? "this" : memoryOwner);
    }

}
