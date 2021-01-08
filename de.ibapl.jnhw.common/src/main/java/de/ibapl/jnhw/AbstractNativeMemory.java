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
    private static native long malloc(long sizeInBytes) throws NativeErrorException;
    private static native long calloc(int elements, int elementSizeInBytes) throws NativeErrorException;
    private static native long calloc(long elements, long elementSizeInBytes) throws NativeErrorException;

    
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
     * On 32 bit systems only uint32_t sizes are possible.
     * 
     * @param sizeInBytes
     * @param clearMem
     */
    public AbstractNativeMemory(long sizeInBytes, boolean clearMem) {
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
     * @param nelem
     * @param elsize
     * @param clearMem
     */
    public AbstractNativeMemory(int nelem, int elsize, boolean clearMem) {
        if (nelem < 0) {
            throw new IllegalArgumentException("nelem < 0");
        }
        if (elsize < 0) {
            throw new IllegalArgumentException("elsize < 0");
        }
        int sizeInBytes = elsize * nelem;
        try {
            if (clearMem) {
                baseAddress = calloc(nelem, elsize);
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
     * On 32 bit systems only uint32_t sizes are possible.
     * 
     * @param nelem
     * @param elsize
     * @param clearMem
     */
    public AbstractNativeMemory(long nelem, long elsize, boolean clearMem) {
        if (nelem < 0) {
            throw new IllegalArgumentException("nelem < 0");
        }
        if (elsize < 0) {
            throw new IllegalArgumentException("elsize < 0");
        }
        long sizeInBytes = elsize * nelem;
        try {
            if (clearMem) {
                baseAddress = calloc(nelem, elsize);
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
    public AbstractNativeMemory(AbstractNativeMemory owner, long offset) {
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
    
    public static native int sizeOfS_i8();
    
    public static native int sizeOfS_s2xi8();
    
    public static native int sizeOfS_3xi8();
    
    public static native int sizeOfS_si8_s3xi8();
            
    public static native int sizeOfS_s3xi8_si8();
            
    public static native int sizeOfS_i8_i16();

    public static native int sizeOfS_i8_i32();

    public static native int sizeOfS_i8_i64();

    public static native int sizeOfS_i16_i8();

    public static native int sizeOfS_i32_i8();

    public static native int sizeOfS_i64_i8();
    
    public static native int offsetOfS_s2xi8__1_si8();

    public static native int offsetOfS_si8_s3xi8__1_s3xi8();
    
    public static native int offsetOfS_s3xi8_si8__1_si8();
    
    public static native int offsetOfS_i8_i16__1_i16();

    public static native int offsetOfS_i8_i32__1_i32();

    public static native int offsetOfS_i8_i64__1_i64();

    public static native int offsetOfS_i16_i8__1_i8();

    public static native int offsetOfS_i32_i8__1_i8();

    public static native int offsetOfS_i64_i8__1_i8();
    
    public static native int allignOfI8();
    
    public static native int allignOfI16();
    
    public static native int allignOfI32();
    
    public static native int allignOfI64();
}
