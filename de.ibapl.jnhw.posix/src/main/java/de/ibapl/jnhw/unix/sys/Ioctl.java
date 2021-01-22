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
import de.ibapl.jnhw.common.exception.NotDefinedException;
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
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    /**
     * <b>Non POSIX:</b> Get the number of bytes in the input buffer..
     *
     * @return the native symbolic constant of FIONREAD.
     */
    @Define
    public final static native int FIONREAD();

    public final static native boolean HAVE_SYS_IOCTL_H();

    /**
     * <b>Non POSIX:</b> Turn break off, that is, stop sending zero bits.
     *
     * @return the native symbolic constant of TIOCCBRK.
     */
    @Define
    public final static native int TIOCCBRK();

    /**
     * <b>Non POSIX:</b> Put the terminal into exclusive mode..
     *
     * @return the native symbolic constant of TIOCEXCL.
     */
    @Define
    public final static native int TIOCEXCL();

    /**
     * <b>Linux:</b> Get counts of input serial line interrupts (DCD, RI, DSR,
     * CTS).
     *
     * @return the native symbolic constant of TIOCGICOUNT.
     * @throws NotDefinedException if TIOCGICOUNT is not defined natively.
     */
    @Define
    public final static native int TIOCGICOUNT() throws NotDefinedException;

    /**
     * <b>Linux:</b> ("Get software carrier flag") Get the status of the CLOCAL
     * flag in the c_cflag field of the termios structure.
     *
     * @return the native symbolic constant of TIOCGSOFTCAR.
     * @throws NotDefinedException if TIOCGSOFTCAR is not defined natively.
     */
    @Define
    public final static native int TIOCGSOFTCAR() throws NotDefinedException;

    /**
     * <b>Non POSIX:</b> Clear the indicated modem bits.
     *
     * @return the native symbolic constant of TIOCMBIC.
     */
    @Define
    public final static native int TIOCMBIC();

    /**
     * <b>Non POSIX:</b> Set the indicated modem bits.
     *
     * @return the native symbolic constant of TIOCMBIS.
     */
    @Define
    public final static native int TIOCMBIS();

    /**
     * <b>Non POSIX:</b> Get the status of modem bits.
     *
     * @return the native symbolic constant of TIOCMGET.
     */
    @Define
    public final static native int TIOCMGET();

    /**
     * <b>Linux:</b> Wait for any of the 4 modem bits (DCD, RI, DSR, CTS) to
     * change.
     *
     * @return the native symbolic constant of TIOCMIWAIT.
     * @throws NotDefinedException if TIOCMIWAIT is not defined natively.
     */
    @Define
    public final static native int TIOCMIWAIT() throws NotDefinedException;

    /**
     * <b>Non POSIX:</b> Set the status of modem bits.
     *
     * @return the native symbolic constant of TIOCMSET.
     */
    @Define
    public final static native int TIOCMSET();

    /**
     * <b>Non POSIX:</b>DCD (data carrier detect) .
     *
     * @return the native symbolic constant of TIOCM_CAR.
     */
    @Define
    public final static native int TIOCM_CAR();

    /**
     * <b>Non POSIX:</b> {@link TIOCM_CAR}.
     *
     * @return the native symbolic constant of TIOCM_CD.
     */
    @Define
    public final static native int TIOCM_CD();

    /**
     * <b>Non POSIX:</b> CTS (clear to send).
     *
     * @return the native symbolic constant of .
     */
    @Define
    public final static native int TIOCM_CTS();

    /**
     * <b>Non POSIX:</b> DSR (data set ready).
     *
     * @return the native symbolic constant of TIOCM_DSR.
     */
    @Define
    public final static native int TIOCM_DSR();

    /**
     * <b>Non POSIX:</b> DTR (data terminal ready).
     *
     * @return the native symbolic constant of TIOCM_DTR.
     */
    @Define
    public final static native int TIOCM_DTR();

    /**
     * <b>Non POSIX:</b> DSR (data set ready/line enable).
     *
     * @return the native symbolic constant of TIOCM_LE.
     */
    @Define
    public final static native int TIOCM_LE();

    /**
     * <b>Non POSIX:</b> {@link TIOCM_RNG}.
     *
     * @return the native symbolic constant of TIOCM_RI.
     */
    @Define
    public final static native int TIOCM_RI();

    /**
     * <b>Non POSIX:</b> RNG (ring).
     *
     * @return the native symbolic constant of TIOCM_RNG.
     */
    @Define
    public final static native int TIOCM_RNG();

    /**
     * <b>Non POSIX:</b> RTS (request to send).
     *
     * @return the native symbolic constant of TIOCM_RTS.
     */
    @Define
    public final static native int TIOCM_RTS();

    /**
     * <b>Non POSIX:</b> Secondary RXD (receive).
     *
     * @return the native symbolic constant of TIOCM_SR.
     */
    @Define
    public final static native int TIOCM_SR();

    /**
     * <b>Non POSIX:</b> Secondary TXD (transmit).
     *
     * @return the native symbolic constant of TIOCM_ST.
     */
    @Define
    public final static native int TIOCM_ST();

    /**
     * <b>Non POSIX:</b> Get the number of bytes in the output buffer.
     *
     * @return the native symbolic constant of TIOCOUTQ.
     */
    @Define
    public final static native int TIOCOUTQ();

    /**
     * <b>Non POSIX:</b> Turn break on, that is, start sending zero bits.
     *
     * @return the native symbolic constant of TIOCSBRK.
     */
    @Define
    public final static native int TIOCSBRK();

    /**
     * <b>Linux:</b> ("Set software carrier flag") Set the CLOCAL flag in the
     * termios structure when *argp is nonzero, and clear it otherwise.
     *
     * @return the native symbolic constant of TIOCSSOFTCAR.
     * @throws NotDefinedException if TIOCSSOFTCAR is not defined natively.
     */
    @Define
    public final static native int TIOCSSOFTCAR() throws NotDefinedException;

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

    private Ioctl() {

    }

}
