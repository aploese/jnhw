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
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.annotation.posix.termios.speed_t;
import de.ibapl.jnhw.annotation.posix.termios.tcflag_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.exception.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annotation.posix.termios.cc_t;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.io.IOException;
import de.ibapl.jnhw.common.memory.Uint8_t;
import de.ibapl.jnhw.common.memory.Uint32_t;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.libloader.MultiarchInfo;

/**
 * Wrapper around the {@code <termios.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">termios.h
 * - define values for termios</a>.
 *
 * @author aploese
 */
@Include("#include <termios.h>")
public final class Termios {

    public static interface Linux_AllArchs_Defines {

        public final static int VINTR = 0;
        public final static int VQUIT = 1;
        public final static int VERASE = 2;
        public final static int VKILL = 3;

        public final static int IGNBRK = 0000001;
        public final static int BRKINT = 0000002;
        public final static int IGNPAR = 0000004;
        public final static int PARMRK = 0000010;
        public final static int INPCK = 0000020;
        public final static int ISTRIP = 0000040;
        public final static int INLCR = 0000100;
        public final static int IGNCR = 0000200;
        public final static int ICRNL = 0000400;
        public final static int IXANY = 0004000;
        public final static int OPOST = 0000001;
        public final static int OCRNL = 0000010;
        public final static int ONOCR = 0000020;
        public final static int ONLRET = 0000040;
        public final static int OFILL = 0000100;
        public final static int OFDEL = 0000200;
        public final static int NL0 = 0000000;
        public final static int NL1 = 0000400;
        public final static int CR0 = 0000000;
        public final static int TAB0 = 0000000;
        public final static int BS0 = 0000000;
        public final static int VT0 = 0000000;
        public final static int FF0 = 0000000;

        /* c_cflag bit meaning */
        //#define CBAUD   0010017
        public final static int B0 = 0000000;
        public final static int B50 = 0000001;
        public final static int B75 = 0000002;
        public final static int B110 = 0000003;
        public final static int B134 = 0000004;
        public final static int B150 = 0000005;
        public final static int B200 = 0000006;
        public final static int B300 = 0000007;
        public final static int B600 = 0000010;
        public final static int B1200 = 0000011;
        public final static int B1800 = 0000012;
        public final static int B2400 = 0000013;
        public final static int B4800 = 0000014;
        public final static int B9600 = 0000015;
        public final static int B19200 = 0000016;
        public final static int B38400 = 0000017;
        public final static int CS5 = 0000000;
        public final static int CRTSCTS = 020000000000;
        public final static int ECHO = 0000010;
        public final static int TCOOFF = 0;
        public final static int TCOON = 1;
        public final static int TCIOFF = 2;
        public final static int TCION = 3;

        public final static int TCIFLUSH = 0;
        public final static int TCOFLUSH = 1;
        public final static int TCIOFLUSH = 2;

        public final static int NCCS = 32;

    }

    public static interface Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines {

        public final static int B1000000 = 0010010;
        public final static int B115200 = 0010002;
        public final static int B1152000 = 0010011;
        public final static int B57600 = 0010001;
        public final static int B230400 = 0010003;
        public final static int B460800 = 0010004;
        public final static int B500000 = 0010005;
        public final static int B576000 = 0010006;

        public final static int B921600 = 0010007;
        public final static int B1500000 = 0010012;
        public final static int B2000000 = 0010013;
        public final static int B2500000 = 0010014;
        public final static int B3000000 = 0010015;
        public final static int B3500000 = 0010016;
        public final static int B4000000 = 0010017;
        public final static int CLOCAL = 0004000;
        public final static int CSIZE = 0000060;
        public final static int CREAD = 0000200;
        public final static int CSTOPB = 0000100;
        public final static int ECHOE = 0000020;
        public final static int ECHOK = 0000040;
        public final static int ECHONL = 0000100;
        public final static int FFDLY = 0100000;
        public final static int FF1 = 0100000;
        public final static int PARENB = 0000400;
        public final static int PARODD = 0001000;
        public final static int HUPCL = 0002000;
        public final static int TABDLY = 0014000;
        public final static int TAB1 = 0004000;
        public final static int TAB2 = 0010000;
        public final static int TAB3 = 0014000;
        public final static int BSDLY = 0020000;
        public final static int BS1 = 0020000;
        public final static int CRDLY = 0003000;
        public final static int CR1 = 0001000;
        public final static int CR2 = 0002000;
        public final static int CR3 = 0003000;
        public final static int CS6 = 0000020;
        public final static int CS7 = 0000040;
        public final static int CS8 = 0000060;
        public final static int ICANON = 0000002;
        public final static int ISIG = 0000001;
        public final static int IXOFF = 0010000;
        public final static int IXON = 0002000;
        public final static int NLDLY = 0000400;
        public final static int NOFLSH = 0000200;
        public final static int ONLCR = 0000004;
        public final static int VSTART = 8;
        public final static int VSTOP = 9;
        public final static int VSUSP = 10;
        public final static int VTDLY = 0040000;
        public final static int VT1 = 0040000;
        public final static int VTIME = 5;

    }

