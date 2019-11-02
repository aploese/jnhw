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
import de.ibapl.jnhw.OpaqueMemory;
import de.ibapl.jnhw.StructArray;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Include("#include <poll.h>")
public final class Poll {
    
    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    public static @interface nfds_t {
    }


    /**
     * Make sure the native lib is loaded
     */
    static {
        LibJnhwPosixLoader.touch();
    }

    public final static native boolean HAVE_POLL_H();

    public final static class PollFd extends OpaqueMemory {

        /**
         * Make sure the native lib is loaded ... this class is static, so we
         * have to
         */
        static {
            LibJnhwPosixLoader.touch();
        }

        public static native int sizeofPollFd();

        public native short events();

        public PollFd(OpaqueMemory owner, int offset) {
            super(owner, offset, sizeofPollFd());
        }

        public native void events(short events);

        public native int fd();

        public native void fd(int fd);

        public native short revents();

        public native void revents(short revents);

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{fd : ").append(fd());
            sb.append(", events : \"");
            event2String(sb, events());
            sb.append("\", revents :\"");
            event2String(sb, revents());
            sb.append("\"}");
            return sb.toString();
        }

        private static void event2String(StringBuilder sb, short event) {
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

    public static class PollFds extends StructArray<PollFd> {

        public PollFds(int arraylength) {
            //get uninitialized mem we need to set this anyway ...
            super(new PollFd[arraylength], PollFd.sizeofPollFd(), false);
        }

        @Override
        protected PollFd createElementAtOffset(int offset) {
            return new PollFd(this, offset);
        }

    }

    public final static native int poll(StructArray<PollFd> fds, int timeout) throws NativeErrorException;

    @Define()
    public final static native short POLLERR();

    @Define()
    public final static native short POLLHUP();

    @Define()
    public final static native short POLLIN();

    @Define()
    public final static native short POLLNVAL();

    @Define()
    public final static native short POLLOUT();

    @Define()
    public final static native short POLLPRI();

    @Define()
    public final static native short POLLRDBAND();

    @Define()
    public final static native short POLLRDNORM();

    @Define()
    public final static native short POLLWRBAND();

    @Define()
    public final static native short POLLWRNORM();

}
