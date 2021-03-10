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
 /* SPDX-License-Identifier: GPL-2.0 WITH Linux-syscall-note */
package de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb;

import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Struct32;
import static de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb.Ch9.Usb_ctrlrequest;
import static de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u8;
import static de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__le16;
import static de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__le32;
import de.ibapl.jnhw.unix.sys.Ioctl;

/**
 *
 * @author aploese
 */
public class Functionfs {

    private static native void initNative();

    private Functionfs() {
        super();
    }

    public final static byte FUNCTIONFS_DESCRIPTORS_MAGIC = 1;
    public final static byte FUNCTIONFS_STRINGS_MAGIC = 2;
    public final static byte FUNCTIONFS_DESCRIPTORS_MAGIC_V2 = 3;

    public static interface Functionfs_flags {

        public final static byte FUNCTIONFS_HAS_FS_DESC = 1;
        public final static byte FUNCTIONFS_HAS_HS_DESC = 2;
        public final static byte FUNCTIONFS_HAS_SS_DESC = 4;
        public final static byte FUNCTIONFS_HAS_MS_OS_DESC = 8;
        public final static byte FUNCTIONFS_VIRTUAL_ADDR = 16;
        public final static byte FUNCTIONFS_EVENTFD = 32;
        public final static byte FUNCTIONFS_ALL_CTRL_RECIP = 64;
        public final static byte FUNCTIONFS_CONFIG0_SETUP = (byte) 128;
    };

    /* Descriptor of an non-audio endpoint */
    public abstract static class Usb_endpoint_descriptor_no_audio extends Struct32 {

        public Usb_endpoint_descriptor_no_audio(AbstractNativeMemory parent, long offset, Byte setMem) {
            super(parent, offset, -1, setMem);
        }

        @__u8
        public abstract short bLength();

        @__u8
        public abstract byte bDescriptorType();

        @__u8
        public abstract byte bEndpointAddress();

        @__u8
        public abstract byte bmAttributes();

        @__le16
        public abstract int wMaxPacketSize();

        @__u8
        public abstract short bInterval();
    }

    public abstract static class Usb_functionfs_descs_head_v2 extends Struct32 {

        public Usb_functionfs_descs_head_v2(AbstractNativeMemory parent, long offset, Byte setMem) {
            super(parent, offset, -1, setMem);
        }

        @__le32
        public abstract int magic();

        @__le32
        public abstract int length();

        @__le32
        public abstract int flags();
        /*
	 * __le32 fs_count, hs_count, fs_count; must be included manually in
	 * the structure taking flags into consideration.
         */
    }

    /* MS OS Descriptor header */
    public abstract static class Usb_os_desc_header extends Struct32 {

        public Usb_os_desc_header(AbstractNativeMemory parent, long offset, Byte setMem) {
            super(parent, offset, -1, setMem);
        }

        @__u8
        public abstract byte interface_();

        @__le32
        public abstract long dwLength();

        @__le16
        public abstract short bcdVersion();

        @__le16
        public abstract int wIndex();

        //start union
        @__u8
        public abstract short bCount();

        @__u8
        public abstract byte Reserved();
        //restart-union

        @__le16
        public abstract int wCount();
        //end-union

    }

    public abstract static class Usb_ext_compat_desc extends Struct32 {

        public Usb_ext_compat_desc(AbstractNativeMemory parent, long offset, Byte setMem) {
            super(parent, offset, -1, setMem);
        }

        @__u8
        public abstract byte bFirstInterfaceNumber();

        @__u8
        public abstract byte Reserved1();

        @__u8
        public abstract byte[] CompatibleID();

        @__u8
        public abstract byte[] SubCompatibleID();

        @__u8
        public abstract byte[] Reserved2();
    };

    public abstract static class Usb_ext_prop_desc extends Struct32 {

        public Usb_ext_prop_desc(AbstractNativeMemory parent, long offset, Byte setMem) {
            super(parent, offset, -1, setMem);
        }

        @__le32
        public abstract long dwSize();

        @__le32
        public abstract int dwPropertyDataType();

        @__le16
        public abstract int wPropertyNameLength();
    }

