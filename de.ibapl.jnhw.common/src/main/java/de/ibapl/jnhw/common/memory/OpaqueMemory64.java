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
import de.ibapl.jnhw.common.exception.NoSuchNativeMethodException;
import de.ibapl.jnhw.common.util.JnhwFormater;

/**
 *
 * The base class for any chunk (i.e. pointer to or structs) of native memory.
 * The run method in MemoryCleaner will clean up the allocated memory after
 * finalizing this instance - if this instance owns the memory.
 *
 * @author aploese
 */
public abstract class OpaqueMemory64 extends AbstractNativeMemory implements  Native {

    public static void clear(OpaqueMemory64 mem) {
        memset(mem, (byte) 0);
    }
    
    public static native void copy(byte[] src, int srcPos, OpaqueMemory64 dest, long destPos, int length);

    public static native void copy(OpaqueMemory64 src, long srcPos, byte[] dest, int destPos, int length);

    public static native void memset(OpaqueMemory64 mem, byte c);

    public static native byte getByte(OpaqueMemory64 opaqueMemory, long index);

    public static native void setByte(OpaqueMemory64 opaqueMemory, long index, byte value);

    public static byte[] toBytes(OpaqueMemory64 mem, long pos, int size) {
        final byte[] result = new byte[size];
        copy(mem, pos, result, 0, size);
        return result;
    }

    public final long sizeInBytes;

    /**
     * Create a static memory slice which will NOT be freed - its static.
     *
     * @param addressHolder the base address.
     * @param sizeInBytes the size.
     */
    protected OpaqueMemory64(NativeAddressHolder addressHolder, long sizeInBytes) {
        super(addressHolder);
        this.sizeInBytes = sizeInBytes;
    }

    /**
     * Creates a new memory which will be freed at the end of life.
     *
     * @param sizeInBytes
     * @param clearMem
     */
    protected OpaqueMemory64(long sizeInBytes, boolean clearMem) throws NoSuchNativeMethodException {
        super(sizeInBytes, clearMem);
        this.sizeInBytes = sizeInBytes;
    }

    /**
     *
     * @param elements
     * @param elementSizeInBytes
     * @param clearMem
     */
    protected OpaqueMemory64(long elements, long elementSizeInBytes, boolean clearMem) throws NoSuchNativeMethodException  {
        super(elements, elementSizeInBytes, clearMem);
        this.sizeInBytes = elementSizeInBytes * elements;
    }

    /**
     *
     * @param owner
     * @param offset
     * @param sizeInBytes
     */
    protected OpaqueMemory64(OpaqueMemory64 owner, long offset, long sizeInBytes) {
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
        long hash = 5;
        hash = 37 * hash + this.baseAddress;
        hash = 37 * hash + this.sizeInBytes;
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

    public String nativeToString() {
        return printMemory(this, true);
    }
    
    public static String printMemory(final OpaqueMemory64 mem,final  boolean printAddress) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ascii = new StringBuilder();
        final int BLOCK_SIZE = 16;
        final int BLOCK_REMINDER = (int)(mem.sizeInBytes % BLOCK_SIZE);
        final long BLOCK_COUNT = mem.sizeInBytes / BLOCK_SIZE + (BLOCK_REMINDER == 0 ? 0 : 1);
        byte[] block = new byte[BLOCK_SIZE];
        for (long i = 0; i < BLOCK_COUNT; i++) {
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
