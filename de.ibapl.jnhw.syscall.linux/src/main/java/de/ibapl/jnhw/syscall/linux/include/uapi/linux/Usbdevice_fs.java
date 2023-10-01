/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.memory.MemoryArray;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u16;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u32;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u8;
import de.ibapl.jnhw.unix.sys.Ioctl;
import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;

public final class Usbdevice_fs {

    private Usbdevice_fs() {
        super();
    }

    /* usbdevfs ioctl codes */
    public abstract static class Usbdevfs_ctrltransfer extends Struct {

        public Usbdevfs_ctrltransfer(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        /**
         * Seconds.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/time.h.html">{@code structure
         * timespec}</a>.
         *
         * @return the native value of tv_sec.
         */
        @__u8
        public abstract byte bRequestType();

        public abstract void bRequestType(@__u8 byte bRequestType);

        @__u8
        public abstract byte bRequest();

        public abstract void bRequest(@__u8 byte bRequest);

        @__u16
        public abstract short wValue();

        public abstract void wValue(@__u16 short wValue);

        @__u16
        public abstract short wIndex();

        public abstract void wIndex(@__u16 short wIndex);

        @__u16
        public abstract short wLength();

        public abstract void wLength(@__u16 short wLength);

        @__u32
        public abstract int timeout();

        /* in milliseconds */
        public abstract void timeout(@__u32 int timeout);

        public abstract MemorySegment data();

        public abstract void data(OpaqueMemory data);
    };

    public abstract static class Usbdevfs_bulktransfer extends Struct {

        public Usbdevfs_bulktransfer(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        private Object data;

        public abstract int ep();

        public abstract void eb(int ep);

        public abstract long len();

        /* in milliseconds */
        public abstract long timeout();

        public abstract void timeout(long timeout);

        public void data(OpaqueMemory data) {
            if (data == null) {
                //          dataOpaqueMemory32(null, 0, 0);
            } else {
                //        dataOpaqueMemory32(data, 0, data.sizeInBytes);
            }
            this.data = data;
        }

        public void data(OpaqueMemory data, int off, int len) {
            if (data == null) {
                if (off != 0) {
                    throw new IllegalArgumentException("off must be 0");
                }
                if (len != 0) {
                    throw new IllegalArgumentException("len must be 0");
                }
                //        dataOpaqueMemory32(null, 0, 0);
            } else {
                if ((off < 0) || (off >= data.sizeof())) {
                    throw new IllegalArgumentException("off not in range");
                }
                if ((len < 0) || (len >= data.sizeof())) {
                    throw new IllegalArgumentException("aio_nbytes not in range");
                }
                //      dataOpaqueMemory32(data, off, len);
            }
            this.data = data;
        }

        public void data(ByteBuffer data, int len) {
            if (data == null) {
                //      dataByteBuffer(null, 0, 0);
            } else {
                //    dataByteBuffer(data, data.position(), data.remaining());
            }
            this.data = data;
        }
    };

    public abstract static class Usbdevfs_setinterface extends Struct {

        public Usbdevfs_setinterface(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        public abstract int interface_();

        public abstract int altsetting();

    };

    public abstract static class Usbdevfs_disconnectsignal extends Struct {

        public Usbdevfs_disconnectsignal(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        public abstract int signr();

        public abstract MemorySegment context();

    };

    public final static byte USBDEVFS_MAXDRIVERNAME = (byte) 255;

    public abstract static class Usbdevfs_getdriver
            extends Struct {

        public Usbdevfs_getdriver(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        public abstract int interface_();

        public abstract String driver();

    };

    public abstract static class Usbdevfs_connectinfo extends Struct {

        public Usbdevfs_connectinfo(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        public abstract int devnum();

        public abstract byte slow();

    };

    public abstract static class Usbdevfs_conninfo_ex extends Struct {

        public Usbdevfs_conninfo_ex(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        /* Size of the structure from the kernel's */
 /* point of view. Can be used by userspace */
 /* to determine how much data can be       */
 /* used/trusted.                           */
        @__u32
        public abstract long size();

        /* USB bus number, as enumerated by the    */
 /* kernel, the device is connected to.     */
        @__u32
        public abstract long busnum();

        /* Device address on the bus.              */
        @__u32
        public abstract long devnum();

        /* USB_SPEED_* constants from ch9.h        */
        @__u32
        public abstract long speed();

        /* Number of ports the device is connected */
 /* to on the way to the root hub. It may   */
 /* be bigger than size of 'ports' array so */
 /* userspace can detect overflows.         */
        @__u8
        public abstract short num_ports();

        /* List of ports on the way from the root  */
 /* hub to the device. Current limit in     */
 /* USB specification is 7 tiers (root hub, */
 /* 5 intermediate hubs, device), which     */
 /* gives at most 6 port entries.           */
        @__u8
        public abstract byte[] ports();
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

    public abstract static class Usbdevfs_iso_packet_desc extends Struct {

        public Usbdevfs_iso_packet_desc(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        public abstract long length();

        public abstract long actual_length();

        public abstract int status();
    };

    public abstract static class Usbdevfs_urb extends Struct {

        public Usbdevfs_urb(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
            iso_frame_desc = null;
            throw new RuntimeException("Implement me!");
        }

        public abstract byte type();

        public abstract byte endpoint();

        public abstract int status();

        public abstract int flags();

        public abstract MemorySegment buffer();

        public abstract int buffer_length();

        public abstract int actual_length();

        public abstract int start_frame();

        //begin-union
        /* Only used for isoc urbs */
        public abstract int number_of_packets();

        /* Only used with bulk streams */
        public abstract int stream_id();
        //endunion

        public abstract int error_count();

        /* signal to be sent on completion,
				  or 0 if none should be sent. */
        public abstract int signr();

        //TODO which datatype is usercontext ???
//        public abstract MemorySegment usercontext();
        final MemoryArray<Usbdevfs_iso_packet_desc> iso_frame_desc;
    };

    /* ioctls for talking directly to drivers */
    public abstract static class Usbdevfs_ioctl extends Struct {

        public Usbdevfs_ioctl(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        /* interface 0..N ; negative numbers reserved */
        public abstract int ifno();

        /* MUST encode size + direction of data so the
				 * macros in <asm/ioctl.h> give correct values */
        public abstract int ioctl_code();

        /* param buffer (in, or out) */
        public abstract MemorySegment data();
    };

    /* You can do most things with hubs just through control messages,
 * except find out what device connects to what port. */
    public abstract static class Usbdevfs_hub_portinfo extends Struct {

        public Usbdevfs_hub_portinfo(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        /* number of downstream ports in this hub */
        public abstract byte nports();

        /* e.g. port 3 connects to device 27 */
        public abstract String port();
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

    public abstract static class Usbdevfs_disconnect_claim extends Struct {

        public Usbdevfs_disconnect_claim(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        public abstract int interface_();

        public abstract int flags();

        public abstract String driver();
    };

    public abstract static class Usbdevfs_streams extends Struct {

        public Usbdevfs_streams(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        /* Not used by USBDEVFS_FREE_STREAMS */
        public abstract long num_streams();

        public abstract long num_eps();

        public abstract byte[] eps();
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