    public static interface Linux_Ppc64_S390_Defines {

        public final static int B1000000 = 23;
        public final static int B115200 = 17;
        public final static int B1152000 = 24;
        public final static int B57600 = 16;
        public final static int B230400 = 18;
        public final static int B460800 = 19;
        public final static int B500000 = 20;
        public final static int B576000 = 21;
        public final static int B921600 = 22;
        public final static int B1500000 = 25;
        public final static int B2000000 = 26;
        public final static int B2500000 = 27;
        public final static int B3000000 = 28;
        public final static int B3500000 = 29;
        public final static int B4000000 = 30;
        public final static int CLOCAL = 32768;
        public final static int CSIZE = 768;
        public final static int CREAD = 2048;
        public final static int CSTOPB = 1024;
        public final static int ECHOE = 2;
        public final static int ECHOK = 4;
        public final static int ECHONL = 16;
        public final static int FFDLY = 16384;
        public final static int FF1 = 16384;
        public final static int PARENB = 4096;
        public final static int PARODD = 8192;
        public final static int HUPCL = 16384;
        public final static int TABDLY = 3072;
        public final static int TAB1 = 1024;
        public final static int TAB2 = 2048;
        public final static int TAB3 = 3072;
        public final static int BSDLY = 32768;
        public final static int BS1 = 32768;
        public final static int CRDLY = 12288;
        public final static int CR1 = 4096;
        public final static int CR2 = 8192;
        public final static int CR3 = 12288;
        public final static int CS6 = 256;
        public final static int CS7 = 512;
        public final static int CS8 = 768;
        public final static int ICANON = 256;
        public final static int IEXTEN = 1024;
        public final static int ISIG = 128;
        public final static int IXOFF = 1024;
        public final static int IXON = 512;
        public final static int NLDLY = 768;
        public final static int NOFLSH = -2147483648;
        public final static int ONLCR = 2;
        public final static int TOSTOP = 4194304;
        public final static int VMIN = 5;
        public final static int VEOL = 6;
        public final static int VSTART = 13;
        public final static int VSTOP = 14;
        public final static int VSUSP = 12;
        public final static int VTDLY = 65536;
        public final static int VT1 = 65536;
        public final static int VTIME = 7;

    }

    public static interface Linux_Aarch64_Arm_I386_RiscV64_X86_64Defines {

        public final static int IEXTEN = 0100000;
        public final static int TOSTOP = 0000400;
        public final static int VMIN = 6;
        public final static int VEOL = 11;

    }

    public static interface Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64Defines {

        public final static int VEOF = 4;

        public final static int CMSPAR = 010000000000;

        public final static int TCSANOW = 0;
        public final static int TCSADRAIN = 1;
        public final static int TCSAFLUSH = 2;

        public final static int _HAVE_STRUCT_TERMIOS_C_ISPEED = 1;
        public final static int _HAVE_STRUCT_TERMIOS_C_OSPEED = 1;
    }

    public static interface Linux_Mips_Mips64_Defines {

        public final static int VEOF = 16;
        public final static int VMIN = 4;
        public final static int VEOL = 17;

        public final static int IEXTEN = 0000400;
        public final static int TCSANOW = 0x540E;
        public final static int TCSADRAIN = 0x540F;
        public final static int TCSAFLUSH = 0x5410;

        public final static int TOSTOP = 0100000;

    }

    public static interface BsdDefines {

        public final static int VINTR = 8;
        public final static int VQUIT = 9;
        public final static int VERASE = 3;
        public final static int VKILL = 5;

        public final static int IGNBRK = 0000001;
        public final static int BRKINT = 0000002;
        public final static int IGNPAR = 0000004;
        public final static int PARMRK = 0000010;
        public final static int INPCK = 0000020;
        public final static int ISTRIP = 0000040;
        public final static int INLCR = 0000100;
        public final static int IGNCR = 0000200;
        public final static int ICRNL = 0000400;
        public final static int IXANY = 0004000;
        public final static int OPOST = 0000001;
        public final static int OCRNL = 16;

