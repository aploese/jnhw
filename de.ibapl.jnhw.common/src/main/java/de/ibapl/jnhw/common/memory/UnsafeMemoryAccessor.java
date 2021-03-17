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

import de.ibapl.jnhw.common.util.JnhwFormater;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.logging.Level;

/**
 *
 * @author aploese
 */
public abstract class UnsafeMemoryAccessor implements MemoryAccessor {

    final sun.misc.Unsafe unsafe;

    @Override
    public void setMemory32(OpaqueMemory32 mem, byte value) {
        unsafe.setMemory(mem.baseAddress, mem.sizeInBytes, value);
    }

    @Override
    public void setMemory64(OpaqueMemory64 mem, byte value) {
        unsafe.setMemory(mem.baseAddress, mem.sizeInBytes, value);
    }

    @Override
    public void copyMemory32(byte[] src, int srcPos, OpaqueMemory32 destMem, int destPos, int length) {
        MemoryAccessor.outOfBoundsMem(destPos, length, destMem.sizeInBytes);
        MemoryAccessor.outOfBoundsByteArray(srcPos, length, src.length);
        unsafe.copyMemory(src, unsafe.ARRAY_BYTE_BASE_OFFSET + srcPos, null, destMem.baseAddress + destPos, length);
    }

    @Override
    public void copyMemory64(byte[] src, int srcPos, OpaqueMemory64 destMem, long destPos, int length) {
        MemoryAccessor.outOfBoundsMem(destPos, length, destMem.sizeInBytes);
        MemoryAccessor.outOfBoundsByteArray(srcPos, length, src.length);
        unsafe.copyMemory(src, unsafe.ARRAY_BYTE_BASE_OFFSET + srcPos, null, destMem.baseAddress + destPos, length);
    }

    @Override
    public void copyMemory32(OpaqueMemory32 srcMem, int srcPos, byte[] dest, int destPos, int length) {
        MemoryAccessor.outOfBoundsByteArray(destPos, length, dest.length);
        MemoryAccessor.outOfBoundsMem(srcPos, length, srcMem.sizeInBytes);
        unsafe.copyMemory(null, srcMem.baseAddress + srcPos, dest, unsafe.ARRAY_BYTE_BASE_OFFSET + destPos, length);
    }

    @Override
    public void copyMemory64(OpaqueMemory64 srcMem, long srcPos, byte[] dest, int destPos, int length) {
        MemoryAccessor.outOfBoundsByteArray(destPos, length, dest.length);
        MemoryAccessor.outOfBoundsMem(srcPos, length, srcMem.sizeInBytes);
        unsafe.copyMemory(null, srcMem.baseAddress + srcPos, dest, unsafe.ARRAY_BYTE_BASE_OFFSET + destPos, length);
    }

    @Override
    public long uintptr_t(OpaqueMemory32 mem, long offset) {
        return unsafe.getAddress(mem.baseAddress + offset);
    }

