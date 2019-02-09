/*-
 * #%L
 * SPSW API
 * %%
 * Copyright (C) 2009 - 2018 Arne Plöse
 * %%
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is
 * available at https://www.gnu.org/software/classpath/license.html.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * #L%
 */
package de.ibapl.jnhw.posix;

import de.ibapl.jnhw.Define;
import de.ibapl.jnhw.Include;
import de.ibapl.jnhw.LibJnhwPosixLoader;
import de.ibapl.jnhw.NativeErrorException;
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.OpaqueMemory;

/**
 *
 * Wrapper around POSIX termios.h with optional,os and architecture extensions.
 * See specs at: <a href=
 * "http://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html">http://pubs.opengroup.org/onlinepubs/9699919799/basedefs/termios.h.html</a>
 *
 * @author aploese
 *
 */
@Include("#include <termios.h>")
public final class Termios extends LibJnhwPosixLoader {

        public final static native boolean HAVE_TERMIOS_H();

    /**
     * Wrapper for the termios struct.
     *
     * @author aploese
     *
     */
    public static class StructTermios extends OpaqueMemory {

        public final static native int sizeofTermios();

        static native int c_iflag(long baseAddress);

        static native void c_iflag(long baseAddress, int c_iflag);

        static native int c_oflag(long baseAddress);

        static native void c_oflag(long baseAddress, int c_oflag);

        static native int c_cflag(long baseAddress);

        static native void c_cflag(long baseAddress, int c_cflag);

        static native int c_lflag(long baseAddress);

        static native void c_lflag(long baseAddress, int c_lflag);

        static native byte c_cc(long baseAddress, int index);

        static native void c_cc(long baseAddress, int index, byte value);
        
        public StructTermios() {
            // get unitialized mem
            super(sizeofTermios(), false);
        }

        public final int c_iflag() {
            return StructTermios.c_iflag(baseAddress);
        }

        public final void c_iflag(int c_iflag) {
            StructTermios.c_iflag(baseAddress, c_iflag);
        }

        public final int c_oflag() {
            return StructTermios.c_oflag(baseAddress);
        }

        public final void c_oflag(int c_oflag) {
            StructTermios.c_oflag(baseAddress, c_oflag);
        }

        public final int c_cflag() {
            return StructTermios.c_cflag(baseAddress);
        }

        public final void c_cflag(int c_cflag) {
            StructTermios.c_cflag(baseAddress, c_cflag);
        }

        public final int c_lflag() {
            return StructTermios.c_lflag(baseAddress);
        }

        public final void c_lflag(int c_lflag) {
             StructTermios.c_lflag(baseAddress, c_lflag);
        }

        public final byte c_cc(int index) {
            return StructTermios.c_cc(baseAddress, index);
        }

        public final void c_cc(int index, byte value) {
             StructTermios.c_cc(baseAddress, index, value);
        }

    }

    @Define
    public final static native int B0();

    @Define
    public final static native int B50();

    @Define
    public final static native int B75();

    @Define
    public final static native int B110();

    @Define
    public final static native int B134();

    @Define
    public final static native int B150();

    @Define
    public final static native int B200();

    @Define
    public final static native int B300();

    @Define
    public final static native int B600();

    @Define
    public final static native int B1200();

    @Define
    public final static native int B1800();

    @Define
    public final static native int B2400();

    @Define
    public final static native int B4800();

    @Define
    public final static native int B9600();

    @Define
    public final static native int B19200();

    @Define
    public final static native int B38400();

    @Define
    public final static native int B57600() throws NotDefinedException;

    @Define
    public final static native int B115200() throws NotDefinedException;

    @Define
    public final static native int B230400() throws NotDefinedException;

    @Define
    public final static native int B460800() throws NotDefinedException;

    @Define
    public final static native int B500000() throws NotDefinedException;

    @Define
    public final static native int B576000() throws NotDefinedException;

    @Define
    public final static native int B921600() throws NotDefinedException;

    @Define
    public final static native int B1000000() throws NotDefinedException;

    @Define
    public final static native int B1152000() throws NotDefinedException;

    @Define
    public final static native int B1500000() throws NotDefinedException;

    @Define
    public final static native int B2000000() throws NotDefinedException;

    @Define
    public final static native int B2500000() throws NotDefinedException;

    @Define
    public final static native int B3000000() throws NotDefinedException;

    @Define
    public final static native int B3500000() throws NotDefinedException;

    @Define
    public final static native int B4000000() throws NotDefinedException;

    @Define
    public final static native int CLOCAL();

    @Define
    public final static native int CMSPAR() throws NotDefinedException;

    @Define
    public final static native int CREAD();

    @Define
    public final static native int CRTSCTS();

    @Define
    public final static native int CS5();

    @Define
    public final static native int CS6();

    @Define
    public final static native int CS7();

    @Define
    public final static native int CS8();

    @Define
    public final static native int CSIZE();

    @Define
    public final static native int CSTOPB();

    @Define
    public final static native int INPCK();

    @Define
    public final static native int IXOFF();

    @Define
    public final static native int IXON();

    @Define
    public final static native int PARENB();

    @Define
    public final static native int PAREXT() throws NotDefinedException;

    @Define
    public final static native int PARODD();

    @Define
    public final static native int TCIOFLUSH();

    @Define
    public final static native int TCSANOW();

    @Define
    public final static native int VMIN();

    @Define
    public final static native int VSTART();

    @Define
    public final static native int VSTOP();

    @Define
    public final static native int VTIME();
    
    @Define
    public final static native int NCCS();

    private static native int cfgetispeed(long termiosAddress);

    public final static int cfgetispeed(StructTermios termios) {
        return cfgetispeed(termios.baseAddress);
    }

    private static native int cfgetospeed(long termiosAddress);

    public final static int cfgetospeed(StructTermios termios) {
        return cfgetospeed(termios.baseAddress);
    }

    private static native int cfsetispeed(long termiosAddress, int speed) throws NativeErrorException;

    public final static int cfsetispeed(StructTermios termios, int speed) throws NativeErrorException {
        return cfsetispeed(termios.baseAddress, speed);
    }

    private static native int cfsetospeed(long termiosAddress, int speed) throws NativeErrorException;

    public final static int cfsetospeed(StructTermios termios, int speed) throws NativeErrorException {
        return cfsetospeed(termios.baseAddress, speed);
    }

    public final static native int tcdrain(int fildes) throws NativeErrorException;

    public final static native int tcflush(int fildes, int queue_selector) throws NativeErrorException;

    private static native int tcgetattr(int fildes, long termiosAddress) throws NativeErrorException;
    
    public final static int tcgetattr(int fildes, StructTermios termios) throws NativeErrorException {
        return tcgetattr(fildes, termios.baseAddress);
    }

    public final static native int tcsendbreak(int fildes, int duration) throws NativeErrorException;

    private static native int tcsetattr(int fildes, int optional_actions, long termiosAddress) throws NativeErrorException;
    
    public final static int tcsetattr(int fildes, int optional_actions, StructTermios termios) throws NativeErrorException {
        return tcsetattr(fildes, optional_actions, termios.baseAddress);
    }
    
    private static native int cfsetspeed(long termiosAddress, int speed) throws NativeErrorException;

    public final static  int cfsetspeed(StructTermios termios, int speed) throws NativeErrorException {
        return cfsetspeed(termios.baseAddress, speed);
    }

}
