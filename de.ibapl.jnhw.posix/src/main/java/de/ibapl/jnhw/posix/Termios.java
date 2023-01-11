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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annotation.posix.termios.cc_t;
import de.ibapl.jnhw.annotation.posix.termios.speed_t;
import de.ibapl.jnhw.annotation.posix.termios.tcflag_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI___A_uL;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_sI;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_sI__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_uL___A;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.util.posix.LibcLoader;
import de.ibapl.jnhw.util.posix.PosixDataType;
import de.ibapl.jnhw.util.posix.memory.PosixStruct;
import java.io.IOException;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

/**
 * Wrapper around the {@code <termios.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">termios.h
 * - define values for termios</a>.
 *
 * Darwin aka MacOS uses uint64_t for tcflag_t ans speed_t , but uses only 32
 * bit - so we leave it for now at 32 bit access.
 *
 * @author aploese
 */
@Include("#include <termios.h>")
public final class Termios {

    public static interface BsdDefines {

        public final static int B0 = 0;
        public final static int B110 = 110;
        public final static int B115200 = 115200;
        public final static int B1200 = 1200;
        public final static int B134 = 134;
        public final static int B150 = 150;
        public final static int B1800 = 1800;
        public final static int B19200 = 19200;
        public final static int B200 = 200;
        public final static int B230400 = 230400;
        public final static int B2400 = 2400;
        public final static int B300 = 300;
        public final static int B38400 = 38400;
        public final static int B4800 = 4800;
        public final static int B50 = 50;
        public final static int B57600 = 57600;
        public final static int B600 = 600;
        public final static int B75 = 75;
        public final static int B9600 = 9600;
        public final static int BRKINT = 0000002;
        public final static int CLOCAL = 32768;
        public final static int CREAD = 2048;
        public final static int CS5 = 0000000;
        public final static int CS6 = 256;
        public final static int CS7 = 512;
        public final static int CS8 = 768;
        public final static int CSIZE = 768;
        public final static int CSTOPB = 1024;
        public final static int ECHO = 0000010;
        public final static int ECHOE = 2;
        public final static int ECHOK = 4;
        public final static int ECHONL = 16;
        public final static int HUPCL = 16384;
        public final static int ICANON = 256;
        public final static int ICRNL = 0000400;
        public final static int IEXTEN = 1024;
        public final static int IGNBRK = 0000001;
        public final static int IGNCR = 0000200;
        public final static int IGNPAR = 0000004;
        public final static int INLCR = 0000100;
        public final static int INPCK = 0000020;
        public final static int ISIG = 128;
        public final static int ISTRIP = 0000040;
        public final static int IXANY = 0004000;
        public final static int IXOFF = 1024;
        public final static int IXON = 512;
        public final static int NCCS = 20;
        public final static int NOFLSH = -2147483648;
        public final static int OCRNL = 16;
        public final static int ONLCR = 2;
        public final static int OPOST = 0000001;
        public final static int PARENB = 4096;
        public final static int PARMRK = 0000010;
        public final static int PARODD = 8192;
        public final static int TCIFLUSH = 1;
        public final static int TCIOFF = 3;
        public final static int TCIOFLUSH = 3;
        public final static int TCION = 4;
        public final static int TCOFLUSH = 2;
        public final static int TCOOFF = 1;
        public final static int TCOON = 2;
        public final static int TCSADRAIN = 1;
        public final static int TCSAFLUSH = 2;
        public final static int TCSANOW = 0;
        public final static int TOSTOP = 4194304;
        public final static int VEOF = 0;
        public final static int VEOL = 1;
        public final static int VERASE = 3;
        public final static int VINTR = 8;
        public final static int VKILL = 5;
        public final static int VMIN = 16;
        public final static int VQUIT = 9;
        public final static int VSTART = 12;
        public final static int VSTOP = 13;
        public final static int VSUSP = 10;
        public final static int VTIME = 17;
    }

    public static class Cc_t__Formatter {

        public static void c_cc2String(Appendable sb, int index, byte c_cc) throws IOException {
            sb.append(String.format(", c_cc[%s] = 0x%02x", toCcName(index), c_cc));
        }

        public static String toCcName(int value) {
            if (VEOF == value) {
                return "VEOF";
            } else if (VEOL == value) {
                return "VEOL";
            } else if (VERASE == value) {
                return "VERASE";
            } else if (VINTR == value) {
                return "VINTR";
            } else if (VKILL == value) {
                return "VKILL";
            } else if (VMIN == value) {
                return "VMIN";
            } else if (VQUIT == value) {
                return "VQUIT";
            } else if (VSTART == value) {
                return "VSTART";
            } else if (VSTOP == value) {
                return "VSTOP";
            } else if (VSUSP == value) {
                return "VSUSP";
            } else if (VTIME == value) {
                return "VTIME";
            } else {
                return String.valueOf(value);
            }
        }

    }

    public static interface DarwinDefines extends BsdDefines {

        public final static int BS0 = 0;
        public final static int BS1 = 32768;
        public final static int BSDLY = 32768;
        public final static int CR0 = 0;
        public final static int CR1 = 4096;
        public final static int CR2 = 8192;
        public final static int CR3 = 12288;
        public final static int CRDLY = 12288;
        public final static int CRTSCTS = 196608;
        public final static int FF0 = 0;
        public final static int FF1 = 16384;
        public final static int FFDLY = 16384;
        public final static int NL0 = 0;
        public final static int NL1 = 256;
        public final static int NLDLY = 768;
        public final static int OFDEL = 131072;
        public final static int OFILL = 128;
        public final static int ONLRET = 64;
        public final static int ONOCR = 32;
        public final static int TAB0 = 0;
        public final static int TAB1 = 1024;
        public final static int TAB2 = 2048;
        public final static int TAB3 = 4;
        public final static int TABDLY = 3076;
        public final static int VT0 = 0;
        public final static int VT1 = 65536;
        public final static int VTDLY = 65536;
    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int B460800 = 460800;
        public final static int B921600 = 921600;
        public final static int CRTSCTS = 196608;
        public final static int ONLRET = 64;
        public final static int ONOCR = 32;
        public final static int TAB0 = 0;
        public final static int TAB3 = 4;
        public final static int TABDLY = 4;
    }

    public static class LinuxDefines {

        public final int B0 = 0000000;
        public final int B110 = 0000003;
        public final int B1200 = 0000011;
        public final int B134 = 0000004;
        public final int B150 = 0000005;
        public final int B1800 = 0000012;
        public final int B19200 = 0000016;
        public final int B200 = 0000006;
        public final int B2400 = 0000013;
        public final int B300 = 0000007;
        public final int B38400 = 0000017;
        public final int B4800 = 0000014;
        public final int B50 = 0000001;
        public final int B600 = 0000010;
        public final int B75 = 0000002;
        public final int B9600 = 0000015;
        public final int BRKINT = 0000002;
        public final int BS0 = 0000000;
        public final int CR0 = 0000000;
        public final int CRTSCTS = 020000000000;
        public final int CS5 = 0000000;
        public final int ECHO = 0000010;
        public final int FF0 = 0000000;
        public final int ICRNL = 0000400;
        public final int IGNBRK = 0000001;
        public final int IGNCR = 0000200;
        public final int IGNPAR = 0000004;
        public final int INLCR = 0000100;
        public final int INPCK = 0000020;
        public final int ISTRIP = 0000040;
        public final int IXANY = 0004000;
        public final int NCCS = 32;
        public final int NL0 = 0000000;
        public final int NL1 = 0000400;
        public final int OCRNL = 0000010;
        public final int OFDEL = 0000200;
        public final int OFILL = 0000100;
        public final int ONLRET = 0000040;
        public final int ONOCR = 0000020;
        public final int OPOST = 0000001;
        public final int PARMRK = 0000010;
        public final int TAB0 = 0000000;
        public final int TCIFLUSH = 0;
        public final int TCIOFF = 2;
        public final int TCIOFLUSH = 2;
        public final int TCION = 3;
        public final int TCOFLUSH = 1;
        public final int TCOOFF = 0;
        public final int TCOON = 1;
        public final int VERASE = 2;
        public final int VINTR = 0;
        public final int VKILL = 3;
        public final int VQUIT = 1;
        public final int VT0 = 0000000;

        public final int IEXTEN;
        public final int TCSADRAIN;
        public final int TCSAFLUSH;
        public final int TCSANOW;
        public final int TOSTOP;
        public final int VEOF;
        public final int VEOL;
        public final int VMIN;

        public final int B1000000;
        public final int B115200;
        public final int B1152000;
        public final int B1500000;
        public final int B2000000;
        public final int B230400;
        public final int B2500000;
        public final int B3000000;
        public final int B3500000;
        public final int B4000000;
        public final int B460800;
        public final int B500000;
        public final int B57600;
        public final int B576000;
        public final int B921600;
        public final int BS1;
        public final int BSDLY;
        public final int CLOCAL;
        public final int CR1;
        public final int CR2;
        public final int CR3;
        public final int CRDLY;
        public final int CREAD;
        public final int CS6;
        public final int CS7;
        public final int CS8;
        public final int CSIZE;
        public final int CSTOPB;
        public final int ECHOE;
        public final int ECHOK;
        public final int ECHONL;
        public final int FF1;
        public final int FFDLY;
        public final int HUPCL;
        public final int ICANON;
        public final int ISIG;
        public final int IXOFF;
        public final int IXON;
        public final int NLDLY;
        public final int NOFLSH;
        public final int ONLCR;
        public final int PARENB;
        public final int PARODD;
        public final int TAB1;
        public final int TAB2;
        public final int TAB3;
        public final int TABDLY;
        public final int VSTART;
        public final int VSTOP;
        public final int VSUSP;
        public final int VT1;
        public final int VTDLY;
        public final int VTIME;
        public final IntDefine _HAVE_STRUCT_TERMIOS_C_ISPEED;
        public final IntDefine _HAVE_STRUCT_TERMIOS_C_OSPEED;
        public final IntDefine CMSPAR = IntDefine.toIntDefine(010000000000);

