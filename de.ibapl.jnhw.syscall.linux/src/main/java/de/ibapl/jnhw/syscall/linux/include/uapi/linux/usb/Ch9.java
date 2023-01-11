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
 /* SPDX-License-Identifier: GPL-2.0 WITH Linux-syscall-note */
 /*
 * This file holds USB constants and structures that are needed for
 * USB device APIs.  These are used by the USB device model, which is
 * defined in chapter 9 of the USB 2.0 specification and in the
 * Wireless USB 1.0 (spread around).  Linux has several APIs in C that
 * need these:
 *
 * - the master/host side Linux-USB kernel driver API;
 * - the "usbfs" user space API; and
 * - the Linux "gadget" slave/device/peripheral side driver API.
 *
 * USB 2.0 adds an additional "On The Go" (OTG) mode, which lets systems
 * act either as a USB master/host or as a USB slave/device.  That means
 * the master and slave side APIs benefit from working well together.
 *
 * There's also "Wireless USB", using low power short range radios for
 * peripheral interconnection but otherwise building on the USB framework.
 *
 * Note all descriptors are declared '__attribute__((packed))' so that:
 *
 * [a] they never get padded, either internally (USB spec writers
 *     probably handled that) or externally;
 *
 * [b] so that accessing bigger-than-a-bytes fields will never
 *     generate bus errors on any platform, even when the location of
 *     its descriptor inside a bundle isn't "naturally aligned", and
 *
 * [c] for consistency, removing all doubt even when it appears to
 *     someone that the two other points are non-issues for that
 *     particular descriptor type.
 */
package de.ibapl.jnhw.syscall.linux.include.uapi.linux.usb;

import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayout;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactory;
import de.ibapl.jnhw.common.memory.layout.StructLayoutFactoryImpl;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.syscall.linux.AbstractLinuxSyscallStruct;
import de.ibapl.jnhw.syscall.linux.annotation.SysFs;
import de.ibapl.jnhw.syscall.linux.include.linux.Hid;
import de.ibapl.jnhw.syscall.linux.include.linux.usb.Uas;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__le16;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__le32;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u16;
import de.ibapl.jnhw.syscall.linux.uapi.asm_generic.Types.__u8;
import java.io.IOException;
import java.lang.foreign.MemorySegment;

/**
 *
 * @author aploese
 */
@Include("linux/usb/ch9.h")
public interface Ch9 {


    /*-------------------------------------------------------------------------*/

 /* CONTROL REQUEST SUPPORT */

 /*
 * USB directions
 *
 * This bit flag is used in endpoint descriptors' bEndpointAddress field.
 * It's also one of three fields in control requests bRequestType.
     */
    public final static short USB_DIR_OUT = 0;
    /* to device */
    public final static short USB_DIR_IN = 0x80;

    /* to host */

 /*
 * USB types, the second of three bRequestType fields
     */
    public final static byte USB_TYPE_MASK = 0x03 << 5;
    public final static byte USB_TYPE_STANDARD = 0x00 << 5;
    public final static byte USB_TYPE_CLASS = 0x01 << 5;
    public final static byte USB_TYPE_VENDOR = 0x02 << 5;
    public final static byte USB_TYPE_RESERVED = 0x03 << 5;

    /*
 * USB recipients, the third of three bRequestType fields
     */
    public final static byte USB_RECIP_MASK = 0x1f;
    public final static byte USB_RECIP_DEVICE = 0x00;
    public final static byte USB_RECIP_INTERFACE = 0x01;
    public final static byte USB_RECIP_ENDPOINT = 0x02;
    public final static byte USB_RECIP_OTHER = 0x03;
    /* From Wireless USB 1.0 */
    public final static byte USB_RECIP_PORT = 0x04;
    public final static byte USB_RECIP_RPIPE = 0x05;

    /*
 * Standard requests, for the bRequest field of a SETUP packet.
 *
 * These are qualified by the bRequestType field, so that for example
 * TYPE_CLASS or TYPE_VENDOR specific feature flags could be retrieved
 * by a GET_STATUS request.
     */
    public final static byte USB_REQ_GET_STATUS = 0x00;
    public final static byte USB_REQ_CLEAR_FEATURE = 0x01;
    public final static byte USB_REQ_SET_FEATURE = 0x03;
    public final static byte USB_REQ_SET_ADDRESS = 0x05;
    public final static byte USB_REQ_GET_DESCRIPTOR = 0x06;
    public final static byte USB_REQ_SET_DESCRIPTOR = 0x07;
    public final static byte USB_REQ_GET_CONFIGURATION = 0x08;
    public final static byte USB_REQ_SET_CONFIGURATION = 0x09;
    public final static byte USB_REQ_GET_INTERFACE = 0x0A;
    public final static byte USB_REQ_SET_INTERFACE = 0x0B;
    public final static byte USB_REQ_SYNCH_FRAME = 0x0C;
    public final static byte USB_REQ_SET_SEL = 0x30;
    public final static byte USB_REQ_SET_ISOCH_DELAY = 0x31;

    /* Wireless USB */
    public final static byte USB_REQ_SET_ENCRYPTION = 0x0D;
    public final static byte USB_REQ_GET_ENCRYPTION = 0x0E;
    public final static byte USB_REQ_RPIPE_ABORT = 0x0E;
    public final static byte USB_REQ_SET_HANDSHAKE = 0x0F;
    public final static byte USB_REQ_RPIPE_RESET = 0x0F;
    public final static byte USB_REQ_GET_HANDSHAKE = 0x10;
    public final static byte USB_REQ_SET_CONNECTION = 0x11;
    public final static byte USB_REQ_SET_SECURITY_DATA = 0x12;
    public final static byte USB_REQ_GET_SECURITY_DATA = 0x13;
    public final static byte USB_REQ_SET_WUSB_DATA = 0x14;
    public final static byte USB_REQ_LOOPBACK_DATA_WRITE = 0x15;
    public final static byte USB_REQ_LOOPBACK_DATA_READ = 0x16;
    public final static byte USB_REQ_SET_INTERFACE_DS = 0x17;

    /* specific requests for USB Power Delivery */
    public final static byte USB_REQ_GET_PARTNER_PDO = 20;
    public final static byte USB_REQ_GET_BATTERY_STATUS = 21;
    public final static byte USB_REQ_SET_PDO = 22;
    public final static byte USB_REQ_GET_VDM = 23;
    public final static byte USB_REQ_SEND_VDM = 24;

    /* The Link Power Management (LPM) ECN defines USB_REQ_TEST_AND_SET command,
 * used by hubs to put ports into a new L1 suspend state, except that it
 * forgot to define its number ...
     */

 /*
 * USB feature flags are written using USB_REQ_{CLEAR,SET}_FEATURE, and
 * are read as a bit array returned by USB_REQ_GET_STATUS.  (So there
 * are at most sixteen features of each type.)  Hubs may also support a
 * new USB_REQ_TEST_AND_SET_FEATURE to put ports into L1 suspend.
     */
 /* (read only) */
    public final static byte USB_DEVICE_SELF_POWERED = 0;
    /* dev may initiate wakeup */
    public final static byte USB_DEVICE_REMOTE_WAKEUP = 1;
    /* (wired high speed only) */
    public final static byte USB_DEVICE_TEST_MODE = 2;
    /* (wireless) */
    public final static byte USB_DEVICE_BATTERY = 2;
    /* (otg) dev may initiate HNP */
    public final static byte USB_DEVICE_B_HNP_ENABLE = 3;
    /* (wireless)*/
    public final static byte USB_DEVICE_WUSB_DEVICE = 3;
    /* (otg) RH port supports HNP */
    public final static byte USB_DEVICE_A_HNP_SUPPORT = 4;
    /* (otg) other RH port does */
    public final static byte USB_DEVICE_A_ALT_HNP_SUPPORT = 5;
    /* (special devices only) */
    public final static byte USB_DEVICE_DEBUG_MODE = 6;

    /*
 * Test Mode Selectors
 * See USB 2.0 spec Table 9-7
     */
    public final static byte TEST_J = 1;
    public final static byte TEST_K = 2;
    public final static byte TEST_SE0_NAK = 3;
    public final static byte TEST_PACKET = 4;
    public final static byte TEST_FORCE_EN = 5;

    /* Status Type */
    public final static byte USB_STATUS_TYPE_STANDARD = 0;
    public final static byte USB_STATUS_TYPE_PTM = 1;

    /*
 * New Feature Selectors as added by USB 3.0
 * See USB 3.0 spec Table 9-7
     */
 /* dev may initiate U1 transition */
    public final static byte USB_DEVICE_U1_ENABLE = 48;
    /* dev may initiate U2 transition */
    public final static byte USB_DEVICE_U2_ENABLE = 49;
    /* dev may send LTM */
    public final static byte USB_DEVICE_LTM_ENABLE = 50;
    /* function suspend */
    public final static short USB_INTRF_FUNC_SUSPEND = 0;

    public final static short USB_INTR_FUNC_SUSPEND_OPT_MASK = (short) 0xFF00;
    /*
 * Suspend Options, Table 9-8 USB 3.0 spec
     */
    public final static byte USB_INTRF_FUNC_SUSPEND_LP = (byte) (1 << (8 + 0));
    public final static byte USB_INTRF_FUNC_SUSPEND_RW = (byte) (1 << (8 + 1));

    /*
 * Interface status, Figure 9-5 USB 3.0 spec
     */
    public final static byte USB_INTRF_STAT_FUNC_RW_CAP = 1;
    public final static byte USB_INTRF_STAT_FUNC_RW = 2;

    /* IN/OUT will STALL */
    public final static byte USB_ENDPOINT_HALT = 0;

    /* Bit array elements as returned by the USB_REQ_GET_STATUS request. */
 /* transition into U1 state */
    public final static byte USB_DEV_STAT_U1_ENABLED = 2;
    /* transition into U2 state */
    public final static byte USB_DEV_STAT_U2_ENABLED = 3;
    /* Latency tolerance messages */
    public final static byte USB_DEV_STAT_LTM_ENABLED = 4;

