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
 /* SPDX-License-Identifier: GPL-2.0+ WITH Linux-syscall-note */
/** ************************************************************************** */

/*
 *	usbdevice_fs.h  --  USB device file system.
 *
 *	Copyright (C) 2000
 *          Thomas Sailer (sailer@ife.ee.ethz.ch)
 *
 *	This program is free software; you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation; either version 2 of the License, or
 *	(at your option) any later version.
 *
 *	This program is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this program; if not, write to the Free Software
 *	Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 *  History:
 *   0.1  04.01.2000  Created
 */
/** ************************************************************************** */

/* --------------------------------------------------------------------- */
package de.ibapl.jnhw.syscall.linux.include.uapi.linux;

import de.ibapl.jnhw.common.annotation.AlignOf;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.memory.NativeAddressHolder;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.memory.StructArray32;
import static de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u8;
import static de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u16;
import static de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u32;
import de.ibapl.jnhw.unix.sys.Ioctl;
import java.nio.ByteBuffer;

public final class Usbdevice_fs {

    private Usbdevice_fs() {
        super();
    }

    /* usbdevfs ioctl codes */
    public static class Usbdevfs_ctrltransfer extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_ctrltransfer(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        /**
         * Seconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @return the native value of tv_sec.
         */
        @__u8
        public native byte bRequestType();

        public native void bRequestType(@__u8 byte bRequestType);

        @__u8
        public native byte bRequest();

        public native void bRequest(@__u8 byte bRequest);

        @__u16
        public native short wValue();

        public native void wValue(@__u16 short wValue);

        @__u16
        public native short wIndex();

        public native void wIndex(@__u16 short wIndex);

        @__u16
        public native short wLength();

        public native void wLength(@__u16 short wLength);

        @__u32
        public native int timeout();

        /* in milliseconds */
        public native void timeout(@__u32 int timeout);

        public native NativeAddressHolder data();

        public native void data(OpaqueMemory32 data);
    };

    public static class Usbdevfs_bulktransfer extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_bulktransfer(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        private Object data;

        public native int ep();

        public native void eb(int ep);

        public native long len();

        /* in milliseconds */
        public native long timeout();

        public native void timeout(long timeout);

        private native NativeAddressHolder data0();

        private native void dataByteBuffer(ByteBuffer aio_buf, int offset, int length);

        private native void dataOpaqueMemory32(OpaqueMemory32 aio_buf, int offset, int length);

        public void data(OpaqueMemory32 data) {
            if (data == null) {
                dataOpaqueMemory32(null, 0, 0);
            } else {
                dataOpaqueMemory32(data, 0, data.sizeInBytes);
            }
            this.data = data;
        }

        public void data(OpaqueMemory32 data, int off, int len) {
            if (data == null) {
                if (off != 0) {
                    throw new IllegalArgumentException("off must be 0");
                }
                if (len != 0) {
                    throw new IllegalArgumentException("len must be 0");
                }
                dataOpaqueMemory32(null, 0, 0);
            } else {
                if ((off < 0) || (off >= data.sizeInBytes)) {
                    throw new IllegalArgumentException("off not in range");
                }
                if ((len < 0) || (len >= data.sizeInBytes)) {
                    throw new IllegalArgumentException("aio_nbytes not in range");
                }
                dataOpaqueMemory32(data, off, len);
            }
            this.data = data;
        }

        public void data(ByteBuffer data, int len) {
            if (data == null) {
                dataByteBuffer(null, 0, 0);
            } else {
                dataByteBuffer(data, data.position(), data.remaining());
            }
            this.data = data;
        }
    };

    public static class Usbdevfs_setinterface extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_setinterface(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        public native int interface_();

        public native int altsetting();

    };

    public static class Usbdevfs_disconnectsignal extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_disconnectsignal(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        public native int signr();

        public native NativeAddressHolder context();

    };

    public final static byte USBDEVFS_MAXDRIVERNAME = (byte) 255;

    public static class Usbdevfs_getdriver
            extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_getdriver(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        public native int interface_();

        public native String driver();

    };

    public static class Usbdevfs_connectinfo extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_connectinfo(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        public native int devnum();

        public native byte slow();

    };