    /*
 * Descriptors format:
 *
 * | off | name      | type         | description                          |
 * |-----+-----------+--------------+--------------------------------------|
 * |   0 | magic     | LE32         | FUNCTIONFS_DESCRIPTORS_MAGIC_V2      |
 * |   4 | length    | LE32         | length of the whole data chunk       |
 * |   8 | flags     | LE32         | combination of functionfs_flags      |
 * |     | eventfd   | LE32         | eventfd file descriptor              |
 * |     | fs_count  | LE32         | number of full-speed descriptors     |
 * |     | hs_count  | LE32         | number of high-speed descriptors     |
 * |     | ss_count  | LE32         | number of super-speed descriptors    |
 * |     | os_count  | LE32         | number of MS OS descriptors          |
 * |     | fs_descrs | Descriptor[] | list of full-speed descriptors       |
 * |     | hs_descrs | Descriptor[] | list of high-speed descriptors       |
 * |     | ss_descrs | Descriptor[] | list of super-speed descriptors      |
 * |     | os_descrs | OSDesc[]     | list of MS OS descriptors            |
 *
 * Depending on which flags are set, various fields may be missing in the
 * structure.  Any flags that are not recognised cause the whole block to be
 * rejected with -ENOSYS.
 *
 * Legacy descriptors format (deprecated as of 3.14):
 *
 * | off | name      | type         | description                          |
 * |-----+-----------+--------------+--------------------------------------|
 * |   0 | magic     | LE32         | FUNCTIONFS_DESCRIPTORS_MAGIC         |
 * |   4 | length    | LE32         | length of the whole data chunk       |
 * |   8 | fs_count  | LE32         | number of full-speed descriptors     |
 * |  12 | hs_count  | LE32         | number of high-speed descriptors     |
 * |  16 | fs_descrs | Descriptor[] | list of full-speed descriptors       |
 * |     | hs_descrs | Descriptor[] | list of high-speed descriptors       |
 *
 * All numbers must be in little endian order.
 *
 * Descriptor[] is an array of valid USB descriptors which have the following
 * format:
 *
 * | off | name            | type | description              |
 * |-----+-----------------+------+--------------------------|
 * |   0 | bLength         | U8   | length of the descriptor |
 * |   1 | bDescriptorType | U8   | descriptor type          |
 * |   2 | payload         |      | descriptor's payload     |
 *
 * OSDesc[] is an array of valid MS OS Feature Descriptors which have one of
 * the following formats:
 *
 * | off | name            | type | description              |
 * |-----+-----------------+------+--------------------------|
 * |   0 | inteface        | U8   | related interface number |
 * |   1 | dwLength        | U32  | length of the descriptor |
 * |   5 | bcdVersion      | U16  | currently supported: 1   |
 * |   7 | wIndex          | U16  | currently supported: 4   |
 * |   9 | bCount          | U8   | number of ext. compat.   |
 * |  10 | Reserved        | U8   | 0                        |
 * |  11 | ExtCompat[]     |      | list of ext. compat. d.  |
 *
 * | off | name            | type | description              |
 * |-----+-----------------+------+--------------------------|
 * |   0 | inteface        | U8   | related interface number |
 * |   1 | dwLength        | U32  | length of the descriptor |
 * |   5 | bcdVersion      | U16  | currently supported: 1   |
 * |   7 | wIndex          | U16  | currently supported: 5   |
 * |   9 | wCount          | U16  | number of ext. compat.   |
 * |  11 | ExtProp[]       |      | list of ext. prop. d.    |
 *
 * ExtCompat[] is an array of valid Extended Compatiblity descriptors
 * which have the following format:
 *
 * | off | name                  | type | description                         |
 * |-----+-----------------------+------+-------------------------------------|
 * |   0 | bFirstInterfaceNumber | U8   | index of the interface or of the 1st|
 * |     |                       |      | interface in an IAD group           |
 * |   1 | Reserved              | U8   | 1                                   |
 * |   2 | CompatibleID          | U8[8]| compatible ID string                |
 * |  10 | SubCompatibleID       | U8[8]| subcompatible ID string             |
 * |  18 | Reserved              | U8[6]| 0                                   |
 *
 * ExtProp[] is an array of valid Extended Properties descriptors
 * which have the following format:
 *
 * | off | name                  | type | description                         |
 * |-----+-----------------------+------+-------------------------------------|
 * |   0 | dwSize                | U32  | length of the descriptor            |
 * |   4 | dwPropertyDataType    | U32  | 1..7                                |
 * |   8 | wPropertyNameLength   | U16  | bPropertyName length (NL)           |
 * |  10 | bPropertyName         |U8[NL]| name of this property               |
 * |10+NL| dwPropertyDataLength  | U32  | bPropertyData length (DL)           |
 * |14+NL| bProperty             |U8[DL]| payload of this property            |
     */
    public abstract static class Usb_functionfs_strings_head extends Struct32 {