        public LinuxDefines(MultiarchInfo multiarchInfo) {
            switch (multiarchInfo.getArch()) {
                case MIPS, MIPS_64 -> {
                    TCSADRAIN = 0x540F;
                    TCSAFLUSH = 0x5410;
                    TCSANOW = 0x540E;
                    VEOF = 16;
                    _HAVE_STRUCT_TERMIOS_C_ISPEED = IntDefine.toIntDefine(0);
                    _HAVE_STRUCT_TERMIOS_C_OSPEED = IntDefine.toIntDefine(0);
                }
                default -> {
                    TCSADRAIN = 1;
                    TCSAFLUSH = 2;
                    TCSANOW = 0;
                    VEOF = 4;
                    _HAVE_STRUCT_TERMIOS_C_ISPEED = IntDefine.toIntDefine(1);
                    _HAVE_STRUCT_TERMIOS_C_OSPEED = IntDefine.toIntDefine(1);
                }
            }
            switch (multiarchInfo.getArch()) {
                case MIPS, MIPS_64 -> {
                    IEXTEN = 0000400;
                    TOSTOP = 0100000;
                    VEOL = 17;
                    VMIN = 4;
                }
                case POWER_PC_64 -> {
                    IEXTEN = 1024;
                    TOSTOP = 4194304;
                    VEOL = 6;
                    VMIN = 5;
                }
                default -> {
                    IEXTEN = 0100000;
                    TOSTOP = 0000400;
                    VEOL = 11;
                    VMIN = 6;
                }
            }
            switch (multiarchInfo.getArch()) {
                case POWER_PC_64 -> {
                    B1000000 = 23;
                    B115200 = 17;
                    B1152000 = 24;
                    B1500000 = 25;
                    B2000000 = 26;
                    B230400 = 18;
                    B2500000 = 27;
                    B3000000 = 28;
                    B3500000 = 29;
                    B4000000 = 30;
                    B460800 = 19;
                    B500000 = 20;
                    B57600 = 16;
                    B576000 = 21;
                    B921600 = 22;
                    BS1 = 32768;
                    BSDLY = 32768;
                    CLOCAL = 32768;
                    CR1 = 4096;
                    CR2 = 8192;
                    CR3 = 12288;
                    CRDLY = 12288;
                    CREAD = 2048;
                    CS6 = 256;
                    CS7 = 512;
                    CS8 = 768;
                    CSIZE = 768;
                    CSTOPB = 1024;
                    ECHOE = 2;
                    ECHOK = 4;
                    ECHONL = 16;
                    FF1 = 16384;
                    FFDLY = 16384;
                    HUPCL = 16384;
                    ICANON = 256;
                    ISIG = 128;
                    IXOFF = 1024;
                    IXON = 512;
                    NLDLY = 768;
                    NOFLSH = -2147483648;
                    ONLCR = 2;
                    PARENB = 4096;
                    PARODD = 8192;
                    TAB1 = 1024;
                    TAB2 = 2048;
                    TAB3 = 3072;
                    TABDLY = 3072;
                    VSTART = 13;
                    VSTOP = 14;
                    VSUSP = 12;
                    VT1 = 65536;
                    VTDLY = 65536;
                    VTIME = 7;
                }
                default -> {
                    B1000000 = 0010010;
                    B115200 = 0010002;
                    B1152000 = 0010011;
                    B1500000 = 0010012;
                    B2000000 = 0010013;
                    B230400 = 0010003;
                    B2500000 = 0010014;
                    B3000000 = 0010015;
                    B3500000 = 0010016;
                    B4000000 = 0010017;
                    B460800 = 0010004;
                    B500000 = 0010005;
                    B57600 = 0010001;
                    B576000 = 0010006;
                    B921600 = 0010007;
                    BS1 = 0020000;
                    BSDLY = 0020000;
                    CLOCAL = 0004000;
                    CR1 = 0001000;
                    CR2 = 0002000;
                    CR3 = 0003000;
                    CRDLY = 0003000;
                    CREAD = 0000200;
                    CS6 = 0000020;
                    CS7 = 0000040;
                    CS8 = 0000060;
                    CSIZE = 0000060;
                    CSTOPB = 0000100;
                    ECHOE = 0000020;
                    ECHOK = 0000040;
                    ECHONL = 0000100;
                    FF1 = 0100000;
                    FFDLY = 0100000;
                    HUPCL = 0002000;
                    ICANON = 0000002;
                    ISIG = 0000001;
                    IXOFF = 0010000;
                    IXON = 0002000;
                    NLDLY = 0000400;
                    NOFLSH = 0000200;
                    ONLCR = 0000004;
                    PARENB = 0000400;
                    PARODD = 0001000;
                    TAB1 = 0004000;
                    TAB2 = 0010000;
                    TAB3 = 0014000;
                    TABDLY = 0014000;
                    VSTART = 8;
                    VSTOP = 9;
                    VSUSP = 10;
                    VT1 = 0040000;
                    VTDLY = 0040000;
                    VTIME = 5;
                }
            }

        }
    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int CRTSCTS = 65536;
        public final static int ONLRET = 128;
        public final static int ONOCR = 64;
    }

    /**
     * speed_t takes only symbolic constants, so the sign is of no relevance...
     */
    public static class Speed_t_Formatter {

        public static String speed_tToString(int speed_t) {
            if (speed_t == B0) {
                return "0";
            } else if (speed_t == B50) {
                return "50";
            } else if (speed_t == B75) {
                return "75";
            } else if (speed_t == B110) {
                return "110";
            } else if (speed_t == B134) {
                return "134";
            } else if (speed_t == B150) {
                return "150";
            } else if (speed_t == B200) {
                return "200";
            } else if (speed_t == B300) {
                return "300";
            } else if (speed_t == B600) {
                return "600";
            } else if (speed_t == B1200) {
                return "1200";
            } else if (speed_t == B1800) {
                return "1800";
            } else if (speed_t == B2400) {
                return "2400";
            } else if (speed_t == B4800) {
                return "4800";
            } else if (speed_t == B9600) {
                return "9600";
            } else if (speed_t == B19200) {
                return "19200";
            } else if (speed_t == B38400) {
                return "38400";
            } else if (speed_t == B57600) {
                return "57600";
            } else if (speed_t == B115200) {
                return "115200";
            } else if (speed_t == B230400) {
                return "230400";
            } else if (B460800.isEqualsTo(speed_t)) {
                return "460800";
            } else if (B500000.isEqualsTo(speed_t)) {
                return "500000";
            } else if (B576000.isEqualsTo(speed_t)) {
                return "576000";
            } else if (B921600.isEqualsTo(speed_t)) {
                return "921600";
            } else if (B1000000.isEqualsTo(speed_t)) {
                return "1000000";
            } else if (B1152000.isEqualsTo(speed_t)) {
                return "1152000";
            } else if (B1500000.isEqualsTo(speed_t)) {
                return "1500000";
            } else if (B2000000.isEqualsTo(speed_t)) {
                return "2000000";
            } else if (B2500000.isEqualsTo(speed_t)) {
                return "2500000";
            } else if (B3000000.isEqualsTo(speed_t)) {
                return "3000000";
            } else if (B3500000.isEqualsTo(speed_t)) {
                return "3500000";
            } else if (B4000000.isEqualsTo(speed_t)) {
                return "4000000";
            } else {
                return "native speed id unknown to us: " + speed_t;
            }
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
     * termios}</a>.
     *
     * @author aploese
     */
    public final static class StructTermios extends PosixStruct {

        public final static Alignment alignof;
        public final static long offsetof_C_cc;
        public final static long offsetof_C_cflag;
        public final static long offsetof_C_iflag;
        public final static long offsetof_C_ispeed;
        public final static long offsetof_C_lflag;
        public final static long offsetof_C_line;
        public final static long offsetof_C_oflag;
        public final static long offsetof_C_ospeed;
        public final static int sizeof;

