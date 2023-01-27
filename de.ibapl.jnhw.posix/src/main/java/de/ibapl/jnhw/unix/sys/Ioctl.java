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
package de.ibapl.jnhw.unix.sys;

import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_uL_VARARGS_NONE;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_uL_VARARGS__A;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.util.IntDefine;
import static de.ibapl.jnhw.libloader.Arch.MIPS;
import static de.ibapl.jnhw.libloader.Arch.MIPS_64;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.posix.Errno;
import de.ibapl.jnhw.libloader.libraries.LibcLoader;

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

    public static class LinuxDefines {

        public final int _IOC_NRBITS = 8;
        public final int _IOC_TYPEBITS = 8;
        public final int _IOC_SIZEBITS;
        public final int _IOC_DIRBITS;

        public final int _IOC_NRMASK = (1 << _IOC_NRBITS) - 1;
        public final int _IOC_TYPEMASK = (1 << _IOC_TYPEBITS) - 1;
        public final int _IOC_SIZEMASK;
        public final int _IOC_DIRMASK;

        public final int _IOC_NRSHIFT = 0;
        public final int _IOC_TYPESHIFT = _IOC_NRSHIFT + _IOC_NRBITS;
        public final int _IOC_SIZESHIFT = _IOC_TYPESHIFT + _IOC_TYPEBITS;
        public final int _IOC_DIRSHIFT;

        public final int _IOC_NONE;
        public final int _IOC_WRITE;
        public final int _IOC_READ = 2;

        public final int IOC_IN;
        public final int IOC_OUT;
        public final int IOC_INOUT;
        public final int IOCSIZE_MASK;
        public final int IOCSIZE_SHIFT = _IOC_SIZESHIFT;

        public final int TIOCCBRK = 21544;
        public final int TIOCM_DTR = 2;
        public final int TIOCM_LE = 1;
        public final int TIOCM_RTS = 4;
        public final int TIOCSBRK = 21543;

        public final int FIONREAD;

        public final int TIOCOUTQ;
        public final int TIOCEXCL;
        public final int TIOCGICOUNT;
        public final int TIOCGSOFTCAR;
        public final int TIOCM_CAR;
        public final int TIOCM_CD;
        public final int TIOCM_CTS;
        public final int TIOCM_DSR;
        public final int TIOCM_RI;
        public final int TIOCM_RNG;
        public final int TIOCM_SR;
        public final int TIOCM_ST;
        public final int TIOCMBIC;
        public final int TIOCMBIS;
        public final int TIOCMGET;
        public final int TIOCMIWAIT;
        public final int TIOCMSET;
        public final int TIOCSSOFTCAR;

        public LinuxDefines(MultiarchInfo mi) {
            switch (mi.getArch()) {
                case MIPS, MIPS_64, POWER_PC, POWER_PC_64 -> {
                    _IOC_SIZEBITS = 13;
                    _IOC_DIRBITS = 3;
                    _IOC_NONE = 1;
                    _IOC_WRITE = 4;
                }
                default -> {
                    _IOC_SIZEBITS = 14;
                    _IOC_DIRBITS = 2;
                    _IOC_NONE = 0;
                    _IOC_WRITE = 1;
                }
            }
            _IOC_DIRSHIFT = _IOC_SIZESHIFT + _IOC_SIZEBITS;

            IOC_IN = _IOC_WRITE << _IOC_DIRSHIFT;
            IOC_OUT = _IOC_READ << _IOC_DIRSHIFT;
            IOC_INOUT = (_IOC_WRITE | _IOC_READ) << _IOC_DIRSHIFT;
            _IOC_SIZEMASK = (1 << _IOC_SIZEBITS) - 1;
            _IOC_DIRMASK = (1 << _IOC_DIRBITS) - 1;
            IOCSIZE_MASK = _IOC_SIZEMASK << _IOC_SIZESHIFT;

            switch (mi.getArch()) {
                case MIPS, MIPS_64 -> {
                    FIONREAD = 18047;
                    TIOCOUTQ = 29810;
                }
                case POWER_PC, POWER_PC_64 -> {
                    FIONREAD = 1074030207;
                    TIOCOUTQ = 1074033779;
                }
                default -> {
                    FIONREAD = 21531;
                    TIOCOUTQ = 21521;
                }
            }
            switch (mi.getArch()) {
                case MIPS, MIPS_64 -> {
                    TIOCEXCL = 29709;
                    TIOCGICOUNT = 21650;
                    TIOCGSOFTCAR = 21633;
                    TIOCM_CAR = 256;
                    TIOCM_CD = 256;
                    TIOCM_CTS = 64;
                    TIOCM_DSR = 1024;
                    TIOCM_RI = 512;
                    TIOCM_RNG = 512;
                    TIOCM_SR = 32;
                    TIOCM_ST = 16;
                    TIOCMBIC = 29724;
                    TIOCMBIS = 29723;
                    TIOCMGET = 29725;
                    TIOCMIWAIT = 21649;
                    TIOCMSET = 29722;
                    TIOCSSOFTCAR = 21634;
                }
                default -> {
                    TIOCEXCL = 21516;
                    TIOCGICOUNT = 21597;
                    TIOCGSOFTCAR = 21529;
                    TIOCM_CAR = 64;
                    TIOCM_CD = 64;
                    TIOCM_CTS = 32;
                    TIOCM_DSR = 256;
                    TIOCM_RI = 128;
                    TIOCM_RNG = 128;
                    TIOCM_SR = 16;
                    TIOCM_ST = 8;
                    TIOCMBIC = 21527;
                    TIOCMBIS = 21526;
                    TIOCMGET = 21525;
                    TIOCMIWAIT = 21596;
                    TIOCMSET = 21528;
                    TIOCSSOFTCAR = 21530;
                }
            }

        }
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
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                HAVE_SYS_IOCTL_H = true;

                final LinuxDefines linuxDefines = new LinuxDefines(MultiarchTupelBuilder.getMultiarch());

                TIOCCBRK = linuxDefines.TIOCCBRK;
                TIOCM_DTR = linuxDefines.TIOCM_DTR;
                TIOCM_LE = linuxDefines.TIOCM_LE;
                TIOCM_RTS = linuxDefines.TIOCM_RTS;
                TIOCSBRK = linuxDefines.TIOCSBRK;

                IOCPARM_MASK = IntDefine.UNDEFINED;
                IOCPARM_MAX = IntDefine.UNDEFINED;
                IOC_VOID = IntDefine.UNDEFINED;
                IOC_DIRMASK = IntDefine.UNDEFINED;

                _IOC_NRBITS = IntDefine.toIntDefine(linuxDefines._IOC_NRBITS);
                _IOC_TYPEBITS = IntDefine.toIntDefine(linuxDefines._IOC_TYPEBITS);
                _IOC_SIZEBITS = IntDefine.toIntDefine(linuxDefines._IOC_SIZEBITS);
                _IOC_DIRBITS = IntDefine.toIntDefine(linuxDefines._IOC_DIRBITS);

                _IOC_NRMASK = IntDefine.toIntDefine(linuxDefines._IOC_NRMASK);
                _IOC_TYPEMASK = IntDefine.toIntDefine(linuxDefines._IOC_TYPEMASK);
                _IOC_SIZEMASK = IntDefine.toIntDefine(linuxDefines._IOC_SIZEMASK);
                _IOC_DIRMASK = IntDefine.toIntDefine(linuxDefines._IOC_DIRMASK);

                _IOC_NRSHIFT = IntDefine.toIntDefine(linuxDefines._IOC_NRSHIFT);
                _IOC_TYPESHIFT = IntDefine.toIntDefine(linuxDefines._IOC_TYPESHIFT);
                _IOC_SIZESHIFT = IntDefine.toIntDefine(linuxDefines._IOC_SIZESHIFT);
                _IOC_DIRSHIFT = IntDefine.toIntDefine(linuxDefines._IOC_DIRSHIFT);

                _IOC_NONE = IntDefine.toIntDefine(linuxDefines._IOC_NONE);
                _IOC_WRITE = IntDefine.toIntDefine(linuxDefines._IOC_WRITE);
                _IOC_READ = IntDefine.toIntDefine(linuxDefines._IOC_READ);

                IOC_IN = linuxDefines.IOC_IN;
                IOC_OUT = linuxDefines.IOC_OUT;
                IOC_INOUT = linuxDefines.IOC_INOUT;
                IOCSIZE_MASK = IntDefine.toIntDefine(linuxDefines.IOCSIZE_MASK);
                IOCSIZE_SHIFT = IntDefine.toIntDefine(linuxDefines.IOCSIZE_SHIFT);

                FIONREAD = linuxDefines.FIONREAD;

                TIOCEXCL = linuxDefines.TIOCEXCL;
                TIOCGICOUNT = IntDefine.toIntDefine(linuxDefines.TIOCGICOUNT);
                TIOCGSOFTCAR = IntDefine.toIntDefine(linuxDefines.TIOCGSOFTCAR);
                TIOCMBIC = linuxDefines.TIOCMBIC;
                TIOCMBIS = linuxDefines.TIOCMBIS;
                TIOCMGET = linuxDefines.TIOCMGET;
                TIOCMIWAIT = IntDefine.toIntDefine(linuxDefines.TIOCMIWAIT);
                TIOCMSET = linuxDefines.TIOCMSET;
                TIOCM_CAR = linuxDefines.TIOCM_CAR;
                TIOCM_CD = linuxDefines.TIOCM_CD;
                TIOCM_CTS = linuxDefines.TIOCM_CTS;
                TIOCM_DSR = linuxDefines.TIOCM_DSR;
                TIOCM_RI = linuxDefines.TIOCM_RI;
                TIOCM_RNG = linuxDefines.TIOCM_RNG;
                TIOCM_SR = linuxDefines.TIOCM_SR;
                TIOCM_ST = linuxDefines.TIOCM_ST;
                TIOCOUTQ = linuxDefines.TIOCOUTQ;
                TIOCSSOFTCAR = IntDefine.toIntDefine(linuxDefines.TIOCSSOFTCAR);
            }
            case APPLE, FREE_BSD, OPEN_BSD -> {
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
                switch (MultiarchTupelBuilder.getOS()) {
                    case APPLE, FREE_BSD ->
                        IOCPARM_MAX = IntDefine.toIntDefine(FreeBsdDefines.IOCPARM_MAX);
                    case OPEN_BSD ->
                        IOCPARM_MAX = IntDefine.toIntDefine(OpenBsdDefines.IOCPARM_MAX);
                    default ->
                        throw new NoClassDefFoundError("No ioctl.h BSD defines for " + MultiarchTupelBuilder.getMultiarch());
                }
            }
            default ->
                throw new NoClassDefFoundError("No ioctl.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    private final static JnhwMh_sI__sI_uL_VARARGS_NONE.ExceptionErased ioctl = JnhwMh_sI__sI_uL_VARARGS_NONE.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "ioctl",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_unsigned_long_int);

    private final static JnhwMh_sI__sI_uL_VARARGS__A.ExceptionErased ioctl_VARARG_intptr_t = JnhwMh_sI__sI_uL_VARARGS__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "ioctl",
            BaseDataType.C_int,
            BaseDataType.C_int,
            BaseDataType.C_unsigned_long_int,
            BaseDataType.C_VaList);

    /*
     * Used to create numbers.
     *
     * NOTE: _IOW means userland is writing and kernel is reading. _IOR
     * means userland is reading and kernel is writing.
     */
    public final static int _IO(char type, int nr) {
        return switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD, OPEN_BSD ->
                // _IO(g,n) _IOC(IOC_VOID, (g), (n), 0)
                _IOC(IOC_VOID.get(), type, nr, 0);
            case LINUX ->
                _IOC(_IOC_NONE.get(), type, nr, 0);
            default ->
                throw new RuntimeException("No _IO in ioctl.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        };
    }

    public final static int _IOC(int dir, char type, int nr, int size) {
        return switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD, OPEN_BSD ->
                // _IOC(inout,group,num,len) ((unsigned long) ((inout) | (((len) & IOCPARM_MASK) << 16) | ((group) << 8) | (num)))
                // TODO result unsigned long ???
                dir | ((size & IOCPARM_MASK.get()) << 16) | (type << 8) | nr;
            case LINUX ->
                (dir << _IOC_DIRSHIFT.get())
                | (type << _IOC_TYPESHIFT.get())
                | (nr << _IOC_NRSHIFT.get())
                | (size << _IOC_SIZESHIFT.get());
            default ->
                throw new RuntimeException("No _IOC in ioctl.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        };
    }

    /* used to decode ioctl numbers.. */
    public final static int _IOC_DIR(int nr) throws NoSuchMethodException {
        return switch (MultiarchTupelBuilder.getOS()) {
            case LINUX ->
                ((nr >> _IOC_DIRSHIFT.get()) & _IOC_DIRMASK.get());
            default ->
                throw new NoSuchMethodException("No _IOC_DIR in ioctl.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        };
    }

    public final static int _IOC_NR(int nr) throws NoSuchMethodException {
        return switch (MultiarchTupelBuilder.getOS()) {
            case LINUX ->
                ((nr >> _IOC_NRSHIFT.get()) & _IOC_NRMASK.get());
            default ->
                throw new NoSuchMethodException("No _IOC_NR in ioctl.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        };
    }

    public final static int _IOC_SIZE(int nr) throws NoSuchMethodException {
        return switch (MultiarchTupelBuilder.getOS()) {
            case LINUX ->
                ((nr >> _IOC_SIZESHIFT.get()) & _IOC_SIZEMASK.get());
            default ->
                throw new NoSuchMethodException("No _IOC_SIZE in ioctl.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        };
    }

    public final static char _IOC_TYPE(int nr) throws NoSuchMethodException {
        return switch (MultiarchTupelBuilder.getOS()) {
            case LINUX ->
                (char) ((nr >> _IOC_TYPESHIFT.get()) & _IOC_TYPEMASK.get());
            default ->
                throw new NoSuchMethodException("No _IOC_TYPE in ioctl.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        };
    }

    /**
     * Fallback to calc ioctl use calculated siste instead of natice type
     *
     * @param type
     * @param nr
     * @param size
     * @return
     */
    public final static int _IOR(char type, int nr, int size) {
        return switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD, OPEN_BSD ->
                _IOC(IOC_OUT, type, nr, size);
            case LINUX ->
                _IOC(_IOC_READ.get(), type, nr, size);
            default ->
                throw new RuntimeException("OS not implememented :" + MultiarchTupelBuilder.getOS());
        };
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
        return switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD, OPEN_BSD ->
                _IOC(IOC_IN, type, nr, size);
            case LINUX ->
                _IOC(_IOC_WRITE.get(), type, nr, size);
            default ->
                throw new RuntimeException("OS not implememented :" + MultiarchTupelBuilder.getOS());
        };
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
        return switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD, OPEN_BSD ->
                _IOC(IOC_INOUT, type, nr, size);
            case LINUX ->
                _IOC(_IOC_READ.get() | _IOC_WRITE.get(), type, nr, size);
            default ->
                throw new RuntimeException("OS not implememented :" + MultiarchTupelBuilder.getOS());
        };
    }

    public final static int IOCBASECMD(int x) throws NoSuchMethodException {
        return switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD, OPEN_BSD ->
                (x & ~(IOCPARM_MASK.get() << 16));
            default ->
                throw new NoSuchMethodException("No IOCBASECMD in ioctl.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        };
    }

    public final static int IOCGROUP(int x) throws NoSuchMethodException {
        return switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD, OPEN_BSD ->
                ((x >> 8) & 0xff);
            default ->
                throw new NoSuchMethodException("No IOCGROUP in ioctl.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        };
    }

    public final static int IOCPARM_LEN(int x) throws NoSuchMethodException {
        return switch (MultiarchTupelBuilder.getOS()) {
            case APPLE, FREE_BSD, OPEN_BSD ->
                ((x >> 16) & IOCPARM_MASK.get());
            default ->
                throw new NoSuchMethodException("No IOCPARM_LEN in ioctl.h OS defines for " + MultiarchTupelBuilder.getMultiarch());
        };
    }

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
    public final static int ioctl(int fd, long request) throws NativeErrorException {
        final int result = ioctl.invoke_sI__sI_uL(fd, request);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

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
    //TODO introduce vaList
    public final static int ioctl(int fd, long request, Int32_t value) throws NativeErrorException {
        final int result = ioctl_VARARG_intptr_t.invoke_sI__sI_uL__P(fd, request, value);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

    /*
    public final static int ioctl(int fd, long request, VaList value) throws NativeErrorException {
        final int result = ioctl_sI__sIvsI.invoke_sI__sI_uLv_A(fd, request, value);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }
     */
    private Ioctl() {

    }

}
