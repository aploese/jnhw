/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.ibapl.jnhw;

import java.util.logging.Level;

/**
 *
 * @author aploese
 */
public class OpaqueMemory extends LibJnhwLoader {
    
    public final long baseAddress;
    public final int sizeInBytes;
    public final OpaqueMemory memoryOwner;

    //get value of define from errno.
    public static final native int ENOMEM();

    private static final native long malloc(int sizeInBytes) throws NativeErrorException;

    private static final native long calloc(int elements, int sizeInBytes) throws NativeErrorException;

    private static final native void free(long baseAddress);
    
    private static native void memset(long baseAddress, byte c, int size);
    
    public static final void clear(OpaqueMemory mem) {
        memset(mem.baseAddress, (byte)0, mem.sizeInBytes);
    }

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
    }

    public OpaqueMemory(int elements, int sizeInBytes, boolean clearMem) {
        this.sizeInBytes = sizeInBytes * elements;
        try {
            if (clearMem) {
                baseAddress = calloc(elements, sizeInBytes);
            } else {
                baseAddress = malloc(sizeInBytes * elements);
            }
        } catch (NativeErrorException nee) {
            if (nee.errno == ENOMEM()) {
                throw new OutOfMemoryError("Can't allocate " + sizeInBytes * elements + " bytes ENOMEM");
            } else {
                throw new RuntimeException("Can't allocate " + sizeInBytes * elements + " bytes ");
            }
        }
        memoryOwner = this;
    }

    public OpaqueMemory(OpaqueMemory owner, long baseAddress, int sizeInBytes) {
        final long offset = baseAddress - owner.baseAddress;
        if (sizeInBytes < 0) {
            throw new IllegalArgumentException("negative size");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("start outside (before) mem area");
        }
        if (offset + sizeInBytes > owner.sizeInBytes) {
            throw new IllegalArgumentException("end will be outside (after)) of owner");
        }
        this.baseAddress = baseAddress;
        this.sizeInBytes = sizeInBytes;
        memoryOwner = owner;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            if (memoryOwner == this) {
                // LOG.log(Level.FINEST, String.format("Finalize: try free memory @0x%016x size: %d", baseAddress, sizeInBytes));
                free(baseAddress);
                // LOG.log(Level.FINEST, String.format("memory @0x%016x freed", baseAddress));
            } else {
                // LOG.log(Level.FINEST, String.format("Finalize: memory @0x%016x size: %d belongs to %s", baseAddress, sizeInBytes, memoryOwner));
            }
        } catch (Throwable t) {
            LibJnhwLoader.LOG.log(Level.SEVERE, String.format("Finalize: Memory Leak freeing memory @0x%016x size: %d failed", baseAddress, sizeInBytes), t);
        } finally {
            super.finalize();
        }
    }
    
}
