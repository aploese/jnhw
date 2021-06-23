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
package de.ibapl.jnhw.linux.sys;

import de.ibapl.jnhw.annotation.linux.sys.eventfd_t;
import de.ibapl.jnhw.common.annotation.Define;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.libloader.MultiarchInfo;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;

/**
 * Wrapper around the linux {@code <sys/eventfd.h>} header. execute
 * {@code  man eventfd} on linux to get more informations.
 *
 * @author aploese
 */
@Include("#include <sys/eventfd.h>")
public final class Eventfd {

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
        final MultiarchInfo multiarchInfo = LibJnhwPosixLoader.getLoadResult().multiarchInfo;
        switch (multiarchInfo.getOS()) {
            case LINUX:
                HAVE_SYS_EVENTFD_H = true;
                EFD_CLOEXEC = 02000000;
                switch (multiarchInfo.getArch()) {
                    case MIPS:
                    case MIPS_64:
                        EFD_NONBLOCK = 00000200;
                        break;
                    default:
                        EFD_NONBLOCK = 00004000;
                }
                EFD_SEMAPHORE = 00000001;
                break;
            default:
                HAVE_SYS_EVENTFD_H = false;
                EFD_CLOEXEC = -1;
                EFD_NONBLOCK = -1;
                EFD_SEMAPHORE = -1;
        }
    }

    /**
     * <b>Linux:</b> Set the close-on-exec (FD_CLOEXEC) flag on the new file
     * descriptor.
     *
     */
    @Define
    public final static int EFD_CLOEXEC;

    /**
     * <b>Linux:</b> Set the O_NONBLOCK file status flag on the open file
     * description (see open(2)) referred to by the new file descriptor..
     *
     */
    @Define
    public final static int EFD_NONBLOCK;

    /**
     * <b>Linux:</b> Provide semaphore-like semantics for reads from the new
     * file descriptor.
     *
     */
    @Define
    public final static int EFD_SEMAPHORE;

    public final static boolean HAVE_SYS_EVENTFD_H;

    /**
     * <b>Linux:</b> eventfd - create a file descriptor for event notification.
     * eventfd creates an "eventfd object" that can be used as an event
     * wait/notify mechanism by user-space applications, and by the kernel to
     * notify user-space applications of events.
     *
     * @param count the initial value of the counter.
     * @param flags
     * {@link EFD_CLOEXEC} |  {@link EFD_NONBLOCK}| {@link EFD_SEMAPHORE}.
     * @return a new file descriptor that can be used to refer to the eventfd
     * object.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native int eventfd(int count, int flags) throws NativeErrorException;

    /**
     * Additional glibc feature to make read from an eventfd simpler.
     *
     * @param fd a valid file descriptor from a call to {@code  eventfd}.
     * @return the 2. parameter of the catice call value a 8 byte buffer to hold
     * the readed value.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native @eventfd_t
    long eventfd_read(int fd) throws NativeErrorException;

    /**
     * Additional glibc feature to make write to an eventfd simpler.
     *
     * @param fd a valid file descriptor from a call to {@code  eventfd}.
     * @param value the 8 bytes to be to write out.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static native void eventfd_write(int fd, @eventfd_t long value) throws NativeErrorException;

    private Eventfd() {

    }

}
