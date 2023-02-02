/*
 * JNHW - Java Native header Wrapper, https://github.com/aploese/jnhw/
 * Copyright (C) 2019-2023, Arne Plöse and individual contributors as indicated
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
import de.ibapl.jnhw.common.annotation.Unsigned;
import de.ibapl.jnhw.common.datatypes.BaseDataType;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI__A;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__sI_uL;
import de.ibapl.jnhw.common.downcall.JnhwMh_sI__uI_sI;
import de.ibapl.jnhw.common.exception.NativeErrorException;
import de.ibapl.jnhw.common.memory.OpaqueMemory;
import de.ibapl.jnhw.common.memory.Uint64_t;
import static de.ibapl.jnhw.common.memory.Uint64_t.DATA_TYPE;
import de.ibapl.jnhw.isoc.Errno;
import de.ibapl.jnhw.libloader.MultiarchTupelBuilder;
import de.ibapl.jnhw.libloader.libraries.LibcLoader;
import de.ibapl.jnhw.util.linux.LinuxDataType;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentScope;

/**
 * Wrapper around the linux {@code <sys/eventfd.h>} header. execute
 * {@code  man eventfd} on linux to get more informations.
 *
 * @author aploese
 */
@Include("#include <sys/eventfd.h>")
public final class Eventfd {

    @eventfd_t
    public final static class PtrEventfd_t extends Uint64_t {

        public static PtrEventfd_t allocateNative(SegmentScope ms) {
            return new PtrEventfd_t(MemorySegment.allocateNative(DATA_TYPE.SIZE_OF, ms), 0);
        }

        public PtrEventfd_t(MemorySegment memorySegment, long offset) {
            super(memorySegment, offset);
        }

        public static PtrEventfd_t map(OpaqueMemory mem, long offset) {
            return new PtrEventfd_t(OpaqueMemory.getMemorySegment(mem), offset);
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
     * @implNote The actual value for the define fields are injected by
     * initFields. The static initialization block is used to set the value here
     * to communicate that this static final fields are not statically foldable.
     * {
     * @see String#COMPACT_STRINGS}
     */
    static {
        switch (MultiarchTupelBuilder.getOS()) {
            case LINUX -> {
                HAVE_SYS_EVENTFD_H = true;
                EFD_CLOEXEC = 02000000;
                EFD_NONBLOCK = switch (MultiarchTupelBuilder.getArch()) {
                    case MIPS, MIPS_64 ->
                        00000200;
                    default ->
                        00004000;
                };
                EFD_SEMAPHORE = 00000001;
            }

            default -> {
                HAVE_SYS_EVENTFD_H = false;
                EFD_CLOEXEC = -1;
                EFD_NONBLOCK = -1;
                EFD_SEMAPHORE = -1;
            }
        }
    }

    private final static JnhwMh_sI__uI_sI.ExceptionErased eventfd = JnhwMh_sI__uI_sI.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "eventfd",
            BaseDataType.C_int,
            BaseDataType.C_unsigned_int,
            BaseDataType.C_int);

    private final static JnhwMh_sI__sI__A.ExceptionErased eventfd_read = JnhwMh_sI__sI__A.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "eventfd_read",
            BaseDataType.C_int,
            BaseDataType.C_int,
            LinuxDataType.eventfd_t_pointer);

    private final static JnhwMh_sI__sI_uL.ExceptionErased eventfd_write = JnhwMh_sI__sI_uL.mandatoryOf(
            LibcLoader.LIB_C_SYMBOL_LOOKUP,
            "eventfd_write",
            BaseDataType.C_int,
            BaseDataType.C_int,
            LinuxDataType.eventfd_t);

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
    public final static int eventfd(@Unsigned long count, int flags) throws NativeErrorException {
        if (count < 0) {
            throw new IllegalArgumentException("count > max unsigned int");
        }
        final int result = eventfd.invoke_sI__uI_sI((int) count, flags);
        if (result < 0) {
            throw new NativeErrorException(Errno.errno());
        }
        return result;
    }

    /**
     * Additional glibc feature to make read from an eventfd simpler.
     *
     * @param fd a valid file descriptor from a call to {@code  eventfd}.
     *
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void eventfd_read(int fd, PtrEventfd_t value) throws NativeErrorException {
        final int result = eventfd_read.invoke_sI__sI__P(fd, value);
        if (result != 0) {
            throw new NativeErrorException(Errno.errno());
        }
    }

    /**
     * Additional glibc feature to make write to an eventfd simpler.
     *
     * @param fd a valid file descriptor from a call to {@code  eventfd}.
     * @param value the 8 bytes to be to write out.
     * @throws NativeErrorException if the return value of the native function
     * indicates an error.
     */
    public final static void eventfd_write(int fd, @Unsigned @eventfd_t long value) throws NativeErrorException {
        final int result = eventfd_write.invoke_sI__sI_uL(fd, value);
        if (result != 0) {
            throw new NativeErrorException(Errno.errno());
        }

    }

    private Eventfd() {

    }

}
