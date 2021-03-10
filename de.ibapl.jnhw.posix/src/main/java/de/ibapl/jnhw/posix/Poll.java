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
import de.ibapl.jnhw.common.memory.AbstractNativeMemory;
import de.ibapl.jnhw.common.memory.Struct32;
import de.ibapl.jnhw.common.memory.StructArray32;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.memory.layout.StructLayout;
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
     *
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        LibJnhwPosixLoader.touch();

        HAVE_POLL_H = false;

        POLLERR = 0;
        POLLHUP = 0;
        POLLIN = 0;
        POLLNVAL = 0;
        POLLOUT = 0;
        POLLPRI = 0;
        POLLRDBAND = 0;
        POLLRDNORM = 0;
        POLLWRBAND = 0;
        POLLWRNORM = 0;

        initFields();
    }

    private static native void initFields();

    public final static boolean HAVE_POLL_H;

    /**
     * <b>POSIX:</b> An error has occurred (revents only).
     *
     */
    @Define()
    public final static short POLLERR;

    /**
     * <b>POSIX:</b> Device has been disconnected (revents only).
     *
     */
    @Define()
    public final static short POLLHUP;

    /**
     * <b>POSIX:</b> Data other than high-priority data may be read without
     * blocking.
     *
     */
    @Define()
    public final static short POLLIN;

    /**
     * <b>POSIX:</b> Invalid fd member (revents only).
     *
     */
    @Define()
    public final static short POLLNVAL;

    /**
     * <b>POSIX:</b> High priority data may be read without blocking.
     *
     */
    @Define()
    public final static short POLLOUT;

    /**
     * <b>POSIX:</b> High priority data may be read without blocking.
     *
     */
    @Define()
    public final static short POLLPRI;

    /**
     * <b>POSIX:</b> Normal data may be read without blocking.
     *
     */
    @Define()
    public final static short POLLRDBAND;

    /**
     * <b>POSIX:</b> Normal data may be read without blocking.
     *
     */
    @Define()
    public final static short POLLRDNORM;

    /**
     * <b>POSIX:</b> Priority data may be written.
     *
     */
    @Define()
    public final static short POLLWRBAND;

    /**
     * <b>POSIX:</b> Equivalent to POLLOUT.
     *
     */
    @Define()
    public final static short POLLWRNORM;

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

        public static class Layout extends StructLayout {

            public final long fd;
            public final long events;
            public final long revents;
            public final Alignment alignment;
            public final int sizeof;

            public Layout(long sizeof, int alignof) {
                super();
                fd = -1;
                events = -1;
                revents = -1;
                this.sizeof = (int) sizeof;
                this.alignment = Alignment.fromAlignof(alignof);
            }

            @Override
            public int getSizeof() {
                return sizeof;
            }

            @Override
            public Alignment getAlignment() {
                return alignment;
            }
        }

        private static native Layout native2Layout(Class<Layout> layoutClass);

        public final static Layout LAYOUT;

        static {
            LibJnhwPosixLoader.touch();
            LAYOUT = native2Layout(Layout.class);
        }

        public PollFd(AbstractNativeMemory owner, long offset) {
            this(owner, offset, null);
        }

        public PollFd() {
            this(null, 0, null);
        }

        public PollFd(AbstractNativeMemory parent, long offset, Byte setMem) {
            super(parent, offset, LAYOUT.sizeof, setMem);
        }

        /**
         * The input event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @return the native value of events;
         */
        public short events() {
            return MEM_ACCESS.uint16_t(this, LAYOUT.events);
        }

        /**
         * The input event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @param events the value of events to be set natively.
         */
        public void events(short events) {
            MEM_ACCESS.uint16_t(this, LAYOUT.events, events);
        }

        /**
         * The file descriptor being polled.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @return the native value of fd;
         */
        public int fd() {
            return MEM_ACCESS.int32_t(this, LAYOUT.fd);
        }

        /**
         * The file descriptor being polled.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @param fd the value of fd to be set natively.
         */
        public void fd(int fd) {
            MEM_ACCESS.int32_t(this, LAYOUT.fd, fd);
        }

        /**
         * The output event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @return the native value of revents;
         */
        public short revents() {
            return MEM_ACCESS.uint16_t(this, LAYOUT.revents);
        }

        /**
         * The output event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @param revents the value of revents to be set natively.
         */
        public void revents(short revents) {
            MEM_ACCESS.uint16_t(this, LAYOUT.revents, revents);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendIntMember("fd", fd());
            jsb.appendMember("events", "[", (sbu) -> event2String(sbu, events()), "]");
            jsb.appendMember("revents", "[", (sbu) -> event2String(sbu, revents()), "]");
            jsb.close();
        }

        private static void event2String(Appendable sb, short event) throws IOException {
            if ((POLLIN & event) == POLLIN) {
                sb.append("POLLIN ");
                event &= ~POLLIN;
            }
            if ((POLLPRI & event) == POLLPRI) {
                sb.append("POLLPRI ");
                event &= ~POLLPRI;
            }
            if ((POLLOUT & event) == POLLOUT) {
                sb.append("POLLOUT ");
                event &= ~POLLOUT;
            }
            if ((POLLRDNORM & event) == POLLRDNORM) {
                sb.append("POLLRDNORM ");
                event &= ~POLLRDNORM;
            }
            if ((POLLRDBAND & event) == POLLRDBAND) {
                sb.append("POLLRDBAND ");
                event &= ~POLLRDBAND;
            }
            if ((POLLWRNORM & event) == POLLWRNORM) {
                sb.append("POLLWRNORM ");
                event &= ~POLLWRNORM;
            }
            if ((POLLWRBAND & event) == POLLWRBAND) {
                sb.append("POLLWRBAND ");
                event &= ~POLLWRBAND;
            }
            if ((POLLERR & event) == POLLERR) {
                sb.append("POLLERR ");
                event &= ~POLLERR;
            }
            if ((POLLHUP & event) == POLLHUP) {
                sb.append("POLLHUP ");
                event &= ~POLLHUP;
            }
            if ((POLLIN & event) == POLLIN) {
                sb.append("POLLIN ");
                event &= ~POLLIN;
            }
            if ((POLLNVAL & event) == POLLNVAL) {
                sb.append("POLLNVAL ");
                event &= ~POLLNVAL;
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
            super(new PollFd[arraylength], PollFds::createAtOffset, PollFd.LAYOUT.sizeof, MEM_UNINITIALIZED);
        }

        public PollFds(AbstractNativeMemory parent, long offset, int arraylength) {
            //get uninitialized mem we need to set this anyway ...
            super(parent, offset, new PollFd[arraylength], PollFds::createAtOffset, PollFd.LAYOUT.sizeof, MEM_UNINITIALIZED);
        }

        private static PollFd createAtOffset(AbstractNativeMemory parent, long offset) {
            return new PollFd(parent, offset);
        }

    }

}