    /*
 * Feature selectors from Table 9-8 USB Power Delivery spec
     */
    public final static byte USB_DEVICE_BATTERY_WAKE_MASK = 40;
    public final static byte USB_DEVICE_OS_IS_PD_AWARE = 41;
    public final static byte USB_DEVICE_POLICY_MODE = 42;
    public final static byte USB_PORT_PR_SWAP = 43;
    public final static byte USB_PORT_GOTO_MIN = 44;
    public final static byte USB_PORT_RETURN_POWER = 45;
    public final static byte USB_PORT_ACCEPT_PD_REQUEST = 46;
    public final static byte USB_PORT_REJECT_PD_REQUEST = 47;
    public final static byte USB_PORT_PORT_PD_RESET = 48;
    public final static byte USB_PORT_C_PORT_PD_CHANGE = 49;
    public final static byte USB_PORT_CABLE_PD_RESET = 50;
    public final static byte USB_DEVICE_CHARGING_POLICY = 54;

    /**
     * struct usb_ctrlrequest - SETUP data for a USB device control request
     *
     * @bRequestType: matches the USB bmRequestType field
     * @bRequest: matches the USB bRequest field
     * @wValue: matches the USB wValue field (le16 byte order)
     * @wIndex: matches the USB wIndex field (le16 byte order)
     * @wLength: matches the USB wLength field (le16 byte order)
     *
     * This structure is used to send control requests to a USB device. It
     * matches the different fields of the USB 2.0 Spec section 9.3, table 9-2.
     * See the USB spec for a fuller description of the different fields, and
     * what they are used for.
     *
     * Note that the driver for any interface can issue control requests. For
     * most devices, interfaces don't coordinate with each other, so such
     * requests may be made at any time.
     */
    public abstract static class Usb_ctrlrequest extends AbstractLinuxSyscallStruct {

        public static final class Layout extends StructLayout {

            protected final StructLayoutFactory slf = new StructLayoutFactoryImpl(StructLayoutFactoryImpl.Type.STRUCT, Alignment.AT_1);
            public final int bRequestType;
            public final int bRequest;
            public final int wValue;
            public final int wIndex;
            public final int wLength;

            protected Layout() {
                bRequestType = (int) slf.uint8_t();
                bRequest = (int) slf.uint8_t();
                wValue = (int) slf.uint8_t();
                wIndex = (int) slf.uint8_t();
                wLength = (int) slf.uint8_t();
            }

            public int getSizeof() {
                return (int) slf.getSizeof();
            }

            public Alignment getAlignment() {
                return slf.getAlignment();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_ctrlrequest(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public byte bRequestType() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bRequestType);
        }

        @__u8
        public byte bRequest() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bRequest);
        }