        static {
            switch (MultiarchTupelBuilder.getOS()) {
                case LINUX:
                    alignof = Alignment.AT_4;
                    offsetof_C_iflag = 0;
                    offsetof_C_oflag = 4;
                    offsetof_C_cflag = 8;
                    offsetof_C_lflag = 12;
                    offsetof_C_cc = 17;
                    offsetof_C_line = 16;
                    switch (MultiarchTupelBuilder.getArch()) {
                        case MIPS:
                        case MIPS_64:
                            sizeof = 52;
                            offsetof_C_ispeed = -1;
                            offsetof_C_ospeed = -1;
                            break;
                        default:
                            offsetof_C_ispeed = 52;
                            offsetof_C_ospeed = 56;
                            sizeof = 60;

                    }
                    break;
                case DARWIN:
                    alignof = Alignment.AT_8;
                    sizeof = 72;
                    offsetof_C_iflag = 0;
                    offsetof_C_oflag = 8;
                    offsetof_C_cflag = 16;
                    offsetof_C_lflag = 24;
                    offsetof_C_cc = 32;
                    offsetof_C_line = -1;
                    offsetof_C_ispeed = 56;
                    offsetof_C_ospeed = 64;
                    break;
                case FREE_BSD:
                    alignof = Alignment.AT_4;
                    sizeof = 44;
                    offsetof_C_iflag = 0;
                    offsetof_C_oflag = 4;
                    offsetof_C_cflag = 8;
                    offsetof_C_lflag = 12;
                    offsetof_C_cc = 16;
                    offsetof_C_line = -1;
                    offsetof_C_ispeed = 36;
                    offsetof_C_ospeed = 40;
                    break;
                case OPEN_BSD:
                    alignof = Alignment.AT_4;
                    sizeof = 44;
                    offsetof_C_iflag = 0;
                    offsetof_C_oflag = 4;
                    offsetof_C_cflag = 8;
                    offsetof_C_lflag = 12;
                    offsetof_C_cc = 16;
                    offsetof_C_line = -1;
                    offsetof_C_ispeed = -1;
                    offsetof_C_ospeed = -1;
                    break;
                default:
                    throw new NoClassDefFoundError("No termios.h defines for " + MultiarchTupelBuilder.getMultiarch());
            }
        }

        public final static StructTermios allocateNative(MemorySession ms) {
            return new StructTermios(MemorySegment.allocateNative(sizeof, ms), 0);
        }

