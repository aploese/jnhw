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
package de.ibapl.jnhw.unix.sys;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.util.IntDefine;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.NativeLibResolver;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

/**
 * Wrapper around the {@code  <sys/ioctl.h>} header. execute
 * {@code  man ioctl_tty} on linux to get more informations.
 *
 * @author aploese
 */
@Include("#include <sys/ioctl.h>")
public final class Ioctl {

    public static interface BsdDefines {

        public final static int FIONREAD = 1074030207;
        public final static int IOC_DIRMASK = -536870912;
        public final static int IOC_IN = -2147483648;
        public final static int IOC_INOUT = -1073741824;
        public final static int IOC_OUT = 1073741824;
        public final static int IOC_VOID = 536870912;
        public final static int IOCPARM_MASK = 8191;
        public final static int IOCSIZE_SHIFT = 16;
        public final static int TIOCCBRK = 536900730;
        public final static int TIOCEXCL = 536900621;
        public final static int TIOCM_CAR = 64;
        public final static int TIOCM_CD = 64;
        public final static int TIOCM_CTS = 32;
        public final static int TIOCM_DSR = 256;
        public final static int TIOCM_DTR = 2;
        public final static int TIOCM_LE = 1;
        public final static int TIOCM_RI = 128;
        public final static int TIOCM_RNG = 128;
        public final static int TIOCM_RTS = 4;
        public final static int TIOCM_SR = 16;
        public final static int TIOCM_ST = 8;
        public final static int TIOCMBIC = -2147191701;
        public final static int TIOCMBIS = -2147191700;
        public final static int TIOCMGET = 1074033770;
        public final static int TIOCMSET = -2147191699;
        public final static int TIOCOUTQ = 1074033779;
        public final static int TIOCSBRK = 536900731;
    }

    public static interface FreeBsdDefines extends BsdDefines {

        public final static int IOCPARM_MAX = 8192;
    }

    public static interface Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines {

        public final static int TIOCEXCL = 21516;
        public final static int TIOCGICOUNT = 21597;
        public final static int TIOCGSOFTCAR = 21529;
        public final static int TIOCM_CAR = 64;
        public final static int TIOCM_CD = 64;
        public final static int TIOCM_CTS = 32;
        public final static int TIOCM_DSR = 256;
        public final static int TIOCM_RI = 128;
        public final static int TIOCM_RNG = 128;
        public final static int TIOCM_SR = 16;
        public final static int TIOCM_ST = 8;
        public final static int TIOCMBIC = 21527;
        public final static int TIOCMBIS = 21526;
        public final static int TIOCMGET = 21525;
        public final static int TIOCMIWAIT = 21596;
        public final static int TIOCMSET = 21528;
        public final static int TIOCSSOFTCAR = 21530;
    }

    public static interface Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines {

        public final static int _IOC_DIRBITS = 2;
        public final static int _IOC_DIRMASK = 3;
        public final static int _IOC_DIRSHIFT = 30;
        public final static int _IOC_NONE = 0;
        public final static int _IOC_SIZEBITS = 14;
        public final static int _IOC_SIZEMASK = 16383;
        public final static int _IOC_WRITE = 1;
        public final static int FIONREAD = 21531;
        public final static int IOC_IN = 1073741824;
        public final static int IOC_OUT = -2147483648;
        public final static int IOCSIZE_MASK = 1073676288;
        public final static int TIOCOUTQ = 21521;
    }

    public static interface Linux_AllArchs_Defines {

        public final static int _IOC_NRBITS = 8;
        public final static int _IOC_NRMASK = 255;
        public final static int _IOC_NRSHIFT = 0;
        public final static int _IOC_READ = 2;
        public final static int _IOC_SIZESHIFT = 16;
        public final static int _IOC_TYPEBITS = 8;
        public final static int _IOC_TYPEMASK = 255;
        public final static int _IOC_TYPESHIFT = 8;
        public final static int IOC_INOUT = -1073741824;
        public final static int IOCSIZE_SHIFT = 16;
        public final static int TIOCCBRK = 21544;
        public final static int TIOCM_DTR = 2;
        public final static int TIOCM_LE = 1;
        public final static int TIOCM_RTS = 4;
        public final static int TIOCSBRK = 21543;
    }

