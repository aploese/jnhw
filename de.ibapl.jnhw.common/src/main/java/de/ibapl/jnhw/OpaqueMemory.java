/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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

import java.lang.ref.Cleaner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * The base class for any chunk (i.e. pointer to or structs) of native memory.
 * The run method in MemoryCleaner will clean up the allocated memory after
 * finalizing this instance - if this instance owns the memory.
 *
 * @author aploese
 */
public class OpaqueMemory {

    static boolean isSameAddress(long baseAddress, OpaqueMemory cachedElement) {
        if (cachedElement == null) {
            return baseAddress == 0L;
        } else {
            return cachedElement.baseAddress == baseAddress;
        }
    }

    @FunctionalInterface
    public static interface OpaqueMemoryProducer<T extends OpaqueMemory, P extends OpaqueMemory> {

        /**
         *
         * @param baseAddress
         * @param parent
         * @return
         */
        T produce(long baseAddress, P parent);

    }

    private static final Cleaner CLEANER = Cleaner.create();

    protected final static Logger LOG = Logger.getLogger("de.ibapl.libjnhw");

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwCommonLoader.touch();
    }

    // get value of define from errno.
    public static final native int ENOMEM();

    private static native long calloc(int elements, int sizeInBytes) throws NativeErrorException;

    public static void clear(OpaqueMemory mem) {
        memset(mem, (byte) 0);
    }

    public static native void copy(byte[] src, int srcPos, OpaqueMemory dest, int destPos, int length);

    public static native void copy(OpaqueMemory src, int srcPos, byte[] dest, int destPos, int length);

    private static native void free(long baseAddress);

    public static native byte getByte(OpaqueMemory opaqueMemory, int index);

    private static native long malloc(int sizeInBytes) throws NativeErrorException;

    public static native void memset(OpaqueMemory mem, byte c);

    public static native void setByte(OpaqueMemory opaqueMemory, int index, byte value);

    public static byte[] toBytes(OpaqueMemory mem) {
        final byte[] result = new byte[mem.sizeInBytes];
        copy(mem, 0, result, 0, mem.sizeInBytes);
        return result;
    }

    private final long baseAddress;
    public final OpaqueMemory memoryOwner;
    public final int sizeInBytes;

    /**
     * Create a static memory slice which will NOT be freed - its static.
     *
     * @param baseAddress the base Address.
     * @param sizeInBytes the size.
     */
    protected OpaqueMemory(long baseAddress, int sizeInBytes) {
        this.baseAddress = baseAddress;
        this.sizeInBytes = sizeInBytes;
        memoryOwner = null;
    }

    /**
     * Creates a new memory which will be freed at the end of life.
     *
     * @param sizeInBytes
     * @param clearMem
     */
    public OpaqueMemory(int sizeInBytes, boolean clearMem) {
        this.sizeInBytes = sizeInBytes;
        try {
            if (clearMem) {
                baseAddress = calloc(1, sizeInBytes);
            } else {
                baseAddress = malloc(sizeInBytes);
            }
        } catch (NativeErrorException nee) {
            if (nee.errno == ENOMEM()) {
                throw new OutOfMemoryError("Can't allocate " + sizeInBytes + " bytes ENOMEM");
            } else {
                throw new RuntimeException("Can't allocate " + sizeInBytes + " bytes ");
            }
        }
        memoryOwner = this;
        CLEANER.register(this, new MemoryCleaner(baseAddress));
    }

    /**
     *
     * @param elements
     * @param elementSizeInBytes
     * @param clearMem
     */
    public OpaqueMemory(int elements, int elementSizeInBytes, boolean clearMem) {
        this.sizeInBytes = elementSizeInBytes * elements;
        try {
            if (clearMem) {
                baseAddress = calloc(elements, elementSizeInBytes);
            } else {
                baseAddress = malloc(sizeInBytes);
            }
        } catch (NativeErrorException nee) {
            if (nee.errno == ENOMEM()) {
                throw new OutOfMemoryError("Can't allocate " + sizeInBytes + " bytes ENOMEM");
            } else {
                throw new RuntimeException("Can't allocate " + sizeInBytes + " bytes ");
            }
        }
        memoryOwner = this;
        CLEANER.register(this, new MemoryCleaner(baseAddress));
    }

    /**
     *
     * @param owner
     * @param offset
     * @param sizeInBytes
     */
    public OpaqueMemory(OpaqueMemory owner, int offset, int sizeInBytes) {
        if (sizeInBytes < 0) {
            throw new IllegalArgumentException("negative size");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("start outside (before) mem area");
        }
        if (offset + sizeInBytes > owner.sizeInBytes) {
            throw new IllegalArgumentException("end will be outside (after)) of owner");
        }
        this.baseAddress = owner.baseAddress + offset;
        this.sizeInBytes = sizeInBytes;
        memoryOwner = owner;
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
        if (obj instanceof OpaqueMemory) {
            final OpaqueMemory other = (OpaqueMemory) obj;
            if (this.baseAddress != other.baseAddress) {
                return false;
            }
            return this.sizeInBytes == other.sizeInBytes;
        }
        return false;
    }

    @Override
    public String toString() {
        if (memoryOwner == this) {
            return String.format("{baseAddress : 0x%08x, sizeInBytes : %d, memoryOwner : this}", baseAddress, sizeInBytes);
        } else {
            return String.format("{baseAddress : 0x%08x, sizeInBytes : %d, memoryOwner : %s}", baseAddress, sizeInBytes, memoryOwner);
        }
    }

    static class MemoryCleaner implements Runnable {

        final long baseAddress;

        MemoryCleaner(final long baseAddress) {
            this.baseAddress = baseAddress;
        }

        @Override
        public void run() {
            try {
                // LOG.log(Level.FINEST, String.format("Finalize: try free memory @0x%016x size:
                // %d", baseAddress, sizeInBytes));
                free(baseAddress);
                // LOG.log(Level.FINEST, String.format("memory @0x%016x freed", baseAddress));
            } catch (Throwable t) {
                LOG.log(Level.SEVERE,
                        String.format("Finalize: Memory Leak freeing memory @0x%016x failed", baseAddress), t);
            }

        }
    }

}
