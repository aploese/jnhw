/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2019, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.NoSuchTypeMemberException;
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.posix.sys.Types.pid_t;
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
    public final static native int B0();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 1000000 baud.
     *
     * @return the native symbolic constant of B1000000.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B1000000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 110 baud.
     *
     * @return the native symbolic constant of B110.
     */
    @Define
    public final static native int B110();

    /**
     * <b>Non POSIX:</b> <i>Baud Rate Selection</i> 115200 baud.
     *
     * @return the native symbolic constant of B115200.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B115200() throws NotDefinedException;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 1152000 baud.
     *
     * @return the native symbolic constant of B1152000.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B1152000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 1200 baud.
     *
     * @return the native symbolic constant of B1200.
     */
    @Define
    public final static native int B1200();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 134.5 baud.
     *
     * @return the native symbolic constant of B134.
     */
    @Define
    public final static native int B134();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 150 baud.
     *
     * @return the native symbolic constant of B150.
     */
    @Define
    public final static native int B150();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 1500000 baud.
     *
     * @return the native symbolic constant of B1500000.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B1500000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 1800 baud.
     *
     * @return the native symbolic constant of B1800.
     */
    @Define
    public final static native int B1800();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 19200 baud.
     *
     * @return the native symbolic constant of B19200.
     */
    @Define
    public final static native int B19200();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 200 baud.
     *
     * @return the native symbolic constant of B200.
     */
    @Define
    public final static native int B200();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 2000000 baud.
     *
     * @return the native symbolic constant of B2000000.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B2000000() throws NotDefinedException;

    /**
     * <b>Non POSIX:</b> <i>Baud Rate Selection</i> 230400 baud.
     *
     * @return the native symbolic constant of B230400.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B230400() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 2400 baud.
     *
     * @return the native symbolic constant of B2400.
     */
    @Define
    public final static native int B2400();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 2500000 baud.
     *
     * @return the native symbolic constant of B2500000.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B2500000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 300 baud.
     *
     * @return the native symbolic constant of B300.
     */
    @Define
    public final static native int B300();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 3000000 baud.
     *
     * @return the native symbolic constant of B3000000.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B3000000() throws NotDefinedException;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 3500000 baud.
     *
     * @return the native symbolic constant of B3500000.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B3500000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 38400 baud.
     *
     * @return the native symbolic constant of B38400.
     */
    @Define
    public final static native int B38400();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 4000000 baud.
     *
     * @return the native symbolic constant of B4000000.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B4000000() throws NotDefinedException;

    /**
     * <b>Linux,FreeBSD:</b> <i>Baud Rate Selection</i> 460800 baud.
     *
     * @return the native symbolic constant of B460800.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B460800() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 4800 baud.
     *
     * @return the native symbolic constant of B4800.
     */
    @Define
    public final static native int B4800();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 50 baud.
     *
     * @return the native symbolic constant of B50.
     */
    @Define
    public final static native int B50();

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 500000 baud.
     *
     * @return the native symbolic constant of B500000.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B500000() throws NotDefinedException;

    /**
     * <b>Non POSIX:</b> <i>Baud Rate Selection</i> 57600 baus
     *
     * @return the native symbolic constant of B57600.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B57600() throws NotDefinedException;

    /**
     * <b>Linux:</b> <i>Baud Rate Selection</i> 576000 baud.
     *
     * @return the native symbolic constant of B576000.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B576000() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 600 baud.
     *
     * @return the native symbolic constant of B600.
     */
    @Define
    public final static native int B600();

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 75 baud.
     *
     * @return the native symbolic constant of B75.
     */
    @Define
    public final static native int B75();

    /**
     * <b>Linux,FreeBSD:</b> <i>Baud Rate Selection</i> 921600 baud.
     *
     * @return the native symbolic constant of B921600.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int B921600() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Baud Rate Selection</i> 9600 baud.
     *
     * @return the native symbolic constant of B9600.
     */
    @Define
    public final static native int B9600();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Signal interrupt on break.
     *
     * @return the native symbolic constant of BRKINT.
     */
    @Define
    public final static native int BRKINT();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Backspace-delay type 0.
     *
     * @return the native symbolic constant of BS0.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int BS0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Backspace-delay type 1.
     *
     * @return the native symbolic constant of BS1.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int BS1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select backspace delays:
     *
     * @return the native symbolic constant of BSDLY.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int BSDLY() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Ignore modem status lines.
     *
     * @return the native symbolic constant of CLOCAL.
     */
    @Define
    public final static native int CLOCAL();

    /**
     * <b>Linux:</b> <i>Control Modes</i> Use d "stick" (mark/space) parity
     * (supported on certain serial devices).
     *
     * @return the native symbolic constant of CMSPAR.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int CMSPAR() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 0.
     *
     * @return the native symbolic constant of CR0.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int CR0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 1.
     *
     * @return the native symbolic constant of CR1.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int CR1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 2.
     *
     * @return the native symbolic constant of CR2.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int CR2() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Carriage-return delay type 3.
     *
     * @return the native symbolic constant of CR3.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int CR3() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select carriage-return delays:
     *
     * @return the native symbolic constant of CRDLY.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int CRDLY() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Enable receiver.
     *
     * @return the native symbolic constant of CREAD.
     */
    @Define
    public final static native int CREAD();

    /**
     * <b>Non POSIX:</b> <i>Control Modes</i>
     *
     * @return the native symbolic constant of .
     */
    @Define
    public final static native int CRTSCTS();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 5 bits.
     *
     * @return the native symbolic constant of CS5.
     */
    @Define
    public final static native int CS5();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 6 bits.
     *
     * @return the native symbolic constant of CS6.
     */
    @Define
    public final static native int CS6();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 7 bits.
     *
     * @return the native symbolic constant of CS7.
     */
    @Define
    public final static native int CS7();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> 8 bits.
     *
     * @return the native symbolic constant of CS8.
     */
    @Define
    public final static native int CS8();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Character size:
     *
     * @return the native symbolic constant of CSIZE.
     */
    @Define
    public final static native int CSIZE();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Send two stop bits, else one.
     *
     * @return the native symbolic constant of CSTOPB.
     */
    @Define
    public final static native int CSTOPB();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Enable echo.
     *
     * @return the native symbolic constant of ECHO.
     */
    @Define
    public final static native int ECHO();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Echo erase character as error-correcting
     * backspace.
     *
     * @return the native symbolic constant of ECHOE.
     */
    @Define
    public final static native int ECHOE();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Echo KILL.
     *
     * @return the native symbolic constant of ECHOK.
     */
    @Define
    public final static native int ECHOK();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Echo NL.
     *
     * @return the native symbolic constant of ECHONL.
     */
    @Define
    public final static native int ECHONL();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Form-feed delay type 0.
     *
     * @return the native symbolic constant of FF0.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int FF0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Form-feed delay type 1.
     *
     * @return the native symbolic constant of FF1.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int FF1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select form-feed delays:
     *
     * @return the native symbolic constant of FFDLY.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int FFDLY() throws NotDefinedException;

    public final static native boolean HAVE_TERMIOS_H();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Hang up on last close.
     *
     * @return the native symbolic constant of HUPCL.
     */
    @Define
    public final static native int HUPCL();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Canonical input (erase and kill
     * processing).
     *
     * @return the native symbolic constant of ICANON.
     */
    @Define
    public final static native int ICANON();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Map CR to NL on input.
     *
     * @return the native symbolic constant of ICRNL.
     */
    @Define
    public final static native int ICRNL();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Enable extended input character
     * processing.
     *
     * @return the native symbolic constant of IEXTEN.
     */
    @Define
    public final static native int IEXTEN();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Ignore break condition.
     *
     * @return the native symbolic constant of IGNBRK.
     */
    @Define
    public final static native int IGNBRK();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Ignore CR.
     *
     * @return the native symbolic constant of IGNCR.
     */
    @Define
    public final static native int IGNCR();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Ignore characters with parity errors.
     *
     * @return the native symbolic constant of IGNPAR.
     */
    @Define
    public final static native int IGNPAR();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Map NL to CR on input.
     *
     * @return the native symbolic constant of INLCR.
     */
    @Define
    public final static native int INLCR();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable input parity check.
     *
     * @return the native symbolic constant of INPCK.
     */
    @Define
    public final static native int INPCK();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Enable signals.
     *
     * @return the native symbolic constant of ISIG.
     */
    @Define
    public final static native int ISIG();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Strip character.
     *
     * @return the native symbolic constant of ISTRIP.
     */
    @Define
    public final static native int ISTRIP();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable any character to restart output.
     *
     * @return the native symbolic constant of IXANY.
     */
    @Define
    public final static native int IXANY();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable start/stop input control.
     *
     * @return the native symbolic constant of IXOFF.
     */
    @Define
    public final static native int IXOFF();

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Enable start/stop output control.
     *
     * @return the native symbolic constant of IXON.
     */
    @Define
    public final static native int IXON();

    /**
     * <b>POSIX:</b> Size of the array c_cc for control characters.
     *
     * @return the native symbolic constant of NCCS.
     */
    @Define
    public final static native int NCCS();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Newline type 0.
     *
     * @return the native symbolic constant of NL0.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int NL0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Newline type 1.
     *
     * @return the native symbolic constant of NL1.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int NL1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select newline delays: {@code NL0}
     * or {@code NL1}
     *
     * @return the native symbolic constant of NLDLY.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int NLDLY() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Disable flush after interrupt or quit.
     *
     * @return the native symbolic constant of NOFLSH.
     */
    @Define
    public final static native int NOFLSH();

    /**
     * <b>POSIX,XSI:</b> <i>Output Modes</i> Map CR to NL on output.
     *
     * @return the native symbolic constant of OCRNL.
     */
    @Define
    public final static native int OCRNL();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Fill is DEL.
     *
     * @return the native symbolic constant of OFDEL.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int OFDEL() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Use fill characters for delay.
     *
     * @return the native symbolic constant of OFILL.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int OFILL() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Map NL to CR-NL on output.
     *
     * @return the native symbolic constant of ONLCR.
     */
    @Define
    public final static native int ONLCR();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> NL performs CR function.
     *
     * @return the native symbolic constant of ONLRET.
     */
    @Define
    public final static native int ONLRET();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> No CR output at column 0.
     *
     * @return the native symbolic constant of ONOCR.
     */
    @Define
    public final static native int ONOCR();

    /**
     * <b>POSIX:</b> <i>Output Modes</i> Post-process output.
     *
     * @return the native symbolic constant of OPOST.
     */
    @Define
    public final static native int OPOST();

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Parity enable.
     *
     * @return the native symbolic constant of PARENB.
     */
    @Define
    public final static native int PARENB();

    /**
     * <b>???:</b> <i>Control Modes</i> ???Use d "stick" (mark/space) parity
     * (supported on certain serial devices).???
     *
     * @return the native symbolic constant of PAREXT.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int PAREXT() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Input Modes</i> Mark parity errors.
     *
     * @return the native symbolic constant of .
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int PARMRK() throws NotDefinedException;

    /**
     * <b>POSIX:</b> <i>Control Modes</i> Odd parity, else even.
     *
     * @return the native symbolic constant of PARODD.
     */
    @Define
    public final static native int PARODD();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Horizontal-tab delay type 0.
     *
     * @return the native symbolic constant of TAB0.
     */
    @Define
    public final static native int TAB0();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Horizontal-tab delay type 1.
     *
     * @return the native symbolic constant of TAB1.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int TAB1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Horizontal-tab delay type 2.
     *
     * @return the native symbolic constant of TAB2.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int TAB2() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Expand tabs to spaces.
     *
     * @return the native symbolic constant of TAB3.
     */
    @Define
    public final static native int TAB3();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select horizontal-tab delays:
     *
     * @return the native symbolic constant of TABDLY.
     */
    @Define
    public final static native int TABDLY();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Flush pending input.
     *
     * @return the native symbolic constant of TCIFLUSH.
     */
    @Define
    public final static native int TCIFLUSH();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Transmit a STOP character, intended to
     * suspend input data.
     *
     * @return the native symbolic constant of TCIOFF.
     */
    @Define
    public final static native int TCIOFF();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Flush both pending input and
     * untransmitted output.
     *
     * @return the native symbolic constant of TCIOFLUSH.
     */
    @Define
    public final static native int TCIOFLUSH();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Transmit a START character, intended to
     * restart input data.
     *
     * @return the native symbolic constant of TCION.
     */
    @Define
    public final static native int TCION();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Flush untransmitted output.
     *
     * @return the native symbolic constant of TCOFLUSH.
     */
    @Define
    public final static native int TCOFLUSH();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Suspend output.
     *
     * @return the native symbolic constant of TCOOFF.
     */
    @Define
    public final static native int TCOOFF();

    /**
     * <b>POSIX:</b> <i>Line Control</i> Restart output.
     *
     * @return the native symbolic constant of TCOON.
     */
    @Define
    public final static native int TCOON();

    /**
     * <b>POSIX:</b> <i>Attribute Selection</i> Change attributes when output
     * has drained; also flush pending input.
     *
     * @return the native symbolic constant of TCSADRAIN.
     */
    @Define
    public final static native int TCSADRAIN();

    /**
     * <b>POSIX:</b> <i>Attribute Selection</i> Change attributes when output
     * has drained.
     *
     * @return the native symbolic constant of TCSAFLUSH.
     */
    @Define
    public final static native int TCSAFLUSH();

    /**
     * <b>POSIX:</b> <i>Attribute Selection</i> Change attributes immediately.
     *
     * @return the native symbolic constant of TCSANOW.
     */
    @Define
    public final static native int TCSANOW();

    /**
     * <b>POSIX:</b> <i>Local Modes</i> Send SIGTTOU for background output.
     *
     * @return the native symbolic constant of TOSTOP.
     */
    @Define
    public final static native int TOSTOP();

    /**
     * <b>POSIX:</b> EOF character in <b>Canonical Mode</b>.
     *
     * @return the native symbolic constant of VEOF.
     */
    @Define
    public final static native int VEOF();

    /**
     * <b>POSIX:</b> EOL character in <b>Canonical Mode</b>.
     *
     * @return the native symbolic constant of VEOL.
     */
    @Define
    public final static native int VEOL();

    /**
     * <b>POSIX:</b> ERASE character in <b>Canonical Mode</b>.
     *
     * @return the native symbolic constant of VERASE.
     */
    @Define
    public final static native int VERASE();

    /**
     * <b>POSIX:</b> INTR character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VINTR.
     */
    @Define
    public final static native int VINTR();

    /**
     * <b>POSIX:</b> KILL character in <b>Canonical Mode</b>.
     *
     * @return the native symbolic constant of VKILL.
     */
    @Define
    public final static native int VKILL();

    /**
     * <b>POSIX:</b> MIN value in <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VMIN.
     */
    @Define
    public final static native int VMIN();

    /**
     * <b>POSIX:</b> QUIT character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VQUIT.
     */
    @Define
    public final static native int VQUIT();

    /**
     * <b>POSIX:</b> START character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VSTART.
     */
    @Define
    public final static native int VSTART();

    /**
     * <b>POSIX:</b> STOP character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VSTOP.
     */
    @Define
    public final static native int VSTOP();

    /**
     * <b>POSIX:</b> VSUSP character in <b>Canonical Mode</b> and
     * <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VSUSP.
     */
    @Define
    public final static native int VSUSP();

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Vertical-tab delay type 0.
     *
     * @return the native symbolic constant of VT0.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int VT0() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Vertical-tab delay type 1.
     *
     * @return the native symbolic constant of VT1.
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int VT1() throws NotDefinedException;

    /**
     * <b>POSIX.XSI:</b> <i>Output Modes</i> Select vertical-tab delays:
     *
     * @return the native symbolic constant of VTDLY.
     */
    @Define
    public final static native int VTDLY() throws NotDefinedException;

    /**
     * <b>POSIX:</b> VTIME value in <b>Non-Canonical Mode</b>.
     *
     * @return the native symbolic constant of VTIME.
     */
    @Define
    public final static native int VTIME();

    /**
     * <b>Linux:</b>
     *
     * @return the native symbolic constant of .
     * @throws de.ibapl.jnhw.NotDefinedException
     */
    @Define
    public final static native int _HAVE_STRUCT_TERMIOS_C_ISPEED() throws NotDefinedException;

    /**
     * <b>Linux:</b>
     *
     * @return the native symbolic constant of .
     * @throws de.ibapl.jnhw.NotDefinedException
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
     * type speed_t representing the input speed
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
     * type speed_t representing the output speed
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

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code typedef
     * speed_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface speed_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code typedef
     * tcflag_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface tcflag_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code typedef
     * cc_t}</a>.
     *
     * @author aploese
     */
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface cc_t {
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
     * termios}</a>.
     *
     * @author aploese
     */
    public final static class StructTermios extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        public final static native int sizeofTermios();

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
         * @throws NoSuchTypeMemberException if c_line does not exists
         */
        public native @cc_t
        byte c_line() throws NoSuchTypeMemberException;

        /**
         * <b>Linux:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_line to be set natively.
         * @throws NoSuchTypeMemberException if c_line does not         * exists.
         */
        public native void c_line(@cc_t byte value) throws NoSuchTypeMemberException;

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_ispeed.
         * @throws NoSuchTypeMemberException if c_ispeed does not         * exists.
         */
        public native @speed_t
        int c_ispeed() throws NoSuchTypeMemberException;

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_ispeed to be set natively.
         * @throws NoSuchTypeMemberException if c_ispeed does not         * exists.
         */
        public native @speed_t
        void c_ispeed(int value) throws NoSuchTypeMemberException;

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @return native value of c_ospeed.
         * @throws NoSuchTypeMemberException if c_ospeed does not         * exists.
         */
        public native @speed_t
        int c_ospeed() throws NoSuchTypeMemberException;

        /**
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">{@code structure
         * termios}</a>.
         *
         * @param value the value of c_ospeed to be set natively.
         * @throws NoSuchTypeMemberException if c_ospeed does not         * exists.
         */
        public native @speed_t
        void c_ospeed(int value) throws NoSuchTypeMemberException;

        public StructTermios() {
            // get unitialized mem
            super(sizeofTermios(), false);
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
            } catch (de.ibapl.jnhw.NotDefinedException nde) {
            }
            try {
                if ((PAREXT() & c_cflag) == PAREXT()) {
                    sb.append("PAREXT ");
                    c_cflag &= ~PAREXT();
                }
            } catch (de.ibapl.jnhw.NotDefinedException nde) {
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
            if ((TABDLY() & c_oflag) == TAB0()) {
                sb.append("TAB0 ");
                c_oflag &= ~TAB0();
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
            if ((TABDLY() & c_oflag) == TAB3()) {
                sb.append("TAB3 ");
                c_oflag &= ~TAB3();
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

        static public void c_cc2String(StringBuilder sb, int index, byte c_cc) {
            String c_ccName = String.valueOf(index);
            if (VEOF() == index) {
                c_ccName = "VEOF";
            } else if (VEOL() == index) {
                c_ccName = "VEOL";
            } else if (VERASE() == index) {
                c_ccName = "VERASE";
            } else if (VINTR() == index) {
                c_ccName = "VINTR";
            } else if (VKILL() == index) {
                c_ccName = "VKILL";
            } else if (VMIN() == index) {
                c_ccName = "VMIN";
            } else if (VQUIT() == index) {
                c_ccName = "VQUIT";
            } else if (VSTART() == index) {
                c_ccName = "VSTART";
            } else if (VSTOP() == index) {
                c_ccName = "VSTOP";
            } else if (VSUSP() == index) {
                c_ccName = "VSUSP";
            } else if (VTIME() == index) {
                c_ccName = "VTIME";
            }
            sb.append(String.format(", c_cc[%s] = 0x%02x", c_ccName, c_cc));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{c_iflag = \"");
            c_iflag2String(sb, c_iflag());
            sb.append("\", c_oflag = \"");
            c_oflag2String(sb, c_oflag());
            sb.append("\", c_cflag = \"");
            c_cflag2String(sb, c_cflag());
            sb.append("\", c_lflag = \"");
            c_lflag2String(sb, c_lflag());
            sb.append("\"");
            try {
                sb.append(String.format(", c_line = 0x%02x", c_line()));
            } catch (NoSuchTypeMemberException nstme) {
            }
            try {
                sb.append(String.format(", c_ispeed = 0x%08x", c_ispeed()));
            } catch (NoSuchTypeMemberException nstme) {
            }
            try {
                sb.append(String.format(", c_ospeed = 0x%08x", c_ospeed()));
            } catch (NoSuchTypeMemberException nstme) {
            }
            for (int i = 0; i < NCCS(); i++) {
                c_cc2String(sb, i, c_cc(i));
            }
            sb.append("}");
            return sb.toString();

        }
    }

}