    @Override
    public NativeAddressHolder uintptr_t_AsNativeAddressHolder(OpaqueMemory32 mem, long offset) {
        return new NativeAddressHolder(unsafe.getAddress(mem.baseAddress + offset));
    }

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, OpaqueMemory32 destMem) {
        unsafe.putAddress(mem.baseAddress + offset, destMem.baseAddress);
    }

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, OpaqueMemory32 destMem, long destOffset) {
        unsafe.putAddress(mem.baseAddress + offset, destMem.baseAddress + destOffset);
    }

    private static native void uintptr_t0(long address, ByteBuffer destMem, int position);

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, ByteBuffer destMem) {
        uintptr_t0(mem.baseAddress + offset, destMem, destMem.position());
    }

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, NativeAddressHolder dest) {
        unsafe.putAddress(mem.baseAddress + offset, dest.address);
    }

    @Override
    public void uintptr_t(OpaqueMemory32 mem, long offset, NativeFunctionPointer dest) {
        unsafe.putAddress(mem.baseAddress + offset, dest.nativeAddress);
    }

    @Override
    public long uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index) {
        return unsafe.getAddress(mem.baseAddress + offset + index * unsafe.addressSize());
    }

    @Override
    public NativeAddressHolder uintptr_t_AtIndex_AsNativeAddressHolder(OpaqueMemory32 mem, long offset, int index) {
        return new NativeAddressHolder(unsafe.getAddress(mem.baseAddress + offset + index * unsafe.addressSize()));
    }

    @Override
    public void uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index, long dest) {
        unsafe.putAddress(mem.baseAddress + offset + index * unsafe.addressSize(), dest);
    }

    @Override
    public void uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index, OpaqueMemory32 destMem) {
        unsafe.putAddress(mem.baseAddress + offset + index * unsafe.addressSize(), destMem.baseAddress);
    }

    @Override
    public void uintptr_t_AtIndex(OpaqueMemory32 mem, long offset, int index, NativeAddressHolder dest) {
        unsafe.putAddress(mem.baseAddress + offset + index * unsafe.addressSize(), dest.address);
    }

    class UnsafeMemoryCleaner implements Runnable {

        final long baseAddress;

        UnsafeMemoryCleaner(final long baseAddress) {
            this.baseAddress = baseAddress;
        }

        @Override
        public void run() {
            try {
                //LOG.log(Level.FINEST, String.format("Finalize: try free memory @%s size: %d", JnhwFormater.formatAddress(baseAddress), sizeInBytes));
                unsafe.freeMemory(baseAddress);
                //LOG.log(Level.FINEST, String.format("memory @%s freed", JnhwFormater.formatAddress(baseAddress)));
            } catch (Throwable t) {
                AbstractNativeMemory.LOG.log(Level.SEVERE, String.format("Finalize: Memory Leak freeing memory @%s failed", JnhwFormater.formatAddress(baseAddress)), t);
            }
        }
    }

    public UnsafeMemoryAccessor() {
        try {
            Field f = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            this.unsafe = (sun.misc.Unsafe) f.get(null);
            //            this.unsafe = sun.misc.Unsafe.getUnsafe();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } //            this.unsafe = sun.misc.Unsafe.getUnsafe();

    @Override
    public byte int8_t(OpaqueMemory32 mem, long offset) {
        return unsafe.getByte(mem.baseAddress + offset);
    }

    @Override
    public byte int8_t(OpaqueMemory64 mem, long offset) {
        return unsafe.getByte(mem.baseAddress + offset);
    }

    @Override
    public void int8_t(OpaqueMemory32 mem, long offset, byte value) {
        unsafe.putByte(mem.baseAddress + offset, value);
    }

    @Override
    public void int8_t(OpaqueMemory64 mem, long offset, byte value) {
        unsafe.putByte(mem.baseAddress + offset, value);
    }

    @Override
    public String int8_t_AsHex(OpaqueMemory32 mem, long offset) {
        return String.format("0x%02x", int8_t(mem, offset));
    }

    @Override
    public String int8_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return String.valueOf(int8_t(mem, offset));
    }

    @Override
    public short int16_t(OpaqueMemory32 mem, long offset) {
        return unsafe.getShort(mem.baseAddress + offset);
    }

    @Override
    public void int16_t(OpaqueMemory32 mem, long offset, short value) {
        unsafe.putShort(mem.baseAddress + offset, value);
    }

    @Override
    public String int16_t_AsHex(OpaqueMemory32 mem, long offset) {
        return String.format("0x%04x", int16_t(mem, offset));
    }

    @Override
    public String int16_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return String.valueOf(int16_t(mem, offset));
    }

    @Override
    public int int32_t(OpaqueMemory32 mem, long offset) {
        return unsafe.getInt(mem.baseAddress + offset);
    }

    @Override
    public void int32_t(OpaqueMemory32 mem, long offset, int value) {
        unsafe.putInt(mem.baseAddress + offset, value);
    }

    @Override
    public String int32_t_AsHex(OpaqueMemory32 mem, long offset) {
        return String.format("0x%08x", int32_t(mem, offset));
    }

    @Override
    public String int32_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return String.valueOf(int32_t(mem, offset));
    }

    @Override
    public long int64_t(OpaqueMemory32 mem, long offset) {
        return unsafe.getLong(mem.baseAddress + offset);
    }

    @Override
    public void int64_t(OpaqueMemory32 mem, long offset, long value) {
        unsafe.putLong(mem.baseAddress + offset, value);
    }

    @Override
    public String int64_t_AsHex(OpaqueMemory32 mem, long offset) {
        return String.format("0x%016x", int64_t(mem, offset));
    }

    @Override
    public String int64_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return String.valueOf(int64_t(mem, offset));
    }

    @Override
    public byte uint8_t(OpaqueMemory32 mem, long offset) {
        return unsafe.getByte(mem.baseAddress + offset);
    }

    @Override
    public short uint8_t_AsShort(OpaqueMemory32 mem, long offset) {
        return (short) (unsafe.getByte(mem.baseAddress + offset) & 0xff);
    }

    @Override
    public void uint8_t(OpaqueMemory32 mem, long offset, byte value) {
        unsafe.putByte(mem.baseAddress + offset, value);
    }

    @Override
    public void uint8_t_FromShort(OpaqueMemory32 mem, long offset, short value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must not be negative: " + value);
        } else if (value > (short) 0x00ff) {
            throw new IllegalArgumentException("value must not be bigger than 255 (0xff): " + value);
        }
        unsafe.putByte(mem.baseAddress + offset, (byte) value);
    }

    @Override
    public String uint8_t_AsHex(OpaqueMemory32 mem, long offset) {
        return String.format("0x%02x", uint8_t(mem, offset));
    }

    @Override
    public String uint8_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return String.valueOf(uint8_t_AsShort(mem, offset));
    }

    @Override
    public short uint16_t(OpaqueMemory32 mem, long offset) {
        return unsafe.getShort(mem.baseAddress + offset);
    }

    @Override
    public int uint16_t_AsInt(OpaqueMemory32 mem, long offset) {
        return (int) (unsafe.getShort(mem.baseAddress + offset) & 0xffff);
    }

    @Override
    public void uint16_t(OpaqueMemory32 mem, long offset, short value) {
        unsafe.putShort(mem.baseAddress + offset, value);
    }

    @Override
    public void uint16_t_FromInt(OpaqueMemory32 mem, long offset, int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must not be negative: " + value);
        } else if (value > 0x0000ffff) {
            throw new IllegalArgumentException("value must not be bigger than  65535 (0xffff): " + value);
        }
        unsafe.putShort(mem.baseAddress + offset, (short) value);
    }

    @Override
    public String uint16_t_AsHex(OpaqueMemory32 mem, long offset) {
        return String.format("0x%04x", uint16_t(mem, offset));
    }

    @Override
    public String uint16_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return String.valueOf(uint16_t_AsInt(mem, offset));
    }

    @Override
    public int uint32_t(OpaqueMemory32 mem, long offset) {
        return unsafe.getInt(mem.baseAddress + offset);
    }

    @Override
    public long uint32_t_AsLong(OpaqueMemory32 mem, long offset) {
        return (long) (unsafe.getInt(mem.baseAddress + offset) & 0x00000000ffffffffL);
    }

    @Override
    public void uint32_t(OpaqueMemory32 mem, long offset, int value) {
        unsafe.putInt(mem.baseAddress + offset, value);
    }

    @Override
    public void uint32_t_FromLong(OpaqueMemory32 mem, long offset, long value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must not be negative: " + value);
        } else if (value > 0x00000000ffffffffL) {
            throw new IllegalArgumentException("value must not be bigger than  4294967295 (0xffffffff): " + value);
        }
        unsafe.putInt(mem.baseAddress + offset, (int) value);
    }

    @Override
    public String uint32_t_AsHex(OpaqueMemory32 mem, long offset) {
        return String.format("0x%08x", uint32_t(mem, offset));
    }

    @Override
    public String uint32_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return Integer.toUnsignedString(uint32_t(mem, offset));
    }

    @Override
    public long uint64_t(OpaqueMemory32 mem, long offset) {
        return unsafe.getLong(mem.baseAddress + offset);
    }

    @Override
    public void uint64_t(OpaqueMemory32 mem, long offset, long value) {
        unsafe.putLong(mem.baseAddress + offset, value);
    }

    @Override
    public String uint64_t_AsHex(OpaqueMemory32 mem, long offset) {
        return String.format("0x%016x", uint64_t(mem, offset));
    }

    @Override
    public String uint64_t_nativeToString(OpaqueMemory32 mem, long offset) {
        return Long.toUnsignedString(uint64_t(mem, offset));
    }

    @Override
    public long allocateMemory(AbstractNativeMemory mem, long sizeInBytes) {
        final long result = unsafe.allocateMemory(sizeInBytes);
        AbstractNativeMemory.CLEANER.register(mem, new UnsafeMemoryCleaner(result));
        return result;
    }

    private static native String callJniNewStringUTF(long address);

    @Override
    public String getUTF_8String(OpaqueMemory32 mem, long offset) {
        //no method on unsafe...
        return callJniNewStringUTF(mem.baseAddress + offset);
    }

    private static native void callJniGetStringUTFRegion(String s, int srcStart, long address, int len);

    @Override
    public void setUTF_8String(String s, int srcStart, OpaqueMemory32 mem, long offset, int len) {
        callJniGetStringUTFRegion(s, srcStart, mem.baseAddress + offset, len);
    }

    private static native int callJniGetStringUTFLength(String s);

    @Override
    public int getUTF_8StringLength(String s) {
        return callJniGetStringUTFLength(s);
    }

    private static native String callJniNewString(long address, int start, int len);

    @Override
    public String getUnicodeString(OpaqueMemory32 mem, long offset, int start, int len) {
        return callJniNewString(mem.baseAddress + offset, start, len);
    }

    private static native void callJniGetStringRegion(String s, int srcStart, long address, int destStart, int len);

    @Override
    public void setUnicodeString(String s, int srcStart, OpaqueMemory32 mem, long offset, int destStart, int len) {
        callJniGetStringRegion(s, srcStart, mem.baseAddress + offset, destStart, len);
    }

    private static native int callJniGetStringLength(String s);

    @Override
    public int getUnicodeStringLength(String s) {
        return callJniGetStringLength(s);
    }

}
