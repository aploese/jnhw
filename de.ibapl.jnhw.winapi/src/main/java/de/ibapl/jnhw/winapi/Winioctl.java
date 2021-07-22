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
package de.ibapl.jnhw.winapi;

import de.ibapl.jnhw.common.annotation.Define;

/**
 *
 * @author apl
 */
public class Winioctl {

    @Define
    public final static int FILE_ANY_ACCESS = 0;
    @Define
    public final static int FILE_DEVICE_8042_PORT = 0x00000027;
    @Define
    public final static int FILE_DEVICE_ACPI = 0x00000032;
    @Define
    public final static int FILE_DEVICE_BATTERY = 0x00000029;
    @Define
    public final static int FILE_DEVICE_BEEP = 0x00000001;
    @Define
    public final static int FILE_DEVICE_BIOMETRIC = 0x00000044;
    @Define
    public final static int FILE_DEVICE_BLUETOOTH = 0x00000041;
    @Define
    public final static int FILE_DEVICE_BUS_EXTENDER = 0x0000002a;
    @Define
    public final static int FILE_DEVICE_CD_ROM = 0x00000002;
    @Define
    public final static int FILE_DEVICE_CD_ROM_FILE_SYSTEM = 0x00000003;
    @Define
    public final static int FILE_DEVICE_CHANGER = 0x00000030;
    @Define
    public final static int FILE_DEVICE_CONSOLE = 0x00000050;
    @Define
    public final static int FILE_DEVICE_CONTROLLER = 0x00000004;
    @Define
    public final static int FILE_DEVICE_CRYPT_PROVIDER = 0x0000003F;
    @Define
    public final static int FILE_DEVICE_DATALINK = 0x00000005;
    @Define
    public final static int FILE_DEVICE_DEVAPI = 0x00000047;
    @Define
    public final static int FILE_DEVICE_DFS = 0x00000006;
    @Define
    public final static int FILE_DEVICE_DFS_FILE_SYSTEM = 0x00000035;
    @Define
    public final static int FILE_DEVICE_DFS_VOLUME = 0x00000036;
    @Define
    public final static int FILE_DEVICE_DISK = 0x00000007;
    @Define
    public final static int FILE_DEVICE_DISK_FILE_SYSTEM = 0x00000008;
    @Define
    public final static int FILE_DEVICE_DVD = 0x00000033;
    @Define
    public final static int FILE_DEVICE_EHSTOR = 0x00000046;
    @Define
    public final static int FILE_DEVICE_FILE_SYSTEM = 0x00000009;
    @Define
    public final static int FILE_DEVICE_FIPS = 0x0000003A;
    @Define
    public final static int FILE_DEVICE_FULLSCREEN_VIDEO = 0x00000034;
    @Define
    public final static int FILE_DEVICE_GPIO = 0x00000048;
    @Define
    public final static int FILE_DEVICE_HOLOGRAPHIC = 0x0000005b;
    @Define
    public final static int FILE_DEVICE_INFINIBAND = 0x0000003B;
    @Define
    public final static int FILE_DEVICE_INPORT_PORT = 0x0000000a;
    @Define
    public final static int FILE_DEVICE_KEYBOARD = 0x0000000b;
    @Define
    public final static int FILE_DEVICE_KS = 0x0000002f;
    @Define
    public final static int FILE_DEVICE_KSEC = 0x00000039;
    @Define
    public final static int FILE_DEVICE_MAILSLOT = 0x0000000c;
    @Define
    public final static int FILE_DEVICE_MASS_STORAGE = 0x0000002d;
    @Define
    public final static int FILE_DEVICE_MIDI_IN = 0x0000000d;
    @Define
    public final static int FILE_DEVICE_MIDI_OUT = 0x0000000e;
    @Define
    public final static int FILE_DEVICE_MODEM = 0x0000002b;
    @Define
    public final static int FILE_DEVICE_MOUSE = 0x0000000f;
    @Define
    public final static int FILE_DEVICE_MT_COMPOSITE = 0x00000042;
    @Define
    public final static int FILE_DEVICE_MT_TRANSPORT = 0x00000043;
    @Define
    public final static int FILE_DEVICE_MULTI_UNC_PROVIDER = 0x00000010;
    @Define
    public final static int FILE_DEVICE_NAMED_PIPE = 0x00000011;
    @Define
    public final static int FILE_DEVICE_NETWORK = 0x00000012;
    @Define
    public final static int FILE_DEVICE_NETWORK_BROWSER = 0x00000013;
    @Define
    public final static int FILE_DEVICE_NETWORK_FILE_SYSTEM = 0x00000014;
    @Define
    public final static int FILE_DEVICE_NETWORK_REDIRECTOR = 0x00000028;
    @Define
    public final static int FILE_DEVICE_NFP = 0x00000051;
    @Define
    public final static int FILE_DEVICE_NULL = 0x00000015;
    @Define
    public final static int FILE_DEVICE_NVDIMM = 0x0000005a;
    @Define
    public final static int FILE_DEVICE_PARALLEL_PORT = 0x00000016;
    @Define
    public final static int FILE_DEVICE_PERSISTENT_MEMORY = 0x00000059;
    @Define
    public final static int FILE_DEVICE_PHYSICAL_NETCARD = 0x00000017;
    @Define
    public final static int FILE_DEVICE_PMI = 0x00000045;
    @Define
    public final static int FILE_DEVICE_POINT_OF_SERVICE = 0x00000054;
    @Define
    public final static int FILE_DEVICE_PRINTER = 0x00000018;
    @Define
    public final static int FILE_DEVICE_SCANNER = 0x00000019;
    @Define
    public final static int FILE_DEVICE_SCREEN = 0x0000001c;
    @Define
    public final static int FILE_DEVICE_SDFXHCI = 0x0000005c;
    @Define
    public final static int FILE_DEVICE_SERENUM = 0x00000037;
    @Define
    public final static int FILE_DEVICE_SERIAL_MOUSE_PORT = 0x0000001a;
    @Define
    public final static int FILE_DEVICE_SERIAL_PORT = 0x0000001b;
    @Define
    public final static int FILE_DEVICE_SMARTCARD = 0x00000031;
    @Define
    public final static int FILE_DEVICE_SMB = 0x0000002e;
    @Define
    public final static int FILE_DEVICE_SOUND = 0x0000001d;
    @Define
    public final static int FILE_DEVICE_STORAGE_REPLICATION = 0x00000055;
    @Define
    public final static int FILE_DEVICE_STREAMS = 0x0000001e;
    @Define
    public final static int FILE_DEVICE_SYSENV = 0x00000052;
    @Define
    public final static int FILE_DEVICE_TAPE = 0x0000001f;
    @Define
    public final static int FILE_DEVICE_TAPE_FILE_SYSTEM = 0x00000020;
    @Define
    public final static int FILE_DEVICE_TERMSRV = 0x00000038;
    @Define
    public final static int FILE_DEVICE_TRANSPORT = 0x00000021;
    @Define
    public final static int FILE_DEVICE_TRUST_ENV = 0x00000056;
    @Define
    public final static int FILE_DEVICE_UCM = 0x00000057;
    @Define
    public final static int FILE_DEVICE_UCMTCPCI = 0x00000058;
    @Define
    public final static int FILE_DEVICE_UCMUCSI = 0x0000005d;
    @Define
    public final static int FILE_DEVICE_UNKNOWN = 0x00000022;
    @Define
    public final static int FILE_DEVICE_USBEX = 0x00000049;
    @Define
    public final static int FILE_DEVICE_VDM = 0x0000002c;
    @Define
    public final static int FILE_DEVICE_VIDEO = 0x00000023;
    @Define
    public final static int FILE_DEVICE_VIRTUAL_BLOCK = 0x00000053;
    @Define
    public final static int FILE_DEVICE_VIRTUAL_DISK = 0x00000024;
    @Define
    public final static int FILE_DEVICE_VMBUS = 0x0000003E;
    @Define
    public final static int FILE_DEVICE_WAVE_IN = 0x00000025;
    @Define
    public final static int FILE_DEVICE_WAVE_OUT = 0x00000026;

