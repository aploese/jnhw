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
package de.ibapl.jnhw.util.winapi.memory;

import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.util.winapi.LibJnhwWinApiLoader;
import de.ibapl.jnhw.winapi.Winnt;

/**
 *
 * @author apl
 */
public class WinApiStruct32 extends Struct32 {

    protected static class Accessor_BOOL_As_int32_t implements Accessor_BOOL {

        @Override
        public boolean BOOL(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.int32_t(mem, offset) != 0;
        }

        @Override
        public void BOOL(OpaqueMemory32 mem, long offset, boolean value) {
            MEM_ACCESS.int32_t(mem, offset, value ? 1 : 0);
        }

    }

    protected static class Accessor_BYTE_As_uint8_t implements Accessor_BYTE {

        @Override
        public byte BYTE(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint8_t(mem, offset);
        }

        @Override
        public void BYTE(OpaqueMemory32 mem, long offset, byte value) {
            MEM_ACCESS.uint8_t(mem, offset, value);
        }

        @Override
        public short BYTE_AsShort(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint8_t_AsShort(mem, offset);
        }

        @Override
        public void BYTE_FromShort(OpaqueMemory32 mem, long offset, short value) {
            MEM_ACCESS.uint8_t_FromShort(mem, offset, value);
        }

    }

    protected static class Accessor_DWORD_As_uint32_t implements Accessor_DWORD {

        @Override
        public int DWORD(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint32_t(mem, offset);
        }

        @Override
        public void DWORD(OpaqueMemory32 mem, long offset, int value) {
            MEM_ACCESS.uint32_t(mem, offset, value);
        }

        @Override
        public long DWORD_AsLong(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint32_t_AsLong(mem, offset);
        }

        @Override
        public void DWORD_FromLong(OpaqueMemory32 mem, long offset, long value) {
            MEM_ACCESS.uint32_t_FromLong(mem, offset, value);
        }

    }

    protected static class Accessor_HANDLE_As_intptr_t implements Accessor_HANDLE {

        @Override
        public Winnt.HANDLE HANDLE(OpaqueMemory32 mem, long offset) {
            return Winnt.HANDLE.of(MEM_ACCESS.intptr_t(mem, offset));
        }

        @Override
        public void HANDLE(OpaqueMemory32 mem, long offset, Winnt.HANDLE value) {
            MEM_ACCESS.intptr_t(mem, offset, Winnt.HANDLE.getHandleValue(value));
        }

    }

    protected static class Accessor_PVOID_As_uintptr_t implements Accessor_PVOID {

        @Override
        public NativeAddressHolder PVOID(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uintptr_t_AsNativeAddressHolder(mem, offset);
        }

        @Override
        public void PVOID(OpaqueMemory32 mem, long offset, NativeAddressHolder value) {
            MEM_ACCESS.uintptr_t(mem, offset, value);
        }

    }

    protected static class Accessor_ULONG_PTR_As_uintptr_t implements Accessor_ULONG_PTR {

        @Override
        public long ULONG_PTR(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uintptr_t(mem, offset);
        }

        @Override
        public void ULONG_PTR(OpaqueMemory32 mem, long offset, long value) {
            MEM_ACCESS.uintptr_t(mem, offset, value);
        }

    }

    protected static class Accessor_WORD_As_uint16_t implements Accessor_WORD {

        @Override
        public short WORD(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint16_t(mem, offset);
        }

        @Override
        public void WORD(OpaqueMemory32 mem, long offset, short value) {
            MEM_ACCESS.uint16_t(mem, offset, value);
        }

        @Override
        public int WORD_AsInt(OpaqueMemory32 mem, long offset) {
            return MEM_ACCESS.uint16_t_AsInt(mem, offset);
        }

        @Override
        public void WORD_FromInt(OpaqueMemory32 mem, long offset, int value) {
            MEM_ACCESS.uint16_t_FromInt(mem, offset, value);
        }

    }

    protected final static Accessor_BOOL ACCESSOR_BOOL;

    protected final static Accessor_BYTE ACCESSOR_BYTE;

    protected final static Accessor_DWORD ACCESSOR_DWORD;

    protected final static Accessor_HANDLE ACCESSOR_HANDLE;
    protected final static Accessor_PVOID ACCESSOR_PVOID;
    protected final static Accessor_ULONG_PTR ACCESSOR_ULONG_PTR;
    protected final static Accessor_WORD ACCESSOR_WORD;
    /**
     * Make sure the native lib is loaded ... this class is static, so we have
     * to
     */
    static {
        LibJnhwWinApiLoader.touch();
    }
    static {
        ACCESSOR_BOOL = new Accessor_BOOL_As_int32_t();
        ACCESSOR_BYTE = new Accessor_BYTE_As_uint8_t();
        ACCESSOR_DWORD = new Accessor_DWORD_As_uint32_t();
        ACCESSOR_HANDLE = new Accessor_HANDLE_As_intptr_t();
        ACCESSOR_PVOID = new Accessor_PVOID_As_uintptr_t();
        ACCESSOR_ULONG_PTR = new Accessor_ULONG_PTR_As_uintptr_t();
        ACCESSOR_WORD = new Accessor_WORD_As_uint16_t();
    }
    public WinApiStruct32(AbstractNativeMemory owner, long offset, int sizeInBytes, SetMem setMem) {
        super(owner, offset, sizeInBytes, setMem);
    }

    public WinApiStruct32(NativeAddressHolder nativeAddressHolder, int sizeInBytes) {
        super(nativeAddressHolder, sizeInBytes);
    }
}