        public Usb_functionfs_strings_head(AbstractNativeMemory parent, long offset, Byte setMem) {
            super(parent, offset, -1, setMem);
        }

        @__le32
        public abstract int magic();

        @__le32
        public abstract long length();

        @__le32
        public abstract long str_count();

        @__le32
        public abstract long lang_count();
    }


    /*
 * Strings format:
 *
 * | off | name       | type                  | description                |
 * |-----+------------+-----------------------+----------------------------|
 * |   0 | magic      | LE32                  | FUNCTIONFS_STRINGS_MAGIC   |
 * |   4 | length     | LE32                  | length of the data chunk   |
 * |   8 | str_count  | LE32                  | number of strings          |
 * |  12 | lang_count | LE32                  | number of languages        |
 * |  16 | stringtab  | StringTab[lang_count] | table of strings per lang  |
 *
 * For each language there is one stringtab entry (ie. there are lang_count
 * stringtab entires).  Each StringTab has following format:
 *
 * | off | name    | type              | description                        |
 * |-----+---------+-------------------+------------------------------------|
 * |   0 | lang    | LE16              | language code                      |
 * |   2 | strings | String[str_count] | array of strings in given language |
 *
 * For each string there is one strings entry (ie. there are str_count
 * string entries).  Each String is a NUL terminated string encoded in
 * UTF-8.
     */
 /*
 * Events are delivered on the ep0 file descriptor, when the user mode driver
 * reads from this file descriptor after writing the descriptors.  Don't
 * stop polling this descriptor.
     */
    public static interface usb_functionfs_event_type {

        public final static byte FUNCTIONFS_BIND = 0;
        public final static byte FUNCTIONFS_UNBIND = 1;
        public final static byte FUNCTIONFS_ENABLE = 2;
        public final static byte FUNCTIONFS_DISABLE = 3;
        public final static byte FUNCTIONFS_SETUP = 4;
        public final static byte FUNCTIONFS_SUSPEND = 5;
        public final static byte FUNCTIONFS_RESUME = 6;
    };

    /* NOTE:  this structure must stay the same size and layout on
 * both 32-bit and 64-bit kernels.
     */
    public abstract static class Usb_functionfs_event extends Struct32 {

        public Usb_functionfs_event(AbstractNativeMemory parent, long offset, Byte setMem) {
            super(parent, offset, -1, setMem);
            setup = null; //new Usb_ctrlrequest(this, offsetof_setup(), setMem);
        }

        //start-union

        /* SETUP: packet; DATA phase i/o precedes next event
		 *(setup.bmRequestType & USB_DIR_IN) flags direction */
        public final Usb_ctrlrequest setup;

        /* enum usb_functionfs_event_type */
        @__u8
        public abstract byte type();

        @__u8
        public abstract byte[] _pad();
    }


    /* Endpoint ioctls */
 /* The same as in gadgetfs */

 /* IN transfers may be reported to the gadget driver as complete
 *	when the fifo is loaded, before the host reads the data;
 * OUT transfers may be reported to the host's "client" driver as
 *	complete when they're sitting in the FIFO unread.
 * THIS returns how many bytes are "unclaimed" in the endpoint fifo
 * (needed for precise fault handling, when the hardware allows it)
     */
    public final static int FUNCTIONFS_FIFO_STATUS = Ioctl._IO('g', 1);

    /* discards any unclaimed data in the fifo. */
    public final static int FUNCTIONFS_FIFO_FLUSH = Ioctl._IO('g', 2);

    /* resets endpoint halt+toggle; used to implement set_interface.
 * some hardware (like pxa2xx) can't support this.
     */
    public final static int FUNCTIONFS_CLEAR_HALT = Ioctl._IO('g', 3);

    /* Specific for functionfs */

 /*
 * Returns reverse mapping of an interface.  Called on EP0.  If there
 * is no such interface returns -EDOM.  If function is not active
 * returns -ENODEV.
     */
    public final static int FUNCTIONFS_INTERFACE_REVMAP = Ioctl._IO('g', 128);

    /*
 * Returns real bEndpointAddress of an endpoint. If endpoint shuts down
 * during the call, returns -ESHUTDOWN.
     */
    public final static int FUNCTIONFS_ENDPOINT_REVMAP = Ioctl._IO('g', 129);

    /*
 * Returns endpoint descriptor. If endpoint shuts down during the call,
 * returns -ESHUTDOWN.
     */
    public final static int FUNCTIONFS_ENDPOINT_DESC = Ioctl._IOR('g', 130, Ch9.Usb_endpoint_descriptor.Layout.sizeof);

}