        public StructTermios(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, StructTermios.sizeof);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param index the index.
         * @return native value of c_cx[index].
         */
        @cc_t
        public byte c_cc(int index) {
            if ((index < 0) || (index >= NCCS)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            return MEM_ACCESS.uint8_t(memorySegment, StructTermios.offsetof_C_cc + index);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param index the index.
         * @param value the value of c_cx[index] to be set natively.
         */
        public void c_cc(int index, @cc_t byte value) {
            if ((index < 0) || (index >= NCCS)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            MEM_ACCESS.uint8_t(memorySegment, StructTermios.offsetof_C_cc + index, value);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_cflag.
         */
        @tcflag_t
        public int c_cflag() {
            return ACCESSOR_TCFLAG_T.tcflag_tAsInt(memorySegment, StructTermios.offsetof_C_cflag);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_cflag to be set natively.
         */
        public void c_cflag(@tcflag_t int value) {
            ACCESSOR_TCFLAG_T.tcflag_tFromInt(memorySegment, StructTermios.offsetof_C_cflag, value);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return the native value of c_iflag.
         */
        @tcflag_t
        public int c_iflag() {
            return ACCESSOR_TCFLAG_T.tcflag_tAsInt(memorySegment, StructTermios.offsetof_C_iflag);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_iflag to be set natively.
         */
        public void c_iflag(@tcflag_t int value) {
            ACCESSOR_TCFLAG_T.tcflag_tFromInt(memorySegment, StructTermios.offsetof_C_iflag, value);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_ispeed.
         * @throws NoSuchNativeTypeMemberException if c_ispeed does not *
         * exists.
         */
        @speed_t
        public int c_ispeed() throws NoSuchNativeTypeMemberException {
            if (StructTermios.offsetof_C_ispeed == -1) {
                throw new NoSuchNativeTypeMemberException("termios", "c_ispeed");
            }
            return ACCESSOR_SPEED_T.speed_tAsInt(memorySegment, StructTermios.offsetof_C_ispeed);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_ispeed to be set natively.
         * @throws NoSuchNativeTypeMemberException if c_ispeed does not *
         * exists.
         */
        public void c_ispeed(@speed_t int value) throws NoSuchNativeTypeMemberException {
            if (StructTermios.offsetof_C_ispeed == -1) {
                throw new NoSuchNativeTypeMemberException("termios", "c_ispeed");
            }
            ACCESSOR_SPEED_T.speed_tFromInt(memorySegment, StructTermios.offsetof_C_ispeed, value);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_lflag.
         */
        @tcflag_t
        public int c_lflag() {
            return ACCESSOR_TCFLAG_T.tcflag_tAsInt(memorySegment, StructTermios.offsetof_C_lflag);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_lflag to be set natively.
         */
        public void c_lflag(@tcflag_t int value) {
            ACCESSOR_TCFLAG_T.tcflag_tFromInt(memorySegment, StructTermios.offsetof_C_lflag, value);
        }

        /**
         * <b>Linux:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_line.
         * @throws NoSuchNativeTypeMemberException if c_line does not exists
         */
        @cc_t
        public byte c_line() throws NoSuchNativeTypeMemberException {
            if (StructTermios.offsetof_C_line == -1) {
                throw new NoSuchNativeTypeMemberException("termios", "c_line");
            }
            return MEM_ACCESS.uint8_t(memorySegment, StructTermios.offsetof_C_line);
        }

        /**
         * <b>Linux:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_line to be set natively.
         * @throws NoSuchNativeTypeMemberException if c_line does not * exists.
         */
        public void c_line(@cc_t byte value) throws NoSuchNativeTypeMemberException {
            if (StructTermios.offsetof_C_line == -1) {
                throw new NoSuchNativeTypeMemberException("termios", "c_line");
            }
            MEM_ACCESS.uint8_t(memorySegment, StructTermios.offsetof_C_line, value);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_oflag.
         */
        @tcflag_t
        public int c_oflag() {
            return ACCESSOR_TCFLAG_T.tcflag_tAsInt(memorySegment, StructTermios.offsetof_C_oflag);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_oflag to be set natively.
         */
        public void c_oflag(@tcflag_t int value) {
            ACCESSOR_TCFLAG_T.tcflag_tFromInt(memorySegment, StructTermios.offsetof_C_oflag, value);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_ospeed.
         * @throws NoSuchNativeTypeMemberException if c_ospeed does not *
         * exists.
         */
        @speed_t
        public int c_ospeed() throws NoSuchNativeTypeMemberException {
            if (StructTermios.offsetof_C_ospeed == -1) {
                throw new NoSuchNativeTypeMemberException("termios", "c_ispeed");
            }
            return ACCESSOR_SPEED_T.speed_tAsInt(memorySegment, StructTermios.offsetof_C_ospeed);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_ospeed to be set natively.
         * @throws NoSuchNativeTypeMemberException if c_ospeed does not *
         * exists.
         */
        public void c_ospeed(@speed_t int value) throws NoSuchNativeTypeMemberException {
            if (StructTermios.offsetof_C_ospeed == -1) {
                throw new NoSuchNativeTypeMemberException("termios", "c_ispeed");
            }
            ACCESSOR_SPEED_T.speed_tFromInt(memorySegment, StructTermios.offsetof_C_ospeed, value);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendMember("c_iflag", "[", (sbu) -> Tcflag_t__Formatter.c_iflag2String(sbu, c_iflag()), "]");
            jsb.appendMember("c_oflag", "[", (sbu) -> Tcflag_t__Formatter.c_oflag2String(sb, c_oflag()), "]");
            jsb.appendMember("c_cflag", "[", (sbu) -> Tcflag_t__Formatter.c_cflag2String(sb, c_cflag()), "]");
            jsb.appendMember("c_lflag", "[", (sbu) -> Tcflag_t__Formatter.c_lflag2String(sb, c_lflag()), "]");
            try {
                jsb.appendHexByteMember("c_line", c_line());
            } catch (NoSuchNativeTypeMemberException nstme) {
            }
            try {
                switch (PosixDataType.speed_t) {
                    case uint32_t:
                        jsb.appendHexIntMember("c_ispeed", (int) c_ispeed());
                        break;
                    case uint64_t:
                        jsb.appendHexLongMember("c_ispeed", c_ispeed());
                        break;
                    default:
                        throw new RuntimeException("Can't handle PosixDataType.speed_t for c_ispeed");
                }
            } catch (NoSuchNativeTypeMemberException nstme) {
            }
            try {
                switch (PosixDataType.speed_t) {
                    case uint32_t:
                        jsb.appendHexIntMember("c_ospeed", (int) c_ospeed());
                        break;
                    case uint64_t:
                        jsb.appendHexLongMember("c_ospeed", c_ospeed());
                        break;
                    default:
                        throw new RuntimeException("Can't handle PosixDataType.speed_t for c_ospeed");
                }
            } catch (NoSuchNativeTypeMemberException nstme) {
            }
            for (int i = 0; i < NCCS; i++) {
                Cc_t__Formatter.c_cc2String(sb, i, c_cc(i));
            }
            jsb.close();
        }
    }

    public static class Tcflag_t__Formatter {

        public static void c_cflag2String(Appendable sb, int c_cflag) throws IOException {
            if ((CSIZE & c_cflag) == CS5) {
                sb.append("CS5 ");
                c_cflag &= ~CS5;
            }
            if ((CSIZE & c_cflag) == CS6) {
                sb.append("CS6 ");
                c_cflag &= ~CS6;
            }
            if ((CSIZE & c_cflag) == CS7) {
                sb.append("CS7 ");
                c_cflag &= ~CS7;
            }
            if ((CSIZE & c_cflag) == CS8) {
                sb.append("CS8 ");
                c_cflag &= ~CS8;
            }
            if ((CSTOPB & c_cflag) == CSTOPB) {
                sb.append("CSTOPB ");
                c_cflag &= ~CSTOPB;
            }
            if ((CREAD & c_cflag) == CREAD) {
                sb.append("CREAD ");
                c_cflag &= ~CREAD;
            }
            if ((PARENB & c_cflag) == PARENB) {
                sb.append("PARENB ");
                c_cflag &= ~PARENB;
            }
            if ((PARODD & c_cflag) == PARODD) {
                sb.append("PARODD ");
                c_cflag &= ~PARODD;
            }
            if ((HUPCL & c_cflag) == HUPCL) {
                sb.append("HUPCL ");
                c_cflag &= ~HUPCL;
            }
            if ((CLOCAL & c_cflag) == CLOCAL) {
                sb.append("CLOCAL ");
                c_cflag &= ~CLOCAL;
            }
            if ((CRTSCTS & c_cflag) == CRTSCTS) {
                sb.append("CRTSCTS ");
                c_cflag &= ~CRTSCTS;
            }
            if (CMSPAR.isDefined()) {
                if ((CMSPAR.get() & c_cflag) == CMSPAR.get()) {
                    sb.append("CMSPAR ");
                    c_cflag &= ~CMSPAR.get();
                }
            }
            if (PAREXT.isDefined()) {
                if ((PAREXT.get() & c_cflag) == PAREXT.get()) {
                    sb.append("PAREXT ");
                    c_cflag &= ~PAREXT.get();
                }
            }
            if (c_cflag != 0) {
                switch (PosixDataType.tcflag_t) {
                    case uint32_t:
                        sb.append(String.format("0x%08x", c_cflag));
                        break;
                    case uint64_t:
                        sb.append(String.format("0x%016x", c_cflag));
                        break;
                    default:
                        throw new RuntimeException("Can't handle PosixDataType.tcflag_t");
                }
            }
        }

        public static void c_iflag2String(Appendable sb, int c_iflag) throws IOException {
            if ((BRKINT & c_iflag) == BRKINT) {
                sb.append("BRKINT ");
                c_iflag &= ~BRKINT;
            }
            if ((ICRNL & c_iflag) == ICRNL) {
                sb.append("ICRNL ");
                c_iflag &= ~ICRNL;
            }
            if ((IGNBRK & c_iflag) == IGNBRK) {
                sb.append("IGNBRK ");
                c_iflag &= ~IGNBRK;
            }
            if ((IGNCR & c_iflag) == IGNCR) {
                sb.append("IGNCR ");
                c_iflag &= ~IGNCR;
            }
            if ((IGNPAR & c_iflag) == IGNPAR) {
                sb.append("IGNPAR ");
                c_iflag &= ~IGNPAR;
            }
            if ((INLCR & c_iflag) == INLCR) {
                sb.append("INLCR ");
                c_iflag &= ~INLCR;
            }
            if ((INPCK & c_iflag) == INPCK) {
                sb.append("INPCK ");
                c_iflag &= ~INPCK;
            }
            if ((ISTRIP & c_iflag) == ISTRIP) {
                sb.append("ISTRIP ");
                c_iflag &= ~ISTRIP;
            }
            if ((IXANY & c_iflag) == IXANY) {
                sb.append("IXANY ");
                c_iflag &= ~IXANY;
            }
            if ((IXOFF & c_iflag) == IXOFF) {
                sb.append("IXOFF ");
                c_iflag &= ~IXOFF;
            }
            if ((IXON & c_iflag) == IXON) {
                sb.append("IXON ");
                c_iflag &= ~IXON;
            }
            if ((PARMRK & c_iflag) == PARMRK) {
                sb.append("PARMRK ");
                c_iflag &= ~PARMRK;
            }
            if (c_iflag != 0) {
                switch (PosixDataType.tcflag_t) {
                    case uint32_t:
                        sb.append(String.format("0x%08x", c_iflag));
                        break;
                    case uint64_t:
                        sb.append(String.format("0x%016x", c_iflag));
                        break;
                    default:
                        throw new RuntimeException("Can't handle PosixDataType.tcflag_t");
                }
            }
        }

        public static void c_lflag2String(Appendable sb, int c_lflag) throws IOException {
            if ((ECHO & c_lflag) == ECHO) {
                sb.append("ECHO ");
                c_lflag &= ~ECHO;
            }
            if ((ECHOE & c_lflag) == ECHOE) {
                sb.append("ECHOE ");
                c_lflag &= ~ECHOE;
            }
            if ((ECHOK & c_lflag) == ECHOK) {
                sb.append("ECHOK ");
                c_lflag &= ~ECHOK;
            }
            if ((ECHONL & c_lflag) == ECHONL) {
                sb.append("ECHONL ");
                c_lflag &= ~ECHONL;
            }
            if ((ICANON & c_lflag) == ICANON) {
                sb.append("ICANON ");
                c_lflag &= ~ICANON;
            }
            if ((IEXTEN & c_lflag) == IEXTEN) {
                sb.append("IEXTEN ");
                c_lflag &= ~IEXTEN;
            }
            if ((ISIG & c_lflag) == ISIG) {
                sb.append("ISIG ");
                c_lflag &= ~ISIG;
            }
            if ((NOFLSH & c_lflag) == NOFLSH) {
                sb.append("NOFLSH ");
                c_lflag &= ~NOFLSH;
            }
            if ((TOSTOP & c_lflag) == TOSTOP) {
                sb.append("TOSTOP ");
                c_lflag &= ~TOSTOP;
            }
            if (c_lflag != 0) {
                switch (PosixDataType.tcflag_t) {
                    case uint32_t:
                        sb.append(String.format("0x%08x", c_lflag));
                        break;
                    case uint64_t:
                        sb.append(String.format("0x%016x", c_lflag));
                        break;
                    default:
                        throw new RuntimeException("Can't handle PosixDataType.tcflag_t");
                }
            }
        }

        public static void c_oflag2String(Appendable sb, int c_oflag) throws IOException {
            if ((OPOST & c_oflag) == OPOST) {
                sb.append("OPOST ");
                c_oflag &= ~OPOST;
            }
            if ((ONLCR & c_oflag) == ONLCR) {
                sb.append("ONLCR ");
                c_oflag &= ~ONLCR;
            }
            if ((OCRNL & c_oflag) == OCRNL) {
                sb.append("OCRNL ");
                c_oflag &= ~OCRNL;
            }
            if ((ONOCR & c_oflag) == ONOCR) {
                sb.append("ONOCR ");
                c_oflag &= ~ONOCR;
            }
            if ((ONLRET & c_oflag) == ONLRET) {
                sb.append("ONLRET ");
                c_oflag &= ~ONLRET;
            }
            if (OFDEL.isDefined()) {
                if ((OFDEL.get() & c_oflag) == OFDEL.get()) {
                    sb.append("OFDEL ");
                    c_oflag &= ~OFDEL.get();
                }
            }
            if (OFILL.isDefined()) {
                if ((OFILL.get() & c_oflag) == OFILL.get()) {
                    sb.append("OFILL ");
                    c_oflag &= ~OFILL.get();
                }
            }
            if (NLDLY.isDefined() && NL0.isDefined()) {
                if ((NLDLY.get() & c_oflag) == NL0.get()) {
                    sb.append("NL0 ");
                    c_oflag &= ~NL0.get();
                }
            }
            if (NLDLY.isDefined() && NL1.isDefined()) {
                if ((NLDLY.get() & c_oflag) == NL1.get()) {
                    sb.append("NL1 ");
                    c_oflag &= ~NL1.get();
                }
            }
            if (CRDLY.isDefined() && CR0.isDefined()) {
                if ((CRDLY.get() & c_oflag) == CR0.get()) {
                    sb.append("CR0 ");
                    c_oflag &= ~CR0.get();
                }
            }
            if (CRDLY.isDefined() && CR1.isDefined()) {
                if ((CRDLY.get() & c_oflag) == CR1.get()) {
                    sb.append("CR1 ");
                    c_oflag &= ~CR1.get();
                }
            }
            if (CRDLY.isDefined() && CR2.isDefined()) {
                if ((CRDLY.get() & c_oflag) == CR2.get()) {
                    sb.append("CR2 ");
                    c_oflag &= ~CR2.get();
                }
            }
            if (CRDLY.isDefined() && CR3.isDefined()) {
                if ((CRDLY.get() & c_oflag) == CR3.get()) {
                    sb.append("CR3 ");
                    c_oflag &= ~CR3.get();
                }
            }
            if (TABDLY.isDefined() && TAB0.isDefined()) {
                if ((TABDLY.get() & c_oflag) == TAB0.get()) {
                    sb.append("TAB0 ");
                    c_oflag &= ~TAB0.get();
                }
            }
            if (TABDLY.isDefined() && TAB1.isDefined()) {
                if ((TABDLY.get() & c_oflag) == TAB1.get()) {
                    sb.append("TAB1 ");
                    c_oflag &= ~TAB1.get();
                }
            }
            if (TABDLY.isDefined() && TAB2.isDefined()) {
                if ((TABDLY.get() & c_oflag) == TAB2.get()) {
                    sb.append("TAB2 ");
                    c_oflag &= ~TAB2.get();
                }
            }
            if (TABDLY.isDefined() && TAB3.isDefined()) {
                if ((TABDLY.get() & c_oflag) == TAB3.get()) {
                    sb.append("TAB3 ");
                    c_oflag &= ~TAB3.get();
                }
            }
            if (BSDLY.isDefined() && BS0.isDefined()) {
                if ((BSDLY.get() & c_oflag) == BS0.get()) {
                    sb.append("BS0 ");
                    c_oflag &= ~BS0.get();
                }
            }
            if (BSDLY.isDefined() && BS1.isDefined()) {
                if ((BSDLY.get() & c_oflag) == BS1.get()) {
                    sb.append("BS1 ");
                    c_oflag &= ~BS1.get();
                }
            }
            if (VTDLY.isDefined() && VT0.isDefined()) {
                if ((VTDLY.get() & c_oflag) == VT0.get()) {
                    sb.append("VT0 ");
                    c_oflag &= ~VT0.get();
                }
            }
            if (VTDLY.isDefined() && VT1.isDefined()) {
                if ((VTDLY.get() & c_oflag) == VT1.get()) {
                    sb.append("VT1 ");
                    c_oflag &= ~VT1.get();
                }
            }
            if (FFDLY.isDefined() && FF0.isDefined()) {
                if ((FFDLY.get() & c_oflag) == FF0.get()) {
                    sb.append("FF0 ");
                    c_oflag &= ~FF0.get();
                }
            }
            if (FFDLY.isDefined() && FF1.isDefined()) {
                if ((FFDLY.get() & c_oflag) == FF1.get()) {
                    sb.append("FF1 ");
                    c_oflag &= ~FF1.get();
                }
            }
            if (c_oflag != 0) {
                switch (PosixDataType.tcflag_t) {
                    case uint32_t:
                        sb.append(String.format("0x%08x", c_oflag));
                        break;
                    case uint64_t:
                        sb.append(String.format("0x%016x", c_oflag));
                        break;
                    default:
                        throw new RuntimeException("Can't handle PosixDataType.tcflag_t");
                }
            }
        }

    }

    /**
     * <b>Linux:</b>
     *
     */
    @Define
    public final static IntDefine _HAVE_STRUCT_TERMIOS_C_ISPEED;

    /**
     * <b>Linux:</b>
     *
     */
    @Define
    public final static IntDefine _HAVE_STRUCT_TERMIOS_C_OSPEED;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> Hang up.
     *
     */
    @Define
    @speed_t
    public final static int B0;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 1000000 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B1000000;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 110 baud.
     *
     */
    @Define
    @speed_t
    public final static int B110;

    /**
     * <b>Non POSIX:</b> <i>Baud Rate Selection</i> 115200 baud.
     *
     */
    @Define
    @speed_t
    public final static int B115200;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 1152000 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B1152000;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 1200 baud.
     *
     */
    @Define
    @speed_t
    public final static int B1200;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 134.5 baud.
     *
     */
    @Define
    @speed_t
    public final static int B134;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 150 baud.
     *
     */
    @Define
    @speed_t
    public final static int B150;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 1500000 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B1500000;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 1800 baud.
     *
     */
    @Define
    @speed_t
    public final static int B1800;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 19200 baud.
     *
     */
    @Define
    @speed_t
    public final static int B19200;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 200 baud.
     *
     */
    @Define
    @speed_t
    public final static int B200;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 2000000 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B2000000;

    /**
     * <b>Non POSIX:</b> <i>Baud Rate Selection</i> 230400 baud.
     *
     */
    @Define
    @speed_t
    public final static int B230400;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 2400 baud.
     *
     */
    @Define
    @speed_t
    public final static int B2400;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 2500000 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B2500000;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 300 baud.
     *
     */
    @Define
    @speed_t
    public final static int B300;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 3000000 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B3000000;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 3500000 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B3500000;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 38400 baud.
     *
     */
    @Define
    @speed_t
    public final static int B38400;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 4000000 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B4000000;

    /**
     * <b>Linux,FreeBSD:</b> <i>Baud Rate Selection</i> 460800 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B460800;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 4800 baud.
     *
     */
    @Define
    @speed_t
    public final static int B4800;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 50 baud.
     *
     */
    @Define
    @speed_t
    public final static int B50;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 500000 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B500000;

    /**
     * <b>Non POSIX:</b> <i>Baud Rate Selection</i> 57600 baus
     *
     */
    @Define
    @speed_t
    public final static int B57600;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 576000 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B576000;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 600 baud.
     *
     */
    @Define
    @speed_t
    public final static int B600;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 75 baud.
     *
     */
    @Define
    @speed_t
    public final static int B75;

    /**
     * <b>Linux,FreeBSD:</b> <i>Baud Rate Selection</i> 921600 baud.
     *
     */
    @Define
    @speed_t
    public final static IntDefine B921600;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 9600 baud.
     *
     */
    @Define
    @speed_t
    public final static int B9600;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Signal interrupt on break.
     *
     */
    @Define
    @tcflag_t
    public final static int BRKINT;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Backspace-delay type 0.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine BS0;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Backspace-delay type 1.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine BS1;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select backspace delays:
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine BSDLY;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Ignore modem status lines.
     *
     */
    @Define
    @tcflag_t
    public final static int CLOCAL;

    /**
     * <b>Linux:</b> <i>Control Modes</i> Use d "stick" (mark/space) parity
     * (supported on certain serial devices).
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine CMSPAR;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 0.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine CR0;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 1.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine CR1;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 2.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine CR2;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 3.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine CR3;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select carriage-return delays:
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine CRDLY;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Enable receiver.
     *
     */
    @Define
    @tcflag_t
    public final static int CREAD;

    /**
     * <b>Non POSIX:</b> <i>Control Modes</i>
     *
     */
    @Define
    @tcflag_t
    public final static int CRTSCTS;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 5 bits.
     *
     */
    @Define
    @tcflag_t
    public final static int CS5;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 6 bits.
     *
     */
    @Define
    @tcflag_t
    public final static int CS6;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 7 bits.
     *
     */
    @Define
    @tcflag_t
    public final static int CS7;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 8 bits.
     *
     */
    @Define
    @tcflag_t
    public final static int CS8;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Character size:
     *
     */
    @Define
    @tcflag_t
    public final static int CSIZE;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Send two stop bits, else one.
     *
     */
    @Define
    @tcflag_t
    public final static int CSTOPB;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Enable echo.
     *
     */
    @Define
    @tcflag_t
    public final static int ECHO;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Echo erase character as error-correcting
     * backspace.
     *
     */
    @Define
    @tcflag_t
    public final static int ECHOE;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Echo KILL.
     *
     */
    @Define
    @tcflag_t
    public final static int ECHOK;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Echo NL.
     *
     */
    @Define
    @tcflag_t
    public final static int ECHONL;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Form-feed delay type 0.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine FF0;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Form-feed delay type 1.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine FF1;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select form-feed delays:
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine FFDLY;

    public final static boolean HAVE_TERMIOS_H;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Hang up on last close.
     *
     */
    @Define
    @tcflag_t
    public final static int HUPCL;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Canonical input (erase and kill
     * processing).
     *
     */
    @Define
    @tcflag_t
    public final static int ICANON;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Map CR to NL on input.
     *
     */
    @Define
    @tcflag_t
    public final static int ICRNL;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Enable extended input character
     * processing.
     *
     */
    @Define
    @tcflag_t
    public final static int IEXTEN;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Ignore break condition.
     *
     */
    @Define
    @tcflag_t
    public final static int IGNBRK;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Ignore CR.
     *
     */
    @Define
    @tcflag_t
    public final static int IGNCR;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Ignore characters with parity errors.
     *
     */
    @Define
    @tcflag_t
    public final static int IGNPAR;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Map NL to CR on input.
     *
     */
    @Define
    @tcflag_t
    public final static int INLCR;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable input parity check.
     *
     */
    @Define
    @tcflag_t
    public final static int INPCK;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Enable signals.
     *
     */
    @Define
    @tcflag_t
    public final static int ISIG;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Strip character.
     *
     */
    @Define
    @tcflag_t
    public final static int ISTRIP;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable any character to restart output.
     *
     */
    @Define
    @tcflag_t
    public final static int IXANY;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable start/stop input control.
     *
     */
    @Define
    @tcflag_t
    public final static int IXOFF;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable start/stop output control.
     *
     */
    @Define
    @tcflag_t
    public final static int IXON;

    /**
     * <b>POSIX:</b> Size of the array c_cc for control characters.
     *
     */
    @Define
    @tcflag_t
    public final static int NCCS;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Newline type 0.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine NL0;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Newline type 1.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine NL1;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select newline delays: {@code NL0}
     * or {@code NL1}
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine NLDLY;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Disable flush after interrupt or quit.
     *
     */
    @Define
    @tcflag_t
    public final static int NOFLSH;

    /**
     * <b>POSIX,XSI:</b> <i>Output Modes</i> Map CR to NL on output.
     *
     */
    @Define
    @tcflag_t
    public final static int OCRNL;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Fill is DEL.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine OFDEL;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Use fill characters for delay.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine OFILL;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Map NL to CR-NL on output.
     *
     */
    @Define
    @tcflag_t
    public final static int ONLCR;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> NL performs CR function.
     *
     */
    @Define
    @tcflag_t
    public final static int ONLRET;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> No CR output at column 0.
     *
     */
    @Define
    @tcflag_t
    public final static int ONOCR;

    /**
     * <b>POSIX:</b> <i>Output Modes</i> Post-process output.
     *
     */
    @Define
    @tcflag_t
    public final static int OPOST;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Parity enable.
     *
     */
    @Define
    @tcflag_t
    public final static int PARENB;

    /**
     * <b>???:</b> <i>Control Modes</i> ???Use d "stick" (mark/space) parity
     * (supported on certain serial devices).???
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine PAREXT;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Mark parity errors.
     *
     */
    @Define
    @tcflag_t
    public final static int PARMRK;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Odd parity, else even.
     *
     */
    @Define
    @tcflag_t
    public final static int PARODD;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Horizontal-tab delay type 0.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine TAB0;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Horizontal-tab delay type 1.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine TAB1;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Horizontal-tab delay type 2.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine TAB2;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Expand tabs to spaces.
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine TAB3;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select horizontal-tab delays:
     *
     */
    @Define
    @tcflag_t
    public final static IntDefine TABDLY;

    /**
     * <b>POSIX:</b> <i>Line Control</i> Flush pending input.
     *
     */
    @Define
    @tcflag_t
    public final static int TCIFLUSH;

    /**
     * <b>POSIX:</b> <i>Line Control</i> Transmit a STOP character, intended to
     * suspend input data.
     *
     */
    @Define
    @tcflag_t
    public final static int TCIOFF;

    /**
     * <b>POSIX:</b> <i>Line Control</i> Flush both pending input and
     * untransmitted output.
     *
     */
    @Define
    @tcflag_t
    public final static int TCIOFLUSH;

    /**
     * <b>POSIX:</b> <i>Line Control</i> Transmit a START character, intended to
     * restart input data.
     *
     */
    @Define
    @tcflag_t
    public final static int TCION;

    /**
     * <b>POSIX:</b> <i>Line Control</i> Flush untransmitted output.
     *
     */
    @Define
    @tcflag_t
    public final static int TCOFLUSH;

    /**
     * <b>POSIX:</b> <i>Line Control</i> Suspend output.
     *
     */
    @Define
    @tcflag_t
    public final static int TCOOFF;

    /**
     * <b>POSIX:</b> <i>Line Control</i> Restart output.
     *
     */
    @Define
    @tcflag_t
    public final static int TCOON;

    /**
     * <b>POSIX:</b> <i>Attribute Selection</i> Change attributes when output
     * has drained; also flush pending input.
     *
     */
    @Define
    @tcflag_t
    public final static int TCSADRAIN;

    /**
     * <b>POSIX:</b> <i>Attribute Selection</i> Change attributes when output
     * has drained.
     *
     */
    @Define
    @tcflag_t
    public final static int TCSAFLUSH;

    /**
     * <b>POSIX:</b> <i>Attribute Selection</i> Change attributes immediately.
     *
     */
    @Define
    @tcflag_t
    public final static int TCSANOW;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Send SIGTTOU for background output.
     *
     */
    @Define
    @tcflag_t
    public final static int TOSTOP;

    /**
     * <b>POSIX:</b> EOF character in <b>Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VEOF;

    /**
     * <b>POSIX:</b> EOL character in <b>Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VEOL;

    /**
     * <b>POSIX:</b> ERASE character in <b>Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VERASE;

    /**
     * <b>POSIX:</b> INTR character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VINTR;

    /**
     * <b>POSIX:</b> KILL character in <b>Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VKILL;

    /**
     * <b>POSIX:</b> MIN value in <b>Non-Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VMIN;

    /**
     * <b>POSIX:</b> QUIT character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VQUIT;

    /**
     * <b>POSIX:</b> START character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VSTART;

    /**
     * <b>POSIX:</b> STOP character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VSTOP;

    /**
     * <b>POSIX:</b> VSUSP character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VSUSP;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Vertical-tab delay type 0.
     *
     */
    @Define
    @cc_t
    public final static IntDefine VT0;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Vertical-tab delay type 1.
     *
     */
    @Define
    @cc_t
    public final static IntDefine VT1;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select vertical-tab delays:
     *
     */
    @Define
    @cc_t
    public final static IntDefine VTDLY;

    /**
     * <b>POSIX:</b> VTIME value in <b>Non-Canonical Mode</b>.
     *
     */
    @Define
    @cc_t
    public final static int VTIME;

    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                final LinuxDefines linuxDefines = new LinuxDefines(MultiarchTupelBuilder.getMultiarch());
                B0 = linuxDefines.B0;

                B110 = linuxDefines.B110;
                B1200 = linuxDefines.B1200;
                B134 = linuxDefines.B134;
                B150 = linuxDefines.B150;
                B1800 = linuxDefines.B1800;
                B19200 = linuxDefines.B19200;
                B200 = linuxDefines.B200;
                B2400 = linuxDefines.B2400;
                B300 = linuxDefines.B300;
                B38400 = linuxDefines.B38400;
                B4800 = linuxDefines.B4800;
                B50 = linuxDefines.B50;
                B600 = linuxDefines.B600;

                B75 = linuxDefines.B75;
                B9600 = linuxDefines.B9600;

                BRKINT = linuxDefines.BRKINT;
                BS0 = IntDefine.toIntDefine(linuxDefines.BS0);
                CR0 = IntDefine.toIntDefine(linuxDefines.CR0);

                B1000000 = IntDefine.toIntDefine(linuxDefines.B1000000);
                B115200 = linuxDefines.B115200;
                B1152000 = IntDefine.toIntDefine(linuxDefines.B1152000);
                B1500000 = IntDefine.toIntDefine(linuxDefines.B1500000);
                B2000000 = IntDefine.toIntDefine(linuxDefines.B2000000);
                B230400 = linuxDefines.B230400;
                B2500000 = IntDefine.toIntDefine(linuxDefines.B2500000);
                B3000000 = IntDefine.toIntDefine(linuxDefines.B3000000);
                B3500000 = IntDefine.toIntDefine(linuxDefines.B3500000);

                B4000000 = IntDefine.toIntDefine(linuxDefines.B4000000);
                B460800 = IntDefine.toIntDefine(linuxDefines.B460800);
                B500000 = IntDefine.toIntDefine(linuxDefines.B500000);
                B57600 = linuxDefines.B57600;
                B576000 = IntDefine.toIntDefine(linuxDefines.B576000);
                B921600 = IntDefine.toIntDefine(linuxDefines.B921600);
                BS1 = IntDefine.toIntDefine(linuxDefines.BS1);
                BSDLY = IntDefine.toIntDefine(linuxDefines.BSDLY);

                CLOCAL = linuxDefines.CLOCAL;
                CR1 = IntDefine.toIntDefine(linuxDefines.CR1);
                CR2 = IntDefine.toIntDefine(linuxDefines.CR2);
                CR3 = IntDefine.toIntDefine(linuxDefines.CR3);
                CRDLY = IntDefine.toIntDefine(linuxDefines.CRDLY);
                CS6 = linuxDefines.CS6;
                CS7 = linuxDefines.CS7;
                CS8 = linuxDefines.CS8;
                TAB1 = IntDefine.toIntDefine(linuxDefines.TAB1);
                TAB2 = IntDefine.toIntDefine(linuxDefines.TAB2);
                TAB3 = IntDefine.toIntDefine(linuxDefines.TAB3);
                TABDLY = IntDefine.toIntDefine(linuxDefines.TABDLY);
                CREAD = linuxDefines.CREAD;
                CSIZE = linuxDefines.CSIZE;
                CSTOPB = linuxDefines.CSTOPB;
                ECHOE = linuxDefines.ECHOE;
                ECHOK = linuxDefines.ECHOK;
                ECHONL = linuxDefines.ECHONL;
                FF1 = IntDefine.toIntDefine(linuxDefines.FF1);
                FFDLY = IntDefine.toIntDefine(linuxDefines.FFDLY);

                HUPCL = linuxDefines.HUPCL;
                PARENB = linuxDefines.PARENB;
                PARODD = linuxDefines.PARODD;
                ICANON = linuxDefines.ICANON;
                ISIG = linuxDefines.ISIG;
                IXOFF = linuxDefines.IXOFF;
                IXON = linuxDefines.IXON;
                NLDLY = IntDefine.toIntDefine(linuxDefines.NLDLY);
                NOFLSH = linuxDefines.NOFLSH;
                ONLCR = linuxDefines.ONLCR;
                VSTART = linuxDefines.VSTART;
                VSTOP = linuxDefines.VSTOP;
                VSUSP = linuxDefines.VSUSP;
                VT1 = IntDefine.toIntDefine(linuxDefines.VT1);
                VTDLY = IntDefine.toIntDefine(linuxDefines.VTDLY);
                VTIME = linuxDefines.VTIME;

                CRTSCTS = linuxDefines.CRTSCTS;
                CS5 = linuxDefines.CS5;

                ECHO = linuxDefines.ECHO;

                FF0 = IntDefine.toIntDefine(linuxDefines.FF0);
                HAVE_TERMIOS_H = true;

                ICRNL = linuxDefines.ICRNL;
                IGNBRK = linuxDefines.IGNBRK;
                IGNCR = linuxDefines.IGNCR;
                IGNPAR = linuxDefines.IGNPAR;
                INLCR = linuxDefines.INLCR;
                INPCK = linuxDefines.INPCK;
                ISTRIP = linuxDefines.ISTRIP;
                IXANY = linuxDefines.IXANY;

                NCCS = linuxDefines.NCCS;
                NL0 = IntDefine.toIntDefine(linuxDefines.NL0);
                NL1 = IntDefine.toIntDefine(linuxDefines.NL1);

                OCRNL = linuxDefines.OCRNL;
                OFDEL = IntDefine.toIntDefine(linuxDefines.OFDEL);
                OFILL = IntDefine.toIntDefine(linuxDefines.OFILL);
                ONLRET = linuxDefines.ONLRET;
                ONOCR = linuxDefines.ONOCR;
                OPOST = linuxDefines.OPOST;

                PAREXT = IntDefine.UNDEFINED;
                PARMRK = linuxDefines.PARMRK;

                TAB0 = IntDefine.toIntDefine(linuxDefines.TAB0);
                TCIFLUSH = linuxDefines.TCIFLUSH;
                TCIOFF = linuxDefines.TCIOFF;
                TCIOFLUSH = linuxDefines.TCIOFLUSH;
                TCION = linuxDefines.TCION;
                TCOFLUSH = linuxDefines.TCOFLUSH;
                TCOOFF = linuxDefines.TCOOFF;
                TCOON = linuxDefines.TCOON;
                VERASE = linuxDefines.VERASE;
                VINTR = linuxDefines.VINTR;
                VKILL = linuxDefines.VKILL;
                VQUIT = linuxDefines.VQUIT;
                VT0 = IntDefine.toIntDefine(linuxDefines.VT0);

                CMSPAR = linuxDefines.CMSPAR;
                TCSADRAIN = linuxDefines.TCSADRAIN;
                TCSAFLUSH = linuxDefines.TCSAFLUSH;
                TCSANOW = linuxDefines.TCSANOW;

                VEOF = linuxDefines.VEOF;

                _HAVE_STRUCT_TERMIOS_C_ISPEED = linuxDefines._HAVE_STRUCT_TERMIOS_C_ISPEED;
                _HAVE_STRUCT_TERMIOS_C_OSPEED = linuxDefines._HAVE_STRUCT_TERMIOS_C_OSPEED;
                TOSTOP = linuxDefines.TOSTOP;
                VEOL = linuxDefines.VEOL;
                IEXTEN = linuxDefines.IEXTEN;
                VMIN = linuxDefines.VMIN;

                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_TERMIOS_H = true;
                B0 = BsdDefines.B0;
                B110 = BsdDefines.B110;
                B1200 = BsdDefines.B1200;
                B134 = BsdDefines.B134;
                B150 = BsdDefines.B150;
                B1800 = BsdDefines.B1800;
                B19200 = BsdDefines.B19200;
                B200 = BsdDefines.B200;
                B2400 = BsdDefines.B2400;
                B300 = BsdDefines.B300;
                B38400 = BsdDefines.B38400;
                B4800 = BsdDefines.B4800;
                B50 = BsdDefines.B50;
                B600 = BsdDefines.B600;

                B75 = BsdDefines.B75;
                B9600 = BsdDefines.B9600;

                BRKINT = BsdDefines.BRKINT;

                B1000000 = IntDefine.UNDEFINED;
                B115200 = BsdDefines.B115200;
                B1152000 = IntDefine.UNDEFINED;
                B1500000 = IntDefine.UNDEFINED;
                B2000000 = IntDefine.UNDEFINED;
                B230400 = BsdDefines.B230400;
                B2500000 = IntDefine.UNDEFINED;
                B3000000 = IntDefine.UNDEFINED;
                B3500000 = IntDefine.UNDEFINED;

                B4000000 = IntDefine.UNDEFINED;
                B500000 = IntDefine.UNDEFINED;
                B57600 = BsdDefines.B57600;
                B576000 = IntDefine.UNDEFINED;

                CLOCAL = BsdDefines.CLOCAL;
                CS6 = BsdDefines.CS6;
                CS7 = BsdDefines.CS7;
                CS8 = BsdDefines.CS8;
                CREAD = BsdDefines.CREAD;
                CSIZE = BsdDefines.CSIZE;
                CSTOPB = BsdDefines.CSTOPB;
                ECHOE = BsdDefines.ECHOE;
                ECHOK = BsdDefines.ECHOK;
                ECHONL = BsdDefines.ECHONL;
                TOSTOP = BsdDefines.TOSTOP;
                VEOL = BsdDefines.VEOL;
                IEXTEN = BsdDefines.IEXTEN;
                VMIN = BsdDefines.VMIN;

                HUPCL = BsdDefines.HUPCL;
                PARENB = BsdDefines.PARENB;
                PARODD = BsdDefines.PARODD;
                ICANON = BsdDefines.ICANON;
                ISIG = BsdDefines.ISIG;
                IXOFF = BsdDefines.IXOFF;
                IXON = BsdDefines.IXON;
                NOFLSH = BsdDefines.NOFLSH;
                ONLCR = BsdDefines.ONLCR;
                VSTART = BsdDefines.VSTART;
                VSTOP = BsdDefines.VSTOP;
                VSUSP = BsdDefines.VSUSP;
                VTIME = BsdDefines.VTIME;
                CS5 = BsdDefines.CS5;
                ECHO = BsdDefines.ECHO;
                ICRNL = BsdDefines.ICRNL;
                IGNBRK = BsdDefines.IGNBRK;
                IGNCR = BsdDefines.IGNCR;
                IGNPAR = BsdDefines.IGNPAR;
                INLCR = BsdDefines.INLCR;
                INPCK = BsdDefines.INPCK;
                ISTRIP = BsdDefines.ISTRIP;
                IXANY = BsdDefines.IXANY;

                NCCS = BsdDefines.NCCS;

                OCRNL = BsdDefines.OCRNL;
                OPOST = BsdDefines.OPOST;

                PAREXT = IntDefine.UNDEFINED;
                PARMRK = BsdDefines.PARMRK;

                TCIFLUSH = BsdDefines.TCIFLUSH;
                TCIOFF = BsdDefines.TCIOFF;
                TCIOFLUSH = BsdDefines.TCIOFLUSH;
                TCION = BsdDefines.TCION;
                TCOFLUSH = BsdDefines.TCOFLUSH;
                TCOOFF = BsdDefines.TCOOFF;
                TCOON = BsdDefines.TCOON;
                VERASE = BsdDefines.VERASE;
                VINTR = BsdDefines.VINTR;
                VKILL = BsdDefines.VKILL;
                VQUIT = BsdDefines.VQUIT;

                CMSPAR = IntDefine.UNDEFINED;
                TCSADRAIN = BsdDefines.TCSADRAIN;
                TCSAFLUSH = BsdDefines.TCSAFLUSH;
                TCSANOW = BsdDefines.TCSANOW;

                VEOF = BsdDefines.VEOF;

                _HAVE_STRUCT_TERMIOS_C_ISPEED = IntDefine.UNDEFINED;
                _HAVE_STRUCT_TERMIOS_C_OSPEED = IntDefine.UNDEFINED;
                switch (MultiarchTupelBuilder.getOS()) {
                    case DARWIN:
                        BS0 = IntDefine.toIntDefine(DarwinDefines.BS0);
                        BS1 = IntDefine.toIntDefine(DarwinDefines.BS1);
                        BSDLY = IntDefine.toIntDefine(DarwinDefines.BSDLY);
                        CR0 = IntDefine.toIntDefine(DarwinDefines.CR0);
                        CR1 = IntDefine.toIntDefine(DarwinDefines.CR1);
                        CR2 = IntDefine.toIntDefine(DarwinDefines.CR2);
                        CR3 = IntDefine.toIntDefine(DarwinDefines.CR3);
                        CRDLY = IntDefine.toIntDefine(DarwinDefines.CRDLY);
                        FF0 = IntDefine.toIntDefine(DarwinDefines.FF0);
                        FF1 = IntDefine.toIntDefine(DarwinDefines.FF1);
                        FFDLY = IntDefine.toIntDefine(DarwinDefines.FFDLY);
                        NL0 = IntDefine.toIntDefine(DarwinDefines.NL0);
                        NL1 = IntDefine.toIntDefine(DarwinDefines.NL1);
                        NLDLY = IntDefine.toIntDefine(DarwinDefines.NLDLY);
                        OFDEL = IntDefine.toIntDefine(DarwinDefines.OFDEL);
                        OFILL = IntDefine.toIntDefine(DarwinDefines.OFILL);

                        B460800 = IntDefine.UNDEFINED;
                        B921600 = IntDefine.UNDEFINED;
                        CRTSCTS = DarwinDefines.CRTSCTS;
                        TAB0 = IntDefine.toIntDefine(DarwinDefines.TAB0);
                        TAB1 = IntDefine.toIntDefine(DarwinDefines.TAB1);
                        TAB2 = IntDefine.toIntDefine(DarwinDefines.TAB2);
                        TAB3 = IntDefine.toIntDefine(DarwinDefines.TAB3);
                        TABDLY = IntDefine.toIntDefine(DarwinDefines.TABDLY);
                        ONLRET = DarwinDefines.ONLRET;
                        ONOCR = DarwinDefines.ONOCR;
                        VT0 = IntDefine.toIntDefine(DarwinDefines.VT0);
                        VT1 = IntDefine.toIntDefine(DarwinDefines.VT1);
                        VTDLY = IntDefine.toIntDefine(DarwinDefines.VTDLY);
                        break;
                    case FREE_BSD:
                        BS0 = IntDefine.UNDEFINED;
                        BS1 = IntDefine.UNDEFINED;
                        BSDLY = IntDefine.UNDEFINED;
                        CR0 = IntDefine.UNDEFINED;
                        CR1 = IntDefine.UNDEFINED;
                        CR2 = IntDefine.UNDEFINED;
                        CR3 = IntDefine.UNDEFINED;
                        CRDLY = IntDefine.UNDEFINED;
                        FF0 = IntDefine.UNDEFINED;
                        FF1 = IntDefine.UNDEFINED;
                        FFDLY = IntDefine.UNDEFINED;
                        NL0 = IntDefine.UNDEFINED;
                        NL1 = IntDefine.UNDEFINED;
                        NLDLY = IntDefine.UNDEFINED;
                        OFDEL = IntDefine.UNDEFINED;
                        OFILL = IntDefine.UNDEFINED;
                        B460800 = IntDefine.toIntDefine(FreeBsdDefines.B460800);
                        B921600 = IntDefine.toIntDefine(FreeBsdDefines.B921600);
                        CRTSCTS = FreeBsdDefines.CRTSCTS;
                        TAB0 = IntDefine.toIntDefine(FreeBsdDefines.TAB0);
                        TAB1 = IntDefine.UNDEFINED;
                        TAB2 = IntDefine.UNDEFINED;
                        TAB3 = IntDefine.toIntDefine(FreeBsdDefines.TAB3);
                        TABDLY = IntDefine.toIntDefine(FreeBsdDefines.TABDLY);
                        ONLRET = FreeBsdDefines.ONLRET;
                        ONOCR = FreeBsdDefines.ONOCR;
                        VT0 = IntDefine.UNDEFINED;
                        VT1 = IntDefine.UNDEFINED;
                        VTDLY = IntDefine.UNDEFINED;
                        break;
                    case OPEN_BSD:
                        BS0 = IntDefine.UNDEFINED;
                        BS1 = IntDefine.UNDEFINED;
                        BSDLY = IntDefine.UNDEFINED;
                        CR0 = IntDefine.UNDEFINED;
                        CR1 = IntDefine.UNDEFINED;
                        CR2 = IntDefine.UNDEFINED;
                        CR3 = IntDefine.UNDEFINED;
                        CRDLY = IntDefine.UNDEFINED;
                        FF0 = IntDefine.UNDEFINED;
                        FF1 = IntDefine.UNDEFINED;
                        FFDLY = IntDefine.UNDEFINED;
                        NL0 = IntDefine.UNDEFINED;
                        NL1 = IntDefine.UNDEFINED;
                        NLDLY = IntDefine.UNDEFINED;
                        OFDEL = IntDefine.UNDEFINED;
                        OFILL = IntDefine.UNDEFINED;
                        B460800 = IntDefine.UNDEFINED;
                        B921600 = IntDefine.UNDEFINED;
                        CRTSCTS = OpenBsdDefines.CRTSCTS;
                        TAB0 = IntDefine.UNDEFINED;
                        TAB1 = IntDefine.UNDEFINED;
                        TAB2 = IntDefine.UNDEFINED;
                        TAB3 = IntDefine.UNDEFINED;
                        TABDLY = IntDefine.UNDEFINED;
                        ONLRET = OpenBsdDefines.ONLRET;
                        ONOCR = OpenBsdDefines.ONOCR;
                        VT0 = IntDefine.UNDEFINED;
                        VT1 = IntDefine.UNDEFINED;
                        VTDLY = IntDefine.UNDEFINED;
                        break;
                    default:
                        throw new NoClassDefFoundError("No termios.h BSD defines for " + MultiarchTupelBuilder.getMultiarch());
                }
                break;
            default:
                throw new NoClassDefFoundError("No termios.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        }

    }

    private final static JnhwMh_uL___A cfgetispeed = JnhwMh_uL___A.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "cfgetispeed",
            PosixDataType.speed_t,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_uL___A cfgetospeed = JnhwMh_uL___A.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "cfgetospeed",
            PosixDataType.speed_t,
            BaseDataType.C_const_struct_pointer);

    private final static JnhwMh_sI___A_uL cfsetispeed = JnhwMh_sI___A_uL.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "cfsetispeed",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            PosixDataType.speed_t);

    private final static JnhwMh_sI___A_uL cfsetospeed = JnhwMh_sI___A_uL.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "cfsetospeed",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            PosixDataType.speed_t);

    private final static JnhwMh_sI___A_uL cfsetspeed = JnhwMh_sI___A_uL.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "cfsetspeed",
            BaseDataType.C_int,
            BaseDataType.C_const_struct_pointer,
            PosixDataType.speed_t);

    private final static JnhwMh_sI__sI tcdrain = JnhwMh_sI__sI.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "tcdrain",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sI tcflow = JnhwMh_sI__sI_sI.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "tcflow",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sI tcflush = JnhwMh_sI__sI_sI.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "tcflush",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI__A tcgetattr = JnhwMh_sI__sI__A.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "tcgetattr",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    private final static JnhwMh_sI__sI tcgetsid = JnhwMh_sI__sI.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "tcgetsid",
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sI tcsendbreak = JnhwMh_sI__sI_sI.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "tcsendbreak",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI_sI__A tcsetattr = JnhwMh_sI__sI_sI__A.of(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "tcsetattr",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_struct_pointer);

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/cfgetispeed.html">cfgetispeed
     * - get input baud rate</a>.
     *
     * @param termios the termios structure from which the input speed is to be
     * extracted.
     * @return Upon successful completion, cfgetispeed() shall return a value of
     * type speed_t representing the input speed.
     */
    @speed_t
    public final static long cfgetispeed(StructTermios termios) {
        return cfgetispeed.invoke_uL___P(termios);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/cfgetospeed.html">cfgetispeed
     * - get output baud rate</a>.
     *
     * @param termios the termios structure from which the output speed is to be
     * extracted.
     * @return Upon successful completion, cfgetospeed() shall return a value of
     * type speed_t representing the output speed.
     */
    @speed_t
    public final static long cfgetospeed(StructTermios termios) {
        return cfgetospeed.invoke_uL___P(termios);
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/cfsetispeed.html">cfgetispeed
     * - set input baud rate</a>.
     *
     * @param termios the termios structure in which the input speed is to be
     * set.
     * @param speed the input speed to be set in the {@code  termios} structure.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void cfsetispeed(StructTermios termios, @speed_t long speed) throws NativeErrorException {
        if (cfsetispeed.invoke_sI___P_uL(termios, speed) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/cfsetospeed.html">cfgetispeed
     * - set output baud rate</a>.
     *
     * @param termios the termios structure in which the output speed is to be
     * set.
     * @param speed the output speed to be set in the {@code  termios} structure.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void cfsetospeed(StructTermios termios, @speed_t long speed) throws NativeErrorException {
        if (cfsetospeed.invoke_sI___P_uL(termios, speed) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>Non POSIX:</b> set input and output spped at the same time.
     *
     * @param termios the termios structure in which the input and output speed
     * is to be set.
     * @param speed the speed to be set in the {@code  termios} structure.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void cfsetspeed(StructTermios termios, @speed_t long speed) throws NativeErrorException {
        if (cfsetspeed.invoke_sI___P_uL(termios, speed) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tcdrain.html">tcdrain
     * - wait for transmission of output</a>.
     *
     * @param fildes an open file descriptor associated with a terminal.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void tcdrain(int fildes) throws NativeErrorException {
        if (tcdrain.invoke_sI__sI(fildes) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tcflow.html">tcflow
     * - suspend or restart the transmission or reception of data</a>.
     *
     * @param fildes an open file descriptor associated with a terminal.
     * @param action one of
     * {@link TCOOFF}, {@link TCOON}, {@link TCIOFF}, {@link TCION}.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void tcflow(int fildes, int action) throws NativeErrorException {
        if (tcflow.invoke_sI__sI_sI(fildes, action) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tcflush.html">tcflush
     * - flush non-transmitted output data, non-read input data, or both</a>.
     *
     * @param fildes an open file descriptor associated with a terminal.
     * @param queue_selector one of
     * {@link TCIFLUSH}, {@link TCOFLUSH}, {@link TCIOFLUSH}.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void tcflush(int fildes, int queue_selector) throws NativeErrorException {
        if (tcflush.invoke_sI__sI_sI(fildes, queue_selector) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tcgetattr.html">tcgetattr
     * - get the parameters associated with the terminal</a>.
     *
     * @param fildes an open file descriptor associated with a terminal.
     * @param termios a termios structure to be filled.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void tcgetattr(int fildes, StructTermios termios) throws NativeErrorException {
        if (tcgetattr.invoke_sI__sI__P(fildes, termios) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tcgetsid.html">tcgetsid
     * - get the process group ID for the session leader for the controlling
     * terminal</a>.
     *
     * @param fildes an open file descriptor associated with a terminal.
     * @return Upon successful completion, tcgetsid() shall return the process
     * group ID of the session associated with the terminal.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    @pid_t
    public final static int tcgetsid(int fildes) throws NativeErrorException {
        final int result = tcgetsid.invoke_sI__sI(fildes);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tcsendbreak.html">tcsendbreak
     * - send a break for a specific duration</a>.
     *
     * @param fildes an open file descriptor associated with a terminal.
     * @param duration the duration for which the terminal transmits a
     * continuous stream of zero-valued bits. If duration is 0, it shall cause
     * transmission of zero-valued bits for at least 0.25 seconds, and not more
     * than 0.5 seconds. If duration is not 0, it shall send zero-valued bits
     * for an implementation-defined period of time.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void tcsendbreak(int fildes, int duration) throws NativeErrorException {
        if (tcsendbreak.invoke_sI__sI_sI(fildes, duration) != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tcsetattr.html">tcsetattr
     * - set the parameters associated with the terminal</a>.
     *
     * @param fildes an open file descriptor associated with a terminal.
     * @param optional_actions one of
     * {@link TCSANOW}, {@link TCSADRAIN}, {@link TCSAFLUSH}.
     * @param termios the termios structure assosiated whith {@code  fildes}.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void tcsetattr(int fildes, int optional_actions, StructTermios termios) throws NativeErrorException {
        tcsetattr.invoke_sI__sI_sI__P(fildes, optional_actions, termios);
    }

}
