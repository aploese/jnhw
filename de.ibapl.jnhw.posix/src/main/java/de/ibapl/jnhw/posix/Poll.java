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

import de.ibapl.jnhw.common.annotation.AlignOf;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.annotation.SizeOf;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.memory.StructArray32;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.io.IOException;

/**
 * Wrapper around the {@code <poll.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">poll.h
 * - definitions for the poll() function</a>.
 *
 * @author aploese
 */
@Include("#include <poll.h>")
public final class Poll {

    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_POLL_H();

    /**
     * <b>POSIX:</b> An error has occurred (revents only).
     *
     * @return the native symbolic constant of POLLERR.
     */
    @Define()
    public final static native short POLLERR();

    /**
     * <b>POSIX:</b> Device has been disconnected (revents only).
     *
     * @return the native symbolic constant of POLLHUP.
     */
    @Define()
    public final static native short POLLHUP();

    /**
     * <b>POSIX:</b> Data other than high-priority data may be read without
     * blocking.
     *
     * @return the native symbolic constant of POLLIN.
     */
    @Define()
    public final static native short POLLIN();

    /**
     * <b>POSIX:</b> Invalid fd member (revents only).
     *
     * @return the native symbolic constant of .POLLNVAL
     */
    @Define()
    public final static native short POLLNVAL();

    /**
     * <b>POSIX:</b> High priority data may be read without blocking.
     *
     * @return the native symbolic constant of POLLOUT.
     */
    @Define()
    public final static native short POLLOUT();

    /**
     * <b>POSIX:</b> High priority data may be read without blocking.
     *
     * @return the native symbolic constant of POLLPRI.
     */
    @Define()
    public final static native short POLLPRI();

    /**
     * <b>POSIX:</b> Normal data may be read without blocking.
     *
     * @return the native symbolic constant of POLLRDBAND.
     */
    @Define()
    public final static native short POLLRDBAND();

    /**
     * <b>POSIX:</b> Normal data may be read without blocking.
     *
     * @return the native symbolic constant of POLLRDNORM.
     */
    @Define()
    public final static native short POLLRDNORM();

    /**
     * <b>POSIX:</b> Priority data may be written.
     *
     * @return the native symbolic constant of POLLWRBAND.
     */
    @Define()
    public final static native short POLLWRBAND();

    /**
     * <b>POSIX:</b> Equivalent to POLLOUT.
     *
     * @return the native symbolic constant of POLLWRNORM.
     */
    @Define()
    public final static native short POLLWRNORM();

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/poll.html">poll
     * - input/output multiplexing</a>.
     *
     * @param fds an array of pollfd.
     * @param timeout the timeout in milliseconds.
     * @return the native result.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int poll(PollFds fds, int timeout) throws NativeErrorException;

    /**
     * <b>POSIX:</b>
     * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/functions/poll.html">poll
     * - input/output multiplexing</a>.
     *
     * @param fd a single pollfd.
     * @param timeout the timeout in milliseconds.
     * @return the native result.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int poll(PollFd fd, int timeout) throws NativeErrorException;


    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
     * pollfd}</a>.
     *
     */
    public final static class PollFd extends Struct32 {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        /**
         * Get the real size of struct pollfd natively.
         *
         * @return the native value sizeof(struct pollfd).
         */
        @SizeOf
        public static native int sizeof();
        
        @AlignOf
        public static native int alignof();

        public PollFd(OpaqueMemory32 owner, int offset) {
            super(owner, offset, sizeof());
        }

        public PollFd() {
            super(sizeof(), false);
        }

        /**
         * The input event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @return the native value of events;
         */
        public native short events();

        /**
         * The input event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @param events the value of events to be set natively.
         */
        public native void events(short events);

        /**
         * The file descriptor being polled.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @return the native value of fd;
         */
        public native int fd();

        /**
         * The file descriptor being polled.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @param fd the value of fd to be set natively.
         */
        public native void fd(int fd);

        /**
         * The output event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @return the native value of revents;
         */
        public native short revents();

        /**
         * The output event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @param revents the value of revents to be set natively.
         */
        public native void revents(short revents);

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendIntMember("fd", fd());
            jsb.appendMember("events", "[", (sbu)->event2String(sbu, events()),"]");
            jsb.appendMember("revents", "[", (sbu)->event2String(sbu, revents()),"]");
            jsb.close();
        }

        private static void event2String(Appendable sb, short event) throws IOException {
            if ((POLLIN() & event) == POLLIN()) {
                sb.append("POLLIN ");
                event &= ~POLLIN();
            }
            if ((POLLPRI() & event) == POLLPRI()) {
                sb.append("POLLPRI ");
                event &= ~POLLPRI();
            }
            if ((POLLOUT() & event) == POLLOUT()) {
                sb.append("POLLOUT ");
                event &= ~POLLOUT();
            }
            if ((POLLRDNORM() & event) == POLLRDNORM()) {
                sb.append("POLLRDNORM ");
                event &= ~POLLRDNORM();
            }
            if ((POLLRDBAND() & event) == POLLRDBAND()) {
                sb.append("POLLRDBAND ");
                event &= ~POLLRDBAND();
            }
            if ((POLLWRNORM() & event) == POLLWRNORM()) {
                sb.append("POLLWRNORM ");
                event &= ~POLLWRNORM();
            }
            if ((POLLWRBAND() & event) == POLLWRBAND()) {
                sb.append("POLLWRBAND ");
                event &= ~POLLWRBAND();
            }
            if ((POLLERR() & event) == POLLERR()) {
                sb.append("POLLERR ");
                event &= ~POLLERR();
            }
            if ((POLLHUP() & event) == POLLHUP()) {
                sb.append("POLLHUP ");
                event &= ~POLLHUP();
            }
            if ((POLLIN() & event) == POLLIN()) {
                sb.append("POLLIN ");
                event &= ~POLLIN();
            }
            if ((POLLNVAL() & event) == POLLNVAL()) {
                sb.append("POLLNVAL ");
                event &= ~POLLNVAL();
            }
            if (event != 0) {
                sb.append(String.format("0x%04x", event));
            }
        }
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
     * pollfd}</a>.
     *
     */
    public static class PollFds extends StructArray32<PollFd> {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        public PollFds(int arraylength) {
            //get uninitialized mem we need to set this anyway ...
            super(new PollFd[arraylength], PollFds::createAtOffset, PollFd.sizeof(), false);
        }

        public PollFds(OpaqueMemory32 parent, int offset, int arraylength) {
            //get uninitialized mem we need to set this anyway ...
            super(parent, offset, new PollFd[arraylength], PollFds::createAtOffset, PollFd.sizeof(), false);
        }

        public PollFds(OpaqueMemory32 parent, OpaqueMemory32 prev, int arraylength) {
            //get uninitialized mem we need to set this anyway ...
            this(parent, OpaqueMemory32.calcNextOffset(parent, prev, Poll.PollFd.alignof()), arraylength);
        }

        private static PollFd createAtOffset(OpaqueMemory32 parent, int offset) {
            return new PollFd(parent, offset);
        }

    }

}