        /* c_cflag bit meaning */
        //#define CBAUD   0010017
        public final static int B0 = 0;
        public final static int B50 = 50;
        public final static int B75 = 75;
        public final static int B110 = 110;
        public final static int B134 = 134;
        public final static int B150 = 150;
        public final static int B200 = 200;
        public final static int B300 = 300;
        public final static int B600 = 600;
        public final static int B1200 = 1200;
        public final static int B1800 = 1800;
        public final static int B2400 = 2400;
        public final static int B4800 = 4800;
        public final static int B9600 = 9600;
        public final static int B19200 = 19200;
        public final static int B38400 = 38400;
        public final static int CS5 = 0000000;
        public final static int ECHO = 0000010;
        public final static int TCOOFF = 1;
        public final static int TCOON = 2;
        public final static int TCIOFF = 3;
        public final static int TCION = 4;

        public final static int TCIFLUSH = 1;
        public final static int TCOFLUSH = 2;
        public final static int TCIOFLUSH = 3;

        public final static int NCCS = 20;

        public final static int B115200 = 115200;
        public final static int B57600 = 57600;
        public final static int B230400 = 230400;
        public final static int CLOCAL = 32768;
        public final static int CSIZE = 768;
        public final static int CREAD = 2048;
        public final static int CSTOPB = 1024;
        public final static int ECHOE = 2;
        public final static int ECHOK = 4;
        public final static int ECHONL = 16;
        public final static int PARENB = 4096;
        public final static int PARODD = 8192;
        public final static int HUPCL = 16384;
        public final static int CS6 = 256;
        public final static int CS7 = 512;
        public final static int CS8 = 768;
        public final static int ICANON = 256;
        public final static int ISIG = 128;
        public final static int IXOFF = 1024;
        public final static int IXON = 512;
        public final static int NOFLSH = -2147483648;
        public final static int ONLCR = 2;
        public final static int VSTART = 12;
        public final static int VSTOP = 13;
        public final static int VSUSP = 10;
        public final static int VTIME = 17;
        public final static int VEOF = 0;
        public final static int VMIN = 16;
        public final static int VEOL = 1;

        public final static int IEXTEN = 1024;
        public final static int TCSANOW = 0;
        public final static int TCSADRAIN = 1;
        public final static int TCSAFLUSH = 2;

