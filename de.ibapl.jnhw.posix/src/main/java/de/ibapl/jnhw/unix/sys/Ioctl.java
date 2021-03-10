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
import de.ibapl.jnhw.common.references.IntRef;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.util.IntDefine;
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

        HAVE_SYS_IOCTL_H = false;

        FIONREAD = 0;
        TIOCCBRK = 0;
        TIOCEXCL = 0;
        TIOCGICOUNT = IntDefine.UNDEFINED;
        TIOCGSOFTCAR = IntDefine.UNDEFINED;
        TIOCMBIC = 0;
        TIOCMBIS = 0;
        TIOCMGET = 0;
        TIOCMIWAIT = IntDefine.UNDEFINED;
        TIOCMSET = 0;
        TIOCM_CAR = 0;
        TIOCM_CD = 0;
        TIOCM_CTS = 0;
        TIOCM_DSR = 0;
        TIOCM_DTR = 0;
        TIOCM_LE = 0;
        TIOCM_RI = 0;
        TIOCM_RNG = 0;
        TIOCM_RTS = 0;
        TIOCM_SR = 0;
        TIOCM_ST = 0;
        TIOCOUTQ = 0;
        TIOCSBRK = 0;
        TIOCSSOFTCAR = IntDefine.UNDEFINED;

        IOCPARM_MASK = IntDefine.UNDEFINED;
        IOCPARM_MAX = IntDefine.UNDEFINED;
        IOC_VOID = IntDefine.UNDEFINED;
        IOC_OUT = 0;
        IOC_IN = 0;
        IOC_INOUT = 0;
        IOC_DIRMASK = IntDefine.UNDEFINED;

        _IOC_NRBITS = IntDefine.UNDEFINED;
        _IOC_TYPEBITS = IntDefine.UNDEFINED;
        _IOC_SIZEBITS = IntDefine.UNDEFINED;
        _IOC_DIRBITS = IntDefine.UNDEFINED;
        _IOC_NRMASK = IntDefine.UNDEFINED;
        _IOC_TYPEMASK = IntDefine.UNDEFINED;
        _IOC_SIZEMASK = IntDefine.UNDEFINED;
        _IOC_DIRMASK = IntDefine.UNDEFINED;
        _IOC_NRSHIFT = IntDefine.UNDEFINED;
        _IOC_TYPESHIFT = IntDefine.UNDEFINED;
        _IOC_SIZESHIFT = IntDefine.UNDEFINED;
        _IOC_DIRSHIFT = IntDefine.UNDEFINED;

        _IOC_NONE = IntDefine.UNDEFINED;
        _IOC_READ = IntDefine.UNDEFINED;
        _IOC_WRITE = IntDefine.UNDEFINED;

        IOCSIZE_MASK = IntDefine.UNDEFINED;
        IOCSIZE_SHIFT = IntDefine.UNDEFINED;

        initFields();
    }

    private static native void initFields();

    /**
     * <b>Non POSIX:</b> Get the number of bytes in the input buffer..
     *
     */
    @Define
    public final static int FIONREAD;

    public final static boolean HAVE_SYS_IOCTL_H;

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

    @Define
    public final static IntDefine IOCPARM_MASK;
    @Define
    public final static IntDefine IOCPARM_MAX;
    @Define
    public final static IntDefine IOC_VOID;
    @Define
    public final static int IOC_OUT;
    @Define
    public final static int IOC_IN;
    @Define
    public final static int IOC_INOUT;
    @Define
    public final static IntDefine IOC_DIRMASK;

    @Define
    public final static IntDefine _IOC_NRBITS;
    @Define
    public final static IntDefine _IOC_TYPEBITS;
    @Define
    public final static IntDefine _IOC_SIZEBITS;
    @Define
    public final static IntDefine _IOC_DIRBITS;
    @Define
    public final static IntDefine _IOC_NRMASK;
    @Define
    public final static IntDefine _IOC_TYPEMASK;
    @Define
    public final static IntDefine _IOC_SIZEMASK;
    @Define
    public final static IntDefine _IOC_DIRMASK;
    @Define
    public final static IntDefine _IOC_NRSHIFT;
    @Define
    public final static IntDefine _IOC_TYPESHIFT;
    @Define
    public final static IntDefine _IOC_SIZESHIFT;
    @Define
    public final static IntDefine _IOC_DIRSHIFT;

    @Define
    public final static IntDefine _IOC_READ;

    @Define
    public final static IntDefine _IOC_WRITE;

    @Define
    public final static IntDefine _IOC_NONE;

    /**
     * <b>Linux:</b> ("Set software carrier flag") Set the CLOCAL flag in the
     * termios structure when *argp is nonzero, and clear it otherwise.
     *
     */
    @Define
    public final static IntDefine TIOCSSOFTCAR;

    public final static native int _IOC(int dir, char type, int nr, int size);

    /*
 * Used to create numbers.
 *
 * NOTE: _IOW means userland is writing and kernel is reading. _IOR
 * means userland is reading and kernel is writing.
     */
    public final static native int _IO(char type, int nr);

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
            case OPEN_BSD:
                return _IOC(IOC_INOUT, type, nr, size);
            default:
                throw new RuntimeException("OS not implememented :" + NativeLibResolver.getOS());
        }
    }


    /* used to decode ioctl numbers.. */
    public final static native int _IOC_DIR(int nr) throws NoSuchMethodException;

    public final static native char _IOC_TYPE(int nr) throws NoSuchMethodException;

    public final static native int _IOC_NR(int nr) throws NoSuchMethodException;

    public final static native int _IOC_SIZE(int nr) throws NoSuchMethodException;

    public final static native int IOCPARM_LEN(int x) throws NoSuchMethodException;

    public final static native int IOCBASECMD(int x) throws NoSuchMethodException;

    public final static native int IOCGROUP(int x) throws NoSuchMethodException;

    /* ...and for the drivers/sound files... */
    @Define
    public final static IntDefine IOCSIZE_MASK;
    @Define
    public final static IntDefine IOCSIZE_SHIFT;

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
    public final static native int ioctl(int fd, int request, IntRef value) throws NativeErrorException;

    public final static native int ioctl(int fd, int request, OpaqueMemory32 value) throws NativeErrorException;

    private Ioctl() {

    }

}
