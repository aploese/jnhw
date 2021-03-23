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
package de.ibapl.jnhw.syscall.linux.include.linux;

import de.ibapl.jnhw.common.annotation.Packed;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.StructArray32;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb.AbstractDescriptor;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u8;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__le16;
import de.ibapl.jnhw.syscall.linux.util.memory.LinuxSyscallStruct32;
import de.ibapl.jnhw.syscall.linux.util.memory.PacketLayout;
import java.io.IOException;

/**
 *
 * @author aploese
 */
public class Hid {

    @Packed
    public final static class Hid_class_descriptor extends LinuxSyscallStruct32 {

        public final static class Layout extends PacketLayout {

            public final static byte bDescriptorType = START_OFFSET;
            public final static byte wDescriptorLength = bDescriptorType + __U8;

            public final static byte sizeof = wDescriptorLength + __LE16;
        }

        public Hid_class_descriptor(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, Layout.sizeof, setMem);
        }

        @__u8
        public byte bDescriptorType() {
            return ACCESSOR___U8.__u8(this, Layout.bDescriptorType);
        }

        @__le16
        public int wDescriptorLength() {
            return ACCESSOR___LE16.__le16_AsInt(this, Layout.wDescriptorLength);
        }

        @Override
        public final void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendByteMember("bDescriptorType", bDescriptorType());
            jsb.appendIntMember("wDescriptorLength", wDescriptorLength());
            jsb.close();
        }

    }

    public static class Hid_class_descriptors extends StructArray32<Hid_class_descriptor> {

        public Hid_class_descriptors(int arraylength) {
            //get uninitialized mem we need to set this anyway ...
            super(new Hid_class_descriptor[arraylength], Hid_class_descriptors::createAtOffset, Hid_class_descriptor.Layout.sizeof, SetMem.DO_NOT_SET);
        }

        public Hid_class_descriptors(AbstractNativeMemory parent, long offset, int arraylength) {
            //get uninitialized mem we need to set this anyway ...
            super(parent, offset, new Hid_class_descriptor[arraylength], Hid_class_descriptors::createAtOffset, Hid_class_descriptor.Layout.sizeof, SetMem.DO_NOT_SET);
        }

        private static Hid_class_descriptor createAtOffset(AbstractNativeMemory parent, long offset) {
            return new Hid_class_descriptor(parent, offset, SetMem.DO_NOT_SET);
        }

    }

    @Packed
    public final static class Hid_descriptor extends AbstractDescriptor {

        public final static class Layout extends AbstractDescriptor.Layout {

            public final static byte bcdHID = _sizeof;
            public final static byte bCountryCode = bcdHID + __LE16;
            public final static byte bNumDescriptors = bCountryCode + __U8;
            public final static byte desc = bNumDescriptors + __U8;

            public final static byte sizeof = desc + Hid_class_descriptor.Layout.sizeof;

        }

        public static final int MIN_SIZEOF = 9;

        public Hid_descriptor(AbstractNativeMemory parent, long offset, int size, SetMem setMem) {
            super(parent, offset, size, setMem);
            if ((size < MIN_SIZEOF) && (size < bLength())) {
                throw new RuntimeException("size is too small");
            }
            desc = new Hid_class_descriptors(this, Layout.desc, bNumDescriptors());
        }

        @__le16
        public short bcdHID() {
            return ACCESSOR___LE16.__le16(this, Layout.bcdHID);
        }

        @__u8
        public byte bCountryCode() {
            return ACCESSOR___U8.__u8(this, Layout.bCountryCode);
        }

        @__u8
        public short bNumDescriptors() {
            return ACCESSOR___U8.__u8_AsShort(this, Layout.bNumDescriptors);
        }

        public StructArray32<Hid_class_descriptor> desc;

        @Override
        protected void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
            jsb.appendShortMember("bLength", bLength());
            jsb.appendByteMember("bDescriptorType", bDescriptorType());
            jsb.appendStringMember("bcdHID", bcd2String(bcdHID()));
            jsb.appendByteMember("bCountryCode", bCountryCode());
            jsb.appendShortMember("bNumDescriptors", bNumDescriptors());
            jsb.appendStructArray32Member("desc", desc);
        }

    }
}
