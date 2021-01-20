/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2020, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.annontation.posix.termios.speed_t;
import de.ibapl.jnhw.annontation.posix.termios.tcflag_t;
import de.ibapl.jnhw.common.annotation.AlignOf;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.annotation.Unsigned;
import de.ibapl.jnhw.common.datatypes.BaseDataTypes;
import de.ibapl.jnhw.common.exceptions.NativeErrorException;
import de.ibapl.jnhw.common.exceptions.NoSuchNativeTypeMemberException;
import de.ibapl.jnhw.common.exceptions.NotDefinedException;
import de.ibapl.jnhw.common.memory.NativeIntNumber;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.annontation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annontation.posix.termios.cc_t;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> Hang up.
     *
     * @return the native symbolic constant of BO.
     */
    @Define
    public final static native @speed_t
    int B0();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 1000000 baud.
     *
     * @return the native symbolic constant of B1000000.
     * @throws NotDefinedException if B1000000 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B1000000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 110 baud.
     *
     * @return the native symbolic constant of B110.
     */
    @Define
    public final static native @speed_t
    int B110();

    /**
     * <b>Non POSIX:</b> <i>Baud Rate Selection</i> 115200 baud.
     *
     * @return the native symbolic constant of B115200.
     * @throws NotDefinedException if B115200 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B115200() throws NotDefinedException;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 1152000 baud.
     *
     * @return the native symbolic constant of B1152000.
     * @throws NotDefinedException if B1152000 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B1152000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 1200 baud.
     *
     * @return the native symbolic constant of B1200.
     */
    @Define
    public final static native @speed_t
    int B1200();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 134.5 baud.
     *
     * @return the native symbolic constant of B134.
     */
    @Define
    public final static native @speed_t
    int B134();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 150 baud.
     *
     * @return the native symbolic constant of B150.
     */
    @Define
    public final static native @speed_t
    int B150();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 1500000 baud.
     *
     * @return the native symbolic constant of B1500000.
     * @throws NotDefinedException if B1500000 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B1500000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 1800 baud.
     *
     * @return the native symbolic constant of B1800.
     */
    @Define
    public final static native @speed_t
    int B1800();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 19200 baud.
     *
     * @return the native symbolic constant of B19200.
     */
    @Define
    public final static native @speed_t
    int B19200();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 200 baud.
     *
     * @return the native symbolic constant of B200.
     */
    @Define
    public final static native @speed_t
    int B200();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 2000000 baud.
     *
     * @return the native symbolic constant of B2000000.
     * @throws NotDefinedException if B2000000 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B2000000() throws NotDefinedException;

    /**
     * <b>Non POSIX:</b> <i>Baud Rate Selection</i> 230400 baud.
     *
     * @return the native symbolic constant of B230400.
     * @throws NotDefinedException if B230400 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B230400() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 2400 baud.
     *
     * @return the native symbolic constant of B2400.
     */
    @Define
    public final static native @speed_t
    int B2400();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 2500000 baud.
     *
     * @return the native symbolic constant of B2500000.
     * @throws NotDefinedException if B2500000 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B2500000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 300 baud.
     *
     * @return the native symbolic constant of B300.
     */
    @Define
    public final static native @speed_t
    int B300();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 3000000 baud.
     *
     * @return the native symbolic constant of B3000000.
     * @throws NotDefinedException if B3000000 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B3000000() throws NotDefinedException;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 3500000 baud.
     *
     * @return the native symbolic constant of B3500000.
     * @throws NotDefinedException if B3500000 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B3500000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 38400 baud.
     *
     * @return the native symbolic constant of B38400.
     */
    @Define
    public final static native @speed_t
    int B38400();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 4000000 baud.
     *
     * @return the native symbolic constant of B4000000.
     * @throws NotDefinedException if B4000000 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B4000000() throws NotDefinedException;

    /**
     * <b>Linux,FreeBSD:</b> <i>Baud Rate Selection</i> 460800 baud.
     *
     * @return the native symbolic constant of B460800.
     * @throws NotDefinedException if B460800 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B460800() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 4800 baud.
     *
     * @return the native symbolic constant of B4800.
     */
    @Define
    public final static native @speed_t
    int B4800();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 50 baud.
     *
     * @return the native symbolic constant of B50.
     */
    @Define
    public final static native @speed_t
    int B50();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 500000 baud.
     *
     * @return the native symbolic constant of B500000.
     * @throws NotDefinedException if B500000 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B500000() throws NotDefinedException;

    /**
     * <b>Non POSIX:</b> <i>Baud Rate Selection</i> 57600 baus
     *
     * @return the native symbolic constant of B57600.
     * @throws NotDefinedException if B57600 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B57600() throws NotDefinedException;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 576000 baud.
     *
     * @return the native symbolic constant of B576000.
     * @throws NotDefinedException if B576000 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B576000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 600 baud.
     *
     * @return the native symbolic constant of B600.
     */
    @Define
    public final static native @speed_t
    int B600();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 75 baud.
     *
     * @return the native symbolic constant of B75.
     */
    @Define
    public final static native @speed_t
    int B75();

    /**
     * <b>Linux,FreeBSD:</b> <i>Baud Rate Selection</i> 921600 baud.
     *
     * @return the native symbolic constant of B921600.
     * @throws NotDefinedException if B921600 is not defined natively.
     */
    @Define
    public final static native @speed_t
    int B921600() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 9600 baud.
     *
     * @return the native symbolic constant of B9600.
     */
    @Define
    public final static native @speed_t
    int B9600();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Signal interrupt on break.
     *
     * @return the native symbolic constant of BRKINT.
     */
    @Define
    public final static native @tcflag_t
    int BRKINT();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Backspace-delay type 0.
     *
     * @return the native symbolic constant of BS0.
     * @throws NotDefinedException if BS0 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int BS0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Backspace-delay type 1.
     *
     * @return the native symbolic constant of BS1.
     * @throws NotDefinedException if BS1 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int BS1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select backspace delays:
     *
     * @return the native symbolic constant of BSDLY.
     * @throws NotDefinedException if BSDLY is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int BSDLY() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Ignore modem status lines.
     *
     * @return the native symbolic constant of CLOCAL.
     */
    @Define
    public final static native @tcflag_t
    int CLOCAL();

    /**
     * <b>Linux:</b> <i>Control Modes</i> Use d "stick" (mark/space) parity
     * (supported on certain serial devices).
     *
     * @return the native symbolic constant of CMSPAR.
     * @throws NotDefinedException if CMSPAR is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int CMSPAR() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 0.
     *
     * @return the native symbolic constant of CR0.
     * @throws NotDefinedException if CR0 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int CR0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 1.
     *
     * @return the native symbolic constant of CR1.
     * @throws NotDefinedException if CR1 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int CR1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 2.
     *
     * @return the native symbolic constant of CR2.
     * @throws NotDefinedException if CR2 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int CR2() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 3.
     *
     * @return the native symbolic constant of CR3.
     * @throws NotDefinedException if CR3 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int CR3() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select carriage-return delays:
     *
     * @return the native symbolic constant of CRDLY.
     * @throws NotDefinedException if CRDLY is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int CRDLY() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Enable receiver.
     *
     * @return the native symbolic constant of CREAD.
     */
    @Define
    public final static native @tcflag_t
    int CREAD();

    /**
     * <b>Non POSIX:</b> <i>Control Modes</i>
     *
     * @return the native symbolic constant of .
     */
    @Define
    public final static native @tcflag_t
    int CRTSCTS();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 5 bits.
     *
     * @return the native symbolic constant of CS5.
     */
    @Define
    public final static native @tcflag_t
    int CS5();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 6 bits.
     *
     * @return the native symbolic constant of CS6.
     */
    @Define
    public final static native @tcflag_t
    int CS6();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 7 bits.
     *
     * @return the native symbolic constant of CS7.
     */
    @Define
    public final static native @tcflag_t
    int CS7();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 8 bits.
     *
     * @return the native symbolic constant of CS8.
     */
    @Define
    public final static native @tcflag_t
    int CS8();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Character size:
     *
     * @return the native symbolic constant of CSIZE.
     */
    @Define
    public final static native @tcflag_t
    int CSIZE();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Send two stop bits, else one.
     *
     * @return the native symbolic constant of CSTOPB.
     */
    @Define
    public final static native @tcflag_t
    int CSTOPB();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Enable echo.
     *
     * @return the native symbolic constant of ECHO.
     */
    @Define
    public final static native @tcflag_t
    int ECHO();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Echo erase character as error-correcting
     * backspace.
     *
     * @return the native symbolic constant of ECHOE.
     */
    @Define
    public final static native @tcflag_t
    int ECHOE();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Echo KILL.
     *
     * @return the native symbolic constant of ECHOK.
     */
    @Define
    public final static native @tcflag_t
    int ECHOK();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Echo NL.
     *
     * @return the native symbolic constant of ECHONL.
     */
    @Define
    public final static native @tcflag_t
    int ECHONL();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Form-feed delay type 0.
     *
     * @return the native symbolic constant of FF0.
     * @throws NotDefinedException if FF0 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int FF0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Form-feed delay type 1.
     *
     * @return the native symbolic constant of FF1.
     * @throws NotDefinedException if FF1 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int FF1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select form-feed delays:
     *
     * @return the native symbolic constant of FFDLY.
     * @throws NotDefinedException if FFDLY is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int FFDLY() throws NotDefinedException;

    public final static native boolean HAVE_TERMIOS_H();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Hang up on last close.
     *
     * @return the native symbolic constant of HUPCL.
     */
    @Define
    public final static native @tcflag_t
    int HUPCL();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Canonical input (erase and kill
     * processing).
     *
     * @return the native symbolic constant of ICANON.
     */
    @Define
    public final static native @tcflag_t
    int ICANON();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Map CR to NL on input.
     *
     * @return the native symbolic constant of ICRNL.
     */
    @Define
    public final static native @tcflag_t
    int ICRNL();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Enable extended input character
     * processing.
     *
     * @return the native symbolic constant of IEXTEN.
     */
    @Define
    public final static native @tcflag_t
    int IEXTEN();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Ignore break condition.
     *
     * @return the native symbolic constant of IGNBRK.
     */
    @Define
    public final static native @tcflag_t
    int IGNBRK();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Ignore CR.
     *
     * @return the native symbolic constant of IGNCR.
     */
    @Define
    public final static native @tcflag_t
    int IGNCR();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Ignore characters with parity errors.
     *
     * @return the native symbolic constant of IGNPAR.
     */
    @Define
    public final static native @tcflag_t
    int IGNPAR();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Map NL to CR on input.
     *
     * @return the native symbolic constant of INLCR.
     */
    @Define
    public final static native @tcflag_t
    int INLCR();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable input parity check.
     *
     * @return the native symbolic constant of INPCK.
     */
    @Define
    public final static native @tcflag_t
    int INPCK();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Enable signals.
     *
     * @return the native symbolic constant of ISIG.
     */
    @Define
    public final static native @tcflag_t
    int ISIG();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Strip character.
     *
     * @return the native symbolic constant of ISTRIP.
     */
    @Define
    public final static native @tcflag_t
    int ISTRIP();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable any character to restart output.
     *
     * @return the native symbolic constant of IXANY.
     */
    @Define
    public final static native @tcflag_t
    int IXANY();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable start/stop input control.
     *
     * @return the native symbolic constant of IXOFF.
     */
    @Define
    public final static native @tcflag_t
    int IXOFF();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable start/stop output control.
     *
     * @return the native symbolic constant of IXON.
     */
    @Define
    public final static native @tcflag_t
    int IXON();

    /**
     * <b>POSIX:</b> Size of the array c_cc for control characters.
     *
     * @return the native symbolic constant of NCCS.
     */
    @Define
    public final static native @tcflag_t
    int NCCS();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Newline type 0.
     *
     * @return the native symbolic constant of NL0.
     * @throws NotDefinedException if NL0 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int NL0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Newline type 1.
     *
     * @return the native symbolic constant of NL1.
     * @throws NotDefinedException if NL1 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int NL1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select newline delays: {@code NL0}
     * or {@code NL1}
     *
     * @return the native symbolic constant of NLDLY.
     * @throws NotDefinedException if NLDLY is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int NLDLY() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Disable flush after interrupt or quit.
     *
     * @return the native symbolic constant of NOFLSH.
     */
    @Define
    public final static native @tcflag_t
    int NOFLSH();

    /**
     * <b>POSIX,XSI:</b> <i>Output Modes</i> Map CR to NL on output.
     *
     * @return the native symbolic constant of OCRNL.
     */
    @Define
    public final static native @tcflag_t
    int OCRNL();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Fill is DEL.
     *
     * @return the native symbolic constant of OFDEL.
     * @throws NotDefinedException if OFDEL is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int OFDEL() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Use fill characters for delay.
     *
     * @return the native symbolic constant of OFILL.
     * @throws NotDefinedException if OFILL is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int OFILL() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Map NL to CR-NL on output.
     *
     * @return the native symbolic constant of ONLCR.
     */
    @Define
    public final static native @tcflag_t
    int ONLCR();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> NL performs CR function.
     *
     * @return the native symbolic constant of ONLRET.
     */
    @Define
    public final static native @tcflag_t
    int ONLRET();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> No CR output at column 0.
     *
     * @return the native symbolic constant of ONOCR.
     */
    @Define
    public final static native @tcflag_t
    int ONOCR();

    /**
     * <b>POSIX:</b> <i>Output Modes</i> Post-process output.
     *
     * @return the native symbolic constant of OPOST.
     */
    @Define
    public final static native @tcflag_t
    int OPOST();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Parity enable.
     *
     * @return the native symbolic constant of PARENB.
     */
    @Define
    public final static native @tcflag_t
    int PARENB();

    /**
     * <b>???:</b> <i>Control Modes</i> ???Use d "stick" (mark/space) parity
     * (supported on certain serial devices).???
     *
     * @return the native symbolic constant of PAREXT.
     * @throws NotDefinedException if PAREXT is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int PAREXT() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Mark parity errors.
     *
     * @return the native symbolic constant of .
     * @throws NotDefinedException if PARMRK is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int PARMRK() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Odd parity, else even.
     *
     * @return the native symbolic constant of PARODD.
     */
    @Define
    public final static native @tcflag_t
    int PARODD();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Horizontal-tab delay type 0.
     *
     * @return the native symbolic constant of TAB0.
     * @throws NotDefinedException if TAB0 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int TAB0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Horizontal-tab delay type 1.
     *
     * @return the native symbolic constant of TAB1.
     * @throws NotDefinedException if TAB1 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int TAB1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Horizontal-tab delay type 2.
     *
     * @return the native symbolic constant of TAB2.
     * @throws NotDefinedException if TAB2 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int TAB2() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Expand tabs to spaces.
     *
     * @return the native symbolic constant of TAB3.
     * @throws NotDefinedException if TAB3 is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int TAB3() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select horizontal-tab delays:
     *
     * @return the native symbolic constant of TABDLY.
     * @throws NotDefinedException if TABDLY is not defined natively.
     */
    @Define
    public final static native @tcflag_t
    int TABDLY() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Line Control</i> Flush pending input.
     *
     * @return the native symbolic constant of TCIFLUSH.
     */
    @Define
    public final static native @tcflag_t
    int TCIFLUSH();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Transmit a STOP character, intended to
     * suspend input data.
     *
     * @return the native symbolic constant of TCIOFF.
     */
    @Define
    public final static native @tcflag_t
    int TCIOFF();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Flush both pending input and
     * untransmitted output.
     *
     * @return the native symbolic constant of TCIOFLUSH.
     */
    @Define
    public final static native @tcflag_t
    int TCIOFLUSH();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Transmit a START character, intended to
     * restart input data.
     *
     * @return the native symbolic constant of TCION.
     */
    @Define
    public final static native @tcflag_t
    int TCION();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Flush untransmitted output.
     *
     * @return the native symbolic constant of TCOFLUSH.
     */
    @Define
    public final static native @tcflag_t
    int TCOFLUSH();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Suspend output.
     *
     * @return the native symbolic constant of TCOOFF.
     */
    @Define
    public final static native @tcflag_t
    int TCOOFF();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Restart output.
     *
     * @return the native symbolic constant of TCOON.
     */
    @Define
    public final static native @tcflag_t
    int TCOON();

    /**
     * <b>POSIX:</b> <i>Attribute Selection</i> Change attributes when output
     * has drained; also flush pending input.
     *
     * @return the native symbolic constant of TCSADRAIN.
     */
    @Define
    public final static native @tcflag_t
    int TCSADRAIN();

    /**
     * <b>POSIX:</b> <i>Attribute Selection</i> Change attributes when output
     * has drained.
     *
     * @return the native symbolic constant of TCSAFLUSH.
     */
    @Define
    public final static native @tcflag_t
    int TCSAFLUSH();

    /**
     * <b>POSIX:</b> <i>Attribute Selection</i> Change attributes immediately.
     *
     * @return the native symbolic constant of TCSANOW.
     */
    @Define
    public final static native @tcflag_t
    int TCSANOW();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Send SIGTTOU for background output.
     *
     * @return the native symbolic constant of TOSTOP.
     */
    @Define
    public final static native @tcflag_t
    int TOSTOP();

    /**
     * <b>POSIX:</b> EOF character in <b>Canonical Mode</b>.
     *
     * @return the native symbolic constant of VEOF.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VEOF();

    /**
     * <b>POSIX:</b> EOL character in <b>Canonical Mode</b>.
     *
     * @return the native symbolic constant of VEOL.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VEOL();

    /**
     * <b>POSIX:</b> ERASE character in <b>Canonical Mode</b>.
     *
     * @return the native symbolic constant of VERASE.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VERASE();

    /**
     * <b>POSIX:</b> INTR character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VINTR.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VINTR();

    /**
     * <b>POSIX:</b> KILL character in <b>Canonical Mode</b>.
     *
     * @return the native symbolic constant of VKILL.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VKILL();

    /**
     * <b>POSIX:</b> MIN value in <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VMIN.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VMIN();

    /**
     * <b>POSIX:</b> QUIT character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VQUIT.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VQUIT();

    /**
     * <b>POSIX:</b> START character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VSTART.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VSTART();

    /**
     * <b>POSIX:</b> STOP character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VSTOP.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VSTOP();

    /**
     * <b>POSIX:</b> VSUSP character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VSUSP.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VSUSP();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Vertical-tab delay type 0.
     *
     * @return the native symbolic constant of VT0.
     * @throws NotDefinedException if VT0 is not defined natively.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VT0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Vertical-tab delay type 1.
     *
     * @return the native symbolic constant of VT1.
     * @throws NotDefinedException if VT1 is not defined natively.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VT1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select vertical-tab delays:
     *
     * @return the native symbolic constant of VTDLY.
     * @throws NotDefinedException if VTDLY is not defined natively.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VTDLY() throws NotDefinedException;

    /**
     * <b>POSIX:</b> VTIME value in <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VTIME.
     */
    @Define
    @cc_t
    public final static native @tcflag_t
    int VTIME();

    /**
     * <b>Linux:</b>
     *
     * @return the native symbolic constant of .
     * @throws NotDefinedException if _HAVE_STRUCT_TERMIOS_C_ISPEED is not
     * defined natively.
     */
    @Define
    public final static native int _HAVE_STRUCT_TERMIOS_C_ISPEED() throws NotDefinedException;

    /**
     * <b>Linux:</b>
     *
     * @return the native symbolic constant of .
     * @throws NotDefinedException if _HAVE_STRUCT_TERMIOS_C_OSPEED is not
     * defined natively.
     */
    @Define
    public final static native int _HAVE_STRUCT_TERMIOS_C_OSPEED() throws NotDefinedException;

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
    public final static native @speed_t
    int cfgetispeed(StructTermios termios);

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
    public final static native @speed_t
    int cfgetospeed(StructTermios termios);

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
    public final static native void cfsetispeed(StructTermios termios, @speed_t int speed) throws NativeErrorException;

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
    public final static native void cfsetospeed(StructTermios termios, @speed_t int speed) throws NativeErrorException;

    /**
     * <b>Non POSIX:</b> set input and output spped at the same time.
     *
     * @param termios the termios structure in which the input and output speed
     * is to be set.
     * @param speed the speed to be set in the {@code  termios} structure.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void cfsetspeed(StructTermios termios, @speed_t int speed) throws NativeErrorException;

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
    public final static native void tcgetattr(int fildes, StructTermios termios) throws NativeErrorException;

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
    public final static native @pid_t
    int tcgetsid(int fildes) throws NativeErrorException;

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
    public final static native void tcsetattr(int fildes, int optional_actions, StructTermios termios) throws NativeErrorException;




    public static class Cc_t extends NativeIntNumber {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        @SizeOf
        public final static native int sizeof();

        @AlignOf
        public final static native int alignof();

        @Unsigned
        public final static native boolean unsigned();

        public Cc_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Cc_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @cc_t
        byte getValue();

        public native void setValue(@cc_t byte value);

        /**
         * This is a control character, maybe not printable
         * @return 
         */
        @Override
        public String nativeToString() {
            return String.valueOf((char)getValue());
        }

        @Override
        public BaseDataTypes getBaseDataType() {
            return BaseDataTypes.uint8_t;
        }

        @Override
        public String nativeToHexString() {
            return nativeInt8ToHexString();
        }
    }

    /**
     * speed_t takes only symbolic constants, so the sign is of no relevance...
     */
    @speed_t
    public static class Speed_t extends NativeIntNumber {

        static String speed_tToString(int speed_t) {
            if (speed_t == B0()) {
                return "0";
            } else if (speed_t == B50()) {
                return "50";
            } else if (speed_t == B75()) {
                return "75";
            } else if (speed_t == B110()) {
                return "110";
            } else if (speed_t == B134()) {
                return "134";
            } else if (speed_t == B150()) {
                return "150";
            } else if (speed_t == B200()) {
                return "200";
            } else if (speed_t == B300()) {
                return "300";
            } else if (speed_t == B600()) {
                return "600";
            } else if (speed_t == B1200()) {
                return "1200";
            } else if (speed_t == B1800()) {
                return "1800";
            } else if (speed_t == B2400()) {
                return "2400";
            } else if (speed_t == B4800()) {
                return "4800";
            } else if (speed_t == B9600()) {
                return "9600";
            } else if (speed_t == B19200()) {
                return "19200";
            } else if (speed_t == B38400()) {
                return "38400";
            }
            try {
                if (speed_t == B57600()) {
                    return "57600";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B115200()) {
                    return "115200";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B230400()) {
                    return "230400";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B460800()) {
                    return "460800";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B500000()) {
                    return "500000";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B576000()) {
                    return "576000";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B921600()) {
                    return "921600";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B1000000()) {
                    return "1000000";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B1152000()) {
                    return "1152000";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B1500000()) {
                    return "1500000";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B2000000()) {
                    return "2000000";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B2500000()) {
                    return "2500000";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B3000000()) {
                    return "3000000";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B3500000()) {
                    return "3500000";
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if (speed_t == B4000000()) {
                    return "4000000";
                }
            } catch (NotDefinedException nde) {
            }
            return "native speed id unknown to us: " + speed_t;
        }

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        @SizeOf
        public final static native int sizeof();

        @AlignOf
        public final static native int alignof();

        @Unsigned
        public final static native boolean unsigned();

        public Speed_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Speed_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @speed_t
        int getValue();

        public native void setValue(@speed_t int value);

        @Override
        public String nativeToString() {
            return speed_tToString(getValue());
        }

        @Override
        public BaseDataTypes getBaseDataType() {
            return BaseDataTypes.uint32_t;
        }

        @Override
        public String nativeToHexString() {
            return  nativeInt32ToHexString();
        }

    }

    @tcflag_t
    public static class Tcflag_t extends NativeIntNumber {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        static public void c_cflag2String(StringBuilder sb, int c_cflag) {
            if ((CSIZE() & c_cflag) == CS5()) {
                sb.append("CS5 ");
                c_cflag &= ~CS5();
            }
            if ((CSIZE() & c_cflag) == CS6()) {
                sb.append("CS6 ");
                c_cflag &= ~CS6();
            }
            if ((CSIZE() & c_cflag) == CS7()) {
                sb.append("CS7 ");
                c_cflag &= ~CS7();
            }
            if ((CSIZE() & c_cflag) == CS8()) {
                sb.append("CS8 ");
                c_cflag &= ~CS8();
            }
            if ((CSTOPB() & c_cflag) == CSTOPB()) {
                sb.append("CSTOPB ");
                c_cflag &= ~CSTOPB();
            }
            if ((CREAD() & c_cflag) == CREAD()) {
                sb.append("CREAD ");
                c_cflag &= ~CREAD();
            }
            if ((PARENB() & c_cflag) == PARENB()) {
                sb.append("PARENB ");
                c_cflag &= ~PARENB();
            }
            if ((PARODD() & c_cflag) == PARODD()) {
                sb.append("PARODD ");
                c_cflag &= ~PARODD();
            }
            if ((HUPCL() & c_cflag) == HUPCL()) {
                sb.append("HUPCL ");
                c_cflag &= ~HUPCL();
            }
            if ((CLOCAL() & c_cflag) == CLOCAL()) {
                sb.append("CLOCAL ");
                c_cflag &= ~CLOCAL();
            }
            if ((CRTSCTS() & c_cflag) == CRTSCTS()) {
                sb.append("CRTSCTS ");
                c_cflag &= ~CRTSCTS();
            }
            try {
                if ((CMSPAR() & c_cflag) == CMSPAR()) {
                    sb.append("CMSPAR ");
                    c_cflag &= ~CMSPAR();
                }
            } catch (de.ibapl.jnhw.common.exceptions.NotDefinedException nde) {
            }
            try {
                if ((PAREXT() & c_cflag) == PAREXT()) {
                    sb.append("PAREXT ");
                    c_cflag &= ~PAREXT();
                }
            } catch (de.ibapl.jnhw.common.exceptions.NotDefinedException nde) {
            }
            if (c_cflag != 0) {
                sb.append(String.format("0x%08x", c_cflag));
            }
        }

        static public void c_iflag2String(StringBuilder sb, int c_iflag) {
            if ((BRKINT() & c_iflag) == BRKINT()) {
                sb.append("BRKINT ");
                c_iflag &= ~BRKINT();
            }
            if ((ICRNL() & c_iflag) == ICRNL()) {
                sb.append("ICRNL ");
                c_iflag &= ~ICRNL();
            }
            if ((IGNBRK() & c_iflag) == IGNBRK()) {
                sb.append("IGNBRK ");
                c_iflag &= ~IGNBRK();
            }
            if ((IGNCR() & c_iflag) == IGNCR()) {
                sb.append("IGNCR ");
                c_iflag &= ~IGNCR();
            }
            if ((IGNPAR() & c_iflag) == IGNPAR()) {
                sb.append("IGNPAR ");
                c_iflag &= ~IGNPAR();
            }
            if ((INLCR() & c_iflag) == INLCR()) {
                sb.append("INLCR ");
                c_iflag &= ~INLCR();
            }
            if ((INPCK() & c_iflag) == INPCK()) {
                sb.append("INPCK ");
                c_iflag &= ~INPCK();
            }
            if ((ISTRIP() & c_iflag) == ISTRIP()) {
                sb.append("ISTRIP ");
                c_iflag &= ~ISTRIP();
            }
            if ((IXANY() & c_iflag) == IXANY()) {
                sb.append("IXANY ");
                c_iflag &= ~IXANY();
            }
            if ((IXOFF() & c_iflag) == IXOFF()) {
                sb.append("IXOFF ");
                c_iflag &= ~IXOFF();
            }
            if ((IXON() & c_iflag) == IXON()) {
                sb.append("IXON ");
                c_iflag &= ~IXON();
            }
            try {
                if ((PARMRK() & c_iflag) == PARMRK()) {
                    sb.append("PARMRK ");
                    c_iflag &= ~PARMRK();
                }
            } catch (NotDefinedException nde) {
                //no-op PARMRK is not defined
            }
            if (c_iflag != 0) {
                sb.append(String.format("0x%08x", c_iflag));
            }
        }

        static public void c_lflag2String(StringBuilder sb, int c_lflag) {
            if ((ECHO() & c_lflag) == ECHO()) {
                sb.append("ECHO ");
                c_lflag &= ~ECHO();
            }
            if ((ECHOE() & c_lflag) == ECHOE()) {
                sb.append("ECHOE ");
                c_lflag &= ~ECHOE();
            }
            if ((ECHOK() & c_lflag) == ECHOK()) {
                sb.append("ECHOK ");
                c_lflag &= ~ECHOK();
            }
            if ((ECHONL() & c_lflag) == ECHONL()) {
                sb.append("ECHONL ");
                c_lflag &= ~ECHONL();
            }
            if ((ICANON() & c_lflag) == ICANON()) {
                sb.append("ICANON ");
                c_lflag &= ~ICANON();
            }
            if ((IEXTEN() & c_lflag) == IEXTEN()) {
                sb.append("IEXTEN ");
                c_lflag &= ~IEXTEN();
            }
            if ((ISIG() & c_lflag) == ISIG()) {
                sb.append("ISIG ");
                c_lflag &= ~ISIG();
            }
            if ((NOFLSH() & c_lflag) == NOFLSH()) {
                sb.append("NOFLSH ");
                c_lflag &= ~NOFLSH();
            }
            if ((TOSTOP() & c_lflag) == TOSTOP()) {
                sb.append("TOSTOP ");
                c_lflag &= ~TOSTOP();
            }
            if (c_lflag != 0) {
                sb.append(String.format("0x%08x", c_lflag));
            }
        }

        static public void c_oflag2String(StringBuilder sb, int c_oflag) {
            if ((OPOST() & c_oflag) == OPOST()) {
                sb.append("OPOST ");
                c_oflag &= ~OPOST();
            }
            if ((ONLCR() & c_oflag) == ONLCR()) {
                sb.append("ONLCR ");
                c_oflag &= ~ONLCR();
            }
            if ((OCRNL() & c_oflag) == OCRNL()) {
                sb.append("OCRNL ");
                c_oflag &= ~OCRNL();
            }
            if ((ONOCR() & c_oflag) == ONOCR()) {
                sb.append("ONOCR ");
                c_oflag &= ~ONOCR();
            }
            if ((ONLRET() & c_oflag) == ONLRET()) {
                sb.append("ONLRET ");
                c_oflag &= ~ONLRET();
            }
            try {
                if ((OFDEL() & c_oflag) == OFDEL()) {
                    sb.append("OFDEL ");
                    c_oflag &= ~OFDEL();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((OFILL() & c_oflag) == OFILL()) {
                    sb.append("OFILL ");
                    c_oflag &= ~OFILL();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((NLDLY() & c_oflag) == NL0()) {
                    sb.append("NL0 ");
                    c_oflag &= ~NL0();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((NLDLY() & c_oflag) == NL1()) {
                    sb.append("NL1 ");
                    c_oflag &= ~NL1();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((CRDLY() & c_oflag) == CR0()) {
                    sb.append("CR0 ");
                    c_oflag &= ~CR0();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((CRDLY() & c_oflag) == CR1()) {
                    sb.append("CR1 ");
                    c_oflag &= ~CR1();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((CRDLY() & c_oflag) == CR2()) {
                    sb.append("CR2 ");
                    c_oflag &= ~CR2();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((CRDLY() & c_oflag) == CR3()) {
                    sb.append("CR3 ");
                    c_oflag &= ~CR3();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((TABDLY() & c_oflag) == TAB0()) {
                    sb.append("TAB0 ");
                    c_oflag &= ~TAB0();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((TABDLY() & c_oflag) == TAB1()) {
                    sb.append("TAB1 ");
                    c_oflag &= ~TAB1();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((TABDLY() & c_oflag) == TAB2()) {
                    sb.append("TAB2 ");
                    c_oflag &= ~TAB2();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((TABDLY() & c_oflag) == TAB3()) {
                    sb.append("TAB3 ");
                    c_oflag &= ~TAB3();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((BSDLY() & c_oflag) == BS0()) {
                    sb.append("BS0 ");
                    c_oflag &= ~BS0();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((BSDLY() & c_oflag) == BS1()) {
                    sb.append("BS1 ");
                    c_oflag &= ~BS1();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((VTDLY() & c_oflag) == VT0()) {
                    sb.append("VT0 ");
                    c_oflag &= ~VT0();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((VTDLY() & c_oflag) == VT1()) {
                    sb.append("VT1 ");
                    c_oflag &= ~VT1();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((FFDLY() & c_oflag) == FF0()) {
                    sb.append("FF0 ");
                    c_oflag &= ~FF0();
                }
            } catch (NotDefinedException nde) {
            }
            try {
                if ((FFDLY() & c_oflag) == FF1()) {
                    sb.append("FF1 ");
                    c_oflag &= ~FF1();
                }
            } catch (NotDefinedException nde) {
            }
            if (c_oflag != 0) {
                sb.append(String.format("0x%08x", c_oflag));
            }
        }

        @SizeOf
        public final static native int sizeof();

        @AlignOf
        public final static native int alignof();

        @Unsigned
        public final static native boolean unsigned();

        public Tcflag_t(boolean clearMem) {
            super(sizeof(), clearMem);
        }

        public Tcflag_t(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public native @tcflag_t
        int getValue();

        public native void setValue(@tcflag_t int value);

        /**
         * the native value as hex string.
         *
         * @return
         */
        @Override
        public String nativeToString() {
            return nativeToHexString();
        }

        @Override
        public String nativeToHexString() {
            return nativeInt32ToHexString();
        }

        @Override
        public BaseDataTypes getBaseDataType() {
            return BaseDataTypes.uint32_t;
        }
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
     * termios}</a>.
     *
     * @author aploese
     */
    public final static class StructTermios extends Struct32 {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        @SizeOf
        public final static native int sizeof();

        @AlignOf
        public final static native int alignof();

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return the native value of c_iflag.
         */
        public native @tcflag_t
        int c_iflag();

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_iflag to be set natively.
         */
        public native void c_iflag(@tcflag_t int value);

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_oflag.
         */
        public native @tcflag_t
        int c_oflag();

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_oflag to be set natively.
         */
        public native void c_oflag(@tcflag_t int value);

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_cflag.
         */
        public native @tcflag_t
        int c_cflag();

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_cflag to be set natively.
         */
        public native void c_cflag(@tcflag_t int value);

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_lflag.
         */
        public native @tcflag_t
        int c_lflag();

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_lflag to be set natively.
         */
        public native void c_lflag(@tcflag_t int value);

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param index the index.
         * @return native value of c_cx[index].
         */
        public native @cc_t
        byte c_cc(int index);

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param index the index.
         * @param value the value of c_cx[index] to be set natively.
         */
        public native void c_cc(int index, @cc_t byte value);

        /**
         * <b>Linux:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_line.
         * @throws NoSuchNativeTypeMemberException if c_line does not exists
         */
        public native @cc_t
        byte c_line() throws NoSuchNativeTypeMemberException;

        /**
         * <b>Linux:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_line to be set natively.
         * @throws NoSuchNativeTypeMemberException if c_line does not * exists.
         */
        public native void c_line(@cc_t byte value) throws NoSuchNativeTypeMemberException;

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_ispeed.
         * @throws NoSuchNativeTypeMemberException if c_ispeed does not *
         * exists.
         */
        public native @speed_t
        int c_ispeed() throws NoSuchNativeTypeMemberException;

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_ispeed to be set natively.
         * @throws NoSuchNativeTypeMemberException if c_ispeed does not *
         * exists.
         */
        public native void c_ispeed(@speed_t int value) throws NoSuchNativeTypeMemberException;

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_ospeed.
         * @throws NoSuchNativeTypeMemberException if c_ospeed does not *
         * exists.
         */
        public native @speed_t
        int c_ospeed() throws NoSuchNativeTypeMemberException;

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_ospeed to be set natively.
         * @throws NoSuchNativeTypeMemberException if c_ospeed does not *
         * exists.
         */
        public native void c_ospeed(@speed_t int value) throws NoSuchNativeTypeMemberException;

        public StructTermios() {
            // get unitialized mem
            super(sizeof(), false);
        }

        public StructTermios(OpaqueMemory32 owner, OpaqueMemory32 prev) {
            super(owner, OpaqueMemory32.calcNextOffset(owner, prev, alignof()), sizeof());
        }

        public static String toCcName(int value) {
            if (VEOF() == value) {
                return "VEOF";
            } else if (VEOL() == value) {
                return "VEOL";
            } else if (VERASE() == value) {
                return "VERASE";
            } else if (VINTR() == value) {
                return "VINTR";
            } else if (VKILL() == value) {
                return "VKILL";
            } else if (VMIN() == value) {
                return "VMIN";
            } else if (VQUIT() == value) {
                return "VQUIT";
            } else if (VSTART() == value) {
                return "VSTART";
            } else if (VSTOP() == value) {
                return "VSTOP";
            } else if (VSUSP() == value) {
                return "VSUSP";
            } else if (VTIME() == value) {
                return "VTIME";
            } else {
                return String.valueOf(value);
            }
        }


        static public void c_cc2String(StringBuilder sb, int index, byte c_cc) {
            sb.append(String.format(", c_cc[%s] = 0x%02x", toCcName(index), c_cc));
        }

        @Override
        public String nativeToString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{c_iflag = \"");
            Tcflag_t.c_iflag2String(sb, c_iflag());
            sb.append("\", c_oflag = \"");
            Tcflag_t.c_oflag2String(sb, c_oflag());
            sb.append("\", c_cflag = \"");
            Tcflag_t.c_cflag2String(sb, c_cflag());
            sb.append("\", c_lflag = \"");
            Tcflag_t.c_lflag2String(sb, c_lflag());
            sb.append("\"");
            try {
                sb.append(String.format(", c_line = 0x%02x", c_line()));
            } catch (NoSuchNativeTypeMemberException nstme) {
            }
            try {
                sb.append(String.format(", c_ispeed = 0x%08x", c_ispeed()));
            } catch (NoSuchNativeTypeMemberException nstme) {
            }
            try {
                sb.append(String.format(", c_ospeed = 0x%08x", c_ospeed()));
            } catch (NoSuchNativeTypeMemberException nstme) {
            }
            for (int i = 0; i < NCCS(); i++) {
                c_cc2String(sb, i, c_cc(i));
            }
            sb.append("}");
            return sb.toString();

        }
    }

}