        @__le16
        public short wValue() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.wValue);
        }

        @__le16
        public int wIndex() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, LAYOUT.wIndex);
        }

        @__le16
        public int wLength() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, LAYOUT.wLength);
        }
    }

    /*-------------------------------------------------------------------------*/

 /*
 * STANDARD DESCRIPTORS ... as returned by GET_DESCRIPTOR, or
 * (rarely) accepted by SET_DESCRIPTOR.
 *
 * Note that all multi-byte values here are encoded in little endian
 * byte order "on the wire".  Within the kernel and when exposed
 * through the Linux-USB APIs, they are not converted to cpu byte
 * order; it is the responsibility of the client code to do this.
 * The single exception is when device and configuration descriptors (but
 * not other descriptors) are read from character devices
 * (i.e. /dev/bus/usb/BBB/DDD);
 * in this case the fields are converted to host endianness by the kernel.
     */

 /*
 * Descriptor types ... USB 2.0 spec table 9.5
     */
    public final static byte USB_DT_DEVICE = 0x01;
    public final static byte USB_DT_CONFIG = 0x02;
    public final static byte USB_DT_STRING = 0x03;
    public final static byte USB_DT_INTERFACE = 0x04;
    public final static byte USB_DT_ENDPOINT = 0x05;
    public final static byte USB_DT_DEVICE_QUALIFIER = 0x06;
    public final static byte USB_DT_OTHER_SPEED_CONFIG = 0x07;
    /* these are from a minor usb 2.0 revision (ECN) */
    public final static byte USB_DT_INTERFACE_POWER = 0x08;
    public final static byte USB_DT_OTG = 0x09;
    public final static byte USB_DT_DEBUG = 0x0a;
    /* these are from the Wireless USB spec */
    public final static byte USB_DT_INTERFACE_ASSOCIATION = 0x0b;
    public final static byte USB_DT_SECURITY = 0x0c;
    public final static byte USB_DT_KEY = 0x0d;
    public final static byte USB_DT_ENCRYPTION_TYPE = 0x0e;
    public final static byte USB_DT_BOS = 0x0f;
    public final static byte USB_DT_DEVICE_CAPABILITY = 0x10;
    public final static byte USB_DT_WIRELESS_ENDPOINT_COMP = 0x11;
    public final static byte USB_DT_WIRE_ADAPTER = 0x21;
    public final static byte USB_DT_RPIPE = 0x22;
    /* From the T10 UAS specification */
    public final static byte USB_DT_CS_RADIO_CONTROL = 0x23;
    /* From the USB 3.0 spec */
    public final static byte USB_DT_PIPE_USAGE = 0x24;
    /* From the USB 3.1 spec */
    public final static byte USB_DT_SS_ENDPOINT_COMP = 0x30;
    public final static byte USB_DT_SSP_ISOC_ENDPOINT_COMP = 0x31;
    /* Conventional codes for class-specific descriptors.  The convention is
 * defined in the USB "Common Class" Spec (3.11).  Individual class specs
 * are authoritative for their usage, not the "common class" writeup.
     */
    public final static byte USB_DT_CS_DEVICE = (USB_TYPE_CLASS | USB_DT_DEVICE);
    public final static byte USB_DT_CS_CONFIG = (USB_TYPE_CLASS | USB_DT_CONFIG);
    public final static byte USB_DT_CS_STRING = (USB_TYPE_CLASS | USB_DT_STRING);
    public final static byte USB_DT_CS_INTERFACE = (USB_TYPE_CLASS | USB_DT_INTERFACE);
    public final static byte USB_DT_CS_ENDPOINT = (USB_TYPE_CLASS | USB_DT_ENDPOINT);

    /* All standard descriptors have these 2 fields at the beginning */
    public final static class Usb_descriptor_header extends AbstractDescriptor {

        public static final class Layout extends AbstractDescriptor.Layout {

            public final static byte sizeof = _sizeof;
        }

        public Usb_descriptor_header(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Layout.sizeof);
        }

        @Override
        protected void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
            //no-op
        }

        /**
         * insert at the same offset as the appropirate descriptor.
         *
         * @return
         */
        public AbstractDescriptor toDescriptor(MemorySegment memorySegment, long currentPos) {
            AbstractDescriptor result;
            switch (bDescriptorType()) {
                case USB_DT_DEVICE:
                    result = new Usb_device_descriptor(memorySegment, currentPos);
                    break;
                case USB_DT_CONFIG:
                    result = new Usb_config_descriptor(memorySegment, currentPos);
                    break;
                /*
                case USB_DT_STRING:
                    throw new RuntimeException("Not implemented");
                 */
                case USB_DT_INTERFACE:
                    result = new Usb_interface_descriptor(memorySegment, currentPos);
                    break;
                case USB_DT_ENDPOINT:
                    result = new Usb_endpoint_descriptor(memorySegment, currentPos, bLength());
                    break;
                case USB_DT_WIRE_ADAPTER:
                    result = new Hid.Hid_descriptor(memorySegment, currentPos, bLength());
                    break;
                case USB_DT_SS_ENDPOINT_COMP:
                    result = new Usb_ss_ep_comp_descriptor(memorySegment, currentPos);
                    break;
                case USB_DT_PIPE_USAGE:
                    result = new Uas.Usb_pipe_usage_descriptor(memorySegment, currentPos, bLength());
                    break;
                case USB_DT_INTERFACE_ASSOCIATION:
                    result = new Usb_interface_assoc_descriptor(memorySegment, currentPos);
                    break;
                default:
                    result = new UsbUnknownDescriptor(memorySegment, currentPos, bLength());
            }
            if (result.sizeof() != bLength()) {
                throw new RuntimeException("bLength mismatch");
            }
            return result;
        }

    }


    /*-------------------------------------------------------------------------*/
    /**
     * found in /sys/bus/usb/devices/*\/descriptors for real devices.
     */
    /* USB_DT_DEVICE: Device descriptor */
    @SysFs("/sys/bus/usb/devices/*/descriptors")
    public final static class Usb_device_descriptor extends AbstractDescriptor {

        public final static class Layout extends AbstractDescriptor.Layout {

            public final static byte bcdUSB = _sizeof;
            public final static byte bDeviceClass = bcdUSB + __LE16;
            public final static byte bDeviceSubClass = bDeviceClass + __U8;
            public final static byte bDeviceProtocol = bDeviceSubClass + __U8;
            public final static byte bMaxPacketSize0 = bDeviceProtocol + __U8;
            public final static byte idVendor = bMaxPacketSize0 + __U8;
            public final static byte idProduct = idVendor + __LE16;
            public final static byte bcdDevice = idProduct + __LE16;
            public final static byte iManufacturer = bcdDevice + __LE16;
            public final static byte iProduct = iManufacturer + __U8;
            public final static byte iSerialNumber = iProduct + __U8;
            public final static byte bNumConfigurations = iSerialNumber + __U8;

            public final static byte sizeof = bNumConfigurations + __U8;

        }

        public final static byte USB_DT_DEVICE_SIZE = 18;

        public Usb_device_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Layout.sizeof);
        }

        @__le16
        public short bcdUSB() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, Layout.bcdUSB);
        }

        @__u8
        public byte bDeviceClass() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bDeviceClass);
        }

        @__u8
        public byte bDeviceSubClass() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bDeviceSubClass);
        }

        @__u8
        public byte bDeviceProtocol() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bDeviceProtocol);
        }

        @__u8
        public byte bMaxPacketSize0() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bMaxPacketSize0);
        }

        @__le16
        public short idVendor() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, Layout.idVendor);
        }

        @__le16
        public short idProduct() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, Layout.idProduct);
        }

        @__le16
        public short bcdDevice() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, Layout.bcdDevice);
        }

        @__u8
        public byte iManufacturer() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.iManufacturer);
        }

        @__u8
        public byte iProduct() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.iProduct);
        }

        @__u8
        public byte iSerialNumber() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.iSerialNumber);
        }

        @__u8
        public short bNumConfigurations() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bNumConfigurations);
        }

        @Override
        public void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
            jsb.appendStringMember("bcdUSB", bcd2String(bcdUSB()));
            jsb.appendByteMember("bDeviceClass", bDeviceClass());
            jsb.appendByteMember("bDeviceSubClass", bDeviceSubClass());
            jsb.appendByteMember("bDeviceProtocol", bDeviceProtocol());
            jsb.appendByteMember("bMaxPacketSize0", bMaxPacketSize0());
            jsb.appendHexShortMember("idVendor", idVendor());
            jsb.appendHexShortMember("idProduct", idProduct());
            jsb.appendStringMember("bcdDevice", bcd2String(bcdDevice()));
            jsb.appendByteMember("iManufacturer", iManufacturer());
            jsb.appendByteMember("iProduct", iProduct());
            jsb.appendByteMember("iSerialNumber", iSerialNumber());
            jsb.appendShortMember("bNumConfigurations", bNumConfigurations());
        }
        //TODO move to better place ....

    }

    /*
 * Device and/or Interface Class codes
 * as found in bDeviceClass or bInterfaceClass
 * and defined by www.usb.org documents
     */
 /* for DeviceClass */
    public final static byte USB_CLASS_PER_INTERFACE = 0;
    public final static byte USB_CLASS_AUDIO = 1;
    public final static byte USB_CLASS_COMM = 2;
    public final static byte USB_CLASS_HID = 3;
    public final static byte USB_CLASS_PHYSICAL = 5;
    public final static byte USB_CLASS_STILL_IMAGE = 6;
    public final static byte USB_CLASS_PRINTER = 7;
    public final static byte USB_CLASS_MASS_STORAGE = 8;
    public final static byte USB_CLASS_HUB = 9;
    public final static byte USB_CLASS_CDC_DATA = 0x0a;
    /* chip+ smart card */
    public final static byte USB_CLASS_CSCID = 0x0b;
    /* content security */
    public final static byte USB_CLASS_CONTENT_SEC = 0x0d;
    public final static byte USB_CLASS_VIDEO = 0x0e;
    public final static byte USB_CLASS_WIRELESS_CONTROLLER = (byte) 0xe0;
    public final static byte USB_CLASS_MISC = (byte) 0xef;
    public final static byte USB_CLASS_APP_SPEC = (byte) 0xfe;
    public final static byte USB_CLASS_VENDOR_SPEC = (byte) 0xff;

    public final static byte USB_SUBCLASS_VENDOR_SPEC = (byte) 0xff;

    /*-------------------------------------------------------------------------*/

 /* USB_DT_CONFIG: Configuration descriptor information.
 *
 * USB_DT_OTHER_SPEED_CONFIG is the same descriptor, except that the
 * descriptor type is different.  Highspeed-capable devices can look
 * different depending on what speed they're currently running.  Only
 * devices with a USB_DT_DEVICE_QUALIFIER have any OTHER_SPEED_CONFIG
 * descriptors.
     */
    public final static class Usb_config_descriptor extends AbstractDescriptor {

        public final static class Layout extends AbstractDescriptor.Layout {

            public final static byte wTotalLength = _sizeof;
            public final static byte bNumInterfaces = wTotalLength + __LE16;
            public final static byte bConfigurationValue = bNumInterfaces + __U8;
            public final static byte iConfiguration = bConfigurationValue + __U8;
            public final static byte bmAttributes = iConfiguration + __U8;
            public final static byte bMaxPower = bmAttributes + __U8;

            public final static byte sizeof = bMaxPower + __U8;

        }

        public final static byte USB_DT_CONFIG_SIZE = 9;

        public Usb_config_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Layout.sizeof);
        }

        @__le16
        public int wTotalLength() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, Layout.wTotalLength);
        }

        @__u8
        public short bNumInterfaces() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, Layout.bNumInterfaces);
        }

        @__u8
        public byte bConfigurationValue() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bConfigurationValue);
        }

        @__u8
        public byte iConfiguration() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.iConfiguration);
        }

        @__u8
        public byte bmAttributes() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bmAttributes);
        }

        @__u8
        public short bMaxPower() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bMaxPower);
        }

        @Override
        protected void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
            jsb.appendIntMember("wTotalLength", wTotalLength());
            jsb.appendShortMember("bNumInterfaces", bNumInterfaces());
            jsb.appendByteMember("bConfigurationValue", bConfigurationValue());
            jsb.appendByteMember("iConfiguration", iConfiguration());
            jsb.appendHexByteMember("bmAttributes", bmAttributes());
            jsb.appendShortMember("bMaxPower", bMaxPower());
        }
    }


    /* from config descriptor bmAttributes */
 /* must be set */
    public final static byte USB_CONFIG_ATT_ONE = (byte) (1 << 7);
    /* self powered */
    public final static byte USB_CONFIG_ATT_SELFPOWER = (1 << 6);
    /* can wakeup */
    public final static byte USB_CONFIG_ATT_WAKEUP = (1 << 5);
    /* battery powered */
    public final static byte USB_CONFIG_ATT_BATTERY = (1 << 4);

    /*-------------------------------------------------------------------------*/

 /* USB_DT_STRING: String descriptor */
    public abstract static class Usb_string_descriptor extends AbstractDescriptor {

        public static class Layout extends AbstractLayout {

            public final int wData;

            protected Layout() {
                wData = (int) slf.uint16_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_string_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        /* UTF-16LE encoded */
        @__le16
        public String wData() {

            throw new RuntimeException("IMPLEMENT ME!");
//            return MEM_ACCESS_BYTE_ALIGNED.UTF_16__String(this, LAYOUT.wData);
        }
    }

    /* note that "string" zero is special, it holds language codes that
 * the device supports, not Unicode characters.
     */

 /*-------------------------------------------------------------------------*/

 /* USB_DT_INTERFACE: Interface descriptor */
    public final static class Usb_interface_descriptor extends AbstractDescriptor {

        public final static class Layout extends AbstractDescriptor.Layout {

            public final static byte bInterfaceNumber = _sizeof;
            public final static byte bAlternateSetting = bInterfaceNumber + __U8;
            public final static byte bNumEndpoints = bAlternateSetting + __U8;
            public final static byte bInterfaceClass = bNumEndpoints + __U8;
            public final static byte bInterfaceSubClass = bInterfaceClass + __U8;
            public final static byte bInterfaceProtocol = bInterfaceSubClass + __U8;
            public final static byte iInterface = bInterfaceProtocol + __U8;

            public final static byte sizeof = iInterface + __U8;

        }

        public final static byte USB_DT_INTERFACE_SIZE = 9;

        public Usb_interface_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Layout.sizeof);
        }

        @__u8
        public short bInterfaceNumber() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, Layout.bInterfaceNumber);
        }

        @__u8
        public byte bAlternateSetting() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bAlternateSetting);
        }

        @__u8
        public short bNumEndpoints() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, Layout.bNumEndpoints);
        }

        @__u8
        public short bInterfaceClass() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, Layout.bInterfaceClass);
        }

        @__u8
        public short bInterfaceSubClass() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, Layout.bInterfaceClass);
        }

        @__u8
        public short bInterfaceProtocol() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, Layout.bInterfaceProtocol);
        }

        @__u8
        public byte iInterface() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.iInterface);
        }

        @Override
        protected void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
            jsb.appendShortMember("bInterfaceNumber", bInterfaceNumber());
            jsb.appendByteMember("bAlternateSetting", bAlternateSetting());
            jsb.appendShortMember("bNumEndpoints", bNumEndpoints());
            jsb.appendShortMember("bInterfaceClass", bInterfaceClass());
            jsb.appendShortMember("bInterfaceSubClass", bInterfaceSubClass());
            jsb.appendShortMember("bInterfaceProtocol", bInterfaceProtocol());
            jsb.appendByteMember("iInterface", iInterface());
        }
    }


    /*-------------------------------------------------------------------------*/

 /* USB_DT_ENDPOINT: Endpoint descriptor */
    public final static class Usb_endpoint_descriptor extends AbstractDescriptor {

        public final static class Layout extends AbstractDescriptor.Layout {

            public final static byte bEndpointAddress = _sizeof;
            public final static byte bmAttributes = bEndpointAddress + __U8;
            public final static byte wMaxPacketSize = bmAttributes + __U8;
            public final static byte bInterval = wMaxPacketSize + __LE16;
            public final static byte bRefresh = bInterval + __U8;
            public final static byte bSynchAddress = bRefresh + __U8;

            public final static byte sizeof = bSynchAddress + __U8;

        }

        public final static byte USB_DT_ENDPOINT_SIZE = 7;
        /* Audio extension */
        public final static byte USB_DT_ENDPOINT_AUDIO_SIZE = 9;

        public Usb_endpoint_descriptor(MemorySegment memorySegment, long offset, int size) {
            super(memorySegment, offset, size);
            if ((size == USB_DT_ENDPOINT_SIZE) || (size == USB_DT_ENDPOINT_AUDIO_SIZE)) {
                //no-op
            } else {
                throw new IllegalArgumentException("size must be USB_DT_ENDPOINT_SIZE or  USB_DT_ENDPOINT_AUDIO_SIZE");
            }
        }

        @__u8
        public short bEndpointAddress() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, Layout.bEndpointAddress);
        }

        @__u8
        public byte bmAttributes() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bmAttributes);
        }

        @__le16
        public int wMaxPacketSize() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, Layout.wMaxPacketSize);
        }

        @__u8
        public short bInterval() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, Layout.bInterval);
        }

        /* NOTE:  these two are _only_ in audio endpoints. */
 /* use USB_DT_ENDPOINT*_SIZE in bLength, not sizeof. */
        /**
         *
         * @return
         *
         * @throws IllegalStateException if not an audio endpoint
         */
        @__u8
        public byte bRefresh() {
            if (sizeof() == USB_DT_ENDPOINT_AUDIO_SIZE) {
                return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bRefresh);
            } else {
                throw new IllegalStateException("Not an audio endpoint");
            }
        }

        /**
         *
         * @return
         *
         * @throws IllegalStateException if not an audio endpoint
         */
        @__u8
        public byte bSynchAddress() {
            if (sizeof() == USB_DT_ENDPOINT_AUDIO_SIZE) {
                return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bSynchAddress);
            } else {
                throw new IllegalStateException("Not an audio endpoint");
            }
        }

        @Override
        protected void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
            jsb.appendShortMember("bEndpointAddress", bEndpointAddress());
            jsb.appendByteMember("bmAttributes", bmAttributes());
            jsb.appendIntMember("wMaxPacketSize", wMaxPacketSize());
            jsb.appendShortMember("bInterval", bInterval());
            if (sizeof() == USB_DT_ENDPOINT_AUDIO_SIZE) {
                jsb.appendByteMember("bRefresh", bRefresh());
                jsb.appendByteMember("bSynchAddress", bSynchAddress());
            }
        }
    }

    /*
 * Endpoints
     */
 /* in bEndpointAddress */
    public final static short USB_ENDPOINT_NUMBER_MASK = 0x0f;
    public final static short USB_ENDPOINT_DIR_MASK = 0x80;

    /* in bmAttributes */
    public final static byte USB_ENDPOINT_XFERTYPE_MASK = 0x03;
    public final static byte USB_ENDPOINT_XFER_CONTROL = 0;
    public final static byte USB_ENDPOINT_XFER_ISOC = 1;
    public final static byte USB_ENDPOINT_XFER_BULK = 2;
    public final static byte USB_ENDPOINT_XFER_INT = 3;
    public final static byte USB_ENDPOINT_MAX_ADJUSTABLE = (byte) 0x80;

    public final static short USB_ENDPOINT_MAXP_MASK = 0x07ff;
    public final static byte USB_EP_MAXP_MULT_SHIFT = 11;
    public final static short USB_EP_MAXP_MULT_MASK = (3 << USB_EP_MAXP_MULT_SHIFT);

    public static int USB_EP_MAXP_MULT(int m) {
        return (((m) & USB_EP_MAXP_MULT_MASK) >> USB_EP_MAXP_MULT_SHIFT);
    }

    /* The USB 3.0 spec redefines bits 5:4 of bmAttributes as interrupt ep type. */
    public final static byte USB_ENDPOINT_INTRTYPE = 0x30;
    public final static byte USB_ENDPOINT_INTR_PERIODIC = (0 << 4);
    public final static byte USB_ENDPOINT_INTR_NOTIFICATION = (1 << 4);

    public final static byte USB_ENDPOINT_SYNCTYPE = 0x0c;
    public final static byte USB_ENDPOINT_SYNC_NONE = (0 << 2);
    public final static byte USB_ENDPOINT_SYNC_ASYNC = (1 << 2);
    public final static byte USB_ENDPOINT_SYNC_ADAPTIVE = (2 << 2);
    public final static byte USB_ENDPOINT_SYNC_SYNC = (3 << 2);

    public final static byte USB_ENDPOINT_USAGE_MASK = 0x30;
    public final static byte USB_ENDPOINT_USAGE_DATA = 0x00;
    public final static byte USB_ENDPOINT_USAGE_FEEDBACK = 0x10;
    /* Implicit feedback Data endpoint */
    public final static byte USB_ENDPOINT_USAGE_IMPLICIT_FB = 0x20;

    /*-------------------------------------------------------------------------*/
    /**
     * usb_endpoint_num - get the endpoint's number
     *
     * @epd: endpoint to be checked
     *
     * Returns @epd's number: 0 to 15.
     */
    public static int usb_endpoint_num(Usb_endpoint_descriptor epd) {
        return epd.bEndpointAddress() & USB_ENDPOINT_NUMBER_MASK;
    }

    /**
     * usb_endpoint_type - get the endpoint's transfer type
     *
     * @epd: endpoint to be checked
     *
     * Returns one of USB_ENDPOINT_XFER_{CONTROL, ISOC, BULK, INT} according to
     * @epd's transfer type.
     */
    public static int usb_endpoint_type(Usb_endpoint_descriptor epd) {
        return epd.bmAttributes() & USB_ENDPOINT_XFERTYPE_MASK;
    }

    /**
     * usb_endpoint_dir_in - check if the endpoint has IN direction
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint is of type IN, otherwise it returns false.
     */
    public static boolean usb_endpoint_dir_in(Usb_endpoint_descriptor epd) {
        return ((epd.bEndpointAddress() & USB_ENDPOINT_DIR_MASK) == USB_DIR_IN);
    }

    /**
     * usb_endpoint_dir_out - check if the endpoint has OUT direction
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint is of type OUT, otherwise it returns false.
     */
    public static boolean usb_endpoint_dir_out(Usb_endpoint_descriptor epd) {
        return ((epd.bEndpointAddress() & USB_ENDPOINT_DIR_MASK) == USB_DIR_OUT);
    }

    /**
     * usb_endpoint_xfer_bulk - check if the endpoint has bulk transfer type
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint is of type bulk, otherwise it returns false.
     */
    public static boolean usb_endpoint_xfer_bulk(Usb_endpoint_descriptor epd) {
        return ((epd.bmAttributes() & USB_ENDPOINT_XFERTYPE_MASK) == USB_ENDPOINT_XFER_BULK);
    }

    /**
     * usb_endpoint_xfer_control - check if the endpoint has control transfer
     * type
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint is of type control, otherwise it returns
     * false.
     */
    public static boolean usb_endpoint_xfer_control(Usb_endpoint_descriptor epd) {
        return ((epd.bmAttributes() & USB_ENDPOINT_XFERTYPE_MASK) == USB_ENDPOINT_XFER_CONTROL);
    }

    /**
     * usb_endpoint_xfer_int - check if the endpoint has interrupt transfer type
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint is of type interrupt, otherwise it returns
     * false.
     */
    public static boolean usb_endpoint_xfer_int(Usb_endpoint_descriptor epd) {
        return ((epd.bmAttributes() & USB_ENDPOINT_XFERTYPE_MASK) == USB_ENDPOINT_XFER_INT);
    }

    /**
     * usb_endpoint_xfer_isoc - check if the endpoint has isochronous transfer
     * type
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint is of type isochronous, otherwise it returns
     * false.
     */
    public static boolean usb_endpoint_xfer_isoc(Usb_endpoint_descriptor epd) {
        return ((epd.bmAttributes() & USB_ENDPOINT_XFERTYPE_MASK)
                == USB_ENDPOINT_XFER_ISOC);
    }

    /**
     * usb_endpoint_is_bulk_in - check if the endpoint is bulk IN
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint has bulk transfer type and IN direction,
     * otherwise it returns false.
     */
    public static boolean usb_endpoint_is_bulk_in(Usb_endpoint_descriptor epd) {
        return usb_endpoint_xfer_bulk(epd) && usb_endpoint_dir_in(epd);
    }

    /**
     * usb_endpoint_is_bulk_out - check if the endpoint is bulk OUT
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint has bulk transfer type and OUT direction,
     * otherwise it returns false.
     */
    public static boolean usb_endpoint_is_bulk_out(Usb_endpoint_descriptor epd) {
        return usb_endpoint_xfer_bulk(epd) && usb_endpoint_dir_out(epd);
    }

    /**
     * usb_endpoint_is_int_in - check if the endpoint is interrupt IN
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint has interrupt transfer type and IN
     * direction, otherwise it returns false.
     */
    public static boolean usb_endpoint_is_int_in(Usb_endpoint_descriptor epd) {
        return usb_endpoint_xfer_int(epd) && usb_endpoint_dir_in(epd);
    }

    /**
     * usb_endpoint_is_int_out - check if the endpoint is interrupt OUT
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint has interrupt transfer type and OUT
     * direction, otherwise it returns false.
     */
    public static boolean usb_endpoint_is_int_out(Usb_endpoint_descriptor epd) {
        return usb_endpoint_xfer_int(epd) && usb_endpoint_dir_out(epd);
    }

    /**
     * usb_endpoint_is_isoc_in - check if the endpoint is isochronous IN
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint has isochronous transfer type and IN
     * direction, otherwise it returns false.
     */
    public static boolean usb_endpoint_is_isoc_in(Usb_endpoint_descriptor epd) {
        return usb_endpoint_xfer_isoc(epd) && usb_endpoint_dir_in(epd);
    }

    /**
     * usb_endpoint_is_isoc_out - check if the endpoint is isochronous OUT
     *
     * @epd: endpoint to be checked
     *
     * Returns true if the endpoint has isochronous transfer type and OUT
     * direction, otherwise it returns false.
     */
    public static boolean usb_endpoint_is_isoc_out(Usb_endpoint_descriptor epd) {
        return usb_endpoint_xfer_isoc(epd) && usb_endpoint_dir_out(epd);
    }

    /**
     * usb_endpoint_maxp - get endpoint's max packet size
     *
     * @epd: endpoint to be checked
     *
     * Returns @epd's max packet bits [10:0]
     */
    public static short usb_endpoint_maxp(Usb_endpoint_descriptor epd) {
        return (short) (epd.wMaxPacketSize() & USB_ENDPOINT_MAXP_MASK);
    }

    /**
     * usb_endpoint_maxp_mult - get endpoint's transactional opportunities
     *
     * @epd: endpoint to be checked
     *
     * Return @epd's wMaxPacketSize[12:11] + 1
     */
    public static short usb_endpoint_maxp_mult(Usb_endpoint_descriptor epd) {
        return (short) (USB_EP_MAXP_MULT(epd.wMaxPacketSize()) + 1);
    }

    public static byte usb_endpoint_interrupt_type(Usb_endpoint_descriptor epd) {
        return (byte) (epd.bmAttributes() & USB_ENDPOINT_INTRTYPE);
    }

    /*-------------------------------------------------------------------------*/

 /* USB_DT_SSP_ISOC_ENDPOINT_COMP: SuperSpeedPlus Isochronous Endpoint Companion
 * descriptor
     */
    public abstract static class Usb_ssp_isoc_ep_comp_descriptor extends AbstractDescriptor {

        /**
         * public Usb_ssp_isoc_ep_comp_descriptor(OpaqueMemory32 parent, int
         * offset, Byte setMem) { super(parent, offset, sizeof(), setMem); }
         *
         * public Usb_ssp_isoc_ep_comp_descriptor(OpaqueMemory32 parent,
         * OpaqueMemory32 prev) { this(parent,
         * OpaqueMemory32.calcNextOffset(parent, prev, alignof()), null); }
         *
         * @__le16 public native short wReseved();
         *
         * @__le32 public native long dwBytesPerInterval(); }
         *
         *
         * /*-------------------------------------------------------------------------
         */
        public Usb_ssp_isoc_ep_comp_descriptor(MemorySegment memorySegment, long offset, int sizeInBytes) {
            super(memorySegment, offset, sizeInBytes);
        }

        /**
         * public Usb_ssp_isoc_ep_comp_descriptor(OpaqueMemory32 parent, int
         * offset, Byte setMem) { super(parent, offset, sizeof(), setMem); }
         *
         * public Usb_ssp_isoc_ep_comp_descriptor(OpaqueMemory32 parent,
         * OpaqueMemory32 prev) { this(parent,
         * OpaqueMemory32.calcNextOffset(parent, prev, alignof()), null); }
         *
         * @__le16 public native short wReseved();
         *
         * @__le32 public native long dwBytesPerInterval(); }
         *
         *
         * /*-------------------------------------------------------------------------
         */
    }

    /* USB_DT_SS_ENDPOINT_COMP: SuperSpeed Endpoint Companion descriptor */
    public final static class Usb_ss_ep_comp_descriptor extends AbstractDescriptor {

        public final static class Layout extends AbstractDescriptor.Layout {

            public final static byte bMaxBurst = _sizeof;
            public final static byte bmAttributes = bMaxBurst + __U8;
            public final static byte wBytesPerInterval = bmAttributes + __U8;

            public final static byte sizeof = wBytesPerInterval + __LE16;
        }

        public final static byte USB_DT_SS_EP_COMP_SIZE = 6;

        public Usb_ss_ep_comp_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Layout.sizeof);
        }

        @__u8
        public short bMaxBurst() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, Layout.bMaxBurst);
        }

        @__u8
        public byte bmAttributes() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bmAttributes);
        }

        @__le16
        public int wBytesPerInterval() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, Layout.wBytesPerInterval);
        }

        @Override
        protected void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
            jsb.appendShortMember("bMaxBurst", bMaxBurst());
            jsb.appendByteMember("bmAttributes", bmAttributes());
            jsb.appendIntMember("wBytesPerInterval", wBytesPerInterval());
        }

    }


    /* Bits 4:0 of bmAttributes if this is a bulk endpoint */
    public static int usb_ss_max_streams(Usb_ss_ep_comp_descriptor comp) {

        int max_streams;

        if (comp == null) {
            return 0;
        }

        max_streams = comp.bmAttributes() & 0x1f;

        if (max_streams == 0) {
            return 0;
        }

        max_streams = 1 << max_streams;

        return max_streams;
    }

    /* Bits 1:0 of bmAttributes if this is an isoc endpoint */
    public static long USB_SS_MULT(byte p) {
        return (1 + ((p) & 0x3));
    }

    /* Bit 7 of bmAttributes if a SSP isoc endpoint companion descriptor exists */
    public static long USB_SS_SSP_ISOC_COMP(byte p) {
        return ((p) & (1 << 7));
    }

    /*-------------------------------------------------------------------------*/

 /* USB_DT_DEVICE_QUALIFIER: Device Qualifier descriptor */
    public abstract static class Usb_qualifier_descriptor extends AbstractDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bcdUSB;
            public final int bDeviceClass;
            public final int bDeviceSubClass;
            public final int bDeviceProtocol;
            public final int bMaxPacketSize0;
            public final int bNumConfigurations;
            public final int bRESERVED;

            protected Layout() {
                bcdUSB = (int) slf.uint16_t();
                bDeviceClass = (int) slf.uint8_t();
                bDeviceSubClass = (int) slf.uint8_t();
                bDeviceProtocol = (int) slf.uint8_t();
                bMaxPacketSize0 = (int) slf.uint8_t();
                bNumConfigurations = (int) slf.uint8_t();
                bRESERVED = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_qualifier_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__le16
        public short bcdUSB() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.bcdUSB);
        }

        @__u8
        public byte bDeviceClass() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bDeviceClass);
        }

        @__u8
        public byte bDeviceSubClass() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bDeviceSubClass);
        }

        @__u8
        public byte bDeviceProtocol() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bDeviceProtocol);
        }

        @__u8
        public short bMaxPacketSize0() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, LAYOUT.bMaxPacketSize0);
        }

        @__u8
        public short bNumConfigurations() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bNumConfigurations);
        }

        @__u8
        public byte bRESERVED() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bRESERVED);
        }
    }


    /*-------------------------------------------------------------------------*/

 /* USB_DT_OTG (from OTG 1.0a supplement) */
    public abstract static class Usb_otg_descriptor extends AbstractDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bmAttributes;

            protected Layout() {
                bmAttributes = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_otg_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        /* support for HNP, SRP, etc */
        @__u8
        public byte bmAttributes() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bmAttributes);
        }
    }

    /* USB_DT_OTG (from OTG 2.0 supplement) */
    public abstract static class Usb_otg20_descriptor extends AbstractDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bmAttributes;
            public final int bcdOTG;

            protected Layout() {
                bmAttributes = (int) slf.uint8_t();
                bcdOTG = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_otg20_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public byte bmAttributes() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bmAttributes);
        }

        /* support for HNP, SRP and ADP, etc */
        @__le16
        public short bcdOTG() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.int16_t(memorySegment, LAYOUT.bcdOTG);
        }
        /* OTG and EH supplement release number
				 * in binary-coded decimal(i.e. 2.0 is 0200H)
         */
    }

    /* from usb_otg_descriptor.bmAttributes */
    public final static byte USB_OTG_SRP = (1 << 0);
    /* swap host/device roles */
    public final static byte USB_OTG_HNP = (1 << 1);
    /* support ADP */
    public final static byte USB_OTG_ADP = (1 << 2);

    /* OTG status selector */
    public final static short OTG_STS_SELECTOR = (short) 0xF000;

    /*-------------------------------------------------------------------------*/

 /* USB_DT_DEBUG:  for special highspeed devices, replacing serial console */
    public abstract static class Usb_debug_descriptor extends AbstractDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bDebugInEndpoint;
            public final int bDebugOutEndpoint;

            protected Layout() {
                bDebugInEndpoint = (int) slf.uint8_t();
                bDebugOutEndpoint = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_debug_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        /* bulk endpoints with 8 byte maxpacket */
        @__u8
        public byte bDebugInEndpoint() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bDebugInEndpoint);
        }

        @__u8
        public byte bDebugOutEndpoint() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bDebugOutEndpoint);
        }
    }

    /*-------------------------------------------------------------------------*/

 /* USB_DT_INTERFACE_ASSOCIATION: groups interfaces */
    public static class Usb_interface_assoc_descriptor extends AbstractDescriptor {

        public final static byte USB_DT_INTERFACE_ASSOCIATION_SIZE = 8;

        public static class Layout extends AbstractDescriptor.Layout {

            public final static byte bFirstInterface = _sizeof;
            public final static byte bInterfaceCount = bFirstInterface + __U8;
            public final static byte bFunctionClass = bInterfaceCount + __U8;
            public final static byte bFunctionSubClass = bFunctionClass + __U8;
            public final static byte bFunctionProtocol = bFunctionSubClass + __U8;
            public final static byte iFunction = bFunctionProtocol + __U8;

            public final static byte sizeof = iFunction + __U8;
        }

        public Usb_interface_assoc_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Layout.sizeof);
        }

        @__u8
        public byte bFirstInterface() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bFirstInterface);
        }

        @__u8
        public short bInterfaceCount() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bInterfaceCount);
        }

        @__u8
        public byte bFunctionClass() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bFunctionClass);
        }

        @__u8
        public byte bFunctionSubClass() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bFunctionSubClass);
        }

        @__u8
        public byte bFunctionProtocol() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bFunctionProtocol);
        }

        @__u8
        public byte iFunction() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, Layout.iFunction);
        }

        @Override
        protected void nativeToString(JsonStringBuilder jsb, String indentPrefix, String indent) throws IOException {
            jsb.appendByteMember("bFirstInterface", bFirstInterface());
            jsb.appendShortMember("bInterfaceCount", bInterfaceCount());
            jsb.appendByteMember("bFunctionClass", bFunctionClass());
            jsb.appendByteMember("bFunctionSubClass", bFunctionSubClass());
            jsb.appendByteMember("bFunctionProtocol", bFunctionProtocol());
            jsb.appendByteMember("iFunction", iFunction());
        }
    }


    /*-------------------------------------------------------------------------*/

 /* USB_DT_SECURITY:  group of wireless security descriptors, including
 * encryption types available for setting up a CC/association.
     */
    public abstract static class Usb_security_descriptor extends AbstractDescriptor {

        public static class Layout extends AbstractLayout {

            public final int wTotalLength;
            public final int bNumEncryptionTypes;

            protected Layout() {
                wTotalLength = (int) slf.uint8_t();
                bNumEncryptionTypes = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_security_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__le16
        public int wTotalLength() {
            return MEM_ACCESS_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, LAYOUT.wTotalLength);
        }

        @__u8
        public short bNumEncryptionTypes() {
            return MEM_ACCESS_BYTE_ALIGNED.int8_t(memorySegment, LAYOUT.bNumEncryptionTypes);
        }
    }

    /*-------------------------------------------------------------------------*/

 /* USB_DT_KEY:  used with {GET,SET}_SECURITY_DATA; only public keys
 * may be retrieved.
     */
    public abstract static class Usb_key_descriptor extends AbstractDescriptor {

        public static class Layout extends AbstractLayout {

            public final int tTKID;
            public final int bReserved;
            public final int bKeyData;

            protected Layout() {
                tTKID = (int) slf.uint8_t();
                bReserved = (int) slf.uint8_t();
                bKeyData = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_key_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public abstract byte[] tTKID();

        @__u8
        public abstract byte bReserved();

        @__u8
        public abstract byte[] bKeyData();
    }

    /*-------------------------------------------------------------------------*/

 /* USB_DT_ENCRYPTION_TYPE:  bundled in DT_SECURITY groups */
    public abstract static class Usb_encryption_descriptor extends AbstractDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bEncryptionType;
            public final int bEncryptionValue;
            public final int bAuthKeyIndex;

            protected Layout() {
                bEncryptionType = (int) slf.uint8_t();
                bEncryptionValue = (int) slf.uint8_t();
                bAuthKeyIndex = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_encryption_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public byte bEncryptionType() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bEncryptionType);
        }
        public final static byte USB_ENC_TYPE_UNSECURE = 0;
        /* non-wireless mode */
        public final static byte USB_ENC_TYPE_WIRED = 1;
        /* aes128/cbc session */
        public final static byte USB_ENC_TYPE_CCM_1 = 2;
        /* rsa3072/sha1 auth */
        public final static byte USB_ENC_TYPE_RSA_1 = 3;

        /* use in SET_ENCRYPTION */
        @__u8
        public byte bEncryptionValue() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bEncryptionValue);
        }

        @__u8
        public byte bAuthKeyIndex() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bAuthKeyIndex);
        }
    }


    /*-------------------------------------------------------------------------*/

 /* USB_DT_BOS:  group of device-level capabilities */
    public abstract static class Usb_bos_descriptor extends AbstractDescriptor {

        public final static byte USB_DT_BOS_SIZE = 5;

        public static class Layout extends AbstractLayout {

            public final int wTotalLength;
            public final int bNumDeviceCaps;

            protected Layout() {
                wTotalLength = (int) slf.uint16_t();
                bNumDeviceCaps = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_bos_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__le16
        public int wTotalLength() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, LAYOUT.wTotalLength);
        }

        @__u8
        public byte bNumDeviceCaps() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bNumDeviceCaps);
        }
    }

    /*-------------------------------------------------------------------------*/

 /* USB_DT_DEVICE_CAPABILITY:  grouped with BOS */
    public abstract static class Usb_dev_cap_header extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            protected Layout() {
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_dev_cap_header(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

    }

    public final static byte USB_CAP_TYPE_WIRELESS_USB = 1;

    /* Ultra Wide Band */
    public abstract static class Usb_wireless_cap_descriptor extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bmAttributes;
            public final int wPHYRates;
            public final int bmTFITXPowerInfo;
            public final int bmFFITXPowerInfo;
            public final int bmBandGroup;
            public final int bReserved;

            protected Layout() {
                bmAttributes = (int) slf.uint8_t();
                wPHYRates = (int) slf.uint16_t();
                bmTFITXPowerInfo = (int) slf.uint8_t();
                bmFFITXPowerInfo = (int) slf.uint8_t();
                bmBandGroup = (int) slf.uint16_t();
                bReserved = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_wireless_cap_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public byte bmAttributes() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bmAttributes);
        }

        public final static byte USB_WIRELESS_P2P_DRD = (1 << 1);
        public final static byte USB_WIRELESS_BEACON_MASK = (3 << 2);
        public final static byte USB_WIRELESS_BEACON_SELF = (1 << 2);
        public final static byte USB_WIRELESS_BEACON_DIRECTED = (2 << 2);
        public final static byte USB_WIRELESS_BEACON_NONE = (3 << 2);

        /* bit rates, Mbps */
        @__le16
        public short wPHYRates() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.wPHYRates);
        }
        /* always set */
        public final static byte USB_WIRELESS_PHY_53 = (1 << 0);
        public final static byte USB_WIRELESS_PHY_80 = (1 << 1);
        /* always set */
        public final static byte USB_WIRELESS_PHY_107 = (1 << 2);
        public final static byte USB_WIRELESS_PHY_160 = (1 << 3);
        /* always set */
        public final static byte USB_WIRELESS_PHY_200 = (1 << 4);
        public final static byte USB_WIRELESS_PHY_320 = (1 << 5);
        public final static byte USB_WIRELESS_PHY_400 = (1 << 6);
        public final static byte USB_WIRELESS_PHY_480 = (byte) (1 << 7);

        /* TFI power levels */
        @__u8
        public byte bmTFITXPowerInfo() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bmTFITXPowerInfo);
        }

        /* FFI power levels */
        @__u8
        public byte bmFFITXPowerInfo() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bmFFITXPowerInfo);
        }

        @__le16
        public short bmBandGroup() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.bmBandGroup);
        }

        @__u8
        public byte bReserved() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bReserved);
        }
    }

    public final static byte USB_DT_USB_WIRELESS_CAP_SIZE = 11;

    /* USB 2.0 Extension descriptor */
    public final static byte USB_CAP_TYPE_EXT = 2;

    /* Link Power Management */
    public abstract static class Usb_ext_cap_descriptor extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bmAttributes;

            protected Layout() {
                bmAttributes = (int) slf.uint32_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_ext_cap_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__le32
        public int bmAttributes() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint32_t(memorySegment, LAYOUT.bmAttributes);
        }
        /* supports LPM */
        public final static byte USB_LPM_SUPPORT = (1 << 1);
        /* supports BESL */
        public final static byte USB_BESL_SUPPORT = (1 << 2);
        /* Baseline BESL valid*/
        public final static byte USB_BESL_BASELINE_VALID = (1 << 3);
        /* Deep BESL valid */
        public final static byte USB_BESL_DEEP_VALID = (1 << 4);

        public static long USB_SET_BESL_BASELINE(byte p) {
            return (((p) & 0xf) << 8);
        }

        public static long USB_SET_BESL_DEEP(byte p) {
            return (((p) & 0xf) << 12);
        }

        public static long USB_GET_BESL_BASELINE(byte p) {
            return (((p) & (0xf << 8)) >> 8);
        }

        public static long USB_GET_BESL_DEEP(byte p) {
            return (((p) & (0xf << 12)) >> 12);
        }
    }

    public final static byte USB_DT_USB_EXT_CAP_SIZE = 7;

    /*
 * SuperSpeed USB Capability descriptor: Defines the set of SuperSpeed USB
 * specific device level capabilities
     */
    public final static byte USB_SS_CAP_TYPE = 3;

    /* Link Power Management */
    public abstract static class Usb_ss_cap_descriptor extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bmAttributes;
            public final int wSpeedSupported;
            public final int bFunctionalitySupport;
            public final int bU1devExitLat;
            public final int bU2DevExitLat;

            protected Layout() {
                bmAttributes = (int) slf.uint8_t();
                wSpeedSupported = (int) slf.uint16_t();
                bFunctionalitySupport = (int) slf.uint8_t();
                bU1devExitLat = (int) slf.uint8_t();
                bU2DevExitLat = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_ss_cap_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public byte bmAttributes() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bmAttributes);
        }
        /* supports LTM */
        public final static byte USB_LTM_SUPPORT = (1 << 1);

        @__le16
        public int wSpeedSupported() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, LAYOUT.wSpeedSupported);
        }
        /* Low speed operation */
        public final static byte USB_LOW_SPEED_OPERATION = (1);
        /* Full speed operation */
        public final static byte USB_FULL_SPEED_OPERATION = (1 << 1);
        /* High speed operation */
        public final static byte USB_HIGH_SPEED_OPERATION = (1 << 2);
        /* Operation at 5Gbps */
        public final static byte USB_5GBPS_OPERATION = (1 << 3);

        @__u8
        public byte bFunctionalitySupport() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bFunctionalitySupport);
        }

        @__u8
        public byte bU1devExitLat() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bU1devExitLat);
        }

        @__le16
        public byte bU2DevExitLat() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bU2DevExitLat);
        }
    }

    public final static byte USB_DT_USB_SS_CAP_SIZE = 10;

    /*
 * Container ID Capability descriptor: Defines the instance unique ID used to
 * identify the instance across all operating modes
     */
    public final static byte CONTAINER_ID_TYPE = 4;

    public abstract static class Usb_ss_container_id_descriptor extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bReserved;
            public final int ContainerID;

            protected Layout() {
                bReserved = (int) slf.uint8_t();
                ContainerID = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_ss_container_id_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public byte bReserved() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.ContainerID);
        }

        /* 128-bit number */
        @__u8
        public abstract byte[] ContainerID();
    }

    public final static byte USB_DT_USB_SS_CONTN_ID_SIZE = 20;

    /*
 * SuperSpeed Plus USB Capability descriptor: Defines the set of
 * SuperSpeed Plus USB specific device level capabilities
     */
    public final static byte USB_SSP_CAP_TYPE = 0xa;

    public abstract static class Usb_ssp_cap_descriptor extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bReserved;
            public final int bmAttributes;
            public final int wFunctionalitySupport;
            public final int wReserved;
            public final int bmSublinkSpeedAttr;

            protected Layout() {
                bReserved = (int) slf.uint8_t();
                bmAttributes = (int) slf.uint32_t();
                wFunctionalitySupport = (int) slf.uint16_t();
                wReserved = (int) slf.uint16_t();
                bmSublinkSpeedAttr = (int) slf.uint32_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_ssp_cap_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public byte bReserved() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bReserved);
        }

        @__le32
        public int bmAttributes() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint32_t(memorySegment, LAYOUT.bmAttributes);
        }
        /* sublink speed entries */
        public final static short USB_SSP_SUBLINK_SPEED_ATTRIBS = (0x1f << 0);
        /* speed ID entries */
        public final static short USB_SSP_SUBLINK_SPEED_IDS = (0xf << 5);

        @__le16
        public short wFunctionalitySupport() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.wFunctionalitySupport);
        }
        public final static short USB_SSP_MIN_SUBLINK_SPEED_ATTRIBUTE_ID = (0xf);
        public final static short USB_SSP_MIN_RX_LANE_COUNT = (0xf << 8);
        public final static short USB_SSP_MIN_TX_LANE_COUNT = (short) (0xf << 12);

        @__le16
        public short wReserved() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.wReserved);
        }

        /* list of sublink speed attrib entries */
        @__le32
        public abstract int[] bmSublinkSpeedAttr();
        /* sublink speed ID */
        public final static byte USB_SSP_SUBLINK_SPEED_SSID = (0xf);
        /* Lanespeed exponent */
        public final static byte USB_SSP_SUBLINK_SPEED_LSE = (0x3 << 4);
        /* Sublink type */
        public final static short USB_SSP_SUBLINK_SPEED_ST = (0x3 << 6);
        /* Reserved */
        public final static short USB_SSP_SUBLINK_SPEED_RSVD = (0x3f << 8);
        /* Link protocol */
        public final static int USB_SSP_SUBLINK_SPEED_LP = (0x3 << 14);
        /* Lanespeed mantissa */
        public final static int USB_SSP_SUBLINK_SPEED_LSM = (0xff << 16);
    }

    /*
 * USB Power Delivery Capability Descriptor:
 * Defines capabilities for PD
     */
 /* Defines the various PD Capabilities of this device */
    public final static byte USB_PD_POWER_DELIVERY_CAPABILITY = 0x06;
    /* Provides information on each battery supported by the device */
    public final static byte USB_PD_BATTERY_INFO_CAPABILITY = 0x07;
    /* The Consumer characteristics of a Port on the device */
    public final static byte USB_PD_PD_CONSUMER_PORT_CAPABILITY = 0x08;
    /* The provider characteristics of a Port on the device */
    public final static byte USB_PD_PD_PROVIDER_PORT_CAPABILITY = 0x09;

    public abstract static class Usb_pd_cap_descriptor extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bReserved;
            public final int bmAttributes;
            public final int bmProviderPorts;
            public final int bmConsumerPorts;
            public final int bcdBCVersion;
            public final int bcdPDVersion;
            public final int bcdUSBTypeCVersion;

            protected Layout() {
                bReserved = (int) slf.uint8_t();
                bmAttributes = (int) slf.uint32_t();
                bmProviderPorts = (int) slf.uint16_t();
                bmConsumerPorts = (int) slf.uint16_t();
                bcdBCVersion = (int) slf.uint16_t();
                bcdPDVersion = (int) slf.uint16_t();
                bcdUSBTypeCVersion = (int) slf.uint16_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_pd_cap_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public byte bReserved() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bReserved);
        }

        @__le32
        public int bmAttributes() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint32_t(memorySegment, LAYOUT.bmAttributes);
        }
        /* supports Battery Charging specification */
        public final static byte USB_PD_CAP_BATTERY_CHARGING = (1 << 1);
        /* supports USB Power Delivery specification */
        public final static byte USB_PD_CAP_USB_PD = (1 << 2);
        /* can provide power */
        public final static byte USB_PD_CAP_PROVIDER = (1 << 3);
        /* can consume power */
        public final static byte USB_PD_CAP_CONSUMER = (1 << 4);
        /* supports CHARGING_POLICY feature */
        public final static byte USB_PD_CAP_CHARGING_POLICY = (1 << 5);
        /* supports power capabilities defined in the USB Type-C Specification */
        public final static byte USB_PD_CAP_TYPE_C_CURRENT = (1 << 6);

        public final static byte USB_PD_CAP_PWR_AC = (byte) (1 << 8);
        public final static byte USB_PD_CAP_PWR_BAT = (byte) (1 << 9);
        public final static byte USB_PD_CAP_PWR_USE_V_BUS = (byte) (1 << 14);

        /* Bit zero refers to the UFP of the device */
        @__le16
        public int bmProviderPorts() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, LAYOUT.bmProviderPorts);
        }

        @__le16
        public int bmConsumerPorts() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, LAYOUT.bmConsumerPorts);
        }

        @__le16
        public short bcdBCVersion() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.bcdBCVersion);
        }

        @__le16
        public short bcdPDVersion() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.bcdPDVersion);
        }

        @__le16
        public short bcdUSBTypeCVersion() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.bcdUSBTypeCVersion);
        }
    }

    public abstract static class Usb_pd_cap_battery_info_descriptor extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            public final int iBattery;
            public final int iSerial;
            public final int iManufacturer;
            public final int bBatteryId;
            public final int bReserved;
            public final int dwChargedThreshold;
            public final int dwWeakThreshold;
            public final int dwBatteryDesignCapacity;
            public final int dwBatteryLastFullchargeCapacity;

            protected Layout() {
                iBattery = (int) slf.uint8_t();
                iSerial = (int) slf.uint8_t();
                iManufacturer = (int) slf.uint8_t();
                bBatteryId = (int) slf.uint8_t();
                bReserved = (int) slf.uint8_t();
                dwChargedThreshold = (int) slf.uint32_t();
                dwWeakThreshold = (int) slf.uint32_t();
                dwBatteryDesignCapacity = (int) slf.uint32_t();
                dwBatteryLastFullchargeCapacity = (int) slf.uint32_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_pd_cap_battery_info_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        /* Index of string descriptor shall contain the user friendly name for this battery */
        @__u8
        public byte iBattery() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.iBattery);
        }

        /* Index of string descriptor shall contain the Serial Number String for this battery */
        @__u8
        public byte iSerial() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.iSerial);
        }

        @__u8
        public byte iManufacturer() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.iManufacturer);
        }

        /* uniquely identifies this battery in status Messages */
        @__u8
        public byte bBatteryId() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bBatteryId);
        }

        @__u8
        public byte bReserved() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bReserved);
        }

        /*
	 * Shall contain the Battery Charge value above which this
	 * battery is considered to be fully charged but not necessarily
	 * “topped off.”
         */
 /* in mWh */
        @__le32
        public int dwChargedThreshold() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint32_t(memorySegment, LAYOUT.dwChargedThreshold);
        }

        /*
	 * Shall contain the minimum charge level of this battery such
	 * that above this threshold, a device can be assured of being
	 * able to power up successfully (see Battery Charging 1.2).
         */
 /* in mWh */
        @__le32
        public long dwWeakThreshold() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint32_t(memorySegment, LAYOUT.dwWeakThreshold);
        }

        /* in mWh */
        @__le32
        public long dwBatteryDesignCapacity() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint32_t(memorySegment, LAYOUT.dwBatteryDesignCapacity);
        }

        /* in mWh */
        @__le32
        public long dwBatteryLastFullchargeCapacity() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint32_t(memorySegment, LAYOUT.dwBatteryLastFullchargeCapacity);
        }
    }

    public abstract static class Usb_pd_cap_consumer_port_descriptor extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bReserved;
            public final int bmCapabilities;
            public final int wMinVoltage;
            public final int wMaxVoltage;
            public final int wReserved;
            public final int dwMaxOperatingPower;
            public final int dwMaxPeakPower;
            public final int dwMaxPeakPowerTime;

            protected Layout() {
                bReserved = (int) slf.uint8_t();
                bmCapabilities = (int) slf.uint16_t();
                wMinVoltage = (int) slf.uint16_t();
                wMaxVoltage = (int) slf.uint16_t();
                wReserved = (int) slf.uint16_t();
                dwMaxOperatingPower = (int) slf.uint32_t();
                dwMaxPeakPower = (int) slf.uint32_t();
                dwMaxPeakPowerTime = (int) slf.uint32_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_pd_cap_consumer_port_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public byte bReserved() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bReserved);
        }

        @__u8
        public byte bmCapabilities() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bmCapabilities);
        }
        /* port will oerate under: */
 /* BC */
        public final static byte USB_PD_CAP_CONSUMER_BC = (byte) (1 << 0);
        /* PD */
        public final static byte USB_PD_CAP_CONSUMER_PD = (byte) (1 << 1);
        /* USB Type-C Current */
        public final static byte USB_PD_CAP_CONSUMER_TYPE_C = (byte) (1 << 2);

        /* in 50mV units */
        @__le16
        public int wMinVoltage() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.wMinVoltage);
        }

        /* in 50mV units */
        @__le16
        public int wMaxVoltage() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t(memorySegment, LAYOUT.wMaxVoltage);
        }

        @__u16
        public short wReserved() {
            return MEM_ACCESS_BYTE_ALIGNED.int16_t(memorySegment, LAYOUT.wReserved);
        }

        /* in 10 mW - operating at steady state */
        @__le32
        public long dwMaxOperatingPower() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint32_t(memorySegment, LAYOUT.dwMaxOperatingPower);
        }

        /* in 10mW units - operating at peak power */
        @__le32
        public long dwMaxPeakPower() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint32_t(memorySegment, LAYOUT.dwMaxPeakPower);
        }

        /* in 100ms units - duration of peak */
        @__le32
        public long dwMaxPeakPowerTime() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint32_t(memorySegment, LAYOUT.dwMaxPeakPowerTime);
        }

        public final static int USB_PD_CAP_CONSUMER_UNKNOWN_PEAK_POWER_TIME = 0xffff;
    }

    public abstract static class Usb_pd_cap_provider_port_descriptor extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bReserved1;
            public final int bmCapabilities;
            public final int bNumOfPDObjects;
            public final int bReserved2;
            public final int wPowerDataObject;

            protected Layout() {
                bReserved1 = (int) slf.uint8_t();
                bmCapabilities = (int) slf.uint8_t();
                bNumOfPDObjects = (int) slf.uint8_t();
                bReserved2 = (int) slf.uint8_t();
                wPowerDataObject = (int) slf.uint32_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_pd_cap_provider_port_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public byte bReserved1() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bReserved1);
        }

        @__u8
        public byte bmCapabilities() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bmCapabilities);
        }
        /* port will oerate under: */
 /* BC */
        public final static byte USB_PD_CAP_PROVIDER_BC = (1 << 0);
        /* PD */
        public final static byte USB_PD_CAP_PROVIDER_PD = (1 << 1);
        /* USB Type-C Current */
        public final static byte USB_PD_CAP_PROVIDER_TYPE_C = (1 << 2);

        @__u8
        public short bNumOfPDObjects() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bNumOfPDObjects);
        }

        @__u8
        public byte bReserved2() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bReserved2);
        }

        @__le32
        public abstract int[] wPowerDataObject();
    }

    /*
 * Precision time measurement capability descriptor: advertised by devices and
 * hubs that support PTM
     */
    public final static byte USB_PTM_CAP_TYPE = 0xb;

    public abstract static class Usb_ptm_cap_descriptor extends AbstractCapabilityDescriptor {

        public static class Layout extends AbstractLayout {

            protected Layout() {
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_ptm_cap_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

    }

    public final static byte USB_DT_USB_PTM_ID_SIZE = 3;

    /*
 * The size of the descriptor for the Sublink Speed Attribute Count
 * (SSAC) specified in bmAttributes[4:0]. SSAC is zero-based
     */
    public static long USB_DT_USB_SSP_CAP_SIZE(byte ssac) {
        return (12 + (ssac + 1) * 4);
    }

    /*-------------------------------------------------------------------------*/

 /* USB_DT_WIRELESS_ENDPOINT_COMP:  companion descriptor associated with
 * each endpoint descriptor for a wireless device
     */
    public abstract static class Usb_wireless_ep_comp_descriptor extends AbstractDescriptor {

        public static class Layout extends AbstractLayout {

            public final int bMaxBurst;
            public final int bMaxSequence;
            public final int wMaxStreamDelay;
            public final int wOverTheAirPacketSize;
            public final int bOverTheAirInterval;
            public final int bmCompAttributes;

            protected Layout() {
                bMaxBurst = (int) slf.uint8_t();
                bMaxSequence = (int) slf.uint8_t();
                wMaxStreamDelay = (int) slf.uint16_t();
                wOverTheAirPacketSize = (int) slf.uint16_t();
                bOverTheAirInterval = (int) slf.uint8_t();
                bmCompAttributes = (int) slf.uint8_t();
            }

        }

        protected final static Layout LAYOUT = new Layout();

        public Usb_wireless_ep_comp_descriptor(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, LAYOUT.getSizeof());
        }

        @__u8
        public short bMaxBurst() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, LAYOUT.bMaxBurst);
        }

        @__u8
        public short bMaxSequence() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, LAYOUT.bMaxSequence);
        }

        @__le16
        public int wMaxStreamDelay() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, LAYOUT.wMaxStreamDelay);
        }

        @__le16
        public int wOverTheAirPacketSize() {
            return MEM_ACCESS_LE_BYTE_ALIGNED.uint16_t_AsInt(memorySegment, LAYOUT.wOverTheAirPacketSize);
        }

        @__u8
        public short bOverTheAirInterval() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, LAYOUT.bOverTheAirInterval);
        }

        @__u8
        public byte bmCompAttributes() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, LAYOUT.bmCompAttributes);
        }
        /* in bmCompAttributes */
        public final static byte USB_ENDPOINT_SWITCH_MASK = 0x03;
        public final static byte USB_ENDPOINT_SWITCH_NO = 0;
        public final static byte USB_ENDPOINT_SWITCH_SWITCH = 1;
        public final static byte USB_ENDPOINT_SWITCH_SCALE = 2;
    }

    /*-------------------------------------------------------------------------*/

 /* USB_REQ_SET_HANDSHAKE is a four-way handshake used between a wireless
 * host and a device for connection set up, mutual authentication, and
 * exchanging short lived session keys.  The handshake depends on a CC.
     */
    public final static class Usb_handshake extends AbstractLinuxSyscallStruct {

        public final class Layout {

            public final static byte bMessageNumber = 0;
            public final static byte bStatus = bMessageNumber + 1;
            public final static byte tTKID = bStatus + 1;
            public final static byte sizeof_tTKID = 3;
            public final static byte bReserved = tTKID + sizeof_tTKID;
            public final static byte CDID = bReserved + 1;
            public final static byte sizeof_CDID = 16;
            public final static byte nonce = CDID + sizeof_CDID;
            public final static byte sizeof_nonce = 16;
            public final static byte MIC = nonce + sizeof_nonce;
            public final static byte sizeof_MIC = 8;

            public final static byte sizeof = MIC + sizeof_MIC;
        }

        public Usb_handshake(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Layout.sizeof);
        }

        @__u8
        public short bMessageNumber() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t_AsShort(memorySegment, Layout.bMessageNumber);
        }

        @__u8
        public byte bStatus() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bStatus);
        }

        @__u8
        public byte[] tTKID() {
            final byte[] result = new byte[Layout.sizeof_tTKID];
            MEM_ACCESS_BYTE_ALIGNED.copyMemory(memorySegment, Layout.tTKID, result, 0, Layout.sizeof_tTKID);
            return result;
        }

        @__u8
        public byte bReserved() {
            return MEM_ACCESS_BYTE_ALIGNED.uint8_t(memorySegment, Layout.bReserved);
        }

        @__u8
        public byte[] CDID() {
            final byte[] result = new byte[Layout.sizeof_CDID];
            MEM_ACCESS_BYTE_ALIGNED.copyMemory(memorySegment, Layout.CDID, result, 0, Layout.sizeof_CDID);
            return result;
        }

        @__u8
        public byte[] nonce() {
            final byte[] result = new byte[Layout.sizeof_nonce];
            MEM_ACCESS_BYTE_ALIGNED.copyMemory(memorySegment, Layout.nonce, result, 0, Layout.sizeof_nonce);
            return result;
        }

        @__u8
        public byte[] MIC() {
            final byte[] result = new byte[Layout.sizeof_MIC];
            MEM_ACCESS_BYTE_ALIGNED.copyMemory(memorySegment, Layout.MIC, result, 0, Layout.sizeof_MIC);
            return result;
        }
    }

    /*-------------------------------------------------------------------------*/

 /* USB_REQ_SET_CONNECTION modifies or revokes a connection context (CC).
 * A CC may also be set up using non-wireless secure channels (including
 * wired USB!), and some devices may support CCs with multiple hosts.
     */
    public abstract static class Usb_connection_context extends Struct {

        public final class Layout {

            public final static byte CHID = 0;
            public final static byte sizeof_CHID = 16;
            public final static byte CDID = CHID + sizeof_CHID;
            public final static byte sizeof_CDID = 16;
            public final static byte CK = CDID + sizeof_CDID;
            public final static byte sizeof_CK = 16;

            public final static byte sizeof = CK + sizeof_CK;
        }

        public Usb_connection_context(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, Layout.sizeof);
        }

        /* persistent host id */
        @__u8
        public abstract byte[] CHID();

        /* device id (unique w/in host context) */
        @__u8
        public abstract byte[] CDID();

        /* connection key */
        @__u8
        public abstract byte[] CK();

    }

    /*-------------------------------------------------------------------------*/

 /* USB 2.0 defines three speeds, here's how Linux identifies them */
    public static interface Usb_device_speed {

        /* enumerating */
        public final static int USB_SPEED_UNKNOWN = 0;
        public final static int USB_SPEED_LOW = 1;
        /* usb 1.1 */
        public final static int USB_SPEED_FULL = 2;
        /* usb 2.0 */
        public final static int USB_SPEED_HIGH = 3;
        /* wireless (usb 2.5) */
        public final static int USB_SPEED_WIRELESS = 4;
        /* usb 3.0 */
        public final static int USB_SPEED_SUPER = 5;
        /* usb 3.1 */
        public final static int USB_SPEED_SUPER_PLUS = 6;
    };

    public static interface Usb_device_state {

        /* NOTATTACHED isn't in the USB spec, and this state acts
	 * the same as ATTACHED ... but it's clearer this way.
         */
        public final static int USB_STATE_NOTATTACHED = 0;
        /* chapter 9 and authentication (wireless) device states */
        public final static int USB_STATE_ATTACHED = 1;
        /* wired */
        public final static int USB_STATE_POWERED = 2;
        /* auth */
        public final static int USB_STATE_RECONNECTING = 3;
        /* auth */
        public final static int USB_STATE_UNAUTHENTICATED = 4;
        /* limited function */
        public final static int USB_STATE_DEFAULT = 5;
        public final static int USB_STATE_ADDRESS = 6;
        /* most functions */
        public final static int USB_STATE_CONFIGURED = 7;

        /* NOTE:  there are actually four different SUSPENDED
	 * states, returning to POWERED, DEFAULT, ADDRESS, or
	 * CONFIGURED respectively when SOF tokens flow again.
	 * At this level there's no difference between L1 and L2
	 * suspend states.  (L2 being original USB 1.1 suspend.)
         */
        public final static int USB_STATE_SUSPENDED = 8;
    };

    public static interface Usb3_link_state {

        public final static int USB3_LPM_U0 = 0;
        public final static int USB3_LPM_U1 = 1;
        public final static int USB3_LPM_U2 = 2;
        public final static int USB3_LPM_U3 = 3;
    };

    /*
 * A U1 timeout of 0x0 means the parent hub will reject any transitions to U1.
 * 0xff means the parent hub will accept transitions to U1, but will not
 * initiate a transition.
 *
 * A U1 timeout of 0x1 to 0x7F also causes the hub to initiate a transition to
 * U1 after that many microseconds.  Timeouts of 0x80 to 0xFE are reserved
 * values.
 *
 * A U2 timeout of 0x0 means the parent hub will reject any transitions to U2.
 * 0xff means the parent hub will accept transitions to U2, but will not
 * initiate a transition.
 *
 * A U2 timeout of 0x1 to 0xFE also causes the hub to initiate a transition to
 * U2 after N*256 microseconds.  Therefore a U2 timeout value of 0x1 means a U2
 * idle timer of 256 microseconds, 0x2 means 512 microseconds, 0xFE means
 * 65.024ms.
     */
    public final static byte USB3_LPM_DISABLED = 0x0;
    public final static byte USB3_LPM_U1_MAX_TIMEOUT = 0x7F;
    public final static byte USB3_LPM_U2_MAX_TIMEOUT = (byte) 0xFE;
    public final static byte USB3_LPM_DEVICE_INITIATED = (byte) 0xFF;

    public abstract static class Usb_set_sel_req extends Struct {

        public Usb_set_sel_req(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, -1);
        }

        @__u8
        public abstract byte u1_sel();

        @__u8
        public abstract byte u1_pel();

        @__le16
        public abstract short u2_sel();

        @__le16
        public abstract short u2_pel();
    }

    /*
 * The Set System Exit Latency control transfer provides one byte each for
 * U1 SEL and U1 PEL, so the max exit latency is 0xFF.  U2 SEL and U2 PEL each
 * are two bytes long.
     */
    public final static short USB3_LPM_MAX_U1_SEL_PEL = 0xFF;
    public final static short USB3_LPM_MAX_U2_SEL_PEL = (short) 0xFFFF;

    /*-------------------------------------------------------------------------*/

 /*
 * As per USB compliance update, a device that is actively drawing
 * more than 100mA from USB must report itself as bus-powered in
 * the GetStatus(DEVICE) call.
 * http://compliance.usb.org/index.asp?UpdateFile=Electrical&Format=Standard#34
     */
    public final static byte USB_SELF_POWER_VBUS_MAX_DRAW = 100;

}