    public static interface Linux_Mips_Mips64_Defines {

        public final static int _IOC_DIRBITS = 3;
        public final static int _IOC_DIRMASK = 7;
        public final static int _IOC_DIRSHIFT = 29;
        public final static int _IOC_NONE = 1;
        public final static int _IOC_SIZEBITS = 13;
        public final static int _IOC_SIZEMASK = 8191;
        public final static int _IOC_WRITE = 4;
        public final static int FIONREAD = 18047;
        public final static int IOC_IN = -2147483648;
        public final static int IOC_OUT = 1073741824;
        public final static int IOCSIZE_MASK = 536805376;
        public final static int TIOCEXCL = 29709;
        public final static int TIOCGICOUNT = 21650;
        public final static int TIOCGSOFTCAR = 21633;
        public final static int TIOCM_CAR = 256;
        public final static int TIOCM_CD = 256;
        public final static int TIOCM_CTS = 64;
        public final static int TIOCM_DSR = 1024;
        public final static int TIOCM_RI = 512;
        public final static int TIOCM_RNG = 512;
        public final static int TIOCM_SR = 32;
        public final static int TIOCM_ST = 16;
        public final static int TIOCMBIC = 29724;
        public final static int TIOCMBIS = 29723;
        public final static int TIOCMGET = 29725;
        public final static int TIOCMIWAIT = 21649;
        public final static int TIOCMSET = 29722;
        public final static int TIOCOUTQ = 29810;
        public final static int TIOCSSOFTCAR = 21634;
    }

    public static interface Linux_Ppc64_Defines {

        public final static int _IOC_DIRBITS = 3;
        public final static int _IOC_DIRMASK = 7;
        public final static int _IOC_DIRSHIFT = 29;
        public final static int _IOC_NONE = 1;
        public final static int _IOC_SIZEBITS = 13;
        public final static int _IOC_SIZEMASK = 8191;
        public final static int _IOC_WRITE = 4;
        public final static int FIONREAD = 1074030207;
        public final static int IOC_IN = -2147483648;
        public final static int IOC_OUT = 1073741824;
        public final static int IOCSIZE_MASK = 536805376;
        public final static int TIOCOUTQ = 1074033779;
    }

    public static interface OpenBsdDefines extends BsdDefines {

        public final static int IOCPARM_MAX = 4096;
    }

    @Define
    public final static IntDefine _IOC_DIRBITS;

    @Define
    public final static IntDefine _IOC_DIRMASK;

    @Define
    public final static IntDefine _IOC_DIRSHIFT;

    @Define
    public final static IntDefine _IOC_NONE;

    @Define
    public final static IntDefine _IOC_NRBITS;

    @Define
    public final static IntDefine _IOC_NRMASK;

    @Define
    public final static IntDefine _IOC_NRSHIFT;

    @Define
    public final static IntDefine _IOC_READ;

    @Define
    public final static IntDefine _IOC_SIZEBITS;

    @Define
    public final static IntDefine _IOC_SIZEMASK;

    @Define
    public final static IntDefine _IOC_SIZESHIFT;

    @Define
    public final static IntDefine _IOC_TYPEBITS;

    @Define
    public final static IntDefine _IOC_TYPEMASK;

    @Define
    public final static IntDefine _IOC_TYPESHIFT;

    @Define
    public final static IntDefine _IOC_WRITE;

    /**
     * <b>Non POSIX:</b> Get the number of bytes in the input buffer..
     *
     */
    @Define
    public final static int FIONREAD;

    public final static boolean HAVE_SYS_IOCTL_H;

    @Define
    public final static IntDefine IOC_DIRMASK;

    @Define
    public final static int IOC_IN;

    @Define
    public final static int IOC_INOUT;

    @Define
    public final static int IOC_OUT;

    @Define
    public final static IntDefine IOC_VOID;

    @Define
    public final static IntDefine IOCPARM_MASK;

    @Define
    public final static IntDefine IOCPARM_MAX;

    /* ...and for the drivers/sound files... */
    @Define
    public final static IntDefine IOCSIZE_MASK;