    public static class Usbdevfs_conninfo_ex extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_conninfo_ex(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        /* Size of the structure from the kernel's */
 /* point of view. Can be used by userspace */
 /* to determine how much data can be       */
 /* used/trusted.                           */
        @__u32
        public native long size();

        /* USB bus number, as enumerated by the    */
 /* kernel, the device is connected to.     */
        @__u32
        public native long busnum();

        /* Device address on the bus.              */
        @__u32
        public native long devnum();

        /* USB_SPEED_* constants from ch9.h        */
        @__u32
        public native long speed();

        /* Number of ports the device is connected */
 /* to on the way to the root hub. It may   */
 /* be bigger than size of 'ports' array so */
 /* userspace can detect overflows.         */
        @__u8
        public native short num_ports();

        /* List of ports on the way from the root  */
 /* hub to the device. Current limit in     */
 /* USB specification is 7 tiers (root hub, */
 /* 5 intermediate hubs, device), which     */
 /* gives at most 6 port entries.           */
        @__u8
        public native byte[] ports();
    };

    public final static byte USBDEVFS_URB_SHORT_NOT_OK = 0x01;
    public final static byte USBDEVFS_URB_ISO_ASAP = 0x02;
    public final static byte USBDEVFS_URB_BULK_CONTINUATION = 0x04;
    /* Not used */
    public final static byte USBDEVFS_URB_NO_FSBR = 0x20;
    public final static byte USBDEVFS_URB_ZERO_PACKET = 0x40;
    public final static byte USBDEVFS_URB_NO_INTERRUPT = (byte) 0x80;

    public final static byte USBDEVFS_URB_TYPE_ISO = 0;
    public final static byte USBDEVFS_URB_TYPE_INTERRUPT = 1;
    public final static byte USBDEVFS_URB_TYPE_CONTROL = 2;
    public final static byte USBDEVFS_URB_TYPE_BULK = 3;

    public static class Usbdevfs_iso_packet_desc extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_iso_packet_desc(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        public native long length();

        public native long actual_length();

        public native int status();
    };

    public static class Usbdevfs_urb extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public static native int offsetof_iso_frame_desc();

        public Usbdevfs_urb(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
            iso_frame_desc = null;
            throw new RuntimeException("Implement me!");
        }

        public native byte type();

        public native byte endpoint();

        public native int status();

        public native int flags();

        public native NativeAddressHolder buffer();

        public native int buffer_length();

        public native int actual_length();

        public native int start_frame();

        //begin-union
        /* Only used for isoc urbs */
        public native int number_of_packets();

        /* Only used with bulk streams */
        public native int stream_id();
        //endunion

        public native int error_count();

        /* signal to be sent on completion,
				  or 0 if none should be sent. */
        public native int signr();

