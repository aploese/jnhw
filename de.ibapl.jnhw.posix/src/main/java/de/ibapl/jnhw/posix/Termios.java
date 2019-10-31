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
import de.ibapl.jnhw.NotDefinedException;
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
public final class Termios {

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface speed_t {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface tcflag_t {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface cc_t {
    }

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_TERMIOS_H();

    /**
     * Wrapper for the termios struct.
     *
     * @author aploese
     *
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

        public native @tcflag_t int c_iflag();

        public native void c_iflag(@tcflag_t int c_iflag);

        public native @tcflag_t int c_oflag();

        public native void c_oflag(@tcflag_t int c_oflag);

        public native @tcflag_t int c_cflag();

        public native void c_cflag(@tcflag_t int c_cflag);

        public native @tcflag_t int c_lflag();

        public native void c_lflag(@tcflag_t int c_lflag);

        public native @cc_t byte c_cc(int index);

        public native void c_cc(int index, @cc_t byte value);

        public native @speed_t
        int c_ispeed() throws NoSuchMethodException;

        public native @speed_t
        void c_ispeed(int speed) throws NoSuchMethodException;

        public native @speed_t
        int c_ospeed() throws NoSuchMethodException;

        public native @speed_t
        void c_ospeed(int speed) throws NoSuchMethodException;

        public StructTermios() {
            // get unitialized mem
            super(sizeofTermios(), false);
        }

        static public void c_cflag2String(StringBuilder sb, int c_cflag) {
            if ((CSIZE() & c_cflag) == CS5()) {
                sb.append("CS5 ");
                c_cflag &= ~CS5();
            } else if ((CSIZE() & c_cflag) == CS6()) {
                sb.append("CS6 ");
                c_cflag &= ~CS6();
            } else if ((CSIZE() & c_cflag) == CS7()) {
                sb.append("CS7 ");
                c_cflag &= ~CS7();
            } else if ((CSIZE() & c_cflag) == CS8()) {
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
            if ((CLOCAL() & c_cflag) == CLOCAL()) {
                sb.append("CLOCAL ");
                c_cflag &= ~CLOCAL();
            }
            if ((CRTSCTS() & c_cflag) == CRTSCTS()) {
                sb.append("CRTSCTS ");
                c_cflag &= ~CRTSCTS();
            }
            if (c_cflag != 0) {
                sb.append(String.format("0x%08x", c_cflag));
            }
        }

        static public void c_iflag2String(StringBuilder sb, int c_iflag) {
            if ((INPCK() & c_iflag) == INPCK()) {
                sb.append("INPCK ");
                c_iflag &= ~INPCK();
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
            if (c_lflag != 0) {
                sb.append(String.format("0x%08x", c_lflag));
            }
        }

        static public void c_oflag2String(StringBuilder sb, int c_oflag) {
            if (c_oflag != 0) {
                sb.append(String.format("0x%08x", c_oflag));
            }
        }

        static public void c_cc2String(StringBuilder sb, int index, byte c_cc) {
            String c_ccName = String.valueOf(index);
            if (VTIME() == index) {
                c_ccName = "VTIME";
            } else if (VMIN() == index) {
                c_ccName = "VMIN";
            } else if (VSTART() == index) {
                c_ccName = "VSTART";
            } else if (VSTOP() == index) {
                c_ccName = "VSTOP";
            }
            sb.append(String.format("\", c_cc[%s] = 0x%02x", c_ccName, c_cc));
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
            sb.append("\", c_line = \"");
            for (int i = 0; i < NCCS(); i++) {
                c_cc2String(sb, i, c_cc(i));
            }
            sb.append("}");
            return sb.toString();

        }
    }

    @Define
    public final static native int _HAVE_STRUCT_TERMIOS_C_ISPEED() throws NotDefinedException;

    @Define
    public final static native int _HAVE_STRUCT_TERMIOS_C_OSPEED() throws NotDefinedException;

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
    public final static native int PARMRK() throws NotDefinedException;

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

    public final static native @speed_t
    int cfgetispeed(StructTermios termios);

    public final static native @speed_t
    int cfgetospeed(StructTermios termios);

    public final static native int cfsetispeed(StructTermios termios, @speed_t int speed) throws NativeErrorException;

    public final static native int cfsetospeed(StructTermios termios, @speed_t int speed) throws NativeErrorException;

    public final static native int tcdrain(int fildes) throws NativeErrorException;

    public final static native int tcflush(int fildes, int queue_selector) throws NativeErrorException;

    public final static native int tcgetattr(int fildes, StructTermios termios) throws NativeErrorException;

    public final static native int tcsendbreak(int fildes, int duration) throws NativeErrorException;

    public final static native int tcsetattr(int fildes, int optional_actions, StructTermios termios) throws NativeErrorException;

    public final static native int cfsetspeed(StructTermios termios, @speed_t int speed) throws NativeErrorException;

}