    @Define
    public final static IntDefine IOCSIZE_SHIFT;
    /**
     * <b>Non POSIX:</b> Turn break off, that is, stop sending zero bits.
     *
     */
    @Define
    public final static int TIOCCBRK;
    /**
     * <b>Non POSIX:</b> Put the terminal into exclusive mode..
     *
     */
    @Define
    public final static int TIOCEXCL;
    /**
     * <b>Linux:</b> Get counts of input serial line interrupts (DCD, RI, DSR,
     * CTS).
     *
     */
    @Define
    public final static IntDefine TIOCGICOUNT;
    /**
     * <b>Linux:</b> ("Get software carrier flag") Get the status of the CLOCAL
     * flag in the c_cflag field of the termios structure.
     *
     */
    @Define
    public final static IntDefine TIOCGSOFTCAR;
    /**
     * <b>Non POSIX:</b>DCD (data carrier detect) .
     *
     */
    @Define
    public final static int TIOCM_CAR;
    /**
     * <b>Non POSIX:</b> {@link TIOCM_CAR}.
     *
     */
    @Define
    public final static int TIOCM_CD;

    /**
     * <b>Non POSIX:</b> CTS (clear to send).
     *
     */
    @Define
    public final static int TIOCM_CTS;
    /**
     * <b>Non POSIX:</b> DSR (data set ready).
     *
     */
    @Define
    public final static int TIOCM_DSR;
    /**
     * <b>Non POSIX:</b> DTR (data terminal ready).
     *
     */
    @Define
    public final static int TIOCM_DTR;
    /**
     * <b>Non POSIX:</b> DSR (data set ready/line enable).
     *
     */
    @Define
    public final static int TIOCM_LE;
    /**
     * <b>Non POSIX:</b> {@link TIOCM_RNG}.
     *
     */
    @Define
    public final static int TIOCM_RI;
    /**
     * <b>Non POSIX:</b> RNG (ring).
     *
     */
    @Define
    public final static int TIOCM_RNG;
    /**
     * <b>Non POSIX:</b> RTS (request to send).
     *
     */
    @Define
    public final static int TIOCM_RTS;
    /**
     * <b>Non POSIX:</b> Secondary RXD (receive).
     *
     */
    @Define
    public final static int TIOCM_SR;
    /**
     * <b>Non POSIX:</b> Secondary TXD (transmit).
     *
     */
    @Define
    public final static int TIOCM_ST;
    /**
     * <b>Non POSIX:</b> Clear the indicated modem bits.
     *
     */
    @Define
    public final static int TIOCMBIC;
    /**
     * <b>Non POSIX:</b> Set the indicated modem bits.
     *
     */
    @Define
    public final static int TIOCMBIS;
    /**
     * <b>Non POSIX:</b> Get the status of modem bits.
     *
     */
    @Define
    public final static int TIOCMGET;

    /**
     * <b>Linux:</b> Wait for any of the 4 modem bits (DCD, RI, DSR, CTS) to
     * change.
     *
     */
    @Define
    public final static IntDefine TIOCMIWAIT;

    /**
     * <b>Non POSIX:</b> Set the status of modem bits.
     *
     */
    @Define
    public final static int TIOCMSET;

    /**
     * <b>Non POSIX:</b> Get the number of bytes in the output buffer.
     *
     */
    @Define
    public final static int TIOCOUTQ;

    /**
     * <b>Non POSIX:</b> Turn break on, that is, start sending zero bits.
     *
     */
    @Define
    public final static int TIOCSBRK;

    /**
     * <b>Linux:</b> ("Set software carrier flag") Set the CLOCAL flag in the
     * termios structure when *argp is nonzero, and clear it otherwise.
     *
     */
    @Define
    public final static IntDefine TIOCSSOFTCAR;

