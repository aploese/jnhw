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

import de.ibapl.jnhw.common.LibJnhwCommonLoader;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.util.JnhwFormater;
import java.nio.ByteBuffer;
import java.util.logging.Level;

/**
 *
 * @author aploese
 */
class JnhwMemoryAccessor implements MemoryAccessor {

    /**
     * Make sure the native lib is loaded. Subclasses in common do not need to
     * call this again....
     */
    static {
        LibJnhwCommonLoader.touch();
    }

    // get value of define from errno.
    private static final native int ENOMEM();

    private static native long malloc(long sizeInBytes) throws NativeErrorException;

    private static native void free(long baseAddress);

    protected JnhwMemoryAccessor() {
    }

    private static native void setMemory0(long address, long sizeInBytes, byte value);

    @Override
    public void setMemory32(OpaqueMemory32 mem, byte value) {
        setMemory0(mem.baseAddress, mem.sizeInBytes, value);
    }

    @Override
    public void setMemory64(OpaqueMemory64 mem, byte value) {
        setMemory0(mem.baseAddress, mem.sizeInBytes, value);
    }

    private static native void copyMemory0(byte[] src, int srcPos, long destAddress, long destPos, int length);

    @Override
    public void copyMemory32(byte[] src, int srcPos, OpaqueMemory32 destMem, int destPos, int length) {
        MemoryAccessor.outOfBoundsMem(destPos, length, destMem.sizeInBytes);
        MemoryAccessor.outOfBoundsByteArray(srcPos, length, src.length);
        copyMemory0(src, srcPos, destMem.baseAddress, destPos, length);
    }

    @Override
    public void copyMemory64(byte[] src, int srcPos, OpaqueMemory64 destMem, long destPos, int length) {
        MemoryAccessor.outOfBoundsMem(destPos, length, destMem.sizeInBytes);
        MemoryAccessor.outOfBoundsByteArray(srcPos, length, src.length);
        copyMemory0(src, srcPos, destMem.baseAddress, destPos, length);
    }

    private static native void copyMemory0(long srcAddress, long srcPos, byte[] dest, int destPos, int length);

    @Override
    public void copyMemory32(OpaqueMemory32 srcMem, int srcPos, byte[] dest, int destPos, int length) {
        MemoryAccessor.outOfBoundsByteArray(destPos, length, dest.length);
        MemoryAccessor.outOfBoundsMem(srcPos, length, srcMem.sizeInBytes);
        copyMemory0(srcMem.baseAddress, srcPos, dest, destPos, length);
    }

    @Override
    public void copyMemory64(OpaqueMemory64 srcMem, long srcPos, byte[] dest, int destPos, int length) {
        MemoryAccessor.outOfBoundsByteArray(destPos, length, dest.length);
        MemoryAccessor.outOfBoundsMem(srcPos, length, srcMem.sizeInBytes);
        copyMemory0(srcMem.baseAddress, srcPos, dest, destPos, length);
    }

    private static native long uintptr_t0(long address);

    private static native void uintptr_t0(long address, long destAddress);

    private static native void uintptr_t0(long address, ByteBuffer destMem, int position);

    private static native long uintptr_t_AtIndex0(long address, int index);

    private static native void uintptr_t_AtIndex0(long address, int index, long destAddress);

    @Override
    public byte int8_t(OpaqueMemory32 mem, long offset) {
        return int8_t0(mem.baseAddress + offset);
    }

    @Override
    public void int8_t(OpaqueMemory32 mem, long offset, byte value) {
        int8_t0(mem.baseAddress + offset, value);
    }

    @Override
    public byte int8_t(OpaqueMemory64 mem, long offset) {
        return int8_t0(mem.baseAddress + offset);
    }

    @Override
    public void int8_t(OpaqueMemory64 mem, long offset, byte value) {
        int8_t0(mem.baseAddress + offset, value);
    }

    @Override
    public String int8_t_AsHex(OpaqueMemory32 mem, long offset) {
        return int8_t_AsHex0(mem.baseAddress + offset);
    }

