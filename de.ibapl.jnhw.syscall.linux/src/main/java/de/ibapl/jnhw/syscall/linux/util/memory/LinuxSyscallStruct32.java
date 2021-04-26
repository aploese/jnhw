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
package de.ibapl.jnhw.syscall.linux.util.memory;

import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;

/**
 *
 * @author aploese
 */
public class LinuxSyscallStruct32 extends Struct32 {

    protected static class Accessor___u8_As_uint8_t implements Accessor___u8 {

        @Override
        public byte __u8(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint8_t(mem, offset);
        }

        @Override
        public short __u8_AsShort(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint8_t_AsShort(mem, offset);
        }

        @Override
        public void __u8(OpaqueMemory32 mem, long offset, byte value) {
            MEM_ACCESS.uint8_t(mem, offset, value);
        }

        @Override
        public void __u8_FromShort(OpaqueMemory32 mem, long offset, short value) {
            MEM_ACCESS.uint8_t_FromShort(mem, offset, value);
        }

        @Override
        public byte[] __u8_Array(OpaqueMemory32 mem, long offset, int lenght) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    protected static class BigEndianAccessor___le16_As_uint16_t implements Accessor___le16 {

        @Override
        public short __le16(OpaqueMemory32 mem, long offset) {
            return Short.reverseBytes(MEM_ACCESS.uint16_t(mem, offset));
        }

        @Override
        public int __le16_AsInt(OpaqueMemory32 mem, long offset) {
            return __le16(mem, offset) & 0xffff;
        }

        @Override
        public void __le16(OpaqueMemory32 mem, long offset, short value) {
            MEM_ACCESS.uint16_t(mem, offset, Short.reverseBytes(value));
        }

        @Override
        public void __le16_FromInt(OpaqueMemory32 mem, long offset, int value) {
            if (value < 0) {
                throw new IllegalArgumentException("value must not be negative: " + value);
            } else if (value > 0x0000ffff) {
                throw new IllegalArgumentException("value must not be bigger than  65535 (0xffff): " + value);
            }
            __le16(mem, offset, (short) value);
        }

        @Override
        public short[] __le16_Array(OpaqueMemory32 mem, long offset, int lenght) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    protected static class LitteleEndianAccessor___le16_As_uint16_t implements Accessor___le16 {

        @Override
        public short __le16(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint16_t(mem, offset);
        }

        @Override
        public int __le16_AsInt(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint16_t_AsInt(mem, offset);
        }

        @Override
        public void __le16(OpaqueMemory32 mem, long offset, short value) {
            MEM_ACCESS.uint16_t(mem, offset, value);
        }

        @Override
        public void __le16_FromInt(OpaqueMemory32 mem, long offset, int value) {
            MEM_ACCESS.uint16_t_FromInt(mem, offset, value);
        }

        @Override
        public short[] __le16_Array(OpaqueMemory32 mem, long offset, int lenght) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public LinuxSyscallStruct32(AbstractNativeMemory owner, long offset, int sizeInBytes, SetMem setMem) {
        super(owner, offset, sizeInBytes, setMem);
    }

    public LinuxSyscallStruct32(NativeAddressHolder nativeAddressHolder, int sizeInBytes) {
        super(nativeAddressHolder, sizeInBytes);
    }

    protected final static Accessor___u8 ACCESSOR___U8 = new Accessor___u8_As_uint8_t();

    protected final static Accessor___le16 ACCESSOR___LE16;

    static {
        switch (new MultiarchTupelBuilder().getEndianess()) {
            case LITTLE:
                ACCESSOR___LE16 = new LitteleEndianAccessor___le16_As_uint16_t();
                break;
            case BIG:
                ACCESSOR___LE16 = new BigEndianAccessor___le16_As_uint16_t();
                break;
            default:
                ACCESSOR___LE16 = null;
                throw new RuntimeException("Unknown Endianess : " + new MultiarchTupelBuilder().getEndianess());
        }
    }

}