    /**
     * Make sure the native lib is loaded
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwPosixLoader.touch();

        final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
        switch (multiarchInfo.getOS()) {
            case LINUX:
                HAVE_SYS_IOCTL_H = true;

                TIOCCBRK = Linux_AllArchs_Defines.TIOCCBRK;
                TIOCM_DTR = Linux_AllArchs_Defines.TIOCM_DTR;
                TIOCM_LE = Linux_AllArchs_Defines.TIOCM_LE;
                TIOCM_RTS = Linux_AllArchs_Defines.TIOCM_RTS;
                TIOCSBRK = Linux_AllArchs_Defines.TIOCSBRK;

                IOCPARM_MASK = IntDefine.UNDEFINED;
                IOCPARM_MAX = IntDefine.UNDEFINED;
                IOC_VOID = IntDefine.UNDEFINED;
                IOC_INOUT = Linux_AllArchs_Defines.IOC_INOUT;
                IOC_DIRMASK = IntDefine.UNDEFINED;

                _IOC_NRBITS = IntDefine.toIntDefine(Linux_AllArchs_Defines._IOC_NRBITS);
                _IOC_TYPEBITS = IntDefine.toIntDefine(Linux_AllArchs_Defines._IOC_TYPEBITS);
                _IOC_NRMASK = IntDefine.toIntDefine(Linux_AllArchs_Defines._IOC_NRMASK);
                _IOC_TYPEMASK = IntDefine.toIntDefine(Linux_AllArchs_Defines._IOC_TYPEMASK);
                _IOC_NRSHIFT = IntDefine.toIntDefine(Linux_AllArchs_Defines._IOC_NRSHIFT);
                _IOC_TYPESHIFT = IntDefine.toIntDefine(Linux_AllArchs_Defines._IOC_TYPESHIFT);
                _IOC_SIZESHIFT = IntDefine.toIntDefine(Linux_AllArchs_Defines._IOC_SIZESHIFT);
                _IOC_READ = IntDefine.toIntDefine(Linux_AllArchs_Defines._IOC_READ);
                IOCSIZE_SHIFT = IntDefine.toIntDefine(Linux_AllArchs_Defines.IOCSIZE_SHIFT);
                switch (multiarchInfo.getArch()) {
                    case MIPS:
                    case MIPS_64:
                        FIONREAD = Linux_Mips_Mips64_Defines.FIONREAD;
                        TIOCEXCL = Linux_Mips_Mips64_Defines.TIOCEXCL;
                        TIOCGICOUNT = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.TIOCGICOUNT);
                        TIOCGSOFTCAR = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.TIOCGSOFTCAR);
                        TIOCMBIC = Linux_Mips_Mips64_Defines.TIOCMBIC;
                        TIOCMBIS = Linux_Mips_Mips64_Defines.TIOCMBIS;
                        TIOCMGET = Linux_Mips_Mips64_Defines.TIOCMGET;
                        TIOCMIWAIT = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.TIOCMIWAIT);
                        TIOCMSET = Linux_Mips_Mips64_Defines.TIOCMSET;
                        TIOCM_CAR = Linux_Mips_Mips64_Defines.TIOCM_CAR;
                        TIOCM_CD = Linux_Mips_Mips64_Defines.TIOCM_CD;
                        TIOCM_CTS = Linux_Mips_Mips64_Defines.TIOCM_CTS;
                        TIOCM_DSR = Linux_Mips_Mips64_Defines.TIOCM_DSR;
                        TIOCM_RI = Linux_Mips_Mips64_Defines.TIOCM_RI;
                        TIOCM_RNG = Linux_Mips_Mips64_Defines.TIOCM_RNG;
                        TIOCM_SR = Linux_Mips_Mips64_Defines.TIOCM_SR;
                        TIOCM_ST = Linux_Mips_Mips64_Defines.TIOCM_ST;
                        TIOCOUTQ = Linux_Mips_Mips64_Defines.TIOCOUTQ;
                        TIOCSSOFTCAR = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.TIOCSSOFTCAR);
                        IOC_OUT = Linux_Mips_Mips64_Defines.IOC_OUT;
                        IOC_IN = Linux_Mips_Mips64_Defines.IOC_IN;
                        _IOC_SIZEBITS = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines._IOC_SIZEBITS);
                        _IOC_DIRBITS = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines._IOC_DIRBITS);
                        _IOC_SIZEMASK = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines._IOC_SIZEMASK);
                        _IOC_DIRMASK = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines._IOC_DIRMASK);
                        _IOC_DIRSHIFT = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines._IOC_DIRSHIFT);

                        _IOC_NONE = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines._IOC_NONE);
                        _IOC_WRITE = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines._IOC_WRITE);

                        IOCSIZE_MASK = IntDefine.toIntDefine(Linux_Mips_Mips64_Defines.IOCSIZE_MASK);
                        break;
                    case POWER_PC_64:
                        FIONREAD = Linux_Ppc64_Defines.FIONREAD;
                        TIOCOUTQ = Linux_Ppc64_Defines.TIOCOUTQ;
                        IOC_OUT = Linux_Ppc64_Defines.IOC_OUT;
                        IOC_IN = Linux_Ppc64_Defines.IOC_IN;
                        _IOC_SIZEBITS = IntDefine.toIntDefine(Linux_Ppc64_Defines._IOC_SIZEBITS);
                        _IOC_DIRBITS = IntDefine.toIntDefine(Linux_Ppc64_Defines._IOC_DIRBITS);
                        _IOC_SIZEMASK = IntDefine.toIntDefine(Linux_Ppc64_Defines._IOC_SIZEMASK);
                        _IOC_DIRMASK = IntDefine.toIntDefine(Linux_Ppc64_Defines._IOC_DIRMASK);
                        _IOC_DIRSHIFT = IntDefine.toIntDefine(Linux_Ppc64_Defines._IOC_DIRSHIFT);

                        _IOC_NONE = IntDefine.toIntDefine(Linux_Ppc64_Defines._IOC_NONE);
                        _IOC_WRITE = IntDefine.toIntDefine(Linux_Ppc64_Defines._IOC_WRITE);
                        IOCSIZE_MASK = IntDefine.toIntDefine(Linux_Ppc64_Defines.IOCSIZE_MASK);
                        TIOCEXCL = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCEXCL;
                        TIOCGICOUNT = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCGICOUNT);
                        TIOCGSOFTCAR = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCGSOFTCAR);
                        TIOCMBIC = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCMBIC;
                        TIOCMBIS = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCMBIS;
                        TIOCMGET = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCMGET;
                        TIOCMIWAIT = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCMIWAIT);
                        TIOCMSET = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCMSET;
                        TIOCM_CAR = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_CAR;
                        TIOCM_CD = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_CD;
                        TIOCM_CTS = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_CTS;
                        TIOCM_DSR = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_DSR;
                        TIOCM_RI = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_RI;
                        TIOCM_RNG = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_RNG;
                        TIOCM_SR = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_SR;
                        TIOCM_ST = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_ST;
                        TIOCSSOFTCAR = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCSSOFTCAR);
                        break;
                    case AARCH64:
                    case ARM:
                    case I386:
                    case RISC_V_64:
                    case S390_X:
                    case X86_64:
                        FIONREAD = Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines.FIONREAD;
                        TIOCOUTQ = Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines.TIOCOUTQ;
                        IOC_OUT = Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines.IOC_OUT;
                        IOC_IN = Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines.IOC_IN;
                        _IOC_SIZEBITS = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines._IOC_SIZEBITS);
                        _IOC_DIRBITS = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines._IOC_DIRBITS);
                        _IOC_SIZEMASK = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines._IOC_SIZEMASK);
                        _IOC_DIRMASK = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines._IOC_DIRMASK);
                        _IOC_DIRSHIFT = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines._IOC_DIRSHIFT);

                        _IOC_NONE = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines._IOC_NONE);
                        _IOC_WRITE = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines._IOC_WRITE);
                        IOCSIZE_MASK = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_RiscV64_S390_X86_64_Defines.IOCSIZE_MASK);
                        TIOCEXCL = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCEXCL;
                        TIOCGICOUNT = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCGICOUNT);
                        TIOCGSOFTCAR = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCGSOFTCAR);
                        TIOCMBIC = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCMBIC;
                        TIOCMBIS = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCMBIS;
                        TIOCMGET = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCMGET;
                        TIOCMIWAIT = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCMIWAIT);
                        TIOCMSET = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCMSET;
                        TIOCM_CAR = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_CAR;
                        TIOCM_CD = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_CD;
                        TIOCM_CTS = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_CTS;
                        TIOCM_DSR = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_DSR;
                        TIOCM_RI = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_RI;
                        TIOCM_RNG = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_RNG;
                        TIOCM_SR = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_SR;
                        TIOCM_ST = Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCM_ST;
                        TIOCSSOFTCAR = IntDefine.toIntDefine(Linux_Aarch64_Arm_I386_Ppc64_RiscV64_S390_X86_64_Defines.TIOCSSOFTCAR);
                        break;
                    default:
                        throw new NoClassDefFoundError("No ioctl.h linux defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                }
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_SYS_IOCTL_H = true;

                TIOCCBRK = BsdDefines.TIOCCBRK;
                TIOCM_DTR = BsdDefines.TIOCM_DTR;
                TIOCM_LE = BsdDefines.TIOCM_LE;
                TIOCM_RTS = BsdDefines.TIOCM_RTS;
                TIOCSBRK = BsdDefines.TIOCSBRK;

                IOCPARM_MASK = IntDefine.toIntDefine(BsdDefines.IOCPARM_MASK);
                IOC_VOID = IntDefine.toIntDefine(BsdDefines.IOC_VOID);
                IOC_INOUT = BsdDefines.IOC_INOUT;
                IOC_DIRMASK = IntDefine.toIntDefine(BsdDefines.IOC_DIRMASK);

                _IOC_NRBITS = IntDefine.UNDEFINED;
                _IOC_TYPEBITS = IntDefine.UNDEFINED;
                _IOC_NRMASK = IntDefine.UNDEFINED;
                _IOC_TYPEMASK = IntDefine.UNDEFINED;
                _IOC_NRSHIFT = IntDefine.UNDEFINED;
                _IOC_TYPESHIFT = IntDefine.UNDEFINED;
                _IOC_SIZESHIFT = IntDefine.UNDEFINED;
                _IOC_READ = IntDefine.UNDEFINED;
                IOCSIZE_SHIFT = IntDefine.UNDEFINED;
                FIONREAD = BsdDefines.FIONREAD;
                TIOCEXCL = BsdDefines.TIOCEXCL;
                TIOCGICOUNT = IntDefine.UNDEFINED;
                TIOCGSOFTCAR = IntDefine.UNDEFINED;
                TIOCMBIC = BsdDefines.TIOCMBIC;
                TIOCMBIS = BsdDefines.TIOCMBIS;
                TIOCMGET = BsdDefines.TIOCMGET;
                TIOCMIWAIT = IntDefine.UNDEFINED;
                TIOCMSET = BsdDefines.TIOCMSET;
                TIOCM_CAR = BsdDefines.TIOCM_CAR;
                TIOCM_CD = BsdDefines.TIOCM_CD;
                TIOCM_CTS = BsdDefines.TIOCM_CTS;
                TIOCM_DSR = BsdDefines.TIOCM_DSR;
                TIOCM_RI = BsdDefines.TIOCM_RI;
                TIOCM_RNG = BsdDefines.TIOCM_RNG;
                TIOCM_SR = BsdDefines.TIOCM_SR;
                TIOCM_ST = BsdDefines.TIOCM_ST;
                TIOCOUTQ = BsdDefines.TIOCOUTQ;
                TIOCSSOFTCAR = IntDefine.UNDEFINED;
                IOC_OUT = BsdDefines.IOC_OUT;
                IOC_IN = BsdDefines.IOC_IN;
                _IOC_SIZEBITS = IntDefine.UNDEFINED;
                _IOC_DIRBITS = IntDefine.UNDEFINED;
                _IOC_SIZEMASK = IntDefine.UNDEFINED;
                _IOC_DIRMASK = IntDefine.UNDEFINED;
                _IOC_DIRSHIFT = IntDefine.UNDEFINED;

                _IOC_NONE = IntDefine.UNDEFINED;
                _IOC_WRITE = IntDefine.UNDEFINED;

                IOCSIZE_MASK = IntDefine.UNDEFINED;
                switch (multiarchInfo.getOS()) {
                    case DARWIN:
                    case FREE_BSD:
                        IOCPARM_MAX = IntDefine.toIntDefine(FreeBsdDefines.IOCPARM_MAX);
                        break;
                    case OPEN_BSD:
                        IOCPARM_MAX = IntDefine.toIntDefine(OpenBsdDefines.IOCPARM_MAX);
                        break;
                    default:
                        throw new NoClassDefFoundError("No ioctl.h BSD defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
                }
                break;
            default:
                throw new NoClassDefFoundError("No ioctl.h OS defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
        }
    }

    /*
 * Used to create numbers.
 *
 * NOTE: _IOW means userland is writing and kernel is reading. _IOR
 * means userland is reading and kernel is writing.
     */
    public final static native int _IO(char type, int nr);