    @Define
    public final static int FILE_DEVICE_WPD = 0x00000040;
    @Define
    public final static int FILE_READ_ACCESS = 0x0001;
    @Define
    public final static int FILE_SPECIAL_ACCESS = FILE_ANY_ACCESS;
    @Define
    public final static int FILE_WRITE_ACCESS = 0x0002;
    @Define
    public final static int METHOD_BUFFERED = 0;
    @Define
    public final static int FSCTL_GET_COMPRESSION = CTL_CODE(FILE_DEVICE_FILE_SYSTEM, 15, METHOD_BUFFERED, FILE_ANY_ACCESS);
    @Define
    public final static int METHOD_IN_DIRECT = 1;
    @Define
    public final static int METHOD_DIRECT_TO_HARDWARE = METHOD_IN_DIRECT;
    @Define
    public final static int METHOD_NEITHER = 3;
    @Define
    public final static int METHOD_OUT_DIRECT = 2;
    @Define
    public final static int METHOD_DIRECT_FROM_HARDWARE = METHOD_OUT_DIRECT;

    public static int CTL_CODE(int DeviceType, int Function, int Method, int Access) {
        return (((DeviceType) << 16) | ((Access) << 14) | ((Function) << 2) | (Method));
    }

    public static int DEVICE_TYPE_FROM_CTL_CODE(int ctrlCode) {
        return (((ctrlCode & 0xffff0000)) >> 16);
    }
}
