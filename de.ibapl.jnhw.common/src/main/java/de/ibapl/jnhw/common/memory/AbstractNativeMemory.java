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

import de.ibapl.jnhw.common.annotation.uintptr_t;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import java.lang.ref.Cleaner;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 * @TODO how to reallocate mem???
 */
public abstract class AbstractNativeMemory {

    public final static long NULL = 0L;

    public static <T extends AbstractNativeMemory> NativeAddressHolder<T> toNativeAddressHolder(T value) {
        return NativeAddressHolder.ofUintptr_t(((AbstractNativeMemory) value).baseAddress);
    }

    public static enum SetMem {
        DO_NOT_SET(false, (byte) 0),
        TO_0x00(false, (byte) 0x00),
        FORCE_0x00(true, (byte) 0x00),
        /**
         *
         * 0b10101010
         */
        TO_0x55(false, (byte) 0x55),
        FORCE_0x55(true, (byte) 0x55),
        /**
         * 0b01010101
         */
        TO_0xAA(false, (byte) 0xAA),
        FORCE_0xAA(true, (byte) 0xAA),
        TO_0x0F(false, (byte) 0x0F),
        FORCE_0xF0(true, (byte) 0xF0),
        TO_0xFF(false, (byte) 0xFF),
        FORCE_0xFF(true, (byte) 0xFF);

        private SetMem(boolean force, byte value) {
            this.value = value;
            this.force = force;
        }

        public final byte value;
        public final boolean force;
    }

    protected final static Cleaner CLEANER = Cleaner.create();

    protected final static Logger LOG = Logger.getLogger("de.ibapl.libjnhw-common");

    public final static String MEM_ACCESS_PROPERTY = "de.ibapl.jnhw.common.memory.MEMORY_ACCESSSOR";
    protected final static MemoryAccessor MEM_ACCESS = getMemoryAccessor();

    /**
     * Get the size in bytes if instance. Wrap instance.getSizeInBytes() - so
     * the namespace of instanes of AbstractNativeMemory is not pollutet.
     *
     * @param instance the instance.
     * @return the instance.getSizeInBytes() .
     */
    public final static long getSizeInBytes(final AbstractNativeMemory instance) {
        return instance.getSizeInBytes();
    }

    @uintptr_t
    public final static long toUintptr_t(final AbstractNativeMemory instance) {
        return instance.baseAddress;
    }

    @uintptr_t
    public final static long toUintptr_tOrNULL(final AbstractNativeMemory instance) {
        return (instance == null) ? AbstractNativeMemory.NULL : instance.baseAddress;
    }

    /**
     * Get the offset of member to direct parent.
     *
     * @param member the direct member of parent.
     * @return the offset om menber in its parent.
     */
    public static long offsetof(AbstractNativeMemory member) {
        return member.getOffset();
    }

    /**
     * Neede for calculating baseaddress of onTheFly
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
    public static long calcOffsetForAlignment(final AbstractNativeMemory mem, final Alignment structAlignment, final long startOffset) {
        return structAlignment.doAlignment(mem.baseAddress + startOffset) - mem.baseAddress;
    }

    private static UnsafeMemoryAccessor getUnsafeMemoryAccessor() {
        switch (NativeLibResolver.getSizeOfPointer()) {
            case _32_BIT:
                switch (NativeLibResolver.getSizeOfLong()) {
                    case _32_BIT:
                        LOG.info("Use sun.misc.Unsafe - 32bit for long and 32 bit for pointer access");
                        return new UnsafeMemoryAccessor_P32_L32();
                    case _64_BIT:
                        LOG.info("Use sun.misc.Unsafe - 64bit for long and 32 bit for pointer access");
                        return new UnsafeMemoryAccessor_P32_L64();
                    default:
                        throw new IllegalStateException("Unknow size of long: " + BaseDataType.__SIZE_OF_LONG);
                }
            case _64_BIT:
                switch (NativeLibResolver.getSizeOfLong()) {
                    case _32_BIT:
                        LOG.info("Use sun.misc.Unsafe - 32bit for long and 64 bit for pointer access");
                        return new UnsafeMemoryAccessor_P64_L32();
                    case _64_BIT:
                        LOG.info("Use sun.misc.Unsafe - 64bit for long and 64 bit for pointer access");
                        return new UnsafeMemoryAccessor_P64_L64();
                    default:
                        throw new IllegalStateException("Unknow size of long: " + BaseDataType.__SIZE_OF_LONG);
                }
            default:
                throw new IllegalStateException("Unknow size of pointer: " + BaseDataType.__SIZE_OF_POINTER);
        }
    }

    private static MemoryAccessor getMemoryAccessor() {
        String memAccProperty = System.getProperty(MEM_ACCESS_PROPERTY);
        if (memAccProperty == null) {
            LOG.info("Use default MEM_ACCESS");
            try {
                return getUnsafeMemoryAccessor();
            } catch (Exception ex) {
                if (ex instanceof IllegalStateException) {
                    throw ex;
                } else {
                    LOG.info("Fall back to JNHW for MEM_ACCESS");
                    return new JnhwMemoryAccessor();
                }
            }
        }
        switch (memAccProperty) {
            case "Unsafe":
                return getUnsafeMemoryAccessor();
            case "Jnhw":
                LOG.info("Force JNHW for MEM_ACCESS");
                return new JnhwMemoryAccessor();
            default:
                String msg = "Unknown value \"" + memAccProperty + "\" for system property: \"" + MEM_ACCESS_PROPERTY + "\"";
                LOG.severe(msg);
                throw new RuntimeException(msg);
        }
    }

    @uintptr_t
    protected final long baseAddress;

    public final AbstractNativeMemory parent;

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
        parent = null;
    }

    /**
     * Creates a new memory which will be freed at the end of life.
     *
     * @param sizeInBytes
     */
    public AbstractNativeMemory(AbstractNativeMemory parent, long offset, long sizeInBytes) {
        if (parent == null) {
            if (offset != 0) {
                throw new IllegalArgumentException("offset must == 0");
            }
            this.baseAddress = MEM_ACCESS.allocateMemory(this, sizeInBytes);
            this.parent = this;
        } else {
            if (offset < 0) {
                throw new IllegalArgumentException("start outside (before) mem area");
            }
            this.baseAddress = parent.baseAddress + offset;
            this.parent = parent;

        }
    }

    /**
     * calc the offset
     *
     * @return
     */
    protected final long getOffset() {
        if (parent == null) {
            throw new RuntimeException("memory Owner is null");
        }
        return baseAddress - parent.baseAddress;
    }

    protected abstract long getSizeInBytes();
}
