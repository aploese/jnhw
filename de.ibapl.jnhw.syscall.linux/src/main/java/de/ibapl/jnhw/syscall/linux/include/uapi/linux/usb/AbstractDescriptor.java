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
package de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb;

import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.PackedStructLayoutFactory;
import de.ibapl.jnhw.common.memory.layout.StructLayout;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactory;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactoryImpl;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.syscall.linux.annotation.SysFs;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types;
import de.ibapl.jnhw.syscall.linux.util.memory.LinuxSyscallStruct32;
import de.ibapl.jnhw.syscall.linux.util.memory.PacketLayout;
import java.io.IOException;

@SysFs("/sys/bus/usb/devices/*/descriptors")
public abstract class AbstractDescriptor extends LinuxSyscallStruct32 {

    public static class Layout extends PacketLayout {

        public final static byte bLength = START_OFFSET;
        public final static byte bDescriptorType = bLength + __U8;

        protected final static byte _sizeof = bDescriptorType + __U8;
    }

    @Deprecated
    public static class AbstractLayout extends StructLayout {

        protected final StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactoryImpl.Type.STRUCT, Alignment.AT_1);
        public final int bLength;
        public final int bDescriptorType;

        protected AbstractLayout() {
            bLength = (int) slf.uint8_t();
            bDescriptorType = (int) slf.uint8_t();
            throw new UnsupportedOperationException("Not implemented!");
        }

        final public int getSizeof() {
            return (int) slf.getSizeof();
        }

        final public Alignment getAlignment() {
            return slf.getAlignment();
        }

    }

    protected final static AbstractLayout ABSTRACT_LAYOUT = null;

    public static String bcd2String(short bcdValue) {
        return String.format("%x.%02x", (bcdValue >> 8), (bcdValue & 0x00FF));
    }

    public AbstractDescriptor(AbstractNativeMemory parent, long offset, int sizeInBytes, Byte setMem) {
        super(parent, offset, sizeInBytes, setMem);
    }

    @Types.__u8
    public final short bLength() {
        return ACCESSOR___U8.__u8_AsShort(this, Layout.bLength);
    }

    @Types.__u8
    public final byte bDescriptorType() {
        return ACCESSOR___U8.__u8(this, Layout.bDescriptorType);
    }

    protected abstract void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException;

    @Override
    public final void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
        JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
        jsb.appendShortMember("bLength", bLength());
        jsb.appendByteMember("bDescriptorType", bDescriptorType());
        nativeToString(jsb, indentPrefix, indent);
        jsb.close();
    }
}