    @Override
    public String int8_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return int8_t_nativeToString0(mem.baseAddress + offset);
    }

    @Override
    public short int16_t(OpaqueMemory32 mem, long offset) {
        return int16_t0(mem.baseAddress + offset);
    }

    @Override
    public void int16_t(OpaqueMemory32 mem, long offset, short value) {
        int16_t0(mem.baseAddress + offset, value);
    }

    @Override
    public String int16_t_AsHex(OpaqueMemory32 mem, long offset) {
        return int16_t_AsHex0(mem.baseAddress + offset);
    }

    @Override
    public String int16_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return int16_t_nativeToString0(mem.baseAddress + offset);
    }

    @Override
    public int int32_t(OpaqueMemory32 mem, long offset) {
        return int32_t0(mem.baseAddress + offset);
    }

    @Override
    public void int32_t(OpaqueMemory32 mem, long offset, int value) {
        int32_t0(mem.baseAddress + offset, value);
    }

    @Override
    public String int32_t_AsHex(OpaqueMemory32 mem, long offset) {
        return int32_t_AsHex0(mem.baseAddress + offset);
    }

    @Override
    public String int32_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return int32_t_nativeToString0(mem.baseAddress + offset);
    }

    @Override
    public long int64_t(OpaqueMemory32 mem, long offset) {
        return int64_t0(mem.baseAddress + offset);
    }

    @Override
    public void int64_t(OpaqueMemory32 mem, long offset, long value) {
        int64_t0(mem.baseAddress + offset, value);
    }

    @Override
    public String int64_t_AsHex(OpaqueMemory32 mem, long offset) {
        return int64_t_AsHex0(mem.baseAddress + offset);
    }

    @Override
    public String int64_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return int64_t_nativeToString0(mem.baseAddress + offset);
    }

    @Override
    public byte uint8_t(OpaqueMemory32 mem, long offset) {
        return uint8_t0(mem.baseAddress + offset);
    }

    @Override
    public short uint8_t_AsShort(OpaqueMemory32 mem, long offset) {
        return uint8_t_AsShort0(mem.baseAddress + offset);
    }

    @Override
    public void uint8_t(OpaqueMemory32 mem, long offset, byte value) {
        uint8_t0(mem.baseAddress + offset, value);
    }

    @Override
    public void uint8_t_FromShort(OpaqueMemory32 mem, long offset, short value) {
        uint8_t_FromShort0(mem.baseAddress + offset, value);
    }

    @Override
    public String uint8_t_AsHex(OpaqueMemory32 mem, long offset) {
        return uint8_t_AsHex0(mem.baseAddress + offset);
    }

    @Override
    public String uint8_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return uint8_t_nativeToString0(mem.baseAddress + offset);
    }

    @Override
    public short uint16_t(OpaqueMemory32 mem, long offset) {
        return uint16_t0(mem.baseAddress + offset);
    }

    @Override
    public int uint16_t_AsInt(OpaqueMemory32 mem, long offset) {
        return uint16_t_AsInt0(mem.baseAddress + offset);
    }

    @Override
    public void uint16_t(OpaqueMemory32 mem, long offset, short value) {
        uint16_t0(mem.baseAddress + offset, value);
    }

    @Override
    public void uint16_t_FromInt(OpaqueMemory32 mem, long offset, int value) {
        uint16_t_FromInt0(mem.baseAddress + offset, value);
    }

    @Override
    public String uint16_t_AsHex(OpaqueMemory32 mem, long offset) {
        return uint16_t_AsHex0(mem.baseAddress + offset);
    }

    @Override
    public String uint16_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return uint16_t_nativeToString0(mem.baseAddress + offset);
    }

    @Override
    public int uint32_t(OpaqueMemory32 mem, long offset) {
        return uint32_t0(mem.baseAddress + offset);
    }

    @Override
    public long uint32_t_AsLong(OpaqueMemory32 mem, long offset) {
        return uint32_t_AsLong0(mem.baseAddress + offset);
    }

    @Override
    public void uint32_t(OpaqueMemory32 mem, long offset, int value) {
        uint32_t0(mem.baseAddress + offset, value);
    }

    @Override
    public void uint32_t_FromLong(OpaqueMemory32 mem, long offset, long value) {
        uint32_t_FromLong0(mem.baseAddress + offset, value);
    }

    @Override
    public String uint32_t_AsHex(OpaqueMemory32 mem, long offset) {
        return uint32_t_AsHex0(mem.baseAddress + offset);
    }

    @Override
    public String uint32_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return uint32_t_nativeToString0(mem.baseAddress + offset);
    }

    @Override
    public long uint64_t(OpaqueMemory32 mem, long offset) {
        return uint64_t0(mem.baseAddress + offset);
    }

    @Override
    public void uint64_t(OpaqueMemory32 mem, long offset, long value) {
        uint64_t0(mem.baseAddress + offset, value);
    }

    @Override
    public String uint64_t_AsHex(OpaqueMemory32 mem, long offset) {
        return uint64_t_AsHex0(mem.baseAddress + offset);
    }

    @Override
    public String uint64_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return uint64_t_nativeToString0(mem.baseAddress + offset);
    }

    @Override
    public long allocateMemory(AbstractNativeMemory mem, long sizeInBytes) {
        final long result = allocateMemory0(sizeInBytes);
        AbstractNativeMemory.CLEANER.register(mem, new JnhwMemoryAccessor.JnhwMemoryCleaner(result));
        return result;
    }

    @Override
    public NativeAddressHolder uintptr_t(OpaqueMemory32 mem, long offset) {
        return new NativeAddressHolder(uintptr_t0(mem.baseAddress + offset));
    }

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, OpaqueMemory32 destMem) {
        uintptr_t0(mem.baseAddress + offset, destMem.baseAddress);
    }

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, OpaqueMemory32 destMem, long destOffset) {
        uintptr_t0(mem.baseAddress + offset, destMem.baseAddress + destOffset);
    }

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, ByteBuffer destMem) {
        uintptr_t0(mem.baseAddress + offset, destMem, destMem.position());
    }

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, NativeAddressHolder dest) {
        uintptr_t0(mem.baseAddress + offset, dest.address);
    }

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, NativeFunctionPointer dest) {
        uintptr_t0(mem.baseAddress + offset, dest.nativeAddress);
    }

    @Override
    public NativeAddressHolder uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index) {
        return new NativeAddressHolder(uintptr_t_AtIndex0(mem.baseAddress + offset, index));
    }

    @Override
    public void uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index, OpaqueMemory32 destAddress) {
        uintptr_t_AtIndex0(mem.baseAddress + offset, index, destAddress.baseAddress);
    }

    @Override
    public void uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index, NativeAddressHolder dest) {
        uintptr_t_AtIndex0(mem.baseAddress + offset, index, dest.address);
    }

    private static native byte int8_t0(long address);

    private static native void int8_t0(long address, @de.ibapl.jnhw.common.annotation.int8_t byte value);

    private static native String int8_t_AsHex0(long address);

    private static native String int8_t_nativeToString0(long address);

    private static native short int16_t0(long address);

    private static native void int16_t0(long address, short value);

    private static native String int16_t_AsHex0(long address);

    private static native String int16_t_nativeToString0(long address);

    private static native int int32_t0(long address);

    private static native void int32_t0(long address, int value);

    private static native String int32_t_AsHex0(long address);

    private static native String int32_t_nativeToString0(long address);

    private static native long int64_t0(long address);

    private static native void int64_t0(long address, long value);

    private static native String int64_t_AsHex0(long address);

    private static native String int64_t_nativeToString0(long address);

    private static native byte uint8_t0(long address);

    private static native short uint8_t_AsShort0(long address);

    private static native void uint8_t0(long address, byte value);

    private static native void uint8_t_FromShort0(long address, short value);

    private static native String uint8_t_AsHex0(long address);

    private static native String uint8_t_nativeToString0(long address);

    private static native short uint16_t0(long address);

    private static native int uint16_t_AsInt0(long address);

    private static native void uint16_t0(long address, short value);

    private static native void uint16_t_FromInt0(long address, int value);

    private static native String uint16_t_AsHex0(long address);

    private static native String uint16_t_nativeToString0(long address);

    private static native int uint32_t0(long address);

    private static native long uint32_t_AsLong0(long address);

    private static native void uint32_t0(long address, int value);

    private static native void uint32_t_FromLong0(long address, long value);

    private static native String uint32_t_AsHex0(long address);

    private static native String uint32_t_nativeToString0(long address);

    private static native long uint64_t0(long address);

    private static native void uint64_t0(long address, long value);

    private static native String uint64_t_AsHex0(long address);

    private static native String uint64_t_nativeToString0(long address);

    private long allocateMemory0(long sizeInBytes) {
        try {
            final long result = malloc(sizeInBytes);
            AbstractNativeMemory.CLEANER.register(this, new JnhwMemoryCleaner(result));
            return result;
        } catch (NativeErrorException nee) {
            if (nee.errno == ENOMEM()) {
                throw new OutOfMemoryError("Can't allocate " + sizeInBytes + " bytes ENOMEM");
            } else {
                throw new RuntimeException("Can't allocate " + sizeInBytes + " bytes ");
            }
        }
    }

    private static native long signed_long0(long address);

    private static native void signed_long0(long address, long value);

    private static native long unsigned_long0(long address);

    private static native void unsigned_long0(long address, long value);

    private static native String getStringUTF0(long address);

    @Override
    public long signed_long(OpaqueMemory32 mem, long offset) {
        return signed_long0(mem.baseAddress + offset);
    }

    @Override
    public void signed_long(OpaqueMemory32 mem, long offset, long value) {
        signed_long0(mem.baseAddress + offset, value);
    }

    @Override
    public long unsigned_long(OpaqueMemory32 mem, long offset) {
        return unsigned_long0(mem.baseAddress + offset);
    }

    @Override
    public void unsigned_long(OpaqueMemory32 mem, long offset, long value) {
        unsigned_long0(mem.baseAddress + offset, value);
    }

    @Override
    public String getStringUTF(OpaqueMemory32 mem, long offset) {
        return getStringUTF0(mem.baseAddress + offset);
    }

    class JnhwMemoryCleaner implements Runnable {

        final long baseAddress;

        JnhwMemoryCleaner(final long baseAddress) {
            this.baseAddress = baseAddress;
        }

        public void run() {
            try {
                //LOG.log(Level.FINEST, String.format("Finalize: try free memory @%s size: %d", JnhwFormater.formatAddress(baseAddress), sizeInBytes));
                free(baseAddress);
                //LOG.log(Level.FINEST, String.format("memory @%s freed", JnhwFormater.formatAddress(baseAddress)));
            } catch (Throwable t) {
                AbstractNativeMemory.LOG.log(Level.SEVERE, String.format("Finalize: Memory Leak freeing memory @%s failed", JnhwFormater.formatAddress(baseAddress)), t);
            }
        }
    }

}
