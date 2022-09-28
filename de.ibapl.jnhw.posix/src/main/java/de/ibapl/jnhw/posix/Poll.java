/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2022, Arne Plöse and individual contributors as indicated
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

import de.ibapl.jnhw.annotation.posix.poll.nfds_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.datatypes.MultiarchTupelBuilder;
import de.ibapl.jnhw.common.downcall.wrapper.JnhwMh_sI___A_uL_sI;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.AsUnsignedLong;
import de.ibapl.jnhw.common.memory.MemoryArray;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Struct;
import de.ibapl.jnhw.common.memory.layout.Alignment;
import de.ibapl.jnhw.common.util.JsonStringBuilder;
import de.ibapl.jnhw.util.posix.PosixDataType;
import java.io.IOException;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

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

    public static interface BsdDefines {

        public final static short POLLERR = 0x0008;
        public final static short POLLHUP = 0x0010;
        public final static short POLLIN = 0x0001;
        public final static short POLLNVAL = 0x0020;
        public final static short POLLOUT = 0x0004;
        public final static short POLLPRI = 0x0002;
        public final static short POLLRDBAND = 0x0080;
        public final static short POLLRDNORM = 0x0040;
        public final static short POLLWRBAND = 0x0100;
        public final static short POLLWRNORM = 0x0004;
    }

    public static interface FreeBsdDefines extends BsdDefines {

    }

    public static interface OpenBsdDefines extends BsdDefines {

    }

    public static interface DarwinDefines extends BsdDefines {

    }

    public static interface Linux_Mips_Mips64_Defines {

        public final static short POLLWRBAND = 0x0100;
        public final static short POLLWRNORM = 0x0004;
    }

    public static interface Linux_NON_Mips_Mips64_Defines {

        public final static short POLLWRBAND = 0x0200;
        public final static short POLLWRNORM = 0x0100;
    }

    public static interface LinuxDefines {

        public final static short POLLERR = 0x0008;
        public final static short POLLHUP = 0x0010;
        public final static short POLLIN = 0x0001;
        public final static short POLLNVAL = 0x0020;
        public final static short POLLOUT = 0x0004;
        public final static short POLLPRI = 0x0002;
        public final static short POLLRDBAND = 0x0080;
        public final static short POLLRDNORM = 0x0040;
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
     * pollfd}</a>.
     *
     */
    public final static class PollFd extends Struct {

        public final static Alignment alignof = Alignment.AT_4;
        public final static long offsetof_Events = 4;
        public final static long offsetof_Fd = 0;
        public final static long offsetof_Revents = 6;
        public final static int sizeof = 8;

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

        public PollFd(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset, PollFd.sizeof);
        }

        /**
         * The input event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @return the native value of events;
         */
        public short events() {
            return MEM_ACCESS.uint16_t(memorySegment, PollFd.offsetof_Events);
        }

        /**
         * The input event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @param events the value of events to be set natively.
         */
        public void events(short events) {
            MEM_ACCESS.uint16_t(memorySegment, PollFd.offsetof_Events, events);
        }

        /**
         * The file descriptor being polled.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @return the native value of fd;
         */
        public int fd() {
            return MEM_ACCESS.int32_t(memorySegment, PollFd.offsetof_Fd);
        }

        /**
         * The file descriptor being polled.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @param fd the value of fd to be set natively.
         */
        public void fd(int fd) {
            MEM_ACCESS.int32_t(memorySegment, PollFd.offsetof_Fd, fd);
        }

        @Override
        public void nativeToString(Appendable sb, String indentPrefix, String indent) throws IOException {
            JsonStringBuilder jsb = new JsonStringBuilder(sb, indentPrefix, indent);
            jsb.appendIntMember("fd", fd());
            jsb.appendMember("events", "[", (sbu) -> event2String(sbu, events()), "]");
            jsb.appendMember("revents", "[", (sbu) -> event2String(sbu, revents()), "]");
            jsb.close();
        }

        /**
         * The output event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @return the native value of revents;
         */
        public short revents() {
            return MEM_ACCESS.uint16_t(memorySegment, PollFd.offsetof_Revents);
        }

        /**
         * The output event flags.
         * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
         * pollfd}</a>.
         *
         * @param revents the value of revents to be set natively.
         */
        public void revents(short revents) {
            MEM_ACCESS.uint16_t(memorySegment, PollFd.offsetof_Revents, revents);
        }
    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
     * pollfd}</a>.
     *
     */
    @nfds_t
    public static class Nfds_t extends AsUnsignedLong {

        public final static Nfds_t allocateNative(ResourceScope scope) {
            return new Nfds_t(MemorySegment.allocateNative(PosixDataType.nfds_t.SIZE_OF, scope), 0);
        }

        public Nfds_t(MemorySegment memorySegment, int offset) {
            super(PosixDataType.nfds_t, memorySegment, offset);
        }

    }

    /**
     * <b>POSIX:</b> <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/poll.h.html">{@code structure
     * pollfd}</a>.
     *
     */
    public final static class PollFds extends MemoryArray<PollFd> {

        private static PollFd createAtOffset(MemorySegment memorySegment, long elementoffset, int index) {
            return new PollFd(memorySegment, elementoffset);
        }

        public final static PollFds allocateNative(ResourceScope scope, int arraylength) {
            return new PollFds(MemorySegment.allocateNative(PollFd.sizeof * arraylength, scope), 0, arraylength);
        }

        public final static PollFds wrap(OpaqueMemory mem, long offset, int arraylength) {
            return new PollFds(OpaqueMemory.sliceMemorySegment(mem, offset, PollFd.sizeof * arraylength), 0, arraylength);
        }

        public PollFds(MemorySegment memorySegment, long offset, int arraylength) {
            super(memorySegment, offset, new PollFd[arraylength], PollFds::createAtOffset, PollFd.sizeof);
        }

    }

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
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX:
                HAVE_POLL_H = true;
                POLLERR = LinuxDefines.POLLERR;
                POLLHUP = LinuxDefines.POLLHUP;
                POLLIN = LinuxDefines.POLLIN;
                POLLNVAL = LinuxDefines.POLLNVAL;
                POLLOUT = LinuxDefines.POLLOUT;
                POLLPRI = LinuxDefines.POLLPRI;
                POLLRDBAND = LinuxDefines.POLLRDBAND;
                POLLRDNORM = LinuxDefines.POLLRDNORM;
                switch (MultiarchTupelBuilder.getArch()) {
                    case MIPS:
                    case MIPS_64:
                        POLLWRBAND = Linux_Mips_Mips64_Defines.POLLWRBAND;
                        POLLWRNORM = Linux_Mips_Mips64_Defines.POLLWRNORM;
                        break;
                    default:
                        POLLWRBAND = Linux_NON_Mips_Mips64_Defines.POLLWRBAND;
                        POLLWRNORM = Linux_NON_Mips_Mips64_Defines.POLLWRNORM;
                }
                break;
            case DARWIN:
            case FREE_BSD:
            case OPEN_BSD:
                HAVE_POLL_H = true;
                POLLERR = BsdDefines.POLLERR;
                POLLHUP = BsdDefines.POLLHUP;
                POLLIN = BsdDefines.POLLIN;
                POLLNVAL = BsdDefines.POLLNVAL;
                POLLOUT = BsdDefines.POLLOUT;
                POLLPRI = BsdDefines.POLLPRI;
                POLLRDBAND = BsdDefines.POLLRDBAND;
                POLLRDNORM = BsdDefines.POLLRDNORM;
                POLLWRBAND = BsdDefines.POLLWRBAND;
                POLLWRNORM = BsdDefines.POLLWRNORM;
                break;
            default:
                throw new NoClassDefFoundError("No poll.h defines for " + MultiarchTupelBuilder.getMultiarch());
        }
    }

    private final static JnhwMh_sI___A_uL_sI poll = JnhwMh_sI___A_uL_sI.of(
            "poll",
            BaseDataType.C_int,
            PosixDataType.struct_pollfd_array,
            PosixDataType.nfds_t,
            BaseDataType.C_int);

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
    public final static int poll(PollFd fd, int timeout) throws NativeErrorException {
        final int result = poll.invoke_sI___P_uL_sI(fd, 1, timeout);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

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
    public final static int poll(PollFds fds, int timeout) throws NativeErrorException {
        final int result = poll.invoke_sI___P_uL_sI(fds, fds.length(), timeout);
        if (result == -1) {
            throw new NativeErrorException(Errno.errno());
        } else {
            return result;
        }
    }

}
