/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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
package de.ibapl.jnhw;

/**
 *
 * The base class for any chunk (i.e. pointer to or structs) of native memory.
 * The run method in MemoryCleaner will clean up the allocated memory after
 * finalizing this instance - if this instance owns the memory.
 *
 * @author aploese
 */
public class OpaqueMemory32 extends AbstractNativeMemory {

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
    public OpaqueMemory32(int sizeInBytes, boolean clearMem) {
        super(sizeInBytes, clearMem);
        this.sizeInBytes = sizeInBytes;
    }

    /**
     *
     * @param elements
     * @param elementSizeInBytes
     * @param clearMem
     */
    public OpaqueMemory32(int elements, int elementSizeInBytes, boolean clearMem) {
        super(elements, elementSizeInBytes, clearMem);
        this.sizeInBytes = elementSizeInBytes * elements;
    }

    /**
     *
     * @param owner
     * @param offset
     * @param sizeInBytes
     */
    public OpaqueMemory32(OpaqueMemory32 owner, int offset, int sizeInBytes) {
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

    /**
     *
     * @param owner
     * @param offset
     * @param sizeInBytes
     */
    public OpaqueMemory32(OpaqueMemory64 owner, long offset, int sizeInBytes) throws NoSuchNativeMethodException {
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

    public static void nativeToString(OpaqueMemory32 mem, StringBuilder sb) {
        sb.append(String.format("baseAddress : 0x%08x, sizeInBytes : %d, memoryOwner : ", mem.baseAddress, mem.sizeInBytes));
        if (mem.memoryOwner == mem) {
             sb.append("this");
        } else if (mem.memoryOwner == null) {
            sb.append("null");
        } else {
            sb.append(mem.memoryOwner.toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        nativeToString(this, sb);
        sb.append("}");
        return sb.toString();
    }

}