        public final static int TOSTOP = 4194304;

    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int B460800 = 460800;
        public final static int B921600 = 921600;
        public final static int CRTSCTS = 196608;
        public final static int ONOCR = 32;
        public final static int ONLRET = 64;
        public final static int TAB0 = 0;
        public final static int TAB3 = 4;
        public final static int TABDLY = 4;
    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int CRTSCTS = 65536;
        public final static int ONOCR = 64;
        public final static int ONLRET = 128;

    }

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
        final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
        switch (multiarchInfo.getOS()) {
            case LINUX:

                B0 = Linux_AllArchs_Defines.B0;

                B110 = Linux_AllArchs_Defines.B110;
                B1200 = Linux_AllArchs_Defines.B1200;
                B134 = Linux_AllArchs_Defines.B134;
                B150 = Linux_AllArchs_Defines.B150;
                B1800 = Linux_AllArchs_Defines.B1800;
                B19200 = Linux_AllArchs_Defines.B19200;
                B200 = Linux_AllArchs_Defines.B200;
                B2400 = Linux_AllArchs_Defines.B2400;
                B300 = Linux_AllArchs_Defines.B300;
                B38400 = Linux_AllArchs_Defines.B38400;
                B4800 = Linux_AllArchs_Defines.B4800;
                B50 = Linux_AllArchs_Defines.B50;
                B600 = Linux_AllArchs_Defines.B600;

                B75 = Linux_AllArchs_Defines.B75;
                B9600 = Linux_AllArchs_Defines.B9600;

                BRKINT = Linux_AllArchs_Defines.BRKINT;
                BS0 = IntDefine.toIntDefine(Linux_AllArchs_Defines.BS0);
                CR0 = IntDefine.toIntDefine(Linux_AllArchs_Defines.CR0);

                switch (multiarchInfo.getArch()) {
                    case AARCH64:
                    case ARM:
                    case I386:
                    case MIPS:
                    case MIPS_64:
                    case RISC_V_64:
                    case X86_64:
                        B1000000 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B1000000);
                        B115200 = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B115200;
                        B1152000 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B1152000);
                        B1500000 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B1500000);
                        B2000000 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B2000000);
                        B230400 = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B230400;
                        B2500000 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B2500000);
                        B3000000 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B3000000);
                        B3500000 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B3500000);

                        B4000000 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B4000000);
                        B460800 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B460800);
                        B500000 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B500000);
                        B57600 = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B57600;
                        B576000 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B576000);
                        B921600 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.B921600);
                        BS1 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.BS1);
                        BSDLY = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.BSDLY);

                        CLOCAL = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CLOCAL;
                        CR1 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CR1);
                        CR2 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CR2);
                        CR3 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CR3);
                        CRDLY = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CRDLY);
                        CS6 = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CS6;
                        CS7 = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CS7;
                        CS8 = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CS8;
                        TAB1 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.TAB1);
                        TAB2 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.TAB2);
                        TAB3 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.TAB3);
                        TABDLY = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.TABDLY);
                        CREAD = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CREAD;
                        CSIZE = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CSIZE;
                        CSTOPB = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.CSTOPB;
                        ECHOE = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.ECHOE;
                        ECHOK = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.ECHOK;
                        ECHONL = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.ECHONL;
                        FF1 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.FF1);
                        FFDLY = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.FFDLY);

                        HUPCL = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.HUPCL;
                        PARENB = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.PARENB;
                        PARODD = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.PARODD;
                        ICANON = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.ICANON;
                        ISIG = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.ISIG;
                        IXOFF = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.IXOFF;
                        IXON = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.IXON;
                        NLDLY = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.NLDLY);
                        NOFLSH = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.NOFLSH;
                        ONLCR = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.ONLCR;
                        VSTART = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.VSTART;
                        VSTOP = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.VSTOP;
                        VSUSP = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.VSUSP;
                        VT1 = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.VT1);
                        VTDLY = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.VTDLY);
                        VTIME = Linux_Aarch64_Arm_I386_Mips_Mips64_RiscV64_X86_64_Defines.VTIME;

                        break;
                    case POWER_PC_64:
                    case S390_X:
                        B1000000 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B1000000);
                        B115200 = Linux_Ppc64_S390_Defines.B115200;
                        B1152000 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B1152000);
                        B1500000 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B1500000);
                        B2000000 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B2000000);
                        B230400 = Linux_Ppc64_S390_Defines.B230400;
                        B2500000 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B2500000);
                        B3000000 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B3000000);
                        B3500000 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B3500000);

                        B4000000 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B4000000);
                        B460800 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B460800);
                        B500000 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B500000);
                        B57600 = Linux_Ppc64_S390_Defines.B57600;
                        B576000 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B576000);
                        B921600 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.B921600);
                        BS1 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.BS1);
                        BSDLY = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.BSDLY);

                        CLOCAL = Linux_Ppc64_S390_Defines.CLOCAL;
                        CR1 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.CR1);
                        CR2 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.CR2);
                        CR3 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.CR3);
                        CRDLY = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.CRDLY);
                        CS6 = Linux_Ppc64_S390_Defines.CS6;
                        CS7 = Linux_Ppc64_S390_Defines.CS7;
                        CS8 = Linux_Ppc64_S390_Defines.CS8;
                        TAB1 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.TAB1);
                        TAB2 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.TAB2);
                        TAB3 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.TAB3);
                        TABDLY = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.TABDLY);
                        CREAD = Linux_Ppc64_S390_Defines.CREAD;
                        CSIZE = Linux_Ppc64_S390_Defines.CSIZE;
                        CSTOPB = Linux_Ppc64_S390_Defines.CSTOPB;
                        ECHOE = Linux_Ppc64_S390_Defines.ECHOE;
                        ECHOK = Linux_Ppc64_S390_Defines.ECHOK;
                        ECHONL = Linux_Ppc64_S390_Defines.ECHONL;
                        FF1 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.FF1);
                        FFDLY = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.FFDLY);

                        HUPCL = Linux_Ppc64_S390_Defines.HUPCL;
                        PARENB = Linux_Ppc64_S390_Defines.PARENB;
                        PARODD = Linux_Ppc64_S390_Defines.PARODD;

                        ICANON = Linux_Ppc64_S390_Defines.ICANON;
                        ISIG = Linux_Ppc64_S390_Defines.ISIG;
                        IXOFF = Linux_Ppc64_S390_Defines.IXOFF;
                        IXON = Linux_Ppc64_S390_Defines.IXON;
                        NLDLY = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.NLDLY);
                        NOFLSH = Linux_Ppc64_S390_Defines.NOFLSH;
                        ONLCR = Linux_Ppc64_S390_Defines.ONLCR;
                        VSTART = Linux_Ppc64_S390_Defines.VSTART;
                        VSTOP = Linux_Ppc64_S390_Defines.VSTOP;
                        VSUSP = Linux_Ppc64_S390_Defines.VSUSP;
                        VT1 = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.VT1);
                        VTDLY = IntDefine.toIntDefine(Linux_Ppc64_S390_Defines.VTDLY);
                        VTIME = Linux_Ppc64_S390_Defines.VTIME;

                        break;
                    default:
                        throw new NoClassDefFoundError("No termios.h linux defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                }
                CRTSCTS = Linux_AllArchs_Defines.CRTSCTS;
                CS5 = Linux_AllArchs_Defines.CS5;

                ECHO = Linux_AllArchs_Defines.ECHO;

                FF0 = IntDefine.toIntDefine(Linux_AllArchs_Defines.FF0);
                HAVE_TERMIOS_H = true;

                ICRNL = Linux_AllArchs_Defines.ICRNL;
                IGNBRK = Linux_AllArchs_Defines.IGNBRK;
                IGNCR = Linux_AllArchs_Defines.IGNCR;
                IGNPAR = Linux_AllArchs_Defines.IGNPAR;
                INLCR = Linux_AllArchs_Defines.INLCR;
                INPCK = Linux_AllArchs_Defines.INPCK;
                ISTRIP = Linux_AllArchs_Defines.ISTRIP;
                IXANY = Linux_AllArchs_Defines.IXANY;

                NCCS = Linux_AllArchs_Defines.NCCS;
                NL0 = IntDefine.toIntDefine(Linux_AllArchs_Defines.NL0);
                NL1 = IntDefine.toIntDefine(Linux_AllArchs_Defines.NL1);

                OCRNL = Linux_AllArchs_Defines.OCRNL;
                OFDEL = IntDefine.toIntDefine(Linux_AllArchs_Defines.OFDEL);
                OFILL = IntDefine.toIntDefine(Linux_AllArchs_Defines.OFILL);
                ONLRET = Linux_AllArchs_Defines.ONLRET;
                ONOCR = Linux_AllArchs_Defines.ONOCR;
                OPOST = Linux_AllArchs_Defines.OPOST;

                PAREXT = IntDefine.UNDEFINED;
                PARMRK = Linux_AllArchs_Defines.PARMRK;

                TAB0 = IntDefine.toIntDefine(Linux_AllArchs_Defines.TAB0);
                TCIFLUSH = Linux_AllArchs_Defines.TCIFLUSH;
                TCIOFF = Linux_AllArchs_Defines.TCIOFF;
                TCIOFLUSH = Linux_AllArchs_Defines.TCIOFLUSH;
                TCION = Linux_AllArchs_Defines.TCION;
                TCOFLUSH = Linux_AllArchs_Defines.TCOFLUSH;
                TCOOFF = Linux_AllArchs_Defines.TCOOFF;
                TCOON = Linux_AllArchs_Defines.TCOON;
                VERASE = Linux_AllArchs_Defines.VERASE;
                VINTR = Linux_AllArchs_Defines.VINTR;
                VKILL = Linux_AllArchs_Defines.VKILL;
                VQUIT = Linux_AllArchs_Defines.VQUIT;
                VT0 = IntDefine.toIntDefine(Linux_AllArchs_Defines.VT0);

                switch (multiarchInfo.getArch()) {
                    case MIPS:
                    case MIPS_64:
                        CMSPAR = IntDefine.UNDEFINED;
                        TCSADRAIN = Linux_Mips_Mips64_Defines.TCSADRAIN;
                        TCSAFLUSH = Linux_Mips_Mips64_Defines.TCSAFLUSH;
                        TCSANOW = Linux_Mips_Mips64_Defines.TCSANOW;

                        VEOF = Linux_Mips_Mips64_Defines.VEOF;

                        _HAVE_STRUCT_TERMIOS_C_ISPEED = IntDefine.UNDEFINED;
                        _HAVE_STRUCT_TERMIOS_C_OSPEED = IntDefine.UNDEFINED;
                        break;
                    case AARCH64:
                    case ARM:
                    case I386:
                    case X86_64:
                    case POWER_PC_64:
                    case RISC_V_64:
                    case S390_X:
                        CMSPAR = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64Defines.CMSPAR);
                        TCSADRAIN = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64Defines.TCSADRAIN;
                        TCSAFLUSH = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64Defines.TCSAFLUSH;
                        TCSANOW = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64Defines.TCSANOW;

                        VEOF = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64Defines.VEOF;

                        _HAVE_STRUCT_TERMIOS_C_ISPEED = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64Defines._HAVE_STRUCT_TERMIOS_C_ISPEED);
                        _HAVE_STRUCT_TERMIOS_C_OSPEED = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64Defines._HAVE_STRUCT_TERMIOS_C_OSPEED);

                        break;
                    default:
                        throw new NoClassDefFoundError("No termios.h linux defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                }
                switch (multiarchInfo.getArch()) {
                    case MIPS:
                    case MIPS_64:
                        TOSTOP = Linux_Mips_Mips64_Defines.TOSTOP;
                        VEOL = Linux_Mips_Mips64_Defines.VEOL;
                        IEXTEN = Linux_Mips_Mips64_Defines.IEXTEN;
                        VMIN = Linux_Mips_Mips64_Defines.VMIN;
                        break;
                    case AARCH64:
                    case ARM:
                    case I386:
                    case RISC_V_64:
                    case X86_64:
                        TOSTOP = Linux_Aarch64_Arm_I386_RiscV64_X86_64Defines.TOSTOP;
                        VEOL = Linux_Aarch64_Arm_I386_RiscV64_X86_64Defines.VEOL;
                        IEXTEN = Linux_Aarch64_Arm_I386_RiscV64_X86_64Defines.IEXTEN;
                        VMIN = Linux_Aarch64_Arm_I386_RiscV64_X86_64Defines.VMIN;
                        break;
                    case POWER_PC_64:
                    case S390_X:
                        TOSTOP = Linux_Ppc64_S390_Defines.TOSTOP;
                        VEOL = Linux_Ppc64_S390_Defines.VEOL;
                        IEXTEN = Linux_Ppc64_S390_Defines.IEXTEN;
                        VMIN = Linux_Ppc64_S390_Defines.VMIN;
                        break;
                    default:
                        throw new NoClassDefFoundError("No termios.h linux defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                }

                break;
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
                BS0 = IntDefine.UNDEFINED;
                CR0 = IntDefine.UNDEFINED;

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
                BS1 = IntDefine.UNDEFINED;
                BSDLY = IntDefine.UNDEFINED;

                CLOCAL = BsdDefines.CLOCAL;
                CR1 = IntDefine.UNDEFINED;
                CR2 = IntDefine.UNDEFINED;
                CR3 = IntDefine.UNDEFINED;
                CRDLY = IntDefine.UNDEFINED;
                CS6 = BsdDefines.CS6;
                CS7 = BsdDefines.CS7;
                CS8 = BsdDefines.CS8;
                TAB1 = IntDefine.UNDEFINED;
                TAB2 = IntDefine.UNDEFINED;
                CREAD = BsdDefines.CREAD;
                CSIZE = BsdDefines.CSIZE;
                CSTOPB = BsdDefines.CSTOPB;
                ECHOE = BsdDefines.ECHOE;
                ECHOK = BsdDefines.ECHOK;
                ECHONL = BsdDefines.ECHONL;
                FF1 = IntDefine.UNDEFINED;
                FFDLY = IntDefine.UNDEFINED;
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
                NLDLY = IntDefine.UNDEFINED;
                NOFLSH = BsdDefines.NOFLSH;
                ONLCR = BsdDefines.ONLCR;
                VSTART = BsdDefines.VSTART;
                VSTOP = BsdDefines.VSTOP;
                VSUSP = BsdDefines.VSUSP;
                VT1 = IntDefine.UNDEFINED;
                VTDLY = IntDefine.UNDEFINED;
                VTIME = BsdDefines.VTIME;
                CS5 = BsdDefines.CS5;

                ECHO = BsdDefines.ECHO;

                FF0 = IntDefine.UNDEFINED;

                ICRNL = BsdDefines.ICRNL;
                IGNBRK = BsdDefines.IGNBRK;
                IGNCR = BsdDefines.IGNCR;
                IGNPAR = BsdDefines.IGNPAR;
                INLCR = BsdDefines.INLCR;
                INPCK = BsdDefines.INPCK;
                ISTRIP = BsdDefines.ISTRIP;
                IXANY = BsdDefines.IXANY;

                NCCS = BsdDefines.NCCS;
                NL0 = IntDefine.UNDEFINED;
                NL1 = IntDefine.UNDEFINED;

                OCRNL = BsdDefines.OCRNL;
                OFDEL = IntDefine.UNDEFINED;
                OFILL = IntDefine.UNDEFINED;
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
                VT0 = IntDefine.UNDEFINED;

                CMSPAR = IntDefine.UNDEFINED;
                TCSADRAIN = BsdDefines.TCSADRAIN;
                TCSAFLUSH = BsdDefines.TCSAFLUSH;
                TCSANOW = BsdDefines.TCSANOW;

                VEOF = BsdDefines.VEOF;

                _HAVE_STRUCT_TERMIOS_C_ISPEED = IntDefine.UNDEFINED;
                _HAVE_STRUCT_TERMIOS_C_OSPEED = IntDefine.UNDEFINED;
                switch (multiarchInfo.getOS()) {
                    case FREE_BSD:
                        B460800 = IntDefine.toIntDefine(FreeBsdDefines.B460800);
                        B921600 = IntDefine.toIntDefine(FreeBsdDefines.B921600);
                        CRTSCTS = FreeBsdDefines.CRTSCTS;
                        TAB0 = IntDefine.toIntDefine(FreeBsdDefines.TAB0);
                        TAB3 = IntDefine.toIntDefine(FreeBsdDefines.TAB3);
                        TABDLY = IntDefine.toIntDefine(FreeBsdDefines.TABDLY);
                        ONLRET = FreeBsdDefines.ONLRET;
                        ONOCR = FreeBsdDefines.ONOCR;
                        break;
                    case OPEN_BSD:
                        B460800 = IntDefine.UNDEFINED;
                        B921600 = IntDefine.UNDEFINED;
                        CRTSCTS = OpenBsdDefines.CRTSCTS;
                        TAB0 = IntDefine.UNDEFINED;
                        TAB3 = IntDefine.UNDEFINED;
                        TABDLY = IntDefine.UNDEFINED;
                        ONLRET = OpenBsdDefines.ONLRET;
                        ONOCR = OpenBsdDefines.ONOCR;
                        break;
                    default:
                        throw new NoClassDefFoundError("No termios.h BSD defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                }
                break;
            default:
                throw new NoClassDefFoundError("No termios.h OS defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
        }

    }

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
    public final static int cfgetispeed(StructTermios termios) {
        return cfgetispeed(AbstractNativeMemory.getAddress(termios));
    }

    private static native int cfgetispeed(long ptrTermios);

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
    public final static int cfgetospeed(StructTermios termios) {
        return cfgetospeed(AbstractNativeMemory.getAddress(termios));
    }

    private static native int cfgetospeed(long ptrTermios);

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
    public final static void cfsetispeed(StructTermios termios, @speed_t int speed) throws NativeErrorException {
        cfsetispeed(AbstractNativeMemory.getAddress(termios), speed);
    }

    private static native void cfsetispeed(long ptrTermios, int speed) throws NativeErrorException;

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
    public final static void cfsetospeed(StructTermios termios, @speed_t int speed) throws NativeErrorException {
        cfsetospeed(AbstractNativeMemory.getAddress(termios), speed);
    }

    private static native void cfsetospeed(long ptrTermios, int speed) throws NativeErrorException;

    /**
     * <b>Non POSIX:</b> set input and output spped at the same time.
     *
     * @param termios the termios structure in which the input and output speed
     * is to be set.
     * @param speed the speed to be set in the {@code  termios} structure.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void cfsetspeed(StructTermios termios, @speed_t int speed) throws NativeErrorException {
        cfsetspeed(AbstractNativeMemory.getAddress(termios), speed);
    }

    private static native void cfsetspeed(long ptrTermios, int speed) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/tcdrain.html">tcdrain
     * - wait for transmission of output</a>.
     *
     * @param fildes an open file descriptor associated with a terminal.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void tcdrain(int fildes) throws NativeErrorException;

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
    public final static native void tcflow(int fildes, int action) throws NativeErrorException;

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
    public final static native void tcflush(int fildes, int queue_selector) throws NativeErrorException;

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
        tcgetattr(fildes, AbstractNativeMemory.getAddress(termios));
    }

    private static native void tcgetattr(int fildes, long ptrTermios) throws NativeErrorException;

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
    public final static native int tcgetsid(int fildes) throws NativeErrorException;

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
    public final static native void tcsendbreak(int fildes, int duration) throws NativeErrorException;

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
        tcsetattr(fildes, optional_actions, AbstractNativeMemory.getAddress(termios));
    }

    private static native void tcsetattr(int fildes, int optional_actions, long ptrTermios) throws NativeErrorException;

    @cc_t
    public static class Cc_t extends Uint8_t {

        public Cc_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(owner, offset, setMem);
        }

        /**
         * This is a control character, maybe not printable
         *
         * @return
         */
        @Override
        public String nativeToString() {
            return String.valueOf((char) uint8_t());
        }

    }

    /**
     * speed_t takes only symbolic constants, so the sign is of no relevance...
     */
    @speed_t
    public static class Speed_t extends Uint32_t {

        static String speed_tToString(int speed_t) {
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

        public Speed_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(owner, offset, setMem);
        }

        @Override
        public String nativeToString() {
            return speed_tToString(uint32_t());
        }

    }

    @tcflag_t
    public static class Tcflag_t extends Uint32_t {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        static public void c_cflag2String(Appendable sb, int c_cflag) throws IOException {
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
                sb.append(String.format("0x%08x", c_cflag));
            }
        }

        static public void c_iflag2String(Appendable sb, int c_iflag) throws IOException {
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
                sb.append(String.format("0x%08x", c_iflag));
            }
        }

        static public void c_lflag2String(Appendable sb, int c_lflag) throws IOException {
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
                sb.append(String.format("0x%08x", c_lflag));
            }
        }

        static public void c_oflag2String(Appendable sb, int c_oflag) throws IOException {
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
                sb.append(String.format("0x%08x", c_oflag));
            }
        }

        public Tcflag_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(owner, offset, setMem);
        }

        /**
         * the native value as hex string.
         *
         * @return
         */
        @Override
        public String nativeToString() {
            return nativeToHexString();
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
     * termios}</a>.
     *
     * @author aploese
     */
    public final static class StructTermios extends Struct32 {

        public final static long offsetof_C_iflag;
        public final static long offsetof_C_oflag;
        public final static long offsetof_C_cflag;
        public final static long offsetof_C_lflag;
        public final static long offsetof_C_cc;
        public final static long offsetof_C_line;
        public final static long offsetof_C_ispeed;
        public final static long offsetof_C_ospeed;
        public final static Alignment alignof;
        public final static int sizeof;

        /**
         * Make sure the native lib is loaded
         */
        static {
            LibJnhwPosixLoader.touch();
            final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
            switch (multiarchInfo.getOS()) {
                case LINUX:
                    alignof = Alignment.AT_4;
                    offsetof_C_iflag = 0;
                    offsetof_C_oflag = 4;
                    offsetof_C_cflag = 8;
                    offsetof_C_lflag = 12;
                    offsetof_C_cc = 17;
                    offsetof_C_line = 16;
                    switch (multiarchInfo.getArch()) {
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
                    throw new NoClassDefFoundError("No termios.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
            }
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return the native value of c_iflag.
         */
        @tcflag_t
        public int c_iflag() {
            return MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_iflag);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_iflag to be set natively.
         */
        public void c_iflag(@tcflag_t int value) {
            MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_iflag, value);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_oflag.
         */
        @tcflag_t
        public int c_oflag() {
            return MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_oflag);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_oflag to be set natively.
         */
        public void c_oflag(@tcflag_t int value) {
            MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_oflag, value);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_cflag.
         */
        @tcflag_t
        public int c_cflag() {
            return MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_cflag);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_cflag to be set natively.
         */
        public void c_cflag(@tcflag_t int value) {
            MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_cflag, value);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_lflag.
         */
        @tcflag_t
        public int c_lflag() {
            return MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_lflag);
        }

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_lflag to be set natively.
         */
        public void c_lflag(@tcflag_t int value) {
            MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_lflag, value);
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
            return MEM_ACCESS.uint8_t(this, StructTermios.offsetof_C_cc + index);
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
            MEM_ACCESS.uint8_t(this, StructTermios.offsetof_C_cc + index, value);
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
            return MEM_ACCESS.uint8_t(this, StructTermios.offsetof_C_line);
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
            MEM_ACCESS.uint8_t(this, StructTermios.offsetof_C_line, value);
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
            return MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_ispeed);
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
            MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_ispeed, value);
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
            return MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_ospeed);
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
            MEM_ACCESS.uint32_t(this, StructTermios.offsetof_C_ospeed, value);
        }

        public StructTermios() {
            // get unitialized mem
            this(null, 0, SetMem.DO_NOT_SET);
        }

        public StructTermios(AbstractNativeMemory parent, long offset, SetMem setMem) {
            super(parent, offset, StructTermios.sizeof, setMem);
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

        static public void c_cc2String(Appendable sb, int index, byte c_cc) throws IOException {
            sb.append(String.format(", c_cc[%s] = 0x%02x", toCcName(index), c_cc));
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendMember("c_iflag", "[", (sbu) -> Tcflag_t.c_iflag2String(sbu, c_iflag()), "]");
            jsb.appendMember("c_oflag", "[", (sbu) -> Tcflag_t.c_oflag2String(sb, c_oflag()), "]");
            jsb.appendMember("c_cflag", "[", (sbu) -> Tcflag_t.c_cflag2String(sb, c_cflag()), "]");
            jsb.appendMember("c_lflag", "[", (sbu) -> Tcflag_t.c_lflag2String(sb, c_lflag()), "]");
            try {
                jsb.appendHexByteMember("c_line", c_line());
            } catch (NoSuchNativeTypeMemberException nstme) {
            }
            try {
                jsb.appendHexIntMember("c_ispeed", c_ispeed());
            } catch (NoSuchNativeTypeMemberException nstme) {
            }
            try {
                jsb.appendHexIntMember("c_ospeed", c_ospeed());
            } catch (NoSuchNativeTypeMemberException nstme) {
            }
            for (int i = 0; i < NCCS; i++) {
                c_cc2String(sb, i, c_cc(i));
            }
            jsb.close();
        }
    }

}