    public final static native int _IOC(int dir, char type, int nr, int size);

    /* used to decode ioctl numbers.. */
    public final static native int _IOC_DIR(int nr) throws NoSuchMethodException;

    public final static native int _IOC_NR(int nr) throws NoSuchMethodException;

    public final static native int _IOC_SIZE(int nr) throws NoSuchMethodException;

    public final static native char _IOC_TYPE(int nr) throws NoSuchMethodException;

    /**
     * Fallback to calc ioctl use calculated siste instead of natice type
     *
     * @param type
     * @param nr
     * @param size
     * @return
     */
    public final static int _IOR(char type, int nr, int size) {
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                return _IOC(_IOC_READ.get(), type, nr, size);
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                return _IOC(IOC_OUT, type, nr, size);
            default:
                throw new RuntimeException("OS not implememented :" + NativeLibResolver.getOS());
        }
    }

    /**
     * Fallback to calc ioctl use calculated siste instead of natice type
     *
     * @param type
     * @param nr
     * @param size
     * @return
     */
    public final static int _IOW(char type, int nr, int size) {
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                return _IOC(_IOC_WRITE.get(), type, nr, size);
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                return _IOC(IOC_IN, type, nr, size);
            default:
                throw new RuntimeException("OS not implememented :" + NativeLibResolver.getOS());
        }
    }

    /**
     * Fallback to calc ioctl use calculated siste instead of natice type
     *
     * @param type
     * @param nr
     * @param size
     * @return
     */
    public final static int _IOWR(char type, int nr, int size) {
        switch (NativeLibResolver.getOS()) {
            case LINUX:
                return _IOC(_IOC_READ.get() | _IOC_WRITE.get(), type, nr, size);
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                return _IOC(IOC_INOUT, type, nr, size);
            default:
                throw new RuntimeException("OS not implememented :" + NativeLibResolver.getOS());
        }
    }

    public final static native int IOCBASECMD(int x) throws NoSuchMethodException;

    public final static native int IOCGROUP(int x) throws NoSuchMethodException;

    public final static native int IOCPARM_LEN(int x) throws NoSuchMethodException;

    /**
     * The {@code  ioctl()} system call manipulates the underlying device
     * parameters of special files. In particular, many operating
     * characteristics of character special files (e.g., terminals) may be
     * controlled with {@code  ioctl()} requests.
     *
     * @param fd an open file descriptor
     * @param request a device-dependent request code
     * @return Usually, on success zero is returned. A few ioctl() requests use
     * the return value as an output parameter and return a nonnegative value on
     * success. On error, -1 is returned, and errno is set ap‐ propriately.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int ioctl(int fd, int request) throws NativeErrorException;

    /**
     * The {@code  ioctl()} system call manipulates the underlying device
     * parameters of special files. In particular, many operating
     * characteristics of character special files (e.g., terminals) may be
     * controlled with {@code  ioctl()} requests.
     *
     * @param fd an open file descriptor
     * @param request a device-dependent request code
     * @param value an untyped pointer to memory. It's traditionally char *argp
     * (from the days before void * was valid C), and will be so named for this
     * discussion.
     *
     * @return Usually, on success zero is returned. A few ioctl() requests use
     * the return value as an output parameter and return a nonnegative value on
     * success. On error, -1 is returned, and errno is set ap‐ propriately.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static int ioctl(int fd, int request, Int32_t value) throws NativeErrorException {
        return ioctl(fd, request, AbstractNativeMemory.toUintptr_t(value));
    }

    private static native int ioctl(int fd, int request, long ptrValue) throws NativeErrorException;

    public final static int ioctl(int fd, int request, OpaqueMemory32 value) throws NativeErrorException {
        return ioctl(fd, request, AbstractNativeMemory.toUintptr_t(value));
    }

    /**
     * An optimize version of {@link  ioctl(int fd, int request, Int32_t value)}
     * the value parameter is passed in and returned instead of the returned
     * value from the call to ioctl.
     *
     * @param fd an open file descriptor
     * @param request a device-dependent request code.
     * @param value the value to pass to ioctl.
     * @return the param value read from the device. The value is obtained by
     * calling ioctl(fd, request, &value).
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int ioctl_ReturnValue(int fd, int request, int value) throws NativeErrorException;

    private Ioctl() {

    }

}
