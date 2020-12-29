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

import java.lang.ref.Cleaner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 */
public class AbstractNativeMemory {

    /**
     * Make sure the native lib is loaded. Subclasses in common do not need to
     * call this again....
     */
    static {
        LibJnhwCommonLoader.touch();
    }
    
        static class MemoryCleaner implements Runnable {

        final long baseAddress;

        MemoryCleaner(final long baseAddress) {
            this.baseAddress = baseAddress;
        }

        private static native void free(long baseAddress);

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

    private static final Cleaner CLEANER = Cleaner.create();
    // get value of define from errno.
    public static final native int ENOMEM();


    protected final static Logger LOG = Logger.getLogger("de.ibapl.libjnhw");

    protected final long baseAddress;
    public final AbstractNativeMemory memoryOwner;
    private static native long malloc(int sizeInBytes) throws NativeErrorException;
    private static native long malloc(long sizeInBytes) throws NativeErrorException, NoSuchNativeMethodException;
    private static native long calloc(int elements, int sizeInBytes) throws NativeErrorException;
    private static native long calloc(long elements, long sizeInBytes) throws NativeErrorException, NoSuchNativeMethodException;

    
    /**
     * test if adresses are the same. If either nativeAddress or om is null and
     * the other has a address of 0 it is considered as the same address.
     *
     * @param nativeAddress
     * @param om
     * @return
     */
    public static boolean isSameAddress(NativeAddressHolder nativeAddress, AbstractNativeMemory om) {
        if (nativeAddress == null) {
            return om == null ? true : om.baseAddress == 0L;
        } else {
            if (om == null) {
                return nativeAddress.isNULL();
            } else {
                return nativeAddress.address == om.baseAddress;
            }
        }
    }


    /**
     * Create a static memory slice which will NOT be freed - its static.
     *
     * @param addressHolder the base address.
     */
    protected AbstractNativeMemory(NativeAddressHolder addressHolder) {
        this.baseAddress = addressHolder.address;
        memoryOwner = null;
    }
    
    /**
     * Creates a new memory which will be freed at the end of life.
     *
     * @param sizeInBytes
     * @param clearMem
     */
    public AbstractNativeMemory(int sizeInBytes, boolean clearMem) {
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
     * Creates a new memory which will be freed at the end of life.
     *
     * @param sizeInBytes
     * @param clearMem
     */
    public AbstractNativeMemory(long sizeInBytes, boolean clearMem) throws NoSuchNativeMethodException {
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
    public AbstractNativeMemory(int elements, int elementSizeInBytes, boolean clearMem) {
        if (elements < 0) {
            throw new IllegalArgumentException("elements < 0");
        }
        if (elementSizeInBytes < 0) {
            throw new IllegalArgumentException("elementSizeInBytes < 0");
        }
        int sizeInBytes = elementSizeInBytes * elements;
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
     * @param elements
     * @param elementSizeInBytes
     * @param clearMem
     */
    public AbstractNativeMemory(long elements, long elementSizeInBytes, boolean clearMem) throws NoSuchNativeMethodException {
        if (elements < 0) {
            throw new IllegalArgumentException("elements < 0");
        }
        if (elementSizeInBytes < 0) {
            throw new IllegalArgumentException("elementSizeInBytes < 0");
        }
        long sizeInBytes = elementSizeInBytes * elements;
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
     * @param owner
     * @param offset
     */
    public AbstractNativeMemory(AbstractNativeMemory owner, long offset) throws NoSuchNativeMethodException {
        this.baseAddress = owner.baseAddress + offset;
        this.memoryOwner = owner;
    }

    /**
     * @param owner
     * @param offset
     */
    public AbstractNativeMemory(AbstractNativeMemory owner, int offset) {
        this.baseAddress = owner.baseAddress + offset;
        this.memoryOwner = owner;
    }
}