        public native NativeAddressHolder usercontext();
        final StructArray32<Usbdevfs_iso_packet_desc> iso_frame_desc;
    };

    /* ioctls for talking directly to drivers */
    public static class Usbdevfs_ioctl extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_ioctl(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        /* interface 0..N ; negative numbers reserved */
        public native int ifno();

        /* MUST encode size + direction of data so the
				 * macros in <asm/ioctl.h> give correct values */
        public native int ioctl_code();

        /* param buffer (in, or out) */
        public native NativeAddressHolder data();
    };

    /* You can do most things with hubs just through control messages,
 * except find out what device connects to what port. */
    public static class Usbdevfs_hub_portinfo extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_hub_portinfo(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        /* number of downstream ports in this hub */
        public native byte nports();

        /* e.g. port 3 connects to device 27 */
        public native String port();
    };

    /* System and bus capability flags */
    public final static short USBDEVFS_CAP_ZERO_PACKET = 0x01;
    public final static short USBDEVFS_CAP_BULK_CONTINUATION = 0x02;
    public final static short USBDEVFS_CAP_NO_PACKET_SIZE_LIM = 0x04;
    public final static short USBDEVFS_CAP_BULK_SCATTER_GATHER = 0x08;
    public final static short USBDEVFS_CAP_REAP_AFTER_DISCONNECT = 0x10;
    public final static short USBDEVFS_CAP_MMAP = 0x20;
    public final static short USBDEVFS_CAP_DROP_PRIVILEGES = 0x40;
    public final static short USBDEVFS_CAP_CONNINFO_EX = 0x80;
    public final static short USBDEVFS_CAP_SUSPEND = 0x100;

    /* USBDEVFS_DISCONNECT_CLAIM flags & struct */

 /* disconnect-and-claim if the driver matches the driver field */
    public final static byte USBDEVFS_DISCONNECT_CLAIM_IF_DRIVER = 0x01;
    /* disconnect-and-claim except when the driver matches the driver field */
    public final static byte USBDEVFS_DISCONNECT_CLAIM_EXCEPT_DRIVER = 0x02;

    public static class Usbdevfs_disconnect_claim extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_disconnect_claim(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        public native int interface_();

        public native int flags();

        public native String driver();
    };

    public static class Usbdevfs_streams extends Struct32 {

        /**
         * Get the real size of struct timespec natively.
         *
         * @return the native value sizeof(struct timespec).
         */
        @SizeOf
        public static native int sizeof();

        @AlignOf
        public static native int alignof();

        public Usbdevfs_streams(OpaqueMemory32 parent, int offset, SetMem setMem) {
            super(parent, offset, sizeof(), setMem);
        }

        /* Not used by USBDEVFS_FREE_STREAMS */
        public native long num_streams();

        public native long num_eps();

        public native byte[] eps();
    };

    /*
 * USB_SPEED_* values returned by USBDEVFS_GET_SPEED are defined in
 * linux/usb/ch9.h
     */
 /*TODO
    @Define
    public final static int USBDEVFS_CONTROL;
    @Define
    public final static int USBDEVFS_BULK;
    @Define
    public final static int USBDEVFS_RESETEP;
    @Define
    public final static int USBDEVFS_SETINTERFACE;
    @Define
    public final static int USBDEVFS_SETCONFIGURATION;
    @Define
    public final static int USBDEVFS_GETDRIVER;
    @Define
    public final static int USBDEVFS_SUBMITURB;
    @Define
    public final static int USBDEVFS_DISCARDURB;
    @Define
    public final static int USBDEVFS_REAPURB;
    @Define
    public final static int USBDEVFS_REAPURBNDELAY;
    @Define
    public final static int USBDEVFS_DISCSIGNAL;
    @Define
    public final static int USBDEVFS_CLAIMINTERFACE;
    @Define
    public final static int USBDEVFS_RELEASEINTERFACE;

    @Define
    public final static int USBDEVFS_CONNECTINFO;
    @Define
    public final static int USBDEVFS_IOCTL;
    @Define
    public final static int USBDEVFS_HUB_PORTINFO;
    @Define
    public final static int USBDEVFS_RESET;
    @Define
    public final static int USBDEVFS_CLEAR_HALT;
    @Define
    public final static int USBDEVFS_DISCONNECT;
    @Define
    public final static int USBDEVFS_CONNECT;
    @Define
    public final static int USBDEVFS_CLAIM_PORT;
    @Define
    public final static int USBDEVFS_RELEASE_PORT;
    @Define
    public final static int USBDEVFS_GET_CAPABILITIES;
    @Define
    public final static int USBDEVFS_DISCONNECT_CLAIM;
    @Define
    public final static int USBDEVFS_ALLOC_STREAMS;
    @Define
    public final static int USBDEVFS_FREE_STREAMS;
    @Define
    public final static int USBDEVFS_DROP_PRIVILEGES;
    @Define
    public final static int USBDEVFS_GET_SPEED;
     */
 /*
 * Returns struct usbdevfs_conninfo_ex; length is variable to allow
 * extending size of the data returned.
     */
    public static int USBDEVFS_CONNINFO_EX(int len) {
        return Ioctl._IOC(Ioctl._IOC_READ.get(), 'U', 32, len);
    }

    @Define
    public final static int USBDEVFS_FORBID_SUSPEND = Ioctl._IO('U', 33);
    @Define
    public final static int USBDEVFS_ALLOW_SUSPEND = Ioctl._IO('U', 34);
    @Define
    public final static int USBDEVFS_WAIT_FOR_RESUME = Ioctl._IO('U', 35);

}
