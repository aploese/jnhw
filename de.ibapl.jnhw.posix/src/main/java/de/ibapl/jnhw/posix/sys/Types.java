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
package de.ibapl.jnhw.posix.sys;

import de.ibapl.jnhw.annotation.posix.sys.types.clock_t;
import de.ibapl.jnhw.annotation.posix.sys.types.pid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.mode_t;
import de.ibapl.jnhw.annotation.posix.sys.types.uid_t;
import de.ibapl.jnhw.annotation.posix.sys.types.ssize_t;
import de.ibapl.jnhw.annotation.posix.sys.types.off_t;
import de.ibapl.jnhw.annotation.posix.sys.types.time_t;
import de.ibapl.jnhw.annotation.posix.sys.types.size_t;
import de.ibapl.jnhw.common.annotation.Include;
import de.ibapl.jnhw.common.memory.AsSignedLong;
import de.ibapl.jnhw.common.memory.AsUnsignedInt;
import de.ibapl.jnhw.common.memory.AsUnsignedLong;
import de.ibapl.jnhw.common.memory.Int32_t;
import de.ibapl.jnhw.common.memory.OpaqueMemory32;
import de.ibapl.jnhw.common.memory.Uint32_t;
import de.ibapl.jnhw.util.posix.LibJnhwPosixLoader;
import de.ibapl.jnhw.util.posix.PosixDataType;

/**
 * Wrapper around the {@code  <sys/stat.h>} header.
 *
 * See specs at:
 * <a href="https://pubs.opengroup.org/onlinepubs/9699919799/basedefs/sys_types.h.html">sys/types.h
 * - data types</a>.
 *
 * @author aploese
 */
@Include("#include <sys/types.h>")
public class Types {

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
        switch (LibJnhwPosixLoader.getLoadResult().multiarchInfo.getOS()) {
            case LINUX:
                HAVE_SYS_TYPES_H = true;
                break;
            default:
                throw new NoClassDefFoundError("No sys/types.h defines for " + LibJnhwPosixLoader.getLoadResult().multiarchInfo);
        }
    }

    public final static boolean HAVE_SYS_TYPES_H;

    @off_t
    public static class Off_t extends AsSignedLong {

        public Off_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(PosixDataType.off_t.baseDataType, owner, offset, setMem);
        }

    }

    @mode_t
    public static class Mode_t extends AsUnsignedInt {

        public Mode_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(PosixDataType.mode_t.baseDataType, owner, offset, setMem);
        }

    }

    @ssize_t
    public static class Ssize_t extends AsSignedLong {

        public Ssize_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(PosixDataType.ssize_t.baseDataType, owner, offset, setMem);
        }

    }

    @size_t
    public static class Size_t extends AsUnsignedLong {

        public Size_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(PosixDataType.size_t.baseDataType, owner, offset, setMem);
        }
    }

    @pid_t
    public static class Pid_t extends Int32_t {

        public Pid_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(owner, offset, setMem);
        }

    }

    @clock_t
    public static class Clock_t extends AsSignedLong {

        public Clock_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(PosixDataType.clock_t.baseDataType, owner, offset, setMem);
        }

    }

    @time_t
    public static class Time_t extends AsSignedLong {

        public Time_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(PosixDataType.time_t.baseDataType, owner, offset, setMem);
        }

    }

    @uid_t
    public static class Uid_t extends Uint32_t {

        public Uid_t(OpaqueMemory32 owner, int offset, SetMem setMem) {
            super(owner, offset, setMem);
        }
    }

}
